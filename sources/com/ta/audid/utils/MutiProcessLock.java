package com.ta.audid.utils;

import com.ta.audid.upload.UtdidKeyFile;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class MutiProcessLock {
    private static FileChannel mChannel;
    private static FileLock mLock;
    private static File mLockFile;
    private static FileChannel mSyncUtdidChannel;
    private static File mSyncUtdidFile;
    private static FileLock mSyncUtdidLock;

    public static synchronized void lockUtdidFile() {
        synchronized (MutiProcessLock.class) {
            UtdidLogger.d();
            if (mLockFile == null) {
                mLockFile = new File(UtdidKeyFile.getFileLockPath());
            }
            if (!mLockFile.exists()) {
                try {
                    mLockFile.createNewFile();
                } catch (Exception unused) {
                    return;
                }
            }
            if (mChannel == null) {
                try {
                    mChannel = new RandomAccessFile(mLockFile, "rw").getChannel();
                } catch (Exception unused2) {
                    return;
                }
            }
            try {
                mLock = mChannel.lock();
            } catch (Throwable unused3) {
            }
        }
    }

    public static synchronized void releaseSyncUtdid() {
        synchronized (MutiProcessLock.class) {
            UtdidLogger.d();
            FileLock fileLock = mSyncUtdidLock;
            if (fileLock != null) {
                try {
                    fileLock.release();
                } catch (Exception unused) {
                } catch (Throwable th) {
                    mSyncUtdidLock = null;
                    throw th;
                }
                mSyncUtdidLock = null;
            }
            FileChannel fileChannel = mSyncUtdidChannel;
            if (fileChannel != null) {
                try {
                    fileChannel.close();
                } catch (Exception unused2) {
                } catch (Throwable th2) {
                    mSyncUtdidChannel = null;
                    throw th2;
                }
                mSyncUtdidChannel = null;
            }
        }
    }

    public static synchronized void releaseUtdidFile() {
        synchronized (MutiProcessLock.class) {
            UtdidLogger.d();
            FileLock fileLock = mLock;
            if (fileLock != null) {
                try {
                    fileLock.release();
                } catch (Exception unused) {
                } catch (Throwable th) {
                    mLock = null;
                    throw th;
                }
                mLock = null;
            }
            FileChannel fileChannel = mChannel;
            if (fileChannel != null) {
                try {
                    fileChannel.close();
                } catch (Exception unused2) {
                } catch (Throwable th2) {
                    mChannel = null;
                    throw th2;
                }
                mChannel = null;
            }
        }
    }

    public static synchronized boolean trylockSyncUtdid() {
        synchronized (MutiProcessLock.class) {
            UtdidLogger.d();
            if (mSyncUtdidFile == null) {
                mSyncUtdidFile = new File(UtdidKeyFile.getSyncUtdidFileLockPath());
            }
            if (!mSyncUtdidFile.exists()) {
                try {
                    mSyncUtdidFile.createNewFile();
                } catch (Exception unused) {
                    return false;
                }
            }
            if (mSyncUtdidChannel == null) {
                try {
                    mSyncUtdidChannel = new RandomAccessFile(mSyncUtdidFile, "rw").getChannel();
                } catch (Exception unused2) {
                    return false;
                }
            }
            try {
                FileLock tryLock = mSyncUtdidChannel.tryLock();
                if (tryLock != null) {
                    mSyncUtdidLock = tryLock;
                    return true;
                }
            } catch (Throwable unused3) {
            }
            return false;
        }
    }
}
