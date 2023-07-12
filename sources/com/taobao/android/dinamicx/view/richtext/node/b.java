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
/* loaded from: classes11.dex */
public class b implements RichTextNode {
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
    /* loaded from: classes11.dex */
    public class a implements ClickSpanDelegate {
        a() {
        }

        @Override // com.taobao.android.dinamicx.view.richtext.ClickSpanDelegate
        public void onClick(@NonNull View view) {
            b.this.r.onLinkTap(b.this.p);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.dinamicx.view.richtext.node.b$b  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public class C0294b implements LongClickSpanDelegate {
        C0294b() {
        }

        @Override // com.taobao.android.dinamicx.view.richtext.LongClickSpanDelegate
        public boolean onLongClick(@NonNull View view) {
            return b.this.s.onLongPress(b.this.q);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public class c implements ClickSpanDelegate {
        c() {
        }

        @Override // com.taobao.android.dinamicx.view.richtext.ClickSpanDelegate
        public void onClick(@NonNull View view) {
            b.this.t.onTap();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public class d implements LongClickSpanDelegate {
        d() {
        }

        @Override // com.taobao.android.dinamicx.view.richtext.LongClickSpanDelegate
        public boolean onLongClick(@NonNull View view) {
            b.this.u.onLongTap();
            return true;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    class e implements ClickSpanDelegate {
        e() {
        }

        @Override // com.taobao.android.dinamicx.view.richtext.ClickSpanDelegate
        public void onClick(@NonNull View view) {
            b.this.t.onTap();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    class f implements LongClickSpanDelegate {
        f() {
        }

        @Override // com.taobao.android.dinamicx.view.richtext.LongClickSpanDelegate
        public boolean onLongClick(@NonNull View view) {
            b.this.u.onLongTap();
            return true;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    class g implements ClickSpanDelegate {
        g() {
        }

        @Override // com.taobao.android.dinamicx.view.richtext.ClickSpanDelegate
        public void onClick(@NonNull View view) {
            b.this.r.onLinkTap(b.this.p);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    class h implements LongClickSpanDelegate {
        h() {
        }

        @Override // com.taobao.android.dinamicx.view.richtext.LongClickSpanDelegate
        public boolean onLongClick(@NonNull View view) {
            return b.this.s.onLongPress(b.this.q);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public static class i {
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

        public i(String str) {
            this.a = str;
        }

        @NonNull
        public b a() {
            b bVar = new b(null);
            bVar.a = this.a;
            bVar.b = this.b;
            bVar.c = this.c;
            bVar.d = this.d;
            bVar.e = this.e;
            bVar.f = this.f;
            bVar.g = this.g;
            bVar.h = this.h;
            bVar.i = this.i;
            bVar.j = this.j;
            bVar.k = this.k;
            bVar.m = this.m;
            bVar.l = this.l;
            bVar.o = this.o;
            bVar.n = this.n;
            bVar.p = this.p;
            bVar.q = this.q;
            bVar.r = this.r;
            bVar.s = this.s;
            bVar.t = this.t;
            bVar.u = this.u;
            bVar.x = this.x;
            bVar.v = this.v;
            bVar.w = this.w;
            bVar.y = this.y;
            return bVar;
        }

        public i b(int i) {
            this.h = Integer.valueOf(i);
            return this;
        }

        public i c(int i) {
            this.i = Integer.valueOf(i);
            return this;
        }

        public i d(int i) {
            this.j = i;
            return this;
        }

        public i e(int i) {
            this.k = i;
            return this;
        }

        public i f(AssetManager assetManager, String str) {
            this.f = str;
            this.g = assetManager;
            return this;
        }

        public i g(boolean z) {
            this.d = z;
            return this;
        }

        public i h(boolean z) {
            this.e = z;
            return this;
        }

        public i i(@NonNull String str) {
            this.p = str;
            return this;
        }

        public i j(String str) {
            this.q = str;
            return this;
        }

        public i k(float f) {
            this.v = f;
            return this;
        }

        public i l(float f) {
            this.w = f;
            return this;
        }

        public i m(float f) {
            this.y = f;
            return this;
        }

        public i n(int i) {
            this.o = i;
            return this;
        }

        public i o(int i) {
            this.n = i;
            return this;
        }

        public i p(int i) {
            this.c = Integer.valueOf(i);
            return this;
        }

        public i q(int i) {
            this.b = i;
            return this;
        }

        public i r(int i) {
            this.m = i;
            return this;
        }

        public i s(int i) {
            this.l = i;
            return this;
        }
    }

    /* synthetic */ b(a aVar) {
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
            this.A.setClickDelegate(new a());
        }
        if (this.s != null) {
            this.B.setLongClickSpanDelegate(new C0294b());
        }
        if (this.t != null) {
            this.C.setClickDelegate(new c());
        }
        if (this.u != null) {
            this.D.setLongClickSpanDelegate(new d());
        }
        if (this.y != 0.0f && this.x != null) {
            linkedList.add(new CloneableShadowSpan(this.y, this.v, this.w, this.x.intValue()));
        }
        if (this.f != null && this.g != null && Build.VERSION.SDK_INT >= 28) {
            bp0 a2 = bp0.a();
            String str = this.f;
            linkedList.add(new TypefaceSpan(a2.b(str, Typeface.createFromAsset(this.g, str))));
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
            this.A.setClickDelegate(new g());
        }
    }

    public void J(RichTextNode.OnLongPressListener onLongPressListener) {
        this.s = onLongPressListener;
        if (this.z == null) {
            this.z = F();
        } else {
            this.B.setLongClickSpanDelegate(new h());
        }
    }

    public void K(RichTextNode.OnLongTapListener onLongTapListener) {
        this.u = onLongTapListener;
        this.D.setLongClickSpanDelegate(new f());
    }

    public void L(RichTextNode.OnTapListener onTapListener) {
        this.t = onTapListener;
        this.C.setClickDelegate(new e());
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

    private b() {
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
