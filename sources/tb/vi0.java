package tb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class vi0 {
    private static transient /* synthetic */ IpChange $ipChange;

    /* JADX WARN: Type inference failed for: r0v1, types: [boolean] */
    public static byte[] a(File file) {
        FileInputStream fileInputStream;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-444414245")) {
            return (byte[]) ipChange.ipc$dispatch("-444414245", new Object[]{file});
        }
        ?? exists = file.exists();
        FileInputStream fileInputStream2 = null;
        try {
            if (exists == 0) {
                return null;
            }
            try {
                fileInputStream = new FileInputStream(file);
            } catch (FileNotFoundException e) {
                e = e;
                fileInputStream = null;
            } catch (IOException e2) {
                e = e2;
                fileInputStream = null;
            } catch (Throwable th) {
                th = th;
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (IOException unused) {
                    }
                }
                throw th;
            }
            try {
                if (fileInputStream.getChannel().size() == 0) {
                    try {
                        fileInputStream.close();
                    } catch (IOException unused2) {
                    }
                    return null;
                }
                byte[] bArr = new byte[fileInputStream.available()];
                fileInputStream.read(bArr);
                try {
                    fileInputStream.close();
                } catch (IOException unused3) {
                }
                return bArr;
            } catch (FileNotFoundException e3) {
                e = e3;
                e.printStackTrace();
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException unused4) {
                    }
                }
                return null;
            } catch (IOException e4) {
                e = e4;
                e.printStackTrace();
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException unused5) {
                    }
                }
                return null;
            }
        } catch (Throwable th2) {
            th = th2;
            fileInputStream2 = exists;
        }
    }
}
