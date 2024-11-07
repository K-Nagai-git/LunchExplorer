package com.example.lunchex.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.lunchex.entity.FileEntity;

public interface FileRepository extends JpaRepository<FileEntity, Long> {
}
