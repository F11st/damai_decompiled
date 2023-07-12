package com.taobao.android.launcher.config;

import com.taobao.android.job.core.TaskDeffer;
import com.taobao.android.job.core.task.TaskFactory;
import com.taobao.android.job.core.task.TaskProvider;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class Configuration {
    public final TaskDeffer<String, Void> deffer;
    public final TaskFactory<String, Void> factory;
    public final Generator<String> generator;
    public final String optimizedSwitch;
    public final TaskProvider<String, Void> provider;

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public static class Builder {
        private TaskDeffer<String, Void> deffer;
        private final TaskFactory<String, Void> factory;
        private final Generator<String> generator;
        private String optimizedSwitch = null;
        private final TaskProvider<String, Void> provider;

        public Builder(TaskFactory<String, Void> taskFactory, TaskProvider<String, Void> taskProvider, Generator<String> generator) {
            this.factory = taskFactory;
            this.provider = taskProvider;
            this.generator = generator;
        }

        public Builder bizSwitch(String str) {
            this.optimizedSwitch = str;
            return this;
        }

        public Configuration build() {
            return new Configuration(this.factory, this.provider, this.generator, this.optimizedSwitch, this.deffer);
        }

        public Builder taskDeffer(TaskDeffer<String, Void> taskDeffer) {
            this.deffer = taskDeffer;
            return this;
        }
    }

    private Configuration(TaskFactory<String, Void> taskFactory, TaskProvider<String, Void> taskProvider, Generator<String> generator, String str, TaskDeffer<String, Void> taskDeffer) {
        this.provider = taskProvider;
        this.generator = generator;
        this.factory = taskFactory;
        this.optimizedSwitch = str;
        this.deffer = taskDeffer;
    }
}
