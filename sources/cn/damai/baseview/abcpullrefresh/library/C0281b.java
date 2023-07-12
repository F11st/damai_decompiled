package cn.damai.baseview.abcpullrefresh.library;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.os.Build;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.RelativeLayout;
import cn.damai.baseview.abcpullrefresh.smoothprogressbar.SmoothProgressBar;
import cn.damai.uikit.R$attr;
import cn.damai.uikit.R$color;
import cn.damai.uikit.R$id;
import cn.damai.uikit.R$string;
import cn.damai.uikit.R$styleable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.lw0;

/* compiled from: Taobao */
/* renamed from: cn.damai.baseview.abcpullrefresh.library.b */
/* loaded from: classes.dex */
public class C0281b extends lw0 {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int PROGRESS_BAR_STYLE_INSIDE = 0;
    public static final int PROGRESS_BAR_STYLE_OUTSIDE = 1;
    private View a;
    private ViewGroup b;
    private SmoothProgressBar c;
    private int d;
    private long e;
    private int f;
    private int g = -2;
    private final Interpolator h = new AccelerateInterpolator();

    /* compiled from: Taobao */
    /* renamed from: cn.damai.baseview.abcpullrefresh.library.b$a */
    /* loaded from: classes.dex */
    public class C0282a extends AnimatorListenerAdapter {
        private static transient /* synthetic */ IpChange $ipChange;

        C0282a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1987335805")) {
                ipChange.ipc$dispatch("-1987335805", new Object[]{this, animator});
                return;
            }
            View l = C0281b.this.l();
            if (l != null) {
                l.setVisibility(8);
            }
            C0281b.this.o();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public C0281b() {
        int m = m();
        if (Build.VERSION.SDK_INT >= m) {
            return;
        }
        throw new IllegalStateException("This HeaderTransformer is designed to run on SDK " + m + "+. If using ActionBarSherlock or ActionBarCompat you should use the appropriate provided extra.");
    }

    private void h() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2113186142")) {
            ipChange.ipc$dispatch("2113186142", new Object[]{this});
        } else if (this.c != null) {
            ShapeDrawable shapeDrawable = new ShapeDrawable();
            shapeDrawable.setShape(new RectShape());
            shapeDrawable.getPaint().setColor(this.d);
            this.c.setProgressDrawable(new ClipDrawable(shapeDrawable, 17, 1));
        }
    }

    private void i() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-53609800")) {
            ipChange.ipc$dispatch("-53609800", new Object[]{this});
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.g);
        int i = this.f;
        if (i == 0) {
            layoutParams.addRule(8, R$id.ptr_content);
        } else if (i == 1) {
            layoutParams.addRule(3, R$id.ptr_content);
        }
        this.c.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static TypedArray n(Context context, int i, int[] iArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-411477579")) {
            return (TypedArray) ipChange.ipc$dispatch("-411477579", new Object[]{context, Integer.valueOf(i), iArr});
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(i, typedValue, true);
        return context.obtainStyledAttributes(typedValue.resourceId, iArr);
    }

    private void p(Activity activity, View view) {
        int resourceId;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1228381436")) {
            ipChange.ipc$dispatch("-1228381436", new Object[]{this, activity, view});
            return;
        }
        TypedArray n = n(activity, R$attr.ptrHeaderStyle, R$styleable.PullToRefreshHeader);
        int i = R$styleable.PullToRefreshHeader_ptrHeaderBackground;
        if (n.hasValue(i)) {
            n.getDrawable(i);
        } else {
            j(activity);
        }
        n.getResourceId(R$styleable.PullToRefreshHeader_ptrHeaderTitleTextAppearance, k(view.getContext()));
        int i2 = R$styleable.PullToRefreshHeader_ptrProgressBarColor;
        if (n.hasValue(i2)) {
            this.d = n.getColor(i2, this.d);
        }
        this.f = n.getInt(R$styleable.PullToRefreshHeader_ptrProgressBarStyle, 1);
        int i3 = R$styleable.PullToRefreshHeader_ptrProgressBarHeight;
        if (n.hasValue(i3)) {
            this.g = n.getDimensionPixelSize(i3, this.g);
        }
        int i4 = R$styleable.PullToRefreshHeader_ptrPullText;
        if (n.hasValue(i4)) {
            n.getString(i4);
        }
        int i5 = R$styleable.PullToRefreshHeader_ptrRefreshingText;
        if (n.hasValue(i5)) {
            n.getString(i5);
        }
        int i6 = R$styleable.PullToRefreshHeader_ptrReleaseText;
        if (n.hasValue(i6)) {
            n.getString(i6);
        }
        int i7 = R$styleable.PullToRefreshHeader_ptrSmoothProgressBarStyle;
        if (n.hasValue(i7) && (resourceId = n.getResourceId(i7, 0)) != 0) {
            this.c.applyStyle(resourceId);
        }
        n.recycle();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // tb.lw0
    public boolean a() {
        ObjectAnimator objectAnimator;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2025024343")) {
            return ((Boolean) ipChange.ipc$dispatch("-2025024343", new Object[]{this})).booleanValue();
        }
        boolean z = this.a.getVisibility() != 8;
        if (z) {
            if (this.b.getAlpha() >= 0.5f) {
                AnimatorSet animatorSet = new AnimatorSet();
                ViewGroup viewGroup = this.b;
                animatorSet.playTogether(ObjectAnimator.ofFloat(viewGroup, "translationY", 0.0f, -viewGroup.getHeight()), ObjectAnimator.ofFloat(this.a, "alpha", 1.0f, 0.0f));
                objectAnimator = animatorSet;
            } else {
                objectAnimator = ObjectAnimator.ofFloat(this.a, "alpha", 1.0f, 0.0f);
            }
            objectAnimator.setDuration(this.e);
            objectAnimator.addListener(new C0282a());
            objectAnimator.start();
        }
        return z;
    }

    @Override // tb.lw0
    public void b(Activity activity, Configuration configuration) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1233245054")) {
            ipChange.ipc$dispatch("-1233245054", new Object[]{this, activity, configuration});
        } else {
            p(activity, l());
        }
    }

    @Override // tb.lw0
    public void c(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1745649686")) {
            ipChange.ipc$dispatch("-1745649686", new Object[]{this, Float.valueOf(f)});
            return;
        }
        SmoothProgressBar smoothProgressBar = this.c;
        if (smoothProgressBar != null) {
            smoothProgressBar.setVisibility(0);
            float interpolation = this.h.getInterpolation(f);
            SmoothProgressBar smoothProgressBar2 = this.c;
            smoothProgressBar2.setProgress(Math.round(smoothProgressBar2.getMax() * interpolation));
        }
    }

    @Override // tb.lw0
    public void d() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-515167313")) {
            ipChange.ipc$dispatch("-515167313", new Object[]{this});
            return;
        }
        ViewGroup viewGroup = this.b;
        if (viewGroup != null) {
            ObjectAnimator.ofFloat(viewGroup, "alpha", 1.0f, 0.0f).start();
        }
    }

    @Override // tb.lw0
    public void e() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1444533695")) {
            ipChange.ipc$dispatch("-1444533695", new Object[]{this});
            return;
        }
        SmoothProgressBar smoothProgressBar = this.c;
        if (smoothProgressBar != null) {
            smoothProgressBar.setProgress(smoothProgressBar.getMax());
        }
    }

    @Override // tb.lw0
    public void f(Activity activity, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "633153267")) {
            ipChange.ipc$dispatch("633153267", new Object[]{this, activity, view});
            return;
        }
        this.a = view;
        this.c = (SmoothProgressBar) view.findViewById(R$id.ptr_progress);
        this.b = (ViewGroup) view.findViewById(R$id.ptr_content);
        activity.getString(R$string.pull_to_refresh_pull_label);
        activity.getString(R$string.pull_to_refresh_refreshing_label);
        activity.getString(R$string.pull_to_refresh_release_label);
        this.e = 600L;
        this.d = activity.getResources().getColor(R$color.default_progress_bar_color);
        p(activity, view);
        i();
        h();
        o();
    }

    @Override // tb.lw0
    public boolean g() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-619905330")) {
            return ((Boolean) ipChange.ipc$dispatch("-619905330", new Object[]{this})).booleanValue();
        }
        boolean z = this.a.getVisibility() != 0;
        if (z) {
            this.a.setVisibility(0);
            AnimatorSet animatorSet = new AnimatorSet();
            ViewGroup viewGroup = this.b;
            animatorSet.playTogether(ObjectAnimator.ofFloat(viewGroup, "translationY", -viewGroup.getHeight(), 0.0f), ObjectAnimator.ofFloat(this.a, "alpha", 0.0f, 1.0f));
            animatorSet.setDuration(this.e);
            animatorSet.start();
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Drawable j(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1074448938")) {
            return (Drawable) ipChange.ipc$dispatch("-1074448938", new Object[]{this, context});
        }
        TypedArray n = n(context, 16843470, new int[]{16842964});
        try {
            return n.getDrawable(0);
        } finally {
            n.recycle();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int k(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "604575714")) {
            return ((Integer) ipChange.ipc$dispatch("604575714", new Object[]{this, context})).intValue();
        }
        TypedArray n = n(context, 16843470, new int[]{16843512});
        try {
            return n.getResourceId(0, 0);
        } finally {
            n.recycle();
        }
    }

    public View l() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1535922123") ? (View) ipChange.ipc$dispatch("1535922123", new Object[]{this}) : this.a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int m() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1006325770")) {
            return ((Integer) ipChange.ipc$dispatch("1006325770", new Object[]{this})).intValue();
        }
        return 14;
    }

    public void o() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-305177631")) {
            ipChange.ipc$dispatch("-305177631", new Object[]{this});
            return;
        }
        SmoothProgressBar smoothProgressBar = this.c;
        if (smoothProgressBar != null) {
            smoothProgressBar.setVisibility(0);
            this.c.setProgress(0);
            this.c.setIndeterminate(true);
        }
        ViewGroup viewGroup = this.b;
        if (viewGroup != null) {
            viewGroup.setVisibility(4);
        }
    }
}
