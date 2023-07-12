package mtopsdk.common.util;

import android.annotation.TargetApi;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.text.TextUtils;
import mtopsdk.common.util.TBSdkLog;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public abstract class AsyncServiceBinder<T extends IInterface> {
    static final String TAG = "mtopsdk.AsyncServiceBinder";
    Class<? extends IInterface> interfaceCls;
    String interfaceName;
    Class<? extends Service> serviceCls;
    protected volatile T service = null;
    final byte[] lock = new byte[0];
    volatile boolean mBindFailed = false;
    volatile boolean mBinding = false;
    private ServiceConnection conn = new ServiceConnection() { // from class: mtopsdk.common.util.AsyncServiceBinder.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Class<?>[] declaredClasses;
            synchronized (AsyncServiceBinder.this.lock) {
                try {
                    if (TextUtils.isEmpty(AsyncServiceBinder.this.interfaceName)) {
                        AsyncServiceBinder asyncServiceBinder = AsyncServiceBinder.this;
                        asyncServiceBinder.interfaceName = asyncServiceBinder.interfaceCls.getSimpleName();
                    }
                    if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                        TBSdkLog.i(AsyncServiceBinder.TAG, "[onServiceConnected] Service connected called. interfaceName =" + AsyncServiceBinder.this.interfaceName);
                    }
                    for (Class<?> cls : AsyncServiceBinder.this.interfaceCls.getDeclaredClasses()) {
                        if (cls.getSimpleName().equals("Stub")) {
                            AsyncServiceBinder.this.service = (T) cls.getDeclaredMethod("asInterface", IBinder.class).invoke(cls, iBinder);
                        }
                    }
                } catch (Exception unused) {
                    AsyncServiceBinder.this.mBindFailed = true;
                    if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.WarnEnable)) {
                        TBSdkLog.w(AsyncServiceBinder.TAG, "[onServiceConnected] Service bind failed. mBindFailed=" + AsyncServiceBinder.this.mBindFailed + ",interfaceName=" + AsyncServiceBinder.this.interfaceName);
                    }
                }
                if (AsyncServiceBinder.this.service != null) {
                    AsyncServiceBinder.this.mBindFailed = false;
                    AsyncServiceBinder.this.afterAsyncBind();
                }
                AsyncServiceBinder.this.mBinding = false;
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            synchronized (AsyncServiceBinder.this.lock) {
                try {
                    if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.WarnEnable)) {
                        if (TextUtils.isEmpty(AsyncServiceBinder.this.interfaceName)) {
                            AsyncServiceBinder asyncServiceBinder = AsyncServiceBinder.this;
                            asyncServiceBinder.interfaceName = asyncServiceBinder.interfaceCls.getSimpleName();
                        }
                        TBSdkLog.w(AsyncServiceBinder.TAG, "[onServiceDisconnected] Service disconnected called,interfaceName=" + AsyncServiceBinder.this.interfaceName);
                    }
                } catch (Exception unused) {
                }
                AsyncServiceBinder.this.service = null;
                AsyncServiceBinder.this.mBinding = false;
            }
        }
    };

    public AsyncServiceBinder(Class<? extends IInterface> cls, Class<? extends Service> cls2) {
        this.interfaceCls = cls;
        this.serviceCls = cls2;
    }

    protected abstract void afterAsyncBind();

    @TargetApi(4)
    public void asyncBind(Context context) {
        if (this.service != null || context == null || this.mBindFailed || this.mBinding) {
            return;
        }
        TBSdkLog.LogEnable logEnable = TBSdkLog.LogEnable.InfoEnable;
        if (TBSdkLog.isLogEnable(logEnable)) {
            TBSdkLog.i(TAG, "[asyncBind] mContext=" + context + ",mBindFailed= " + this.mBindFailed + ",mBinding=" + this.mBinding);
        }
        this.mBinding = true;
        try {
            if (TextUtils.isEmpty(this.interfaceName)) {
                this.interfaceName = this.interfaceCls.getSimpleName();
            }
            if (TBSdkLog.isLogEnable(logEnable)) {
                TBSdkLog.i(TAG, "[asyncBind]try to bind service for " + this.interfaceName);
            }
            Intent intent = new Intent(context.getApplicationContext(), this.serviceCls);
            intent.setAction(this.interfaceCls.getName());
            intent.setPackage(context.getPackageName());
            intent.addCategory("android.intent.category.DEFAULT");
            boolean bindService = context.bindService(intent, this.conn, 1);
            if (TBSdkLog.isLogEnable(logEnable)) {
                TBSdkLog.i(TAG, "[asyncBind]use intent bind service ret=" + bindService + " for interfaceName=" + this.interfaceName);
            }
            this.mBindFailed = !bindService;
        } catch (Throwable th) {
            this.mBindFailed = true;
            TBSdkLog.e(TAG, "[asyncBind] use intent bind service failed. mBindFailed=" + this.mBindFailed + ",interfaceName = " + this.interfaceName, th);
        }
        if (this.mBindFailed) {
            this.mBinding = false;
        }
    }

    public T getService() {
        return this.service;
    }
}
