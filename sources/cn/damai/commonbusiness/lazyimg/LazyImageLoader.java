package cn.damai.commonbusiness.lazyimg;

import android.view.View;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.lazyimg.view.GifCareImageView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.HashMap;
import tb.d21;

/* compiled from: Taobao */
@RequiresApi(api = 19)
/* loaded from: classes4.dex */
public class LazyImageLoader extends ImgLoader implements View.OnAttachStateChangeListener, TaskListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private int a = 0;
    private HashMap<View, d21> b = new HashMap<>();
    private HashMap<View, d21> c = new HashMap<>();
    private HashMap<Integer, GifCareImageView> d = new HashMap<>();

    private void b(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1645256004")) {
            ipChange.ipc$dispatch("1645256004", new Object[]{this, view});
        } else if ((view instanceof GifCareImageView) && view.isAttachedToWindow()) {
            GifCareImageView gifCareImageView = (GifCareImageView) view;
            gifCareImageView.processParentScrollState(this.a);
            this.d.put(Integer.valueOf(view.hashCode()), gifCareImageView);
        }
    }

    private void c() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1473167756")) {
            ipChange.ipc$dispatch("1473167756", new Object[]{this});
        } else if (this.c.size() > 0) {
            for (d21 d21Var : new ArrayList(this.c.values())) {
                d(d21Var);
            }
        }
    }

    private void d(d21 d21Var) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-521086518")) {
            ipChange.ipc$dispatch("-521086518", new Object[]{this, d21Var});
        } else if (g()) {
            GifCareImageView b = d21Var.b();
            if (b.isAttachedToWindow()) {
                this.c.remove(b);
                this.b.put(b, d21Var);
                d21Var.e(this);
            }
        }
    }

    private void e() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1117085257")) {
            ipChange.ipc$dispatch("-1117085257", new Object[]{this});
        } else if (this.d.size() > 0) {
            for (GifCareImageView gifCareImageView : this.d.values()) {
                gifCareImageView.processParentScrollState(this.a);
            }
        }
    }

    private void f(View view) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-1812147424")) {
            ipChange.ipc$dispatch("-1812147424", new Object[]{this, view});
            return;
        }
        int i = R$id.id_lazy_tag;
        Object tag = view.getTag(i);
        int hashCode = hashCode();
        if (((tag instanceof Integer) && ((Integer) tag).intValue() == hashCode) ? false : false) {
            return;
        }
        view.setTag(i, Integer.valueOf(hashCode));
        view.addOnAttachStateChangeListener(this);
    }

    private boolean g() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "104653765")) {
            return ((Boolean) ipChange.ipc$dispatch("104653765", new Object[]{this})).booleanValue();
        }
        int i = this.a;
        return i == 0 || i == 1;
    }

    @Override // cn.damai.commonbusiness.lazyimg.ImgLoader
    public void a(d21 d21Var) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-569803782")) {
            ipChange.ipc$dispatch("-569803782", new Object[]{this, d21Var});
        } else if (d21Var == null || !d21Var.c()) {
        } else {
            GifCareImageView b = d21Var.b();
            if (this.b.remove(b) != null) {
                d21Var.a();
            }
            f(b);
            this.c.put(b, d21Var);
            d21Var.f();
            b(b);
            d(d21Var);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1601932917")) {
            ipChange.ipc$dispatch("-1601932917", new Object[]{this, recyclerView, Integer.valueOf(i)});
            return;
        }
        boolean z = this.a != i;
        this.a = i;
        if (g()) {
            c();
        }
        if (z) {
            e();
        }
    }

    @Override // cn.damai.commonbusiness.lazyimg.TaskListener
    public void onTaskLoadFinish(d21 d21Var) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-586461615")) {
            ipChange.ipc$dispatch("-586461615", new Object[]{this, d21Var});
        } else if (d21Var != null) {
            this.b.remove(d21Var.b());
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "420123607")) {
            ipChange.ipc$dispatch("420123607", new Object[]{this, view});
            return;
        }
        b(view);
        d21 d21Var = this.c.get(view);
        if (d21Var != null) {
            d(d21Var);
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "135364244")) {
            ipChange.ipc$dispatch("135364244", new Object[]{this, view});
        } else {
            this.d.remove(Integer.valueOf(view.hashCode()));
        }
    }
}
