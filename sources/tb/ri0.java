package tb;

import android.content.Context;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class ri0 {
    public static byte[] a(Context context, String str) {
        BufferedInputStream bufferedInputStream;
        try {
            InputStream open = context.getAssets().open(str);
            if (open == null) {
                return "".getBytes();
            }
            BufferedInputStream bufferedInputStream2 = null;
            try {
                bufferedInputStream = new BufferedInputStream(open);
            } catch (IOException unused) {
            } catch (Throwable th) {
                th = th;
            }
            try {
                byte[] bArr = new byte[bufferedInputStream.available()];
                bufferedInputStream.read(bArr);
                try {
                    bufferedInputStream.close();
                } catch (Exception unused2) {
                }
                return bArr;
            } catch (IOException unused3) {
                bufferedInputStream2 = bufferedInputStream;
                if (bufferedInputStream2 != null) {
                    try {
                        bufferedInputStream2.close();
                    } catch (Exception unused4) {
                    }
                }
                return "".getBytes();
            } catch (Throwable th2) {
                th = th2;
                bufferedInputStream2 = bufferedInputStream;
                if (bufferedInputStream2 != null) {
                    try {
                        bufferedInputStream2.close();
                    } catch (Exception unused5) {
                    }
                }
                throw th;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "".getBytes();
        }
    }
}
