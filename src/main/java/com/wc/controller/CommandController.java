package com.wc.controller;

import com.wc.server.CommandServer;
import com.wc.server.impl.*;

import java.util.Scanner;

public class CommandController {

    public CommandServer SearchControlsCommand(String command){
        CommandServer server = null;
        switch (command){
            case "-c": server = new CharacterCountServer();break;
            case "-w": server = new WordCountServer();break;
            case "-l": server = new RowCountServer();break;
            case "-s": server = new ConditionFileServer();break;
            case "-a": server = new ComplexCountServer();break;
        }
        return server;
    }
}
