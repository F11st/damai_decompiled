package com.alibaba.pictures.moimage;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0011\u0010\u0005\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u0011\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0004\b\u0007\u0010\bJ\u0011\u0010\t\u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0004\b\t\u0010\bJ\u0011\u0010\n\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\n\u0010\u0004¨\u0006\u000b"}, d2 = {"Lcom/alibaba/pictures/moimage/IMoImageConfig;", "", "", "debugAble", "()Ljava/lang/Boolean;", "showImageOff", "", "defaultErrorDrawable", "()Ljava/lang/Integer;", "defaultDrawable", "disableFadeIn", "moimage_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes7.dex */
public interface IMoImageConfig {
    @Nullable
    Boolean debugAble();

    @Nullable
    Integer defaultDrawable();

    @Nullable
    Integer defaultErrorDrawable();

    @Nullable
    Boolean disableFadeIn();

    @Nullable
    Boolean showImageOff();
}
