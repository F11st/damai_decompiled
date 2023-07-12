package anetwork.channel.aidl;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import anet.channel.util.ALog;
import anetwork.channel.aidl.IRemoteNetworkGetter;
import anetwork.channel.aidl.RemoteNetwork;
import anetwork.channel.degrade.DegradableNetworkDelegate;
import anetwork.channel.http.HttpNetworkDelegate;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class NetworkService extends Service {
    private static final String TAG = "anet.NetworkService";
    private Context context;
    private RemoteNetwork.Stub degradeableNetwork = null;
    private RemoteNetwork.Stub httpNetwork = null;
    IRemoteNetworkGetter.Stub stub = new IRemoteNetworkGetter.Stub() { // from class: anetwork.channel.aidl.NetworkService.1
        @Override // anetwork.channel.aidl.IRemoteNetworkGetter
        public RemoteNetwork get(int i) throws RemoteException {
            return i == 1 ? NetworkService.this.degradeableNetwork : NetworkService.this.httpNetwork;
        }
    };

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        this.context = getApplicationContext();
        if (ALog.g(2)) {
            ALog.f(TAG, "onBind:" + intent.getAction(), null, new Object[0]);
        }
        this.degradeableNetwork = new DegradableNetworkDelegate(this.context);
        this.httpNetwork = new HttpNetworkDelegate(this.context);
        if (IRemoteNetworkGetter.class.getName().equals(intent.getAction())) {
            return this.stub;
        }
        return null;
    }

    @Override // android.app.Service
    public void onDestroy() {
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        return 2;
    }
}
