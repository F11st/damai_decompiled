package cn.damai.tetris.component.home.bean;

import android.text.TextUtils;
import cn.damai.commonbusiness.imagebrowse.bean.VideoInfo;
import cn.damai.tetris.mvp.CommonBean;
import cn.damai.uikit.view.LiveRoomView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class HomePageVideoBean extends CommonBean {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final long serialVersionUID = 8224487845474565344L;
    public List<HomePageVideoItem> content;
    public String mainTitle;

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public static class HomePageVideoItem implements Serializable {
        private static transient /* synthetic */ IpChange $ipChange;
        public List<ArtistHeadBean> artistVOS;
        public String categoryName;
        public String contentVideoCoverUrl;
        public String contentVideoUrl;
        public int index;
        public boolean isPlay;
        public String liveStatus;
        public String priceLow;
        public String projectId;
        public String projectName;
        public String projectPic;
        public String schema;
        public String videoId;
        public String videoPic;
        public String videoUrl;

        public LiveRoomView.DMLiveRoomType getLiveType() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2006185595")) {
                return (LiveRoomView.DMLiveRoomType) ipChange.ipc$dispatch("-2006185595", new Object[]{this});
            }
            if (!TextUtils.isEmpty(this.liveStatus)) {
                if (this.liveStatus.equals("2")) {
                    return LiveRoomView.DMLiveRoomType.TAG_TYPE_LIVE;
                }
                if (this.liveStatus.equals("1")) {
                    return LiveRoomView.DMLiveRoomType.TAG_TYPE_DEFAULT;
                }
            }
            return LiveRoomView.DMLiveRoomType.TAG_TYPE_INIT;
        }

        public boolean isLiveRoom() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "224094029")) {
                return ((Boolean) ipChange.ipc$dispatch("224094029", new Object[]{this})).booleanValue();
            }
            if (TextUtils.isEmpty(this.liveStatus)) {
                return false;
            }
            return this.liveStatus.equals("2") || this.liveStatus.equals("1");
        }
    }

    public static VideoInfo getVideoInfo(HomePageVideoItem homePageVideoItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1319608209")) {
            return (VideoInfo) ipChange.ipc$dispatch("-1319608209", new Object[]{homePageVideoItem});
        }
        VideoInfo videoInfo = new VideoInfo();
        if (!TextUtils.isEmpty(homePageVideoItem.contentVideoCoverUrl)) {
            videoInfo.setPicUrl(homePageVideoItem.contentVideoCoverUrl);
        } else {
            videoInfo.setPicUrl(homePageVideoItem.videoPic);
        }
        if (!TextUtils.isEmpty(homePageVideoItem.contentVideoUrl)) {
            videoInfo.setVideoUrl(homePageVideoItem.contentVideoUrl);
            videoInfo.setType(VideoInfo.VideoType.VIDEO_URL);
        } else if (!TextUtils.isEmpty(homePageVideoItem.videoId)) {
            videoInfo.setType(VideoInfo.VideoType.VIDEO_VID);
            videoInfo.setVid(homePageVideoItem.videoId);
        } else if (!TextUtils.isEmpty(homePageVideoItem.videoUrl)) {
            videoInfo.setVideoUrl(homePageVideoItem.videoUrl);
            videoInfo.setType(VideoInfo.VideoType.VIDEO_URL);
        }
        return videoInfo;
    }
}
