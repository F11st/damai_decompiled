package com.youku.uplayer;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Environment;
import android.os.StatFs;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class FileUtils {
    private static final int BUF_SIZE = 32768;
    public static final int FAILED = -1;
    static final String LOG_TAG = "FileUtils";
    private static final Class<?>[] SIG_SET_PERMISSION;
    public static final int SUCCESS = 0;
    public static final int S_IRGRP = 32;
    public static final int S_IROTH = 4;
    public static final int S_IRUSR = 256;
    public static final int S_IRWXG = 56;
    public static final int S_IRWXO = 7;
    public static final int S_IRWXU = 448;
    public static final int S_IWGRP = 16;
    public static final int S_IWOTH = 2;
    public static final int S_IWUSR = 128;
    public static final int S_IXGRP = 8;
    public static final int S_IXOTH = 1;
    public static final int S_IXUSR = 64;
    private static WeakReference<Exception> exReference;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public enum FileState {
        FState_Dir("I am director!"),
        FState_File("I am file!"),
        FState_None("I am a ghost!"),
        FState_Other("I am not human!");
        
        private String tag;

        FileState(String str) {
            this.tag = str;
        }

        public String getTag() {
            return this.tag;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.tag;
        }
    }

    static {
        Class<?> cls = Integer.TYPE;
        SIG_SET_PERMISSION = new Class[]{String.class, cls, cls, cls};
    }

    private FileUtils() {
    }

    public static boolean assetExist(AssetManager assetManager, String str) {
        try {
            try {
                try {
                    assetManager.open(str).close();
                } catch (Exception unused) {
                }
                return true;
            } catch (IOException unused2) {
                throw null;
            } catch (Throwable th) {
                try {
                    throw null;
                } catch (Exception unused3) {
                    throw th;
                }
            }
        } catch (Exception unused4) {
            return false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r0v2 */
    public static byte[] assetToBytes(Context context, String str) {
        InputStream inputStream;
        ?? r0 = 0;
        try {
            try {
                inputStream = context.getAssets().open(str);
            } catch (Exception e) {
                e = e;
                inputStream = null;
            } catch (Throwable th) {
                th = th;
                try {
                    r0.close();
                } catch (Exception unused) {
                }
                throw th;
            }
            try {
                byte[] bArr = new byte[inputStream.available()];
                inputStream.read(bArr);
                try {
                    inputStream.close();
                } catch (Exception unused2) {
                }
                return bArr;
            } catch (Exception e2) {
                e = e2;
                setLastException(e);
                try {
                    inputStream.close();
                } catch (Exception unused3) {
                }
                return null;
            }
        } catch (Throwable th2) {
            th = th2;
            r0 = context;
            r0.close();
            throw th;
        }
    }

    public static int assetToFile(Context context, String str, File file) {
        InputStream inputStream = null;
        try {
            try {
                inputStream = context.getAssets().open(str);
                int streamToFile = streamToFile(file, inputStream, false);
                try {
                    inputStream.close();
                } catch (Exception unused) {
                }
                return streamToFile;
            } catch (Exception unused2) {
                inputStream.close();
                return -1;
            } catch (Throwable th) {
                try {
                    inputStream.close();
                } catch (Exception unused3) {
                }
                throw th;
            }
        } catch (Exception unused4) {
            return -1;
        }
    }

    public static int assetToFile(Context context, String str, String str2) {
        return assetToFile(context, str, new File(str2));
    }

    public static int assetToFileIfNotExist(Context context, String str, File file) {
        InputStream inputStream = null;
        try {
            try {
                inputStream = context.getAssets().open(str);
                if (checkExistBySize(file, inputStream.available())) {
                    try {
                        inputStream.close();
                    } catch (Exception unused) {
                    }
                    return 0;
                }
                int streamToFile = streamToFile(file, inputStream, false);
                try {
                    inputStream.close();
                } catch (Exception unused2) {
                }
                return streamToFile;
            } catch (Exception unused3) {
                inputStream.close();
                return -1;
            } catch (Throwable th) {
                try {
                    inputStream.close();
                } catch (Exception unused4) {
                }
                throw th;
            }
        } catch (Exception unused5) {
            return -1;
        }
    }

    public static String assetToString(Context context, String str) {
        byte[] assetToBytes = assetToBytes(context, str);
        if (assetToBytes != null) {
            return new String(assetToBytes);
        }
        return null;
    }

    public static int bytesToFile(File file, byte[] bArr) {
        return bytesToFile(file, bArr, 0, bArr.length, false);
    }

    public static int bytesToFile(File file, byte[] bArr, int i, int i2, boolean z) {
        checkParentPath(file);
        if (bArr == null) {
            return -1;
        }
        if (i2 <= 0) {
            i2 = bArr.length;
        }
        FileOutputStream fileOutputStream = null;
        try {
            FileOutputStream fileOutputStream2 = new FileOutputStream(file, z);
            try {
                fileOutputStream2.write(bArr, i, i2);
                fileOutputStream2.flush();
                try {
                    fileOutputStream2.close();
                } catch (Exception unused) {
                }
                return 0;
            } catch (Exception unused2) {
                fileOutputStream = fileOutputStream2;
                try {
                    fileOutputStream.close();
                } catch (Exception unused3) {
                }
                return -1;
            } catch (Throwable th) {
                th = th;
                fileOutputStream = fileOutputStream2;
                try {
                    fileOutputStream.close();
                } catch (Exception unused4) {
                }
                throw th;
            }
        } catch (Exception unused5) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static int bytesToFile(File file, byte[] bArr, boolean z) {
        return bytesToFile(file, bArr, 0, bArr.length, z);
    }

    public static int bytesToFile(String str, byte[] bArr, int i, int i2, boolean z) {
        return bytesToFile(new File(str), bArr, i, i2, z);
    }

    public static boolean checkExistBySize(File file, long j) {
        return file.exists() && file.isFile() && file.length() == j;
    }

    public static void checkParentPath(File file) {
        File parentFile = file.getParentFile();
        if (parentFile == null || parentFile.isDirectory()) {
            return;
        }
        createDir(parentFile);
    }

    public static void checkParentPath(String str) {
        checkParentPath(new File(str));
    }

    public static int copyTo(File file, File file2) {
        FileInputStream fileInputStream;
        if (fileState(file2) != FileState.FState_File) {
            return -1;
        }
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(file2);
        } catch (Exception unused) {
        } catch (Throwable th) {
            th = th;
        }
        try {
            int streamToFile = streamToFile(file, (InputStream) fileInputStream, false);
            try {
                fileInputStream.close();
            } catch (Exception unused2) {
            }
            return streamToFile;
        } catch (Exception unused3) {
            fileInputStream2 = fileInputStream;
            try {
                fileInputStream2.close();
            } catch (Exception unused4) {
            }
            return -1;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream2 = fileInputStream;
            try {
                fileInputStream2.close();
            } catch (Exception unused5) {
            }
            throw th;
        }
    }

    public static int copyTo(String str, String str2) {
        return copyTo(new File(str), new File(str2));
    }

    public static String coverSize(long j) {
        if (j < 1024) {
            return "" + j + "b";
        } else if (j < 1048576) {
            return String.format(Locale.getDefault(), "%.1fK", Float.valueOf(((float) j) / 1024.0f));
        } else {
            int i = (j > 1073741824L ? 1 : (j == 1073741824L ? 0 : -1));
            Locale locale = Locale.getDefault();
            Object[] objArr = new Object[1];
            long j2 = j / 1024;
            if (i < 0) {
                objArr[0] = Float.valueOf(((float) j2) / 1024.0f);
                return String.format(locale, "%.1fM", objArr);
            }
            objArr[0] = Float.valueOf(((float) (j2 / 1024)) / 1024.0f);
            return String.format(locale, "%.1fG", objArr);
        }
    }

    public static int createDir(File file) {
        if (file.exists()) {
            if (file.isDirectory()) {
                return 0;
            }
            file.delete();
        }
        return file.mkdirs() ? 0 : -1;
    }

    public static int createDir(String str) {
        return createDir(new File(str));
    }

    public static boolean createLink(String str, String str2) {
        try {
            Process exec = Runtime.getRuntime().exec(String.format("ln -s %s %s", str, str2));
            InputStream inputStream = exec.getInputStream();
            while (inputStream.read() != -1) {
            }
            inputStream.close();
            exec.waitFor();
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static int deleteBlankPath(String str) {
        File file = new File(str);
        if (file.canWrite()) {
            if (file.list() == null || file.list().length <= 0) {
                return file.delete() ? 0 : 3;
            }
            return 2;
        }
        return 1;
    }

    public static FileState fileState(File file) {
        return !file.exists() ? FileState.FState_None : file.isFile() ? FileState.FState_File : file.isDirectory() ? FileState.FState_Dir : FileState.FState_Other;
    }

    public static FileState fileState(String str) {
        return fileState(new File(str));
    }

    public static byte[] fileToBytes(File file) {
        return fileToBytes(file, 0, 0);
    }

    public static byte[] fileToBytes(File file, int i, int i2) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        if (i2 >= 0 && file.exists()) {
            try {
                fileInputStream = new FileInputStream(file);
                if (i2 == 0) {
                    try {
                        i2 = fileInputStream.available();
                    } catch (Exception unused) {
                        try {
                            fileInputStream.close();
                        } catch (Exception unused2) {
                        }
                        return null;
                    } catch (Throwable th) {
                        th = th;
                        fileInputStream2 = fileInputStream;
                        try {
                            fileInputStream2.close();
                        } catch (Exception unused3) {
                        }
                        throw th;
                    }
                }
                byte[] bArr = new byte[i2];
                fileInputStream.read(bArr, i, i2);
                try {
                    fileInputStream.close();
                } catch (Exception unused4) {
                }
                return bArr;
            } catch (Exception unused5) {
                fileInputStream = null;
            } catch (Throwable th2) {
                th = th2;
            }
        }
        return null;
    }

    public static byte[] fileToBytes(String str, int i, int i2) {
        return fileToBytes(new File(str), i, i2);
    }

    public static String fileToString(File file) {
        byte[] fileToBytes = fileToBytes(file);
        if (fileToBytes != null) {
            return new String(fileToBytes);
        }
        return null;
    }

    public static void freeFileLock(FileLock fileLock, File file) {
        if (file != null) {
            file.delete();
        }
        if (fileLock != null && fileLock.isValid()) {
            try {
                fileLock.release();
            } catch (IOException unused) {
            }
        }
    }

    public static String getDirPathInPrivate(Context context, String str) {
        return context.getDir(str, 0).getAbsolutePath() + File.separator;
    }

    public static Exception getLastException() {
        WeakReference<Exception> weakReference = exReference;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public static String getPathName(String str) {
        return str.substring(str.lastIndexOf(File.separator) + 1, str.length());
    }

    public static long getROMLeft() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getAbsolutePath());
        long blockSize = statFs.getBlockSize();
        statFs.getBlockCount();
        return statFs.getAvailableBlocks() * blockSize;
    }

    public static long getSDLeftSpace() {
        if (isSDMounted()) {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory() + File.separator);
            return statFs.getAvailableBlocks() * statFs.getBlockSize();
        }
        return 0L;
    }

    public static String getSDPath() {
        File externalStorageDirectory = Environment.getExternalStorageState().equals("mounted") ? Environment.getExternalStorageDirectory() : null;
        return externalStorageDirectory != null ? externalStorageDirectory.toString() : "";
    }

    public static String getSDRoot() {
        return Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator;
    }

    public static String getSoPath(Context context) {
        return context.getApplicationInfo().dataDir + "/lib/";
    }

    public static List<String> getVideoFileName(String str) {
        ArrayList arrayList = new ArrayList();
        File[] listFiles = new File(str).listFiles();
        if (listFiles != null) {
            for (int i = 0; i < listFiles.length; i++) {
                if (!listFiles[i].isDirectory()) {
                    String name = listFiles[i].getName();
                    if (name.trim().toLowerCase().endsWith(".mp4")) {
                        arrayList.add(name);
                    }
                }
            }
        }
        return arrayList;
    }

    public static boolean isFileExist(String str) {
        return new File(str).exists();
    }

    public static boolean isSDAvailable() {
        if (isSDMounted()) {
            File externalStorageDirectory = Environment.getExternalStorageDirectory();
            return externalStorageDirectory.canRead() && externalStorageDirectory.canWrite();
        }
        return false;
    }

    public static boolean isSDAvailable(int i) {
        return isSDAvailable() && getSDLeftSpace() >= (((long) i) * 1024) * 1024;
    }

    public static boolean isSDMounted() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    public static List<String> listPath(String str) {
        ArrayList arrayList = new ArrayList();
        SecurityManager securityManager = new SecurityManager();
        File file = new File(str);
        securityManager.checkRead(str);
        if (file.isDirectory() && file.listFiles() != null) {
            File[] listFiles = file.listFiles();
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    arrayList.add(file2.getAbsolutePath());
                }
            }
        }
        return arrayList;
    }

    public static void printLastException() {
        Exception lastException = getLastException();
        if (lastException != null) {
            lastException.printStackTrace();
        }
    }

    public static boolean reNamePath(String str, String str2) {
        return new File(str).renameTo(new File(str2));
    }

    public static int removeDir(File file) {
        File[] listFiles;
        if (file.exists()) {
            if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
                for (File file2 : listFiles) {
                    if (file2.isDirectory()) {
                        removeDir(file2);
                    } else {
                        file2.delete();
                    }
                }
            }
            return file.delete() ? 0 : -1;
        }
        return 0;
    }

    public static int removeDir(String str) {
        return removeDir(new File(str));
    }

    private static void setLastException(Exception exc) {
        exReference = new WeakReference<>(exc);
    }

    public static int setPermissions(String str, int i) {
        return setPermissions(str, i, -1, -1);
    }

    public static int setPermissions(String str, int i, int i2, int i3) {
        try {
            Method declaredMethod = Class.forName("android.os.FileUtils").getDeclaredMethod("setPermissions", SIG_SET_PERMISSION);
            declaredMethod.setAccessible(true);
            return ((Integer) declaredMethod.invoke(null, str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3))).intValue();
        } catch (Exception unused) {
            return -1;
        }
    }

    public static ByteArrayOutputStream streamToByteArray(InputStream inputStream) {
        try {
            byte[] bArr = new byte[256];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    return byteArrayOutputStream;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
        } catch (Exception e) {
            setLastException(e);
            return null;
        }
    }

    public static int streamToFile(File file, InputStream inputStream, boolean z) {
        FileOutputStream fileOutputStream;
        checkParentPath(file);
        FileOutputStream fileOutputStream2 = null;
        try {
            fileOutputStream = new FileOutputStream(file, z);
        } catch (Exception unused) {
        } catch (Throwable th) {
            th = th;
        }
        try {
            byte[] bArr = new byte[32768];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                fileOutputStream.write(bArr, 0, read);
            }
            fileOutputStream.flush();
            try {
                fileOutputStream.close();
            } catch (Exception unused2) {
            }
            return 0;
        } catch (Exception unused3) {
            fileOutputStream2 = fileOutputStream;
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (Exception unused4) {
                }
            }
            return -1;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (Exception unused5) {
                }
            }
            throw th;
        }
    }

    public static int streamToFile(String str, InputStream inputStream, boolean z) {
        return streamToFile(new File(str), inputStream, z);
    }

    public static String streamToString(InputStream inputStream) {
        ByteArrayOutputStream streamToByteArray = streamToByteArray(inputStream);
        if (streamToByteArray != null) {
            return streamToByteArray.toString();
        }
        return null;
    }

    public static int stringToFile(File file, String str) {
        return bytesToFile(file, str.getBytes());
    }

    public static FileLock tryFileLock(File file) {
        try {
            checkParentPath(file);
            FileLock tryLock = new FileOutputStream(file).getChannel().tryLock();
            if (tryLock != null) {
                if (tryLock.isValid()) {
                    return tryLock;
                }
                return null;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public static FileLock tryFileLock(String str) {
        return tryFileLock(new File(str));
    }
}
