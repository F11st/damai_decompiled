package com.alipay.android.phone.mrpc.core;

import java.lang.reflect.Method;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public abstract class a implements v {
    public Method a;
    public byte[] b;
    public String c;
    public int d;
    public String e;
    public boolean f;

    public a(Method method, int i, String str, byte[] bArr, String str2, boolean z) {
        this.a = method;
        this.d = i;
        this.c = str;
        this.b = bArr;
        this.e = str2;
        this.f = z;
    }
}
