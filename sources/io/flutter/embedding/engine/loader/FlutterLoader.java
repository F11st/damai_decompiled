package io.flutter.embedding.engine.loader;

import android.app.ActivityManager;
import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.support.v4.media.session.PlaybackStateCompat;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.taobao.accs.common.Constants;
import io.flutter.FlutterInjector;
import io.flutter.Log;
import io.flutter.UCBuildFlags;
import io.flutter.embedding.android.FlutterFPS;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.util.CrashSDK;
import io.flutter.util.PathUtils;
import io.flutter.util.SourceLocation;
import io.flutter.util.Trace;
import io.flutter.view.VsyncWaiter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.apache.commons.lang3.StringUtils;
import tb.v;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class FlutterLoader {
    static final String AOT_SHARED_LIBRARY_NAME = "aot-shared-library-name";
    static final String AUTOMATICALLY_REGISTER_PLUGINS_KEY = "automatically-register-plugins";
    private static final String DEFAULT_KERNEL_BLOB = "kernel_blob.bin";
    private static final String DEFAULT_LIBRARY = "libflutter.so";
    private static final String ENABLE_SKPARAGRAPH_META_DATA_KEY = "io.flutter.embedding.android.EnableSkParagraph";
    static final String FLUTTER_ASSETS_DIR_KEY = "flutter-assets-dir";
    static final String ISOLATE_SNAPSHOT_DATA_KEY = "isolate-snapshot-data";
    private static final String OLD_GEN_HEAP_SIZE_META_DATA_KEY = "io.flutter.embedding.android.OldGenHeapSize";
    static final String SNAPSHOT_ASSET_PATH_KEY = "snapshot-asset-path";
    private static final String TAG = "FlutterLoader";
    static final String VM_SNAPSHOT_DATA_KEY = "vm-snapshot-data";
    private static FlutterLoader instance;
    private static volatile boolean sHasInitGWPASan;
    private FlutterApplicationInfo flutterApplicationInfo;
    private FlutterJNI flutterJNI;
    @Nullable
    Future<InitResult> initResultFuture;
    private long initStartTimestampMillis;
    private boolean initialized;
    @Nullable
    private Settings settings;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static class InitResult {
        final String appStoragePath;
        final String dataDirPath;
        final String engineCachesPath;

        private InitResult(String str, String str2, String str3) {
            this.appStoragePath = str;
            this.engineCachesPath = str2;
            this.dataDirPath = str3;
        }
    }

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

    public FlutterLoader() {
        this(FlutterInjector.instance().getFlutterJNIFactory().provideFlutterJNI());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doUploadGWPASanLogIfNeeded(String str) {
        String[] list;
        File file = new File(str);
        if (file.exists() && (list = file.list()) != null) {
            for (String str2 : list) {
                File file2 = new File(file, str2);
                StringBuffer stringBuffer = new StringBuffer();
                try {
                    FileReader fileReader = new FileReader(file2);
                    BufferedReader bufferedReader = new BufferedReader(fileReader);
                    boolean z = false;
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        stringBuffer.append(readLine);
                        stringBuffer.append(StringUtils.LF);
                        z = true;
                    }
                    if (z) {
                        Log.e("gwp_asan", "find gwp_asan log file: " + str2);
                        Bundle bundle = new Bundle();
                        bundle.putBoolean("mAddHeader", true);
                        bundle.putBoolean("mAddFooter", true);
                        bundle.putBoolean("mUploadNow", true);
                        bundle.putBoolean("mAddBuildId", true);
                        CrashSDK.generateCustomLog(stringBuffer, "exception", bundle);
                        Log.e("gwp_asan", "succeed upload log file: " + str2);
                    }
                    fileReader.close();
                    bufferedReader.close();
                    file2.delete();
                } catch (IOException unused) {
                }
            }
        }
    }

    @NonNull
    private String fullAssetPathFrom(@NonNull String str) {
        return this.flutterApplicationInfo.flutterAssetsDir + File.separator + str;
    }

    @NonNull
    @Deprecated
    public static FlutterLoader getInstance() {
        if (instance == null) {
            instance = new FlutterLoader();
        }
        return instance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ResourceExtractor initResources(@NonNull Context context) {
        return null;
    }

    public static void registerWarmUpDartVMCallback(@NonNull Handler handler, @NonNull Runnable runnable) {
        FlutterJNI.registerWarmUpDartVMCallback(handler, runnable);
    }

    private void uploadGWPASanLogIfNeeded(final String str) {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: io.flutter.embedding.engine.loader.FlutterLoader.2
            @Override // java.lang.Runnable
            public void run() {
                Thread thread = new Thread(null, new Runnable() { // from class: io.flutter.embedding.engine.loader.FlutterLoader.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                        FlutterLoader.this.doUploadGWPASanLogIfNeeded(str);
                    }
                }, "UploadGWPASanLog", PlaybackStateCompat.ACTION_SET_REPEAT_MODE);
                thread.setDaemon(true);
                thread.start();
            }
        }, 10000L);
    }

    @NonNull
    public boolean automaticallyRegisterPlugins() {
        return this.flutterApplicationInfo.automaticallyRegisterPlugins;
    }

    public void ensureInitializationComplete(@NonNull Context context, @Nullable String[] strArr) {
        ActivityManager.MemoryInfo memoryInfo;
        if (this.initialized) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            if (this.settings != null) {
                try {
                    Trace.beginSection(SourceLocation.clazz(this) + "." + SourceLocation.method());
                    InitResult initResult = this.initResultFuture.get();
                    ArrayList arrayList = new ArrayList();
                    arrayList.add("--icu-symbol-prefix=_binary_icudtl_dat");
                    StringBuilder sb = new StringBuilder();
                    sb.append("--icu-native-lib-path=");
                    sb.append(this.flutterApplicationInfo.nativeLibraryDir);
                    String str = File.separator;
                    sb.append(str);
                    sb.append(DEFAULT_LIBRARY);
                    arrayList.add(sb.toString());
                    if (strArr != null) {
                        Collections.addAll(arrayList, strArr);
                    }
                    arrayList.add("--aot-shared-library-name=" + this.flutterApplicationInfo.aotSharedLibraryName);
                    arrayList.add("--aot-shared-library-name=" + this.flutterApplicationInfo.nativeLibraryDir + str + this.flutterApplicationInfo.aotSharedLibraryName);
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("--cache-dir-path=");
                    sb2.append(initResult.engineCachesPath);
                    arrayList.add(sb2.toString());
                    if (this.flutterApplicationInfo.domainNetworkPolicy != null) {
                        arrayList.add("--domain-network-policy=" + this.flutterApplicationInfo.domainNetworkPolicy);
                    }
                    if (this.settings.getLogTag() != null) {
                        arrayList.add("--log-tag=" + this.settings.getLogTag());
                    }
                    if (!sHasInitGWPASan) {
                        sHasInitGWPASan = true;
                        String str2 = context.getCacheDir().getAbsolutePath() + str + "flutter_gwp_asan";
                        arrayList.add("--gwp-asan-log-dir=" + str2);
                        uploadGWPASanLogIfNeeded(str2);
                    }
                    Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
                    int i = bundle != null ? bundle.getInt(OLD_GEN_HEAP_SIZE_META_DATA_KEY) : 0;
                    if (i == 0) {
                        ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(new ActivityManager.MemoryInfo());
                        i = (int) ((memoryInfo.totalMem / 1000000.0d) / 2.0d);
                    }
                    arrayList.add("--old-gen-heap-size=" + i);
                    if (bundle != null && bundle.getBoolean(ENABLE_SKPARAGRAPH_META_DATA_KEY)) {
                        arrayList.add("--enable-skparagraph");
                    }
                    if (Build.getBRAND().indexOf("vivo", 0) != -1 && arrayList.indexOf("disable-custom-font") == -1) {
                        arrayList.add("--disable-custom-font");
                    }
                    this.flutterJNI.init(context, context.getPackageName(), (String[]) arrayList.toArray(new String[0]), null, initResult.appStoragePath, initResult.engineCachesPath, SystemClock.uptimeMillis() - this.initStartTimestampMillis);
                    this.initialized = true;
                    Trace.endSection();
                    return;
                } catch (Exception e) {
                    Log.e(TAG, "Flutter initialization failed.", e);
                    throw new RuntimeException(e);
                }
            }
            throw new IllegalStateException("ensureInitializationComplete must be called after startInitialization");
        }
        throw new IllegalStateException("ensureInitializationComplete must be called on the main thread");
    }

    public void ensureInitializationCompleteAsync(@NonNull final Context context, @Nullable final String[] strArr, @NonNull final Handler handler, @NonNull final Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            if (this.settings != null) {
                if (this.initialized) {
                    handler.post(runnable);
                    return;
                } else {
                    Executors.newSingleThreadExecutor().execute(new Runnable() { // from class: io.flutter.embedding.engine.loader.FlutterLoader.3
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                FlutterLoader.this.initResultFuture.get();
                                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: io.flutter.embedding.engine.loader.FlutterLoader.3.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                                        FlutterLoader.this.ensureInitializationComplete(context.getApplicationContext(), strArr);
                                        AnonymousClass3 anonymousClass32 = AnonymousClass3.this;
                                        handler.post(runnable);
                                    }
                                });
                            } catch (Exception e) {
                                Log.e(FlutterLoader.TAG, "Flutter initialization failed.", e);
                                throw new RuntimeException(e);
                            }
                        }
                    });
                    return;
                }
            }
            throw new IllegalStateException("ensureInitializationComplete must be called after startInitialization");
        }
        throw new IllegalStateException("ensureInitializationComplete must be called on the main thread");
    }

    @NonNull
    public String findAppBundlePath() {
        return this.flutterApplicationInfo.flutterAssetsDir;
    }

    @NonNull
    public String getLookupKeyForAsset(@NonNull String str) {
        return fullAssetPathFrom(str);
    }

    public boolean initialized() {
        return this.initialized;
    }

    public void startInitialization(@NonNull Context context) {
        startInitialization(context, new Settings());
    }

    public FlutterLoader(@NonNull FlutterJNI flutterJNI) {
        this.initialized = false;
        this.flutterJNI = flutterJNI;
    }

    @NonNull
    public String getLookupKeyForAsset(@NonNull String str, @NonNull String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(Constants.KEY_PACKAGES);
        String str3 = File.separator;
        sb.append(str3);
        sb.append(str2);
        sb.append(str3);
        sb.append(str);
        return getLookupKeyForAsset(sb.toString());
    }

    public void startInitialization(@NonNull final Context context, @NonNull Settings settings) {
        VsyncWaiter vsyncWaiter;
        if (this.settings != null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            Trace.beginSection(SourceLocation.clazz(this) + "." + SourceLocation.method());
            FlutterFPS.enableDebugIfNeeded();
            FlutterFPS.setEngineVersion(UCBuildFlags.UC_ENGINE_VERSION, UCBuildFlags.FLUTTER_ENGINE_VERSION);
            final Context applicationContext = context.getApplicationContext();
            this.settings = settings;
            this.initStartTimestampMillis = SystemClock.uptimeMillis();
            this.flutterApplicationInfo = ApplicationInfoLoader.load(applicationContext);
            if (Build.VERSION.SDK_INT >= 17) {
                vsyncWaiter = VsyncWaiter.getInstance((DisplayManager) applicationContext.getSystemService("display"), this.flutterJNI);
            } else {
                vsyncWaiter = VsyncWaiter.getInstance(((WindowManager) applicationContext.getSystemService(v.ATTACH_MODE_WINDOW)).getDefaultDisplay().getRefreshRate(), this.flutterJNI);
            }
            vsyncWaiter.init();
            this.initResultFuture = Executors.newSingleThreadExecutor().submit(new Callable<InitResult>() { // from class: io.flutter.embedding.engine.loader.FlutterLoader.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public InitResult call() {
                    ResourceExtractor initResources = FlutterLoader.this.initResources(applicationContext);
                    FlutterLoader.this.flutterJNI.loadLibrary();
                    Executors.newSingleThreadExecutor().execute(new Runnable() { // from class: io.flutter.embedding.engine.loader.FlutterLoader.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            FlutterLoader.this.flutterJNI.prefetchDefaultFontManager();
                        }
                    });
                    if (initResources != null) {
                        initResources.waitForCompletion();
                    }
                    return new InitResult(PathUtils.getFilesDir(applicationContext), PathUtils.getCacheDirectory(applicationContext), PathUtils.getDataDirectory(applicationContext));
                }
            });
            Trace.endSection();
            return;
        }
        throw new IllegalStateException("startInitialization must be called on the main thread");
    }
}
