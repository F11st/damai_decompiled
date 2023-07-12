package com.taobao.android.dinamicx.widget;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.taobao.android.dinamicx.DinamicXEngine;
import com.taobao.android.dinamicx.view.DXNativeCountDownTimerView;
import com.taobao.android.dinamicx.widget.DXWidgetNode;
import tb.hy;
import tb.z00;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class b extends DXWidgetNode {
    public static final int DEFAULT_TEXT_COLOR = -16777216;
    public static final int DXCOUNTDOWNVIEW_FONTSTYLE_BOLD = 1;
    public static final int DXCOUNTDOWNVIEW_FONTSTYLE_NONE = -1;
    public static final int DXCOUNTDOWNVIEW_FONTSTYLE_NORMAL = 0;
    private int c;
    private int d;
    private int e;
    private int f;
    private String g;
    private int i;
    private int j;
    private int k;
    private int l;
    private double m;
    private int o;
    private int s;
    private int t;
    private int u;
    private int v;
    private long w;
    private long x;
    private double y;
    private double z;
    private String a = ":";
    private int b = -16777216;
    private int h = -16777216;
    private int n = -16777216;
    private int p = -1;
    private int q = 0;
    private int r = 0;
    private boolean A = true;
    private boolean B = false;
    private int C = 1;
    private boolean D = false;
    private boolean E = false;
    private int F = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public class a implements DXNativeCountDownTimerView.OnFinishListener {
        a() {
        }

        @Override // com.taobao.android.dinamicx.view.DXNativeCountDownTimerView.OnFinishListener
        public void onFinish() {
            b.this.postEvent(new hy(-6786364507638278416L));
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.dinamicx.widget.b$b  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0296b implements IDXBuilderWidgetNode {
        @Override // com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode
        public DXWidgetNode build(@Nullable Object obj) {
            return new b();
        }
    }

    public b() {
        this.m = 12.0d;
        this.y = 10.0d;
        this.z = 12.0d;
        if (DinamicXEngine.i() != null) {
            this.y = z00.c(DinamicXEngine.i(), 10.0f);
            this.z = z00.c(DinamicXEngine.i(), 12.0f);
            this.m = z00.c(DinamicXEngine.i(), 12.0f);
        }
    }

    private Typeface a(int i) {
        return Typeface.defaultFromStyle(i != 0 ? 1 : 0);
    }

    private void b(DXNativeCountDownTimerView dXNativeCountDownTimerView, int i, int i2, int i3, int i4, double d, int i5, String str) {
        TextView colonFirst = dXNativeCountDownTimerView.getColonFirst();
        TextView colonSecond = dXNativeCountDownTimerView.getColonSecond();
        TextView colonThird = dXNativeCountDownTimerView.getColonThird();
        e(colonFirst, i, i2, i3, i4, 0, 0, d, i5);
        e(colonSecond, i, i2, i3, i4, 0, 0, d, i5);
        if (this.B) {
            colonThird.setVisibility(0);
            e(colonThird, i, i2, i3, i4, 0, 0, d, i5);
        } else {
            colonThird.setVisibility(8);
        }
        colonFirst.setText(str);
        colonSecond.setText(str);
        colonThird.setText(str);
        int i6 = this.F;
        if (i6 != -1) {
            Typeface a2 = a(i6);
            colonFirst.setTypeface(a2);
            colonSecond.setTypeface(a2);
            colonThird.setTypeface(a2);
        }
    }

    private void c(DXNativeCountDownTimerView dXNativeCountDownTimerView, long j, long j2) {
        dXNativeCountDownTimerView.setFutureTime(j);
        dXNativeCountDownTimerView.setCurrentTime(j2);
        if (dXNativeCountDownTimerView.getLastTime() > 0) {
            dXNativeCountDownTimerView.showCountDown();
            dXNativeCountDownTimerView.updateCountView();
            dXNativeCountDownTimerView.getTimer().start();
            dXNativeCountDownTimerView.setOnFinishListener(new a());
            return;
        }
        dXNativeCountDownTimerView.hideCountDown();
        dXNativeCountDownTimerView.getTimer().stop();
        postEvent(new hy(-6786364507638278416L));
    }

    private void d(DXNativeCountDownTimerView dXNativeCountDownTimerView, String str, int i, int i2, int i3, int i4, double d, int i5) {
        TextView seeMoreView = dXNativeCountDownTimerView.getSeeMoreView();
        seeMoreView.setText(str);
        e(seeMoreView, i, i2, i3, i4, 0, 0, d, i5);
    }

    private void e(TextView textView, int i, int i2, int i3, int i4, int i5, int i6, double d, int i7) {
        textView.setTextSize(0, (float) d);
        textView.setTextColor(i7);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) textView.getLayoutParams();
        if (i5 != 0) {
            marginLayoutParams.width = i5;
        }
        if (i6 != 0) {
            marginLayoutParams.height = i6;
        }
        marginLayoutParams.setMargins(i, i2, i3, i4);
        textView.setLayoutParams(marginLayoutParams);
    }

    private void f(TextView textView, TextView textView2, TextView textView3, TextView textView4, int i, int i2) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        float f = i2;
        gradientDrawable.setCornerRadius(f);
        gradientDrawable.setColor(i);
        textView.setBackgroundDrawable(gradientDrawable);
        textView2.setBackgroundDrawable(gradientDrawable);
        textView3.setBackgroundDrawable(gradientDrawable);
        if (this.B) {
            if (this.C == 1 && this.D) {
                GradientDrawable gradientDrawable2 = new GradientDrawable();
                gradientDrawable2.setCornerRadius(f);
                gradientDrawable2.setColor(i);
                textView4.setBackgroundDrawable(gradientDrawable2);
                return;
            }
            textView4.setBackgroundDrawable(gradientDrawable);
        }
    }

    private void g(DXNativeCountDownTimerView dXNativeCountDownTimerView, int i, int i2, int i3, int i4, int i5, int i6, double d, int i7, int i8, int i9) {
        TextView hour = dXNativeCountDownTimerView.getHour();
        TextView minute = dXNativeCountDownTimerView.getMinute();
        TextView second = dXNativeCountDownTimerView.getSecond();
        TextView milli = dXNativeCountDownTimerView.getMilli();
        e(hour, i, i2, i3, i4, i5, i6, d, i7);
        e(minute, i, i2, i3, i4, i5, i6, d, i7);
        e(second, i, i2, i3, i4, i5, i6, d, i7);
        if (this.B) {
            milli.setVisibility(0);
            e(milli, i, i2, i3, i4, (this.C == 1 && this.D && i5 > 0) ? i5 / 2 : i5, i6, d, i7);
        } else {
            milli.setVisibility(8);
        }
        f(hour, minute, second, milli, i8, i9);
        int i10 = this.F;
        if (i10 != -1) {
            Typeface a2 = a(i10);
            hour.setTypeface(a2);
            milli.setTypeface(a2);
            minute.setTypeface(a2);
            second.setTypeface(a2);
        }
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode, com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode
    public DXWidgetNode build(@Nullable Object obj) {
        return new b();
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public int getDefaultValueForIntAttr(long j) {
        if (j == 836506953899434884L || j == -7569082268550024243L) {
            return -16777216;
        }
        if (j == 3586614778875286483L) {
            return -1;
        }
        if (j == -502340563974947291L || j == -7371269035395216254L) {
            return 1;
        }
        if (j == -8574960089337605395L) {
            return 0;
        }
        return super.getDefaultValueForIntAttr(j);
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onClone(DXWidgetNode dXWidgetNode, boolean z) {
        super.onClone(dXWidgetNode, z);
        if (dXWidgetNode instanceof b) {
            b bVar = (b) dXWidgetNode;
            this.w = bVar.w;
            this.x = bVar.x;
            this.b = bVar.b;
            this.a = bVar.a;
            this.c = bVar.c;
            this.d = bVar.d;
            this.e = bVar.e;
            this.f = bVar.f;
            this.y = bVar.y;
            this.g = bVar.g;
            this.m = bVar.m;
            this.h = bVar.h;
            this.j = bVar.j;
            this.l = bVar.l;
            this.k = bVar.k;
            this.i = bVar.i;
            this.n = bVar.n;
            this.o = bVar.o;
            this.p = bVar.p;
            this.q = bVar.q;
            this.r = bVar.r;
            this.s = bVar.s;
            this.t = bVar.t;
            this.v = bVar.v;
            this.u = bVar.u;
            this.z = bVar.z;
            this.A = bVar.A;
            this.B = bVar.B;
            this.C = bVar.C;
            this.D = bVar.D;
            this.E = bVar.E;
            this.F = bVar.F;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public View onCreateView(Context context) {
        return new DXNativeCountDownTimerView(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onMeasure(int i, int i2) {
        int a2 = DXWidgetNode.DXMeasureSpec.a(i);
        int a3 = DXWidgetNode.DXMeasureSpec.a(i2);
        setMeasuredDimension(a2 == 1073741824 ? DXWidgetNode.DXMeasureSpec.b(i) : 0, a3 == 1073741824 ? DXWidgetNode.DXMeasureSpec.b(i2) : 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onRenderView(Context context, View view) {
        if (view == null || !(view instanceof DXNativeCountDownTimerView)) {
            return;
        }
        DXNativeCountDownTimerView dXNativeCountDownTimerView = (DXNativeCountDownTimerView) view;
        if (getDXRuntimeContext() != null && getDXRuntimeContext().getEngineContext() != null) {
            long a2 = getDXRuntimeContext().getEngineContext().a();
            if (this.E && a2 > 0) {
                this.w = a2;
            }
        }
        dXNativeCountDownTimerView.setShowMilliSecond(this.B);
        dXNativeCountDownTimerView.setMilliSecondDigitCount(this.C);
        int tryFetchDarkModeColor = tryFetchDarkModeColor("colonTextColor", 0, this.b);
        int tryFetchDarkModeColor2 = tryFetchDarkModeColor("seeMoreTextColor", 0, this.h);
        int tryFetchDarkModeColor3 = tryFetchDarkModeColor("timerBackgroundColor", 1, this.n);
        g(dXNativeCountDownTimerView, this.t, this.v, this.u, this.s, this.r, this.q, this.z, tryFetchDarkModeColor("timerTextColor", 0, this.p), tryFetchDarkModeColor3, this.o);
        b(dXNativeCountDownTimerView, this.d, this.f, this.e, this.c, this.y, tryFetchDarkModeColor, this.a);
        d(dXNativeCountDownTimerView, this.g, this.j, this.l, this.k, this.i, this.m, tryFetchDarkModeColor2);
        dXNativeCountDownTimerView.setShowSeeMoreText(this.A);
        c(dXNativeCountDownTimerView, this.x, this.w);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetIntAttribute(long j, int i) {
        if (-7569082268550024243L == j) {
            this.b = i;
        } else if (-5446467777356887384L == j) {
            this.c = i;
        } else if (-2349968600282703684L == j) {
            this.d = i;
        } else if (-4097512581907102928L == j) {
            this.e = i;
        } else if (2974479846771431523L == j) {
            this.f = i;
        } else if (836506953899434884L == j) {
            this.h = i;
        } else if (-6389039416330352289L == j) {
            this.i = i;
        } else if (-991465590347635341L == j) {
            this.j = i;
        } else if (6878642454060075239L == j) {
            this.k = i;
        } else if (-1982127542287307750L == j) {
            this.l = i;
        } else if (-2066932502216216012L == j) {
            this.n = i;
        } else if (-7541914668888054013L == j) {
            this.o = i;
        } else if (3586614778875286483L == j) {
            this.p = i;
        } else if (-5195705055003868114L == j) {
            this.q = i;
        } else if (3588042683016644308L == j) {
            this.r = i;
        } else if (4113718844605699246L == j) {
            this.s = i;
        } else if (4975799217651406530L == j) {
            this.t = i;
        } else if (-5434794314794449098L == j) {
            this.u = i;
        } else if (-3498357187900469143L == j) {
            this.v = i;
        } else if (-5268712888762272737L == j) {
            this.m = i;
        } else if (9031654720231161192L == j) {
            this.y = i;
        } else if (5087222913038931822L == j) {
            this.z = i;
        } else {
            if (-502340563974947291L == j) {
                this.A = i != 0;
            } else if (-2361257553306292445L == j) {
                this.B = i != 0;
            } else if (-7371269035395216254L == j) {
                this.C = i;
            } else if (-8574960089337605395L == j) {
                this.D = i != 0;
            } else if (-1047143332071710891L == j) {
                this.E = i != 0;
            } else if (j == -435593654112940591L) {
                this.F = i;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetLongAttribute(long j, long j2) {
        if (8195572952744500637L == j) {
            this.w = j2;
        } else if (8766053855851211060L == j) {
            this.x = j2;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetStringAttribute(long j, String str) {
        if (7523271490450403529L == j) {
            this.a = str;
        } else if (4189101800495477120L == j) {
            this.g = str;
        }
    }
}
