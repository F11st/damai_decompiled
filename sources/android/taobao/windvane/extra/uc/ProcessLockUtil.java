package android.taobao.windvane.extra.uc;

import android.taobao.windvane.util.TaoLog;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class ProcessLockUtil {
    private static final String TAG = "ProcessLockUtil";
    private FileLock cacheLock;
    private FileChannel lockChannel;
    private File lockFile;
    private RandomAccessFile lockRaf;

    public ProcessLockUtil(String str) {
        this.lockFile = new File(str);
    }

    private void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e) {
                TaoLog.e(TAG, "Failed to close resource", e, new Object[0]);
            }
        }
    }

    public void lock() {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(this.lockFile, "rw");
            this.lockRaf = randomAccessFile;
            if (this.lockFile == null) {
                TaoLog.e(TAG, "lock error lockRaf = " + this.lockRaf + " lockFile = " + this.lockFile);
                return;
            }
            this.lockChannel = randomAccessFile.getChannel();
            TaoLog.d(TAG, "Blocking on lock " + this.lockFile.getPath());
            try {
                this.cacheLock = this.lockChannel.lock();
                TaoLog.d(TAG, this.lockFile.getPath() + " locked");
            } catch (IOException e) {
                TaoLog.e(TAG, "lock error ", e, new Object[0]);
            }
        } catch (FileNotFoundException e2) {
            TaoLog.e(TAG, "ProcessLock error", e2, new Object[0]);
        }
    }

    public void unlock() {
        FileLock fileLock = this.cacheLock;
        if (fileLock != null) {
            try {
                fileLock.release();
            } catch (IOException unused) {
                StringBuilder sb = new StringBuilder();
                sb.append("Failed to release lock on ");
                File file = this.lockFile;
                sb.append(file != null ? file.getPath() : "");
                TaoLog.e(TAG, sb.toString());
            }
        }
        FileChannel fileChannel = this.lockChannel;
        if (fileChannel != null) {
            closeQuietly(fileChannel);
        }
        closeQuietly(this.lockRaf);
        if (this.lockFile != null) {
            TaoLog.d(TAG, this.lockFile.getPath() + " unlocked");
        }
    }

    public ProcessLockUtil(File file) {
        this.lockFile = file;
    }
}
