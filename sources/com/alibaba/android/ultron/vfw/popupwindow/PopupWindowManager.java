package com.alibaba.android.ultron.vfw.popupwindow;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import androidx.annotation.ColorInt;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.android.ultron.vfw.R$id;
import com.alibaba.android.ultron.vfw.R$layout;
import com.alibaba.android.ultron.vfw.adapter.RecyclerViewAdapter;
import com.alibaba.android.ultron.vfw.viewholder.RecyclerViewHolder;
import com.taobao.android.ultron.common.model.IDMComponent;
import java.util.List;
import tb.ay2;
import tb.cy2;
import tb.h30;
import tb.ny2;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class PopupWindowManager {
    private static float s = 0.6f;
    private h30 a;
    private PopupWindow b;
    private ay2 c;
    private FrameLayout d;
    private LinearLayout e;
    private RecyclerView f;
    private LinearLayout g;
    private ImageView h;
    private RecyclerViewAdapter i;
    private View j;
    private AlphaAnimation k;
    private AlphaAnimation l;
    private TranslateAnimation m;
    private TranslateAnimation n;
    private RelativeLayout o;
    private OnCancelListener p;
    private PopupRecyclerViewLayoutManager q;
    private boolean r = false;

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public interface OnCancelListener {
        void onCancel();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.alibaba.android.ultron.vfw.popupwindow.PopupWindowManager$a  reason: invalid class name */
    /* loaded from: classes15.dex */
    public class animationAnimation$AnimationListenerC3261a implements Animation.AnimationListener {
        animationAnimation$AnimationListenerC3261a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            PopupWindowManager.this.b.dismiss();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.alibaba.android.ultron.vfw.popupwindow.PopupWindowManager$b */
    /* loaded from: classes15.dex */
    public class View$OnClickListenerC3262b implements View.OnClickListener {
        View$OnClickListenerC3262b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PopupWindowManager.this.j.setEnabled(false);
            PopupWindowManager.this.g(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.alibaba.android.ultron.vfw.popupwindow.PopupWindowManager$c */
    /* loaded from: classes15.dex */
    public class View$OnKeyListenerC3263c implements View.OnKeyListener {
        View$OnKeyListenerC3263c() {
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            if (i == 4 && PopupWindowManager.this.b.isShowing() && !PopupWindowManager.this.l.hasStarted()) {
                PopupWindowManager.this.g(false);
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.alibaba.android.ultron.vfw.popupwindow.PopupWindowManager$d */
    /* loaded from: classes15.dex */
    public class View$OnClickListenerC3264d implements View.OnClickListener {
        View$OnClickListenerC3264d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PopupWindowManager.this.g(false);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.android.ultron.vfw.popupwindow.PopupWindowManager$e */
    /* loaded from: classes15.dex */
    public static class C3265e {
        public static final String KEY_BOTTOM_RADIUS = "popupWindowBottomRadius";
        public static final String KEY_TOP_RADIUS = "popupWindowTopRadius";
        private float a;
        private int c;
        private Drawable e;
        private float f;
        private float g;
        private int b = 0;
        private int d = 0;

        public void h(Drawable drawable) {
            this.e = drawable;
        }

        public void i(int i) {
            this.c = i;
        }

        public void j(@ColorInt int i) {
            this.d = i;
        }

        public void k(float f, float f2) {
            this.f = f;
            this.g = f2;
        }

        public void l(float f) {
            this.a = f;
        }
    }

    public PopupWindowManager(ay2 ay2Var) {
        this.c = ay2Var;
        i();
        f();
        h();
    }

    private void f() {
        this.j.setOnClickListener(new View$OnClickListenerC3262b());
        this.d.setOnKeyListener(new View$OnKeyListenerC3263c());
    }

    private void h() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        this.k = alphaAnimation;
        alphaAnimation.setDuration(200L);
        AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
        this.l = alphaAnimation2;
        alphaAnimation2.setDuration(200L);
        this.l.setAnimationListener(new animationAnimation$AnimationListenerC3261a());
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
        this.m = translateAnimation;
        translateAnimation.setDuration(200L);
        TranslateAnimation translateAnimation2 = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, 1.0f);
        this.n = translateAnimation2;
        translateAnimation2.setDuration(200L);
    }

    private void i() {
        this.d = new FrameLayout(this.c.l());
        View view = new View(this.c.l());
        this.j = view;
        view.setBackgroundColor(Color.parseColor("#7F000000"));
        this.d.addView(this.j);
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.c.l()).inflate(R$layout.ultron_popop_window, (ViewGroup) this.d, false);
        this.o = relativeLayout;
        relativeLayout.setClickable(true);
        this.e = (LinearLayout) this.o.findViewById(R$id.ultron_popup_header_view);
        this.f = (RecyclerView) this.o.findViewById(R$id.ultron_popup_recycler_view);
        this.g = (LinearLayout) this.o.findViewById(R$id.ultron_popup_footer_view);
        this.h = (ImageView) this.o.findViewById(R$id.ultron_popup_close_button);
        this.d.addView(this.o, new FrameLayout.LayoutParams(-1, (int) (ny2.c(this.c.l()) * s), 80));
        this.d.setFocusable(true);
        this.d.setFocusableInTouchMode(true);
        this.i = new RecyclerViewAdapter(this.c);
        PopupRecyclerViewLayoutManager popupRecyclerViewLayoutManager = new PopupRecyclerViewLayoutManager(this.c.l());
        this.q = popupRecyclerViewLayoutManager;
        popupRecyclerViewLayoutManager.setOrientation(1);
        this.f.setLayoutManager(this.q);
        this.f.setAdapter(this.i);
    }

    private void k() {
        List<IDMComponent> a = this.a.a();
        if (a != null && a.size() <= 1) {
            this.q.a(false);
        } else {
            this.q.a(true);
        }
        this.i.setData(a);
        this.i.notifyDataSetChanged();
    }

    private void l() {
        LinearLayout linearLayout = this.g;
        if (linearLayout != null) {
            if (linearLayout.getChildCount() > 0) {
                this.g.removeAllViews();
            }
            List<IDMComponent> c = this.a.c();
            cy2 cy2Var = (cy2) this.c.getService(cy2.class);
            if (c == null || c.size() <= 0) {
                return;
            }
            for (IDMComponent iDMComponent : c) {
                RecyclerViewHolder c2 = cy2Var.c(this.g, cy2Var.f(iDMComponent));
                View view = c2.itemView;
                if (view != null) {
                    this.g.addView(view);
                }
                cy2Var.b(c2, iDMComponent);
            }
        }
    }

    private void m() {
        LinearLayout linearLayout = this.e;
        if (linearLayout != null) {
            if (linearLayout.getChildCount() > 0) {
                this.e.removeAllViews();
            }
            cy2 cy2Var = (cy2) this.c.getService(cy2.class);
            List<IDMComponent> d = this.a.d();
            if (d == null || d.size() <= 0) {
                return;
            }
            for (IDMComponent iDMComponent : d) {
                RecyclerViewHolder c = cy2Var.c(this.e, cy2Var.f(iDMComponent));
                View view = c.itemView;
                if (view != null) {
                    this.e.addView(view);
                }
                cy2Var.b(c, iDMComponent);
            }
        }
    }

    public void g(boolean z) {
        this.r = z;
        this.j.startAnimation(this.l);
        this.o.startAnimation(this.n);
    }

    public boolean j() {
        PopupWindow popupWindow = this.b;
        return popupWindow != null && popupWindow.isShowing();
    }

    public void n() {
        this.i.notifyDataSetChanged();
    }

    public void o(h30 h30Var) {
        this.a = h30Var;
    }

    public void p(OnCancelListener onCancelListener) {
        this.p = onCancelListener;
    }

    public void q(C3265e c3265e) {
        if (this.b == null) {
            PopupWindow popupWindow = new PopupWindow(this.c.l());
            this.b = popupWindow;
            popupWindow.setBackgroundDrawable(new ColorDrawable(0));
            this.b.setWidth(-1);
            this.b.setHeight(-1);
            this.b.setSoftInputMode(16);
            this.b.setOutsideTouchable(true);
            this.b.setFocusable(true);
        }
        if (c3265e != null) {
            if (c3265e.b < 0) {
                this.j.setBackgroundColor(c3265e.b);
            }
            if (c3265e.a > 0.0f && c3265e.a != s) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.o.getLayoutParams();
                layoutParams.height = (int) (ny2.c(this.c.l()) * c3265e.a);
                this.o.setLayoutParams(layoutParams);
            }
            if (c3265e.e != null) {
                this.h.setVisibility(0);
                this.h.setContentDescription("关闭");
                this.h.setImageDrawable(c3265e.e);
                this.h.setOnClickListener(new View$OnClickListenerC3264d());
            } else {
                this.h.setVisibility(8);
            }
            if (c3265e.d < 0) {
                this.o.setBackgroundDrawable(ny2.b(c3265e.d, c3265e.f, c3265e.g));
            }
        }
        this.j.setEnabled(true);
        this.b.setContentView(this.d);
        this.b.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.alibaba.android.ultron.vfw.popupwindow.PopupWindowManager.5
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (PopupWindowManager.this.p == null || PopupWindowManager.this.r) {
                    return;
                }
                PopupWindowManager.this.p.onCancel();
            }
        });
        m();
        k();
        l();
        this.j.startAnimation(this.k);
        this.o.startAnimation(this.m);
        this.b.showAtLocation(this.d, c3265e.c, 0, 0);
    }
}
