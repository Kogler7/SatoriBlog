package cn.hereforus.satori.controller;

import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import cn.hereforus.satori.entity.UserInfo;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

@RestController
public class UserController {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/users")
    public List<Map<String, Object>> getUsers() {
        System.out.println("getUsers");
        String sql = "select * from User";//SQL查询语句
        return jdbcTemplate.queryForList(sql);
    }

    @GetMapping("/user")
    public String getUserById(
            @RequestParam("id") String id
    ) {
        System.out.println("getUserById");
        System.out.println(id);
        return "user";
    }

    @PostMapping("/user")
    public String addUser(
            @RequestBody UserInfo user
    ) {
        System.out.println("addUser");
        System.out.println(user);
        String sql = "insert into user (userName, passWord, auth, sex, nick, brief, birth, email) values "+
                "('" + user.userName + "', " +
                "'" + user.passWord + "', " +
                "'" + user.auth + "', " +
                "'" + user.sex + "', " +
                "'" + user.nick + "', " +
                "'" + user.brief + "', " +
                "'" + user.birth + "', " +
                "'" + user.email + "'" +
                ")";
        jdbcTemplate.execute(sql);
        return "success";
    }

    @PutMapping("/user")
    public String updateUser(
            @RequestBody UserInfo user
    ) {
        System.out.println("updateUser");
        System.out.println(user);
        String sql = "update user set " +
                "username = '" + user.userName + "', " +
                "password = '" + user.passWord + "', " +
                "auth = '" + user.auth + "', " +
                "sex = '" + user.sex + "', " +
                "nick = '" + user.nick + "', " +
                "brief = '" + user.brief + "', " +
                "birth = '" + user.birth + "', " +
                "email = '" + user.email + "', " +
                "where id = " + user.id;
        jdbcTemplate.execute(sql);
        return "success";
    }

    @DeleteMapping("/user")
    public String deleteUser(
            @RequestParam("id") String id
    ) {
        System.out.println("deleteUser");
        System.out.println(id);
        String sql = "delete from user where id = " + id;
        System.out.println(sql);
        jdbcTemplate.execute(sql);
        return "success";
    }
}
