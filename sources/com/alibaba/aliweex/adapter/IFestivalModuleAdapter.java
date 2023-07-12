package com.alibaba.aliweex.adapter;

import android.content.Context;
import com.taobao.weex.bridge.JSCallback;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public interface IFestivalModuleAdapter {
    Map<String, String> queryFestivalStyle();

    void setFestivalStyle(Context context, String str, JSCallback jSCallback, JSCallback jSCallback2);
}
