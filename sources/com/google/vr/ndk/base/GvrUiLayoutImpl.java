package com.google.vr.ndk.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.ViewGroup;
import com.google.vr.cardboard.UiLayer;
import com.google.vr.vrcore.library.api.IGvrUiLayout;
import com.google.vr.vrcore.library.api.IObjectWrapper;
import com.google.vr.vrcore.library.api.ObjectWrapper;
import tb.co;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class GvrUiLayoutImpl extends IGvrUiLayout.Stub {
    private static final float DAYDREAM_ALIGNMENT_MARKER_SCALE = 0.35f;
    private static final String TAG = "GvrUiLayoutImpl";
    private final CloseButtonListenerWrapper closeButtonListener;
    private boolean daydreamModeEnabled;
    private final UiLayer uiLayer;

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    static class CloseButtonListenerWrapper implements Runnable {
        private Runnable activeCloseButtonListener;
        private final Context context;
        private final Runnable defaultCloseButtonListener;
        private boolean invokingCloseButton = false;
        private final Runnable passiveCloseButtonListener;

        CloseButtonListenerWrapper(Context context, Runnable runnable, DaydreamUtilsWrapper daydreamUtilsWrapper) {
            this.context = context;
            this.passiveCloseButtonListener = runnable;
            Runnable createDefaultCloseButtonListener = GvrUiLayoutImpl.createDefaultCloseButtonListener(context, daydreamUtilsWrapper);
            this.defaultCloseButtonListener = createDefaultCloseButtonListener;
            this.activeCloseButtonListener = createDefaultCloseButtonListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.invokingCloseButton) {
                Log.w(GvrUiLayoutImpl.TAG, "GVR close behavior invoked recursively.");
                Activity a = co.a(this.context);
                if (a != null) {
                    a.finish();
                    return;
                }
                return;
            }
            Log.d(GvrUiLayoutImpl.TAG, "GVR close behavior invoked.");
            this.invokingCloseButton = true;
            try {
                Runnable runnable = this.passiveCloseButtonListener;
                if (runnable != null) {
                    runnable.run();
                }
                Runnable runnable2 = this.activeCloseButtonListener;
                if (runnable2 != null) {
                    runnable2.run();
                }
            } finally {
                this.invokingCloseButton = false;
            }
        }

        public void setClientCloseButtonListener(Runnable runnable) {
            if (runnable == null) {
                runnable = this.defaultCloseButtonListener;
            }
            this.activeCloseButtonListener = runnable;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GvrUiLayoutImpl(Context context, Runnable runnable) {
        this(context, runnable, new DaydreamUtilsWrapper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Runnable createDefaultCloseButtonListener(final Context context, DaydreamUtilsWrapper daydreamUtilsWrapper) {
        final Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.HOME");
        intent.setFlags(268435456);
        final Activity a = co.a(context);
        if (a == null) {
            return new Runnable() { // from class: com.google.vr.ndk.base.GvrUiLayoutImpl.1
                @Override // java.lang.Runnable
                public void run() {
                    context.startActivity(intent);
                }
            };
        }
        if (daydreamUtilsWrapper.isDaydreamActivity(a)) {
            return new Runnable() { // from class: com.google.vr.ndk.base.GvrUiLayoutImpl.2
                @Override // java.lang.Runnable
                public void run() {
                    a.startActivity(intent);
                    a.finish();
                }
            };
        }
        return new Runnable() { // from class: com.google.vr.ndk.base.GvrUiLayoutImpl.3
            @Override // java.lang.Runnable
            public void run() {
                a.onBackPressed();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewGroup getRoot() {
        return this.uiLayer.o();
    }

    @Override // com.google.vr.vrcore.library.api.IGvrUiLayout
    public IObjectWrapper getRootView() {
        return ObjectWrapper.wrap(this.uiLayer.o());
    }

    UiLayer getUiLayer() {
        return this.uiLayer;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void invokeCloseButtonListener() {
        this.closeButtonListener.run();
    }

    boolean isDaydreamModeEnabled() {
        return this.daydreamModeEnabled;
    }

    @Override // com.google.vr.vrcore.library.api.IGvrUiLayout
    public boolean isEnabled() {
        return this.uiLayer.q();
    }

    @Override // com.google.vr.vrcore.library.api.IGvrUiLayout
    public void setCloseButtonListener(IObjectWrapper iObjectWrapper) {
        this.closeButtonListener.setClientCloseButtonListener(iObjectWrapper != null ? (Runnable) ObjectWrapper.unwrap(iObjectWrapper, Runnable.class) : null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setDaydreamModeEnabled(boolean z) {
        if (this.daydreamModeEnabled == z) {
            return;
        }
        this.daydreamModeEnabled = z;
        if (z) {
            this.uiLayer.s(DAYDREAM_ALIGNMENT_MARKER_SCALE);
            this.uiLayer.y(false);
            return;
        }
        this.uiLayer.s(1.0f);
    }

    @Override // com.google.vr.vrcore.library.api.IGvrUiLayout
    public void setEnabled(boolean z) {
        this.uiLayer.u(z);
    }

    @Override // com.google.vr.vrcore.library.api.IGvrUiLayout
    public void setSettingsButtonEnabled(boolean z) {
        this.uiLayer.w(z);
    }

    @Override // com.google.vr.vrcore.library.api.IGvrUiLayout
    public void setSettingsButtonListener(IObjectWrapper iObjectWrapper) {
        this.uiLayer.x(iObjectWrapper != null ? (Runnable) ObjectWrapper.unwrap(iObjectWrapper, Runnable.class) : null);
    }

    @Override // com.google.vr.vrcore.library.api.IGvrUiLayout
    public void setTransitionViewEnabled(boolean z) {
        this.uiLayer.y(z && !this.daydreamModeEnabled);
    }

    @Override // com.google.vr.vrcore.library.api.IGvrUiLayout
    public void setTransitionViewListener(IObjectWrapper iObjectWrapper) {
        this.uiLayer.z(iObjectWrapper != null ? (Runnable) ObjectWrapper.unwrap(iObjectWrapper, Runnable.class) : null);
    }

    @Override // com.google.vr.vrcore.library.api.IGvrUiLayout
    public void setViewerName(String str) {
        this.uiLayer.A(str);
    }

    GvrUiLayoutImpl(Context context, Runnable runnable, DaydreamUtilsWrapper daydreamUtilsWrapper) {
        this.daydreamModeEnabled = false;
        CloseButtonListenerWrapper closeButtonListenerWrapper = new CloseButtonListenerWrapper(context, runnable, daydreamUtilsWrapper);
        this.closeButtonListener = closeButtonListenerWrapper;
        UiLayer uiLayer = new UiLayer(context);
        this.uiLayer = uiLayer;
        uiLayer.t(closeButtonListenerWrapper);
    }
}
