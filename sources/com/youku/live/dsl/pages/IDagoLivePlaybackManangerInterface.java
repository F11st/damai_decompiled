package com.youku.live.dsl.pages;

import android.app.Application;
import android.content.Context;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public interface IDagoLivePlaybackManangerInterface {
    String getCkeyInfoForRoomSwitchList(Context context, Map<String, String> map);

    void registerAll(Application application);
}
