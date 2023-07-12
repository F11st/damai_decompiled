package tb;

import android.content.Context;
import android.view.View;
import cn.damai.commonbusiness.dynamicx.customwidget.temp.DMDXHomeGrabTicketNoticeView;
import com.alibaba.fastjson.JSONArray;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.android.dinamicx.widget.DXWidgetNode;
import com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class ju extends DXWidgetNode {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final long DXDMHOMEGRABTICKETNOTICEVIEW_ANIMATETIME = 4553219649980565881L;
    public static final long DXDMHOMEGRABTICKETNOTICEVIEW_DATASTATUS = -5948788524897209048L;
    public static final long DXDMHOMEGRABTICKETNOTICEVIEW_DMHOMEGRABTICKETNOTICEVIEW = 8929889745416512273L;
    public static final long DXDMHOMEGRABTICKETNOTICEVIEW_HIGHLIGHTCOLOR = -2509796262060624955L;
    public static final long DXDMHOMEGRABTICKETNOTICEVIEW_INTERVAL = 3522016527368756845L;
    public static final long DXDMHOMEGRABTICKETNOTICEVIEW_ISDISENABLED = 6617851322227835315L;
    public static final long DXDMHOMEGRABTICKETNOTICEVIEW_NORMALCOLOR = -3839249724436785773L;
    public static final long DXDMHOMEGRABTICKETNOTICEVIEW_POINTSIZE = -2396097246344434994L;
    public static final long DXDMHOMEGRABTICKETNOTICEVIEW_TEXTDATA = 6751005153931247175L;
    private double a;
    private String b;
    private int c;
    private double d;
    private String e;
    private int f;
    private int g;
    private JSONArray h;

    /* compiled from: Taobao */
    /* renamed from: tb.ju$a */
    /* loaded from: classes4.dex */
    public static class C9322a implements IDXBuilderWidgetNode {
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode
        public DXWidgetNode build(Object obj) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1924111230") ? (DXWidgetNode) ipChange.ipc$dispatch("1924111230", new Object[]{this, obj}) : new ju();
        }
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode, com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode
    public DXWidgetNode build(Object obj) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "156654581") ? (DXWidgetNode) ipChange.ipc$dispatch("156654581", new Object[]{this, obj}) : new ju();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onBindEvent(Context context, View view, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2092724784")) {
            ipChange.ipc$dispatch("-2092724784", new Object[]{this, context, view, Long.valueOf(j)});
        } else {
            super.onBindEvent(context, view, j);
        }
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onClone(DXWidgetNode dXWidgetNode, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "354358639")) {
            ipChange.ipc$dispatch("354358639", new Object[]{this, dXWidgetNode, Boolean.valueOf(z)});
        } else if (dXWidgetNode == null || !(dXWidgetNode instanceof ju)) {
        } else {
            super.onClone(dXWidgetNode, z);
            ju juVar = (ju) dXWidgetNode;
            this.a = juVar.a;
            this.b = juVar.b;
            this.c = juVar.c;
            this.d = juVar.d;
            this.e = juVar.e;
            this.f = juVar.f;
            this.g = juVar.g;
            this.h = juVar.h;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public View onCreateView(Context context) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1453378328") ? (View) ipChange.ipc$dispatch("-1453378328", new Object[]{this, context}) : new DMDXHomeGrabTicketNoticeView(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1774785627")) {
            ipChange.ipc$dispatch("1774785627", new Object[]{this, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
        } else {
            super.onLayout(z, i, i2, i3, i4);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onMeasure(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "71014505")) {
            ipChange.ipc$dispatch("71014505", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
        } else {
            super.onMeasure(i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onRenderView(Context context, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-122360302")) {
            ipChange.ipc$dispatch("-122360302", new Object[]{this, context, view});
            return;
        }
        super.onRenderView(context, view);
        if (view == null || !(view instanceof DMDXHomeGrabTicketNoticeView)) {
            return;
        }
        DMDXHomeGrabTicketNoticeView dMDXHomeGrabTicketNoticeView = (DMDXHomeGrabTicketNoticeView) view;
        dMDXHomeGrabTicketNoticeView.setPointSize(this.g);
        dMDXHomeGrabTicketNoticeView.setHighlightColor(this.c);
        dMDXHomeGrabTicketNoticeView.setNormalColor(this.f);
        dMDXHomeGrabTicketNoticeView.setAnimateTime((long) this.a);
        dMDXHomeGrabTicketNoticeView.setInterval((int) this.d);
        dMDXHomeGrabTicketNoticeView.setIsDisEnabled(this.e);
        dMDXHomeGrabTicketNoticeView.create(this.h);
        dMDXHomeGrabTicketNoticeView.setDataStatus(this.b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetDoubleAttribute(long j, double d) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-996957932")) {
            ipChange.ipc$dispatch("-996957932", new Object[]{this, Long.valueOf(j), Double.valueOf(d)});
        } else if (j == 4553219649980565881L) {
            this.a = d;
        } else if (j == 3522016527368756845L) {
            this.d = d;
        } else {
            super.onSetDoubleAttribute(j, d);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetIntAttribute(long j, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1302727209")) {
            ipChange.ipc$dispatch("-1302727209", new Object[]{this, Long.valueOf(j), Integer.valueOf(i)});
        } else if (j == DXDMHOMEGRABTICKETNOTICEVIEW_HIGHLIGHTCOLOR) {
            this.c = i;
        } else if (j == DXDMHOMEGRABTICKETNOTICEVIEW_NORMALCOLOR) {
            this.f = i;
        } else if (j == -2396097246344434994L) {
            this.g = i;
        } else {
            super.onSetIntAttribute(j, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetListAttribute(long j, JSONArray jSONArray) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2010284571")) {
            ipChange.ipc$dispatch("-2010284571", new Object[]{this, Long.valueOf(j), jSONArray});
        } else if (j == DXDMHOMEGRABTICKETNOTICEVIEW_TEXTDATA) {
            this.h = jSONArray;
        } else {
            super.onSetListAttribute(j, jSONArray);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetStringAttribute(long j, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-796753036")) {
            ipChange.ipc$dispatch("-796753036", new Object[]{this, Long.valueOf(j), str});
        } else if (j == DXDMHOMEGRABTICKETNOTICEVIEW_DATASTATUS) {
            this.b = str;
        } else if (j == DXDMHOMEGRABTICKETNOTICEVIEW_ISDISENABLED) {
            this.e = str;
        } else {
            super.onSetStringAttribute(j, str);
        }
    }
}
