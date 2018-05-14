/*
 * Copyright (c) 2018 Sixlab. All rights reserved.
 * <p>
 * License information see the LICENSE file in the project's root directory.
 * <p>
 * For more information, please see
 * https://sixlab.cn/
 *
 * @time: 2018/5/14 22:36
 * @author: Patrick <root@sixlab.cn>
 */
package cn.sixlab.mine.hexo.server.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class CommandUtil {
    
    public static void run(String command, String path) {
        String[] commands = command.split(" ");
    
        ProcessBuilder processBuilder = new ProcessBuilder(commands);
        processBuilder.redirectErrorStream(true);
        processBuilder.directory(new File(path));
        Process p = null;
        try {
            p = processBuilder.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
        InputStream is = p.getInputStream();
        BufferedReader bs = new BufferedReader(new InputStreamReader(is));
    
        try {
            p.waitFor();
    
            if (p.exitValue() != 0) {
                //说明命令执行失败
                //可以进入到错误处理步骤中
            }
            String line;
            while ((line = bs.readLine()) != null) {
                System.out.println(line);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
