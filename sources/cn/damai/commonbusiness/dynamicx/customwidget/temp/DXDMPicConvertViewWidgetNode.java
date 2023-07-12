package cn.damai.commonbusiness.dynamicx.customwidget.temp;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import cn.damai.common.image.DMImageCreator;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.util.Bitmap12ColorHex;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.android.dinamicx.widget.DXWidgetNode;
import tb.m62;
import tb.mu0;
import tb.vr;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class DXDMPicConvertViewWidgetNode extends DXWidgetNode implements Runnable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final long DXDMPICCONVERTVIEW_DMPICCONVERTVIEW = -4809976646969178823L;
    public static final long DXDMPICCONVERTVIEW_IMGURL = 9421724166673910L;
    private String imgUrl;
    private vr mLastTicket;
    private View mWeakView;

    /* compiled from: Taobao */
    /* loaded from: classes4.dex */
    public class a implements DMImageCreator.DMImageFailListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
        public void onFail(DMImageCreator.d dVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1205974100")) {
                ipChange.ipc$dispatch("-1205974100", new Object[]{this, dVar});
            } else {
                DXDMPicConvertViewWidgetNode.this.setBackGroundRes(R$drawable.abg_b_purple_default_4);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes4.dex */
    public class b implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;

        /* compiled from: Taobao */
        /* loaded from: classes4.dex */
        public class a extends cn.damai.commonbusiness.util.a {
            private static transient /* synthetic */ IpChange $ipChange;

            a() {
            }

            @Override // cn.damai.commonbusiness.util.a
            public void a(int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1869236672")) {
                    ipChange.ipc$dispatch("1869236672", new Object[]{this, Integer.valueOf(i)});
                } else {
                    DXDMPicConvertViewWidgetNode.this.setBackGroundRes(i);
                }
            }
        }

        b() {
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public void onSuccess(DMImageCreator.e eVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1211249599")) {
                ipChange.ipc$dispatch("-1211249599", new Object[]{this, eVar});
            } else if (eVar == null || eVar.b == null) {
                DXDMPicConvertViewWidgetNode.this.setBackGroundRes(R$drawable.abg_b_purple_default_4);
            } else {
                Bitmap12ColorHex.e().f(eVar.b, DXDMPicConvertViewWidgetNode.this.imgUrl, new a());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBackGroundRes(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2025073975")) {
            ipChange.ipc$dispatch("2025073975", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        View view = this.mWeakView;
        if (view != null) {
            view.setBackgroundResource(i);
        }
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode, com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode
    public DXWidgetNode build(Object obj) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-418252645") ? (DXWidgetNode) ipChange.ipc$dispatch("-418252645", new Object[]{this, obj}) : new DXDMPicConvertViewWidgetNode();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onBindEvent(Context context, View view, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1243626")) {
            ipChange.ipc$dispatch("1243626", new Object[]{this, context, view, Long.valueOf(j)});
        } else {
            super.onBindEvent(context, view, j);
        }
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onClone(DXWidgetNode dXWidgetNode, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "842869909")) {
            ipChange.ipc$dispatch("842869909", new Object[]{this, dXWidgetNode, Boolean.valueOf(z)});
        } else if (dXWidgetNode == null || !(dXWidgetNode instanceof DXDMPicConvertViewWidgetNode)) {
        } else {
            super.onClone(dXWidgetNode, z);
            this.imgUrl = ((DXDMPicConvertViewWidgetNode) dXWidgetNode).imgUrl;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public View onCreateView(Context context) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "692379022") ? (View) ipChange.ipc$dispatch("692379022", new Object[]{this, context}) : super.onCreateView(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onMeasure(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "244097551")) {
            ipChange.ipc$dispatch("244097551", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
        } else {
            super.onMeasure(i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onRenderView(Context context, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1971608108")) {
            ipChange.ipc$dispatch("1971608108", new Object[]{this, context, view});
            return;
        }
        super.onRenderView(context, view);
        this.mWeakView = view;
        if (view != null) {
            vr vrVar = this.mLastTicket;
            if (vrVar != null) {
                vrVar.cancel();
                this.mLastTicket = null;
            }
            if (TextUtils.isEmpty(this.imgUrl)) {
                view.setBackgroundResource(R$drawable.abg_b_purple_default_4);
                return;
            }
            view.removeCallbacks(this);
            view.post(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetStringAttribute(long j, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1070974950")) {
            ipChange.ipc$dispatch("-1070974950", new Object[]{this, Long.valueOf(j), str});
        } else if (j == DXDMPICCONVERTVIEW_IMGURL) {
            this.imgUrl = str;
        } else {
            super.onSetStringAttribute(j, str);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1740085411")) {
            ipChange.ipc$dispatch("1740085411", new Object[]{this});
        } else if (this.mWeakView == null || TextUtils.isEmpty(this.imgUrl)) {
        } else {
            int measuredWidth = this.mWeakView.getMeasuredWidth();
            int measuredHeight = this.mWeakView.getMeasuredHeight();
            if (measuredHeight <= 0 || measuredWidth <= 0) {
                measuredWidth = m62.a(mu0.a(), 208.0f);
                measuredHeight = m62.a(mu0.a(), 64.0f);
            }
            this.mLastTicket = cn.damai.common.image.a.b().f(this.imgUrl, measuredWidth, measuredHeight).n(new b()).e(new a()).f();
        }
    }
}
