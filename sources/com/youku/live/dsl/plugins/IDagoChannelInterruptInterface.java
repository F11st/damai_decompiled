package com.youku.live.dsl.plugins;

import com.youku.live.widgets.protocol.IPlugin;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public interface IDagoChannelInterruptInterface {
    void onDagoChannelCloseFail(String str, IPlugin iPlugin);

    void onDagoChannelCloseSuccess(String str, IPlugin iPlugin);

    void onDagoChannelClosing(String str, IPlugin iPlugin);

    void onDagoChannelDispatch(String str, IPlugin iPlugin, Object obj);

    void onDagoChannelOpenFail(String str, IPlugin iPlugin);

    void onDagoChannelOpenSuccess(String str, IPlugin iPlugin);

    void onDagoChannelOpening(String str, IPlugin iPlugin, long j, String str2);
}
