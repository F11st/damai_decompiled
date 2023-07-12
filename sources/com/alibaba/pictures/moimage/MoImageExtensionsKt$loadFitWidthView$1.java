package com.alibaba.pictures.moimage;

import android.graphics.Bitmap;
import android.view.ViewGroup;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class MoImageExtensionsKt$loadFitWidthView$1 implements DownloadImgListener<Bitmap> {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ MoImageView a;
    final /* synthetic */ Integer b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MoImageExtensionsKt$loadFitWidthView$1(MoImageView moImageView, Integer num) {
        this.a = moImageView;
        this.b = num;
    }

    @Override // com.alibaba.pictures.moimage.DownloadImgListener
    /* renamed from: a */
    public void onDownloaded(@Nullable String str, @NotNull final Bitmap bitmap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-240521341")) {
            ipChange.ipc$dispatch("-240521341", new Object[]{this, str, bitmap});
            return;
        }
        b41.i(bitmap, "source");
        this.a.post(new Runnable() { // from class: com.alibaba.pictures.moimage.MoImageExtensionsKt$loadFitWidthView$1$onDownloaded$1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // java.lang.Runnable
            public final void run() {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1900567843")) {
                    ipChange2.ipc$dispatch("-1900567843", new Object[]{this});
                } else if (bitmap.getWidth() <= 0 || bitmap.getHeight() <= 0) {
                } else {
                    ViewGroup.LayoutParams layoutParams = MoImageExtensionsKt$loadFitWidthView$1.this.a.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = MoImageExtensionsKt$loadFitWidthView$1.this.b.intValue();
                    }
                    ViewGroup.LayoutParams layoutParams2 = MoImageExtensionsKt$loadFitWidthView$1.this.a.getLayoutParams();
                    if (layoutParams2 != null) {
                        layoutParams2.width = (MoImageExtensionsKt$loadFitWidthView$1.this.b.intValue() * bitmap.getWidth()) / bitmap.getHeight();
                    }
                    MoImageView moImageView = MoImageExtensionsKt$loadFitWidthView$1.this.a;
                    moImageView.setLayoutParams(moImageView.getLayoutParams());
                }
            }
        });
        this.a.setLocalImageBitmap(bitmap);
    }

    @Override // com.alibaba.pictures.moimage.DownloadImgListener
    public void onFail(@NotNull MoImageLoadException moImageLoadException, @Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2025010942")) {
            ipChange.ipc$dispatch("-2025010942", new Object[]{this, moImageLoadException, str});
        } else {
            b41.i(moImageLoadException, "exception");
        }
    }
}
