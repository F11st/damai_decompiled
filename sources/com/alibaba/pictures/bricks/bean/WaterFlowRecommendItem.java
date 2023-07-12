package com.alibaba.pictures.bricks.bean;

import android.text.TextUtils;
import cn.damai.commonbusiness.search.bean.MarketTabBase;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class WaterFlowRecommendItem extends MarketTabBase {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final long serialVersionUID = -6393508292466552013L;
    public String alg;
    public boolean atmospheric;
    public String atmosphericPic;
    public AttractiveLabel attractiveLabel;
    public String backgroundPic;
    public String brandId;
    public String buttonColor1;
    public String buttonColor2;
    public String buttonText;
    public String cardType;
    public String categoryName;
    public CircleCard circleCard;
    public NoteBean contentCard;
    public String desc;
    public String detailedListId;
    public String giftsAmount;
    public String guideSubCategoryName;
    public boolean hasVideo;
    public List<String> hotwords;
    public String id;
    public int index;
    public String isLastPage;
    public double itemScore;
    public double itemStar;
    public String liveStartTime;
    public int liveStatus;
    public String loadMoreText;
    public String lotteryDate;
    public String name;
    public boolean netWorkException;
    public int pageNum;
    public String pic;
    public String price;
    public String priceLow;
    public String projectDatetime;
    public String projectId;
    public String projectName;
    public String projectPic;
    public String rankType;
    public String schema;
    public String scm;
    public String subTitle;
    public String tag;
    public String tagType;
    public String textColor;
    public ThemeBean themeCard;
    public String title;
    public VoteInfoBean voteCard;

    public String getCategoryNameCompat() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-434149543")) {
            return (String) ipChange.ipc$dispatch("-434149543", new Object[]{this});
        }
        if (!TextUtils.isEmpty(this.guideSubCategoryName)) {
            return this.guideSubCategoryName;
        }
        return this.categoryName;
    }
}
