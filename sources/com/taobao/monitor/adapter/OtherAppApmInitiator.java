package com.taobao.monitor.adapter;

import android.app.Application;
import com.taobao.android.tlog.protocol.Constants;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class OtherAppApmInitiator extends AbsAPMInitiator {
    @Override // com.taobao.monitor.adapter.AbsAPMInitiator
    public /* bridge */ /* synthetic */ void init(Application application, HashMap hashMap) {
        super.init(application, hashMap);
    }

    @Override // com.taobao.monitor.adapter.AbsAPMInitiator
    protected void initPage(Application application) {
    }

    void yourFuncation(Application application) {
        HashMap hashMap = new HashMap();
        hashMap.put("deviceId", "xxxxx");
        hashMap.put("onlineAppKey", "xxxxx");
        hashMap.put("appVersion", "x.x.x");
        hashMap.put(Constants.KEY_APP_BUILD, "x.x.x");
        hashMap.put("process", "com.xxx.xxx");
        hashMap.put("ttid", "xxxxx");
        hashMap.put("channel", "xxxxx");
        hashMap.put("appPatch", "xxxxx");
        new OtherAppApmInitiator().init(application, hashMap);
    }
}
