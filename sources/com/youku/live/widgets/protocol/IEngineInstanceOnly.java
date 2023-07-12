package com.youku.live.widgets.protocol;

import android.content.Context;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public interface IEngineInstanceOnly extends ISystemEvent {
    IPlugin createPluginIfNotExists(String str);

    void render(String str, Map<String, Object> map);

    void setContext(Context context);

    void setRenderListener(IEngineRenderListener iEngineRenderListener);
}
