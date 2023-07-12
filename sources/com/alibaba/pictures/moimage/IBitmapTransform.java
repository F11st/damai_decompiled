package com.alibaba.pictures.moimage;

import android.graphics.Bitmap;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¨\u0006\u0005"}, d2 = {"Lcom/alibaba/pictures/moimage/IBitmapTransform;", "", "Landroid/graphics/Bitmap;", "toTransform", "transform", "moimage_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes7.dex */
public interface IBitmapTransform {
    @Nullable
    Bitmap transform(@Nullable Bitmap bitmap);
}
