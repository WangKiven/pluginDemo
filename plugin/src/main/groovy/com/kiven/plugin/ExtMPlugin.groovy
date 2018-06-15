package com.kiven.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.Task

class ExtMPlugin implements Plugin<Project> {
    @Override
    void apply(Project project) {
        Task task = project.getTasks().create("hello", MyTask.class)
        task.setGroup("customTask")
        // 任务顺序
        /*task.mustRunAfter(project.getTasksByName("", false));
        task.dependsOn()*/

//        project.getExtensions().create("myExt", MyExt.class);

        // 配置工程
        configProject(project)
    }

    private void configProject(Project project) {
        //
        MyExt myExt = project.getExtensions().create("myExt", MyExt.class)
        // 打包后复制文件
        project.tasks.whenTaskAdded {
            task ->
                if (task.name.contains('assemble')) {
                    task.doLast {
                        myExt.map.each {
                            key, assembleInfo ->
                                if (key.equalsIgnoreCase(task.name) && assembleInfo.isSigningReady) {
                                    println(":myPlugin:copyFile")

                                    project.copy {
                                        String fn = assembleInfo.flavorName
                                        String mappingPath
                                        if (fn == null || fn.length() == 0) {
                                            mappingPath = "build/outputs/mapping/$assembleInfo.buildType"
                                        } else {
                                            mappingPath = "build/outputs/mapping/$fn/$assembleInfo.buildType"
                                        }

                                        from mappingPath
                                        into assembleInfo.apkPath.parent
                                        include 'mapping.txt'
                                    }
                                }
                        }
                    }
                }
        }
//        project.apply from : 'config.gradle'
    }
}
