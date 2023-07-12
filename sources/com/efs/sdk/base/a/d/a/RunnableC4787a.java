package com.efs.sdk.base.a.d.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.efs.sdk.base.a.d.C4786a;
import tb.m73;
import tb.v43;
import tb.w63;
import tb.x53;

/* compiled from: Taobao */
/* renamed from: com.efs.sdk.base.a.d.a.a */
/* loaded from: classes10.dex */
public final class RunnableC4787a extends BroadcastReceiver implements Runnable {
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        x53.a(this);
    }

    @Override // java.lang.Runnable
    public final void run() {
        v43 v43Var;
        v43Var = v43.C9807a.a;
        String b = m73.b(C4786a.a().c);
        w63.b("efs.info.manager", "network change: ".concat(String.valueOf(b)), null);
        v43Var.a.b("net", b);
    }
}
