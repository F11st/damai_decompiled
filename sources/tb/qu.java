package tb;

import android.content.Context;
import android.view.View;
import cn.damai.commonbusiness.dynamicx.customwidget.textview.DMUltronSellView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.android.dinamicx.widget.DXTextViewWidgetNode;
import com.taobao.android.dinamicx.widget.DXWidgetNode;
import com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class qu extends DXTextViewWidgetNode {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final long DXDMSELLTEXTVIEW_ITEMNAME = 3528824657463466040L;
    public static final long DXDMSELLTEXTVIEW_ITEMSELLTIP = -5946406911668095369L;
    public static final long DX_DMSELLTEXTVIEW = 530239555773748079L;
    private String v;
    private String w;

    /* compiled from: Taobao */
    /* loaded from: classes4.dex */
    public static class a implements IDXBuilderWidgetNode {
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode
        public DXWidgetNode build(Object obj) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-683960116") ? (DXWidgetNode) ipChange.ipc$dispatch("-683960116", new Object[]{this, obj}) : new qu();
        }
    }

    @Override // com.taobao.android.dinamicx.widget.DXTextViewWidgetNode, com.taobao.android.dinamicx.widget.DXWidgetNode, com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode
    public DXWidgetNode build(Object obj) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "526616387") ? (DXWidgetNode) ipChange.ipc$dispatch("526616387", new Object[]{this, obj}) : new qu();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onBindEvent(Context context, View view, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "171634754")) {
            ipChange.ipc$dispatch("171634754", new Object[]{this, context, view, Long.valueOf(j)});
        } else {
            super.onBindEvent(context, view, j);
        }
    }

    @Override // com.taobao.android.dinamicx.widget.DXTextViewWidgetNode, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onClone(DXWidgetNode dXWidgetNode, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1830027581")) {
            ipChange.ipc$dispatch("1830027581", new Object[]{this, dXWidgetNode, Boolean.valueOf(z)});
        } else if (dXWidgetNode == null || !(dXWidgetNode instanceof qu)) {
        } else {
            super.onClone(dXWidgetNode, z);
            qu quVar = (qu) dXWidgetNode;
            this.v = quVar.v;
            this.w = quVar.w;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXTextViewWidgetNode, com.taobao.android.dinamicx.widget.DXWidgetNode
    public View onCreateView(Context context) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "697875510") ? (View) ipChange.ipc$dispatch("697875510", new Object[]{this, context}) : new DMUltronSellView(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXTextViewWidgetNode, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onMeasure(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1043342153")) {
            ipChange.ipc$dispatch("-1043342153", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
        } else {
            super.onMeasure(i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXTextViewWidgetNode, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onRenderView(Context context, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2141999236")) {
            ipChange.ipc$dispatch("2141999236", new Object[]{this, context, view});
            return;
        }
        super.onRenderView(context, view);
        if (view == null || !(view instanceof DMUltronSellView)) {
            return;
        }
        ((DMUltronSellView) view).setItemSellDesc(this.v, this.w);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXTextViewWidgetNode, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetStringAttribute(long j, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-148871486")) {
            ipChange.ipc$dispatch("-148871486", new Object[]{this, Long.valueOf(j), str});
        } else if (j == DXDMSELLTEXTVIEW_ITEMNAME) {
            this.v = str;
        } else if (j == DXDMSELLTEXTVIEW_ITEMSELLTIP) {
            this.w = str;
        } else {
            super.onSetStringAttribute(j, str);
        }
    }
}
