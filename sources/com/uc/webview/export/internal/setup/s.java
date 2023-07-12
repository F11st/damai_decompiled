package com.uc.webview.export.internal.setup;

import java.util.HashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class s extends HashMap<String, String> {
    final /* synthetic */ boolean a;
    final /* synthetic */ o b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(o oVar, boolean z) {
        this.b = oVar;
        this.a = z;
        put("vmsize_saving_enable", z ? "true" : "false");
    }
}
