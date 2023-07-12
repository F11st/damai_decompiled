package com.huawei.hms.adapter;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.huawei.hms.activity.BridgeActivity;
import com.huawei.hms.api.BindingFailedResolution;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.Util;
import org.apache.commons.lang3.time.DateUtils;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class BinderAdapter implements ServiceConnection {
    private static final int BINDER_SYSTEM_ERROR = -1;
    private static final int DELAY_MILLIS = 60000;
    private static final String TAG = "BinderAdapter";
    private BinderCallBack callback;
    private final String mAction;
    private Context mContext;
    private final String mService;
    private IBinder serviceBinder;
    private final Object LOCK_CONNECT_TIMEOUT_HANDLER = new Object();
    private boolean bindFail = false;
    private Handler mBinderTimeoutHandler = null;
    private Handler delayDisconnectHandler = null;

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public interface BinderCallBack {
        void onBinderFailed(int i);

        void onBinderFailed(int i, Intent intent);

        void onNullBinding(ComponentName componentName);

        void onServiceConnected(ComponentName componentName, IBinder iBinder);

        void onServiceDisconnected(ComponentName componentName);

        void onTimedDisconnected();
    }

    public BinderAdapter(Context context, String str, String str2) {
        this.mContext = context;
        this.mAction = str;
        this.mService = str2;
    }

    private void bindCoreService() {
        if (TextUtils.isEmpty(this.mAction) || TextUtils.isEmpty(this.mService)) {
            getBindFailPendingIntent();
        }
        Intent intent = new Intent(this.mAction);
        intent.setPackage(this.mService);
        synchronized (this.LOCK_CONNECT_TIMEOUT_HANDLER) {
            if (this.mContext.bindService(intent, this, 1)) {
                postConnDelayHandle();
                return;
            }
            this.bindFail = true;
            getBindFailPendingIntent();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void binderServiceFailed() {
        BinderCallBack callBack = getCallBack();
        if (callBack != null) {
            callBack.onBinderFailed(-1);
        }
    }

    private void cancelConnDelayHandle() {
        synchronized (this.LOCK_CONNECT_TIMEOUT_HANDLER) {
            Handler handler = this.mBinderTimeoutHandler;
            if (handler != null) {
                handler.removeMessages(getConnTimeOut());
                this.mBinderTimeoutHandler = null;
            }
        }
    }

    private void delayedUnbind() {
        Handler handler = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.huawei.hms.adapter.BinderAdapter.2
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                if (message == null || message.what != BinderAdapter.this.getMsgDelayDisconnect()) {
                    return false;
                }
                HMSLog.i(BinderAdapter.TAG, "The serviceConnection has been bind for 60s, need to unbind.");
                BinderAdapter.this.unBind();
                BinderCallBack callBack = BinderAdapter.this.getCallBack();
                if (callBack != null) {
                    callBack.onTimedDisconnected();
                    return true;
                }
                return true;
            }
        });
        this.delayDisconnectHandler = handler;
        handler.sendEmptyMessageDelayed(getMsgDelayDisconnect(), DateUtils.MILLIS_PER_MINUTE);
    }

    private void getBindFailPendingIntent() {
        HMSLog.e(TAG, "In connect, bind core service fail");
        ComponentName componentName = new ComponentName(this.mContext.getApplicationInfo().packageName, "com.huawei.hms.activity.BridgeActivity");
        Intent intent = new Intent();
        intent.setComponent(componentName);
        intent.putExtra(BridgeActivity.EXTRA_DELEGATE_CLASS_NAME, BindingFailedResolution.class.getName());
        BinderCallBack callBack = getCallBack();
        if (callBack != null) {
            callBack.onBinderFailed(-1, intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public BinderCallBack getCallBack() {
        return this.callback;
    }

    private void postConnDelayHandle() {
        Handler handler = this.mBinderTimeoutHandler;
        if (handler != null) {
            handler.removeMessages(getConnTimeOut());
        } else {
            this.mBinderTimeoutHandler = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.huawei.hms.adapter.BinderAdapter.1
                @Override // android.os.Handler.Callback
                public boolean handleMessage(Message message) {
                    if (message == null || message.what != BinderAdapter.this.getConnTimeOut()) {
                        return false;
                    }
                    HMSLog.e(BinderAdapter.TAG, "In connect, bind core service time out");
                    BinderAdapter.this.binderServiceFailed();
                    return true;
                }
            });
        }
        this.mBinderTimeoutHandler.sendEmptyMessageDelayed(getConnTimeOut(), 10000L);
    }

    private void removeDelayDisconnectTask() {
        HMSLog.d(TAG, "removeDelayDisconnectTask.");
        synchronized (BinderAdapter.class) {
            Handler handler = this.delayDisconnectHandler;
            if (handler != null) {
                handler.removeMessages(getMsgDelayDisconnect());
            }
        }
    }

    public void binder(BinderCallBack binderCallBack) {
        if (binderCallBack == null) {
            return;
        }
        this.callback = binderCallBack;
        bindCoreService();
    }

    protected int getConnTimeOut() {
        return 0;
    }

    protected int getMsgDelayDisconnect() {
        return 0;
    }

    public IBinder getServiceBinder() {
        return this.serviceBinder;
    }

    @Override // android.content.ServiceConnection
    public void onNullBinding(ComponentName componentName) {
        HMSLog.e(TAG, "Enter onNullBinding, than unBind.");
        if (this.bindFail) {
            this.bindFail = false;
            return;
        }
        unBind();
        cancelConnDelayHandle();
        BinderCallBack callBack = getCallBack();
        if (callBack != null) {
            callBack.onNullBinding(componentName);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        HMSLog.i(TAG, "BinderAdapter Enter onServiceConnected.");
        this.serviceBinder = iBinder;
        cancelConnDelayHandle();
        BinderCallBack callBack = getCallBack();
        if (callBack != null) {
            callBack.onServiceConnected(componentName, iBinder);
        }
        delayedUnbind();
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        HMSLog.i(TAG, "Enter onServiceDisconnected.");
        BinderCallBack callBack = getCallBack();
        if (callBack != null) {
            callBack.onServiceDisconnected(componentName);
        }
        removeDelayDisconnectTask();
    }

    public void unBind() {
        Util.unBindServiceCatchException(this.mContext, this);
    }

    public void updateDelayTask() {
        HMSLog.d(TAG, "updateDelayTask.");
        synchronized (BinderAdapter.class) {
            Handler handler = this.delayDisconnectHandler;
            if (handler != null) {
                handler.removeMessages(getMsgDelayDisconnect());
                this.delayDisconnectHandler.sendEmptyMessageDelayed(getMsgDelayDisconnect(), DateUtils.MILLIS_PER_MINUTE);
            }
        }
    }
}
