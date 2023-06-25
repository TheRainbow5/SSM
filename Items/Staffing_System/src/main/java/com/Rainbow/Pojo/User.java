package com.Rainbow.Pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * User
 *
 * @description
 * @author:Rainbow
 * @date:2023/6/24 0024 20:09
 * @version:1.0
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer id;
    private String name;
    private String gender;
}
