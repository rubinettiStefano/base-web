package com.generation.entities;

public class Question 
{
    private int id;
    private String content;
    private boolean resolved;

    public Question(){}

    

    public Question(int id, String content, boolean resolved) {
        this.id = id;
        this.content = content;
        this.resolved = resolved;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isResolved() {
        return resolved;
    }

    public void setResolved(boolean resolved) {
        this.resolved = resolved;
    }

    
}
