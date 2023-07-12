package cn.damai.player.video.decor;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import cn.damai.commonbusiness.imagebrowse.bean.VideoInfo;
import cn.damai.player.video.listener.VideoOperateListener;
import cn.damai.player.video.view.ApiPlayer;
import cn.damai.videoplayer.R$id;
import cn.damai.videoplayer.R$layout;
import cn.damai.videoplayer.R$string;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.ef0;
import tb.mu0;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class ArtistVideoUiFacade extends BaseVideoUiFacade implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private ImageView mCover;
    private TextView mErrorTip;
    private View mErrorUi;
    private View mFacade;
    private View mLoading;
    private TextView mMuteTv;
    private View mPlay;

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1584879892")) {
                ipChange.ipc$dispatch("-1584879892", new Object[]{this, view});
                return;
            }
            ArtistVideoUiFacade artistVideoUiFacade = ArtistVideoUiFacade.this;
            VideoOperateListener videoOperateListener = artistVideoUiFacade.mOperateListener;
            if (videoOperateListener != null) {
                videoOperateListener.onPlayClick(artistVideoUiFacade.mApiPlayer.getPlayInfo());
            }
        }
    }

    public ArtistVideoUiFacade(ApiPlayer apiPlayer) {
        super(apiPlayer);
        View inflate = LayoutInflater.from(mu0.a()).inflate(R$layout.video_artist_decor, (ViewGroup) null);
        this.mFacade = inflate;
        this.mPlay = inflate.findViewById(R$id.video_play);
        this.mLoading = this.mFacade.findViewById(R$id.video_loading);
        this.mCover = (ImageView) this.mFacade.findViewById(R$id.video_cover);
        this.mMuteTv = (TextView) this.mFacade.findViewById(R$id.video_voice_btn);
        this.mErrorUi = this.mFacade.findViewById(R$id.video_error_ui);
        this.mErrorTip = (TextView) this.mFacade.findViewById(R$id.video_error_tips);
        this.mFacade.setOnClickListener(new a());
        this.mMuteTv.setOnClickListener(this);
        this.mFacade.findViewById(R$id.video_error_refresh).setOnClickListener(this);
    }

    private void showCover(@Nullable VideoInfo videoInfo, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-625601152")) {
            ipChange.ipc$dispatch("-625601152", new Object[]{this, videoInfo, Boolean.valueOf(z)});
        } else if (z) {
            final String picUrl = videoInfo == null ? "" : videoInfo.getPicUrl();
            this.mCover.setVisibility(0);
            this.mCover.setImageDrawable(null);
            if (TextUtils.isEmpty(picUrl)) {
                return;
            }
            this.mCover.post(new Runnable() { // from class: cn.damai.player.video.decor.ArtistVideoUiFacade.2
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // java.lang.Runnable
                public void run() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "905389923")) {
                        ipChange2.ipc$dispatch("905389923", new Object[]{this});
                    } else {
                        cn.damai.common.image.a.b().f(picUrl, ArtistVideoUiFacade.this.mCover.getWidth(), ArtistVideoUiFacade.this.mCover.getHeight()).g(ArtistVideoUiFacade.this.mCover);
                    }
                }
            });
        } else {
            this.mCover.setVisibility(8);
        }
    }

    private void showErrorUi(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-447228553")) {
            ipChange.ipc$dispatch("-447228553", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.mErrorUi.setVisibility(z ? 0 : 8);
        }
    }

    private void showLoading(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "435747831")) {
            ipChange.ipc$dispatch("435747831", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.mLoading.setVisibility(z ? 0 : 8);
        }
    }

    private void showPlayIcon(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2117934608")) {
            ipChange.ipc$dispatch("2117934608", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.mPlay.setVisibility(z ? 0 : 8);
        }
    }

    @Override // cn.damai.player.video.decor.BaseVideoUiFacade
    public View getView() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1161776413") ? (View) ipChange.ipc$dispatch("-1161776413", new Object[]{this}) : this.mFacade;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        VideoInfo playInfo;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1620378721")) {
            ipChange.ipc$dispatch("-1620378721", new Object[]{this, view});
            return;
        }
        int id = view.getId();
        if (id == R$id.video_voice_btn) {
            ApiPlayer apiPlayer = this.mApiPlayer;
            apiPlayer.mute(!apiPlayer.isMute());
            VideoOperateListener videoOperateListener = this.mOperateListener;
            if (videoOperateListener != null) {
                videoOperateListener.onMuteClick(this.mApiPlayer.getPlayInfo(), this.mApiPlayer.isMute());
            }
        } else if (id != R$id.video_error_refresh || (playInfo = this.mApiPlayer.getPlayInfo()) == null) {
        } else {
            this.mApiPlayer.play(playInfo);
        }
    }

    @Override // cn.damai.player.video.decor.BaseVideoUiFacade
    public void showMute(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-599135652")) {
            ipChange.ipc$dispatch("-599135652", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.mMuteTv.setVisibility(z ? 0 : 4);
        }
    }

    @Override // cn.damai.player.video.decor.BaseVideoUiFacade
    public void updateMute(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-112382360")) {
            ipChange.ipc$dispatch("-112382360", new Object[]{this, Boolean.valueOf(z)});
        } else if (z) {
            this.mMuteTv.setText(mu0.a().getString(R$string.iconfont_shengyinguan22));
        } else {
            this.mMuteTv.setText(mu0.a().getString(R$string.iconfont_shengyinkai22));
        }
    }

    @Override // cn.damai.player.video.decor.BaseVideoUiFacade
    public void videoComplete() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "545678664")) {
            ipChange.ipc$dispatch("545678664", new Object[]{this});
            return;
        }
        showErrorUi(false);
        showLoading(false);
        showPlayIcon(true);
        showCover(this.mApiPlayer.getPlayInfo(), true);
    }

    @Override // cn.damai.player.video.decor.BaseVideoUiFacade
    public void videoEndLoading() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "824616608")) {
            ipChange.ipc$dispatch("824616608", new Object[]{this});
        } else {
            showLoading(false);
        }
    }

    @Override // cn.damai.player.video.decor.BaseVideoUiFacade
    public void videoError(int i, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1151497772")) {
            ipChange.ipc$dispatch("1151497772", new Object[]{this, Integer.valueOf(i), str});
            return;
        }
        showPlayIcon(false);
        showLoading(false);
        showCover(null, false);
        showErrorUi(true);
        this.mErrorTip.setText(ef0.b(mu0.a()));
    }

    @Override // cn.damai.player.video.decor.BaseVideoUiFacade
    public void videoIdle(VideoInfo videoInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1426394111")) {
            ipChange.ipc$dispatch("1426394111", new Object[]{this, videoInfo});
            return;
        }
        showLoading(false);
        showCover(videoInfo, true);
        showErrorUi(false);
        showPlayIcon(true);
    }

    @Override // cn.damai.player.video.decor.BaseVideoUiFacade
    public void videoLoading() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "135645581")) {
            ipChange.ipc$dispatch("135645581", new Object[]{this});
            return;
        }
        showPlayIcon(false);
        showLoading(true);
    }

    @Override // cn.damai.player.video.decor.BaseVideoUiFacade
    public void videoPause() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-854018157")) {
            ipChange.ipc$dispatch("-854018157", new Object[]{this});
        } else {
            showPlayIcon(true);
        }
    }

    @Override // cn.damai.player.video.decor.BaseVideoUiFacade
    public void videoPlaying() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1934695771")) {
            ipChange.ipc$dispatch("1934695771", new Object[]{this});
            return;
        }
        showPlayIcon(false);
        showErrorUi(false);
        showCover(null, false);
        showLoading(false);
    }

    @Override // cn.damai.player.video.decor.BaseVideoUiFacade
    public void videoStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-810913369")) {
            ipChange.ipc$dispatch("-810913369", new Object[]{this});
        } else {
            showPlayIcon(false);
        }
    }
}
