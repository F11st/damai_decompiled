package tb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class xz0 {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int A = 14;
    public static final int AUDIO = 92;
    public static final int B = 11;
    public static final int BIG = 7;
    public static final int BLOCKQUOTE = 71;
    public static final int BR = 16;
    public static final int CAPTION = 82;
    public static final int CITE = 4;
    public static final int CODE = 25;
    public static final int DEL = 20;
    public static final int DFN = 5;
    public static final int DIV = 53;
    public static final int EM = 9;
    public static final int FONT = 1;
    public static final int FOOTER = 51;
    public static final int H1 = 61;
    public static final int H2 = 62;
    public static final int H3 = 63;
    public static final int H4 = 64;
    public static final int H5 = 65;
    public static final int H6 = 66;
    public static final int HEADER = 50;
    public static final int HR = 72;
    public static final int I = 3;
    public static final int IMG = 15;
    public static final int INS = 19;
    public static final int KBD = 12;
    public static final int LI = 57;
    public static final int MARK = 13;
    public static final int OL = 56;
    public static final int P = 54;
    public static final int PRE = 70;
    public static final int Q = 24;
    public static final int S = 21;
    public static final int SMALL = 8;
    public static final int SPAN = 23;
    public static final int STRIKE = 22;
    public static final int STRONG = 10;
    public static final int SUB = 17;
    public static final int SUP = 18;
    public static final int TABLE = 81;
    public static final int TBODY = 85;
    public static final int TD = 88;
    public static final int TFOOT = 84;
    public static final int TH = 87;
    public static final int THEAD = 83;
    public static final int TR = 86;
    public static final int TT = 2;
    public static final int U = 6;
    public static final int UL = 55;
    public static final int UNKNOWN = -1;
    public static final int VIDEO = 91;

    public static boolean a(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2056334198") ? ((Boolean) ipChange.ipc$dispatch("-2056334198", new Object[]{Integer.valueOf(i)})).booleanValue() : i >= 50;
    }
}
