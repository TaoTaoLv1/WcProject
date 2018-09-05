package com.wc.server.impl;

import com.wc.server.CommandServer;

import java.io.*;
import java.util.*;

public class WordCountServer implements CommandServer {
    @Override
    public void command(String path) {
        try {
            File file = new File(path);
            BufferedReader bf = new BufferedReader(new FileReader(file));
            String line;
            String reg = "\\s+";
            TreeMap<String, Integer> tm = new TreeMap<>();
            while ((line = bf.readLine()) != null) {
                String[] strs = line.split(reg);
                for (String str : strs) {
                    if(!tm.containsKey(str))
                        tm.put(str,1);
                    tm.put(str,tm.get(str)+1);

                }
            }

            List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(tm.entrySet());
            Collections.sort(list, (a, b) -> b.getValue() - a.getValue());
            list.forEach(it -> System.out.println(it.getKey()+" "+it.getValue()));
            System.out.println();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
