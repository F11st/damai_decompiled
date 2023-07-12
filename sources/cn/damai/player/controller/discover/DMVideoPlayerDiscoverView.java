package cn.damai.player.controller.discover;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import cn.damai.common.image.a;
import cn.damai.videoplayer.R$color;
import cn.damai.videoplayer.R$id;
import cn.damai.videoplayer.R$layout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.xs;
import tb.ys;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class DMVideoPlayerDiscoverView extends FrameLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private FragmentActivity mActivity;
    private ImageView mCoverImg;
    private xs mDataHolder;

    public DMVideoPlayerDiscoverView(FragmentActivity fragmentActivity) {
        super(fragmentActivity);
        this.mActivity = fragmentActivity;
        init();
    }

    private void init() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "648544520")) {
            ipChange.ipc$dispatch("648544520", new Object[]{this});
            return;
        }
        this.mCoverImg = (ImageView) LayoutInflater.from(this.mActivity).inflate(R$layout.yk_player_discover_handler_layout, this).findViewById(R$id.yk_player_video_cover);
        this.mDataHolder = ys.d().c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void changeVideoData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "639086045")) {
            ipChange.ipc$dispatch("639086045", new Object[]{this});
        } else {
            this.mCoverImg.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onError() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1354742807")) {
            ipChange.ipc$dispatch("-1354742807", new Object[]{this});
        } else {
            this.mCoverImg.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onLoadingEnd() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1319516390")) {
            ipChange.ipc$dispatch("-1319516390", new Object[]{this});
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onLoadingStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1395658189")) {
            ipChange.ipc$dispatch("-1395658189", new Object[]{this});
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNewRequest() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-503407030")) {
            ipChange.ipc$dispatch("-503407030", new Object[]{this});
        } else {
            this.mCoverImg.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onPlayerCompletion() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1431402564")) {
            ipChange.ipc$dispatch("-1431402564", new Object[]{this});
        } else {
            this.mCoverImg.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onPlayerPause() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1833976380")) {
            ipChange.ipc$dispatch("1833976380", new Object[]{this});
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onPlayerPlaying() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-472866364")) {
            ipChange.ipc$dispatch("-472866364", new Object[]{this});
        } else {
            this.mCoverImg.setVisibility(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onReloadSo() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1151652732")) {
            ipChange.ipc$dispatch("-1151652732", new Object[]{this});
        } else {
            this.mCoverImg.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void playViewGone() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2055040544")) {
            ipChange.ipc$dispatch("-2055040544", new Object[]{this});
        } else if (this.mCoverImg.getVisibility() == 0) {
            this.mCoverImg.setVisibility(4);
        }
    }

    public void refresh() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1547678921")) {
            ipChange.ipc$dispatch("-1547678921", new Object[]{this});
        } else if (this.mDataHolder.e() == null || TextUtils.isEmpty(this.mDataHolder.e().getPicUrl())) {
        } else {
            a.b().c(this.mDataHolder.e().getPicUrl()).c(R$color.color_111111).g(this.mCoverImg);
        }
    }

    public void stop() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1110843606")) {
            ipChange.ipc$dispatch("1110843606", new Object[]{this});
        } else {
            this.mCoverImg.setVisibility(0);
        }
    }
}
