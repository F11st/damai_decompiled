package tb;

import android.content.res.Resources;
import com.taobao.phenix.cache.memory.C6851a;
import com.taobao.phenix.cache.memory.ReleasableReferenceListener;
import java.util.HashSet;
import java.util.Set;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public abstract class ef implements ReleasableReferenceListener {
    private final String a;
    private final String b;
    private final int c;
    private final int d;
    private boolean e;
    private boolean f;
    private boolean g;
    private final Set<Integer> h = new HashSet(2);

    public ef(String str, String str2, int i, int i2) {
        this.a = str;
        this.b = str2;
        this.c = i;
        this.d = i2;
    }

    private synchronized void a(tq1 tq1Var) {
        if (tq1Var == null) {
            return;
        }
        if (this.f) {
            this.f = false;
            g();
        }
        if (this.g) {
            return;
        }
        if (tq1Var instanceof m12) {
            Set<Integer> set = this.h;
            Integer valueOf = Integer.valueOf(tq1Var.hashCode());
            if (set.contains(valueOf)) {
                this.g = true;
                xt2.i(C6851a.TAG_RECYCLE, "references dirty now(last releasable drawable same with the hash is lost), refer=%d, image=%s, drawable=%s", Integer.valueOf(this.h.size()), this, tq1Var);
            } else {
                this.h.add(valueOf);
                ((m12) tq1Var).c(this);
            }
        } else {
            this.g = true;
        }
    }

    private void h() {
        if (this.f || this.g || !this.e || this.h.size() != 0) {
            return;
        }
        f();
        this.f = true;
    }

    public String b() {
        return this.a;
    }

    public abstract int c();

    protected abstract tq1 d(String str, String str2, int i, int i2, boolean z, Resources resources);

    public tq1 e(boolean z, Resources resources) {
        tq1 d = d(this.a, this.b, this.c, this.d, z, resources);
        a(d);
        return d;
    }

    protected void f() {
    }

    protected void g() {
    }

    public synchronized void i(boolean z) {
        if (this.f && !z) {
            this.f = false;
            g();
        }
        this.e = z;
        xt2.a(C6851a.TAG_RECYCLE, "release from cache, result=%b, isDirty=%b, refer=%d, image=%s", Boolean.valueOf(z), Boolean.valueOf(this.g), Integer.valueOf(this.h.size()), this);
        h();
    }

    public synchronized void j() {
        this.g = true;
    }

    @Override // com.taobao.phenix.cache.memory.ReleasableReferenceListener
    public synchronized void onReferenceDowngrade2Passable(m12 m12Var) {
        if (m12Var == null) {
            return;
        }
        this.g = true;
        m12Var.c(null);
        this.h.remove(Integer.valueOf(m12Var.hashCode()));
        xt2.a(C6851a.TAG_RECYCLE, "image reference downgraded to passable, isDirty=%b, refer=%d, image=%s, drawable=%s", Boolean.valueOf(this.g), Integer.valueOf(this.h.size()), this, m12Var);
    }

    @Override // com.taobao.phenix.cache.memory.ReleasableReferenceListener
    public synchronized void onReferenceReleased(m12 m12Var) {
        if (m12Var == null) {
            return;
        }
        this.h.remove(Integer.valueOf(m12Var.hashCode()));
        xt2.a(C6851a.TAG_RECYCLE, "image reference released, isDirty=%b, refer=%d, image=%s, drawable=%s", Boolean.valueOf(this.g), Integer.valueOf(this.h.size()), this, m12Var);
        h();
    }

    public String toString() {
        return getClass().getSimpleName() + jn1.BRACKET_START_STR + Integer.toHexString(hashCode()) + ", key@" + this.a + jn1.BRACKET_END_STR;
    }
}
