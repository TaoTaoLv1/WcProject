package com.wc.server.impl;

import com.wc.server.CommandServer;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileReader;

public class ComplexCountServer implements CommandServer {

    static int cntCode = 0, cntNode = 0, cntSpace = 0;
    static boolean flagNode = false;

    @Override
    public void command(String path) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(path));
            String line = "";
            while((line = br.readLine()) != null){
                pattern(line);
            }
            System.out.println("注释行： " + cntNode);
            System.out.println("空行： " + cntSpace);
            System.out.println("代码行： " + cntCode);
            System.out.println();
        } catch (FileNotFoundException e) {
            System.out.println("错误：文件找不到");
        } catch (IOException e) {
            System.out.println("错误：文件读入异常");
        }
    }

    public void pattern(String line) {
        String regxNodeBegin = "\\s*/\\*.*";
        String regxNodeEnd = ".*\\*/\\s*";
        String regx = "//.*";
        String regxSpace = "\\s*";
        if(line.matches(regxNodeBegin) && line.matches(regxNodeEnd)){
            ++cntNode;
            return ;
        }
        if(line.matches(regxNodeBegin)){
            ++cntNode;
            flagNode = true;
        } else if(line.matches(regxNodeEnd)){
            ++cntNode;
            flagNode = false;
        } else if(line.matches(regxSpace))
            ++cntSpace;
        else if(line.matches(regx))
            ++cntNode;
        else if(flagNode)
            ++cntNode;
        else ++cntCode;
    }
}
