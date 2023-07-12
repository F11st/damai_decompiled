package tb;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class ug1 {
    private final int[] a;
    private final int b;
    private final String c;
    public static final ug1 TERMINATOR = new ug1(new int[]{0, 0, 0}, 0, "TERMINATOR");
    public static final ug1 NUMERIC = new ug1(new int[]{10, 12, 14}, 1, "NUMERIC");
    public static final ug1 ALPHANUMERIC = new ug1(new int[]{9, 11, 13}, 2, "ALPHANUMERIC");
    public static final ug1 STRUCTURED_APPEND = new ug1(new int[]{0, 0, 0}, 3, "STRUCTURED_APPEND");
    public static final ug1 BYTE = new ug1(new int[]{8, 16, 16}, 4, "BYTE");
    public static final ug1 ECI = new ug1(null, 7, "ECI");
    public static final ug1 KANJI = new ug1(new int[]{8, 10, 12}, 8, "KANJI");
    public static final ug1 FNC1_FIRST_POSITION = new ug1(null, 5, "FNC1_FIRST_POSITION");
    public static final ug1 FNC1_SECOND_POSITION = new ug1(null, 9, "FNC1_SECOND_POSITION");

    private ug1(int[] iArr, int i, String str) {
        this.a = iArr;
        this.b = i;
        this.c = str;
    }

    public int a() {
        return this.b;
    }

    public int b(ex2 ex2Var) {
        if (this.a != null) {
            int f = ex2Var.f();
            return this.a[f <= 9 ? (char) 0 : f <= 26 ? (char) 1 : (char) 2];
        }
        throw new IllegalArgumentException("Character count doesn't apply to this mode");
    }

    public String toString() {
        return this.c;
    }
}
