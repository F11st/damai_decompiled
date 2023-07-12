package tb;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import com.alibaba.responsive.IDisableOritationActivity;
import com.alibaba.responsive.page.IResponsivePage;
import com.alibaba.responsive.page.orientation.C3730a;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class r22 {
    private IResponsivePage a;
    private int b;
    private int c;
    private C3730a d;

    public r22(IResponsivePage iResponsivePage) {
        this.a = iResponsivePage;
        d();
    }

    private void a(Configuration configuration) {
        if (b80.e(this.a.getPageActivity()) && b80.g(this.a.getPageActivity())) {
            int requestedOrientation = this.a.getPageActivity().getRequestedOrientation();
            if (configuration.orientation == 2 && requestedOrientation == 1) {
                configuration.orientation = 1;
            }
        }
    }

    private void b(Context context, int i, int i2) {
        int i3;
        if (!b80.c() || i2 * xe2.b() > i) {
            i3 = (i < xe2.a() || !((((double) i2) > (((double) i) * xe2.d()) ? 1 : (((double) i2) == (((double) i) * xe2.d()) ? 0 : -1)) <= 0)) ? 1000 : 1001;
        } else {
            i3 = 1002;
        }
        w22.d().i(context, i3);
    }

    private void d() {
        if (d32.i(this.a.getPageActivity())) {
            int h = d32.h(this.a.getPageActivity());
            int f = d32.f(this.a.getPageActivity());
            float f2 = this.a.getPageActivity().getResources().getDisplayMetrics().density;
            int i = (int) (h / f2);
            int i2 = (int) (f / f2);
            if (Build.VERSION.SDK_INT >= 24 && this.a.getPageActivity().isInMultiWindowMode()) {
                this.a.getPageActivity().getResources().getConfiguration().screenWidthDp = i;
                this.a.getPageActivity().getResources().getConfiguration().screenHeightDp = i2;
            }
            w22.d().f(this.a.getPageActivity(), this.a.getPageActivity().getResources().getConfiguration().orientation);
            w22.d().h(this.a.getPageActivity(), i);
            w22.d().g(this.a.getPageActivity(), this.a.getPageActivity().getResources().getConfiguration().screenHeightDp);
            b(this.a.getPageActivity(), i, i2);
            this.c = w22.d().e(this.a.getPageActivity());
            if (b80.e(this.a.getPageActivity())) {
                return;
            }
            IDisableOritationActivity b = v22.c().b();
            if (b == null || !b.hitDisableOritationActivityClassName(this.a.getPageActivity().getLocalClassName())) {
                this.d = new C3730a(this.a.getPageActivity());
                return;
            }
            return;
        }
        IDisableOritationActivity b2 = v22.c().b();
        if ((b2 != null && b2.hitDisableOritationActivityClassName(this.a.getPageActivity().getLocalClassName())) || this.a.getPageActivity() == null || this.a.getPageActivity().getRequestedOrientation() == 1) {
            return;
        }
        cp1.b(this.a.getPageActivity(), 1);
    }

    private void h() {
        if (this.d != null && b80.g(this.a.getPageActivity())) {
            int requestedOrientation = this.a.getPageActivity().getRequestedOrientation();
            if (requestedOrientation == 0 || requestedOrientation == 8) {
                float b = w22.d().b(this.a.getPageActivity());
                if (w22.d().c(this.a.getPageActivity()) <= xe2.c() || b > xe2.c()) {
                    return;
                }
                cp1.b(this.a.getPageActivity(), 1);
            }
        }
    }

    public void c(Context context, Configuration configuration) {
        w22.d().f(context, configuration.orientation);
        w22.d().h(context, configuration.screenWidthDp);
        w22.d().g(context, configuration.screenHeightDp);
        b(context, configuration.screenWidthDp, configuration.screenHeightDp);
    }

    public void e(Configuration configuration) {
        if (d32.i(this.a.getPageActivity())) {
            a(configuration);
            c(this.a.getPageActivity(), configuration);
            this.b = this.c;
            this.c = w22.d().e(this.a.getPageActivity());
        }
    }

    public void f() {
        w22.d().a(this.a.getPageActivity());
        C3730a c3730a = this.d;
        if (c3730a != null) {
            c3730a.g();
        }
    }

    public void g(Configuration configuration) {
        if (d32.i(this.a.getPageActivity())) {
            h();
            int i = this.b;
            int i2 = this.c;
            this.a.onResponsiveLayout(configuration, i2, i != i2);
        }
    }
}
