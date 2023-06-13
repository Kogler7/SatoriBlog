package cn.hereforus.satori.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

@RestController
public class ProcController {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/proc")
    public List<Map<String, Object>> testProc() {
        System.out.println("testProc");
        String sql = "CALL GetHostPostsByTitle('Hdgkj');";
        List<Map<String, Object>> resultList = jdbcTemplate.queryForList(sql);

        for (Map<String, Object> row : resultList) {
            for (Map.Entry<String, Object> entry : row.entrySet()) {
                System.out.println(entry.getKey() + " = " + entry.getValue());
            }
            System.out.println("--------------------");
        }
        return resultList;
    }
}
