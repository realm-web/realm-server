package com.realm.folder;

import com.realm.document.Document;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.ArrayList;
import java.util.List;

@Node
public class Folder {
    
    @Id
    @GeneratedValue
    private Long id;
    
    private String name;

    @Relationship(type = "BELONGS_TO", direction = Relationship.Direction.INCOMING)
    private List<Folder> folders = new ArrayList<>();
    
    @Relationship(type = "BELONGS_TO", direction = Relationship.Direction.INCOMING)
    private List<Document> documents = new ArrayList<>();

    public Folder(Long id, String name) {
        this.id = id;
        this.name = name;
    }

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

    public List<Folder> getFolders() {
        return folders;
    }

    public void setFolders(List<Folder> folders) {
        this.folders = folders;
    }

    public List<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }

    public boolean containsFolder(String name) {
        return folders.stream().anyMatch(folder -> folder.getName().equals(name));
    }
    
    public boolean containsDocument(String name) {
        return documents.stream().anyMatch(document -> document.getName().equals(name));
    }

}
