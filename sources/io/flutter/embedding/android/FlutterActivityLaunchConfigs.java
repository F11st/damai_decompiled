package io.flutter.embedding.android;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class FlutterActivityLaunchConfigs {
    static final String DART_ENTRYPOINT_META_DATA_KEY = "io.flutter.Entrypoint";
    static final String DEFAULT_BACKGROUND_MODE = BackgroundMode.opaque.name();
    static final String DEFAULT_DART_ENTRYPOINT = "main";
    static final String DEFAULT_INITIAL_ROUTE = "/";
    static final String EXTRA_BACKGROUND_MODE = "background_mode";
    static final String EXTRA_CACHED_ENGINE_ID = "cached_engine_id";
    static final String EXTRA_DESTROY_ENGINE_WITH_ACTIVITY = "destroy_engine_with_activity";
    static final String EXTRA_ENABLE_STATE_RESTORATION = "enable_state_restoration";
    static final String EXTRA_INITIAL_ROUTE = "route";
    static final String HANDLE_DEEPLINKING_META_DATA_KEY = "flutter_deeplinking_enabled";
    static final String INITIAL_ROUTE_META_DATA_KEY = "io.flutter.InitialRoute";
    static final String NORMAL_THEME_META_DATA_KEY = "io.flutter.embedding.android.NormalTheme";
    static final String SPLASH_SCREEN_META_DATA_KEY = "io.flutter.embedding.android.SplashScreenDrawable";

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public enum BackgroundMode {
        opaque,
        transparent
    }

    private FlutterActivityLaunchConfigs() {
    }
}
