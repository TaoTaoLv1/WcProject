package com.wc;

import com.wc.controller.CommandController;
import com.wc.server.CommandServer;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        CommandController commandController = new CommandController();
        while (true) {
            Scanner s = new Scanner(System.in);
            String m =s.nextLine();
            String arr[]=m.split("\\s");
            CommandServer server = commandController.SearchControlsCommand(arr[0]);
            server.command(arr[1]);
        }
    }
}
