package com.wc.controller;

import com.wc.server.CommandServer;
import com.wc.server.impl.*;

import java.util.Scanner;

public class CommandController {

    public CommandServer SearchControlsCommand(){
        CommandServer server = null;
        Scanner s = new Scanner(System.in);
        String m =s.nextLine();
        String arr[]=m.split("\\s");
        switch (arr[0]){
            case "-c": server = new CharacterCountServer();break;
            case "-w": server = new WordCountServer();break;
            case "-l": server = new RowCountServer();break;
            case "-s": server = new ConditionFileServer();break;
            case "-a": server = new ComplexCountServer();break;
        }
        return server;
    }
}
