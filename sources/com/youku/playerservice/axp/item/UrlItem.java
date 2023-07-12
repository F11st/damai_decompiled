package com.youku.playerservice.axp.item;

import com.youku.playerservice.axp.playparams.PlayParams;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class UrlItem extends PlayItem {
    private String mPlayUrl;

    public UrlItem(PlayParams playParams) {
        super(playParams);
        if (playParams.getPlayUrlParams() != null) {
            this.mPlayFormat = playParams.getPlayUrlParams().getPlayFormat();
        }
    }

    @Override // com.youku.playerservice.axp.item.PlayItem
    public String getPlayUrl() {
        return this.mPlayUrl;
    }

    public void setPlayUrl(String str) {
        this.mPlayUrl = str;
    }
}
