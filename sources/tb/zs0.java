package tb;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class zs0 {
    private static transient /* synthetic */ IpChange $ipChange;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0071  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static byte[] a(java.io.File r8) throws java.io.IOException {
        /*
            com.android.alibaba.ip.runtime.IpChange r0 = tb.zs0.$ipChange
            java.lang.String r1 = "-1154196628"
            boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
            r3 = 0
            if (r2 == 0) goto L17
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r2[r3] = r8
            java.lang.Object r8 = r0.ipc$dispatch(r1, r2)
            byte[] r8 = (byte[]) r8
            return r8
        L17:
            if (r8 == 0) goto L75
            boolean r0 = r8.exists()
            if (r0 == 0) goto L75
            boolean r0 = c(r8)
            r1 = 0
            if (r0 != 0) goto L27
            return r1
        L27:
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L60
            r0.<init>()     // Catch: java.lang.Throwable -> L60
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L5d
            r2.<init>(r8)     // Catch: java.lang.Throwable -> L5d
            java.util.zip.GZIPInputStream r8 = new java.util.zip.GZIPInputStream     // Catch: java.lang.Throwable -> L58
            r8.<init>(r2)     // Catch: java.lang.Throwable -> L58
            r1 = 1024(0x400, float:1.435E-42)
            byte[] r4 = new byte[r1]     // Catch: java.lang.Throwable -> L56
        L3a:
            int r5 = r8.read(r4, r3, r1)     // Catch: java.lang.Throwable -> L56
            r6 = -1
            if (r5 == r6) goto L45
            r0.write(r4, r3, r5)     // Catch: java.lang.Throwable -> L56
            goto L3a
        L45:
            r0.flush()     // Catch: java.lang.Throwable -> L56
            byte[] r1 = r0.toByteArray()     // Catch: java.lang.Throwable -> L56
            r8.close()
            r2.close()
            r0.close()
            return r1
        L56:
            r1 = move-exception
            goto L65
        L58:
            r8 = move-exception
            r7 = r1
            r1 = r8
            r8 = r7
            goto L65
        L5d:
            r8 = move-exception
            r2 = r1
            goto L63
        L60:
            r8 = move-exception
            r0 = r1
            r2 = r0
        L63:
            r1 = r8
            r8 = r2
        L65:
            if (r8 == 0) goto L6a
            r8.close()
        L6a:
            if (r2 == 0) goto L6f
            r2.close()
        L6f:
            if (r0 == 0) goto L74
            r0.close()
        L74:
            throw r1
        L75:
            java.io.IOException r8 = new java.io.IOException
            java.lang.String r0 = "decode gzip error. Gzip file is null!!"
            r8.<init>(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.zs0.a(java.io.File):byte[]");
    }

    public static byte[] b(String str) throws IOException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "865944185")) {
            return (byte[]) ipChange.ipc$dispatch("865944185", new Object[]{str});
        }
        if (!TextUtils.isEmpty(str)) {
            return a(new File(str));
        }
        throw new IOException("gzip file name not exists!!");
    }

    public static boolean c(File file) {
        FileInputStream fileInputStream;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "696038830")) {
            return ((Boolean) ipChange.ipc$dispatch("696038830", new Object[]{file})).booleanValue();
        }
        if (file == null || !file.exists() || file.isDirectory()) {
            return false;
        }
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(file);
        } catch (IOException unused) {
        } catch (Throwable th) {
            th = th;
        }
        try {
            byte[] bArr = new byte[2];
            if (fileInputStream.read(bArr) < 2) {
                fileInputStream.read(bArr);
            }
            boolean z = ((bArr[0] << 8) | (bArr[1] & 255)) == 8075;
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return z;
        } catch (IOException unused2) {
            fileInputStream2 = fileInputStream;
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
            return false;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream2 = fileInputStream;
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            }
            throw th;
        }
    }
}
