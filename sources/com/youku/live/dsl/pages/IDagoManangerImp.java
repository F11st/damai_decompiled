package com.youku.live.dsl.pages;

import android.app.Application;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.DagoWidgetLib;
import com.youku.live.dago.widgetlib.ailproom.adapter.chatinput.expression.ExpressionManager;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class IDagoManangerImp implements IDagoManangerInterface {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // com.youku.live.dsl.pages.IDagoManangerInterface
    public void registerAll(Application application) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "581803565")) {
            ipChange.ipc$dispatch("581803565", new Object[]{this, application});
            return;
        }
        DagoWidgetLib.registerAll(application);
        ExpressionManager.getInstance();
    }
}
