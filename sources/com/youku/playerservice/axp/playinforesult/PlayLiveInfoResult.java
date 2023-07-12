package com.youku.playerservice.axp.playinforesult;

import android.text.TextUtils;
import com.youku.playerservice.axp.PlayerConfig;
import com.youku.playerservice.axp.item.LiveItem;
import com.youku.playerservice.axp.playinfo.PlayInfo;
import com.youku.playerservice.axp.playinfo.PlayInfoResponse;
import com.youku.playerservice.axp.playinfo.PlayInfoResult;
import com.youku.playerservice.axp.playparams.PlayParams;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class PlayLiveInfoResult {
    private PlayerConfig mPlayerConfig;

    public PlayLiveInfoResult(PlayerConfig playerConfig) {
        this.mPlayerConfig = playerConfig;
    }

    public static List<PlayInfo> getPlayInfo(PlayParams playParams, PlayerConfig playerConfig, PlayInfoResponse playInfoResponse) {
        ArrayList arrayList = new ArrayList();
        List playItem = playInfoResponse.getPlayItem(playParams);
        if (playInfoResponse.getError() == null && playItem != null && playItem.size() > 0) {
            for (int i = 0; i < playItem.size(); i++) {
                PlayInfo playInfo = new PlayInfo(playParams, playerConfig);
                playInfo.setPlayInfoResponse(playInfoResponse);
                playInfo.setPlayIndex(i);
                playInfo.setPlayItem((LiveItem) playItem.get(i));
                if (playInfoResponse.getLiveInfo() != null && playInfoResponse.getLiveInfo().getLivePlayControl() != null && playInfoResponse.getLiveInfo().getLivePlayControl().bizSwitch.timeShift == 1) {
                    String string = playParams.getString("features");
                    if (TextUtils.isEmpty(string)) {
                        playParams.putString("features", "timeshift");
                    } else if (!string.contains("timeshift")) {
                        playParams.putString("features", string + ",timeshift");
                    }
                }
                arrayList.add(playInfo);
            }
        }
        return arrayList;
    }

    public static PlayInfoResult getPlayInfoResult(List<PlayInfo> list) {
        PlayInfoResult playInfoResult = null;
        for (int i = 0; i < list.size(); i++) {
            PlayInfo playInfo = list.get(i);
            if (i == 0) {
                playInfoResult = new PlayInfoResult(playInfo);
            }
            playInfoResult.addPlayInfo(playInfo);
        }
        return playInfoResult;
    }

    public PlayInfoResult getPlayInfoResult(PlayParams playParams, PlayInfoResponse playInfoResponse) {
        List playItem = playInfoResponse.getPlayItem(playParams);
        if (playInfoResponse.getError() != null || playItem == null || playItem.size() <= 0) {
            PlayInfoResult playInfoResult = new PlayInfoResult(playInfoResponse.getError());
            PlayInfo playInfo = new PlayInfo(playParams, this.mPlayerConfig);
            playInfo.setPlayInfoResponse(playInfoResponse);
            playInfoResult.setPlayInfo(playInfo);
            playInfoResult.addPlayInfo(playInfo);
            return playInfoResult;
        }
        PlayInfoResult playInfoResult2 = null;
        for (int i = 0; i < playItem.size(); i++) {
            PlayInfo playInfo2 = new PlayInfo(playParams, this.mPlayerConfig);
            playInfo2.setPlayInfoResponse(playInfoResponse);
            playInfo2.setPlayIndex(i);
            playInfo2.setPlayItem((LiveItem) playItem.get(i));
            if (playInfoResponse.getLiveInfo() != null && playInfoResponse.getLiveInfo().getLivePlayControl() != null && playInfoResponse.getLiveInfo().getLivePlayControl().bizSwitch.timeShift == 1) {
                String string = playParams.getString("features");
                if (TextUtils.isEmpty(string)) {
                    playParams.putString("features", "timeshift");
                } else if (!string.contains("timeshift")) {
                    playParams.putString("features", string + ",timeshift");
                }
            }
            if (i == 0) {
                playInfoResult2 = new PlayInfoResult(playInfo2);
            }
            playInfoResult2.addPlayInfo(playInfo2);
        }
        return playInfoResult2;
    }
}
