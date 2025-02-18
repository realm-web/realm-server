package com.realm.repository;

import com.realm.entity.Document;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface DocumentRepository extends Neo4jRepository<Document, Long> {
}
