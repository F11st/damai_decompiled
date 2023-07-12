package com.google.common.base;

import tb.du1;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
enum Functions$ToStringFunction implements Function<Object, String> {
    INSTANCE;

    @Override // java.lang.Enum
    public String toString() {
        return "Functions.toStringFunction()";
    }

    @Override // com.google.common.base.Function
    public String apply(Object obj) {
        du1.p(obj);
        return obj.toString();
    }
}
