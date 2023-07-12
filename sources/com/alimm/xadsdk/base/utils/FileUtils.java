package com.alimm.xadsdk.base.utils;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class FileUtils {
    private static final int COPY_BUFFER_SIZE = 4096;
    public static final int DIR_TYPE_CACHE = 1;
    public static final int DIR_TYPE_FILE = 0;
    private static final String TAG = "FileUtils";

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public interface FileKeepRule {
        boolean needKept(String str);
    }

    private static void closeIO(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static boolean copyTo(File file, InputStream inputStream) {
        FileOutputStream fileOutputStream = null;
        try {
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                try {
                    byte[] bArr = new byte[4096];
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read == -1) {
                            closeIO(fileOutputStream2);
                            return true;
                        }
                        fileOutputStream2.write(bArr, 0, read);
                    }
                } catch (IOException e) {
                    e = e;
                    fileOutputStream = fileOutputStream2;
                    LogUtils.d(TAG, "copyTo exception: output = " + file, e);
                    closeIO(fileOutputStream);
                    return false;
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    closeIO(fileOutputStream);
                    throw th;
                }
            } catch (IOException e2) {
                e = e2;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static boolean decompress(String str, String str2) {
        ZipInputStream zipInputStream = null;
        try {
            try {
                File file = new File(str2);
                if (!file.exists()) {
                    file.mkdirs();
                }
                ZipInputStream zipInputStream2 = new ZipInputStream(new FileInputStream(new File(str)));
                boolean z = true;
                while (true) {
                    try {
                        ZipEntry nextEntry = zipInputStream2.getNextEntry();
                        if (nextEntry == null) {
                            closeIO(zipInputStream2);
                            return z;
                        }
                        String joinPath = joinPath(str2, nextEntry.getName());
                        if (nextEntry.isDirectory()) {
                            mkdir(joinPath);
                        } else {
                            z &= copyTo(new File(joinPath), zipInputStream2);
                        }
                    } catch (Exception e) {
                        e = e;
                        zipInputStream = zipInputStream2;
                        LogUtils.d(TAG, "decompress exception: inputFilePath = " + str + ", outputDirPath = " + str2, e);
                        closeIO(zipInputStream);
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        zipInputStream = zipInputStream2;
                        closeIO(zipInputStream);
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    public static void delete(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            deleteFile(new File(str));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteExpiredFiles(String str, int i, FileKeepRule fileKeepRule) {
        try {
            List<File> files = getFiles(str);
            if (LogUtils.DEBUG) {
                LogUtils.d(TAG, "deleteExpiredFiles: expireDays = " + i);
            }
            if (files == null || files.size() <= 0) {
                return;
            }
            for (File file : files) {
                if (System.currentTimeMillis() - file.lastModified() > TimeUnit.DAYS.toMillis(i) && (fileKeepRule == null || !fileKeepRule.needKept(file.getName()))) {
                    if (LogUtils.DEBUG) {
                        LogUtils.d(TAG, "deleteExpiredFile: file = " + file);
                    }
                    deleteFile(file);
                }
            }
        } catch (Exception e) {
            LogUtils.e(TAG, "deleteExpiredFiles: exception.", e);
        }
    }

    public static boolean deleteFile(File file) {
        File[] listFiles;
        if (file != null && file.exists()) {
            if (file.isFile()) {
                return file.delete();
            }
            if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
                for (File file2 : listFiles) {
                    if (!deleteFile(file2)) {
                        return false;
                    }
                }
            }
            return file.delete();
        }
        return false;
    }

    private static boolean ensureFileExists(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File file = new File(str);
        if (file.exists()) {
            return true;
        }
        try {
            File parentFile = file.getParentFile();
            if (parentFile.exists() || parentFile.mkdirs()) {
                return file.createNewFile();
            }
            return false;
        } catch (IOException | SecurityException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean exists(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return new File(str).exists();
        } catch (SecurityException e) {
            LogUtils.d(TAG, "call exists failed.", e);
            return false;
        }
    }

    public static File getExternalDir(@NonNull Context context, int i) {
        File file = null;
        try {
        } catch (Throwable unused) {
            LogUtils.d(TAG, "getExternalDir exception: type = " + i);
        }
        if (i != 0) {
            if (i == 1) {
                file = context.getExternalCacheDir();
            }
            return file;
        }
        file = context.getExternalFilesDir(null);
        return file;
    }

    @NonNull
    public static List<File> getFiles(String str) {
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            getFiles(str, arrayList);
        }
        return arrayList;
    }

    private static List<File> getFiles(String str, List<File> list) {
        File[] listFiles;
        File file = new File(str);
        if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    getFiles(file2.getAbsolutePath(), list);
                }
                list.add(file2);
            }
        }
        return list;
    }

    public static synchronized String getStrFromFile(String str) {
        String str2;
        synchronized (FileUtils.class) {
            String str3 = "";
            FileInputStream fileInputStream = null;
            try {
                try {
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Exception e) {
                e = e;
            }
            if (!new File(str).exists()) {
                closeIO(null);
                return null;
            }
            FileInputStream fileInputStream2 = new FileInputStream(str);
            try {
                try {
                    byte[] bArr = new byte[fileInputStream2.available()];
                    fileInputStream2.read(bArr);
                    str2 = new String(bArr, "UTF-8");
                    try {
                        fileInputStream2.close();
                        closeIO(fileInputStream2);
                    } catch (Exception e2) {
                        e = e2;
                        str3 = str2;
                        fileInputStream = fileInputStream2;
                        e.printStackTrace();
                        closeIO(fileInputStream);
                        str2 = str3;
                        return str2;
                    }
                } catch (Exception e3) {
                    e = e3;
                }
                return str2;
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = fileInputStream2;
                closeIO(fileInputStream);
                throw th;
            }
        }
    }

    public static String joinPath(String... strArr) {
        StringBuilder sb = new StringBuilder();
        if (strArr != null) {
            for (int i = 0; i < strArr.length; i++) {
                if (i > 0) {
                    sb.append(File.separator);
                }
                sb.append(strArr[i]);
            }
        }
        return sb.toString();
    }

    public static void mkdir(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        File file = new File(str);
        if (file.exists()) {
            return;
        }
        try {
            file.mkdirs();
        } catch (Exception e) {
            LogUtils.d(TAG, "mkdir exception: folderPath = " + str, e);
        }
    }

    public static String readAssetFile(@NonNull Context context, @NonNull String str) {
        BufferedReader bufferedReader = null;
        try {
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(context.getResources().getAssets().open(str)));
                try {
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        String readLine = bufferedReader2.readLine();
                        if (readLine == null) {
                            String sb2 = sb.toString();
                            closeIO(bufferedReader2);
                            return sb2;
                        }
                        sb.append(readLine);
                    }
                } catch (Exception e) {
                    e = e;
                    bufferedReader = bufferedReader2;
                    e.printStackTrace();
                    closeIO(bufferedReader);
                    return "";
                } catch (Throwable th) {
                    th = th;
                    bufferedReader = bufferedReader2;
                    closeIO(bufferedReader);
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static List<String> readLines(String str) {
        LinkedList linkedList = new LinkedList();
        if (exists(str)) {
            BufferedReader bufferedReader = null;
            try {
                try {
                    BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(new FileInputStream(str)));
                    while (true) {
                        try {
                            String readLine = bufferedReader2.readLine();
                            if (readLine == null) {
                                break;
                            }
                            linkedList.add(readLine);
                        } catch (IOException e) {
                            e = e;
                            bufferedReader = bufferedReader2;
                            e.printStackTrace();
                            closeIO(bufferedReader);
                            return linkedList;
                        } catch (Throwable th) {
                            th = th;
                            bufferedReader = bufferedReader2;
                            closeIO(bufferedReader);
                            throw th;
                        }
                    }
                    closeIO(bufferedReader2);
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (IOException e2) {
                e = e2;
            }
        }
        return linkedList;
    }

    public static synchronized boolean saveStrToFile(String str, String str2) {
        synchronized (FileUtils.class) {
            boolean z = false;
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return false;
            }
            FileOutputStream fileOutputStream = null;
            try {
                try {
                    File file = new File(str);
                    if (!file.exists()) {
                        new File(file.getParent()).mkdirs();
                        file.createNewFile();
                    }
                    FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                    try {
                        fileOutputStream2.write(str2.getBytes());
                        fileOutputStream2.close();
                        closeIO(fileOutputStream2);
                        z = true;
                    } catch (Exception e) {
                        fileOutputStream = fileOutputStream2;
                        e = e;
                        e.printStackTrace();
                        closeIO(fileOutputStream);
                        return z;
                    } catch (Throwable th) {
                        fileOutputStream = fileOutputStream2;
                        th = th;
                        closeIO(fileOutputStream);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception e2) {
                e = e2;
            }
            return z;
        }
    }

    public static void writeLine(String str, boolean z, String str2) {
        if (!ensureFileExists(str)) {
            return;
        }
        PrintWriter printWriter = null;
        try {
            try {
                PrintWriter printWriter2 = new PrintWriter(new BufferedWriter(new FileWriter(str, z)));
                try {
                    printWriter2.println(str2);
                    closeIO(printWriter2);
                } catch (IOException e) {
                    e = e;
                    printWriter = printWriter2;
                    e.printStackTrace();
                    closeIO(printWriter);
                } catch (Throwable th) {
                    th = th;
                    printWriter = printWriter2;
                    closeIO(printWriter);
                    throw th;
                }
            } catch (IOException e2) {
                e = e2;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
