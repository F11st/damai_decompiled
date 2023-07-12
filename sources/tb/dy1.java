package tb;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class dy1 {
    public static final int NUM_MASK_PATTERNS = 8;
    private ug1 a = null;
    private df0 b = null;
    private int c = -1;
    private int d = -1;
    private int e = -1;
    private int f = -1;
    private int g = -1;
    private int h = -1;
    private int i = -1;
    private ne j = null;

    public static boolean j(int i) {
        return i >= 0 && i < 8;
    }

    public df0 a() {
        return this.b;
    }

    public int b() {
        return this.e;
    }

    public ne c() {
        return this.j;
    }

    public int d() {
        return this.d;
    }

    public int e() {
        return this.g;
    }

    public int f() {
        return this.i;
    }

    public int g() {
        return this.f;
    }

    public int h() {
        return this.c;
    }

    public boolean i() {
        int i;
        ne neVar;
        return (this.a == null || this.b == null || this.c == -1 || this.d == -1 || (i = this.e) == -1 || this.f == -1 || this.g == -1 || this.h == -1 || this.i == -1 || !j(i) || this.f != this.g + this.h || (neVar = this.j) == null || this.d != neVar.e() || this.j.e() != this.j.d()) ? false : true;
    }

    public void k(df0 df0Var) {
        this.b = df0Var;
    }

    public void l(int i) {
        this.e = i;
    }

    public void m(ne neVar) {
        this.j = neVar;
    }

    public void n(int i) {
        this.d = i;
    }

    public void o(ug1 ug1Var) {
        this.a = ug1Var;
    }

    public void p(int i) {
        this.g = i;
    }

    public void q(int i) {
        this.h = i;
    }

    public void r(int i) {
        this.i = i;
    }

    public void s(int i) {
        this.f = i;
    }

    public void t(int i) {
        this.c = i;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(200);
        stringBuffer.append("<<\n");
        stringBuffer.append(" mode: ");
        stringBuffer.append(this.a);
        stringBuffer.append("\n ecLevel: ");
        stringBuffer.append(this.b);
        stringBuffer.append("\n version: ");
        stringBuffer.append(this.c);
        stringBuffer.append("\n matrixWidth: ");
        stringBuffer.append(this.d);
        stringBuffer.append("\n maskPattern: ");
        stringBuffer.append(this.e);
        stringBuffer.append("\n numTotalBytes: ");
        stringBuffer.append(this.f);
        stringBuffer.append("\n numDataBytes: ");
        stringBuffer.append(this.g);
        stringBuffer.append("\n numECBytes: ");
        stringBuffer.append(this.h);
        stringBuffer.append("\n numRSBlocks: ");
        stringBuffer.append(this.i);
        if (this.j == null) {
            stringBuffer.append("\n matrix: null\n");
        } else {
            stringBuffer.append("\n matrix:\n");
            stringBuffer.append(this.j.toString());
        }
        stringBuffer.append(">>\n");
        return stringBuffer.toString();
    }
}
