package com.youku.arch.v3.util;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class FileUtil {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String TAG = "OneArch.FileUtil";
    private static String mSeparator = File.separator;
    private static char mSeparatorChar = File.separatorChar;

    public static synchronized int clearFolder(String str, long j) {
        synchronized (FileUtil.class) {
            IpChange ipChange = $ipChange;
            int i = 0;
            if (AndroidInstantRuntime.support(ipChange, "-1875557543")) {
                return ((Integer) ipChange.ipc$dispatch("-1875557543", new Object[]{str, Long.valueOf(j)})).intValue();
            }
            if (!TextUtils.isEmpty(str)) {
                i = clearFolder(new File(str), j);
            }
            return i;
        }
    }

    public static int clearFolderNoSynchronized(File file, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "581912545")) {
            return ((Integer) ipChange.ipc$dispatch("581912545", new Object[]{file, Long.valueOf(j)})).intValue();
        }
        long currentTimeMillis = System.currentTimeMillis() - j;
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            int i = 0;
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    i += clearFolder(file2, j);
                }
                if (file2.lastModified() < currentTimeMillis && file2.delete()) {
                    i++;
                }
            }
            return i;
        }
        return 0;
    }

    public static void closeQuietly(Closeable closeable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1847702425")) {
            ipChange.ipc$dispatch("1847702425", new Object[]{closeable});
        } else if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }

    public static boolean copy(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1491919522")) {
            return ((Boolean) ipChange.ipc$dispatch("-1491919522", new Object[]{str, str2})).booleanValue();
        }
        if (str != null && str2 != null) {
            FileInputStream fileInputStream = null;
            try {
                FileInputStream fileInputStream2 = new FileInputStream(str2);
                try {
                    return store(fileInputStream2, str);
                } catch (FileNotFoundException e) {
                    e = e;
                    fileInputStream = fileInputStream2;
                    e.printStackTrace();
                    try {
                        fileInputStream.close();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    return false;
                }
            } catch (FileNotFoundException e3) {
                e = e3;
            }
        } else {
            throw new NullPointerException("path should not be null.");
        }
    }

    public static void copyFile(String str, String str2) {
        FileOutputStream fileOutputStream;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1158171582")) {
            ipChange.ipc$dispatch("1158171582", new Object[]{str, str2});
            return;
        }
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(str);
            try {
                fileOutputStream = new FileOutputStream(str2);
            } catch (Exception unused) {
                fileOutputStream = null;
            } catch (Throwable th) {
                th = th;
                fileOutputStream = null;
            }
            try {
                copyFile(fileInputStream2, fileOutputStream);
                fileOutputStream.flush();
                closeQuietly(fileInputStream2);
            } catch (Exception unused2) {
                fileInputStream = fileInputStream2;
                closeQuietly(fileInputStream);
                closeQuietly(fileOutputStream);
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = fileInputStream2;
                closeQuietly(fileInputStream);
                closeQuietly(fileOutputStream);
                throw th;
            }
        } catch (Exception unused3) {
            fileOutputStream = null;
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
        }
        closeQuietly(fileOutputStream);
    }

    public static synchronized File createFile(String str) {
        synchronized (FileUtil.class) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2083553376")) {
                return (File) ipChange.ipc$dispatch("2083553376", new Object[]{str});
            } else if (TextUtils.isEmpty(str)) {
                return null;
            } else {
                File file = new File(str);
                if (file.isFile()) {
                    return file;
                }
                File parentFile = file.getParentFile();
                if (parentFile != null && (parentFile.isDirectory() || parentFile.mkdirs())) {
                    try {
                        if (file.createNewFile()) {
                            return file;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                return null;
            }
        }
    }

    public static synchronized File createFolder(String str) {
        synchronized (FileUtil.class) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1352869202")) {
                return (File) ipChange.ipc$dispatch("1352869202", new Object[]{str});
            }
            File file = null;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            File file2 = new File(str);
            if (file2.isDirectory() || file2.mkdirs()) {
                file = file2;
            }
            return file;
        }
    }

    public static synchronized boolean delete(String str) {
        synchronized (FileUtil.class) {
            IpChange ipChange = $ipChange;
            boolean z = false;
            if (AndroidInstantRuntime.support(ipChange, "345709982")) {
                return ((Boolean) ipChange.ipc$dispatch("345709982", new Object[]{str})).booleanValue();
            }
            if (!TextUtils.isEmpty(str) && delete(new File(str))) {
                z = true;
            }
            return z;
        }
    }

    public static void deleteAllFile(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "46203783")) {
            ipChange.ipc$dispatch("46203783", new Object[]{str});
            return;
        }
        try {
            File file = new File(str);
            if (file.exists()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null && listFiles.length != 0) {
                    for (int i = 0; i < listFiles.length; i++) {
                        if (listFiles[i].isDirectory()) {
                            deleteAllFile(listFiles[i].getAbsolutePath());
                            listFiles[i].delete();
                        } else {
                            listFiles[i].delete();
                        }
                    }
                    return;
                }
                file.delete();
            }
        } catch (Exception unused) {
        }
    }

    public static void deleteFile(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1493317634")) {
            ipChange.ipc$dispatch("-1493317634", new Object[]{str});
            return;
        }
        File file = new File(str);
        if (file.exists()) {
            file.delete();
        }
    }

    public static boolean deleteNoSynchronized(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "409491433") ? ((Boolean) ipChange.ipc$dispatch("409491433", new Object[]{str})).booleanValue() : !TextUtils.isEmpty(str) && deleteNoSynchronized(new File(str));
    }

    public static boolean exists(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "132282253") ? ((Boolean) ipChange.ipc$dispatch("132282253", new Object[]{str})).booleanValue() : !TextUtils.isEmpty(str) && new File(str).exists();
    }

    public static boolean fileExists(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "138951025")) {
            return ((Boolean) ipChange.ipc$dispatch("138951025", new Object[]{str})).booleanValue();
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File file = new File(str);
        return file.exists() && file.isFile();
    }

    public static long fileLength(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1937657111")) {
            return ((Long) ipChange.ipc$dispatch("1937657111", new Object[]{str})).longValue();
        }
        if (fileExists(str)) {
            return new File(str).length();
        }
        return 0L;
    }

    public static boolean folderExists(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1960801857")) {
            return ((Boolean) ipChange.ipc$dispatch("-1960801857", new Object[]{str})).booleanValue();
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File file = new File(str);
        return file.exists() && file.isDirectory();
    }

    public static String getCanonicalPath(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1305103774")) {
            return (String) ipChange.ipc$dispatch("1305103774", new Object[]{str});
        }
        try {
            return new File(str).getCanonicalPath();
        } catch (IOException e) {
            e.printStackTrace();
            return str;
        }
    }

    public static String getFileExtension(String str) {
        int lastIndexOf;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-145384184")) {
            return (String) ipChange.ipc$dispatch("-145384184", new Object[]{str});
        }
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int lastIndexOf2 = str.lastIndexOf(63);
        if (lastIndexOf2 > 0) {
            str = str.substring(0, lastIndexOf2);
        }
        int lastIndexOf3 = str.lastIndexOf(47);
        if (lastIndexOf3 >= 0) {
            str = str.substring(lastIndexOf3 + 1);
        }
        return (str.length() <= 0 || (lastIndexOf = str.lastIndexOf(46)) < 0) ? "" : str.substring(lastIndexOf + 1);
    }

    public static String getFileName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1593426364")) {
            return (String) ipChange.ipc$dispatch("-1593426364", new Object[]{str});
        }
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int lastIndexOf = str.lastIndexOf(63);
        if (lastIndexOf > 0) {
            str = str.substring(0, lastIndexOf);
        }
        int lastIndexOf2 = str.lastIndexOf(mSeparatorChar);
        return lastIndexOf2 >= 0 ? str.substring(lastIndexOf2 + 1) : str;
    }

    public static String getFilePath(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1822762078")) {
            return (String) ipChange.ipc$dispatch("1822762078", new Object[]{str});
        }
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int lastIndexOf = (str == null || !str.startsWith(mSeparator)) ? -1 : str.lastIndexOf(mSeparatorChar);
        return lastIndexOf == -1 ? mSeparator : str.substring(0, lastIndexOf);
    }

    public static String getFileShortName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-687183888")) {
            return (String) ipChange.ipc$dispatch("-687183888", new Object[]{str});
        }
        String fileName = getFileName(str);
        int lastIndexOf = fileName.lastIndexOf(46);
        return lastIndexOf > 0 ? fileName.substring(0, lastIndexOf) : fileName;
    }

    public static synchronized long getFileSize(String str) {
        synchronized (FileUtil.class) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "460057114")) {
                return ((Long) ipChange.ipc$dispatch("460057114", new Object[]{str})).longValue();
            }
            return TextUtils.isEmpty(str) ? 0L : getFileSize(new File(str));
        }
    }

    public static Uri getResourceUri(Context context, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-469424955")) {
            return (Uri) ipChange.ipc$dispatch("-469424955", new Object[]{context, Integer.valueOf(i)});
        }
        return Uri.parse("android.resource://" + context.getPackageName() + "/" + i);
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x005d, code lost:
        if (exists(r6 + r5 + r0) != false) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean isSamePhysicalPath(java.lang.String r5, java.lang.String r6) {
        /*
            com.android.alibaba.ip.runtime.IpChange r0 = com.youku.arch.v3.util.FileUtil.$ipChange
            java.lang.String r1 = "-1905657"
            boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L1e
            r2 = 2
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r2[r4] = r5
            r2[r3] = r6
            java.lang.Object r5 = r0.ipc$dispatch(r1, r2)
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r5 = r5.booleanValue()
            return r5
        L1e:
            long r0 = java.lang.System.currentTimeMillis()
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r5)
            java.lang.String r5 = java.io.File.separator
            r1.append(r5)
            java.lang.String r2 = r0.toString()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            createFile(r1)
            boolean r2 = exists(r1)
            if (r2 == 0) goto L60
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r6)
            r2.append(r5)
            r2.append(r0)
            java.lang.String r5 = r2.toString()
            boolean r5 = exists(r5)
            if (r5 == 0) goto L60
            goto L61
        L60:
            r3 = 0
        L61:
            delete(r1)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youku.arch.v3.util.FileUtil.isSamePhysicalPath(java.lang.String, java.lang.String):boolean");
    }

    public static long lastModified(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "746186682")) {
            return ((Long) ipChange.ipc$dispatch("746186682", new Object[]{str})).longValue();
        }
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        return new File(str).lastModified();
    }

    public static String load(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1152333887")) {
            return (String) ipChange.ipc$dispatch("-1152333887", new Object[]{str});
        }
        Objects.requireNonNull(str, "path should not be null.");
        String str2 = null;
        try {
            str2 = stringFromInputStream(new FileInputStream(str));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str2 != null ? str2 : "";
    }

    public static byte[] readFile(String str) {
        Throwable th;
        FileInputStream fileInputStream;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "377011018")) {
            return (byte[]) ipChange.ipc$dispatch("377011018", new Object[]{str});
        }
        if (str == null) {
            return null;
        }
        File file = new File(str);
        if (file.exists()) {
            try {
                fileInputStream = new FileInputStream(file);
            } catch (Exception unused) {
                fileInputStream = null;
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = null;
            }
            try {
                byte[] byteArray = toByteArray(fileInputStream);
                try {
                    fileInputStream.close();
                } catch (Exception unused2) {
                }
                return byteArray;
            } catch (Exception unused3) {
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Exception unused4) {
                    }
                }
                return null;
            } catch (Throwable th3) {
                th = th3;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Exception unused5) {
                    }
                }
                throw th;
            }
        }
        return null;
    }

    public static String readFileFromAssets(Context context, String str) {
        InputStream inputStream;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "695400362")) {
            return (String) ipChange.ipc$dispatch("695400362", new Object[]{context, str});
        }
        AssetManager assets = context.getAssets();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        InputStream inputStream2 = null;
        try {
            inputStream = assets.open(str);
            try {
                byte[] bArr = new byte[2048];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read != -1) {
                        byteArrayOutputStream.write(bArr, 0, read);
                    } else {
                        String str2 = new String(byteArrayOutputStream.toByteArray(), "UTF-8");
                        closeQuietly(inputStream);
                        closeQuietly(byteArrayOutputStream);
                        return str2;
                    }
                }
            } catch (IOException unused) {
                closeQuietly(inputStream);
                closeQuietly(byteArrayOutputStream);
                return null;
            } catch (Throwable th) {
                th = th;
                inputStream2 = inputStream;
                closeQuietly(inputStream2);
                closeQuietly(byteArrayOutputStream);
                throw th;
            }
        } catch (IOException unused2) {
            inputStream = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String readFileFromRaw(Context context, int i) {
        BufferedReader bufferedReader;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1825375070")) {
            return (String) ipChange.ipc$dispatch("-1825375070", new Object[]{context, Integer.valueOf(i)});
        }
        InputStreamReader inputStreamReader = null;
        try {
            InputStreamReader inputStreamReader2 = new InputStreamReader(context.getResources().openRawResource(i));
            try {
                bufferedReader = new BufferedReader(inputStreamReader2);
                String str = "";
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine != null) {
                            str = str + readLine;
                        } else {
                            closeQuietly(inputStreamReader2);
                            closeQuietly(bufferedReader);
                            return str;
                        }
                    } catch (Exception e) {
                        e = e;
                        inputStreamReader = inputStreamReader2;
                        try {
                            e.printStackTrace();
                            closeQuietly(inputStreamReader);
                            closeQuietly(bufferedReader);
                            return "";
                        } catch (Throwable th) {
                            th = th;
                            closeQuietly(inputStreamReader);
                            closeQuietly(bufferedReader);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        inputStreamReader = inputStreamReader2;
                        closeQuietly(inputStreamReader);
                        closeQuietly(bufferedReader);
                        throw th;
                    }
                }
            } catch (Exception e2) {
                e = e2;
                bufferedReader = null;
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
            }
        } catch (Exception e3) {
            e = e3;
            bufferedReader = null;
        } catch (Throwable th4) {
            th = th4;
            bufferedReader = null;
        }
    }

    public static boolean rename(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "361321461")) {
            return ((Boolean) ipChange.ipc$dispatch("361321461", new Object[]{str, str2})).booleanValue();
        }
        File file = new File(str);
        return file.isFile() && file.renameTo(new File(str2));
    }

    public static void setSeparatorChar(char c) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2083640293")) {
            ipChange.ipc$dispatch("-2083640293", new Object[]{Character.valueOf(c)});
            return;
        }
        mSeparatorChar = c;
        mSeparator = String.valueOf(c);
    }

    public static synchronized boolean store(String str, String str2) {
        synchronized (FileUtil.class) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "284468838")) {
                return ((Boolean) ipChange.ipc$dispatch("284468838", new Object[]{str, str2})).booleanValue();
            }
            return store(str, str2, false);
        }
    }

    public static boolean storeNoSynchronized(InputStream inputStream, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2051633320")) {
            return ((Boolean) ipChange.ipc$dispatch("2051633320", new Object[]{inputStream, str})).booleanValue();
        }
        Objects.requireNonNull(str, "filePath should not be null.");
        FileOutputStream fileOutputStream = null;
        try {
            try {
                File createFile = createFile(str);
                if (createFile == null) {
                    Log.d("FileUtils", String.format("inputStream sotreFile == null filePath=%s", str));
                    try {
                        inputStream.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return false;
                }
                byte[] bArr = new byte[4096];
                FileOutputStream fileOutputStream2 = new FileOutputStream(createFile);
                while (true) {
                    try {
                        int read = inputStream.read(bArr);
                        if (read > 0) {
                            fileOutputStream2.write(bArr, 0, read);
                        } else {
                            try {
                                break;
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                    } catch (Exception e3) {
                        e = e3;
                        fileOutputStream = fileOutputStream2;
                        e.printStackTrace();
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e4) {
                                e4.printStackTrace();
                            }
                        }
                        try {
                            inputStream.close();
                        } catch (Exception e5) {
                            e5.printStackTrace();
                        }
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream = fileOutputStream2;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e6) {
                                e6.printStackTrace();
                            }
                        }
                        try {
                            inputStream.close();
                        } catch (Exception e7) {
                            e7.printStackTrace();
                        }
                        throw th;
                    }
                }
                fileOutputStream2.close();
                try {
                    inputStream.close();
                } catch (Exception e8) {
                    e8.printStackTrace();
                }
                return true;
            } catch (Exception e9) {
                e = e9;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String stringFromInputStream(InputStream inputStream) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1648332621")) {
            return (String) ipChange.ipc$dispatch("1648332621", new Object[]{inputStream});
        }
        try {
            try {
                try {
                    try {
                        byte[] bArr = new byte[4096];
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        while (true) {
                            int read = inputStream.read(bArr, 0, 4096);
                            if (read <= 0) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr, 0, read);
                        }
                        String byteArrayOutputStream2 = byteArrayOutputStream.toString("UTF-8");
                        try {
                            inputStream.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        return byteArrayOutputStream2;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        inputStream.close();
                        return null;
                    }
                } catch (OutOfMemoryError e3) {
                    e3.printStackTrace();
                    inputStream.close();
                    return null;
                }
            } catch (Exception e4) {
                e4.printStackTrace();
                return null;
            }
        } catch (Throwable th) {
            try {
                inputStream.close();
            } catch (Exception e5) {
                e5.printStackTrace();
            }
            throw th;
        }
    }

    public static byte[] toByteArray(InputStream inputStream) throws IOException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1879123843")) {
            return (byte[]) ipChange.ipc$dispatch("1879123843", new Object[]{inputStream});
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[100];
        while (true) {
            int read = inputStream.read(bArr, 0, 100);
            if (read > 0) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    public static boolean updateFileLastModified(String str, long j) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1547278343") ? ((Boolean) ipChange.ipc$dispatch("1547278343", new Object[]{str, Long.valueOf(j)})).booleanValue() : fileExists(str) && new File(str).setLastModified(j);
    }

    public static String validateFileName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1489811464")) {
            return (String) ipChange.ipc$dispatch("-1489811464", new Object[]{str});
        }
        if (str == null) {
            return null;
        }
        return str.replaceAll("([{/\\\\:*?\"<>|}\\u0000-\\u001f\\uD7B0-\\uFFFF]+)", "");
    }

    public static boolean writeFile(String str, byte[] bArr) {
        FileOutputStream fileOutputStream;
        Throwable th;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-108526071")) {
            return ((Boolean) ipChange.ipc$dispatch("-108526071", new Object[]{str, bArr})).booleanValue();
        }
        if (str != null && bArr != null) {
            File file = new File(str);
            FileOutputStream fileOutputStream2 = null;
            try {
                fileOutputStream = new FileOutputStream(file);
            } catch (IOException unused) {
            } catch (Throwable th2) {
                fileOutputStream = null;
                th = th2;
            }
            try {
                fileOutputStream.write(bArr);
                fileOutputStream.flush();
                try {
                    fileOutputStream.close();
                } catch (IOException unused2) {
                }
                return true;
            } catch (IOException unused3) {
                fileOutputStream2 = fileOutputStream;
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException unused4) {
                    }
                }
                return false;
            } catch (Throwable th3) {
                th = th3;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException unused5) {
                    }
                }
                throw th;
            }
        }
        return false;
    }

    public static synchronized void clearFolder(String str, long j, boolean z) {
        synchronized (FileUtil.class) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1987304494")) {
                ipChange.ipc$dispatch("1987304494", new Object[]{str, Long.valueOf(j), Boolean.valueOf(z)});
            } else {
                clearFolder(str, j, (String[]) null);
            }
        }
    }

    public static synchronized boolean delete(File file) {
        File[] listFiles;
        synchronized (FileUtil.class) {
            IpChange ipChange = $ipChange;
            boolean z = false;
            if (AndroidInstantRuntime.support(ipChange, "675112267")) {
                return ((Boolean) ipChange.ipc$dispatch("675112267", new Object[]{file})).booleanValue();
            }
            if (file == null) {
                return true;
            }
            if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
                for (File file2 : listFiles) {
                    if (!delete(file2)) {
                        return false;
                    }
                }
            }
            return (!file.exists() || file.delete()) ? true : true;
        }
    }

    public static boolean deleteNoSynchronized(File file) {
        File[] listFiles;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1094615786")) {
            return ((Boolean) ipChange.ipc$dispatch("-1094615786", new Object[]{file})).booleanValue();
        }
        if (file == null) {
            return true;
        }
        if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                if (!delete(file2)) {
                    return false;
                }
            }
        }
        return !file.exists() || file.delete();
    }

    public static synchronized long getFileSize(File file) {
        synchronized (FileUtil.class) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-417179705")) {
                return ((Long) ipChange.ipc$dispatch("-417179705", new Object[]{file})).longValue();
            }
            long j = 0;
            if (file == null) {
                return 0L;
            }
            if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    for (File file2 : listFiles) {
                        j += file2.isDirectory() ? getFileSize(file2) : file2.length();
                    }
                }
            } else {
                j = file.length();
            }
            return j;
        }
    }

    public static synchronized boolean store(String str, String str2, boolean z) {
        synchronized (FileUtil.class) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "228645046")) {
                return ((Boolean) ipChange.ipc$dispatch("228645046", new Object[]{str, str2, Boolean.valueOf(z)})).booleanValue();
            } else if (str2 != null) {
                BufferedWriter bufferedWriter = null;
                try {
                    try {
                        File createFile = createFile(str2);
                        if (createFile == null) {
                            Log.d("FileUtils", String.format("file == null path=%s", str2));
                            return false;
                        }
                        BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter(createFile, z));
                        if (str == null) {
                            str = "";
                        }
                        try {
                            bufferedWriter2.write(str);
                            bufferedWriter2.flush();
                            try {
                                bufferedWriter2.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            return true;
                        } catch (IOException e2) {
                            e = e2;
                            bufferedWriter = bufferedWriter2;
                            e.printStackTrace();
                            if (bufferedWriter != null) {
                                try {
                                    bufferedWriter.close();
                                } catch (IOException e3) {
                                    e3.printStackTrace();
                                }
                            }
                            return false;
                        } catch (ArrayIndexOutOfBoundsException e4) {
                            e = e4;
                            bufferedWriter = bufferedWriter2;
                            e.printStackTrace();
                            if (bufferedWriter != null) {
                                try {
                                    bufferedWriter.close();
                                } catch (IOException e5) {
                                    e5.printStackTrace();
                                }
                            }
                            return false;
                        } catch (Throwable th) {
                            th = th;
                            bufferedWriter = bufferedWriter2;
                            if (bufferedWriter != null) {
                                try {
                                    bufferedWriter.close();
                                } catch (IOException e6) {
                                    e6.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    } catch (IOException e7) {
                        e = e7;
                    } catch (ArrayIndexOutOfBoundsException e8) {
                        e = e8;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } else {
                throw new NullPointerException("path should not be null.");
            }
        }
    }

    public static synchronized void clearFolder(String str, long j, String[] strArr) {
        synchronized (FileUtil.class) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-810513415")) {
                ipChange.ipc$dispatch("-810513415", new Object[]{str, Long.valueOf(j), strArr});
                return;
            }
            long fileSize = getFileSize(str);
            if (fileSize > j) {
                List arrayList = strArr == null ? new ArrayList() : Arrays.asList(strArr);
                File[] listFiles = new File(str).listFiles();
                if (listFiles != null) {
                    List<File> asList = Arrays.asList(listFiles);
                    try {
                        Collections.sort(asList, new Comparator<File>() { // from class: com.youku.arch.v3.util.FileUtil.1
                            private static transient /* synthetic */ IpChange $ipChange;

                            @Override // java.util.Comparator
                            public int compare(File file, File file2) {
                                IpChange ipChange2 = $ipChange;
                                if (AndroidInstantRuntime.support(ipChange2, "-284594818")) {
                                    return ((Integer) ipChange2.ipc$dispatch("-284594818", new Object[]{this, file, file2})).intValue();
                                }
                                if (file.lastModified() == file2.lastModified()) {
                                    return 0;
                                }
                                return file.lastModified() < file2.lastModified() ? -1 : 1;
                            }
                        });
                    } catch (IllegalArgumentException e) {
                        e.printStackTrace();
                    }
                    for (File file : asList) {
                        if (fileSize <= j) {
                            break;
                        } else if (!arrayList.contains(file.getAbsolutePath())) {
                            file.lastModified();
                            fileSize -= file.length();
                            file.delete();
                        }
                    }
                }
            }
        }
    }

    public static void copyFile(InputStream inputStream, OutputStream outputStream) throws IOException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "545668699")) {
            ipChange.ipc$dispatch("545668699", new Object[]{inputStream, outputStream});
            return;
        }
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return;
            }
            outputStream.write(bArr, 0, read);
        }
    }

    public static synchronized int clearFolder(File file, long j) {
        synchronized (FileUtil.class) {
            IpChange ipChange = $ipChange;
            int i = 0;
            if (AndroidInstantRuntime.support(ipChange, "1017565004")) {
                return ((Integer) ipChange.ipc$dispatch("1017565004", new Object[]{file, Long.valueOf(j)})).intValue();
            }
            long currentTimeMillis = System.currentTimeMillis() - j;
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                int length = listFiles.length;
                int i2 = 0;
                while (i < length) {
                    File file2 = listFiles[i];
                    if (file2.isDirectory()) {
                        i2 += clearFolder(file2, j);
                    }
                    if (file2.lastModified() < currentTimeMillis && file2.delete()) {
                        i2++;
                    }
                    i++;
                }
                i = i2;
            }
            return i;
        }
    }

    public static synchronized boolean store(InputStream inputStream, String str) {
        synchronized (FileUtil.class) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-791479917")) {
                return ((Boolean) ipChange.ipc$dispatch("-791479917", new Object[]{inputStream, str})).booleanValue();
            } else if (str != null) {
                FileOutputStream fileOutputStream = null;
                try {
                    try {
                        File createFile = createFile(str);
                        if (createFile == null) {
                            Log.d("FileUtils", String.format("inputStream file == null path=%s", str));
                            try {
                                inputStream.close();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            return false;
                        }
                        byte[] bArr = new byte[4096];
                        FileOutputStream fileOutputStream2 = new FileOutputStream(createFile);
                        while (true) {
                            try {
                                int read = inputStream.read(bArr);
                                if (read > 0) {
                                    fileOutputStream2.write(bArr, 0, read);
                                } else {
                                    try {
                                        break;
                                    } catch (IOException e2) {
                                        e2.printStackTrace();
                                    }
                                }
                            } catch (Exception e3) {
                                e = e3;
                                fileOutputStream = fileOutputStream2;
                                e.printStackTrace();
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (IOException e4) {
                                        e4.printStackTrace();
                                    }
                                }
                                try {
                                    inputStream.close();
                                } catch (Exception e5) {
                                    e5.printStackTrace();
                                }
                                return false;
                            } catch (Throwable th) {
                                th = th;
                                fileOutputStream = fileOutputStream2;
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (IOException e6) {
                                        e6.printStackTrace();
                                    }
                                }
                                try {
                                    inputStream.close();
                                } catch (Exception e7) {
                                    e7.printStackTrace();
                                }
                                throw th;
                            }
                        }
                        fileOutputStream2.close();
                        try {
                            inputStream.close();
                        } catch (Exception e8) {
                            e8.printStackTrace();
                        }
                        return true;
                    } catch (Exception e9) {
                        e = e9;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } else {
                throw new NullPointerException("path should not be null.");
            }
        }
    }

    public static synchronized int clearFolder(File file) {
        synchronized (FileUtil.class) {
            IpChange ipChange = $ipChange;
            int i = 0;
            if (AndroidInstantRuntime.support(ipChange, "1972486334")) {
                return ((Integer) ipChange.ipc$dispatch("1972486334", new Object[]{file})).intValue();
            }
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                int length = listFiles.length;
                int i2 = 0;
                while (i < length) {
                    File file2 = listFiles[i];
                    if (file2.isDirectory()) {
                        i2 += clearFolder(file2);
                    }
                    if (file2.delete()) {
                        i2++;
                    }
                    i++;
                }
                i = i2;
            }
            return i;
        }
    }
}
