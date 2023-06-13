package cn.hereforus.satori.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

@RestController
public class CommentController {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/comments")
    public List<Map<String, Object>> getComments(
            @RequestParam("essayId") String essayId
    ) {
        System.out.println("getComments");
        String sql = "call GetComments('" + essayId + "')";
        List<Map<String, Object>> result = jdbcTemplate.queryForList(sql);
        for (Map<String, Object> row : result) {
            for (Map.Entry<String, Object> entry : row.entrySet()) {
                System.out.println(entry.getKey() + " = " + entry.getValue());
            }
            System.out.println("--------------------");
        }
        return result;
    }

    @PostMapping("/comments")
    public String postComments(
            @RequestParam("essayId") String essayId,
            @RequestParam("userId") String userId,
            @RequestParam("content") String content
    ) {
        System.out.println("postComments");
        String sql = "call AddComment('" + essayId + "','" + userId + "','" + content + "')";
        jdbcTemplate.execute(sql);
        return "success";
    }
}
