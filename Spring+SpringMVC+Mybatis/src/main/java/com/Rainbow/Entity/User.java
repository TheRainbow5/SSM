package com.Rainbow.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: User
 * @Author: Rainbow
 * @Description: Todo
 * @Date: 2023/6/10 12:37
 * @Version: 1.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id;
    private String username;
    private String gender;
}
