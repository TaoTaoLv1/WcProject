package com.wc;

import com.wc.controller.CommandController;

public class main {
    public static void main(String[] args) {
        CommandController commandController = new CommandController();
        while (true) {
            commandController.SearchControlsCommand();
        }
    }
}
