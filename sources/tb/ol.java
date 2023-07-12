package tb;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.commonbusiness.imagebrowse.bean.VideoInfo;
import cn.damai.player.video.ProxyVideoView;
import cn.damai.player.video.listener.VideoListener;
import cn.damai.player.video.view.ApiPlayer;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class ol implements VideoListener {
    private static transient /* synthetic */ IpChange $ipChange;
    public final Context a;
    public final String b;
    public final String c;
    public final ProxyVideoView d;

    public ol(Context context, ProxyVideoView proxyVideoView, String str, String str2) {
        this.a = context;
        this.d = proxyVideoView;
        this.b = str;
        this.c = str2;
    }

    @Override // cn.damai.player.video.listener.VideoOperateListener
    public void onMuteClick(@Nullable VideoInfo videoInfo, boolean z) {
        String videoUrl;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1849963119")) {
            ipChange.ipc$dispatch("-1849963119", new Object[]{this, videoInfo, Boolean.valueOf(z)});
        } else if (videoInfo == null) {
        } else {
            if (VideoInfo.VideoType.VIDEO_VID == videoInfo.getType()) {
                videoUrl = videoInfo.getVid();
            } else {
                videoUrl = videoInfo.getVideoUrl();
            }
            oy0.B().R(this.b, this.c, videoUrl, !z ? 1 : 0);
        }
    }

    public void onPlayClick(@Nullable VideoInfo videoInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-756170690")) {
            ipChange.ipc$dispatch("-756170690", new Object[]{this, videoInfo});
        } else if (videoInfo != null) {
            try {
                ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
                arrayList.add(videoInfo);
                ArrayList<? extends Parcelable> arrayList2 = new ArrayList<>();
                Bundle bundle = new Bundle();
                bundle.putParcelableArrayList("video_info", arrayList);
                bundle.putParcelableArrayList("pic_info", arrayList2);
                bundle.putInt("position", 0);
                DMNav.from(this.a).withExtras(bundle).toUri(NavUri.b("videobrowse"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // cn.damai.player.video.listener.VideoEventListener
    public void onVideoEnd(ApiPlayer apiPlayer, VideoInfo videoInfo, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "254514800")) {
            ipChange.ipc$dispatch("254514800", new Object[]{this, apiPlayer, videoInfo, Integer.valueOf(i)});
        } else {
            oy0.B().P(this.b, this.c, "playend", null, videoInfo, i, apiPlayer.getSessionId());
        }
    }

    @Override // cn.damai.player.video.listener.VideoEventListener
    public void onVideoPlay(ApiPlayer apiPlayer, VideoInfo videoInfo, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "587313769")) {
            ipChange.ipc$dispatch("587313769", new Object[]{this, apiPlayer, videoInfo, Integer.valueOf(i)});
        } else {
            oy0.B().Q(this.b, this.c, "playstart", null, videoInfo, true, this.d.getSessionId());
        }
    }
}
