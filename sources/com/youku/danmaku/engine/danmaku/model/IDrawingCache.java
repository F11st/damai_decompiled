package com.youku.danmaku.engine.danmaku.model;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public interface IDrawingCache<T> {
    void build(int i, int i2, int i3, boolean z, int i4);

    void decreaseReference();

    void destroy();

    void erase();

    T get();

    boolean hasReferences();

    int height();

    void increaseReference();

    int size();

    int width();
}
