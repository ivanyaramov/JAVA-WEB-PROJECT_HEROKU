package com.example.project.web;

public class ObjectNotFoundException extends RuntimeException{

    private final Long objectId;
    private final String type;

    public ObjectNotFoundException(Long objectId, String type) {
        super("Object with id " + objectId + " not found in " + type);
        this.objectId = objectId;
        this.type = type;
    }

    public Long getObjectId() {
        return objectId;
    }

    public String getType() {
        return type;
    }
}
