package tb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.nio.ByteBuffer;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class sh2 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static int a(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1496504560")) {
            return ((Integer) ipChange.ipc$dispatch("1496504560", new Object[]{str})).intValue();
        }
        try {
            String b = b(str);
            if (b == null || "".equals(b)) {
                return -1;
            }
            return Integer.parseInt(b(str));
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return -1;
        } catch (Exception e2) {
            e2.printStackTrace();
            return -1;
        }
    }

    public static String b(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1339721393")) {
            return (String) ipChange.ipc$dispatch("-1339721393", new Object[]{str});
        }
        String str2 = "";
        if (str != null && str.length() != 0) {
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                    str2 = str2 + str.charAt(i);
                }
            }
        }
        return str2;
    }

    public static String c(byte b) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-405162206")) {
            return (String) ipChange.ipc$dispatch("-405162206", new Object[]{Byte.valueOf(b)});
        }
        String hexString = Integer.toHexString(b & 255);
        if (hexString.length() == 1) {
            return "0" + hexString;
        }
        return hexString;
    }

    public static String d(ByteBuffer byteBuffer) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1759312941")) {
            return (String) ipChange.ipc$dispatch("1759312941", new Object[]{byteBuffer});
        }
        if (byteBuffer == null || byteBuffer.limit() == 0) {
            return null;
        }
        ByteBuffer slice = byteBuffer.slice();
        String str = "";
        for (int i = 0; i < slice.limit(); i++) {
            byte b = slice.get(i);
            str = str + c(b);
        }
        return str;
    }

    public static String e(byte[] bArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "979317435")) {
            return (String) ipChange.ipc$dispatch("979317435", new Object[]{bArr});
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b : bArr) {
            stringBuffer.append(c(b));
        }
        return stringBuffer.toString();
    }
}
