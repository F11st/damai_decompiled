package tb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.nio.ByteBuffer;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class pw0 {
    private static transient /* synthetic */ IpChange $ipChange;
    private static byte[] a = new byte[128];

    private static void a() {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "-2095547107")) {
            ipChange.ipc$dispatch("-2095547107", new Object[0]);
            return;
        }
        while (true) {
            byte[] bArr = a;
            if (i >= bArr.length) {
                return;
            }
            switch (i) {
                case 48:
                case 49:
                case 50:
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                    bArr[i] = (byte) (i - 48);
                    break;
                default:
                    switch (i) {
                        case 65:
                        case 66:
                        case 67:
                        case 68:
                        case 69:
                        case 70:
                            bArr[i] = (byte) (i - 55);
                            continue;
                        default:
                            switch (i) {
                                case 97:
                                case 98:
                                case 99:
                                case 100:
                                case 101:
                                case 102:
                                    bArr[i] = (byte) (i - 87);
                                    continue;
                                default:
                                    bArr[i] = -1;
                                    continue;
                                    continue;
                            }
                    }
            }
            i++;
        }
    }

    public static void b(ByteBuffer byteBuffer, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "414051143")) {
            ipChange.ipc$dispatch("414051143", new Object[]{byteBuffer, str});
            return;
        }
        byte[] bytes = str.getBytes();
        long j = 0;
        int length = str.length();
        int i = length - ((length >>> 4) << 4);
        for (int i2 = 0; i2 < i / 2; i2++) {
            byte[] bArr = a;
            int i3 = i2 * 2;
            byteBuffer.put((byte) ((bArr[bytes[i3 + 1]] | (bArr[bytes[i3]] << 4)) & 255));
        }
        while (i < length) {
            for (int i4 = 0; i4 < 16; i4++) {
                j = (j << 4) | a[bytes[i + i4]];
            }
            byteBuffer.putLong(j);
            i += 16;
        }
    }

    public static void c() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1535391052")) {
            ipChange.ipc$dispatch("-1535391052", new Object[0]);
        } else {
            a();
        }
    }
}
