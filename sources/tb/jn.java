package tb;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class jn {
    public static final int ALL = 29;
    public static final int CANCELLATION = 8;
    public static final int FAILURE = 16;
    public static final int LAST_RESULT = 2;
    public static final int NEW_RESULT = 1;
    public static final int PROGRESS_UPDATE = 4;
    public static final int SKIP = 0;
    private final int a;

    public jn(int i) {
        this.a = i;
    }

    public boolean a(int i) {
        return (i & this.a) > 0;
    }
}
