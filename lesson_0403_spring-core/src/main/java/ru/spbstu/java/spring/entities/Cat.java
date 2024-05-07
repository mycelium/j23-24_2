package ru.spbstu.java.spring.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("CATS")
public class Cat {
    @Id
    Integer id;

    String name;
    Integer age;
}
