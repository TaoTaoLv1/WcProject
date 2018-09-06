package com.wc.server.impl;

import com.wc.server.CommandServer;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeMap;

public class CharacterCountServer implements CommandServer {

    @Override
    public void command(String path) {
        BufferedReader br = null;
        String str = "";
        StringBuffer sb  = new StringBuffer();
        try {
            br = new BufferedReader(new FileReader(path));
            while ((str = br.readLine()) != null) {
                sb.append(str);
            }

            TreeMap<Character, Integer> tm = Pross(sb.toString());
            System.out.println("字符统计结果为：" + tm);
            System.out.println();

        } catch (FileNotFoundException e) {
            System.out.println("错误：文件找不到");
        } catch (IOException e){
            System.out.println("错误：文件读入异常");
        }
    }

    // 统计数字或者字符出现的次数
    public TreeMap<Character, Integer> Pross(String str) {
        char[] charArray = str.toCharArray();

        TreeMap<Character, Integer> tm = new TreeMap<Character, Integer>();

        for (int x = 0; x < charArray.length; x++) {
            if (!tm.containsKey(charArray[x])) {
                tm.put(charArray[x], 1);
            } else {
                int count = tm.get(charArray[x]) + 1;
                tm.put(charArray[x], count);
            }
        }
        return tm;
    }
}
