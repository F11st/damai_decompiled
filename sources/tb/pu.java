package tb;

import android.content.Context;
import android.view.View;
import cn.damai.commonbusiness.dynamicx.customwidget.scaleimage.DMDXScaleAnimationImage;
import com.alibaba.fastjson.JSONArray;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.android.dinamicx.widget.DXWidgetNode;
import java.util.ArrayList;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class pu extends DXWidgetNode {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final long DXDMSCALEANIMATIONVIEW_ANIMATIONDURATION = 7542118000091127575L;
    public static final long DXDMSCALEANIMATIONVIEW_ANIMATIONINVERTAL = -1911798644495483370L;
    public static final long DXDMSCALEANIMATIONVIEW_DMSCALEANIMATIONVIEW = 3754100569737524168L;
    public static final long DXDMSCALEANIMATIONVIEW_IMAGELIST = 8842287391283277224L;
    private long a;
    private long b;
    private JSONArray c;

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode, com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode
    public DXWidgetNode build(Object obj) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-787554841") ? (DXWidgetNode) ipChange.ipc$dispatch("-787554841", new Object[]{this, obj}) : new pu();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onBindEvent(Context context, View view, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2114561566")) {
            ipChange.ipc$dispatch("2114561566", new Object[]{this, context, view, Long.valueOf(j)});
        } else {
            super.onBindEvent(context, view, j);
        }
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onClone(DXWidgetNode dXWidgetNode, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1931216609")) {
            ipChange.ipc$dispatch("1931216609", new Object[]{this, dXWidgetNode, Boolean.valueOf(z)});
        } else if (dXWidgetNode == null || !(dXWidgetNode instanceof pu)) {
        } else {
            super.onClone(dXWidgetNode, z);
            pu puVar = (pu) dXWidgetNode;
            this.a = puVar.a;
            this.b = puVar.b;
            this.c = puVar.c;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public View onCreateView(Context context) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1871848742") ? (View) ipChange.ipc$dispatch("-1871848742", new Object[]{this, context}) : new DMDXScaleAnimationImage(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1168283443")) {
            ipChange.ipc$dispatch("-1168283443", new Object[]{this, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
        } else {
            super.onLayout(z, i, i2, i3, i4);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onMeasure(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1381917019")) {
            ipChange.ipc$dispatch("1381917019", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
        } else {
            super.onMeasure(i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onRenderView(Context context, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-210041248")) {
            ipChange.ipc$dispatch("-210041248", new Object[]{this, context, view});
            return;
        }
        super.onRenderView(context, view);
        if (view == null || !(view instanceof DMDXScaleAnimationImage)) {
            return;
        }
        DMDXScaleAnimationImage dMDXScaleAnimationImage = (DMDXScaleAnimationImage) view;
        dMDXScaleAnimationImage.setDuration(this.a);
        dMDXScaleAnimationImage.setInterval(this.b);
        cb1.b("pcj", "imageUrlSize = " + t41.b(this.c));
        if (t41.b(this.c) <= 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < t41.b(this.c); i++) {
            Object obj = this.c.get(i);
            StringBuilder sb = new StringBuilder();
            sb.append("urlObj instanceof String = ");
            boolean z = obj instanceof String;
            sb.append(z);
            cb1.b("pcj", sb.toString());
            if (z) {
                String str = (String) obj;
                cb1.b("pcj", "imageUrl = " + str);
                if (!wh2.j(str)) {
                    arrayList.add(str);
                }
            }
        }
        dMDXScaleAnimationImage.setImageList(arrayList);
        dMDXScaleAnimationImage.startAnimation();
        cb1.b("pcj", "startAnimation");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetListAttribute(long j, JSONArray jSONArray) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1655640873")) {
            ipChange.ipc$dispatch("-1655640873", new Object[]{this, Long.valueOf(j), jSONArray});
        } else if (j == DXDMSCALEANIMATIONVIEW_IMAGELIST) {
            this.c = jSONArray;
        } else {
            super.onSetListAttribute(j, jSONArray);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetLongAttribute(long j, long j2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-350595501")) {
            ipChange.ipc$dispatch("-350595501", new Object[]{this, Long.valueOf(j), Long.valueOf(j2)});
        } else if (j == 7542118000091127575L) {
            this.a = j2;
        } else if (j == -1911798644495483370L) {
            this.b = j2;
        } else {
            super.onSetLongAttribute(j, j2);
        }
    }
}
