package com.youku.android.liveservice.bean;

import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class VideoInfo {
    public boolean ad;
    public String adInfo;
    public String bizType;
    public BypassPlayInfo bypassPlayInfo;
    public long costTime;
    public boolean isLaifengPk;
    public boolean isTrail;
    public boolean landscape;
    public String liveId;
    public LivePlayControl livePlayControl;
    public int liveStatus;
    public String loginYtid;
    public int mcu;
    public List<MicPlayInfo> micPlayInfos;
    public List<String> poList;
    public String protocol;
    public String pushStreamType;
    public String screenId;
    public int status;
    public String streamMode;
    public String videoFormat;
    public List<WaterMarkV2> waterMarkV2List;

    public BizType getBizType() {
        return BizType.getBizTypeByValue(this.bizType);
    }
}
