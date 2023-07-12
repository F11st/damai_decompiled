package com.youku.live.dago.liveplayback.widget.plugins.dlna;

import android.app.Activity;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.ViewGroup;
import com.alibaba.fastjson.JSON;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.tmalltv.tv.lib.ali_tvsharelib.all.utils.ConnectivityMgr;
import com.tmalltv.tv.lib.ali_tvsharelib.all.utils.LogEx;
import com.tmalltv.tv.lib.ali_tvsharelib.all.utils.PropUtil;
import com.tmalltv.tv.lib.ali_tvsharelib.all.utils.StrUtil;
import com.youku.alixplayer.IAlixPlayer;
import com.youku.alixplayer.OnStateChangeListener;
import com.youku.alixplayer.opensdk.IPlayer;
import com.youku.alixplayer.opensdk.IVideoRequest;
import com.youku.alixplayer.opensdk.OnVideoStreamListener;
import com.youku.alixplayer.opensdk.PlayVideoInfo;
import com.youku.alixplayer.opensdk.VideoRequestError;
import com.youku.alixplayer.opensdk.YoukuVideoInfo;
import com.youku.alixplugin.AlixPlayerContext;
import com.youku.alixplugin.OnDataSourceListener;
import com.youku.alixplugin.base.AbsPlugin;
import com.youku.alixplugin.base.PluginConfig;
import com.youku.alixplugin.view.OnInflateListener;
import com.youku.android.liveservice.bean.BypassPlayInfo;
import com.youku.android.liveservice.bean.LivePlayControl;
import com.youku.android.liveservice.bean.Quality;
import com.youku.kubus.Event;
import com.youku.kubus.Subscribe;
import com.youku.kubus.ThreadMode;
import com.youku.live.UserInfo;
import com.youku.live.dago.liveplayback.ApiConstants;
import com.youku.live.dago.liveplayback.R;
import com.youku.live.dago.liveplayback.widget.Utils;
import com.youku.live.dago.liveplayback.widget.plugins.dlna.DlnaContract;
import com.youku.live.dago.liveplayback.widget.plugins.dlna.data.ClientModelDesc;
import com.youku.live.dago.liveplayback.widget.plugins.dlna.data.DlnaQualityInfo;
import com.youku.live.dago.liveplayback.widget.plugins.dlna.data.LiveControlInfo;
import com.youku.live.dago.liveplayback.widget.plugins.dlna.data.ScanPairDeviceInfo;
import com.youku.live.dago.liveplayback.widget.plugins.dlna.view.DlnaDlg;
import com.youku.live.dsl.config.OptConfigUtils;
import com.youku.multiscreen.Client;
import com.yunos.lego.LegoApp;
import com.yunos.tvhelper.support.api.SupportApiBu;
import com.yunos.tvhelper.ui.api.UiApiDef;
import com.yunos.tvhelper.ui.app.UiAppDef;
import com.yunos.tvhelper.ui.app.uielem.nowbar.Nowbar;
import com.yunos.tvhelper.youku.dlna.api.DlnaApiBu;
import com.yunos.tvhelper.youku.dlna.api.DlnaPublic;
import com.yunos.youku.multiscreen.YkMultiscreenEntry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class DlnaPlugin extends AbsPlugin implements OnInflateListener, DlnaContract.Presenter {
    private static final String TAG = "DlnaPlugin";
    private UiApiDef.IActionCallback mActionCallback;
    private Activity mActivity;
    private AudioManager mAudioManager;
    private int mChangeDevReason;
    private UiApiDef.IControlPanelListener mControlPanelListener;
    private DlnaControlPanelView mControlPanelView;
    private Runnable mDelayShowControl;
    private Runnable mDevicePairRunnable;
    private DlnaPublic.IDlnaDevsListenerEx mDlnaDevListener;
    private DlnaOpreater mDlnaOpreater;
    private Boolean mIsDlna;
    boolean mNeedSetSpeed;
    private boolean mNeedUpdate;
    private ScanPairDeviceInfo mOttScanDeviceInfo;
    private IPlayer mPlayer;
    private DlnaPlugin mPlugin;
    private Client mPushClient;
    private DlnaDlg.QualityListener mQualityListener;
    private String mSceneId;
    private Client mSourceClient;
    Double mSpeed;
    private int mTryCount;
    private LiveControlInfo mVideoInfo;
    private YoukuVideoInfo mYoukuVideoInfo;

    public DlnaPlugin(AlixPlayerContext alixPlayerContext, PluginConfig pluginConfig, ViewGroup viewGroup) {
        super(alixPlayerContext, pluginConfig, viewGroup);
        this.mIsDlna = Boolean.FALSE;
        this.mAudioManager = null;
        this.mNeedUpdate = true;
        this.mPushClient = null;
        this.mTryCount = 0;
        this.mDevicePairRunnable = new Runnable() { // from class: com.youku.live.dago.liveplayback.widget.plugins.dlna.DlnaPlugin.5
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // java.lang.Runnable
            public void run() {
                Client cloudCastDev;
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1237309732")) {
                    ipChange.ipc$dispatch("-1237309732", new Object[]{this});
                    return;
                }
                DlnaPlugin dlnaPlugin = DlnaPlugin.this;
                Client scanClient = dlnaPlugin.getScanClient(dlnaPlugin.mOttScanDeviceInfo);
                if (scanClient != null) {
                    DlnaPlugin dlnaPlugin2 = DlnaPlugin.this;
                    dlnaPlugin2.startOttScanProj(scanClient, ((AbsPlugin) dlnaPlugin2).mPlayerContext.getPlayerContainer().getPlayVideoInfo().getLiveId());
                    LogEx.i("", "startOttScanProj by dlna:");
                } else if (!SupportApiBu.api().orange().multiscreen().support_downgrade_cloud || (cloudCastDev = DlnaApiBu.api().devs().getCloudCastDev()) == null || !cloudCastDev.isAlived() || DlnaPlugin.this.mTryCount < 3) {
                    if (DlnaPlugin.this.mTryCount % 3 == 0) {
                        DlnaApiBu.api().devs().search();
                    }
                    if (DlnaPlugin.this.mTryCount == 0 && SupportApiBu.api().orange().multiscreen().support_downgrade_cloud) {
                        DlnaApiBu.api().devs().searchCloudCastDev(JSON.toJSONString(DlnaPlugin.this.mOttScanDeviceInfo));
                    }
                    if (DlnaPlugin.this.mTryCount <= SupportApiBu.api().orange().multiscreen().ott_scan_timeout) {
                        LegoApp.handler().postDelayed(DlnaPlugin.this.mDevicePairRunnable, 1000L);
                    } else {
                        DlnaPlugin dlnaPlugin3 = DlnaPlugin.this;
                        dlnaPlugin3.commitOttScanResult(dlnaPlugin3.mOttScanDeviceInfo);
                    }
                    DlnaPlugin.access$1108(DlnaPlugin.this);
                } else {
                    DlnaPlugin dlnaPlugin4 = DlnaPlugin.this;
                    dlnaPlugin4.startOttScanProj(cloudCastDev, ((AbsPlugin) dlnaPlugin4).mPlayerContext.getPlayerContainer().getPlayVideoInfo().getLiveId());
                    LogEx.i("", "startOttScanProj by cloud:");
                }
            }
        };
        this.mDelayShowControl = new Runnable() { // from class: com.youku.live.dago.liveplayback.widget.plugins.dlna.DlnaPlugin.8
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // java.lang.Runnable
            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1826850247")) {
                    ipChange.ipc$dispatch("-1826850247", new Object[]{this});
                    return;
                }
                ((AbsPlugin) DlnaPlugin.this).mPlayerContext.getEventBus().post(new Event(ApiConstants.EventType.SHOW_CONTROL));
                Event event = new Event(ApiConstants.EventType.SHOW_DLNA_NOTIFY_TIP);
                event.data = Boolean.FALSE;
                ((AbsPlugin) DlnaPlugin.this).mPlayerContext.getEventBus().post(event);
            }
        };
        this.mControlPanelListener = new UiApiDef.IControlPanelListener() { // from class: com.youku.live.dago.liveplayback.widget.plugins.dlna.DlnaPlugin.10
            public void onExit() {
                if (DlnaPlugin.this.mPlugin.mControlPanelView.isShow()) {
                    DlnaPlugin.this.mPlugin.onHideDlnaPanel();
                }
            }

            public void onShowDeviceList(Activity activity) {
                Event event = new Event();
                event.data = Boolean.FALSE;
                DlnaPlugin.this.mPlugin.showDeviceListInfo(event);
            }

            public void setActionCallback(UiApiDef.IActionCallback iActionCallback) {
                DlnaPlugin.this.mActionCallback = iActionCallback;
            }

            public void showLanguage(Activity activity) {
            }

            public void showQuality(Activity activity) {
                DlnaPlugin.this.mPlugin.onShowQualityView(activity);
            }

            public void showSeries(Activity activity) {
            }

            public void showSpeed(Activity activity) {
            }

            public void startProjRealVideo() {
            }
        };
        this.mQualityListener = new DlnaDlg.QualityListener() { // from class: com.youku.live.dago.liveplayback.widget.plugins.dlna.DlnaPlugin.11
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.live.dago.liveplayback.widget.plugins.dlna.view.DlnaDlg.QualityListener
            public String onGetCurQuality() {
                IpChange ipChange = $ipChange;
                return AndroidInstantRuntime.support(ipChange, "-1468923856") ? (String) ipChange.ipc$dispatch("-1468923856", new Object[]{this}) : DlnaPlugin.this.getCurQuality();
            }

            @Override // com.youku.live.dago.liveplayback.widget.plugins.dlna.view.DlnaDlg.QualityListener
            public List<DlnaQualityInfo> onGetQualities() {
                IpChange ipChange = $ipChange;
                return AndroidInstantRuntime.support(ipChange, "-1361805495") ? (List) ipChange.ipc$dispatch("-1361805495", new Object[]{this}) : DlnaPlugin.this.getDefinitionList();
            }

            @Override // com.youku.live.dago.liveplayback.widget.plugins.dlna.view.DlnaDlg.QualityListener
            public void onQualitySelected(Activity activity, DlnaQualityInfo dlnaQualityInfo) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1490185936")) {
                    ipChange.ipc$dispatch("-1490185936", new Object[]{this, activity, dlnaQualityInfo});
                } else {
                    DlnaPlugin.this.changeQualitySelected(activity, dlnaQualityInfo);
                }
            }
        };
        this.mNeedSetSpeed = false;
        this.mSpeed = Double.valueOf(1.0d);
        this.mChangeDevReason = -1;
        this.mDlnaDevListener = new DlnaPublic.IDlnaDevsListenerEx() { // from class: com.youku.live.dago.liveplayback.widget.plugins.dlna.DlnaPlugin.15
            public void onDevAdded(Client client) {
                if (DlnaPlugin.this.mSourceClient == null || DlnaPlugin.this.mChangeDevReason < 0 || !client.getManufacturer().startsWith("www.yunos.com_") || !DlnaPlugin.this.mSourceClient.getIp().equals(client.getIp())) {
                    return;
                }
                new DlnaPreProjHandler(DlnaPlugin.this, DlnaPreProjHandler.createPreProjInfo(client, DlnaPlugin.this.mVideoInfo, DlnaPublic.DlnaProjScene.AUTOSELECT, UiAppDef.DevpickerScene.NONE)).start(DlnaPlugin.this.mActivity);
                DlnaPlugin.this.mSourceClient = null;
                DlnaPlugin.this.mChangeDevReason = -1;
            }

            public void onDevRemoved(Client client) {
            }

            public void onDevSearchStart() {
            }

            public void onDevsChanged() {
            }

            public void onSimulatedDevSearchStop() {
            }
        };
        this.mPlugin = this;
        DlnaControlPanelView dlnaControlPanelView = new DlnaControlPanelView(alixPlayerContext, alixPlayerContext.getPluginManager(viewGroup).getLayerManager(), this.mLayerId, R.layout.dago_dlna_control_panel_container, alixPlayerContext.getPluginManager(viewGroup).getViewPlaceholder(this.mName));
        this.mControlPanelView = dlnaControlPanelView;
        dlnaControlPanelView.setPresenter((DlnaContract.Presenter) this);
        this.mControlPanelView.setOnInflateListener(this);
        this.mAttachToParent = true;
        this.mActivity = alixPlayerContext.getActivity();
        IPlayer player = alixPlayerContext.getPlayerContainer().getPlayer();
        this.mPlayer = player;
        player.addOnPlayerStateListener(new OnStateChangeListener() { // from class: com.youku.live.dago.liveplayback.widget.plugins.dlna.DlnaPlugin.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.alixplayer.OnStateChangeListener
            public void onStateChange(IAlixPlayer.State state, IAlixPlayer.State state2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "357865029")) {
                    ipChange.ipc$dispatch("357865029", new Object[]{this, state, state2});
                } else if (state2 == IAlixPlayer.State.STATE_VIDEO_STARTED) {
                    DlnaPlugin.this.onRealVideoStart();
                } else if (state2 == IAlixPlayer.State.STATE_RELEASED) {
                    DlnaPlugin.this.onActivityDestroy();
                }
            }
        });
        alixPlayerContext.getPlayerContainer().addVideoStreamListener(new OnVideoStreamListener() { // from class: com.youku.live.dago.liveplayback.widget.plugins.dlna.DlnaPlugin.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.alixplayer.opensdk.OnVideoStreamListener
            public void onDataFail(VideoRequestError videoRequestError) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "54552275")) {
                    ipChange.ipc$dispatch("54552275", new Object[]{this, videoRequestError});
                }
            }

            @Override // com.youku.alixplayer.opensdk.OnVideoStreamListener
            public void onDataReady(YoukuVideoInfo youkuVideoInfo) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "261195410")) {
                    ipChange.ipc$dispatch("261195410", new Object[]{this, youkuVideoInfo});
                    return;
                }
                DlnaPlugin.this.mYoukuVideoInfo = youkuVideoInfo;
                DlnaPlugin.this.onGetVideoInfo();
            }

            @Override // com.youku.alixplayer.opensdk.OnVideoStreamListener
            public void onNewRequest(PlayVideoInfo playVideoInfo) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1651890229")) {
                    ipChange.ipc$dispatch("-1651890229", new Object[]{this, playVideoInfo});
                } else {
                    DlnaPlugin.this.onNewRequest(playVideoInfo);
                }
            }
        });
        alixPlayerContext.addDataSourceListener(new OnDataSourceListener() { // from class: com.youku.live.dago.liveplayback.widget.plugins.dlna.DlnaPlugin.3
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.alixplugin.OnDataSourceListener
            public void onChanged(String str, Object obj, Object obj2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-2064583018")) {
                    ipChange.ipc$dispatch("-2064583018", new Object[]{this, str, obj, obj2});
                } else if ("sceneId".equals(str)) {
                    DlnaPlugin.this.mSceneId = (String) obj2;
                    if (DlnaPlugin.this.mDlnaOpreater != null) {
                        DlnaPlugin.this.mDlnaOpreater.setSceneId(DlnaPlugin.this.mSceneId);
                    }
                }
            }
        });
        alixPlayerContext.getEventBus().register(this);
        initWithFetchDeviceInfoAndCheckShowPanel();
    }

    static /* synthetic */ int access$1108(DlnaPlugin dlnaPlugin) {
        int i = dlnaPlugin.mTryCount;
        dlnaPlugin.mTryCount = i + 1;
        return i;
    }

    private void changeDlnaPlayerQuality(int i) {
        Client client;
        LiveControlInfo liveControlInfo;
        if (DlnaApiBu.api().proj().stat() != DlnaPublic.DlnaProjStat.IDLE) {
            client = DlnaApiBu.api().proj().req().mDev;
        } else {
            client = DlnaApiBu.api().proj().preReq() != null ? DlnaApiBu.api().proj().preReq().mDev : null;
        }
        if (client == null || (liveControlInfo = this.mVideoInfo) == null || liveControlInfo.livePlayControl == null) {
            return;
        }
        DlnaPreProjInfo createPreProjInfo = DlnaPreProjHandler.createPreProjInfo(client, liveControlInfo, DlnaPublic.DlnaProjScene.CHANGE_DEFINITION, UiAppDef.DevpickerScene.NONE);
        createPreProjInfo.liveQuality = i;
        new DlnaPreProjHandler(this, createPreProjInfo).start(this.mActivity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changeQualitySelected(Activity activity, DlnaQualityInfo dlnaQualityInfo) {
        DlnaPublic.DlnaProjReq preReq;
        List devs;
        if (!dlnaQualityInfo.onlyCibn) {
            dlnaChangeQuality(dlnaQualityInfo.quality);
            return;
        }
        if (DlnaApiBu.api().proj().stat() != DlnaPublic.DlnaProjStat.IDLE) {
            preReq = DlnaApiBu.api().proj().req();
        } else {
            preReq = DlnaApiBu.api().proj().preReq();
        }
        if (preReq == null || preReq.mDev == null || preReq.mDev.getIp() == null || (devs = DlnaApiBu.api().devs().devs()) == null) {
            return;
        }
        Client client = null;
        Iterator it = devs.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Client client2 = (Client) it.next();
            if (client2.getIp() != null && client2.getIp().equalsIgnoreCase(preReq.mDev.getIp()) && client2.getManufacturer().equalsIgnoreCase("www.yunos.com_cibn")) {
                client = client2;
                break;
            }
        }
        if (client == null) {
            DlnaDlg.showInstallCibn(activity, this.mYoukuVideoInfo, this.mPlayerContext, DlnaDlg.INSTALL_REASON.HIGH_DEFINITION);
            return;
        }
        DlnaPreProjInfo createPreProjInfo = DlnaPreProjHandler.createPreProjInfo(client, this.mVideoInfo, DlnaPublic.DlnaProjScene.DEVPICKER, UiAppDef.DevpickerScene.CHANGE_DEV);
        createPreProjInfo.liveQuality = dlnaQualityInfo.quality;
        new DlnaPreProjHandler(this, createPreProjInfo).start(this.mActivity);
    }

    private boolean checkCopyrightForbidden() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkShowPanel() {
        YoukuVideoInfo youkuVideoInfo = this.mYoukuVideoInfo;
        if (youkuVideoInfo == null || youkuVideoInfo.getLivePlayControl() == null || !YkMultiscreenEntry.isInited() || DlnaApiBu.api().proj().stat() != DlnaPublic.DlnaProjStat.PLAYING) {
            return;
        }
        String liveId = this.mPlayerContext.getPlayerContainer().getPlayVideoInfo().getLiveId();
        DlnaPublic.DlnaProjReq req = DlnaApiBu.api().proj().req();
        if (liveId != null && req != null && req.mVid != null) {
            if (!YkMultiscreenEntry.isInited()) {
                YkMultiscreenEntry.init(this.mPlayerContext.getContext());
            }
            if (YkMultiscreenEntry.isInited()) {
                if (this.mDlnaOpreater == null) {
                    DlnaOpreater dlnaOpreater = new DlnaOpreater(this.mPlayerContext, this);
                    this.mDlnaOpreater = dlnaOpreater;
                    dlnaOpreater.setSceneId(this.mSceneId);
                }
                if (liveId.equals(req.mVid)) {
                    LiveControlInfo liveControlInfo = new LiveControlInfo();
                    liveControlInfo.livePlayControl = this.mYoukuVideoInfo.getLivePlayControl();
                    setProjVideoInfo(liveControlInfo);
                    onShowDlnaPanel(DlnaPublic.DlnaProjScene.AUTO);
                    DlnaContinueProjMgr.getInst().setAttachDetailAcivity(true);
                    return;
                }
                return;
            }
            return;
        }
        Log.e(TAG, "live id is null");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void commitOttScanResult(ScanPairDeviceInfo scanPairDeviceInfo) {
        Properties ottScanProp = getOttScanProp(scanPairDeviceInfo);
        if (ottScanProp == null) {
            ottScanProp = new Properties();
        }
        if (ConnectivityMgr.getInst().getCurrentConnectivity() != ConnectivityMgr.ConnectivityType.WIFI) {
            SupportApiBu.api().ut().commitEvt("tp_auto_weex_nowifi", ottScanProp);
        } else {
            SupportApiBu.api().ut().commitEvt("tp_auto_weex_noserver", ottScanProp);
        }
    }

    private DlnaPreProjHandler createProjHandler(Client client) {
        if (this.mVideoInfo == null) {
            LiveControlInfo liveControlInfo = new LiveControlInfo();
            this.mVideoInfo = liveControlInfo;
            liveControlInfo.livePlayControl = this.mYoukuVideoInfo.getLivePlayControl();
        }
        return new DlnaPreProjHandler(this, DlnaPreProjHandler.createPreProjInfo(client, this.mPlayerContext.getPlayerContainer().getPlayVideoInfo().getLiveId(), DlnaPublic.DlnaProjScene.AUTOSELECT, UiAppDef.DevpickerScene.CHANGE_DEV));
    }

    private void dlnaUpsRequest(PlayVideoInfo playVideoInfo) {
        if (this.mPlayerContext.isDlnaMode() || DlnaApiBu.api().proj().stat() != DlnaPublic.DlnaProjStat.IDLE) {
            if (this.mDlnaOpreater != null && StrUtil.isValidStr(playVideoInfo.getVid())) {
                Client client = null;
                if (DlnaPublic.DlnaProjStat.IDLE != DlnaApiBu.api().proj().stat()) {
                    client = DlnaApiBu.api().proj().req().mDev;
                } else if (DlnaApiBu.api().proj().preReq() != null) {
                    client = DlnaApiBu.api().proj().preReq().mDev;
                }
                if (client == null) {
                    return;
                }
                final DlnaPreProjHandler dlnaPreProjHandler = new DlnaPreProjHandler(this, DlnaPreProjHandler.createPreProjInfoByVideoInfo(client, playVideoInfo, DlnaPublic.DlnaProjScene.AUTO, UiAppDef.DevpickerScene.NONE));
                LegoApp.handler().post(new Runnable() { // from class: com.youku.live.dago.liveplayback.widget.plugins.dlna.DlnaPlugin.14
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // java.lang.Runnable
                    public void run() {
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "-2103852136")) {
                            ipChange.ipc$dispatch("-2103852136", new Object[]{this});
                        } else {
                            dlnaPreProjHandler.start(DlnaPlugin.this.mActivity);
                        }
                    }
                });
                return;
            }
            Log.e(TAG, "dlnaUpsRequest error liveid is null !");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fetchOttScanDeviceInfo() {
        Bundle bundle;
        String string;
        Event stickyEvent = this.mPlayerContext.getEventBus().getStickyEvent("kubus://player/notification/external_params");
        if (stickyEvent != null) {
            Object obj = stickyEvent.data;
            if ((obj instanceof Bundle) && (string = (bundle = (Bundle) obj).getString("source")) != null && string.equalsIgnoreCase("ott_scan")) {
                if (!YkMultiscreenEntry.isInited()) {
                    YkMultiscreenEntry.init(this.mPlayerContext.getContext());
                }
                if (this.mDlnaOpreater == null) {
                    DlnaOpreater dlnaOpreater = new DlnaOpreater(this.mPlayerContext, this);
                    this.mDlnaOpreater = dlnaOpreater;
                    dlnaOpreater.setSceneId(this.mSceneId);
                }
                String string2 = bundle.getString("tpDeviceInfo");
                if (StrUtil.isValidStr(string2)) {
                    LogEx.i("", " tpDeviceInfo:" + string2);
                    try {
                        this.mOttScanDeviceInfo = (ScanPairDeviceInfo) JSON.parseObject(string2, ScanPairDeviceInfo.class);
                    } catch (Exception unused) {
                    }
                    ScanPairDeviceInfo scanPairDeviceInfo = this.mOttScanDeviceInfo;
                    if (scanPairDeviceInfo == null) {
                        return;
                    }
                    Properties ottScanProp = getOttScanProp(scanPairDeviceInfo);
                    if (ottScanProp == null) {
                        ottScanProp = new Properties();
                    }
                    SupportApiBu.api().ut().commitEvt("tp_scanned_weex_qrcode", ottScanProp);
                    LegoApp.handler().postDelayed(this.mDevicePairRunnable, 1000L);
                }
            }
        }
    }

    private AudioManager getAudioManager() {
        if (this.mAudioManager == null) {
            AudioManager audioManager = (AudioManager) getPlayerContext().getContext().getSystemService("audio");
            this.mAudioManager = audioManager;
            if (audioManager.getMode() == -2) {
                this.mAudioManager.setMode(0);
            }
        }
        return this.mAudioManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getCurQuality() {
        if (getDefinitionList() == null) {
            return null;
        }
        if (DlnaApiBu.api().proj().stat() == DlnaPublic.DlnaProjStat.PLAYING) {
            String str = DlnaApiBu.api().proj().req().mDefinition;
            String str2 = TAG;
            Log.i(str2, "dlna get cur quality " + str);
            return str;
        }
        int liveQuality = this.mPlayerContext.getPlayerContainer().getVideoStream().getCurAlixVideoItem().getLiveQuality();
        Quality liveControlQuality = Utils.getLiveControlQuality(this.mPlayerContext.getPlayerContainer().getVideoStream().getYoukuVideoInfo(), liveQuality);
        String str3 = liveControlQuality != null ? liveControlQuality.selectionName : "未知";
        String str4 = TAG;
        Log.i(str4, "dlna get player quality " + str3 + ":" + liveQuality);
        return str3;
    }

    private Properties getOttScanProp(ScanPairDeviceInfo scanPairDeviceInfo) {
        if (this.mOttScanDeviceInfo == null || this.mPlayerContext == null || this.mYoukuVideoInfo == null) {
            return null;
        }
        String ytId = UserInfo.isLogin() ? UserInfo.getYtId() : "";
        Properties properties = new Properties();
        String[] strArr = new String[28];
        strArr[0] = "uuid_o";
        strArr[1] = scanPairDeviceInfo.uuid;
        strArr[2] = "utdid_o";
        strArr[3] = scanPairDeviceInfo.utdid;
        strArr[4] = "package_name_o";
        String str = scanPairDeviceInfo.pkg;
        if (str == null) {
            str = "";
        }
        strArr[5] = str;
        strArr[6] = "ytid_o";
        String str2 = scanPairDeviceInfo.ytid;
        if (str2 == null) {
            str2 = "";
        }
        strArr[7] = str2;
        strArr[8] = "version_code_o";
        String str3 = scanPairDeviceInfo.version_code;
        if (str3 == null) {
            str3 = "";
        }
        strArr[9] = str3;
        strArr[10] = "version_name_o";
        String str4 = scanPairDeviceInfo.version_name;
        if (str4 == null) {
            str4 = "";
        }
        strArr[11] = str4;
        strArr[12] = "showid";
        strArr[13] = "";
        strArr[14] = "vid";
        strArr[15] = this.mPlayerContext.getPlayerContainer().getPlayVideoInfo().getLiveId();
        strArr[16] = "os_type";
        strArr[17] = "android";
        strArr[18] = "version_name_p";
        strArr[19] = LegoApp.verName();
        strArr[20] = "version_code_p";
        strArr[21] = String.valueOf(LegoApp.verCode());
        strArr[22] = "device_mode_p";
        strArr[23] = Build.getMODEL();
        strArr[24] = "device_system_version_p";
        strArr[25] = Build.VERSION.BASE_OS;
        strArr[26] = "ytid_p";
        strArr[27] = ytId;
        return PropUtil.get(properties, strArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Client getScanClient(ScanPairDeviceInfo scanPairDeviceInfo) {
        ClientModelDesc clientModelDesc = null;
        for (Client client : DlnaApiBu.api().devs().devs()) {
            if (client.getManufacturer().startsWith("www.yunos.com_") && !client.isCloudDev()) {
                String modelDescription = client.getModelDescription();
                if (StrUtil.isValidStr(modelDescription)) {
                    try {
                        clientModelDesc = (ClientModelDesc) JSON.parseObject(modelDescription, ClientModelDesc.class);
                    } catch (Exception unused) {
                    }
                    if (clientModelDesc != null && clientModelDesc.yunos.equalsIgnoreCase(scanPairDeviceInfo.uuid) && clientModelDesc.pkg.equalsIgnoreCase(scanPairDeviceInfo.pkg)) {
                        return client;
                    }
                } else {
                    continue;
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handlePreProj(String str, Event event) {
        DlnaPreProjInfo createPreProjInfo;
        Object obj;
        Object obj2 = event.data;
        boolean parseBoolean = obj2 instanceof Properties ? Boolean.parseBoolean(((Properties) Properties.class.cast(obj2)).getProperty("from_ad", "false")) : false;
        if (this.mPlayerContext.isDlnaMode()) {
            createPreProjInfo = DlnaPreProjHandler.createPreProjInfo((Client) null, str, DlnaPublic.DlnaProjScene.DEVPICKER, UiAppDef.DevpickerScene.CHANGE_DEV);
        } else if (parseBoolean) {
            createPreProjInfo = DlnaPreProjHandler.createPreProjInfo((Client) null, str, DlnaPublic.DlnaProjScene.DEVPICKER_AD, UiAppDef.DevpickerScene.DLNA_BTN_AD);
        } else {
            createPreProjInfo = DlnaPreProjHandler.createPreProjInfo((Client) null, str, DlnaPublic.DlnaProjScene.DEVPICKER, UiAppDef.DevpickerScene.DLNA_BTN);
        }
        if (!parseBoolean && (obj = event.data) != null) {
            if (((Boolean) obj).booleanValue()) {
                createPreProjInfo.mUseLastDevIfAvailable = false;
            } else if (createPreProjInfo.mDevpickeScene == UiAppDef.DevpickerScene.CHANGE_DEV) {
                createPreProjInfo.mUseLastDevIfAvailable = false;
            } else {
                createPreProjInfo.mUseLastDevIfAvailable = true;
            }
        } else if (createPreProjInfo.mDevpickeScene == UiAppDef.DevpickerScene.CHANGE_DEV) {
            createPreProjInfo.mUseLastDevIfAvailable = false;
        } else {
            createPreProjInfo.mUseLastDevIfAvailable = true;
        }
        DlnaPreProjHandler dlnaPreProjHandler = new DlnaPreProjHandler(this, createPreProjInfo);
        dlnaPreProjHandler.setProjFromAd(parseBoolean);
        dlnaPreProjHandler.start(this.mActivity);
    }

    private void initWithFetchDeviceInfoAndCheckShowPanel() {
        boolean isOpenOpt = OptConfigUtils.isOpenOpt();
        long configLong = OptConfigUtils.getConfigLong("delayInitDlnaSdk", 0L);
        Runnable runnable = new Runnable() { // from class: com.youku.live.dago.liveplayback.widget.plugins.dlna.DlnaPlugin.4
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // java.lang.Runnable
            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1040796227")) {
                    ipChange.ipc$dispatch("-1040796227", new Object[]{this});
                    return;
                }
                DlnaPlugin.this.fetchOttScanDeviceInfo();
                DlnaPlugin.this.checkShowPanel();
            }
        };
        if (isOpenOpt && configLong > 0) {
            LegoApp.handler().postDelayed(runnable, configLong);
        } else {
            runnable.run();
        }
    }

    private boolean isShowFullScreenControl(DlnaPublic.DlnaProjScene dlnaProjScene) {
        return DlnaPublic.DlnaProjScene.DEVPICKER == dlnaProjScene || DlnaPublic.DlnaProjScene.DEVPICKER_AD == dlnaProjScene || DlnaPublic.DlnaProjScene.OTT_SCAN == dlnaProjScene || DlnaPublic.DlnaProjScene.LASTUSEDEV == dlnaProjScene || DlnaPublic.DlnaProjScene.LASTUSEDEV_AD == dlnaProjScene;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onGetVideoInfo() {
        LogEx.e("", "isOttScanTp ON_GET_YOUKU_VIDEO_INFO_SUCCESS");
        if (this.mPushClient == null) {
            return;
        }
        if (!YkMultiscreenEntry.isInited()) {
            YkMultiscreenEntry.init(this.mPlayerContext.getContext());
        }
        if (this.mDlnaOpreater == null) {
            DlnaOpreater dlnaOpreater = new DlnaOpreater(this.mPlayerContext, this);
            this.mDlnaOpreater = dlnaOpreater;
            dlnaOpreater.setSceneId(this.mSceneId);
        }
        new DlnaPreProjHandler(this, DlnaPreProjHandler.createPreProjInfo(this.mPushClient, this.mPlayerContext.getPlayerContainer().getPlayVideoInfo().getLiveId(), DlnaPublic.DlnaProjScene.BOOSTER, UiAppDef.DevpickerScene.NONE)).start(this.mActivity);
        this.mPushClient = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onRealVideoStart() {
        LegoApp.handler().post(new Runnable() { // from class: com.youku.live.dago.liveplayback.widget.plugins.dlna.DlnaPlugin.7
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // java.lang.Runnable
            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1630336742")) {
                    ipChange.ipc$dispatch("-1630336742", new Object[]{this});
                    return;
                }
                if (!YkMultiscreenEntry.isInited()) {
                    YkMultiscreenEntry.init(((AbsPlugin) DlnaPlugin.this).mContext);
                }
                if (YkMultiscreenEntry.isInited()) {
                    if (DlnaPlugin.this.mDlnaOpreater == null) {
                        DlnaPlugin.this.mDlnaOpreater = new DlnaOpreater(((AbsPlugin) DlnaPlugin.this).mPlayerContext, DlnaPlugin.this);
                        DlnaPlugin.this.mDlnaOpreater.setSceneId(DlnaPlugin.this.mSceneId);
                    }
                    DlnaPlugin.this.mDlnaOpreater.setActivityIntent(((AbsPlugin) DlnaPlugin.this).mPlayerContext.getActivity().getIntent());
                    if (!((AbsPlugin) DlnaPlugin.this).mPlayerContext.isDlnaMode()) {
                        DlnaPlugin.this.mDlnaOpreater.checkChangeDlnaModel();
                    } else if (DlnaPlugin.this.mPlayer != null) {
                        DlnaPlugin.this.mPlayer.release();
                    }
                    if (((AbsPlugin) DlnaPlugin.this).mPlayerContext.isDlnaMode()) {
                        DlnaContinueProjMgr.getInst().setAttachDetailAcivity(true);
                    }
                }
            }
        });
    }

    private void showFullDlnaControl(DlnaPublic.DlnaProjScene dlnaProjScene) {
        if (!isShowFullScreenControl(dlnaProjScene)) {
            this.mControlPanelView.show();
        } else {
            LegoApp.handler().postDelayed(new Runnable() { // from class: com.youku.live.dago.liveplayback.widget.plugins.dlna.DlnaPlugin.9
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // java.lang.Runnable
                public void run() {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-2023363752")) {
                        ipChange.ipc$dispatch("-2023363752", new Object[]{this});
                        return;
                    }
                    ((AbsPlugin) DlnaPlugin.this).mPlayerContext.isLandScreen();
                    if (DlnaPlugin.this.mControlPanelView.isShow()) {
                        return;
                    }
                    DlnaPlugin.this.mControlPanelView.show();
                }
            }, 500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startOttScanProj(Client client, String str) {
        new DlnaPreProjHandler(this, DlnaPreProjHandler.createPreProjInfo(client, str, DlnaPublic.DlnaProjScene.OTT_SCAN, UiAppDef.DevpickerScene.NONE)).start(this.mActivity);
        Properties ottScanProp = getOttScanProp(this.mOttScanDeviceInfo);
        if (ottScanProp == null) {
            ottScanProp = new Properties();
        }
        ottScanProp.put("cloud_dev", String.valueOf(client.isCloudDev()));
        SupportApiBu.api().ut().commitEvt("tp_auto_weex_success", ottScanProp);
    }

    private String tag() {
        return LogEx.tag(this);
    }

    private void unRegisterDlnaDevListener() {
        DlnaOpreater dlnaOpreater = this.mDlnaOpreater;
        if (dlnaOpreater != null) {
            dlnaOpreater.release();
        }
        if (YkMultiscreenEntry.isInited()) {
            DlnaApiBu.api().devs().unregisterListenerIf(this.mDlnaDevListener);
        }
    }

    @Override // com.youku.live.dago.liveplayback.widget.plugins.dlna.DlnaContract.Presenter
    public void dlnaChangeQuality(int i) {
        changeDlnaPlayerQuality(i);
    }

    @Subscribe(eventType = {"kubus://player/dlna/change_dlna_definition"}, priority = 1, threadMode = ThreadMode.POSTING)
    public void dlnaChangeQuality(Event event) {
    }

    public List<DlnaQualityInfo> getDefinitionList() {
        ArrayList arrayList = new ArrayList();
        if (this.mYoukuVideoInfo.getLivePlayControl() != null) {
            for (Quality quality : this.mYoukuVideoInfo.getLivePlayControl().qualities) {
                if (quality.hbr != 1 && !quality.name.contains("智能")) {
                    arrayList.add(new DlnaQualityInfo(quality.selectionName, "", false, quality.quality));
                }
            }
        }
        return arrayList;
    }

    @Override // com.youku.live.dago.liveplayback.widget.plugins.dlna.DlnaContract.Presenter
    public void handleDrm(Client client) {
        if (YkMultiscreenEntry.isInited()) {
            LegoApp.handler().post(new Runnable() { // from class: com.youku.live.dago.liveplayback.widget.plugins.dlna.DlnaPlugin.12
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // java.lang.Runnable
                public void run() {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-1710825126")) {
                        ipChange.ipc$dispatch("-1710825126", new Object[]{this});
                    } else {
                        DlnaDlg.showInstallCibn(((AbsPlugin) DlnaPlugin.this).mPlayerContext.getActivity(), DlnaPlugin.this.mYoukuVideoInfo, ((AbsPlugin) DlnaPlugin.this).mPlayerContext, DlnaDlg.INSTALL_REASON.COPYRIGHT_DRM);
                    }
                }
            });
        }
    }

    @Override // com.youku.live.dago.liveplayback.widget.plugins.dlna.DlnaContract.Presenter
    public void handleNoCopyRight() {
        if (YkMultiscreenEntry.isInited()) {
            LegoApp.handler().post(new Runnable() { // from class: com.youku.live.dago.liveplayback.widget.plugins.dlna.DlnaPlugin.13
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // java.lang.Runnable
                public void run() {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-1907338631")) {
                        ipChange.ipc$dispatch("-1907338631", new Object[]{this});
                    } else {
                        DlnaDlg.showInstallCibn(((AbsPlugin) DlnaPlugin.this).mPlayerContext.getActivity(), DlnaPlugin.this.mYoukuVideoInfo, ((AbsPlugin) DlnaPlugin.this).mPlayerContext, DlnaDlg.INSTALL_REASON.FORBIDDEN_TP);
                    }
                }
            });
            LiveControlInfo liveControlInfo = this.mVideoInfo;
            if (liveControlInfo == null) {
                liveControlInfo = new LiveControlInfo();
                liveControlInfo.livePlayControl = this.mYoukuVideoInfo.getLivePlayControl();
            }
            if (liveControlInfo == null) {
                return;
            }
            SupportApiBu.api().ut().commitEvt("tp_no_copyright", PropUtil.get(new Properties(), new String[]{"videoTitle", "", "videoId", this.mPlayerContext.getPlayerContainer().getPlayVideoInfo().getLiveId(), "videoShowId", ""}));
        }
    }

    @Override // com.youku.live.dago.liveplayback.widget.plugins.dlna.DlnaContract.Presenter
    public void handleUpsError(VideoRequestError videoRequestError) {
        if (videoRequestError == null || videoRequestError.getErrorCode() == 72001 || videoRequestError.getErrorCode() != 71001) {
            return;
        }
        LivePlayControl livePlayControl = videoRequestError.getLivePlayControl();
        if (livePlayControl != null) {
            this.mPlayerContext.getPlayerContainer().getPlayVideoInfo().getRequestLiveQuality();
            for (Quality quality : livePlayControl.qualities) {
                if (quality.bizSwitch.memberQuality == 1) {
                    int i = quality.quality;
                }
            }
        }
        Event event = new Event(ApiConstants.EventType.SHOW_BUY_VIEW);
        HashMap hashMap = new HashMap();
        hashMap.put("playControl", livePlayControl);
        hashMap.put("payType", 3);
        event.data = hashMap;
        this.mPlayerContext.getEventBus().post(event);
    }

    void hideNowbar() {
        if (Nowbar.getInst().haveNowbar(this.mPlayerContext.getActivity())) {
            Nowbar.getInst().setForceHide(this.mPlayerContext.getActivity(), true);
        }
    }

    @Override // com.youku.live.dago.liveplayback.widget.plugins.dlna.DlnaContract.Presenter
    public void installCibn() {
        Client client;
        if (DlnaApiBu.api().proj().stat() == DlnaPublic.DlnaProjStat.IDLE) {
            client = DlnaApiBu.api().proj().preReq() != null ? DlnaApiBu.api().proj().preReq().mDev : null;
        } else {
            client = DlnaApiBu.api().proj().req().mDev;
        }
        if (client == null) {
            return;
        }
        DlnaPreProjHandler createProjHandler = createProjHandler(client);
        this.mControlPanelView.toggleInstallCibn(false);
        DlnaDlg.installCibnOrOpen(this.mActivity, client, createProjHandler);
    }

    public void onActivityDestroy() {
        LegoApp.handler().removeCallbacks(this.mDelayShowControl);
        LegoApp.handler().removeCallbacks(this.mDevicePairRunnable);
        if (this.mPlayerContext.isDlnaMode()) {
            DlnaContinueProjMgr.getInst().setPlayerConfig(this.mPlayerContext.getPlayerConfig());
        }
        DlnaContinueProjMgr.getInst().setAttachDetailAcivity(false);
        unRegisterDlnaDevListener();
    }

    @Override // com.youku.live.dago.liveplayback.widget.plugins.dlna.DlnaContract.Presenter
    public void onControlEnable(boolean z) {
        seekBarEnable(z);
    }

    @Override // com.youku.live.dago.liveplayback.widget.plugins.dlna.DlnaContract.Presenter
    public void onCurrentPositionUpdate(int i, int i2) {
    }

    @Subscribe(eventType = {ApiConstants.EventType.CLOSE_DLNA_MODE}, priority = 1, threadMode = ThreadMode.POSTING)
    public void onDlnaExit(Event event) {
        if (DlnaApiBu.api().proj().stat() != DlnaPublic.DlnaProjStat.IDLE) {
            DlnaApiBu.api().proj().stop();
        } else {
            onHideDlnaPanel();
        }
    }

    @Subscribe(eventType = {"kubus://player/dlna/get_dlna_definitions"}, priority = 1, threadMode = ThreadMode.POSTING)
    public void onGetDlnaDefinitions(Event event) {
        String tag = tag();
        LogEx.i(tag, "hit, is dlna: " + this.mIsDlna);
        this.mPlayerContext.getEventBus().response(event, getDefinitionList());
    }

    @Override // com.youku.live.dago.liveplayback.widget.plugins.dlna.DlnaContract.Presenter
    public void onHide() {
        this.mPlayerContext.getEventBus().post(new Event(ApiConstants.EventType.SHOW_CONTROL));
    }

    @Override // com.youku.live.dago.liveplayback.widget.plugins.dlna.DlnaContract.Presenter
    public void onHideDlnaPanel() {
        int i;
        if (this.mYoukuVideoInfo == null) {
            return;
        }
        this.mControlPanelView.hide();
        PlayVideoInfo playVideoInfo = this.mYoukuVideoInfo.getPlayVideoInfo();
        if (this.mYoukuVideoInfo.getLivePlayControl() != null) {
            String curQuality = getCurQuality();
            Iterator<Quality> it = this.mYoukuVideoInfo.getLivePlayControl().qualities.iterator();
            while (true) {
                if (!it.hasNext()) {
                    i = -1;
                    break;
                }
                Quality next = it.next();
                if (next.selectionName.equals(curQuality)) {
                    i = next.quality;
                    break;
                }
            }
            if (i != -1) {
                playVideoInfo.setRequestLiveQuality(i);
            }
        }
        this.mPlayerContext.getPlayerContainer().play(playVideoInfo);
        Log.i(TAG, "resume player from dlna");
        this.mIsDlna = Boolean.FALSE;
        this.mPlayerContext.setDlnaMode(false);
        this.mPlayerContext.getEventBus().post(new Event(ApiConstants.EventType.SHOW_CONTROL));
        seekBarEnable(true);
    }

    @Override // com.youku.alixplugin.view.OnInflateListener
    public void onInflate() {
        this.mHolderView = this.mControlPanelView.getInflatedView();
    }

    @Subscribe(eventType = {ApiConstants.EventType.ON_ACTIVITY_KEY_DOWN}, priority = 45, threadMode = ThreadMode.POSTING)
    public void onKeyDown(Event event) {
        Map map = (Map) event.data;
        if (map == null || !onKeyDown(((Integer) map.get(ApiConstants.EventParams.KEY_CODE)).intValue(), (KeyEvent) map.get(ApiConstants.EventParams.KEY_EVENT))) {
            return;
        }
        this.mPlayerContext.getEventBus().release(event);
    }

    public void onNewRequest(PlayVideoInfo playVideoInfo) {
    }

    @Override // com.youku.live.dago.liveplayback.widget.plugins.dlna.DlnaContract.Presenter
    public void onPlayerPause() {
        if (this.mPlayerContext.isDlnaMode()) {
            this.mPlayerContext.getEventBus().post(new Event(ApiConstants.EventType.DLNA_PLAYER_PAUSE));
        }
    }

    @Override // com.youku.live.dago.liveplayback.widget.plugins.dlna.DlnaContract.Presenter
    public void onPlayerPlay() {
        Object obj;
        if (this.mPlayerContext.isDlnaMode()) {
            this.mPlayerContext.getEventBus().post(new Event(ApiConstants.EventType.DLNA_PLAYER_START));
            Event stickyEvent = this.mPlayerContext.getEventBus().getStickyEvent("kubus://notify/dlna/seekbar/clickable");
            if (stickyEvent == null || (obj = stickyEvent.data) == null || !((Boolean) obj).booleanValue()) {
                seekBarEnable(false);
            }
        }
    }

    @Override // com.youku.live.dago.liveplayback.widget.plugins.dlna.DlnaContract.Presenter
    public void onPlayerSpeed(int i) {
    }

    @Subscribe(eventType = {ApiConstants.EventType.ON_SCREEN_MODE_CHANGE}, priority = 1, threadMode = ThreadMode.MAIN)
    public void onScreenModeChange(Event event) {
        int intValue = ((Integer) event.data).intValue();
        if (intValue == 1 || intValue == 2) {
            this.mControlPanelView.hidePopupWindow();
        }
    }

    @Subscribe(eventType = {"kubus://player/notification/dlna_full_screen"}, priority = 1, threadMode = ThreadMode.POSTING)
    public void onShowDlnaFullControl(Event event) {
        showFullDlnaControl(DlnaPublic.DlnaProjScene.DEVPICKER);
    }

    @Override // com.youku.live.dago.liveplayback.widget.plugins.dlna.DlnaContract.Presenter
    public void onShowDlnaPanel(DlnaPublic.DlnaProjScene dlnaProjScene) {
        if (!this.mPlayerContext.isDlnaMode()) {
            this.mPlayer.stop();
        }
        Log.i(TAG, "show panel stop player");
        LegoApp.handler().postDelayed(this.mDelayShowControl, 500L);
        this.mIsDlna = Boolean.TRUE;
        this.mPlayerContext.setDlnaMode(true);
        showFullDlnaControl(dlnaProjScene);
        seekBarEnable(false);
        hideNowbar();
        this.mPlayerContext.getActivity().setRequestedOrientation(1);
    }

    @Override // com.youku.live.dago.liveplayback.widget.plugins.dlna.DlnaContract.Presenter
    public void onShowFullScreenDevList() {
        this.mPlayerContext.getEventBus().post(new Event(ApiConstants.EventType.REQUEST_DLNA_SHOW_FULLSCREEN));
    }

    @Override // com.youku.live.dago.liveplayback.widget.plugins.dlna.DlnaContract.Presenter
    public void onShowQualityView(Activity activity) {
        if (this.mPlayerContext.isLandScreen()) {
            this.mPlayerContext.getEventBus().post(new Event(ApiConstants.EventType.HIDE_CONTROL));
            this.mPlayerContext.getEventBus().post(new Event("kubus://function/notification/show_dlna_definition"));
            return;
        }
        if (activity == null) {
            activity = this.mPlayerContext.getActivity();
        }
        DlnaDlg.openQualityDlg(activity, this.mQualityListener);
    }

    @Subscribe(eventType = {ApiConstants.EventType.ON_GESTURE_SCROLL}, priority = 1, threadMode = ThreadMode.POSTING)
    public void onVolumeScroll(Event event) {
        if (this.mIsDlna.booleanValue() && ((Integer) ((Map) event.data).get(ApiConstants.EventParams.WHAT)).intValue() == 3) {
            int streamVolume = getAudioManager().getStreamVolume(3);
            int streamMaxVolume = getAudioManager().getStreamMaxVolume(3);
            if (streamMaxVolume > 0) {
                DlnaApiBu.api().proj().setVolume((streamVolume * 100) / streamMaxVolume);
            }
        }
    }

    @Override // com.youku.live.dago.liveplayback.widget.plugins.dlna.DlnaContract.Presenter
    public void retryProj() {
        if (this.mDlnaOpreater == null || this.mVideoInfo == null || DlnaApiBu.api().proj().preReq() == null) {
            return;
        }
        new DlnaPreProjHandler(this, DlnaPreProjHandler.createPreProjInfo(DlnaApiBu.api().proj().preReq().mDev, this.mVideoInfo, DlnaPublic.DlnaProjScene.RETRY, UiAppDef.DevpickerScene.NONE)).start(this.mActivity);
    }

    void seekBarEnable(boolean z) {
        Event event = new Event("kubus://notify/dlna/seekbar/clickable");
        event.data = new Boolean(z);
        this.mPlayerContext.getEventBus().postSticky(event);
    }

    @Override // com.youku.live.dago.liveplayback.widget.plugins.dlna.DlnaContract.Presenter
    public void setChangeDevToCibn(Client client, int i) {
        DlnaApiBu.api().devs().unregisterListenerIf(this.mDlnaDevListener);
        DlnaApiBu.api().devs().registerListener(this.mDlnaDevListener);
        this.mSourceClient = client;
        this.mChangeDevReason = i;
    }

    @Override // com.youku.live.dago.liveplayback.widget.plugins.dlna.DlnaContract.Presenter
    public void setProjVideoInfo(LiveControlInfo liveControlInfo) {
        this.mVideoInfo = liveControlInfo;
    }

    @Override // com.youku.live.dago.liveplayback.widget.plugins.dlna.DlnaContract.Presenter
    public boolean shouldFilterHdr() {
        return SupportApiBu.api().orange().multiscreen().filter_hdr;
    }

    @Override // com.youku.live.dago.liveplayback.widget.plugins.dlna.DlnaContract.Presenter
    public boolean shouldShowExit() {
        return false;
    }

    @Subscribe(eventType = {ApiConstants.EventType.REQUEST_DLNA_SHOW_SMALL, ApiConstants.EventType.REQUEST_DLNA_SHOW_FULLSCREEN}, priority = 1, threadMode = ThreadMode.POSTING)
    public void showDeviceListInfo(final Event event) {
        if (!YkMultiscreenEntry.isInited()) {
            YkMultiscreenEntry.init(this.mPlayerContext.getContext());
        }
        if (this.mDlnaOpreater == null) {
            DlnaOpreater dlnaOpreater = new DlnaOpreater(this.mPlayerContext, this);
            this.mDlnaOpreater = dlnaOpreater;
            dlnaOpreater.setSceneId(this.mSceneId);
        }
        this.mDlnaOpreater.setActivityIntent(this.mPlayerContext.getActivity().getIntent());
        if (this.mYoukuVideoInfo == null) {
            return;
        }
        if (!checkCopyrightForbidden()) {
            handlePreProj(this.mPlayerContext.getPlayerContainer().getPlayVideoInfo().getLiveId(), event);
        } else {
            this.mDlnaOpreater.liveRequestForCopyright(this.mPlayerContext.getPlayerContainer().getPlayVideoInfo().getLiveId(), new IVideoRequest.Callback<BypassPlayInfo, LivePlayControl>() { // from class: com.youku.live.dago.liveplayback.widget.plugins.dlna.DlnaPlugin.6
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.youku.alixplayer.opensdk.IVideoRequest.Callback
                public void onFailure(VideoRequestError videoRequestError) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "1682581717")) {
                        ipChange.ipc$dispatch("1682581717", new Object[]{this, videoRequestError});
                    }
                }

                @Override // com.youku.alixplayer.opensdk.IVideoRequest.Callback
                public void onStat(Map<String, String> map) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-1734433228")) {
                        ipChange.ipc$dispatch("-1734433228", new Object[]{this, map});
                    }
                }

                @Override // com.youku.alixplayer.opensdk.IVideoRequest.Callback
                public void onSuccess(BypassPlayInfo bypassPlayInfo, LivePlayControl livePlayControl) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-1814135961")) {
                        ipChange.ipc$dispatch("-1814135961", new Object[]{this, bypassPlayInfo, livePlayControl});
                        return;
                    }
                    new LiveControlInfo().livePlayControl = livePlayControl;
                    DlnaPlugin dlnaPlugin = DlnaPlugin.this;
                    dlnaPlugin.handlePreProj(((AbsPlugin) dlnaPlugin).mPlayerContext.getPlayerContainer().getPlayVideoInfo().getLiveId(), event);
                }
            });
        }
    }

    public void startProj(Client client, DlnaPreProjHandler dlnaPreProjHandler) {
        if (this.mDlnaOpreater == null) {
            return;
        }
        if (dlnaPreProjHandler.getPreProjInfo().liveQuality == -1) {
            List<DlnaQualityInfo> definitionList = getDefinitionList();
            Iterator<DlnaQualityInfo> it = definitionList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (it.next().quality == this.mPlayer.getVideoStream().getCurAlixVideoItem().getLiveQuality()) {
                    dlnaPreProjHandler.getPreProjInfo().liveQuality = this.mPlayer.getVideoStream().getCurAlixVideoItem().getLiveQuality();
                    break;
                }
            }
            if (dlnaPreProjHandler.getPreProjInfo().liveQuality == -1) {
                Iterator<DlnaQualityInfo> it2 = definitionList.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    Quality liveControlQuality = Utils.getLiveControlQuality(this.mYoukuVideoInfo, it2.next().quality);
                    if (liveControlQuality.bizSwitch.memberQuality != 1) {
                        dlnaPreProjHandler.getPreProjInfo().liveQuality = liveControlQuality.quality;
                        break;
                    }
                }
            }
        }
        this.mDlnaOpreater.startProjectionDevice(dlnaPreProjHandler, client);
    }

    @Subscribe(eventType = {ApiConstants.EventType.TOGGLE_DLNA_PLAY_PAUSE_STATUS}, priority = 1, threadMode = ThreadMode.POSTING)
    public void toggleDlnaPlayPauseStatus(Event event) {
        if (this.mPlayerContext.isDlnaMode() && DlnaApiBu.api().proj().stat() != DlnaPublic.DlnaProjStat.IDLE) {
            if (DlnaApiBu.api().proj().getPlayerStat() == DlnaPublic.DlnaPlayerStat.PLAYING) {
                this.mDlnaOpreater.pause();
            } else {
                this.mDlnaOpreater.play();
            }
        }
    }

    private boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.mPlayerContext.isDlnaMode()) {
            if (i == 24) {
                this.mControlPanelView.volumeUp();
            } else if (i != 25) {
                return false;
            } else {
                this.mControlPanelView.volumeDown();
            }
            return true;
        }
        return false;
    }
}
