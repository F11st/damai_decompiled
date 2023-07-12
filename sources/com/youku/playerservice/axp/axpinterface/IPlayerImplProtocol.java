package com.youku.playerservice.axp.axpinterface;

import com.youku.playerservice.axp.item.PlayItem;
import com.youku.playerservice.axp.modules.ModuleManager;
import com.youku.playerservice.axp.playinfo.PlayInfo;
import com.youku.playerservice.axp.playparams.PlayParams;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public interface IPlayerImplProtocol extends IPlayerProtocol {
    ModuleManager getModuleManager();

    PlayInfo getPlayInfo();

    PlayInfo getPlayInfoOfReuse(String str);

    PlayParams getPlayParams();

    void playWithPlayInfo(PlayInfo playInfo);

    void setInternalPlayEventListener(InternalPlayerEventListener internalPlayerEventListener);

    void switchPlayItem(PlayItem playItem);
}
