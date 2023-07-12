package com.youku.playerservice.axp.playinfo.request;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.fastjson.JSONObject;
import com.youku.android.liveservice.LivePlayerController;
import com.youku.android.liveservice.bean.LivePlayControl;
import com.youku.android.liveservice.bean.Quality;
import com.youku.android.liveservice.bean.Stream;
import com.youku.android.liveservice.bean.VideoInfo;
import com.youku.playerservice.axp.PlayerConfig;
import com.youku.playerservice.axp.axpinterface.IPlayInfoRequest;
import com.youku.playerservice.axp.axpinterface.PlayDefinition;
import com.youku.playerservice.axp.playinfo.LiveInfo;
import com.youku.playerservice.axp.playinfo.PlayInfoError;
import com.youku.playerservice.axp.playinfo.PlayInfoLiveResponse;
import com.youku.playerservice.axp.playinfo.PlayInfoResponse;
import com.youku.playerservice.axp.playparams.PlayParams;
import com.youku.playerservice.axp.utils.AdUtil;
import com.youku.playerservice.axp.utils.PlayerUtil;
import com.youku.playerservice.axp.utils.TLogUtil;
import com.youku.vpm.constants.TableField;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class LiveRequest implements IPlayInfoRequest {
    private static final String TAG = "LiveRequest";
    private IPlayInfoRequest.Callback mCallback;
    private Context mContext;
    protected volatile boolean mIsCancel;
    private PlayParams mPlayParams;
    private PlayerConfig mPlayerConfig;
    private List<PlayInfoResponse> mResponses;
    private IPlayInfoRequest.State mState = IPlayInfoRequest.State.IDLE;

    public LiveRequest(PlayerConfig playerConfig) {
        this.mContext = playerConfig.getContext();
        this.mPlayerConfig = playerConfig;
    }

    private String getEdgeParam(LivePlayControl livePlayControl) {
        List<Stream> list;
        if (livePlayControl == null || (list = livePlayControl.streams) == null || list.size() <= 0) {
            return null;
        }
        for (Stream stream : livePlayControl.streams) {
            if (!TextUtils.isEmpty(stream.edgeParam)) {
                return stream.edgeParam;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportResult(PlayInfoResponse playInfoResponse) {
        if (this.mCallback == null || this.mIsCancel) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(playInfoResponse);
        this.mResponses = arrayList;
        this.mCallback.onFinished(this.mPlayParams, arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean useRaphaelPlayer(LivePlayControl livePlayControl) {
        List<Stream> list;
        if (livePlayControl == null || (list = livePlayControl.streams) == null || list.size() <= 0 || 1 != livePlayControl.fansMode) {
            return false;
        }
        String edgeParam = getEdgeParam(livePlayControl);
        for (Stream stream : livePlayControl.streams) {
            if (edgeParam != null && livePlayControl.sceneId.equals(stream.sceneId)) {
                TLogUtil.playLog("PlayInfoLiveResponse edge video, use raphael player:" + stream.edgeParam);
                return true;
            }
        }
        TLogUtil.playLog("PlayInfoLiveResponse edge video, use raphael player false edgeParam ： " + edgeParam);
        return false;
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayInfoRequest
    public void cancel() {
        this.mIsCancel = true;
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayInfoRequest
    public List<PlayInfoResponse> getPlayInfoResponses() {
        return this.mResponses;
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayInfoRequest
    public PlayParams getPlayParams() {
        return this.mPlayParams;
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayInfoRequest
    public IPlayInfoRequest.State getState() {
        return this.mState;
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayInfoRequest
    public void request(PlayParams playParams) {
        Map<String, String> adRequestParams;
        TLogUtil.playLog("request live liveId=" + playParams.getPlayIdParams().getPlayId());
        this.mState = IPlayInfoRequest.State.RUNNING;
        this.mPlayParams = playParams;
        if (this.mIsCancel) {
            return;
        }
        String playId = playParams.getPlayIdParams().getPlayId();
        String string = playParams.getPlayIdParams().getString("sceneId");
        String string2 = playParams.getPlayIdParams().getString(TableField.PS_ID);
        String valueOf = String.valueOf(playParams.getPlayIdParams().getRequestLiveQuality());
        String string3 = playParams.getPlayIdParams().getString("params");
        String string4 = playParams.getPlayIdParams().getString(PlayInfoLiveResponse.IS_RAPHAEL);
        String jSONObject = PlayerUtil.getAbilityJsonInJsonObject(true, this.mContext).toString();
        String str = playParams.getPlayIdParams().getDlnaParams().get("dlnaLivePlayAbility");
        String str2 = !TextUtils.isEmpty(str) ? str : jSONObject;
        LivePlayerController livePlayerController = new LivePlayerController(playId, this.mContext, playParams.getPlayIdParams().getCCode(), this.mPlayerConfig.getAppKey());
        livePlayerController.setPlayControlListener(new LivePlayerController.IPlayControlListener() { // from class: com.youku.playerservice.axp.playinfo.request.LiveRequest.1
            @Override // com.youku.android.liveservice.LivePlayerController.IPlayControlListener
            public void requestFailure(LivePlayControl livePlayControl, int i, String str3) {
                if (LiveRequest.this.mIsCancel) {
                    return;
                }
                LiveRequest.this.mState = IPlayInfoRequest.State.FINISHED;
                PlayInfoLiveResponse playInfoLiveResponse = new PlayInfoLiveResponse(LiveRequest.this.mContext, LiveRequest.this.mPlayParams);
                playInfoLiveResponse.setInfoType(PlayDefinition.PlayInfoType.LIVE);
                playInfoLiveResponse.setLiveInfo(new LiveInfo(livePlayControl));
                PlayInfoError playInfoError = new PlayInfoError();
                playInfoError.setErrorCode(i);
                playInfoError.setErrorMsg(str3);
                playInfoLiveResponse.setError(playInfoError);
                playInfoLiveResponse.setRequestMode(PlayInfoResponse.RequestMode.NORMAL);
                playInfoLiveResponse.setTimeOfRequestEnd(System.currentTimeMillis());
                LiveRequest.this.reportResult(playInfoLiveResponse);
            }

            @Override // com.youku.android.liveservice.LivePlayerController.IPlayControlListener
            public void requestSuccess(VideoInfo videoInfo) {
                LivePlayControl livePlayControl;
                Quality defaultQuality;
                if (LiveRequest.this.mIsCancel) {
                    return;
                }
                LiveRequest.this.mState = IPlayInfoRequest.State.FINISHED;
                PlayInfoLiveResponse playInfoLiveResponse = new PlayInfoLiveResponse(LiveRequest.this.mContext, LiveRequest.this.mPlayParams);
                playInfoLiveResponse.setInfoType(PlayDefinition.PlayInfoType.LIVE);
                if (LiveRequest.this.useRaphaelPlayer(videoInfo.livePlayControl) && (livePlayControl = videoInfo.livePlayControl) != null && (defaultQuality = livePlayControl.getDefaultQuality()) != null) {
                    defaultQuality.playType = "raphael";
                }
                LiveInfo liveInfo = new LiveInfo(videoInfo.livePlayControl);
                liveInfo.setTrail(videoInfo.isTrail);
                playInfoLiveResponse.setLiveInfo(liveInfo);
                playInfoLiveResponse.setRequestMode(PlayInfoResponse.RequestMode.NORMAL);
                playInfoLiveResponse.setTimeOfRequestEnd(System.currentTimeMillis());
                playInfoLiveResponse.setDurationOfRequest(videoInfo.costTime);
                LiveRequest.this.reportResult(playInfoLiveResponse);
            }
        });
        String str3 = null;
        if (this.mPlayParams.getPlayIdParams() != null && !this.mPlayParams.getPlayIdParams().isDisableAd() && (adRequestParams = AdUtil.getAdRequestParams(7)) != null) {
            str3 = new JSONObject(adRequestParams).toString();
        }
        HashMap hashMap = new HashMap();
        hashMap.put("fansMode", string4);
        livePlayerController.getPlayControl(playId, string, valueOf, str3, str2, string3, null, null, null, false, string2, hashMap);
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayInfoRequest
    public void setRequestCallback(IPlayInfoRequest.Callback callback) {
        this.mCallback = callback;
    }
}
