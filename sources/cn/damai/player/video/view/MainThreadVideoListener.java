package cn.damai.player.video.view;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import cn.damai.common.AppConfig;
import cn.damai.commonbusiness.imagebrowse.bean.VideoInfo;
import cn.damai.player.video.decor.BaseVideoUiFacade;
import cn.damai.player.video.listener.VideoEventListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.uc.webview.export.media.MessageID;
import com.youku.youkuplayer.YKEventListener;
import tb.b23;
import tb.m61;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class MainThreadVideoListener extends YKEventListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private Handler a = new Handler(Looper.getMainLooper());
    private ApiPlayer b;
    private BaseVideoUiFacade c;
    private VideoEventListener d;
    private VideoInfo e;
    private long f;

    public MainThreadVideoListener(ApiPlayer apiPlayer, BaseVideoUiFacade baseVideoUiFacade) {
        this.b = apiPlayer;
        this.c = baseVideoUiFacade;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(String str, int i, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "912908411")) {
            ipChange.ipc$dispatch("912908411", new Object[]{this, str, Integer.valueOf(i), str2});
            return;
        }
        try {
            ApiPlayer apiPlayer = this.b;
            VideoInfo playInfo = apiPlayer != null ? apiPlayer.getPlayInfo() : null;
            String str3 = str + "_errorCode=" + i + "_errorMsg=" + str2 + "_videoData=" + (playInfo != null ? m61.e(playInfo) : "");
            b23.a(b23.i("播放器播放错误", str, i + "", str2, str3), "-601", str3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "437848405")) {
            ipChange.ipc$dispatch("437848405", new Object[]{this});
        } else if (this.d == null || this.e == null) {
        } else {
            this.d.onVideoEnd(this.b, this.e, (int) (System.currentTimeMillis() - this.f));
            this.e = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-490237522")) {
            ipChange.ipc$dispatch("-490237522", new Object[]{this});
            return;
        }
        VideoInfo playInfo = this.b.getPlayInfo();
        if (this.d == null || playInfo == null) {
            return;
        }
        this.e = playInfo;
        this.f = System.currentTimeMillis();
        VideoEventListener videoEventListener = this.d;
        ApiPlayer apiPlayer = this.b;
        videoEventListener.onVideoPlay(apiPlayer, playInfo, apiPlayer.getDuration());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void i(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2022888145")) {
            ipChange.ipc$dispatch("2022888145", new Object[]{str});
        } else if (AppConfig.v()) {
            Log.e("MyVideoView", " thread=" + Thread.currentThread().getName() + " " + str);
        }
    }

    private void runOnUiThread(Runnable runnable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "855012578")) {
            ipChange.ipc$dispatch("855012578", new Object[]{this, runnable});
        } else if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            runnable.run();
        } else {
            this.a.post(runnable);
        }
    }

    public void j(VideoEventListener videoEventListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1991255844")) {
            ipChange.ipc$dispatch("1991255844", new Object[]{this, videoEventListener});
        } else {
            this.d = videoEventListener;
        }
    }

    @Override // com.youku.youkuplayer.YKEventListener, com.youku.youkuplayer.IPlayerEventListener
    public void onComplete() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2017222662")) {
            ipChange.ipc$dispatch("2017222662", new Object[]{this});
        } else {
            runOnUiThread(new Runnable() { // from class: cn.damai.player.video.view.MainThreadVideoListener.8
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // java.lang.Runnable
                public void run() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1941409651")) {
                        ipChange2.ipc$dispatch("-1941409651", new Object[]{this});
                        return;
                    }
                    MainThreadVideoListener.i("onVideoComplete");
                    MainThreadVideoListener.this.g();
                    MainThreadVideoListener.this.c.videoComplete();
                }
            });
        }
    }

    @Override // com.youku.youkuplayer.YKEventListener, com.youku.youkuplayer.IPlayerEventListener
    public void onDataFail(final int i, final String str, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-190038510")) {
            ipChange.ipc$dispatch("-190038510", new Object[]{this, Integer.valueOf(i), str, obj});
            return;
        }
        super.onDataFail(i, str, obj);
        runOnUiThread(new Runnable() { // from class: cn.damai.player.video.view.MainThreadVideoListener.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // java.lang.Runnable
            public void run() {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-565815116")) {
                    ipChange2.ipc$dispatch("-565815116", new Object[]{this});
                    return;
                }
                MainThreadVideoListener.this.f("直击现场CMS组件onDataFail", i, str);
                MainThreadVideoListener.i("onDataFail");
                MainThreadVideoListener.this.c.videoError(i, str);
            }
        });
    }

    @Override // com.youku.youkuplayer.YKEventListener, com.youku.youkuplayer.IPlayerEventListener
    public void onEndLoading() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1934158302")) {
            ipChange.ipc$dispatch("1934158302", new Object[]{this});
        } else {
            runOnUiThread(new Runnable() { // from class: cn.damai.player.video.view.MainThreadVideoListener.7
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // java.lang.Runnable
                public void run() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1744896146")) {
                        ipChange2.ipc$dispatch("-1744896146", new Object[]{this});
                        return;
                    }
                    MainThreadVideoListener.i("onEndLoading");
                    MainThreadVideoListener.this.c.videoEndLoading();
                }
            });
        }
    }

    @Override // com.youku.youkuplayer.YKEventListener, com.youku.youkuplayer.IPlayerEventListener
    public void onError(final int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1040487200")) {
            ipChange.ipc$dispatch("1040487200", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        super.onError(i);
        runOnUiThread(new Runnable() { // from class: cn.damai.player.video.view.MainThreadVideoListener.5
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // java.lang.Runnable
            public void run() {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1351869136")) {
                    ipChange2.ipc$dispatch("-1351869136", new Object[]{this});
                } else {
                    MainThreadVideoListener.this.f("直击现场CMS组件onError", i, "");
                }
            }
        });
    }

    @Override // com.youku.youkuplayer.YKEventListener, com.youku.youkuplayer.IPlayerEventListener
    public void onPause() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1573709205")) {
            ipChange.ipc$dispatch("1573709205", new Object[]{this});
        } else {
            runOnUiThread(new Runnable() { // from class: cn.damai.player.video.view.MainThreadVideoListener.3
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // java.lang.Runnable
                public void run() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-958842126")) {
                        ipChange2.ipc$dispatch("-958842126", new Object[]{this});
                        return;
                    }
                    MainThreadVideoListener.i(MessageID.onPause);
                    MainThreadVideoListener.this.g();
                    MainThreadVideoListener.this.c.videoPause();
                }
            });
        }
    }

    @Override // com.youku.youkuplayer.YKEventListener, com.youku.youkuplayer.IPlayerEventListener
    public void onPositionChange(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1034600387")) {
            ipChange.ipc$dispatch("-1034600387", new Object[]{this, Integer.valueOf(i)});
        } else {
            super.onPositionChange(i);
        }
    }

    @Override // com.youku.youkuplayer.YKEventListener, com.youku.youkuplayer.IPlayerEventListener
    public void onRealVideoStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1971113306")) {
            ipChange.ipc$dispatch("1971113306", new Object[]{this});
        } else {
            runOnUiThread(new Runnable() { // from class: cn.damai.player.video.view.MainThreadVideoListener.2
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // java.lang.Runnable
                public void run() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-762328621")) {
                        ipChange2.ipc$dispatch("-762328621", new Object[]{this});
                        return;
                    }
                    MainThreadVideoListener.this.h();
                    MainThreadVideoListener.i("onVideoStart");
                    MainThreadVideoListener.this.c.videoPlaying();
                }
            });
        }
    }

    @Override // com.youku.youkuplayer.YKEventListener, com.youku.youkuplayer.IPlayerEventListener
    public void onStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1616813993")) {
            ipChange.ipc$dispatch("1616813993", new Object[]{this});
        } else {
            runOnUiThread(new Runnable() { // from class: cn.damai.player.video.view.MainThreadVideoListener.4
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // java.lang.Runnable
                public void run() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1155355631")) {
                        ipChange2.ipc$dispatch("-1155355631", new Object[]{this});
                        return;
                    }
                    MainThreadVideoListener.i("onStart");
                    MainThreadVideoListener.this.h();
                    MainThreadVideoListener.this.c.videoStart();
                }
            });
        }
    }

    @Override // com.youku.youkuplayer.YKEventListener, com.youku.youkuplayer.IPlayerEventListener
    public void onStartLoading() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1199035941")) {
            ipChange.ipc$dispatch("1199035941", new Object[]{this});
        } else {
            runOnUiThread(new Runnable() { // from class: cn.damai.player.video.view.MainThreadVideoListener.6
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // java.lang.Runnable
                public void run() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1548382641")) {
                        ipChange2.ipc$dispatch("-1548382641", new Object[]{this});
                        return;
                    }
                    MainThreadVideoListener.i("onStartLoading");
                    MainThreadVideoListener.this.c.videoLoading();
                }
            });
        }
    }
}
