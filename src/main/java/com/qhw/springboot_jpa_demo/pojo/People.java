package com.qhw.springboot_jpa_demo.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by asus on 2019/11/14  14:19
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_people")
public class People {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name",nullable = true,length = 32)
    private String name;

    @Column(name = "age",nullable = true,length = 8)
    private Integer age;

    @Column(name = "birthday")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date birthday;


}
