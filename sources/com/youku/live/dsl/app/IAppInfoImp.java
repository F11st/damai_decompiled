package com.youku.live.dsl.app;

import android.app.Application;
import android.content.Context;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.mu0;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class IAppInfoImp implements IAppInfo {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // com.youku.live.dsl.app.IAppInfo
    public Application getApplication() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-208110079") ? (Application) ipChange.ipc$dispatch("-208110079", new Object[]{this}) : mu0.a();
    }

    @Override // com.youku.live.dsl.app.IAppInfo
    public Context getApplicationContext() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-959942623") ? (Context) ipChange.ipc$dispatch("-959942623", new Object[]{this}) : mu0.a().getApplicationContext();
    }
}
