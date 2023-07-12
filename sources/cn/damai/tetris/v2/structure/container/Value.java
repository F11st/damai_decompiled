package cn.damai.tetris.v2.structure.container;

import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class Value<T> implements Serializable {
    public final T obj;
    public final Class<T> objClass;

    public Value(Class<T> cls, T t) {
        this.objClass = cls;
        this.obj = t;
    }
}
