package com.wangyi.website.model;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by cengruilin on 15/7/31.
 */

@Document
public class CategoryModel {

    private String categoryName;

    private String describe;

    private int index;

    private String category;

    private String id;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
