package tb;

import android.content.Context;
import com.alibaba.pictures.uploader.FileUploader;
import com.alibaba.pictures.uploader.IImageCompressor;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import io.flutter.wpkbridge.WPKFactory;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import kotlin.jvm.JvmOverloads;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class ru2 implements IImageCompressor {
    private static transient /* synthetic */ IpChange $ipChange;

    private final int a(int i, int i2, qu2 qu2Var) {
        IpChange ipChange = $ipChange;
        int i3 = 1;
        if (AndroidInstantRuntime.support(ipChange, "1765971422")) {
            return ((Integer) ipChange.ipc$dispatch("1765971422", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), qu2Var})).intValue();
        }
        if (qu2Var.c() != null) {
            Integer c = qu2Var.c();
            b41.f(c);
            if (c.intValue() > 0 && qu2Var.e() != null) {
                Integer e = qu2Var.e();
                b41.f(e);
                if (e.intValue() > 0) {
                    if (i <= i2) {
                        while (true) {
                            int i4 = i2 / i3;
                            Integer c2 = qu2Var.c();
                            b41.f(c2);
                            if (i4 <= c2.intValue()) {
                                break;
                            }
                            i3 *= 2;
                        }
                    } else {
                        while (true) {
                            int i5 = i / i3;
                            Integer e2 = qu2Var.e();
                            b41.f(e2);
                            if (i5 <= e2.intValue()) {
                                break;
                            }
                            i3 *= 2;
                        }
                    }
                }
            }
        }
        return i3;
    }

    private final qu2 b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1786417318")) {
            return (qu2) ipChange.ipc$dispatch("-1786417318", new Object[]{this});
        }
        qu2 qu2Var = new qu2();
        qu2Var.k(60);
        qu2Var.g(Boolean.FALSE);
        qu2Var.j(2160);
        qu2Var.h(3840);
        qu2Var.i(2097152);
        return qu2Var;
    }

    @JvmOverloads
    private final File c(Context context, byte[] bArr, String str) {
        FileOutputStream fileOutputStream;
        File createTempFile;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "733982231")) {
            return (File) ipChange.ipc$dispatch("733982231", new Object[]{this, context, bArr, str});
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            FileUploader.C3645a c3645a = FileUploader.Companion;
            StringBuilder sb = new StringBuilder();
            sb.append("compress:after compress this file size = ");
            sb.append((bArr != null ? bArr.length : 0) / 1024);
            c3645a.h(sb.toString());
            createTempFile = File.createTempFile(WPKFactory.INIT_KEY_UPLOAD_COMPRESS, str, context.getCacheDir());
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

    /* JADX WARN: Code restructure failed: missing block: B:23:0x007f, code lost:
        if (r3 == false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00d2, code lost:
        if (r3 != false) goto L33;
     */
    @Override // com.alibaba.pictures.uploader.IImageCompressor
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String compress(@org.jetbrains.annotations.Nullable java.lang.String r18, @org.jetbrains.annotations.Nullable tb.qu2 r19) {
        /*
            Method dump skipped, instructions count: 619
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.ru2.compress(java.lang.String, tb.qu2):java.lang.String");
    }
}
