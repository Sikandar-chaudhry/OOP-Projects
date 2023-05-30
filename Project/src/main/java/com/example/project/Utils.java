package com.example.project;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Utils {

    public void takeCredentials(String username ,String password){
        File file=new File("src/Credentials.txt");
        try {
            file.createNewFile();
            FileWriter fw=new FileWriter(file,true);
            BufferedWriter bw=new BufferedWriter(fw);
            bw.write(username);
            bw.write("\t");
            bw.write(password);
            bw.newLine();
            bw.close();
            fw.close();

        } catch (FileNotFoundException e){
            throw new RuntimeException(e);
        } catch (IOException e){
        }
    }
    public ArrayList<String> ReadCredentials(File file){
        ArrayList<String> list=new ArrayList<>();
        FileReader fr=null;

        try{
            fr=new FileReader(file);
            BufferedReader br=new BufferedReader(fr);
            String text="";
            while((text= br.readLine())!=null){
                list.add(text);
            }
        }
        catch (FileNotFoundException e){
            throw new RuntimeException(e);
        } catch(IOException e){
        }
        return list;
    }

}
