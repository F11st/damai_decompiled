package tb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.upsplayer.util.YKUpsConvert;
import java.util.Random;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class vk2 {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String TAG = "TagUtil";
    private static final char[] a = {YKUpsConvert.CHAR_ZERO, '1', '2', '3', '4', '5', '6', '7', '8', YKUpsConvert.CHAR_NINE, YKUpsConvert.CHAR_A, 'B', 'C', qb1.LEVEL_D, qb1.LEVEL_E, YKUpsConvert.CHAR_F};
    private static final char[] b = new char[256];
    private static final char[] c = new char[256];
    private static final byte[] d;

    static {
        for (int i = 0; i < 256; i++) {
            char[] cArr = b;
            char[] cArr2 = a;
            cArr[i] = cArr2[(i >> 4) & 15];
            c[i] = cArr2[i & 15];
        }
        d = new byte[103];
        for (int i2 = 0; i2 <= 70; i2++) {
            d[i2] = -1;
        }
        for (byte b2 = 0; b2 < 10; b2 = (byte) (b2 + 1)) {
            d[b2 + 48] = b2;
        }
        for (byte b3 = 0; b3 < 6; b3 = (byte) (b3 + 1)) {
            byte[] bArr = d;
            byte b4 = (byte) (b3 + 10);
            bArr[b3 + 65] = b4;
            bArr[b3 + 97] = b4;
        }
    }

    public static String a(byte[] bArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1526772722")) {
            return (String) ipChange.ipc$dispatch("1526772722", new Object[]{bArr});
        }
        if (bArr != null) {
            return c(bArr, false);
        }
        throw new IllegalArgumentException("param bytes is null.");
    }

    public static byte[] b(String str) {
        byte[] bArr;
        byte b2;
        byte b3;
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "1421707363")) {
            return (byte[]) ipChange.ipc$dispatch("1421707363", new Object[]{str});
        }
        int length = str.length();
        if ((length & 1) == 0) {
            byte[] bArr2 = new byte[length >> 1];
            int i = 0;
            int i2 = 0;
            while (i < length) {
                int i3 = i + 1;
                char charAt = str.charAt(i);
                if (charAt <= 'f' && (b2 = (bArr = d)[charAt]) != -1) {
                    int i4 = i3 + 1;
                    char charAt2 = str.charAt(i3);
                    if (charAt2 <= 'f' && (b3 = bArr[charAt2]) != -1) {
                        bArr2[i2] = (byte) ((b2 << 4) | b3);
                        i2++;
                        i = i4;
                    }
                }
                z = true;
                break;
            }
            if (z) {
                throw new IllegalArgumentException("Invalid hexadecimal digit: " + str);
            }
            return bArr2;
        }
        throw new IllegalArgumentException("Odd number of characters: " + str);
    }

    public static String c(byte[] bArr, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1664677525")) {
            return (String) ipChange.ipc$dispatch("-1664677525", new Object[]{bArr, Boolean.valueOf(z)});
        }
        char[] cArr = new char[bArr.length * 2];
        int i = 0;
        for (int i2 = 0; i2 < bArr.length; i2++) {
            int i3 = bArr[i2] & 255;
            if (z && i3 == 0 && i2 == bArr.length - 1) {
                break;
            }
            int i4 = i + 1;
            cArr[i] = b[i3];
            i = i4 + 1;
            cArr[i4] = c[i3];
        }
        return new String(cArr, 0, i);
    }

    public static byte[] d(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2079656874")) {
            return (byte[]) ipChange.ipc$dispatch("2079656874", new Object[]{str});
        }
        if (str != null) {
            return b(str);
        }
        throw new IllegalArgumentException("param string is null.");
    }

    public static String e(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-477908431")) {
            return (String) ipChange.ipc$dispatch("-477908431", new Object[]{Integer.valueOf(i)});
        }
        try {
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < i; i2++) {
                sb.append(Integer.toHexString(new Random().nextInt(16)));
            }
            return sb.toString().toUpperCase();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String f(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "286775485")) {
            return (String) ipChange.ipc$dispatch("286775485", new Object[]{str});
        }
        byte[] d2 = d(str);
        byte[] bArr = new byte[d2.length];
        for (int i = 0; i < d2.length; i++) {
            bArr[i] = d2[(d2.length - 1) - i];
        }
        return a(bArr);
    }
}
