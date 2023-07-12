package com.google.vr.ndk.base;

import android.content.Context;
import com.google.vr.internal.controller.ControllerServiceBridge;
import com.google.vr.vrcore.controller.api.ControllerButtonEvent;
import com.google.vr.vrcore.controller.api.ControllerEventPacket;
import com.google.vr.vrcore.controller.api.ControllerEventPacket2;
import com.google.vr.vrcore.controller.api.ControllerOrientationEvent;
import tb.wm2;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
class CardboardEmulator {
    private final ControllerServiceBridge controllerServiceBridge;
    private boolean resumed;

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    static class ControllerCallbacks implements ControllerServiceBridge.Callbacks {
        private final Runnable cardboardTriggerCallback;

        ControllerCallbacks(Runnable runnable) {
            this.cardboardTriggerCallback = runnable;
        }

        @Override // com.google.vr.internal.controller.ControllerServiceBridge.Callbacks
        public void onControllerEventPacket(ControllerEventPacket controllerEventPacket) {
            int i;
            for (int i2 = 0; i2 < controllerEventPacket.getButtonEventCount(); i2++) {
                ControllerButtonEvent buttonEvent = controllerEventPacket.getButtonEvent(i2);
                if (buttonEvent.down && ((i = buttonEvent.button) == 1 || i == 3)) {
                    wm2.a(this.cardboardTriggerCallback);
                }
            }
        }

        @Override // com.google.vr.internal.controller.ControllerServiceBridge.Callbacks
        public void onControllerEventPacket2(ControllerEventPacket2 controllerEventPacket2) {
            onControllerEventPacket(controllerEventPacket2);
        }

        @Override // com.google.vr.internal.controller.ControllerServiceBridge.Callbacks
        public void onControllerRecentered(ControllerOrientationEvent controllerOrientationEvent) {
        }

        @Override // com.google.vr.internal.controller.ControllerServiceBridge.Callbacks
        public void onControllerStateChanged(int i, int i2) {
        }

        @Override // com.google.vr.internal.controller.ControllerServiceBridge.Callbacks
        public void onServiceConnected(int i) {
        }

        @Override // com.google.vr.internal.controller.ControllerServiceBridge.Callbacks
        public void onServiceDisconnected() {
        }

        @Override // com.google.vr.internal.controller.ControllerServiceBridge.Callbacks
        public void onServiceFailed() {
        }

        @Override // com.google.vr.internal.controller.ControllerServiceBridge.Callbacks
        public void onServiceInitFailed(int i) {
        }

        @Override // com.google.vr.internal.controller.ControllerServiceBridge.Callbacks
        public void onServiceUnavailable() {
        }
    }

    public CardboardEmulator(Context context, Runnable runnable) {
        ControllerServiceBridge createServiceBridge = createServiceBridge(context, new ControllerCallbacks(runnable));
        this.controllerServiceBridge = createServiceBridge;
        createServiceBridge.setOrientationEnabled(false);
        createServiceBridge.setGyroEnabled(false);
        createServiceBridge.setAccelEnabled(false);
        createServiceBridge.setTouchEnabled(false);
        createServiceBridge.setGesturesEnabled(false);
    }

    protected ControllerServiceBridge createServiceBridge(Context context, ControllerServiceBridge.Callbacks callbacks) {
        return new ControllerServiceBridge(context, callbacks);
    }

    public void onPause() {
        if (this.resumed) {
            this.resumed = false;
            this.controllerServiceBridge.requestUnbind();
        }
    }

    public void onResume() {
        if (this.resumed) {
            return;
        }
        this.resumed = true;
        this.controllerServiceBridge.requestBind();
    }
}
