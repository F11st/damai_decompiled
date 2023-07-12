package com.alibaba.pictures.moimage;

import com.uc.webview.export.media.MessageID;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.h23;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u001c\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\b\u001a\u00060\u0006j\u0002`\u0007H&J-\u0010\u000f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\nH&¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/alibaba/pictures/moimage/IMoImageViewMonitor;", "", "Lcom/alibaba/pictures/moimage/ImageStatistics;", "imageStatistics", "Ltb/wt2;", "onSuccess", "Ljava/lang/Exception;", "Lkotlin/Exception;", "e", "onFail", "", h23.BIZ_SCENE_DIMEN, "", "errorCode", "errorMsg", MessageID.onError, "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "moimage_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes7.dex */
public interface IMoImageViewMonitor {
    void onError(@Nullable String str, @Nullable Integer num, @Nullable String str2);

    void onFail(@NotNull ImageStatistics imageStatistics, @NotNull Exception exc);

    void onSuccess(@NotNull ImageStatistics imageStatistics);
}
