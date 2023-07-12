package tb;

import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AlignmentSpan;
import android.util.Log;
import com.alibaba.pictures.bricks.util.htmlparser.C3556a;
import com.alibaba.pictures.bricks.util.htmlparser.HtmlParserManager;
import com.alibaba.pictures.bricks.util.htmlparser.ParserCallback;
import com.alibaba.pictures.bricks.util.htmlparser.callback.ImageGetter;
import com.alibaba.pictures.bricks.util.htmlparser.callback.ImageGetterCallBack;
import com.alibaba.pictures.bricks.util.htmlparser.callback.SpanClickListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.util.LogUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import org.apache.commons.text.StringEscapeUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.vz0;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class o32 implements ParserCallback, ImageGetterCallBack {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final C9504a Companion = new C9504a(null);
    @NotNull
    private static final String m = "htmlParser " + o32.class.getSimpleName();
    @NotNull
    private final String a;
    @NotNull
    private final SpanClickListener b;
    @Nullable
    private SpannableStringBuilder c;
    @Nullable
    private final ImageGetter d;
    @NotNull
    private final C3556a e;
    @NotNull
    private final Stack<vz0> f;
    private int g;
    @Nullable
    private final HtmlParserManager.OnParseFinishedListener h;
    @NotNull
    private List<HtmlParserManager.C3555b> i;
    private int j;
    private boolean k;
    @Nullable
    private final List<HtmlParserManager.C3555b> l;

    /* compiled from: Taobao */
    /* renamed from: tb.o32$a */
    /* loaded from: classes7.dex */
    public static final class C9504a {
        private static transient /* synthetic */ IpChange $ipChange;

        private C9504a() {
        }

        public /* synthetic */ C9504a(k50 k50Var) {
            this();
        }

        public final void a(@NotNull String str, @NotNull ImageGetter imageGetter, @NotNull SpanClickListener spanClickListener, @Nullable HtmlParserManager.OnParseFinishedListener onParseFinishedListener) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1953392204")) {
                ipChange.ipc$dispatch("-1953392204", new Object[]{this, str, imageGetter, spanClickListener, onParseFinishedListener});
                return;
            }
            b41.i(str, "source");
            b41.i(imageGetter, "imageGetter");
            b41.i(spanClickListener, "listener");
            new o32(str, imageGetter, spanClickListener, onParseFinishedListener, null).k();
        }
    }

    private o32(String str, ImageGetter imageGetter, SpanClickListener spanClickListener, HtmlParserManager.OnParseFinishedListener onParseFinishedListener) {
        this.a = str;
        this.b = spanClickListener;
        this.d = imageGetter;
        C3556a c3556a = new C3556a();
        this.e = c3556a;
        c3556a.p(this);
        this.f = new Stack<>();
        this.g = 0;
        this.i = new ArrayList();
        this.l = new ArrayList();
        this.h = onParseFinishedListener;
        this.j = 1;
    }

    public /* synthetic */ o32(String str, ImageGetter imageGetter, SpanClickListener spanClickListener, HtmlParserManager.OnParseFinishedListener onParseFinishedListener, k50 k50Var) {
        this(str, imageGetter, spanClickListener, onParseFinishedListener);
    }

    private final void b(vz0.C9832b c9832b) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1887360231")) {
            ipChange.ipc$dispatch("1887360231", new Object[]{this, c9832b});
            return;
        }
        HtmlParserManager.C3555b c3555b = new HtmlParserManager.C3555b();
        c3555b.m(this.j);
        c3555b.h(new SpannableStringBuilder().append((CharSequence) new SpannableString(c9832b.h())));
        c3555b.g(c9832b.a());
        c3555b.n(c9832b.k());
        c3555b.k(c9832b.f());
        c3555b.j(c9832b.d());
        c3555b.i(c9832b.c());
        this.i.add(c3555b);
        if (this.k) {
            List<HtmlParserManager.C3555b> list = this.l;
            b41.f(list);
            list.add(c3555b);
        }
        this.c = new SpannableStringBuilder();
        this.g = 0;
        this.j = 1;
    }

    private final void c() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "980846790")) {
            ipChange.ipc$dispatch("980846790", new Object[]{this});
            return;
        }
        HtmlParserManager.C3555b c3555b = new HtmlParserManager.C3555b();
        c3555b.m(this.j);
        if (this.j == 1) {
            SpannableStringBuilder spannableStringBuilder = this.c;
            b41.f(spannableStringBuilder);
            int length = spannableStringBuilder.length();
            if (length > 1) {
                SpannableStringBuilder spannableStringBuilder2 = this.c;
                b41.f(spannableStringBuilder2);
                int i = length - 1;
                if (spannableStringBuilder2.charAt(i) == '\n') {
                    SpannableStringBuilder spannableStringBuilder3 = this.c;
                    b41.f(spannableStringBuilder3);
                    spannableStringBuilder3.delete(i, length);
                }
                LogUtil.d(m, "mSpannedBuilder str = " + ((Object) this.c));
            }
        }
        c3555b.h(this.c);
        this.i.add(c3555b);
        this.c = new SpannableStringBuilder();
        this.g = 0;
        this.j = 1;
    }

    private final void d(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-570239569")) {
            ipChange.ipc$dispatch("-570239569", new Object[]{this, Integer.valueOf(i)});
        } else {
            j(i, new jy1());
        }
    }

    private final void e(int i, boolean z, int i2, int i3, vz0.C9832b c9832b) {
        Layout.Alignment alignment;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1405438275")) {
            ipChange.ipc$dispatch("1405438275", new Object[]{this, Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), c9832b});
        } else if (this.g <= 0) {
        } else {
            SpannableStringBuilder spannableStringBuilder = this.c;
            b41.f(spannableStringBuilder);
            if (spannableStringBuilder.charAt(this.g - 1) != '\n') {
                SpannableStringBuilder spannableStringBuilder2 = this.c;
                b41.f(spannableStringBuilder2);
                spannableStringBuilder2.append('\n');
                this.g++;
            }
            if (z || c9832b == null) {
                return;
            }
            if (c9832b.a() == 0) {
                alignment = Layout.Alignment.ALIGN_NORMAL;
            } else if (c9832b.a() == 2) {
                alignment = Layout.Alignment.ALIGN_OPPOSITE;
            } else {
                alignment = c9832b.a() == 1 ? Layout.Alignment.ALIGN_CENTER : null;
            }
            if (alignment != null) {
                i(i3, this.g, new AlignmentSpan.Standard(alignment));
            }
        }
    }

    private final void f(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "798668106")) {
            ipChange.ipc$dispatch("798668106", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        SpannableStringBuilder spannableStringBuilder = this.c;
        b41.f(spannableStringBuilder);
        spannableStringBuilder.append(' ');
        this.g++;
        j(i, new tz0());
    }

    private final void g(int i, vz0.C9832b c9832b) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1100108691")) {
            ipChange.ipc$dispatch("1100108691", new Object[]{this, Integer.valueOf(i), c9832b});
        } else if (c9832b == null) {
        } else {
            int k = c9832b.k();
            String h = c9832b.h();
            if (k == -1) {
                if (TextUtils.isEmpty(h)) {
                    return;
                }
                this.j = 2;
                b(c9832b);
            } else if (k <= 36) {
                ImageGetter imageGetter = this.d;
                if (imageGetter != null) {
                    imageGetter.getDrawable(h, i, this.g, this);
                }
            } else if (TextUtils.isEmpty(h)) {
            } else {
                this.j = 2;
                b(c9832b);
            }
        }
    }

    private final void h(int i, vz0.C9832b c9832b) {
        Layout.Alignment alignment;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1946724960")) {
            ipChange.ipc$dispatch("-1946724960", new Object[]{this, Integer.valueOf(i), c9832b});
        } else if (c9832b == null) {
        } else {
            j(i, new ei2(c9832b));
            if (c9832b.i() == 0) {
                alignment = Layout.Alignment.ALIGN_NORMAL;
            } else if (c9832b.i() == 2) {
                alignment = Layout.Alignment.ALIGN_OPPOSITE;
            } else {
                alignment = c9832b.i() == 1 ? Layout.Alignment.ALIGN_CENTER : null;
            }
            if (alignment != null) {
                i(i, this.g, new AlignmentSpan.Standard(alignment));
            }
        }
    }

    private final void i(int i, int i2, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "598783791")) {
            ipChange.ipc$dispatch("598783791", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), obj});
        } else if (i2 <= i) {
        } else {
            SpannableStringBuilder spannableStringBuilder = this.c;
            b41.f(spannableStringBuilder);
            spannableStringBuilder.setSpan(obj, i, i2, 33);
        }
    }

    private final void j(int i, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1325539636")) {
            ipChange.ipc$dispatch("-1325539636", new Object[]{this, Integer.valueOf(i), obj});
        } else {
            i(i, this.g, obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2001984739")) {
            ipChange.ipc$dispatch("2001984739", new Object[]{this});
            return;
        }
        try {
            this.e.g(this.a);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override // com.alibaba.pictures.bricks.util.htmlparser.ParserCallback
    public void characters(@Nullable char[] cArr, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-595939927")) {
            ipChange.ipc$dispatch("-595939927", new Object[]{this, cArr, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        b41.f(cArr);
        String unescapeHtml4 = StringEscapeUtils.unescapeHtml4(new String(cArr, i, i2));
        if (TextUtils.isEmpty(unescapeHtml4)) {
            return;
        }
        SpannableStringBuilder spannableStringBuilder = this.c;
        b41.f(spannableStringBuilder);
        spannableStringBuilder.append((CharSequence) unescapeHtml4);
        this.g += unescapeHtml4.length();
    }

    @Override // com.alibaba.pictures.bricks.util.htmlparser.ParserCallback
    public void endDocument() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1711974167")) {
            ipChange.ipc$dispatch("-1711974167", new Object[]{this});
            return;
        }
        String str = m;
        Log.d(str, "end   document: " + SystemClock.elapsedRealtime());
        SpannableStringBuilder spannableStringBuilder = this.c;
        if (spannableStringBuilder != null) {
            b41.f(spannableStringBuilder);
            if (spannableStringBuilder.length() != 0) {
                c();
            }
        }
        if (this.i.size() == 0 && !TextUtils.isEmpty(this.a)) {
            HtmlParserManager.C3555b c3555b = new HtmlParserManager.C3555b();
            c3555b.m(1);
            c3555b.h(new SpannableStringBuilder(this.a));
            this.i.add(c3555b);
            this.c = new SpannableStringBuilder();
            this.g = 0;
            this.j = 1;
        }
        HtmlParserManager.OnParseFinishedListener onParseFinishedListener = this.h;
        if (onParseFinishedListener != null) {
            onParseFinishedListener.onParseFinished(this.i);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:62:? A[RETURN, SYNTHETIC] */
    @Override // com.alibaba.pictures.bricks.util.htmlparser.ParserCallback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void endElement(int r11, @org.jetbrains.annotations.Nullable java.lang.String r12) {
        /*
            Method dump skipped, instructions count: 278
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.o32.endElement(int, java.lang.String):void");
    }

    @Override // com.alibaba.pictures.bricks.util.htmlparser.callback.ImageGetterCallBack
    public void onImageReady(@Nullable String str, int i, int i2, @NotNull Drawable drawable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "402298002")) {
            ipChange.ipc$dispatch("402298002", new Object[]{this, str, Integer.valueOf(i), Integer.valueOf(i2), drawable});
            return;
        }
        b41.i(drawable, "d");
        SpannableStringBuilder spannableStringBuilder = this.c;
        b41.f(spannableStringBuilder);
        f11[] f11VarArr = (f11[]) spannableStringBuilder.getSpans(i, i2, f11.class);
        b41.h(f11VarArr, "`is`");
        for (f11 f11Var : f11VarArr) {
            SpannableStringBuilder spannableStringBuilder2 = this.c;
            b41.f(spannableStringBuilder2);
            spannableStringBuilder2.removeSpan(f11Var);
        }
        i(i, i2, new f11(str, drawable));
    }

    @Override // com.alibaba.pictures.bricks.util.htmlparser.ParserCallback
    public void startDocument(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2039282369")) {
            ipChange.ipc$dispatch("2039282369", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        String str = m;
        Log.d(str, "start document: " + SystemClock.elapsedRealtime());
        this.i = new ArrayList();
        this.c = new SpannableStringBuilder();
    }

    @Override // com.alibaba.pictures.bricks.util.htmlparser.ParserCallback
    public void startElement(@NotNull vz0 vz0Var) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2019764695")) {
            ipChange.ipc$dispatch("2019764695", new Object[]{this, vz0Var});
            return;
        }
        b41.i(vz0Var, "node");
        if (wz0.INSTANCE.a(vz0Var.d())) {
            e(0, true, vz0Var.d(), this.g, null);
        }
        int d = vz0Var.d();
        if (d != -1) {
            if (d != 72) {
                switch (d) {
                    case 14:
                        this.k = true;
                        vz0Var.f(this.g);
                        this.f.push(vz0Var);
                        return;
                    case 15:
                        SpannableStringBuilder spannableStringBuilder = this.c;
                        if (spannableStringBuilder != null) {
                            b41.f(spannableStringBuilder);
                            if (spannableStringBuilder.length() != 0) {
                                c();
                            }
                        }
                        g(this.g, vz0Var.a());
                        return;
                    case 16:
                        e(-1, false, vz0Var.d(), this.g, vz0Var.a());
                        return;
                    default:
                        vz0Var.f(this.g);
                        this.f.push(vz0Var);
                        return;
                }
            }
            f(this.g);
        }
    }
}
