package tb;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.damai.common.crouton.LifecycleCallback;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.di2;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public final class dq {
    private static transient /* synthetic */ IpChange $ipChange;
    private final CharSequence a;
    private final di2 b;
    private final View d;
    private View.OnClickListener e;
    private Activity f;
    private ViewGroup g;
    private FrameLayout h;
    private Animation i;
    private Animation j;
    private rm c = null;
    private LifecycleCallback k = null;

    private dq(Activity activity, View view) {
        if (activity != null && view != null) {
            this.f = activity;
            this.g = null;
            this.d = view;
            this.b = new di2.b().z();
            this.a = null;
            return;
        }
        throw new IllegalArgumentException("Null parameters are not accepted");
    }

    private RelativeLayout m(Resources resources) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1143473610")) {
            return (RelativeLayout) ipChange.ipc$dispatch("-1143473610", new Object[]{this, resources});
        }
        RelativeLayout relativeLayout = new RelativeLayout(this.f);
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        di2 di2Var = this.b;
        int i = di2Var.v;
        int i2 = di2Var.w;
        if (i2 > 0) {
            i = resources.getDimensionPixelSize(i2);
        }
        relativeLayout.setPadding(i, i, i, i);
        ImageView imageView = null;
        di2 di2Var2 = this.b;
        if (di2Var2.m != null || di2Var2.n != 0) {
            imageView = p();
            relativeLayout.addView(imageView, imageView.getLayoutParams());
        }
        TextView q = q(resources);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        if (imageView != null) {
            layoutParams.addRule(1, imageView.getId());
        }
        int i3 = this.b.l;
        if ((i3 & 17) != 0) {
            layoutParams.addRule(13);
        } else if ((i3 & 16) != 0) {
            layoutParams.addRule(15);
        } else if ((i3 & 1) != 0) {
            layoutParams.addRule(14);
        }
        relativeLayout.addView(q, layoutParams);
        return relativeLayout;
    }

    private void n() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2139714410")) {
            ipChange.ipc$dispatch("-2139714410", new Object[]{this});
            return;
        }
        Resources resources = this.f.getResources();
        this.h = o(resources);
        this.h.addView(m(resources));
    }

    private FrameLayout o(Resources resources) {
        int i;
        int i2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "522767053")) {
            return (FrameLayout) ipChange.ipc$dispatch("522767053", new Object[]{this, resources});
        }
        FrameLayout frameLayout = new FrameLayout(this.f);
        View.OnClickListener onClickListener = this.e;
        if (onClickListener != null) {
            frameLayout.setOnClickListener(onClickListener);
        }
        di2 di2Var = this.b;
        int i3 = di2Var.i;
        if (i3 > 0) {
            i = resources.getDimensionPixelSize(i3);
        } else {
            i = di2Var.h;
        }
        di2 di2Var2 = this.b;
        int i4 = di2Var2.k;
        if (i4 > 0) {
            i2 = resources.getDimensionPixelSize(i4);
        } else {
            i2 = di2Var2.j;
        }
        if (i2 == 0) {
            i2 = -1;
        }
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(i2, i));
        di2 di2Var3 = this.b;
        int i5 = di2Var3.d;
        if (i5 != -1) {
            frameLayout.setBackgroundColor(i5);
        } else {
            frameLayout.setBackgroundColor(resources.getColor(di2Var3.b));
        }
        int i6 = this.b.c;
        if (i6 != 0) {
            BitmapDrawable bitmapDrawable = new BitmapDrawable(resources, BitmapFactory.decodeResource(resources, i6));
            if (this.b.e) {
                Shader.TileMode tileMode = Shader.TileMode.REPEAT;
                bitmapDrawable.setTileModeXY(tileMode, tileMode);
            }
            frameLayout.setBackgroundDrawable(bitmapDrawable);
        }
        return frameLayout;
    }

    private ImageView p() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "360378743")) {
            return (ImageView) ipChange.ipc$dispatch("360378743", new Object[]{this});
        }
        ImageView imageView = new ImageView(this.f);
        imageView.setId(256);
        imageView.setAdjustViewBounds(true);
        imageView.setScaleType(this.b.o);
        Drawable drawable = this.b.m;
        if (drawable != null) {
            imageView.setImageDrawable(drawable);
        }
        int i = this.b.n;
        if (i != 0) {
            imageView.setImageResource(i);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(9, -1);
        layoutParams.addRule(15, -1);
        imageView.setLayoutParams(layoutParams);
        return imageView;
    }

    private TextView q(Resources resources) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1635738390")) {
            return (TextView) ipChange.ipc$dispatch("1635738390", new Object[]{this, resources});
        }
        TextView textView = new TextView(this.f);
        textView.setId(257);
        di2 di2Var = this.b;
        String str = di2Var.x;
        if (str != null) {
            x(textView, str);
        } else {
            int i = di2Var.y;
            if (i != 0) {
                x(textView, resources.getString(i));
            } else {
                textView.setText(this.a);
            }
        }
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        textView.setGravity(this.b.l);
        di2 di2Var2 = this.b;
        int i2 = di2Var2.g;
        if (i2 != -1) {
            textView.setTextColor(i2);
        } else {
            int i3 = di2Var2.f;
            if (i3 != 0) {
                textView.setTextColor(resources.getColor(i3));
            }
        }
        int i4 = this.b.p;
        if (i4 != 0) {
            textView.setTextSize(2, i4);
        }
        if (this.b.q != 0) {
            r(resources, textView);
        }
        int i5 = this.b.u;
        if (i5 != 0) {
            textView.setTextAppearance(this.f, i5);
        }
        return textView;
    }

    private void r(Resources resources, TextView textView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1250256094")) {
            ipChange.ipc$dispatch("-1250256094", new Object[]{this, resources, textView});
            return;
        }
        int color = resources.getColor(this.b.q);
        di2 di2Var = this.b;
        textView.setShadowLayer(di2Var.r, di2Var.t, di2Var.s, color);
    }

    private boolean s() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1231060796")) {
            return ((Boolean) ipChange.ipc$dispatch("-1231060796", new Object[]{this})).booleanValue();
        }
        FrameLayout frameLayout = this.h;
        return (frameLayout == null || frameLayout.getParent() == null) ? false : true;
    }

    private boolean t() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "943223955")) {
            return ((Boolean) ipChange.ipc$dispatch("943223955", new Object[]{this})).booleanValue();
        }
        View view = this.d;
        return (view == null || view.getParent() == null) ? false : true;
    }

    public static dq v(Activity activity, View view) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1975565958") ? (dq) ipChange.ipc$dispatch("-1975565958", new Object[]{activity, view}) : new dq(activity, view);
    }

    private void w() {
        int makeMeasureSpec;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2045588732")) {
            ipChange.ipc$dispatch("2045588732", new Object[]{this});
            return;
        }
        View k = k();
        ViewGroup viewGroup = this.g;
        if (viewGroup != null) {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(viewGroup.getMeasuredWidth(), Integer.MIN_VALUE);
        } else {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.f.getWindow().getDecorView().getMeasuredWidth(), Integer.MIN_VALUE);
        }
        k.measure(makeMeasureSpec, View.MeasureSpec.makeMeasureSpec(0, 0));
    }

    private void x(TextView textView, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "682709978")) {
            ipChange.ipc$dispatch("682709978", new Object[]{this, textView, str});
        } else if (this.a != null) {
            SpannableString spannableString = new SpannableString(this.a);
            spannableString.setSpan(new lr2(textView.getContext(), str), 0, spannableString.length(), 33);
            textView.setText(spannableString);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1522359359")) {
            ipChange.ipc$dispatch("1522359359", new Object[]{this});
        } else {
            this.f = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "844128557")) {
            ipChange.ipc$dispatch("844128557", new Object[]{this});
        } else {
            this.k = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1469165758")) {
            ipChange.ipc$dispatch("-1469165758", new Object[]{this});
        } else {
            this.g = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Activity d() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2020778844") ? (Activity) ipChange.ipc$dispatch("-2020778844", new Object[]{this}) : this.f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public rm e() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1357797462")) {
            return (rm) ipChange.ipc$dispatch("1357797462", new Object[]{this});
        }
        if (this.c == null) {
            this.c = i().a;
        }
        return this.c;
    }

    public Animation f() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1587690466")) {
            return (Animation) ipChange.ipc$dispatch("-1587690466", new Object[]{this});
        }
        if (this.i == null && this.f != null) {
            if (e().b > 0) {
                this.i = AnimationUtils.loadAnimation(d(), e().b);
            } else {
                w();
                this.i = e50.d(k());
            }
        }
        return this.i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LifecycleCallback g() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1578736412") ? (LifecycleCallback) ipChange.ipc$dispatch("-1578736412", new Object[]{this}) : this.k;
    }

    public Animation h() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1173122727")) {
            return (Animation) ipChange.ipc$dispatch("-1173122727", new Object[]{this});
        }
        if (this.j == null && this.f != null) {
            if (e().c > 0) {
                this.j = AnimationUtils.loadAnimation(d(), e().c);
            } else {
                this.j = e50.e(k());
            }
        }
        return this.j;
    }

    di2 i() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-388291424") ? (di2) ipChange.ipc$dispatch("-388291424", new Object[]{this}) : this.b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CharSequence j() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1807357012") ? (CharSequence) ipChange.ipc$dispatch("1807357012", new Object[]{this}) : this.a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View k() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-176662288")) {
            return (View) ipChange.ipc$dispatch("-176662288", new Object[]{this});
        }
        View view = this.d;
        if (view != null) {
            return view;
        }
        if (this.h == null) {
            n();
        }
        return this.h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewGroup l() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-920527400") ? (ViewGroup) ipChange.ipc$dispatch("-920527400", new Object[]{this}) : this.g;
    }

    public String toString() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1395440917")) {
            return (String) ipChange.ipc$dispatch("-1395440917", new Object[]{this});
        }
        return "Crouton{text=" + ((Object) this.a) + ", style=" + this.b + ", configuration=" + this.c + ", customView=" + this.d + ", onClickListener=" + this.e + ", activity=" + this.f + ", viewGroup=" + this.g + ", croutonView=" + this.h + ", inAnimation=" + this.i + ", outAnimation=" + this.j + ", lifecycleCallback=" + this.k + '}';
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean u() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1383892206")) {
            return ((Boolean) ipChange.ipc$dispatch("-1383892206", new Object[]{this})).booleanValue();
        }
        if (this.f != null) {
            return s() || t();
        }
        return false;
    }

    public void y() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1076679132")) {
            ipChange.ipc$dispatch("-1076679132", new Object[]{this});
        } else {
            ad1.g().b(this);
        }
    }
}
