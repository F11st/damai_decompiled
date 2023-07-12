package tb;

import android.content.Context;
import android.view.View;
import cn.damai.commonbusiness.dynamicx.customwidget.liveroom.DmImageAnimView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.android.dinamicx.widget.DXWidgetNode;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class dy extends DXWidgetNode {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final long DXDMIMAGEANIMVIEW_BUNDLENAME = 427114982425999621L;
    public static final long DXDMIMAGEANIMVIEW_DMIMAGEANIMVIEW = -6721763298045482813L;
    public static final long DXDMIMAGEANIMVIEW_LOTTIENAME = -1933963517306291684L;
    private String a;
    private String b;

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode, com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode
    public DXWidgetNode build(Object obj) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1147477405") ? (DXWidgetNode) ipChange.ipc$dispatch("-1147477405", new Object[]{this, obj}) : new dy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onBindEvent(Context context, View view, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "215791906")) {
            ipChange.ipc$dispatch("215791906", new Object[]{this, context, view, Long.valueOf(j)});
        } else {
            super.onBindEvent(context, view, j);
        }
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onClone(DXWidgetNode dXWidgetNode, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1096068003")) {
            ipChange.ipc$dispatch("-1096068003", new Object[]{this, dXWidgetNode, Boolean.valueOf(z)});
        } else if (dXWidgetNode == null || !(dXWidgetNode instanceof dy)) {
        } else {
            super.onClone(dXWidgetNode, z);
            dy dyVar = (dy) dXWidgetNode;
            this.a = dyVar.a;
            this.b = dyVar.b;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public View onCreateView(Context context) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "422205270") ? (View) ipChange.ipc$dispatch("422205270", new Object[]{this, context}) : new DmImageAnimView(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onMeasure(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1250797527")) {
            ipChange.ipc$dispatch("1250797527", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
        } else {
            super.onMeasure(i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onRenderView(Context context, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2108810908")) {
            ipChange.ipc$dispatch("-2108810908", new Object[]{this, context, view});
            return;
        }
        super.onRenderView(context, view);
        if (view == null || !(view instanceof DmImageAnimView)) {
            return;
        }
        ((DmImageAnimView) view).updateImageAnim(context, this.b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetStringAttribute(long j, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1232322078")) {
            ipChange.ipc$dispatch("-1232322078", new Object[]{this, Long.valueOf(j), str});
        } else if (j == DXDMIMAGEANIMVIEW_BUNDLENAME) {
            this.a = str;
        } else if (j == DXDMIMAGEANIMVIEW_LOTTIENAME) {
            this.b = str;
        } else {
            super.onSetStringAttribute(j, str);
        }
    }
}
