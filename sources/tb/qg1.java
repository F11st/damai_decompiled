package tb;

import android.net.Uri;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.phenix.loader.LocalSchemeHandler;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class qg1 implements LocalSchemeHandler {
    private static transient /* synthetic */ IpChange $ipChange;

    /* JADX WARN: Code restructure failed: missing block: B:27:0x005d, code lost:
        r11 = tb.q11.INSTANCE;
        r1 = r7.getPath();
        tb.b41.f(r1);
        tb.b41.h(r1, "uri.path!!");
        r11 = r11.a(r3, r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x006f, code lost:
        if (r11 == null) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0071, code lost:
        r11 = r3.getContentResolver().openInputStream(r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0079, code lost:
        if (r11 == null) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0084, code lost:
        return new tb.p22(r11, r11.available());
     */
    @Override // com.taobao.phenix.loader.LocalSchemeHandler
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public tb.p22 handleScheme(@org.jetbrains.annotations.Nullable java.lang.String r11) {
        /*
            r10 = this;
            java.lang.String r0 = "MoLocalSchemeHandler:handleScheme"
            com.android.alibaba.ip.runtime.IpChange r1 = tb.qg1.$ipChange
            java.lang.String r2 = "-1355263590"
            boolean r3 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r1, r2)
            r4 = 1
            r5 = 0
            if (r3 == 0) goto L1c
            r0 = 2
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r0[r5] = r10
            r0[r4] = r11
            java.lang.Object r11 = r1.ipc$dispatch(r2, r0)
            tb.p22 r11 = (tb.p22) r11
            return r11
        L1c:
            long r1 = java.lang.System.currentTimeMillis()
            if (r11 == 0) goto L2b
            int r3 = r11.length()
            if (r3 != 0) goto L29
            goto L2b
        L29:
            r3 = 0
            goto L2c
        L2b:
            r3 = 1
        L2c:
            r6 = 0
            if (r3 == 0) goto L30
            return r6
        L30:
            tb.mg1 r3 = tb.mg1.INSTANCE     // Catch: java.lang.Exception -> Lc7
            android.app.Application r3 = r3.c()     // Catch: java.lang.Exception -> Lc7
            if (r3 == 0) goto Ldc
            android.net.Uri r7 = android.net.Uri.parse(r11)     // Catch: java.lang.Exception -> Lc7
            java.lang.String r8 = "file_q"
            java.lang.String r9 = "uri"
            tb.b41.h(r7, r9)     // Catch: java.lang.Exception -> Lc7
            java.lang.String r9 = r7.getScheme()     // Catch: java.lang.Exception -> Lc7
            boolean r8 = tb.b41.d(r8, r9)     // Catch: java.lang.Exception -> Lc7
            if (r8 == 0) goto L85
            java.lang.String r8 = r7.getPath()     // Catch: java.lang.Exception -> Lc7
            if (r8 == 0) goto L5b
            int r8 = r8.length()     // Catch: java.lang.Exception -> Lc7
            if (r8 != 0) goto L5a
            goto L5b
        L5a:
            r4 = 0
        L5b:
            if (r4 != 0) goto L85
            tb.q11 r11 = tb.q11.INSTANCE     // Catch: java.lang.Exception -> Lc7
            java.lang.String r1 = r7.getPath()     // Catch: java.lang.Exception -> Lc7
            tb.b41.f(r1)     // Catch: java.lang.Exception -> Lc7
            java.lang.String r2 = "uri.path!!"
            tb.b41.h(r1, r2)     // Catch: java.lang.Exception -> Lc7
            android.net.Uri r11 = r11.a(r3, r1)     // Catch: java.lang.Exception -> Lc7
            if (r11 == 0) goto Ldc
            android.content.ContentResolver r1 = r3.getContentResolver()     // Catch: java.lang.Exception -> Lc7
            java.io.InputStream r11 = r1.openInputStream(r11)     // Catch: java.lang.Exception -> Lc7
            if (r11 == 0) goto Ldc
            tb.p22 r1 = new tb.p22     // Catch: java.lang.Exception -> Lc7
            int r2 = r11.available()     // Catch: java.lang.Exception -> Lc7
            r1.<init>(r11, r2)     // Catch: java.lang.Exception -> Lc7
            return r1
        L85:
            java.lang.String r4 = "content"
            java.lang.String r5 = r7.getScheme()     // Catch: java.lang.Exception -> Lc7
            boolean r4 = tb.b41.d(r4, r5)     // Catch: java.lang.Exception -> Lc7
            if (r4 == 0) goto Ldc
            android.content.ContentResolver r3 = r3.getContentResolver()     // Catch: java.lang.Exception -> Lc7
            java.io.InputStream r3 = r3.openInputStream(r7)     // Catch: java.lang.Exception -> Lc7
            if (r3 == 0) goto Ldc
            tb.p22 r4 = new tb.p22     // Catch: java.lang.Exception -> Lc7
            int r5 = r3.available()     // Catch: java.lang.Exception -> Lc7
            r4.<init>(r3, r5)     // Catch: java.lang.Exception -> Lc7
            long r7 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Exception -> Lc7
            long r7 = r7 - r1
            tb.lg1 r3 = tb.lg1.INSTANCE     // Catch: java.lang.Exception -> Lc7
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Lc7
            r5.<init>()     // Catch: java.lang.Exception -> Lc7
            r5.append(r0)     // Catch: java.lang.Exception -> Lc7
            r5.append(r11)     // Catch: java.lang.Exception -> Lc7
            java.lang.String r11 = ",duration:"
            r5.append(r11)     // Catch: java.lang.Exception -> Lc7
            long r7 = r7 - r1
            r5.append(r7)     // Catch: java.lang.Exception -> Lc7
            java.lang.String r11 = r5.toString()     // Catch: java.lang.Exception -> Lc7
            r3.a(r11)     // Catch: java.lang.Exception -> Lc7
            return r4
        Lc7:
            r11 = move-exception
            tb.lg1 r1 = tb.lg1.INSTANCE
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
            r2.append(r11)
            java.lang.String r11 = r2.toString()
            r1.c(r11)
        Ldc:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.qg1.handleScheme(java.lang.String):tb.p22");
    }

    @Override // com.taobao.phenix.loader.LocalSchemeHandler
    public boolean isSupported(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "912566397")) {
            return ((Boolean) ipChange.ipc$dispatch("912566397", new Object[]{this, str})).booleanValue();
        }
        try {
            if (mg1.INSTANCE.c() != null) {
                Uri parse = Uri.parse(str);
                b41.h(parse, "uri");
                if (b41.d(jg1.SCHEME_FILE_Q, parse.getScheme())) {
                    return true;
                }
                return b41.d("content", parse.getScheme());
            }
        } catch (Exception e) {
            lg1 lg1Var = lg1.INSTANCE;
            lg1Var.c("MoLocalSchemeHandler:isSupported" + e);
        }
        return false;
    }
}
