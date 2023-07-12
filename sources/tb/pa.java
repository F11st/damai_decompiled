package tb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class pa {
    private static transient /* synthetic */ IpChange $ipChange;
    public int code;
    public short dictIndex;
    public short num;
    public byte numOffset;
    public String origin;
    public String tail;
    private final int NUM_ERROR = 16383;
    private final int MAX_OFFSET = 32;

    private String insert(String str, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1032107772")) {
            return (String) ipChange.ipc$dispatch("-1032107772", new Object[]{this, str, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        StringBuffer stringBuffer = new StringBuffer();
        if (i2 == 0) {
            stringBuffer.append(i);
            stringBuffer.append(str);
            return stringBuffer.toString();
        }
        for (int i3 = 0; i3 < i2; i3++) {
            stringBuffer.append(str.charAt(i3));
        }
        stringBuffer.append(i);
        int length = str.length();
        while (i2 < length) {
            stringBuffer.append(str.charAt(i2));
            i2++;
        }
        return stringBuffer.toString();
    }

    public int decode(int i, b50 b50Var) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1350546705")) {
            return ((Integer) ipChange.ipc$dispatch("1350546705", new Object[]{this, Integer.valueOf(i), b50Var})).intValue();
        }
        this.code = i;
        this.num = (short) ((i >>> 18) & 16383);
        this.dictIndex = (short) ((i >>> 5) & 8191);
        this.numOffset = (byte) ((i >>> 0) & 31);
        throw null;
    }

    public int encode(short s) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1596389163")) {
            return ((Integer) ipChange.ipc$dispatch("1596389163", new Object[]{this, Short.valueOf(s)})).intValue();
        }
        if (s < 0) {
            return -1;
        }
        this.dictIndex = s;
        this.code = (s << 5) | (this.num << 18) | this.numOffset;
        return 0;
    }

    public int init(String str) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-4870856")) {
            return ((Integer) ipChange.ipc$dispatch("-4870856", new Object[]{this, str})).intValue();
        }
        if (str == null || str.length() == 0) {
            return -1;
        }
        this.origin = str;
        String str2 = "";
        String str3 = "";
        int i = 0;
        for (int i2 = 0; i2 < str.length(); i2++) {
            if (str.charAt(i2) >= '0' && str.charAt(i2) <= '9') {
                if (z) {
                    i = str3.length();
                    z = false;
                }
                str2 = str2 + str.charAt(i2);
            } else {
                str3 = str3 + str.charAt(i2);
            }
        }
        if (str2.length() > 0) {
            int intValue = Integer.valueOf(str2).intValue();
            if (intValue >= 65535) {
                return -1;
            }
            this.num = (short) intValue;
        } else {
            this.num = (short) -1;
        }
        if (i >= 32) {
            return -1;
        }
        this.tail = str3;
        this.numOffset = (byte) i;
        return 0;
    }
}
