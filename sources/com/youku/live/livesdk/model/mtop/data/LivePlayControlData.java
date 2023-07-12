package com.youku.live.livesdk.model.mtop.data;

import com.youku.live.livesdk.model.mtop.data.liveplaycontrol.BizSwitch;
import com.youku.live.livesdk.model.mtop.data.liveplaycontrol.LivePlayAbilityDefaultQualityDTO;
import com.youku.live.livesdk.model.mtop.data.liveplaycontrol.LiveSceneV5Dto;
import com.youku.live.livesdk.model.mtop.data.liveplaycontrol.MultiWatermarkHumpDto;
import com.youku.live.livesdk.model.mtop.data.liveplaycontrol.PlayCtrlDTO;
import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class LivePlayControlData implements Serializable {
    public Boolean ad;
    public String adInfo;
    public String areaCode;
    public Integer audioDq;
    public List<AudioInfoDto> audioInfo;
    public String bizExtra;
    public Long bizType;
    public String broadcastVideoCode;
    public String countryCode;
    public Integer dq;
    public LivePlayAbilityDefaultQualityDTO dqDolby;
    public Long endTimestamp;
    public Integer hasAudio;
    public Boolean landscape;
    public Long liveId;
    public Integer liveStatus;
    public Long loginYtid;
    public Integer mcu;
    public PlayCtrlDTO micInfo;
    public Long now;
    public Boolean paid;
    public Object payScenes;
    public Boolean play;
    public Integer playMode;
    public String psid;
    public List<QualityCtrlDto> qualities;
    public Long sceneId;
    public Integer sceneType;
    public Long screenId;
    public Long startTimestamp;
    public List<LiveSceneV5Dto> stream;
    public String streamMode;
    public String tryPlayNotice;
    public String tryPlayTime;
    public Boolean userPaid;
    public String verifyFailRedirectUrl;
    public String videoUrlCode;
    public Integer videoUrlQuality;
    public List<MultiWatermarkHumpDto> waterMark;

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public static class AudioInfoDto implements Serializable {
        public String name;
        public String playUrl;
        public Integer quality;
    }

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public static class QualityCtrlDto implements Serializable {
        public String bitStream;
        public Integer bizCode;
        public BizSwitch bizSwitch;
        public String cRk;
        public Integer code;
        public String eRs;
        public String h264PlayUrl;
        public Integer h265;
        public String h265PlayUrl;
        public String msg;
        public String name;
        public String playType;
        public Integer quality;
        public String selectionName;
        public String subtitleUrl;
        public Integer timeShiftOffset;
        public Integer vr;
    }
}
