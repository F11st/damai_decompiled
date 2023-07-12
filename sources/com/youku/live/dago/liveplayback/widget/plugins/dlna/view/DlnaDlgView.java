package com.youku.live.dago.liveplayback.widget.plugins.dlna.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.tmalltv.tv.lib.ali_tvsharelib.all.utils.LogEx;
import com.youku.multiscreen.Client;
import com.yunos.tvhelper.ui.api.UiApiBu;
import com.yunos.tvhelper.ui.api.UiApiDef;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class DlnaDlgView extends LinearLayout {
    private View.OnClickListener mClickListener;
    DlgListener mListener;
    private boolean mOnFinishInflateCalled;

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public interface DlgListener {
        void onClickOneKey();
    }

    public DlnaDlgView(Context context) {
        super(context);
        this.mClickListener = new View.OnClickListener() { // from class: com.youku.live.dago.liveplayback.widget.plugins.dlna.view.DlnaDlgView.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "2065594945")) {
                    ipChange.ipc$dispatch("2065594945", new Object[]{this, view});
                    return;
                }
                LogEx.i(DlnaDlgView.this.tag(), "hit");
                DlgListener dlgListener = DlnaDlgView.this.mListener;
                if (dlgListener != null) {
                    dlgListener.onClickOneKey();
                }
                UiApiBu.rinstaller().openCibnInstaller((Activity) Activity.class.cast(DlnaDlgView.this.getContext()), (UiApiDef.CibnInstallerOpt) null);
            }
        };
        constructor();
    }

    private void constructor() {
        setOrientation(1);
        setGravity(17);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String tag() {
        return LogEx.tag(this);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        if (this.mOnFinishInflateCalled) {
            return;
        }
        this.mOnFinishInflateCalled = true;
    }

    public void setActionTitle(int i) {
        ((TextView) getChildAt(1)).setText(i);
    }

    public void setDlgListener(DlgListener dlgListener) {
        this.mListener = dlgListener;
    }

    public void setMsg(int i) {
        ((TextView) TextView.class.cast(getChildAt(0))).setText(i);
    }

    public void setTargetClient(Client client) {
        View childAt = getChildAt(1);
        childAt.setVisibility(0);
        childAt.setOnClickListener(this.mClickListener);
    }

    public void setMsg(String str) {
        ((TextView) TextView.class.cast(getChildAt(0))).setText(str);
    }

    public DlnaDlgView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mClickListener = new View.OnClickListener() { // from class: com.youku.live.dago.liveplayback.widget.plugins.dlna.view.DlnaDlgView.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "2065594945")) {
                    ipChange.ipc$dispatch("2065594945", new Object[]{this, view});
                    return;
                }
                LogEx.i(DlnaDlgView.this.tag(), "hit");
                DlgListener dlgListener = DlnaDlgView.this.mListener;
                if (dlgListener != null) {
                    dlgListener.onClickOneKey();
                }
                UiApiBu.rinstaller().openCibnInstaller((Activity) Activity.class.cast(DlnaDlgView.this.getContext()), (UiApiDef.CibnInstallerOpt) null);
            }
        };
        constructor();
    }

    public DlnaDlgView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mClickListener = new View.OnClickListener() { // from class: com.youku.live.dago.liveplayback.widget.plugins.dlna.view.DlnaDlgView.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "2065594945")) {
                    ipChange.ipc$dispatch("2065594945", new Object[]{this, view});
                    return;
                }
                LogEx.i(DlnaDlgView.this.tag(), "hit");
                DlgListener dlgListener = DlnaDlgView.this.mListener;
                if (dlgListener != null) {
                    dlgListener.onClickOneKey();
                }
                UiApiBu.rinstaller().openCibnInstaller((Activity) Activity.class.cast(DlnaDlgView.this.getContext()), (UiApiDef.CibnInstallerOpt) null);
            }
        };
        constructor();
    }
}
