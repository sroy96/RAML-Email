package wiProj.Projwipr.CompareEngine;

import java.io.BufferedInputStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


public class compare {
    public boolean compare(String str) throws IOException {
        boolean x;
        String s="";
        File folder= new File("uploadingDirec");
        File[] listOfFiles=folder.listFiles();
        for(int i=0;i<listOfFiles.length;i++){
            if(listOfFiles[0].isFile()){
               s= listOfFiles[0].getName();
            }

        }


        long start = System.nanoTime();

        BufferedInputStream fis1 = new BufferedInputStream(new FileInputStream("uploadingDirec/"+s+""));
        BufferedInputStream fis2 = new BufferedInputStream(new FileInputStream("uploadingDir/"+str+""));
        int b1 = 0, b2 = 0;
        while (b1 != -1 && b2 != -1) {

            b1 = fis1.read();
            b2 = fis2.read();
        }
        if (b1 != b2) {
            System.out.println("Files have different length");
            x=true;


        } else {
            System.out.println("Files are identical thus NO UPSERT...");
            x=false;
        }
        fis1.close();
        fis2.close();
        long end = System.nanoTime();
        System.out.print("Execution time: " + (end - start) / 1000000 + "ms");


        return x;
    }





}
