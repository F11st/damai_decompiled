package com.youku.alixplayer.opensdk.live;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.fastjson.JSONObject;
import com.ta.utdid2.android.utils.Base64;
import com.youku.alixplayer.opensdk.IVideoRequest;
import com.youku.alixplayer.opensdk.PlayVideoInfo;
import com.youku.alixplayer.opensdk.PlayerConfig;
import com.youku.alixplayer.opensdk.VideoRequestError;
import com.youku.alixplayer.opensdk.utils.PlayerUtil;
import com.youku.alixplayer.opensdk.utils.TLogUtil;
import com.youku.android.liveservice.LivePlayerController;
import com.youku.android.liveservice.bean.LivePlayControl;
import com.youku.android.liveservice.bean.VideoInfo;
import com.youku.vpm.constants.TableField;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class LiveVideoRequest implements IVideoRequest {
    public static final String TAG = "LiveVideoRequest";
    protected IVideoRequest.Callback mCallback;
    protected Context mContext;
    protected volatile boolean mIsCancel;
    protected PlayerConfig mPlayerConfig;
    protected IVideoRequest.State mState = IVideoRequest.State.IDLE;

    public LiveVideoRequest(Context context, PlayerConfig playerConfig) {
        this.mContext = context;
        this.mPlayerConfig = playerConfig;
    }

    public static byte[] base64Decode(String str) {
        return Base64.decode(str, 2);
    }

    private void reportError(IVideoRequest.Callback callback, VideoRequestError videoRequestError) {
        if (callback == null || this.mIsCancel) {
            return;
        }
        callback.onFailure(videoRequestError);
    }

    private void reportSuccess(IVideoRequest.Callback callback, LiveInfo liveInfo, List<LiveInfo> list) {
        if (callback == null || this.mIsCancel) {
            return;
        }
        callback.onSuccess(liveInfo, list);
    }

    @Override // com.youku.alixplayer.opensdk.IVideoRequest
    public void cancel() {
        this.mIsCancel = true;
    }

    public IVideoRequest.State getState() {
        return this.mState;
    }

    @Override // com.youku.alixplayer.opensdk.IVideoRequest
    public void request(final PlayVideoInfo playVideoInfo, final Map map) {
        TLogUtil.playLog("request live liveId=" + playVideoInfo.getLiveId());
        this.mState = IVideoRequest.State.DOING;
        final String liveId = playVideoInfo.getLiveId();
        final String string = playVideoInfo.getString("sceneId");
        final String string2 = playVideoInfo.getString(TableField.PS_ID);
        final String valueOf = String.valueOf(playVideoInfo.getRequestLiveQuality());
        final String string3 = playVideoInfo.getString("params");
        new Thread() { // from class: com.youku.alixplayer.opensdk.live.LiveVideoRequest.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                String abilityJson;
                String str = liveId;
                LiveVideoRequest liveVideoRequest = LiveVideoRequest.this;
                LivePlayerController livePlayerController = new LivePlayerController(str, liveVideoRequest.mContext, liveVideoRequest.mPlayerConfig.getLiveCCode(), LiveVideoRequest.this.mPlayerConfig.getAppKey());
                livePlayerController.setPlayControlListener(new LivePlayerController.IPlayControlListener() { // from class: com.youku.alixplayer.opensdk.live.LiveVideoRequest.1.1
                    @Override // com.youku.android.liveservice.LivePlayerController.IPlayControlListener
                    public void requestFailure(LivePlayControl livePlayControl, int i, String str2) {
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        LiveVideoRequest.this.requestFailure(playVideoInfo, livePlayControl, i, str2);
                    }

                    @Override // com.youku.android.liveservice.LivePlayerController.IPlayControlListener
                    public void requestSuccess(VideoInfo videoInfo) {
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        LiveVideoRequest.this.requestSuccess(playVideoInfo, videoInfo);
                    }
                });
                String json = map != null ? new JSONObject(map).toString() : null;
                PlayerConfig playerConfig = LiveVideoRequest.this.mPlayerConfig;
                if (playerConfig != null && !TextUtils.isEmpty(playerConfig.getPlayAbilityJson())) {
                    abilityJson = LiveVideoRequest.this.mPlayerConfig.getPlayAbilityJson();
                } else {
                    abilityJson = PlayerUtil.getAbilityJson();
                }
                livePlayerController.getPlayControl(liveId, string, valueOf, json, abilityJson, string3, null, null, null, false, string2);
            }
        }.start();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void requestFailure(PlayVideoInfo playVideoInfo, LivePlayControl livePlayControl, int i, String str) {
        this.mState = IVideoRequest.State.FINISH;
        VideoRequestError videoRequestError = new VideoRequestError(playVideoInfo);
        videoRequestError.setLivePlayControl(livePlayControl);
        videoRequestError.setErrorCode(i);
        videoRequestError.setErrorMsg(str);
        reportError(this.mCallback, videoRequestError);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:49:0x017b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void requestSuccess(com.youku.alixplayer.opensdk.PlayVideoInfo r17, com.youku.android.liveservice.bean.VideoInfo r18) {
        /*
            Method dump skipped, instructions count: 430
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youku.alixplayer.opensdk.live.LiveVideoRequest.requestSuccess(com.youku.alixplayer.opensdk.PlayVideoInfo, com.youku.android.liveservice.bean.VideoInfo):void");
    }

    @Override // com.youku.alixplayer.opensdk.IVideoRequest
    public void setVideoRequestListener(IVideoRequest.Callback callback) {
        this.mCallback = callback;
    }
}
