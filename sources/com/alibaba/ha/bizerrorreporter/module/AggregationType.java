package com.alibaba.ha.bizerrorreporter.module;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public enum AggregationType {
    STACK("按堆栈聚合，传入堆栈对象throwable"),
    CONTENT("根据内容聚合，无堆栈的错误就根据内容聚合");
    
    private String name;

    AggregationType(String str) {
        this.name = str;
    }
}
