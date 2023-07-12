package com.youku.live.dsl.danmaku;

import android.view.View;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public interface IDanmakuController {
    void addDanmu(DanmakuItem danmakuItem);

    void addDanmu(Map<String, Object> map);

    void addDanmuOld(DanmakuItem danmakuItem);

    void clearDanmu();

    void destroy();

    View getView();

    void hide();

    void pause();

    void resume();

    void setMaximumLines(int i);

    void show();
}
