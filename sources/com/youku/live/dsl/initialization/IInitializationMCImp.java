package com.youku.live.dsl.initialization;

import cn.damai.common.AppConfig;
import cn.damai.net.NetConstants;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.messagechannel.engine.MCEngine;
import com.youku.live.messagechannel.engine.MCEngineConfig;
import mtopsdk.mtop.intf.Mtop;
import tb.mu0;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class IInitializationMCImp implements IInitializationMC {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // com.youku.live.dsl.initialization.IInitializationObject
    public boolean initialize() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-29603676")) {
            return ((Boolean) ipChange.ipc$dispatch("-29603676", new Object[]{this})).booleanValue();
        }
        MCEngineConfig mCEngineConfig = new MCEngineConfig();
        mCEngineConfig.mtopInstance = Mtop.instance(NetConstants.YOUKU_MTOP_INSTANCE_ID, mu0.a(), AppConfig.p()).registerTtid(AppConfig.p());
        MCEngine.config(mCEngineConfig);
        return true;
    }
}
