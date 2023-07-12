package tb;

import androidx.fragment.app.FragmentActivity;
import cn.damai.commonbusiness.imagebrowse.bean.VideoInfo;
import cn.damai.player.DMVideoPlayer;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.youkuplayer.IYoukuPlayer;
import com.youku.youkuplayer.YoukuPlayer;
import java.lang.ref.WeakReference;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class xs {
    private static transient /* synthetic */ IpChange $ipChange;
    private w01 a;
    private VideoInfo b;
    private zs c;
    private long d;
    private long e;
    private WeakReference<DMVideoPlayer> f;
    VideoInfo g;

    public xs(FragmentActivity fragmentActivity, DMVideoPlayer dMVideoPlayer) {
        f(fragmentActivity);
        this.f = new WeakReference<>(dMVideoPlayer);
    }

    private void f(FragmentActivity fragmentActivity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1549641308")) {
            ipChange.ipc$dispatch("-1549641308", new Object[]{this, fragmentActivity});
            return;
        }
        IYoukuPlayer create = YoukuPlayer.create(fragmentActivity.getApplication(), new C9878ws().a(), null);
        create.setWaterMarkImageView(new bt(fragmentActivity));
        this.a = new w01(create);
        this.c = new zs();
    }

    public VideoInfo a() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-7514891") ? (VideoInfo) ipChange.ipc$dispatch("-7514891", new Object[]{this}) : this.g;
    }

    public w01 b() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1320519752") ? (w01) ipChange.ipc$dispatch("-1320519752", new Object[]{this}) : this.a;
    }

    public zs c() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-258038627")) {
            return (zs) ipChange.ipc$dispatch("-258038627", new Object[]{this});
        }
        if (this.c == null) {
            this.c = new zs();
        }
        return this.c;
    }

    public long d() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-765411801") ? ((Long) ipChange.ipc$dispatch("-765411801", new Object[]{this})).longValue() : this.e - this.d;
    }

    public VideoInfo e() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-181077013") ? (VideoInfo) ipChange.ipc$dispatch("-181077013", new Object[]{this}) : this.b;
    }

    public void g(VideoInfo videoInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "278308269")) {
            ipChange.ipc$dispatch("278308269", new Object[]{this, videoInfo});
        } else {
            this.g = videoInfo;
        }
    }

    public void h(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-577709988")) {
            ipChange.ipc$dispatch("-577709988", new Object[]{this, Long.valueOf(j)});
        } else {
            this.e = j;
        }
    }

    public void i(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "698645475")) {
            ipChange.ipc$dispatch("698645475", new Object[]{this, Long.valueOf(j)});
        } else {
            this.d = j;
        }
    }

    public void j(VideoInfo videoInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-126743301")) {
            ipChange.ipc$dispatch("-126743301", new Object[]{this, videoInfo});
            return;
        }
        this.b = videoInfo;
        WeakReference<DMVideoPlayer> weakReference = this.f;
        DMVideoPlayer dMVideoPlayer = weakReference != null ? weakReference.get() : null;
        if (dMVideoPlayer == null || dMVideoPlayer.getController() == null) {
            return;
        }
        dMVideoPlayer.getController().refresh();
    }
}
