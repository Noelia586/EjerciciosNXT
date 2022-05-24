package com.example.EJ31.Teacher.Infraestructure.Repositories;

import com.example.EJ31.Teacher.Domain.Models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface TeacherRepository extends JpaRepository<Teacher, String> {

    @Query(value = "select * from Teacher where person_id =?1", nativeQuery = true)
    Optional<Teacher> findByPersonId(String person);
}
