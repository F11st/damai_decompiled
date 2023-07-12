package com.youku.live.dago.liveplayback.widget.plugins.watermark;

import android.content.Context;
import android.view.ViewGroup;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.alixplayer.IAlixPlayer;
import com.youku.alixplayer.OnCurrentPositionChangeListener;
import com.youku.alixplayer.OnStateChangeListener;
import com.youku.alixplayer.opensdk.IPlayerContainer;
import com.youku.alixplayer.opensdk.OnVideoStreamListener;
import com.youku.alixplayer.opensdk.PlayVideoInfo;
import com.youku.alixplayer.opensdk.VideoRequestError;
import com.youku.alixplayer.opensdk.YoukuVideoInfo;
import com.youku.alixplayer.opensdk.utils.Logger;
import com.youku.alixplayer.opensdk.utils.TLogUtil;
import com.youku.alixplugin.AlixPlayerContext;
import com.youku.alixplugin.base.PluginConfig;
import com.youku.android.liveservice.bean.WaterMarkV2;
import com.youku.upsplayer.module.Watermark;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class WaterMarkPlugin implements OnCurrentPositionChangeListener, OnStateChangeListener, OnVideoStreamListener {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String TAG = "WaterMarkPlugin";
    private Context mContext;
    private IPlayerContainer mPlayerContainer;
    private YoukuVideoInfo mVideoInfo;
    private WaterMarkContainer mWaterMarkContainer;
    private List<WaterMark> mWaterMarks;

    public WaterMarkPlugin(AlixPlayerContext alixPlayerContext, PluginConfig pluginConfig, ViewGroup viewGroup) {
        this.mContext = alixPlayerContext.getContext();
        IPlayerContainer playerContainer = alixPlayerContext.getPlayerContainer();
        this.mPlayerContainer = playerContainer;
        playerContainer.addVideoStreamListener(this);
        this.mPlayerContainer.getPlayer().addOnCurrentPositionChangeListener(this);
        this.mPlayerContainer.getPlayer().addOnPlayerStateListener(this);
        this.mWaterMarkContainer = new WaterMarkContainer(this.mContext);
    }

    public WaterMarkContainer getWaterMarkContainer() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-489572043") ? (WaterMarkContainer) ipChange.ipc$dispatch("-489572043", new Object[]{this}) : this.mWaterMarkContainer;
    }

    @Override // com.youku.alixplayer.OnCurrentPositionChangeListener
    public void onCurrentPostionChange(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "138606373")) {
            ipChange.ipc$dispatch("138606373", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.mWaterMarkContainer.updateCurrentPosition(i);
        }
    }

    @Override // com.youku.alixplayer.opensdk.OnVideoStreamListener
    public void onDataFail(VideoRequestError videoRequestError) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-181879025")) {
            ipChange.ipc$dispatch("-181879025", new Object[]{this, videoRequestError});
        }
    }

    @Override // com.youku.alixplayer.opensdk.OnVideoStreamListener
    public void onDataReady(YoukuVideoInfo youkuVideoInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1927986638")) {
            ipChange.ipc$dispatch("1927986638", new Object[]{this, youkuVideoInfo});
            return;
        }
        this.mVideoInfo = youkuVideoInfo;
        this.mWaterMarks = new ArrayList();
        if (this.mVideoInfo.getLiveInfo() != null && this.mVideoInfo.getLiveInfo().waterMarkV2List != null) {
            try {
                for (WaterMarkV2 waterMarkV2 : this.mVideoInfo.getLiveInfo().waterMarkV2List) {
                    this.mWaterMarks.add(new WaterMark(waterMarkV2));
                }
                Logger.d(TAG, "construct watermark from Live!");
            } catch (Exception unused) {
                TLogUtil.loge(TAG, "construct watermark exception!");
            }
        } else if (youkuVideoInfo.getUpsVideoInfo() != null && youkuVideoInfo.getUpsVideoInfo().getWatermarks() != null) {
            try {
                for (Watermark watermark : youkuVideoInfo.getUpsVideoInfo().getWatermarks()) {
                    this.mWaterMarks.add(new WaterMark(this.mContext, watermark));
                    Logger.d(TAG, "construct watermark from Live1!");
                }
            } catch (Exception unused2) {
                TLogUtil.loge(TAG, "construct watermark exception1!");
            }
        }
    }

    @Override // com.youku.alixplayer.opensdk.OnVideoStreamListener
    public void onNewRequest(PlayVideoInfo playVideoInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "14900999")) {
            ipChange.ipc$dispatch("14900999", new Object[]{this, playVideoInfo});
        }
    }

    public void onSizeChanged(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2122354490")) {
            ipChange.ipc$dispatch("2122354490", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
        } else {
            this.mWaterMarkContainer.onSizeChanged(i, i2);
        }
    }

    @Override // com.youku.alixplayer.OnStateChangeListener
    public void onStateChange(IAlixPlayer.State state, IAlixPlayer.State state2) {
        List<WaterMark> list;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1294677224")) {
            ipChange.ipc$dispatch("1294677224", new Object[]{this, state, state2});
        } else if (state == IAlixPlayer.State.STATE_VIDEO_PAUSED || state2 != IAlixPlayer.State.STATE_VIDEO_STARTED || (list = this.mWaterMarks) == null) {
        } else {
            this.mWaterMarkContainer.bindData(list);
        }
    }
}
