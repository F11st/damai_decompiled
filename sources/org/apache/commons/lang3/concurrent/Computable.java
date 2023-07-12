package org.apache.commons.lang3.concurrent;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public interface Computable<I, O> {
    O compute(I i) throws InterruptedException;
}
