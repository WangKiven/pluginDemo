package com.kiven.plugin;

import java.io.File;

/**
 * Created by kiven on 2017/9/13.
 */

public class AssembleInfo{
    public boolean isSigningReady;
    public File apkPath;
    public String flavorName;
    public String buildType;
    public String subDir;

    public AssembleInfo(boolean isSigningReady, File apkPath, String flavorName, String buildType, String subDir) {
        this.isSigningReady = isSigningReady;
        this.apkPath = apkPath;
        this.flavorName = flavorName;
        this.buildType = buildType;
        this.subDir = subDir;
    }
}
