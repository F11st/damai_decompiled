package cn.damai.seatdecoder.common.decoder.serialize.quantumbinrary.binary.model;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.a50;
import tb.qe0;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class Chair {
    private static transient /* synthetic */ IpChange $ipChange;
    private static StringBuilder mSB = new StringBuilder(256);
    public int angle;
    public String chairOrigin;
    public String floorOrigin;
    public long groupId;
    public long groupPriceId;
    public long priceId;
    public String rowOrigin;
    public int secondIndex;
    public long sid;
    public int x;
    public int y;
    public int floorCode = -1;
    public int rowCode = -1;
    public int chairCode = -1;
    private final int NAME_NUM_ERROR = 16383;
    private final int MAX_OFFSET = 32;

    private String decodeName(int i, a50 a50Var) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "823879114")) {
            return (String) ipChange.ipc$dispatch("823879114", new Object[]{this, Integer.valueOf(i), a50Var});
        }
        short s = (short) ((i >>> 18) & 16383);
        byte b = (byte) ((i >>> 0) & 31);
        String b2 = a50Var.b((short) ((i >>> 5) & 8191));
        if (s == 16383 || s == -1 || s == 0) {
            return b2;
        }
        StringBuilder stringBuilder = getStringBuilder();
        stringBuilder.append(b2);
        stringBuilder.insert((int) b, (int) s);
        return stringBuilder.toString();
    }

    private int encodeName(String str, qe0 qe0Var) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1420705754")) {
            return ((Integer) ipChange.ipc$dispatch("-1420705754", new Object[]{this, str, qe0Var})).intValue();
        }
        return -1;
    }

    private StringBuilder getStringBuilder() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1946295729")) {
            return (StringBuilder) ipChange.ipc$dispatch("-1946295729", new Object[]{this});
        }
        mSB.setLength(0);
        return mSB;
    }

    private String insert(String str, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-378499097")) {
            return (String) ipChange.ipc$dispatch("-378499097", new Object[]{this, str, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        StringBuilder sb = new StringBuilder();
        if (i2 == 0) {
            sb.append(i);
            sb.append(str);
            return sb.toString();
        }
        sb.append(str);
        sb.insert(i2, i);
        return sb.toString();
    }

    public void decodeChair(int i, a50 a50Var) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1900486522")) {
            ipChange.ipc$dispatch("1900486522", new Object[]{this, Integer.valueOf(i), a50Var});
            return;
        }
        this.chairCode = i;
        this.chairOrigin = decodeName(i, a50Var);
    }

    public void decodeFloor(int i, a50 a50Var) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1798532031")) {
            ipChange.ipc$dispatch("-1798532031", new Object[]{this, Integer.valueOf(i), a50Var});
            return;
        }
        this.floorCode = i;
        this.floorOrigin = decodeName(i, a50Var);
    }

    public void decodeRow(int i, a50 a50Var) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1599395407")) {
            ipChange.ipc$dispatch("1599395407", new Object[]{this, Integer.valueOf(i), a50Var});
            return;
        }
        this.rowCode = i;
        this.rowOrigin = decodeName(i, a50Var);
    }

    public void encodeChair(String str, qe0 qe0Var) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "484432927")) {
            ipChange.ipc$dispatch("484432927", new Object[]{this, str, qe0Var});
            return;
        }
        this.chairCode = encodeName(str, qe0Var);
        this.chairOrigin = str;
    }

    public void encodeFloor(String str, qe0 qe0Var) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1143493064")) {
            ipChange.ipc$dispatch("-1143493064", new Object[]{this, str, qe0Var});
            return;
        }
        this.floorCode = encodeName(str, qe0Var);
        this.floorOrigin = str;
    }

    public void encodeRow(String str, qe0 qe0Var) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1572572182")) {
            ipChange.ipc$dispatch("-1572572182", new Object[]{this, str, qe0Var});
            return;
        }
        this.rowCode = encodeName(str, qe0Var);
        this.rowOrigin = str;
    }
}
