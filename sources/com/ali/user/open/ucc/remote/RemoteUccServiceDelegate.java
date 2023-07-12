package com.ali.user.open.ucc.remote;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ali.user.open.core.AliMemberSDK;
import com.ali.user.open.core.Site;
import com.ali.user.open.core.config.ConfigManager;
import com.ali.user.open.core.context.KernelContext;
import com.ali.user.open.core.model.LoginReturnData;
import com.ali.user.open.core.trace.SDKLogger;
import com.ali.user.open.core.util.CommonUtils;
import com.ali.user.open.service.SessionService;
import com.ali.user.open.session.Session;
import com.ali.user.open.ucc.IRemoteUccCallback;
import com.ali.user.open.ucc.IRemoteUccService;
import com.ali.user.open.ucc.UccCallback;
import com.ali.user.open.ucc.UccService;
import com.ali.user.open.ucc.UccServiceImpl;
import com.ali.user.open.ucc.UccServiceProviderFactory;
import com.ali.user.open.ucc.remote.broadcast.UccBroadcastHelper;
import com.ali.user.open.ucc.remote.broadcast.UccBroadcastReceiver;
import com.ali.user.open.ucc.util.UccConstants;
import com.alibaba.fastjson.JSON;
import com.taobao.orange.OConfigListener;
import com.taobao.orange.OrangeConfig;
import com.youku.danmaku.engine.danmaku.model.android.DanmakuFactory;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeoutException;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class RemoteUccServiceDelegate extends UccServiceImpl {
    public static final String TAG = "UccServiceImpl";
    private static volatile RemoteUccServiceDelegate sInstance;
    private IRemoteUccService mIRemoteUccService;
    private IBinder.DeathRecipient mDeathRecipient = new IBinder.DeathRecipient() { // from class: com.ali.user.open.ucc.remote.RemoteUccServiceDelegate.1
        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            if (RemoteUccServiceDelegate.this.mIRemoteUccService != null) {
                RemoteUccServiceDelegate.this.mIRemoteUccService.asBinder().unlinkToDeath(RemoteUccServiceDelegate.this.mDeathRecipient, 0);
                RemoteUccServiceDelegate.this.mIRemoteUccService = null;
            }
            OrangeConfig.getInstance().registerListener(new String[]{"login4android"}, new OConfigListener() { // from class: com.ali.user.open.ucc.remote.RemoteUccServiceDelegate.1.1
                @Override // com.taobao.orange.OConfigListener
                public void onConfigUpdate(String str, Map<String, String> map) {
                    try {
                        if (TextUtils.equals(OrangeConfig.getInstance().getConfig("login4android", "rebind_ucc_service_when_death", "false"), "true")) {
                            RemoteUccServiceDelegate.this.bindService();
                        }
                        OrangeConfig.getInstance().unregisterListener(new String[]{"login4android"}, this);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            }, false);
        }
    };
    private ServiceConnection conn = new ServiceConnection() { // from class: com.ali.user.open.ucc.remote.RemoteUccServiceDelegate.2
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            synchronized (RemoteUccServiceDelegate.this.mLock) {
                RemoteUccServiceDelegate.this.mIRemoteUccService = IRemoteUccService.Stub.asInterface(iBinder);
                RemoteUccServiceDelegate.this.mLock.notifyAll();
            }
            try {
                iBinder.linkToDeath(RemoteUccServiceDelegate.this.mDeathRecipient, 0);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            RemoteUccServiceDelegate.this.mIRemoteUccService = null;
            SDKLogger.d("UccServiceImpl", "binder died");
        }
    };
    private final Object mLock = new Object();

    public RemoteUccServiceDelegate() {
        if (!ConfigManager.getInstance().isMultiProcessEnable || TextUtils.equals(CommonUtils.getProcessName(KernelContext.getApplicationContext()), KernelContext.getApplicationContext().getPackageName())) {
            return;
        }
        bindService();
        UccBroadcastHelper.registerLoginReceiver(KernelContext.getApplicationContext(), new UccBroadcastReceiver());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bindService() {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(KernelContext.getApplicationContext().getPackageName(), "com.ali.user.open.ucc.remote.RemoteUccService"));
        KernelContext.getApplicationContext().bindService(intent, this.conn, 1);
    }

    public static RemoteUccServiceDelegate getInstance() {
        if (sInstance == null) {
            synchronized (RemoteUccServiceDelegate.class) {
                if (sInstance == null) {
                    sInstance = new RemoteUccServiceDelegate();
                }
            }
        }
        return sInstance;
    }

    @Override // com.ali.user.open.ucc.UccServiceImpl, com.ali.user.open.ucc.UccService
    public void bind(Activity activity, String str, String str2, UccCallback uccCallback) {
        bind(activity, str, str2, new HashMap(4), uccCallback);
    }

    @Override // com.ali.user.open.ucc.UccServiceImpl, com.ali.user.open.ucc.UccService
    public void cleanUp() {
        UccServiceProviderFactory.getInstance().cleanUp();
    }

    @Override // com.ali.user.open.ucc.UccServiceImpl, com.ali.user.open.ucc.UccService
    public Session getSession(String str) {
        if (ConfigManager.getInstance().isMultiProcessEnable && !TextUtils.equals(CommonUtils.getProcessName(KernelContext.getApplicationContext()), KernelContext.getApplicationContext().getPackageName())) {
            try {
                IRemoteUccService iRemoteUccService = this.mIRemoteUccService;
                if (iRemoteUccService == null) {
                    bindService();
                    return null;
                }
                String session = iRemoteUccService.getSession(str);
                if (TextUtils.isEmpty(session)) {
                    return null;
                }
                return (Session) JSON.parseObject(session, Session.class);
            } catch (Throwable th) {
                th.printStackTrace();
                SDKLogger.e("UccServiceImpl", "remote unbind exception = " + th.getMessage());
                return null;
            }
        }
        return UccServiceImpl.getInstance().getSession(str);
    }

    @Override // com.ali.user.open.ucc.UccServiceImpl, com.ali.user.open.ucc.UccService
    public void logout(Context context, String str) {
        if (ConfigManager.getInstance().isMultiProcessEnable && !TextUtils.equals(CommonUtils.getProcessName(context.getApplicationContext()), context.getPackageName())) {
            try {
                IRemoteUccService iRemoteUccService = this.mIRemoteUccService;
                if (iRemoteUccService == null) {
                    bindService();
                    return;
                } else {
                    iRemoteUccService.logout(str);
                    return;
                }
            } catch (Throwable th) {
                th.printStackTrace();
                SDKLogger.e("UccServiceImpl", "remote unbind exception = " + th.getMessage());
                return;
            }
        }
        UccServiceImpl.getInstance().logout(context, str);
    }

    @Override // com.ali.user.open.ucc.UccServiceImpl, com.ali.user.open.ucc.UccService
    public void logoutAll(Context context) {
        if (ConfigManager.getInstance().isMultiProcessEnable && !TextUtils.equals(CommonUtils.getProcessName(context.getApplicationContext()), context.getPackageName())) {
            try {
                IRemoteUccService iRemoteUccService = this.mIRemoteUccService;
                if (iRemoteUccService == null) {
                    bindService();
                    return;
                } else {
                    iRemoteUccService.logoutAll();
                    return;
                }
            } catch (Throwable th) {
                th.printStackTrace();
                SDKLogger.e("UccServiceImpl", "remote unbind exception = " + th.getMessage());
                return;
            }
        }
        UccServiceImpl.getInstance().logoutAll(context);
    }

    @Override // com.ali.user.open.ucc.UccServiceImpl, com.ali.user.open.ucc.UccService
    public void trustLogin(Activity activity, @Site.SiteName String str, Map<String, String> map, UccCallback uccCallback) {
        if (activity == null) {
            trustLogin(str, map, uccCallback);
            return;
        }
        if (map != null) {
            map.remove("site");
        }
        if (ConfigManager.getInstance().isMultiProcessEnable && !TextUtils.equals(CommonUtils.getProcessName(KernelContext.getApplicationContext()), KernelContext.getApplicationContext().getPackageName())) {
            trustLogin(str, map, uccCallback);
            return;
        }
        UccServiceImpl.getInstance().setUccDataProvider(((UccService) AliMemberSDK.getService(UccService.class)).getUccDataProvider());
        UccServiceImpl.getInstance().trustLogin(activity, str, map, uccCallback);
    }

    @Override // com.ali.user.open.ucc.UccServiceImpl, com.ali.user.open.ucc.UccService
    public void unbind(@Site.SiteName String str, UccCallback uccCallback) {
        unbind(str, null, uccCallback);
    }

    public boolean waitUntilConnected(long j) throws InterruptedException, TimeoutException {
        try {
            IRemoteUccService iRemoteUccService = this.mIRemoteUccService;
            if (iRemoteUccService == null || iRemoteUccService.asBinder() == null) {
                synchronized (this.mLock) {
                    this.mLock.wait(j);
                }
                return true;
            }
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    @Override // com.ali.user.open.ucc.UccServiceImpl, com.ali.user.open.ucc.UccService
    public void bind(Activity activity, @NonNull String str, String str2, Map<String, String> map, UccCallback uccCallback) {
        if (activity == null) {
            bind(str, str2, map, uccCallback);
            return;
        }
        if (map != null) {
            map.remove("site");
        }
        if (ConfigManager.getInstance().isMultiProcessEnable && !TextUtils.equals(CommonUtils.getProcessName(activity.getApplicationContext()), activity.getPackageName())) {
            bind(str, str2, map, uccCallback);
            return;
        }
        UccServiceImpl.getInstance().setUccDataProvider(((UccService) AliMemberSDK.getService(UccService.class)).getUccDataProvider());
        UccServiceImpl.getInstance().bind(activity, str, str2, map, uccCallback);
    }

    @Override // com.ali.user.open.ucc.UccServiceImpl, com.ali.user.open.ucc.UccService
    public void unbind(final String str, final Map<String, String> map, final UccCallback uccCallback) {
        if (map != null) {
            map.remove("site");
        }
        if (ConfigManager.getInstance().isMultiProcessEnable && !TextUtils.equals(CommonUtils.getProcessName(KernelContext.getApplicationContext()), KernelContext.getApplicationContext().getPackageName())) {
            if (map == null) {
                try {
                    map = new HashMap<>();
                } catch (Throwable th) {
                    th.printStackTrace();
                    SDKLogger.e("UccServiceImpl", "remote unbind exception = " + th.getMessage());
                    if (uccCallback != null) {
                        uccCallback.onFail(str, 1999, "");
                        return;
                    }
                    return;
                }
            }
            map.put("process", CommonUtils.getProcessName(KernelContext.getApplicationContext()));
            ((ExecutorService) AliMemberSDK.getService(ExecutorService.class)).execute(new Runnable() { // from class: com.ali.user.open.ucc.remote.RemoteUccServiceDelegate.4
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (RemoteUccServiceDelegate.this.mIRemoteUccService == null || RemoteUccServiceDelegate.this.mIRemoteUccService.asBinder() == null || !RemoteUccServiceDelegate.this.mIRemoteUccService.asBinder().isBinderAlive()) {
                            RemoteUccServiceDelegate.this.bindService();
                            RemoteUccServiceDelegate.this.waitUntilConnected(DanmakuFactory.DEFAULT_DANMAKU_DURATION_V);
                        }
                        if (RemoteUccServiceDelegate.this.mIRemoteUccService == null) {
                            return;
                        }
                        RemoteUccServiceDelegate.this.mIRemoteUccService.unbind(str, map, new IRemoteUccCallback.Stub() { // from class: com.ali.user.open.ucc.remote.RemoteUccServiceDelegate.4.1
                            @Override // com.ali.user.open.ucc.IRemoteUccCallback
                            public void onFail(String str2, int i, String str3) throws RemoteException {
                                UccCallback uccCallback2 = uccCallback;
                                if (uccCallback2 != null) {
                                    uccCallback2.onFail(str2, i, str3);
                                }
                            }

                            @Override // com.ali.user.open.ucc.IRemoteUccCallback
                            public void onSuccess(String str2, Map map2) throws RemoteException {
                                UccCallback uccCallback2 = uccCallback;
                                if (uccCallback2 != null) {
                                    uccCallback2.onSuccess(str2, map2);
                                }
                            }
                        });
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                        UccCallback uccCallback2 = uccCallback;
                        if (uccCallback2 != null) {
                            uccCallback2.onFail(str, 1999, "");
                        }
                    }
                }
            });
            return;
        }
        UccServiceImpl.getInstance().setUccDataProvider(((UccService) AliMemberSDK.getService(UccService.class)).getUccDataProvider());
        UccServiceImpl.getInstance().unbind(str, map, uccCallback);
    }

    @Override // com.ali.user.open.ucc.UccServiceImpl, com.ali.user.open.ucc.UccService
    public void trustLogin(final String str, final Map<String, String> map, final UccCallback uccCallback) {
        if (map != null) {
            map.remove("site");
        }
        if (ConfigManager.getInstance().isMultiProcessEnable && !TextUtils.equals(CommonUtils.getProcessName(KernelContext.getApplicationContext()), KernelContext.getApplicationContext().getPackageName())) {
            if (map == null) {
                try {
                    map = new HashMap<>();
                } catch (Throwable th) {
                    th.printStackTrace();
                    SDKLogger.e("UccServiceImpl", "remote unbind exception = " + th.getMessage());
                    return;
                }
            }
            map.put("process", CommonUtils.getProcessName(KernelContext.getApplicationContext()));
            ((ExecutorService) AliMemberSDK.getService(ExecutorService.class)).execute(new Runnable() { // from class: com.ali.user.open.ucc.remote.RemoteUccServiceDelegate.5
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (RemoteUccServiceDelegate.this.mIRemoteUccService == null || RemoteUccServiceDelegate.this.mIRemoteUccService.asBinder() == null || !RemoteUccServiceDelegate.this.mIRemoteUccService.asBinder().isBinderAlive()) {
                            RemoteUccServiceDelegate.this.bindService();
                            RemoteUccServiceDelegate.this.waitUntilConnected(DanmakuFactory.DEFAULT_DANMAKU_DURATION_V);
                        }
                        if (RemoteUccServiceDelegate.this.mIRemoteUccService == null) {
                            return;
                        }
                        RemoteUccServiceDelegate.this.mIRemoteUccService.trustLogin(str, map, new IRemoteUccCallback.Stub() { // from class: com.ali.user.open.ucc.remote.RemoteUccServiceDelegate.5.1
                            @Override // com.ali.user.open.ucc.IRemoteUccCallback
                            public void onFail(String str2, int i, String str3) throws RemoteException {
                                UccCallback uccCallback2 = uccCallback;
                                if (uccCallback2 != null) {
                                    uccCallback2.onFail(str2, i, str3);
                                }
                            }

                            @Override // com.ali.user.open.ucc.IRemoteUccCallback
                            public void onSuccess(String str2, Map map2) throws RemoteException {
                                if (map2 != null) {
                                    String str3 = (String) map2.get(UccConstants.PARAM_LOGIN_DATA);
                                    if (!TextUtils.isEmpty(str3)) {
                                        ((SessionService) AliMemberSDK.getService(SessionService.class)).refreshCookie(str2, (LoginReturnData) JSON.parseObject(str3, LoginReturnData.class));
                                    }
                                }
                                UccCallback uccCallback2 = uccCallback;
                                if (uccCallback2 != null) {
                                    uccCallback2.onSuccess(str2, map2);
                                }
                            }
                        });
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                        UccCallback uccCallback2 = uccCallback;
                        if (uccCallback2 != null) {
                            uccCallback2.onFail(str, 1999, "");
                        }
                    }
                }
            });
            return;
        }
        UccServiceImpl.getInstance().setUccDataProvider(((UccService) AliMemberSDK.getService(UccService.class)).getUccDataProvider());
        UccServiceImpl.getInstance().trustLogin(str, map, uccCallback);
    }

    @Override // com.ali.user.open.ucc.UccServiceImpl, com.ali.user.open.ucc.UccService
    public void bind(@NonNull String str, String str2, Map<String, String> map, UccCallback uccCallback) {
        SDKLogger.d("UccServiceImpl", "bind goUccActivity");
        if (map != null) {
            map.remove("site");
        }
        if (ConfigManager.getInstance().isMultiProcessEnable && !TextUtils.equals(CommonUtils.getProcessName(KernelContext.getApplicationContext()), KernelContext.getApplicationContext().getPackageName())) {
            bind(str2, map, uccCallback);
            return;
        }
        UccServiceImpl.getInstance().setUccDataProvider(((UccService) AliMemberSDK.getService(UccService.class)).getUccDataProvider());
        UccServiceImpl.getInstance().bind(str, str2, map, uccCallback);
    }

    @Override // com.ali.user.open.ucc.UccServiceImpl, com.ali.user.open.ucc.UccService
    public void bind(Activity activity, String str, UccCallback uccCallback) {
        bind(activity, str, new HashMap(4), uccCallback);
    }

    @Override // com.ali.user.open.ucc.UccServiceImpl, com.ali.user.open.ucc.UccService
    public void bind(Activity activity, String str, Map<String, String> map, UccCallback uccCallback) {
        if (activity == null) {
            bind(str, map, uccCallback);
            return;
        }
        if (map != null) {
            map.remove("site");
        }
        if (ConfigManager.getInstance().isMultiProcessEnable && !TextUtils.equals(CommonUtils.getProcessName(activity.getApplicationContext()), activity.getPackageName())) {
            bind(str, map, uccCallback);
            return;
        }
        UccServiceImpl.getInstance().setUccDataProvider(((UccService) AliMemberSDK.getService(UccService.class)).getUccDataProvider());
        UccServiceImpl.getInstance().bind(activity, str, map, uccCallback);
    }

    @Override // com.ali.user.open.ucc.UccServiceImpl, com.ali.user.open.ucc.UccService
    public void bind(final String str, final Map<String, String> map, final UccCallback uccCallback) {
        if (map != null) {
            map.remove("site");
        }
        if (ConfigManager.getInstance().isMultiProcessEnable && !TextUtils.equals(CommonUtils.getProcessName(KernelContext.getApplicationContext()), KernelContext.getApplicationContext().getPackageName())) {
            if (map == null) {
                try {
                    map = new HashMap<>();
                } catch (Throwable th) {
                    th.printStackTrace();
                    SDKLogger.e("UccServiceImpl", "remote bind exception = " + th.getMessage());
                    return;
                }
            }
            map.put("process", CommonUtils.getProcessName(KernelContext.getApplicationContext()));
            ((ExecutorService) AliMemberSDK.getService(ExecutorService.class)).execute(new Runnable() { // from class: com.ali.user.open.ucc.remote.RemoteUccServiceDelegate.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (RemoteUccServiceDelegate.this.mIRemoteUccService == null || RemoteUccServiceDelegate.this.mIRemoteUccService.asBinder() == null || !RemoteUccServiceDelegate.this.mIRemoteUccService.asBinder().isBinderAlive()) {
                            RemoteUccServiceDelegate.this.bindService();
                            RemoteUccServiceDelegate.this.waitUntilConnected(DanmakuFactory.DEFAULT_DANMAKU_DURATION_V);
                        }
                        if (RemoteUccServiceDelegate.this.mIRemoteUccService == null) {
                            return;
                        }
                        RemoteUccServiceDelegate.this.mIRemoteUccService.bind(str, map, new IRemoteUccCallback.Stub() { // from class: com.ali.user.open.ucc.remote.RemoteUccServiceDelegate.3.1
                            @Override // com.ali.user.open.ucc.IRemoteUccCallback
                            public void onFail(String str2, int i, String str3) throws RemoteException {
                                UccCallback uccCallback2 = uccCallback;
                                if (uccCallback2 != null) {
                                    uccCallback2.onFail(str2, i, str3);
                                }
                            }

                            @Override // com.ali.user.open.ucc.IRemoteUccCallback
                            public void onSuccess(String str2, Map map2) throws RemoteException {
                                if (map2 != null) {
                                    String str3 = (String) map2.get(UccConstants.PARAM_LOGIN_DATA);
                                    if (!TextUtils.isEmpty(str3)) {
                                        ((SessionService) AliMemberSDK.getService(SessionService.class)).refreshCookie(str2, (LoginReturnData) JSON.parseObject(str3, LoginReturnData.class));
                                    }
                                }
                                UccCallback uccCallback2 = uccCallback;
                                if (uccCallback2 != null) {
                                    uccCallback2.onSuccess(str2, map2);
                                }
                            }
                        });
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                        SDKLogger.e("UccServiceImpl", "remote bind exception = " + th2.getMessage());
                    }
                }
            });
            return;
        }
        UccServiceImpl.getInstance().setUccDataProvider(((UccService) AliMemberSDK.getService(UccService.class)).getUccDataProvider());
        UccServiceImpl.getInstance().bind(str, map, uccCallback);
    }
}
