package com.google.vr.cardboard;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import tb.ht2;
import tb.wm2;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class UiLayer {
    private final Context a;
    private ImageButton b;
    private ImageButton c;
    private RelativeLayout d;
    private TransitionView e;
    private RelativeLayout f;
    private volatile Runnable k;
    private volatile String n;
    private volatile boolean g = true;
    private volatile boolean h = true;
    private volatile boolean i = true;
    private volatile Runnable j = null;
    private volatile Runnable l = null;
    private volatile boolean m = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Runnable runnable = UiLayer.this.k;
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Runnable runnable = UiLayer.this.j;
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    public UiLayer(Context context) {
        this.a = context;
        p(R$layout.ui_layer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int k(boolean z) {
        return z ? 0 : 8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TransitionView n() {
        if (this.e == null) {
            this.e = new TransitionView(this.a);
            this.e.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            this.e.setVisibility(k(this.m));
            if (this.n != null) {
                this.e.setViewerName(this.n);
            }
            if (this.l != null) {
                this.e.setTransitionListener(this.l);
            }
            this.e.setBackButtonListener(this.j);
            this.f.addView(this.e);
        }
        return this.e;
    }

    private void p(int i) {
        this.f = (RelativeLayout) LayoutInflater.from(this.a).inflate(i, (ViewGroup) null, false);
        this.k = new Runnable() { // from class: com.google.vr.cardboard.UiLayer.1
            @Override // java.lang.Runnable
            public void run() {
                ht2.b(UiLayer.this.a);
            }
        };
        ImageButton imageButton = (ImageButton) this.f.findViewById(R$id.ui_settings_button);
        this.b = imageButton;
        imageButton.setVisibility(k(this.h));
        this.b.setContentDescription("Settings");
        this.b.setOnClickListener(new a());
        ImageButton imageButton2 = (ImageButton) this.f.findViewById(R$id.ui_back_button);
        this.c = imageButton2;
        imageButton2.setVisibility(k(m()));
        this.c.setOnClickListener(new b());
        RelativeLayout relativeLayout = (RelativeLayout) this.f.findViewById(R$id.ui_alignment_marker);
        this.d = relativeLayout;
        relativeLayout.setVisibility(k(l()));
    }

    public void A(final String str) {
        this.n = str;
        wm2.a(new Runnable() { // from class: com.google.vr.cardboard.UiLayer.11
            @Override // java.lang.Runnable
            public void run() {
                if (UiLayer.this.e != null) {
                    UiLayer.this.e.setViewerName(str);
                }
            }
        });
    }

    public boolean l() {
        return this.i;
    }

    public boolean m() {
        return this.j != null;
    }

    public ViewGroup o() {
        return this.f;
    }

    public boolean q() {
        return this.g;
    }

    public void r(final boolean z) {
        this.i = z;
        wm2.a(new Runnable() { // from class: com.google.vr.cardboard.UiLayer.7
            @Override // java.lang.Runnable
            public void run() {
                UiLayer.this.d.setVisibility(UiLayer.k(z));
            }
        });
    }

    @TargetApi(23)
    public void s(final float f) {
        if (Build.VERSION.SDK_INT < 23) {
            return;
        }
        wm2.a(new Runnable() { // from class: com.google.vr.cardboard.UiLayer.8
            @Override // java.lang.Runnable
            public void run() {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) UiLayer.this.d.getLayoutParams();
                int dimension = (int) (((int) UiLayer.this.a.getResources().getDimension(R$dimen.alignment_marker_height)) * f);
                if (layoutParams.getRule(15) == -1) {
                    layoutParams.width = dimension;
                } else {
                    layoutParams.height = dimension;
                }
                UiLayer.this.d.setLayoutParams(layoutParams);
            }
        });
    }

    public void t(final Runnable runnable) {
        this.j = runnable;
        wm2.a(new Runnable() { // from class: com.google.vr.cardboard.UiLayer.6
            @Override // java.lang.Runnable
            public void run() {
                UiLayer.this.c.setVisibility(UiLayer.k(runnable != null));
                if (UiLayer.this.e != null) {
                    UiLayer.this.e.setBackButtonListener(runnable);
                }
            }
        });
    }

    public void u(final boolean z) {
        this.g = z;
        wm2.a(new Runnable() { // from class: com.google.vr.cardboard.UiLayer.4
            @Override // java.lang.Runnable
            public void run() {
                UiLayer.this.f.setVisibility(UiLayer.k(z));
            }
        });
    }

    public void v(boolean z) {
        p(z ? R$layout.ui_layer_with_portrait_support : R$layout.ui_layer);
    }

    public void w(final boolean z) {
        this.h = z;
        wm2.a(new Runnable() { // from class: com.google.vr.cardboard.UiLayer.5
            @Override // java.lang.Runnable
            public void run() {
                UiLayer.this.b.setVisibility(UiLayer.k(z));
            }
        });
    }

    public void x(Runnable runnable) {
        this.k = runnable;
    }

    public void y(final boolean z) {
        this.m = z;
        wm2.a(new Runnable() { // from class: com.google.vr.cardboard.UiLayer.9
            @Override // java.lang.Runnable
            public void run() {
                if (z || UiLayer.this.e != null) {
                    UiLayer.this.n().setVisibility(UiLayer.k(z));
                }
            }
        });
    }

    public void z(final Runnable runnable) {
        this.l = runnable;
        wm2.a(new Runnable() { // from class: com.google.vr.cardboard.UiLayer.10
            @Override // java.lang.Runnable
            public void run() {
                if (runnable == null && UiLayer.this.e == null) {
                    return;
                }
                UiLayer.this.n().setTransitionListener(runnable);
            }
        });
    }
}
