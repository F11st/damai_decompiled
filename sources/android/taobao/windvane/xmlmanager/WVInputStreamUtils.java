package android.taobao.windvane.xmlmanager;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class WVInputStreamUtils {
    static final int BUFFER_SIZE = 4096;

    public static byte[] InputStreamTOByte(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[4096];
        while (true) {
            int read = inputStream.read(bArr, 0, 4096);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    public static String InputStreamTOString(InputStream inputStream) throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[4096];
        while (true) {
            int read = inputStream.read(bArr, 0, 4096);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                return new String(byteArrayOutputStream.toByteArray(), "ISO-8859-1");
            }
        }
    }

    public static InputStream StringTOInputStream(String str) throws Exception {
        return new ByteArrayInputStream(str.getBytes("ISO-8859-1"));
    }

    public static InputStream byteTOInputStream(byte[] bArr) throws Exception {
        return new ByteArrayInputStream(bArr);
    }

    public static String byteTOString(byte[] bArr) throws Exception {
        return InputStreamTOString(byteTOInputStream(bArr));
    }

    public static String InputStreamTOString(InputStream inputStream, String str) throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[4096];
        while (true) {
            int read = inputStream.read(bArr, 0, 4096);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                return new String(byteArrayOutputStream.toByteArray(), "ISO-8859-1");
            }
        }
    }
}
