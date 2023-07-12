package cn.damai.tetris.component.home.viewholder;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.imagebrowse.bean.PicInfo;
import cn.damai.commonbusiness.imagebrowse.bean.VideoInfo;
import cn.damai.player.DMVideoPlayer;
import cn.damai.player.controller.home.DMVideoPlayerHomeController;
import cn.damai.player.listener.OnPlayerUTReportListener;
import cn.damai.tetris.component.home.HomeData;
import cn.damai.tetris.component.home.adapter.IVideoAdapter;
import cn.damai.tetris.component.home.adapter.VideoAdapter;
import cn.damai.tetris.component.home.bean.HomePageVideoBean;
import cn.damai.tetris.component.home.utils.RankItemDividerDecoration;
import cn.damai.tetris.core.TrackInfo;
import cn.damai.tetris.mvp.CommonBean;
import cn.damai.tetris.mvp.CommonViewHolder;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import tb.cs;
import tb.oy0;
import tb.qx2;
import tb.qz1;
import tb.t60;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class VideoViewHolder extends CommonViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    boolean isShow;
    protected IVideoAdapter mAdapter;
    private Context mContext;
    private DMVideoPlayerHomeController mController;
    protected int mIndex;
    private TextView mModuleTitle;
    private OnPlayerUTReportListener mOnPlayerUTReportListener;
    private IVideoAdapter.OnVideoItemClickListener mOnVideoItemClickListener;
    private String mProjectId;
    private RecyclerView mProjectList;
    private View mTitleLayout;
    private TrackInfo mTrackInfo;
    private View mVideoCover;
    private VideoInfo mVideoInfo;
    private DMVideoPlayer mVideoPlayer;
    private String moduleTitle;
    protected boolean reset;
    protected View userAvatar;

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public class a implements OnPlayerUTReportListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // cn.damai.player.listener.OnPlayerUTReportListener
        public void fullScreenBtnClick(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "771272542")) {
                ipChange.ipc$dispatch("771272542", new Object[]{this, str});
            }
        }

        @Override // cn.damai.player.listener.OnPlayerUTReportListener
        public void onMuteBtnClick(String str, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1990322078")) {
                ipChange.ipc$dispatch("-1990322078", new Object[]{this, str, Integer.valueOf(i)});
            } else {
                oy0.B().x(VideoViewHolder.this.mTrackInfo, str, i);
            }
        }

        @Override // cn.damai.player.listener.OnPlayerUTReportListener
        public void onPauseOrPlayClick(String str, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1933365720")) {
                ipChange.ipc$dispatch("1933365720", new Object[]{this, str, Integer.valueOf(i)});
            } else if (VideoViewHolder.this.mVideoInfo == null) {
            } else {
                ArrayList<VideoInfo> arrayList = new ArrayList<>();
                arrayList.add(VideoViewHolder.this.mVideoInfo);
                ArrayList<PicInfo> arrayList2 = new ArrayList<>();
                VideoViewHolder videoViewHolder = VideoViewHolder.this;
                videoViewHolder.startVideoBrowseActivity(videoViewHolder.mProjectId, arrayList, arrayList2, 0);
                oy0.B().w(VideoViewHolder.this.mTrackInfo, VideoViewHolder.this.mVideoInfo.getVid(), VideoViewHolder.this.mProjectId, VideoViewHolder.this.mIndex);
            }
        }

        @Override // cn.damai.player.listener.OnPlayerUTReportListener
        public void onSeekBarClick(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1844190649")) {
                ipChange.ipc$dispatch("1844190649", new Object[]{this, str});
            }
        }

        @Override // cn.damai.player.listener.OnPlayerUTReportListener
        public void playEnd(String str, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-543019343")) {
                ipChange.ipc$dispatch("-543019343", new Object[]{this, str, Integer.valueOf(i)});
            }
        }

        @Override // cn.damai.player.listener.OnPlayerUTReportListener
        public void playStart(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1201096213")) {
                ipChange.ipc$dispatch("-1201096213", new Object[]{this, str});
            }
        }

        @Override // cn.damai.player.listener.OnPlayerUTReportListener
        public void returnSmallScreen(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1527596950")) {
                ipChange.ipc$dispatch("1527596950", new Object[]{this, str});
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public class b implements IVideoAdapter.OnVideoItemClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // cn.damai.tetris.component.home.adapter.IVideoAdapter.OnVideoItemClickListener
        public void onBuyClick(int i, String str, String str2, String str3) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1720803846")) {
                ipChange.ipc$dispatch("1720803846", new Object[]{this, Integer.valueOf(i), str, str2, str3});
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("from_page", "homepage");
            bundle.putString("projectImage", str2);
            bundle.putString("id", str3);
            if (wh2.j(str)) {
                DMNav.from(VideoViewHolder.this.mContext).withExtras(bundle).toUri(NavUri.b(cs.b));
            } else {
                DMNav.from(VideoViewHolder.this.mContext).toUri(str);
            }
            oy0.B().u(VideoViewHolder.this.mTrackInfo, str3, i);
        }

        @Override // cn.damai.tetris.component.home.adapter.IVideoAdapter.OnVideoItemClickListener
        public void onItemClick(View view, int i, HomePageVideoBean.HomePageVideoItem homePageVideoItem) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-665594949")) {
                ipChange.ipc$dispatch("-665594949", new Object[]{this, view, Integer.valueOf(i), homePageVideoItem});
                return;
            }
            VideoViewHolder.this.mProjectId = homePageVideoItem.projectId;
            VideoViewHolder videoViewHolder = VideoViewHolder.this;
            videoViewHolder.mIndex = i;
            if (videoViewHolder.mVideoPlayer != null) {
                VideoInfo videoInfo = HomePageVideoBean.getVideoInfo(homePageVideoItem);
                VideoViewHolder.this.mController.setClickByUser(true);
                VideoViewHolder.this.mVideoInfo = videoInfo;
                VideoViewHolder.this.mVideoPlayer.setVideoData(videoInfo);
            }
            qz1.a(VideoViewHolder.this.mContext, VideoViewHolder.this.mProjectList, view);
            oy0.B().v(VideoViewHolder.this.mTrackInfo, homePageVideoItem.projectId, i);
            VideoViewHolder.this.initUserHeaderPic(homePageVideoItem);
        }

        @Override // cn.damai.tetris.component.home.adapter.IVideoAdapter.OnVideoItemClickListener
        public void onItemReClick(int i, String str, String str2, String str3) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "960305206")) {
                ipChange.ipc$dispatch("960305206", new Object[]{this, Integer.valueOf(i), str, str2, str3});
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("from_page", "homepage");
            bundle.putString("projectImage", str2);
            bundle.putString("id", str3);
            if (wh2.j(str)) {
                DMNav.from(VideoViewHolder.this.mContext).withExtras(bundle).toUri(NavUri.b(cs.b));
            } else {
                DMNav.from(VideoViewHolder.this.mContext).toUri(str);
            }
            oy0.B().i(VideoViewHolder.this.mTrackInfo, str3, i);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public class c implements View.OnAttachStateChangeListener {
        private static transient /* synthetic */ IpChange $ipChange;

        c() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-486299832")) {
                ipChange.ipc$dispatch("-486299832", new Object[]{this, view});
                return;
            }
            if (VideoViewHolder.this.mVideoPlayer != null) {
                VideoViewHolder.this.mVideoPlayer.autoPlay();
            }
            HomeData.isVideoPlayerVisibility = true;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "940800453")) {
                ipChange.ipc$dispatch("940800453", new Object[]{this, view});
                return;
            }
            if (VideoViewHolder.this.mVideoPlayer != null) {
                VideoViewHolder.this.mVideoPlayer.pause(false);
            }
            HomeData.isVideoPlayerVisibility = false;
        }
    }

    public VideoViewHolder(View view) {
        super(view);
        this.mOnPlayerUTReportListener = new a();
        this.mOnVideoItemClickListener = new b();
        this.reset = true;
        this.mContext = view.getContext();
        this.mModuleTitle = (TextView) this.itemView.findViewById(R$id.homepage_module_title_label);
        this.mVideoPlayer = (DMVideoPlayer) this.itemView.findViewById(R$id.homepage_video_player);
        this.mTitleLayout = this.itemView.findViewById(R$id.module_title_layout);
        this.mVideoCover = this.itemView.findViewById(R$id.homepage_video_cover);
        this.userAvatar = this.itemView.findViewById(R$id.single_user_layout);
        this.mProjectList = (RecyclerView) this.itemView.findViewById(R$id.homepage_video_project_list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.mContext);
        linearLayoutManager.setOrientation(0);
        this.mProjectList.setLayoutManager(linearLayoutManager);
        this.mProjectList.addItemDecoration(new RankItemDividerDecoration(15, 9));
        getVideoAdapter();
        this.mAdapter.setOnVideoItemClickListener(this.mOnVideoItemClickListener);
        this.mProjectList.setAdapter((RecyclerView.Adapter) this.mAdapter);
        DMVideoPlayerHomeController dMVideoPlayerHomeController = new DMVideoPlayerHomeController(this.mContext);
        this.mController = dMVideoPlayerHomeController;
        dMVideoPlayerHomeController.setBottomPadding(t60.a(this.mContext, 22.0f));
        this.mController.enableAutoVoice(this.mContext);
        this.mController.setAutoReport(true);
        this.mController.setSpmData("category_livehouse", "live");
        this.mVideoPlayer.setController(this.mController);
        this.mController.setUTReportListener(this.mOnPlayerUTReportListener);
        fixVideoHeight();
        this.itemView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.mVideoPlayer.addOnAttachStateChangeListener(new c());
    }

    protected void fixVideoHeight() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1321136031")) {
            ipChange.ipc$dispatch("-1321136031", new Object[]{this});
            return;
        }
        int c2 = qx2.c();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mVideoCover.getLayoutParams();
        layoutParams.topMargin = c2;
        this.mVideoCover.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mProjectList.getLayoutParams();
        layoutParams2.topMargin = c2 - t60.a(this.mContext, 22.0f);
        this.mProjectList.setLayoutParams(layoutParams2);
    }

    protected void getVideoAdapter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-518752430")) {
            ipChange.ipc$dispatch("-518752430", new Object[]{this});
        } else {
            this.mAdapter = new VideoAdapter();
        }
    }

    public DMVideoPlayer getVideoPlayer() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "358378297") ? (DMVideoPlayer) ipChange.ipc$dispatch("358378297", new Object[]{this}) : this.mVideoPlayer;
    }

    protected void initUserHeaderPic(HomePageVideoBean.HomePageVideoItem homePageVideoItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1411634070")) {
            ipChange.ipc$dispatch("-1411634070", new Object[]{this, homePageVideoItem});
        }
    }

    @Override // cn.damai.tetris.mvp.CommonViewHolder
    public void setData(CommonBean commonBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "942689057")) {
            ipChange.ipc$dispatch("942689057", new Object[]{this, commonBean});
        } else if (commonBean != null && (commonBean instanceof HomePageVideoBean)) {
            this.mTrackInfo = commonBean.trackInfo;
            HomePageVideoBean homePageVideoBean = (HomePageVideoBean) commonBean;
            String str = homePageVideoBean.mainTitle;
            this.moduleTitle = str;
            if (TextUtils.isEmpty(str)) {
                this.mTitleLayout.setVisibility(8);
            } else {
                this.mTitleLayout.setVisibility(0);
                this.mModuleTitle.setText(homePageVideoBean.mainTitle);
            }
            int e = wh2.e(homePageVideoBean.content);
            for (int i = 0; i < e; i++) {
                homePageVideoBean.content.get(i).isPlay = false;
            }
            if (e > 0) {
                if (this.reset) {
                    this.mIndex = 0;
                } else {
                    int i2 = this.mIndex;
                    if (i2 >= e) {
                        i2 = 0;
                    }
                    this.mIndex = i2;
                }
                HomePageVideoBean.HomePageVideoItem homePageVideoItem = homePageVideoBean.content.get(this.mIndex);
                this.mProjectId = homePageVideoItem.projectId;
                homePageVideoItem.isPlay = true;
                VideoInfo videoInfo = HomePageVideoBean.getVideoInfo(homePageVideoItem);
                DMVideoPlayerHomeController dMVideoPlayerHomeController = this.mController;
                if (dMVideoPlayerHomeController != null) {
                    dMVideoPlayerHomeController.mute();
                    this.mController.setClickByUser(false);
                }
                this.mVideoInfo = videoInfo;
                this.mVideoPlayer.setVideoData(videoInfo);
                oy0.B().O(this.mTrackInfo, this.mVideoPlayer, videoInfo, homePageVideoItem.projectId);
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(homePageVideoBean.content);
            this.mAdapter.reset(this.reset);
            this.mAdapter.setData(this.moduleTitle, arrayList, this.mTrackInfo);
            Log.d("animationx", " ===== setdata : ");
            initUserHeaderPic((HomePageVideoBean.HomePageVideoItem) arrayList.get(this.mIndex));
        }
    }

    @Override // cn.damai.tetris.mvp.CommonViewHolder
    public void setMessage(int i, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1183977142")) {
            ipChange.ipc$dispatch("1183977142", new Object[]{this, Integer.valueOf(i), obj});
            return;
        }
        switch (i) {
            case 11001:
                if (obj instanceof Boolean) {
                    boolean booleanValue = ((Boolean) obj).booleanValue();
                    this.isShow = booleanValue;
                    if (booleanValue) {
                        videoPlay();
                        return;
                    } else {
                        videoPause();
                        return;
                    }
                }
                return;
            case 11002:
                if (this.isShow) {
                    videoPlay();
                    return;
                }
                return;
            case 11003:
                videoPause();
                return;
            case 11004:
                videoDestory();
                return;
            case 11005:
                videoPlay();
                return;
            default:
                return;
        }
    }

    public void setReset(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1046536115")) {
            ipChange.ipc$dispatch("1046536115", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.reset = z;
        }
    }

    public void startVideoBrowseActivity(String str, ArrayList<VideoInfo> arrayList, ArrayList<PicInfo> arrayList2, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1779587491")) {
            ipChange.ipc$dispatch("-1779587491", new Object[]{this, str, arrayList, arrayList2, Integer.valueOf(i)});
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("projectId", str);
        bundle.putParcelableArrayList("video_info", arrayList);
        bundle.putParcelableArrayList("pic_info", arrayList2);
        bundle.putInt("position", i);
        DMNav.from(this.mContext).withExtras(bundle).toUri(NavUri.b("videobrowse"));
    }

    public void videoDestory() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1238433483")) {
            ipChange.ipc$dispatch("-1238433483", new Object[]{this});
            return;
        }
        DMVideoPlayer dMVideoPlayer = this.mVideoPlayer;
        if (dMVideoPlayer != null) {
            dMVideoPlayer.release();
            this.mController.destroy();
            this.mController.setPlayer(null);
            this.mController = null;
        }
    }

    public void videoPause() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "341307923")) {
            ipChange.ipc$dispatch("341307923", new Object[]{this});
        } else if (this.mVideoPlayer != null) {
            this.mController.setClickByUser(false);
            this.mVideoPlayer.pause(false);
        }
    }

    public void videoPlay() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1138864365")) {
            ipChange.ipc$dispatch("1138864365", new Object[]{this});
            return;
        }
        DMVideoPlayer dMVideoPlayer = this.mVideoPlayer;
        if (dMVideoPlayer != null) {
            dMVideoPlayer.autoPlay();
            DMVideoPlayerHomeController dMVideoPlayerHomeController = this.mController;
            if (dMVideoPlayerHomeController != null) {
                dMVideoPlayerHomeController.mute();
            }
        }
    }
}
