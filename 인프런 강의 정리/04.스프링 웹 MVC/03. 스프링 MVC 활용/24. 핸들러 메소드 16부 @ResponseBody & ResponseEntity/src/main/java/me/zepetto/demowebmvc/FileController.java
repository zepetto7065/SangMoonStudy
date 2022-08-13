package me.zepetto.demowebmvc;

import org.apache.tika.Tika;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;

@Controller
public class FileController {

    @Autowired
    private ResourceLoader resourceLoader; //파일을 읽어와서 응답을 넣어주기위해 선언

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

    @GetMapping("/file/{filename}")
    //@ResponseBody가 없어도 ResponseEntity 자체로도 응답임을 인식
    public ResponseEntity<Resource> fileDownload(@PathVariable String filename) throws IOException {
        //ResponseEntity안에 타입을 정해줄수도 있다.
        //가령 ResponseEntity.ok() -> 200으로 응답을 하겠다. 이때, 헤더에 설정을 해주면 좋은
        final Resource resource = resourceLoader.getResource("classpath:" + filename);
        File file = resource.getFile();

        Tika tika = new Tika(); //mediatype을 그떄그때 알아내는 방법 , 무슨 확장자인지 모르니까..
        String type = tika.detect(file);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachement; filename=\""
                        + resource.getFilename() + "\"")
                .header(HttpHeaders.CONTENT_TYPE, type)
                .header(HttpHeaders.CONTENT_LENGTH, String.valueOf(file.length()))
                .body(resource);
    }

}
