/*
 * Copyright (c) 2018 Sixlab. All rights reserved.
 * <p>
 * License information see the LICENSE file in the project's root directory.
 * <p>
 * For more information, please see
 * https://sixlab.cn/
 *
 * @time: 2018/5/14 22:21
 * @author: Patrick <root@sixlab.cn>
 */
package cn.sixlab.mine.hexo.server.handler;

import cn.sixlab.mine.hexo.server.service.GitService;
import cn.sixlab.mine.hexo.server.util.CommandUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Controller
@RequestMapping("/git")
public class GitHandler {
    @Autowired
    private GitService service;
    
    @Value("${gitDir}")
    private String gitDir;
    
    @ResponseBody
    @RequestMapping("/update")
    public String update() throws IOException, InterruptedException {
    
        CommandUtil.run("git pull", gitDir);
        CommandUtil.run("hexo g", gitDir);
        
        return "";
    }
}
