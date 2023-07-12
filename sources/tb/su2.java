package tb;

import android.content.Context;
import com.alibaba.pictures.uploader.FileUploader;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class su2 {
    private static transient /* synthetic */ IpChange $ipChange;

    /* JADX WARN: Code restructure failed: missing block: B:19:0x006f, code lost:
        if (r0 != false) goto L18;
     */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.String a(@org.jetbrains.annotations.Nullable java.lang.String r8, @org.jetbrains.annotations.Nullable tb.qu2 r9) {
        /*
            com.android.alibaba.ip.runtime.IpChange r0 = tb.su2.$ipChange
            java.lang.String r1 = "-655102923"
            boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
            r3 = 1
            r4 = 2
            r5 = 0
            if (r2 == 0) goto L1a
            java.lang.Object[] r2 = new java.lang.Object[r4]
            r2[r5] = r8
            r2[r3] = r9
            java.lang.Object r8 = r0.ipc$dispatch(r1, r2)
            java.lang.String r8 = (java.lang.String) r8
            return r8
        L1a:
            if (r8 == 0) goto L25
            int r0 = r8.length()
            if (r0 != 0) goto L23
            goto L25
        L23:
            r0 = 0
            goto L26
        L25:
            r0 = 1
        L26:
            if (r0 == 0) goto L29
            return r8
        L29:
            com.alibaba.pictures.uploader.FileUploader$a r0 = com.alibaba.pictures.uploader.FileUploader.Companion
            android.content.Context r1 = r0.b()
            android.graphics.BitmapFactory$Options r2 = new android.graphics.BitmapFactory$Options
            r2.<init>()
            r2.inJustDecodeBounds = r3
            tb.pi0 r3 = tb.pi0.INSTANCE
            android.content.Context r0 = r0.b()
            r3.c(r0, r8, r2)
            java.lang.String r0 = r2.outMimeType
            if (r0 == 0) goto Lcb
            java.lang.String r2 = "sizeOptions.outMimeType"
            tb.b41.h(r0, r2)
            java.lang.String r2 = "null cannot be cast to non-null type java.lang.String"
            java.util.Objects.requireNonNull(r0, r2)
            java.lang.String r0 = r0.toLowerCase()
            java.lang.String r3 = "(this as java.lang.String).toLowerCase()"
            tb.b41.h(r0, r3)
            java.lang.String r6 = "heif"
            r7 = 0
            boolean r0 = kotlin.text.C8596g.p(r0, r6, r5, r4, r7)
            if (r0 != 0) goto L71
            java.util.Objects.requireNonNull(r8, r2)
            java.lang.String r0 = r8.toLowerCase()
            tb.b41.h(r0, r3)
            java.lang.String r2 = ".heif"
            boolean r0 = kotlin.text.C8596g.p(r0, r2, r5, r4, r7)
            if (r0 == 0) goto Lcb
        L71:
            android.graphics.Bitmap r0 = android.graphics.BitmapFactory.decodeFile(r8)
            if (r0 == 0) goto Lcb
            java.io.ByteArrayOutputStream r8 = new java.io.ByteArrayOutputStream
            r8.<init>()
            if (r9 == 0) goto L83
            java.lang.Boolean r2 = r9.a()
            goto L84
        L83:
            r2 = r7
        L84:
            java.lang.Boolean r3 = java.lang.Boolean.TRUE
            boolean r2 = tb.b41.d(r2, r3)
            if (r2 == 0) goto L8f
            android.graphics.Bitmap$CompressFormat r2 = android.graphics.Bitmap.CompressFormat.PNG
            goto L91
        L8f:
            android.graphics.Bitmap$CompressFormat r2 = android.graphics.Bitmap.CompressFormat.JPEG
        L91:
            if (r9 == 0) goto L9e
            java.lang.Integer r4 = r9.f()
            if (r4 == 0) goto L9e
            int r4 = r4.intValue()
            goto La0
        L9e:
            r4 = 100
        La0:
            r0.compress(r2, r4, r8)
            byte[] r2 = r8.toByteArray()
            if (r9 == 0) goto Lae
            java.lang.Boolean r9 = r9.a()
            goto Laf
        Lae:
            r9 = r7
        Laf:
            boolean r9 = tb.b41.d(r9, r3)
            if (r9 == 0) goto Lb8
            java.lang.String r9 = ".png"
            goto Lba
        Lb8:
            java.lang.String r9 = ".jpeg"
        Lba:
            java.io.File r9 = b(r1, r2, r9)
            r0.recycle()
            r8.close()
            if (r9 == 0) goto Lca
            java.lang.String r7 = r9.getAbsolutePath()
        Lca:
            return r7
        Lcb:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.su2.a(java.lang.String, tb.qu2):java.lang.String");
    }

    private static final File b(Context context, byte[] bArr, String str) {
        FileOutputStream fileOutputStream;
        File createTempFile;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2143069949")) {
            return (File) ipChange.ipc$dispatch("-2143069949", new Object[]{context, bArr, str});
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            FileUploader.C3645a c3645a = FileUploader.Companion;
            StringBuilder sb = new StringBuilder();
            sb.append("decode:after decode this file size = ");
            sb.append((bArr != null ? bArr.length : 0) / 1024);
            c3645a.h(sb.toString());
            createTempFile = File.createTempFile("upload_decode", str, context.getCacheDir());
            fileOutputStream = new FileOutputStream(createTempFile);
        } catch (IOException e) {
            e = e;
            fileOutputStream = null;
        } catch (Throwable th) {
            th = th;
            try {
                b41.f(fileOutputStream2);
                fileOutputStream2.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            throw th;
        }
        try {
            try {
                fileOutputStream.write(bArr);
                fileOutputStream.flush();
                try {
                    fileOutputStream.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
                return createTempFile;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                b41.f(fileOutputStream2);
                fileOutputStream2.close();
                throw th;
            }
        } catch (IOException e4) {
            e = e4;
            e.printStackTrace();
            try {
                b41.f(fileOutputStream);
                fileOutputStream.close();
            } catch (IOException e5) {
                e5.printStackTrace();
            }
            return null;
        }
    }
}
