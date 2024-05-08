package ru.spbstu.java.spring.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.springframework.data.relational.core.mapping.Table;

@Entity
@Table("cats")
public class Cat {
    @Id
    @GeneratedValue
    Integer id;

    String name;
    Integer age;
}
