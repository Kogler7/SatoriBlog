package cn.hereforus.satori.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.*;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cn.hereforus.satori.entity.Auth;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
public class AuthController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

//    public int checkLogin(String userName, String passWord) {
//        int result = (int) jdbcTemplate.execute(
//                new CallableStatementCreator() {
//                    @Override
//                    public CallableStatement createCallableStatement(java.sql.Connection con) throws java.sql.SQLException {
//                        String storedProc = "{call CheckLogin(?,?,?)}";// 调用的sql
//                        CallableStatement cs = con.prepareCall(storedProc);
//                        cs.setString(1, userName);// 设置输入参数的值
//                        cs.setString(2, passWord);// 设置输入参数的值
//                        cs.registerOutParameter(3, Types.INTEGER);// 注册输出参数的类型
//                        return cs;
//                    }
//                }, new CallableStatementCallback<Integer>() {
//                    @Override
//                    public Integer doInCallableStatement(CallableStatement cs) throws SQLException, DataAccessException {
//                        return cs.getInt(3);// 获取输出参数的值
//                    }
//                }
//        );
//        return result;
//    }
//
//    @PostMapping("/auth/login")
//    public String login(
//            @RequestBody Auth auth
//    ) {
//        System.out.println("login");
//        System.out.println(auth.username);
//        System.out.println(auth.password);
//        int result = checkLogin(auth.username, auth.password);
//        System.out.println(result);
//        if (result == 0) {
//            return "fail";
//        }
//        return Integer.toString(result);
//    }

    @PostMapping("/auth/login")
    public String login(
            @RequestBody Auth auth
    ) {
        System.out.println("login");
        System.out.println(auth.username);
        System.out.println(auth.password);
        String SelectSQL = String.format(
                "SELECT id FROM user WHERE userName = '%s' AND passWord = '%s';",
                auth.username, auth.password
        );
        List<Map<String, Object>> result = jdbcTemplate.queryForList(SelectSQL);
        if (result.size() == 0) {
            return "fail";
        }
        return result.get(0).get("id").toString();
    }

    @PostMapping("/auth/register")
    public String register(
            @RequestBody Auth auth
    ) {
        System.out.println("register");
        System.out.println(auth.username);
        System.out.println(auth.password);
        String sql = "CALL CreateUserInShort('" + auth.username + "', '" + auth.password + "')";
        jdbcTemplate.execute(sql);
        return "success";
    }
}
