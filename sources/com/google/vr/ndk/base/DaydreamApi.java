package com.google.vr.ndk.base;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.vr.cardboard.annotations.UsedByReflection;
import com.google.vr.vrcore.base.api.VrCoreNotAvailableException;
import com.google.vr.vrcore.base.api.VrCoreUtils;
import com.google.vr.vrcore.common.api.IDaydreamManager;
import com.google.vr.vrcore.common.api.ITransitionCallbacks;
import com.google.vr.vrcore.common.api.IVrCoreSdkService;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
@UsedByReflection("IAP")
@TargetApi(24)
/* loaded from: classes10.dex */
public class DaydreamApi implements AutoCloseable {
    private static final String TAG = DaydreamApi.class.getSimpleName();
    private boolean closed;
    private final Context context;
    private IDaydreamManager daydreamManager;
    private int vrCoreApiVersion;
    private IVrCoreSdkService vrCoreSdkService;
    private ArrayList<Runnable> queuedRunnables = new ArrayList<>();
    private final ServiceConnection connection = new ServiceConnection() { // from class: com.google.vr.ndk.base.DaydreamApi.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            DaydreamApi.this.vrCoreSdkService = IVrCoreSdkService.Stub.asInterface(iBinder);
            try {
                DaydreamApi daydreamApi = DaydreamApi.this;
                daydreamApi.daydreamManager = daydreamApi.vrCoreSdkService.getDaydreamManager();
            } catch (RemoteException unused) {
                Log.e(DaydreamApi.TAG, "RemoteException in onServiceConnected");
            }
            if (DaydreamApi.this.daydreamManager == null) {
                Log.w(DaydreamApi.TAG, "Daydream service component unavailable.");
            }
            ArrayList arrayList = DaydreamApi.this.queuedRunnables;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                ((Runnable) obj).run();
            }
            DaydreamApi.this.queuedRunnables.clear();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            DaydreamApi.this.vrCoreSdkService = null;
        }
    };

    /* compiled from: Taobao */
    /* renamed from: com.google.vr.ndk.base.DaydreamApi$10  reason: invalid class name */
    /* loaded from: classes10.dex */
    class AnonymousClass10 implements Runnable {
        final /* synthetic */ byte[] val$deviceParams;

        AnonymousClass10(byte[] bArr) {
            this.val$deviceParams = bArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (DaydreamApi.this.vrCoreApiVersion < 11) {
                String str = DaydreamApi.TAG;
                int i = DaydreamApi.this.vrCoreApiVersion;
                StringBuilder sb = new StringBuilder("Can't handle insertion of phone into headset: VrCore API too old. Need: 11, found: ".length() + 11);
                sb.append("Can't handle insertion of phone into headset: VrCore API too old. Need: 11, found: ");
                sb.append(i);
                Log.e(str, sb.toString());
            } else if (DaydreamApi.this.daydreamManager == null) {
                Log.e(DaydreamApi.TAG, "Can't handle insertion of phone into headset: no DaydreamManager.");
            } else {
                try {
                    DaydreamApi.this.daydreamManager.handleInsertionIntoHeadset(this.val$deviceParams);
                } catch (RemoteException e) {
                    Log.e(DaydreamApi.TAG, "RemoteException while notifying phone insertion.", e);
                } catch (SecurityException e2) {
                    Log.e(DaydreamApi.TAG, "SecurityException when notifying phone insertion. Check that the calling app is in the system image (must have the SYSTEM flag in package manager).", e2);
                }
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.google.vr.ndk.base.DaydreamApi$11  reason: invalid class name */
    /* loaded from: classes10.dex */
    class AnonymousClass11 implements Runnable {
        AnonymousClass11() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (DaydreamApi.this.vrCoreApiVersion < 11) {
                String str = DaydreamApi.TAG;
                int i = DaydreamApi.this.vrCoreApiVersion;
                StringBuilder sb = new StringBuilder("Can't handle removal of phone from headset: VrCore API too old. Need: 11, found: ".length() + 11);
                sb.append("Can't handle removal of phone from headset: VrCore API too old. Need: 11, found: ");
                sb.append(i);
                Log.e(str, sb.toString());
            } else if (DaydreamApi.this.daydreamManager == null) {
                Log.e(DaydreamApi.TAG, "Can't handle removal of phone from headset: no DaydreamManager.");
            } else {
                try {
                    DaydreamApi.this.daydreamManager.handleRemovalFromHeadset();
                } catch (RemoteException e) {
                    Log.e(DaydreamApi.TAG, "RemoteException while notifying phone removal.", e);
                } catch (SecurityException e2) {
                    Log.e(DaydreamApi.TAG, "SecurityException when notifying phone removal. Check that the calling app is in the system image (must have the SYSTEM flag in package manager).", e2);
                }
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.google.vr.ndk.base.DaydreamApi$2  reason: invalid class name */
    /* loaded from: classes10.dex */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ PendingIntent val$intent;

        AnonymousClass2(PendingIntent pendingIntent) {
            this.val$intent = pendingIntent;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (DaydreamApi.this.daydreamManager == null) {
                Log.w(DaydreamApi.TAG, "Can't register/unregister daydream intent: no DaydreamManager.");
                return;
            }
            try {
                if (this.val$intent != null) {
                    DaydreamApi.this.daydreamManager.registerDaydreamIntent(this.val$intent);
                } else {
                    DaydreamApi.this.daydreamManager.unregisterDaydreamIntent();
                }
            } catch (RemoteException e) {
                Log.e(DaydreamApi.TAG, "Error when attempting to register/unregister daydream intent: ", e);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.google.vr.ndk.base.DaydreamApi$9  reason: invalid class name */
    /* loaded from: classes10.dex */
    class AnonymousClass9 implements Runnable {
        final /* synthetic */ ComponentName val$componentName;
        final /* synthetic */ boolean val$shouldInhibit;

        AnonymousClass9(boolean z, ComponentName componentName) {
            this.val$shouldInhibit = z;
            this.val$componentName = componentName;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Bundle bundle = new Bundle();
                bundle.putBoolean("OPTION_INHIBIT_SYSTEM_BUTTONS", this.val$shouldInhibit);
                if (DaydreamApi.this.vrCoreSdkService.setClientOptions(this.val$componentName, bundle)) {
                    return;
                }
                Log.w(DaydreamApi.TAG, "Failed to set client options to inhibit system button.");
            } catch (RemoteException e) {
                Log.e(DaydreamApi.TAG, "RemoteException while setting client options.", e);
            }
        }
    }

    private DaydreamApi(Context context) {
        this.context = context;
    }

    private void checkIntent(Intent intent) throws ActivityNotFoundException {
        List<ResolveInfo> queryIntentActivities = this.context.getPackageManager().queryIntentActivities(intent, 0);
        if (queryIntentActivities == null || queryIntentActivities.isEmpty()) {
            String valueOf = String.valueOf(intent);
            StringBuilder sb = new StringBuilder(valueOf.length() + 43);
            sb.append("No activity is available to handle intent: ");
            sb.append(valueOf);
            throw new ActivityNotFoundException(sb.toString());
        }
    }

    private void checkNotClosed() {
        if (this.closed) {
            throw new IllegalStateException("DaydreamApi object is closed and can no longer be used.");
        }
    }

    @UsedByReflection("IAP")
    public static DaydreamApi create(Context context) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            if (!DaydreamUtils.isDaydreamPhone(context)) {
                Log.i(TAG, "Phone is not Daydream-compatible");
                return null;
            }
            DaydreamApi daydreamApi = new DaydreamApi(context);
            if (daydreamApi.init()) {
                return daydreamApi;
            }
            Log.w(TAG, "Failed to initialize DaydreamApi object.");
            return null;
        }
        throw new IllegalStateException("DaydreamApi must only be used from the main thread.");
    }

    @UsedByReflection("IAP")
    public static Intent createVrIntent(ComponentName componentName) {
        Intent intent = new Intent();
        intent.setComponent(componentName);
        return setupVrIntent(intent);
    }

    private boolean init() {
        int vrCoreClientApiVersion;
        try {
            vrCoreClientApiVersion = VrCoreUtils.getVrCoreClientApiVersion(this.context);
            this.vrCoreApiVersion = vrCoreClientApiVersion;
        } catch (VrCoreNotAvailableException e) {
            String str = TAG;
            String valueOf = String.valueOf(e);
            StringBuilder sb = new StringBuilder(valueOf.length() + 22);
            sb.append("VrCore not available: ");
            sb.append(valueOf);
            Log.e(str, sb.toString());
        }
        if (vrCoreClientApiVersion < 8) {
            String str2 = TAG;
            StringBuilder sb2 = new StringBuilder(79);
            sb2.append("VrCore out of date, current version: ");
            sb2.append(vrCoreClientApiVersion);
            sb2.append(", required version: 8");
            Log.e(str2, sb2.toString());
            return false;
        }
        Intent intent = new Intent("com.google.vr.vrcore.BIND_SDK_SERVICE");
        intent.setPackage("com.google.vr.vrcore");
        if (this.context.bindService(intent, this.connection, 1)) {
            return true;
        }
        Log.e(TAG, "Unable to bind to VrCoreSdkService");
        return false;
    }

    private void launchTransitionCallbackInVr(final ITransitionCallbacks iTransitionCallbacks) {
        runWhenServiceConnected(new Runnable() { // from class: com.google.vr.ndk.base.DaydreamApi.4
            /* JADX WARN: Removed duplicated region for block: B:10:0x0022  */
            /* JADX WARN: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void run() {
                /*
                    r3 = this;
                    com.google.vr.ndk.base.DaydreamApi r0 = com.google.vr.ndk.base.DaydreamApi.this
                    com.google.vr.vrcore.common.api.IDaydreamManager r0 = com.google.vr.ndk.base.DaydreamApi.access$100(r0)
                    if (r0 == 0) goto L1f
                    com.google.vr.ndk.base.DaydreamApi r0 = com.google.vr.ndk.base.DaydreamApi.this     // Catch: android.os.RemoteException -> L15
                    com.google.vr.vrcore.common.api.IDaydreamManager r0 = com.google.vr.ndk.base.DaydreamApi.access$100(r0)     // Catch: android.os.RemoteException -> L15
                    com.google.vr.vrcore.common.api.ITransitionCallbacks r1 = r2     // Catch: android.os.RemoteException -> L15
                    boolean r0 = r0.launchVrTransition(r1)     // Catch: android.os.RemoteException -> L15
                    goto L20
                L15:
                    r0 = move-exception
                    java.lang.String r1 = com.google.vr.ndk.base.DaydreamApi.access$200()
                    java.lang.String r2 = "RemoteException while launching VR transition: "
                    android.util.Log.e(r1, r2, r0)
                L1f:
                    r0 = 0
                L20:
                    if (r0 != 0) goto L30
                    java.lang.String r0 = com.google.vr.ndk.base.DaydreamApi.access$200()
                    java.lang.String r1 = "Can't launch callbacks via DaydreamManager, sending manually"
                    android.util.Log.w(r0, r1)
                    com.google.vr.vrcore.common.api.ITransitionCallbacks r0 = r2     // Catch: android.os.RemoteException -> L30
                    r0.onTransitionComplete()     // Catch: android.os.RemoteException -> L30
                L30:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.vr.ndk.base.DaydreamApi.AnonymousClass4.run():void");
            }
        });
    }

    private void runWhenServiceConnected(Runnable runnable) {
        if (this.vrCoreSdkService != null) {
            runnable.run();
        } else {
            this.queuedRunnables.add(runnable);
        }
    }

    @UsedByReflection("IAP")
    public static Intent setupVrIntent(Intent intent) {
        intent.addCategory("com.google.intent.category.DAYDREAM");
        intent.addFlags(335609856);
        return intent;
    }

    @Override // java.lang.AutoCloseable
    @UsedByReflection("IAP")
    public void close() {
        if (this.closed) {
            return;
        }
        this.closed = true;
        runWhenServiceConnected(new Runnable() { // from class: com.google.vr.ndk.base.DaydreamApi.12
            @Override // java.lang.Runnable
            public void run() {
                DaydreamApi.this.context.unbindService(DaydreamApi.this.connection);
                DaydreamApi.this.vrCoreSdkService = null;
            }
        });
    }

    @UsedByReflection("IAP")
    public void exitFromVr(Activity activity, int i, Intent intent) {
        checkNotClosed();
        if (intent == null) {
            intent = new Intent();
        }
        final PendingIntent createPendingResult = activity.createPendingResult(i, intent, 1073741824);
        final Runnable runnable = new Runnable(this) { // from class: com.google.vr.ndk.base.DaydreamApi.7
            @Override // java.lang.Runnable
            public void run() {
                try {
                    createPendingResult.send(0);
                } catch (Exception e) {
                    String str = DaydreamApi.TAG;
                    String valueOf = String.valueOf(e);
                    StringBuilder sb = new StringBuilder(valueOf.length() + 31);
                    sb.append("Couldn't launch PendingIntent: ");
                    sb.append(valueOf);
                    Log.e(str, sb.toString());
                }
            }
        };
        runWhenServiceConnected(new Runnable() { // from class: com.google.vr.ndk.base.DaydreamApi.8
            @Override // java.lang.Runnable
            public void run() {
                if (DaydreamApi.this.daydreamManager == null) {
                    Log.w(DaydreamApi.TAG, "Failed to exit VR: Daydream service unavailable.");
                    runnable.run();
                    return;
                }
                try {
                    if (DaydreamApi.this.daydreamManager.exitFromVr(createPendingResult)) {
                        return;
                    }
                    Log.w(DaydreamApi.TAG, "Failed to exit VR: Invalid request.");
                    runnable.run();
                } catch (RemoteException e) {
                    String str = DaydreamApi.TAG;
                    String valueOf = String.valueOf(e);
                    StringBuilder sb = new StringBuilder(valueOf.length() + 49);
                    sb.append("Failed to exit VR: RemoteException while exiting:");
                    sb.append(valueOf);
                    Log.e(str, sb.toString());
                    runnable.run();
                }
            }
        });
    }

    @UsedByReflection("IAP")
    public void launchInVr(PendingIntent pendingIntent) {
        checkNotClosed();
        launchInVr(pendingIntent, null);
    }

    @UsedByReflection("IAP")
    public void launchInVrForResult(final Activity activity, final PendingIntent pendingIntent, final int i) {
        checkNotClosed();
        launchTransitionCallbackInVr(new ITransitionCallbacks.Stub(this) { // from class: com.google.vr.ndk.base.DaydreamApi.6
            @Override // com.google.vr.vrcore.common.api.ITransitionCallbacks
            public void onTransitionComplete() {
                activity.runOnUiThread(new Runnable() { // from class: com.google.vr.ndk.base.DaydreamApi.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            AnonymousClass6 anonymousClass6 = AnonymousClass6.this;
                            activity.startIntentSenderForResult(pendingIntent.getIntentSender(), i, null, 0, 0, 0);
                        } catch (IntentSender.SendIntentException e) {
                            String str = DaydreamApi.TAG;
                            String valueOf = String.valueOf(e);
                            StringBuilder sb = new StringBuilder(valueOf.length() + 43);
                            sb.append("Exception while starting next VR activity: ");
                            sb.append(valueOf);
                            Log.e(str, sb.toString());
                        }
                    }
                });
            }
        });
    }

    @UsedByReflection("IAP")
    public void launchVrHomescreen() {
        checkNotClosed();
        runWhenServiceConnected(new Runnable() { // from class: com.google.vr.ndk.base.DaydreamApi.5
            @Override // java.lang.Runnable
            public void run() {
                if (DaydreamApi.this.daydreamManager != null) {
                    try {
                        if (DaydreamApi.this.daydreamManager.launchVrHome()) {
                            return;
                        }
                        Log.e(DaydreamApi.TAG, "There is no VR homescreen installed.");
                        return;
                    } catch (RemoteException e) {
                        String str = DaydreamApi.TAG;
                        String valueOf = String.valueOf(e);
                        StringBuilder sb = new StringBuilder(valueOf.length() + 47);
                        sb.append("RemoteException while launching VR homescreen: ");
                        sb.append(valueOf);
                        Log.e(str, sb.toString());
                        return;
                    }
                }
                Log.e(DaydreamApi.TAG, "Can't launch VR homescreen via DaydreamManager. Giving up trying to leave current VR activity...");
            }
        });
    }

    private void launchInVr(final PendingIntent pendingIntent, final ComponentName componentName) {
        runWhenServiceConnected(new Runnable() { // from class: com.google.vr.ndk.base.DaydreamApi.3
            @Override // java.lang.Runnable
            public void run() {
                if (DaydreamApi.this.daydreamManager != null) {
                    try {
                        DaydreamApi.this.daydreamManager.launchInVr(pendingIntent, componentName);
                        return;
                    } catch (RemoteException e) {
                        Log.e(DaydreamApi.TAG, "RemoteException while launching PendingIntent in VR.", e);
                        return;
                    }
                }
                Log.w(DaydreamApi.TAG, "Can't launch PendingIntent via DaydreamManager: not available.");
                try {
                    pendingIntent.send();
                } catch (Exception e2) {
                    Log.e(DaydreamApi.TAG, "Couldn't launch PendingIntent: ", e2);
                }
            }
        });
    }

    @UsedByReflection("IAP")
    public void launchInVr(Intent intent) throws ActivityNotFoundException {
        checkNotClosed();
        if (intent != null) {
            checkIntent(intent);
            launchInVr(PendingIntent.getActivity(this.context, 0, intent, 1207959552), intent.getComponent());
            return;
        }
        throw new IllegalArgumentException("Null argument 'intent' passed to launchInVr");
    }

    @UsedByReflection("IAP")
    public void launchInVr(ComponentName componentName) throws ActivityNotFoundException {
        checkNotClosed();
        if (componentName != null) {
            Intent createVrIntent = createVrIntent(componentName);
            checkIntent(createVrIntent);
            launchInVr(PendingIntent.getActivity(this.context, 0, createVrIntent, 1073741824), createVrIntent.getComponent());
            return;
        }
        throw new IllegalArgumentException("Null argument 'componentName' passed to launchInVr");
    }
}
