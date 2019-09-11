package com.example.demo.Entity;

public class Poetry {
    String content;
    String translate;
    String notes;
    String appreciation;
    String pinyin;
    String name;
    String dynasty;
    String poet;
    long poetId;

    public Poetry() {
    }

    @Override
    public String toString() {
        return "Poetry{" +
                "content='" + content + '\'' +
                ", translate='" + translate + '\'' +
                ", notes='" + notes + '\'' +
                ", appreciation='" + appreciation + '\'' +
                ", pinyin='" + pinyin + '\'' +
                ", name='" + name + '\'' +
                ", dynasty='" + dynasty + '\'' +
                ", poet='" + poet + '\'' +
                ", poetId=" + poetId +
                '}';
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTranslate() {
        return translate;
    }

    public void setTranslate(String translate) {
        this.translate = translate;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getAppreciation() {
        return appreciation;
    }

    public void setAppreciation(String appreciation) {
        this.appreciation = appreciation;
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDynasty() {
        return dynasty;
    }

    public void setDynasty(String dynasty) {
        this.dynasty = dynasty;
    }

    public String getPoet() {
        return poet;
    }

    public void setPoet(String poet) {
        this.poet = poet;
    }

    public long getPoetId() {
        return poetId;
    }

    public void setPoetId(long poetId) {
        this.poetId = poetId;
    }
}
