package com.taobao.pexode;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.util.TypedValue;
import com.taobao.pexode.entity.IncrementalStaging;
import com.taobao.pexode.mimetype.MimeType;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class PexodeOptions {
    public static final Bitmap.Config CONFIG = Bitmap.Config.ARGB_8888;
    static boolean sEnabledCancellability = true;
    public boolean allowDegrade2NoAshmem;
    public boolean allowDegrade2NoInBitmap;
    public boolean allowDegrade2System;
    volatile boolean cancelled;
    private volatile long cancelledPtr;
    public boolean enableAshmem;
    public boolean forceStaticIfAnimation;
    public boolean fromLocal;
    public Bitmap inBitmap;
    public boolean incrementalDecode;
    public boolean justDecodeBounds;
    int lastSampleSize;
    IncrementalStaging mIncrementalStaging;
    public boolean outAlpha;
    public MimeType outMimeType;
    public Rect outPadding;
    public TypedValue resourceValue;
    public int sampleSize;
    public byte[] tempHeaderBuffer;
    private BitmapFactory.Options uponSysOptions;
    public int outWidth = -1;
    public int outHeight = -1;
    public boolean outIcc = false;

    private native void nativeRequestCancel(long j);

    protected void finalize() {
        try {
            if (this.tempHeaderBuffer != null) {
                C6827a.f().h(this.tempHeaderBuffer);
            }
            super.finalize();
        } catch (Throwable unused) {
        }
    }

    public boolean isSizeAvailable() {
        return this.outWidth > 0 && this.outHeight > 0;
    }

    public synchronized boolean requestCancel() {
        if (sEnabledCancellability) {
            this.cancelled = true;
            BitmapFactory.Options options = this.uponSysOptions;
            if (options != null) {
                options.requestCancelDecode();
                return true;
            } else if (this.cancelledPtr != 0) {
                nativeRequestCancel(this.cancelledPtr);
                this.cancelledPtr = 0L;
                return true;
            } else {
                IncrementalStaging incrementalStaging = this.mIncrementalStaging;
                if (incrementalStaging != null) {
                    incrementalStaging.c();
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void setUponSysOptions(BitmapFactory.Options options) {
        this.uponSysOptions = options;
    }
}
