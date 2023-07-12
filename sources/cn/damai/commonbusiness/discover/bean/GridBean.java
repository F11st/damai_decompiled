package cn.damai.commonbusiness.discover.bean;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import cn.damai.comment.bean.CommentsVideoBean;
import cn.damai.tetris.component.discover.bean.VideoInfo;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import tb.cb2;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class GridBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int TYPE_PIC_URL = 275;
    public static final int TYPE_VIDEO_COVER = 274;
    public static final int TYPE_VIDEO_UNDER_REVIEW = 273;
    public int countRightBottomTag = -1;
    public String formatVideoTime;
    public int itemCount;
    public final String picUrl;
    public final int type;

    public GridBean(int i, String str) {
        this.type = i;
        this.picUrl = str;
    }

    public static void ensureItemCountMemberVar(List<GridBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1545155119")) {
            ipChange.ipc$dispatch("1545155119", new Object[]{list});
        } else if (!cb2.d(list)) {
            int size = list.size();
            for (GridBean gridBean : list) {
                gridBean.itemCount = size;
            }
        }
    }

    @Nullable
    public static List<GridBean> formImgList(List<String> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1481012310")) {
            return (List) ipChange.ipc$dispatch("1481012310", new Object[]{list});
        }
        if (cb2.d(list)) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (String str : list) {
            arrayList.add(new GridBean(TYPE_PIC_URL, str));
        }
        return arrayList;
    }

    public static GridBean fromVideo(CommentsVideoBean commentsVideoBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1396058309")) {
            return (GridBean) ipChange.ipc$dispatch("-1396058309", new Object[]{commentsVideoBean});
        }
        if (commentsVideoBean != null) {
            if (commentsVideoBean.isVideoStatusUnReview()) {
                return new GridBean(TYPE_VIDEO_UNDER_REVIEW, null);
            }
            if (TextUtils.isEmpty(commentsVideoBean.getCoverUrl()) || TextUtils.isEmpty(commentsVideoBean.getUrl())) {
                return null;
            }
            return new GridBean(TYPE_VIDEO_COVER, commentsVideoBean.getCoverUrl());
        }
        return null;
    }

    public static GridBean fromVideo2(VideoInfo videoInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "810646843")) {
            return (GridBean) ipChange.ipc$dispatch("810646843", new Object[]{videoInfo});
        }
        if (videoInfo != null) {
            if (videoInfo.isVideoUnderReviewStatus()) {
                return new GridBean(TYPE_VIDEO_UNDER_REVIEW, null);
            }
            if (TextUtils.isEmpty(videoInfo.coverUrl) || TextUtils.isEmpty(videoInfo.url)) {
                return null;
            }
            GridBean gridBean = new GridBean(TYPE_VIDEO_COVER, videoInfo.coverUrl);
            gridBean.formatVideoTime = videoInfo.formatVideoTime();
            return gridBean;
        }
        return null;
    }
}
