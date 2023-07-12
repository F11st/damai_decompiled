package com.android.alibaba.ip.server;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.RequiresApi;
import com.android.alibaba.ip.common.IPatchVerifier;
import com.android.alibaba.ip.common.PatchInfo;
import com.android.alibaba.ip.common.PatchResult;
import com.android.alibaba.ip.runtime.ApplicationPatch;
import com.android.alibaba.ip.runtime.PatchesLoader;
import com.android.alibaba.ip.utils.PreferencesProviderUtils;
import com.android.alibaba.ip.utils.ThreadUtils;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipFile;
import tb.q6;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class InstantPatcher {
    private static final String CLASSES_DEX = "classes.dex";
    public static final int HAS_PATCHED = 1;
    private static final String INSTANT_BASE_VERSION = "instant_base_Version";
    private static final String INSTANT_PATCH_PRIORITY = "instant_patch_priority";
    private static final String INSTANT_PATCH_VERSION = "instant_patch_version";
    public static final int NO_DEX = 4;
    public static final int PATCH_FAILED = 3;
    private static final String PATCH_INFO_FILE_NAME = "instant_patch";
    public static final int PATCH_MODIFIED = 2;
    public static final int PATCH_NOT_MATCH = 5;
    public static final int PATCH_SUCCESS = 0;
    private static final String TAG = "InstantPatcher";
    private static InstantPatcher sInstantPatcher;
    private final Context context;
    private String packageName;
    private IPatchVerifier patchVerifier;
    private PatchInfo savePatchInfo = null;
    private boolean isMainProcess = true;

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class FileState {
        public boolean external;
        public File file;
    }

    private InstantPatcher(String str, Context context) {
        this.context = context;
        this.packageName = str;
        FileManager.context = context;
    }

    private boolean authenticate(String str) throws IOException {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return this.context.getPackageManager().getPackageInfo(this.packageName, 0).versionName.equals(str);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return true;
        }
    }

    private void clearPatch() {
        try {
            File dataFolder = FileManager.getDataFolder();
            File externalDataFolder = FileManager.getExternalDataFolder();
            File file = new File(optPathFor(this.context.getCacheDir()));
            File file2 = new File(optPathFor(this.context.getExternalCacheDir()));
            if (externalDataFolder != null) {
                FileManager.purgeTempDexFiles(externalDataFolder);
            }
            FileManager.purgeTempDexFiles(dataFolder);
            FileManager.purgeOptFiles(file);
            FileManager.purgeOptFiles(file2);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @RequiresApi(api = 9)
    private void clearPatchInfo() {
        this.savePatchInfo = null;
        PreferencesProviderUtils.clear(this.context, PATCH_INFO_FILE_NAME);
    }

    public static InstantPatcher create(Context context) {
        if (sInstantPatcher == null) {
            sInstantPatcher = new InstantPatcher(context.getPackageName(), context);
        }
        return sInstantPatcher;
    }

    private void handleHotSwapPatch(PatchResult patchResult, ApplicationPatch applicationPatch) {
        if (Log.isLoggable("InstantPatcher", 2)) {
            Log.v("InstantPatcher", "Received patch");
        }
        try {
            FileState writeTempDexFile = FileManager.writeTempDexFile(applicationPatch.getPath(), applicationPatch.getPatchVersion());
            if (writeTempDexFile.file == null) {
                patchResult.resCode = 3;
                patchResult.msg = "mkdir failed";
                Log.e("InstantPatcher", "mkdir failed");
                return;
            }
            handlePatch(writeTempDexFile, patchResult);
            if (patchResult.resCode != 0) {
                purge();
            }
        } catch (Exception e) {
            e.printStackTrace();
            patchResult.resCode = 3;
            patchResult.msg = "write dex failed";
            patchResult.t = e;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @RequiresApi(api = 3)
    public void handlePatch(FileState fileState, PatchResult patchResult) {
        DexClassLoader dexClassLoader;
        try {
            String path = FileManager.getNativeLibraryFolder().getPath();
            if (!fileState.external) {
                dexClassLoader = new DexClassLoader(fileState.file.getPath(), optPathFor(this.context.getCacheDir()), path, getClass().getClassLoader());
            } else {
                dexClassLoader = new DexClassLoader(fileState.file.getPath(), optPathFor(this.context.getExternalCacheDir()), path, getClass().getClassLoader());
            }
            Class<?> cls = Class.forName("com.android.alibaba.ip.runtime.AppPatchesLoaderImpl", true, dexClassLoader);
            try {
                Log.e("InstantPatcher", "Got the patcher class " + cls);
                PatchesLoader patchesLoader = (PatchesLoader) cls.newInstance();
                Log.e("InstantPatcher", "Got the patcher instance " + patchesLoader);
                String[] strArr = (String[]) cls.getDeclaredMethod("getPatchedClasses", new Class[0]).invoke(patchesLoader, new Object[0]);
                Log.e("InstantPatcher", "Got the list of classes ");
                for (String str : strArr) {
                    Log.v("InstantPatcher", "class " + str);
                }
                if (patchesLoader.load()) {
                    return;
                }
                patchResult.resCode = 3;
                patchResult.msg = "exception to apply changes load";
            } catch (Exception e) {
                Log.e("InstantPatcher", "Couldn't apply code changes", e);
                e.printStackTrace();
                patchResult.resCode = 3;
                patchResult.msg = "exception to apply changes " + e.getMessage();
                patchResult.t = e;
            }
        } catch (Throwable th) {
            Log.e("InstantPatcher", "Couldn't apply code changes", th);
            patchResult.resCode = 3;
            patchResult.msg = "dexopt failed or loadclass Failed";
            patchResult.t = th;
        }
    }

    private static boolean hasResources(List<ApplicationPatch> list) {
        for (ApplicationPatch applicationPatch : list) {
            if (isResourcePath(applicationPatch.getPath())) {
                return true;
            }
        }
        return false;
    }

    private static boolean isResourcePath(String str) {
        return str.equals("resources.ap_") || str.startsWith("res/");
    }

    private String optPathFor(File file) {
        File file2 = new File(file, "instant-opt");
        file2.mkdirs();
        return file2.getPath();
    }

    @RequiresApi(api = 9)
    private void savePatchInfo(PatchInfo patchInfo) {
        this.savePatchInfo = patchInfo;
        PreferencesProviderUtils.putString(this.context, PATCH_INFO_FILE_NAME, INSTANT_BASE_VERSION, patchInfo.baseVersion);
        PreferencesProviderUtils.putInt(this.context, PATCH_INFO_FILE_NAME, INSTANT_PATCH_VERSION, patchInfo.patchVersion);
        PreferencesProviderUtils.putInt(this.context, PATCH_INFO_FILE_NAME, INSTANT_PATCH_PRIORITY, patchInfo.priority);
    }

    @RequiresApi(api = 9)
    public void applyPatch() {
        PatchInfo patchInfo = getPatchInfo();
        if (TextUtils.isEmpty(patchInfo.baseVersion)) {
            Log.e("InstantPatcher", "no patch");
            return;
        }
        final PatchResult patchResult = new PatchResult();
        try {
            if (!this.context.getPackageManager().getPackageInfo(this.packageName, 0).versionName.equals(patchInfo.baseVersion) && isMainProcess(this.context)) {
                purge();
            } else {
                final FileState tempDexFile = FileManager.getTempDexFile(patchInfo.patchVersion, false);
                File file = tempDexFile.file;
                if (file != null && file.exists()) {
                    Runnable runnable = new Runnable() { // from class: com.android.alibaba.ip.server.InstantPatcher.1
                        @Override // java.lang.Runnable
                        public void run() {
                            InstantPatcher.this.handlePatch(tempDexFile, patchResult);
                            if (patchResult.resCode == 0) {
                                Log.e("InstantPatcher", "patch success");
                                return;
                            }
                            InstantPatcher.this.purge();
                            Log.e("InstantPatcher", "patch failed and clear patch:" + tempDexFile.file.getPath());
                        }
                    };
                    int i = patchInfo.priority;
                    if (i == 0) {
                        ThreadUtils.asyncExcute(runnable);
                    } else if (i == 1) {
                        ThreadUtils.syncExcute(runnable);
                    }
                }
                purge();
                Log.e("InstantPatcher", "no patchFile");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public PatchInfo getPatchInfo() {
        if (this.savePatchInfo == null) {
            PatchInfo patchInfo = new PatchInfo();
            this.savePatchInfo = patchInfo;
            patchInfo.baseVersion = PreferencesProviderUtils.getString(this.context, PATCH_INFO_FILE_NAME, INSTANT_BASE_VERSION, "");
            this.savePatchInfo.patchVersion = PreferencesProviderUtils.getInt(this.context, PATCH_INFO_FILE_NAME, INSTANT_PATCH_VERSION, 0);
            this.savePatchInfo.priority = PreferencesProviderUtils.getInt(this.context, PATCH_INFO_FILE_NAME, INSTANT_PATCH_PRIORITY, 0);
        }
        return this.savePatchInfo;
    }

    public IPatchVerifier getPatchVerifier() {
        return this.patchVerifier;
    }

    @RequiresApi(api = 3)
    @SuppressLint({"NewApi"})
    public PatchResult handlePatches(String str, PatchInfo patchInfo) throws IOException {
        PatchResult patchResult = new PatchResult();
        if (hasPatched(patchInfo)) {
            patchResult.resCode = 1;
            return patchResult;
        }
        ZipFile zipFile = null;
        try {
            try {
                if (!TextUtils.isEmpty(str) && new File(str).exists()) {
                    if (this.patchVerifier != null && !isApkInDebug() && !this.patchVerifier.authenticate(new File(str))) {
                        patchResult.resCode = 2;
                        return patchResult;
                    }
                    ZipFile zipFile2 = new ZipFile(str);
                    try {
                        if (zipFile2.getEntry(CLASSES_DEX) == null) {
                            patchResult.resCode = 4;
                            zipFile2.close();
                            return patchResult;
                        } else if (!authenticate(patchInfo.baseVersion)) {
                            patchResult.resCode = 5;
                            zipFile2.close();
                            return patchResult;
                        } else {
                            handlePatches(Arrays.asList(new ApplicationPatch(str, patchInfo.patchVersion)), patchResult);
                            if (patchResult.resCode != 0) {
                                zipFile2.close();
                                return patchResult;
                            }
                            savePatchInfo(patchInfo);
                            zipFile2.close();
                            return patchResult;
                        }
                    } catch (Exception e) {
                        e = e;
                        zipFile = zipFile2;
                        e.printStackTrace();
                        if (zipFile != null) {
                            zipFile.close();
                        }
                        return patchResult;
                    } catch (Throwable th) {
                        th = th;
                        zipFile = zipFile2;
                        if (zipFile != null) {
                            zipFile.close();
                        }
                        throw th;
                    }
                }
            } catch (Exception e2) {
                e = e2;
            }
            return patchResult;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public boolean hasPatched(PatchInfo patchInfo) {
        return patchInfo.equals(getPatchInfo());
    }

    @RequiresApi(api = 4)
    public boolean isApkInDebug() {
        try {
            return (this.context.getApplicationInfo().flags & 2) != 0;
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean isMainProcess(Context context) {
        try {
            if (q6.a != null) {
                boolean z = false;
                int myPid = Process.myPid();
                Iterator<ActivityManager.RunningAppProcessInfo> it = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    ActivityManager.RunningAppProcessInfo next = it.next();
                    if (q6.a.equals(next.processName)) {
                        if (next.pid == myPid) {
                            this.isMainProcess = true;
                            z = true;
                            break;
                        }
                        z = true;
                    }
                }
                if (!this.isMainProcess && !z) {
                    this.isMainProcess = true;
                    Log.w("InstantRun", "considering this process main process:no process with this package found?!");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this.isMainProcess;
    }

    @RequiresApi(api = 9)
    public void purge() {
        clearPatchInfo();
        clearPatch();
    }

    public void setiPatchVerifier(IPatchVerifier iPatchVerifier) {
        this.patchVerifier = iPatchVerifier;
    }

    private void handlePatches(List<ApplicationPatch> list, PatchResult patchResult) {
        for (ApplicationPatch applicationPatch : list) {
            handleHotSwapPatch(patchResult, applicationPatch);
        }
    }
}
