package com.example.demo.drom.pojo;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class User {
    @Min(value=1000, message = "uid必须大于1000")
    private Integer uid;

    @NotBlank
    @Size(min = 5, max = 10, message = "长度在5-10")
    private String uname;

}
