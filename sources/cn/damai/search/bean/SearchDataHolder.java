package cn.damai.search.bean;

import cn.damai.commonbusiness.brand.BrandOptimizationDO;
import cn.damai.commonbusiness.search.bean.BaccountInfo;
import cn.damai.commonbusiness.search.bean.ProjectItemBean;
import cn.damai.commonbusiness.search.bean.SearchTourBean;
import cn.damai.search.bean.youku.ArtificialProxy;
import cn.damai.tetris.component.discover.bean.NoteBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class SearchDataHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    public String aaid;
    public List<ArtificialProxy> artificialList;
    public long beginTime;
    public List<SearchDataHolder> foldProjectList;
    public int inputType;
    public boolean isProjectEnded;
    public boolean isRecommendProject;
    public boolean isVisableLine;
    public boolean isYouKuResponse;
    public String keyword;
    public BaccountInfo mAccountInfo;
    public String mArtistName;
    public List<BrandOptimizationDO> mBrandOptimizations;
    public List<String> mHistoryKey;
    public NoteBean mNoteBean;
    public ProjectItemBean mProjectItem;
    public SearchEggs mSearchEggs;
    public SearchFindWordList mSearchFindWordList;
    public SearchSuggest mSuggestWord;
    public int mTipType;
    public int mType;
    public String mUtAaid;
    public List<NoteBean> mWaterFlowContentList;
    public List<ProjectItemBean> mWaterFlowRecommendList;
    public String targetId;
    public SearchTourBean tour;
    public boolean isSectionFirst = false;
    public boolean showDiv = false;
    public boolean isNoteFeed = false;

    public SearchDataHolder(int i) {
        this.mType = i;
    }

    public void addWaterFlowItem(List<NoteBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2000263768")) {
            ipChange.ipc$dispatch("-2000263768", new Object[]{this, list});
            return;
        }
        if (this.mWaterFlowContentList == null) {
            this.mWaterFlowContentList = new ArrayList();
        }
        this.mWaterFlowContentList.addAll(list);
    }
}
