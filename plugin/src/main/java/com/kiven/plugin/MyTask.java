package com.kiven.plugin;

import org.gradle.api.Action;
import org.gradle.api.DefaultTask;
import org.gradle.api.Task;

/**
 *
 * Created by kiven on 2017/7/27.
 */

public class MyTask extends DefaultTask {
    @Override
    public Task doFirst(Action<? super Task> action) {
        return super.doFirst(action);
    }

    @Override
    public Task doLast(Action<? super Task> action) {
        return super.doLast(action);
    }
}
