package com.taobao.android.service;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.IBinder;
import android.os.RemoteException;
import com.taobao.android.modular.IAidlServiceBridge;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class AidlBridgeService extends Service {
    private static final String b = AidlBridgeService.class.getName();
    private static final BroadcastReceiver c = new BroadcastReceiver() { // from class: com.taobao.android.service.AidlBridgeService.2
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
        }
    };
    private IAidlServiceBridge a = new IAidlServiceBridge.Stub() { // from class: com.taobao.android.service.AidlBridgeService.1
        private Map<ComponentName, ServiceConnectionC6587a> mServices = new HashMap();

        @Override // com.taobao.android.modular.IAidlServiceBridge
        public synchronized IBinder bindService(Intent intent) {
            ComponentName component = intent.getComponent();
            boolean z = false;
            if (component == null) {
                ResolveInfo resolveService = AidlBridgeService.this.getPackageManager().resolveService(intent, 0);
                if (resolveService == null) {
                    return null;
                }
                ServiceInfo serviceInfo = resolveService.serviceInfo;
                component = new ComponentName(serviceInfo.packageName, serviceInfo.name);
            }
            ServiceConnectionC6587a serviceConnectionC6587a = this.mServices.get(component);
            if (serviceConnectionC6587a != null) {
                return serviceConnectionC6587a.a;
            }
            intent.setComponent(component);
            ServiceConnectionC6587a serviceConnectionC6587a2 = new ServiceConnectionC6587a();
            try {
                z = LocalAidlServices.b(AidlBridgeService.this, intent, serviceConnectionC6587a2);
            } catch (ClassNotFoundException unused) {
            }
            if (z) {
                this.mServices.put(component, serviceConnectionC6587a2);
                return serviceConnectionC6587a2.a;
            }
            return null;
        }

        @Override // com.taobao.android.modular.IAidlServiceBridge
        public synchronized void unbindService(IBinder iBinder) {
            Iterator<Map.Entry<ComponentName, ServiceConnectionC6587a>> it = this.mServices.entrySet().iterator();
            while (it.hasNext()) {
                ServiceConnectionC6587a value = it.next().getValue();
                if (value.a == iBinder) {
                    LocalAidlServices.h(AidlBridgeService.this, value);
                    it.remove();
                }
            }
        }
    };

    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.service.AidlBridgeService$a */
    /* loaded from: classes12.dex */
    private static class ServiceConnectionC6587a implements ServiceConnection {
        IBinder a;

        private ServiceConnectionC6587a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            this.a = iBinder;
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public static IBinder a(Context context) {
        return c.peekService(context, new Intent(context, AidlBridgeService.class));
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        if (intent.getAction() == null) {
            return (IBinder) this.a;
        }
        intent.setComponent(null).setPackage(getPackageName());
        List<ResolveInfo> queryIntentServices = getPackageManager().queryIntentServices(intent, 0);
        if (queryIntentServices != null && !queryIntentServices.isEmpty()) {
            Iterator<ResolveInfo> it = queryIntentServices.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ResolveInfo next = it.next();
                if (!b.equals(next.serviceInfo.name)) {
                    ServiceInfo serviceInfo = next.serviceInfo;
                    intent.setComponent(new ComponentName(serviceInfo.packageName, serviceInfo.name));
                    try {
                        IBinder bindService = this.a.bindService(intent);
                        intent.setComponent(null);
                        return bindService;
                    } catch (RemoteException unused) {
                    }
                }
            }
        }
        return null;
    }
}
