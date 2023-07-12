package tb;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import cn.damai.commonbusiness.dynamicx.customwidget.colorlayout.DMDXColorFrameLayout;
import com.alibaba.fastjson.JSONArray;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.android.dinamicx.widget.DXWidgetNode;
import com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class du extends com.taobao.android.dinamicx.widget.d {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final long DXDMCOLORFRAMELAYOUT_GRADIENT = 2937554514589711958L;
    public static final long DXDMCOLORFRAMELAYOUT_IMAGEURL = 3520785955321526846L;
    public static final long DX_DMCOLORFRAMELAYOUT = -3453172820799319797L;
    public static final long DX_DMCOLORFRAMELAYOUT_GRADIENTENDPOINTX = -3703964337255701544L;
    public static final long DX_DMCOLORFRAMELAYOUT_GRADIENTENDPOINTY = -3703964337255570471L;
    public static final long DX_DMCOLORFRAMELAYOUT_GRADIENTLOCATIONS = -2180576229883493877L;
    public static final long DX_DMCOLORFRAMELAYOUT_GRADIENTSTARTPOINTX = 967009270229382865L;
    public static final long DX_DMCOLORFRAMELAYOUT_GRADIENTSTARTPOINTY = 967009270229907154L;
    public static final long DX_DMCOLORFRAMELAYOUT_GTCOLORS = 2939712638768169045L;
    public static final long DX_DMCOLORFRAMELAYOUT_SHADOWCOLOR = -7272671779511765872L;
    public static final long DX_DMCOLORFRAMELAYOUT_SHADOWOFFSETX = 1186471842813171794L;
    public static final long DX_DMCOLORFRAMELAYOUT_SHADOWOFFSETY = 1186471842813179987L;
    public static final long DX_DMCOLORFRAMELAYOUT_SHADOWOPACITY = 1187712257266486892L;
    public static final long DX_DMCOLORFRAMELAYOUT_SHADOWRADIUS = -946376925464026374L;
    private JSONArray c;
    private double d;
    private double e;
    private JSONArray f;
    private double g;
    private double h;
    private JSONArray i;
    private int j;
    private String k;
    private int l;
    private int m;
    private double n;
    private int o;

    /* compiled from: Taobao */
    /* loaded from: classes4.dex */
    public static class a implements IDXBuilderWidgetNode {
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode
        public DXWidgetNode build(Object obj) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1069098811") ? (DXWidgetNode) ipChange.ipc$dispatch("-1069098811", new Object[]{this, obj}) : new du();
        }
    }

    @Override // com.taobao.android.dinamicx.widget.d, com.taobao.android.dinamicx.widget.DXWidgetNode, com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode
    public DXWidgetNode build(Object obj) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2052665284") ? (DXWidgetNode) ipChange.ipc$dispatch("-2052665284", new Object[]{this, obj}) : new du();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onBindEvent(Context context, View view, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1257769879")) {
            ipChange.ipc$dispatch("-1257769879", new Object[]{this, context, view, Long.valueOf(j)});
        } else {
            super.onBindEvent(context, view, j);
        }
    }

    @Override // com.taobao.android.dinamicx.widget.f, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onClone(DXWidgetNode dXWidgetNode, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "468156918")) {
            ipChange.ipc$dispatch("468156918", new Object[]{this, dXWidgetNode, Boolean.valueOf(z)});
        } else if (dXWidgetNode == null || !(dXWidgetNode instanceof du)) {
        } else {
            super.onClone(dXWidgetNode, z);
            du duVar = (du) dXWidgetNode;
            this.c = duVar.c;
            this.d = duVar.d;
            this.e = duVar.e;
            this.f = duVar.f;
            this.g = duVar.g;
            this.h = duVar.h;
            this.i = duVar.i;
            this.k = duVar.k;
            this.j = duVar.j;
            this.l = duVar.l;
            this.m = duVar.m;
            this.n = duVar.n;
            this.o = duVar.o;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.d, com.taobao.android.dinamicx.widget.DXWidgetNode
    public View onCreateView(Context context) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "513218351") ? (View) ipChange.ipc$dispatch("513218351", new Object[]{this, context}) : new DMDXColorFrameLayout(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.d, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-756502686")) {
            ipChange.ipc$dispatch("-756502686", new Object[]{this, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
        } else {
            super.onLayout(z, i, i2, i3, i4);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.d, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onMeasure(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1824803120")) {
            ipChange.ipc$dispatch("1824803120", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
        } else {
            super.onMeasure(i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.f, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onRenderView(Context context, View view) {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "712594603")) {
            ipChange.ipc$dispatch("712594603", new Object[]{this, context, view});
            return;
        }
        super.onRenderView(context, view);
        if (view == null || !(view instanceof DMDXColorFrameLayout)) {
            return;
        }
        DMDXColorFrameLayout dMDXColorFrameLayout = (DMDXColorFrameLayout) view;
        float[] fArr = getCornerRadius() > 0 ? new float[]{getCornerRadius(), getCornerRadius(), getCornerRadius(), getCornerRadius(), getCornerRadius(), getCornerRadius(), getCornerRadius(), getCornerRadius()} : new float[]{getCornerRadiusLeftTop(), getCornerRadiusLeftTop(), getCornerRadiusRightTop(), getCornerRadiusRightTop(), getCornerRadiusRightBottom(), getCornerRadiusRightBottom(), getCornerRadiusLeftBottom(), getCornerRadiusLeftBottom()};
        float[] fArr2 = null;
        if (t41.b(this.c) > 0) {
            int b = t41.b(this.c);
            if (b > 0) {
                if (b == 1) {
                    fArr2 = new float[]{this.c.getFloatValue(0), this.c.getFloatValue(0)};
                } else {
                    fArr2 = new float[b];
                    while (i < b) {
                        fArr2[i] = this.c.getFloatValue(i);
                        i++;
                    }
                }
            }
            dMDXColorFrameLayout.setImageUrl(this.k, fArr2, fArr);
            return;
        }
        JSONArray jSONArray = this.i;
        if (jSONArray != null && jSONArray.size() > 0) {
            try {
                fArr2 = new int[this.i.size()];
                while (i < this.i.size()) {
                    fArr2[i] = Color.parseColor(this.i.getString(i));
                    i++;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        int[] iArr = fArr2;
        if (tq.b(iArr) > 0 && this.j != 0) {
            dMDXColorFrameLayout.setShadow(iArr, getCornerRadius(), this.j, this.o, this.l, this.m);
        } else if (tq.b(iArr) > 0 && this.j == 0) {
            dMDXColorFrameLayout.setGradientParams(fArr, iArr);
        } else if (tq.b(iArr) > 0 || this.j == 0) {
        } else {
            dMDXColorFrameLayout.setShadow(getCornerRadius(), this.j, this.o, this.l, this.m);
        }
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetDoubleAttribute(long j, double d) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1406434797")) {
            ipChange.ipc$dispatch("1406434797", new Object[]{this, Long.valueOf(j), Double.valueOf(d)});
        } else if (j == DX_DMCOLORFRAMELAYOUT_GRADIENTENDPOINTX) {
            this.d = d;
        } else if (j == DX_DMCOLORFRAMELAYOUT_GRADIENTENDPOINTY) {
            this.e = d;
        } else if (j == DX_DMCOLORFRAMELAYOUT_GRADIENTSTARTPOINTX) {
            this.g = d;
        } else if (j == DX_DMCOLORFRAMELAYOUT_GRADIENTSTARTPOINTY) {
            this.h = d;
        } else if (j == DX_DMCOLORFRAMELAYOUT_SHADOWOPACITY) {
            this.n = d;
        } else {
            super.onSetDoubleAttribute(j, d);
        }
    }

    @Override // com.taobao.android.dinamicx.widget.d, com.taobao.android.dinamicx.widget.f, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetIntAttribute(long j, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1617227678")) {
            ipChange.ipc$dispatch("1617227678", new Object[]{this, Long.valueOf(j), Integer.valueOf(i)});
        } else if (j == -7272671779511765872L) {
            this.j = i;
        } else if (j == DX_DMCOLORFRAMELAYOUT_SHADOWOFFSETX) {
            this.l = i;
        } else if (j == DX_DMCOLORFRAMELAYOUT_SHADOWOFFSETY) {
            this.m = i;
        } else if (j == -946376925464026374L) {
            this.o = i;
        } else {
            super.onSetIntAttribute(j, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.f, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetListAttribute(long j, JSONArray jSONArray) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "919051180")) {
            ipChange.ipc$dispatch("919051180", new Object[]{this, Long.valueOf(j), jSONArray});
        } else if (j == DXDMCOLORFRAMELAYOUT_GRADIENT) {
            this.c = jSONArray;
        } else if (j == DX_DMCOLORFRAMELAYOUT_GRADIENTLOCATIONS) {
            this.f = jSONArray;
        } else if (j == DX_DMCOLORFRAMELAYOUT_GTCOLORS) {
            this.i = jSONArray;
        } else {
            super.onSetListAttribute(j, jSONArray);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetStringAttribute(long j, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1489120325")) {
            ipChange.ipc$dispatch("-1489120325", new Object[]{this, Long.valueOf(j), str});
        } else if (j == DXDMCOLORFRAMELAYOUT_IMAGEURL) {
            this.k = str;
        } else {
            super.onSetStringAttribute(j, str);
        }
    }
}
