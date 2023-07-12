package com.taobao.accs.windvane;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.taobao.windvane.extra.jsbridge.WVACCSService;
import androidx.annotation.Keep;
import com.taobao.accs.base.TaoBaseService;
import com.taobao.accs.utl.ALog;
import com.taobao.browser.ipc.ConnectInfoWrapper;
import com.taobao.browser.ipc.ExtraInfoWrapper;
import com.taobao.browser.ipc.ProcessUtils;
import com.taobao.browser.ipc.RemoteAccsStub;
import com.taobao.browser.ipc.RemoteWVACCSService;

/* compiled from: Taobao */
@Keep
/* loaded from: classes8.dex */
public class BrowserACCSService extends WVACCSService {
    private static final String TAG = "BrowserACCSService";
    private InsideConnection mConnection;
    private volatile boolean mIsBinding;
    private volatile boolean mIsConnect;
    private RemoteAccsStub mStub = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public class InsideConnection implements ServiceConnection {
        InsideConnection() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            ALog.d(BrowserACCSService.TAG, "onServiceConnected", new Object[0]);
            BrowserACCSService.this.mStub = RemoteAccsStub.Stub.asInterface(iBinder);
            BrowserACCSService.this.mIsConnect = true;
            BrowserACCSService.this.mIsBinding = false;
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            BrowserACCSService.this.mIsConnect = false;
            BrowserACCSService.this.mIsBinding = false;
        }
    }

    private synchronized void checkConnection() {
        if (this.mStub == null || !this.mIsConnect) {
            if (this.mIsBinding) {
                return;
            }
            try {
                if (ProcessUtils.isMainProcess(this)) {
                    if (ProcessUtils.isProcessAlive(this, getPackageName() + ":wml1")) {
                        ALog.d(TAG, "Begin to bind sub process", new Object[0]);
                        this.mIsBinding = true;
                        this.mConnection = new InsideConnection();
                        Intent intent = new Intent();
                        intent.setClass(this, RemoteWVACCSService.class);
                        startService(intent);
                        bindService(intent, this.mConnection, 1);
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    @Override // android.taobao.windvane.extra.jsbridge.WVACCSService, com.taobao.accs.base.TaoBaseService, com.taobao.accs.base.AccsDataListener
    public void onConnected(TaoBaseService.ConnectInfo connectInfo) {
        if (ProcessUtils.isMainProcess(this)) {
            if (ProcessUtils.isProcessAlive(this, getPackageName() + ":wml1")) {
                if (this.mStub != null && this.mIsConnect) {
                    try {
                        ALog.d(TAG, "Transform onConnected()", new Object[0]);
                        this.mStub.onConnected(new ConnectInfoWrapper(connectInfo));
                    } catch (Throwable th) {
                        ALog.e(TAG, "onConnected error:", th, new Object[0]);
                    }
                } else {
                    checkConnection();
                }
            }
        }
        ALog.e(TAG, "onConnected()", new Object[0]);
        super.onConnected(connectInfo);
    }

    @Override // android.taobao.windvane.extra.jsbridge.WVACCSService, com.taobao.accs.base.TaoBaseService, android.app.Service
    public void onCreate() {
        super.onCreate();
    }

    @Override // android.taobao.windvane.extra.jsbridge.WVACCSService, com.taobao.accs.base.AccsDataListener
    public void onData(String str, String str2, String str3, byte[] bArr, TaoBaseService.ExtraInfo extraInfo) {
        if (ProcessUtils.isMainProcess(this)) {
            if (ProcessUtils.isProcessAlive(this, getPackageName() + ":wml1")) {
                if (this.mStub != null && this.mIsConnect) {
                    try {
                        ALog.d(TAG, "Transform onData()", new Object[0]);
                        this.mStub.onData(str, str2, str3, bArr, new ExtraInfoWrapper(extraInfo));
                    } catch (Throwable th) {
                        ALog.e(TAG, "onData error:", th, new Object[0]);
                    }
                } else {
                    checkConnection();
                }
            }
        }
        super.onData(str, str2, str3, bArr, extraInfo);
    }

    @Override // android.taobao.windvane.extra.jsbridge.WVACCSService, com.taobao.accs.base.TaoBaseService, com.taobao.accs.base.AccsDataListener
    public void onDisconnected(TaoBaseService.ConnectInfo connectInfo) {
        if (ProcessUtils.isMainProcess(this)) {
            if (ProcessUtils.isProcessAlive(this, getPackageName() + ":wml1")) {
                if (this.mStub != null && this.mIsConnect) {
                    try {
                        ALog.d(TAG, "Transform onDisconnected()", new Object[0]);
                        this.mStub.onDisconnected(new ConnectInfoWrapper(connectInfo));
                    } catch (Throwable th) {
                        ALog.e(TAG, "onDisconnected error:", th, new Object[0]);
                    }
                } else {
                    checkConnection();
                }
            }
        }
        ALog.e(TAG, "onDisconnected()", new Object[0]);
        super.onDisconnected(connectInfo);
    }

    @Override // com.taobao.accs.base.TaoBaseService, android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        checkConnection();
        return super.onStartCommand(intent, i, i2);
    }
}
