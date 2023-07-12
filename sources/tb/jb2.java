package tb;

import android.graphics.PointF;
import androidx.annotation.FloatRange;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class jb2 {
    private final List<iq> a;
    private PointF b;
    private boolean c;

    public jb2(PointF pointF, boolean z, List<iq> list) {
        this.b = pointF;
        this.c = z;
        this.a = new ArrayList(list);
    }

    private void e(float f, float f2) {
        if (this.b == null) {
            this.b = new PointF();
        }
        this.b.set(f, f2);
    }

    public List<iq> a() {
        return this.a;
    }

    public PointF b() {
        return this.b;
    }

    public void c(jb2 jb2Var, jb2 jb2Var2, @FloatRange(from = 0.0d, to = 1.0d) float f) {
        if (this.b == null) {
            this.b = new PointF();
        }
        this.c = jb2Var.d() || jb2Var2.d();
        if (jb2Var.a().size() != jb2Var2.a().size()) {
            kb1.c("Curves must have the same number of control points. Shape 1: " + jb2Var.a().size() + "\tShape 2: " + jb2Var2.a().size());
        }
        int min = Math.min(jb2Var.a().size(), jb2Var2.a().size());
        if (this.a.size() < min) {
            for (int size = this.a.size(); size < min; size++) {
                this.a.add(new iq());
            }
        } else if (this.a.size() > min) {
            for (int size2 = this.a.size() - 1; size2 >= min; size2--) {
                List<iq> list = this.a;
                list.remove(list.size() - 1);
            }
        }
        PointF b = jb2Var.b();
        PointF b2 = jb2Var2.b();
        e(eg1.k(b.x, b2.x, f), eg1.k(b.y, b2.y, f));
        for (int size3 = this.a.size() - 1; size3 >= 0; size3--) {
            iq iqVar = jb2Var.a().get(size3);
            iq iqVar2 = jb2Var2.a().get(size3);
            PointF a = iqVar.a();
            PointF b3 = iqVar.b();
            PointF c = iqVar.c();
            PointF a2 = iqVar2.a();
            PointF b4 = iqVar2.b();
            PointF c2 = iqVar2.c();
            this.a.get(size3).d(eg1.k(a.x, a2.x, f), eg1.k(a.y, a2.y, f));
            this.a.get(size3).e(eg1.k(b3.x, b4.x, f), eg1.k(b3.y, b4.y, f));
            this.a.get(size3).f(eg1.k(c.x, c2.x, f), eg1.k(c.y, c2.y, f));
        }
    }

    public boolean d() {
        return this.c;
    }

    public String toString() {
        return "ShapeData{numCurves=" + this.a.size() + "closed=" + this.c + '}';
    }

    public jb2() {
        this.a = new ArrayList();
    }
}
