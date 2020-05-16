package com.hillel.lombok;

import lombok.*;

import java.io.Serializable;

@Builder
@ToString
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    static final long serialVersionUID = 1;

    String name;
    String surname;

    int age;
    int salary;

    //transient String surname;

}
