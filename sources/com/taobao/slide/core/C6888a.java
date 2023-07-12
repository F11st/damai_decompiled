package com.taobao.slide.core;

import com.taobao.slide.model.ValidDO;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import tb.au1;
import tb.m42;
import tb.nl;

/* compiled from: Taobao */
/* renamed from: com.taobao.slide.core.a */
/* loaded from: classes11.dex */
public class C6888a<T extends ValidDO> {
    private File a;

    public C6888a(File file) {
        this.a = file;
    }

    private boolean a(File file) {
        try {
            return file.delete();
        } catch (Throwable th) {
            m42.d("DiskCache", "delete", th, new Object[0]);
            return false;
        }
    }

    public T b(String str) throws Throwable {
        FileInputStream fileInputStream;
        ObjectInputStream objectInputStream;
        ObjectInputStream objectInputStream2 = null;
        try {
            File file = new File(this.a, str);
            if (!file.exists()) {
                nl.a(null);
                nl.a(null);
                return null;
            }
            fileInputStream = new FileInputStream(file);
            try {
                objectInputStream = new ObjectInputStream(new BufferedInputStream(fileInputStream));
            } catch (Throwable th) {
                th = th;
            }
            try {
                T t = (T) objectInputStream.readObject();
                au1.a(t.isValid(), String.format("%s:not valid", str));
                nl.a(objectInputStream);
                nl.a(fileInputStream);
                return t;
            } catch (Throwable th2) {
                th = th2;
                objectInputStream2 = objectInputStream;
                try {
                    throw th;
                } catch (Throwable th3) {
                    nl.a(objectInputStream2);
                    nl.a(fileInputStream);
                    throw th3;
                }
            }
        } catch (Throwable th4) {
            th = th4;
            fileInputStream = null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0072, code lost:
        if (r6.exists() != false) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean c(java.lang.String r11, T r12) {
        /*
            r10 = this;
            java.io.File r0 = r10.a
            boolean r0 = r0.exists()
            r1 = 2
            java.lang.String r2 = "save"
            java.lang.String r3 = "DiskCache"
            r4 = 1
            r5 = 0
            if (r0 != 0) goto L24
            java.io.File r0 = r10.a
            boolean r0 = r0.mkdirs()
            java.lang.Object[] r6 = new java.lang.Object[r1]
            java.lang.String r7 = "mkdirs root"
            r6[r5] = r7
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            r6[r4] = r0
            tb.m42.g(r3, r2, r6)
        L24:
            r0 = 0
            java.lang.String r6 = ".tmp"
            java.io.File r7 = r10.a     // Catch: java.lang.Throwable -> L7e
            java.io.File r6 = java.io.File.createTempFile(r11, r6, r7)     // Catch: java.lang.Throwable -> L7e
            java.io.FileOutputStream r7 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L7b
            r7.<init>(r6)     // Catch: java.lang.Throwable -> L7b
            java.io.ObjectOutputStream r8 = new java.io.ObjectOutputStream     // Catch: java.lang.Throwable -> L77
            java.io.BufferedOutputStream r9 = new java.io.BufferedOutputStream     // Catch: java.lang.Throwable -> L77
            r9.<init>(r7)     // Catch: java.lang.Throwable -> L77
            r8.<init>(r9)     // Catch: java.lang.Throwable -> L77
            r8.writeObject(r12)     // Catch: java.lang.Throwable -> L75
            r8.flush()     // Catch: java.lang.Throwable -> L75
            java.io.File r12 = new java.io.File     // Catch: java.lang.Throwable -> L75
            java.io.File r0 = r10.a     // Catch: java.lang.Throwable -> L75
            r12.<init>(r0, r11)     // Catch: java.lang.Throwable -> L75
            boolean r12 = r6.renameTo(r12)     // Catch: java.lang.Throwable -> L75
            if (r12 == 0) goto L5f
            tb.nl.a(r8)
            tb.nl.a(r7)
            boolean r11 = r6.exists()
            if (r11 == 0) goto L5e
            r10.a(r6)
        L5e:
            return r4
        L5f:
            java.lang.String r12 = "save rename fail"
            java.lang.Object[] r0 = new java.lang.Object[r4]     // Catch: java.lang.Throwable -> L75
            r0[r5] = r11     // Catch: java.lang.Throwable -> L75
            tb.m42.k(r3, r12, r0)     // Catch: java.lang.Throwable -> L75
            tb.nl.a(r8)
            tb.nl.a(r7)
            boolean r11 = r6.exists()
            if (r11 == 0) goto L9d
            goto L9a
        L75:
            r12 = move-exception
            goto L79
        L77:
            r12 = move-exception
            r8 = r0
        L79:
            r0 = r7
            goto L81
        L7b:
            r12 = move-exception
            r8 = r0
            goto L81
        L7e:
            r12 = move-exception
            r6 = r0
            r8 = r6
        L81:
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L9e
            java.lang.String r7 = "name"
            r1[r5] = r7     // Catch: java.lang.Throwable -> L9e
            r1[r4] = r11     // Catch: java.lang.Throwable -> L9e
            tb.m42.d(r3, r2, r12, r1)     // Catch: java.lang.Throwable -> L9e
            tb.nl.a(r8)
            tb.nl.a(r0)
            if (r6 == 0) goto L9d
            boolean r11 = r6.exists()
            if (r11 == 0) goto L9d
        L9a:
            r10.a(r6)
        L9d:
            return r5
        L9e:
            r11 = move-exception
            tb.nl.a(r8)
            tb.nl.a(r0)
            if (r6 == 0) goto Lb0
            boolean r12 = r6.exists()
            if (r12 == 0) goto Lb0
            r10.a(r6)
        Lb0:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.slide.core.C6888a.c(java.lang.String, com.taobao.slide.model.ValidDO):boolean");
    }
}
