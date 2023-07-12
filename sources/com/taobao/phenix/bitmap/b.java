package com.taobao.phenix.bitmap;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.taobao.pexode.Pexode;
import com.taobao.phenix.bitmap.BitmapProcessor;
import tb.n8;
import tb.ur1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class b implements BitmapProcessor.BitmapSupplier {
    private static final b a = new b();

    public static b a() {
        return a;
    }

    @Override // com.taobao.phenix.bitmap.BitmapProcessor.BitmapSupplier
    @NonNull
    public Bitmap get(int i, int i2, Bitmap.Config config) {
        Bitmap fromPool;
        if (Pexode.j()) {
            fromPool = n8.a().newBitmapWithPin(i, i2, config);
        } else {
            BitmapPool build = ur1.o().a().build();
            fromPool = build != null ? build.getFromPool(i, i2, config) : null;
        }
        return fromPool == null ? Bitmap.createBitmap(i, i2, config) : fromPool;
    }
}
