package com.uc.webview.export.business.setup;

import com.uc.webview.export.business.setup.a;
import com.uc.webview.export.internal.interfaces.IWaStat;
import java.util.HashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class h extends HashMap<String, String> {
    final /* synthetic */ String a;
    final /* synthetic */ a b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(a aVar, String str) {
        a.C0349a c0349a;
        a.C0349a c0349a2;
        a.C0349a c0349a3;
        a.C0349a c0349a4;
        a.C0349a c0349a5;
        a.C0349a c0349a6;
        this.b = aVar;
        this.a = str;
        put(IWaStat.BUSINESS_ELAPSE_INIT_TYPE, str);
        c0349a = aVar.h;
        put(IWaStat.BUSINESS_ELAPSE_INIT_CHECK, c0349a.b);
        c0349a2 = aVar.h;
        put(IWaStat.BUSINESS_ELAPSE_INIT_CHECK_CPU, c0349a2.c);
        c0349a3 = aVar.h;
        put(IWaStat.BUSINESS_ELAPSE_SETUP_CALLBACK, c0349a3.d);
        c0349a4 = aVar.h;
        put(IWaStat.BUSINESS_ELAPSE_SETUP_CALLBACK_CPU, c0349a4.e);
        c0349a5 = aVar.h;
        put(IWaStat.BUSINESS_ELAPSE_SUCCESS_CALLBACK, c0349a5.f);
        c0349a6 = aVar.h;
        put(IWaStat.BUSINESS_ELAPSE_SUCCESS_CALLBACK_CPU, c0349a6.g);
    }
}
