package com.uc.webview.export;

import java.util.HashMap;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class a extends HashMap<String, String> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public a() {
        AtomicInteger atomicInteger;
        AtomicInteger atomicInteger2;
        AtomicInteger atomicInteger3;
        Locale locale = Locale.CHINA;
        atomicInteger = WebView.j;
        atomicInteger2 = WebView.l;
        atomicInteger3 = WebView.k;
        put("export.webview", String.format(locale, "total:%d, u4:%d, system:%d", Integer.valueOf(atomicInteger.get()), Integer.valueOf(atomicInteger2.get()), Integer.valueOf(atomicInteger3.get())));
    }
}
