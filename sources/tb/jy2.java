package tb;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.ColorRes;
import androidx.annotation.IntRange;
import androidx.annotation.LayoutRes;
import androidx.core.content.ContextCompat;
import cn.damai.commonbusiness.R$color;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.skeleton.ShimmerLayout;
import cn.damai.commonbusiness.skeleton.SkeletonScreen;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class jy2 implements SkeletonScreen {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String h = "tb.jy2";
    private final hy2 a;
    private final View b;
    private final int c;
    private final int d;
    private final boolean e;
    private final int f;
    private final int g;

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class a implements View.OnAttachStateChangeListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ ShimmerLayout a;

        a(jy2 jy2Var, ShimmerLayout shimmerLayout) {
            this.a = shimmerLayout;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-104177724")) {
                ipChange.ipc$dispatch("-104177724", new Object[]{this, view});
            } else {
                this.a.startShimmerAnimation();
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1207041215")) {
                ipChange.ipc$dispatch("-1207041215", new Object[]{this, view});
            } else {
                this.a.stopShimmerAnimation();
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public static class b {
        private static transient /* synthetic */ IpChange $ipChange;
        private final View a;
        private int b;
        private int d;
        private boolean c = true;
        private int e = 1000;
        private int f = 20;

        public b(View view) {
            this.a = view;
            this.d = ContextCompat.getColor(view.getContext(), R$color.shimmer_color);
        }

        public b g(@IntRange(from = 0, to = 30) int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1846333818")) {
                return (b) ipChange.ipc$dispatch("1846333818", new Object[]{this, Integer.valueOf(i)});
            }
            this.f = i;
            return this;
        }

        public b h(@ColorRes int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1764558858")) {
                return (b) ipChange.ipc$dispatch("1764558858", new Object[]{this, Integer.valueOf(i)});
            }
            this.d = ContextCompat.getColor(this.a.getContext(), i);
            return this;
        }

        public b i(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "467404879")) {
                return (b) ipChange.ipc$dispatch("467404879", new Object[]{this, Integer.valueOf(i)});
            }
            this.e = i;
            return this;
        }

        public b j(@LayoutRes int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "909907105")) {
                return (b) ipChange.ipc$dispatch("909907105", new Object[]{this, Integer.valueOf(i)});
            }
            this.b = i;
            return this;
        }

        public jy2 k() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1694193336")) {
                return (jy2) ipChange.ipc$dispatch("-1694193336", new Object[]{this});
            }
            jy2 jy2Var = new jy2(this, null);
            jy2Var.show();
            return jy2Var;
        }
    }

    /* synthetic */ jy2(b bVar, a aVar) {
        this(bVar);
    }

    private ShimmerLayout a(ViewGroup viewGroup) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2128308863")) {
            return (ShimmerLayout) ipChange.ipc$dispatch("2128308863", new Object[]{this, viewGroup});
        }
        ShimmerLayout shimmerLayout = (ShimmerLayout) LayoutInflater.from(this.b.getContext()).inflate(R$layout.layout_shimmer, viewGroup, false);
        shimmerLayout.setShimmerColor(this.d);
        shimmerLayout.setShimmerAngle(this.g);
        shimmerLayout.setShimmerAnimationDuration(this.f);
        View inflate = LayoutInflater.from(this.b.getContext()).inflate(this.c, (ViewGroup) shimmerLayout, false);
        ViewGroup.LayoutParams layoutParams = inflate.getLayoutParams();
        if (layoutParams != null) {
            shimmerLayout.setLayoutParams(layoutParams);
        }
        shimmerLayout.addView(inflate);
        shimmerLayout.addOnAttachStateChangeListener(new a(this, shimmerLayout));
        shimmerLayout.startShimmerAnimation();
        return shimmerLayout;
    }

    private View b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "929434233")) {
            return (View) ipChange.ipc$dispatch("929434233", new Object[]{this});
        }
        ViewParent parent = this.b.getParent();
        if (parent == null) {
            Log.e(h, "the source view have not attach to any view");
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) parent;
        if (this.e) {
            return a(viewGroup);
        }
        return LayoutInflater.from(this.b.getContext()).inflate(this.c, viewGroup, false);
    }

    @Override // cn.damai.commonbusiness.skeleton.SkeletonScreen
    public void hide() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-470359694")) {
            ipChange.ipc$dispatch("-470359694", new Object[]{this});
            return;
        }
        if (this.a.a() instanceof ShimmerLayout) {
            ((ShimmerLayout) this.a.a()).stopShimmerAnimation();
        }
        this.a.d();
    }

    @Override // cn.damai.commonbusiness.skeleton.SkeletonScreen
    public void show() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "684312023")) {
            ipChange.ipc$dispatch("684312023", new Object[]{this});
            return;
        }
        View b2 = b();
        if (b2 != null) {
            this.a.c(b2);
        }
    }

    private jy2(b bVar) {
        this.b = bVar.a;
        this.c = bVar.b;
        this.e = bVar.c;
        this.f = bVar.e;
        this.g = bVar.f;
        this.d = bVar.d;
        this.a = new hy2(bVar.a);
    }
}
