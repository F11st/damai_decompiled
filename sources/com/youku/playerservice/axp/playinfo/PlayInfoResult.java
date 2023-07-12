package com.youku.playerservice.axp.playinfo;

import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class PlayInfoResult {
    private PlayInfoError mError;
    private List<PlayInfo> mOtherPlayInfos = new ArrayList();
    private PlayInfo mPlayInfo;

    public PlayInfoResult(PlayInfo playInfo) {
        this.mPlayInfo = playInfo;
    }

    public PlayInfoResult(PlayInfoError playInfoError) {
        this.mError = playInfoError;
    }

    public void addPlayInfo(PlayInfo playInfo) {
        if (playInfo != null) {
            this.mOtherPlayInfos.add(playInfo);
        }
    }

    public PlayInfoError getError() {
        return this.mError;
    }

    public List<PlayInfo> getOtherPlayInfos() {
        return this.mOtherPlayInfos;
    }

    public PlayInfo getPlayInfo() {
        return this.mPlayInfo;
    }

    public void setError(PlayInfoError playInfoError) {
        this.mError = playInfoError;
    }

    public void setPlayInfo(PlayInfo playInfo) {
        this.mPlayInfo = playInfo;
    }
}
