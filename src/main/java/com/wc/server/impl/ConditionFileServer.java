package com.wc.server.impl;

import com.wc.server.CommandServer;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConditionFileServer implements CommandServer {
    @Override
    public void command(String path) {
        System.out.print("请输入查询的文件名（可模糊）：");
        Scanner s = new Scanner(System.in);
        String fileName =s.nextLine();
        List<String> file = searchFile(path, fileName);
        if (file.isEmpty()){
            System.out.println("错误：暂无此文件");
        }else {
            file.forEach(it -> System.out.println(it));
            System.out.println();
        }
    }

    public List<String> searchFile(String path, String fileName){
        if(path!=null&&fileName!=null){
            File file = new File(path);
            List<String> list = new ArrayList<String>();
            getFilesList(file,fileName,list);
            return list;
        }
        return null;
    }

    public void getFilesList(File file, String fileName, List<String> list){
        if(file.exists()){
            if(file.isDirectory()){
                File[] files = file.listFiles();
                if(files != null && files.length > 0){
                    for(File f:files){
                        getFilesList(f,fileName,list);
                    }
                }
            }else if(file.isFile()){
                if(file.getName().contains(fileName)){
                    list.add(file.getPath());
                }
            }
        }
    }
}
