package com.alibaba.pictures.moimage;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J8\u0010\u000b\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH&J\u0014\u0010\f\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¨\u0006\r"}, d2 = {"Lcom/alibaba/pictures/moimage/IImageUrlFixer;", "", "", "imageUrl", "", "measureWidth", "measureHeight", "Lcom/alibaba/pictures/moimage/ImgResQuality;", "imgResQuality", "Lcom/alibaba/pictures/moimage/ImgResExtraInfo;", "resFragmentInfo", "autoFix", "addPrefixIfNeeded", "moimage_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes7.dex */
public interface IImageUrlFixer {
    @Nullable
    String addPrefixIfNeeded(@Nullable String str);

    @Nullable
    String autoFix(@Nullable String str, int i, int i2, @Nullable ImgResQuality imgResQuality, @Nullable ImgResExtraInfo imgResExtraInfo);
}
