package com.example.community.mini;

import java.io.Serializable;

public class DictDto implements Serializable {

    private String label;
    private String value;


    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
