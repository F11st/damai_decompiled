package com.youku.skinmanager.download;

import com.youku.skinmanager.entity.SkinDTO;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public interface IDownloadListener {
    void onFail(SkinDTO skinDTO);

    void onSuccess(SkinDTO skinDTO);

    void update(int i);
}
