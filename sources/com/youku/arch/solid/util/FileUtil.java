package com.youku.arch.solid.util;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.upsplayer.util.YKUpsConvert;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class FileUtil {
    private static transient /* synthetic */ IpChange $ipChange;
    private static final char[] HEX_DIGITS = {YKUpsConvert.CHAR_ZERO, '1', '2', '3', '4', '5', '6', '7', '8', YKUpsConvert.CHAR_NINE, 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String byteToHexString(byte[] bArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-172745713")) {
            return (String) ipChange.ipc$dispatch("-172745713", new Object[]{bArr});
        }
        char[] cArr = new char[32];
        int i = 0;
        for (int i2 = 0; i2 < 16; i2++) {
            byte b = bArr[i2];
            int i3 = i + 1;
            char[] cArr2 = HEX_DIGITS;
            cArr[i] = cArr2[(b >>> 4) & 15];
            i = i3 + 1;
            cArr[i3] = cArr2[b & 15];
        }
        return new String(cArr);
    }

    public static void close(Closeable closeable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1270113104")) {
            ipChange.ipc$dispatch("1270113104", new Object[]{closeable});
        } else if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static String computeFileMD5(File file) {
        FileChannel fileChannel;
        FileChannel fileChannel2;
        MessageDigest messageDigest;
        FileInputStream fileInputStream;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1798484675")) {
            return (String) ipChange.ipc$dispatch("-1798484675", new Object[]{file});
        }
        if (file == null || !file.exists()) {
            return "";
        }
        FileChannel fileChannel3 = null;
        try {
            messageDigest = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            fileInputStream = new FileInputStream(file);
        } catch (Exception unused) {
            fileChannel2 = null;
        } catch (Throwable th) {
            th = th;
            fileChannel = null;
        }
        try {
            fileChannel3 = fileInputStream.getChannel();
            ByteBuffer allocate = ByteBuffer.allocate(102400);
            while (true) {
                int read = fileChannel3.read(allocate);
                if (read != -1) {
                    messageDigest.update(allocate.array(), 0, read);
                    allocate.position(0);
                    Thread.sleep(1L);
                } else {
                    String byteToHexString = byteToHexString(messageDigest.digest());
                    close(fileInputStream);
                    close(fileChannel3);
                    return byteToHexString;
                }
            }
        } catch (Exception unused2) {
            fileChannel2 = fileChannel3;
            fileChannel3 = fileInputStream;
            close(fileChannel3);
            close(fileChannel2);
            return "";
        } catch (Throwable th2) {
            th = th2;
            fileChannel = fileChannel3;
            fileChannel3 = fileInputStream;
            close(fileChannel3);
            close(fileChannel);
            throw th;
        }
    }
}
