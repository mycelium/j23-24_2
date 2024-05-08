package ru.spbstu.java.spring.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;
import ru.spbstu.java.spring.entities.Cat;

import java.util.List;

@Repository
public interface CatRepository extends CrudRepository<Cat, Integer> {

    public List<Cat> findAll();
}
