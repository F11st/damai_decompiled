package com.android.alibaba.ip.server;

import android.content.Context;
import android.util.Log;
import com.android.alibaba.ip.runtime.Paths;
import com.android.alibaba.ip.server.InstantPatcher;
import com.android.alibaba.ip.utils.FileUtils;
import com.youku.arch.solid.monitor.SolidMonitor;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import tb.q6;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class FileManager {
    public static final String CLASSES_DEX_SUFFIX = ".dex";
    private static final String FILE_NAME_ACTIVE = "active";
    private static final String FOLDER_NAME_LEFT = "left";
    private static final String FOLDER_NAME_RIGHT = "right";
    private static final String RELOAD_DEX_PREFIX = "reload";
    private static final String RESOURCE_FILE_NAME = "resources.ap_";
    private static final String RESOURCE_FOLDER_NAME = "resources";
    private static final String TAG = "FileManager";
    static final boolean USE_EXTRACTED_RESOURCES = false;
    public static Context context;
    private static boolean havePurgedTempDexFolder;

    private static void delete(File file) {
        File[] listFiles;
        if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                delete(file2);
            }
        }
        if (file.delete()) {
            return;
        }
        Log.e(TAG, "Failed to delete file " + file);
    }

    public static File getDataFolder() {
        if (context != null) {
            return new File(Paths.getDataDirectory(context));
        }
        return new File(Paths.getDataDirectory(q6.a));
    }

    public static File getExternalDataFolder() {
        String externalDataDirectory;
        Context context2 = context;
        if (context2 == null || (externalDataDirectory = Paths.getExternalDataDirectory(context2)) == null) {
            return null;
        }
        return new File(externalDataDirectory);
    }

    public static File getFilesFolder() {
        if (context != null) {
            return new File(Paths.getMainApkFilesDirectory(context));
        }
        return new File(Paths.getMainApkFilesDirectory(q6.a));
    }

    public static File getNativeLibraryFolder() {
        if (context != null) {
            return new File(Paths.getMainApkDataDirectory(context), SolidMonitor.CHECK_TYPE_LIB);
        }
        return new File(Paths.getMainApkDataDirectory(q6.a), SolidMonitor.CHECK_TYPE_LIB);
    }

    public static InstantPatcher.FileState getTempDexFile(int i, boolean z) {
        int i2;
        int i3;
        String format;
        InstantPatcher.FileState fileState = new InstantPatcher.FileState();
        File dataFolder = getDataFolder();
        File tempDexFileFolder = getTempDexFileFolder(dataFolder);
        int i4 = 3;
        do {
            i2 = -1;
            if (tempDexFileFolder.exists() || !z || (tempDexFileFolder.mkdirs() && tempDexFileFolder.exists())) {
                break;
            }
            Log.e("InstantPatch", "Failed to create directory " + tempDexFileFolder);
            i4 += -1;
        } while (i4 > 0);
        if (!tempDexFileFolder.exists()) {
            File externalDataFolder = getExternalDataFolder();
            if (externalDataFolder == null) {
                return fileState;
            }
            tempDexFileFolder = getTempDexFileFolder(externalDataFolder);
            if (z) {
                dataFolder.mkdirs();
            }
            fileState.external = true;
        } else {
            fileState.external = false;
        }
        if (i == 0) {
            File[] listFiles = tempDexFileFolder.listFiles();
            if (listFiles != null) {
                for (File file : listFiles) {
                    String name = file.getName();
                    if (name.startsWith("reload") && name.endsWith(".jar")) {
                        try {
                            int intValue = Integer.decode(name.substring(6, name.length() - 4)).intValue();
                            if (intValue > i2) {
                                i2 = intValue;
                            }
                        } catch (NumberFormatException unused) {
                        }
                    }
                }
            }
            i3 = 2;
            format = String.format("%s0x%04x%s", "reload", Integer.valueOf(i2 + 1), ".jar");
        } else {
            i3 = 2;
            format = String.format("%s0x%04x%s", "reload", Integer.valueOf(i), ".jar");
        }
        File file2 = new File(tempDexFileFolder, format);
        fileState.file = file2;
        if (Log.isLoggable("InstantPatch", i3)) {
            Log.v("InstantPatch", "Writing new dex file: " + file2);
        }
        return fileState;
    }

    private static File getTempDexFileFolder(File file) {
        return new File(file, "dex-temp");
    }

    public static void purgeOptFiles(File file) {
        File[] listFiles;
        if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                if (!file2.delete()) {
                    Log.e("InstantPatch", "Could not delete temp dex file " + file2);
                }
            }
        }
    }

    public static void purgeTempDexFiles(File file) {
        File[] listFiles;
        havePurgedTempDexFolder = true;
        File tempDexFileFolder = getTempDexFileFolder(file);
        if (tempDexFileFolder.isDirectory() && (listFiles = tempDexFileFolder.listFiles()) != null) {
            for (File file2 : listFiles) {
                if (file2.getPath().endsWith(".jar") && !file2.delete()) {
                    Log.e("InstantPatch", "Could not delete temp dex file " + file2);
                }
            }
        }
    }

    public static boolean writeRawBytes(File file, byte[] bArr) {
        BufferedOutputStream bufferedOutputStream;
        BufferedOutputStream bufferedOutputStream2 = null;
        try {
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
        } catch (Throwable th) {
            th = th;
        }
        try {
            bufferedOutputStream.write(bArr);
            bufferedOutputStream.flush();
            bufferedOutputStream.close();
            try {
                bufferedOutputStream.close();
            } catch (Exception unused) {
            }
            return true;
        } catch (Throwable th2) {
            th = th2;
            bufferedOutputStream2 = bufferedOutputStream;
            try {
                Log.wtf(Logging.LOG_TAG, "Failed to write file, clean project and rebuild " + file, th);
                throw new RuntimeException(String.format("InstantRun could not write file %1$s, clean project and rebuild ", file));
            } catch (Throwable th3) {
                try {
                    bufferedOutputStream2.close();
                } catch (Exception unused2) {
                }
                throw th3;
            }
        }
    }

    public static InstantPatcher.FileState writeTempDexFile(String str, int i) throws IOException {
        InstantPatcher.FileState tempDexFile = getTempDexFile(i, true);
        File file = tempDexFile.file;
        if (file == null) {
            return tempDexFile;
        }
        if (!file.exists()) {
            if (!new File(str).renameTo(tempDexFile.file)) {
                FileUtils.copyInputStreamToFile(new FileInputStream(str), tempDexFile.file);
            }
            return tempDexFile;
        }
        File file2 = tempDexFile.file;
        if (file2 != null && file2.exists()) {
            if (FileUtils.isSameFile(tempDexFile.file, new File(str))) {
                return tempDexFile;
            }
            tempDexFile.file.delete();
            new File(str).renameTo(tempDexFile.file);
            return tempDexFile;
        }
        Log.e("InstantPatch", "No file to write temp dex content to");
        return tempDexFile;
    }
}
