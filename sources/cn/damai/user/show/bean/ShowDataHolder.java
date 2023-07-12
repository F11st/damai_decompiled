package cn.damai.user.show.bean;

import cn.damai.commonbusiness.search.bean.ProjectItemBean;
import cn.damai.commonbusiness.search.bean.RepertoireBean;
import cn.damai.commonbusiness.search.bean.StarBean;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class ShowDataHolder {
    public boolean isRecommendProject;
    public StarBean mArtistBean;
    public String mArtistName;
    public List<String> mHistoryKey;
    public ProjectItemBean mProjectItem;
    public String mRecommendSearchWord;
    public RepertoireBean mRepertoireBean;
    public int mTipType;
    public int mType;

    public ShowDataHolder(int i) {
        this.mType = i;
    }
}
