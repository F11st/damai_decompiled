package com.youku.playerservice.axp.cache.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.youku.playerservice.axp.cache.MinsetPreloadInfo;
import com.youku.playerservice.axp.playinfo.PlayInfoResponse;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public interface IMinsetDiskCacheCallback {
    boolean checkVideoExist(@NonNull MinsetPreloadInfo minsetPreloadInfo, @Nullable String str);

    String getRedirectUrl(String str);

    @Nullable
    PlayInfoResponse tryFindCacheInfo();

    void updateMinVideoInfo(@NonNull PlayInfoResponse playInfoResponse);

    void updateMinVideoInfo(@NonNull List<PlayInfoResponse> list);
}
