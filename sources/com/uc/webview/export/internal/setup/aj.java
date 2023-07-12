package com.uc.webview.export.internal.setup;

import android.content.Context;
import android.webkit.ValueCallback;
import com.taobao.accs.common.Constants;
import com.uc.webview.export.internal.setup.UCSetupTask;
import com.uc.webview.export.internal.utility.C7349p;
import com.uc.webview.export.internal.utility.Log;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class aj<RETURN_TYPE extends UCSetupTask<RETURN_TYPE, CALLBACK_TYPE>, CALLBACK_TYPE extends UCSetupTask<RETURN_TYPE, CALLBACK_TYPE>> {
    private static String d = "aj";
    String a = "";
    public final ValueCallback<CALLBACK_TYPE> b = new ak(this);
    public final ValueCallback<CALLBACK_TYPE> c = new al(this);
    private WeakReference<UCSetupTask> e;
    private File f;
    private File g;
    private File h;

    /* compiled from: Taobao */
    /* renamed from: com.uc.webview.export.internal.setup.aj$a */
    /* loaded from: classes11.dex */
    public static class C7265a {
        private static ConcurrentHashMap<String, aj> a = new ConcurrentHashMap<>();

        static /* synthetic */ aj a(Context context, String str) {
            return b(null, context, str);
        }

        private static aj b(UCSetupTask uCSetupTask, Context context, String str) {
            aj ajVar;
            String str2 = aj.d;
            Log.d(str2, "create " + str);
            if (C7349p.a(str)) {
                return null;
            }
            synchronized (aj.class) {
                ajVar = new aj(uCSetupTask, context, str);
                a.put(str, ajVar);
            }
            return ajVar;
        }

        public static aj a(UCSetupTask uCSetupTask, Context context, String str) {
            if (C7349p.a(str)) {
                return null;
            }
            synchronized (aj.class) {
                if (a.containsKey(str)) {
                    aj ajVar = a.get(str);
                    ajVar.a(uCSetupTask);
                    return ajVar;
                }
                return b(uCSetupTask, context, str);
            }
        }
    }

    public aj(UCSetupTask uCSetupTask, Context context, String str) {
        if (this.f == null) {
            a(uCSetupTask);
            File b = C7349p.b(C7349p.a(context, Constants.KEY_FLAGS), C7349p.e(str));
            String str2 = d;
            Log.d(str2, "<init> flgDirFile.path: " + b.getAbsolutePath());
            this.f = new File(b, "b36ce8d879e33bc88f717f74617ea05a");
            this.g = new File(b, "bd89426940609c9ae14e5ae90827201b");
            this.h = new File(b, "51bfcd9dd2f1379936c4fbb3558a6e67");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x006c, code lost:
        if (r1 != false) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static /* synthetic */ void d(com.uc.webview.export.internal.setup.aj r6) {
        /*
            java.io.File r0 = r6.f
            boolean r0 = r0.exists()
            java.io.File r1 = r6.h
            boolean r1 = r1.exists()
            java.io.File r2 = r6.g
            boolean r2 = r2.exists()
            r3 = 1
            if (r2 == 0) goto L6a
            if (r0 == 0) goto L70
            if (r1 == 0) goto L70
            java.io.File r1 = r6.g
            long r1 = r1.lastModified()
            java.io.File r3 = r6.h
            long r3 = r3.lastModified()
            long r1 = java.lang.Math.max(r1, r3)
            long r3 = java.lang.System.currentTimeMillis()
            long r3 = r3 - r1
            r1 = 86400000(0x5265c00, double:4.2687272E-316)
            int r5 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r5 <= 0) goto L40
            java.io.File r1 = r6.g     // Catch: java.lang.Throwable -> L3a
            r1.delete()     // Catch: java.lang.Throwable -> L3a
        L3a:
            java.io.File r1 = r6.f     // Catch: java.lang.Throwable -> L6f
            r1.delete()     // Catch: java.lang.Throwable -> L6f
            goto L6f
        L40:
            java.lang.String r0 = "2"
            r6.a = r0
            java.lang.ref.WeakReference<com.uc.webview.export.internal.setup.UCSetupTask> r0 = r6.e
            java.lang.Object r0 = r0.get()
            com.uc.webview.export.internal.setup.UCSetupTask r0 = (com.uc.webview.export.internal.setup.UCSetupTask) r0
            java.lang.String r1 = "disable_multi_unknown_crash"
            java.lang.Object r0 = r0.getOption(r1)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            if (r0 == 0) goto L5c
            boolean r0 = r0.booleanValue()
            if (r0 != 0) goto L69
        L5c:
            java.lang.ref.WeakReference<com.uc.webview.export.internal.setup.UCSetupTask> r6 = r6.e
            java.lang.Object r6 = r6.get()
            com.uc.webview.export.internal.setup.UCSetupTask r6 = (com.uc.webview.export.internal.setup.UCSetupTask) r6
            java.lang.String r0 = "crash_repeat"
            r6.callback(r0)
        L69:
            return
        L6a:
            if (r0 == 0) goto L6f
            if (r1 == 0) goto L6f
            goto L70
        L6f:
            r3 = 0
        L70:
            if (r0 == 0) goto L99
            java.lang.ref.WeakReference<com.uc.webview.export.internal.setup.UCSetupTask> r0 = r6.e
            java.lang.Object r0 = r0.get()
            com.uc.webview.export.internal.setup.UCSetupTask r0 = (com.uc.webview.export.internal.setup.UCSetupTask) r0
            java.lang.String r1 = "VERIFY_POLICY"
            java.lang.Object r0 = r0.getOption(r1)
            java.lang.Integer r0 = (java.lang.Integer) r0
            if (r0 == 0) goto L99
            java.lang.ref.WeakReference<com.uc.webview.export.internal.setup.UCSetupTask> r2 = r6.e
            java.lang.Object r2 = r2.get()
            com.uc.webview.export.internal.setup.UCSetupTask r2 = (com.uc.webview.export.internal.setup.UCSetupTask) r2
            int r0 = r0.intValue()
            r0 = r0 | 16
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r2.setup(r1, r0)
        L99:
            if (r3 == 0) goto L9e
            java.lang.String r0 = "1"
            goto La0
        L9e:
            java.lang.String r0 = "0"
        La0:
            r6.a = r0
            java.lang.ref.WeakReference<com.uc.webview.export.internal.setup.UCSetupTask> r6 = r6.e
            java.lang.Object r6 = r6.get()
            com.uc.webview.export.internal.setup.UCSetupTask r6 = (com.uc.webview.export.internal.setup.UCSetupTask) r6
            if (r3 == 0) goto Laf
            java.lang.String r0 = "crash_seen"
            goto Lb1
        Laf:
            java.lang.String r0 = "crash_none"
        Lb1:
            r6.callback(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.webview.export.internal.setup.aj.d(com.uc.webview.export.internal.setup.aj):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void e(aj ajVar) {
        try {
            if (!ajVar.f.exists()) {
                ajVar.f.createNewFile();
            } else if (!ajVar.h.exists()) {
                ajVar.h.createNewFile();
            } else if (ajVar.g.exists()) {
            } else {
                ajVar.g.createNewFile();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static String a(String str) {
        return "ThickSetupTask_" + str;
    }

    public static void a(Context context, String[] strArr) {
        for (int i = 0; i < 2; i++) {
            C7265a.a(context, strArr[i]);
        }
    }

    public final void a(UCSetupTask uCSetupTask) {
        if (uCSetupTask != null) {
            WeakReference<UCSetupTask> weakReference = this.e;
            if (weakReference == null || weakReference.get() != uCSetupTask) {
                this.e = new WeakReference<>(uCSetupTask);
                String str = d;
                Log.d(str, "UCSetupt.class: " + this.e.get().getClass());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a() {
        try {
            this.f.delete();
        } catch (Throwable unused) {
        }
        try {
            this.h.delete();
        } catch (Throwable unused2) {
        }
    }
}
