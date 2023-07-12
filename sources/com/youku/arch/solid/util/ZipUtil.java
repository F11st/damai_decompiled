package com.youku.arch.solid.util;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class ZipUtil {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final int BUFFER_LEN = 8192;

    public static boolean createOrExistsDir(File file) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1831743113")) {
            return ((Boolean) ipChange.ipc$dispatch("-1831743113", new Object[]{file})).booleanValue();
        }
        if (file != null) {
            if (file.exists()) {
                if (!file.isDirectory()) {
                    return false;
                }
            } else if (!file.mkdirs()) {
                return false;
            }
            return true;
        }
        return false;
    }

    public static boolean createOrExistsFile(File file) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-678455680")) {
            return ((Boolean) ipChange.ipc$dispatch("-678455680", new Object[]{file})).booleanValue();
        }
        if (file == null) {
            return false;
        }
        if (file.exists()) {
            return file.isFile();
        }
        if (createOrExistsDir(file.getParentFile())) {
            try {
                return file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }

    private static boolean unzipChildFile(File file, Map<String, File> map, ZipFile zipFile, ZipEntry zipEntry, String str) throws IOException {
        BufferedOutputStream bufferedOutputStream;
        Throwable th;
        BufferedInputStream bufferedInputStream;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1551730894")) {
            return ((Boolean) ipChange.ipc$dispatch("1551730894", new Object[]{file, map, zipFile, zipEntry, str})).booleanValue();
        }
        File file2 = new File(file, str);
        map.put(file2.getName(), file2);
        if (zipEntry.isDirectory()) {
            return createOrExistsDir(file2);
        }
        if (!createOrExistsFile(file2)) {
            return false;
        }
        try {
            bufferedInputStream = new BufferedInputStream(zipFile.getInputStream(zipEntry));
            try {
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2));
                try {
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int read = bufferedInputStream.read(bArr);
                        if (read != -1) {
                            bufferedOutputStream.write(bArr, 0, read);
                        } else {
                            bufferedInputStream.close();
                            bufferedOutputStream.close();
                            return true;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (bufferedInputStream != null) {
                        bufferedInputStream.close();
                    }
                    if (bufferedOutputStream != null) {
                        bufferedOutputStream.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                bufferedOutputStream = null;
                th = th3;
            }
        } catch (Throwable th4) {
            bufferedOutputStream = null;
            th = th4;
            bufferedInputStream = null;
        }
    }

    public static Map<String, File> unzipFileByKeyword(File file, File file2, String str) throws IOException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2140079749")) {
            return (Map) ipChange.ipc$dispatch("-2140079749", new Object[]{file, file2, str});
        }
        if (file == null || file2 == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        ZipFile zipFile = new ZipFile(file);
        Enumeration<? extends ZipEntry> entries = zipFile.entries();
        try {
            if (TextUtils.isEmpty(str)) {
                while (entries.hasMoreElements()) {
                    ZipEntry nextElement = entries.nextElement();
                    if (!unzipChildFile(file2, hashMap, zipFile, nextElement, nextElement.getName().replace("\\", "/"))) {
                        return hashMap;
                    }
                }
            } else {
                while (entries.hasMoreElements()) {
                    ZipEntry nextElement2 = entries.nextElement();
                    String replace = nextElement2.getName().replace("\\", "/");
                    if (replace.contains(str) && !unzipChildFile(file2, hashMap, zipFile, nextElement2, replace)) {
                        return hashMap;
                    }
                }
            }
            return hashMap;
        } finally {
            zipFile.close();
        }
    }
}
