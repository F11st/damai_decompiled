package tb;

import android.content.Context;
import android.text.TextUtils;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class i53 extends j53 {
    protected int b;
    protected long c;
    private String d;
    private Context e;

    public i53(Context context, int i, String str, j53 j53Var) {
        super(j53Var);
        this.b = i;
        this.d = str;
        this.e = context;
    }

    @Override // tb.j53
    public final void b(boolean z) {
        super.b(z);
        if (z) {
            String str = this.d;
            long currentTimeMillis = System.currentTimeMillis();
            this.c = currentTimeMillis;
            com.loc.al.d(this.e, str, String.valueOf(currentTimeMillis));
        }
    }

    @Override // tb.j53
    protected final boolean c() {
        if (this.c == 0) {
            String a = com.loc.al.a(this.e, this.d);
            this.c = TextUtils.isEmpty(a) ? 0L : Long.parseLong(a);
        }
        return System.currentTimeMillis() - this.c >= ((long) this.b);
    }
}
