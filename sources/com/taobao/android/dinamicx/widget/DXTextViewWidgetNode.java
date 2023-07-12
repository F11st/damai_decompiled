package com.taobao.android.dinamicx.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.widget.TextViewCompat;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.taobao.android.dinamic.R$id;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.DinamicXEngine;
import com.taobao.android.dinamicx.monitor.DXAppMonitor;
import com.taobao.android.dinamicx.util.FontUtil;
import com.taobao.android.dinamicx.view.DXMeasuredTextView;
import com.taobao.android.dinamicx.view.DXNativeTextView;
import java.util.HashMap;
import tb.d20;
import tb.lm1;
import tb.lz;
import tb.ry;
import tb.s00;
import tb.w00;
import tb.wt;
import tb.y00;
import tb.z00;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class DXTextViewWidgetNode extends DXWidgetNode {
    public static final int DEFAULT_TEXT_COLOR = -16777216;
    public static int q = 0;
    public static int r = 1;
    private static ThreadLocal<lz> s = new ThreadLocal<>();
    private static ThreadLocal<HashMap<Class, DXMeasuredTextView>> t = new ThreadLocal<>();
    private static int u = 0;
    private DXMeasuredTextView a;
    private lz b;
    float e;
    int f;
    int g;
    int h;
    int i;
    int j;
    int k;
    private String l;
    private boolean m = true;
    private boolean n = false;
    private int o = 32767;
    private int p = 1;
    CharSequence c = "";
    int d = -16777216;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class a implements IDXBuilderWidgetNode {
        @Override // com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode
        public DXWidgetNode build(@Nullable Object obj) {
            return new DXTextViewWidgetNode();
        }
    }

    public DXTextViewWidgetNode() {
        if (q == 0 && DinamicXEngine.i() != null) {
            q = z00.c(DinamicXEngine.i(), 12.0f);
        }
        HashMap<Class, DXMeasuredTextView> hashMap = t.get();
        if (hashMap == null) {
            hashMap = new HashMap<>();
            t.set(hashMap);
        }
        DXMeasuredTextView dXMeasuredTextView = hashMap.get(getClass());
        this.a = dXMeasuredTextView;
        if (dXMeasuredTextView == null) {
            if (wt.G0()) {
                if (DinamicXEngine.i() != null) {
                    DXMeasuredTextView dXMeasuredTextView2 = new DXMeasuredTextView(DinamicXEngine.i());
                    this.a = dXMeasuredTextView2;
                    u = dXMeasuredTextView2.getPaintFlags();
                    hashMap.put(getClass(), this.a);
                } else {
                    s00.b("DXTextViewWidgetNode create textViewUtilForMeasure 时 context是空");
                }
            } else {
                DXMeasuredTextView dXMeasuredTextView3 = new DXMeasuredTextView(DinamicXEngine.i());
                this.a = dXMeasuredTextView3;
                u = dXMeasuredTextView3.getPaintFlags();
                hashMap.put(getClass(), this.a);
            }
        }
        lz lzVar = s.get();
        this.b = lzVar;
        if (lzVar == null) {
            lz lzVar2 = new lz();
            this.b = lzVar2;
            s.set(lzVar2);
        }
        this.e = q;
        this.f = 0;
        this.j = -1;
        this.h = 0;
        this.i = 1;
        this.k = -1;
        this.l = "";
    }

    @SuppressLint({"WrongCall"})
    private void c(final int i, final int i2, final int i3, final int i4) {
        if (wt.H0()) {
            try {
                y00.l(new Runnable() { // from class: com.taobao.android.dinamicx.widget.DXTextViewWidgetNode.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            DXMeasuredTextView dXMeasuredTextView = new DXMeasuredTextView(DinamicXEngine.i());
                            DXTextViewWidgetNode.this.h(dXMeasuredTextView);
                            int i5 = R$id.dx_textview_font_tag;
                            if (dXMeasuredTextView.getTag(i5) == null) {
                                return;
                            }
                            int intValue = ((Integer) dXMeasuredTextView.getTag(i5)).intValue();
                            if (intValue == 0) {
                                DXTextViewWidgetNode dXTextViewWidgetNode = DXTextViewWidgetNode.this;
                                dXMeasuredTextView.setTypeface(dXTextViewWidgetNode.e(dXTextViewWidgetNode.f));
                                dXMeasuredTextView.onMeasure(i, i2);
                            } else if (intValue == 1) {
                                DXTextViewWidgetNode dXTextViewWidgetNode2 = DXTextViewWidgetNode.this;
                                dXMeasuredTextView.setTypeface(Typeface.defaultFromStyle(dXTextViewWidgetNode2.f(dXTextViewWidgetNode2.f)));
                                dXMeasuredTextView.onMeasure(i, i2);
                            }
                            int measuredWidthAndState = dXMeasuredTextView.getMeasuredWidthAndState();
                            int measuredHeightAndState = (TextUtils.isEmpty(DXTextViewWidgetNode.this.c) && DXTextViewWidgetNode.this.layoutHeight == -2) ? 0 : dXMeasuredTextView.getMeasuredHeightAndState();
                            if (measuredWidthAndState == i3 && measuredHeightAndState == i4) {
                                return;
                            }
                            DXAppMonitor.p(DXTextViewWidgetNode.this.getDXRuntimeContext(), "DX_TextView_Font", "DX_TextView_Font_Measure_Error", com.taobao.android.dinamicx.e.DX_TEXTVIEW_FONT_MEASURE_ERROR, String.format("text view 宽高计算不一致[width=%s height=%s measuredWidth=%s measuredHeight=%s  manufacturer=%s romName=%s romverName=%s systemModel=%s brand=%s fontStyle=%s  useTypeface=%s]", Integer.valueOf(measuredWidthAndState), Integer.valueOf(measuredHeightAndState), Integer.valueOf(i3), Integer.valueOf(i4), lm1.a(), lm1.d(), lm1.e(), lm1.f(), Build.getBRAND(), intValue + "", wt.I0() + ""));
                        } catch (Throwable th) {
                            ry.b(th);
                        }
                    }
                });
            } catch (Throwable th) {
                ry.b(th);
            }
        }
    }

    public static void d() {
        t = new ThreadLocal<>();
        q = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Typeface e(int i) {
        Typeface typeface = Typeface.DEFAULT;
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    return i != 3 ? typeface : Typeface.defaultFromStyle(3);
                }
                return Typeface.defaultFromStyle(2);
            }
            return Typeface.DEFAULT_BOLD;
        }
        return typeface;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int f(int i) {
        if (i != 0) {
            if (i == 1) {
                return 1;
            }
            if (i == 2) {
                return 2;
            }
            if (i == 3) {
                return 3;
            }
        }
        return 0;
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode, com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode
    public DXWidgetNode build(@Nullable Object obj) {
        return new DXTextViewWidgetNode();
    }

    public int g() {
        return this.d;
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public int getDefaultValueForIntAttr(long j) {
        if (j == 5737767606580872653L) {
            return -16777216;
        }
        if (j == 6751005219504497256L) {
            return q;
        }
        if (j == w00.DXRICHTEXT_MAXLINES) {
            return r;
        }
        if (j == 4822617398935994384L) {
            return 1;
        }
        if (j == 1174195049226651996L) {
            return 0;
        }
        if (j == -7175398628172498739L) {
            return 32767;
        }
        if (j == 5734523154528465099L) {
            return 1;
        }
        return super.getDefaultValueForIntAttr(j);
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public String getDefaultValueForStringAttr(long j) {
        return j == 38178040921L ? "" : super.getDefaultValueForStringAttr(j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h(TextView textView) {
        ViewGroup.LayoutParams generateLayoutParams;
        i(textView);
        lz lzVar = this.b;
        lzVar.a = this.layoutWidth;
        lzVar.b = this.layoutHeight;
        lzVar.c = this.weight;
        int i = this.layoutGravity;
        if (i != lzVar.e) {
            lzVar.d = d20.a(DXWidgetNode.getAbsoluteGravity(i, getDirection()));
            this.b.e = this.layoutGravity;
        }
        f fVar = (f) this.parentWidget;
        ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
        if (layoutParams == null) {
            generateLayoutParams = fVar.generateLayoutParams(this.b);
        } else {
            generateLayoutParams = fVar.generateLayoutParams(this.b, layoutParams);
        }
        textView.setLayoutParams(generateLayoutParams);
    }

    protected void i(TextView textView) {
        o(textView, this.c);
        float textSize = textView.getTextSize();
        float f = this.e;
        if (textSize != f) {
            textView.setTextSize(0, f);
        }
        if (!TextUtils.isEmpty(this.l)) {
            q(textView, this.l, this.f);
        } else {
            s(textView, this.f);
        }
        m(textView, this.i);
        l(textView, this.j);
        n(textView, this.k);
        p(textView, this.g);
    }

    protected void j(TextView textView, int i, int i2) {
        if (!this.n || i2 <= 0 || i <= 0) {
            return;
        }
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                textView.setAutoSizeTextTypeUniformWithConfiguration(i, i2, 1, 0);
            } else {
                TextViewCompat.setAutoSizeTextTypeUniformWithConfiguration(textView, i, i2, 1, 0);
            }
        } catch (Throwable th) {
            ry.b(th);
        }
    }

    protected void k(TextView textView, int i) {
        textView.setTag(R$id.dx_textview_font_tag, 0);
        textView.setTypeface(Typeface.defaultFromStyle(f(i)));
    }

    protected void l(TextView textView, int i) {
        if (i == 0) {
            textView.setEllipsize(null);
        } else if (i == 1) {
            textView.setEllipsize(TextUtils.TruncateAt.START);
        } else if (i == 2) {
            textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        } else if (i != 3) {
        } else {
            textView.setEllipsize(TextUtils.TruncateAt.END);
        }
    }

    protected void m(TextView textView, int i) {
        if (i > 0) {
            textView.setMaxLines(i);
        } else {
            textView.setMaxLines(Integer.MAX_VALUE);
        }
    }

    protected void n(TextView textView, int i) {
        if (i > 0) {
            textView.setMaxWidth(i);
        } else {
            textView.setMaxWidth(Integer.MAX_VALUE);
        }
    }

    protected void o(TextView textView, CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            textView.setText("");
        } else {
            textView.setText(charSequence);
        }
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onClone(DXWidgetNode dXWidgetNode, boolean z) {
        super.onClone(dXWidgetNode, z);
        if (dXWidgetNode instanceof DXTextViewWidgetNode) {
            DXTextViewWidgetNode dXTextViewWidgetNode = (DXTextViewWidgetNode) dXWidgetNode;
            this.f = dXTextViewWidgetNode.f;
            this.h = dXTextViewWidgetNode.h;
            this.i = dXTextViewWidgetNode.i;
            this.j = dXTextViewWidgetNode.j;
            this.k = dXTextViewWidgetNode.k;
            this.c = dXTextViewWidgetNode.c;
            this.d = dXTextViewWidgetNode.d;
            this.e = dXTextViewWidgetNode.e;
            this.g = dXTextViewWidgetNode.g;
            this.l = dXTextViewWidgetNode.l;
            this.m = dXTextViewWidgetNode.m;
            this.n = dXTextViewWidgetNode.n;
            this.o = dXTextViewWidgetNode.o;
            this.p = dXTextViewWidgetNode.p;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public View onCreateView(Context context) {
        return new DXNativeTextView(context);
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onEndParser() {
        DXRuntimeContext dXRuntimeContext;
        if (this.m && (dXRuntimeContext = this.dXRuntimeContext) != null && dXRuntimeContext.getEngineContext().b().p()) {
            this.e = com.taobao.android.dinamicx.c.b(this.dXRuntimeContext, this.e);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    @SuppressLint({"WrongCall"})
    public void onMeasure(int i, int i2) {
        DXMeasuredTextView dXMeasuredTextView;
        if (View.MeasureSpec.getMode(i) == 1073741824 && View.MeasureSpec.getMode(i2) == 1073741824) {
            setMeasuredDimension(i, i2);
            return;
        }
        if (wt.z0() && ((dXMeasuredTextView = this.a) == null || dXMeasuredTextView.getInitThreadId() != Thread.currentThread().getId())) {
            HashMap<Class, DXMeasuredTextView> hashMap = t.get();
            if (hashMap == null) {
                hashMap = new HashMap<>();
                t.set(hashMap);
            }
            DXMeasuredTextView dXMeasuredTextView2 = hashMap.get(getClass());
            this.a = dXMeasuredTextView2;
            if (dXMeasuredTextView2 == null) {
                DXMeasuredTextView dXMeasuredTextView3 = new DXMeasuredTextView(DinamicXEngine.i());
                this.a = dXMeasuredTextView3;
                u = dXMeasuredTextView3.getPaintFlags();
                hashMap.put(getClass(), this.a);
            }
        }
        h(this.a);
        this.a.onMeasure(i, i2);
        if (TextUtils.isEmpty(this.c) && this.layoutHeight == -2) {
            setMeasuredDimension(this.a.getMeasuredWidthAndState(), 0);
        } else {
            setMeasuredDimension(this.a.getMeasuredWidthAndState(), this.a.getMeasuredHeightAndState());
        }
        c(i, i2, this.measuredWidth, this.measuredHeight);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onRenderView(Context context, View view) {
        if (view == null || !(view instanceof TextView)) {
            return;
        }
        TextView textView = (TextView) view;
        o(textView, this.c);
        textView.setTextColor(tryFetchDarkModeColor("textColor", 0, this.d));
        textView.setTextSize(0, this.e);
        if (!TextUtils.isEmpty(this.l)) {
            q(textView, this.l, this.f);
        } else {
            int i = this.f;
            if (i != -1) {
                s(textView, i);
            }
        }
        m(textView, this.i);
        r(textView, this.h);
        int i2 = this.j;
        if (i2 != -1) {
            l(textView, i2);
        }
        int i3 = this.k;
        if (i3 != -1) {
            n(textView, i3);
        }
        p(textView, this.g);
        j(textView, this.p, this.o);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetDoubleAttribute(long j, double d) {
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetIntAttribute(long j, int i) {
        if (5737767606580872653L == j) {
            this.d = i;
        } else if (w00.DXRICHTEXT_TEXTGRAVITY == j) {
            this.h = i;
        } else if (w00.DXRICHTEXT_MAXLINES == j) {
            if (i > 0) {
                this.i = i;
            } else {
                this.i = Integer.MAX_VALUE;
            }
        } else if (w00.DXRICHTEXT_MAXWIDTH == j) {
            if (i > 0) {
                this.k = i;
            } else {
                this.k = Integer.MAX_VALUE;
            }
        } else if (w00.DXRICHTEXT_LINEBREAKMODE == j) {
            this.j = i;
        } else if (6751005219504497256L == j) {
            if (i > 0) {
                this.e = i;
            } else {
                this.e = q;
            }
        } else {
            if (9423384817756195L == j) {
                int i2 = this.f;
                this.f = i > 0 ? i2 | 1 : i2 & (-2);
            } else if (3527554185889034042L == j) {
                int i3 = this.f;
                this.f = i > 0 ? i3 | 2 : i3 & (-3);
            } else if (-1740854880214056386L == j) {
                int i4 = this.g;
                this.g = i > 0 ? i4 | 17 : i4 & (-18);
            } else if (-8089424158689439347L == j) {
                int i5 = this.g;
                this.g = i > 0 ? i5 | 9 : i5 & (-10);
            } else if (4822617398935994384L == j) {
                this.m = i != 0;
            } else if (1174195049226651996L == j) {
                this.n = i != 0;
            } else if (-7175398628172498739L == j) {
                if (i > 0) {
                    this.o = i;
                } else {
                    this.o = 32767;
                }
            } else if (5734523154528465099L != j) {
                super.onSetIntAttribute(j, i);
            } else if (i > 0) {
                this.p = i;
            } else {
                this.p = 1;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetStringAttribute(long j, String str) {
        if (38178040921L == j) {
            this.c = str;
        } else if (j == 34149272427L) {
            this.l = str;
        } else {
            super.onSetStringAttribute(j, str);
        }
    }

    protected void p(TextView textView, int i) {
        if (i != textView.getPaintFlags()) {
            if (i == 0) {
                i = u;
            }
            textView.getPaint().setFlags(i);
        }
    }

    protected void q(TextView textView, String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            if (DinamicXEngine.i() == null) {
                s(textView, i);
                return;
            }
            Typeface b = FontUtil.c().b(str, f(i));
            if (b != null) {
                textView.setTypeface(b);
                textView.setTag(R$id.dx_textview_font_tag, 2);
                return;
            }
            s(textView, i);
        } catch (Throwable th) {
            s(textView, i);
            ry.c(th, false);
        }
    }

    protected void r(TextView textView, int i) {
        if (getDirection() == 1) {
            if (i == 0) {
                textView.setGravity(21);
            } else if (i == 1) {
                textView.setGravity(17);
            } else if (i == 2) {
                textView.setGravity(19);
            } else {
                textView.setGravity(16);
            }
        } else if (i == 0) {
            textView.setGravity(19);
        } else if (i == 1) {
            textView.setGravity(17);
        } else if (i == 2) {
            textView.setGravity(21);
        } else {
            textView.setGravity(16);
        }
    }

    protected void s(TextView textView, int i) {
        if (wt.I0()) {
            v(textView, i);
        } else {
            k(textView, i);
        }
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    void setAccessibility(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            String str = this.accessibilityText;
            if (str != null) {
                view.setContentDescription(str);
            }
            int i = this.accessibility;
            if (i == 3) {
                return;
            }
            if (i == 1 || i == -1) {
                view.setImportantForAccessibility(1);
                view.setFocusable(true);
                return;
            } else if (i == 2) {
                view.setImportantForAccessibility(4);
                return;
            } else {
                view.setImportantForAccessibility(2);
                return;
            }
        }
        view.setContentDescription("");
    }

    public void t(CharSequence charSequence) {
        this.c = charSequence;
    }

    public void u(int i) {
        this.d = i;
    }

    protected void v(TextView textView, int i) {
        textView.setTag(R$id.dx_textview_font_tag, 1);
        textView.setTypeface(e(i));
    }
}
