package tb;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class i4 {
    public int a;
    public float d;
    public float b = 0.0f;
    public float c = Float.MAX_VALUE;
    public int e = -1;
    private float[] f = {1.9f, 1.8f, 1.7f, 1.5f, 1.4f, 1.2f, 1.0f, 0.9f, 0.8f};
    private float[] g = {2.4f, 2.2f, 2.0f, 1.8f, 1.5f, 1.3f, 1.2f, 1.0f, 0.9f};

    /* JADX WARN: Removed duplicated region for block: B:70:0x00a5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x009b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:97:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void b() {
        /*
            Method dump skipped, instructions count: 196
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.i4.b():void");
    }

    @Deprecated
    public void a() {
        float[] fArr;
        b();
        int i = 8;
        if (this.a >= 8) {
            fArr = this.f;
        } else {
            fArr = this.g;
        }
        int i2 = 0;
        while (true) {
            if (i2 >= fArr.length) {
                i2 = 9;
                break;
            } else if (this.b >= fArr[i2]) {
                break;
            } else {
                i2++;
            }
        }
        int i3 = 10 - i2;
        int i4 = this.a;
        if (i4 >= 16) {
            i = 10;
        } else if (i4 >= 8) {
            i = 9;
        } else if (i4 < 6) {
            i = i4 >= 4 ? 6 : i4 >= 2 ? 4 : 0;
        }
        this.e = (int) ((i3 * 0.6f) + (i * 0.4f));
    }
}
