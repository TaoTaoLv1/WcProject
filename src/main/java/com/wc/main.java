package com.wc;

import com.wc.controller.CommandController;
import com.wc.server.CommandServer;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        CommandController commandController = new CommandController();
        boolean exit = true;
        while (exit) {
            System.out.println("\n*********************************************");
            System.out.println("**** -c [文件名]  返回文件字符数         ****");
            System.out.println("**** -w [文件名]  返回文件词的数目       ****");
            System.out.println("**** -l [文件名]  返回文件行数           ****");
            System.out.println("**** -s [文件夹]  搜索文件名             ****");
            System.out.println("**** -a [文件名]  统计代码行/空行/注释行 ****");
            System.out.println("**** exit  退出                         ****");
            System.out.println("*********************************************");
            System.out.print("请输入命令：");
            Scanner s = new Scanner(System.in);
            String m =s.nextLine();
            String arr[]=m.split("\\s");
            if (arr[0].equals("exit")){
                exit = false;
            }else {
                CommandServer server = commandController.SearchControlsCommand(arr[0]);
                server.command(arr[1]);
            }
        }

        System.out.println("bye-bye");
    }
}
