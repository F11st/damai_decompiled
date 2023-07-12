package com.alipay.mobile.binarize;

import android.content.Context;
import com.alipay.ma.MaLogger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class BinarizeHandler {
    public static final String TAG = "BinarizeHandler";
    private List<BinarizeResult> a;
    private AdaptiveHybridBinarizer b;
    private HybridStdBinarizer c;
    private LocalAdaptiveBinarizer d;
    private int e;
    private boolean f;
    private BinarizeResult g;
    private BinarizeResult h;
    private static final int[] i = {0, 1, 2, 3, 4};
    private static boolean j = true;
    private static Lock k = new ReentrantLock();
    public static boolean INIT_EXCEPTION_REACHES_LIMIT = false;

    public BinarizeHandler(Context context) {
        try {
            k.lock();
            b(context);
        } finally {
            k.unlock();
        }
    }

    private void a(BinarizeResult binarizeResult, BinarizeResult binarizeResult2) {
        if (binarizeResult == null || binarizeResult2 == null) {
            return;
        }
        binarizeResult2.width = binarizeResult.width;
        binarizeResult2.height = binarizeResult.height;
        binarizeResult2.methodId = binarizeResult.methodId;
        byte[] bArr = binarizeResult2.bitMatrixData;
        if (bArr == null || bArr.length != binarizeResult.bitMatrixData.length) {
            binarizeResult2.bitMatrixData = new byte[binarizeResult.bitMatrixData.length];
        }
        byte[] bArr2 = binarizeResult.bitMatrixData;
        System.arraycopy(bArr2, 0, binarizeResult2.bitMatrixData, 0, bArr2.length);
    }

    private void b(Context context) {
        MaLogger.d(TAG, "BinarizeHandler init");
        this.e = 0;
        this.f = false;
        this.a = new ArrayList();
        this.b = new AdaptiveHybridBinarizer(context);
        this.c = new HybridStdBinarizer(context);
        this.d = new LocalAdaptiveBinarizer(context);
    }

    private void c() {
        MaLogger.d(TAG, "BinarizeHandler release");
        AdaptiveHybridBinarizer adaptiveHybridBinarizer = this.b;
        if (adaptiveHybridBinarizer != null) {
            adaptiveHybridBinarizer.destroy();
        }
        HybridStdBinarizer hybridStdBinarizer = this.c;
        if (hybridStdBinarizer != null) {
            hybridStdBinarizer.destroy();
        }
        LocalAdaptiveBinarizer localAdaptiveBinarizer = this.d;
        if (localAdaptiveBinarizer != null) {
            localAdaptiveBinarizer.destroy();
        }
        this.b = null;
        this.c = null;
        this.d = null;
    }

    public static void preHeatBinarizer(Context context) {
        if (j) {
            return;
        }
        try {
            try {
                k.lock();
                new BinarizeHandler(context, false).c();
                j = true;
            } catch (Exception e) {
                MaLogger.d(TAG, "preHeatBinarizer exception " + e);
            }
        } finally {
            k.unlock();
        }
    }

    public void destroy() {
        try {
            k.lock();
            c();
        } finally {
            k.unlock();
        }
    }

    public void doBinarize(byte[] bArr, int i2, int i3) {
        if (this.f) {
            this.e = (this.e + 1) % i.length;
            this.f = false;
        }
        BinarizeResult binarizeResult = null;
        int[] iArr = i;
        int i4 = iArr[this.e];
        if (i4 == 0) {
            this.b.initialize(i2, i3);
            this.b.setPreferWhite(true);
            this.b.setDeNoiseByAvg(false);
            binarizeResult = this.b.getBinarizedData(bArr);
        } else if (i4 == 1) {
            this.c.initialize(i2, i3);
            binarizeResult = this.c.getBinarizedData(bArr);
        } else if (i4 == 2) {
            this.d.initialize(i2, i3);
            binarizeResult = this.d.getBinarizedData(bArr);
        } else if (i4 == 3) {
            this.b.initialize(i2, i3);
            this.b.setPreferWhite(true);
            this.b.setDeNoiseByAvg(true);
            binarizeResult = this.b.getBinarizedData(bArr);
        } else if (i4 == 4) {
            this.b.initialize(i2, i3);
            this.b.setPreferWhite(false);
            this.b.setDeNoiseByAvg(false);
            binarizeResult = this.b.getBinarizedData(bArr);
        }
        if (binarizeResult != null) {
            binarizeResult.methodId = iArr[this.e];
            synchronized (this.a) {
                if (this.g == null) {
                    this.g = new BinarizeResult();
                }
                a(binarizeResult, this.g);
                this.a.clear();
                this.a.add(this.g);
            }
        }
    }

    public boolean isBinarizePoolEmpty() {
        boolean isEmpty;
        synchronized (this.a) {
            isEmpty = this.a.isEmpty();
        }
        return isEmpty;
    }

    public BinarizeResult popFirstBinarizeResult() {
        synchronized (this.a) {
            if (this.a.isEmpty()) {
                return null;
            }
            this.f = true;
            BinarizeResult remove = this.a.remove(0);
            if (this.h == null) {
                this.h = new BinarizeResult();
            }
            a(remove, this.h);
            return this.h;
        }
    }

    private BinarizeHandler(Context context, boolean z) {
        b(context);
    }
}
