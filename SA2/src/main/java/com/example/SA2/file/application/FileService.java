package com.example.SA2.file.application;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

public interface FileService {
  void init();
  void store(MultipartFile file);
  Stream<Path> loadAll();
  Path load(String filename);
  Resource loadAsResource(String filename);
  void deleteAll();
}
