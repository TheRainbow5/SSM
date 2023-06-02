package org.jiejie.myMapper;
import org.jiejie.myEntity.User;

import java.util.List;

public interface UserMapper {
    /**
     *  添加用户信息
     * @return
     */
    int insertUser();

    /**
     * 修改用户信息
     */
    void updateUser();

    /**
     * 删除用户信息
     */
    void deleteUser();

    /**
     * 通过id查询一个User信息
     * @return
     */
    User getUserById();

    /**
     * 查询所有用户信息，存储在List集合中
     * @return
     */
    List<User> getAllUser();
}
