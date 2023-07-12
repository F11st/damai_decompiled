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
public class ku extends DXWidgetNode {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final long DXDMHOMEMARKETADVIEW_ANIMATIONDURATION = 7542118000091127575L;
    public static final long DXDMHOMEMARKETADVIEW_ANIMATIONINVERTAL = -1911798644495483370L;
    public static final long DXDMHOMEMARKETADVIEW_CONTENTLIST = 5151831634233551778L;
    public static final long DXDMHOMEMARKETADVIEW_DMHOMEMARKETADVIEW = -5106943729652684368L;
    private double a;
    private double b;
    private JSONArray c;

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode, com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode
    public DXWidgetNode build(Object obj) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1813839645") ? (DXWidgetNode) ipChange.ipc$dispatch("-1813839645", new Object[]{this, obj}) : new ku();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onBindEvent(Context context, View view, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-768906590")) {
            ipChange.ipc$dispatch("-768906590", new Object[]{this, context, view, Long.valueOf(j)});
        } else {
            super.onBindEvent(context, view, j);
        }
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onClone(DXWidgetNode dXWidgetNode, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1556950307")) {
            ipChange.ipc$dispatch("-1556950307", new Object[]{this, dXWidgetNode, Boolean.valueOf(z)});
        } else if (dXWidgetNode == null || !(dXWidgetNode instanceof ku)) {
        } else {
            super.onClone(dXWidgetNode, z);
            ku kuVar = (ku) dXWidgetNode;
            this.a = kuVar.a;
            this.b = kuVar.b;
            this.c = kuVar.c;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public View onCreateView(Context context) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-25201194") ? (View) ipChange.ipc$dispatch("-25201194", new Object[]{this, context}) : new DMDXScaleAnimationImage(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-312459575")) {
            ipChange.ipc$dispatch("-312459575", new Object[]{this, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
        } else {
            super.onLayout(z, i, i2, i3, i4);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onMeasure(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1026128297")) {
            ipChange.ipc$dispatch("-1026128297", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
        } else {
            super.onMeasure(i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onRenderView(Context context, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1201457892")) {
            ipChange.ipc$dispatch("1201457892", new Object[]{this, context, view});
            return;
        }
        super.onRenderView(context, view);
        if (view == null || !(view instanceof DMDXScaleAnimationImage)) {
            return;
        }
        DMDXScaleAnimationImage dMDXScaleAnimationImage = (DMDXScaleAnimationImage) view;
        dMDXScaleAnimationImage.setDuration((long) (this.a * 1000.0d));
        dMDXScaleAnimationImage.setInterval((long) (this.b * 1000.0d));
        if (t41.b(this.c) <= 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < t41.b(this.c); i++) {
            Object obj = this.c.get(i);
            if (obj instanceof String) {
                String str = (String) obj;
                if (!wh2.j(str)) {
                    arrayList.add(str);
                }
            }
        }
        dMDXScaleAnimationImage.setImageList(arrayList);
        dMDXScaleAnimationImage.startAnimation();
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetDoubleAttribute(long j, double d) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1593463398")) {
            ipChange.ipc$dispatch("1593463398", new Object[]{this, Long.valueOf(j), Double.valueOf(d)});
        } else if (j == 7542118000091127575L) {
            this.a = d;
        } else if (j == -1911798644495483370L) {
            this.b = d;
        } else {
            super.onSetDoubleAttribute(j, d);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetListAttribute(long j, JSONArray jSONArray) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "696214995")) {
            ipChange.ipc$dispatch("696214995", new Object[]{this, Long.valueOf(j), jSONArray});
        } else if (j == DXDMHOMEMARKETADVIEW_CONTENTLIST) {
            this.c = jSONArray;
        } else {
            super.onSetListAttribute(j, jSONArray);
        }
    }
}
