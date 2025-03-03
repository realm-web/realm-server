package com.realm.folder;

import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;
import reactor.core.publisher.Mono;

public interface FolderRepository extends ReactiveNeo4jRepository<Folder, Long> {
    // Update the parent of a folder
    @Query("MATCH (f:Folder)-[r:BELONGS_TO]->() WHERE id(f) = $id DELETE r " +
            "WITH f " +
            "MATCH (p:Folder) WHERE id(p) = $newParentId " +
            "CREATE (f)-[:BELONGS_TO]->(p)")
    Mono<Void> updateFolderParent(@Param("id") Long id, @Param("newParentId") Long newParentId);

    // Delete a folder and cascade delete its relationships
    @Query("MATCH (f:Folder) WHERE id(f) = $id " +
            "OPTIONAL MATCH (f)-[r:BELONGS_TO]->() " +
            "DELETE f, r")
    Mono<Void> deleteFolderCascade(@Param("id") Long id);
}
