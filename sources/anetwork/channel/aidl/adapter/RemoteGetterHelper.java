package anetwork.channel.aidl.adapter;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import anet.channel.util.ALog;
import anetwork.channel.aidl.IRemoteNetworkGetter;
import anetwork.channel.aidl.NetworkService;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import tb.rj1;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class RemoteGetterHelper {
    private static final String TAG = "anet.RemoteGetter";
    static volatile boolean bBindFailed;
    static volatile boolean bBinding;
    static volatile IRemoteNetworkGetter mGetter;
    static volatile CountDownLatch mServiceBindLock;
    static Handler handler = new Handler(Looper.getMainLooper());
    private static ServiceConnection conn = new ServiceConnection() { // from class: anetwork.channel.aidl.adapter.RemoteGetterHelper.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (ALog.g(2)) {
                ALog.f(RemoteGetterHelper.TAG, "[onServiceConnected]ANet_Service start success. ANet run with service mode", null, new Object[0]);
            }
            synchronized (RemoteGetterHelper.class) {
                RemoteGetterHelper.mGetter = IRemoteNetworkGetter.Stub.asInterface(iBinder);
                if (RemoteGetterHelper.mServiceBindLock != null) {
                    RemoteGetterHelper.mServiceBindLock.countDown();
                }
            }
            RemoteGetterHelper.bBindFailed = false;
            RemoteGetterHelper.bBinding = false;
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            if (ALog.g(2)) {
                ALog.f(RemoteGetterHelper.TAG, "ANet_Service Disconnected", null, new Object[0]);
            }
            RemoteGetterHelper.mGetter = null;
            RemoteGetterHelper.bBinding = false;
            if (RemoteGetterHelper.mServiceBindLock != null) {
                RemoteGetterHelper.mServiceBindLock.countDown();
            }
        }
    };

    private static void asyncBindService(Context context) {
        if (ALog.g(2)) {
            ALog.f(TAG, "[asyncBindService] mContext:" + context + " bBindFailed:" + bBindFailed + " bBinding:" + bBinding, null, new Object[0]);
        }
        if (context == null || bBindFailed || bBinding) {
            return;
        }
        bBinding = true;
        Intent intent = new Intent(context, NetworkService.class);
        intent.setAction(IRemoteNetworkGetter.class.getName());
        intent.addCategory("android.intent.category.DEFAULT");
        bBindFailed = !context.bindService(intent, conn, 1);
        if (bBindFailed) {
            bBinding = false;
            ALog.e(TAG, "[asyncBindService]ANet_Service start not success. ANet run with local mode!", null, new Object[0]);
        }
        handler.postDelayed(new Runnable() { // from class: anetwork.channel.aidl.adapter.RemoteGetterHelper.2
            @Override // java.lang.Runnable
            public void run() {
                if (RemoteGetterHelper.bBinding) {
                    RemoteGetterHelper.bBinding = false;
                    ALog.e(RemoteGetterHelper.TAG, "binding service timeout. reset status!", null, new Object[0]);
                }
            }
        }, 10000L);
    }

    public static IRemoteNetworkGetter getRemoteGetter() {
        return mGetter;
    }

    public static void initRemoteGetterAndWait(Context context, boolean z) {
        if (mGetter == null && !bBindFailed) {
            asyncBindService(context);
            if (bBindFailed || !z) {
                return;
            }
            try {
                synchronized (RemoteGetterHelper.class) {
                    if (mGetter != null) {
                        return;
                    }
                    if (mServiceBindLock == null) {
                        mServiceBindLock = new CountDownLatch(1);
                    }
                    ALog.f(TAG, "[initRemoteGetterAndWait]begin to wait", null, new Object[0]);
                    if (mServiceBindLock.await(rj1.d(), TimeUnit.SECONDS)) {
                        ALog.f(TAG, "mServiceBindLock count down to 0", null, new Object[0]);
                    } else {
                        ALog.f(TAG, "mServiceBindLock wait timeout", null, new Object[0]);
                    }
                }
            } catch (InterruptedException unused) {
                ALog.e(TAG, "mServiceBindLock wait interrupt", null, new Object[0]);
            }
        }
    }
}
