package com.taobao.android.dinamicx.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import com.taobao.android.dinamicx.DXGlobalCenter;
import com.taobao.android.dinamicx.DinamicXEngine;
import com.taobao.android.dinamicx.widget.DXImageWidgetNode;
import com.taobao.android.dinamicx.widget.DXWidgetNode;
import tb.ry;
import tb.s00;

/* compiled from: Taobao */
/* renamed from: com.taobao.android.dinamicx.widget.a */
/* loaded from: classes11.dex */
public class C6476a extends DXWidgetNode {
    public static final long DX_WIDGET_ANIMATEDVIEW = -2149351516928899638L;
    private double a = 1.0d;
    private String b;
    private int c;

    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.dinamicx.widget.a$a */
    /* loaded from: classes11.dex */
    public static class C6477a implements IDXBuilderWidgetNode {
        @Override // com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode
        public DXWidgetNode build(Object obj) {
            return new C6476a();
        }
    }

    protected void a(ImageView imageView, int i) {
        if (i == 1) {
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        } else if (i != 2) {
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        } else {
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode, com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode
    public DXWidgetNode build(Object obj) {
        return new C6476a();
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public double getDefaultValueForDoubleAttr(long j) {
        if (j == 7594222789952419722L) {
            return 1.0d;
        }
        return super.getDefaultValueForDoubleAttr(j);
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onClone(DXWidgetNode dXWidgetNode, boolean z) {
        super.onClone(dXWidgetNode, z);
        if (dXWidgetNode instanceof C6476a) {
            C6476a c6476a = (C6476a) dXWidgetNode;
            this.a = c6476a.a;
            this.b = c6476a.b;
            this.c = c6476a.c;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public View onCreateView(Context context) {
        IDXWebImageInterface f = DXGlobalCenter.f(getDXRuntimeContext());
        if (f == null) {
            return new ImageView(context);
        }
        return f.buildView(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onMeasure(int i, int i2) {
        int i3;
        int max;
        int i4;
        int a = DXWidgetNode.DXMeasureSpec.a(i);
        int a2 = DXWidgetNode.DXMeasureSpec.a(i2);
        int i5 = 0;
        boolean z = a != 1073741824;
        boolean z2 = a2 != 1073741824;
        if (!z && !z2) {
            i4 = DXWidgetNode.DXMeasureSpec.b(i);
            max = DXWidgetNode.DXMeasureSpec.b(i2);
        } else {
            double d = this.a;
            if (d <= 0.0d) {
                if (DinamicXEngine.x()) {
                    Log.w("DXAnimatedViewWidgetNode", "DXAnimatedViewWidgetNode", new IllegalArgumentException("非定高顶宽场景下需要设置aspectRatio"));
                }
                s00.b("DXAnimatedViewWidgetNode" + ry.a(new IllegalArgumentException("aspectRatio 非定高顶宽场景下需要设置aspectRatio")));
            }
            if (!z || z2) {
                if (!z && z2) {
                    int size = View.MeasureSpec.getSize(i);
                    if (d > 0.0d) {
                        i5 = size;
                        i3 = (int) (size / d);
                    } else {
                        i5 = size;
                    }
                }
                i3 = 0;
            } else {
                i3 = View.MeasureSpec.getSize(i2);
                if (d > 0.0d) {
                    i5 = (int) (i3 * d);
                }
            }
            int max2 = Math.max(i5, getSuggestedMinimumWidth());
            max = Math.max(i3, getSuggestedMinimumHeight());
            i4 = max2;
        }
        setMeasuredDimension(DXWidgetNode.resolveSize(i4, i), DXWidgetNode.resolveSize(max, i2));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onRenderView(Context context, View view) {
        ImageView imageView = (ImageView) view;
        DXImageWidgetNode.C6440c c6440c = new DXImageWidgetNode.C6440c();
        c6440c.h = true;
        a(imageView, this.c);
        if (TextUtils.isEmpty(this.b)) {
            imageView.setImageDrawable(null);
        }
        IDXWebImageInterface f = DXGlobalCenter.f(getDXRuntimeContext());
        if (f == null) {
            return;
        }
        f.setImage(imageView, this.b, c6440c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetDoubleAttribute(long j, double d) {
        if (j == 7594222789952419722L) {
            this.a = d;
        } else {
            super.onSetDoubleAttribute(j, d);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetIntAttribute(long j, int i) {
        if (j == 1015096712691932083L) {
            this.c = i;
        } else {
            super.onSetIntAttribute(j, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetStringAttribute(long j, String str) {
        if (j == 9274838684923695L) {
            this.b = str;
        } else {
            super.onSetStringAttribute(j, str);
        }
    }
}
