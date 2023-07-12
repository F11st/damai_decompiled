package tb;

import android.content.Context;
import android.view.View;
import cn.damai.uikit.tag.DMCategroyTagView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.android.dinamicx.widget.DXWidgetNode;
import com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class iu extends DXWidgetNode {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final long DX_DMHOMECARDTAGVIEW = -1894840009740061348L;
    public static final long DX_DMHOMECARDTAGVIEW_FONTNAME = 2639694824232449600L;
    public static final long DX_DMHOMECARDTAGVIEW_POINTSIZE = -2396097246344434994L;
    public static final long DX_DMHOMECARDTAGVIEW_TEXT = 38178040921L;
    public static final long DX_DMHOMECARDTAGVIEW_TEXTCOLOR = 5737767606580872653L;
    public static final long DX_DMHOMECARDTAGVIEW_TEXTSTYLE = 5737803457717833695L;
    public static final long USER_DEFINE_PARAM_HASH_CODE = 9999999999L;
    private String a;
    private int b;
    private String c;
    private String d;
    private String e;
    private int f;

    /* compiled from: Taobao */
    /* loaded from: classes4.dex */
    public static class a implements IDXBuilderWidgetNode {
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode
        public DXWidgetNode build(Object obj) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "662411594") ? (DXWidgetNode) ipChange.ipc$dispatch("662411594", new Object[]{this, obj}) : new iu();
        }
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode, com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode
    public DXWidgetNode build(Object obj) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1808603711") ? (DXWidgetNode) ipChange.ipc$dispatch("-1808603711", new Object[]{this, obj}) : new iu();
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public int getDefaultValueForIntAttr(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-197765888")) {
            return ((Integer) ipChange.ipc$dispatch("-197765888", new Object[]{this, Long.valueOf(j)})).intValue();
        }
        if (j == 9999999999L) {
            return -100;
        }
        return super.getDefaultValueForIntAttr(j);
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onBeforeBindChildData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1956104183")) {
            ipChange.ipc$dispatch("-1956104183", new Object[]{this});
        } else {
            super.onBeforeBindChildData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onBindEvent(Context context, View view, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1318462852")) {
            ipChange.ipc$dispatch("1318462852", new Object[]{this, context, view, Long.valueOf(j)});
        } else {
            super.onBindEvent(context, view, j);
        }
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onClone(DXWidgetNode dXWidgetNode, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1273007045")) {
            ipChange.ipc$dispatch("-1273007045", new Object[]{this, dXWidgetNode, Boolean.valueOf(z)});
            return;
        }
        super.onClone(dXWidgetNode, z);
        if (dXWidgetNode == null || !(dXWidgetNode instanceof iu)) {
            return;
        }
        iu iuVar = (iu) dXWidgetNode;
        this.a = iuVar.a;
        this.b = iuVar.b;
        this.c = iuVar.c;
        this.f = iuVar.f;
        this.d = iuVar.d;
        this.e = iuVar.e;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public View onCreateView(Context context) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-96414028") ? (View) ipChange.ipc$dispatch("-96414028", new Object[]{this, context}) : new DMCategroyTagView(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onMeasure(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "753581109")) {
            ipChange.ipc$dispatch("753581109", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
        } else {
            super.onMeasure(i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onRenderView(Context context, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1006139962")) {
            ipChange.ipc$dispatch("-1006139962", new Object[]{this, context, view});
            return;
        }
        super.onRenderView(context, view);
        if (view == null || !(view instanceof DMCategroyTagView)) {
            return;
        }
        ((DMCategroyTagView) view).setTagName(this.c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetIntAttribute(long j, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1035898275")) {
            ipChange.ipc$dispatch("1035898275", new Object[]{this, Long.valueOf(j), Integer.valueOf(i)});
        } else if (j == 5737767606580872653L) {
            this.b = i;
        } else if (j == -2396097246344434994L) {
            this.f = i;
        } else {
            super.onSetIntAttribute(j, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetStringAttribute(long j, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "77151552")) {
            ipChange.ipc$dispatch("77151552", new Object[]{this, Long.valueOf(j), str});
        } else if (j == 38178040921L) {
            this.c = str;
        } else if (j == 2639694824232449600L) {
            this.d = str;
        } else if (j == DX_DMHOMECARDTAGVIEW_TEXTSTYLE) {
            this.e = str;
        } else {
            super.onSetStringAttribute(j, str);
        }
    }
}
