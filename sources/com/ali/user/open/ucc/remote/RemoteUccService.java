package com.ali.user.open.ucc.remote;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.ali.user.open.core.AliMemberSDK;
import com.ali.user.open.service.SessionService;
import com.ali.user.open.session.Session;
import com.ali.user.open.ucc.IRemoteUccCallback;
import com.ali.user.open.ucc.IRemoteUccService;
import com.ali.user.open.ucc.UccCallback;
import com.ali.user.open.ucc.UccService;
import com.ali.user.open.ucc.UccServiceImpl;
import com.alibaba.fastjson.JSON;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class RemoteUccService extends Service {
    private static final String TAG = "RemoteUccService";
    private UccBinder binder = new UccBinder();
    private final RemoteCallbackList<IRemoteUccCallback> mTrustLoginListenerList = new RemoteCallbackList<>();
    private final RemoteCallbackList<IRemoteUccCallback> mBindListenerList = new RemoteCallbackList<>();
    private final RemoteCallbackList<IRemoteUccCallback> mUnbindListenerList = new RemoteCallbackList<>();

    /* compiled from: Taobao */
    /* loaded from: classes9.dex */
    class UccBinder extends IRemoteUccService.Stub {
        UccBinder() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void onReceiveFail(RemoteCallbackList<IRemoteUccCallback> remoteCallbackList, String str, int i, String str2) {
            synchronized (remoteCallbackList) {
                int beginBroadcast = remoteCallbackList.beginBroadcast();
                for (int i2 = 0; i2 < beginBroadcast; i2++) {
                    try {
                        IRemoteUccCallback broadcastItem = remoteCallbackList.getBroadcastItem(i2);
                        if (broadcastItem != null) {
                            broadcastItem.onFail(str, i, str2);
                        }
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
                remoteCallbackList.kill();
                remoteCallbackList.finishBroadcast();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void onReceiveSuccess(RemoteCallbackList<IRemoteUccCallback> remoteCallbackList, String str, Map map) {
            synchronized (remoteCallbackList) {
                int beginBroadcast = remoteCallbackList.beginBroadcast();
                for (int i = 0; i < beginBroadcast; i++) {
                    try {
                        IRemoteUccCallback broadcastItem = remoteCallbackList.getBroadcastItem(i);
                        if (broadcastItem != null) {
                            broadcastItem.onSuccess(str, map);
                        }
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
                remoteCallbackList.kill();
                remoteCallbackList.finishBroadcast();
            }
        }

        @Override // com.ali.user.open.ucc.IRemoteUccService
        public void bind(String str, Map map, IRemoteUccCallback iRemoteUccCallback) {
            try {
                RemoteUccService.this.mBindListenerList.register(iRemoteUccCallback);
                UccServiceImpl.getInstance().setUccDataProvider(((UccService) AliMemberSDK.getService(UccService.class)).getUccDataProvider());
                UccServiceImpl.getInstance().bind(str, map, new UccCallback() { // from class: com.ali.user.open.ucc.remote.RemoteUccService.UccBinder.1
                    @Override // com.ali.user.open.ucc.UccCallback
                    public void onFail(String str2, int i, String str3) {
                        try {
                            UccBinder uccBinder = UccBinder.this;
                            uccBinder.onReceiveFail(RemoteUccService.this.mBindListenerList, str2, i, str3);
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }

                    @Override // com.ali.user.open.ucc.UccCallback
                    public void onSuccess(String str2, Map map2) {
                        try {
                            UccBinder uccBinder = UccBinder.this;
                            uccBinder.onReceiveSuccess(RemoteUccService.this.mBindListenerList, str2, map2);
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                });
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        @Override // com.ali.user.open.ucc.IRemoteUccService
        public String getSession(String str) {
            Session session = ((SessionService) AliMemberSDK.getService(SessionService.class)).getSession(str);
            return session == null ? "" : JSON.toJSONString(session);
        }

        @Override // com.ali.user.open.ucc.IRemoteUccService
        public void logout(String str) {
            UccServiceImpl.getInstance().logout(RemoteUccService.this.getApplicationContext(), str);
        }

        @Override // com.ali.user.open.ucc.IRemoteUccService
        public void logoutAll() {
            UccServiceImpl.getInstance().logoutAll(RemoteUccService.this.getApplicationContext());
        }

        @Override // com.ali.user.open.ucc.IRemoteUccService
        public void trustLogin(String str, Map map, IRemoteUccCallback iRemoteUccCallback) {
            try {
                RemoteUccService.this.mTrustLoginListenerList.register(iRemoteUccCallback);
                UccServiceImpl.getInstance().setUccDataProvider(((UccService) AliMemberSDK.getService(UccService.class)).getUccDataProvider());
                UccServiceImpl.getInstance().trustLogin(str, map, new UccCallback() { // from class: com.ali.user.open.ucc.remote.RemoteUccService.UccBinder.2
                    @Override // com.ali.user.open.ucc.UccCallback
                    public void onFail(String str2, int i, String str3) {
                        try {
                            UccBinder uccBinder = UccBinder.this;
                            uccBinder.onReceiveFail(RemoteUccService.this.mTrustLoginListenerList, str2, i, str3);
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }

                    @Override // com.ali.user.open.ucc.UccCallback
                    public void onSuccess(String str2, Map map2) {
                        try {
                            UccBinder uccBinder = UccBinder.this;
                            uccBinder.onReceiveSuccess(RemoteUccService.this.mTrustLoginListenerList, str2, map2);
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                });
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        @Override // com.ali.user.open.ucc.IRemoteUccService
        public void unbind(String str, Map map, IRemoteUccCallback iRemoteUccCallback) {
            try {
                RemoteUccService.this.mUnbindListenerList.register(iRemoteUccCallback);
                UccServiceImpl.getInstance().setUccDataProvider(((UccService) AliMemberSDK.getService(UccService.class)).getUccDataProvider());
                UccServiceImpl.getInstance().unbind(str, map, new UccCallback() { // from class: com.ali.user.open.ucc.remote.RemoteUccService.UccBinder.3
                    @Override // com.ali.user.open.ucc.UccCallback
                    public void onFail(String str2, int i, String str3) {
                        try {
                            UccBinder uccBinder = UccBinder.this;
                            uccBinder.onReceiveFail(RemoteUccService.this.mUnbindListenerList, str2, i, str3);
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }

                    @Override // com.ali.user.open.ucc.UccCallback
                    public void onSuccess(String str2, Map map2) {
                        try {
                            UccBinder uccBinder = UccBinder.this;
                            uccBinder.onReceiveSuccess(RemoteUccService.this.mUnbindListenerList, str2, map2);
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                });
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.binder;
    }
}
