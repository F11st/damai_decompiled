package tb;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import androidx.core.graphics.ColorUtils;
import com.taomai.android.h5container.webview.TaoMaiUCWebView;
import com.taomai.android.h5container.widget.H5ToolBar;
import com.taomai.android.h5container.widget.TitleBar;
import kotlin.text.C8604o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class eq2 {
    @NotNull
    public static final C9108a Companion = new C9108a(null);
    private final TitleBar a;
    private String b;
    private boolean c;
    private int d;
    private int e;
    private int f;
    private float g;
    private int h;
    private int i;
    private boolean j;
    private boolean k;
    private final H5ToolBar l;
    @NotNull
    private final TaoMaiUCWebView m;

    /* compiled from: Taobao */
    /* renamed from: tb.eq2$a */
    /* loaded from: classes11.dex */
    public static final class C9108a {
        private C9108a() {
        }

        public /* synthetic */ C9108a(k50 k50Var) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: tb.eq2$b */
    /* loaded from: classes11.dex */
    public static final class View$OnScrollChangeListenerC9109b implements View.OnScrollChangeListener {
        View$OnScrollChangeListenerC9109b() {
        }

        @Override // android.view.View.OnScrollChangeListener
        public final void onScrollChange(View view, int i, int i2, int i3, int i4) {
            eq2.this.h += i2 - i4;
            eq2 eq2Var = eq2.this;
            eq2Var.k(eq2Var.d, eq2.this.f, true);
            fb1.a("Kian", "delayDy " + eq2.this.h + "   alpha:" + eq2.this.g);
            TitleBar titleBar = eq2.this.a;
            b41.h(titleBar, "titleBar");
            eq2 eq2Var2 = eq2.this;
            eq2Var2.q(titleBar.getSolidColor() | (-16777216), eq2Var2.e, true);
        }
    }

    public eq2(@NotNull H5ToolBar h5ToolBar, @NotNull TaoMaiUCWebView taoMaiUCWebView) {
        b41.i(h5ToolBar, "toolBar");
        b41.i(taoMaiUCWebView, "webView");
        this.l = h5ToolBar;
        this.m = taoMaiUCWebView;
        this.a = h5ToolBar.getTitleBar();
        this.f = 1;
        this.i = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k(int i, int i2, boolean z) {
        float abs;
        int realScrollY = z ? this.h : this.m.realScrollY();
        if (Math.abs(realScrollY) >= i) {
            abs = realScrollY <= 0 ? 0.0f : 1.0f;
        } else {
            abs = Math.abs(realScrollY / i2) / 255.0f;
        }
        this.g = abs;
    }

    private final void l() {
        this.a.setBackgroundColor(0);
        Drawable background = this.l.getBackground();
        b41.h(background, "toolBar.background");
        background.setAlpha((int) (this.g * 255.0f));
        if (this.g <= 0.2d) {
            this.a.setLineVisable(false);
        } else {
            this.a.setLineVisable(true);
        }
        TitleBar titleBar = this.a;
        b41.h(titleBar, "titleBar");
        titleBar.getTitleTextView().setTextColor(ColorUtils.setAlphaComponent(0, (int) (255 * this.g)));
    }

    private final void m() {
        ViewParent parent = this.m.getParent();
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
            layoutParams2.addRule(3, this.l.getId());
        }
        ViewParent parent3 = this.m.getParent();
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
        if (Math.abs(z ? this.h : this.m.realScrollY()) >= i2) {
            if (this.i == -1) {
                t("default");
            } else {
                t("light");
            }
            if (!this.k) {
                s("default");
            }
        } else {
            r();
        }
        l();
    }

    private final void r() {
        if (this.k && this.i == -1) {
            t("default");
        } else {
            t("light");
        }
        if (this.k) {
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
        this.m.setOnScrollChangeListener(new View$OnScrollChangeListenerC9109b());
    }

    public final void j(@Nullable String str) {
        if (this.l.getVisibility() != 0) {
            return;
        }
        H5ToolBar h5ToolBar = this.l;
        dv0 dv0Var = dv0.INSTANCE;
        h5ToolBar.setPreventTouch(!b41.d(dv0Var.b(this.m.getUrl(), "titlePenetrate"), "YES"));
        this.c = false;
        if (str == null) {
            str = dv0Var.b(this.m.getUrl(), "transparentTitle");
        }
        this.b = str;
        if (!(str == null || str.length() == 0)) {
            this.c = b41.d("always", this.b) || b41.d("auto", this.b);
        }
        if (this.c) {
            if (b41.d(this.b, "auto")) {
                String b = dv0Var.b(this.m.getUrl(), "scrollDistance");
                int parseInt = b != null ? Integer.parseInt(b) : 255;
                this.d = parseInt;
                int i = parseInt / 255;
                if (i == 0) {
                    i = 1;
                }
                this.f = i;
                this.e = (parseInt * 3) / 4;
                k(parseInt, i, false);
                q(-1, this.e, false);
                this.h = this.m.realScrollY();
                C8604o.q("YES", dv0Var.b(this.m.getUrl(), "transparentTitleTextAuto"), true);
            } else {
                this.g = 0.0f;
                if (!this.j) {
                    t("default");
                    s("default");
                }
            }
            u(this.b);
        } else {
            this.g = 1.0f;
            l();
            if (Build.VERSION.SDK_INT >= 23) {
                this.m.setOnScrollChangeListener(null);
            }
            t("default");
            s("default");
        }
        m();
    }

    public final void n(@Nullable String str) {
        this.j = true;
        j(str);
    }
}
