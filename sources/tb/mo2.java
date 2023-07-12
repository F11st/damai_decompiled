package tb;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import androidx.core.graphics.ColorUtils;
import com.taomai.android.h5container.widget.H5ToolBar;
import com.taomai.android.h5container.widget.TitleBar;
import com.youku.media.arch.instruments.statistics.ConfigReporter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class mo2 {
    @NotNull
    public static final a Companion = new a(null);
    private final TitleBar a;
    private String b;
    private boolean c;
    private int d;
    private int e;
    private int f;
    private float g;
    private int h;
    private boolean i;
    private int j;
    private boolean k;
    private boolean l;
    @NotNull
    private final H5ToolBar m;
    @NotNull
    private final WebView n;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static final class a {
        private a() {
        }

        @TargetApi(21)
        public final void a(@Nullable Activity activity, int i) {
            if (activity == null || activity.isFinishing()) {
                return;
            }
            Window window = activity.getWindow();
            window.clearFlags(ConfigReporter.BIT_GETTER_IMP);
            window.addFlags(Integer.MIN_VALUE);
            b41.h(window, v.ATTACH_MODE_WINDOW);
            View decorView = window.getDecorView();
            b41.h(decorView, "window.decorView");
            decorView.setSystemUiVisibility(1280);
            window.setStatusBarColor(i);
        }

        public /* synthetic */ a(k50 k50Var) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static final class b implements View.OnScrollChangeListener {
        b() {
        }

        @Override // android.view.View.OnScrollChangeListener
        public final void onScrollChange(View view, int i, int i2, int i3, int i4) {
            mo2.this.h += i2 - i4;
            mo2 mo2Var = mo2.this;
            mo2Var.k(mo2Var.d, mo2.this.f, true);
            fb1.a("Kian", "delayDy " + mo2.this.h + "   alpha:" + mo2.this.g);
            TitleBar titleBar = mo2.this.a;
            b41.h(titleBar, "titleBar");
            mo2 mo2Var2 = mo2.this;
            mo2Var2.q(titleBar.getSolidColor() | (-16777216), mo2Var2.e, true);
        }
    }

    public mo2(@NotNull H5ToolBar h5ToolBar, @NotNull WebView webView) {
        b41.i(h5ToolBar, "toolBar");
        b41.i(webView, "webView");
        this.m = h5ToolBar;
        this.n = webView;
        this.a = h5ToolBar.getTitleBar();
        this.f = 1;
        this.j = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k(int i, int i2, boolean z) {
        float abs;
        int scrollY = z ? this.h : this.n.getScrollY();
        if (Math.abs(scrollY) >= i) {
            abs = scrollY <= 0 ? 0.0f : 1.0f;
        } else {
            abs = Math.abs(scrollY / i2) / 255.0f;
        }
        this.g = abs;
    }

    private final void l() {
        this.a.setBackgroundColor(0);
        Drawable background = this.m.getBackground();
        b41.h(background, "toolBar.background");
        background.setAlpha((int) (this.g * 255.0f));
        if (this.g <= 0.2d) {
            this.a.setLineVisable(false);
        } else {
            this.a.setLineVisable(true);
        }
        if (this.i) {
            TitleBar titleBar = this.a;
            b41.h(titleBar, "titleBar");
            titleBar.getTitleTextView().setTextColor(ColorUtils.setAlphaComponent(0, (int) (255 * this.g)));
        }
    }

    private final void m() {
        ViewParent parent = this.n.getParent();
        ViewParent parent2 = parent != null ? parent.getParent() : null;
        if (!(parent2 instanceof ViewGroup)) {
            parent2 = null;
        }
        ViewGroup viewGroup = (ViewGroup) parent2;
        ViewGroup.LayoutParams layoutParams = viewGroup != null ? viewGroup.getLayoutParams() : null;
        if (!(layoutParams instanceof RelativeLayout.LayoutParams)) {
            layoutParams = null;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        if (layoutParams2 == null) {
            layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        }
        if (this.c) {
            layoutParams2.removeRule(3);
            layoutParams2.addRule(6);
        } else {
            layoutParams2.addRule(3, this.m.getId());
        }
        ViewParent parent3 = this.n.getParent();
        ViewParent parent4 = parent3 != null ? parent3.getParent() : null;
        ViewGroup viewGroup2 = parent4 instanceof ViewGroup ? parent4 : null;
        if (viewGroup2 != null) {
            viewGroup2.setLayoutParams(layoutParams2);
        }
    }

    private final void o() {
        TitleBar titleBar = this.a;
        b41.h(titleBar, "titleBar");
        titleBar.getLeftButtonView().setTextColor(-16777216);
        TitleBar titleBar2 = this.a;
        b41.h(titleBar2, "titleBar");
        titleBar2.getRightButtonView().setTextColor(-16777216);
        TitleBar titleBar3 = this.a;
        b41.h(titleBar3, "titleBar");
        titleBar3.getRight2ButtonView().setTextColor(-16777216);
    }

    private final void p() {
        TitleBar titleBar = this.a;
        b41.h(titleBar, "titleBar");
        titleBar.getLeftButtonView().setTextColor(-1);
        TitleBar titleBar2 = this.a;
        b41.h(titleBar2, "titleBar");
        titleBar2.getRightButtonView().setTextColor(-1);
        TitleBar titleBar3 = this.a;
        b41.h(titleBar3, "titleBar");
        titleBar3.getRight2ButtonView().setTextColor(-1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q(int i, int i2, boolean z) {
        if (Math.abs(z ? this.h : this.n.getScrollY()) >= i2) {
            if (this.j == -1) {
                t("default");
            } else {
                t("light");
            }
            if (!this.l) {
                s("default");
            }
        } else {
            r();
        }
        l();
    }

    private final void r() {
        if (this.l && this.j == -1) {
            t("default");
        } else {
            t("light");
        }
        if (this.l) {
            return;
        }
        s("light");
    }

    private final void s(String str) {
        int hashCode = str.hashCode();
        if (hashCode != 102970646) {
            if (hashCode == 1544803905 && str.equals("default")) {
                this.a.setTitleColor(TitleBar.DEFAULT_COLOR_MAIN_TITLE_TEXT);
            }
        } else if (str.equals("light")) {
            this.a.setTitleColor(TitleBar.DEFAULT_COLOR_OVERLAY_TITLE_TEXT);
        }
    }

    private final void t(String str) {
        int hashCode = str.hashCode();
        if (hashCode != 102970646) {
            if (hashCode == 1544803905 && str.equals("default")) {
                o();
            }
        } else if (str.equals("light")) {
            p();
        }
    }

    private final void u(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        l();
        if (!TextUtils.equals(str, "auto") || Build.VERSION.SDK_INT < 23) {
            return;
        }
        this.n.setOnScrollChangeListener(new b());
    }

    public final void j(@Nullable String str) {
        boolean q;
        if (this.m.getVisibility() != 0) {
            return;
        }
        H5ToolBar h5ToolBar = this.m;
        dv0 dv0Var = dv0.INSTANCE;
        h5ToolBar.setPreventTouch(!b41.d(dv0Var.b(this.n.getUrl(), "titlePenetrate"), "YES"));
        this.c = false;
        if (str == null) {
            str = dv0Var.b(this.n.getUrl(), "transparentTitle");
        }
        this.b = str;
        if (!(str == null || str.length() == 0)) {
            this.c = b41.d("always", this.b) || b41.d("auto", this.b);
        }
        if (this.c) {
            if (b41.d(this.b, "auto")) {
                String b2 = dv0Var.b(this.n.getUrl(), "scrollDistance");
                int parseInt = b2 != null ? Integer.parseInt(b2) : 255;
                this.d = parseInt;
                int i = parseInt / 255;
                if (i == 0) {
                    i = 1;
                }
                this.f = i;
                this.e = (parseInt * 3) / 4;
                k(parseInt, i, false);
                q(-1, this.e, false);
                this.h = this.n.getScrollY();
                q = kotlin.text.o.q("YES", dv0Var.b(this.n.getUrl(), "transparentTitleTextAuto"), true);
                this.i = q;
            } else {
                this.g = 0.0f;
                this.i = false;
                if (!this.k) {
                    t("default");
                    s("default");
                }
            }
            u(this.b);
        } else {
            this.g = 1.0f;
            l();
            this.i = false;
            if (Build.VERSION.SDK_INT >= 23) {
                this.n.setOnScrollChangeListener(null);
            }
            t("default");
            s("default");
        }
        m();
    }

    public final void n(@Nullable String str) {
        this.k = true;
        j(str);
    }
}
