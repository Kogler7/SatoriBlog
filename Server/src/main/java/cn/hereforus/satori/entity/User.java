package cn.hereforus.satori.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
//
//@Entity
//@Table(name = "user")
//public class User implements Serializable {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
//    public Integer id;
//
//    @Column(name = "userName", nullable = false, length = 32)
//    public String userName;
//
//    @Column(name = "passWord", nullable = false, length = 32)
//    public String passWord;
//
//    @Enumerated(EnumType.STRING)
//    @Column(name = "auth", nullable = false, columnDefinition = "enum('0', '1', '2', '3') DEFAULT '3'")
//    public Auth auth;
//
//    @Enumerated(EnumType.STRING)
//    @Column(name = "sex", nullable = false, columnDefinition = "enum('M', 'F') DEFAULT 'M'")
//    public Sex sex;
//
//    @Column(name = "nick", nullable = false, length = 32, columnDefinition = "char(32) DEFAULT '新用户'")
//    public String nick;
//
//    @Column(name = "brief", length = 128)
//    public String brief;
//
//    @Column(name = "birth")
//    public Date birth;
//
//    @Column(name = "email", length = 32)
//    public String email;
//
//    @Column(name = "initTime")
//    public Date initTime;
//
//    public enum Auth {
//        ADMIN("0"),
//        OPERATOR("1"),
//        USER("2"),
//        GUEST("3");
//
//        private final String value;
//
//        Auth(String value) {
//            this.value = value;
//        }
//
//        public String getValue() {
//            return value;
//        }
//    }
//
//    public enum Sex {
//        MALE("M"),
//        FEMALE("F");
//
//        private final String value;
//
//        Sex(String value) {
//            this.value = value;
//        }
//
//        public String getValue() {
//            return value;
//        }
//    }
//
//    public User(String username, String password) {
//        this.userName = username;
//        this.passWord = password;
//    }
//}
