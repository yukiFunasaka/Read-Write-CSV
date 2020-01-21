package app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {
    public static void main(String[] args) throws Exception {
        File csv = new File("sample.csv");
        InputStreamReader input = new InputStreamReader(new FileInputStream(csv), "UTF-8");
        BufferedReader br = new BufferedReader(input);

        try {
            String line;
            while ((line = br.readLine()) != null) {
                String arr[] = line.split(",");
                for(String val : arr){
                    System.out.println(val);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            br.close();
        }
    }
}