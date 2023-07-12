package tb;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.taobao.phenix.bitmap.BitmapProcessor;
import com.taobao.phenix.intf.event.IPhenixListener;
import com.taobao.phenix.intf.event.IRetryHandlerOnFailure;
import com.taobao.phenix.request.C6865a;
import com.taobao.rxm.produce.Producer;
import com.taobao.rxm.schedule.SchedulerSupplier;
import java.lang.ref.WeakReference;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class wr1 extends d1 {
    private static int[] m;
    private final C6865a a;
    private int b;
    private Drawable c;
    private int d;
    private Drawable e;
    private WeakReference<ImageView> f;
    private IPhenixListener<nh0> g;
    private IPhenixListener<ui2> h;
    private IPhenixListener<ce1> i;
    private IPhenixListener<xr1> j;
    private IPhenixListener<gv1> k;
    private IRetryHandlerOnFailure l;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: tb.wr1$a */
    /* loaded from: classes11.dex */
    public class C9875a implements IPhenixListener<ui2> {
        C9875a() {
        }

        @Override // com.taobao.phenix.intf.event.IPhenixListener
        /* renamed from: a */
        public boolean onHappen(ui2 ui2Var) {
            ImageView imageView;
            if (wr1.this.f == null || (imageView = (ImageView) wr1.this.f.get()) == null) {
                return false;
            }
            if (ui2Var.f() != null) {
                imageView.setImageDrawable(ui2Var.f());
                return true;
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: tb.wr1$b */
    /* loaded from: classes11.dex */
    public class C9876b implements IPhenixListener<ce1> {
        C9876b() {
        }

        @Override // com.taobao.phenix.intf.event.IPhenixListener
        /* renamed from: a */
        public boolean onHappen(ce1 ce1Var) {
            ImageView imageView;
            if (wr1.this.f == null || (imageView = (ImageView) wr1.this.f.get()) == null) {
                return false;
            }
            if (wr1.this.b != 0) {
                imageView.setImageResource(wr1.this.b);
                return true;
            } else if (wr1.this.c != null) {
                imageView.setImageDrawable(wr1.this.c);
                return true;
            } else {
                return true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: tb.wr1$c */
    /* loaded from: classes11.dex */
    public class C9877c implements IPhenixListener<nh0> {
        C9877c() {
        }

        @Override // com.taobao.phenix.intf.event.IPhenixListener
        /* renamed from: a */
        public boolean onHappen(nh0 nh0Var) {
            ImageView imageView;
            if (wr1.this.f == null || (imageView = (ImageView) wr1.this.f.get()) == null) {
                return false;
            }
            if (wr1.this.d != 0) {
                imageView.setImageResource(wr1.this.d);
                return true;
            } else if (wr1.this.e != null) {
                imageView.setImageDrawable(wr1.this.e);
                return true;
            } else {
                return true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public wr1(dh1 dh1Var, String str, ye yeVar) {
        this.a = new C6865a(str, yeVar, ur1.o().isGenericTypeCheckEnabled());
        J(ur1.o().q());
        M(ur1.o().r());
    }

    private ds1 o(ImageView imageView) {
        this.f = new WeakReference<>(imageView);
        return m(new C9877c()).C(new C9876b()).Q(new C9875a()).n();
    }

    public static int[] v(Context context) {
        if (m == null) {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            m = new int[]{com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(displayMetrics), com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(displayMetrics)};
        }
        return m;
    }

    public wr1 A(View view) {
        int[] v = v(view.getContext());
        return B(view, v[0], v[1]);
    }

    public wr1 B(View view, int i, int i2) {
        ViewGroup.LayoutParams layoutParams;
        if (view != null && (layoutParams = view.getLayoutParams()) != null) {
            int i3 = layoutParams.width;
            if (i3 > 0) {
                this.a.n0(i3);
            } else if (i3 != -2) {
                this.a.n0(view.getWidth());
            }
            int i4 = layoutParams.height;
            if (i4 > 0) {
                this.a.m0(i4);
            } else if (i4 != -2) {
                this.a.m0(view.getHeight());
            }
        }
        if (this.a.J() <= 0) {
            this.a.n0(i);
        }
        if (this.a.I() <= 0) {
            this.a.m0(i2);
        }
        return this;
    }

    public wr1 C(IPhenixListener<ce1> iPhenixListener) {
        this.i = iPhenixListener;
        return this;
    }

    public wr1 D(boolean z) {
        this.a.e0(z);
        return this;
    }

    public wr1 E(int i) {
        this.a.o0(i);
        return this;
    }

    @Deprecated
    public wr1 F(boolean z) {
        return this;
    }

    public wr1 G() {
        this.a.f0(true);
        return this;
    }

    public wr1 H(int i) {
        if (i != 0) {
            if (this.c == null) {
                this.b = i;
                return this;
            }
            throw new IllegalStateException("Placeholder image already set.");
        }
        throw new IllegalArgumentException("Placeholder image resource invalid.");
    }

    public wr1 I(Drawable drawable) {
        if (this.b == 0) {
            this.c = drawable;
            return this;
        }
        throw new IllegalStateException("Placeholder image already set.");
    }

    public wr1 J(boolean z) {
        this.a.v(z, 2);
        return this;
    }

    public wr1 K(boolean z) {
        this.a.h0(z);
        return this;
    }

    public wr1 L(IRetryHandlerOnFailure iRetryHandlerOnFailure) {
        this.l = iRetryHandlerOnFailure;
        return this;
    }

    public wr1 M(boolean z) {
        this.a.v(z, 4);
        return this;
    }

    public wr1 N(int i) {
        this.a.q(i);
        return this;
    }

    public wr1 O(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.a.q0(str);
        }
        return this;
    }

    public wr1 P() {
        this.a.s0();
        return this;
    }

    public wr1 Q(IPhenixListener<ui2> iPhenixListener) {
        this.h = iPhenixListener;
        return this;
    }

    public String R() {
        return this.a.G().k();
    }

    public wr1 f(String str, String str2) {
        this.a.t(str, str2);
        return this;
    }

    public wr1 g(int i, boolean z) {
        if (i == 1 || i == 3) {
            this.a.w(i, z);
        }
        return this;
    }

    public wr1 h(BitmapProcessor... bitmapProcessorArr) {
        if (bitmapProcessorArr != null && bitmapProcessorArr.length > 0) {
            this.a.j0(bitmapProcessorArr);
        }
        return this;
    }

    public wr1 i(IPhenixListener<xr1> iPhenixListener) {
        this.j = iPhenixListener;
        return this;
    }

    public wr1 j(int i) {
        this.a.l0(i);
        return this;
    }

    public wr1 k(int i) {
        if (i != 0) {
            if (this.e == null) {
                this.d = i;
                return this;
            }
            throw new IllegalStateException("Error image already set.");
        }
        throw new IllegalArgumentException("Error image resource invalid.");
    }

    public wr1 l(Drawable drawable) {
        if (drawable != null) {
            if (this.d == 0) {
                this.e = drawable;
                return this;
            }
            throw new IllegalStateException("Error image already set.");
        }
        throw new IllegalArgumentException("Error image may not be null.");
    }

    public wr1 m(IPhenixListener<nh0> iPhenixListener) {
        this.g = iPhenixListener;
        return this;
    }

    public ds1 n() {
        String str;
        ds1 P = this.a.P();
        if (TextUtils.isEmpty(this.a.N())) {
            IPhenixListener<nh0> iPhenixListener = this.g;
            if (iPhenixListener != null) {
                iPhenixListener.onHappen(new nh0(P));
            }
            return P;
        }
        Map<String, String> H = this.a.H();
        if (H != null && (str = H.get("bundle_biz_code")) != null) {
            this.a.U().r = str;
        }
        il1 m2 = ur1.o().m();
        Producer<tq1, C6865a> producer = m2.get();
        SchedulerSupplier c = m2.c();
        producer.produceResults(new zr1(this.a, this, ur1.o().k(), c, ur1.o().j()).consumeOn(c.forUiThread()));
        return P;
    }

    public wr1 p(boolean z) {
        this.a.y(z);
        return this;
    }

    public IPhenixListener<xr1> q() {
        return this.j;
    }

    public IPhenixListener<nh0> r() {
        return this.g;
    }

    public IPhenixListener<ce1> s() {
        return this.i;
    }

    public IPhenixListener<gv1> t() {
        return this.k;
    }

    public IRetryHandlerOnFailure u() {
        return this.l;
    }

    public IPhenixListener<ui2> w() {
        return this.h;
    }

    public int x() {
        C6865a c6865a = this.a;
        if (c6865a != null) {
            return c6865a.d();
        }
        return -1;
    }

    public ds1 y(ImageView imageView) {
        return z(imageView, 1.0f);
    }

    public ds1 z(ImageView imageView, float f) {
        A(imageView);
        if (f > 1.0f) {
            C6865a c6865a = this.a;
            c6865a.n0((int) (c6865a.J() / f));
            C6865a c6865a2 = this.a;
            c6865a2.m0((int) (c6865a2.I() / f));
        }
        return o(imageView);
    }
}
