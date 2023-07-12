package cn.damai.tetris.component.common;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.tetris.component.common.bean.BaseTabResultItem;
import cn.damai.tetris.component.home.adapter.RankTopAdapter;
import cn.damai.tetris.component.home.adapter.RecentShowAdapter;
import cn.damai.tetris.component.home.bean.HomePageRankBean;
import cn.damai.tetris.component.home.bean.HomePageRecentBean;
import cn.damai.tetris.component.home.utils.RankItemDividerDecoration;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class BaseTabPagerView extends FrameLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private BaseTabResultItem mData;
    private int mIndex;
    private View mRankTopPageDivider;
    private RecyclerView mRankTopRecyclerView;
    private String mTabName;
    private JSONObject mTrackInfo;

    public BaseTabPagerView(@NonNull Context context) {
        this(context, null);
    }

    private void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-666427645")) {
            ipChange.ipc$dispatch("-666427645", new Object[]{this});
            return;
        }
        LayoutInflater.from(getContext()).inflate(R$layout.homepage_recent_list, this);
        this.mRankTopPageDivider = findViewById(R$id.homepage_recent_page_divider);
        this.mRankTopRecyclerView = (RecyclerView) findViewById(R$id.homepage_recent_recyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(0);
        this.mRankTopRecyclerView.setLayoutManager(linearLayoutManager);
        this.mRankTopRecyclerView.addItemDecoration(new RankItemDividerDecoration(21, 12));
    }

    private void updateData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-467143355")) {
            ipChange.ipc$dispatch("-467143355", new Object[]{this});
            return;
        }
        this.mRankTopPageDivider.setVisibility(this.mIndex == 0 ? 8 : 0);
        BaseTabResultItem baseTabResultItem = this.mData;
        if (baseTabResultItem == null || baseTabResultItem.tabList == null) {
            return;
        }
        if (baseTabResultItem.tabType.equals(BaseTabResultItem.CMSTabTypeEnum.RANKING.name())) {
            RankTopAdapter rankTopAdapter = new RankTopAdapter(getContext());
            this.mRankTopRecyclerView.setAdapter(rankTopAdapter);
            try {
                rankTopAdapter.l(this.mTabName, this.mIndex, JSON.parseArray(JSON.toJSONString(this.mData.tabList), HomePageRankBean.Content.RankLists.class), this.mTrackInfo);
                rankTopAdapter.m("item_tabResults_" + this.mIndex + "_tabList_");
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        RecentShowAdapter recentShowAdapter = new RecentShowAdapter(getContext());
        this.mRankTopRecyclerView.setAdapter(recentShowAdapter);
        try {
            List<HomePageRecentBean.Labels.HomePageRecentItems> parseArray = JSON.parseArray(JSON.toJSONString(this.mData.tabList), HomePageRecentBean.Labels.HomePageRecentItems.class);
            recentShowAdapter.n(this.mIndex);
            recentShowAdapter.m(this.mTabName, parseArray, this.mTrackInfo);
            recentShowAdapter.o("item_tabResults_" + this.mIndex + "_tabList_");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void setData(int i, String str, BaseTabResultItem baseTabResultItem, JSONObject jSONObject) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2090264226")) {
            ipChange.ipc$dispatch("2090264226", new Object[]{this, Integer.valueOf(i), str, baseTabResultItem, jSONObject});
            return;
        }
        this.mIndex = i;
        this.mTabName = str;
        this.mData = baseTabResultItem;
        this.mTrackInfo = jSONObject;
        updateData();
    }

    public BaseTabPagerView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BaseTabPagerView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView();
    }
}
