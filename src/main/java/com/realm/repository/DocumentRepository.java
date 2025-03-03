package com.realm.repository;

import com.realm.entity.Document;
import org.springframework.data.neo4j.repository.Neo4jRepository;



public interface DocumentRepository extends Neo4jRepository<Document, Long> {
    
    @Query(
            "MATCH (d:Document) WHERE id(d) = $id " +
            "MATCH (p:Folder) WHERE id(p) = $newParentId " +
            "MERGE (d)-[:BELONGS_TO]->(p) " + 
            "RETURN d")
    public Mono<Void> updateDocumentParent(Long id, Long newParentId);
}
