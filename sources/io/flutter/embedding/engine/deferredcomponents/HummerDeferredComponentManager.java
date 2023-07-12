package io.flutter.embedding.engine.deferredcomponents;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.taobao.weex.annotation.JSMethod;
import io.flutter.Log;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.embedding.engine.loader.ApplicationInfoLoader;
import io.flutter.embedding.engine.loader.FlutterApplicationInfo;
import io.flutter.embedding.engine.systemchannels.DeferredComponentChannel;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class HummerDeferredComponentManager implements DeferredComponentManager {
    public static final String LOCAL_FILES_MAPPING_KEY = "io.flutter.embedding.engine.deferredcomponents.DeferredComponentManager.loadingFromLocalFiles";
    private static final String TAG = "flutter";
    public static final String default_packed_zip = "splitted_so.zip";
    public static final String default_split_load_dir = "split_load";
    private static String split_load_dir;
    private static SplitLoadProvider split_load_provider;
    @Nullable
    private DeferredComponentChannel channel;
    @NonNull
    private Context context;
    @NonNull
    private FlutterApplicationInfo flutterApplicationInfo;
    private List<FlutterJNI> flutterJNIList = new LinkedList();

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public interface SplitLoadProvider {
        void loadDartLibrary(int i, String str, DeferredComponentManager deferredComponentManager);
    }

    public HummerDeferredComponentManager(@NonNull Context context, @Nullable FlutterJNI flutterJNI) {
        this.context = context;
        this.flutterApplicationInfo = ApplicationInfoLoader.load(context);
    }

    @NonNull
    private ApplicationInfo getApplicationInfo() {
        try {
            return this.context.getPackageManager().getApplicationInfo(this.context.getPackageName(), 128);
        } catch (PackageManager.NameNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @NonNull
    private static ApplicationInfo getApplicationInfoFromContext(Context context) {
        try {
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
        } catch (PackageManager.NameNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void initForLocalTest(@NonNull Context context) {
        Bundle bundle;
        ApplicationInfo applicationInfoFromContext = getApplicationInfoFromContext(context);
        if (applicationInfoFromContext == null || (bundle = applicationInfoFromContext.metaData) == null || !bundle.getBoolean(LOCAL_FILES_MAPPING_KEY, false)) {
            return;
        }
        File file = new File(context.getExternalFilesDir(default_split_load_dir).getAbsolutePath(), default_packed_zip);
        File file2 = new File(context.getFilesDir().getAbsolutePath(), default_split_load_dir);
        if (split_load_dir == null) {
            split_load_dir = file2.getAbsolutePath();
        }
        try {
            if (file.exists() && file.isFile()) {
                unzip(file, file2);
            }
            if (!file.exists() || !file.isFile()) {
                return;
            }
        } catch (Exception unused) {
            if (!file.exists() || !file.isFile()) {
                return;
            }
        } catch (Throwable th) {
            if (file.exists() && file.isFile()) {
                file.delete();
            }
            throw th;
        }
        file.delete();
    }

    public static void setSplitLoadDir(String str) {
        split_load_dir = str;
    }

    public static void setSplitLoadProvider(SplitLoadProvider splitLoadProvider) {
        split_load_provider = splitLoadProvider;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0055, code lost:
        throw new java.io.FileNotFoundException("Failed to ensure directory: " + r3.getAbsolutePath());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void unzip(java.io.File r5, java.io.File r6) throws java.io.IOException {
        /*
            java.util.zip.ZipInputStream r0 = new java.util.zip.ZipInputStream
            java.io.BufferedInputStream r1 = new java.io.BufferedInputStream
            java.io.FileInputStream r2 = new java.io.FileInputStream
            r2.<init>(r5)
            r1.<init>(r2)
            r0.<init>(r1)
            r5 = 8192(0x2000, float:1.148E-41)
            byte[] r5 = new byte[r5]     // Catch: java.lang.Throwable -> L7b
        L13:
            java.util.zip.ZipEntry r1 = r0.getNextEntry()     // Catch: java.lang.Throwable -> L7b
            if (r1 == 0) goto L77
            java.io.File r2 = new java.io.File     // Catch: java.lang.Throwable -> L7b
            java.lang.String r3 = r1.getName()     // Catch: java.lang.Throwable -> L7b
            r2.<init>(r6, r3)     // Catch: java.lang.Throwable -> L7b
            boolean r3 = r1.isDirectory()     // Catch: java.lang.Throwable -> L7b
            if (r3 == 0) goto L2a
            r3 = r2
            goto L2e
        L2a:
            java.io.File r3 = r2.getParentFile()     // Catch: java.lang.Throwable -> L7b
        L2e:
            boolean r4 = r3.isDirectory()     // Catch: java.lang.Throwable -> L7b
            if (r4 != 0) goto L56
            boolean r4 = r3.mkdirs()     // Catch: java.lang.Throwable -> L7b
            if (r4 == 0) goto L3b
            goto L56
        L3b:
            java.io.FileNotFoundException r5 = new java.io.FileNotFoundException     // Catch: java.lang.Throwable -> L7b
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L7b
            r6.<init>()     // Catch: java.lang.Throwable -> L7b
            java.lang.String r1 = "Failed to ensure directory: "
            r6.append(r1)     // Catch: java.lang.Throwable -> L7b
            java.lang.String r1 = r3.getAbsolutePath()     // Catch: java.lang.Throwable -> L7b
            r6.append(r1)     // Catch: java.lang.Throwable -> L7b
            java.lang.String r6 = r6.toString()     // Catch: java.lang.Throwable -> L7b
            r5.<init>(r6)     // Catch: java.lang.Throwable -> L7b
            throw r5     // Catch: java.lang.Throwable -> L7b
        L56:
            boolean r1 = r1.isDirectory()     // Catch: java.lang.Throwable -> L7b
            if (r1 == 0) goto L5d
            goto L13
        L5d:
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L7b
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L7b
        L62:
            int r2 = r0.read(r5)     // Catch: java.lang.Throwable -> L72
            r3 = -1
            if (r2 == r3) goto L6e
            r3 = 0
            r1.write(r5, r3, r2)     // Catch: java.lang.Throwable -> L72
            goto L62
        L6e:
            r1.close()     // Catch: java.lang.Throwable -> L7b
            goto L13
        L72:
            r5 = move-exception
            r1.close()     // Catch: java.lang.Throwable -> L7b
            throw r5     // Catch: java.lang.Throwable -> L7b
        L77:
            r0.close()
            return
        L7b:
            r5 = move-exception
            r0.close()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.embedding.engine.deferredcomponents.HummerDeferredComponentManager.unzip(java.io.File, java.io.File):void");
    }

    private boolean verifyJNI() {
        if (this.flutterJNIList.size() == 0) {
            Log.e("flutter", "No FlutterJNI provided. `setJNI` must be called on the DeferredComponentManager before attempting to load dart libraries or invoking with platform channels.");
            return false;
        }
        return true;
    }

    @Override // io.flutter.embedding.engine.deferredcomponents.DeferredComponentManager
    public void destroy() {
        this.channel = null;
        this.flutterJNIList = new LinkedList();
    }

    @Override // io.flutter.embedding.engine.deferredcomponents.DeferredComponentManager
    public String getDeferredComponentInstallState(int i, String str) {
        return i > 1 ? "installed" : "failed";
    }

    @Override // io.flutter.embedding.engine.deferredcomponents.DeferredComponentManager
    public void installDeferredComponent(final int i, String str) {
        final String str2 = "";
        if (str != null && !str.equals("")) {
            str2 = "hummer";
        }
        SplitLoadProvider splitLoadProvider = split_load_provider;
        if (splitLoadProvider == null) {
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: io.flutter.embedding.engine.deferredcomponents.HummerDeferredComponentManager.1
                @Override // java.lang.Runnable
                public void run() {
                    HummerDeferredComponentManager.this.loadDartLibrary(i, str2);
                }
            }, 1L);
        } else {
            splitLoadProvider.loadDartLibrary(i, str, this);
        }
    }

    @Override // io.flutter.embedding.engine.deferredcomponents.DeferredComponentManager
    public void loadAssets(int i, String str) {
        if (verifyJNI()) {
            try {
                AssetManager assets = this.context.getAssets();
                for (FlutterJNI flutterJNI : this.flutterJNIList) {
                    flutterJNI.updateJavaAssetManager(assets, this.flutterApplicationInfo.flutterAssetsDir);
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override // io.flutter.embedding.engine.deferredcomponents.DeferredComponentManager
    public void loadDartLibrary(int i, String str) {
        String cpu_abi;
        if (verifyJNI() && i >= 0) {
            String str2 = "app.so-" + i + ".part.so";
            if (Build.VERSION.SDK_INT >= 21) {
                cpu_abi = Build.SUPPORTED_ABIS[0];
            } else {
                cpu_abi = com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getCPU_ABI();
            }
            cpu_abi.replace("-", JSMethod.NOT_SET);
            ArrayList<String> arrayList = new ArrayList();
            LinkedList linkedList = new LinkedList();
            if (split_load_dir == null) {
                linkedList.add(this.context.getFilesDir());
            } else {
                linkedList.add(new File(split_load_dir));
            }
            while (!linkedList.isEmpty()) {
                File file = (File) linkedList.remove();
                String str3 = Process.is64Bit() ? "arm64-v8a" : "armeabi-v7a";
                if (file != null && file.isDirectory()) {
                    for (File file2 : file.listFiles()) {
                        linkedList.add(file2);
                    }
                } else if (file.getName().equals(str2)) {
                    if (file.getAbsolutePath().indexOf(str3) != -1) {
                        arrayList.add(0, file.getAbsolutePath());
                    } else {
                        arrayList.add(file.getAbsolutePath());
                    }
                }
            }
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(str2);
            for (String str4 : arrayList) {
                arrayList2.add(str4);
            }
            for (FlutterJNI flutterJNI : this.flutterJNIList) {
                flutterJNI.loadDartDeferredLibrary(i, (String[]) arrayList2.toArray(new String[arrayList2.size()]));
            }
            DeferredComponentChannel deferredComponentChannel = this.channel;
            if (deferredComponentChannel != null) {
                deferredComponentChannel.completeInstallSuccess(str);
            }
        }
    }

    @Override // io.flutter.embedding.engine.deferredcomponents.DeferredComponentManager
    public void setDeferredComponentChannel(DeferredComponentChannel deferredComponentChannel) {
        this.channel = deferredComponentChannel;
    }

    @Override // io.flutter.embedding.engine.deferredcomponents.DeferredComponentManager
    public void setJNI(@NonNull FlutterJNI flutterJNI) {
        if (flutterJNI == null) {
            this.flutterJNIList = new LinkedList();
        } else {
            this.flutterJNIList.add(flutterJNI);
        }
    }

    @Override // io.flutter.embedding.engine.deferredcomponents.DeferredComponentManager
    public boolean uninstallDeferredComponent(int i, String str) {
        if (str != null) {
            str.equals("");
            return true;
        }
        return true;
    }
}
