package com.realm.repository;

import com.realm.entity.Folder;
import org.springframework.data.neo4j.repository.Neo4jRepository;


public interface FolderRepository extends Neo4jRepository<Folder, Long> {
    @Query(
        "MATCH (d:Document) WHERE id(d) = $id " +
        "MATCH (p:Document) WHERE id(p) = $newParentId " +
        "MERGE (d)-[BELONGS_TO]->(p) " +
        "RETURN d"
    )
    public Mono<Void> updateFolderParent(Long id, Long newParentId);

    
    public Mono<Void> deleteFolderCascade(Long id);
}
