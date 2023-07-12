package com.taobao.securityjni;

import android.app.ActivityManager;
import android.content.Context;
import android.content.res.AssetManager;
import android.os.Process;
import android.util.Log;
import androidx.annotation.NonNull;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class SGJpgProcess {
    private static String[] DEFAULT_FILES = {"res/drawable/yw_1222.jpg", "res/drawable/yw_1222_mwua.jpg", "res/drawable/yw_1222_sharetoken.jpg"};
    private static String FINISHED_FILE_NAME = "SGJpgProcessFinished";
    private static String JPG_DIR_PREFIX = "jpgs_";
    private static String JPG_PREFIX = "yw_1222";
    private static String ROOT_FOLDER = "SGLib";
    private static final String TAG = "SG_Compatible";
    private static Method sOpenNonAssetMethod;
    private static boolean sOpenNonAssetMethodFetched;
    private Context ctx;

    public SGJpgProcess(Context context) {
        this.ctx = context;
    }

    private boolean deleteDir(File file) {
        if (file == null) {
            return false;
        }
        if (file.isDirectory()) {
            String[] list = file.list();
            for (int i = 0; list != null && i < list.length; i++) {
                if (!deleteDir(new File(file, list[i]))) {
                    return false;
                }
            }
        }
        return file.delete();
    }

    private void fetchOpenNonAssetMethod() {
        if (sOpenNonAssetMethodFetched) {
            return;
        }
        try {
            Method declaredMethod = AssetManager.class.getDeclaredMethod("openNonAsset", String.class);
            sOpenNonAssetMethod = declaredMethod;
            declaredMethod.setAccessible(true);
        } catch (NoSuchMethodException e) {
            Log.i(TAG, "Failed to retrieve openNonAsset method", e);
        }
        sOpenNonAssetMethodFetched = true;
    }

    private static String getProcessName(Context context) {
        try {
            int myPid = Process.myPid();
            if (context != null) {
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
                    if (runningAppProcessInfo.pid == myPid) {
                        String str = runningAppProcessInfo.processName;
                        return str != null ? str : "";
                    }
                }
                return "";
            }
            return "";
        } catch (Throwable unused) {
            return "";
        }
    }

    private boolean isMainProcess() {
        try {
            return getProcessName(this.ctx).equals(this.ctx.getPackageName());
        } catch (Exception unused) {
            return false;
        }
    }

    private boolean isPathSecurityValid(String str) {
        return !Pattern.compile("\\S*(\\.\\.)+(%)*\\S*").matcher(str).find();
    }

    private boolean unzipByAssetManager(String str, String str2, String[] strArr) {
        int indexOf;
        FileOutputStream fileOutputStream;
        int available;
        BufferedOutputStream bufferedOutputStream;
        for (String str3 : strArr) {
            if (isPathSecurityValid(str3) && (indexOf = str3.indexOf(str2)) >= 0) {
                try {
                    InputStream openNonAsset = openNonAsset(this.ctx.getAssets(), str3);
                    if (openNonAsset == null) {
                        return false;
                    }
                    String substring = str3.substring(indexOf);
                    BufferedOutputStream bufferedOutputStream2 = null;
                    try {
                        available = openNonAsset.available();
                        fileOutputStream = new FileOutputStream(new File(str, substring));
                        try {
                            bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                        } catch (Exception unused) {
                        } catch (Throwable th) {
                            th = th;
                        }
                    } catch (Exception unused2) {
                        fileOutputStream = null;
                    } catch (Throwable th2) {
                        th = th2;
                        fileOutputStream = null;
                    }
                    try {
                        byte[] bArr = new byte[available];
                        int i = 0;
                        while (i < available) {
                            int read = openNonAsset.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            bufferedOutputStream.write(bArr, 0, read);
                            i += read;
                        }
                        if (i != available) {
                            try {
                                bufferedOutputStream.flush();
                                bufferedOutputStream.close();
                                fileOutputStream.close();
                            } catch (Exception unused3) {
                            }
                            return false;
                        }
                        try {
                            bufferedOutputStream.flush();
                            bufferedOutputStream.close();
                            fileOutputStream.close();
                        } catch (Exception unused4) {
                            return false;
                        }
                    } catch (Exception unused5) {
                        bufferedOutputStream2 = bufferedOutputStream;
                        try {
                            bufferedOutputStream2.flush();
                            bufferedOutputStream2.close();
                            fileOutputStream.close();
                        } catch (Exception unused6) {
                        }
                        return false;
                    } catch (Throwable th3) {
                        th = th3;
                        bufferedOutputStream2 = bufferedOutputStream;
                        try {
                            bufferedOutputStream2.flush();
                            bufferedOutputStream2.close();
                            fileOutputStream.close();
                            throw th;
                        } catch (Exception unused7) {
                            return false;
                        }
                    }
                } catch (Exception unused8) {
                    if (str3.indexOf("sharetoken") == -1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean unzipByPrefix(String str, String str2, String str3, String[] strArr) {
        ZipEntry entry;
        int indexOf;
        FileOutputStream fileOutputStream;
        if (strArr != null) {
            try {
                if (strArr.length > 0) {
                    ZipFile zipFile = new ZipFile(str);
                    for (String str4 : strArr) {
                        if (isPathSecurityValid(str4) && (entry = zipFile.getEntry(str4)) != null && (indexOf = str4.indexOf(str3)) >= 0) {
                            InputStream inputStream = zipFile.getInputStream(entry);
                            int size = (int) entry.getSize();
                            String substring = str4.substring(indexOf);
                            BufferedOutputStream bufferedOutputStream = null;
                            try {
                                fileOutputStream = new FileOutputStream(new File(str2, substring));
                                try {
                                    BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(fileOutputStream, size);
                                    try {
                                        byte[] bArr = new byte[size];
                                        int i = 0;
                                        while (i < size) {
                                            int read = inputStream.read(bArr);
                                            if (read == -1) {
                                                break;
                                            }
                                            bufferedOutputStream2.write(bArr, 0, read);
                                            i += read;
                                        }
                                        if (i != size) {
                                            try {
                                                bufferedOutputStream2.flush();
                                                bufferedOutputStream2.close();
                                                fileOutputStream.close();
                                            } catch (Exception unused) {
                                            }
                                            return false;
                                        }
                                        try {
                                            bufferedOutputStream2.flush();
                                            bufferedOutputStream2.close();
                                            fileOutputStream.close();
                                        } catch (Exception unused2) {
                                        }
                                    } catch (Exception unused3) {
                                        bufferedOutputStream = bufferedOutputStream2;
                                        try {
                                            bufferedOutputStream.flush();
                                            bufferedOutputStream.close();
                                            fileOutputStream.close();
                                        } catch (Exception unused4) {
                                        }
                                        return false;
                                    } catch (Throwable th) {
                                        th = th;
                                        bufferedOutputStream = bufferedOutputStream2;
                                        try {
                                            bufferedOutputStream.flush();
                                            bufferedOutputStream.close();
                                            fileOutputStream.close();
                                        } catch (Exception unused5) {
                                        }
                                        throw th;
                                    }
                                } catch (Exception unused6) {
                                } catch (Throwable th2) {
                                    th = th2;
                                }
                            } catch (Exception unused7) {
                                fileOutputStream = null;
                            } catch (Throwable th3) {
                                th = th3;
                                fileOutputStream = null;
                            }
                        }
                    }
                    return true;
                }
            } catch (IOException unused8) {
            }
        }
        return false;
    }

    private boolean writeEmptyFile(File file) {
        FileOutputStream fileOutputStream = null;
        try {
            if (file != null) {
                try {
                    FileOutputStream fileOutputStream2 = new FileOutputStream(file.getAbsolutePath());
                    try {
                        fileOutputStream2.close();
                        try {
                            fileOutputStream2.close();
                        } catch (IOException unused) {
                        }
                        return true;
                    } catch (IOException e) {
                        e = e;
                        fileOutputStream = fileOutputStream2;
                        e.printStackTrace();
                        try {
                            fileOutputStream.close();
                            return false;
                        } catch (IOException unused2) {
                            return false;
                        }
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream = fileOutputStream2;
                        try {
                            fileOutputStream.close();
                        } catch (IOException unused3) {
                        }
                        throw th;
                    }
                } catch (IOException e2) {
                    e = e2;
                }
            } else {
                throw null;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public InputStream openNonAsset(@NonNull AssetManager assetManager, @NonNull String str) {
        fetchOpenNonAssetMethod();
        Method method = sOpenNonAssetMethod;
        if (method != null) {
            try {
                return (InputStream) method.invoke(assetManager, str);
            } catch (IllegalAccessException unused) {
                return null;
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e.getCause());
            }
        }
        return null;
    }

    public boolean unzipFinished() {
        return unzipFinished(DEFAULT_FILES);
    }

    public boolean unzipFinished(String[] strArr) {
        File file;
        try {
            if (this.ctx != null && isMainProcess()) {
                String absolutePath = this.ctx.getDir(ROOT_FOLDER, 0).getAbsolutePath();
                String str = this.ctx.getApplicationInfo().sourceDir;
                String str2 = null;
                if (str != null) {
                    if (new File(str).exists()) {
                        str2 = absolutePath + "/app_" + (file.lastModified() / 1000);
                    }
                    File file2 = new File(str2);
                    if (!file2.exists()) {
                        file2.mkdir();
                    }
                    str2 = str2 + "/pre_unzip_jpgs";
                    File file3 = new File(str2);
                    if (!file3.exists()) {
                        file3.mkdir();
                    }
                }
                File file4 = new File(str2, FINISHED_FILE_NAME);
                if (file4.exists()) {
                    return true;
                }
                if (unzipByAssetManager(str2, JPG_PREFIX, strArr) || unzipByPrefix(str, str2, JPG_PREFIX, strArr)) {
                    return writeEmptyFile(file4);
                }
                return false;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
