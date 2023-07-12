package tb;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class cv1 {
    public static final int ALL_IN = 2;
    public static final int PART_IN = 1;
    public static final int SKIP = 0;

    public static String a(int i) {
        return i == 1 ? "PART_IN" : i == 2 ? "ALL_IN" : "SKIP";
    }
}
