package com.example.SA2.file.infrastructure.repository;

import com.example.SA2.file.domain.FileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
public interface FileRepositoryJpa extends JpaRepository<FileEntity,String>{
}
