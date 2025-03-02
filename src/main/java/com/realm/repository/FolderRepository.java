package com.realm.repository;

import com.realm.entity.Folder;
import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository;

public interface FolderRepository extends ReactiveNeo4jRepository<Folder, Long> {
}
