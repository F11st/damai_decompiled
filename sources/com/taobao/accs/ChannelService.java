package com.taobao.accs;

import android.app.Notification;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.IBinder;
import com.taobao.accs.asp.APreferencesManager;
import com.taobao.accs.base.BaseService;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.common.Constants;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.NoTraceTriggerHelper;
import com.taobao.accs.utl.OrangeAdapter;
import io.flutter.plugins.connectivity.ConnectivityBroadcastReceiver;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class ChannelService extends BaseService {
    public static final int DEFAULT_FORGROUND_V = 21;
    static final int NOTIFY_ID = 9371;
    public static final String SUPPORT_FOREGROUND_VERSION_KEY = "support_foreground_v";
    static final String TAG = "ChannelService";
    private static ChannelService mInstance;
    private boolean mFristStarted = true;
    private volatile boolean isRegisterReceiver = false;
    private final EventReceiver eventReceiver = new EventReceiver();

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static class KernelService extends Service {
        private static KernelService instance;
        private Context mContext;

        public static KernelService getInstance() {
            return instance;
        }

        @Override // android.app.Service
        public IBinder onBind(Intent intent) {
            return null;
        }

        @Override // android.app.Service
        public void onCreate() {
            super.onCreate();
            instance = this;
            this.mContext = getApplicationContext();
        }

        @Override // android.app.Service
        public void onDestroy() {
            try {
                stopForeground(true);
            } catch (Throwable th) {
                ALog.e(ChannelService.TAG, "onDestroy", th, new Object[0]);
            }
            instance = null;
            super.onDestroy();
        }

        @Override // android.app.Service
        public int onStartCommand(Intent intent, int i, int i2) {
            try {
                ThreadPoolExecutorFactory.execute(new Runnable() { // from class: com.taobao.accs.ChannelService.KernelService.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            ChannelService channelService = ChannelService.getInstance();
                            int i3 = KernelService.this.mContext.getPackageManager().getPackageInfo(KernelService.this.getPackageName(), 0).applicationInfo.icon;
                            if (i3 != 0) {
                                Notification.Builder builder = new Notification.Builder(KernelService.this.mContext);
                                builder.setSmallIcon(i3);
                                builder.setContentText("正在运行…");
                                channelService.startForeground(ChannelService.NOTIFY_ID, builder.build());
                                Notification.Builder builder2 = new Notification.Builder(KernelService.this.mContext);
                                builder2.setSmallIcon(i3);
                                builder2.setContentText("正在运行…");
                                KernelService.instance.startForeground(ChannelService.NOTIFY_ID, builder2.build());
                                KernelService.instance.stopForeground(true);
                            }
                            KernelService.instance.stopSelf();
                        } catch (Throwable th) {
                            ALog.e(ChannelService.TAG, " onStartCommand run", th, new Object[0]);
                        }
                    }
                });
            } catch (Throwable th) {
                ALog.e(ChannelService.TAG, " onStartCommand", th, new Object[0]);
            }
            return super.onStartCommand(intent, i, i2);
        }
    }

    public static ChannelService getInstance() {
        return mInstance;
    }

    static int getSupportForegroundVer(Context context) {
        try {
            return APreferencesManager.getSharedPreferences(context, Constants.SP_FILE_NAME, 0).getInt(SUPPORT_FOREGROUND_VERSION_KEY, 21);
        } catch (Throwable th) {
            ALog.e(TAG, "getSupportForegroundVer fail:", th, "key", SUPPORT_FOREGROUND_VERSION_KEY);
            return 21;
        }
    }

    static void startKernel(Context context) {
        try {
            if (Build.VERSION.SDK_INT < getSupportForegroundVer(context)) {
                Intent intent = new Intent(context, KernelService.class);
                intent.setPackage(context.getPackageName());
                context.startService(intent);
            }
        } catch (Throwable th) {
            ALog.e(TAG, "startKernel", th, new Object[0]);
        }
    }

    static void stopKernel(Context context) {
        try {
            if (Build.VERSION.SDK_INT < getSupportForegroundVer(context)) {
                Intent intent = new Intent(context, KernelService.class);
                intent.setPackage(context.getPackageName());
                context.stopService(intent);
            }
        } catch (Throwable th) {
            ALog.e(TAG, "stopKernel", th, new Object[0]);
        }
    }

    @Override // com.taobao.accs.base.BaseService, android.app.Service
    public void onCreate() {
        super.onCreate();
        GlobalClientInfo.mContext = getApplicationContext();
        mInstance = this;
        if (Build.VERSION.SDK_INT < 18) {
            try {
                startForeground(NOTIFY_ID, new Notification());
            } catch (Throwable th) {
                ALog.e(TAG, "ChannelService onCreate", th, new Object[0]);
            }
        }
        if (OrangeAdapter.isRegisterReceiverEnable(this)) {
            ThreadPoolExecutorFactory.getScheduledExecutor().execute(new Runnable() { // from class: com.taobao.accs.ChannelService.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        NoTraceTriggerHelper.registerEventReceiver(GlobalClientInfo.mContext);
                        IntentFilter intentFilter = new IntentFilter();
                        intentFilter.addAction(ConnectivityBroadcastReceiver.CONNECTIVITY_ACTION);
                        intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
                        intentFilter.addAction("android.intent.action.USER_PRESENT");
                        intentFilter.addDataScheme("package");
                        GlobalClientInfo.mContext.registerReceiver(ChannelService.this.eventReceiver, intentFilter);
                        ChannelService.this.isRegisterReceiver = true;
                    } catch (Throwable th2) {
                        ALog.e(ChannelService.TAG, "ChannelService onCreate registerReceiver", th2, new Object[0]);
                    }
                }
            });
        }
    }

    @Override // com.taobao.accs.base.BaseService, android.app.Service
    public void onDestroy() {
        if (Build.VERSION.SDK_INT < 18) {
            try {
                stopForeground(true);
            } catch (Throwable th) {
                ALog.e(TAG, "ChannelService onDestroy", th, new Object[0]);
            }
        }
        stopKernel(getApplicationContext());
        if (this.isRegisterReceiver) {
            try {
                unregisterReceiver(this.eventReceiver);
            } catch (Throwable th2) {
                ALog.e(TAG, "ChannelService unregisterReceiver", th2, new Object[0]);
            }
        }
        super.onDestroy();
    }

    @Override // com.taobao.accs.base.BaseService, android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        if (this.mFristStarted) {
            this.mFristStarted = false;
            startKernel(getApplicationContext());
        }
        return super.onStartCommand(intent, i, i2);
    }
}
