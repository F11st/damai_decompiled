package com.alibaba.aliweex.adapter.module;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.HandlerThread;
import androidx.core.app.ActivityCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.alibaba.aliweex.adapter.module.location.DefaultLocation;
import com.alibaba.aliweex.adapter.module.location.ILocatable;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.WXSDKManager;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.common.Destroyable;
import com.taobao.weex.common.WXModule;
import java.util.HashMap;
import tb.fa1;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class GeolocationModule extends WXModule implements Destroyable {
    private HandlerThread mGeolocationThread;
    private Handler mHandler;
    private ILocatable mILocatable = fa1.a(this.mWXSDKInstance);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public static class PerReceiver extends BroadcastReceiver {
        String a;
        ILocatable b;
        String c;
        String d;
        String e;

        PerReceiver(String str, ILocatable iLocatable, String str2, String str3, String str4) {
            this.b = iLocatable;
            this.c = str2;
            this.d = str3;
            this.e = str4;
            this.a = str;
        }

        private void a() {
            HashMap hashMap = new HashMap();
            hashMap.put("errorCode", 90001);
            hashMap.put("errorMsg", ILocatable.ErrorMsg.NO_PERMISSION_ERROR);
            WXSDKManager.v().a(this.a, this.d, hashMap);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            int intExtra = intent.getIntExtra("requestCode", 0);
            int[] intArrayExtra = intent.getIntArrayExtra(WXModule.GRANT_RESULTS);
            if (intExtra == 18) {
                if (intArrayExtra.length > 0 && intArrayExtra[0] == 0) {
                    this.b.getCurrentPosition(this.c, this.d, this.e);
                } else {
                    a();
                }
            } else if (intExtra == 19) {
                if (intArrayExtra.length > 0 && intArrayExtra[0] == 0) {
                    this.b.watchPosition(this.c, this.d, this.e);
                } else {
                    a();
                }
            }
            LocalBroadcastManager.getInstance(context).unregisterReceiver(this);
        }
    }

    public GeolocationModule() {
        HandlerThread handlerThread = new HandlerThread("Geolocation");
        this.mGeolocationThread = handlerThread;
        handlerThread.start();
        this.mHandler = new Handler(this.mGeolocationThread.getLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkPermission() {
        WXSDKInstance wXSDKInstance = this.mWXSDKInstance;
        if (wXSDKInstance != null) {
            return DefaultLocation.a(wXSDKInstance.getContext());
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestPermission(String str, String str2, String str3, int i) {
        try {
            ActivityCompat.requestPermissions((Activity) this.mWXSDKInstance.getContext(), new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, i);
            LocalBroadcastManager.getInstance(this.mWXSDKInstance.getContext()).registerReceiver(new PerReceiver(this.mWXSDKInstance.getInstanceId(), this.mILocatable, str, str2, str3), new IntentFilter(WXModule.ACTION_REQUEST_PERMISSIONS_RESULT));
        } catch (Throwable unused) {
        }
    }

    @JSMethod(uiThread = false)
    public void clearWatch(final String str) {
        this.mILocatable.setWXSDKInstance(this.mWXSDKInstance);
        this.mHandler.post(new Runnable() { // from class: com.alibaba.aliweex.adapter.module.GeolocationModule.3
            @Override // java.lang.Runnable
            public void run() {
                GeolocationModule.this.mILocatable.clearWatch(str);
            }
        });
    }

    @Override // com.taobao.weex.common.Destroyable
    public void destroy() {
        this.mILocatable.destroy();
        HandlerThread handlerThread = this.mGeolocationThread;
        if (handlerThread != null) {
            handlerThread.quit();
            this.mGeolocationThread = null;
        }
    }

    @JSMethod(uiThread = false)
    public void getCurrentPosition(final String str, final String str2, final String str3) {
        WXSDKInstance wXSDKInstance = this.mWXSDKInstance;
        if (wXSDKInstance == null || wXSDKInstance.getContext() == null) {
            return;
        }
        this.mILocatable.setWXSDKInstance(this.mWXSDKInstance);
        this.mHandler.post(new Runnable() { // from class: com.alibaba.aliweex.adapter.module.GeolocationModule.1
            @Override // java.lang.Runnable
            public void run() {
                if (GeolocationModule.this.checkPermission()) {
                    GeolocationModule.this.mILocatable.getCurrentPosition(str, str2, str3);
                } else {
                    GeolocationModule.this.requestPermission(str, str2, str3, 18);
                }
            }
        });
    }

    @JSMethod(uiThread = false)
    public void watchPosition(final String str, final String str2, final String str3) {
        WXSDKInstance wXSDKInstance = this.mWXSDKInstance;
        if (wXSDKInstance == null || wXSDKInstance.getContext() == null) {
            return;
        }
        this.mILocatable.setWXSDKInstance(this.mWXSDKInstance);
        this.mHandler.post(new Runnable() { // from class: com.alibaba.aliweex.adapter.module.GeolocationModule.2
            @Override // java.lang.Runnable
            public void run() {
                if (GeolocationModule.this.checkPermission()) {
                    GeolocationModule.this.mILocatable.watchPosition(str, str2, str3);
                } else {
                    GeolocationModule.this.requestPermission(str, str2, str3, 19);
                }
            }
        });
    }
}
