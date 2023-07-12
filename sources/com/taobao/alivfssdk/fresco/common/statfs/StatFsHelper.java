package com.taobao.alivfssdk.fresco.common.statfs;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import com.taobao.orange.OConstant;
import java.io.File;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;

/* compiled from: Taobao */
@ThreadSafe
/* loaded from: classes8.dex */
public class StatFsHelper {
    private static StatFsHelper h;
    private static final long i = TimeUnit.MINUTES.toMillis(2);
    private volatile File b;
    private volatile File d;
    @GuardedBy(OConstant.DIMEN_FILE_LOCK)
    private long e;
    private volatile StatFs a = null;
    private volatile StatFs c = null;
    private volatile boolean g = false;
    private final Lock f = new ReentrantLock();

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public enum StorageType {
        INTERNAL,
        EXTERNAL
    }

    protected StatFsHelper() {
    }

    protected static StatFs a(String str) {
        return new StatFs(str);
    }

    private void b() {
        if (this.g) {
            return;
        }
        this.f.lock();
        try {
            if (!this.g) {
                this.b = Environment.getDataDirectory();
                this.d = Environment.getExternalStorageDirectory();
                g();
                this.g = true;
            }
        } finally {
            this.f.unlock();
        }
    }

    public static synchronized StatFsHelper d() {
        StatFsHelper statFsHelper;
        synchronized (StatFsHelper.class) {
            if (h == null) {
                h = new StatFsHelper();
            }
            statFsHelper = h;
        }
        return statFsHelper;
    }

    private void e() {
        if (this.f.tryLock()) {
            try {
                if (SystemClock.uptimeMillis() - this.e > i) {
                    g();
                }
            } finally {
                this.f.unlock();
            }
        }
    }

    @GuardedBy(OConstant.DIMEN_FILE_LOCK)
    private void g() {
        this.a = h(this.a, this.b);
        this.c = h(this.c, this.d);
        this.e = SystemClock.uptimeMillis();
    }

    private StatFs h(@Nullable StatFs statFs, @Nullable File file) {
        StatFs statFs2 = null;
        if (file == null || !file.exists()) {
            return null;
        }
        try {
            if (statFs == null) {
                statFs = a(file.getAbsolutePath());
            } else {
                statFs.restat(file.getAbsolutePath());
            }
            statFs2 = statFs;
            return statFs2;
        } catch (IllegalArgumentException unused) {
            return statFs2;
        } catch (Throwable th) {
            throw new RuntimeException(th);
        }
    }

    @SuppressLint({"DeprecatedMethod"})
    public long c(StorageType storageType) {
        long blockSize;
        long availableBlocks;
        b();
        e();
        StatFs statFs = storageType == StorageType.INTERNAL ? this.a : this.c;
        if (statFs != null) {
            if (Build.VERSION.SDK_INT >= 18) {
                blockSize = statFs.getBlockSizeLong();
                availableBlocks = statFs.getAvailableBlocksLong();
            } else {
                blockSize = statFs.getBlockSize();
                availableBlocks = statFs.getAvailableBlocks();
            }
            return blockSize * availableBlocks;
        }
        return 0L;
    }

    public boolean f(StorageType storageType, long j) {
        b();
        long c = c(storageType);
        return c <= 0 || c < j;
    }
}
