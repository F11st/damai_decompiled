package tb;

import android.text.TextUtils;
import com.taobao.pexode.mimetype.C6838a;
import com.taobao.pexode.mimetype.MimeType;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class oe0 extends ne0 {
    public static final int EXACT_SIZE_LEVEL = 1;
    public static final int LARGE_SIZE_LEVEL = 4;
    public static final int SMALL_SIZE_LEVEL = 2;
    public final String i;
    public final boolean j;
    public final boolean k;
    public final int l;
    public final String m;
    public int n;
    public int o;
    public boolean p;
    private MimeType q;
    private boolean r;

    public oe0(ne0 ne0Var, String str, int i, boolean z, String str2) {
        this(ne0Var, str, i, z, str2, false);
    }

    public static MimeType h(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.indexOf(46) == 0) {
            str = str.substring(1);
        }
        try {
            for (MimeType mimeType : C6838a.ALL_EXTENSION_TYPES) {
                if (mimeType != null && mimeType.e(str)) {
                    return mimeType;
                }
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public oe0 d(ne0 ne0Var, int i) {
        return e(ne0Var, i, this.j);
    }

    public oe0 e(ne0 ne0Var, int i, boolean z) {
        oe0 oe0Var = new oe0(ne0Var, this.i, i, this.k, this.m, z);
        oe0Var.n = this.n;
        oe0Var.o = this.o;
        oe0Var.p = this.p;
        return oe0Var;
    }

    public oe0 f(boolean z) {
        this.r = z;
        return this;
    }

    protected void finalize() {
        try {
            b(false);
            super.finalize();
        } catch (Throwable unused) {
        }
    }

    public MimeType g() {
        if (this.q == null) {
            this.q = h(this.m);
        }
        return this.q;
    }

    public boolean i() {
        if (this.r || this.a != 1) {
            return true;
        }
        return (this.k && !this.j) || !this.g || this.c == null;
    }

    public void j(MimeType mimeType) {
        this.q = mimeType;
    }

    public oe0(ne0 ne0Var, String str, int i, boolean z, String str2, boolean z2) {
        super(ne0Var == null ? new ne0(false, null, 0, 0) : ne0Var);
        this.i = str;
        this.l = i;
        this.k = z;
        this.m = str2;
        this.j = z2;
    }
}
