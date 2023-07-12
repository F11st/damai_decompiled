package com.google.gson;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public interface ExclusionStrategy {
    boolean shouldSkipClass(Class<?> cls);

    boolean shouldSkipField(FieldAttributes fieldAttributes);
}
