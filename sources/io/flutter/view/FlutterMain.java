package io.flutter.view;

import android.content.Context;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import io.flutter.FlutterInjector;
import io.flutter.embedding.engine.loader.FlutterLoader;

/* compiled from: Taobao */
@Deprecated
/* loaded from: classes3.dex */
public class FlutterMain {

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static class Settings {
        private String logTag;

        @Nullable
        public String getLogTag() {
            return this.logTag;
        }

        public void setLogTag(String str) {
            this.logTag = str;
        }
    }

    public static void ensureInitializationComplete(@NonNull Context context, @Nullable String[] strArr) {
        FlutterInjector.instance().flutterLoader().ensureInitializationComplete(context, strArr);
    }

    public static void ensureInitializationCompleteAsync(@NonNull Context context, @Nullable String[] strArr, @NonNull Handler handler, @NonNull Runnable runnable) {
        FlutterInjector.instance().flutterLoader().ensureInitializationCompleteAsync(context, strArr, handler, runnable);
    }

    @NonNull
    public static String findAppBundlePath() {
        return FlutterInjector.instance().flutterLoader().findAppBundlePath();
    }

    @NonNull
    public static String getLookupKeyForAsset(@NonNull String str) {
        return FlutterInjector.instance().flutterLoader().getLookupKeyForAsset(str);
    }

    public static void startInitialization(@NonNull Context context) {
        FlutterInjector.instance().flutterLoader().startInitialization(context);
    }

    @Nullable
    @Deprecated
    public static String findAppBundlePath(@NonNull Context context) {
        return FlutterInjector.instance().flutterLoader().findAppBundlePath();
    }

    @NonNull
    public static String getLookupKeyForAsset(@NonNull String str, @NonNull String str2) {
        return FlutterInjector.instance().flutterLoader().getLookupKeyForAsset(str, str2);
    }

    public static void startInitialization(@NonNull Context context, @NonNull Settings settings) {
        FlutterLoader.Settings settings2 = new FlutterLoader.Settings();
        settings2.setLogTag(settings.getLogTag());
        FlutterInjector.instance().flutterLoader().startInitialization(context, settings2);
    }
}
