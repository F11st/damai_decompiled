package com.taobao.android.dinamicx.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.Nullable;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.DinamicXEngine;
import com.taobao.android.dinamicx.e;
import com.taobao.android.dinamicx.monitor.DXAppMonitor;
import com.taobao.android.dinamicx.view.DXNativeFastText;
import tb.r10;
import tb.w00;
import tb.z00;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class c extends DXWidgetNode {
    public static final int DEFAULT_TEXT_COLOR = -16777216;
    public static final CharSequence ELLIPSIS_TEXT = "…";
    public static int v = 0;
    public static int w = 1;
    int a;
    int b;
    int c;
    int d;
    float f;
    protected TextPaint h;
    StaticLayout i;
    int j;
    int k;
    TextUtils.TruncateAt m;
    float n;
    int o;
    int p;
    Layout.Alignment r;
    int u;
    CharSequence l = "";
    private boolean q = true;
    int s = -1;
    int t = -1;
    CharSequence g = "";
    int e = -16777216;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class a implements IDXBuilderWidgetNode {
        @Override // com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode
        public DXWidgetNode build(@Nullable Object obj) {
            return new c();
        }
    }

    public c() {
        if (v == 0 && DinamicXEngine.i() != null) {
            v = z00.c(DinamicXEngine.i(), 12.0f);
        }
        this.f = v;
        this.k = 0;
        this.c = -1;
        this.b = 0;
        this.j = w;
        this.d = Integer.MAX_VALUE;
    }

    private void a() {
        int i;
        int lineEnd = this.i.getLineEnd(this.j - 1);
        try {
            if (lineEnd <= 0) {
                this.l = "";
                return;
            }
            if (this.m != null && this.g.length() != 1) {
                TextPaint textPaint = this.h;
                CharSequence charSequence = ELLIPSIS_TEXT;
                float width = this.i.getWidth() - textPaint.measureText(charSequence, 0, charSequence.length());
                int lineStart = this.i.getLineStart(this.j - 1);
                TextUtils.TruncateAt truncateAt = this.m;
                if (truncateAt == TextUtils.TruncateAt.END) {
                    int i2 = lineEnd - 1;
                    while (true) {
                        if (i2 < lineStart) {
                            i2 = 0;
                            break;
                        }
                        CharSequence subSequence = this.g.subSequence(lineStart, i2);
                        if (this.h.measureText(subSequence, 0, subSequence.length()) < width) {
                            break;
                        }
                        i2--;
                    }
                    this.l = this.g.subSequence(0, i2).toString() + ((Object) ELLIPSIS_TEXT);
                    return;
                } else if (truncateAt == TextUtils.TruncateAt.START && this.j == 1) {
                    int length = this.g.length();
                    int i3 = length - 1;
                    while (true) {
                        if (i3 < 0) {
                            i = 0;
                            break;
                        } else if (this.h.measureText(this.g, i3, length) > width) {
                            i = i3 + 1;
                            break;
                        } else {
                            i3--;
                        }
                    }
                    this.l = ((Object) ELLIPSIS_TEXT) + this.g.subSequence(i, length).toString();
                    return;
                } else if (truncateAt == TextUtils.TruncateAt.MIDDLE && this.j == 1) {
                    int length2 = this.g.length();
                    float f = 0.0f;
                    int i4 = length2;
                    float f2 = 0.0f;
                    int i5 = 0;
                    boolean z = true;
                    int i6 = 0;
                    while (true) {
                        if (i5 >= length2) {
                            break;
                        } else if (z) {
                            i6++;
                            f = this.h.measureText(this.g, 0, i6);
                            if (f + f2 > width) {
                                i6--;
                                break;
                            } else {
                                z = false;
                                i5++;
                            }
                        } else {
                            i4--;
                            f2 = this.h.measureText(this.g, i4, length2);
                            if (f + f2 > width) {
                                i4++;
                                break;
                            } else {
                                z = true;
                                i5++;
                            }
                        }
                    }
                    this.l = this.g.subSequence(0, i6).toString() + ((Object) ELLIPSIS_TEXT) + ((Object) this.g.subSequence(i4, length2));
                    return;
                } else {
                    return;
                }
            }
            this.l = this.g.subSequence(0, lineEnd);
        } catch (Exception e) {
            this.l = this.g.subSequence(0, lineEnd);
            if (getDXRuntimeContext() != null && !TextUtils.isEmpty(getDXRuntimeContext().getBizType())) {
                com.taobao.android.dinamicx.e dxError = getDXRuntimeContext().getDxError();
                dxError.b = getDXRuntimeContext().getDxTemplateItem();
                dxError.c.add(new e.a("Pipeline_Detail", "Pipeline_Detail_PerformMeasure", 80005));
            } else {
                com.taobao.android.dinamicx.e eVar = new com.taobao.android.dinamicx.e(r10.DB_NAME);
                eVar.c.add(new e.a("Pipeline_Detail", "Pipeline_Detail_PerformMeasure", 80005));
                DXAppMonitor.n(eVar);
            }
            if (DinamicXEngine.x()) {
                e.printStackTrace();
            }
        }
    }

    private StaticLayout h(int i, CharSequence charSequence) {
        boolean z;
        float f;
        boolean z2 = true;
        boolean z3 = this.t >= 0;
        float e = e();
        float descent = this.h.descent() - this.h.ascent();
        boolean z4 = ((float) this.s) >= descent;
        this.o = getPaddingTop();
        this.p = getPaddingBottom();
        float f2 = 0.0f;
        if (z3 && !z4) {
            f2 = Math.max(this.t - (descent - e), 0.0f);
            z2 = false;
        }
        if (z4) {
            float f3 = descent - e;
            int i2 = this.s;
            int i3 = (int) (((i2 - descent) + f3) / 2.0f);
            int max = Math.max((int) (((i2 - descent) - f3) / 2.0f), 0);
            int max2 = Math.max(i3, 0);
            this.o = getPaddingTop() + max;
            this.p = getPaddingBottom() + max2;
            f = z3 ? max + max2 + this.t : max + max2;
            z = false;
        } else {
            z = z2;
            f = f2;
        }
        return new StaticLayout(charSequence, this.h, i, this.r, 1.0f, f, z);
    }

    protected float b(int i) {
        int height = this.i.getHeight();
        int measuredHeight = (getMeasuredHeight() - this.o) - this.p;
        if (height >= measuredHeight || i != 1073741824) {
            return 0.0f;
        }
        return (measuredHeight - height) >> 1;
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode, com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode
    public DXWidgetNode build(@Nullable Object obj) {
        return new c();
    }

    protected Layout.Alignment c(int i) {
        if (getDirection() == 1) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        return Layout.Alignment.ALIGN_OPPOSITE;
                    }
                    return Layout.Alignment.ALIGN_NORMAL;
                }
                return Layout.Alignment.ALIGN_CENTER;
            }
            return Layout.Alignment.ALIGN_OPPOSITE;
        } else if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    return Layout.Alignment.ALIGN_NORMAL;
                }
                return Layout.Alignment.ALIGN_OPPOSITE;
            }
            return Layout.Alignment.ALIGN_CENTER;
        } else {
            return Layout.Alignment.ALIGN_NORMAL;
        }
    }

    protected TextUtils.TruncateAt d(int i) {
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    return null;
                }
                return TextUtils.TruncateAt.END;
            }
            return TextUtils.TruncateAt.MIDDLE;
        }
        return TextUtils.TruncateAt.START;
    }

    public float e() {
        return this.f;
    }

    protected Typeface f(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return Typeface.defaultFromStyle(0);
                    }
                    return Typeface.defaultFromStyle(3);
                }
                return Typeface.defaultFromStyle(2);
            }
            return Typeface.defaultFromStyle(1);
        }
        return Typeface.defaultFromStyle(0);
    }

    protected void g() {
        if (this.h == null) {
            this.h = new TextPaint();
        }
        this.h.setAntiAlias(true);
        this.h.setTextSize(this.f);
        this.h.setColor(tryFetchDarkModeColor("textColor", 0, this.e));
        this.h.setTypeface(f(this.k));
        int i = this.a;
        if (i > 0) {
            this.h.setFlags(i);
        }
        this.m = d(this.c);
        this.r = c(this.b);
        if (this.accessibilityText == null) {
            setAccessibilityText(this.g.toString());
        }
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public int getDefaultValueForIntAttr(long j) {
        if (j == 5737767606580872653L) {
            return -16777216;
        }
        if (j == 6751005219504497256L) {
            return v;
        }
        if (j == w00.DXRICHTEXT_MAXLINES) {
            return w;
        }
        if (j == w00.DXRICHTEXT_LINESPACING || j == w00.DXRICHTEXT_LINEHEIGHT) {
            return -1;
        }
        if (j == 4822617398935994384L) {
            return 1;
        }
        return super.getDefaultValueForIntAttr(j);
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public String getDefaultValueForStringAttr(long j) {
        return j == 38178040921L ? "" : super.getDefaultValueForStringAttr(j);
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onClone(DXWidgetNode dXWidgetNode, boolean z) {
        super.onClone(dXWidgetNode, z);
        if (dXWidgetNode instanceof c) {
            c cVar = (c) dXWidgetNode;
            this.k = cVar.k;
            this.b = cVar.b;
            this.j = cVar.j;
            this.c = cVar.c;
            this.d = cVar.d;
            this.g = cVar.g;
            this.e = cVar.e;
            this.f = cVar.f;
            this.a = cVar.a;
            this.l = cVar.l;
            this.h = cVar.h;
            this.i = cVar.i;
            this.m = cVar.m;
            this.n = cVar.n;
            this.r = cVar.r;
            this.s = cVar.s;
            this.t = cVar.t;
            this.o = cVar.o;
            this.p = cVar.p;
            this.u = cVar.u;
            this.q = cVar.q;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public View onCreateView(Context context) {
        return new DXNativeFastText(context);
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onEndParser() {
        DXRuntimeContext dXRuntimeContext;
        if (this.q && (dXRuntimeContext = this.dXRuntimeContext) != null && dXRuntimeContext.getEngineContext().b().p()) {
            this.f = com.taobao.android.dinamicx.c.b(this.dXRuntimeContext, this.f);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    @SuppressLint({"WrongCall"})
    public void onMeasure(int i, int i2) {
        int min;
        this.l = this.g;
        g();
        if (View.MeasureSpec.getMode(i) == 1073741824) {
            min = View.MeasureSpec.getSize(i);
            this.i = h((min - getPaddingLeft()) - getPaddingRight(), this.l);
        } else {
            min = Math.min(Math.min(((int) this.h.measureText(this.g.toString())) + getPaddingLeft() + getPaddingRight(), View.MeasureSpec.getSize(i)), this.d);
            this.i = h((min - getPaddingLeft()) - getPaddingRight(), this.g);
        }
        int i3 = this.j;
        if (i3 > 0 && i3 < this.i.getLineCount()) {
            this.u = this.i.getLineCount();
            a();
            this.i = h((min - getPaddingLeft()) - getPaddingRight(), this.l);
        } else {
            this.l = this.g;
        }
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode != 1073741824) {
            if (TextUtils.isEmpty(this.g) && this.layoutHeight == -2) {
                size = 0;
            } else {
                int height = this.i.getHeight() + this.p + this.o;
                int i4 = this.j;
                if (i4 > 0 && i4 < this.i.getLineCount()) {
                    height = this.i.getLineTop(this.j);
                }
                size = Math.min(height, size);
            }
        }
        setMeasuredDimension(min, size);
        this.n = b(mode);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onRenderView(Context context, View view) {
        if (view == null || !(view instanceof DXNativeFastText)) {
            return;
        }
        DXNativeFastText dXNativeFastText = (DXNativeFastText) view;
        StaticLayout staticLayout = this.i;
        if (staticLayout != null) {
            dXNativeFastText.setStaticLayout(staticLayout);
        }
        dXNativeFastText.setTranslateY(this.n + this.o);
        dXNativeFastText.setTranslateX(getPaddingLeft());
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetIntAttribute(long j, int i) {
        if (5737767606580872653L == j) {
            this.e = i;
        } else if (w00.DXRICHTEXT_TEXTGRAVITY == j) {
            this.b = i;
        } else if (w00.DXRICHTEXT_MAXLINES == j) {
            if (i > 0) {
                this.j = i;
            } else {
                this.j = Integer.MAX_VALUE;
            }
        } else if (w00.DXRICHTEXT_MAXWIDTH == j) {
            if (i > 0) {
                this.d = i;
            } else {
                this.d = Integer.MAX_VALUE;
            }
        } else if (w00.DXRICHTEXT_LINEBREAKMODE == j) {
            this.c = i;
        } else if (6751005219504497256L == j) {
            if (i > 0) {
                this.f = i;
            } else {
                this.f = v;
            }
        } else {
            if (9423384817756195L == j) {
                int i2 = this.k;
                this.k = i > 0 ? i2 | 1 : i2 & (-2);
            } else if (3527554185889034042L == j) {
                int i3 = this.k;
                this.k = i > 0 ? i3 | 2 : i3 & (-3);
            } else if (-1740854880214056386L == j) {
                int i4 = this.a;
                this.a = i > 0 ? i4 | 17 : i4 & (-18);
            } else if (-8089424158689439347L == j) {
                int i5 = this.a;
                this.a = i > 0 ? i5 | 9 : i5 & (-10);
            } else if (w00.DXRICHTEXT_LINEHEIGHT == j) {
                this.s = i;
            } else if (w00.DXRICHTEXT_LINESPACING == j) {
                this.t = i;
            } else if (4822617398935994384L == j) {
                this.q = i != 0;
            } else {
                super.onSetIntAttribute(j, i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetStringAttribute(long j, String str) {
        if (38178040921L == j) {
            this.g = str;
        } else {
            super.onSetStringAttribute(j, str);
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
}
