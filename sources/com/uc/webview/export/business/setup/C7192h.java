package com.uc.webview.export.business.setup;

import com.uc.webview.export.business.setup.C7184a;
import com.uc.webview.export.internal.interfaces.IWaStat;
import java.util.HashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* renamed from: com.uc.webview.export.business.setup.h */
/* loaded from: classes11.dex */
public final class C7192h extends HashMap<String, String> {
    final /* synthetic */ String a;
    final /* synthetic */ C7184a b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C7192h(C7184a c7184a, String str) {
        C7184a.C7185a c7185a;
        C7184a.C7185a c7185a2;
        C7184a.C7185a c7185a3;
        C7184a.C7185a c7185a4;
        C7184a.C7185a c7185a5;
        C7184a.C7185a c7185a6;
        this.b = c7184a;
        this.a = str;
        put(IWaStat.BUSINESS_ELAPSE_INIT_TYPE, str);
        c7185a = c7184a.h;
        put(IWaStat.BUSINESS_ELAPSE_INIT_CHECK, c7185a.b);
        c7185a2 = c7184a.h;
        put(IWaStat.BUSINESS_ELAPSE_INIT_CHECK_CPU, c7185a2.c);
        c7185a3 = c7184a.h;
        put(IWaStat.BUSINESS_ELAPSE_SETUP_CALLBACK, c7185a3.d);
        c7185a4 = c7184a.h;
        put(IWaStat.BUSINESS_ELAPSE_SETUP_CALLBACK_CPU, c7185a4.e);
        c7185a5 = c7184a.h;
        put(IWaStat.BUSINESS_ELAPSE_SUCCESS_CALLBACK, c7185a5.f);
        c7185a6 = c7184a.h;
        put(IWaStat.BUSINESS_ELAPSE_SUCCESS_CALLBACK_CPU, c7185a6.g);
    }
}
