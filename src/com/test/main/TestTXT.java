package com.test.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class TestTXT {

	public TestTXT() {
		
	}
	
	public static String txt2String(File file){
        StringBuilder result = new StringBuilder();
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));//构造一个BufferedReader类来读取文件
            String s = null;
            while((s = br.readLine())!=null){//使用readLine方法，一次读一行
                result.append(System.lineSeparator()+s);
            }
            br.close();    
        }catch(Exception e){
            e.printStackTrace();
        }
        return result.toString();
    }
	public static String deleteAllCRLF(String input) {  
        return input.replaceAll("((\r\n)|\n)[\\s\t ]*", " ").replaceAll(  
                "^((\r\n)|\n)", "").replace(" ", "");  
    }  
    public static void main(String[] args){
    	File f = new File(TestTXT.class.getClassLoader().getResource("test.txt").getPath());
 
    	String str = txt2String(f);
    	
        System.out.println(deleteAllCRLF(str));
    }

    
    

}
