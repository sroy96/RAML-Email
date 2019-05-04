package wiProj.Projwipr.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import wiProj.Projwipr.CompareEngine.compare;
import wiProj.Projwipr.MailFactory.Generate;


import java.io.File;



@Controller
public class controller {

    public static final String uploadingDir = System.getProperty("user.dir") + "/uploadingDir/";

    public static final String uploadingDirec = System.getProperty("user.dir") + "/uploadingDirec/";

    @Autowired
    private Generate g;

    compare c=new compare();

    @RequestMapping("/")
    public String uploading(Model model) {
        File file = new File(uploadingDir);

        model.addAttribute("files", file.listFiles());

        return "uploading";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String uploadingPost(@RequestParam("uploadingFiles") MultipartFile[] uploadingFiles) throws Exception {

        for(MultipartFile uploadedFile : uploadingFiles) {
            File file = new File(uploadingDir + uploadedFile.getOriginalFilename());

            uploadedFile.transferTo(file);
            boolean t=c.compare(uploadedFile.getOriginalFilename());

            if(t==true) {
                g.run(uploadedFile.getOriginalFilename());
            }
        }

        return "redirect:/";
    }



    @RequestMapping("/test")
    public String upload(Model model) {
        File file1 = new File(uploadingDirec);

        model.addAttribute("files", file1.listFiles());

        return "uploading";
    }

    @RequestMapping(value = "/test",method=RequestMethod.POST)
public String uploadPost(@RequestParam("uploadingFile") MultipartFile[] uploadingFile) throws Exception {
    for (MultipartFile uploadedFil : uploadingFile) {
        File file1 = new File(uploadingDirec + uploadedFil.getOriginalFilename());
        uploadedFil.transferTo(file1);
    }
    return "redirect:/test";
}

@RequestMapping(value = "/delete",method = RequestMethod.POST)
    public String delete(){
    String s="";
    File folder= new File("uploadingDirec");
    File[] listOfFiles=folder.listFiles();
    for(int i=0;i<listOfFiles.length;i++){
        if(listOfFiles[0].isFile()){
            s= listOfFiles[0].getName();
        }

    }
     File file=new File("uploadingDirec"+s+"");
    if(file.delete()){
        System.out.println("Deletion Successful");
    }

        return "redirect:/test";
}



}
