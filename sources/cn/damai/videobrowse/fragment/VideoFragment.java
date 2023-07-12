package cn.damai.videobrowse.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.imagebrowse.bean.VideoInfo;
import cn.damai.player.DMVideoPlayer;
import cn.damai.player.base.IVideoPlayerExtend;
import cn.damai.player.controller.DMVideoPlayerDefaultController;
import cn.damai.player.listener.OnPlayerUTReportListener;
import cn.damai.videobrowse.view.VideoProjectView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.common.Constants;
import tb.tx2;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class VideoFragment extends LazyLoadFragment {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String TAG = "VideoBrowse";
    private DMVideoPlayerDefaultController mController;
    private DMVideoPlayer mPlayer;
    private String mProjectId;
    private VideoInfo mVideoInfo;
    private FrameLayout projectLayout;
    private TextView sourceLabel;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.videobrowse.fragment.VideoFragment$a */
    /* loaded from: classes9.dex */
    public class C2787a implements IVideoPlayerExtend {
        private static transient /* synthetic */ IpChange $ipChange;

        C2787a() {
        }

        @Override // cn.damai.player.base.IVideoPlayerExtend
        public void onScreenModeChangedView(boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-147518288")) {
                ipChange.ipc$dispatch("-147518288", new Object[]{this, Boolean.valueOf(z)});
            } else if (z) {
                VideoFragment.this.projectLayout.setVisibility(8);
            } else {
                VideoFragment.this.projectLayout.setVisibility(0);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.videobrowse.fragment.VideoFragment$b */
    /* loaded from: classes9.dex */
    public class C2788b implements OnPlayerUTReportListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C2788b() {
        }

        @Override // cn.damai.player.listener.OnPlayerUTReportListener
        public void fullScreenBtnClick(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "791674271")) {
                ipChange.ipc$dispatch("791674271", new Object[]{this, str});
                return;
            }
            Log.e(VideoFragment.TAG, "fullScreenBtnClick: " + str);
            tx2.g().i("bottom", "fullscreen", false, VideoFragment.this.mProjectId, str, z20.E());
        }

        @Override // cn.damai.player.listener.OnPlayerUTReportListener
        public void onMuteBtnClick(String str, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1440635329")) {
                ipChange.ipc$dispatch("1440635329", new Object[]{this, str, Integer.valueOf(i)});
                return;
            }
            Log.e(VideoFragment.TAG, "onMuteBtnClick: " + str + " " + i);
            tx2.g().j("bottom", "mute", false, VideoFragment.this.mProjectId, str, z20.E(), String.valueOf(i));
        }

        @Override // cn.damai.player.listener.OnPlayerUTReportListener
        public void onPauseOrPlayClick(String str, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1729147977")) {
                ipChange.ipc$dispatch("-1729147977", new Object[]{this, str, Integer.valueOf(i)});
                return;
            }
            String str2 = i == 5 ? "1" : i == 11 ? "0" : "";
            Log.e(VideoFragment.TAG, "onPauseOrPlayClick: " + i);
            tx2.g().j("bottom", "pause_play", false, VideoFragment.this.mProjectId, str, z20.E(), str2);
        }

        @Override // cn.damai.player.listener.OnPlayerUTReportListener
        public void onSeekBarClick(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1539224698")) {
                ipChange.ipc$dispatch("1539224698", new Object[]{this, str});
                return;
            }
            Log.e(VideoFragment.TAG, "onSeekBarClick: " + str);
            tx2.g().i("bottom", "progress", false, VideoFragment.this.mProjectId, str, z20.E());
        }

        @Override // cn.damai.player.listener.OnPlayerUTReportListener
        public void playEnd(String str, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1775839794")) {
                ipChange.ipc$dispatch("1775839794", new Object[]{this, str, Integer.valueOf(i)});
                return;
            }
            Log.e(VideoFragment.TAG, "playEnd: " + str + " " + i);
            tx2.g().k(VideoFragment.this.mProjectId, z20.E(), "playend", str, VideoFragment.this.mVideoInfo != null ? VideoFragment.this.mVideoInfo.getTitle() : "", String.valueOf(i));
        }

        @Override // cn.damai.player.listener.OnPlayerUTReportListener
        public void playStart(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1964060298")) {
                ipChange.ipc$dispatch("1964060298", new Object[]{this, str});
                return;
            }
            Log.e(VideoFragment.TAG, "playStart: " + str);
            if (VideoFragment.this.mVideoInfo != null) {
                VideoFragment.this.mVideoInfo.getTitle();
            }
        }

        @Override // cn.damai.player.listener.OnPlayerUTReportListener
        public void returnSmallScreen(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "142781749")) {
                ipChange.ipc$dispatch("142781749", new Object[]{this, str});
                return;
            }
            Log.e(VideoFragment.TAG, "returnSmallScreen: " + str);
            tx2.g().i("fullscreen", Constants.Event.RETURN, false, VideoFragment.this.mProjectId, str, z20.E());
        }
    }

    public static VideoFragment getInstance(String str, VideoInfo videoInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1805265485")) {
            return (VideoFragment) ipChange.ipc$dispatch("1805265485", new Object[]{str, videoInfo});
        }
        VideoFragment videoFragment = new VideoFragment();
        Bundle bundle = new Bundle();
        if (videoInfo != null) {
            bundle.putString("projectId", str);
            bundle.putParcelable("videoInfo", videoInfo);
        }
        videoFragment.setArguments(bundle);
        return videoFragment;
    }

    private void registerListeners() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "299595456")) {
            ipChange.ipc$dispatch("299595456", new Object[]{this});
        } else {
            this.mController.setUTReportListener(new C2788b());
        }
    }

    @Override // cn.damai.videobrowse.fragment.LazyLoadFragment
    protected void lazyLoad() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "341062452")) {
            ipChange.ipc$dispatch("341062452", new Object[]{this});
        }
    }

    @Override // cn.damai.videobrowse.fragment.LazyLoadFragment
    public void onActivityCreated() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "461156322")) {
            ipChange.ipc$dispatch("461156322", new Object[]{this});
            return;
        }
        super.onActivityCreated();
        VideoInfo videoInfo = this.mVideoInfo;
        if (videoInfo != null && !TextUtils.isEmpty(videoInfo.getSourceLabel())) {
            this.sourceLabel.setText(this.mVideoInfo.getSourceLabel());
            this.sourceLabel.setVisibility(0);
        } else {
            this.sourceLabel.setVisibility(8);
        }
        this.mPlayer.setVideoData(this.mVideoInfo);
        if (getUserVisibleHint()) {
            this.mPlayer.autoPlay();
        } else {
            this.mPlayer.stop();
        }
        VideoInfo videoInfo2 = this.mVideoInfo;
        if (videoInfo2 != null && videoInfo2.getProjectInfo() != null) {
            this.projectLayout.setVisibility(0);
            this.projectLayout.removeAllViews();
            VideoProjectView videoProjectView = new VideoProjectView(getContext());
            String str = this.mVideoInfo.getProjectInfo().venueCity;
            if (!TextUtils.isEmpty(this.mVideoInfo.getProjectInfo().venueName)) {
                str = this.mVideoInfo.getProjectInfo().venueCity + " | " + this.mVideoInfo.getProjectInfo().venueName;
            }
            videoProjectView.update(this.mVideoInfo.getProjectInfo().id, this.mVideoInfo.getProjectInfo().name, this.mVideoInfo.getProjectInfo().showTime, str, this.mVideoInfo.getProjectInfo().verticalPic);
            this.projectLayout.addView(videoProjectView);
        } else {
            this.projectLayout.setVisibility(8);
        }
        registerListeners();
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1824295841")) {
            ipChange.ipc$dispatch("1824295841", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mProjectId = arguments.getString("projectId");
            if (arguments.getParcelable("videoInfo") != null) {
                VideoInfo videoInfo = (VideoInfo) arguments.getParcelable("videoInfo");
                this.mVideoInfo = videoInfo;
                if (videoInfo != null && videoInfo.getProjectInfo() != null && !TextUtils.isEmpty(this.mVideoInfo.getProjectInfo().id)) {
                    this.mProjectId = this.mVideoInfo.getProjectInfo().id;
                }
            }
            Log.e(TAG, "onCreate: ");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.videobrowse.fragment.LazyLoadFragment
    public void onCreateView(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1621490596")) {
            ipChange.ipc$dispatch("1621490596", new Object[]{this, view});
            return;
        }
        super.onCreateView(view);
        view.setKeepScreenOn(true);
        this.mPlayer = (DMVideoPlayer) findViewById(R$id.player);
        this.sourceLabel = (TextView) findViewById(R$id.sourcelabel_txt);
        this.projectLayout = (FrameLayout) findViewById(R$id.video_project);
        DMVideoPlayerDefaultController dMVideoPlayerDefaultController = new DMVideoPlayerDefaultController(getActivity());
        this.mController = dMVideoPlayerDefaultController;
        dMVideoPlayerDefaultController.setPlayerExtend(new C2787a());
        this.mController.setAutoReport(true);
        this.mController.setSpmData("video", Constants.Value.PLAY);
        if (this.mVideoInfo.getProjectInfo() == null) {
            this.mPlayer.setAutoAdaptVideoSize(true);
        }
        this.mPlayer.setController(this.mController);
    }

    @Override // cn.damai.videobrowse.fragment.LazyLoadFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-886619076")) {
            ipChange.ipc$dispatch("-886619076", new Object[]{this});
            return;
        }
        super.onDestroyView();
        DMVideoPlayer dMVideoPlayer = this.mPlayer;
        if (dMVideoPlayer != null) {
            dMVideoPlayer.release();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "923403557")) {
            ipChange.ipc$dispatch("923403557", new Object[]{this});
            return;
        }
        super.onPause();
        this.mPlayer.pause(false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "966508345")) {
            ipChange.ipc$dispatch("966508345", new Object[]{this});
            return;
        }
        super.onStart();
        if (getUserVisibleHint()) {
            this.mPlayer.start();
        }
    }

    @Override // cn.damai.videobrowse.fragment.LazyLoadFragment
    protected int setContentView() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1694615205") ? ((Integer) ipChange.ipc$dispatch("1694615205", new Object[]{this})).intValue() : R$layout.video_fragment_layout;
    }

    @Override // cn.damai.videobrowse.fragment.LazyLoadFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "479910514")) {
            ipChange.ipc$dispatch("479910514", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        super.setUserVisibleHint(z);
        getActivity();
        DMVideoPlayer dMVideoPlayer = this.mPlayer;
        if (dMVideoPlayer != null) {
            if (z) {
                dMVideoPlayer.play();
            } else {
                dMVideoPlayer.pause(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.videobrowse.fragment.LazyLoadFragment
    public void stopLoad() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1110254310")) {
            ipChange.ipc$dispatch("1110254310", new Object[]{this});
            return;
        }
        super.stopLoad();
        this.mPlayer.stop();
    }
}
