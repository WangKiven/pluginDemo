package com.kiven.plugin;

import java.io.File;
import java.util.TreeMap;

/**
 * Created by kiven on 2017/7/27.
 */

public class MyExt {
    private String name;
    private MyInnerExt innerExt;

    private final TreeMap<String, AssembleInfo> map = new TreeMap<>();

    public void setName(String name) {
        this.name = name;
    }

    public void setInnerExt(MyInnerExt innerExt) {
        this.innerExt = innerExt;
    }

    public String getName() {
        return name;
    }

    public MyInnerExt getInnerExt() {
        return innerExt;
    }

    public TreeMap<String, AssembleInfo> getMap() {
        return map;
    }

    public void addAssembleInfo(boolean isSigningReady, String flavorName, String buildType, File outputFile, String subDir) {
        map.put("assemble" + flavorName + buildType,
                new AssembleInfo(isSigningReady, outputFile, flavorName, buildType, subDir));
    }

    public void addAssembleInfo(boolean isSigningReady, String flavorName, String buildType, File outputFile) {
        map.put("assemble" + flavorName + buildType,
                new AssembleInfo(isSigningReady, outputFile, flavorName, buildType, null));
    }
}
