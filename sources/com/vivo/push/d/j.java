package com.vivo.push.d;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
final class j implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ List b;
    final /* synthetic */ List c;
    final /* synthetic */ String d;
    final /* synthetic */ h e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(h hVar, int i, List list, List list2, String str) {
        this.e = hVar;
        this.a = i;
        this.b = list;
        this.c = list2;
        this.d = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        h hVar = this.e;
        PushMessageCallback pushMessageCallback = ((z) hVar).b;
        context = ((com.vivo.push.l) hVar).a;
        pushMessageCallback.onDelAlias(context, this.a, this.b, this.c, this.d);
    }
}
