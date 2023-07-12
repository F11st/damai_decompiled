package io.flutter.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.PluginRegistry;
import io.flutter.plugin.platform.PlatformViewRegistry;
import io.flutter.plugin.platform.PlatformViewsController;
import io.flutter.view.FlutterMain;
import io.flutter.view.FlutterNativeView;
import io.flutter.view.FlutterView;
import io.flutter.view.TextureRegistry;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
@Deprecated
/* loaded from: classes3.dex */
public class FlutterPluginRegistry implements PluginRegistry.ActivityResultListener, PluginRegistry.NewIntentListener, PluginRegistry.RequestPermissionsResultListener, PluginRegistry.UserLeaveHintListener, PluginRegistry.ViewDestroyListener, PluginRegistry {
    private static final String TAG = "FlutterPluginRegistry";
    private Activity mActivity;
    private Context mAppContext;
    private FlutterView mFlutterView;
    private FlutterNativeView mNativeView;
    private final Map<String, Object> mPluginMap = new LinkedHashMap(0);
    private final List<PluginRegistry.RequestPermissionsResultListener> mRequestPermissionsResultListeners = new ArrayList(0);
    private final List<PluginRegistry.ActivityResultListener> mActivityResultListeners = new ArrayList(0);
    private final List<PluginRegistry.NewIntentListener> mNewIntentListeners = new ArrayList(0);
    private final List<PluginRegistry.UserLeaveHintListener> mUserLeaveHintListeners = new ArrayList(0);
    private final List<PluginRegistry.ViewDestroyListener> mViewDestroyListeners = new ArrayList(0);
    private final PlatformViewsController mPlatformViewsController = new PlatformViewsController();

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    private class FlutterRegistrar implements PluginRegistry.Registrar {
        private final String pluginKey;

        FlutterRegistrar(String str) {
            this.pluginKey = str;
        }

        @Override // io.flutter.plugin.common.PluginRegistry.Registrar
        public Context activeContext() {
            return FlutterPluginRegistry.this.mActivity != null ? FlutterPluginRegistry.this.mActivity : FlutterPluginRegistry.this.mAppContext;
        }

        @Override // io.flutter.plugin.common.PluginRegistry.Registrar
        public Activity activity() {
            return FlutterPluginRegistry.this.mActivity;
        }

        @Override // io.flutter.plugin.common.PluginRegistry.Registrar
        public PluginRegistry.Registrar addActivityResultListener(PluginRegistry.ActivityResultListener activityResultListener) {
            FlutterPluginRegistry.this.mActivityResultListeners.add(activityResultListener);
            return this;
        }

        @Override // io.flutter.plugin.common.PluginRegistry.Registrar
        public PluginRegistry.Registrar addNewIntentListener(PluginRegistry.NewIntentListener newIntentListener) {
            FlutterPluginRegistry.this.mNewIntentListeners.add(newIntentListener);
            return this;
        }

        @Override // io.flutter.plugin.common.PluginRegistry.Registrar
        public PluginRegistry.Registrar addRequestPermissionsResultListener(PluginRegistry.RequestPermissionsResultListener requestPermissionsResultListener) {
            FlutterPluginRegistry.this.mRequestPermissionsResultListeners.add(requestPermissionsResultListener);
            return this;
        }

        @Override // io.flutter.plugin.common.PluginRegistry.Registrar
        public PluginRegistry.Registrar addUserLeaveHintListener(PluginRegistry.UserLeaveHintListener userLeaveHintListener) {
            FlutterPluginRegistry.this.mUserLeaveHintListeners.add(userLeaveHintListener);
            return this;
        }

        @Override // io.flutter.plugin.common.PluginRegistry.Registrar
        public PluginRegistry.Registrar addViewDestroyListener(PluginRegistry.ViewDestroyListener viewDestroyListener) {
            FlutterPluginRegistry.this.mViewDestroyListeners.add(viewDestroyListener);
            return this;
        }

        @Override // io.flutter.plugin.common.PluginRegistry.Registrar
        public Context context() {
            return FlutterPluginRegistry.this.mAppContext;
        }

        @Override // io.flutter.plugin.common.PluginRegistry.Registrar
        public String lookupKeyForAsset(String str) {
            return FlutterMain.getLookupKeyForAsset(str);
        }

        @Override // io.flutter.plugin.common.PluginRegistry.Registrar
        public BinaryMessenger messenger() {
            return FlutterPluginRegistry.this.mNativeView;
        }

        @Override // io.flutter.plugin.common.PluginRegistry.Registrar
        public PlatformViewRegistry platformViewRegistry() {
            return FlutterPluginRegistry.this.mPlatformViewsController.getRegistry();
        }

        @Override // io.flutter.plugin.common.PluginRegistry.Registrar
        public PluginRegistry.Registrar publish(Object obj) {
            FlutterPluginRegistry.this.mPluginMap.put(this.pluginKey, obj);
            return this;
        }

        @Override // io.flutter.plugin.common.PluginRegistry.Registrar
        public TextureRegistry textures() {
            return FlutterPluginRegistry.this.mFlutterView;
        }

        @Override // io.flutter.plugin.common.PluginRegistry.Registrar
        public FlutterView view() {
            return FlutterPluginRegistry.this.mFlutterView;
        }

        @Override // io.flutter.plugin.common.PluginRegistry.Registrar
        public String lookupKeyForAsset(String str, String str2) {
            return FlutterMain.getLookupKeyForAsset(str, str2);
        }
    }

    public FlutterPluginRegistry(FlutterNativeView flutterNativeView, Context context) {
        this.mNativeView = flutterNativeView;
        this.mAppContext = context;
    }

    public void attach(FlutterView flutterView, Activity activity) {
        this.mFlutterView = flutterView;
        this.mActivity = activity;
        this.mPlatformViewsController.attach(activity, flutterView, flutterView.getDartExecutor());
    }

    public void destroy() {
        this.mPlatformViewsController.onDetachedFromJNI();
    }

    public void detach() {
        this.mPlatformViewsController.detach();
        this.mPlatformViewsController.onDetachedFromJNI();
        this.mFlutterView = null;
        this.mActivity = null;
    }

    public PlatformViewsController getPlatformViewsController() {
        return this.mPlatformViewsController;
    }

    @Override // io.flutter.plugin.common.PluginRegistry
    public boolean hasPlugin(String str) {
        return this.mPluginMap.containsKey(str);
    }

    @Override // io.flutter.plugin.common.PluginRegistry.ActivityResultListener
    public boolean onActivityResult(int i, int i2, Intent intent) {
        for (PluginRegistry.ActivityResultListener activityResultListener : this.mActivityResultListeners) {
            if (activityResultListener.onActivityResult(i, i2, intent)) {
                return true;
            }
        }
        return false;
    }

    @Override // io.flutter.plugin.common.PluginRegistry.NewIntentListener
    public boolean onNewIntent(Intent intent) {
        for (PluginRegistry.NewIntentListener newIntentListener : this.mNewIntentListeners) {
            if (newIntentListener.onNewIntent(intent)) {
                return true;
            }
        }
        return false;
    }

    public void onPreEngineRestart() {
        this.mPlatformViewsController.onPreEngineRestart();
    }

    @Override // io.flutter.plugin.common.PluginRegistry.RequestPermissionsResultListener
    public boolean onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        for (PluginRegistry.RequestPermissionsResultListener requestPermissionsResultListener : this.mRequestPermissionsResultListeners) {
            if (requestPermissionsResultListener.onRequestPermissionsResult(i, strArr, iArr)) {
                return true;
            }
        }
        return false;
    }

    @Override // io.flutter.plugin.common.PluginRegistry.UserLeaveHintListener
    public void onUserLeaveHint() {
        for (PluginRegistry.UserLeaveHintListener userLeaveHintListener : this.mUserLeaveHintListeners) {
            userLeaveHintListener.onUserLeaveHint();
        }
    }

    @Override // io.flutter.plugin.common.PluginRegistry.ViewDestroyListener
    public boolean onViewDestroy(FlutterNativeView flutterNativeView) {
        boolean z = false;
        for (PluginRegistry.ViewDestroyListener viewDestroyListener : this.mViewDestroyListeners) {
            if (viewDestroyListener.onViewDestroy(flutterNativeView)) {
                z = true;
            }
        }
        return z;
    }

    @Override // io.flutter.plugin.common.PluginRegistry
    public PluginRegistry.Registrar registrarFor(String str) {
        if (!this.mPluginMap.containsKey(str)) {
            this.mPluginMap.put(str, null);
            return new FlutterRegistrar(str);
        }
        throw new IllegalStateException("Plugin key " + str + " is already in use");
    }

    @Override // io.flutter.plugin.common.PluginRegistry
    public <T> T valuePublishedByPlugin(String str) {
        return (T) this.mPluginMap.get(str);
    }

    public FlutterPluginRegistry(FlutterEngine flutterEngine, Context context) {
        this.mAppContext = context;
    }
}
