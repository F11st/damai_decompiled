package tb;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.RequiresApi;
import com.alibaba.gaiax.render.view.basic.GXView;
import com.taobao.weex.bridge.WXBridgeManager;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@RequiresApi(api = 17)
/* loaded from: classes6.dex */
public final class gq0 {
    @NotNull
    private final GXView a;
    private int b;
    private float c;
    private int d;
    private int e;
    private boolean f;
    @NotNull
    private final hq0 g;
    @Nullable
    private Bitmap h;
    @Nullable
    private Bitmap i;
    @Nullable
    private Canvas j;
    private boolean k;
    @NotNull
    private final Paint l;
    @NotNull
    private final Rect m;
    @NotNull
    private final Rect n;
    @Nullable
    private View o;
    @NotNull
    private final ViewTreeObserver.OnPreDrawListener p;

    /* compiled from: Taobao */
    /* renamed from: tb.gq0$a */
    /* loaded from: classes6.dex */
    static final class ViewTreeObserver$OnPreDrawListenerC9182a implements ViewTreeObserver.OnPreDrawListener {
        ViewTreeObserver$OnPreDrawListenerC9182a() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public final boolean onPreDraw() {
            Bitmap bitmap;
            int[] iArr = new int[2];
            View view = gq0.this.o;
            if (view != null) {
                gq0 gq0Var = gq0.this;
                if (gq0Var.a.isShown() && gq0Var.q()) {
                    view.getLocationOnScreen(iArr);
                    gq0Var.a.getLocationOnScreen(iArr);
                    int i = (-iArr[0]) + iArr[0];
                    int i2 = (-iArr[1]) + iArr[1];
                    Canvas canvas = gq0Var.j;
                    if (canvas != null && (bitmap = gq0Var.h) != null) {
                        bitmap.eraseColor(gq0Var.k() & 16777215);
                        int save = canvas.save();
                        gq0Var.u(true);
                        gq0Var.v(gq0Var.l() + 1);
                        try {
                            canvas.scale(1.0f / gq0Var.m(), 1.0f / gq0Var.m());
                            canvas.translate(-i, -i2);
                            if (view.getBackground() != null) {
                                view.getBackground().draw(canvas);
                            }
                            gq0Var.s(true);
                            view.draw(canvas);
                            gq0Var.s(false);
                        } catch (Exception unused) {
                        } catch (Throwable th) {
                            gq0Var.u(false);
                            gq0Var.v(gq0Var.l() - 1);
                            canvas.restoreToCount(save);
                            throw th;
                        }
                        gq0Var.u(false);
                        gq0Var.v(gq0Var.l() - 1);
                        canvas.restoreToCount(save);
                        gq0Var.g.a(bitmap, gq0Var.j());
                        gq0Var.a.invalidate();
                    }
                }
            }
            return true;
        }
    }

    public gq0(@NotNull GXView gXView) {
        b41.i(gXView, "host");
        this.a = gXView;
        this.b = 4;
        this.c = 25.0f;
        this.g = new hq0();
        this.l = new Paint();
        this.m = new Rect();
        this.n = new Rect();
        this.p = new ViewTreeObserver$OnPreDrawListenerC9182a();
    }

    private final void i(Canvas canvas, Bitmap bitmap) {
        this.m.right = bitmap.getWidth();
        this.m.bottom = bitmap.getHeight();
        this.n.right = this.a.getLayoutParams().width;
        this.n.bottom = this.a.getLayoutParams().height;
        this.l.setFlags(3);
        this.l.setColorFilter(new PorterDuffColorFilter(this.d, PorterDuff.Mode.SRC_ATOP));
        canvas.drawBitmap(bitmap, this.m, this.n, this.l);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean q() {
        Bitmap createBitmap;
        int i = this.a.getLayoutParams().width;
        int i2 = this.a.getLayoutParams().height;
        if ((this.c == 0.0f) || (i == 0 && i2 == 0)) {
            return false;
        }
        int i3 = this.b;
        int i4 = i / i3;
        int i5 = i2 / i3;
        if (this.h == null || this.i == null) {
            r();
            try {
                createBitmap = Bitmap.createBitmap(i4, i5, Bitmap.Config.ARGB_8888);
                this.h = createBitmap;
            } catch (OutOfMemoryError unused) {
            } finally {
                n();
            }
            if (createBitmap == null) {
                return false;
            }
            this.j = createBitmap == null ? null : new Canvas(createBitmap);
            Bitmap createBitmap2 = Bitmap.createBitmap(i4, i5, Bitmap.Config.ARGB_8888);
            this.i = createBitmap2;
            if (createBitmap2 == null) {
                return false;
            }
            this.g.b(this.a.getContext(), this.h, this.c);
        }
        os0 gxTemplateContext = this.a.getGxTemplateContext();
        if (gxTemplateContext != null) {
            if (gxTemplateContext.c() <= 0) {
                return false;
            }
            gxTemplateContext.E(gxTemplateContext.c() - 1);
        }
        return true;
    }

    private final void r() {
        this.j = null;
        Bitmap bitmap = this.h;
        if (bitmap != null) {
            bitmap.recycle();
        }
        this.h = null;
        Bitmap bitmap2 = this.i;
        if (bitmap2 != null) {
            bitmap2.recycle();
        }
        this.i = null;
    }

    public final void g(@NotNull Canvas canvas, @NotNull Function0<wt2> function0) {
        b41.i(canvas, "canvas");
        b41.i(function0, WXBridgeManager.METHOD_CALLBACK);
        if (this.f) {
            return;
        }
        Bitmap bitmap = this.i;
        if (bitmap != null) {
            i(canvas, bitmap);
        }
        function0.invoke();
    }

    public final void h(@NotNull Canvas canvas, @NotNull Function0<wt2> function0) {
        b41.i(canvas, "canvas");
        b41.i(function0, WXBridgeManager.METHOD_CALLBACK);
        if (!this.k && this.e <= 0) {
            function0.invoke();
        }
    }

    @Nullable
    public final Bitmap j() {
        return this.i;
    }

    public final int k() {
        return this.d;
    }

    public final int l() {
        return this.e;
    }

    public final int m() {
        return this.b;
    }

    public final void n() {
        r();
        this.g.c();
    }

    public final void o() {
        ViewTreeObserver viewTreeObserver;
        if (this.a.getGxBackdropFilter() != null) {
            os0 gxTemplateContext = this.a.getGxTemplateContext();
            View k = gxTemplateContext == null ? null : gxTemplateContext.k();
            this.o = k;
            if (k == null || k == null || (viewTreeObserver = k.getViewTreeObserver()) == null) {
                return;
            }
            viewTreeObserver.addOnPreDrawListener(this.p);
        }
    }

    public final void p() {
        View view;
        ViewTreeObserver viewTreeObserver;
        if (this.a.getGxBackdropFilter() == null || (view = this.o) == null || view == null || (viewTreeObserver = view.getViewTreeObserver()) == null) {
            return;
        }
        viewTreeObserver.removeOnPreDrawListener(this.p);
    }

    public final void s(boolean z) {
        this.f = z;
    }

    public final void t(float f) {
        this.c = f;
    }

    public final void u(boolean z) {
        this.k = z;
    }

    public final void v(int i) {
        this.e = i;
    }

    public final void w(int i) {
        this.b = i;
    }
}
