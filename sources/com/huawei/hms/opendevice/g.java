package com.huawei.hms.opendevice;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.huawei.hms.support.log.HMSLog;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class g implements ServiceConnection {
    public final /* synthetic */ Bundle a;
    public final /* synthetic */ Context b;
    public final /* synthetic */ h c;

    public g(h hVar, Bundle bundle, Context context) {
        this.c = hVar;
        this.a = bundle;
        this.b = context;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        ServiceConnection serviceConnection;
        Messenger messenger;
        HMSLog.i("RemoteService", "remote service onConnected");
        this.c.b = new Messenger(iBinder);
        Message obtain = Message.obtain();
        obtain.setData(this.a);
        try {
            messenger = this.c.b;
            messenger.send(obtain);
        } catch (RemoteException unused) {
            HMSLog.i("RemoteService", "remote service message send failed");
        }
        HMSLog.i("RemoteService", "remote service unbindservice");
        Context context = this.b;
        serviceConnection = this.c.a;
        context.unbindService(serviceConnection);
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        HMSLog.i("RemoteService", "remote service onDisconnected");
        this.c.b = null;
    }
}
