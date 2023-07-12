package com.youku.playerservice.axp.axpinterface;

import com.youku.playerservice.axp.axpinterface.IPlayInfoRequest;
import com.youku.playerservice.axp.interceptor.Interceptor;
import com.youku.playerservice.axp.item.Quality;
import com.youku.playerservice.axp.playinfo.PlayInfo;
import com.youku.playerservice.axp.playparams.PlayParams;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public interface IPlayerService extends IMultiPlayerProtocol, IPlayerProtocol, ISwitchStream {
    void addInterceptor(Interceptor interceptor);

    Quality getCurrentQuality();

    PlayInfo getPlayInfo();

    PlayParams getPlayParams();

    void playWithParams(PlayParams playParams);

    void release();

    void requestWithParams(PlayParams playParams, IPlayInfoRequest.Callback callback);

    void requestWithUpdatePlayInfo(Map<String, String> map);

    void setMultiPlayerEventListener(MultiPlayerEventListener multiPlayerEventListener);

    void setPlayerEventListener(PlayerEventListener playerEventListener);

    void setPositionFrenquency(int i);

    /* synthetic */ void switchLanguage(String str);

    /* synthetic */ void switchQuality(Quality quality);

    /* synthetic */ void switchSceneId(String str);

    /* synthetic */ void switchTimeShifted(String str);
}
