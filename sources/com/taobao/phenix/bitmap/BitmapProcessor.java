package com.taobao.phenix.bitmap;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public interface BitmapProcessor {

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public interface BitmapSupplier {
        @NonNull
        Bitmap get(int i, int i2, Bitmap.Config config);
    }

    String getId();

    Bitmap process(@NonNull String str, @NonNull BitmapSupplier bitmapSupplier, @NonNull Bitmap bitmap);
}
