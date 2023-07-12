package com.uc.webview.export.utility;

import java.util.Formatter;
import java.util.Locale;

/* compiled from: Taobao */
/* renamed from: com.uc.webview.export.utility.a */
/* loaded from: classes11.dex */
final class C7360a extends ThreadLocal<Formatter> {
    StringBuilder a = new StringBuilder();

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.ThreadLocal
    /* renamed from: a */
    public synchronized Formatter initialValue() {
        return new Formatter(this.a, Locale.getDefault());
    }

    @Override // java.lang.ThreadLocal
    public final /* synthetic */ Formatter get() {
        Formatter formatter = (Formatter) super.get();
        this.a.setLength(0);
        return formatter;
    }
}
