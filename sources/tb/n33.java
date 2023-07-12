package tb;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class n33 {
    public String a;
    public byte b;
    public int c = 0;
    public String d = "none";
    public int e = 1;
    long f = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n33(String str, byte b) {
        this.b = (byte) 2;
        this.a = str;
        if (b <= 0 || 3 < b) {
            throw new IllegalArgumentException("log protocol flag invalid : ".concat(String.valueOf((int) b)));
        }
        this.b = b;
    }
}
