package com.youku.live.dago.widgetlib.component;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.ui.action.BasicComponentData;
import com.taobao.weex.ui.component.WXVContainer;
import com.youku.live.dago.widgetlib.view.usercard.DagoUserCardView;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.log.ILog;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class YKLUserCardComponent extends ProxyWXComponent<View> {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String TAG = "YKLUserCardComponent";
    private DagoUserCardView mDagoUserCardView;

    public YKLUserCardComponent(WXSDKInstance wXSDKInstance, WXVContainer wXVContainer, BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, basicComponentData);
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    protected View initComponentHostView(@NonNull Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1091596434")) {
            return (View) ipChange.ipc$dispatch("1091596434", new Object[]{this, context});
        }
        ((ILog) Dsl.getService(ILog.class)).i(TAG, "initComponentHostView: ");
        FrameLayout frameLayout = new FrameLayout(context);
        DagoUserCardView dagoUserCardView = new DagoUserCardView(context);
        this.mDagoUserCardView = dagoUserCardView;
        frameLayout.addView(dagoUserCardView);
        return frameLayout;
    }
}
