package cn.hereforus.satori.dao;
//
//import cn.hereforus.satori.entity.User;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Modifying;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//
//import java.util.List;
//
//public interface UserDao extends JpaRepository<User, Long> {
//    User findByUserName(String userName);
//
//    User findById(int userId);
//
//    User deleteById(int userId);
//
//    @Override
//    Page<User> findAll(Pageable pageable);
//
//    Page<User> findByUserNameLike(String userName, Pageable pageable);
//
//    List<User> findByUserNameLike(String userName);
//
//    //jpa没有提供更新语句，所以更新语句需要我们自己编写，语法格式和sql非常类似，不过注意我们要直接对实体类对象进行操作，具体写法参照下面的来就行。
//    //一般来说，有更新语句还需要提供@Transactional事物注解，但是在实践的项目中
//    // 我们不直接使用Dao层函数，而是新建一个service层，所以注解我直接加在了Service类里面。
//    // （注意，如果想直接使用dao层的更新语句，则必须在@Modifying前面加上@Transactional）
//
//    @Modifying
//    @Query(value = "update User as u set u.userName=:name where u.userId=:id")
//    void updateUserName(@Param("name") String name, @Param("id") int id);
//
//    @Modifying
//    @Query(value = "update user as u set u.passWord=:password where u.id=:id")
//    //=:password 其中  :  是占位符的意思，我们通过传入的参数，利用@Param("password") 就可以将我们想要更新的参数传给sql语句了。
//    void updatePasswordById(@Param("password") String password, @Param("id") int id);
//
//
//    @Modifying
//    @Query(value = "update User as u set u.auth=:auth where u.id=:id")
//    void updateUserAuthById(@Param("auth") String auth, @Param("id") int id);
//
//
//    @Modifying
//    @Query(value = "update User as u set u.sex=:sex where u.id=:id")
//    void updateUserSexById(@Param("sex") String sex, @Param("id") int id);
//
//
//    @Modifying
//    @Query(value = "update User as u set u.nick=:nick where u.id=:id")
//    void updateUserNickById(String nick, int id);
//
//
//    @Modifying
//    @Query(value = "update User as u set u.email=:email where u.id=:id")
//    void updateUserEmailById(@Param("email") String email, @Param("id") int id);
//
//    @Modifying
//    @Query(value = "update User as u set u.brief = :brief where u.id=:id")
//    void updateUserBriefById(@Param("brief") String brief, @Param("id") int id);
//}
//
