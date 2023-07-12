package com.youku.live.dago.liveplayback.widget.plugins.dlna;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.tmalltv.tv.lib.ali_tvsharelib.all.utils.LogEx;
import com.tmalltv.tv.lib.ali_tvsharelib.all.utils.StrUtil;
import com.youku.alixplayer.opensdk.IVideoRequest;
import com.youku.alixplayer.opensdk.PlayVideoInfo;
import com.youku.alixplayer.opensdk.VideoRequestError;
import com.youku.alixplayer.opensdk.YoukuVideoInfo;
import com.youku.alixplugin.AlixPlayerContext;
import com.youku.android.liveservice.bean.BypassPlayInfo;
import com.youku.android.liveservice.bean.LivePlayControl;
import com.youku.live.dago.liveplayback.widget.Utils;
import com.youku.live.dago.liveplayback.widget.plugins.dlna.DlnaContract;
import com.youku.live.dago.liveplayback.widget.plugins.dlna.DlnaLiveRequest;
import com.youku.live.dago.liveplayback.widget.plugins.dlna.data.LiveControlInfo;
import com.youku.multiscreen.Client;
import com.yunos.lego.LegoApp;
import com.yunos.tvhelper.ui.app.uielem.nowbar.Nowbar;
import com.yunos.tvhelper.youku.dlna.api.DlnaApiBu;
import com.yunos.tvhelper.youku.dlna.api.DlnaPublic;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class DlnaOpreater {
    public static final String TAG = DlnaPlugin.class.getSimpleName();
    private boolean isRegisterCall;
    private Intent mActivityIntent;
    private Context mContext;
    private AlixPlayerContext mPlayContext;
    private DlnaContract.Presenter mPresenter;
    private String mSceneId;
    private UpsRequestListener upsRequestListener = new UpsRequestListener() { // from class: com.youku.live.dago.liveplayback.widget.plugins.dlna.DlnaOpreater.3
        @Override // com.youku.live.dago.liveplayback.widget.plugins.dlna.DlnaOpreater.UpsRequestListener
        public void onVideoInfoFail(VideoRequestError videoRequestError, Client client) {
            if (videoRequestError.getErrorCode() == -4001) {
                DlnaOpreater.this.mPresenter.handleNoCopyRight();
            } else if (videoRequestError.getErrorCode() != -4008) {
                DlnaOpreater.this.mPresenter.handleUpsError(videoRequestError);
            } else if (client.getExtInfo().drm_type > 1) {
                DlnaOpreater.this.mPresenter.handleNoCopyRight();
            } else {
                DlnaOpreater.this.mPresenter.handleDrm(client);
            }
        }

        @Override // com.youku.live.dago.liveplayback.widget.plugins.dlna.DlnaOpreater.UpsRequestListener
        public void onVideoUrlInfo(DlnaPreProjHandler dlnaPreProjHandler, LiveControlInfo liveControlInfo, int i, boolean z, Client client) {
            if (liveControlInfo == null || client == null) {
                return;
            }
            DlnaOpreater.this.mPresenter.setProjVideoInfo(liveControlInfo);
            BypassPlayInfo bypassPlayInfo = liveControlInfo.BypassPlayInfo;
            final String str = bypassPlayInfo.url;
            if (StrUtil.isValidStr(str) && str.startsWith("http://")) {
                DlnaPublic.DlnaProjReqBuilder vid = new DlnaPublic.DlnaProjReqBuilder().setClient(client).setUrl(str).setTitle(bypassPlayInfo.title).setProjMode(DlnaPublic.DlnaProjMode.LIVE_WEEX).setVid(liveControlInfo.livePlayControl.liveId);
                final DlnaPublic.DlnaProjReq build = vid.setDrmCopyrightKey(bypassPlayInfo.r1 + "," + bypassPlayInfo.encryptRServer + "," + bypassPlayInfo.copyrightKey).setProjScene(dlnaPreProjHandler.getProjScene()).setDefinition(bypassPlayInfo.definition).setshowEpisode(false).build();
                String str2 = DlnaOpreater.TAG;
                StringBuilder sb = new StringBuilder();
                sb.append("start definition ");
                sb.append(bypassPlayInfo.definition);
                Log.i(str2, sb.toString());
                LegoApp.handler().post(new Runnable() { // from class: com.youku.live.dago.liveplayback.widget.plugins.dlna.DlnaOpreater.3.1
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // java.lang.Runnable
                    public void run() {
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "1835617552")) {
                            ipChange.ipc$dispatch("1835617552", new Object[]{this});
                            return;
                        }
                        String str3 = DlnaOpreater.TAG;
                        Log.i(str3, "start cast !!!! with url " + str);
                        DlnaApiBu.api().proj().start(build);
                    }
                });
            }
        }
    };
    private DlnaPublic.IDlnaProjListener mDlnaProjListener = new DlnaPublic.IDlnaProjListener() { // from class: com.youku.live.dago.liveplayback.widget.plugins.dlna.DlnaOpreater.4
        public void onProjExit(DlnaPublic.DlnaProjExitReason dlnaProjExitReason) {
            if (DlnaOpreater.this.mPlayContext.isDlnaMode()) {
                if (!dlnaProjExitReason.mNeedRetry && dlnaProjExitReason != DlnaPublic.DlnaProjExitReason.NEW_REQ && dlnaProjExitReason != DlnaPublic.DlnaProjExitReason.PLAYER_COMPLETE && dlnaProjExitReason != DlnaPublic.DlnaProjExitReason.UNREGISTER_LISTENER) {
                    DlnaOpreater.this.mPresenter.onHideDlnaPanel();
                }
                if (dlnaProjExitReason == DlnaPublic.DlnaProjExitReason.PLAYER_KICKOUT || dlnaProjExitReason == DlnaPublic.DlnaProjExitReason.PLAYER_TERMINATE) {
                    DlnaOpreater.this.mPresenter.onControlEnable(false);
                }
                DlnaPublic.DlnaProjExitReason dlnaProjExitReason2 = DlnaPublic.DlnaProjExitReason.PLAYER_COMPLETE;
            }
        }

        public void onProjReqResult(int i) {
        }

        public void onProjReqStart() {
            String str = DlnaOpreater.TAG;
            Log.i(str, "onProjReqStart");
            if (DlnaOpreater.this.isRegisterCall || DlnaApiBu.api().proj().req().mScene == DlnaPublic.DlnaProjScene.AUTO_2 || DlnaApiBu.api().proj().req().isTracking()) {
                return;
            }
            if (DlnaApiBu.api().proj().req() != null && DlnaApiBu.api().proj().req().mMode != DlnaPublic.DlnaProjMode.LIVE_WEEX) {
                Log.i(str, "onProjReqStart hide panel");
                DlnaOpreater.this.mPresenter.onHideDlnaPanel();
            } else {
                DlnaOpreater.this.mLastClient = DlnaApiBu.api().proj().req().mDev;
                Log.i(str, "onProjReqStart show panel");
                DlnaOpreater.this.mPresenter.onShowDlnaPanel(DlnaApiBu.api().proj().req().mScene);
            }
            DlnaPublic.DlnaProjScene dlnaProjScene = DlnaApiBu.api().proj().req().mScene;
            DlnaPublic.DlnaProjScene dlnaProjScene2 = DlnaPublic.DlnaProjScene.OTT_SCAN;
        }

        public void onProjSucc(DlnaPublic.DlnaProjSuccReason dlnaProjSuccReason, DlnaPublic.DlnaProjSuccMode dlnaProjSuccMode) {
            Log.i(DlnaOpreater.TAG, "onProjSucc");
            if (DlnaApiBu.api().proj().req().mScene == DlnaPublic.DlnaProjScene.AUTO_2) {
                return;
            }
            if (DlnaOpreater.this.mLastClient == null) {
                DlnaOpreater.this.mLastClient = DlnaApiBu.api().proj().req().mDev;
            }
            DlnaPublic.DlnaProjReq req = DlnaApiBu.api().proj().req();
            if (req != null) {
                DlnaPublic.DlnaProjScene dlnaProjScene = req.mScene;
                DlnaPublic.DlnaProjScene dlnaProjScene2 = DlnaPublic.DlnaProjScene.OTT_SCAN;
            }
        }

        public void onUpdatePlayerAttr(DlnaPublic.DlnaPlayerAttr dlnaPlayerAttr) {
            if (DlnaOpreater.this.mPlayContext.isDlnaMode()) {
                if (dlnaPlayerAttr == DlnaPublic.DlnaPlayerAttr.PROGRESS) {
                    DlnaOpreater.this.mPresenter.onCurrentPositionUpdate(DlnaApiBu.api().proj().getPlayerProgress(), 0);
                } else if (dlnaPlayerAttr == DlnaPublic.DlnaPlayerAttr.STAT) {
                    if (DlnaApiBu.api().proj().getPlayerStat() == DlnaPublic.DlnaPlayerStat.PLAYING) {
                        DlnaOpreater.this.mPresenter.onPlayerPlay();
                    } else {
                        DlnaOpreater.this.mPresenter.onPlayerPause();
                    }
                } else if (dlnaPlayerAttr == DlnaPublic.DlnaPlayerAttr.PLAYSPEED) {
                    DlnaOpreater.this.mPresenter.onPlayerSpeed(DlnaApiBu.api().proj().getPlayerPlaySpeed());
                }
            }
        }
    };
    private Client mLastClient = null;

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public interface UpsRequestListener {
        void onVideoInfoFail(VideoRequestError videoRequestError, Client client);

        void onVideoUrlInfo(DlnaPreProjHandler dlnaPreProjHandler, LiveControlInfo liveControlInfo, int i, boolean z, Client client);
    }

    public DlnaOpreater(AlixPlayerContext alixPlayerContext, DlnaContract.Presenter presenter) {
        this.mContext = alixPlayerContext.getContext();
        this.mPlayContext = alixPlayerContext;
        this.mPresenter = presenter;
        this.isRegisterCall = true;
        DlnaApiBu.api().proj().registerListener(this.mDlnaProjListener);
        this.isRegisterCall = false;
    }

    private boolean ismFromNowbar() {
        Intent intent = this.mActivityIntent;
        if (intent == null || intent.getExtras() == null) {
            return false;
        }
        return this.mActivityIntent.getExtras().getBoolean("from_nowbar", false);
    }

    private void liveGetVideoInfo(final DlnaPreProjHandler dlnaPreProjHandler, final int i, final boolean z, final Client client, final UpsRequestListener upsRequestListener) {
        PlayVideoInfo playVideoInfo;
        if (z) {
            playVideoInfo = new PlayVideoInfo(dlnaPreProjHandler.getPreProjInfo().mVid);
        } else {
            playVideoInfo = new PlayVideoInfo(dlnaPreProjHandler.getPreProjInfo().mVid);
        }
        PlayVideoInfo playVideoInfo2 = playVideoInfo;
        playVideoInfo2.setRequestLiveQuality(dlnaPreProjHandler.getPreProjInfo().liveQuality);
        String str = TAG;
        Log.i(str, "liveGetVideoInfo with id " + dlnaPreProjHandler.getPreProjInfo().mVid + " quality=" + playVideoInfo2.getRequestLiveQuality());
        if (client.getExtInfo().drm_type % 2 == 0) {
            int i2 = client.getExtInfo().drm_type;
        } else {
            int i3 = client.getExtInfo().drm_type;
        }
        playVideoInfo2.putString("sceneId", this.mSceneId);
        DlnaLiveRequest dlnaLiveRequest = new DlnaLiveRequest(this.mContext, this.mPlayContext.getPlayerConfig());
        HashMap hashMap = new HashMap();
        hashMap.put("ccode", Utils.getDlnaCCode(this.mContext));
        dlnaLiveRequest.request(playVideoInfo2, hashMap, new DlnaLiveRequest.Callback<BypassPlayInfo, LivePlayControl>() { // from class: com.youku.live.dago.liveplayback.widget.plugins.dlna.DlnaOpreater.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.live.dago.liveplayback.widget.plugins.dlna.DlnaLiveRequest.Callback
            public void onFailure(VideoRequestError videoRequestError) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "2118642777")) {
                    ipChange.ipc$dispatch("2118642777", new Object[]{this, videoRequestError});
                    return;
                }
                String str2 = DlnaOpreater.TAG;
                Log.e(str2, "liveGetVideoInfo fail ." + videoRequestError.getErrorMsg());
                upsRequestListener.onVideoInfoFail(videoRequestError, client);
                DlnaPreProjHandler dlnaPreProjHandler2 = dlnaPreProjHandler;
                if (dlnaPreProjHandler2 != null) {
                    dlnaPreProjHandler2.onUpsResult(videoRequestError.getErrorCode(), videoRequestError.getErrorMsg());
                }
            }

            @Override // com.youku.live.dago.liveplayback.widget.plugins.dlna.DlnaLiveRequest.Callback
            public void onStat(Map<String, String> map) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1254742968")) {
                    ipChange.ipc$dispatch("1254742968", new Object[]{this, map});
                }
            }

            @Override // com.youku.live.dago.liveplayback.widget.plugins.dlna.DlnaLiveRequest.Callback
            public void onSuccess(BypassPlayInfo bypassPlayInfo, LivePlayControl livePlayControl) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1113854819")) {
                    ipChange.ipc$dispatch("1113854819", new Object[]{this, bypassPlayInfo, livePlayControl});
                    return;
                }
                Log.i(DlnaOpreater.TAG, "liveGetVideoInfo success .");
                LiveControlInfo liveControlInfo = new LiveControlInfo();
                liveControlInfo.livePlayControl = livePlayControl;
                liveControlInfo.BypassPlayInfo = bypassPlayInfo;
                upsRequestListener.onVideoUrlInfo(dlnaPreProjHandler, liveControlInfo, i, z, client);
                DlnaPreProjHandler dlnaPreProjHandler2 = dlnaPreProjHandler;
                if (dlnaPreProjHandler2 != null) {
                    dlnaPreProjHandler2.onUpsResult(0, "ups success");
                }
            }
        });
    }

    private String tag() {
        return LogEx.tag(this);
    }

    public void checkChangeDlnaModel() {
        try {
            YoukuVideoInfo youkuVideoInfo = this.mPlayContext.getPlayerContainer().getPlayer().getVideoStream().getYoukuVideoInfo();
            if (youkuVideoInfo != null && youkuVideoInfo.getBypassPlayInfo() != null && ismFromNowbar()) {
                LivePlayControl livePlayControl = youkuVideoInfo.getLivePlayControl();
                if (StrUtil.isValidStr(livePlayControl.liveId) && DlnaApiBu.api().proj().stat() != DlnaPublic.DlnaProjStat.IDLE) {
                    String str = DlnaApiBu.api().proj().req().mVid;
                    if (StrUtil.isValidStr(str) && str.equals(livePlayControl.liveId)) {
                        LiveControlInfo liveControlInfo = new LiveControlInfo();
                        liveControlInfo.BypassPlayInfo = youkuVideoInfo.getBypassPlayInfo();
                        liveControlInfo.livePlayControl = youkuVideoInfo.getLivePlayControl();
                        this.mPresenter.setProjVideoInfo(liveControlInfo);
                        this.mPresenter.onShowDlnaPanel(DlnaPublic.DlnaProjScene.AUTO);
                        if (this.mPlayContext == null || !Nowbar.getInst().haveNowbar(this.mPlayContext.getActivity())) {
                            return;
                        }
                        Nowbar.getInst().setForceHide(this.mPlayContext.getActivity(), true);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void liveRequestForCopyright(String str, final IVideoRequest.Callback<BypassPlayInfo, LivePlayControl> callback) {
        PlayVideoInfo playVideoInfo = new PlayVideoInfo(str);
        HashMap hashMap = new HashMap();
        hashMap.put("ccode", Utils.getDlnaCCode(this.mContext));
        new DlnaLiveRequest(this.mContext, this.mPlayContext.getPlayerConfig()).request(playVideoInfo, hashMap, new DlnaLiveRequest.Callback<BypassPlayInfo, LivePlayControl>() { // from class: com.youku.live.dago.liveplayback.widget.plugins.dlna.DlnaOpreater.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.live.dago.liveplayback.widget.plugins.dlna.DlnaLiveRequest.Callback
            public void onFailure(VideoRequestError videoRequestError) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-56037320")) {
                    ipChange.ipc$dispatch("-56037320", new Object[]{this, videoRequestError});
                } else {
                    callback.onFailure(videoRequestError);
                }
            }

            @Override // com.youku.live.dago.liveplayback.widget.plugins.dlna.DlnaLiveRequest.Callback
            public void onStat(Map<String, String> map) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1000006423")) {
                    ipChange.ipc$dispatch("1000006423", new Object[]{this, map});
                }
            }

            @Override // com.youku.live.dago.liveplayback.widget.plugins.dlna.DlnaLiveRequest.Callback
            public void onSuccess(BypassPlayInfo bypassPlayInfo, LivePlayControl livePlayControl) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "472768676")) {
                    ipChange.ipc$dispatch("472768676", new Object[]{this, bypassPlayInfo, livePlayControl});
                } else {
                    callback.onSuccess(bypassPlayInfo, livePlayControl);
                }
            }
        });
    }

    public void pause() {
        DlnaApiBu.api().proj().pause();
    }

    public void play() {
        DlnaApiBu.api().proj().play();
    }

    public void release() {
        DlnaApiBu.api().proj().unregisterListenerIf(this.mDlnaProjListener);
        this.mPlayContext = null;
    }

    public void setActivityIntent(Intent intent) {
        this.mActivityIntent = intent;
    }

    public void setSceneId(String str) {
        this.mSceneId = str;
    }

    public void startProjectionDevice(DlnaPreProjHandler dlnaPreProjHandler, Client client) {
        AlixPlayerContext alixPlayerContext;
        AlixPlayerContext alixPlayerContext2;
        if (client == null || (alixPlayerContext = this.mPlayContext) == null || alixPlayerContext.getPlayerContainer() == null || this.mPlayContext.getPlayerContainer() == null || this.mPlayContext.getPlayerContainer().getVideoStream() == null) {
            return;
        }
        if (DlnaApiBu.api().branding().shouldUseMp4(client)) {
            liveGetVideoInfo(dlnaPreProjHandler, (int) this.mPlayContext.getPlayerContainer().getPlayer().getCurrentPosition(), true, client, this.upsRequestListener);
        } else {
            liveGetVideoInfo(dlnaPreProjHandler, (dlnaPreProjHandler.getProjScene() == DlnaPublic.DlnaProjScene.AUTO || (alixPlayerContext2 = this.mPlayContext) == null || alixPlayerContext2.getPlayerContainer() == null || this.mPlayContext.getPlayerContainer().getPlayer() == null) ? 0 : (int) this.mPlayContext.getPlayerContainer().getPlayer().getCurrentPosition(), false, client, this.upsRequestListener);
        }
    }
}
