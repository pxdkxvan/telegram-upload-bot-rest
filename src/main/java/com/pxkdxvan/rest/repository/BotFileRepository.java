package com.pxkdxvan.rest.repository;

import com.pxkdxvan.rest.model.BotFile;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface BotFileRepository extends JpaRepository<BotFile, UUID> {
    Optional<BotFile> findByShareId(UUID sharedId);
}
