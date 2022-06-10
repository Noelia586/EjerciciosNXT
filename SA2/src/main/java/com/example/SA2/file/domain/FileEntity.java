package com.example.SA2.file.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
public class FileEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private String id;

  private String name;
  private Date uploadDate = new Date();
  private String metadata;

  public FileEntity(String name, String metadata) {
    this.name = name;
    this.metadata = metadata;
  }
}
