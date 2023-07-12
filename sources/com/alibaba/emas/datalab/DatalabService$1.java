package com.alibaba.emas.datalab;

import android.util.Log;
import com.alibaba.emas.datalab.decision.make.C3324a;
import com.tmall.android.dai.DAIKVStoreage;
import java.util.TimerTask;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
class DatalabService$1 extends TimerTask {
    final /* synthetic */ C3318a this$0;

    DatalabService$1(C3318a c3318a) {
        this.this$0 = c3318a;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        Log.w("Datalab.DatalabService", "run: start notify update alinn ");
        if (!this.this$0.d.booleanValue()) {
            this.this$0.d("dai init finish = false");
        }
        Log.w("Datalab.DatalabService", "notify update message");
        try {
            C3318a c3318a = this.this$0;
            if (c3318a.b == null) {
                c3318a.d("datalab dm service is null");
            }
            C3324a c3324a = this.this$0.b;
            if (c3324a == null || !c3324a.b.booleanValue()) {
                return;
            }
            String diskValue = DAIKVStoreage.getDiskValue("cml_cc_smart_android_version_update", "cml_cc_smart_android_version_update");
            if (diskValue == null) {
                DAIKVStoreage.putToDisk("cml_cc_smart_android_version_update", "cml_cc_smart_android_version_update", "show");
                DAIKVStoreage.putToMemory("cml_cc_smart_android_version_update", "cml_cc_smart_android_version_update", "show");
                this.this$0.d("first notify to dai:show");
            } else {
                DAIKVStoreage.putToMemory("cml_cc_smart_android_version_update", "cml_cc_smart_android_version_update", diskValue);
                C3318a c3318a2 = this.this$0;
                c3318a2.d("other notify to dai:" + diskValue);
            }
            Log.w("Datalab.DatalabService", "success put value to dai : cml_cc_smart_android_version_update:" + diskValue);
        } catch (Exception e) {
            C3318a c3318a3 = this.this$0;
            c3318a3.d("notify error: " + e.getMessage());
            Log.e("Datalab.DatalabService", "notify update error", e);
        } catch (NoSuchMethodError e2) {
            C3318a c3318a4 = this.this$0;
            c3318a4.d("notify error: " + e2.getMessage());
            Log.e("Datalab.DatalabService", "notify error", e2);
        } catch (UnsatisfiedLinkError e3) {
            C3318a c3318a5 = this.this$0;
            c3318a5.d("notify error: " + e3.getMessage());
            Log.e("Datalab.DatalabService", "notify update UnsatisfiedLinkError error", e3);
        }
    }
}
