package cn.damai.search.bean;

import cn.damai.tetris.component.discover.bean.VideoInfo;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import tb.cb2;

/* compiled from: Taobao */
@Deprecated
/* loaded from: classes15.dex */
public class NoteBeanFromSearch implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public List<Content> content;
    public String contentId;
    public List<Image> image;
    public String isFeature;
    public PraiseInfo praiseInfo;
    public String publishTimeStr;
    public String relateTitle;
    public String schema;
    public String sourceId;
    public String sourceType;
    public String subType;
    public UserInfo userInfo;
    public VideoInfo videoInfo;

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public static class Content implements Serializable {
        public String value;
    }

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public static class Image implements Serializable {
        public boolean coverImage;
        public String type;
        public String url;
    }

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public static class PerformFilmVipDO {
        @Deprecated
        public String havanaId;
        public String memberFlag;
    }

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public static class PraiseInfo implements Serializable {
        public boolean hasPraised;
        public String praiseCount;
    }

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public static class UserInfo implements Serializable {
        public boolean focus;
        public String havanaId;
        public String headImg;
        public String id;
        public String nickname;
        public PerformFilmVipDO performFilmVipDO;
        public String targetType;
        public String userTypeCode;
        public String userTypeText;
        public String vip;
    }

    public String getPic() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1041833424")) {
            return (String) ipChange.ipc$dispatch("1041833424", new Object[]{this});
        }
        String str = null;
        if (cb2.d(this.image)) {
            return null;
        }
        Iterator<Image> it = this.image.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Image next = it.next();
            if (next.coverImage) {
                str = next.url;
                break;
            }
        }
        return str == null ? this.image.get(0).url : str;
    }
}
