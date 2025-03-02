package com.realm.entity;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.List;

@Node
public class Folder {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @Relationship(type = "BELONGS_TO", direction = Relationship.Direction.INCOMING)
    private List<Document> documents;

    @Relationship(type = "BELONGS_TO", direction = Relationship.Direction.INCOMING)
    private List<Folder> folders;
    @Relationship(type = "BELONGS_TO", direction = Relationship.Direction.OUTGOING)
    private Folder parent;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }

    public List<Folder> getFolders() {
        return folders;
    }

    public void setFolders(List<Folder> folders) {
        this.folders = folders;
    }

    public Folder getParent() {
        return parent;
    }

    public void setParent(Folder parent) {
        this.parent = parent;
    }
}