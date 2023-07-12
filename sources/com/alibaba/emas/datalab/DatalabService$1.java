package com.alibaba.emas.datalab;

import android.util.Log;
import com.tmall.android.dai.DAIKVStoreage;
import java.util.TimerTask;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
class DatalabService$1 extends TimerTask {
    final /* synthetic */ a this$0;

    DatalabService$1(a aVar) {
        this.this$0 = aVar;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        Log.w("Datalab.DatalabService", "run: start notify update alinn ");
        if (!this.this$0.d.booleanValue()) {
            this.this$0.d("dai init finish = false");
        }
        Log.w("Datalab.DatalabService", "notify update message");
        try {
            a aVar = this.this$0;
            if (aVar.b == null) {
                aVar.d("datalab dm service is null");
            }
            com.alibaba.emas.datalab.decision.make.a aVar2 = this.this$0.b;
            if (aVar2 == null || !aVar2.b.booleanValue()) {
                return;
            }
            String diskValue = DAIKVStoreage.getDiskValue("cml_cc_smart_android_version_update", "cml_cc_smart_android_version_update");
            if (diskValue == null) {
                DAIKVStoreage.putToDisk("cml_cc_smart_android_version_update", "cml_cc_smart_android_version_update", "show");
                DAIKVStoreage.putToMemory("cml_cc_smart_android_version_update", "cml_cc_smart_android_version_update", "show");
                this.this$0.d("first notify to dai:show");
            } else {
                DAIKVStoreage.putToMemory("cml_cc_smart_android_version_update", "cml_cc_smart_android_version_update", diskValue);
                a aVar3 = this.this$0;
                aVar3.d("other notify to dai:" + diskValue);
            }
            Log.w("Datalab.DatalabService", "success put value to dai : cml_cc_smart_android_version_update:" + diskValue);
        } catch (Exception e) {
            a aVar4 = this.this$0;
            aVar4.d("notify error: " + e.getMessage());
            Log.e("Datalab.DatalabService", "notify update error", e);
        } catch (NoSuchMethodError e2) {
            a aVar5 = this.this$0;
            aVar5.d("notify error: " + e2.getMessage());
            Log.e("Datalab.DatalabService", "notify error", e2);
        } catch (UnsatisfiedLinkError e3) {
            a aVar6 = this.this$0;
            aVar6.d("notify error: " + e3.getMessage());
            Log.e("Datalab.DatalabService", "notify update UnsatisfiedLinkError error", e3);
        }
    }
}
