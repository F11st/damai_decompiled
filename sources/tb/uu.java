package tb;

import android.content.Context;
import android.view.View;
import cn.damai.commonbusiness.dynamicx.customwidget.scrollerlayout.DXViewFlipper;
import com.alibaba.fastjson.JSONArray;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.android.dinamicx.widget.DXWidgetNode;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class uu extends DXWidgetNode {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final long DXDMVIEWFLIPPER_ANIMATETIME = 4553219649980565881L;
    public static final long DXDMVIEWFLIPPER_DATA = 33556442494L;
    public static final long DXDMVIEWFLIPPER_DMVIEWFLIPPER = -6786860215198286837L;
    public static final long DXDMVIEWFLIPPER_INTERVAL = 3522016527368756845L;
    private double a;
    private JSONArray b;
    private double c;

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode, com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode
    public DXWidgetNode build(Object obj) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1396665260") ? (DXWidgetNode) ipChange.ipc$dispatch("1396665260", new Object[]{this, obj}) : new uu();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onBindEvent(Context context, View view, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-384178439")) {
            ipChange.ipc$dispatch("-384178439", new Object[]{this, context, view, Long.valueOf(j)});
        } else {
            super.onBindEvent(context, view, j);
        }
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onClone(DXWidgetNode dXWidgetNode, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1779687782")) {
            ipChange.ipc$dispatch("1779687782", new Object[]{this, dXWidgetNode, Boolean.valueOf(z)});
        } else if (dXWidgetNode == null || !(dXWidgetNode instanceof uu)) {
        } else {
            super.onClone(dXWidgetNode, z);
            uu uuVar = (uu) dXWidgetNode;
            this.a = uuVar.a;
            this.b = uuVar.b;
            this.c = uuVar.c;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public View onCreateView(Context context) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-566979937") ? (View) ipChange.ipc$dispatch("-566979937", new Object[]{this, context}) : new DXViewFlipper(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1729001170")) {
            ipChange.ipc$dispatch("1729001170", new Object[]{this, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
        } else {
            super.onLayout(z, i, i2, i3, i4);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onMeasure(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-241881952")) {
            ipChange.ipc$dispatch("-241881952", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
        } else {
            super.onMeasure(i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onRenderView(Context context, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1586186043")) {
            ipChange.ipc$dispatch("1586186043", new Object[]{this, context, view});
            return;
        }
        super.onRenderView(context, view);
        if (view == null || !(view instanceof DXViewFlipper)) {
            return;
        }
        DXViewFlipper dXViewFlipper = (DXViewFlipper) view;
        dXViewFlipper.setAnimateTime((long) this.a);
        dXViewFlipper.setInterval((int) this.c);
        dXViewFlipper.createView(this.b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetDoubleAttribute(long j, double d) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1872751491")) {
            ipChange.ipc$dispatch("-1872751491", new Object[]{this, Long.valueOf(j), Double.valueOf(d)});
        } else if (j == 4553219649980565881L) {
            this.a = d;
        } else if (j == 3522016527368756845L) {
            this.c = d;
        } else {
            super.onSetDoubleAttribute(j, d);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetListAttribute(long j, JSONArray jSONArray) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "936136476")) {
            ipChange.ipc$dispatch("936136476", new Object[]{this, Long.valueOf(j), jSONArray});
        } else if (j == DXDMVIEWFLIPPER_DATA) {
            this.b = jSONArray;
        } else {
            super.onSetListAttribute(j, jSONArray);
        }
    }
}
