package wiProj.Projwipr.CompareEngine;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class compare {
    public void compare(File file) throws IOException {
        long start = System.nanoTime();
        BufferedInputStream fis1 = new BufferedInputStream(new FileInputStream("uploadingDir/api.raml"));
        BufferedInputStream fis2 = new BufferedInputStream(new FileInputStream("uploadingDir/"+file+""));
        int b1 = 0, b2 = 0, pos = 1;
        while (b1 != -1 && b2 != -1) {
//            if (b1 != b2) {
//                System.out.println("Files differ at position " + pos);
//            }
//            pos++;
            b1 = fis1.read();
            b2 = fis2.read();
        }
        if (b1 != b2) {
            System.out.println("Files have different length");

            /////

            //email

            ////

        } else {
            System.out.println("Files are identical, you can delete one of them.");
        }
        fis1.close();
        fis2.close();
        long end = System.nanoTime();
        System.out.print("Execution time: " + (end - start) / 1000000 + "ms");




    }





}
