package tb;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.alibaba.fastjson.JSONArray;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.DinamicXEngine;
import com.taobao.android.dinamicx.view.richtext.DXNativeRichText;
import com.taobao.android.dinamicx.view.richtext.node.RichText;
import com.taobao.android.dinamicx.widget.DXWidgetNode;
import com.taobao.android.dinamicx.widget.richtext.DXImageSpanWidgetNode;
import java.util.ArrayList;
import java.util.List;
import tb.q32;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class w00 extends com.taobao.android.dinamicx.widget.f {
    public static final int DEFAULT_TEXT_COLOR = -16777216;
    public static final long DXRICHTEXT_BASELINE = 1445754069157927243L;
    public static final int DXRICHTEXT_BASELINE_BOTTOM = 0;
    public static final int DXRICHTEXT_BASELINE_MIDDLE = 1;
    public static final int DXRICHTEXT_BASELINE_TOP = 2;
    public static final long DXRICHTEXT_ENABLECUSTOMTRUNCATION = -7904255114002670305L;
    public static final long DXRICHTEXT_ENABLETEXTSIZESTRATEGY = 4822617398935994384L;
    public static final long DXRICHTEXT_EXPANDED = 2355535793353806417L;
    public static final long DXRICHTEXT_EXPANDLINES = 8720999726396813958L;
    public static final long DXRICHTEXT_FIRSTLINEHEADINDENT = 4761283217210504855L;
    public static final long DXRICHTEXT_FONT = 34149272427L;
    public static final long DXRICHTEXT_FORCEORIGINAL = -6490331624039946159L;
    public static final long DXRICHTEXT_IGNOREUNTRUNCATEDTAP = 867831422994583882L;
    public static final long DXRICHTEXT_ISBOLD = 9423384817756195L;
    public static final long DXRICHTEXT_ISITALIC = 3527554185889034042L;
    public static final long DXRICHTEXT_LINEBREAKMODE = 1650157837879951391L;
    public static final int DXRICHTEXT_LINEBREAKMODE_CHAR = 4;
    public static final int DXRICHTEXT_LINEBREAKMODE_END = 3;
    public static final int DXRICHTEXT_LINEBREAKMODE_MIDDLE = 2;
    public static final int DXRICHTEXT_LINEBREAKMODE_NONE = 0;
    public static final int DXRICHTEXT_LINEBREAKMODE_START = 1;
    public static final long DXRICHTEXT_LINEHEIGHT = 6086495633913771275L;
    public static final long DXRICHTEXT_LINESPACING = -2369181291898902408L;
    public static final long DXRICHTEXT_LINK = 35873943762L;
    public static final long DXRICHTEXT_MAXHEIGHT = -2628143228636041048L;
    public static final long DXRICHTEXT_MAXLINES = 4685059187929305417L;
    public static final long DXRICHTEXT_MAXWIDTH = 4685059378591825230L;
    public static final long DXRICHTEXT_ONLINK = 9859228430928305L;
    public static final long DXRICHTEXT_ONPRESS = 5176476879387311985L;
    public static final long DXRICHTEXT_PRESS = 19050239308914L;
    public static final long DXRICHTEXT_RICHTEXT = -3256835378505648333L;
    public static final long DXRICHTEXT_SHADOWCOLOR = -7272671779511765872L;
    public static final long DXRICHTEXT_SHADOWOFFSET = -946588628814454279L;
    public static final long DXRICHTEXT_SHADOWRADIUS = -946376925464026374L;
    public static final long DXRICHTEXT_SHRINKLINES = 5091055928078111125L;
    public static final long DXRICHTEXT_STRIKETHROUGHCOLOR = -5920401438808043356L;
    public static final long DXRICHTEXT_STRIKETHROUGHSTYLE = -5902081368050436426L;
    public static final int DXRICHTEXT_STRIKETHROUGHSTYLE_DOUBLE = 3;
    public static final int DXRICHTEXT_STRIKETHROUGHSTYLE_NONE = 0;
    public static final int DXRICHTEXT_STRIKETHROUGHSTYLE_SINGLE = 1;
    public static final int DXRICHTEXT_STRIKETHROUGHSTYLE_THICK = 2;
    public static final long DXRICHTEXT_TEXTCOLOR = 5737767606580872653L;
    public static final long DXRICHTEXT_TEXTGRAVITY = -1564827143683948874L;
    public static final int DXRICHTEXT_TEXTGRAVITY_CENTER = 1;
    public static final int DXRICHTEXT_TEXTGRAVITY_LEFT = 0;
    public static final int DXRICHTEXT_TEXTGRAVITY_RIGHT = 2;
    public static final long DXRICHTEXT_TEXTSIZE = 6751005219504497256L;
    public static final long DXRICHTEXT_UNDERLINECOLOR = 2436253123551448787L;
    public static final long DXRICHTEXT_UNDERLINESTYLE = 2437398193491227877L;
    public static final int DXRICHTEXT_UNDERLINESTYLE_DOUBLE = 3;
    public static final int DXRICHTEXT_UNDERLINESTYLE_NONE = 0;
    public static final int DXRICHTEXT_UNDERLINESTYLE_SINGLE = 1;
    public static final int DXRICHTEXT_UNDERLINESTYLE_THICK = 2;
    public static final long DXRICHTEXT_WORDKERN = 7645877425838446932L;
    public static final CharSequence ELLIPSIS_TEXT = "…";
    public static int J = 0;
    public static int K = 1;
    private int A;
    private boolean C;
    private q32 E;
    private boolean F;
    private boolean G;
    private boolean H;
    private boolean I;
    private double b;
    private String c;
    private boolean d;
    private boolean e;
    private int f;
    private String i;
    private int k;
    private String m;
    private int n;
    private JSONArray o;
    private double p;
    private int q;
    private int t;
    private int u;
    private Integer v;
    private double x;
    private int y;
    private boolean z;
    private int a = 0;
    private double g = -1.0d;
    private double h = -1.0d;
    private int j = Integer.MAX_VALUE;
    private int l = Integer.MAX_VALUE;
    private int r = 0;
    private int w = 0;
    private boolean B = true;
    private boolean D = true;
    private Integer s = -16777216;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            w00.this.k();
            w00.this.m();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            w00.this.k();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    class c implements View.OnLongClickListener {
        c() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            w00.this.l();
            w00.this.onLongTap();
            return true;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            w00.this.m();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            w00.this.k();
            w00.this.m();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    class f implements View.OnLongClickListener {
        f() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            w00.this.onLongTap();
            return true;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    class g implements View.OnLongClickListener {
        g() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            w00.this.l();
            w00.this.onLongTap();
            return true;
        }
    }

    public w00() {
        this.f = 0;
        this.t = 0;
        if (J == 0 && DinamicXEngine.i() != null) {
            J = z00.c(DinamicXEngine.i(), 12.0f);
        }
        this.u = J;
        this.f = -1;
        this.t = 0;
        this.k = K;
    }

    private void e() {
        if (wt.E0()) {
            try {
                List<DXWidgetNode> children = getChildren();
                if (children != null && !children.isEmpty()) {
                    for (int i = 0; i < children.size(); i++) {
                        DXWidgetNode dXWidgetNode = children.get(i);
                        if (((dXWidgetNode instanceof u10) || (dXWidgetNode instanceof DXImageSpanWidgetNode)) && wt.j0(dXWidgetNode)) {
                            DXWidgetNode referenceNode = !dXWidgetNode.isFlatten() ? dXWidgetNode.getReferenceNode() : dXWidgetNode;
                            if (referenceNode != null) {
                                referenceNode.bindEvent(dXWidgetNode.getDXRuntimeContext().getContext());
                            }
                        }
                    }
                }
            } catch (Exception e2) {
                ry.b(e2);
            }
        }
    }

    private RichText f() {
        com.taobao.android.dinamicx.view.richtext.node.a k;
        StringBuilder sb = new StringBuilder();
        ArrayList arrayList = new ArrayList();
        List<DXWidgetNode> children = getChildren();
        for (int i = 0; i < children.size(); i++) {
            DXWidgetNode dXWidgetNode = children.get(i);
            if (dXWidgetNode.getVisibility() != 2) {
                if (dXWidgetNode instanceof u10) {
                    u10 u10Var = (u10) dXWidgetNode;
                    com.taobao.android.dinamicx.view.richtext.node.b a2 = u10Var.a();
                    if (a2 != null) {
                        if (u10Var.d()) {
                            if (!this.z) {
                                RichText richText = new RichText();
                                richText.add(a2);
                                this.E.A(richText.renderText());
                                this.f = 3;
                                this.E.H(3);
                            }
                        } else {
                            arrayList.add(a2);
                        }
                        sb.append(a2.getText());
                    }
                } else if ((dXWidgetNode instanceof DXImageSpanWidgetNode) && (k = ((DXImageSpanWidgetNode) dXWidgetNode).k(true, this.D)) != null) {
                    arrayList.add(k);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        RichText richText2 = new RichText();
        richText2.addAll(arrayList);
        if (getAccessibilityText() == null) {
            setAccessibilityText(sb.toString());
        }
        return richText2;
    }

    private int g() {
        int i = this.a;
        if (i == 0) {
            return 0;
        }
        if (i == 2) {
            return 2;
        }
        return i == 1 ? 1 : 0;
    }

    private int h() {
        int i = this.r;
        if (i == 1) {
            return 1;
        }
        if (i == 3) {
            return 3;
        }
        return i == 2 ? 2 : 0;
    }

    private int i() {
        int i = this.t;
        if (i == 1) {
            return 1;
        }
        return i == 2 ? 2 : 0;
    }

    private int j() {
        int i = this.w;
        if (i == 1) {
            return 1;
        }
        if (i == 3) {
            return 3;
        }
        return i == 2 ? 2 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        u00 u00Var = new u00(9859228430928305L);
        u00Var.f(this.i);
        postEvent(u00Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        v00 v00Var = new v00(5176476879387311985L);
        v00Var.f(this.m);
        postEvent(v00Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        if (!this.C || this.E.q()) {
            postEvent(new hy(18903999933159L));
        }
    }

    private void n() {
        q32 q32Var = new q32();
        this.E = q32Var;
        int i = this.z ? this.y : this.A;
        this.k = i;
        if (i <= 0) {
            this.k = Integer.MAX_VALUE;
        }
        q32Var.w(getBorderColor());
        this.E.x(Math.max(getBorderWidth(), 0));
        this.E.y(getDXRuntimeContext().getContext());
        this.E.z(getCornerRadius());
        this.E.B((int) this.b);
        this.E.C(this.c);
        this.E.D(this.d);
        this.E.E(this.e);
        this.E.F(getDirection());
        this.E.G((float) this.x);
        this.E.H(this.f);
        this.E.L(this.k);
        this.E.M(this.l);
        this.E.K(this.j);
        this.E.b0(this.v);
        this.E.c0(j());
        this.E.V(this.q);
        this.E.W(h());
        this.E.O(getPaddingLeft());
        this.E.P(getPaddingRight());
        this.E.N(getPaddingBottom());
        this.E.Q(getPaddingTop());
        this.E.Z(i());
        this.E.v(g());
        this.E.I((float) this.g);
        this.E.J((float) this.h);
        int i2 = this.u;
        if (i2 > 0) {
            this.E.a0(i2);
        }
        Integer num = this.s;
        if (num != null) {
            this.E.Y(tryFetchDarkModeColor("textColor", 0, num.intValue()));
        }
        JSONArray jSONArray = this.o;
        if (jSONArray != null) {
            if (jSONArray.size() >= 1) {
                this.E.S(this.o.getFloat(0).floatValue());
            }
            if (this.o.size() >= 2) {
                this.E.T(this.o.getFloat(1).floatValue());
            }
        }
        this.E.U((float) this.p);
        this.E.R(this.n);
        this.E.X(f());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onLongTap() {
        postEvent(new hy(-6544685697300501093L));
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode, com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode
    public DXWidgetNode build(Object obj) {
        return new w00();
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public double getDefaultValueForDoubleAttr(long j) {
        if (j == DXRICHTEXT_LINEHEIGHT || j == DXRICHTEXT_LINESPACING) {
            return -1.0d;
        }
        return super.getDefaultValueForDoubleAttr(j);
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public int getDefaultValueForIntAttr(long j) {
        if (j == DXRICHTEXT_BASELINE || j == DXRICHTEXT_ENABLECUSTOMTRUNCATION || j == DXRICHTEXT_LINEBREAKMODE || j == -5902081368050436426L || j == 2437398193491227877L) {
            return 0;
        }
        if (j == 5737767606580872653L) {
            return -16777216;
        }
        if (j == 4822617398935994384L) {
            return 1;
        }
        if (j == 6751005219504497256L) {
            return J;
        }
        if (j == DXRICHTEXT_FORCEORIGINAL) {
            return 1;
        }
        return super.getDefaultValueForIntAttr(j);
    }

    @Override // com.taobao.android.dinamicx.widget.f
    public boolean isDisableFlatten() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onBindEvent(Context context, View view, long j) {
        if (j == 9859228430928305L && !TextUtils.isEmpty(this.i)) {
            this.F = true;
            if (this.H) {
                view.setOnClickListener(new a());
            } else {
                view.setOnClickListener(new b());
            }
        } else if (j == 5176476879387311985L && !TextUtils.isEmpty(this.m)) {
            this.G = true;
            if (this.I) {
                view.setOnLongClickListener(new c());
            }
        } else if (j == 18903999933159L) {
            this.H = true;
            if (!this.F) {
                view.setOnClickListener(new d());
            } else {
                view.setOnClickListener(new e());
            }
        } else if (j == -6544685697300501093L) {
            this.I = true;
            if (!this.G) {
                view.setOnLongClickListener(new f());
            } else {
                view.setOnLongClickListener(new g());
            }
        } else {
            super.onBindEvent(context, view, j);
        }
    }

    @Override // com.taobao.android.dinamicx.widget.f, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onClone(DXWidgetNode dXWidgetNode, boolean z) {
        if (dXWidgetNode == null || !(dXWidgetNode instanceof w00)) {
            return;
        }
        super.onClone(dXWidgetNode, z);
        w00 w00Var = (w00) dXWidgetNode;
        this.a = w00Var.a;
        this.b = w00Var.b;
        this.c = w00Var.c;
        this.d = w00Var.d;
        this.e = w00Var.e;
        this.f = w00Var.f;
        this.g = w00Var.g;
        this.h = w00Var.h;
        this.i = w00Var.i;
        this.j = w00Var.j;
        this.k = w00Var.k;
        this.l = w00Var.l;
        this.m = w00Var.m;
        this.n = w00Var.n;
        this.o = w00Var.o;
        this.p = w00Var.p;
        this.q = w00Var.q;
        this.r = w00Var.r;
        this.s = w00Var.s;
        this.t = w00Var.t;
        this.u = w00Var.u;
        this.v = w00Var.v;
        this.w = w00Var.w;
        this.x = w00Var.x;
        this.z = w00Var.z;
        this.y = w00Var.y;
        this.A = w00Var.A;
        this.B = w00Var.B;
        this.C = w00Var.C;
        this.D = w00Var.D;
        this.E = w00Var.E;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public View onCreateView(Context context) {
        return new DXNativeRichText(context);
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onEndParser() {
        DXRuntimeContext dXRuntimeContext = getDXRuntimeContext();
        List<DXWidgetNode> children = getChildren();
        for (int i = 0; i < children.size(); i++) {
            DXWidgetNode dXWidgetNode = children.get(i);
            if (dXWidgetNode.getVisibility() != 2 && (dXWidgetNode instanceof u10)) {
                u10 u10Var = (u10) dXWidgetNode;
                if (this.B && u10Var.c() && u10Var.b() > 0) {
                    u10Var.f((int) com.taobao.android.dinamicx.c.b(dXRuntimeContext, u10Var.b()));
                }
                u10Var.e(this.B && u10Var.c());
            }
        }
        if (this.B && dXRuntimeContext != null && dXRuntimeContext.getEngineContext().b().p()) {
            this.u = (int) com.taobao.android.dinamicx.c.b(dXRuntimeContext, this.u);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onMeasure(int i, int i2) {
        n();
        q32.a u = this.E.u(i, i2);
        if (u == null) {
            super.onMeasure(i, i2);
        } else {
            setMeasuredDimension(u.b(), u.a());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.f, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onRenderView(Context context, View view) {
        if (view instanceof DXNativeRichText) {
            ((DXNativeRichText) view).setRichTextRender(this.E);
            e();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetDoubleAttribute(long j, double d2) {
        if (j == DXRICHTEXT_FIRSTLINEHEADINDENT) {
            this.b = d2;
        } else if (j == DXRICHTEXT_LINEHEIGHT) {
            this.g = d2;
        } else if (j == DXRICHTEXT_LINESPACING) {
            this.h = d2;
        } else if (j == -946376925464026374L) {
            this.p = d2;
        } else if (j == DXRICHTEXT_WORDKERN) {
            this.x = d2;
        } else {
            super.onSetDoubleAttribute(j, d2);
        }
    }

    @Override // com.taobao.android.dinamicx.widget.f, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetIntAttribute(long j, int i) {
        if (j == DXRICHTEXT_BASELINE) {
            this.a = i;
        } else if (j == DXRICHTEXT_EXPANDLINES) {
            this.y = i;
        } else {
            if (j == DXRICHTEXT_EXPANDED) {
                this.z = i != 0;
            } else if (j == DXRICHTEXT_SHRINKLINES) {
                this.A = i;
            } else if (j == 9423384817756195L) {
                this.d = i != 0;
            } else if (j == 3527554185889034042L) {
                this.e = i != 0;
            } else if (j == DXRICHTEXT_LINEBREAKMODE) {
                this.f = i;
            } else if (j == DXRICHTEXT_MAXHEIGHT) {
                this.j = i;
            } else if (j == DXRICHTEXT_MAXWIDTH) {
                this.l = i;
            } else if (j == -7272671779511765872L) {
                this.n = i;
            } else if (j == -5920401438808043356L) {
                this.q = i;
            } else if (j == -5902081368050436426L) {
                this.r = i;
            } else if (j == 5737767606580872653L) {
                this.s = Integer.valueOf(i);
            } else if (j == DXRICHTEXT_TEXTGRAVITY) {
                this.t = i;
            } else if (j == 6751005219504497256L) {
                this.u = i;
            } else if (j == 2436253123551448787L) {
                this.v = Integer.valueOf(i);
            } else if (j == 2437398193491227877L) {
                this.w = i;
            } else if (j == 4822617398935994384L) {
                this.B = i != 0;
            } else if (j == DXRICHTEXT_IGNOREUNTRUNCATEDTAP) {
                this.C = i != 0;
            } else if (j == DXRICHTEXT_FORCEORIGINAL) {
                this.D = i != 0;
            } else {
                super.onSetIntAttribute(j, i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.f, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetListAttribute(long j, JSONArray jSONArray) {
        if (j == -946588628814454279L) {
            this.o = jSONArray;
        } else {
            super.onSetListAttribute(j, jSONArray);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetStringAttribute(long j, String str) {
        if (j == 34149272427L) {
            this.c = str;
        } else if (j == 35873943762L) {
            this.i = str;
        } else if (j == 19050239308914L) {
            this.m = str;
        } else {
            super.onSetStringAttribute(j, str);
        }
    }
}
