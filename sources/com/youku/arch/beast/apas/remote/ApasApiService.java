package com.youku.arch.beast.apas.remote;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.util.Logger;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class ApasApiService extends Service {
    private static transient /* synthetic */ IpChange $ipChange;
    private static final String TAG = ApasApiService.class.getSimpleName();
    private ApasApiServiceStub mStub;

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1895740877")) {
            return (IBinder) ipChange.ipc$dispatch("-1895740877", new Object[]{this, intent});
        }
        Logger.d(TAG, "onbind");
        if (this.mStub == null) {
            this.mStub = new ApasApiServiceStub();
        }
        return this.mStub;
    }

    @Override // android.app.Service
    public void onCreate() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "239920686")) {
            ipChange.ipc$dispatch("239920686", new Object[]{this});
        } else {
            super.onCreate();
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1060205914")) {
            ipChange.ipc$dispatch("-1060205914", new Object[]{this});
        } else {
            super.onDestroy();
        }
    }
}
