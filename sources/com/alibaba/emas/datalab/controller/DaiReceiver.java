package com.alibaba.emas.datalab.controller;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.alibaba.emas.datalab.C3318a;
import com.alibaba.emas.datalab.DatalabBizType;
import com.alibaba.fastjson.JSON;
import com.tmall.android.dai.DAIKVStoreage;
import java.util.ArrayList;
import tb.l30;
import tb.p30;
import tb.ve2;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class DaiReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String str;
        C3318a b = C3318a.b();
        Boolean bool = Boolean.TRUE;
        b.d = bool;
        l30.c().d();
        try {
            String diskValue = DAIKVStoreage.getDiskValue("cml_cc_smart_android_version_update", "cml_cc_smart_android_version_update");
            if (diskValue != null && diskValue.equals("show")) {
                Log.d("Datalab.DaiReceiver", "put to dai mem " + diskValue);
                DAIKVStoreage.putToMemory("cml_cc_smart_android_version_update", "cml_cc_smart_android_version_update", diskValue);
            }
            ve2 b2 = ve2.b();
            DatalabBizType datalabBizType = DatalabBizType.zcache;
            p30 a = b2.a(context, datalabBizType, "algo.open");
            Log.d("Datalab.DaiReceiver", "algoNotify result is " + JSON.toJSONString(a));
            if (a != null && (str = a.d) != null) {
                if (str.equals("true")) {
                    Log.d("Datalab.DaiReceiver", "run: dai trigger start ");
                    DaiController.a().b(context, bool, new ArrayList());
                    Log.d("Datalab.DaiReceiver", "run: dai trigger end ");
                    l30.c().b("dai", datalabBizType, "200", "true");
                    return;
                }
                l30.c().b("dai", datalabBizType, "200", "false");
                return;
            }
            Log.d("Datalab.DaiReceiver", "run first: dai trigger start ");
            DaiController.a().b(context, bool, new ArrayList());
            Log.d("Datalab.DaiReceiver", "run first: dai trigger end ");
            l30.c().b("dai", datalabBizType, "201", "true");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
