package com.wc.server.impl;

import com.wc.server.CommandServer;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class RowCountServer implements CommandServer {
    @Override
    public void command(String path) {
        BufferedReader br = null;
        int line = 0;
        String str = "";
        StringBuffer sb  = new StringBuffer();
        try {
            br = new BufferedReader(new FileReader(path));
            while ((str = br.readLine()) != null) {
                ++line;
            }
            System.out.println("文件行数：" + line);
            System.out.println();
        } catch (FileNotFoundException e) {
            System.out.println("错误：文件找不到");
        } catch (IOException e){
            System.out.println("错误：文件读入异常");
        }
    }
}
