package com.alibaba.poplayer.layermanager.config;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class ConfigItem {
    public boolean enqueue;
    public boolean exclusive;
    public boolean forcePopRespectingPriority;
    public int level;
    public int priority;

    public String toString() {
        return "{level=" + this.level + ", priority=" + this.priority + ", enqueue=" + this.enqueue + ", force=" + this.forcePopRespectingPriority + ", exclusive=" + this.exclusive + '}';
    }
}
