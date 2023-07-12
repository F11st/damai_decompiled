package com.taobao.pexode.entity;

import android.graphics.Bitmap;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class IncrementalStaging {
    private final Bitmap a;
    private final NativeDestructor b;
    private long c;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public interface NativeDestructor {
        void destruct(long j);
    }

    public IncrementalStaging(Bitmap bitmap, long j, NativeDestructor nativeDestructor) {
        this.a = bitmap;
        this.c = j;
        this.b = nativeDestructor;
    }

    public Bitmap a() {
        return this.a;
    }

    public long b() {
        return this.c;
    }

    public synchronized void c() {
        long j = this.c;
        if (j != 0) {
            this.b.destruct(j);
            this.c = 0L;
        }
    }

    protected void finalize() {
        try {
            c();
            super.finalize();
        } catch (Throwable unused) {
        }
    }
}
