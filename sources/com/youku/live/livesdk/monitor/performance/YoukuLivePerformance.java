package com.youku.live.livesdk.monitor.performance;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class YoukuLivePerformance extends AbsPerformance {
    private static transient /* synthetic */ IpChange $ipChange;
    private boolean hasFullInfoMtopEnd;
    private boolean hasFullInfoStart;
    private boolean hasLiveCoreFirstFrame;
    private boolean hasLiveCoreInfo;
    private boolean hasLiveFirstFrame;
    private boolean hasLiveStart;
    private boolean hasPkType;

    public YoukuLivePerformance() {
        super(YoukuLivePerformanceConstants.MODULE_NAME, YoukuLivePerformanceConstants.MONITOR_POINT, YoukuLivePerformanceConstants.PAGE_NAME, "", YoukuLivePerformanceConstants.DIMS, YoukuLivePerformanceConstants.MESS);
        this.hasLiveStart = false;
        this.hasLiveFirstFrame = false;
        this.hasLiveCoreFirstFrame = false;
        this.hasLiveCoreInfo = false;
        this.hasPkType = false;
        this.hasFullInfoStart = false;
        this.hasFullInfoMtopEnd = false;
    }

    public YoukuLivePerformance report() {
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "1261282778")) {
            return (YoukuLivePerformance) ipChange.ipc$dispatch("1261282778", new Object[]{this});
        }
        Map<String, Double> measureValueMap = getMeasureValueMap();
        getDimensionValueMap();
        if (measureValueMap.containsKey(YoukuLivePerformanceConstants.MES_NAVIGATE_END) && measureValueMap.containsKey(YoukuLivePerformanceConstants.MES_PAGE_END) && measureValueMap.containsKey(YoukuLivePerformanceConstants.MES_TEMPLATE_END) && measureValueMap.containsKey(YoukuLivePerformanceConstants.MES_FULL_INFO_END) && measureValueMap.containsKey(YoukuLivePerformanceConstants.MES_WEEX_END) && measureValueMap.containsKey(YoukuLivePerformanceConstants.MES_CHANNEL_END)) {
            if (measureValueMap.containsKey(YoukuLivePerformanceConstants.MES_LIVE_START) && measureValueMap.containsKey(YoukuLivePerformanceConstants.MES_LIVE_FIRST_FRAME)) {
                setDimension(YoukuLivePerformanceConstants.DIM_REPORT_TYPE, "0");
            } else if (measureValueMap.containsKey(YoukuLivePerformanceConstants.MES_AUDIO_START) && measureValueMap.containsKey(YoukuLivePerformanceConstants.MES_AUDIO_JOIN_CHANNEL) && measureValueMap.containsKey(YoukuLivePerformanceConstants.MES_AUDIO_HEAR_SOUND)) {
                setDimension(YoukuLivePerformanceConstants.DIM_REPORT_TYPE, "0");
            }
            z = true;
        }
        if (!z) {
            setDimension(YoukuLivePerformanceConstants.DIM_REPORT_TYPE, "1");
        }
        commit();
        return this;
    }

    public YoukuLivePerformance setAudioHearSound(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1919035755")) {
            return (YoukuLivePerformance) ipChange.ipc$dispatch("-1919035755", new Object[]{this, Long.valueOf(j)});
        }
        setMeasure(YoukuLivePerformanceConstants.MES_AUDIO_HEAR_SOUND, j);
        return this;
    }

    public YoukuLivePerformance setAudioJoinChannel(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "696344205")) {
            return (YoukuLivePerformance) ipChange.ipc$dispatch("696344205", new Object[]{this, Long.valueOf(j)});
        }
        setMeasure(YoukuLivePerformanceConstants.MES_AUDIO_JOIN_CHANNEL, j);
        return this;
    }

    public YoukuLivePerformance setAudioJoinError(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-262090464")) {
            return (YoukuLivePerformance) ipChange.ipc$dispatch("-262090464", new Object[]{this, str});
        }
        setDimension(YoukuLivePerformanceConstants.DIM_AUDIO_JOIN_ERROR, str);
        return this;
    }

    public YoukuLivePerformance setAudioRoomType() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-693634363") ? (YoukuLivePerformance) ipChange.ipc$dispatch("-693634363", new Object[]{this}) : setRoomType("2");
    }

    public YoukuLivePerformance setAudioStart(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "711734")) {
            return (YoukuLivePerformance) ipChange.ipc$dispatch("711734", new Object[]{this, Long.valueOf(j)});
        }
        setMeasure(YoukuLivePerformanceConstants.MES_AUDIO_START, j);
        return this;
    }

    public YoukuLivePerformance setBizType(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2065625203")) {
            return (YoukuLivePerformance) ipChange.ipc$dispatch("-2065625203", new Object[]{this, str});
        }
        setDimString("biz_type", str);
        return this;
    }

    public YoukuLivePerformance setChannelEnd(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1684007138")) {
            return (YoukuLivePerformance) ipChange.ipc$dispatch("1684007138", new Object[]{this, Long.valueOf(j)});
        }
        setMeasure(YoukuLivePerformanceConstants.MES_CHANNEL_END, j);
        return this;
    }

    public YoukuLivePerformance setChannelError(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-467304445")) {
            return (YoukuLivePerformance) ipChange.ipc$dispatch("-467304445", new Object[]{this, str});
        }
        setDimension(YoukuLivePerformanceConstants.DIM_CHANNEL_ERROR, str);
        return this;
    }

    public YoukuLivePerformance setChannelStart(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1483108503")) {
            return (YoukuLivePerformance) ipChange.ipc$dispatch("-1483108503", new Object[]{this, Long.valueOf(j)});
        }
        setMeasure(YoukuLivePerformanceConstants.MES_CHANNEL_START, j);
        return this;
    }

    public YoukuLivePerformance setDimBoolean(String str, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-174393072")) {
            return (YoukuLivePerformance) ipChange.ipc$dispatch("-174393072", new Object[]{this, str, Boolean.valueOf(z)});
        }
        if (!TextUtils.isEmpty(str)) {
            setDimension(str, z ? "1" : "0");
        }
        return this;
    }

    public YoukuLivePerformance setDimInt(String str, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1613349306")) {
            return (YoukuLivePerformance) ipChange.ipc$dispatch("-1613349306", new Object[]{this, str, Integer.valueOf(i)});
        }
        if (!TextUtils.isEmpty(str)) {
            setDimension(str, String.valueOf(i));
        }
        return this;
    }

    public YoukuLivePerformance setDimString(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1982629621")) {
            return (YoukuLivePerformance) ipChange.ipc$dispatch("-1982629621", new Object[]{this, str, str2});
        }
        if (!TextUtils.isEmpty(str)) {
            if (str2 == null) {
                str2 = "null";
            }
            setDimension(str, str2);
        }
        return this;
    }

    public YoukuLivePerformance setEnterType(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1324080936")) {
            return (YoukuLivePerformance) ipChange.ipc$dispatch("1324080936", new Object[]{this, str});
        }
        setDimString(YoukuLivePerformanceConstants.DIM_ENTER_TYPE, str);
        return this;
    }

    public YoukuLivePerformance setFirstEnter(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2073144866")) {
            return (YoukuLivePerformance) ipChange.ipc$dispatch("2073144866", new Object[]{this, Boolean.valueOf(z)});
        }
        setDimBoolean(YoukuLivePerformanceConstants.DIM_FIRST_ENTER, z);
        return this;
    }

    public YoukuLivePerformance setFullInfoEnd() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1499072786")) {
            return (YoukuLivePerformance) ipChange.ipc$dispatch("1499072786", new Object[]{this});
        }
        if (!hasDimension(YoukuLivePerformanceConstants.DIM_FULL_INFO_ERROR) && !hasDimension(YoukuLivePerformanceConstants.MES_FULL_INFO_END)) {
            setMeasure(YoukuLivePerformanceConstants.MES_FULL_INFO_END);
        }
        return this;
    }

    public YoukuLivePerformance setFullInfoError(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "182806095")) {
            return (YoukuLivePerformance) ipChange.ipc$dispatch("182806095", new Object[]{this, str});
        }
        if (!hasDimension(YoukuLivePerformanceConstants.DIM_FULL_INFO_ERROR) && !hasDimension(YoukuLivePerformanceConstants.MES_FULL_INFO_END)) {
            setDimension(YoukuLivePerformanceConstants.DIM_FULL_INFO_ERROR, str);
        }
        return this;
    }

    public YoukuLivePerformance setFullInfoMtopEnd() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "736889338")) {
            return (YoukuLivePerformance) ipChange.ipc$dispatch("736889338", new Object[]{this});
        }
        if (this.hasFullInfoMtopEnd) {
            return this;
        }
        this.hasFullInfoMtopEnd = true;
        setMeasure(YoukuLivePerformanceConstants.MES_FULL_INFO_MTOP_END);
        return this;
    }

    public YoukuLivePerformance setFullInfoStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1032973653")) {
            return (YoukuLivePerformance) ipChange.ipc$dispatch("-1032973653", new Object[]{this});
        }
        if (this.hasFullInfoStart) {
            return this;
        }
        this.hasFullInfoStart = true;
        setMeasure(YoukuLivePerformanceConstants.MES_FULL_INFO_START);
        return this;
    }

    public YoukuLivePerformance setHasPageInfo(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1387964509")) {
            return (YoukuLivePerformance) ipChange.ipc$dispatch("-1387964509", new Object[]{this, str});
        }
        setDimString(YoukuLivePerformanceConstants.DIM_HAS_PAGEINFO, str);
        return this;
    }

    public YoukuLivePerformance setHasPlayInfo(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1572825758")) {
            return (YoukuLivePerformance) ipChange.ipc$dispatch("1572825758", new Object[]{this, str});
        }
        setDimString(YoukuLivePerformanceConstants.DIM_HAS_PLAYINFO, str);
        return this;
    }

    public YoukuLivePerformance setHasPlayInfoUrl(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-726571219")) {
            return (YoukuLivePerformance) ipChange.ipc$dispatch("-726571219", new Object[]{this, Boolean.valueOf(z)});
        }
        setDimBoolean(YoukuLivePerformanceConstants.DIM_HAS_PLAY_INFO_URL, z);
        return this;
    }

    public YoukuLivePerformance setHasRtcInfo(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-800951217")) {
            return (YoukuLivePerformance) ipChange.ipc$dispatch("-800951217", new Object[]{this, Boolean.valueOf(z)});
        }
        setDimBoolean(YoukuLivePerformanceConstants.DIM_HAS_RTC_INFO, z);
        return this;
    }

    public YoukuLivePerformance setHitTemplateCache(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2036988625")) {
            return (YoukuLivePerformance) ipChange.ipc$dispatch("-2036988625", new Object[]{this, Boolean.valueOf(z)});
        }
        setDimBoolean(YoukuLivePerformanceConstants.DIM_HIT_TEMPLATE_CACHE, z);
        return this;
    }

    public YoukuLivePerformance setListOrder(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-921683801")) {
            return (YoukuLivePerformance) ipChange.ipc$dispatch("-921683801", new Object[]{this, Integer.valueOf(i)});
        }
        setDimInt(YoukuLivePerformanceConstants.DIM_LIST_ORDER, i);
        return this;
    }

    public YoukuLivePerformance setLiveCoreFirstFrame(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1449915214")) {
            return (YoukuLivePerformance) ipChange.ipc$dispatch("-1449915214", new Object[]{this, Long.valueOf(j)});
        }
        if (!this.hasLiveCoreFirstFrame) {
            this.hasLiveCoreFirstFrame = true;
            setMeasure(YoukuLivePerformanceConstants.MES_LIVE_CORE_FIRST_FRAME, j);
        }
        return this;
    }

    public YoukuLivePerformance setLiveCoreInfo(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-375460529")) {
            return (YoukuLivePerformance) ipChange.ipc$dispatch("-375460529", new Object[]{this, str});
        }
        if (!this.hasLiveCoreInfo) {
            this.hasLiveCoreInfo = true;
            setDimension(YoukuLivePerformanceConstants.DIM_PLAYER_CORE_INFO, str);
        }
        return this;
    }

    public YoukuLivePerformance setLiveFirstFrame(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "940182963")) {
            return (YoukuLivePerformance) ipChange.ipc$dispatch("940182963", new Object[]{this, Long.valueOf(j)});
        }
        if (!this.hasLiveFirstFrame) {
            this.hasLiveFirstFrame = true;
            setMeasure(YoukuLivePerformanceConstants.MES_LIVE_FIRST_FRAME, j);
        }
        return this;
    }

    public YoukuLivePerformance setLiveId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1208547807")) {
            return (YoukuLivePerformance) ipChange.ipc$dispatch("-1208547807", new Object[]{this, str});
        }
        setDimString(YoukuLivePerformanceConstants.DIM_LIVE_ID, str);
        return this;
    }

    public YoukuLivePerformance setLiveStart(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-259551506")) {
            return (YoukuLivePerformance) ipChange.ipc$dispatch("-259551506", new Object[]{this, Long.valueOf(j)});
        }
        if (!this.hasLiveStart) {
            this.hasLiveStart = true;
            setMeasure(YoukuLivePerformanceConstants.MES_LIVE_START, j);
        }
        return this;
    }

    public YoukuLivePerformance setLiveStatus(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-70555094")) {
            return (YoukuLivePerformance) ipChange.ipc$dispatch("-70555094", new Object[]{this, str});
        }
        setDimension(YoukuLivePerformanceConstants.DIM_LIVE_STATUS, str);
        return this;
    }

    public YoukuLivePerformance setLiveStatusLive() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-598988076") ? (YoukuLivePerformance) ipChange.ipc$dispatch("-598988076", new Object[]{this}) : setLiveStatus("1");
    }

    public YoukuLivePerformance setLiveStatusPreview() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-522007386") ? (YoukuLivePerformance) ipChange.ipc$dispatch("-522007386", new Object[]{this}) : setLiveStatus("0");
    }

    public YoukuLivePerformance setLiveStatusReplay() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1826112441") ? (YoukuLivePerformance) ipChange.ipc$dispatch("1826112441", new Object[]{this}) : setLiveStatus("2");
    }

    public YoukuLivePerformance setLiveStatusUnknown() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "174796004") ? (YoukuLivePerformance) ipChange.ipc$dispatch("174796004", new Object[]{this}) : setLiveStatus("0");
    }

    public YoukuLivePerformance setNavigateEnd(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1574925826")) {
            return (YoukuLivePerformance) ipChange.ipc$dispatch("1574925826", new Object[]{this, Long.valueOf(j)});
        }
        setMeasure(YoukuLivePerformanceConstants.MES_NAVIGATE_END, j);
        return this;
    }

    public YoukuLivePerformance setNavigateStart(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1063933065")) {
            return (YoukuLivePerformance) ipChange.ipc$dispatch("1063933065", new Object[]{this, Long.valueOf(j)});
        }
        if (!hasMeasure(YoukuLivePerformanceConstants.MES_NAVIGATE_START)) {
            setMeasure(YoukuLivePerformanceConstants.MES_NAVIGATE_START, j);
        }
        return this;
    }

    public YoukuLivePerformance setNavigatorUrl(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1400567536")) {
            return (YoukuLivePerformance) ipChange.ipc$dispatch("-1400567536", new Object[]{this, str});
        }
        setDimString(YoukuLivePerformanceConstants.DIM_NAVIGATOR_URL, str);
        return this;
    }

    public YoukuLivePerformance setOtherRoomType() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "434077515") ? (YoukuLivePerformance) ipChange.ipc$dispatch("434077515", new Object[]{this}) : setRoomType("0");
    }

    public YoukuLivePerformance setPageEnd(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "920673956")) {
            return (YoukuLivePerformance) ipChange.ipc$dispatch("920673956", new Object[]{this, Long.valueOf(j)});
        }
        setMeasure(YoukuLivePerformanceConstants.MES_PAGE_END, j);
        return this;
    }

    public YoukuLivePerformance setPageStart(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-606888789")) {
            return (YoukuLivePerformance) ipChange.ipc$dispatch("-606888789", new Object[]{this, Long.valueOf(j)});
        }
        setMeasure(YoukuLivePerformanceConstants.MES_PAGE_START, j);
        return this;
    }

    public YoukuLivePerformance setPkType(boolean z, boolean z2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1977143063")) {
            return (YoukuLivePerformance) ipChange.ipc$dispatch("-1977143063", new Object[]{this, Boolean.valueOf(z), Boolean.valueOf(z2)});
        }
        if (!this.hasPkType) {
            this.hasPkType = true;
            setDimension(YoukuLivePerformanceConstants.DIM_PK_TYPE, !z ? "0" : z2 ? "2" : "1");
        }
        return this;
    }

    public YoukuLivePerformance setPlayControlEnd(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-525891812")) {
            return (YoukuLivePerformance) ipChange.ipc$dispatch("-525891812", new Object[]{this, Long.valueOf(j)});
        }
        setMeasure(YoukuLivePerformanceConstants.MES_PLAY_CONTROL_END, j);
        return this;
    }

    public YoukuLivePerformance setPlayControlStart(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "812812067")) {
            return (YoukuLivePerformance) ipChange.ipc$dispatch("812812067", new Object[]{this, Long.valueOf(j)});
        }
        setMeasure(YoukuLivePerformanceConstants.MES_PLAY_CONTROL_START, j);
        return this;
    }

    public YoukuLivePerformance setPlayInfoErrorCode(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "697368263")) {
            return (YoukuLivePerformance) ipChange.ipc$dispatch("697368263", new Object[]{this, str});
        }
        setDimString(YoukuLivePerformanceConstants.DIM_PLAYINFO_ERRORCODE, str);
        return this;
    }

    public YoukuLivePerformance setPlayInfoFormat(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "621335791")) {
            return (YoukuLivePerformance) ipChange.ipc$dispatch("621335791", new Object[]{this, str});
        }
        setDimString(YoukuLivePerformanceConstants.DIM_PLAY_INFO_FORMAT, str);
        return this;
    }

    public YoukuLivePerformance setPlayInfoRefetch(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1020425099")) {
            return (YoukuLivePerformance) ipChange.ipc$dispatch("-1020425099", new Object[]{this, str});
        }
        setDimString(YoukuLivePerformanceConstants.DIM_PLAYINFO_REFETCH, str);
        return this;
    }

    public YoukuLivePerformance setPlayInfoRefetchPageName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-394588453")) {
            return (YoukuLivePerformance) ipChange.ipc$dispatch("-394588453", new Object[]{this, str});
        }
        setDimString(YoukuLivePerformanceConstants.DIM_PLAYINFO_REFETCH_PAGENAME, str);
        return this;
    }

    public YoukuLivePerformance setPlayInfoStatus(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-523522092")) {
            return (YoukuLivePerformance) ipChange.ipc$dispatch("-523522092", new Object[]{this, str});
        }
        setDimString(YoukuLivePerformanceConstants.DIM_PLAYINFO_STATUS, str);
        return this;
    }

    public YoukuLivePerformance setPreprocess(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "512559238")) {
            return (YoukuLivePerformance) ipChange.ipc$dispatch("512559238", new Object[]{this, Boolean.valueOf(z)});
        }
        setDimBoolean(YoukuLivePerformanceConstants.DIM_PREPROCESS, z);
        return this;
    }

    public YoukuLivePerformance setReportType(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1644269978")) {
            return (YoukuLivePerformance) ipChange.ipc$dispatch("1644269978", new Object[]{this, str});
        }
        setDimString(YoukuLivePerformanceConstants.DIM_REPORT_TYPE, str);
        return this;
    }

    public YoukuLivePerformance setRetryFullInfo(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-391713796")) {
            return (YoukuLivePerformance) ipChange.ipc$dispatch("-391713796", new Object[]{this, Integer.valueOf(i)});
        }
        setDimInt(YoukuLivePerformanceConstants.DIM_RETRY_FULL_INFO, i);
        return this;
    }

    public YoukuLivePerformance setRetryWeex(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-678762767")) {
            return (YoukuLivePerformance) ipChange.ipc$dispatch("-678762767", new Object[]{this, str});
        }
        setDimString(YoukuLivePerformanceConstants.DIM_RETRY_WEEX, str);
        return this;
    }

    public YoukuLivePerformance setRoomType(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "373430675")) {
            return (YoukuLivePerformance) ipChange.ipc$dispatch("373430675", new Object[]{this, str});
        }
        setDimString(YoukuLivePerformanceConstants.DIM_ROOM_TYPE, str);
        return this;
    }

    public YoukuLivePerformance setSourceFrom(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1919674845")) {
            return (YoukuLivePerformance) ipChange.ipc$dispatch("-1919674845", new Object[]{this, str});
        }
        setDimension("source_from", str);
        return this;
    }

    public YoukuLivePerformance setSpmUrl(String str) {
        String str2;
        String str3;
        String str4;
        String[] split;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "879443625")) {
            return (YoukuLivePerformance) ipChange.ipc$dispatch("879443625", new Object[]{this, str});
        }
        if (!TextUtils.isEmpty(str)) {
            String str5 = null;
            try {
                split = str.split("\\.");
                str2 = split.length >= 1 ? split[0] : null;
            } catch (Throwable unused) {
                str2 = null;
                str3 = null;
            }
            try {
                str3 = split.length >= 2 ? split[1] : null;
                try {
                    str4 = split.length >= 3 ? split[2] : null;
                    try {
                        if (split.length >= 4) {
                            str5 = split[3];
                        }
                    } catch (Throwable unused2) {
                    }
                } catch (Throwable unused3) {
                    str4 = null;
                }
            } catch (Throwable unused4) {
                str3 = null;
                str4 = str3;
                setDimString(YoukuLivePerformanceConstants.DIM_SPM_URL_A, str2);
                setDimString(YoukuLivePerformanceConstants.DIM_SPM_URL_B, str3);
                setDimString(YoukuLivePerformanceConstants.DIM_SPM_URL_C, str4);
                setDimString(YoukuLivePerformanceConstants.DIM_SPM_URL_D, str5);
                setDimString(YoukuLivePerformanceConstants.DIM_SPM_URL_AB, str2 + "." + str3);
                setDimString("spm_url", str);
                return this;
            }
            setDimString(YoukuLivePerformanceConstants.DIM_SPM_URL_A, str2);
            setDimString(YoukuLivePerformanceConstants.DIM_SPM_URL_B, str3);
            setDimString(YoukuLivePerformanceConstants.DIM_SPM_URL_C, str4);
            setDimString(YoukuLivePerformanceConstants.DIM_SPM_URL_D, str5);
            setDimString(YoukuLivePerformanceConstants.DIM_SPM_URL_AB, str2 + "." + str3);
            setDimString("spm_url", str);
        }
        return this;
    }

    public YoukuLivePerformance setTemplateEnd(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1230984487")) {
            return (YoukuLivePerformance) ipChange.ipc$dispatch("-1230984487", new Object[]{this, Long.valueOf(j)});
        }
        setMeasure(YoukuLivePerformanceConstants.MES_TEMPLATE_END, j);
        return this;
    }

    public YoukuLivePerformance setTemplateId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1971779757")) {
            return (YoukuLivePerformance) ipChange.ipc$dispatch("-1971779757", new Object[]{this, str});
        }
        setDimString("template_id", str);
        return this;
    }

    public YoukuLivePerformance setTemplateStart(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1823584160")) {
            return (YoukuLivePerformance) ipChange.ipc$dispatch("1823584160", new Object[]{this, Long.valueOf(j)});
        }
        setMeasure(YoukuLivePerformanceConstants.MES_TEMPLATE_START, j);
        return this;
    }

    public YoukuLivePerformance setVideoRoomType() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1300578048") ? (YoukuLivePerformance) ipChange.ipc$dispatch("-1300578048", new Object[]{this}) : setRoomType("1");
    }

    public YoukuLivePerformance setWeexEnd() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "920723126")) {
            return (YoukuLivePerformance) ipChange.ipc$dispatch("920723126", new Object[]{this});
        }
        setMeasure(YoukuLivePerformanceConstants.MES_WEEX_END);
        return this;
    }

    public YoukuLivePerformance setWeexError(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2098020851")) {
            return (YoukuLivePerformance) ipChange.ipc$dispatch("2098020851", new Object[]{this, str});
        }
        setDimension(YoukuLivePerformanceConstants.DIM_WEEX_ERROR, str);
        return this;
    }

    public YoukuLivePerformance setWeexStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1518751567")) {
            return (YoukuLivePerformance) ipChange.ipc$dispatch("1518751567", new Object[]{this});
        }
        setMeasure(YoukuLivePerformanceConstants.MES_WEEX_START);
        return this;
    }

    public YoukuLivePerformance setChannelEnd() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1230570694")) {
            return (YoukuLivePerformance) ipChange.ipc$dispatch("1230570694", new Object[]{this});
        }
        setMeasure(YoukuLivePerformanceConstants.MES_CHANNEL_END);
        return this;
    }

    public YoukuLivePerformance setChannelStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1365446305")) {
            return (YoukuLivePerformance) ipChange.ipc$dispatch("-1365446305", new Object[]{this});
        }
        setMeasure(YoukuLivePerformanceConstants.MES_CHANNEL_START);
        return this;
    }

    public YoukuLivePerformance setWeexEnd(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "668667122")) {
            return (YoukuLivePerformance) ipChange.ipc$dispatch("668667122", new Object[]{this, Long.valueOf(j)});
        }
        setMeasure(YoukuLivePerformanceConstants.MES_WEEX_END, j);
        return this;
    }

    public YoukuLivePerformance setWeexStart(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2027679609")) {
            return (YoukuLivePerformance) ipChange.ipc$dispatch("2027679609", new Object[]{this, Long.valueOf(j)});
        }
        setMeasure(YoukuLivePerformanceConstants.MES_WEEX_START, j);
        return this;
    }
}
