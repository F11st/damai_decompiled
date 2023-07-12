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
/* loaded from: classes11.dex */
public class a implements RichTextNode {
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
    /* renamed from: com.taobao.android.dinamicx.view.richtext.node.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public class C0293a implements ClickSpanDelegate {
        C0293a() {
        }

        @Override // com.taobao.android.dinamicx.view.richtext.ClickSpanDelegate
        public void onClick(@NonNull View view) {
            a.this.f.onLinkTap(a.this.d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public class b implements LongClickSpanDelegate {
        b() {
        }

        @Override // com.taobao.android.dinamicx.view.richtext.LongClickSpanDelegate
        public boolean onLongClick(@NonNull View view) {
            return a.this.g.onLongPress(a.this.e);
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
            a.this.h.onTap();
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
            a.this.i.onLongTap();
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
            a.this.h.onTap();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    class f implements LongClickSpanDelegate {
        f() {
        }

        @Override // com.taobao.android.dinamicx.view.richtext.LongClickSpanDelegate
        public boolean onLongClick(@NonNull View view) {
            a.this.i.onLongTap();
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
            a.this.f.onLinkTap(a.this.d);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    class h implements LongClickSpanDelegate {
        h() {
        }

        @Override // com.taobao.android.dinamicx.view.richtext.LongClickSpanDelegate
        public boolean onLongClick(@NonNull View view) {
            return a.this.g.onLongPress(a.this.e);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public static class i {
        private int a;
        private int b;
        private double c;
        private String d;
        private String e;
        private RichTextNode.OnLinkTapListener f;
        private RichTextNode.OnLongPressListener g;
        private RichTextNode.OnTapListener h;
        private RichTextNode.OnLongTapListener i;

        public a a() {
            a aVar = new a(null);
            aVar.a = this.a;
            aVar.b = this.b;
            aVar.c = this.c;
            aVar.d = this.d;
            aVar.e = this.e;
            aVar.f = this.f;
            aVar.g = this.g;
            aVar.h = this.h;
            aVar.i = this.i;
            return aVar;
        }

        public i b(int i) {
            this.b = i;
            return this;
        }

        public i c(String str) {
            this.d = str;
            return this;
        }

        public i d(String str) {
            this.e = str;
            return this;
        }

        public i e(double d) {
            this.c = d;
            return this;
        }

        public i f(int i) {
            this.a = i;
            return this;
        }
    }

    /* synthetic */ a(C0293a c0293a) {
        this();
    }

    private List<Object> p() {
        ArrayList arrayList = new ArrayList();
        int i2 = this.a;
        if (i2 >= 0 || this.b <= 0) {
            if (i2 == 0) {
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
            this.k.setClickDelegate(new C0293a());
        }
        if (this.g != null) {
            this.l.setLongClickSpanDelegate(new b());
        }
        if (this.h != null) {
            this.m.setClickDelegate(new c());
        }
        if (this.i != null) {
            this.n.setLongClickSpanDelegate(new d());
        }
        return arrayList;
    }

    private void s() {
        int i2 = this.a;
        if (i2 >= 0 || this.b <= 0) {
            if (i2 == 0) {
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

    public void t(int i2) {
        u(i2, false);
    }

    @Override // com.taobao.android.dinamicx.view.richtext.node.RichTextNode
    @NonNull
    public List<Object> toSpans() {
        return toSpans(false);
    }

    public void u(int i2, boolean z) {
        if (this.j == null) {
            this.j = p();
        }
        for (Object obj : this.j) {
            if (obj instanceof CloneableResizedImageSpan) {
                CloneableResizedImageSpan cloneableResizedImageSpan = (CloneableResizedImageSpan) obj;
                if (z) {
                    i2 += cloneableResizedImageSpan.getAppendTransY();
                }
                cloneableResizedImageSpan.setAppendTransY(i2);
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
            this.k.setClickDelegate(new g());
        }
    }

    public void x(RichTextNode.OnLongPressListener onLongPressListener) {
        this.g = onLongPressListener;
        if (this.j == null) {
            this.j = p();
        } else {
            this.l.setLongClickSpanDelegate(new h());
        }
    }

    public void y(RichTextNode.OnLongTapListener onLongTapListener) {
        this.i = onLongTapListener;
        this.n.setLongClickSpanDelegate(new f());
    }

    public void z(RichTextNode.OnTapListener onTapListener) {
        this.h = onTapListener;
        this.m.setClickDelegate(new e());
    }

    private a() {
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
