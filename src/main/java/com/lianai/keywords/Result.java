package com.lianai.keywords;

/**
 * 匹配结果
 * 
 * @author RUIZ
 */
public class Result {

    private int index;

    private String content;

    public Result(int index, String content) {
        this.index = index;
        this.content = content;
    }

    public int getIndex() {
        return index;
    }

    public String getContent() {
        return content;
    }

    public int length() {
        return content.length();
    }

    public String toString() {
        return "{index=" + index + ", content=" + content + "}";
    }

}
