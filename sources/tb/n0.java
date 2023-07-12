package tb;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import cn.damai.uikit.R$anim;
import cn.damai.uikit.R$attr;
import cn.damai.uikit.R$id;
import cn.damai.uikit.R$styleable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class n0 extends cn.damai.baseview.abcpullrefresh.library.b {
    private static transient /* synthetic */ IpChange $ipChange;
    private Animation i;
    private Animation j;

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class a implements Animation.AnimationListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-209301052")) {
                ipChange.ipc$dispatch("-209301052", new Object[]{this, animation});
            } else if (animation == n0.this.j) {
                View l = n0.this.l();
                if (l != null) {
                    l.setVisibility(8);
                }
                n0.this.o();
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "492267312")) {
                ipChange.ipc$dispatch("492267312", new Object[]{this, animation});
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-779647971")) {
                ipChange.ipc$dispatch("-779647971", new Object[]{this, animation});
            }
        }
    }

    @Override // cn.damai.baseview.abcpullrefresh.library.b, tb.lw0
    public boolean a() {
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "2086918949")) {
            return ((Boolean) ipChange.ipc$dispatch("2086918949", new Object[]{this})).booleanValue();
        }
        if (Build.VERSION.SDK_INT >= super.m()) {
            return super.a();
        }
        View l = l();
        if (l != null && l.getVisibility() != 8) {
            z = true;
        }
        if (z) {
            Animation animation = this.j;
            if (animation != null) {
                l.startAnimation(animation);
            } else {
                l.setVisibility(8);
                o();
            }
        }
        return z;
    }

    @Override // cn.damai.baseview.abcpullrefresh.library.b, tb.lw0
    public void d() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1411568683")) {
            ipChange.ipc$dispatch("1411568683", new Object[]{this});
        } else if (Build.VERSION.SDK_INT >= super.m()) {
            super.d();
        } else {
            View findViewById = l().findViewById(R$id.ptr_content);
            if (findViewById != null) {
                findViewById.startAnimation(AnimationUtils.loadAnimation(findViewById.getContext(), R$anim.fade_out));
                findViewById.setVisibility(4);
            }
        }
    }

    @Override // cn.damai.baseview.abcpullrefresh.library.b, tb.lw0
    public void f(Activity activity, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-517258897")) {
            ipChange.ipc$dispatch("-517258897", new Object[]{this, activity, view});
            return;
        }
        super.f(activity, view);
        this.i = AnimationUtils.loadAnimation(activity, R$anim.fade_in);
        Animation loadAnimation = AnimationUtils.loadAnimation(activity, R$anim.fade_out);
        this.j = loadAnimation;
        if (loadAnimation == null && this.i == null) {
            return;
        }
        a aVar = new a();
        Animation animation = this.j;
        if (animation != null) {
            animation.setAnimationListener(aVar);
        }
    }

    @Override // cn.damai.baseview.abcpullrefresh.library.b, tb.lw0
    public boolean g() {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-802929334")) {
            return ((Boolean) ipChange.ipc$dispatch("-802929334", new Object[]{this})).booleanValue();
        }
        if (Build.VERSION.SDK_INT >= super.m()) {
            return super.g();
        }
        View l = l();
        z = (l == null || l.getVisibility() == 0) ? false : false;
        if (z) {
            Animation animation = this.i;
            if (animation != null) {
                l.startAnimation(animation);
            }
            l.setVisibility(0);
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.baseview.abcpullrefresh.library.b
    public Drawable j(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1246428754")) {
            return (Drawable) ipChange.ipc$dispatch("1246428754", new Object[]{this, context});
        }
        if (Build.VERSION.SDK_INT >= super.m()) {
            return super.j(context);
        }
        TypedArray n = cn.damai.baseview.abcpullrefresh.library.b.n(context, R$attr.actionBarStyle, R$styleable.ActionBar);
        try {
            return n.getDrawable(R$styleable.ActionBar_background);
        } finally {
            n.recycle();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.baseview.abcpullrefresh.library.b
    public int k(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1193963290")) {
            return ((Integer) ipChange.ipc$dispatch("-1193963290", new Object[]{this, context})).intValue();
        }
        if (Build.VERSION.SDK_INT >= super.m()) {
            return super.k(context);
        }
        TypedArray n = cn.damai.baseview.abcpullrefresh.library.b.n(context, R$attr.actionBarStyle, R$styleable.ActionBar);
        try {
            return n.getResourceId(R$styleable.ActionBar_titleTextStyle, 0);
        } finally {
            n.recycle();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.baseview.abcpullrefresh.library.b
    public int m() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1361905530")) {
            return ((Integer) ipChange.ipc$dispatch("-1361905530", new Object[]{this})).intValue();
        }
        return 7;
    }
}
