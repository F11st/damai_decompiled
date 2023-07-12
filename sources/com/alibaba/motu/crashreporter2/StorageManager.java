package com.alibaba.motu.crashreporter2;

import android.content.Context;
import com.alibaba.motu.tbrest.utils.StringUtils;
import java.io.File;
import java.io.FileFilter;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
final class StorageManager {
    final Context mContext;
    final String mProcessName;
    final File mProcessTombstoneDir;
    final String mProcessTombstoneDirPath;
    final File mTombstoneDir;
    final String mTombstoneDirPath;

    /* JADX INFO: Access modifiers changed from: package-private */
    public StorageManager(Context context, String str) {
        this.mContext = context;
        File dir = context.getDir("tombstone", 0);
        this.mTombstoneDir = dir;
        String absolutePath = dir.getAbsolutePath();
        this.mTombstoneDirPath = absolutePath;
        String str2 = absolutePath + File.separator + str;
        this.mProcessTombstoneDirPath = str2;
        File file = new File(str2);
        this.mProcessTombstoneDir = file;
        this.mProcessName = str;
        if (file.exists() && file.isFile()) {
            file.delete();
        }
        file.mkdirs();
    }

    public File getProcessTombstoneFile(String str) {
        if (!StringUtils.isBlank(str)) {
            String str2 = File.separator;
            if (!str.contains(str2)) {
                return new File(this.mProcessTombstoneDirPath + str2 + str);
            }
        }
        throw new IllegalArgumentException("file name can't not empty or contains " + File.separator);
    }

    public File[] listProcessTombstoneFiles(FileFilter fileFilter) {
        return this.mProcessTombstoneDir.listFiles(fileFilter);
    }

    StorageManager(Context context, String str, String str2) {
        this.mContext = context;
        this.mTombstoneDirPath = str;
        this.mTombstoneDir = new File(str);
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(File.separator);
        sb.append(StringUtils.isNotBlank(str2) ? str2 : "DEFAULT");
        String sb2 = sb.toString();
        this.mProcessTombstoneDirPath = sb2;
        File file = new File(sb2);
        this.mProcessTombstoneDir = file;
        if (file.exists() && file.isFile()) {
            file.delete();
        }
        file.mkdirs();
        this.mProcessName = str2;
    }
}
