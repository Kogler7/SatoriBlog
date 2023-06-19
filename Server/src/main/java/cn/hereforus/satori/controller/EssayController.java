package cn.hereforus.satori.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
public class EssayController {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/essays/latest")
    public List<Map<String, Object>> getLatestEssays(
            @RequestParam("section") String section
    ) {
        System.out.println("getLatestEssays");
        // 如果含有section参数，则返回该section下的最新文章
        if (Objects.equals(section, "null")) {
            String sql = "call GetLatestSectEssays('" + section + "')";
            List<Map<String, Object>> result = jdbcTemplate.queryForList(sql);
            for (Map<String, Object> row : result) {
                for (Map.Entry<String, Object> entry : row.entrySet()) {
                    System.out.println(entry.getKey() + " = " + entry.getValue());
                }
                System.out.println("--------------------");
            }
            return result;
        }
        String sql = "select * from essay order by initTime desc limit 10";//SQL查询语句
        List<Map<String, Object>> result = jdbcTemplate.queryForList(sql);
        System.out.println(result);
        for (Map<String, Object> row : result) {
            for (Map.Entry<String, Object> entry : row.entrySet()) {
                System.out.println(entry.getKey() + " = " + entry.getValue());
            }
            System.out.println("--------------------");
        }
        return result;
    }

    @GetMapping("/essays/hot")
    public List<Map<String, Object>> getHotEssays() {
        System.out.println("getHotEssays");
        String sql = "call GetHotEssays()";//SQL查询语句
        List<Map<String, Object>> result = jdbcTemplate.queryForList(sql);
        for (Map<String, Object> row : result) {
            for (Map.Entry<String, Object> entry : row.entrySet()) {
                System.out.println(entry.getKey() + " = " + entry.getValue());
            }
            System.out.println("--------------------");
        }
        return result;
    }
}
