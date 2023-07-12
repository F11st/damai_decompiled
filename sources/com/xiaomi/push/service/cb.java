package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.AbstractC7535b;
import com.xiaomi.push.C7594ab;
import com.xiaomi.push.C7672hn;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class cb implements Runnable {
    final /* synthetic */ Context a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ C7672hn f957a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cb(Context context, C7672hn c7672hn) {
        this.a = context;
        this.f957a = c7672hn;
    }

    @Override // java.lang.Runnable
    public void run() {
        RandomAccessFile randomAccessFile;
        synchronized (ca.a) {
            FileLock fileLock = null;
            try {
                try {
                    File file = new File(this.a.getFilesDir(), "tiny_data.lock");
                    C7594ab.m659a(file);
                    randomAccessFile = new RandomAccessFile(file, "rw");
                } catch (Exception e) {
                    e = e;
                    randomAccessFile = null;
                } catch (Throwable th) {
                    th = th;
                    randomAccessFile = null;
                    if (fileLock != null) {
                        try {
                            fileLock.release();
                        } catch (IOException e2) {
                            AbstractC7535b.a(e2);
                        }
                    }
                    C7594ab.a(randomAccessFile);
                    throw th;
                }
                try {
                    try {
                        fileLock = randomAccessFile.getChannel().lock();
                        ca.c(this.a, this.f957a);
                        if (fileLock != null && fileLock.isValid()) {
                            try {
                                fileLock.release();
                            } catch (IOException e3) {
                                AbstractC7535b.a(e3);
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (fileLock != null && fileLock.isValid()) {
                            fileLock.release();
                        }
                        C7594ab.a(randomAccessFile);
                        throw th;
                    }
                } catch (Exception e4) {
                    e = e4;
                    AbstractC7535b.a(e);
                    if (fileLock != null && fileLock.isValid()) {
                        try {
                            fileLock.release();
                        } catch (IOException e5) {
                            AbstractC7535b.a(e5);
                        }
                    }
                    C7594ab.a(randomAccessFile);
                }
                C7594ab.a(randomAccessFile);
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }
}
