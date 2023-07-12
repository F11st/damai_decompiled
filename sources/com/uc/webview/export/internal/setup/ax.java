package com.uc.webview.export.internal.setup;

import com.uc.webview.export.internal.interfaces.IWaStat;
import com.uc.webview.export.internal.utility.Log;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public abstract class ax extends l {
    protected bu a;

    protected abstract bu a(bt btVar);

    protected void a(String str, Object obj) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(List<bt> list) {
        StringBuilder sb = new StringBuilder("runQuick ucms:");
        sb.append(list == null ? "null" : Integer.valueOf(list.size()));
        Log.i("StandardSetupTask", sb.toString());
        IWaStat.WaStat.stat(IWaStat.SETUP_UCM_LIST_SIZE, Integer.toString(list == null ? 0 : list.size()));
        if (list != null && list.size() > 0) {
            b(list.get(0));
            return;
        }
        throw new UCSetupException(3004, "UCM packages not found, status:" + af.c());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't wrap try/catch for region: R(16:1|(4:2|3|(1:5)|6)|(4:8|(2:10|68)|26|(5:28|29|(1:31)|32|(2:34|(3:(1:37)|38|39)(1:40))(1:41)))(1:73)|42|(1:44)|45|(2:47|109)|64|65|66|67|29|(0)|32|(0)(0)|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x01ab, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x01ac, code lost:
        setException(new com.uc.webview.export.internal.setup.UCSetupException(4018, r0));
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x01b7, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x01b8, code lost:
        setException(r0);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01f6 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x022d  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0258 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Type inference failed for: r0v4, types: [com.uc.webview.export.internal.setup.UCSetupException] */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r3v2, types: [com.uc.webview.export.internal.setup.UCSetupException] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void b(com.uc.webview.export.internal.setup.bt r20) {
        /*
            Method dump skipped, instructions count: 601
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.webview.export.internal.setup.ax.b(com.uc.webview.export.internal.setup.bt):void");
    }
}
