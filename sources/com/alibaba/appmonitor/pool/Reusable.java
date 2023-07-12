package com.alibaba.appmonitor.pool;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public interface Reusable {
    void clean();

    void fill(Object... objArr);
}
