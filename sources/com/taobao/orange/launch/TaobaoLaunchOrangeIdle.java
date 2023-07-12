package com.taobao.orange.launch;

import android.app.Application;
import com.taobao.orange.ConfigCenter;
import com.taobao.orange.util.OLog;
import java.io.Serializable;
import java.util.HashMap;

/* loaded from: classes11.dex */
public class TaobaoLaunchOrangeIdle implements Serializable {
    private static final String TAG = "TaobaoLaunchOrangeIdle";

    public void init(Application application, HashMap<String, Object> hashMap) {
        OLog.d(TAG, "TaobaoLaunchOrangeIdle been called", new Object[0]);
        ConfigCenter.getInstance().delayLoadConfig();
    }
}
