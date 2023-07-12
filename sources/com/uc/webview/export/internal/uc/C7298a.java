package com.uc.webview.export.internal.uc;

import com.uc.webview.export.internal.interfaces.InvokeObject;

/* compiled from: Taobao */
/* renamed from: com.uc.webview.export.internal.uc.a */
/* loaded from: classes11.dex */
public final class C7298a implements InvokeObject {
    Object a;
    int b;

    public C7298a(int i, Object obj) {
        this.a = obj;
        this.b = i;
    }

    @Override // com.uc.webview.export.internal.interfaces.InvokeObject
    public final Object invoke(int i, Object[] objArr) {
        return Integer.valueOf(this.b);
    }
}
