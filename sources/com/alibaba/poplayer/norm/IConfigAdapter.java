package com.alibaba.poplayer.norm;

import android.content.Context;
import com.alibaba.poplayer.PopLayer;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public interface IConfigAdapter {
    void addConfigObserver(Context context, PopLayer popLayer);

    String getConfigItemByKey(Context context, String str);

    void initializeConfigContainer(Context context, PopLayer popLayer);
}
