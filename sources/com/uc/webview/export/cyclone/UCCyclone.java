package com.uc.webview.export.cyclone;

import android.content.Context;
import android.os.Process;
import android.util.Pair;
import android.webkit.ValueCallback;
import com.android.alibaba.ip.server.FileManager;
import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import com.taobao.weex.annotation.JSMethod;
import com.uc.webview.export.cyclone.service.UCUnSevenZip;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Stack;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import org.apache.commons.lang3.StringUtils;

/* compiled from: Taobao */
@Constant
/* loaded from: classes11.dex */
public class UCCyclone {
    private static final String FILE_LIST_PREFIX = "  ";
    static final String LOG_TAG = "cyclone";
    static final boolean RELEASE_BUILD = false;
    private static final String TEMP_DEC_DIR_PREFIX = "temp_dec_";
    public static String dataFolder = "cyclone";
    public static boolean enableDebugLog = true;
    public static ValueCallback<String> loadLibraryCallback = null;
    public static String logExtraTag = "cyclone.";
    @Constant
    public static ConcurrentLinkedQueue<File> sInusedFiles = null;
    public static String serverZipTag = "7z";
    public static ValueCallback<Pair<String, HashMap<String, String>>> statCallback;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class DecFileOrign {
        public static String DecFileOrignFlag = "_dec_ori_";
        public static int Other = 1;
        public static int Sdcard = 2;
        public static int Sdcard_Share_Core = 3;
        public static int Update = 1;
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public enum MessageDigestType {
        MD5,
        SHA1,
        SHA256
    }

    public static void close(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static boolean containsFile(ArrayList<File> arrayList, File file) {
        if (file != null && arrayList != null && arrayList.size() != 0) {
            try {
                Iterator<File> it = arrayList.iterator();
                while (it.hasNext()) {
                    if (file.getCanonicalPath().equals(it.next().getCanonicalPath())) {
                        return true;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static void copy(File file, File file2) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            byte[] bArr = new byte[8192];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read > 0) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    fileOutputStream.close();
                    return;
                }
            }
        } finally {
            fileInputStream.close();
        }
    }

    static void decompress(boolean z, Context context, String str, String str2, FilenameFilter filenameFilter) throws UCKnownException {
        decompress(z, context, str, str2, "", filenameFilter);
    }

    public static synchronized boolean decompressIfNeeded(Context context, String str, File file, File file2, FilenameFilter filenameFilter, boolean z) throws UCKnownException {
        boolean decompressIfNeeded;
        synchronized (UCCyclone.class) {
            decompressIfNeeded = decompressIfNeeded(context, str, file.getAbsolutePath(), file.length(), file.lastModified(), file, file2, filenameFilter, z, DecFileOrign.Other);
        }
        return decompressIfNeeded;
    }

    static void deleteFile(File file) throws UCKnownException {
        if (!file.delete()) {
            throw new UCKnownException(1004, String.format("File [%s] delete failed.", file.getAbsolutePath()));
        }
    }

    public static void deleteUnusedFiles(Context context) {
        try {
            File dataFolder2 = getDataFolder(context);
            ConcurrentLinkedQueue<File> concurrentLinkedQueue = sInusedFiles;
            recursiveDelete(dataFolder2, true, concurrentLinkedQueue != null ? (File[]) concurrentLinkedQueue.toArray(new File[5]) : null);
        } catch (Throwable unused) {
        }
        try {
            File[] listFiles = context.getCacheDir().listFiles(new FilenameFilter() { // from class: com.uc.webview.export.cyclone.UCCyclone.1
                @Override // java.io.FilenameFilter
                public final boolean accept(File file, String str) {
                    return str.startsWith(UCCyclone.TEMP_DEC_DIR_PREFIX);
                }
            });
            if (listFiles == null || listFiles.length <= 0) {
                return;
            }
            for (File file : listFiles) {
                recursiveDelete(file, false, null);
            }
        } catch (Throwable unused2) {
        }
    }

    public static boolean detect7zFromFileName(String str) {
        return str.endsWith(".7z") || str.contains("_7z_") || str.contains("_7z");
    }

    public static boolean detectZipByFileType(String str) {
        try {
            close(new ZipFile(str));
            return true;
        } catch (Exception unused) {
            close((ZipFile) null);
            return false;
        } catch (Throwable th) {
            close((ZipFile) null);
            throw th;
        }
    }

    public static File expectCreateDirFile(File file) {
        int i = 3;
        while (!file.exists() && !file.mkdirs()) {
            int i2 = i - 1;
            if (i <= 0) {
                throw new UCKnownException(1003, String.format("Directory [%s] mkdir failed.", file.getAbsolutePath()));
            }
            i = i2;
        }
        return file;
    }

    public static File expectFile(File file, String str) throws UCKnownException {
        return expectFile(new File(file, str));
    }

    static void expectMakeDecompressFinished(String str, long j, long j2, File file, int i) throws UCKnownException {
        UCKnownException uCKnownException;
        try {
            File decompressStopFlgFile = getDecompressStopFlgFile(str, j, j2, file, false);
            if (!decompressStopFlgFile.exists() && !decompressStopFlgFile.createNewFile()) {
                throw new Exception("createNewFile return false");
            }
            try {
                File decompressStartFlgFile = getDecompressStartFlgFile(str, j, j2, file, false);
                if (decompressStartFlgFile.exists() && !decompressStartFlgFile.delete()) {
                    throw new Exception("delete File return false");
                }
                if (i == DecFileOrign.Sdcard_Share_Core) {
                    try {
                        File decompressOrignFlgFile = getDecompressOrignFlgFile(str, j, j2, file, false, i);
                        if (!decompressOrignFlgFile.exists() && !decompressOrignFlgFile.createNewFile()) {
                            throw new Exception("createNewFile return false");
                        }
                    } finally {
                    }
                }
            } catch (Throwable th) {
                throw new UCKnownException(1004, th);
            }
        } finally {
        }
    }

    static void expectMakeDecompressNotFinished(String str, long j, long j2, File file) throws UCKnownException {
        try {
            File decompressStartFlgFile = getDecompressStartFlgFile(str, j, j2, file, false);
            if (!decompressStartFlgFile.exists() && !decompressStartFlgFile.createNewFile()) {
                throw new Exception("createNewFile return false");
            }
        } catch (Throwable th) {
            throw new UCKnownException(1006, th);
        }
    }

    public static File genFile(Context context, String str, String str2, String str3, long j, String str4, byte[][] bArr, Object... objArr) throws UCKnownException, IOException {
        File dataFolder2 = getDataFolder(context);
        if (str != null && str.length() > 0) {
            dataFolder2 = expectCreateDirFile(new File(dataFolder2, str));
        }
        if (str2 == null) {
            str2 = "";
        }
        if (str3 == null) {
            str3 = "";
        }
        String str5 = str2 + String.valueOf(j) + str3;
        File file = new File(dataFolder2, str5);
        if (!file.canRead()) {
            file.delete();
        }
        long codeLength = getCodeLength(bArr);
        if (!file.exists() || file.length() != codeLength || !str4.equals(hashFileContents(file, MessageDigestType.MD5))) {
            getFile(bArr, file);
            UCLogger create = !enableDebugLog ? null : UCLogger.create("d", LOG_TAG);
            if (create != null) {
                create.print("genFile Extract new " + str5 + " to " + dataFolder2, new Throwable[0]);
            }
        }
        ConcurrentLinkedQueue<File> concurrentLinkedQueue = sInusedFiles;
        if (concurrentLinkedQueue != null) {
            concurrentLinkedQueue.add(file);
        }
        return file;
    }

    private static int getCodeLength(byte[][] bArr) {
        int i = 0;
        for (byte[] bArr2 : bArr) {
            i += bArr2.length;
        }
        return i;
    }

    @Constant
    public static File getDataFolder(Context context) throws UCKnownException {
        UCLogger create;
        try {
            if (dataFolder == null) {
                dataFolder = LOG_TAG;
            }
            File dir = context.getDir(dataFolder, 0);
            if (sInusedFiles == null) {
                synchronized (UCCyclone.class) {
                    if (sInusedFiles == null) {
                        sInusedFiles = new ConcurrentLinkedQueue<>();
                    }
                }
            }
            create = enableDebugLog ? UCLogger.create("i", LOG_TAG) : null;
            if (create != null) {
                create.print("getDataFolder: ok.", new Throwable[0]);
            }
            return dir;
        } catch (Throwable th) {
            create = enableDebugLog ? UCLogger.create("e", LOG_TAG) : null;
            if (create != null) {
                create.print("getDataFolder: from dir app_* Exception:", th);
            }
            throw new UCKnownException(1003, th);
        }
    }

    @Constant
    public static String getDecompressFileHash(File file) {
        return getDecompressSourceHash(file.getAbsolutePath(), file.length(), file.lastModified(), false);
    }

    static File getDecompressOrignFlgFile(String str, long j, long j2, File file, boolean z, int i) {
        return new File(file, getDecompressSourceHash(str, j, j2, z) + DecFileOrign.DecFileOrignFlag + Integer.toString(i));
    }

    public static String getDecompressSourceHash(String str, long j, long j2, boolean z) {
        StringBuilder sb = new StringBuilder();
        if (!z) {
            str = getSourceHash(str);
        }
        sb.append(str);
        sb.append(JSMethod.NOT_SET);
        sb.append(getSourceHash(j, j2));
        return sb.toString();
    }

    static File getDecompressStartFlgFile(String str, long j, long j2, File file, boolean z) {
        return new File(file, getDecompressSourceHash(str, j, j2, z) + "_start");
    }

    static File getDecompressStopFlgFile(String str, long j, long j2, File file, boolean z) {
        return new File(file, getDecompressSourceHash(str, j, j2, z));
    }

    @Constant
    static void getFile(byte[][] bArr, File file) throws IOException {
        BufferedOutputStream bufferedOutputStream;
        BufferedOutputStream bufferedOutputStream2 = null;
        try {
            expectCreateDirFile(file.getParentFile());
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
        } catch (Throwable th) {
            th = th;
        }
        try {
            for (byte[] bArr2 : bArr) {
                bufferedOutputStream.write(bArr2);
            }
            close(bufferedOutputStream);
        } catch (Throwable th2) {
            th = th2;
            bufferedOutputStream2 = bufferedOutputStream;
            close(bufferedOutputStream2);
            throw th;
        }
    }

    public static String getFileInfo(File file) {
        try {
            long lastModified = file.lastModified();
            long length = file.length();
            return Log.formatTime(lastModified) + " " + length + " " + lastModified + " " + file.getName();
        } catch (Throwable th) {
            return file.getName() + ", failed:" + Log.getStackTraceString(th);
        }
    }

    public static long getFolderSize(File file) {
        return getFolderSize(file, -1L);
    }

    public static String getSourceHash(String str) {
        return String.valueOf(str.hashCode()).replace('-', '_');
    }

    public static String hashFileContents(File file, MessageDigestType messageDigestType) {
        String str;
        String str2;
        BufferedInputStream bufferedInputStream;
        if (!file.isFile()) {
            return null;
        }
        if (messageDigestType == MessageDigestType.MD5) {
            str = MessageDigestAlgorithms.MD5;
            str2 = "%032x";
        } else if (messageDigestType == MessageDigestType.SHA1) {
            str = MessageDigestAlgorithms.SHA_1;
            str2 = "%040x";
        } else if (messageDigestType != MessageDigestType.SHA256) {
            return null;
        } else {
            str = MessageDigestAlgorithms.SHA_256;
            str2 = "%064x";
        }
        byte[] bArr = new byte[131072];
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str);
            bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            while (true) {
                try {
                    int read = bufferedInputStream.read(bArr, 0, 131072);
                    if (read != -1) {
                        messageDigest.update(bArr, 0, read);
                    } else {
                        close(bufferedInputStream);
                        return String.format(Locale.CHINA, str2, new BigInteger(1, messageDigest.digest()));
                    }
                } catch (Throwable th) {
                    th = th;
                    try {
                        th.printStackTrace();
                        return null;
                    } finally {
                        close(bufferedInputStream);
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            bufferedInputStream = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object invoke(Class<?> cls, String str, Class[] clsArr, Object[] objArr) throws Exception {
        return invoke(null, cls, str, clsArr, objArr);
    }

    public static boolean isDecompressFinished(File file) {
        String[] split = file.getName().split(JSMethod.NOT_SET);
        if (split.length == 2) {
            return isDecompressFinished(file.getParentFile().getName(), Long.valueOf(split[0]).longValue(), Long.valueOf(split[1]).longValue(), file, true);
        }
        return false;
    }

    public static String listAllDerivedFiles(Context context, String str) {
        StringBuilder sb = new StringBuilder();
        File dir = context.getDir(str, 0);
        if (dir == null) {
            sb.append(str + " get failed");
        } else {
            sb.append(dir.getAbsolutePath());
            listAllFiles(sb, dir, "  ");
        }
        return sb.toString();
    }

    public static void listAllFiles(StringBuilder sb, File file) {
        listAllFiles(sb, file, "  ");
    }

    public static File optimizedFileFor(String str, String str2) {
        String name = new File(str).getName();
        if (!name.endsWith(FileManager.CLASSES_DEX_SUFFIX)) {
            int lastIndexOf = name.lastIndexOf(".");
            if (lastIndexOf < 0) {
                name = name + FileManager.CLASSES_DEX_SUFFIX;
            } else {
                StringBuilder sb = new StringBuilder(lastIndexOf + 4);
                sb.append((CharSequence) name, 0, lastIndexOf);
                sb.append(FileManager.CLASSES_DEX_SUFFIX);
                name = sb.toString();
            }
        }
        return new File(str2, name);
    }

    public static void recursiveDelete(File file, boolean z, Object obj) {
        ArrayList arrayList;
        if (file.exists()) {
            if (obj != null) {
                arrayList = new ArrayList(2);
                if (obj instanceof File) {
                    arrayList.add((File) obj);
                } else if (obj instanceof File[]) {
                    Collections.addAll(arrayList, (File[]) obj);
                } else {
                    throw new UCKnownException(1010, String.format("File or File[] argument expected, but get [%s].", obj.getClass().getName()));
                }
            } else {
                arrayList = null;
            }
            UCLogger create = !enableDebugLog ? null : UCLogger.create("i", LOG_TAG);
            if (create != null) {
                create.print("recursiveDelete " + file + AVFSCacheConstants.COMMA_SEP + z + AVFSCacheConstants.COMMA_SEP + arrayList, new Throwable[0]);
            }
            ArrayList arrayList2 = new ArrayList(20);
            File[] listFiles = (z && file.isDirectory()) ? file.listFiles() : new File[]{file};
            int i = -1;
            do {
                for (File file2 : listFiles) {
                    if (arrayList == null || !containsFile(arrayList, file2)) {
                        if (file2.isDirectory()) {
                            if (file2.getName().replace(".", "").replace("/", "").replace(" ", "").length() != 0) {
                                arrayList2.add(file2);
                            }
                        } else {
                            if (create != null) {
                                create.print("recursiveDelete delete file:" + file2.getAbsolutePath(), new Throwable[0]);
                            }
                            file2.delete();
                        }
                    }
                }
                i++;
                listFiles = i < arrayList2.size() ? ((File) arrayList2.get(i)).listFiles() : null;
                if (listFiles == null) {
                    break;
                }
            } while (i < 256);
            for (int size = arrayList2.size() - 1; size >= 0; size--) {
                File file3 = (File) arrayList2.get(size);
                if (create != null) {
                    create.print("recursiveDelete delete dir:" + file3.getAbsolutePath(), new Throwable[0]);
                }
                file3.delete();
            }
        }
    }

    @Constant
    public static void stat(String str, HashMap<String, String> hashMap) {
        ValueCallback<Pair<String, HashMap<String, String>>> valueCallback = statCallback;
        if (valueCallback != null) {
            try {
                valueCallback.onReceiveValue(new Pair<>(str, hashMap));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void decompress(boolean z, Context context, String str, String str2, String str3, FilenameFilter filenameFilter) throws UCKnownException {
        IOException e;
        stat("sdk_dec", null);
        try {
            if (z) {
                UCUnSevenZip uCUnSevenZip = (UCUnSevenZip) UCService.initImpl(UCUnSevenZip.class);
                if (uCUnSevenZip != null) {
                    int deccompress = uCUnSevenZip.deccompress(context, str, str2, str3);
                    if (deccompress != 0) {
                        String failedFilePath = uCUnSevenZip.failedFilePath();
                        if (deccompress == 7 && failedFilePath != null) {
                            try {
                                if (failedFilePath.length() > 0) {
                                    new File(failedFilePath).createNewFile();
                                }
                            } catch (IOException e2) {
                                e = e2;
                            }
                        }
                        e = null;
                        String format = String.format("Error on 7z decoding: %d freeSize: %dKB 7z len: %dKB exception: %s failed file: %s inputFilePath: %s dirPath: %s", Integer.valueOf(deccompress), Long.valueOf(new File(str2).getFreeSpace() / 1024), Long.valueOf(new File(str).length() / 1024), e, failedFilePath, str, str2);
                        android.util.Log.e(LOG_TAG, format);
                        throw new UCKnownException(2001, format);
                    }
                } else {
                    throw new UCKnownException(2015, "Error on 7z decoding: no impl found.");
                }
            } else {
                stat("sdk_decz", null);
                ZipInputStream zipInputStream = new ZipInputStream(new BufferedInputStream(new FileInputStream(str)));
                BufferedOutputStream bufferedOutputStream = null;
                int i = 0;
                int i2 = 0;
                while (true) {
                    ZipEntry nextEntry = zipInputStream.getNextEntry();
                    if (nextEntry != null) {
                        byte[] bArr = new byte[4096];
                        String name = nextEntry.getName();
                        if (!name.contains("..")) {
                            if (filenameFilter != null) {
                                File file = new File(name);
                                if (!filenameFilter.accept(file.getParentFile(), file.getName())) {
                                    continue;
                                }
                            }
                            File file2 = new File(str2 + "/" + name);
                            if (!name.endsWith("/") && !name.endsWith("\\")) {
                                expectCreateDirFile(new File(file2.getParent()));
                                BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(file2), 4096);
                                while (true) {
                                    int read = zipInputStream.read(bArr, 0, 4096);
                                    if (read != -1) {
                                        bufferedOutputStream2.write(bArr, 0, read);
                                        i += read;
                                        if (i > 536870912) {
                                            throw new UCKnownException(2010, "Zip contents is too big.");
                                        }
                                    } else {
                                        bufferedOutputStream2.flush();
                                        bufferedOutputStream2.close();
                                        zipInputStream.closeEntry();
                                        i2++;
                                        if (i2 > 1024) {
                                            throw new UCKnownException(2011, "Too many files to unzip.");
                                        }
                                        bufferedOutputStream = bufferedOutputStream2;
                                    }
                                }
                            }
                            expectCreateDirFile(file2);
                        } else {
                            throw new UCKnownException(2012, String.format("Zip entry [%s] not valid.", name));
                        }
                    } else {
                        close(zipInputStream);
                        if (bufferedOutputStream != null) {
                            stat("sdk_decz_s", null);
                        } else {
                            throw new UCKnownException(2002, "No entry exists in zip file. Make sure specify a valid zip file url.");
                        }
                    }
                }
            }
            stat("sdk_dec_s", null);
        } catch (Throwable th) {
            stat("sdk_dec_e", null);
            if (th instanceof UCKnownException) {
                throw th;
            }
            throw new UCKnownException(2005, th);
        }
    }

    public static long getFolderSize(File file, long j) {
        Stack stack = new Stack();
        if (file.exists()) {
            stack.push(file);
        }
        long j2 = 0;
        while (!stack.empty()) {
            File[] listFiles = ((File) stack.pop()).listFiles();
            if (listFiles != null) {
                for (File file2 : listFiles) {
                    try {
                        String name = file2.getName();
                        if (!name.equals(".") && !name.equals("..") && !name.equals("./") && !name.equals("../")) {
                            if (file2.isDirectory() && file2.exists()) {
                                stack.push(file2);
                            } else if (file2.exists()) {
                                j2 += file2.length();
                                if (j >= 0 && j2 > j) {
                                    return j2;
                                }
                            } else {
                                continue;
                            }
                        }
                    } catch (Throwable unused) {
                    }
                }
                continue;
            }
        }
        return j2;
    }

    public static String getSourceHash(long j, long j2) {
        return j + JSMethod.NOT_SET + j2;
    }

    @Constant
    public static Object invoke(Object obj, Class<?> cls, String str, Class[] clsArr, Object[] objArr) throws Exception {
        Method method;
        try {
            method = cls.getDeclaredMethod(str, clsArr);
        } catch (Throwable unused) {
            method = cls.getMethod(str, clsArr);
        }
        return invoke(obj, cls, method, objArr);
    }

    private static void listAllFiles(StringBuilder sb, File file, String str) {
        try {
            if (!file.exists()) {
                sb.append(StringUtils.LF + str);
                sb.append(file.getName());
                sb.append(" [Not Exists]");
            } else if (file.isDirectory()) {
                sb.append(StringUtils.LF + str);
                sb.append(file.getName());
                sb.append(" [dir]");
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    String str2 = str + "  ";
                    for (File file2 : listFiles) {
                        if (file2.isDirectory()) {
                            listAllFiles(sb, file2, str2);
                        } else {
                            sb.append(StringUtils.LF + str2);
                            sb.append(getFileInfo(file2));
                        }
                    }
                }
            } else {
                sb.append(StringUtils.LF + str);
                sb.append(getFileInfo(file));
            }
        } catch (Throwable th) {
            sb.append("listAllFiles failed:" + Log.getStackTraceString(th));
        }
    }

    public static void close(ZipFile zipFile) {
        if (zipFile != null) {
            try {
                zipFile.close();
            } catch (Exception unused) {
            }
        }
    }

    public static synchronized boolean decompressIfNeeded(Context context, boolean z, File file, File file2, FilenameFilter filenameFilter, boolean z2) throws UCKnownException {
        boolean decompressIfNeeded;
        synchronized (UCCyclone.class) {
            decompressIfNeeded = decompressIfNeeded(context, z, file.getAbsolutePath(), file.length(), file.lastModified(), file, file2, filenameFilter, z2, DecFileOrign.Other);
        }
        return decompressIfNeeded;
    }

    public static File expectFile(String str) throws UCKnownException {
        return expectFile(new File(str));
    }

    public static synchronized boolean decompressIfNeeded(Context context, boolean z, File file, File file2, FilenameFilter filenameFilter, boolean z2, int i) throws UCKnownException {
        boolean decompressIfNeeded;
        synchronized (UCCyclone.class) {
            decompressIfNeeded = decompressIfNeeded(context, z, file.getAbsolutePath(), file.length(), file.lastModified(), file, file2, filenameFilter, z2, i);
        }
        return decompressIfNeeded;
    }

    public static File expectFile(File file) throws UCKnownException {
        if (file.exists()) {
            if (file.canRead()) {
                return file;
            }
            throw new UCKnownException(1016, String.format("File [%s] cannot read.", file.getAbsolutePath()));
        }
        throw new UCKnownException(1001, String.format("File [%s] not exists.", file.getAbsolutePath()));
    }

    @Constant
    public static Object invoke(Object obj, Class<?> cls, Method method, Object[] objArr) throws Exception {
        method.setAccessible(true);
        try {
            return method.invoke(obj, objArr);
        } catch (InvocationTargetException e) {
            Throwable targetException = e.getTargetException();
            if (!(targetException instanceof Exception)) {
                if (targetException instanceof Error) {
                    throw ((Error) targetException);
                }
                throw new RuntimeException(targetException);
            }
            throw ((Exception) targetException);
        }
    }

    public static synchronized boolean decompressIfNeeded(Context context, boolean z, String str, long j, long j2, File file, File file2, FilenameFilter filenameFilter, boolean z2, int i) throws UCKnownException {
        boolean decompressIfNeeded;
        synchronized (UCCyclone.class) {
            decompressIfNeeded = decompressIfNeeded(context, z ? serverZipTag : "", str, j, j2, file, file2, filenameFilter, z2, i);
        }
        return decompressIfNeeded;
    }

    static boolean isDecompressFinished(String str, long j, long j2, File file, boolean z) {
        return getDecompressStopFlgFile(str, j, j2, file, z).exists() && !getDecompressStartFlgFile(str, j, j2, file, z).exists();
    }

    public static synchronized boolean decompressIfNeeded(Context context, String str, String str2, long j, long j2, File file, File file2, FilenameFilter filenameFilter, boolean z, int i) throws UCKnownException {
        File file3;
        boolean z2;
        synchronized (UCCyclone.class) {
            if (isDecompressFinished(str2, j, j2, file2, false)) {
                return false;
            }
            if (file.exists()) {
                while (true) {
                    file3 = new File(context.getCacheDir(), TEMP_DEC_DIR_PREFIX + Process.myPid() + JSMethod.NOT_SET + Process.myTid() + JSMethod.NOT_SET + String.valueOf(System.currentTimeMillis()));
                    if (!file3.exists()) {
                        break;
                    }
                }
                expectCreateDirFile(file3);
                if (str != null && str.length() > 0) {
                    z2 = serverZipTag.equalsIgnoreCase(str);
                } else {
                    z2 = !detectZipByFileType(file.getAbsolutePath());
                }
                System.currentTimeMillis();
                decompress(z2, context, file.getAbsolutePath(), file3.getAbsolutePath(), filenameFilter);
                expectMakeDecompressNotFinished(str2, j, j2, file2);
                File[] listFiles = file3.listFiles();
                if (listFiles != null) {
                    for (File file4 : listFiles) {
                        if (file4.getName().replace(".", "").replace("/", "").replace(" ", "").length() != 0) {
                            File file5 = new File(file2, file4.getName());
                            if (file5.exists()) {
                                if (file5.isDirectory()) {
                                    recursiveDelete(file5, false, null);
                                } else if (!file5.delete()) {
                                    throw new UCKnownException(1004, String.format("File [%s] delete failed.", file5));
                                }
                            }
                            if (!file4.renameTo(file5)) {
                                throw new UCKnownException(1005, String.format("File [%s] renameTo [%s] failed.", file4, file5));
                            }
                        }
                    }
                    expectMakeDecompressFinished(str2, j, j2, file2, i);
                    recursiveDelete(file3, false, null);
                    if (z) {
                        deleteFile(file);
                    }
                    return true;
                }
                throw new UCKnownException(2008, String.format("Zip [%s] decompress success but no items found.", file));
            }
            throw new UCKnownException(1001, String.format("File [%s] not exists.", file.getAbsolutePath()));
        }
    }
}
