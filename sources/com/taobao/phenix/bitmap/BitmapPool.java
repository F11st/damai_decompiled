package com.taobao.phenix.bitmap;

import android.graphics.Bitmap;
import tb.ef;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public interface BitmapPool {
    int available();

    void clear();

    Bitmap getFromPool(int i, int i2, Bitmap.Config config);

    void maxPoolSize(int i);

    boolean putIntoPool(ef efVar);

    void trimPool(int i);
}
