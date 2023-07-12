package com.uc.webview.export.internal.setup;

import java.util.HashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* renamed from: com.uc.webview.export.internal.setup.s */
/* loaded from: classes11.dex */
public final class C7289s extends HashMap<String, String> {
    final /* synthetic */ boolean a;
    final /* synthetic */ C7285o b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C7289s(C7285o c7285o, boolean z) {
        this.b = c7285o;
        this.a = z;
        put("vmsize_saving_enable", z ? "true" : "false");
    }
}
