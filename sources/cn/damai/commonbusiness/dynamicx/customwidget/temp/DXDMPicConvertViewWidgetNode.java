package cn.damai.commonbusiness.dynamicx.customwidget.temp;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import cn.damai.common.image.C0504a;
import cn.damai.common.image.DMImageCreator;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.util.AbstractC0948a;
import cn.damai.commonbusiness.util.Bitmap12ColorHex;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.android.dinamicx.widget.DXWidgetNode;
import tb.C9826vr;
import tb.m62;
import tb.mu0;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class DXDMPicConvertViewWidgetNode extends DXWidgetNode implements Runnable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final long DXDMPICCONVERTVIEW_DMPICCONVERTVIEW = -4809976646969178823L;
    public static final long DXDMPICCONVERTVIEW_IMGURL = 9421724166673910L;
    private String imgUrl;
    private C9826vr mLastTicket;
    private View mWeakView;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.dynamicx.customwidget.temp.DXDMPicConvertViewWidgetNode$a */
    /* loaded from: classes4.dex */
    public class C0673a implements DMImageCreator.DMImageFailListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C0673a() {
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
        public void onFail(DMImageCreator.C0501d c0501d) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1205974100")) {
                ipChange.ipc$dispatch("-1205974100", new Object[]{this, c0501d});
            } else {
                DXDMPicConvertViewWidgetNode.this.setBackGroundRes(R$drawable.abg_b_purple_default_4);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.dynamicx.customwidget.temp.DXDMPicConvertViewWidgetNode$b */
    /* loaded from: classes4.dex */
    public class C0674b implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;

        /* compiled from: Taobao */
        /* renamed from: cn.damai.commonbusiness.dynamicx.customwidget.temp.DXDMPicConvertViewWidgetNode$b$a */
        /* loaded from: classes4.dex */
        public class C0675a extends AbstractC0948a {
            private static transient /* synthetic */ IpChange $ipChange;

            C0675a() {
            }

            @Override // cn.damai.commonbusiness.util.AbstractC0948a
            public void a(int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1869236672")) {
                    ipChange.ipc$dispatch("1869236672", new Object[]{this, Integer.valueOf(i)});
                } else {
                    DXDMPicConvertViewWidgetNode.this.setBackGroundRes(i);
                }
            }
        }

        C0674b() {
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public void onSuccess(DMImageCreator.C0502e c0502e) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1211249599")) {
                ipChange.ipc$dispatch("-1211249599", new Object[]{this, c0502e});
            } else if (c0502e == null || c0502e.b == null) {
                DXDMPicConvertViewWidgetNode.this.setBackGroundRes(R$drawable.abg_b_purple_default_4);
            } else {
                Bitmap12ColorHex.e().f(c0502e.b, DXDMPicConvertViewWidgetNode.this.imgUrl, new C0675a());
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
            C9826vr c9826vr = this.mLastTicket;
            if (c9826vr != null) {
                c9826vr.cancel();
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
            this.mLastTicket = C0504a.b().f(this.imgUrl, measuredWidth, measuredHeight).n(new C0674b()).e(new C0673a()).f();
        }
    }
}
