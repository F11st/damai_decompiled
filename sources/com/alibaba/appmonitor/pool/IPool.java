package com.alibaba.appmonitor.pool;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
interface IPool {
    <T extends Reusable> void offer(T t);

    <T extends Reusable> T poll(Class<T> cls, Object... objArr);
}
