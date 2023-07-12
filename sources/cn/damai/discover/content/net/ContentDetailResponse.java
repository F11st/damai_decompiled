package cn.damai.discover.content.net;

import cn.damai.discover.content.bean.ContentCommentList;
import cn.damai.discover.content.bean.ContentDetail;
import cn.damai.discover.content.bean.ContentRecommendList;
import cn.damai.discover.content.bean.ContentShareInfo;
import cn.damai.discover.content.bean.ContentTour;
import cn.damai.discover.content.bean.RelatedBrandOrArtist;
import cn.damai.tetris.component.drama.bean.DramaV1Bean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class ContentDetailResponse implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public ContentCard card;
    public CliqueInfo cliqueInfo;
    public ContentCommentList commentList;
    public ContentDetail contentDetail;
    public String goDnaUrl;
    public boolean myself;
    public ContentRecommendList recommendList;
    public ContentShareInfo shareInfo;
    public String similarity;
    public ContentTour.ContentTopic themeInfo;

    public List<RelatedBrandOrArtist> getArtistItem() {
        ArtistBrandWrap artistBrandWrap;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1111701570")) {
            return (List) ipChange.ipc$dispatch("1111701570", new Object[]{this});
        }
        ContentCard contentCard = this.card;
        if (contentCard == null || (artistBrandWrap = contentCard.artist) == null) {
            return null;
        }
        return artistBrandWrap.artistItem;
    }

    public DramaV1Bean getIpInfo() {
        IpInfoWrap ipInfoWrap;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-126274317")) {
            return (DramaV1Bean) ipChange.ipc$dispatch("-126274317", new Object[]{this});
        }
        ContentCard contentCard = this.card;
        if (contentCard == null || (ipInfoWrap = contentCard.ipInfo) == null) {
            return null;
        }
        return ipInfoWrap.ipInfo;
    }

    public ContentTour getItemInfo() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1726943892")) {
            return (ContentTour) ipChange.ipc$dispatch("1726943892", new Object[]{this});
        }
        ContentCard contentCard = this.card;
        if (contentCard != null) {
            return contentCard.itemInfo;
        }
        return null;
    }
}
