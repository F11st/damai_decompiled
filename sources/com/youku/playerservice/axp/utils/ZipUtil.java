package com.youku.playerservice.axp.utils;

import android.util.Log;
import com.youku.playerservice.axp.modules.tlog.TLogUploader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class ZipUtil {
    public static void delete(File file) {
        File[] listFiles;
        if (file.isDirectory() && file.exists() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                delete(file2);
            }
        }
        file.delete();
    }

    public static long getFolderSize(File file) {
        long j = 0;
        try {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (int i = 0; i < listFiles.length; i++) {
                    j += listFiles[i].isDirectory() ? getFolderSize(listFiles[i]) : listFiles[i].length();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return j;
    }

    private static void zipFiles(File file, ZipOutputStream zipOutputStream) {
        try {
            if (!file.isFile()) {
                File[] listFiles = file.listFiles();
                if (listFiles == null || listFiles.length <= 0) {
                    TLogUtil.loge(TLogUploader.TAG, "文件夹中没有文件");
                    return;
                }
                for (File file2 : listFiles) {
                    zipFiles(file2, zipOutputStream);
                }
                return;
            }
            ZipEntry zipEntry = new ZipEntry(file.getName());
            FileInputStream fileInputStream = new FileInputStream(file);
            zipOutputStream.putNextEntry(zipEntry);
            byte[] bArr = new byte[4096];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read == -1) {
                    zipOutputStream.closeEntry();
                    fileInputStream.close();
                    return;
                }
                zipOutputStream.write(bArr, 0, read);
            }
        } catch (Exception e) {
            TLogUtil.loge(TLogUploader.TAG, "zip files fail " + Log.getStackTraceString(e));
        }
    }

    public static void zipFolder(String str, String str2) {
        try {
            File file = new File(str);
            if (!file.exists()) {
                TLogUtil.loge(TLogUploader.TAG, "需要打包的文件不存在");
            }
            ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(new File(str2)));
            zipFiles(file, zipOutputStream);
            zipOutputStream.finish();
            zipOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
            TLogUtil.loge(TLogUploader.TAG, "zip fail " + Log.getStackTraceString(e));
        }
    }
}
