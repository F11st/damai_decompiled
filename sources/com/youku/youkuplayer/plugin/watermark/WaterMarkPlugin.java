package com.youku.youkuplayer.plugin.watermark;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.youku.android.liveservice.bean.WaterMarkV2;
import com.youku.media.arch.instruments.utils.Logger;
import com.youku.playerservice.axp.axpinterface.PlayDefinition;
import com.youku.playerservice.axp.playinfo.PlayInfo;
import com.youku.playerservice.axp.playinfo.PlayInfoResult;
import com.youku.playerservice.axp.utils.TLogUtil;
import com.youku.upsplayer.module.Watermark;
import com.youku.youkuplayer.YKEventListener;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class WaterMarkPlugin extends YKEventListener {
    private static final String TAG = "WaterMarkPlugin";
    private Context mContext;
    private boolean mDisableWaterMark;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private WaterMarkRootView mWaterMarkRootView;
    private List<WaterMarkBean> mWaterMarks;

    public WaterMarkPlugin(Context context) {
        this.mContext = context;
        this.mWaterMarkRootView = new WaterMarkRootView(this.mContext);
    }

    public WaterMarkRootView getWaterMarkRootView() {
        return this.mWaterMarkRootView;
    }

    @Override // com.youku.youkuplayer.YKEventListener, com.youku.youkuplayer.IPlayerEventListener
    public void onDataReady(PlayInfoResult playInfoResult) {
        String str;
        this.mWaterMarks = new ArrayList();
        if (this.mDisableWaterMark) {
            return;
        }
        PlayInfo playInfo = playInfoResult.getPlayInfo();
        if (playInfo.getPlayType() == PlayDefinition.PlayType.LIVE && playInfo.getPlayInfoResponse() != null && playInfo.getPlayInfoResponse().getLiveInfo() != null && playInfo.getPlayInfoResponse().getLiveInfo().getLivePlayControl() != null && playInfo.getPlayInfoResponse().getLiveInfo().getLivePlayControl().waterMarkV2 != null) {
            try {
                for (WaterMarkV2 waterMarkV2 : playInfo.getPlayInfoResponse().getLiveInfo().getLivePlayControl().waterMarkV2) {
                    this.mWaterMarks.add(new WaterMarkBean(waterMarkV2));
                }
                Logger.d(TAG, "construct watermark from Live!", new Object[0]);
                return;
            } catch (Exception unused) {
                str = "construct watermark exception!";
            }
        } else if (playInfo.getPlayType() != PlayDefinition.PlayType.VOD || playInfo.getPlayInfoResponse() == null || playInfo.getPlayInfoResponse().getUpsInfo() == null || playInfo.getPlayInfoResponse().getUpsInfo().getVideoInfo() == null || playInfo.getPlayInfoResponse().getUpsInfo().getVideoInfo().getWatermarks() == null) {
            return;
        } else {
            try {
                for (Watermark watermark : playInfo.getPlayInfoResponse().getUpsInfo().getVideoInfo().getWatermarks()) {
                    this.mWaterMarks.add(new WaterMarkBean(this.mContext, watermark));
                    Logger.d(TAG, "construct watermark from Live1!", new Object[0]);
                }
                return;
            } catch (Exception unused2) {
                str = "construct watermark exception1!";
            }
        }
        TLogUtil.loge(TAG, str);
    }

    @Override // com.youku.youkuplayer.YKEventListener, com.youku.youkuplayer.IPlayerEventListener
    public void onPositionChange(int i) {
        this.mWaterMarkRootView.updateCurrentPosition(i);
    }

    @Override // com.youku.youkuplayer.YKEventListener, com.youku.youkuplayer.IPlayerEventListener
    public void onRealVideoStart() {
        List<WaterMarkBean> list = this.mWaterMarks;
        if (list != null) {
            this.mWaterMarkRootView.bindData(list);
        }
    }

    @Override // com.youku.youkuplayer.YKEventListener, com.youku.youkuplayer.IPlayerEventListener
    public void onVideoSizeChanged(int i, int i2) {
        super.onVideoSizeChanged(i, i2);
        this.mWaterMarkRootView.onSizeChanged(i, i2);
    }

    public void setDisableWaterMark(boolean z) {
        this.mDisableWaterMark = z;
    }
}
