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
package cn.sixlab.mine.hexo.server.service;

import cn.sixlab.mine.hexo.server.util.CommandUtil;

import java.io.IOException;

//@Service
public class GitService {
    
    public void pull(String path)  {
        CommandUtil.run("git pull", path);
    }
}
