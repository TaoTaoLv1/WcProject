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
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
        System.out.println("文件行数：" + line);
        System.out.println();
    }
}
