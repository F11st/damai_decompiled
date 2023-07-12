package com.xiaomi.push.service;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.xiaomi.channel.commonutils.logger.AbstractC7535b;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class bu implements ServiceConnection {
    final /* synthetic */ ServiceClient a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bu(ServiceClient serviceClient) {
        this.a = serviceClient;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        List<Message> list;
        List list2;
        Messenger messenger;
        synchronized (this.a) {
            this.a.f828b = new Messenger(iBinder);
            this.a.f829b = false;
            list = this.a.f826a;
            for (Message message : list) {
                try {
                    messenger = this.a.f828b;
                    messenger.send(message);
                } catch (RemoteException e) {
                    AbstractC7535b.a(e);
                }
            }
            list2 = this.a.f826a;
            list2.clear();
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        this.a.f828b = null;
        this.a.f829b = false;
    }
}
