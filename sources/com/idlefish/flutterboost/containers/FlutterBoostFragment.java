package com.idlefish.flutterboost.containers;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.idlefish.flutterboost.FlutterBoost;
import io.flutter.Log;
import io.flutter.embedding.android.FlutterFragment;
import io.flutter.embedding.android.FlutterTextureView;
import io.flutter.embedding.android.FlutterView;
import io.flutter.embedding.android.RenderMode;
import io.flutter.embedding.android.TransparencyMode;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.platform.PlatformPlugin;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import tb.bo0;
import tb.do0;
import tb.o8;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class FlutterBoostFragment extends FlutterFragment implements FlutterViewContainer {
    private static final boolean DEBUG = false;
    private static final String TAG = "FlutterBoostFragment";
    private FlutterView flutterView;
    private PlatformPlugin platformPlugin;
    private LifecycleStage stage;
    private final String who = UUID.randomUUID().toString();
    private final C5780a textureHooker = new C5780a();
    private boolean isAttached = false;
    private boolean isFinishing = false;

    private void didFragmentHide() {
        FlutterBoost.h().g().E(this);
    }

    private void didFragmentShow() {
        FlutterViewContainer g = do0.h().g();
        if (g != null && g != this) {
            g.detachFromEngineIfNeeded();
        }
        FlutterBoost.h().g().B(this);
        performAttach();
        this.textureHooker.e();
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

    @Override // com.idlefish.flutterboost.containers.FlutterViewContainer
    public void detachFromEngineIfNeeded() {
        performDetach();
    }

    @Override // io.flutter.embedding.android.FlutterFragment, io.flutter.embedding.android.FlutterActivityAndFragmentDelegate.Host
    public void detachFromFlutterEngine() {
    }

    @Override // com.idlefish.flutterboost.containers.FlutterViewContainer
    public void finishContainer(Map<String, Object> map) {
        this.isFinishing = true;
        if (map != null) {
            Intent intent = new Intent();
            intent.putExtra("ActivityResult", new HashMap(map));
            getActivity().setResult(-1, intent);
        }
        getActivity().finish();
    }

    @Override // io.flutter.embedding.android.FlutterFragment, io.flutter.embedding.android.FlutterActivityAndFragmentDelegate.Host
    public String getCachedEngineId() {
        return FlutterBoost.ENGINE_ID;
    }

    @Override // com.idlefish.flutterboost.containers.FlutterViewContainer
    public Activity getContextActivity() {
        return getActivity();
    }

    @Override // io.flutter.embedding.android.FlutterFragment, io.flutter.embedding.android.FlutterActivityAndFragmentDelegate.Host
    public RenderMode getRenderMode() {
        return RenderMode.texture;
    }

    @Override // io.flutter.embedding.android.FlutterFragment, io.flutter.embedding.android.FlutterActivityAndFragmentDelegate.Host
    public TransparencyMode getTransparencyMode() {
        return TransparencyMode.valueOf(getArguments().getString("flutterview_transparency_mode", TransparencyMode.opaque.name()));
    }

    @Override // com.idlefish.flutterboost.containers.FlutterViewContainer
    public String getUniqueId() {
        return getArguments().getString("unique_id", this.who);
    }

    @Override // com.idlefish.flutterboost.containers.FlutterViewContainer
    public String getUrl() {
        if (getArguments().containsKey("url")) {
            return getArguments().getString("url");
        }
        throw new RuntimeException("Oops! The fragment url are *MISSED*! You should override the |getUrl|, or set url via CachedEngineFragmentBuilder.");
    }

    @Override // com.idlefish.flutterboost.containers.FlutterViewContainer
    public Map<String, Object> getUrlParams() {
        return (HashMap) getArguments().getSerializable("url_param");
    }

    @Override // com.idlefish.flutterboost.containers.FlutterViewContainer
    public boolean isOpaque() {
        return getTransparencyMode() == TransparencyMode.opaque;
    }

    @Override // com.idlefish.flutterboost.containers.FlutterViewContainer
    public boolean isPausing() {
        LifecycleStage lifecycleStage = this.stage;
        return (lifecycleStage == LifecycleStage.ON_PAUSE || lifecycleStage == LifecycleStage.ON_STOP) && !this.isFinishing;
    }

    @Override // io.flutter.embedding.android.FlutterFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override // io.flutter.embedding.android.FlutterFragment
    public void onBackPressed() {
        FlutterBoost.h().g().z();
    }

    @Override // io.flutter.embedding.android.FlutterFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.stage = LifecycleStage.ON_CREATE;
    }

    @Override // io.flutter.embedding.android.FlutterFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        FlutterBoost.h().g().C(this);
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        FlutterView c = bo0.c(onCreateView);
        this.flutterView = c;
        c.detachFromFlutterEngine();
        return onCreateView;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.stage = LifecycleStage.ON_DESTROY;
        this.textureHooker.d();
        detachFromEngineIfNeeded();
    }

    @Override // io.flutter.embedding.android.FlutterFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        FlutterBoost.h().g().D(this);
    }

    @Override // io.flutter.embedding.android.FlutterFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        FlutterEngine flutterEngine = getFlutterEngine();
        super.onDetach();
        flutterEngine.getLifecycleChannel().appIsResumed();
    }

    @Override // io.flutter.embedding.android.FlutterFragment, io.flutter.embedding.android.FlutterActivityAndFragmentDelegate.Host
    public void onFlutterTextureViewCreated(FlutterTextureView flutterTextureView) {
        super.onFlutterTextureViewCreated(flutterTextureView);
        this.textureHooker.c(flutterTextureView);
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (this.flutterView == null) {
            return;
        }
        if (z) {
            didFragmentHide();
        } else {
            didFragmentShow();
        }
    }

    @Override // io.flutter.embedding.android.FlutterFragment, androidx.fragment.app.Fragment
    public void onPause() {
        FlutterViewContainer f;
        super.onPause();
        if (Build.VERSION.SDK_INT == 29 && (f = do0.h().f()) != null && f != getContextActivity() && !f.isOpaque() && f.isPausing()) {
            Log.w(TAG, "Skip the unexpected activity lifecycle event on Android Q. See https://issuetracker.google.com/issues/185693011 for more details.");
            return;
        }
        this.stage = LifecycleStage.ON_PAUSE;
        didFragmentHide();
        getFlutterEngine().getLifecycleChannel().appIsResumed();
    }

    @Override // io.flutter.embedding.android.FlutterFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (Build.VERSION.SDK_INT == 29) {
            do0 h = do0.h();
            FlutterViewContainer f = h.f();
            if (h.i(this) && f != null && f != getContextActivity() && !f.isOpaque() && f.isPausing()) {
                Log.w(TAG, "Skip the unexpected activity lifecycle event on Android Q. See https://issuetracker.google.com/issues/185693011 for more details.");
                return;
            }
        }
        this.stage = LifecycleStage.ON_RESUME;
        if (isHidden()) {
            return;
        }
        didFragmentShow();
        getFlutterEngine().getLifecycleChannel().appIsResumed();
        o8.a(this.platformPlugin);
        this.platformPlugin.updateSystemUiOverlays();
    }

    @Override // io.flutter.embedding.android.FlutterFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // io.flutter.embedding.android.FlutterFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        this.stage = LifecycleStage.ON_STOP;
        getFlutterEngine().getLifecycleChannel().appIsResumed();
    }

    @Override // io.flutter.embedding.android.FlutterFragment
    public void onUserLeaveHint() {
        super.onUserLeaveHint();
    }

    @Override // io.flutter.embedding.android.FlutterFragment, io.flutter.embedding.android.FlutterActivityAndFragmentDelegate.Host
    public PlatformPlugin providePlatformPlugin(Activity activity, FlutterEngine flutterEngine) {
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        if (this.flutterView == null) {
            return;
        }
        if (z) {
            didFragmentShow();
        } else {
            didFragmentHide();
        }
    }

    @Override // io.flutter.embedding.android.FlutterFragment, io.flutter.embedding.android.FlutterActivityAndFragmentDelegate.Host
    public boolean shouldDestroyEngineWithHost() {
        return false;
    }

    @Override // io.flutter.embedding.android.FlutterFragment, io.flutter.embedding.android.FlutterActivityAndFragmentDelegate.Host
    public boolean shouldRestoreAndSaveState() {
        if (getArguments().containsKey("enable_state_restoration")) {
            return getArguments().getBoolean("enable_state_restoration");
        }
        return true;
    }
}
