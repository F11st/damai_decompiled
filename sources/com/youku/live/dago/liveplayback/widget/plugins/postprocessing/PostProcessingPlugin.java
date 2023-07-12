package com.youku.live.dago.liveplayback.widget.plugins.postprocessing;

import android.text.TextUtils;
import android.view.ViewGroup;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.alixplayer.IAlixPlayer;
import com.youku.alixplayer.OnInfoListener;
import com.youku.alixplayer.OnStateChangeListener;
import com.youku.alixplayer.opensdk.IPlayer;
import com.youku.alixplayer.opensdk.OnChangeVideoListener;
import com.youku.alixplayer.opensdk.OnVideoStreamListener;
import com.youku.alixplayer.opensdk.PlayVideoInfo;
import com.youku.alixplayer.opensdk.VideoRequestError;
import com.youku.alixplayer.opensdk.YoukuVideoInfo;
import com.youku.alixplayer.opensdk.utils.Logger;
import com.youku.alixplayer.opensdk.utils.TLogUtil;
import com.youku.alixplugin.AlixPlayerContext;
import com.youku.alixplugin.base.AbsPlugin;
import com.youku.alixplugin.base.PluginConfig;
import com.youku.android.liveservice.bean.BypassPlayInfo;
import com.youku.android.liveservice.bean.LivePlayControl;
import com.youku.android.liveservice.bean.PlayerWidget;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class PostProcessingPlugin extends AbsPlugin {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String TAG = "PostProcessing-Plugin";
    private HashSet<String> lastPPFilters;
    private IPlayer mPlayer;
    private IAlixPlayer.State mState;
    private YoukuVideoInfo mYoukuVideoInfo;
    private ArrayList<String> processingNamespaces2;

    public PostProcessingPlugin(AlixPlayerContext alixPlayerContext, PluginConfig pluginConfig, ViewGroup viewGroup) {
        super(alixPlayerContext, pluginConfig, viewGroup);
        this.processingNamespaces2 = new ArrayList<>();
        this.mState = IAlixPlayer.State.STATE_IDLE;
        this.lastPPFilters = new HashSet<>();
        this.processingNamespaces2.add("pp_sharp");
        this.processingNamespaces2.add("pp_color_filter");
        this.processingNamespaces2.add("pp_color_space_correct");
        this.processingNamespaces2.add("pp_hdr");
        this.processingNamespaces2.add("pp_audio_enhancement");
        this.processingNamespaces2.add("pp_hdr10");
        this.processingNamespaces2.add("pp_deband");
        this.mAttachToParent = true;
        alixPlayerContext.getPlayerContainer().addVideoStreamListener(new OnVideoStreamListener() { // from class: com.youku.live.dago.liveplayback.widget.plugins.postprocessing.PostProcessingPlugin.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.alixplayer.opensdk.OnVideoStreamListener
            public void onDataFail(VideoRequestError videoRequestError) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1284235634")) {
                    ipChange.ipc$dispatch("1284235634", new Object[]{this, videoRequestError});
                }
            }

            @Override // com.youku.alixplayer.opensdk.OnVideoStreamListener
            public void onDataReady(YoukuVideoInfo youkuVideoInfo) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "812195057")) {
                    ipChange.ipc$dispatch("812195057", new Object[]{this, youkuVideoInfo});
                    return;
                }
                PostProcessingPlugin.this.mYoukuVideoInfo = youkuVideoInfo;
                PostProcessingPlugin.this.onGetVideoInfoSuccess();
            }

            @Override // com.youku.alixplayer.opensdk.OnVideoStreamListener
            public void onNewRequest(PlayVideoInfo playVideoInfo) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1100890582")) {
                    ipChange.ipc$dispatch("-1100890582", new Object[]{this, playVideoInfo});
                }
            }
        });
        IPlayer player = alixPlayerContext.getPlayerContainer().getPlayer();
        this.mPlayer = player;
        player.addOnPlayerStateListener(new OnStateChangeListener() { // from class: com.youku.live.dago.liveplayback.widget.plugins.postprocessing.PostProcessingPlugin.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.alixplayer.OnStateChangeListener
            public void onStateChange(IAlixPlayer.State state, IAlixPlayer.State state2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1969512452")) {
                    ipChange.ipc$dispatch("1969512452", new Object[]{this, state, state2});
                    return;
                }
                PostProcessingPlugin.this.mState = state2;
                if (state2 == IAlixPlayer.State.STATE_VIDEO_STARTED) {
                    PostProcessingPlugin.this.onRealVideoStart();
                }
            }
        });
        this.mPlayer.addOnInfoListener(new OnInfoListener() { // from class: com.youku.live.dago.liveplayback.widget.plugins.postprocessing.PostProcessingPlugin.3
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.alixplayer.OnInfoListener
            public void onInfo(int i, int i2, int i3, Object obj) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1945148555")) {
                    ipChange.ipc$dispatch("1945148555", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), obj});
                } else {
                    PostProcessingPlugin.this.onPlayerInfo(i, i2, i3, obj);
                }
            }
        });
        alixPlayerContext.getPlayerContainer().addChangeVideoListener(new OnChangeVideoListener() { // from class: com.youku.live.dago.liveplayback.widget.plugins.postprocessing.PostProcessingPlugin.4
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.alixplayer.opensdk.OnChangeVideoListener
            public void onChangeVideo(int i, int i2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "478387292")) {
                    ipChange.ipc$dispatch("478387292", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
                }
            }

            @Override // com.youku.alixplayer.opensdk.OnChangeVideoListener
            public void onChangeVideoFinish(boolean z) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1410807861")) {
                    ipChange.ipc$dispatch("-1410807861", new Object[]{this, Boolean.valueOf(z)});
                } else if (z) {
                    PostProcessingPlugin.this.onQualityChangeSuccess();
                }
            }
        });
    }

    private void closePostProcess2(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-494850458")) {
            ipChange.ipc$dispatch("-494850458", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        if (Logger.DEBUG) {
            Logger.d(TAG, "close2 " + i);
        }
        if (i == 0) {
            if (Logger.DEBUG) {
                Logger.d(TAG, "close2 wrong filter");
            }
        } else if (this.mPlayer == null) {
        } else {
            HashMap hashMap = new HashMap();
            hashMap.put("type", "0");
            int filter = this.mPlayer.setFilter(i, hashMap);
            TLogUtil.loge(TAG, "close2  filter = " + i + "  with params = " + hashMap + " , result = " + filter);
        }
    }

    private void doPostProcessByPlayControl(BypassPlayInfo bypassPlayInfo, String str) {
        LivePlayControl livePlayControl;
        PlayerWidget playerWidget;
        String str2;
        List<JSONObject> parseArray;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1327438904")) {
            ipChange.ipc$dispatch("1327438904", new Object[]{this, bypassPlayInfo, str});
            return;
        }
        HashSet hashSet = new HashSet();
        try {
            if (bypassPlayInfo != null) {
                try {
                    livePlayControl = bypassPlayInfo.livePlayControl;
                } catch (Exception e) {
                    e.printStackTrace();
                    Iterator<String> it = this.lastPPFilters.iterator();
                    while (it.hasNext()) {
                        closePostProcess2(Integer.parseInt(it.next()));
                    }
                }
                if (livePlayControl != null && (playerWidget = livePlayControl.playerWidget) != null && (str2 = playerWidget.postProcessConfig) != null) {
                    JSONObject parseObject = JSON.parseObject(str2);
                    if (parseObject != null && (parseArray = JSON.parseArray(parseObject.getString(str), JSONObject.class)) != null && !parseArray.isEmpty()) {
                        for (JSONObject jSONObject : parseArray) {
                            if (TextUtils.equals("1", jSONObject.getString("appPostProcessingMode")) && openPostProcessByPlayControl(jSONObject) == 0) {
                                String string = jSONObject.getString("appPostProcessingType");
                                hashSet.add(string);
                                this.lastPPFilters.remove(string);
                            }
                        }
                    }
                    Iterator<String> it2 = this.lastPPFilters.iterator();
                    while (it2.hasNext()) {
                        closePostProcess2(Integer.parseInt(it2.next()));
                    }
                    this.lastPPFilters.clear();
                    this.lastPPFilters.addAll(hashSet);
                    return;
                }
            }
            Iterator<String> it3 = this.lastPPFilters.iterator();
            while (it3.hasNext()) {
                closePostProcess2(Integer.parseInt(it3.next()));
            }
            this.lastPPFilters.clear();
            this.lastPPFilters.addAll(hashSet);
        } catch (Throwable th) {
            Iterator<String> it4 = this.lastPPFilters.iterator();
            while (it4.hasNext()) {
                closePostProcess2(Integer.parseInt(it4.next()));
            }
            this.lastPPFilters.clear();
            this.lastPPFilters.addAll(hashSet);
            throw th;
        }
    }

    private void doPostProcessing2(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1772033582")) {
            ipChange.ipc$dispatch("1772033582", new Object[]{this, str});
        } else {
            doPostProcessing2(str, PostProcessingConfigManager2.getCurrentPPTypeId(this.mPlayer.getVideoStream().getCurAlixVideoItem().getStreamType()));
        }
    }

    private void masterPostProcess2(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "670177591")) {
            ipChange.ipc$dispatch("670177591", new Object[]{this, str});
            return;
        }
        YoukuVideoInfo youkuVideoInfo = this.mYoukuVideoInfo;
        if (youkuVideoInfo == null) {
            return;
        }
        int playControlPostProcessMode = PostProcessingConfigManager2.getPlayControlPostProcessMode(youkuVideoInfo.getBypassPlayInfo());
        if (playControlPostProcessMode != 1) {
            if (playControlPostProcessMode == 2) {
                doPostProcessByPlayControl(this.mYoukuVideoInfo.getBypassPlayInfo(), str);
                return;
            }
            return;
        }
        Iterator<String> it = this.processingNamespaces2.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (PostProcessingConfigManager2.isPPMasterEnable(next)) {
                doPostProcessing2(next, PostProcessingConfigManager2.getCurrentPPTypeId(str));
            } else {
                closePostProcess2(PostProcessingConfigManager2.getPPFilterType(next));
            }
        }
    }

    private void noneMasterPostProcess2() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1505545685")) {
            ipChange.ipc$dispatch("1505545685", new Object[]{this});
            return;
        }
        YoukuVideoInfo youkuVideoInfo = this.mYoukuVideoInfo;
        if (youkuVideoInfo == null) {
            return;
        }
        int playControlPostProcessMode = PostProcessingConfigManager2.getPlayControlPostProcessMode(youkuVideoInfo.getBypassPlayInfo());
        if (playControlPostProcessMode != 1) {
            if (playControlPostProcessMode == 2) {
                doPostProcessByPlayControl(this.mYoukuVideoInfo.getBypassPlayInfo(), this.mPlayer.getVideoStream().getCurAlixVideoItem().getStreamType());
                return;
            }
            return;
        }
        try {
            Iterator<String> it = this.processingNamespaces2.iterator();
            while (it.hasNext()) {
                doPostProcessing2(it.next());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onGetVideoInfoSuccess() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1296956825")) {
            ipChange.ipc$dispatch("-1296956825", new Object[]{this});
        } else if (this.mState == IAlixPlayer.State.STATE_VIDEO_STARTED) {
            noneMasterPostProcess2();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPlayerInfo(int i, int i2, int i3, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1367463675")) {
            ipChange.ipc$dispatch("1367463675", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), obj});
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onQualityChangeSuccess() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1294483295")) {
            ipChange.ipc$dispatch("1294483295", new Object[]{this});
        } else {
            noneMasterPostProcess2();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onRealVideoStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "779133646")) {
            ipChange.ipc$dispatch("779133646", new Object[]{this});
        } else {
            noneMasterPostProcess2();
        }
    }

    private void openPostProcess2(int i, PPConfigItem pPConfigItem, PPConfigItem pPConfigItem2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1430855106")) {
            ipChange.ipc$dispatch("-1430855106", new Object[]{this, Integer.valueOf(i), pPConfigItem, pPConfigItem2});
            return;
        }
        if (Logger.DEBUG) {
            Logger.d(TAG, "open2 " + i);
        }
        if (i == 0) {
            if (Logger.DEBUG) {
                Logger.d(TAG, "open2 wrong filter");
            }
        } else if (this.mPlayer == null) {
        } else {
            HashMap hashMap = new HashMap();
            hashMap.put("type", pPConfigItem2 != null ? pPConfigItem2.algorithm : pPConfigItem.algorithm);
            if (pPConfigItem != null && !TextUtils.isEmpty(pPConfigItem.extend)) {
                hashMap.put("extend", pPConfigItem.extend);
            }
            if (pPConfigItem2 != null && !TextUtils.isEmpty(pPConfigItem2.extend)) {
                hashMap.put("ups_extend", pPConfigItem2.extend);
            }
            int filter = this.mPlayer.setFilter(i, hashMap);
            TLogUtil.loge(TAG, " open2  filter = " + i + "  with params = " + hashMap + " , result = " + filter);
        }
    }

    private int openPostProcessByPlayControl(JSONObject jSONObject) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1107280418")) {
            return ((Integer) ipChange.ipc$dispatch("-1107280418", new Object[]{this, jSONObject})).intValue();
        }
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(jSONObject.getString("appPostProcessingAlgorithm"))) {
            hashMap.put("type", jSONObject.getString("appPostProcessingAlgorithm"));
        }
        if (!TextUtils.isEmpty(jSONObject.getString("appPostProcessingDefaultExtend"))) {
            hashMap.put("extend", jSONObject.getString("appPostProcessingDefaultExtend"));
        }
        if (!TextUtils.isEmpty(jSONObject.getString("appPostProcessingExtend"))) {
            hashMap.put("ups_extend", jSONObject.getString("appPostProcessingExtend"));
        }
        String string = jSONObject.getString("appPostProcessingType");
        int filter = this.mPlayer.setFilter(Integer.parseInt(string), hashMap);
        TLogUtil.loge(TAG, "openPostProcessByPlayControl  filter = " + string + "  with params = " + hashMap + " , result = " + filter);
        return filter;
    }

    private void doPostProcessing2(String str, String str2) {
        PPConfigItem pPConfigItem;
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "-72855432")) {
            ipChange.ipc$dispatch("-72855432", new Object[]{this, str, str2});
            return;
        }
        PPConfigItem pPConfigItem2 = null;
        if (TextUtils.isEmpty(str2) || !PostProcessingConfigManager2.isPostProcessingEnable(this.mPlayerContext.getContext(), str)) {
            pPConfigItem = null;
        } else {
            i = PostProcessingConfigManager2.getPPFilterType(str);
            pPConfigItem2 = PostProcessingConfigManager2.getPPConfigItemByTypeId(str, str2);
            pPConfigItem = PostProcessingConfigManager2.getPPConfigItemByLiveControl(str, this.mYoukuVideoInfo.getBypassPlayInfo(), str2);
        }
        String pPMode = PostProcessingConfigManager2.getPPMode(pPConfigItem2, pPConfigItem);
        if ("1".equals(pPMode)) {
            openPostProcess2(i, pPConfigItem2, pPConfigItem);
        } else if ("2".equals(pPMode)) {
        } else {
            closePostProcess2(i);
        }
    }
}
