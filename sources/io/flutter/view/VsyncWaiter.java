package io.flutter.view;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.view.Choreographer;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import io.flutter.Log;
import io.flutter.embedding.engine.FlutterJNI;
import java.util.ArrayList;
import java.util.Iterator;
import tb.C9796v;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class VsyncWaiter {
    private static final float MAX_REFRESH_RATE_DELTA = 2.0f;
    private static VsyncWaiter instance;
    private static DisplayListener listener;
    private static float startRefreshRate;
    private FlutterJNI flutterJNI;
    private long refreshPeriodNanos = -1;
    @NonNull
    private final ArrayList<Long> cookies = new ArrayList<>(4);
    private final FlutterJNI.AsyncWaitForVsyncDelegate asyncWaitForVsyncDelegate = new FlutterJNI.AsyncWaitForVsyncDelegate() { // from class: io.flutter.view.VsyncWaiter.1
        @Override // io.flutter.embedding.engine.FlutterJNI.AsyncWaitForVsyncDelegate
        public void asyncWaitForVsync(final long j) {
            VsyncWaiter.this.cookies.add(0, Long.valueOf(j));
            if (VsyncWaiter.this.cookies.size() > 1) {
                return;
            }
            Choreographer.getInstance().postFrameCallback(new Choreographer.FrameCallback() { // from class: io.flutter.view.VsyncWaiter.1.1
                @Override // android.view.Choreographer.FrameCallback
                public void doFrame(long j2) {
                    long nanoTime = System.nanoTime() - j2;
                    if (nanoTime < 0) {
                        nanoTime = 0;
                    }
                    Iterator it = VsyncWaiter.this.cookies.iterator();
                    while (it.hasNext()) {
                        VsyncWaiter.this.flutterJNI.nativeOnVsync(nanoTime, VsyncWaiter.this.refreshPeriodNanos, ((Long) it.next()).longValue());
                    }
                    VsyncWaiter.this.cookies.clear();
                }
            });
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    @TargetApi(17)
    /* loaded from: classes3.dex */
    public class DisplayListener implements DisplayManager.DisplayListener {
        private DisplayManager displayManager;

        DisplayListener(DisplayManager displayManager) {
            this.displayManager = displayManager;
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayAdded(int i) {
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayChanged(int i) {
            if (i == 0) {
                float refreshRate = this.displayManager.getDisplay(0).getRefreshRate();
                VsyncWaiter.this.refreshPeriodNanos = (long) (1.0E9d / refreshRate);
                VsyncWaiter.this.flutterJNI.setRefreshRateFPS(refreshRate);
            }
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayRemoved(int i) {
        }

        void register() {
            this.displayManager.registerDisplayListener(this, null);
        }
    }

    private VsyncWaiter(FlutterJNI flutterJNI) {
        this.flutterJNI = flutterJNI;
    }

    @Nullable
    public static Activity activityFromContext(@Nullable Context context) {
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        return null;
    }

    @NonNull
    public static VsyncWaiter getInstance(float f, FlutterJNI flutterJNI) {
        if (instance == null) {
            instance = new VsyncWaiter(flutterJNI);
        }
        flutterJNI.setRefreshRateFPS(f);
        startRefreshRate = f;
        VsyncWaiter vsyncWaiter = instance;
        vsyncWaiter.refreshPeriodNanos = (long) (1.0E9d / f);
        return vsyncWaiter;
    }

    @SuppressLint({"NewApi"})
    @TargetApi(23)
    private int getPreferredModeId(Context context, float f) {
        Display.Mode[] supportedModes;
        if (f == 0.0f) {
            return 0;
        }
        Display.Mode mode = null;
        float f2 = Float.MAX_VALUE;
        for (Display.Mode mode2 : ((WindowManager) context.getSystemService(C9796v.ATTACH_MODE_WINDOW)).getDefaultDisplay().getSupportedModes()) {
            float abs = Math.abs(f - mode2.getRefreshRate());
            if (abs < f2) {
                mode = mode2;
                f2 = abs;
            }
        }
        if (f2 > MAX_REFRESH_RATE_DELTA) {
            Log.e("VsyncWaiter", "Refresh rate not supported : " + f);
            return 0;
        }
        return mode.getModeId();
    }

    private Window getWindow(Context context) {
        Activity activityFromContext = activityFromContext(context);
        if (activityFromContext == null) {
            return null;
        }
        return activityFromContext.getWindow();
    }

    @VisibleForTesting
    public static void reset() {
        instance = null;
        listener = null;
    }

    @SuppressLint({"NewApi"})
    public static void setPreferredRefreshRateAsStartRefreshRate(Context context) {
        VsyncWaiter vsyncWaiter;
        if (Build.VERSION.SDK_INT < 23 || (vsyncWaiter = instance) == null) {
            return;
        }
        float f = startRefreshRate;
        if (f > 88.0f) {
            vsyncWaiter.setPreferredRefreshRate(context, f);
        }
    }

    public void init() {
        this.flutterJNI.setAsyncWaitForVsyncDelegate(this.asyncWaitForVsyncDelegate);
    }

    @SuppressLint({"NewApi"})
    public void setPreferredRefreshRate(Context context, float f) {
        Window window = getWindow(context);
        if (window == null) {
            return;
        }
        int preferredModeId = getPreferredModeId(context, f);
        WindowManager.LayoutParams attributes = window.getAttributes();
        if (attributes.preferredDisplayModeId == preferredModeId) {
            return;
        }
        attributes.preferredDisplayModeId = preferredModeId;
        window.setAttributes(attributes);
        Log.w("VsyncWaiter", "VsyncWaiter.setPreferredRefreshRate, preferredRefreshRate=" + f + ", preferredModeId=" + preferredModeId);
    }

    @NonNull
    @TargetApi(17)
    public static VsyncWaiter getInstance(DisplayManager displayManager, FlutterJNI flutterJNI) {
        if (instance == null) {
            instance = new VsyncWaiter(flutterJNI);
        }
        if (listener == null) {
            VsyncWaiter vsyncWaiter = instance;
            vsyncWaiter.getClass();
            DisplayListener displayListener = new DisplayListener(displayManager);
            listener = displayListener;
            displayListener.register();
        }
        if (instance.refreshPeriodNanos == -1) {
            float refreshRate = displayManager.getDisplay(0).getRefreshRate();
            instance.refreshPeriodNanos = (long) (1.0E9d / refreshRate);
            flutterJNI.setRefreshRateFPS(refreshRate);
            startRefreshRate = refreshRate;
        }
        return instance;
    }
}
