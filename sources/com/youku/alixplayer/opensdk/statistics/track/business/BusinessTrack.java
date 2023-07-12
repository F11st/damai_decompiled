package com.youku.alixplayer.opensdk.statistics.track.business;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import anet.channel.entity.ConnType;
import com.alibaba.fastjson.JSON;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.youku.alixplayer.IAlixPlayer;
import com.youku.alixplayer.OnInfoListener;
import com.youku.alixplayer.OnStateChangeListener;
import com.youku.alixplayer.opensdk.AlixVideoItem;
import com.youku.alixplayer.opensdk.IBusinessTrack;
import com.youku.alixplayer.opensdk.IPlayerContainer;
import com.youku.alixplayer.opensdk.OnVideoStreamListener;
import com.youku.alixplayer.opensdk.PlayVideoInfo;
import com.youku.alixplayer.opensdk.VideoRequestError;
import com.youku.alixplayer.opensdk.YoukuVideoInfo;
import com.youku.alixplayer.opensdk.statistics.ITrack;
import com.youku.alixplayer.opensdk.statistics.OnPlayerTrackListener;
import com.youku.alixplayer.opensdk.ups.data.Quality;
import com.youku.alixplayer.opensdk.utils.Logger;
import com.youku.android.liveservice.bean.LivePlayControl;
import com.youku.android.liveservice.bean.VideoInfo;
import com.youku.ntpsync.NtpSyncUtils;
import com.youku.vpm.constants.TableField;
import com.youku.vpm.track.OnePlayTrack;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class BusinessTrack extends OnPlayerTrackListener implements OnInfoListener, IBusinessTrack, OnVideoStreamListener {
    private BusinessReport mBusinessReport;
    private Context mContext;
    private IPlayerContainer mPlayerContainer;
    private String mSdkVersion;
    private boolean mIsAppear = false;
    private List<OnBusinessTrackListener> mOnBusinessTrackListeners = new CopyOnWriteArrayList();
    private OnBusinessTrackListener mOnBusinessTrackListener = new OnBusinessTrackListener() { // from class: com.youku.alixplayer.opensdk.statistics.track.business.BusinessTrack.1
        @Override // com.youku.alixplayer.opensdk.statistics.track.business.OnBusinessTrackListener
        public void onMonitorPoint(BusinessReport businessReport, String str, Map<String, String> map) {
            for (OnBusinessTrackListener onBusinessTrackListener : BusinessTrack.this.mOnBusinessTrackListeners) {
                onBusinessTrackListener.onMonitorPoint(businessReport, str, map);
            }
        }
    };
    private OnStateChangeListener mOnStateChangeListener = new OnStateChangeListener() { // from class: com.youku.alixplayer.opensdk.statistics.track.business.BusinessTrack.2
        @Override // com.youku.alixplayer.OnStateChangeListener
        public void onStateChange(IAlixPlayer.State state, IAlixPlayer.State state2) {
            if (BusinessTrack.this.mBusinessReport == null || state2 != IAlixPlayer.State.STATE_VIDEO_STARTED) {
                return;
            }
            BusinessTrack.this.videoStarted();
        }
    };
    private Quality mAbrGearQuality = Quality.UNKNOWN;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.youku.alixplayer.opensdk.statistics.track.business.BusinessTrack$3  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$com$youku$alixplayer$opensdk$ups$data$Quality;

        static {
            int[] iArr = new int[Quality.values().length];
            $SwitchMap$com$youku$alixplayer$opensdk$ups$data$Quality = iArr;
            try {
                iArr[Quality.HD3GP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$youku$alixplayer$opensdk$ups$data$Quality[Quality.SD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$youku$alixplayer$opensdk$ups$data$Quality[Quality.HD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$youku$alixplayer$opensdk$ups$data$Quality[Quality.HD2.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$youku$alixplayer$opensdk$ups$data$Quality[Quality.HD3.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$youku$alixplayer$opensdk$ups$data$Quality[Quality.HD4K.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public BusinessTrack(Context context, IPlayerContainer iPlayerContainer) {
        this.mContext = context;
        this.mPlayerContainer = iPlayerContainer;
        iPlayerContainer.getPlayerTrack().addPlayerTrackInfoListener(this);
        iPlayerContainer.addVideoStreamListener(this);
        iPlayerContainer.getPlayer().addOnPlayerStateListener(this.mOnStateChangeListener);
    }

    private void playStart() {
        if (this.mBusinessReport != null) {
            int autoAbsGear = getAutoAbsGear();
            if (autoAbsGear != -1) {
                BusinessReport businessReport = this.mBusinessReport;
                businessReport.put("abrCurrentGear", autoAbsGear + "");
            }
            IPlayerContainer iPlayerContainer = this.mPlayerContainer;
            if (iPlayerContainer != null && iPlayerContainer.getVideoStream() != null && this.mPlayerContainer.getVideoStream().getCurAlixVideoItem() != null) {
                this.mBusinessReport.put("real_format", this.mPlayerContainer.getVideoStream().getCurAlixVideoItem().getStreamType());
            }
            this.mBusinessReport.reportPlayStart();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void videoStarted() {
        if (this.mPlayerContainer.getPlayerTrack() == null || this.mPlayerContainer.getPlayerTrack().getTrack() == null) {
            return;
        }
        String string = this.mPlayerContainer.getPlayerTrack().getTrack().getString("liveUrlReplace");
        BusinessReport businessReport = this.mBusinessReport;
        if (businessReport != null) {
            businessReport.put("liveUrlReplace", string);
        }
    }

    @Override // com.youku.alixplayer.opensdk.IBusinessTrack
    public void addBusinessTrackListener(OnBusinessTrackListener onBusinessTrackListener) {
        this.mOnBusinessTrackListeners.add(onBusinessTrackListener);
    }

    @Override // com.youku.alixplayer.opensdk.IBusinessTrack
    public void didAppear() {
        this.mIsAppear = true;
        BusinessReport businessReport = this.mBusinessReport;
        if (businessReport != null) {
            businessReport.setAppear(true);
            this.mBusinessReport.reportPlayStart();
        }
    }

    @Override // com.youku.alixplayer.opensdk.IBusinessTrack
    public void didDisappear() {
        this.mIsAppear = false;
        BusinessReport businessReport = this.mBusinessReport;
        if (businessReport != null) {
            businessReport.reportPlayEnd();
        }
        if (this.mPlayerContainer.getPlayerTrack() != null) {
            Bundle bundle = new Bundle();
            bundle.putString("from", "live");
            this.mPlayerContainer.getPlayerTrack().onAction("onVVEnd", bundle);
        }
    }

    public int getAutoAbsGear() {
        switch (AnonymousClass3.$SwitchMap$com$youku$alixplayer$opensdk$ups$data$Quality[this.mAbrGearQuality.ordinal()]) {
            case 1:
                return 0;
            case 2:
                return 1;
            case 3:
                return 2;
            case 4:
                return 3;
            case 5:
                return 4;
            case 6:
                return 5;
            default:
                return -1;
        }
    }

    @Override // com.youku.alixplayer.opensdk.OnVideoStreamListener
    public void onDataFail(VideoRequestError videoRequestError) {
    }

    @Override // com.youku.alixplayer.opensdk.OnVideoStreamListener
    public void onDataReady(YoukuVideoInfo youkuVideoInfo) {
        if (this.mBusinessReport == null || youkuVideoInfo.getLiveInfo() == null || youkuVideoInfo.getLiveInfo().videoInfo == null) {
            return;
        }
        VideoInfo videoInfo = youkuVideoInfo.getLiveInfo().videoInfo;
        this.mBusinessReport.put("screen_id", videoInfo.screenId);
        this.mBusinessReport.put("instanceCount", videoInfo.isLaifengPk ? "2" : "1");
        BusinessReport businessReport = this.mBusinessReport;
        String str = videoInfo.videoFormat;
        if (str == null) {
            str = "2";
        }
        businessReport.put("video_format", str);
        this.mBusinessReport.put("protocol", videoInfo.protocol);
        this.mBusinessReport.put("biz_type", videoInfo.bizType);
        this.mBusinessReport.put("pushStreamType", videoInfo.pushStreamType);
        String str2 = videoInfo.bizType;
        if ("2".equals(str2)) {
            this.mBusinessReport.put("live_type", "5");
        } else if ("3".equals(str2)) {
            this.mBusinessReport.put("live_type", "4");
        } else if ("11".equals(str2)) {
            this.mBusinessReport.put("live_type", "6");
        } else {
            this.mBusinessReport.put("live_type", "1");
        }
        this.mBusinessReport.put("ispk", videoInfo.isLaifengPk ? "1" : "0");
        LivePlayControl livePlayControl = videoInfo.livePlayControl;
        int i = 0;
        AlixVideoItem curAlixVideoItem = this.mPlayerContainer.getVideoStream().getCurAlixVideoItem();
        if (livePlayControl != null) {
            for (com.youku.android.liveservice.bean.Quality quality : livePlayControl.qualities) {
                if (curAlixVideoItem != null && quality.quality == curAlixVideoItem.getLiveQuality()) {
                    i = quality.bizSwitch.abr;
                }
            }
            this.mBusinessReport.put("isFreeView", livePlayControl.paid ? "1" : "0");
            if ("mic".equals(livePlayControl.streamMode) && PushConstants.URI_PACKAGE_NAME.equals(livePlayControl.micMode) && livePlayControl.mcu == 1) {
                this.mBusinessReport.put("ismcu", "1");
            } else {
                this.mBusinessReport.put("ismcu", "0");
            }
        }
        this.mBusinessReport.remove("abrCurrentGear");
        this.mBusinessReport.remove("streamGroup");
        if (i > 0) {
            this.mBusinessReport.put("abrCurrentGear", "-1");
        }
        this.mBusinessReport.put("real_format", curAlixVideoItem != null ? curAlixVideoItem.getStreamType() : null);
    }

    @Override // com.youku.alixplayer.OnInfoListener
    public void onInfo(int i, int i2, int i3, Object obj) {
        if (i == 2016) {
            this.mAbrGearQuality = Quality.getQualityByAbrCode(i2);
            int autoAbsGear = getAutoAbsGear();
            if (autoAbsGear != -1) {
                BusinessReport businessReport = this.mBusinessReport;
                businessReport.put("abrCurrentGear", autoAbsGear + "");
            }
        } else if (i == 2017) {
            this.mBusinessReport.put("streamGroup", String.valueOf(i2));
            Logger.e("upper live group " + i2);
        } else if (2012 == i) {
            try {
                long longValue = JSON.parseArray((String) obj).getJSONObject(0).getLong("ext").longValue();
                SeiDelay seiDelay = new SeiDelay();
                long offset = NtpSyncUtils.getOffset();
                long currentTimeMillis = System.currentTimeMillis();
                long j = (currentTimeMillis + offset) - longValue;
                seiDelay.mDelay = j;
                seiDelay.ntpOffset = offset;
                seiDelay.localTimestamp = currentTimeMillis + "";
                seiDelay.seiTimestamp = String.valueOf(longValue);
                BusinessReport businessReport2 = this.mBusinessReport;
                if (businessReport2 != null) {
                    businessReport2.setDelay(j);
                    this.mBusinessReport.setSeiDelay(seiDelay);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                String[] split = ((String) obj).split("=");
                long parseLong = Long.parseLong(split[1]);
                SeiDelay seiDelay2 = new SeiDelay();
                long offset2 = NtpSyncUtils.getOffset();
                long currentTimeMillis2 = System.currentTimeMillis();
                long j2 = (currentTimeMillis2 + offset2) - parseLong;
                seiDelay2.mDelay = j2;
                seiDelay2.ntpOffset = offset2;
                seiDelay2.localTimestamp = currentTimeMillis2 + "";
                seiDelay2.seiTimestamp = split[1];
                BusinessReport businessReport3 = this.mBusinessReport;
                if (businessReport3 != null) {
                    businessReport3.setDelay(j2);
                    this.mBusinessReport.setSeiDelay(seiDelay2);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.youku.alixplayer.opensdk.statistics.OnPlayerTrackListener
    public void onMonitorPoint(ITrack iTrack, String str, OnPlayerTrackListener.Result result) {
        BusinessReport businessReport;
        Map<String, String> dimensions = result.getDimensions();
        Map<String, Double> measures = result.getMeasures();
        if ("onePlay".equals(str)) {
            String str2 = dimensions.get("playType");
            String str3 = dimensions.get(TableField.FILE_FORMAT);
            String str4 = dimensions.get("vvId");
            String str5 = dimensions.get("isCDN");
            String str6 = dimensions.get("decodingType");
            String str7 = dimensions.get("videoCode");
            if (this.mBusinessReport != null && OnePlayTrack.PlayType.BEGIN.equals(str2) && 2.0d == measures.get("beginStage").doubleValue()) {
                this.mBusinessReport.setFirstPlay(true);
                this.mBusinessReport.put(TableField.FILE_FORMAT, str3);
                this.mBusinessReport.put("vvId", str4);
                this.mBusinessReport.put("data_source", ConnType.PK_CDN.equalsIgnoreCase(str5) ? "1" : "3");
                this.mBusinessReport.put("isp2p", ConnType.PK_CDN.equalsIgnoreCase(str5) ? "1" : "3");
                this.mBusinessReport.put("decodingType", str6);
                this.mBusinessReport.put("videoCode", str7);
                playStart();
            } else if (!"end".equals(str2) || (businessReport = this.mBusinessReport) == null) {
            } else {
                businessReport.reportPlayEnd();
            }
        }
    }

    @Override // com.youku.alixplayer.opensdk.OnVideoStreamListener
    public void onNewRequest(PlayVideoInfo playVideoInfo) {
        this.mAbrGearQuality = Quality.UNKNOWN;
    }

    @Override // com.youku.alixplayer.opensdk.statistics.OnPlayerTrackListener
    public void onNewTrack(ITrack iTrack) {
        PlayVideoInfo playVideoInfo = iTrack.getPlayVideoInfo();
        BusinessReport businessReport = new BusinessReport(this.mContext, playVideoInfo.getLiveId());
        this.mBusinessReport = businessReport;
        businessReport.setBusinessTrackListener(this.mOnBusinessTrackListener);
        this.mBusinessReport.setAppear(this.mIsAppear);
        this.mBusinessReport.put("live_container_sdk_version", this.mSdkVersion);
        this.mBusinessReport.put("playsdk_version", this.mSdkVersion);
        if (playVideoInfo.getFastData() != null) {
            this.mBusinessReport.put(TableField.USE_MIN_SET, "1");
        } else {
            this.mBusinessReport.put(TableField.USE_MIN_SET, "0");
        }
    }

    public void onPictureInPictureModeChanged(boolean z, Configuration configuration) {
        BusinessReport businessReport = this.mBusinessReport;
        if (businessReport != null) {
            businessReport.put("smallplayer_au", "1");
            this.mBusinessReport.put("usePIP", "1");
            this.mBusinessReport.put("isPIP", z ? "1" : "0");
        }
        if (this.mPlayerContainer.getPlayerTrack().getTrack() != null) {
            this.mPlayerContainer.getPlayerTrack().getTrack().putString("usePIP", "1");
            this.mPlayerContainer.getPlayerTrack().getTrack().putString("isPIP", z ? "1" : "0");
        }
    }

    public void onPreloadNewTrack(PlayVideoInfo playVideoInfo) {
        BusinessReport businessReport = new BusinessReport(this.mContext, playVideoInfo.getLiveId());
        this.mBusinessReport = businessReport;
        businessReport.setBusinessTrackListener(this.mOnBusinessTrackListener);
        this.mBusinessReport.setAppear(this.mIsAppear);
        this.mBusinessReport.put("live_container_sdk_version", this.mSdkVersion);
        this.mBusinessReport.put("playsdk_version", this.mSdkVersion);
        this.mBusinessReport.put("fromwall", "1");
        if (playVideoInfo.getFastData() != null) {
            this.mBusinessReport.put(TableField.USE_MIN_SET, "1");
        } else {
            this.mBusinessReport.put(TableField.USE_MIN_SET, "0");
        }
    }

    @Override // com.youku.alixplayer.opensdk.IBusinessTrack
    public boolean put(String str, String str2) {
        BusinessReport businessReport = this.mBusinessReport;
        if (businessReport == null) {
            return false;
        }
        businessReport.put(str, str2);
        return true;
    }

    @Override // com.youku.alixplayer.opensdk.IBusinessTrack
    public void removeBusinessTrackListener(OnBusinessTrackListener onBusinessTrackListener) {
        this.mOnBusinessTrackListeners.remove(onBusinessTrackListener);
    }

    public void setPlayerInfoSB(StringBuilder sb) {
        String sb2 = sb != null ? sb.toString() : "";
        if (this.mBusinessReport == null || TextUtils.isEmpty(sb2)) {
            return;
        }
        this.mBusinessReport.put("playerinfo", sb2);
    }

    public void setSdkVersion(String str) {
        this.mSdkVersion = str;
    }

    public void setShownTime(long j) {
        if (this.mBusinessReport == null || j <= BusinessReport.shownTime) {
            return;
        }
        Logger.d("showntime", "setShownTime:" + String.valueOf(j) + "|" + String.valueOf(BusinessReport.shownTime));
        BusinessReport.shownTime = j;
    }
}
