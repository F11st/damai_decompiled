package com.google.vr.internal.controller;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import android.util.SparseArray;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import com.google.vr.cardboard.annotations.UsedByNative;
import com.google.vr.vrcore.controller.api.ControllerEventPacket;
import com.google.vr.vrcore.controller.api.ControllerEventPacket2;
import com.google.vr.vrcore.controller.api.ControllerListenerOptions;
import com.google.vr.vrcore.controller.api.ControllerOrientationEvent;
import com.google.vr.vrcore.controller.api.IControllerListener;
import com.google.vr.vrcore.controller.api.IControllerService;
import java.lang.ref.WeakReference;
import tb.eo;

/* compiled from: Taobao */
@UsedByNative
/* loaded from: classes10.dex */
public class ControllerServiceBridge implements ServiceConnection {
    public static final int FLAG_SUPPORTS_RECENTER = 1;
    public static final int TARGET_SERVICE_API_VERSION = 13;
    static final String i = ControllerServiceBridge.class.getSimpleName();
    private final Context a;
    private final Handler b;
    private IControllerService c;
    private a d;
    private final SparseArray<a> e;
    private boolean f;
    private final Runnable g;
    private final Runnable h;

    /* compiled from: Taobao */
    @UsedByNative
    /* loaded from: classes10.dex */
    public interface Callbacks {
        void onControllerEventPacket(ControllerEventPacket controllerEventPacket);

        void onControllerEventPacket2(ControllerEventPacket2 controllerEventPacket2);

        void onControllerRecentered(ControllerOrientationEvent controllerOrientationEvent);

        void onControllerStateChanged(int i, int i2);

        void onServiceConnected(int i);

        void onServiceDisconnected();

        void onServiceFailed();

        void onServiceInitFailed(int i);

        void onServiceUnavailable();
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    static class ControllerListener extends IControllerListener.Stub {
        private final WeakReference<a> listener;

        public ControllerListener(a aVar) {
            this.listener = new WeakReference<>(aVar);
        }

        @Override // com.google.vr.vrcore.controller.api.IControllerListener
        public int getApiVersion() throws RemoteException {
            return 13;
        }

        @Override // com.google.vr.vrcore.controller.api.IControllerListener
        public ControllerListenerOptions getOptions() throws RemoteException {
            a aVar = this.listener.get();
            if (aVar == null) {
                return null;
            }
            return aVar.b;
        }

        @Override // com.google.vr.vrcore.controller.api.IControllerListener
        public void onControllerEventPacket(ControllerEventPacket controllerEventPacket) throws RemoteException {
            a aVar = this.listener.get();
            if (aVar == null) {
                return;
            }
            aVar.a.onControllerEventPacket(controllerEventPacket);
            controllerEventPacket.recycle();
        }

        @Override // com.google.vr.vrcore.controller.api.IControllerListener
        public void onControllerEventPacket2(ControllerEventPacket2 controllerEventPacket2) throws RemoteException {
            a aVar = this.listener.get();
            if (aVar == null) {
                return;
            }
            ControllerServiceBridge.e(controllerEventPacket2);
            aVar.a.onControllerEventPacket2(controllerEventPacket2);
            controllerEventPacket2.recycle();
        }

        @Override // com.google.vr.vrcore.controller.api.IControllerListener
        public void onControllerRecentered(ControllerOrientationEvent controllerOrientationEvent) {
            a aVar = this.listener.get();
            if (aVar == null) {
                return;
            }
            aVar.a.onControllerRecentered(controllerOrientationEvent);
        }

        @Override // com.google.vr.vrcore.controller.api.IControllerListener
        public void onControllerStateChanged(int i, int i2) throws RemoteException {
            a aVar = this.listener.get();
            if (aVar == null) {
                return;
            }
            aVar.a.onControllerStateChanged(i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class a {
        public final Callbacks a;
        public final ControllerListenerOptions b;

        public a(Callbacks callbacks, ControllerListenerOptions controllerListenerOptions) {
            this.a = callbacks;
            this.b = controllerListenerOptions;
        }
    }

    @UsedByNative
    public ControllerServiceBridge(Context context, Callbacks callbacks) {
        SparseArray<a> sparseArray = new SparseArray<>();
        this.e = sparseArray;
        this.g = new Runnable() { // from class: com.google.vr.internal.controller.ControllerServiceBridge.1
            @Override // java.lang.Runnable
            public void run() {
                ControllerServiceBridge.this.b();
            }
        };
        this.h = new Runnable() { // from class: com.google.vr.internal.controller.ControllerServiceBridge.2
            @Override // java.lang.Runnable
            public void run() {
                ControllerServiceBridge.this.c();
            }
        };
        this.a = context.getApplicationContext();
        a aVar = new a(callbacks, new ControllerListenerOptions());
        this.d = aVar;
        sparseArray.put(0, aVar);
        this.b = new Handler(Looper.getMainLooper());
    }

    private void d() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalStateException("This should be running on the main thread.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void e(ControllerEventPacket2 controllerEventPacket2) {
        if (controllerEventPacket2.getTimestampMillis() == 0) {
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime() - controllerEventPacket2.getTimestampMillis();
        if (elapsedRealtime > 300) {
            String str = i;
            StringBuilder sb = new StringBuilder(122);
            sb.append("Experiencing large controller packet delivery time between service and  client: timestamp diff in ms: ");
            sb.append(elapsedRealtime);
            Log.w(str, sb.toString());
        }
    }

    public void b() {
        d();
        if (this.f) {
            Log.w(i, "Service is already bound.");
            return;
        }
        Intent intent = new Intent("com.google.vr.vrcore.controller.BIND");
        intent.setPackage("com.google.vr.vrcore");
        if (!this.a.bindService(intent, this, 1)) {
            Log.w(i, "Bind failed. Service is not available.");
            this.d.a.onServiceUnavailable();
            return;
        }
        this.f = true;
    }

    public void c() {
        d();
        if (!this.f) {
            Log.w(i, "Service is already unbound.");
            return;
        }
        f();
        this.a.unbindService(this);
        this.f = false;
    }

    public void f() {
        d();
        IControllerService iControllerService = this.c;
        if (iControllerService == null) {
            return;
        }
        try {
            iControllerService.unregisterListener("com.google.vr.internal.controller.LISTENER_KEY");
        } catch (RemoteException e) {
            ThrowableExtension.printStackTrace(e);
            Log.w(i, "RemoteException while unregistering listener.");
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        d();
        IControllerService asInterface = IControllerService.Stub.asInterface(iBinder);
        this.c = asInterface;
        try {
            int initialize = asInterface.initialize(13);
            if (initialize != 0) {
                String str = i;
                String valueOf = String.valueOf(eo.a(initialize));
                Log.e(str, valueOf.length() != 0 ? "initialize() returned error: ".concat(valueOf) : new String("initialize() returned error: "));
                this.d.a.onServiceInitFailed(initialize);
                c();
                return;
            }
            this.d.a.onServiceConnected(1);
            try {
                if (!this.c.registerListener(0, "com.google.vr.internal.controller.LISTENER_KEY", new ControllerListener(this.d))) {
                    Log.w(i, "Failed to register listener.");
                    this.d.a.onServiceFailed();
                    c();
                    return;
                }
                this.e.put(0, this.d);
            } catch (RemoteException e) {
                ThrowableExtension.printStackTrace(e);
                Log.w(i, "RemoteException while registering listener.");
                this.d.a.onServiceFailed();
                c();
            }
        } catch (RemoteException e2) {
            ThrowableExtension.printStackTrace(e2);
            Log.e(i, "Failed to call initialize() on controller service (RemoteException).");
            this.d.a.onServiceFailed();
            c();
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        d();
        this.c = null;
        this.d.a.onServiceDisconnected();
    }

    @UsedByNative
    public void requestBind() {
        this.b.post(this.g);
    }

    @UsedByNative
    public void requestUnbind() {
        this.b.post(this.h);
    }

    @UsedByNative
    public void setAccelEnabled(boolean z) {
        this.d.b.enableAccel = z;
    }

    @UsedByNative
    public void setBatteryEnabled(boolean z) {
    }

    @UsedByNative
    public void setGesturesEnabled(boolean z) {
        this.d.b.enableGestures = z;
    }

    @UsedByNative
    public void setGyroEnabled(boolean z) {
        this.d.b.enableGyro = z;
    }

    @UsedByNative
    public void setOrientationEnabled(boolean z) {
        this.d.b.enableOrientation = z;
    }

    @UsedByNative
    public void setPositionEnabled(boolean z) {
    }

    @UsedByNative
    public void setTouchEnabled(boolean z) {
        this.d.b.enableTouch = z;
    }
}
