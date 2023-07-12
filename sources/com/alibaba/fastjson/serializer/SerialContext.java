package com.alibaba.fastjson.serializer;

import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class SerialContext {
    public final int features;
    public final Object fieldName;
    public final Object object;
    public final SerialContext parent;

    public SerialContext(SerialContext serialContext, Object obj, Object obj2, int i) {
        this.parent = serialContext;
        this.object = obj;
        this.fieldName = obj2;
        this.features = i;
    }

    public String toString() {
        if (this.parent == null) {
            return "$";
        }
        if (this.fieldName instanceof Integer) {
            return this.parent.toString() + jn1.ARRAY_START_STR + this.fieldName + jn1.ARRAY_END_STR;
        }
        return this.parent.toString() + "." + this.fieldName;
    }
}
