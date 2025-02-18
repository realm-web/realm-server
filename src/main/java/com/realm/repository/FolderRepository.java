package com.realm.repository;

import com.realm.entity.Folder;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface FolderRepository extends Neo4jRepository<Folder, Long> {
}
