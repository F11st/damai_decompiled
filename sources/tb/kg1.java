package tb;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.widget.ImageView;
import com.alibaba.pictures.moimage.MoImageView;
import com.alibaba.pictures.moimage.R$id;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.phenix.bitmap.BitmapProcessor;
import com.taobao.phenix.bitmap.C6849b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class kg1 {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final C9357a Companion = new C9357a(null);
    private Uri a;
    private og1 b;
    private Boolean c;
    private MoImageView.SimpleRequestListener d;
    private ds1 e;
    @Nullable
    private final Context f;

    /* compiled from: Taobao */
    /* renamed from: tb.kg1$a */
    /* loaded from: classes7.dex */
    public static final class C9357a {
        private static transient /* synthetic */ IpChange $ipChange;

        private C9357a() {
        }

        @JvmStatic
        @NotNull
        public final kg1 a(@Nullable Context context) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-658151500") ? (kg1) ipChange.ipc$dispatch("-658151500", new Object[]{this, context}) : new kg1(context, null);
        }

        public /* synthetic */ C9357a(k50 k50Var) {
            this();
        }
    }

    /* compiled from: Taobao */
    /* renamed from: tb.kg1$b */
    /* loaded from: classes7.dex */
    public static final class C9358b extends ye {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ String a;

        C9358b(String str) {
            this.a = str;
        }

        @Override // tb.ye
        @NotNull
        public String b(@Nullable String str, @Nullable String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1225502225")) {
                return (String) ipChange.ipc$dispatch("-1225502225", new Object[]{this, str, str2});
            }
            return str2 + this.a;
        }

        @Override // tb.ye
        @NotNull
        public String c(@Nullable String str, @Nullable String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2044287443")) {
                return (String) ipChange.ipc$dispatch("2044287443", new Object[]{this, str, str2});
            }
            return str2 + this.a;
        }
    }

    private kg1(Context context) {
        this.f = context;
        this.c = Boolean.FALSE;
    }

    private final og1 d() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "895300316")) {
            return (og1) ipChange.ipc$dispatch("895300316", new Object[]{this});
        }
        if (this.b == null) {
            this.b = new og1();
        }
        og1 og1Var = this.b;
        b41.f(og1Var);
        return og1Var;
    }

    private final void f(Integer num, ImageView imageView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "8109860")) {
            ipChange.ipc$dispatch("8109860", new Object[]{this, num, imageView});
            return;
        }
        imageView.setImageDrawable(null);
        if (num == null || num.intValue() == 0) {
            return;
        }
        imageView.setBackgroundResource(num.intValue());
    }

    private final void h(ImageView imageView) {
        Integer i;
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "390178486")) {
            ipChange.ipc$dispatch("390178486", new Object[]{this, imageView});
            return;
        }
        lg1 lg1Var = lg1.INSTANCE;
        lg1Var.b("MoImageLoader", ":-----load image with phenix!------");
        Context context = this.f;
        if (context == null) {
            context = imageView.getContext();
        }
        if (context != null && this.a != null) {
            if ((context instanceof Activity) && ((Activity) context).isDestroyed()) {
                lg1Var.d("MoImageLoader", "context is a Activity&& this activity isDestroyed!!");
                return;
            }
            String valueOf = String.valueOf(this.a);
            jg1 jg1Var = jg1.INSTANCE;
            if (jg1Var.f(this.a) && (i = jg1Var.i(this.a)) != null && i.intValue() != 0) {
                if (jg1Var.h(context, i.intValue())) {
                    valueOf = h62.r(i.intValue());
                } else {
                    try {
                        imageView.setImageResource(i.intValue());
                        MoImageView.SimpleRequestListener simpleRequestListener = this.d;
                        if (simpleRequestListener != null) {
                            simpleRequestListener.onResourceReady(null, String.valueOf(i.intValue()), -1, -1);
                        }
                    } catch (Exception e) {
                        MoImageView.SimpleRequestListener simpleRequestListener2 = this.d;
                        if (simpleRequestListener2 != null) {
                            simpleRequestListener2.onLoadFailed(e, String.valueOf(i.intValue()));
                        }
                    }
                    lg1.INSTANCE.f("MoImageLoader", "非图片 类型的drawable资源直接走setImageResource(),return");
                    return;
                }
            }
            Uri uri = this.a;
            if (uri != null) {
                String path = uri.getPath();
                if (!(!((path == null || path.length() == 0) ? true : true))) {
                    uri = null;
                }
                if (uri != null) {
                    if (b41.d("file", uri.getScheme()) && q11.INSTANCE.g(context, uri.getPath())) {
                        valueOf = "file_q://" + uri.getPath();
                    } else {
                        String j = q11.INSTANCE.j(uri, valueOf);
                        if (j != null) {
                            valueOf = j;
                        }
                    }
                }
            }
            og1 d = d();
            f(Integer.valueOf(d.p()), imageView);
            ArrayList<BitmapProcessor> e2 = d.e();
            int size = e2.size();
            BitmapProcessor[] bitmapProcessorArr = new BitmapProcessor[size];
            e2.toArray(bitmapProcessorArr);
            og1 og1Var = this.b;
            String l = og1Var != null ? og1Var.l() : null;
            imageView.setTag(R$id.moimage_target_uri, b41.r(valueOf, l));
            wr1 v = ur1.o().v(valueOf, new C9358b(l));
            if (b41.d(this.c, Boolean.TRUE)) {
                v.P();
            }
            v.m(new yr1(imageView, d, this.d, valueOf));
            v.Q(new yr1(imageView, d, this.d, valueOf));
            v.C(new yr1(imageView, d, this.d, valueOf));
            this.e = v.h((BitmapProcessor[]) Arrays.copyOf(bitmapProcessorArr, size)).n();
            return;
        }
        lg1Var.d("MoImageLoader", "context==null||targetUri==null,please check!");
    }

    @JvmStatic
    @NotNull
    public static final kg1 q(@Nullable Context context) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-942720596") ? (kg1) ipChange.ipc$dispatch("-942720596", new Object[]{context}) : Companion.a(context);
    }

    @NotNull
    public final kg1 a(@Nullable MoImageView.SimpleRequestListener simpleRequestListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1329544110")) {
            return (kg1) ipChange.ipc$dispatch("-1329544110", new Object[]{this, simpleRequestListener});
        }
        this.d = simpleRequestListener;
        return this;
    }

    @NotNull
    public final kg1 b(@Nullable og1 og1Var) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "735740463")) {
            return (kg1) ipChange.ipc$dispatch("735740463", new Object[]{this, og1Var});
        }
        og1 og1Var2 = this.b;
        if (og1Var2 == null) {
            this.b = og1Var;
        } else if (og1Var2 != null) {
            og1Var2.u(og1Var);
        }
        return this;
    }

    public final void c() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "853470840")) {
            ipChange.ipc$dispatch("853470840", new Object[]{this});
            return;
        }
        ds1 ds1Var = this.e;
        if (ds1Var != null) {
            if (!(!ds1Var.a())) {
                ds1Var = null;
            }
            if (ds1Var != null) {
                lg1.INSTANCE.a("cancel--");
                ds1Var.cancel();
            }
        }
    }

    @NotNull
    public final kg1 e(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "652348085")) {
            return (kg1) ipChange.ipc$dispatch("652348085", new Object[]{this, Integer.valueOf(i)});
        }
        d().H(i);
        return this;
    }

    public final void g(@NotNull ImageView imageView) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "628975948")) {
            ipChange.ipc$dispatch("628975948", new Object[]{this, imageView});
            return;
        }
        b41.i(imageView, "imageView");
        og1 d = d();
        if (d.d() > 0 && d.c() > 0) {
            z = false;
        }
        if (!z) {
            d = null;
        }
        if (d != null && imageView.getLayoutParams() != null) {
            if (d.d() <= 0) {
                d.z(imageView.getLayoutParams().width);
            }
            if (d.c() <= 0) {
                d.y(imageView.getLayoutParams().height);
            }
        }
        if (mg1.INSTANCE.l()) {
            return;
        }
        h(imageView);
    }

    @NotNull
    public final kg1 i(@Nullable Uri uri) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2067425965")) {
            return (kg1) ipChange.ipc$dispatch("2067425965", new Object[]{this, uri});
        }
        this.a = uri;
        return this;
    }

    @NotNull
    public final kg1 j(@Nullable String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1768339506") ? (kg1) ipChange.ipc$dispatch("1768339506", new Object[]{this, str}) : k(str, -1, -1);
    }

    @NotNull
    public final kg1 k(@Nullable String str, int i, int i2) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1302698322") ? (kg1) ipChange.ipc$dispatch("1302698322", new Object[]{this, str, Integer.valueOf(i), Integer.valueOf(i2)}) : l(str, i, i2, null, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0062 A[Catch: Exception -> 0x005e, TRY_LEAVE, TryCatch #0 {Exception -> 0x005e, blocks: (B:13:0x0055, B:20:0x0062), top: B:24:0x0055 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0055 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @org.jetbrains.annotations.NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final tb.kg1 l(@org.jetbrains.annotations.Nullable java.lang.String r10, int r11, int r12, @org.jetbrains.annotations.Nullable com.alibaba.pictures.moimage.ImgResQuality r13, @org.jetbrains.annotations.Nullable com.alibaba.pictures.moimage.ImgResExtraInfo r14) {
        /*
            r9 = this;
            com.android.alibaba.ip.runtime.IpChange r1 = tb.kg1.$ipChange
            java.lang.String r2 = "850568697"
            boolean r3 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r1, r2)
            r7 = 1
            r8 = 0
            if (r3 == 0) goto L2e
            r3 = 6
            java.lang.Object[] r3 = new java.lang.Object[r3]
            r3[r8] = r9
            r3[r7] = r10
            r0 = 2
            java.lang.Integer r4 = java.lang.Integer.valueOf(r11)
            r3[r0] = r4
            r0 = 3
            java.lang.Integer r4 = java.lang.Integer.valueOf(r12)
            r3[r0] = r4
            r0 = 4
            r3[r0] = r13
            r0 = 5
            r3[r0] = r14
            java.lang.Object r0 = r1.ipc$dispatch(r2, r3)
            tb.kg1 r0 = (tb.kg1) r0
            return r0
        L2e:
            if (r10 == 0) goto L48
            tb.jg1 r1 = tb.jg1.INSTANCE
            boolean r2 = r1.g(r10)
            if (r2 != 0) goto L48
            java.lang.Integer r3 = java.lang.Integer.valueOf(r11)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r12)
            r2 = r10
            r5 = r13
            r6 = r14
            java.lang.String r0 = r1.b(r2, r3, r4, r5, r6)
            goto L49
        L48:
            r0 = r10
        L49:
            tb.og1 r1 = r9.d()
            r1.z(r11)
            r1.y(r12)
            if (r0 == 0) goto L60
            int r1 = r0.length()     // Catch: java.lang.Exception -> L5e
            if (r1 != 0) goto L5c
            goto L60
        L5c:
            r7 = 0
            goto L60
        L5e:
            r0 = move-exception
            goto L69
        L60:
            if (r7 != 0) goto L81
            android.net.Uri r0 = android.net.Uri.parse(r0)     // Catch: java.lang.Exception -> L5e
            r9.a = r0     // Catch: java.lang.Exception -> L5e
            goto L81
        L69:
            tb.lg1 r1 = tb.lg1.INSTANCE
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "load-"
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            java.lang.String r2 = "MoImageLoader"
            r1.b(r2, r0)
        L81:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.kg1.l(java.lang.String, int, int, com.alibaba.pictures.moimage.ImgResQuality, com.alibaba.pictures.moimage.ImgResExtraInfo):tb.kg1");
    }

    public final void m(@NotNull Bitmap bitmap, @NotNull MoImageView moImageView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1252200431")) {
            ipChange.ipc$dispatch("-1252200431", new Object[]{this, bitmap, moImageView});
            return;
        }
        b41.i(bitmap, "bm");
        b41.i(moImageView, "imageView");
        try {
            ArrayList<BitmapProcessor> e = d().e();
            String bitmap2 = bitmap.toString();
            Iterator<BitmapProcessor> it = e.iterator();
            while (it.hasNext()) {
                bitmap = it.next().process(bitmap2, C6849b.a(), bitmap);
                b41.h(bitmap, "bitmapProcessor.process(…r.getInstance(), tBitmap)");
            }
            moImageView.setImageBitmap(bitmap);
        } catch (Exception e2) {
            lg1.INSTANCE.c(e2.toString());
        }
    }

    @NotNull
    public final kg1 n(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "396474794")) {
            return (kg1) ipChange.ipc$dispatch("396474794", new Object[]{this, Integer.valueOf(i)});
        }
        d().I(i);
        return this;
    }

    public final void o() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-892432279")) {
            ipChange.ipc$dispatch("-892432279", new Object[]{this});
            return;
        }
        lg1.INSTANCE.a("reset--");
        c();
        this.a = null;
        this.b = null;
        this.c = Boolean.FALSE;
        this.d = null;
        this.e = null;
    }

    @NotNull
    public final kg1 p(@Nullable Boolean bool) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "274446032")) {
            return (kg1) ipChange.ipc$dispatch("274446032", new Object[]{this, bool});
        }
        this.c = bool;
        return this;
    }

    public /* synthetic */ kg1(Context context, k50 k50Var) {
        this(context);
    }
}
