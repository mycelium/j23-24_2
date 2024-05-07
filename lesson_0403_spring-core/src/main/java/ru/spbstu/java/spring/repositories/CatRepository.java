package ru.spbstu.java.spring.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import ru.spbstu.java.spring.entities.Cat;

@NoRepositoryBean
public interface CatRepository extends CrudRepository<Cat, Integer> {
}
