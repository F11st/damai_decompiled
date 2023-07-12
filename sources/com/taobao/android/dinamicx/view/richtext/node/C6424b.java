package com.taobao.android.dinamicx.view.richtext.node;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.os.Build;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.taobao.android.dinamicx.view.richtext.ClickSpanDelegate;
import com.taobao.android.dinamicx.view.richtext.LongClickSpanDelegate;
import com.taobao.android.dinamicx.view.richtext.node.RichTextNode;
import com.taobao.android.dinamicx.view.richtext.span.CloneableLongClickSpan;
import com.taobao.android.dinamicx.view.richtext.span.CloneableNoStyleClickSpan;
import com.taobao.android.dinamicx.view.richtext.span.CloneableShadowSpan;
import com.taobao.android.dinamicx.view.richtext.span.CloneableUnderlineSpan;
import java.util.LinkedList;
import java.util.List;
import tb.bp0;

/* compiled from: Taobao */
/* renamed from: com.taobao.android.dinamicx.view.richtext.node.b */
/* loaded from: classes11.dex */
public class C6424b implements RichTextNode {
    public static final int NONE_STRIKE_THROUGH = 0;
    public static final int NONE_UNDERLINE = 0;
    private CloneableNoStyleClickSpan A;
    private CloneableLongClickSpan B;
    private CloneableNoStyleClickSpan C;
    private CloneableLongClickSpan D;
    private String a;
    private int b;
    private Integer c;
    private boolean d;
    private boolean e;
    private String f;
    private AssetManager g;
    private Integer h;
    private Integer i;
    private int j;
    private int k;
    private int l;
    private int m;
    private int n;
    private int o;
    private String p;
    private String q;
    private RichTextNode.OnLinkTapListener r;
    private RichTextNode.OnLongPressListener s;
    private RichTextNode.OnTapListener t;
    private RichTextNode.OnLongTapListener u;
    private float v;
    private float w;
    private Integer x;
    private float y;
    private List<Object> z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.dinamicx.view.richtext.node.b$a */
    /* loaded from: classes11.dex */
    public class C6425a implements ClickSpanDelegate {
        C6425a() {
        }

        @Override // com.taobao.android.dinamicx.view.richtext.ClickSpanDelegate
        public void onClick(@NonNull View view) {
            C6424b.this.r.onLinkTap(C6424b.this.p);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.dinamicx.view.richtext.node.b$b */
    /* loaded from: classes11.dex */
    public class C6426b implements LongClickSpanDelegate {
        C6426b() {
        }

        @Override // com.taobao.android.dinamicx.view.richtext.LongClickSpanDelegate
        public boolean onLongClick(@NonNull View view) {
            return C6424b.this.s.onLongPress(C6424b.this.q);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.dinamicx.view.richtext.node.b$c */
    /* loaded from: classes11.dex */
    public class C6427c implements ClickSpanDelegate {
        C6427c() {
        }

        @Override // com.taobao.android.dinamicx.view.richtext.ClickSpanDelegate
        public void onClick(@NonNull View view) {
            C6424b.this.t.onTap();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.dinamicx.view.richtext.node.b$d */
    /* loaded from: classes11.dex */
    public class C6428d implements LongClickSpanDelegate {
        C6428d() {
        }

        @Override // com.taobao.android.dinamicx.view.richtext.LongClickSpanDelegate
        public boolean onLongClick(@NonNull View view) {
            C6424b.this.u.onLongTap();
            return true;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.dinamicx.view.richtext.node.b$e */
    /* loaded from: classes11.dex */
    class C6429e implements ClickSpanDelegate {
        C6429e() {
        }

        @Override // com.taobao.android.dinamicx.view.richtext.ClickSpanDelegate
        public void onClick(@NonNull View view) {
            C6424b.this.t.onTap();
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.dinamicx.view.richtext.node.b$f */
    /* loaded from: classes11.dex */
    class C6430f implements LongClickSpanDelegate {
        C6430f() {
        }

        @Override // com.taobao.android.dinamicx.view.richtext.LongClickSpanDelegate
        public boolean onLongClick(@NonNull View view) {
            C6424b.this.u.onLongTap();
            return true;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.dinamicx.view.richtext.node.b$g */
    /* loaded from: classes11.dex */
    class C6431g implements ClickSpanDelegate {
        C6431g() {
        }

        @Override // com.taobao.android.dinamicx.view.richtext.ClickSpanDelegate
        public void onClick(@NonNull View view) {
            C6424b.this.r.onLinkTap(C6424b.this.p);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.dinamicx.view.richtext.node.b$h */
    /* loaded from: classes11.dex */
    class C6432h implements LongClickSpanDelegate {
        C6432h() {
        }

        @Override // com.taobao.android.dinamicx.view.richtext.LongClickSpanDelegate
        public boolean onLongClick(@NonNull View view) {
            return C6424b.this.s.onLongPress(C6424b.this.q);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.dinamicx.view.richtext.node.b$i */
    /* loaded from: classes12.dex */
    public static class C6433i {
        private String a;
        private int b;
        private Integer c;
        private boolean d;
        private boolean e;
        private String f;
        private AssetManager g;
        private Integer h;
        private Integer i;
        private int j;
        private int k;
        private int m;
        private int o;
        private String p;
        private String q;
        private RichTextNode.OnLinkTapListener r;
        private RichTextNode.OnLongPressListener s;
        private RichTextNode.OnTapListener t;
        private RichTextNode.OnLongTapListener u;
        private float v;
        private float w;
        private Integer x;
        private float y;
        private int l = 0;
        private int n = 0;

        public C6433i(String str) {
            this.a = str;
        }

        @NonNull
        public C6424b a() {
            C6424b c6424b = new C6424b(null);
            c6424b.a = this.a;
            c6424b.b = this.b;
            c6424b.c = this.c;
            c6424b.d = this.d;
            c6424b.e = this.e;
            c6424b.f = this.f;
            c6424b.g = this.g;
            c6424b.h = this.h;
            c6424b.i = this.i;
            c6424b.j = this.j;
            c6424b.k = this.k;
            c6424b.m = this.m;
            c6424b.l = this.l;
            c6424b.o = this.o;
            c6424b.n = this.n;
            c6424b.p = this.p;
            c6424b.q = this.q;
            c6424b.r = this.r;
            c6424b.s = this.s;
            c6424b.t = this.t;
            c6424b.u = this.u;
            c6424b.x = this.x;
            c6424b.v = this.v;
            c6424b.w = this.w;
            c6424b.y = this.y;
            return c6424b;
        }

        public C6433i b(int i) {
            this.h = Integer.valueOf(i);
            return this;
        }

        public C6433i c(int i) {
            this.i = Integer.valueOf(i);
            return this;
        }

        public C6433i d(int i) {
            this.j = i;
            return this;
        }

        public C6433i e(int i) {
            this.k = i;
            return this;
        }

        public C6433i f(AssetManager assetManager, String str) {
            this.f = str;
            this.g = assetManager;
            return this;
        }

        public C6433i g(boolean z) {
            this.d = z;
            return this;
        }

        public C6433i h(boolean z) {
            this.e = z;
            return this;
        }

        public C6433i i(@NonNull String str) {
            this.p = str;
            return this;
        }

        public C6433i j(String str) {
            this.q = str;
            return this;
        }

        public C6433i k(float f) {
            this.v = f;
            return this;
        }

        public C6433i l(float f) {
            this.w = f;
            return this;
        }

        public C6433i m(float f) {
            this.y = f;
            return this;
        }

        public C6433i n(int i) {
            this.o = i;
            return this;
        }

        public C6433i o(int i) {
            this.n = i;
            return this;
        }

        public C6433i p(int i) {
            this.c = Integer.valueOf(i);
            return this;
        }

        public C6433i q(int i) {
            this.b = i;
            return this;
        }

        public C6433i r(int i) {
            this.m = i;
            return this;
        }

        public C6433i s(int i) {
            this.l = i;
            return this;
        }
    }

    /* synthetic */ C6424b(C6425a c6425a) {
        this();
    }

    private List<Object> F() {
        LinkedList linkedList = new LinkedList();
        if (this.b > 0) {
            linkedList.add(new AbsoluteSizeSpan(this.b, true));
        }
        if (this.c != null) {
            linkedList.add(new ForegroundColorSpan(this.c.intValue()));
        }
        if (this.l != 0) {
            linkedList.add(new CloneableUnderlineSpan(this.m));
        }
        if (this.n != 0) {
            linkedList.add(new StrikethroughSpan());
        }
        if (this.d) {
            linkedList.add(new StyleSpan(1));
        }
        if (this.e) {
            linkedList.add(new StyleSpan(2));
        }
        if (this.h != null) {
            linkedList.add(new BackgroundColorSpan(this.h.intValue()));
        }
        this.A = new CloneableNoStyleClickSpan();
        this.B = new CloneableLongClickSpan();
        this.C = new CloneableNoStyleClickSpan();
        this.D = new CloneableLongClickSpan();
        linkedList.add(this.A);
        linkedList.add(this.B);
        linkedList.add(this.C);
        linkedList.add(this.D);
        if (this.r != null) {
            this.A.setClickDelegate(new C6425a());
        }
        if (this.s != null) {
            this.B.setLongClickSpanDelegate(new C6426b());
        }
        if (this.t != null) {
            this.C.setClickDelegate(new C6427c());
        }
        if (this.u != null) {
            this.D.setLongClickSpanDelegate(new C6428d());
        }
        if (this.y != 0.0f && this.x != null) {
            linkedList.add(new CloneableShadowSpan(this.y, this.v, this.w, this.x.intValue()));
        }
        if (this.f != null && this.g != null && Build.VERSION.SDK_INT >= 28) {
            bp0 a = bp0.a();
            String str = this.f;
            linkedList.add(new TypefaceSpan(a.b(str, Typeface.createFromAsset(this.g, str))));
        }
        return linkedList;
    }

    @Nullable
    public Integer G() {
        return this.c;
    }

    public int H() {
        return this.b;
    }

    public void I(RichTextNode.OnLinkTapListener onLinkTapListener) {
        this.r = onLinkTapListener;
        if (this.z == null) {
            this.z = F();
        } else {
            this.A.setClickDelegate(new C6431g());
        }
    }

    public void J(RichTextNode.OnLongPressListener onLongPressListener) {
        this.s = onLongPressListener;
        if (this.z == null) {
            this.z = F();
        } else {
            this.B.setLongClickSpanDelegate(new C6432h());
        }
    }

    public void K(RichTextNode.OnLongTapListener onLongTapListener) {
        this.u = onLongTapListener;
        this.D.setLongClickSpanDelegate(new C6430f());
    }

    public void L(RichTextNode.OnTapListener onTapListener) {
        this.t = onTapListener;
        this.C.setClickDelegate(new C6429e());
    }

    @Override // com.taobao.android.dinamicx.view.richtext.node.RichTextNode
    @NonNull
    public String getText() {
        return this.a;
    }

    @Override // com.taobao.android.dinamicx.view.richtext.node.RichTextNode
    @NonNull
    public List<Object> toSpans() {
        return toSpans(false);
    }

    private C6424b() {
    }

    @Override // com.taobao.android.dinamicx.view.richtext.node.RichTextNode
    @NonNull
    public List<Object> toSpans(boolean z) {
        if (!z || this.z == null) {
            this.z = F();
        }
        return this.z;
    }
}
