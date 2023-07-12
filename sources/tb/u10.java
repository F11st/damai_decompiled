package tb;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.alibaba.fastjson.JSONArray;
import com.taobao.android.dinamicx.view.richtext.node.C6424b;
import com.taobao.android.dinamicx.view.richtext.node.RichTextNode;
import com.taobao.android.dinamicx.widget.DXWidgetNode;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class u10 extends DXWidgetNode {
    public static final long DXTEXTSPAN_ENABLETEXTSIZESTRATEGY = 4822617398935994384L;
    public static final long DXTEXTSPAN_FONT = 34149272427L;
    public static final long DXTEXTSPAN_ISBOLD = 9423384817756195L;
    public static final long DXTEXTSPAN_ISITALIC = 3527554185889034042L;
    public static final long DXTEXTSPAN_ISTRUNCATED = -1735247218921453423L;
    public static final long DXTEXTSPAN_LINK = 35873943762L;
    public static final long DXTEXTSPAN_ONLINK = 9859228430928305L;
    public static final long DXTEXTSPAN_ONPRESS = 5176476879387311985L;
    public static final long DXTEXTSPAN_PRESS = 19050239308914L;
    public static final long DXTEXTSPAN_SHADOWCOLOR = -7272671779511765872L;
    public static final long DXTEXTSPAN_SHADOWOFFSET = -946588628814454279L;
    public static final long DXTEXTSPAN_SHADOWRADIUS = -946376925464026374L;
    public static final long DXTEXTSPAN_STRIKETHROUGHCOLOR = -5920401438808043356L;
    public static final long DXTEXTSPAN_STRIKETHROUGHSTYLE = -5902081368050436426L;
    public static final int DXTEXTSPAN_STRIKETHROUGHSTYLE_DOUBLE = 3;
    public static final int DXTEXTSPAN_STRIKETHROUGHSTYLE_NONE = 0;
    public static final int DXTEXTSPAN_STRIKETHROUGHSTYLE_SINGLE = 1;
    public static final int DXTEXTSPAN_STRIKETHROUGHSTYLE_THICK = 2;
    public static final long DXTEXTSPAN_TEXT = 38178040921L;
    public static final long DXTEXTSPAN_TEXTCOLOR = 5737767606580872653L;
    public static final long DXTEXTSPAN_TEXTSIZE = 6751005219504497256L;
    public static final long DXTEXTSPAN_TEXTSPAN = -2672364301597372865L;
    public static final long DXTEXTSPAN_UNDERLINECOLOR = 2436253123551448787L;
    public static final long DXTEXTSPAN_UNDERLINESTYLE = 2437398193491227877L;
    public static final int DXTEXTSPAN_UNDERLINESTYLE_DOUBLE = 3;
    public static final int DXTEXTSPAN_UNDERLINESTYLE_NONE = 0;
    public static final int DXTEXTSPAN_UNDERLINESTYLE_SINGLE = 1;
    public static final int DXTEXTSPAN_UNDERLINESTYLE_THICK = 2;
    private String b;
    private boolean c;
    private boolean d;
    private boolean e;
    private String f;
    private int h;
    private JSONArray i;
    private double j;
    private int k;
    private String m;
    private Integer n;
    private int o;
    private int p;
    private C6424b r;
    private boolean a = true;
    private String g = "none";
    private int l = 0;
    private int q = 0;

    /* compiled from: Taobao */
    /* renamed from: tb.u10$a */
    /* loaded from: classes11.dex */
    class C9756a implements RichTextNode.OnLinkTapListener {
        final /* synthetic */ long a;

        C9756a(long j) {
            this.a = j;
        }

        @Override // com.taobao.android.dinamicx.view.richtext.node.RichTextNode.OnLinkTapListener
        public void onLinkTap(String str) {
            u00 u00Var = new u00(this.a);
            u00Var.f(str);
            u10.this.postEvent(u00Var);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: tb.u10$b */
    /* loaded from: classes11.dex */
    class C9757b implements RichTextNode.OnLongPressListener {
        final /* synthetic */ long a;

        C9757b(long j) {
            this.a = j;
        }

        @Override // com.taobao.android.dinamicx.view.richtext.node.RichTextNode.OnLongPressListener
        public boolean onLongPress(String str) {
            v00 v00Var = new v00(this.a);
            v00Var.f(str);
            u10.this.postEvent(v00Var);
            return true;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: tb.u10$c */
    /* loaded from: classes11.dex */
    class C9758c implements RichTextNode.OnTapListener {
        C9758c() {
        }

        @Override // com.taobao.android.dinamicx.view.richtext.node.RichTextNode.OnTapListener
        public void onTap() {
            u10.this.postEvent(new hy(18903999933159L));
        }
    }

    /* compiled from: Taobao */
    /* renamed from: tb.u10$d */
    /* loaded from: classes11.dex */
    class C9759d implements RichTextNode.OnLongTapListener {
        C9759d() {
        }

        @Override // com.taobao.android.dinamicx.view.richtext.node.RichTextNode.OnLongTapListener
        public void onLongTap() {
            u10.this.postEvent(new hy(-6544685697300501093L));
        }
    }

    public C6424b a() {
        if (TextUtils.isEmpty(this.m)) {
            return null;
        }
        C6424b.C6433i o = new C6424b.C6433i(this.m).q(this.o).b(getBackGroundColor()).c(getBorderColor()).d(getBorderWidth()).e(getCornerRadius()).g(this.c).h(this.d).i(this.f).j(this.g).m((float) this.j).r(this.p).s(this.q).n(this.k).o(this.l);
        Integer num = this.n;
        if (num != null) {
            o.p(num.intValue());
        }
        JSONArray jSONArray = this.i;
        if (jSONArray != null) {
            if (jSONArray.size() >= 1) {
                o.k(this.i.getFloat(0).floatValue());
            }
            if (this.i.size() >= 2) {
                o.l(this.i.getFloat(1).floatValue());
            }
        }
        if (getDXRuntimeContext() != null && getDXRuntimeContext().getContext() != null) {
            o.f(getDXRuntimeContext().getContext().getAssets(), this.b);
        }
        C6424b a = o.a();
        this.r = a;
        return a;
    }

    public int b() {
        return this.o;
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode, com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode
    public DXWidgetNode build(Object obj) {
        return new u10();
    }

    public boolean c() {
        return this.a;
    }

    public boolean d() {
        return this.e;
    }

    public void e(boolean z) {
        this.a = z;
    }

    public void f(int i) {
        this.o = i;
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public int getDefaultValueForIntAttr(long j) {
        if (j == -5902081368050436426L || j == 2437398193491227877L) {
            return 0;
        }
        if (j == 5737767606580872653L) {
            return -16777216;
        }
        if (j == 4822617398935994384L) {
            return 1;
        }
        return super.getDefaultValueForIntAttr(j);
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public String getDefaultValueForStringAttr(long j) {
        return j == 19050239308914L ? "none" : super.getDefaultValueForStringAttr(j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onBindEvent(Context context, View view, long j) {
        C6424b c6424b = this.r;
        if (c6424b == null) {
            if (wt.j0(this)) {
                return;
            }
            super.onBindEvent(context, view, j);
        } else if (j == 9859228430928305L) {
            c6424b.I(new C9756a(j));
        } else if (j == 5176476879387311985L) {
            c6424b.J(new C9757b(j));
        } else if (j == 18903999933159L) {
            c6424b.L(new C9758c());
        } else if (j == -6544685697300501093L) {
            c6424b.K(new C9759d());
        } else if (wt.j0(this)) {
        } else {
            super.onBindEvent(context, view, j);
        }
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onClone(DXWidgetNode dXWidgetNode, boolean z) {
        if (dXWidgetNode == null || !(dXWidgetNode instanceof u10)) {
            return;
        }
        super.onClone(dXWidgetNode, z);
        u10 u10Var = (u10) dXWidgetNode;
        this.b = u10Var.b;
        this.c = u10Var.c;
        this.d = u10Var.d;
        this.e = u10Var.e;
        this.f = u10Var.f;
        this.g = u10Var.g;
        this.h = u10Var.h;
        this.i = u10Var.i;
        this.j = u10Var.j;
        this.k = u10Var.k;
        this.l = u10Var.l;
        this.m = u10Var.m;
        this.n = u10Var.n;
        this.o = u10Var.o;
        this.p = u10Var.p;
        this.q = u10Var.q;
        this.r = u10Var.r;
        this.a = u10Var.a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public View onCreateView(Context context) {
        if (wt.j0(this)) {
            return null;
        }
        return super.onCreateView(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetDoubleAttribute(long j, double d) {
        if (j == -946376925464026374L) {
            this.j = d;
        } else {
            super.onSetDoubleAttribute(j, d);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetIntAttribute(long j, int i) {
        if (j == 9423384817756195L) {
            this.c = i != 0;
        } else if (j == 3527554185889034042L) {
            this.d = i != 0;
        } else if (j == DXTEXTSPAN_ISTRUNCATED) {
            this.e = i != 0;
        } else if (j == -7272671779511765872L) {
            this.h = i;
        } else if (j == -5920401438808043356L) {
            this.k = i;
        } else if (j == -5902081368050436426L) {
            this.l = i;
        } else if (j == 5737767606580872653L) {
            this.n = Integer.valueOf(i);
        } else if (j == 6751005219504497256L) {
            this.o = i;
        } else if (j == 2436253123551448787L) {
            this.p = i;
        } else if (j == 2437398193491227877L) {
            this.q = i;
        } else if (j == 4822617398935994384L) {
            this.a = i != 0;
        } else {
            super.onSetIntAttribute(j, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetListAttribute(long j, JSONArray jSONArray) {
        if (j == -946588628814454279L) {
            this.i = jSONArray;
        } else {
            super.onSetListAttribute(j, jSONArray);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetStringAttribute(long j, String str) {
        if (j == 34149272427L) {
            this.b = str;
        } else if (j == 35873943762L) {
            this.f = str;
        } else if (j == 19050239308914L) {
            this.g = str;
        } else if (j == 38178040921L) {
            this.m = str;
        } else {
            super.onSetStringAttribute(j, str);
        }
    }
}
