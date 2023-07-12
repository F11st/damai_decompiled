package com.youku.playerservice.axp.item;

import com.youku.playerservice.axp.axpinterface.PlayDefinition;
import com.youku.playerservice.axp.playparams.PlayParams;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class PlayItem {
    protected PlayDefinition.PlayFormat mPlayFormat = PlayDefinition.PlayFormat.UNKNOWN;
    protected PlayParams mPlayParams;
    protected String mPlayUrl;
    protected SliceItem sliceItem;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static class Result {
        public static final String CODE = "code";
        public static final String FIRST_URL = "firstUrl";
        public static final String NOTE = "note";
        public static final String SECOND_URL = "secondUrl";
        private final Map<String, Object> data = new HashMap();
        private final boolean isSame;

        public Result(boolean z) {
            this.isSame = z;
        }

        public Object getValue(String str) {
            return this.data.get(str);
        }

        public boolean isSame() {
            return this.isSame;
        }

        public void putValue(String str, Object obj) {
            this.data.put(str, obj);
        }
    }

    public PlayItem(PlayParams playParams) {
        this.mPlayParams = playParams;
    }

    public String getCellularDomain() {
        return "";
    }

    public int getDuration() {
        return 0;
    }

    public String getLangCode() {
        return null;
    }

    public PlayDefinition.PlayFormat getPlayFormat() {
        return this.mPlayFormat;
    }

    public PlayParams getPlayParams() {
        return this.mPlayParams;
    }

    public String getPlayUrl() {
        return this.mPlayUrl;
    }

    public String getPlayWay() {
        return "net";
    }

    public Quality getQuality() {
        return Quality.UNKNOWN;
    }

    public SliceItem getSliceItem() {
        return this.sliceItem;
    }

    public String getStreamType() {
        return "";
    }

    public String getVideoFormat() {
        return null;
    }

    public String getWifiDomain() {
        return "";
    }

    public Result match(PlayItem playItem) {
        return new Result(true);
    }

    public void setPlayFormat(PlayDefinition.PlayFormat playFormat) {
        this.mPlayFormat = playFormat;
    }
}
