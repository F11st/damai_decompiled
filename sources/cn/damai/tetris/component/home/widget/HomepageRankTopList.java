package cn.damai.tetris.component.home.widget;

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
import cn.damai.tetris.component.home.adapter.RankTopAdapter;
import cn.damai.tetris.component.home.bean.HomePageRankBean;
import cn.damai.tetris.component.home.utils.RankItemDividerDecoration;
import cn.damai.tetris.core.TrackInfo;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class HomepageRankTopList extends FrameLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<HomePageRankBean.Content.RankLists> mData;
    private int mIndex;
    private RankTopAdapter mRankTopAdapter;
    private View mRankTopPageDivider;
    private RecyclerView mRankTopRecyclerView;
    private String mTabName;
    private TrackInfo mmTrackInfo;

    public HomepageRankTopList(@NonNull Context context) {
        this(context, null);
    }

    private void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1785069337")) {
            ipChange.ipc$dispatch("1785069337", new Object[]{this});
            return;
        }
        LayoutInflater.from(getContext()).inflate(R$layout.homepage_recent_list, this);
        this.mRankTopPageDivider = findViewById(R$id.homepage_recent_page_divider);
        this.mRankTopRecyclerView = (RecyclerView) findViewById(R$id.homepage_recent_recyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(0);
        this.mRankTopRecyclerView.setLayoutManager(linearLayoutManager);
        this.mRankTopRecyclerView.addItemDecoration(new RankItemDividerDecoration(21, 12));
        RankTopAdapter rankTopAdapter = new RankTopAdapter(getContext());
        this.mRankTopAdapter = rankTopAdapter;
        this.mRankTopRecyclerView.setAdapter(rankTopAdapter);
    }

    private void updateData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1779378139")) {
            ipChange.ipc$dispatch("1779378139", new Object[]{this});
            return;
        }
        try {
            this.mRankTopPageDivider.setVisibility(this.mIndex == 0 ? 8 : 0);
            this.mRankTopAdapter.k(this.mTabName, this.mIndex, this.mData, this.mmTrackInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setData(int i, String str, List<HomePageRankBean.Content.RankLists> list, TrackInfo trackInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1540761369")) {
            ipChange.ipc$dispatch("1540761369", new Object[]{this, Integer.valueOf(i), str, list, trackInfo});
            return;
        }
        this.mIndex = i;
        this.mTabName = str;
        this.mData = list;
        this.mmTrackInfo = trackInfo;
        updateData();
    }

    public HomepageRankTopList(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public HomepageRankTopList(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView();
    }
}
