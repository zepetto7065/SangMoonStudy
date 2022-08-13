package me.zepetto.demowebmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class FileController {


    //redirect된 session을 Model에서 가져와 화면으로 다시 return
    @GetMapping("/file")
    public String fileUpladForm(Model model){
        return "files/index";
    }


    // 화면에서 upload된 파일 정보를 session에 담는 flashAttribute 방식으로 redirect
    @PostMapping("/file")
    public String fileUpload(@RequestParam MultipartFile file, RedirectAttributes attributes){
        //파일을 저장후
        String message = file.getOriginalFilename() + " is uploaded";
        attributes.addFlashAttribute("message", message);
        return "redirect:/file";
    }

}
