package tb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class sq1 {
    private static transient /* synthetic */ IpChange $ipChange;
    private static final double[] e = new double[128];
    private final char[] a;
    private final int b;
    private char c;
    public int d;

    static {
        int i = 0;
        while (true) {
            double[] dArr = e;
            if (i >= dArr.length) {
                return;
            }
            dArr[i] = Math.pow(10.0d, i);
            i++;
        }
    }

    public sq1(String str, int i) {
        try {
            char[] charArray = str.toCharArray();
            this.a = charArray;
            this.d = i;
            this.b = charArray.length;
            this.c = charArray[i];
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    public static float b(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-724886115")) {
            return ((Float) ipChange.ipc$dispatch("-724886115", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)})).floatValue();
        }
        if (i2 < -125 || i == 0) {
            return 0.0f;
        }
        if (i2 >= 128) {
            return i > 0 ? Float.POSITIVE_INFINITY : Float.NEGATIVE_INFINITY;
        } else if (i2 == 0) {
            return i;
        } else {
            if (i >= 67108864) {
                i++;
            }
            double d = i;
            double[] dArr = e;
            return (float) (i2 > 0 ? d * dArr[i2] : d / dArr[-i2]);
        }
    }

    private char f() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2084592370")) {
            return ((Character) ipChange.ipc$dispatch("2084592370", new Object[]{this})).charValue();
        }
        int i = this.d;
        int i2 = this.b;
        if (i < i2) {
            this.d = i + 1;
        }
        int i3 = this.d;
        if (i3 == i2) {
            return (char) 0;
        }
        return this.a[i3];
    }

    private void g(char c) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2046648678")) {
            ipChange.ipc$dispatch("2046648678", new Object[]{this, Character.valueOf(c)});
            return;
        }
        throw new RuntimeException("Unexpected char '" + c + "'.");
    }

    public void a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-647163635")) {
            ipChange.ipc$dispatch("-647163635", new Object[]{this});
        } else {
            this.c = f();
        }
    }

    public int c() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2120130577")) {
            return ((Integer) ipChange.ipc$dispatch("-2120130577", new Object[]{this})).intValue();
        }
        i();
        int i = this.c - '0';
        this.c = f();
        h();
        return i;
    }

    public float d() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-902009226")) {
            return ((Float) ipChange.ipc$dispatch("-902009226", new Object[]{this})).floatValue();
        }
        i();
        float e2 = e();
        h();
        return e2;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x003e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0041 A[LOOP:0: B:17:0x0041->B:21:0x004d, LOOP_START] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00b2 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00da A[LOOP:3: B:67:0x00da->B:68:0x00e0, LOOP_START] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x006f A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public float e() {
        /*
            Method dump skipped, instructions count: 532
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.sq1.e():float");
    }

    public void h() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-229717358")) {
            ipChange.ipc$dispatch("-229717358", new Object[]{this});
            return;
        }
        while (true) {
            int i = this.d;
            if (i >= this.b) {
                return;
            }
            char c = this.a[i];
            if (c != '\t' && c != '\n' && c != ' ' && c != ',') {
                return;
            }
            a();
        }
    }

    public void i() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-978916865")) {
            ipChange.ipc$dispatch("-978916865", new Object[]{this});
            return;
        }
        while (true) {
            int i = this.d;
            if (i >= this.b || !Character.isWhitespace(this.a[i])) {
                return;
            }
            a();
        }
    }
}
