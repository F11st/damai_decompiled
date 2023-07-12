package com.alibaba.emas.datalab.controller;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.alibaba.emas.datalab.DatalabBizType;
import com.alibaba.emas.datalab.DatalabListener;
import com.alibaba.emas.datalab.stage.Stage;
import com.tmall.android.dai.DAIKVStoreage;
import java.util.HashMap;
import tb.l30;
import tb.q30;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class DaiUpdateReceiver extends BroadcastReceiver {
    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        Log.w("Datalab.Update", str);
        l30.c().b("update", DatalabBizType.update, "200", str);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        try {
            Log.w("Datalab.Update", "onReceive, action=" + intent.getAction());
            b("dai notify to datalab");
            final DatalabListener datalabListener = com.alibaba.emas.datalab.a.b().a.get(DatalabBizType.update);
            if (datalabListener == null) {
                b("listener is null");
                return;
            }
            HashMap hashMap = (HashMap) intent.getSerializableExtra("com.tmall.android.dai.intent.extra.OUTPUT_DATA");
            if (hashMap == null) {
                b("alinn ouput data is null");
                return;
            }
            Object obj = hashMap.get("showAndroidUpdateAlert");
            Log.w("Datalab.Update", "ob value is " + obj);
            if (obj == null) {
                b("alinn ouput data is null, not key value");
                return;
            }
            final String valueOf = String.valueOf(obj);
            new Thread() { // from class: com.alibaba.emas.datalab.controller.DaiUpdateReceiver.1
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    Boolean bool = Boolean.FALSE;
                    if (!valueOf.equals("true")) {
                        DaiUpdateReceiver.this.b("notify to update, result=false");
                    } else {
                        bool = Boolean.TRUE;
                        DaiUpdateReceiver.this.b("notify to update, open=true, result=true");
                    }
                    q30 q30Var = new q30();
                    q30Var.b = DatalabBizType.update;
                    Stage stage = Stage.NOTIFY;
                    q30Var.a = "datalab";
                    bool.booleanValue();
                    DAIKVStoreage.putToDisk("cml_cc_smart_android_version_update", "cml_cc_smart_android_version_update", "clean");
                    DAIKVStoreage.putToMemory("cml_cc_smart_android_version_update", "cml_cc_smart_android_version_update", "clean");
                    datalabListener.execute(stage, q30Var);
                }
            }.start();
        } catch (Exception e) {
            b("dai receive error" + e.getMessage());
            Log.e("Datalab.Update", "on receive update model", e);
        }
    }
}
