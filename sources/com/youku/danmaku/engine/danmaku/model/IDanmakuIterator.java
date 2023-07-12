package com.youku.danmaku.engine.danmaku.model;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public interface IDanmakuIterator {
    boolean hasNext();

    BaseDanmaku next();

    void remove();

    void reset();
}
