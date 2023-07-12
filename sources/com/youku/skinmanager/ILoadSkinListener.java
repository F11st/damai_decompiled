package com.youku.skinmanager;

import com.youku.skinmanager.entity.SkinDTO;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public interface ILoadSkinListener {
    void onLoadFail(SkinDTO skinDTO);

    void onLoadSuccess(SkinDTO skinDTO);
}
