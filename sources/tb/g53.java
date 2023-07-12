package tb;

import android.content.Context;
import android.text.TextUtils;
import com.loc.C5861o;
import mtopsdk.common.util.SymbolExpUtil;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class g53 extends j53 {
    private Context c;
    private boolean d;
    private int e;
    private int f;
    private String b = "iKey";
    private int g = 0;

    public g53(Context context, boolean z, int i, int i2, String str) {
        f(context, z, i, i2, str, 0);
    }

    public g53(Context context, boolean z, int i, int i2, String str, int i3) {
        f(context, z, i, i2, str, i3);
    }

    private void f(Context context, boolean z, int i, int i2, String str, int i3) {
        this.c = context;
        this.d = z;
        this.e = i;
        this.f = i2;
        this.b = str;
        this.g = i3;
    }

    @Override // tb.j53
    public final void a(int i) {
        if (C5861o.a0(this.c) == 1) {
            return;
        }
        String c = com.loc.v1.c(System.currentTimeMillis(), "yyyyMMdd");
        String a = com.loc.al.a(this.c, this.b);
        if (!TextUtils.isEmpty(a)) {
            String[] split = a.split(SymbolExpUtil.SYMBOL_VERTICALBAR);
            if (split == null || split.length < 2) {
                com.loc.al.g(this.c, this.b);
            } else if (c.equals(split[0])) {
                i += Integer.parseInt(split[1]);
            }
        }
        Context context = this.c;
        String str = this.b;
        com.loc.al.d(context, str, c + "|" + i);
    }

    @Override // tb.j53
    protected final boolean c() {
        if (C5861o.a0(this.c) == 1) {
            return true;
        }
        if (this.d) {
            String a = com.loc.al.a(this.c, this.b);
            if (TextUtils.isEmpty(a)) {
                return true;
            }
            String[] split = a.split(SymbolExpUtil.SYMBOL_VERTICALBAR);
            if (split != null && split.length >= 2) {
                return !com.loc.v1.c(System.currentTimeMillis(), "yyyyMMdd").equals(split[0]) || Integer.parseInt(split[1]) < this.f;
            }
            com.loc.al.g(this.c, this.b);
            return true;
        }
        return false;
    }

    @Override // tb.j53
    public final int d() {
        int i;
        int i2 = Integer.MAX_VALUE;
        if ((C5861o.a0(this.c) != 1 && (i = this.e) > 0) || ((i = this.g) > 0 && i < Integer.MAX_VALUE)) {
            i2 = i;
        }
        j53 j53Var = this.a;
        return j53Var != null ? Math.max(i2, j53Var.d()) : i2;
    }
}
