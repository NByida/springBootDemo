package com.example.demo.Entity;

public class Tag {
    String id;
    String tag;
    String poetryid;

    @Override
    public String toString() {
        return "Tag{" +
                "id='" + id + '\'' +
                ", tag='" + tag + '\'' +
                ", poetryid='" + poetryid + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getPoetryid() {
        return poetryid;
    }

    public void setPoetryid(String poetryid) {
        this.poetryid = poetryid;
    }

    public Tag() {
    }
}
