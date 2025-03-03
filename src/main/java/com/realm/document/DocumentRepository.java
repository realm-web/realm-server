package com.realm.document;

import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository;

public interface DocumentRepository extends ReactiveNeo4jRepository<Document, Long> {
    @Query(
        "MATCH (d:Document)-[r:BELONGS_TO]->(o:Folder), (n:Folder)" + 
        "WHERE d.id = $id AND n.id = $newParentId" + 
        "DELETE r" + 
        "CREATE (d)-[:BELONGS_TO]->(n)"
    )
    public Mono<Void> updateDocumentParent(@Param("id") Long id, @Param("newParentId") Long newParentId);

}
