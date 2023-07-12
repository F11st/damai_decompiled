package com.youku.playerservice.axp.playinforesult;

import com.youku.playerservice.axp.PlayerConfig;
import com.youku.playerservice.axp.playinfo.PlayInfo;
import com.youku.playerservice.axp.playinfo.PlayInfoResponse;
import com.youku.playerservice.axp.playinfo.PlayInfoResult;
import com.youku.playerservice.axp.playparams.PlayParams;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class PlayUpsInfoResult {
    private PlayerConfig mPlayerConfig;

    public PlayUpsInfoResult(PlayerConfig playerConfig) {
        this.mPlayerConfig = playerConfig;
    }

    public PlayInfoResult getPlayInfoResult(PlayParams playParams, PlayInfoResponse playInfoResponse) {
        PlayInfo playInfo = new PlayInfo(playParams, this.mPlayerConfig);
        playInfo.setPlayInfoResponse(playInfoResponse);
        if (playInfoResponse.getError() == null) {
            return new PlayInfoResult(playInfo);
        }
        PlayInfoResult playInfoResult = new PlayInfoResult(playInfoResponse.getError());
        playInfoResult.setPlayInfo(playInfo);
        return playInfoResult;
    }
}
