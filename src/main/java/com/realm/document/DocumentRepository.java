package com.realm.document;

import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;
import reactor.core.publisher.Mono;

public interface DocumentRepository extends ReactiveNeo4jRepository<Document, Long> {

    @Query("""
        MATCH (d:Document)-[r:BELONGS_TO]->(:Folder)
        WHERE id(d) = $id
        MATCH (n:Folder)
        WHERE id(n) = $newParentId
        DELETE r
        CREATE (d)-[:BELONGS_TO]->(n)
        """)
    Mono<Void> updateDocumentParent(@Param("id") Long id, @Param("newParentId") Long newParentId);

}
