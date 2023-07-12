package org.reactivestreams;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public interface Subscription {
    void cancel();

    void request(long j);
}
