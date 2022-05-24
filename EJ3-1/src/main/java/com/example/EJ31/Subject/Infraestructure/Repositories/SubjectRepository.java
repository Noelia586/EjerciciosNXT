package com.example.EJ31.Subject.Infraestructure.Repositories;

import com.example.EJ31.Subject.Domain.Models.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, String> {
}
