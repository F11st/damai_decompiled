package com.efs.sdk.base.a.b;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import androidx.annotation.NonNull;
import com.efs.sdk.base.Constants;
import com.efs.sdk.base.a.b.a;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import tb.j43;
import tb.n43;
import tb.n73;
import tb.q33;
import tb.r33;
import tb.v53;
import tb.w63;
import tb.y43;
import tb.z43;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class d extends Handler implements e {
    private final ConcurrentHashMap<String, a> a;
    private v53 b;
    private y43 c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class a extends FileOutputStream {
        File a;

        a(@NonNull File file) {
            super(file);
            this.a = file;
            System.currentTimeMillis();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d() {
        super(r33.a.getLooper());
        this.a = new ConcurrentHashMap<>();
        this.b = new v53();
        this.c = new y43();
    }

    private boolean b(j43 j43Var, File file) {
        BufferedReader bufferedReader;
        StringBuilder sb = new StringBuilder();
        FileReader fileReader = null;
        try {
            FileReader fileReader2 = new FileReader(file);
            try {
                bufferedReader = new BufferedReader(fileReader2);
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            j43Var.e(sb.toString().getBytes());
                            j43Var.i();
                            this.c.a(j43Var);
                            this.b.a(j43Var);
                            j43Var.d = file;
                            z43.c(bufferedReader);
                            z43.c(fileReader2);
                            return true;
                        }
                        String d = n43.d(readLine.getBytes());
                        if (!TextUtils.isEmpty(d)) {
                            sb.append(d);
                            sb.append(StringUtils.LF);
                        }
                    } catch (Throwable th) {
                        th = th;
                        fileReader = fileReader2;
                        try {
                            w63.c("efs.cache", "local decode error", th);
                            z43.c(bufferedReader);
                            z43.c(fileReader);
                            return false;
                        } catch (Throwable th2) {
                            z43.c(bufferedReader);
                            z43.c(fileReader);
                            throw th2;
                        }
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
            }
        } catch (Throwable th4) {
            th = th4;
            bufferedReader = null;
        }
    }

    private static long c(String str) {
        Map<String, String> i = com.efs.sdk.base.a.c.a.c.a().i();
        String concat = "record_accumulation_time_".concat(String.valueOf(str));
        if (i.containsKey(concat)) {
            String str2 = i.get(concat);
            if (TextUtils.isEmpty(str2)) {
                return DateUtils.MILLIS_PER_MINUTE;
            }
            try {
                return Math.max(Long.parseLong(str2) * 1000, 1000L);
            } catch (Throwable th) {
                w63.c("efs.cache", "get cache interval error", th);
                return DateUtils.MILLIS_PER_MINUTE;
            }
        }
        return DateUtils.MILLIS_PER_MINUTE;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0076  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.efs.sdk.base.a.b.d.a d(tb.j43 r6) {
        /*
            r5 = this;
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.efs.sdk.base.a.b.d$a> r0 = r5.a
            tb.n33 r1 = r6.a
            java.lang.String r1 = r1.a
            boolean r0 = r0.containsKey(r1)
            if (r0 == 0) goto L19
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.efs.sdk.base.a.b.d$a> r0 = r5.a
            tb.n33 r6 = r6.a
            java.lang.String r6 = r6.a
            java.lang.Object r6 = r0.get(r6)
            com.efs.sdk.base.a.b.d$a r6 = (com.efs.sdk.base.a.b.d.a) r6
            return r6
        L19:
            java.lang.String r0 = tb.z43.b(r6)
            java.io.File r1 = new java.io.File
            tb.f33 r2 = com.efs.sdk.base.a.d.a.a()
            android.content.Context r2 = r2.c
            tb.f33 r3 = com.efs.sdk.base.a.d.a.a()
            java.lang.String r3 = r3.a
            java.io.File r2 = tb.q33.f(r2, r3)
            r1.<init>(r2, r0)
            r0 = 0
            com.efs.sdk.base.a.b.d$a r2 = new com.efs.sdk.base.a.b.d$a     // Catch: java.lang.Throwable -> L64
            r2.<init>(r1)     // Catch: java.lang.Throwable -> L64
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.efs.sdk.base.a.b.d$a> r0 = r5.a     // Catch: java.lang.Throwable -> L62
            tb.n33 r3 = r6.a     // Catch: java.lang.Throwable -> L62
            java.lang.String r3 = r3.a     // Catch: java.lang.Throwable -> L62
            java.lang.Object r0 = r0.putIfAbsent(r3, r2)     // Catch: java.lang.Throwable -> L62
            com.efs.sdk.base.a.b.d$a r0 = (com.efs.sdk.base.a.b.d.a) r0     // Catch: java.lang.Throwable -> L62
            if (r0 == 0) goto L4d
            tb.z43.c(r2)     // Catch: java.lang.Throwable -> L62
            tb.z43.i(r1)     // Catch: java.lang.Throwable -> L62
            return r0
        L4d:
            android.os.Message r0 = android.os.Message.obtain()     // Catch: java.lang.Throwable -> L62
            tb.n33 r1 = r6.a     // Catch: java.lang.Throwable -> L62
            java.lang.String r1 = r1.a     // Catch: java.lang.Throwable -> L62
            r0.obj = r1     // Catch: java.lang.Throwable -> L62
            r3 = 1
            r0.what = r3     // Catch: java.lang.Throwable -> L62
            long r3 = c(r1)     // Catch: java.lang.Throwable -> L62
            r5.sendMessageDelayed(r0, r3)     // Catch: java.lang.Throwable -> L62
            goto L6a
        L62:
            r0 = move-exception
            goto L67
        L64:
            r1 = move-exception
            r2 = r0
            r0 = r1
        L67:
            r0.printStackTrace()
        L6a:
            tb.n33 r6 = r6.a
            java.lang.String r6 = r6.a
            java.lang.String r0 = "wa"
            boolean r6 = r0.equalsIgnoreCase(r6)
            if (r6 != 0) goto L7f
            tb.n73 r6 = tb.n73.a.a()
            tb.y53 r6 = r6.c
            r6.b()
        L7f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.efs.sdk.base.a.b.d.d(tb.j43):com.efs.sdk.base.a.b.d$a");
    }

    private void e(String str) {
        a aVar;
        n73 n73Var;
        if (this.a.containsKey(str) && (aVar = this.a.get(str)) != null) {
            try {
                aVar.flush();
                z43.c(aVar);
                a(aVar.a);
            } catch (Throwable th) {
                try {
                    th.printStackTrace();
                    this.a.remove(str);
                    if (Constants.LOG_TYPE_WA.equalsIgnoreCase(str)) {
                    }
                } finally {
                    this.a.remove(str);
                    if (!Constants.LOG_TYPE_WA.equalsIgnoreCase(str)) {
                        n73Var = n73.a.a;
                        n73Var.c.c();
                    }
                }
            }
        }
    }

    @Override // com.efs.sdk.base.a.b.e
    public final void a(File file) {
        byte[] bArr;
        com.efs.sdk.base.a.b.a unused;
        com.efs.sdk.base.a.b.a unused2;
        j43 h = z43.h(file.getName());
        if (h == null) {
            unused = a.b.a;
            com.efs.sdk.base.a.b.a.d(file);
        } else if (!b(h, file) || (bArr = h.c) == null || bArr.length <= 0) {
            unused2 = a.b.a;
            com.efs.sdk.base.a.b.a.d(file);
        } else {
            z43.f(new File(q33.g(com.efs.sdk.base.a.d.a.a().c, com.efs.sdk.base.a.d.a.a().a), z43.b(h)), h.c);
            z43.i(file);
        }
    }

    @Override // com.efs.sdk.base.a.b.e
    public final void a(@NonNull String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Message obtain = Message.obtain();
        obtain.obj = str;
        obtain.what = 1;
        sendMessage(obtain);
    }

    @Override // com.efs.sdk.base.a.b.e
    public final void a(j43 j43Var) {
        Message obtain = Message.obtain();
        obtain.obj = j43Var;
        obtain.what = 0;
        sendMessage(obtain);
    }

    @Override // com.efs.sdk.base.a.b.e
    public final boolean a(File file, j43 j43Var) {
        if (!j43Var.g()) {
            a(file);
            return false;
        } else if (file.exists()) {
            j43Var.d = file;
            j43Var.i();
            j43Var.f(1);
            return true;
        } else {
            return false;
        }
    }

    @Override // android.os.Handler
    public final void handleMessage(@NonNull Message message) {
        int i = message.what;
        if (i != 0) {
            if (i != 1) {
                return;
            }
            Object obj = message.obj;
            if (obj instanceof String) {
                e(obj.toString());
                return;
            }
            return;
        }
        j43 j43Var = (j43) message.obj;
        for (int i2 = 0; i2 < 3; i2++) {
            try {
                a d = d(j43Var);
                if (d == null) {
                    w63.b("efs.cache", "writer is null for type " + j43Var.a.a, null);
                    return;
                }
                if (d.getChannel().position() + j43Var.c.length > 819200) {
                    e(j43Var.a.a);
                    d = d(j43Var);
                    if (d == null) {
                        w63.b("efs.cache", "writer is null for type " + j43Var.a.a, null);
                        return;
                    }
                }
                d.write(Base64.encode(j43Var.c, 11));
                d.write(StringUtils.LF.getBytes());
                return;
            } catch (Throwable th) {
                w63.c("efs.cache", "cache file error", th);
            }
        }
    }
}
