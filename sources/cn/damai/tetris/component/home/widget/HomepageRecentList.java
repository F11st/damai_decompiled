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
import cn.damai.tetris.component.home.adapter.RecentShowAdapter;
import cn.damai.tetris.component.home.bean.HomePageRecentBean;
import cn.damai.tetris.component.home.utils.RankItemDividerDecoration;
import cn.damai.tetris.core.TrackInfo;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class HomepageRecentList extends FrameLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<HomePageRecentBean.Labels.HomePageRecentItems> mData;
    private int mIndex;
    private RecentShowAdapter mRecentAdapter;
    private View mRecentPageDivider;
    private RecyclerView mRecentRecyclerView;
    private String mTabName;
    private TrackInfo mTrackInfo;

    public HomepageRecentList(@NonNull Context context) {
        this(context, null);
    }

    private void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "997908015")) {
            ipChange.ipc$dispatch("997908015", new Object[]{this});
            return;
        }
        LayoutInflater.from(getContext()).inflate(R$layout.homepage_recent_list, this);
        this.mRecentPageDivider = findViewById(R$id.homepage_recent_page_divider);
        this.mRecentRecyclerView = (RecyclerView) findViewById(R$id.homepage_recent_recyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(0);
        this.mRecentRecyclerView.setLayoutManager(linearLayoutManager);
        this.mRecentRecyclerView.addItemDecoration(new RankItemDividerDecoration(21, 12));
        RecentShowAdapter recentShowAdapter = new RecentShowAdapter(getContext());
        this.mRecentAdapter = recentShowAdapter;
        this.mRecentRecyclerView.setAdapter(recentShowAdapter);
    }

    private void updateData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1231591793")) {
            ipChange.ipc$dispatch("1231591793", new Object[]{this});
            return;
        }
        try {
            this.mRecentPageDivider.setVisibility(this.mIndex == 0 ? 8 : 0);
            this.mRecentAdapter.l(this.mTabName, this.mData, this.mTrackInfo, this.mIndex);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setData(int i, String str, ArrayList<HomePageRecentBean.Labels.HomePageRecentItems> arrayList, TrackInfo trackInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "620638754")) {
            ipChange.ipc$dispatch("620638754", new Object[]{this, Integer.valueOf(i), str, arrayList, trackInfo});
            return;
        }
        this.mIndex = i;
        this.mTabName = str;
        this.mData = arrayList;
        this.mTrackInfo = trackInfo;
        updateData();
    }

    public HomepageRecentList(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public HomepageRecentList(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView();
    }
}
