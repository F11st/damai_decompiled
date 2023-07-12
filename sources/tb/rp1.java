package tb;

import android.app.Activity;
import android.view.View;
import android.view.Window;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.taobao.monitor.impl.data.lifecycle.FragmentLifecycle;
import com.taobao.monitor.procedure.IPage;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class rp1 {
    private View b;
    private Fragment c;
    private String d;
    private String e;
    Activity h;
    Fragment i;
    private String j;
    private boolean a = true;
    private boolean f = true;
    private boolean g = true;

    @NonNull
    public IPage a() {
        ra je0Var;
        if (!this.a) {
            return new com.taobao.monitor.procedure.b();
        }
        if (this.b == null) {
            e30.a("CustomPageBuilder", "create error: page root view is null");
            return new com.taobao.monitor.procedure.b();
        }
        pp1 pp1Var = new pp1();
        pp1Var.L(this.b);
        pp1Var.B(this.j);
        Activity activity = this.h;
        if (activity != null) {
            pp1Var.x(activity);
            pp1Var.A(m3.b(this.h));
        } else {
            Fragment fragment = this.i;
            if (fragment != null) {
                pp1Var.z(fragment);
                pp1Var.A(mp0.a(this.i));
            }
        }
        if (this.g) {
            je0Var = new eq1(pp1Var);
        } else {
            je0Var = new je0(pp1Var);
        }
        je0Var.k(this.f);
        pp1Var.H(this.f);
        lq lqVar = new lq(pp1Var);
        pp1Var.N(je0Var);
        pp1Var.D(lqVar);
        if (jd0.v) {
            pp1Var.K(new mq(pp1Var));
        } else {
            pp1Var.K(je0Var);
        }
        Fragment fragment2 = this.c;
        if (fragment2 != null) {
            pp1Var.I(FragmentLifecycle.a(fragment2));
            pp1Var.getPageLifecycleCallback().onPageCreate(this.d, this.e, new HashMap());
        }
        return pp1Var;
    }

    public rp1 b(Activity activity) {
        this.h = activity;
        return this;
    }

    public rp1 c(Fragment fragment) {
        this.i = fragment;
        return this;
    }

    public rp1 d(String str) {
        this.j = str;
        return this;
    }

    public rp1 e(boolean z) {
        this.f = z;
        return this;
    }

    public rp1 f(boolean z) {
        this.g = z;
        return this;
    }

    public rp1 g(String str) {
        this.d = str;
        return this;
    }

    public rp1 h(Fragment fragment) {
        this.c = fragment;
        return this;
    }

    public rp1 i(View view) {
        this.b = view;
        return this;
    }

    public rp1 j(Window window) {
        if (window != null) {
            this.b = window.getDecorView();
        }
        return this;
    }

    public rp1 k(String str) {
        this.e = str;
        return this;
    }

    public rp1 l(boolean z) {
        this.a = z;
        return this;
    }
}
