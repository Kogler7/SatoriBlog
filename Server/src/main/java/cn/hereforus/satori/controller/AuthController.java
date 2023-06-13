package cn.hereforus.satori.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.CallableStatementCallback;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cn.hereforus.satori.entity.Auth;

@RestController
public class AuthController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int checkLogin(String userName, String passWord) {
        String sql = "{call CheckLogin(?, ?, ?)}";
        Object[] params = new Object[]{userName, passWord, null};
        int result = jdbcTemplate.execute(sql, (CallableStatementCallback<Integer>) cs -> {
            cs.setString(1, userName);
            cs.setString(2, passWord);
            cs.registerOutParameter(3, java.sql.Types.INTEGER);
            cs.execute();
            return cs.getInt(3);
        });
        return result;
    }

    @PostMapping("/auth/login")
    public String login(
            @RequestBody Auth auth
    ) {
        System.out.println("login");
        System.out.println(auth.username);
        System.out.println(auth.password);
        int result = checkLogin(auth.username, auth.password);
        System.out.println(result);
        if (result == 0) {
            return "fail";
        }
        return "success";
    }

    @PostMapping("/auth/register")
    public String register(
            @RequestBody Auth auth
    ) {
        System.out.println("register");
        System.out.println(auth.username);
        System.out.println(auth.password);
        String sql = "CreateUserInShort('" + auth.username + "', '" + auth.password + "')";
        jdbcTemplate.execute(sql);
        return "success";
    }
}
