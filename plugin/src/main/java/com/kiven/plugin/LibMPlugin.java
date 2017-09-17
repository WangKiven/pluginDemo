package com.kiven.plugin;

import org.codehaus.groovy.runtime.InvokerHelper;
import org.gradle.api.Action;
import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.Task;
import org.gradle.api.file.CopySpec;
import org.gradle.api.tasks.Copy;

import groovy.lang.Closure;

public class LibMPlugin implements Plugin<Project> {
    @Override
    public void apply(Project project) {
        Task task = project.getTasks().create("hello", MyTask.class);
        task.setGroup("customTask");
        // 任务顺序
        /*task.mustRunAfter(project.getTasksByName("", false));
        task.dependsOn()*/

//        project.getExtensions().create("myExt", MyExt.class);

        // 配置工程
        configProject(project);

    }

    private void configProject(Project project) {
        //
        MyExt myExt = project.getExtensions().create("myExt", MyExt.class);
        // 打包后复制文件
        project.getTasks().whenTaskAdded((Task task) -> {
            if (task.getName().contains("assemble")) {
                task.doLast(task1 -> {
                    println("------------------ 复制mapping文件 -----------------------");
                    myExt.getMap().forEach((key, assembleInfo) -> {
                        println("key = " + key);
                        if (key.equalsIgnoreCase(task.getName()) && assembleInfo.isSigningReady) {
                            // 获取目标文件路径
                            String fn = assembleInfo.flavorName;
                            String mappingPath;
                            if (fn == null || fn.length() == 0) {
                                mappingPath = "build/outputs/mapping/" + assembleInfo.buildType;
                            } else {
                                mappingPath = "build/outputs/mapping/$fn/" + assembleInfo.buildType;
                            }
                            // 复制
                            project.copy(copy -> {
                                copy.from(mappingPath);
                                copy.into(assembleInfo.apkPath.getParent());
                                copy.include("mapping.txt");
                            });
                        }
                    });
                });
            }
        });
    }

    public void println(/*Object self, */Object value) {
        /*if(self instanceof Writer) {
            PrintWriter pw = new GroovyPrintWriter((Writer)self);
            pw.println(value);
        } else {*/
        System.out.println(InvokerHelper.toString(value));
        /*}*/

    }
}
