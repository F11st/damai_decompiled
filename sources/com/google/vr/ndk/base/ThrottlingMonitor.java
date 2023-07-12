package com.google.vr.ndk.base;

import android.os.Handler;
import com.google.vr.vrcore.performance.api.IThrottlingTriggerCallback;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class ThrottlingMonitor implements AutoCloseable {
    public static final int ERROR_NOT_ACCURATE = -4;
    public static final int ERROR_NOT_CONNECTED = -3;
    public static final int ERROR_NOT_SUPPORTED = -1;
    public static final int ERROR_NO_PERMISSION = -2;
    public static final int ERROR_UNKNOWN = -5;
    public static final int SUCCESS = 0;

    /* compiled from: Taobao */
    /* renamed from: com.google.vr.ndk.base.ThrottlingMonitor$2  reason: invalid class name */
    /* loaded from: classes10.dex */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ SetupCallback val$callback;

        AnonymousClass2(ThrottlingMonitor throttlingMonitor, SetupCallback setupCallback) {
            this.val$callback = setupCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.val$callback.onInitialized();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public interface SetupCallback {
        void onInitialized();
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public interface TemperatureTrigger {
        void onTemperatureEvent(float f, long j);
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    static class ThrottlingTriggerCallback extends IThrottlingTriggerCallback.Stub {
        private final Handler handler;
        private final TemperatureTrigger trigger;

        public ThrottlingTriggerCallback(TemperatureTrigger temperatureTrigger, Handler handler) {
            this.trigger = temperatureTrigger;
            this.handler = handler;
        }

        @Override // com.google.vr.vrcore.performance.api.IThrottlingTriggerCallback
        public void onTriggerActivated(final float f, final long j) {
            Handler handler = this.handler;
            if (handler == null) {
                this.trigger.onTemperatureEvent(f, j);
            } else {
                handler.post(new Runnable() { // from class: com.google.vr.ndk.base.ThrottlingMonitor.ThrottlingTriggerCallback.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ThrottlingTriggerCallback.this.trigger.onTemperatureEvent(f, j);
                    }
                });
            }
        }
    }
}
