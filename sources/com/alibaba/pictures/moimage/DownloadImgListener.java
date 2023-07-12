package com.alibaba.pictures.moimage;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J!\u0010\u0007\u001a\u00020\u00062\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0005\u001a\u00028\u0000H&¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\f\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003H&¨\u0006\r"}, d2 = {"Lcom/alibaba/pictures/moimage/DownloadImgListener;", "T", "", "", "url", "source", "Ltb/wt2;", "onDownloaded", "(Ljava/lang/String;Ljava/lang/Object;)V", "Lcom/alibaba/pictures/moimage/MoImageLoadException;", "exception", "msg", "onFail", "moimage_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes7.dex */
public interface DownloadImgListener<T> {
    void onDownloaded(@Nullable String str, T t);

    void onFail(@NotNull MoImageLoadException moImageLoadException, @Nullable String str);
}
