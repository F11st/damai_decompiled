package tb;

import android.view.View;
import com.taobao.monitor.impl.data.calculator.ICalculator;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class cf2 implements ICalculator {
    private final View a;
    private final View b;

    public cf2(View view, View view2) {
        this.a = view;
        this.b = view2;
    }

    @Override // com.taobao.monitor.impl.data.calculator.ICalculator
    public ff calculate() {
        ey2 ey2Var = new ey2(this.a, this.b);
        List<dy2> c = ey2Var.c();
        View f = ey2Var.f();
        float a = new d91().a(this.a, c, this.b);
        e30.a("DrawCalculator2", "SpecificViewAreaCalculator calculate percent = " + a);
        for (dy2 dy2Var : c) {
            dy2Var.c();
        }
        ey2Var.n();
        boolean g = ey2Var.g();
        View e = ey2Var.e();
        if (f == this.b) {
            f = null;
        }
        return new ff(cf2.class, a, g, e, f);
    }
}
