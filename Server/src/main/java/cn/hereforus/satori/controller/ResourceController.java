package cn.hereforus.satori.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Time;

import static java.nio.file.Files.readAllBytes;

@RestController
public class ResourceController {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private HttpServletResponse response;


    @GetMapping("/essay")
    public String getEssay(
            @RequestParam(name = "path", required = false, defaultValue = "test.md")
            String path
    ) {
        String essayPath = "src/main/resources/essays/" + path;
        System.out.println(essayPath);
        String content = "";
        try {
            content = new String(readAllBytes(java.nio.file.Paths.get(essayPath)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return content;
    }

    @GetMapping("/image")
    public void getImage(
            @RequestParam(name = "path", required = false, defaultValue = "test.jpg")
            String path
    ) throws InterruptedException {
        String imagePath = "src/main/resources/images/" + path;
        System.out.println(imagePath);
        try {
            response.getOutputStream().write(readAllBytes(java.nio.file.Paths.get(imagePath)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}