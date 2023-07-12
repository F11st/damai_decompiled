package cn.damai.tetris.component.home.viewholder;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewParent;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.imagebrowse.bean.PicInfo;
import cn.damai.commonbusiness.imagebrowse.bean.VideoInfo;
import cn.damai.player.video.ProxyVideoView;
import cn.damai.player.video.listener.VideoListener;
import cn.damai.player.video.opt.MultiConditionPlayOptHelper;
import cn.damai.player.video.view.ApiPlayer;
import cn.damai.tetris.component.home.adapter.IVideoAdapter;
import cn.damai.tetris.component.home.adapter.VideoAdapter;
import cn.damai.tetris.component.home.bean.HomePageVideoBean;
import cn.damai.tetris.component.home.utils.RankItemDividerDecoration;
import cn.damai.tetris.core.NodeData;
import cn.damai.tetris.core.TrackInfo;
import cn.damai.tetris.mvp.CommonBean;
import cn.damai.tetris.mvp.CommonViewHolder;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.cs;
import tb.oy0;
import tb.qz1;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class VideoViewHolderV2 extends CommonViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    private boolean isPageShowing;
    private boolean isSetVideoPlayOptHelper;
    private IVideoAdapter mAdapter;
    private Context mContext;
    private int mIndex;
    private TextView mModuleTitle;
    private IVideoAdapter.OnVideoItemClickListener mOnVideoItemClickListener;
    private MultiConditionPlayOptHelper mOptHelper;
    private String mProjectId;
    private RecyclerView mProjectList;
    private View mTitleLayout;
    private TrackInfo mTrackInfo;
    private VideoInfo mVideoInfo;
    private ProxyVideoView mVideoPlayer;

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public class a implements IVideoAdapter.OnVideoItemClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // cn.damai.tetris.component.home.adapter.IVideoAdapter.OnVideoItemClickListener
        public void onBuyClick(int i, String str, String str2, String str3) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-115585205")) {
                ipChange.ipc$dispatch("-115585205", new Object[]{this, Integer.valueOf(i), str, str2, str3});
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("from_page", "homepage");
            bundle.putString("projectImage", str2);
            bundle.putString("id", str3);
            if (wh2.j(str)) {
                DMNav.from(VideoViewHolderV2.this.mContext).withExtras(bundle).toUri(NavUri.b(cs.b));
            } else {
                DMNav.from(VideoViewHolderV2.this.mContext).toUri(str);
            }
            oy0.B().u(VideoViewHolderV2.this.mTrackInfo, str3, i);
        }

        @Override // cn.damai.tetris.component.home.adapter.IVideoAdapter.OnVideoItemClickListener
        public void onItemClick(View view, int i, HomePageVideoBean.HomePageVideoItem homePageVideoItem) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "295318230")) {
                ipChange.ipc$dispatch("295318230", new Object[]{this, view, Integer.valueOf(i), homePageVideoItem});
                return;
            }
            VideoViewHolderV2.this.mProjectId = homePageVideoItem.projectId;
            VideoViewHolderV2.this.mIndex = i;
            if (VideoViewHolderV2.this.mVideoPlayer != null) {
                VideoInfo videoInfo = HomePageVideoBean.getVideoInfo(homePageVideoItem);
                VideoViewHolderV2.this.mVideoInfo = videoInfo;
                VideoViewHolderV2.this.mVideoPlayer.play(videoInfo);
                oy0.B().O(VideoViewHolderV2.this.mTrackInfo, VideoViewHolderV2.this.mVideoPlayer, videoInfo, VideoViewHolderV2.this.mProjectId);
            }
            qz1.a(VideoViewHolderV2.this.mContext, VideoViewHolderV2.this.mProjectList, view);
            oy0.B().v(VideoViewHolderV2.this.mTrackInfo, homePageVideoItem.projectId, i);
        }

        @Override // cn.damai.tetris.component.home.adapter.IVideoAdapter.OnVideoItemClickListener
        public void onItemReClick(int i, String str, String str2, String str3) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1907463983")) {
                ipChange.ipc$dispatch("-1907463983", new Object[]{this, Integer.valueOf(i), str, str2, str3});
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("from_page", "homepage");
            bundle.putString("projectImage", str2);
            bundle.putString("id", str3);
            if (wh2.j(str)) {
                DMNav.from(VideoViewHolderV2.this.mContext).withExtras(bundle).toUri(NavUri.b(cs.b));
            } else {
                DMNav.from(VideoViewHolderV2.this.mContext).toUri(str);
            }
            oy0.B().i(VideoViewHolderV2.this.mTrackInfo, str3, i);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public class b implements View.OnAttachStateChangeListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1162728333")) {
                ipChange.ipc$dispatch("1162728333", new Object[]{this, view});
            } else if (VideoViewHolderV2.this.isSetVideoPlayOptHelper) {
            } else {
                ViewParent parent = VideoViewHolderV2.this.itemView.getParent();
                if (parent instanceof RecyclerView) {
                    VideoViewHolderV2.this.isSetVideoPlayOptHelper = true;
                    VideoViewHolderV2 videoViewHolderV2 = VideoViewHolderV2.this;
                    videoViewHolderV2.mOptHelper = new MultiConditionPlayOptHelper((RecyclerView) parent, videoViewHolderV2.itemView, videoViewHolderV2.mVideoPlayer);
                    VideoViewHolderV2.this.mVideoPlayer.setOptHelper(VideoViewHolderV2.this.mOptHelper);
                }
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "813934794")) {
                ipChange.ipc$dispatch("813934794", new Object[]{this, view});
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public class c implements VideoListener {
        private static transient /* synthetic */ IpChange $ipChange;

        c() {
        }

        @Override // cn.damai.player.video.listener.VideoOperateListener
        public void onMuteClick(VideoInfo videoInfo, boolean z) {
            String videoUrl;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1294266815")) {
                ipChange.ipc$dispatch("-1294266815", new Object[]{this, videoInfo, Boolean.valueOf(z)});
            } else if (videoInfo != null) {
                if (VideoInfo.VideoType.VIDEO_VID == videoInfo.getType()) {
                    videoUrl = videoInfo.getVid();
                } else {
                    videoUrl = videoInfo.getVideoUrl();
                }
                oy0.B().x(VideoViewHolderV2.this.mTrackInfo, videoUrl, !z ? 1 : 0);
            }
        }

        @Override // cn.damai.player.video.listener.VideoOperateListener
        public void onPlayClick(VideoInfo videoInfo) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "93038990")) {
                ipChange.ipc$dispatch("93038990", new Object[]{this, videoInfo});
            } else if (VideoViewHolderV2.this.mVideoInfo == null) {
            } else {
                ArrayList<VideoInfo> arrayList = new ArrayList<>();
                arrayList.add(VideoViewHolderV2.this.mVideoInfo);
                ArrayList<PicInfo> arrayList2 = new ArrayList<>();
                VideoViewHolderV2 videoViewHolderV2 = VideoViewHolderV2.this;
                videoViewHolderV2.startVideoBrowseActivity(videoViewHolderV2.mProjectId, arrayList, arrayList2, 0);
                if (VideoViewHolderV2.this.mTrackInfo != null) {
                    oy0.B().w(VideoViewHolderV2.this.mTrackInfo, VideoViewHolderV2.this.mVideoInfo.getVid(), VideoViewHolderV2.this.mProjectId, VideoViewHolderV2.this.mIndex);
                }
            }
        }

        @Override // cn.damai.player.video.listener.VideoEventListener
        public void onVideoEnd(ApiPlayer apiPlayer, VideoInfo videoInfo, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "358613952")) {
                ipChange.ipc$dispatch("358613952", new Object[]{this, apiPlayer, videoInfo, Integer.valueOf(i)});
            } else if (VideoViewHolderV2.this.mTrackInfo == null) {
            } else {
                oy0.B().P(VideoViewHolderV2.this.mTrackInfo.trackB, VideoViewHolderV2.this.mTrackInfo.trackC, "playend", VideoViewHolderV2.this.mProjectId, videoInfo, i, apiPlayer.getSessionId());
            }
        }

        @Override // cn.damai.player.video.listener.VideoEventListener
        public void onVideoPlay(ApiPlayer apiPlayer, VideoInfo videoInfo, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-480579815")) {
                ipChange.ipc$dispatch("-480579815", new Object[]{this, apiPlayer, videoInfo, Integer.valueOf(i)});
            } else if (VideoViewHolderV2.this.mTrackInfo == null) {
            } else {
                oy0.B().Q(VideoViewHolderV2.this.mTrackInfo.trackB, VideoViewHolderV2.this.mTrackInfo.trackC, "playstart", VideoViewHolderV2.this.mProjectId, videoInfo, true, VideoViewHolderV2.this.mVideoPlayer.getSessionId());
            }
        }
    }

    public VideoViewHolderV2(View view) {
        super(view);
        this.isPageShowing = true;
        this.isSetVideoPlayOptHelper = false;
        this.mOnVideoItemClickListener = new a();
        this.mContext = view.getContext();
        this.mModuleTitle = (TextView) this.itemView.findViewById(R$id.homepage_module_title_label);
        this.mVideoPlayer = (ProxyVideoView) this.itemView.findViewById(R$id.homepage_video_player_v2);
        this.itemView.addOnAttachStateChangeListener(new b());
        this.mTitleLayout = this.itemView.findViewById(R$id.module_title_layout);
        this.mProjectList = (RecyclerView) this.itemView.findViewById(R$id.homepage_video_project_list_v2);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.mContext);
        linearLayoutManager.setOrientation(0);
        this.mProjectList.setLayoutManager(linearLayoutManager);
        this.mProjectList.addItemDecoration(new RankItemDividerDecoration(15, 9));
        VideoAdapter videoAdapter = new VideoAdapter();
        this.mAdapter = videoAdapter;
        videoAdapter.setOnVideoItemClickListener(this.mOnVideoItemClickListener);
        this.mProjectList.setAdapter((RecyclerView.Adapter) this.mAdapter);
        this.mVideoPlayer.setListener(new c());
    }

    @Override // cn.damai.tetris.mvp.CommonViewHolder
    public void rebind(NodeData nodeData) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1937767942")) {
            ipChange.ipc$dispatch("1937767942", new Object[]{this, nodeData});
        } else {
            Log.d("rebind", " ===== video viewholder : ");
        }
    }

    @Override // cn.damai.tetris.mvp.CommonViewHolder
    public boolean rebindAble() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "441573604")) {
            return ((Boolean) ipChange.ipc$dispatch("441573604", new Object[]{this})).booleanValue();
        }
        return true;
    }

    @Override // cn.damai.tetris.mvp.CommonViewHolder
    protected void setData(CommonBean commonBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-620115131")) {
            ipChange.ipc$dispatch("-620115131", new Object[]{this, commonBean});
        } else if (commonBean instanceof HomePageVideoBean) {
            this.mTrackInfo = commonBean.trackInfo;
            HomePageVideoBean homePageVideoBean = (HomePageVideoBean) commonBean;
            String str = homePageVideoBean.mainTitle;
            if (TextUtils.isEmpty(str)) {
                this.mTitleLayout.setVisibility(8);
            } else {
                this.mTitleLayout.setVisibility(0);
                this.mModuleTitle.setText(homePageVideoBean.mainTitle);
            }
            List<HomePageVideoBean.HomePageVideoItem> list = homePageVideoBean.content;
            int e = wh2.e(list);
            for (int i = 0; i < e; i++) {
                list.get(i).isPlay = false;
            }
            ArrayList arrayList = new ArrayList();
            if (e > 0) {
                this.mIndex = 0;
                HomePageVideoBean.HomePageVideoItem homePageVideoItem = list.get(0);
                this.mProjectId = homePageVideoItem.projectId;
                homePageVideoItem.isPlay = true;
                VideoInfo videoInfo = HomePageVideoBean.getVideoInfo(homePageVideoItem);
                this.mVideoInfo = videoInfo;
                this.mVideoPlayer.setVideoInfo(videoInfo);
                this.mVideoPlayer.autoPlay();
                arrayList.addAll(list);
                oy0.B().O(this.mTrackInfo, this.mVideoPlayer, videoInfo, homePageVideoItem.projectId);
            }
            this.mAdapter.setData(str, arrayList, this.mTrackInfo);
        }
    }

    @Override // cn.damai.tetris.mvp.CommonViewHolder
    public void setMessage(int i, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-878531622")) {
            ipChange.ipc$dispatch("-878531622", new Object[]{this, Integer.valueOf(i), obj});
            return;
        }
        switch (i) {
            case 11001:
                if (obj instanceof Boolean) {
                    boolean booleanValue = ((Boolean) obj).booleanValue();
                    this.isPageShowing = booleanValue;
                    MultiConditionPlayOptHelper multiConditionPlayOptHelper = this.mOptHelper;
                    if (multiConditionPlayOptHelper != null) {
                        multiConditionPlayOptHelper.a(booleanValue);
                    }
                    if (this.isPageShowing) {
                        this.mVideoPlayer.start();
                        return;
                    } else {
                        this.mVideoPlayer.pause();
                        return;
                    }
                }
                return;
            case 11002:
            default:
                return;
            case 11003:
                MultiConditionPlayOptHelper multiConditionPlayOptHelper2 = this.mOptHelper;
                if (multiConditionPlayOptHelper2 != null) {
                    multiConditionPlayOptHelper2.a(false);
                }
                this.mVideoPlayer.pause();
                return;
            case 11004:
                MultiConditionPlayOptHelper multiConditionPlayOptHelper3 = this.mOptHelper;
                if (multiConditionPlayOptHelper3 != null) {
                    multiConditionPlayOptHelper3.a(false);
                }
                this.mVideoPlayer.release();
                return;
            case 11005:
                MultiConditionPlayOptHelper multiConditionPlayOptHelper4 = this.mOptHelper;
                if (multiConditionPlayOptHelper4 != null) {
                    multiConditionPlayOptHelper4.a(true);
                }
                if (this.isPageShowing) {
                    this.mVideoPlayer.start();
                    return;
                }
                return;
        }
    }

    public void startVideoBrowseActivity(String str, ArrayList<VideoInfo> arrayList, ArrayList<PicInfo> arrayList2, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1118533759")) {
            ipChange.ipc$dispatch("-1118533759", new Object[]{this, str, arrayList, arrayList2, Integer.valueOf(i)});
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("projectId", str);
        bundle.putParcelableArrayList("video_info", arrayList);
        bundle.putParcelableArrayList("pic_info", arrayList2);
        bundle.putInt("position", i);
        DMNav.from(this.mContext).withExtras(bundle).toUri(NavUri.b("videobrowse"));
    }
}
