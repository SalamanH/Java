/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package keyword;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 *
 * @author soola
 */
public class Keyword {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ArrayList<String> wordArray = new ArrayList<>();
        Map<String, Integer> map = new TreeMap<>();

        String key;
        String[] ss = null;
        String temp = "";
        String file="";
        Scanner x = null;
        for(String s: args){
            file += s;
        }
        try {
            x = new Scanner(new File("C:/Users/soola/Desktop/school/JAC444- Introduction to Java for C++ Programmers/workshop4/src/"+ file));


        } catch (FileNotFoundException e) {

            System.out.println("File Not Found... Program Terminating...." + e);
        }


        while(x.hasNext()) {

            temp +=  x.nextLine() + "\n";
        }
            temp = temp.replaceAll("[\\[\\]{}]", " ");
            temp = temp.replaceAll("(\".*\")", " ");
            temp = temp.replaceAll("(/\\*.*\\n.*\\n.*\\n.*\\n.\\*/)", " ");
            temp = temp.replaceAll("(/\\*.*\\*/)", " ");
            temp = temp.replaceAll("(/\\*.*\\n.*\\n.*\\n.*\\*/)", " ");
            temp = temp.replaceAll("(//.*\\n)", " ");
            temp = temp.replaceAll("[().;\n]", " ");

        ss = temp.split("\\s");

        for(int i=0;i<ss.length;i++)
            wordArray.add(ss[i]);

        for (int i=0;i<wordArray.size();i++){
            if(wordArray.get(i).equals("this"))
                System.out.println("match");
            if(wordArray.get(i).equals("abstract")       ||  wordArray.get(i).equals("assert")    || wordArray.get(i).equals("boolean")      || wordArray.get(i).equals("break")      || wordArray.get(i).equals("byte")      ||
                    wordArray.get(i).equals("case")      || wordArray.get(i).equals("catch")      || wordArray.get(i).equals("char")         ||  wordArray.get(i).equals("class")     || wordArray.get(i).equals("const")     ||
                    wordArray.get(i).equals("continue")  || wordArray.get(i).equals("default")    || wordArray.get(i).equals("do")           || wordArray.get(i).equals("do")         || wordArray.get(i).equals("double")    ||
                    wordArray.get(i).equals("else")      || wordArray.get(i).equals("enum")       || wordArray.get(i).equals("extends")      || wordArray.get(i).equals("final")      || wordArray.get(i).equals("finally")   ||
                    wordArray.get(i).equals("float")     || wordArray.get(i).equals("for")        ||  wordArray.get(i).equals("goto")        || wordArray.get(i).equals("if")         || wordArray.get(i).equals("implements")||
                    wordArray.get(i).equals("import")    || wordArray.get(i).equals("instanceof") || wordArray.get(i).equals("int")          || wordArray.get(i).equals("interface")  ||  wordArray.get(i).equals("long")     ||
                    wordArray.get(i).equals("native")    || wordArray.get(i).equals("new")        || wordArray.get(i).equals("package")      || wordArray.get(i).equals("private")    || wordArray.get(i).equals("protected") ||
                    wordArray.get(i).equals("public")    ||  wordArray.get(i).equals("return")    || wordArray.get(i).equals("short")        || wordArray.get(i).equals("static")     || wordArray.get(i).equals("strictfp")  ||
                    wordArray.get(i).equals("super")     || wordArray.get(i).equals("switch")     || wordArray.get(i).equals("synchronized") ||  wordArray.get(i).equals("this")      || wordArray.get(i).equals("throw")     ||
                    wordArray.get(i).equals("throws")    || wordArray.get(i).equals("transient")  || wordArray.get(i).equals("try")          || wordArray.get(i).equals("void")       || wordArray.get(i).equals("volatile")  ||
                    wordArray.get(i).equals("while")     || wordArray.get(i).equals("true")       || wordArray.get(i).equals("false")        ||  wordArray.get(i).equals(null) ) {
                key = wordArray.get(i).toLowerCase();
                if (!map.containsKey(key)) {
                    map.put(key, 1);
                } else {
                    int value = map.get(key);
                    value++;
                    map.put(key, value);
                }
            }
        }

        System.out.println(map);


    }}



