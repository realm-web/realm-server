package com.realm.folder;

import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;
import reactor.core.publisher.Mono;

public interface FolderRepository extends ReactiveNeo4jRepository<Folder, Long> {

    @Query("""
        MATCH (f:Folder)-[r:BELONGS_TO]->(:Folder)
        WHERE id(f) = $id
        MATCH (n:Folder)
        WHERE id(n) = $newParentId
        DELETE r
        CREATE (f)-[:BELONGS_TO]->(n)
        """)
    Mono<Void> updateFolderParent(@Param("id") Long id, @Param("newParentId") Long newParentId);

    @Query("""
        MATCH (a:Folder) WHERE id(a) = $id
        OPTIONAL MATCH (a) (()<-[:BELONGS_TO]-())* (b)
        DETACH DELETE b
        """)
    Mono<Void> deleteFolderCascade(@Param("id") Long id);

}
