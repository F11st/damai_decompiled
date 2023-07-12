package com.youku.playerservice.axp.playparams;

import com.youku.playerservice.axp.axpinterface.PlayDefinition;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class PlayUrlParams {
    private PlayDefinition.PlayFormat mPlayFormat;
    private String mPlayUrl;

    private PlayUrlParams(String str, PlayDefinition.PlayFormat playFormat) {
        this.mPlayFormat = PlayDefinition.PlayFormat.UNKNOWN;
        this.mPlayUrl = str;
        this.mPlayFormat = playFormat;
    }

    public static PlayUrlParams createPlayUrlParams(String str, PlayDefinition.PlayFormat playFormat) {
        return new PlayUrlParams(str, playFormat);
    }

    public PlayDefinition.PlayFormat getPlayFormat() {
        return this.mPlayFormat;
    }

    public String getPlayUrl() {
        return this.mPlayUrl;
    }
}
