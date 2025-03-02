package com.realm.document;

import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository;

public interface DocumentRepository extends ReactiveNeo4jRepository<Document, Long> {
}
