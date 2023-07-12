package com.efs.sdk.base.a.e;

import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import java.io.File;
import java.io.FileOutputStream;
import tb.j83;
import tb.q33;
import tb.w63;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class f {
    volatile int a;

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class a {
        private static final f a = new f((byte) 0);

        public static /* synthetic */ f a() {
            return a;
        }
    }

    private f() {
        this.a = 0;
        a(com.efs.sdk.base.a.d.a.a().c);
    }

    /* synthetic */ f(byte b) {
        this();
    }

    private synchronized void a(final Context context) {
        w63.b("efs.send_log", "tryFileLock start! ", null);
        this.a = 1;
        new Thread(new Runnable() { // from class: com.efs.sdk.base.a.e.f.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    File a2 = q33.a(context);
                    if (!a2.exists()) {
                        a2.mkdirs();
                    }
                    File file = new File(a2.getPath() + File.separator + "sendlock");
                    if (!file.exists()) {
                        file.createNewFile();
                    }
                    do {
                    } while (!new FileOutputStream(file).getChannel().lock().isValid());
                    StringBuilder sb = new StringBuilder("tryFileLock sendlock sucess! processname: ");
                    String str = j83.a;
                    if (TextUtils.isEmpty(str)) {
                        str = j83.a(Process.myPid());
                        j83.a = str;
                    }
                    sb.append(str);
                    w63.b("efs.send_log", sb.toString(), null);
                    f.this.a = 2;
                } catch (Exception e) {
                    w63.b("efs.send_log", "tryFileLock fail! " + e.getMessage(), null);
                    f.this.a = 0;
                }
            }
        }).start();
    }

    public final boolean b() {
        if (this.a == 2) {
            return true;
        }
        if (this.a == 0) {
            a(com.efs.sdk.base.a.d.a.a().c);
            return false;
        }
        return false;
    }
}
