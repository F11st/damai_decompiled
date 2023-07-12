package com.uc.webview.export.internal.utility;

import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import com.uc.webview.export.internal.utility.n;
import java.lang.Thread;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
final class o implements Thread.UncaughtExceptionHandler {
    final /* synthetic */ String a;
    final /* synthetic */ n.b b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n.b bVar, String str) {
        this.b = bVar;
        this.a = str;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th) {
        String str = n.a;
        Log.d(str, this.a + " uncaughtException " + thread + AVFSCacheConstants.COMMA_SEP + p.a(th));
    }
}
