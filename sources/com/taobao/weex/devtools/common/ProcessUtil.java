package com.taobao.weex.devtools.common;

import java.io.FileInputStream;
import java.io.IOException;
import javax.annotation.Nullable;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ProcessUtil {
    private static final int CMDLINE_BUFFER_SIZE = 64;
    private static String sProcessName;
    private static boolean sProcessNameRead;

    @Nullable
    public static synchronized String getProcessName() {
        String str;
        synchronized (ProcessUtil.class) {
            if (!sProcessNameRead) {
                sProcessNameRead = true;
                try {
                    sProcessName = readProcessName();
                } catch (IOException unused) {
                }
            }
            str = sProcessName;
        }
        return str;
    }

    private static int indexOf(byte[] bArr, int i, int i2, byte b) {
        for (int i3 = 0; i3 < bArr.length; i3++) {
            if (bArr[i3] == b) {
                return i3;
            }
        }
        return -1;
    }

    private static String readProcessName() throws IOException {
        int read;
        byte[] bArr = new byte[64];
        FileInputStream fileInputStream = new FileInputStream("/proc/self/cmdline");
        boolean z = false;
        try {
            read = fileInputStream.read(bArr);
        } catch (Throwable th) {
            th = th;
        }
        try {
            int indexOf = indexOf(bArr, 0, read, (byte) 0);
            if (indexOf > 0) {
                read = indexOf;
            }
            String str = new String(bArr, 0, read);
            Util.close(fileInputStream, false);
            return str;
        } catch (Throwable th2) {
            th = th2;
            z = true;
            Util.close(fileInputStream, true ^ z);
            throw th;
        }
    }
}
