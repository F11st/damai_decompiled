package cn.damai.player.video.decor;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import cn.damai.common.image.C0504a;
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
public class HomeVideoUiFacade extends BaseVideoUiFacade implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private ImageView mCover;
    private TextView mErrorTip;
    private View mErrorUi;
    private View mFacade;
    private View mLoading;
    private TextView mMuteTv;
    private View mPlay;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.player.video.decor.HomeVideoUiFacade$a */
    /* loaded from: classes15.dex */
    public class View$OnClickListenerC1505a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC1505a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-728038636")) {
                ipChange.ipc$dispatch("-728038636", new Object[]{this, view});
                return;
            }
            HomeVideoUiFacade homeVideoUiFacade = HomeVideoUiFacade.this;
            VideoOperateListener videoOperateListener = homeVideoUiFacade.mOperateListener;
            if (videoOperateListener != null) {
                videoOperateListener.onPlayClick(homeVideoUiFacade.mApiPlayer.getPlayInfo());
            }
        }
    }

    public HomeVideoUiFacade(ApiPlayer apiPlayer) {
        super(apiPlayer);
        View inflate = LayoutInflater.from(mu0.a()).inflate(R$layout.video_home_decor, (ViewGroup) null);
        this.mFacade = inflate;
        this.mPlay = inflate.findViewById(R$id.video_play);
        this.mLoading = this.mFacade.findViewById(R$id.video_loading);
        this.mCover = (ImageView) this.mFacade.findViewById(R$id.video_cover);
        this.mMuteTv = (TextView) this.mFacade.findViewById(R$id.video_voice_btn);
        this.mErrorUi = this.mFacade.findViewById(R$id.video_error_ui);
        this.mErrorTip = (TextView) this.mFacade.findViewById(R$id.video_error_tips);
        this.mFacade.setOnClickListener(new View$OnClickListenerC1505a());
        this.mMuteTv.setOnClickListener(this);
        this.mFacade.findViewById(R$id.video_error_refresh).setOnClickListener(this);
    }

    private void showCover(@Nullable VideoInfo videoInfo, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1072732248")) {
            ipChange.ipc$dispatch("-1072732248", new Object[]{this, videoInfo, Boolean.valueOf(z)});
        } else if (z) {
            final String picUrl = videoInfo == null ? "" : videoInfo.getPicUrl();
            this.mCover.setVisibility(0);
            this.mCover.setImageDrawable(null);
            if (TextUtils.isEmpty(picUrl)) {
                return;
            }
            this.mCover.post(new Runnable() { // from class: cn.damai.player.video.decor.HomeVideoUiFacade.2
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // java.lang.Runnable
                public void run() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1711233083")) {
                        ipChange2.ipc$dispatch("1711233083", new Object[]{this});
                    } else {
                        C0504a.b().f(picUrl, HomeVideoUiFacade.this.mCover.getWidth(), HomeVideoUiFacade.this.mCover.getHeight()).g(HomeVideoUiFacade.this.mCover);
                    }
                }
            });
        } else {
            this.mCover.setVisibility(8);
        }
    }

    private void showErrorUi(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-88637025")) {
            ipChange.ipc$dispatch("-88637025", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.mErrorUi.setVisibility(z ? 0 : 8);
        }
    }

    private void showLoading(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "794339359")) {
            ipChange.ipc$dispatch("794339359", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.mLoading.setVisibility(z ? 0 : 8);
        }
    }

    private void showPlayIcon(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "349370088")) {
            ipChange.ipc$dispatch("349370088", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.mPlay.setVisibility(z ? 0 : 8);
        }
    }

    @Override // cn.damai.player.video.decor.BaseVideoUiFacade
    public View getView() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-438302789") ? (View) ipChange.ipc$dispatch("-438302789", new Object[]{this}) : this.mFacade;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        VideoInfo playInfo;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-667532857")) {
            ipChange.ipc$dispatch("-667532857", new Object[]{this, view});
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
        if (AndroidInstantRuntime.support(ipChange, "2023616308")) {
            ipChange.ipc$dispatch("2023616308", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.mMuteTv.setVisibility(z ? 0 : 4);
        }
    }

    @Override // cn.damai.player.video.decor.BaseVideoUiFacade
    public void updateMute(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-793551552")) {
            ipChange.ipc$dispatch("-793551552", new Object[]{this, Boolean.valueOf(z)});
        } else if (z) {
            this.mMuteTv.setText(mu0.a().getString(R$string.iconfont_shengyinguan22));
        } else {
            this.mMuteTv.setText(mu0.a().getString(R$string.iconfont_shengyinkai22));
        }
    }

    @Override // cn.damai.player.video.decor.BaseVideoUiFacade
    public void videoComplete() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1222885856")) {
            ipChange.ipc$dispatch("-1222885856", new Object[]{this});
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
        if (AndroidInstantRuntime.support(ipChange, "2041162104")) {
            ipChange.ipc$dispatch("2041162104", new Object[]{this});
        } else {
            showLoading(false);
        }
    }

    @Override // cn.damai.player.video.decor.BaseVideoUiFacade
    public void videoError(int i, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1943772932")) {
            ipChange.ipc$dispatch("1943772932", new Object[]{this, Integer.valueOf(i), str});
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
        if (AndroidInstantRuntime.support(ipChange, "1134875863")) {
            ipChange.ipc$dispatch("1134875863", new Object[]{this, videoInfo});
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
        if (AndroidInstantRuntime.support(ipChange, "494237109")) {
            ipChange.ipc$dispatch("494237109", new Object[]{this});
            return;
        }
        showPlayIcon(false);
        showLoading(true);
    }

    @Override // cn.damai.player.video.decor.BaseVideoUiFacade
    public void videoPause() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1153086021")) {
            ipChange.ipc$dispatch("-1153086021", new Object[]{this});
        } else {
            showPlayIcon(true);
        }
    }

    @Override // cn.damai.player.video.decor.BaseVideoUiFacade
    public void videoPlaying() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2001679997")) {
            ipChange.ipc$dispatch("-2001679997", new Object[]{this});
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
        if (AndroidInstantRuntime.support(ipChange, "-1109981233")) {
            ipChange.ipc$dispatch("-1109981233", new Object[]{this});
        } else {
            showPlayIcon(false);
        }
    }
}
