package com.youku.live.dago.liveplayback.widget.preload;

import android.content.Context;
import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.alixplayer.opensdk.IVideoRequest;
import com.youku.alixplayer.opensdk.PlayVideoInfo;
import com.youku.alixplayer.opensdk.PlayerConfig;
import com.youku.alixplayer.opensdk.live.LiveVideoRequest;
import com.youku.alixplayer.opensdk.utils.TLogUtil;
import com.youku.android.liveservice.bean.LivePlayControl;
import com.youku.android.liveservice.bean.VideoInfo;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.preloader.IPreloader;
import com.youku.live.dsl.preloader.IPreloaderMananger;
import com.youku.live.dsl.preloader.IResultCallback;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class LiveVideoRequestWithPreloader extends LiveVideoRequest {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String TAG = "LiveVideoRequestWithPreloader";

    public LiveVideoRequestWithPreloader(Context context, PlayerConfig playerConfig) {
        super(context, playerConfig);
    }

    @Override // com.youku.alixplayer.opensdk.live.LiveVideoRequest, com.youku.alixplayer.opensdk.IVideoRequest
    public void request(final PlayVideoInfo playVideoInfo, Map map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "901831386")) {
            ipChange.ipc$dispatch("901831386", new Object[]{this, playVideoInfo, map});
            return;
        }
        TLogUtil.playLog("request live liveId=" + playVideoInfo.getLiveId());
        this.mState = IVideoRequest.State.DOING;
        String string = playVideoInfo.getString("playControlRequireId");
        if (!TextUtils.isEmpty(string)) {
            IPreloaderMananger iPreloaderMananger = (IPreloaderMananger) Dsl.getService(IPreloaderMananger.class);
            IPreloader livePlayControlPreloader = iPreloaderMananger != null ? iPreloaderMananger.getLivePlayControlPreloader(string) : null;
            if (livePlayControlPreloader != null) {
                livePlayControlPreloader.isFinish();
                livePlayControlPreloader.addResultCallback(new IResultCallback() { // from class: com.youku.live.dago.liveplayback.widget.preload.LiveVideoRequestWithPreloader.1
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // com.youku.live.dsl.preloader.IResultCallback
                    public void onResult(Map<String, Object> map2) {
                        IpChange ipChange2 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange2, "-1971554645")) {
                            ipChange2.ipc$dispatch("-1971554645", new Object[]{this, map2});
                            return;
                        }
                        VideoInfo videoInfo = null;
                        if (map2 != null) {
                            Object obj = map2.get("videoInfo");
                            if (obj instanceof VideoInfo) {
                                videoInfo = (VideoInfo) obj;
                            }
                        }
                        LiveVideoRequestWithPreloader.this.requestSuccess(playVideoInfo, videoInfo);
                    }
                }, new IResultCallback() { // from class: com.youku.live.dago.liveplayback.widget.preload.LiveVideoRequestWithPreloader.2
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // com.youku.live.dsl.preloader.IResultCallback
                    public void onResult(Map<String, Object> map2) {
                        String str;
                        Integer num;
                        IpChange ipChange2 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange2, "-1960238518")) {
                            ipChange2.ipc$dispatch("-1960238518", new Object[]{this, map2});
                            return;
                        }
                        LivePlayControl livePlayControl = null;
                        if (map2 != null) {
                            Object obj = map2.get("livePlayControl");
                            LivePlayControl livePlayControl2 = obj instanceof LivePlayControl ? (LivePlayControl) obj : null;
                            Object obj2 = map2.get("code");
                            num = obj2 instanceof Integer ? (Integer) obj2 : null;
                            Object obj3 = map2.get("msg");
                            str = obj3 instanceof String ? (String) obj3 : null;
                            livePlayControl = livePlayControl2;
                        } else {
                            str = null;
                            num = null;
                        }
                        LiveVideoRequestWithPreloader.this.requestFailure(playVideoInfo, livePlayControl, num.intValue(), str);
                    }
                });
                return;
            }
        }
        super.request(playVideoInfo, map);
    }
}
