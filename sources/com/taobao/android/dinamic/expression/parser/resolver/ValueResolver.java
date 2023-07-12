package com.taobao.android.dinamic.expression.parser.resolver;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
interface ValueResolver {
    boolean canResolve(Object obj, Class<?> cls, String str);

    Object resolve(Object obj, Class<?> cls, String str);
}
