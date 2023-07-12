package cn.damai.player;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import cn.damai.common.user.c;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.imagebrowse.bean.VideoInfo;
import cn.damai.network.NetworkType;
import cn.damai.player.base.DMBaseVideoController;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.playerservice.axp.playinfo.PlayInfoResult;
import com.youku.youkuplayer.YKEventListener;
import java.util.HashMap;
import tb.b23;
import tb.cb1;
import tb.m61;
import tb.wj1;
import tb.xs;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class PlayerEventListener extends YKEventListener {
    private static transient /* synthetic */ IpChange $ipChange;
    volatile DMBaseVideoController a;
    volatile xs b;
    volatile Context c;
    private int d = 0;
    private String e;
    private String f;
    private OnRealVideoStartListener g;
    long h;
    String i;

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public interface OnRealVideoStartListener {
        void getVideoSize(int i, int i2);
    }

    public PlayerEventListener(DMBaseVideoController dMBaseVideoController, xs xsVar, Context context) {
        this.a = dMBaseVideoController;
        this.b = xsVar;
        this.c = context;
        this.e = dMBaseVideoController.getSpmB();
        this.f = dMBaseVideoController.getSpmC() == null ? "" : dMBaseVideoController.getSpmC();
    }

    private void d(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1734293558")) {
            ipChange.ipc$dispatch("1734293558", new Object[]{this, str, str2});
            return;
        }
        if (this.b == null || this.a == null) {
            return;
        }
        String str3 = this.a.getClass().getName() + "_errorCode=" + str2 + "_errorMsg=" + str + "_videoData=" + (this.b.e() != null ? m61.e(this.b.e()) : null);
        b23.a(b23.i("播放器播放错误", this.a.getClass().getName(), str2, str, str3), "-600", str3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(VideoInfo videoInfo, long j, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1080390588")) {
            ipChange.ipc$dispatch("-1080390588", new Object[]{this, videoInfo, Long.valueOf(j), str});
        } else if (videoInfo == null) {
        } else {
            HashMap hashMap = new HashMap();
            hashMap.put("usercode", z20.E());
            if (videoInfo.getProjectInfo() != null) {
                hashMap.put("item_id", videoInfo.getProjectInfo().id);
            }
            hashMap.put("videoId", videoInfo.getValidId());
            hashMap.put("videoTitle", videoInfo.getTitle());
            hashMap.put("duration", j + "");
            hashMap.put("spm-url", "a2o4t." + this.e + "." + this.f + ".playend");
            if (!TextUtils.isEmpty(str)) {
                hashMap.put("play_session_id", str);
            }
            c e = c.e();
            String str2 = this.e;
            e.D(str2, "page_" + this.e + "_playend", "playend", "", hashMap, 12003);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(VideoInfo videoInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2049268387")) {
            ipChange.ipc$dispatch("2049268387", new Object[]{this, videoInfo});
        } else if (videoInfo == null) {
        } else {
            HashMap hashMap = new HashMap();
            hashMap.put("usercode", z20.E());
            if (videoInfo.getProjectInfo() != null) {
                hashMap.put("item_id", videoInfo.getProjectInfo().id);
            }
            hashMap.put("videoId", videoInfo.getValidId());
            hashMap.put("videoTitle", videoInfo.getTitle());
            if (this.c != null) {
                hashMap.put("is_auto_play", wj1.b(this.c) == NetworkType.NETWORK_WIFI ? "1" : "0");
            }
            hashMap.put("spm-url", "a2o4t." + this.e + "." + this.f + ".playstart");
            if (this.b != null && this.b.b() != null) {
                hashMap.put("play_session_id", this.b.b().getSessionId());
            }
            c e = c.e();
            String str = this.e;
            e.D(str, "page_" + this.e + "_playstart", "playstart", "", hashMap, 12002);
        }
    }

    private void i(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2071816186")) {
            ipChange.ipc$dispatch("-2071816186", new Object[]{this, Integer.valueOf(i)});
        } else {
            j(null, i);
        }
    }

    private void j(final Object obj, final int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1537439510")) {
            ipChange.ipc$dispatch("-1537439510", new Object[]{this, obj, Integer.valueOf(i)});
            return;
        }
        if (i != 6) {
            cb1.c("PlayerEventListener", "currentState: " + i);
        }
        Context context = this.c;
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            if (i != 6) {
                cb1.c("PlayerEventListener", "mContext currentState: " + i);
            }
            activity.runOnUiThread(new Runnable() { // from class: cn.damai.player.PlayerEventListener.2
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // java.lang.Runnable
                public void run() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-44097574")) {
                        ipChange2.ipc$dispatch("-44097574", new Object[]{this});
                        return;
                    }
                    if (i != 6) {
                        cb1.c("PlayerEventListener", "run currentState: " + i);
                    }
                    if (PlayerEventListener.this.a != null) {
                        PlayerEventListener.this.a.onPlayStateChanged(i, obj);
                    }
                }
            });
        } else if (i != 6) {
            cb1.c("PlayerEventListener", "context currentState: null" + i);
            release();
        }
        xs xsVar = this.b;
        if (i == 6 || xsVar == null || xsVar.c() == null) {
            return;
        }
        xsVar.c().f(i);
    }

    public int e() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "533411512") ? ((Integer) ipChange.ipc$dispatch("533411512", new Object[]{this})).intValue() : this.d;
    }

    public void h(OnRealVideoStartListener onRealVideoStartListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "79610214")) {
            ipChange.ipc$dispatch("79610214", new Object[]{this, onRealVideoStartListener});
        } else {
            this.g = onRealVideoStartListener;
        }
    }

    @Override // com.youku.youkuplayer.YKEventListener, com.youku.youkuplayer.IPlayerEventListener
    public void onComplete() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2088454561")) {
            ipChange.ipc$dispatch("-2088454561", new Object[]{this});
            return;
        }
        super.onComplete();
        this.d = 7;
        i(7);
        if (this.a == null || !this.a.isAutoReport() || this.b == null) {
            return;
        }
        f(this.b.e(), System.currentTimeMillis() - this.h, this.i);
        this.b.g(null);
    }

    @Override // com.youku.youkuplayer.YKEventListener, com.youku.youkuplayer.IPlayerEventListener
    public void onDataFail(int i, String str, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1824136025")) {
            ipChange.ipc$dispatch("1824136025", new Object[]{this, Integer.valueOf(i), str, obj});
            return;
        }
        super.onDataFail(i, str, obj);
        this.d = 9;
        m61.e(obj);
        d(str + "_ext" + m61.e(obj) + "_DM_PLAYER_GET_VIDEO_INFO_FAILED", i + "");
        i(9);
    }

    @Override // com.youku.youkuplayer.YKEventListener, com.youku.youkuplayer.IPlayerEventListener
    public void onDataReady(PlayInfoResult playInfoResult) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "87409569")) {
            ipChange.ipc$dispatch("87409569", new Object[]{this, playInfoResult});
            return;
        }
        super.onDataReady(playInfoResult);
        this.d = 10;
        i(10);
    }

    @Override // com.youku.youkuplayer.YKEventListener, com.youku.youkuplayer.IPlayerEventListener
    public void onEndLoading() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-841675273")) {
            ipChange.ipc$dispatch("-841675273", new Object[]{this});
            return;
        }
        super.onEndLoading();
        this.d = 13;
        i(13);
    }

    @Override // com.youku.youkuplayer.YKEventListener, com.youku.youkuplayer.IPlayerEventListener
    public void onError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "334539705")) {
            ipChange.ipc$dispatch("334539705", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        super.onError(i);
        this.d = 8;
        d("DM_PLAYER_ERROR", i + "");
        if (i == 15301) {
            ToastUtil.b("          暂不支持\n此视频格式的预览哦~", 1000);
            b23.g("IssueFragment:jsondata={HavanaId:" + z20.i() + ",videoPath:" + this.b.e().getVideoUrl() + "}", "-602", "播放器不识别的视频格式");
        }
        i(8);
    }

    @Override // com.youku.youkuplayer.YKEventListener, com.youku.youkuplayer.IPlayerEventListener
    public void onNewRequest() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-502479287")) {
            ipChange.ipc$dispatch("-502479287", new Object[]{this});
            return;
        }
        super.onNewRequest();
        this.d = 1;
        i(1);
    }

    @Override // com.youku.youkuplayer.YKEventListener, com.youku.youkuplayer.IPlayerEventListener
    public void onPause() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "304010716")) {
            ipChange.ipc$dispatch("304010716", new Object[]{this});
            return;
        }
        super.onPause();
        int i = this.d;
        if (i == 4 || i == 7) {
            return;
        }
        this.d = 4;
        i(4);
        if (this.a == null || !this.a.isAutoReport() || this.b == null) {
            return;
        }
        f(this.b.e(), System.currentTimeMillis() - this.h, this.i);
        if (this.b != null) {
            this.b.g(null);
        }
    }

    @Override // com.youku.youkuplayer.YKEventListener, com.youku.youkuplayer.IPlayerEventListener
    public void onPositionChange(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1201093692")) {
            ipChange.ipc$dispatch("-1201093692", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        super.onPositionChange(i);
        this.d = 6;
        j(Integer.valueOf(i), 6);
    }

    @Override // com.youku.youkuplayer.YKEventListener, com.youku.youkuplayer.IPlayerEventListener
    public void onRealVideoStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1497940749")) {
            ipChange.ipc$dispatch("-1497940749", new Object[]{this});
            return;
        }
        super.onRealVideoStart();
        this.d = 5;
        i(5);
        if (this.b == null) {
            return;
        }
        ((Activity) this.c).runOnUiThread(new Runnable() { // from class: cn.damai.player.PlayerEventListener.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // java.lang.Runnable
            public void run() {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "152415931")) {
                    ipChange2.ipc$dispatch("152415931", new Object[]{this});
                } else if (PlayerEventListener.this.b != null) {
                    if (PlayerEventListener.this.b.a() == null) {
                        if (PlayerEventListener.this.g != null) {
                            PlayerEventListener.this.g.getVideoSize(PlayerEventListener.this.b.b().getVideoWidth(), PlayerEventListener.this.b.b().getVideoHeight());
                        }
                        PlayerEventListener.this.h = System.currentTimeMillis();
                        PlayerEventListener playerEventListener = PlayerEventListener.this;
                        playerEventListener.i = playerEventListener.b.b().getSessionId();
                        if (PlayerEventListener.this.a != null && PlayerEventListener.this.a.isAutoReport()) {
                            PlayerEventListener playerEventListener2 = PlayerEventListener.this;
                            playerEventListener2.g(playerEventListener2.b.e());
                        }
                    } else if (PlayerEventListener.this.a != null && PlayerEventListener.this.a.isAutoReport()) {
                        PlayerEventListener playerEventListener3 = PlayerEventListener.this;
                        VideoInfo a = playerEventListener3.b.a();
                        long currentTimeMillis = System.currentTimeMillis();
                        PlayerEventListener playerEventListener4 = PlayerEventListener.this;
                        playerEventListener3.f(a, currentTimeMillis - playerEventListener4.h, playerEventListener4.i);
                        PlayerEventListener.this.b.g(null);
                        PlayerEventListener playerEventListener5 = PlayerEventListener.this;
                        playerEventListener5.g(playerEventListener5.b.e());
                        PlayerEventListener.this.h = System.currentTimeMillis();
                        PlayerEventListener playerEventListener6 = PlayerEventListener.this;
                        playerEventListener6.i = playerEventListener6.b.b().getSessionId();
                    }
                    PlayerEventListener.this.b.g(PlayerEventListener.this.b.e());
                }
            }
        });
    }

    @Override // com.youku.youkuplayer.YKEventListener, com.youku.youkuplayer.IPlayerEventListener
    public void onStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "347115504")) {
            ipChange.ipc$dispatch("347115504", new Object[]{this});
            return;
        }
        super.onStart();
        this.d = 5;
        i(5);
    }

    @Override // com.youku.youkuplayer.YKEventListener, com.youku.youkuplayer.IPlayerEventListener
    public void onStartLoading() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "797661182")) {
            ipChange.ipc$dispatch("797661182", new Object[]{this});
            return;
        }
        super.onStartLoading();
        this.d = 12;
        i(12);
    }

    @Override // com.youku.youkuplayer.YKEventListener, com.youku.youkuplayer.IPlayerEventListener
    public void onVideoSizeChanged(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "222365856")) {
            ipChange.ipc$dispatch("222365856", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        super.onVideoSizeChanged(i, i2);
        i(e());
    }

    public void release() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-961795284")) {
            ipChange.ipc$dispatch("-961795284", new Object[]{this});
            return;
        }
        this.c = null;
        this.a = null;
        this.b = null;
    }
}
