package com.youku.live.dago.liveplayback.widget.track;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import anet.channel.entity.ConnType;
import cn.damai.category.category.ui.ShowFragment;
import com.alibaba.fastjson.JSON;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.youku.alixplayer.OnInfoListener;
import com.youku.alixplayer.opensdk.AlixVideoItem;
import com.youku.alixplayer.opensdk.IPlayerContainer;
import com.youku.alixplayer.opensdk.OnChangeVideoListener;
import com.youku.alixplayer.opensdk.OnVideoStreamListener;
import com.youku.alixplayer.opensdk.PlayVideoInfo;
import com.youku.alixplayer.opensdk.VideoRequestError;
import com.youku.alixplayer.opensdk.YoukuVideoInfo;
import com.youku.alixplayer.opensdk.statistics.ITrack;
import com.youku.alixplayer.opensdk.statistics.OnPlayerTrackListener;
import com.youku.alixplayer.opensdk.ups.data.Quality;
import com.youku.alixplayer.opensdk.utils.Logger;
import com.youku.alixplugin.AlixPlayerContext;
import com.youku.alixplugin.OnNotifyListener;
import com.youku.android.liveservice.bean.BypassPlayInfo;
import com.youku.android.liveservice.bean.LivePlayControl;
import com.youku.android.liveservice.bean.VideoInfo;
import com.youku.live.dago.liveplayback.widget.AlixLivePlayback;
import com.youku.live.dago.liveplayback.widget.BusinessTrack;
import com.youku.live.dago.liveplayback.widget.model.SeiDelay;
import com.youku.live.dago.liveplayback.widget.ut.LaifengVVParams;
import com.youku.live.livesdk.model.mtop.data.LiveFullInfoData;
import com.youku.live.widgets.ActivityLifecycleState;
import com.youku.live.widgets.protocol.Orientation;
import com.youku.ntpsync.NtpSyncUtils;
import com.youku.vpm.constants.TableField;
import com.youku.vpm.track.OnePlayTrack;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class AlixPlayerTrack extends OnPlayerTrackListener implements OnInfoListener, OnChangeVideoListener, OnVideoStreamListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private BusinessTrack mBusinessTrack;
    private Context mContext;
    private AlixLivePlayback.PlaybackVariables mPlaybackVariables;
    private IPlayerContainer mPlayerContainer;
    private String mSdkVersion;
    private boolean mIsAppear = false;
    private Quality mAbrGearQuality = Quality.UNKNOWN;
    private OnNotifyListener mOnNotifyListener = new OnNotifyListener() { // from class: com.youku.live.dago.liveplayback.widget.track.AlixPlayerTrack.1
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // com.youku.alixplugin.OnNotifyListener
        public void onNotify(Intent intent, Object obj) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1078491031")) {
                ipChange.ipc$dispatch("-1078491031", new Object[]{this, intent, obj});
            } else if ("LFLWDataCenterAHDR".equalsIgnoreCase(intent.getAction())) {
                String stringExtra = intent.getStringExtra("isAudioHbr");
                if (AlixPlayerTrack.this.mBusinessTrack != null) {
                    AlixPlayerTrack.this.mBusinessTrack.put("isAudioHbr", stringExtra);
                    if ("1".equals(stringExtra)) {
                        AlixPlayerTrack.this.mBusinessTrack.put("useAudioHbr", "1");
                    }
                }
                ITrack track = AlixPlayerTrack.this.mPlayerContainer.getPlayerTrack().getTrack();
                if (track != null) {
                    track.putString("isAudioHbr", stringExtra);
                    if ("1".equals(stringExtra)) {
                        track.putString("useAudioHbr", "1");
                    }
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.youku.live.dago.liveplayback.widget.track.AlixPlayerTrack$2  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass2 {
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

    public AlixPlayerTrack(AlixPlayerContext alixPlayerContext, IPlayerContainer iPlayerContainer) {
        this.mContext = alixPlayerContext.getContext();
        this.mPlayerContainer = iPlayerContainer;
        iPlayerContainer.getPlayerTrack().addPlayerTrackInfoListener(this);
        iPlayerContainer.addVideoStreamListener(this);
        iPlayerContainer.addChangeVideoListener(this);
        alixPlayerContext.addNotifyListener(this.mOnNotifyListener);
    }

    private void playStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "495587729")) {
            ipChange.ipc$dispatch("495587729", new Object[]{this});
        } else if (this.mBusinessTrack != null) {
            int autoAbsGear = getAutoAbsGear();
            if (autoAbsGear != -1) {
                BusinessTrack businessTrack = this.mBusinessTrack;
                businessTrack.put("abrCurrentGear", autoAbsGear + "");
            }
            if (this.mPlayerContainer.getVideoStream() != null && this.mPlayerContainer.getVideoStream().getCurAlixVideoItem() != null) {
                this.mBusinessTrack.put("real_format", this.mPlayerContainer.getVideoStream().getCurAlixVideoItem().getStreamType());
            }
            this.mBusinessTrack.reportPlayStart();
        }
    }

    private void updateUtParamsWithLiveFullInfo(LiveFullInfoData liveFullInfoData) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-398995316")) {
            ipChange.ipc$dispatch("-398995316", new Object[]{this, liveFullInfoData});
        } else if (liveFullInfoData == null) {
        } else {
            Long l = liveFullInfoData.liveId;
            String valueOf = l != null ? String.valueOf(l) : "";
            Long l2 = liveFullInfoData.screenId;
            String valueOf2 = l2 != null ? String.valueOf(l2) : "";
            String str = liveFullInfoData.clientIp;
            if (str == null) {
                str = "";
            }
            Long l3 = liveFullInfoData.categoryId;
            String valueOf3 = l3 != null ? String.valueOf(l3) : "";
            Integer num = liveFullInfoData.liveStatus;
            String valueOf4 = num != null ? String.valueOf(num) : "";
            String valueOf5 = liveFullInfoData.liveStatus != null ? String.valueOf(liveFullInfoData.bizType) : "";
            HashMap hashMap = new HashMap(16);
            hashMap.put("intrIP", str);
            hashMap.put("categoryId", valueOf3);
            hashMap.put(ShowFragment.CATEGORYNAME_KEY, "");
            hashMap.put("play_type", valueOf4);
            hashMap.put("isvip_rt", "n");
            hashMap.put("biz_type", valueOf5);
            if (valueOf5.equals("2")) {
                hashMap.put("live_type", "5");
            } else if (valueOf5.equals("3")) {
                hashMap.put("live_type", "4");
            } else if (valueOf5.equals("11")) {
                hashMap.put("live_type", "6");
            } else {
                hashMap.put("live_type", "1");
            }
            hashMap.put("screen_id", valueOf2);
            hashMap.put("view", "默认");
            hashMap.put("topic_id", "");
            hashMap.put("outArgs", "");
            hashMap.put("roomid", valueOf);
            hashMap.put("liveid", valueOf);
            hashMap.put("type", OnePlayTrack.PlayType.BEGIN);
            hashMap.put("video_ctype", "UGC");
            hashMap.put("play_decoding", "1");
            BusinessTrack businessTrack = this.mBusinessTrack;
            if (businessTrack != null) {
                businessTrack.putAll(hashMap);
            }
        }
    }

    public void destory() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "170083019")) {
            ipChange.ipc$dispatch("170083019", new Object[]{this});
        } else {
            this.mPlaybackVariables = null;
        }
    }

    public void didAppear() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1731745387")) {
            ipChange.ipc$dispatch("1731745387", new Object[]{this});
            return;
        }
        this.mIsAppear = true;
        BusinessTrack businessTrack = this.mBusinessTrack;
        if (businessTrack != null) {
            businessTrack.setAppear(true);
            this.mBusinessTrack.reportPlayStart();
        }
    }

    public void didDisappear() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2102293607")) {
            ipChange.ipc$dispatch("2102293607", new Object[]{this});
            return;
        }
        this.mIsAppear = false;
        if (this.mBusinessTrack != null) {
            IPlayerContainer iPlayerContainer = this.mPlayerContainer;
            if (iPlayerContainer != null && iPlayerContainer.getPlayerTrack() != null && this.mPlayerContainer.getPlayerTrack().getPlayTimeTrack() != null) {
                BusinessTrack businessTrack = this.mBusinessTrack;
                businessTrack.put("rotateStayTime", this.mPlayerContainer.getPlayerTrack().getPlayTimeTrack().getRotateStayTime() + "");
            }
            this.mBusinessTrack.reportPlayEnd();
        }
        if (this.mPlayerContainer.getPlayerTrack() != null) {
            Bundle bundle = new Bundle();
            bundle.putString("from", "live");
            this.mPlayerContainer.getPlayerTrack().onAction("onVVEnd", bundle);
        }
    }

    public int getAutoAbsGear() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1752659586")) {
            return ((Integer) ipChange.ipc$dispatch("1752659586", new Object[]{this})).intValue();
        }
        switch (AnonymousClass2.$SwitchMap$com$youku$alixplayer$opensdk$ups$data$Quality[this.mAbrGearQuality.ordinal()]) {
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

    public void onActivityConfigurationChanged(Configuration configuration) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2005138991")) {
            ipChange.ipc$dispatch("-2005138991", new Object[]{this, configuration});
            return;
        }
        BusinessTrack businessTrack = this.mBusinessTrack;
        if (businessTrack == null) {
            return;
        }
        int i = configuration.orientation;
        if (i == 1) {
            businessTrack.put("screenType", "0");
            if (this.mPlaybackVariables.getFirstVideoOrientation() == Orientation.ORIENTATION_PORTAIT) {
                this.mBusinessTrack.put("direction", "vplayer");
            } else {
                this.mBusinessTrack.put("direction", "vhplayer");
            }
        } else if (i != 2) {
        } else {
            businessTrack.put("screenType", "1");
            if (this.mPlaybackVariables.getFirstVideoOrientation() == Orientation.ORIENTATION_LANDSCAPE) {
                this.mBusinessTrack.put("direction", "fplayer");
            }
        }
    }

    public void onActivityLifecycleStateChanged(ActivityLifecycleState activityLifecycleState) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "162090748")) {
            ipChange.ipc$dispatch("162090748", new Object[]{this, activityLifecycleState});
            return;
        }
        BusinessTrack businessTrack = this.mBusinessTrack;
        if (businessTrack != null) {
            if (activityLifecycleState == ActivityLifecycleState.STARTED) {
                businessTrack.putHeatArgs("background_mode", "0");
            } else if (activityLifecycleState == ActivityLifecycleState.STOPPED) {
                businessTrack.putHeatArgs("background_mode", "1");
            }
        }
        if (this.mPlayerContainer.getPlayerTrack().getTrack() != null) {
            if (activityLifecycleState == ActivityLifecycleState.STARTED) {
                this.mPlayerContainer.getPlayerTrack().getTrack().putString("background_mode", "0");
            } else if (activityLifecycleState == ActivityLifecycleState.STOPPED) {
                this.mPlayerContainer.getPlayerTrack().getTrack().putString("background_mode", "1");
            }
        }
    }

    @Override // com.youku.alixplayer.opensdk.OnChangeVideoListener
    public void onChangeVideo(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "888927667")) {
            ipChange.ipc$dispatch("888927667", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        BusinessTrack businessTrack = this.mBusinessTrack;
        if (businessTrack != null) {
            businessTrack.put("changeType", "1");
        }
    }

    @Override // com.youku.alixplayer.opensdk.OnChangeVideoListener
    public void onChangeVideoFinish(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1841976108")) {
            ipChange.ipc$dispatch("-1841976108", new Object[]{this, Boolean.valueOf(z)});
        }
    }

    @Override // com.youku.alixplayer.opensdk.OnVideoStreamListener
    public void onDataFail(VideoRequestError videoRequestError) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-246669378")) {
            ipChange.ipc$dispatch("-246669378", new Object[]{this, videoRequestError});
        }
    }

    @Override // com.youku.alixplayer.opensdk.OnVideoStreamListener
    public void onDataReady(YoukuVideoInfo youkuVideoInfo) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        int i;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1937998275")) {
            ipChange.ipc$dispatch("-1937998275", new Object[]{this, youkuVideoInfo});
            return;
        }
        String str9 = "0";
        if (this.mBusinessTrack == null || youkuVideoInfo.getLiveInfo() == null || youkuVideoInfo.getLiveInfo().videoInfo == null) {
            str = "2";
            str2 = "0";
            str3 = str2;
            str4 = null;
            str5 = null;
            str6 = null;
            str7 = null;
            str8 = null;
        } else {
            VideoInfo videoInfo = youkuVideoInfo.getLiveInfo().videoInfo;
            str4 = videoInfo.screenId;
            boolean z = videoInfo.isLaifengPk;
            str5 = z ? "2" : "1";
            str3 = z ? "1" : "0";
            str = videoInfo.videoFormat;
            if (str == null) {
                str = "2";
            }
            str6 = videoInfo.protocol;
            str7 = videoInfo.bizType;
            str8 = videoInfo.pushStreamType;
            LivePlayControl livePlayControl = videoInfo.livePlayControl;
            if (livePlayControl != null) {
                String str10 = livePlayControl.paid ? "1" : "0";
                if ("mic".equals(livePlayControl.streamMode) && PushConstants.URI_PACKAGE_NAME.equals(livePlayControl.micMode) && livePlayControl.mcu == 1) {
                    str9 = str10;
                    str2 = "1";
                } else {
                    str2 = "0";
                    str9 = str10;
                }
            } else {
                str2 = "0";
            }
            BypassPlayInfo bypassPlayInfo = youkuVideoInfo.getLiveInfo().bypassPlayInfo;
            if (bypassPlayInfo != null) {
                BusinessTrack businessTrack = this.mBusinessTrack;
                businessTrack.put("videoCode", bypassPlayInfo.h265 + "");
            }
        }
        BusinessTrack businessTrack2 = this.mBusinessTrack;
        if (businessTrack2 != null) {
            businessTrack2.put("screen_id", str4);
            this.mBusinessTrack.put("instanceCount", str5);
            this.mBusinessTrack.put("video_format", str);
            this.mBusinessTrack.put("protocol", str6);
            this.mBusinessTrack.put("biz_type", str7);
            this.mBusinessTrack.put("pushStreamType", str8);
            this.mBusinessTrack.put("isFreeView", str9);
            if ("2".equals(str7)) {
                this.mBusinessTrack.put("live_type", "5");
            } else if ("3".equals(str7)) {
                this.mBusinessTrack.put("live_type", "4");
            } else if ("11".equals(str7)) {
                this.mBusinessTrack.put("live_type", "6");
            } else {
                this.mBusinessTrack.put("live_type", "1");
            }
            this.mBusinessTrack.put("ispk", str3);
            this.mBusinessTrack.put("ismcu", str2);
            AlixVideoItem curAlixVideoItem = this.mPlayerContainer.getVideoStream().getCurAlixVideoItem();
            if (youkuVideoInfo == null || youkuVideoInfo.getLivePlayControl() == null) {
                i = 0;
            } else {
                i = 0;
                for (com.youku.android.liveservice.bean.Quality quality : youkuVideoInfo.getLivePlayControl().qualities) {
                    if (curAlixVideoItem != null && quality.quality == curAlixVideoItem.getLiveQuality()) {
                        i = quality.bizSwitch.abr;
                    }
                }
                BusinessTrack businessTrack3 = this.mBusinessTrack;
                businessTrack3.put("hbrHit", youkuVideoInfo.getLivePlayControl().hbrHit + "");
            }
            this.mBusinessTrack.remove("abrCurrentGear");
            this.mBusinessTrack.remove("streamGroup");
            if (i > 0) {
                this.mBusinessTrack.put("abrCurrentGear", "-1");
            }
            this.mBusinessTrack.put("real_format", curAlixVideoItem != null ? curAlixVideoItem.getStreamType() : null);
            this.mBusinessTrack.putAll(new LaifengVVParams().getVVCommonParams(this.mContext, str7));
        }
    }

    @Override // com.youku.alixplayer.OnInfoListener
    public void onInfo(int i, int i2, int i3, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1901227905")) {
            ipChange.ipc$dispatch("1901227905", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), obj});
            return;
        }
        BusinessTrack businessTrack = this.mBusinessTrack;
        if (businessTrack == null) {
            return;
        }
        if (i == 2016) {
            this.mAbrGearQuality = Quality.getQualityByAbrCode(i2);
            int autoAbsGear = getAutoAbsGear();
            if (autoAbsGear != -1) {
                BusinessTrack businessTrack2 = this.mBusinessTrack;
                businessTrack2.put("abrCurrentGear", autoAbsGear + "");
            }
        } else if (i == 2017) {
            businessTrack.put("streamGroup", String.valueOf(i2));
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
                BusinessTrack businessTrack3 = this.mBusinessTrack;
                if (businessTrack3 != null) {
                    businessTrack3.setDelay(j);
                    this.mBusinessTrack.setSeiDelay(seiDelay);
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
                BusinessTrack businessTrack4 = this.mBusinessTrack;
                if (businessTrack4 != null) {
                    businessTrack4.setDelay(j2);
                    this.mBusinessTrack.setSeiDelay(seiDelay2);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void onLiveFullInfoReady(LiveFullInfoData liveFullInfoData) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "849803318")) {
            ipChange.ipc$dispatch("849803318", new Object[]{this, liveFullInfoData});
            return;
        }
        Long l = liveFullInfoData.screenId;
        String valueOf = l != null ? String.valueOf(l) : "";
        BusinessTrack businessTrack = this.mBusinessTrack;
        if (businessTrack != null) {
            businessTrack.put("screen_id", valueOf);
        }
        updateUtParamsWithLiveFullInfo(liveFullInfoData);
    }

    @Override // com.youku.alixplayer.opensdk.statistics.OnPlayerTrackListener
    public void onMonitorPoint(ITrack iTrack, String str, OnPlayerTrackListener.Result result) {
        int intValue;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-302406176")) {
            ipChange.ipc$dispatch("-302406176", new Object[]{this, iTrack, str, result});
            return;
        }
        Map<String, String> dimensions = result.getDimensions();
        Map<String, Double> measures = result.getMeasures();
        if ("onePlay".equals(str)) {
            String str2 = dimensions.get("playType");
            String str3 = dimensions.get(TableField.FILE_FORMAT);
            String str4 = dimensions.get("vvId");
            String str5 = dimensions.get("isCDN");
            String str6 = dimensions.get("decodingType");
            if (this.mBusinessTrack != null && OnePlayTrack.PlayType.BEGIN.equals(str2) && 2.0d == measures.get("beginStage").doubleValue()) {
                this.mBusinessTrack.setFirstPlay(true);
                this.mBusinessTrack.put(TableField.FILE_FORMAT, str3);
                this.mBusinessTrack.put("vvId", str4);
                this.mBusinessTrack.put("data_source", ConnType.PK_CDN.equalsIgnoreCase(str5) ? "1" : "3");
                this.mBusinessTrack.put("isp2p", ConnType.PK_CDN.equalsIgnoreCase(str5) ? "1" : "3");
                this.mBusinessTrack.put("decodingType", str6);
                if (measures.get("firstFrameGear") != null && (intValue = measures.get("firstFrameGear").intValue()) != -1) {
                    BusinessTrack businessTrack = this.mBusinessTrack;
                    businessTrack.put("abrCurrentGear", intValue + "");
                }
                playStart();
            } else if (!"end".equals(str2) || this.mBusinessTrack == null) {
            } else {
                IPlayerContainer iPlayerContainer = this.mPlayerContainer;
                if (iPlayerContainer != null && iPlayerContainer.getPlayerTrack() != null && this.mPlayerContainer.getPlayerTrack().getPlayTimeTrack() != null) {
                    BusinessTrack businessTrack2 = this.mBusinessTrack;
                    businessTrack2.put("rotateStayTime", this.mPlayerContainer.getPlayerTrack().getPlayTimeTrack().getRotateStayTime() + "");
                }
                this.mBusinessTrack.reportPlayEnd();
            }
        }
    }

    @Override // com.youku.alixplayer.opensdk.OnVideoStreamListener
    public void onNewRequest(PlayVideoInfo playVideoInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "443883382")) {
            ipChange.ipc$dispatch("443883382", new Object[]{this, playVideoInfo});
        } else {
            this.mAbrGearQuality = Quality.UNKNOWN;
        }
    }

    @Override // com.youku.alixplayer.opensdk.statistics.OnPlayerTrackListener
    public void onNewTrack(ITrack iTrack) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "629842625")) {
            ipChange.ipc$dispatch("629842625", new Object[]{this, iTrack});
            return;
        }
        PlayVideoInfo playVideoInfo = iTrack.getPlayVideoInfo();
        BusinessTrack businessTrack = new BusinessTrack(this.mContext, playVideoInfo.getLiveId());
        this.mBusinessTrack = businessTrack;
        businessTrack.setAppear(this.mIsAppear);
        this.mBusinessTrack.put("live_container_sdk_version", this.mSdkVersion);
        this.mBusinessTrack.put("playsdk_version", this.mSdkVersion);
        if (playVideoInfo.getFastData() != null) {
            this.mBusinessTrack.put(TableField.USE_MIN_SET, "1");
        } else {
            this.mBusinessTrack.put(TableField.USE_MIN_SET, "0");
        }
        this.mBusinessTrack.put("timeShift", playVideoInfo.getString("timeShift", "0"));
    }

    public void onPictureInPictureModeChanged(boolean z, Configuration configuration) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-825199196")) {
            ipChange.ipc$dispatch("-825199196", new Object[]{this, Boolean.valueOf(z), configuration});
            return;
        }
        BusinessTrack businessTrack = this.mBusinessTrack;
        if (businessTrack != null) {
            businessTrack.put("smallplayer_au", "1");
            this.mBusinessTrack.put("usePIP", "1");
            this.mBusinessTrack.put("isPIP", z ? "1" : "0");
        }
        if (this.mPlayerContainer.getPlayerTrack().getTrack() != null) {
            this.mPlayerContainer.getPlayerTrack().getTrack().putString("usePIP", "1");
            this.mPlayerContainer.getPlayerTrack().getTrack().putString("isPIP", z ? "1" : "0");
        }
    }

    public void onPreloadNewTrack(PlayVideoInfo playVideoInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "856676579")) {
            ipChange.ipc$dispatch("856676579", new Object[]{this, playVideoInfo});
            return;
        }
        BusinessTrack businessTrack = new BusinessTrack(this.mContext, playVideoInfo.getLiveId());
        this.mBusinessTrack = businessTrack;
        businessTrack.setAppear(this.mIsAppear);
        this.mBusinessTrack.put("live_container_sdk_version", this.mSdkVersion);
        this.mBusinessTrack.put("playsdk_version", this.mSdkVersion);
        this.mBusinessTrack.put("fromwall", "1");
        if (playVideoInfo.getFastData() != null) {
            this.mBusinessTrack.put(TableField.USE_MIN_SET, "1");
        } else {
            this.mBusinessTrack.put(TableField.USE_MIN_SET, "0");
        }
        this.mBusinessTrack.put("timeShift", playVideoInfo.getString("timeShift", "0"));
    }

    public void setPlaybackVariables(AlixLivePlayback.PlaybackVariables playbackVariables) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1542423785")) {
            ipChange.ipc$dispatch("1542423785", new Object[]{this, playbackVariables});
        } else {
            this.mPlaybackVariables = playbackVariables;
        }
    }

    public void setPlayerInfoSB(StringBuilder sb) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1864474092")) {
            ipChange.ipc$dispatch("1864474092", new Object[]{this, sb});
            return;
        }
        String sb2 = sb != null ? sb.toString() : "";
        if (this.mBusinessTrack == null || TextUtils.isEmpty(sb2)) {
            return;
        }
        this.mBusinessTrack.put("playerinfo", sb2);
    }

    public void setSdkVersion(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1448605609")) {
            ipChange.ipc$dispatch("1448605609", new Object[]{this, str});
        } else {
            this.mSdkVersion = str;
        }
    }

    public void setShownTime(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "426133141")) {
            ipChange.ipc$dispatch("426133141", new Object[]{this, Long.valueOf(j)});
        } else if (this.mBusinessTrack == null || j <= BusinessTrack.shownTime) {
        } else {
            Logger.d("showntime", "setShownTime:" + String.valueOf(j) + "|" + String.valueOf(BusinessTrack.shownTime));
            BusinessTrack.shownTime = j;
        }
    }

    public void videoStarted() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "793382789")) {
            ipChange.ipc$dispatch("793382789", new Object[]{this});
        } else if (this.mPlayerContainer.getPlayerTrack() == null || this.mPlayerContainer.getPlayerTrack().getTrack() == null) {
        } else {
            String string = this.mPlayerContainer.getPlayerTrack().getTrack().getString("liveUrlReplace");
            BusinessTrack businessTrack = this.mBusinessTrack;
            if (businessTrack != null) {
                businessTrack.put("liveUrlReplace", string);
            }
        }
    }
}
