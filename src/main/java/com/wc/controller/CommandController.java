package com.wc.controller;

import com.wc.server.CommandServer;
import com.wc.server.impl.*;

public class CommandController {

    public CommandServer SearchControlsCommand(String command){
        CommandServer server = null;
        switch (command){
            case "-c": server = new CharacterCountServer();break; //返回文件字符数
            case "-w": server = new WordCountServer();break;      //返回文件词的数目
            case "-l": server = new RowCountServer();break;       //返回文件行数
            case "-s": server = new ConditionFileServer();break;  //搜索文件名
            case "-a": server = new ComplexCountServer();break;   //统计代码行 / 空行 / 注释行
            default:
                System.out.println("参数输入不正确");
        }
        return server;
    }
}
