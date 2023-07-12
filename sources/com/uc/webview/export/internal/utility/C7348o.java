package com.uc.webview.export.internal.utility;

import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import com.uc.webview.export.internal.utility.C7345n;
import java.lang.Thread;

/* compiled from: Taobao */
/* renamed from: com.uc.webview.export.internal.utility.o */
/* loaded from: classes11.dex */
final class C7348o implements Thread.UncaughtExceptionHandler {
    final /* synthetic */ String a;
    final /* synthetic */ C7345n.ThreadFactoryC7347b b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C7348o(C7345n.ThreadFactoryC7347b threadFactoryC7347b, String str) {
        this.b = threadFactoryC7347b;
        this.a = str;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th) {
        String str = C7345n.a;
        Log.d(str, this.a + " uncaughtException " + thread + AVFSCacheConstants.COMMA_SEP + C7349p.a(th));
    }
}
