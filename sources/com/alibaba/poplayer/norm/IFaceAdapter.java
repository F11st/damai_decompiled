package com.alibaba.poplayer.norm;

import android.content.Context;
import com.alibaba.poplayer.PopLayer;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public interface IFaceAdapter {
    long getCurrentTimeStamp(Context context);

    void navToUrl(Context context, String str);

    void registerNavPreprocessor(Context context, PopLayer popLayer);

    void registerTrackViewTypes(Context context, PopLayer popLayer);
}
