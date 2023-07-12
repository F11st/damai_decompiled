package com.taobao.phenix.bitmap;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.taobao.pexode.Pexode;
import com.taobao.phenix.bitmap.BitmapProcessor;
import tb.n8;
import tb.ur1;

/* compiled from: Taobao */
/* renamed from: com.taobao.phenix.bitmap.b */
/* loaded from: classes11.dex */
public class C6849b implements BitmapProcessor.BitmapSupplier {
    private static final C6849b a = new C6849b();

    public static C6849b a() {
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
