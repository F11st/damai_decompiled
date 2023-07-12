package tb;

import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class b00 extends hy {
    public int d;

    public b00(long j) {
        super(j);
    }

    public void f(int i) {
        this.d = i;
        if (this.c == null) {
            this.c = new HashMap();
        }
        this.c.put("pageIndex", az.J(i));
    }
}
