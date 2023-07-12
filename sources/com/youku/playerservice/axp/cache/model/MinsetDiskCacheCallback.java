package com.youku.playerservice.axp.cache.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.youku.playerservice.axp.cache.MinsetPreloadInfo;
import com.youku.playerservice.axp.playinfo.PlayInfoResponse;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class MinsetDiskCacheCallback implements IMinsetDiskCacheCallback {
    @Override // com.youku.playerservice.axp.cache.model.IMinsetDiskCacheCallback
    public boolean checkVideoExist(@NonNull MinsetPreloadInfo minsetPreloadInfo, @Nullable String str) {
        return false;
    }

    @Override // com.youku.playerservice.axp.cache.model.IMinsetDiskCacheCallback
    public String getRedirectUrl(String str) {
        return null;
    }

    @Override // com.youku.playerservice.axp.cache.model.IMinsetDiskCacheCallback
    @Nullable
    public PlayInfoResponse tryFindCacheInfo() {
        return null;
    }

    @Override // com.youku.playerservice.axp.cache.model.IMinsetDiskCacheCallback
    public void updateMinVideoInfo(@NonNull PlayInfoResponse playInfoResponse) {
    }

    @Override // com.youku.playerservice.axp.cache.model.IMinsetDiskCacheCallback
    public void updateMinVideoInfo(@NonNull List<PlayInfoResponse> list) {
    }
}
