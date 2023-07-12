package com.uc.webview.export.business.setup;

import com.uc.webview.export.business.C7179a;
import com.uc.webview.export.internal.interfaces.IWaStat;
import java.util.HashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* renamed from: com.uc.webview.export.business.setup.b */
/* loaded from: classes11.dex */
public final class C7186b extends HashMap<String, String> {
    final /* synthetic */ C7184a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C7186b(C7184a c7184a) {
        C7179a c7179a;
        C7179a c7179a2;
        C7179a c7179a3;
        C7179a c7179a4;
        C7179a c7179a5;
        this.a = c7184a;
        c7179a = c7184a.c;
        put(IWaStat.BUSINESS_INIT_START, Long.toString(c7179a.a));
        c7179a2 = c7184a.e;
        put(IWaStat.BUSINESS_CHECK_INPUT_CONDITIONS, Long.toString(c7179a2.a));
        c7179a3 = c7184a.f;
        put(IWaStat.BUSINESS_CHECK_NEW_CORE, Long.toString(c7179a3.a));
        c7179a4 = c7184a.g;
        put(IWaStat.BUSINESS_CHECK_OLD_CORE, Long.toString(c7179a4.a));
        c7179a5 = c7184a.d;
        put(IWaStat.BUSINESS_INIT_PROCESS, Long.toString(c7179a5.a));
    }
}
