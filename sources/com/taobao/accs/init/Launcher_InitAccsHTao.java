package com.taobao.accs.init;

import android.app.Application;
import com.taobao.accs.client.AdapterGlobalClientInfo;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class Launcher_InitAccsHTao extends Launcher_InitAccs {
    @Override // com.taobao.accs.init.Launcher_InitAccs
    public void init(Application application, HashMap<String, Object> hashMap) {
        Launcher_InitAccs.defaultAppkey = "";
        super.init(application, hashMap);
        AdapterGlobalClientInfo.mAgooCustomServiceName = "com.taobao.taobao.TaobaoIntentService";
    }
}
