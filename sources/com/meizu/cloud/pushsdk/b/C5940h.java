package com.meizu.cloud.pushsdk.b;

/* compiled from: Taobao */
/* renamed from: com.meizu.cloud.pushsdk.b.h */
/* loaded from: classes10.dex */
public class C5940h<T> {
    private T a;
    private T b;

    /* JADX INFO: Access modifiers changed from: protected */
    public C5940h(T t) {
        if (t == null) {
            throw new RuntimeException("proxy must be has a default implementation");
        }
        this.b = t;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public T c() {
        T t = this.a;
        return t != null ? t : this.b;
    }
}
