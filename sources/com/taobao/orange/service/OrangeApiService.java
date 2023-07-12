package com.taobao.orange.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.taobao.orange.aidl.IOrangeApiService;
import com.taobao.orange.aidl.OrangeApiServiceStub;
import com.taobao.orange.util.OLog;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class OrangeApiService extends Service {
    private static final String TAG = "OrangeApiService";
    private IOrangeApiService.Stub mBinder = null;

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        OLog.i(TAG, "onBind", new Object[0]);
        if (this.mBinder == null) {
            this.mBinder = new OrangeApiServiceStub(this);
        }
        return this.mBinder;
    }

    @Override // android.app.Service
    public void onCreate() {
        OLog.d(TAG, "onCreate", new Object[0]);
        super.onCreate();
    }

    @Override // android.app.Service
    public void onDestroy() {
        OLog.d(TAG, "onDestroy", new Object[0]);
        super.onDestroy();
    }

    @Override // android.app.Service
    public void onRebind(Intent intent) {
        OLog.i(TAG, "onRebind", CommonCode.Resolution.HAS_RESOLUTION_FROM_APK, intent);
        super.onRebind(intent);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        return 2;
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        OLog.i(TAG, "onUnbind", new Object[0]);
        return super.onUnbind(intent);
    }
}
