package com.kiven.plugin;

/**
 * Created by kiven on 2017/7/27.
 */

public class MyInnerExt {
    private String name;
    private int version;

    public String getName() {
        return name;
    }

    public MyInnerExt(String name, int version) {
        this.name = name;
        this.version = version;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
