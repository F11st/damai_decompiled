package cn.damai.category.ranksquare.bean;

import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class RankSquareDataHolder {
    public int fans;
    public long id;
    public List<RankSquareGroupItemBean> mLocalItemBeans;
    public boolean mLocalRank;
    public RankSquareListItemBean mRankItem;
    public int mType;
    public String rankSquareName;
    public String rankSquareSubTitle;
    public int rankType;

    public RankSquareDataHolder(int i) {
        this.mType = i;
    }
}
