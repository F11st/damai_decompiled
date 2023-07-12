package com.youku.live.dago.liveplayback.widget;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.exifinterface.media.ExifInterface;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.phenix.bitmap.BitmapProcessor;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class ScaleCropBitmapProcessor implements BitmapProcessor {
    private static transient /* synthetic */ IpChange $ipChange;
    private final int mTargetHeight;
    private final int mTargetWidth;

    public ScaleCropBitmapProcessor(int i, int i2) {
        this.mTargetWidth = i;
        this.mTargetHeight = i2;
    }

    @Override // com.taobao.phenix.bitmap.BitmapProcessor
    public String getId() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-566732573")) {
            return (String) ipChange.ipc$dispatch("-566732573", new Object[]{this});
        }
        return ExifInterface.LONGITUDE_WEST + this.mTargetWidth + "$H" + this.mTargetHeight;
    }

    @Override // com.taobao.phenix.bitmap.BitmapProcessor
    public Bitmap process(@NonNull String str, @NonNull BitmapProcessor.BitmapSupplier bitmapSupplier, @NonNull Bitmap bitmap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1188815740")) {
            return (Bitmap) ipChange.ipc$dispatch("-1188815740", new Object[]{this, str, bitmapSupplier, bitmap});
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i = this.mTargetHeight;
        int i2 = this.mTargetWidth;
        int i3 = width * i;
        int i4 = i2 * height;
        if (i3 > i4) {
            i2 = i3 / height;
        } else {
            i = i4 / width;
        }
        return Bitmap.createScaledBitmap(bitmap, i2, i, true);
    }
}
