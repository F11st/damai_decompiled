package com.uc.webview.export.cyclone.update;

import com.uc.webview.export.cyclone.update.Utils;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class FileLocker {
    private static final String TAG = "UpdateFileLocker";
    private FileLock mCacheLock;
    private FileChannel mLockChannel;
    private File mLockFile;
    private RandomAccessFile mLockRaf;
    private Utils.LogHelper mLog;

    public FileLocker(File file, String str, Utils.LogHelper logHelper) {
        this.mLockFile = new File(file, ".ucbsup_" + str + ".lock");
        this.mLog = logHelper;
    }

    private void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e) {
                printLog("Failed to close resource", e);
            }
        }
    }

    private void printLog(String str) {
        printLog(str, null);
    }

    public void lock() {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(this.mLockFile, "rw");
            this.mLockRaf = randomAccessFile;
            if (this.mLockFile == null) {
                printLog("lock error lockRaf = " + this.mLockRaf + " lockFile = " + this.mLockFile);
                return;
            }
            this.mLockChannel = randomAccessFile.getChannel();
            printLog("Blocking on lock " + this.mLockFile.getPath());
            try {
                this.mCacheLock = this.mLockChannel.lock();
                printLog(this.mLockFile.getPath() + " locked");
            } catch (IOException e) {
                printLog("lock error ", e);
            }
        } catch (FileNotFoundException e2) {
            printLog("exception: ", e2);
        }
    }

    public void unlock() {
        FileLock fileLock = this.mCacheLock;
        if (fileLock != null) {
            try {
                fileLock.release();
            } catch (IOException unused) {
                StringBuilder sb = new StringBuilder("Failed to release lock on ");
                File file = this.mLockFile;
                sb.append(file != null ? file.getPath() : "");
                printLog(sb.toString());
            }
        }
        FileChannel fileChannel = this.mLockChannel;
        if (fileChannel != null) {
            closeQuietly(fileChannel);
        }
        closeQuietly(this.mLockRaf);
        if (this.mLockFile != null) {
            printLog(this.mLockFile.getPath() + " unlocked");
        }
    }

    private void printLog(String str, Throwable th) {
        Utils.LogHelper logHelper = this.mLog;
        if (logHelper != null) {
            logHelper.print(TAG, str, th);
        }
    }
}
