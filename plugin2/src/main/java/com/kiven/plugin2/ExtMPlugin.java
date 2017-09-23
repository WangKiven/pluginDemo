package com.kiven.plugin2;

import org.gradle.api.Plugin;
import org.gradle.api.Project;

/**
 *
 * Created by kiven on 2017/9/23.
 */

public class ExtMPlugin  implements Plugin<Project> {
    @Override
    public void apply(Project project) {
        System.out.println(":plugin2:ExtMPlugin");
    }
}
