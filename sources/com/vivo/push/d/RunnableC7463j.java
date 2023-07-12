package com.vivo.push.d;

import android.content.Context;
import com.vivo.push.AbstractRunnableC7491l;
import com.vivo.push.sdk.PushMessageCallback;
import java.util.List;

/* compiled from: Taobao */
/* renamed from: com.vivo.push.d.j */
/* loaded from: classes11.dex */
final class RunnableC7463j implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ List b;
    final /* synthetic */ List c;
    final /* synthetic */ String d;
    final /* synthetic */ C7461h e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC7463j(C7461h c7461h, int i, List list, List list2, String str) {
        this.e = c7461h;
        this.a = i;
        this.b = list;
        this.c = list2;
        this.d = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        C7461h c7461h = this.e;
        PushMessageCallback pushMessageCallback = ((AbstractC7480z) c7461h).b;
        context = ((AbstractRunnableC7491l) c7461h).a;
        pushMessageCallback.onDelAlias(context, this.a, this.b, this.c, this.d);
    }
}
