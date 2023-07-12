package com.taobao.alivfssdk.monitor.init;

import android.app.Application;
import android.content.ComponentName;
import android.content.Intent;
import java.io.Serializable;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class InitAVFSMonitorService implements Serializable {
    public void init(Application application, HashMap<String, Object> hashMap) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(application, "com.taobao.alivfssdk.monitor.AVFSMonitorService"));
        application.getApplicationContext().startService(intent);
    }
}
