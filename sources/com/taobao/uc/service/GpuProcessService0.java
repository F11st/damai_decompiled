package com.taobao.uc.service;

import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import com.uc.sandboxExport.SandboxedProcessService;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class GpuProcessService0 extends SandboxedProcessService {
    @Override // com.uc.sandboxExport.SandboxedProcessService, android.app.Service
    public IBinder onBind(Intent intent) {
        return super.onBind(intent);
    }

    @Override // com.uc.sandboxExport.SandboxedProcessService, android.app.Service
    public void onCreate() {
        super.onCreate();
        Log.i("GPU_PROCESS", "start gpu process");
    }

    @Override // com.uc.sandboxExport.SandboxedProcessService, android.app.Service
    public void onDestroy() {
        super.onDestroy();
    }
}
