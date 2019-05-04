package wiProj.Projwipr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import wiProj.Projwipr.controller.controller;


import java.io.File;

import java.io.IOException;
@SpringBootApplication
public class ProjwiprApplication {






		public static void main(String[] args)throws IOException {
            new File(controller.uploadingDir).mkdirs();

            new File(controller.uploadingDirec).mkdirs();

            SpringApplication.run(ProjwiprApplication.class, args);
        }




        }
