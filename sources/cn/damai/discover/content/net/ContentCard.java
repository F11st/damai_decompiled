package cn.damai.discover.content.net;

import android.text.TextUtils;
import cn.damai.comment.bean.StoreInfo;
import cn.damai.discover.content.bean.ContentTour;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.HashSet;
import tb.cb2;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class ContentCard implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public ArtistBrandWrap artist;
    public IpInfoWrap ipInfo;
    public ContentTour itemInfo;
    public StoreInfo storeInfo;
    public String targetId;
    public String targetType;
    public String title;
    public String type;

    public boolean isArtistBrandRelateCard() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-49849028")) {
            return ((Boolean) ipChange.ipc$dispatch("-49849028", new Object[]{this})).booleanValue();
        }
        HashSet hashSet = new HashSet();
        hashSet.add("3");
        hashSet.add("4");
        hashSet.add("5");
        return hashSet.contains(this.type);
    }

    public boolean isDramaRelateCard() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2876491") ? ((Boolean) ipChange.ipc$dispatch("-2876491", new Object[]{this})).booleanValue() : TextUtils.equals("1", this.type);
    }

    public boolean isHasBody() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1742506839")) {
            return ((Boolean) ipChange.ipc$dispatch("-1742506839", new Object[]{this})).booleanValue();
        }
        if (!TextUtils.isEmpty(this.type)) {
            ContentTour contentTour = this.itemInfo;
            if (contentTour != null && contentTour.itemInfo != null) {
                return true;
            }
            ArtistBrandWrap artistBrandWrap = this.artist;
            if (artistBrandWrap != null && !cb2.d(artistBrandWrap.artistItem)) {
                return true;
            }
            IpInfoWrap ipInfoWrap = this.ipInfo;
            if (ipInfoWrap != null && ipInfoWrap.ipInfo != null) {
                return true;
            }
        }
        return false;
    }

    public boolean isProjectRelateCard() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1966811459") ? ((Boolean) ipChange.ipc$dispatch("1966811459", new Object[]{this})).booleanValue() : TextUtils.equals("2", this.type);
    }

    public boolean isStoreCard() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1965198676") ? ((Boolean) ipChange.ipc$dispatch("1965198676", new Object[]{this})).booleanValue() : TextUtils.equals("6", this.type);
    }

    public boolean isTourTitleType() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1886767093") ? ((Boolean) ipChange.ipc$dispatch("-1886767093", new Object[]{this})).booleanValue() : TextUtils.equals("3", this.type);
    }
}
