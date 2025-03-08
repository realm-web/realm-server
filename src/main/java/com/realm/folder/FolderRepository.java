package com.realm.folder;

import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository;

public interface FolderRepository extends ReactiveNeo4jRepository<Folder, Long> {
}
