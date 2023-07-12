package com.taobao.android.dinamicx.view.richtext.node;

import android.graphics.Bitmap;
import android.view.View;
import androidx.annotation.NonNull;
import com.taobao.android.dinamicx.view.richtext.ClickSpanDelegate;
import com.taobao.android.dinamicx.view.richtext.LongClickSpanDelegate;
import com.taobao.android.dinamicx.view.richtext.node.RichTextNode;
import com.taobao.android.dinamicx.view.richtext.span.CloneableLongClickSpan;
import com.taobao.android.dinamicx.view.richtext.span.CloneableNoStyleClickSpan;
import com.taobao.android.dinamicx.view.richtext.span.CloneableResizedImageSpan;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* renamed from: com.taobao.android.dinamicx.view.richtext.node.a */
/* loaded from: classes11.dex */
public class C6414a implements RichTextNode {
    private int a;
    private int b;
    private double c;
    private String d;
    private String e;
    private RichTextNode.OnLinkTapListener f;
    private RichTextNode.OnLongPressListener g;
    private RichTextNode.OnTapListener h;
    private RichTextNode.OnLongTapListener i;
    private List<Object> j;
    private CloneableNoStyleClickSpan k;
    private CloneableLongClickSpan l;
    private CloneableNoStyleClickSpan m;
    private CloneableLongClickSpan n;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.dinamicx.view.richtext.node.a$a */
    /* loaded from: classes11.dex */
    public class C6415a implements ClickSpanDelegate {
        C6415a() {
        }

        @Override // com.taobao.android.dinamicx.view.richtext.ClickSpanDelegate
        public void onClick(@NonNull View view) {
            C6414a.this.f.onLinkTap(C6414a.this.d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.dinamicx.view.richtext.node.a$b */
    /* loaded from: classes11.dex */
    public class C6416b implements LongClickSpanDelegate {
        C6416b() {
        }

        @Override // com.taobao.android.dinamicx.view.richtext.LongClickSpanDelegate
        public boolean onLongClick(@NonNull View view) {
            return C6414a.this.g.onLongPress(C6414a.this.e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.dinamicx.view.richtext.node.a$c */
    /* loaded from: classes11.dex */
    public class C6417c implements ClickSpanDelegate {
        C6417c() {
        }

        @Override // com.taobao.android.dinamicx.view.richtext.ClickSpanDelegate
        public void onClick(@NonNull View view) {
            C6414a.this.h.onTap();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.dinamicx.view.richtext.node.a$d */
    /* loaded from: classes11.dex */
    public class C6418d implements LongClickSpanDelegate {
        C6418d() {
        }

        @Override // com.taobao.android.dinamicx.view.richtext.LongClickSpanDelegate
        public boolean onLongClick(@NonNull View view) {
            C6414a.this.i.onLongTap();
            return true;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.dinamicx.view.richtext.node.a$e */
    /* loaded from: classes11.dex */
    class C6419e implements ClickSpanDelegate {
        C6419e() {
        }

        @Override // com.taobao.android.dinamicx.view.richtext.ClickSpanDelegate
        public void onClick(@NonNull View view) {
            C6414a.this.h.onTap();
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.dinamicx.view.richtext.node.a$f */
    /* loaded from: classes11.dex */
    class C6420f implements LongClickSpanDelegate {
        C6420f() {
        }

        @Override // com.taobao.android.dinamicx.view.richtext.LongClickSpanDelegate
        public boolean onLongClick(@NonNull View view) {
            C6414a.this.i.onLongTap();
            return true;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.dinamicx.view.richtext.node.a$g */
    /* loaded from: classes11.dex */
    class C6421g implements ClickSpanDelegate {
        C6421g() {
        }

        @Override // com.taobao.android.dinamicx.view.richtext.ClickSpanDelegate
        public void onClick(@NonNull View view) {
            C6414a.this.f.onLinkTap(C6414a.this.d);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.dinamicx.view.richtext.node.a$h */
    /* loaded from: classes11.dex */
    class C6422h implements LongClickSpanDelegate {
        C6422h() {
        }

        @Override // com.taobao.android.dinamicx.view.richtext.LongClickSpanDelegate
        public boolean onLongClick(@NonNull View view) {
            return C6414a.this.g.onLongPress(C6414a.this.e);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.dinamicx.view.richtext.node.a$i */
    /* loaded from: classes12.dex */
    public static class C6423i {
        private int a;
        private int b;
        private double c;
        private String d;
        private String e;
        private RichTextNode.OnLinkTapListener f;
        private RichTextNode.OnLongPressListener g;
        private RichTextNode.OnTapListener h;
        private RichTextNode.OnLongTapListener i;

        public C6414a a() {
            C6414a c6414a = new C6414a(null);
            c6414a.a = this.a;
            c6414a.b = this.b;
            c6414a.c = this.c;
            c6414a.d = this.d;
            c6414a.e = this.e;
            c6414a.f = this.f;
            c6414a.g = this.g;
            c6414a.h = this.h;
            c6414a.i = this.i;
            return c6414a;
        }

        public C6423i b(int i) {
            this.b = i;
            return this;
        }

        public C6423i c(String str) {
            this.d = str;
            return this;
        }

        public C6423i d(String str) {
            this.e = str;
            return this;
        }

        public C6423i e(double d) {
            this.c = d;
            return this;
        }

        public C6423i f(int i) {
            this.a = i;
            return this;
        }
    }

    /* synthetic */ C6414a(C6415a c6415a) {
        this();
    }

    private List<Object> p() {
        ArrayList arrayList = new ArrayList();
        int i = this.a;
        if (i >= 0 || this.b <= 0) {
            if (i == 0) {
                this.a = (int) Math.round(this.c * this.b);
            }
            if (this.b == 0) {
                this.b = (int) Math.round(this.a / this.c);
            }
            arrayList.add(new CloneableResizedImageSpan(this.a, this.b));
        }
        this.k = new CloneableNoStyleClickSpan();
        this.l = new CloneableLongClickSpan();
        this.m = new CloneableNoStyleClickSpan();
        this.n = new CloneableLongClickSpan();
        arrayList.add(this.k);
        arrayList.add(this.l);
        arrayList.add(this.m);
        arrayList.add(this.n);
        if (this.f != null) {
            this.k.setClickDelegate(new C6415a());
        }
        if (this.g != null) {
            this.l.setLongClickSpanDelegate(new C6416b());
        }
        if (this.h != null) {
            this.m.setClickDelegate(new C6417c());
        }
        if (this.i != null) {
            this.n.setLongClickSpanDelegate(new C6418d());
        }
        return arrayList;
    }

    private void s() {
        int i = this.a;
        if (i >= 0 || this.b <= 0) {
            if (i == 0) {
                this.a = (int) Math.round(this.c * this.b);
            }
            if (this.b == 0) {
                this.b = (int) Math.round(this.a / this.c);
            }
        }
    }

    @Override // com.taobao.android.dinamicx.view.richtext.node.RichTextNode
    @NonNull
    public String getText() {
        return "[image]";
    }

    public int q() {
        s();
        return this.b;
    }

    public int r() {
        s();
        return this.a;
    }

    public void t(int i) {
        u(i, false);
    }

    @Override // com.taobao.android.dinamicx.view.richtext.node.RichTextNode
    @NonNull
    public List<Object> toSpans() {
        return toSpans(false);
    }

    public void u(int i, boolean z) {
        if (this.j == null) {
            this.j = p();
        }
        for (Object obj : this.j) {
            if (obj instanceof CloneableResizedImageSpan) {
                CloneableResizedImageSpan cloneableResizedImageSpan = (CloneableResizedImageSpan) obj;
                if (z) {
                    i += cloneableResizedImageSpan.getAppendTransY();
                }
                cloneableResizedImageSpan.setAppendTransY(i);
            }
        }
    }

    public void v(Bitmap bitmap) {
        if (this.j == null) {
            this.j = p();
        }
        for (Object obj : this.j) {
            if (obj instanceof CloneableResizedImageSpan) {
                ((CloneableResizedImageSpan) obj).refreshDrawable(bitmap);
                return;
            }
        }
    }

    public void w(RichTextNode.OnLinkTapListener onLinkTapListener) {
        this.f = onLinkTapListener;
        if (this.j == null) {
            this.j = p();
        } else {
            this.k.setClickDelegate(new C6421g());
        }
    }

    public void x(RichTextNode.OnLongPressListener onLongPressListener) {
        this.g = onLongPressListener;
        if (this.j == null) {
            this.j = p();
        } else {
            this.l.setLongClickSpanDelegate(new C6422h());
        }
    }

    public void y(RichTextNode.OnLongTapListener onLongTapListener) {
        this.i = onLongTapListener;
        this.n.setLongClickSpanDelegate(new C6420f());
    }

    public void z(RichTextNode.OnTapListener onTapListener) {
        this.h = onTapListener;
        this.m.setClickDelegate(new C6419e());
    }

    private C6414a() {
    }

    @Override // com.taobao.android.dinamicx.view.richtext.node.RichTextNode
    @NonNull
    public List<Object> toSpans(boolean z) {
        if (this.j == null || z) {
            this.j = p();
        }
        return this.j;
    }
}
