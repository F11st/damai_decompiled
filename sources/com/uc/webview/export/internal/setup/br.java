package com.uc.webview.export.internal.setup;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class br extends Handler {
    final /* synthetic */ UCAsyncTask a;
    private UCAsyncTask b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public br(UCAsyncTask uCAsyncTask, Looper looper) {
        super(looper);
        this.a = uCAsyncTask;
        this.b = null;
    }

    private static void a(UCAsyncTask uCAsyncTask) {
        Object obj;
        if (uCAsyncTask == null) {
            return;
        }
        obj = uCAsyncTask.d;
        synchronized (obj) {
            uCAsyncTask.mPercent = (int) ((UCAsyncTask.e(uCAsyncTask) * 100.0f) / UCAsyncTask.f(uCAsyncTask));
        }
        uCAsyncTask.callback("progress");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:1|(2:2|3)|(18:5|7|8|(4:10|11|(2:13|14)|15)|16|48|(3:23|5d|29)|(1:33)|35|36|(7:38|40|(5:41|d8|86|87|60)|(1:65)(1:80)|66|67|(4:69|(1:71)(1:76)|72|73)(1:77))|94|40|(3:41|d8|60)|(0)(0)|66|67|(0)(0))|111|7|8|(0)|16|48|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x009c, code lost:
        r9 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x009d, code lost:
        r2 = r8.b;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00a1, code lost:
        if ((r9 instanceof com.uc.webview.export.internal.setup.UCSetupException) != false) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00a3, code lost:
        r9 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00a6, code lost:
        r9 = new com.uc.webview.export.internal.setup.UCSetupException(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00ac, code lost:
        r2.setException(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00af, code lost:
        r9 = r8.b.d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00b5, code lost:
        monitor-enter(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00b6, code lost:
        com.uc.webview.export.internal.setup.UCAsyncTask.j(r8.b);
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00c0, code lost:
        r9 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00c1, code lost:
        r9.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x014b, code lost:
        r6 = r0;
     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0167 A[Catch: all -> 0x019e, TryCatch #10 {all -> 0x019e, blocks: (B:98:0x015d, B:100:0x0167, B:104:0x017c, B:103:0x0174), top: B:114:0x015d }] */
    /* JADX WARN: Removed duplicated region for block: B:10:0x001a A[Catch: all -> 0x009c, TRY_LEAVE, TryCatch #7 {all -> 0x009c, blocks: (B:8:0x0012, B:10:0x001a, B:17:0x0036, B:18:0x003b, B:19:0x0042, B:20:0x0048, B:26:0x0055, B:27:0x005d, B:37:0x008a, B:39:0x0090, B:13:0x0028, B:28:0x005e, B:30:0x0066, B:31:0x0083, B:21:0x0049, B:24:0x0052), top: B:123:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:122:0x00d9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:128:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0049 A[Catch: all -> 0x0099, TRY_ENTER, TryCatch #7 {all -> 0x009c, blocks: (B:8:0x0012, B:10:0x001a, B:17:0x0036, B:18:0x003b, B:19:0x0042, B:20:0x0048, B:26:0x0055, B:27:0x005d, B:37:0x008a, B:39:0x0090, B:13:0x0028, B:28:0x005e, B:30:0x0066, B:31:0x0083, B:21:0x0049, B:24:0x0052), top: B:123:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0158  */
    @Override // android.os.Handler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void dispatchMessage(android.os.Message r9) {
        /*
            Method dump skipped, instructions count: 421
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.webview.export.internal.setup.br.dispatchMessage(android.os.Message):void");
    }
}
