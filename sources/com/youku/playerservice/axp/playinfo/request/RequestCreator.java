package com.youku.playerservice.axp.playinfo.request;

import android.content.Context;
import com.youku.playerservice.axp.PlayerConfig;
import com.youku.playerservice.axp.axpinterface.IPlayInfoRequest;
import com.youku.playerservice.axp.axpinterface.PlayDefinition;
import com.youku.playerservice.axp.playparams.PlayParams;
import com.youku.vpm.constants.TableField;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class RequestCreator {
    public static IPlayInfoRequest create(Context context, PlayParams playParams, PlayerConfig playerConfig) {
        if (playParams.getPlayIdParams() == null || playParams.getPlayIdParams().getPlayInfoRequest() == null) {
            if (playParams.getPlayType() != PlayDefinition.PlayType.VOD) {
                if (playParams.getPlayType() == PlayDefinition.PlayType.LIVE) {
                    return new LiveRequest(playerConfig);
                }
                return null;
            } else if (CacheRequest.hasCacheData(playParams)) {
                CacheRequest cacheRequest = new CacheRequest(context, playerConfig);
                playParams.putString(TableField.PLAY_WAY, "local");
                return cacheRequest;
            } else {
                return new UpsWithCacheRequest(playerConfig);
            }
        }
        return playParams.getPlayIdParams().getPlayInfoRequest();
    }
}
