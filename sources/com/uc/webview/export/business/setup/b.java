package com.uc.webview.export.business.setup;

import com.uc.webview.export.internal.interfaces.IWaStat;
import java.util.HashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class b extends HashMap<String, String> {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        com.uc.webview.export.business.a aVar2;
        com.uc.webview.export.business.a aVar3;
        com.uc.webview.export.business.a aVar4;
        com.uc.webview.export.business.a aVar5;
        com.uc.webview.export.business.a aVar6;
        this.a = aVar;
        aVar2 = aVar.c;
        put(IWaStat.BUSINESS_INIT_START, Long.toString(aVar2.a));
        aVar3 = aVar.e;
        put(IWaStat.BUSINESS_CHECK_INPUT_CONDITIONS, Long.toString(aVar3.a));
        aVar4 = aVar.f;
        put(IWaStat.BUSINESS_CHECK_NEW_CORE, Long.toString(aVar4.a));
        aVar5 = aVar.g;
        put(IWaStat.BUSINESS_CHECK_OLD_CORE, Long.toString(aVar5.a));
        aVar6 = aVar.d;
        put(IWaStat.BUSINESS_INIT_PROCESS, Long.toString(aVar6.a));
    }
}
