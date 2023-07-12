package io.flutter.app;

import android.app.Application;
import androidx.annotation.CallSuper;
import io.flutter.FlutterInjector;
import io.flutter.embedding.engine.deferredcomponents.HummerDeferredComponentManager;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class HummerSplitLoadApplication extends Application {
    @Override // android.app.Application
    @CallSuper
    public void onCreate() {
        super.onCreate();
        HummerDeferredComponentManager.initForLocalTest(this);
        FlutterInjector.setInstance(new FlutterInjector.Builder().setDeferredComponentManager(new HummerDeferredComponentManager(this, null)).build());
    }
}
