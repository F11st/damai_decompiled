package tb;

import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class pc1 {
    public static String a(File file) {
        FileInputStream fileInputStream;
        if (file != null) {
            try {
                if (file.exists() && file.isFile() && file.length() > 0) {
                    byte[] bArr = new byte[1024];
                    try {
                        MessageDigest messageDigest = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
                        fileInputStream = new FileInputStream(file);
                        while (true) {
                            try {
                                try {
                                    int read = fileInputStream.read(bArr, 0, 1024);
                                    if (read != -1) {
                                        messageDigest.update(bArr, 0, read);
                                    } else {
                                        String b = b(messageDigest);
                                        yj.a(fileInputStream);
                                        return b;
                                    }
                                } catch (Throwable th) {
                                    th = th;
                                    yj.a(fileInputStream);
                                    throw th;
                                }
                            } catch (Exception e) {
                                e = e;
                                e.printStackTrace();
                                yj.a(fileInputStream);
                                return null;
                            }
                        }
                    } catch (Exception e2) {
                        e = e2;
                        fileInputStream = null;
                    } catch (Throwable th2) {
                        th = th2;
                        fileInputStream = null;
                        yj.a(fileInputStream);
                        throw th;
                    }
                }
            } catch (Throwable th3) {
                ob1.e(th3);
            }
        }
        return null;
    }

    public static String b(MessageDigest messageDigest) {
        byte[] digest = messageDigest.digest();
        StringBuilder sb = new StringBuilder();
        int length = digest.length;
        for (int i = 0; i < length; i++) {
            int i2 = digest[i];
            if (i2 < 0) {
                i2 += 256;
            }
            if (i2 < 16) {
                sb.append(0);
            }
            sb.append(Integer.toHexString(i2));
        }
        return sb.toString().toLowerCase();
    }

    public static String c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            byte[] bytes = str.getBytes();
            messageDigest.update(bytes, 0, bytes.length);
            return b(messageDigest);
        } catch (Exception e) {
            ob1.e(e);
            return null;
        }
    }
}
