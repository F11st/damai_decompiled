package tb;

import android.util.LruCache;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.InputStream;
import java.io.OutputStream;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class wi0 {
    static {
        new LruCache(32);
    }

    public static final boolean a(@Nullable Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
                return true;
            } catch (Exception e) {
                i23.INSTANCE.c("StackTrace", e.toString());
            }
        }
        return false;
    }

    private static final boolean b(InputStream inputStream, OutputStream outputStream) {
        if (inputStream == null || outputStream == null) {
            return false;
        }
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read > 0) {
                outputStream.write(bArr, 0, read);
            } else {
                outputStream.flush();
                return true;
            }
        }
    }

    @Nullable
    public static final String c(@Nullable InputStream inputStream) {
        byte[] d;
        if (inputStream == null || (d = d(inputStream)) == null) {
            return null;
        }
        String str = new String(d, hi.UTF_8);
        a(inputStream);
        return str;
    }

    private static final byte[] d(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream;
        byte[] bArr = null;
        bArr = null;
        bArr = null;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        try {
            if (inputStream != null) {
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                } catch (Exception e) {
                    e = e;
                    byteArrayOutputStream = null;
                } catch (Throwable th) {
                    th = th;
                    a(byteArrayOutputStream2);
                    throw th;
                }
                try {
                    if (b(inputStream, byteArrayOutputStream)) {
                        bArr = byteArrayOutputStream.toByteArray();
                    }
                } catch (Exception e2) {
                    e = e2;
                    e.printStackTrace();
                    a(byteArrayOutputStream);
                    return bArr;
                }
                a(byteArrayOutputStream);
            }
            return bArr;
        } catch (Throwable th2) {
            th = th2;
            byteArrayOutputStream2 = byteArrayOutputStream;
        }
    }
}
