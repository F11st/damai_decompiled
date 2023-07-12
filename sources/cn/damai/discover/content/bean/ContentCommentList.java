package cn.damai.discover.content.bean;

import android.text.TextUtils;
import cn.damai.commonbusiness.yymember.bean.PerformFilmVipDO;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.ArrayList;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class ContentCommentList implements Serializable {
    public ArrayList<CommentListItem> comments;
    public CommentListItem commentsDO;
    public boolean hasNext;
    public int pageIndex;
    public String sourceId;
    public String sourceType;
    public int totalComment;

    /* compiled from: Taobao */
    /* loaded from: classes14.dex */
    public static class CommentListItem implements Serializable {
        private static transient /* synthetic */ IpChange $ipChange;
        public ArrayList<CommentListItem> appendComments;
        public String commentId;
        public String gmtCreate;
        public int position;
        public CommentPraiseInfo praiseInfo;
        public String publishCityName;
        public ArrayList<TextDO> textDOList;
        public ReplyUserInfo userDO;

        /* compiled from: Taobao */
        /* loaded from: classes14.dex */
        public static class CommentPraiseInfo implements Serializable {
            public String commentId;
            public boolean hasPraised;
            public int position;
            public int praiseCount;
        }

        /* compiled from: Taobao */
        /* loaded from: classes14.dex */
        public static class ReplyUserInfo implements Serializable {
            public String havanaIdStr;
            public String headerImage;
            public String nickname;
            public PerformFilmVipDO performFilmVipDO;
            public String userTag;
            public boolean vip;
            public int vipLevel;
            public String vipLevelIcon;
            public String vtag;
        }

        /* compiled from: Taobao */
        /* loaded from: classes14.dex */
        public static class TextDO implements Serializable {
            public String isRequired;
            public String textId;
            public String value;
        }

        public String getPublishDateAndCity() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2003760324")) {
                return (String) ipChange.ipc$dispatch("-2003760324", new Object[]{this});
            }
            if (TextUtils.isEmpty(this.publishCityName)) {
                return this.gmtCreate;
            }
            return this.gmtCreate + " " + this.publishCityName;
        }
    }
}
