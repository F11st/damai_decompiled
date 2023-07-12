package com.alibaba.pictures.bricks.util.htmlparser;

import android.content.Context;
import android.text.Spanned;
import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import io.flutter.wpkbridge.WPKFactory;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.a01;
import tb.b41;
import tb.k50;
import tb.tm;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class HtmlParserManager {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final C3554a Companion = new C3554a(null);
    private final int a;
    private final float b;
    private final int c;
    private final int d;
    private final int e;
    private final int f;

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public interface OnParseFinishedListener {
        void onParseFinished(@Nullable List<C3555b> list);
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public interface OnSpanClickListener {
        void onSpanClick(int i, @NotNull String str);
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.pictures.bricks.util.htmlparser.HtmlParserManager$a */
    /* loaded from: classes7.dex */
    public static final class C3554a {
        private static transient /* synthetic */ IpChange $ipChange;

        private C3554a() {
        }

        public /* synthetic */ C3554a(k50 k50Var) {
            this();
        }

        @NotNull
        public final HtmlParserManager a(int i, float f, int i2, int i3, int i4, int i5) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1272859526") ? (HtmlParserManager) ipChange.ipc$dispatch("-1272859526", new Object[]{this, Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) : new HtmlParserManager(i, f, i3, i2, i4, i5, null);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.pictures.bricks.util.htmlparser.HtmlParserManager$b */
    /* loaded from: classes7.dex */
    public static final class C3555b {
        private static transient /* synthetic */ IpChange $ipChange;
        private int a;
        @Nullable
        private Spanned b;
        private int c;
        private int d;
        private int e;
        private int f;
        @Nullable
        private String g;
        private int h;

        @Nullable
        public final Spanned a() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "2090223074") ? (Spanned) ipChange.ipc$dispatch("2090223074", new Object[]{this}) : this.b;
        }

        public final int b() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1554090097") ? ((Integer) ipChange.ipc$dispatch("-1554090097", new Object[]{this})).intValue() : this.f;
        }

        public final int c() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1662324876") ? ((Integer) ipChange.ipc$dispatch("-1662324876", new Object[]{this})).intValue() : this.e;
        }

        @Nullable
        public final String d() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1336413564") ? (String) ipChange.ipc$dispatch("1336413564", new Object[]{this}) : this.g;
        }

        public final int e() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "384963160") ? ((Integer) ipChange.ipc$dispatch("384963160", new Object[]{this})).intValue() : this.h;
        }

        public final int f() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "73950504") ? ((Integer) ipChange.ipc$dispatch("73950504", new Object[]{this})).intValue() : this.a;
        }

        public final void g(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "900466657")) {
                ipChange.ipc$dispatch("900466657", new Object[]{this, Integer.valueOf(i)});
            }
        }

        public final void h(@Nullable Spanned spanned) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1474754460")) {
                ipChange.ipc$dispatch("1474754460", new Object[]{this, spanned});
            } else {
                this.b = spanned;
            }
        }

        public final void i(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-12089253")) {
                ipChange.ipc$dispatch("-12089253", new Object[]{this, Integer.valueOf(i)});
            } else {
                this.f = i;
            }
        }

        public final void j(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-932586578")) {
                ipChange.ipc$dispatch("-932586578", new Object[]{this, Integer.valueOf(i)});
            } else {
                this.e = i;
            }
        }

        public final void k(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "433806439")) {
                ipChange.ipc$dispatch("433806439", new Object[]{this, Integer.valueOf(i)});
            } else {
                this.d = i;
            }
        }

        public final void l(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1572217010")) {
                ipChange.ipc$dispatch("1572217010", new Object[]{this, Integer.valueOf(i)});
            } else {
                this.h = i;
            }
        }

        public final void m(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2091051654")) {
                ipChange.ipc$dispatch("-2091051654", new Object[]{this, Integer.valueOf(i)});
            } else {
                this.a = i;
            }
        }

        public final void n(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-918202846")) {
                ipChange.ipc$dispatch("-918202846", new Object[]{this, Integer.valueOf(i)});
            } else {
                this.c = i;
            }
        }

        @NotNull
        public String toString() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1957042599")) {
                return (String) ipChange.ipc$dispatch("1957042599", new Object[]{this});
            }
            String str = ", content:" + ((CharSequence) this.b) + ", width:" + this.c + ", height:" + this.d + ", damaiWidth:" + this.e + ", damaiHeight:" + this.f + "}";
            b41.h(str, "StringBuilder()\n        …  .append(\"}\").toString()");
            return str;
        }
    }

    private HtmlParserManager(int i, float f, int i2, int i3, int i4, int i5) {
        this.a = i;
        this.b = f;
        this.c = i2;
        this.d = i3;
        this.e = i4;
        this.f = i5;
    }

    public /* synthetic */ HtmlParserManager(int i, float f, int i2, int i3, int i4, int i5, k50 k50Var) {
        this(i, f, i2, i3, i4, i5);
    }

    private final void a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-315271360")) {
            ipChange.ipc$dispatch("-315271360", new Object[]{this});
            return;
        }
        tm a = tm.Companion.a();
        a.i(this.c);
        a.h(this.d);
        a.e(this.e);
        a.d(this.f);
        a.g(this.b);
        a.f(this.a);
    }

    public final void b(@NotNull Context context, @NotNull String str, @NotNull OnSpanClickListener onSpanClickListener, @NotNull OnParseFinishedListener onParseFinishedListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "285463531")) {
            ipChange.ipc$dispatch("285463531", new Object[]{this, context, str, onSpanClickListener, onParseFinishedListener});
            return;
        }
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        b41.i(str, "content");
        b41.i(onSpanClickListener, "onSpanClickListener");
        b41.i(onParseFinishedListener, "onParseFinishedListener");
        if (TextUtils.isEmpty(str)) {
            return;
        }
        a();
        a01.Companion.b(str).c(context, onSpanClickListener, onParseFinishedListener);
    }
}
