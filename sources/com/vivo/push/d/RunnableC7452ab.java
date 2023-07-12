package com.vivo.push.d;

import android.content.Context;
import com.vivo.push.AbstractRunnableC7491l;
import com.vivo.push.sdk.PushMessageCallback;
import java.util.List;

/* compiled from: Taobao */
/* renamed from: com.vivo.push.d.ab */
/* loaded from: classes11.dex */
final class RunnableC7452ab implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ List b;
    final /* synthetic */ List c;
    final /* synthetic */ String d;
    final /* synthetic */ aa e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC7452ab(aa aaVar, int i, List list, List list2, String str) {
        this.e = aaVar;
        this.a = i;
        this.b = list;
        this.c = list2;
        this.d = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        aa aaVar = this.e;
        PushMessageCallback pushMessageCallback = ((AbstractC7480z) aaVar).b;
        context = ((AbstractRunnableC7491l) aaVar).a;
        pushMessageCallback.onSetTags(context, this.a, this.b, this.c, this.d);
    }
}
