package com.youku.skinmanager;

import android.content.Context;
import androidx.annotation.Nullable;
import com.youku.skinmanager.download.IDownloadListener;
import com.youku.skinmanager.entity.SkinDTO;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public interface ISkinManager {
    @Nullable
    SkinDTO getCurrentSkinConfig();

    @Nullable
    String getSkinPath();

    void init(Context context);

    boolean isOverdraw();

    void loadSkin(SkinDTO skinDTO, String str, @Nullable ILoadSkinListener iLoadSkinListener);

    void loadSkinById(String str, @Nullable IDownloadListener iDownloadListener);

    void restoreDefault(@Nullable ILoadSkinListener iLoadSkinListener);
}
