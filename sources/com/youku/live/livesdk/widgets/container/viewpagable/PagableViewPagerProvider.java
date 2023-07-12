package com.youku.live.livesdk.widgets.container.viewpagable;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewpager.widget.ViewPager;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.livesdk.widgets.container.interfaces.PagableViewProvider;
import com.youku.live.livesdk.widgets.container.pagable.LiveContentView;
import com.youku.live.livesdk.widgets.container.pager.model.SwitchItemModel;
import com.youku.live.livesdk.widgets.helper.Accessor;
import com.youku.live.livesdk.widgets.helper.Caller;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class PagableViewPagerProvider implements PagableViewProvider<SwitchItemModel, LiveContentView> {
    private static transient /* synthetic */ IpChange $ipChange;
    private FrameLayout mContentView;
    private List<SwitchItemModel> mItemList;
    private PagableAdapter pagableAdapter = new PagableAdapter();
    private ViewPager viewPager;

    public PagableViewPagerProvider(Context context) {
        this.mContentView = new FrameLayout(context);
        VerticalViewPager verticalViewPager = new VerticalViewPager(context);
        this.viewPager = verticalViewPager;
        verticalViewPager.setAdapter(this.pagableAdapter);
        this.viewPager.setOnPageChangeListener(this.pagableAdapter);
        this.mContentView.addView(this.viewPager, new ViewGroup.LayoutParams(-1, -1));
    }

    @Override // com.youku.live.livesdk.widgets.container.interfaces.PagableViewProvider
    public void addOnPagingLifecycleListener(PagableViewProvider.OnPagingLifecycleListener<SwitchItemModel, LiveContentView> onPagingLifecycleListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1532391145")) {
            ipChange.ipc$dispatch("-1532391145", new Object[]{this, onPagingLifecycleListener});
        }
    }

    @Override // com.youku.live.livesdk.widgets.container.interfaces.PagableViewProvider
    public <Params, RetValue> RetValue callActiveView(Caller<LiveContentView, Params, RetValue> caller, Params params, RetValue retvalue) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1443219310") ? (RetValue) ipChange.ipc$dispatch("-1443219310", new Object[]{this, caller, params, retvalue}) : caller.onCall(this.pagableAdapter.getContentViewByIndex(this.viewPager.getCurrentItem()), params);
    }

    @Override // com.youku.live.livesdk.widgets.container.interfaces.PagableViewProvider
    public View getContentView() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2114255464") ? (View) ipChange.ipc$dispatch("-2114255464", new Object[]{this}) : this.mContentView;
    }

    @Override // com.youku.live.livesdk.widgets.container.interfaces.PagableViewProvider
    public void notifyActiveView(Accessor<LiveContentView> accessor) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "950327201")) {
            ipChange.ipc$dispatch("950327201", new Object[]{this, accessor});
        } else {
            accessor.onAccess(this.pagableAdapter.getContentViewByIndex(this.viewPager.getCurrentItem()));
        }
    }

    @Override // com.youku.live.livesdk.widgets.container.interfaces.PagableViewProvider
    public void notifyAllViews(Accessor<LiveContentView> accessor) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1792401887")) {
            ipChange.ipc$dispatch("1792401887", new Object[]{this, accessor});
        } else {
            this.pagableAdapter.notifyAllViews(accessor);
        }
    }

    @Override // com.youku.live.livesdk.widgets.container.interfaces.PagableViewProvider
    public void setDataList(List<SwitchItemModel> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-770238221")) {
            ipChange.ipc$dispatch("-770238221", new Object[]{this, list});
            return;
        }
        this.mItemList = list;
        this.pagableAdapter.setDataList(list);
        updateDataList();
    }

    @Override // com.youku.live.livesdk.widgets.container.interfaces.PagableViewProvider
    public void setLimit(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1355852763")) {
            ipChange.ipc$dispatch("-1355852763", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
        }
    }

    @Override // com.youku.live.livesdk.widgets.container.interfaces.PagableViewProvider
    public void setPagingContentCreator(PagableViewProvider.PagingContentCreator<LiveContentView> pagingContentCreator) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "939669510")) {
            ipChange.ipc$dispatch("939669510", new Object[]{this, pagingContentCreator});
        }
    }

    @Override // com.youku.live.livesdk.widgets.container.interfaces.PagableViewProvider
    public void setRoomSwitch(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-315871911")) {
            ipChange.ipc$dispatch("-315871911", new Object[]{this, Boolean.valueOf(z)});
        }
    }

    @Override // com.youku.live.livesdk.widgets.container.interfaces.PagableViewProvider
    public void updateDataList() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2009544595")) {
            ipChange.ipc$dispatch("-2009544595", new Object[]{this});
        } else {
            this.pagableAdapter.notifyDataSetChanged();
        }
    }
}
