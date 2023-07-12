package com.youku.live.dago.liveplayback.widget.plugins.tipsview;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.liveplayback.widget.plugins.tipsview.TipsConstants;
import com.youku.live.dago.liveplayback.widget.plugins.tipsview.widget.ITipsPresenter;
import com.youku.live.dago.liveplayback.widget.plugins.tipsview.widget.TipsPosition;
import java.util.Map;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class TipsConfig {
    private static transient /* synthetic */ IpChange $ipChange;
    private static final Long DEFAULT_DISPLAY_TIME = 3000L;
    public static final Long MAX_DISPLAY_DURATION = 600000L;
    private Map<String, Object> extraMap;
    private TipsPosition position;
    private String tipId;
    private ITipsPresenter tipsPresenter;
    private BaseTipsUiConfig tipsUiConfig;
    private long displayTime = -1;
    private int tipsLevel = 0;
    private String tipsKey = TipsConstants.LeftBottomTips.KEY.KEY_DEFAULT;
    private FrequencyType frequencyType = FrequencyType.NO_LIMIT;
    private int frequency = Integer.MAX_VALUE;
    private String description = "";

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public enum FrequencyType {
        NO_LIMIT,
        DAY,
        APP_INSTALL,
        APP_RUN,
        DAYS
    }

    private Map<String, Object> getExtraMap() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-850683615") ? (Map) ipChange.ipc$dispatch("-850683615", new Object[]{this}) : this.extraMap;
    }

    public String getDescription() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1394853738") ? (String) ipChange.ipc$dispatch("1394853738", new Object[]{this}) : this.description;
    }

    public long getDisplayTime() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "497962071") ? ((Long) ipChange.ipc$dispatch("497962071", new Object[]{this})).longValue() : this.displayTime;
    }

    public int getFrequency() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-303647287") ? ((Integer) ipChange.ipc$dispatch("-303647287", new Object[]{this})).intValue() : this.frequency;
    }

    public FrequencyType getFrequencyType() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1207717668") ? (FrequencyType) ipChange.ipc$dispatch("-1207717668", new Object[]{this}) : this.frequencyType;
    }

    public TipsPosition getPosition() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1339407985") ? (TipsPosition) ipChange.ipc$dispatch("-1339407985", new Object[]{this}) : this.position;
    }

    public String getTipId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1273825340") ? (String) ipChange.ipc$dispatch("-1273825340", new Object[]{this}) : this.tipId;
    }

    public String getTipsKey() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-752254603") ? (String) ipChange.ipc$dispatch("-752254603", new Object[]{this}) : this.tipsKey;
    }

    public int getTipsLevel() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "804326905") ? ((Integer) ipChange.ipc$dispatch("804326905", new Object[]{this})).intValue() : this.tipsLevel;
    }

    public ITipsPresenter getTipsPresenter() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1802045366") ? (ITipsPresenter) ipChange.ipc$dispatch("1802045366", new Object[]{this}) : this.tipsPresenter;
    }

    public BaseTipsUiConfig getTipsUiConfig() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2017111") ? (BaseTipsUiConfig) ipChange.ipc$dispatch("2017111", new Object[]{this}) : this.tipsUiConfig;
    }

    public TipsConfig setDescription(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "773150302")) {
            return (TipsConfig) ipChange.ipc$dispatch("773150302", new Object[]{this, str});
        }
        this.description = str;
        return this;
    }

    public TipsConfig setDisplayTime(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "190026951")) {
            return (TipsConfig) ipChange.ipc$dispatch("190026951", new Object[]{this, Long.valueOf(j)});
        }
        Long l = MAX_DISPLAY_DURATION;
        if (j > l.longValue()) {
            j = l.longValue();
        }
        this.displayTime = j;
        return this;
    }

    public void setExtraMap(Map<String, Object> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1012406235")) {
            ipChange.ipc$dispatch("-1012406235", new Object[]{this, map});
        } else {
            this.extraMap = map;
        }
    }

    public TipsConfig setFrequency(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "734383347")) {
            return (TipsConfig) ipChange.ipc$dispatch("734383347", new Object[]{this, Integer.valueOf(i)});
        }
        this.frequency = i;
        return this;
    }

    public TipsConfig setFrequencyType(FrequencyType frequencyType) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1953117574")) {
            return (TipsConfig) ipChange.ipc$dispatch("-1953117574", new Object[]{this, frequencyType});
        }
        this.frequencyType = frequencyType;
        return this;
    }

    public TipsConfig setPosition(TipsPosition tipsPosition) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "240448189")) {
            return (TipsConfig) ipChange.ipc$dispatch("240448189", new Object[]{this, tipsPosition});
        }
        this.position = tipsPosition;
        return this;
    }

    public void setTipId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1657487666")) {
            ipChange.ipc$dispatch("1657487666", new Object[]{this, str});
        } else {
            this.tipId = str;
        }
    }

    public TipsConfig setTipsKey(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1358260531")) {
            return (TipsConfig) ipChange.ipc$dispatch("1358260531", new Object[]{this, str});
        }
        this.tipsKey = str;
        return this;
    }

    public TipsConfig setTipsLevel(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1153133885")) {
            return (TipsConfig) ipChange.ipc$dispatch("-1153133885", new Object[]{this, Integer.valueOf(i)});
        }
        this.tipsLevel = i;
        return this;
    }

    public TipsConfig setTipsUiConfig(BaseTipsUiConfig baseTipsUiConfig) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2118005775")) {
            return (TipsConfig) ipChange.ipc$dispatch("-2118005775", new Object[]{this, baseTipsUiConfig});
        }
        this.tipsUiConfig = baseTipsUiConfig;
        return this;
    }

    public TipsConfig setTipsView(ITipsPresenter iTipsPresenter) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1693781955")) {
            return (TipsConfig) ipChange.ipc$dispatch("1693781955", new Object[]{this, iTipsPresenter});
        }
        this.tipsPresenter = iTipsPresenter;
        return this;
    }

    public String toString() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-525166896")) {
            return (String) ipChange.ipc$dispatch("-525166896", new Object[]{this});
        }
        return "[tipId:" + this.tipId + "|tipsLevel:" + this.tipsLevel + "|displayTime:" + this.displayTime + "|frequencyType:" + this.frequencyType + "|frequency:" + this.frequency + "|tipsKey:" + this.tipsKey + "|description:" + this.description + jn1.ARRAY_END_STR;
    }
}
