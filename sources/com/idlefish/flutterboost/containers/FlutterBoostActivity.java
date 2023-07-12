package com.idlefish.flutterboost.containers;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import com.idlefish.flutterboost.FlutterBoost;
import io.flutter.embedding.android.FlutterActivity;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import io.flutter.embedding.android.FlutterTextureView;
import io.flutter.embedding.android.FlutterView;
import io.flutter.embedding.android.RenderMode;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.renderer.FlutterRenderer;
import io.flutter.plugin.platform.PlatformPlugin;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import tb.bo0;
import tb.do0;
import tb.o8;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class FlutterBoostActivity extends FlutterActivity implements FlutterViewContainer {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final boolean DEBUG = false;
    private static final String TAG = "FlutterBoostActivity";
    private FlutterView flutterView;
    private PlatformPlugin platformPlugin;
    private LifecycleStage stage;
    private final String who = UUID.randomUUID().toString();
    private final C5780a textureHooker = new C5780a();
    private boolean isAttached = false;

    /* compiled from: Taobao */
    /* renamed from: com.idlefish.flutterboost.containers.FlutterBoostActivity$a */
    /* loaded from: classes10.dex */
    public static class C5779a {
        private final Class<? extends FlutterBoostActivity> a;
        private boolean b = false;
        private String c = FlutterActivityLaunchConfigs.BackgroundMode.opaque.name();
        private String d;
        private HashMap<String, Object> e;
        private String f;

        public C5779a(Class<? extends FlutterBoostActivity> cls) {
            this.a = cls;
        }

        public C5779a a(FlutterActivityLaunchConfigs.BackgroundMode backgroundMode) {
            this.c = backgroundMode.name();
            return this;
        }

        public Intent b(Context context) {
            Intent putExtra = new Intent(context, this.a).putExtra("cached_engine_id", FlutterBoost.ENGINE_ID).putExtra("destroy_engine_with_activity", this.b).putExtra("background_mode", this.c).putExtra("url", this.d).putExtra("url_param", this.e);
            String str = this.f;
            if (str == null) {
                str = bo0.b(this.d);
            }
            return putExtra.putExtra("unique_id", str);
        }

        public C5779a c(boolean z) {
            this.b = z;
            return this;
        }

        public C5779a d(String str) {
            this.f = str;
            return this;
        }

        public C5779a e(String str) {
            this.d = str;
            return this;
        }

        public C5779a f(Map<String, Object> map) {
            this.e = map instanceof HashMap ? (HashMap) map : new HashMap<>(map);
            return this;
        }
    }

    private void performAttach() {
        if (this.isAttached) {
            return;
        }
        getFlutterEngine().getActivityControlSurface().attachToActivity(getActivity(), getLifecycle());
        if (this.platformPlugin == null) {
            this.platformPlugin = new PlatformPlugin(getActivity(), getFlutterEngine().getPlatformChannel());
        }
        this.flutterView.attachToFlutterEngine(getFlutterEngine());
        this.isAttached = true;
    }

    private void performDetach() {
        if (this.isAttached) {
            getFlutterEngine().getActivityControlSurface().detachFromActivity();
            releasePlatformChannel();
            this.flutterView.detachFromFlutterEngine();
            this.isAttached = false;
        }
    }

    private void releasePlatformChannel() {
        PlatformPlugin platformPlugin = this.platformPlugin;
        if (platformPlugin != null) {
            platformPlugin.destroy();
            this.platformPlugin = null;
        }
    }

    private void setIsFlutterUiDisplayed(boolean z) {
        try {
            FlutterRenderer renderer = getFlutterEngine().getRenderer();
            Field declaredField = FlutterRenderer.class.getDeclaredField("isDisplayingFlutterUi");
            declaredField.setAccessible(true);
            declaredField.setBoolean(renderer, false);
        } catch (Exception e) {
            Log.e(TAG, "You *should* keep fields in io.flutter.embedding.engine.renderer.FlutterRenderer.");
            e.printStackTrace();
        }
    }

    @Override // com.idlefish.flutterboost.containers.FlutterViewContainer
    public void detachFromEngineIfNeeded() {
        performDetach();
    }

    @Override // io.flutter.embedding.android.FlutterActivity, io.flutter.embedding.android.FlutterActivityAndFragmentDelegate.Host
    public void detachFromFlutterEngine() {
    }

    @Override // com.idlefish.flutterboost.containers.FlutterViewContainer
    public void finishContainer(Map<String, Object> map) {
        if (map != null) {
            Intent intent = new Intent();
            intent.putExtra("ActivityResult", new HashMap(map));
            setResult(-1, intent);
        }
        finish();
    }

    @Override // io.flutter.embedding.android.FlutterActivity, io.flutter.embedding.android.FlutterActivityAndFragmentDelegate.Host
    public String getCachedEngineId() {
        return FlutterBoost.ENGINE_ID;
    }

    @Override // com.idlefish.flutterboost.containers.FlutterViewContainer
    public Activity getContextActivity() {
        return this;
    }

    @Override // io.flutter.embedding.android.FlutterActivity, io.flutter.embedding.android.FlutterActivityAndFragmentDelegate.Host
    public RenderMode getRenderMode() {
        return RenderMode.texture;
    }

    @Override // com.idlefish.flutterboost.containers.FlutterViewContainer
    public String getUniqueId() {
        if (!getIntent().hasExtra("unique_id")) {
            return this.who;
        }
        return getIntent().getStringExtra("unique_id");
    }

    @Override // com.idlefish.flutterboost.containers.FlutterViewContainer
    public String getUrl() {
        if (!getIntent().hasExtra("url")) {
            Log.e(TAG, "Oops! The activity url are *MISSED*! You should override the |getUrl|, or set url via |CachedEngineIntentBuilder.url|.");
            return null;
        }
        return getIntent().getStringExtra("url");
    }

    @Override // com.idlefish.flutterboost.containers.FlutterViewContainer
    public Map<String, Object> getUrlParams() {
        return (HashMap) getIntent().getSerializableExtra("url_param");
    }

    @Override // com.idlefish.flutterboost.containers.FlutterViewContainer
    public boolean isOpaque() {
        return getBackgroundMode() == FlutterActivityLaunchConfigs.BackgroundMode.opaque;
    }

    @Override // com.idlefish.flutterboost.containers.FlutterViewContainer
    public boolean isPausing() {
        LifecycleStage lifecycleStage = this.stage;
        return (lifecycleStage == LifecycleStage.ON_PAUSE || lifecycleStage == LifecycleStage.ON_STOP) && !isFinishing();
    }

    @Override // io.flutter.embedding.android.FlutterActivity, android.app.Activity
    public void onBackPressed() {
        FlutterBoost.h().g().z();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.flutter.embedding.android.FlutterActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.stage = LifecycleStage.ON_CREATE;
        FlutterView c = bo0.c(getWindow().getDecorView());
        this.flutterView = c;
        c.detachFromFlutterEngine();
        FlutterBoost.h().g().C(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.flutter.embedding.android.FlutterActivity, android.app.Activity
    public void onDestroy() {
        this.stage = LifecycleStage.ON_DESTROY;
        detachFromEngineIfNeeded();
        this.textureHooker.d();
        FlutterEngine flutterEngine = getFlutterEngine();
        super.onDestroy();
        flutterEngine.getLifecycleChannel().appIsResumed();
        FlutterBoost.h().g().D(this);
    }

    @Override // io.flutter.embedding.android.FlutterActivity, io.flutter.embedding.android.FlutterActivityAndFragmentDelegate.Host
    public void onFlutterTextureViewCreated(FlutterTextureView flutterTextureView) {
        super.onFlutterTextureViewCreated(flutterTextureView);
        this.textureHooker.c(flutterTextureView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.flutter.embedding.android.FlutterActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        FlutterViewContainer f = do0.h().f();
        if (Build.VERSION.SDK_INT == 29 && f != null && f != this && !f.isOpaque() && f.isPausing()) {
            Log.w(TAG, "Skip the unexpected activity lifecycle event on Android Q. See https://issuetracker.google.com/issues/185693011 for more details.");
            return;
        }
        this.stage = LifecycleStage.ON_PAUSE;
        FlutterBoost.h().g().E(this);
        getFlutterEngine().getLifecycleChannel().appIsResumed();
        setIsFlutterUiDisplayed(false);
    }

    @Override // io.flutter.embedding.android.FlutterActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        do0 h = do0.h();
        if (Build.VERSION.SDK_INT == 29) {
            FlutterViewContainer f = h.f();
            if (h.i(this) && f != null && f != this && !f.isOpaque() && f.isPausing()) {
                Log.w(TAG, "Skip the unexpected activity lifecycle event on Android Q. See https://issuetracker.google.com/issues/185693011 for more details.");
                return;
            }
        }
        this.stage = LifecycleStage.ON_RESUME;
        FlutterViewContainer g = h.g();
        if (g != null && g != this) {
            g.detachFromEngineIfNeeded();
        }
        performAttach();
        this.textureHooker.e();
        FlutterBoost.h().g().B(this);
        getFlutterEngine().getLifecycleChannel().appIsResumed();
        o8.a(this.platformPlugin);
        this.platformPlugin.updateSystemUiOverlays();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.flutter.embedding.android.FlutterActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.stage = LifecycleStage.ON_START;
    }

    @Override // io.flutter.embedding.android.FlutterActivity, android.app.Activity
    protected void onStop() {
        super.onStop();
        this.stage = LifecycleStage.ON_STOP;
        getFlutterEngine().getLifecycleChannel().appIsResumed();
    }

    @Override // io.flutter.embedding.android.FlutterActivity, android.app.Activity
    public void onUserLeaveHint() {
        super.onUserLeaveHint();
    }

    @Override // io.flutter.embedding.android.FlutterActivity, io.flutter.embedding.android.FlutterActivityAndFragmentDelegate.Host
    public PlatformPlugin providePlatformPlugin(Activity activity, FlutterEngine flutterEngine) {
        return null;
    }

    @Override // io.flutter.embedding.android.FlutterActivity, io.flutter.embedding.android.FlutterActivityAndFragmentDelegate.Host
    public boolean shouldAttachEngineToActivity() {
        return false;
    }

    @Override // io.flutter.embedding.android.FlutterActivity, io.flutter.embedding.android.FlutterActivityAndFragmentDelegate.Host
    public boolean shouldDestroyEngineWithHost() {
        return false;
    }

    @Override // io.flutter.embedding.android.FlutterActivity, io.flutter.embedding.android.FlutterActivityAndFragmentDelegate.Host
    public boolean shouldRestoreAndSaveState() {
        if (getIntent().hasExtra("enable_state_restoration")) {
            return getIntent().getBooleanExtra("enable_state_restoration", false);
        }
        return true;
    }
}
