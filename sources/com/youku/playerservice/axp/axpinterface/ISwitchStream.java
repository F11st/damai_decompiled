package com.youku.playerservice.axp.axpinterface;

import com.youku.playerservice.axp.item.Quality;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
interface ISwitchStream {
    void changeToMultiScene(String str, Map<String, String> map);

    void switchLanguage(String str);

    void switchQuality(Quality quality);

    void switchSceneId(String str);

    void switchTimeShifted(String str);
}
