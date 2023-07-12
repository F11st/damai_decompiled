package com.youku.alixplayer.opensdk.live;

import android.text.TextUtils;
import com.alimm.xadsdk.request.builder.BaseAdRequestBuilder;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.youku.alixplayer.opensdk.PlayVideoInfo;
import com.youku.alixplayer.opensdk.YoukuVideoInfo;
import com.youku.android.liveservice.bean.BypassPlayInfo;
import com.youku.android.liveservice.bean.LivePlayControl;
import com.youku.android.liveservice.bean.VideoInfo;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class LiveVideoInfo extends YoukuVideoInfo {
    private BypassPlayInfo mBypassPlayInfo;
    private String mLiveId;
    private LiveInfo mLiveInfo;
    private LivePlayControl mLivePlayControl;
    private String mScreenId;
    private VideoInfo mVideoInfo;

    public LiveVideoInfo(PlayVideoInfo playVideoInfo) {
        super(playVideoInfo);
        this.mLiveId = playVideoInfo.getLiveId();
    }

    @Override // com.youku.alixplayer.opensdk.YoukuVideoInfo
    public String getAdString() {
        LivePlayControl livePlayControl = this.mLivePlayControl;
        if (livePlayControl == null || !livePlayControl.ad || TextUtils.isEmpty(livePlayControl.adJsonStr)) {
            return null;
        }
        return this.mLivePlayControl.adJsonStr;
    }

    @Override // com.youku.alixplayer.opensdk.YoukuVideoInfo
    public BypassPlayInfo getBypassPlayInfo() {
        return this.mBypassPlayInfo;
    }

    @Override // com.youku.alixplayer.opensdk.YoukuVideoInfo
    public String getLiveId() {
        return this.mLiveId;
    }

    @Override // com.youku.alixplayer.opensdk.YoukuVideoInfo
    public LiveInfo getLiveInfo() {
        return this.mLiveInfo;
    }

    @Override // com.youku.alixplayer.opensdk.YoukuVideoInfo
    public LivePlayControl getLivePlayControl() {
        return this.mLivePlayControl;
    }

    @Override // com.youku.alixplayer.opensdk.YoukuVideoInfo
    public String getPsid() {
        LivePlayControl livePlayControl = this.mLivePlayControl;
        if (livePlayControl != null) {
            return livePlayControl.psid;
        }
        return null;
    }

    @Override // com.youku.alixplayer.opensdk.YoukuVideoInfo
    public String getScreenId() {
        return this.mScreenId;
    }

    @Override // com.youku.alixplayer.opensdk.YoukuVideoInfo
    public String getVideoType() {
        VideoInfo videoInfo = this.mVideoInfo;
        if (videoInfo != null) {
            String str = videoInfo.bizType;
            if ("3".equals(str)) {
                return "来疯";
            }
            if ("4".equals(str)) {
                return "OGC";
            }
            if ("5".equals(str)) {
                return "体育";
            }
            if ("6".equals(str)) {
                return "PGC";
            }
            if ("7".equals(str)) {
                return BaseAdRequestBuilder.LICENSE_CIBN;
            }
            if ("9".equals(str)) {
                return "轮播台";
            }
        }
        return null;
    }

    @Override // com.youku.alixplayer.opensdk.YoukuVideoInfo
    public String isMcu() {
        LivePlayControl livePlayControl = this.mLivePlayControl;
        return (livePlayControl != null && "mic".equals(livePlayControl.streamMode) && PushConstants.URI_PACKAGE_NAME.equals(this.mLivePlayControl.micMode) && this.mLivePlayControl.mcu == 1) ? "1" : "0";
    }

    @Override // com.youku.alixplayer.opensdk.YoukuVideoInfo
    public String isPK() {
        LivePlayControl livePlayControl = this.mLivePlayControl;
        return (livePlayControl == null || !"mic".equals(livePlayControl.streamMode) || !PushConstants.URI_PACKAGE_NAME.equals(this.mLivePlayControl.micMode) || this.mLivePlayControl.micInfo.mcs.size() <= 1) ? "0" : "1";
    }

    public void setLiveVideoInfo(LiveInfo liveInfo) {
        this.mLiveInfo = liveInfo;
        this.mVideoInfo = liveInfo.videoInfo;
        this.mBypassPlayInfo = liveInfo.bypassPlayInfo;
        LivePlayControl livePlayControl = liveInfo.playControl;
        this.mLivePlayControl = livePlayControl;
        if (livePlayControl != null) {
            this.mScreenId = livePlayControl.screenId;
            this.mLiveId = livePlayControl.liveId;
        }
    }
}
