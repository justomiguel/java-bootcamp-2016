package com.topic5.app;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;
import org.mongodb.morphia.annotations.Version;
 
/**
 *Class BaseEntity corresponding to the Topic 5 of Java bootcamp
 *@author Juan Ignacio Cavalieri
 *@version 2016
 */
public abstract class BaseEntity {
 
    @Id
    @Property("id")
    protected ObjectId id;
 
    @Version
    @Property("version")
    private Long version;
 
    /**
     * Constructor of BaseEntity class
     */
    public BaseEntity() {
        super();
    }
 
    public ObjectId getId() {
        return id;
    }
 
    public void setId(ObjectId id) {
        this.id = id;
    }
 
    public Long getVersion() {
        return version;
    }
 
    public void setVersion(Long version) {
        this.version = version;
    }
 
}
