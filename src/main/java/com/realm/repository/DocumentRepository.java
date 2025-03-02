package com.realm.repository;

import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository;

import com.realm.entity.Document;

public interface DocumentRepository extends ReactiveNeo4jRepository<Document, Long> {
}
