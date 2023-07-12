package com.youku.live.dago.widgetlib.interactive.gift.view.pageview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import androidx.viewpager.widget.ViewPager;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.R;
import com.youku.live.dago.widgetlib.interactive.gift.adapter.CommonAdapter;
import com.youku.live.dago.widgetlib.interactive.gift.adapter.TitleViewPagerAdapter;
import com.youku.live.dago.widgetlib.interactive.gift.bean.GiftInfoBean;
import com.youku.live.dago.widgetlib.interactive.utils.DensityUtil;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.log.ILog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public abstract class GiftBaseView<T> extends LinearLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    protected List<View> dots;
    LinearLayout indicatorLayout;
    public HashMap<CommonAdapter<T>, NoScrollGridView> mCategoryAllAdapterGV;
    private int mCurrentPosition;
    protected List<T> mData;
    protected List<List> mDataList;
    private boolean mIslandscape;
    private OnItemClickInterface mItemClickInterface;
    public int mNumColumns;
    public int mNumRows;
    ViewPager.OnPageChangeListener mOnPageChangeListener;
    public int mPageSize;
    private TitleViewPagerAdapter mViewPagerAdapter;
    ViewPager viewPager;
    protected List<View> viewPagerContentViews;

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public interface OnItemClickInterface<T> {
        void onChildPageChangeListener(int i, List<T> list);

        void onItemClick(AdapterView<?> adapterView, View view, int i, int i2, long j, CommonAdapter<T> commonAdapter);
    }

    public GiftBaseView(Context context) {
        this(context, null);
        initView(context);
    }

    private void initView(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-696400736")) {
            ipChange.ipc$dispatch("-696400736", new Object[]{this, context});
            return;
        }
        setOrientation(1);
        LayoutInflater.from(context).inflate(R.C7942layout.dago_pgc_ykl_indicator_viewpager, (ViewGroup) this, true);
        this.viewPager = (ViewPager) findViewById(R.id.id_vp);
        this.indicatorLayout = (LinearLayout) findViewById(R.id.id_layout_indicator);
    }

    private void notifyDataChange() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1322784486")) {
            ipChange.ipc$dispatch("-1322784486", new Object[]{this});
            return;
        }
        this.viewPagerContentViews.clear();
        ViewPager viewPager = this.viewPager;
        if (viewPager != null && viewPager.getAdapter() != null) {
            this.viewPager.getAdapter().notifyDataSetChanged();
        }
        this.dots.clear();
        this.mDataList.clear();
        this.indicatorLayout.removeAllViews();
        this.mCategoryAllAdapterGV.clear();
        initData();
    }

    protected abstract CommonAdapter<T> getAdapter(List<T> list);

    public List<GiftInfoBean> getCurrentChildPageData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1253337068")) {
            return (List) ipChange.ipc$dispatch("1253337068", new Object[]{this});
        }
        List<List> list = this.mDataList;
        if (list == null || list.size() <= 0 || this.mCurrentPosition >= this.mDataList.size()) {
            return null;
        }
        return this.mDataList.get(this.mCurrentPosition);
    }

    protected abstract List<T> getData();

    public int getPagePosition(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1000637673") ? ((Integer) ipChange.ipc$dispatch("-1000637673", new Object[]{this, Integer.valueOf(i)})).intValue() : i / this.mPageSize;
    }

    protected void initData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "678212867")) {
            ipChange.ipc$dispatch("678212867", new Object[]{this});
            return;
        }
        this.viewPager.setOffscreenPageLimit(4);
        List<T> data = getData();
        ((ILog) Dsl.getService(ILog.class)).i("liulei-prop", "pageList Size = " + data);
        if (data == null || data.size() <= 0) {
            return;
        }
        this.mPageSize = this.mNumColumns * this.mNumRows;
        int size = (data.size() / this.mPageSize) + (data.size() % this.mPageSize == 0 ? 0 : 1);
        if (size == 1) {
            this.indicatorLayout.setVisibility(4);
        } else {
            this.indicatorLayout.setVisibility(0);
        }
        this.mCategoryAllAdapterGV.clear();
        int dip2px = DensityUtil.dip2px(getContext(), 1.0f);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        for (final int i = 0; i < size; i++) {
            NoScrollGridView noScrollGridView = new NoScrollGridView(getContext());
            noScrollGridView.setMotionEventSplittingEnabled(false);
            noScrollGridView.setNumColumns(this.mNumColumns);
            noScrollGridView.setStretchMode(1);
            noScrollGridView.setColumnWidth(dip2px * 82);
            noScrollGridView.setCacheColorHint(0);
            noScrollGridView.setOverScrollMode(2);
            noScrollGridView.setVerticalScrollBarEnabled(false);
            int i2 = dip2px * 3;
            noScrollGridView.setVerticalSpacing(i2);
            noScrollGridView.setHorizontalSpacing(0);
            noScrollGridView.setVerticalScrollBarEnabled(false);
            int i3 = dip2px * 16;
            noScrollGridView.setPadding(i3, i2, i3, dip2px * 0);
            noScrollGridView.setLayoutParams(layoutParams);
            ArrayList arrayList = new ArrayList();
            if (i == size - 1) {
                arrayList.addAll(data.subList(this.mPageSize * i, data.size()));
            } else {
                int i4 = this.mPageSize;
                arrayList.addAll(data.subList(i * i4, (i + 1) * i4));
            }
            this.mDataList.add(arrayList);
            final CommonAdapter<T> adapter = getAdapter(arrayList);
            noScrollGridView.setAdapter((ListAdapter) adapter);
            this.mCategoryAllAdapterGV.put(adapter, noScrollGridView);
            noScrollGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.youku.live.dago.widgetlib.interactive.gift.view.pageview.GiftBaseView.1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // android.widget.AdapterView.OnItemClickListener
                public void onItemClick(AdapterView<?> adapterView, View view, int i5, long j) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1424715869")) {
                        ipChange2.ipc$dispatch("-1424715869", new Object[]{this, adapterView, view, Integer.valueOf(i5), Long.valueOf(j)});
                    } else if (GiftBaseView.this.mItemClickInterface != null) {
                        GiftBaseView.this.mItemClickInterface.onItemClick(adapterView, view, i, i5, j, adapter);
                    }
                }
            });
            this.viewPagerContentViews.add(noScrollGridView);
            View view = new View(getContext());
            int i5 = dip2px * 5;
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(i5, i5);
            int i6 = dip2px * 2;
            layoutParams2.leftMargin = i6;
            layoutParams2.rightMargin = i6;
            view.setLayoutParams(layoutParams2);
            if (i == 0) {
                view.setBackgroundResource(R.C7941drawable.dago_pgc_ykl_indicator_dot_selected);
            } else {
                view.setBackgroundResource(R.C7941drawable.dago_pgc_ykl_indicator_dot_normal);
            }
            this.indicatorLayout.addView(view);
            this.dots.add(view);
        }
        TitleViewPagerAdapter titleViewPagerAdapter = new TitleViewPagerAdapter(this.viewPagerContentViews);
        this.mViewPagerAdapter = titleViewPagerAdapter;
        this.viewPager.setAdapter(titleViewPagerAdapter);
        this.viewPager.addOnPageChangeListener(this.mOnPageChangeListener);
    }

    public void jumpToPosition(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-938725608")) {
            ipChange.ipc$dispatch("-938725608", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        int size = this.dots.size();
        int i2 = this.mCurrentPosition;
        if (size > i2) {
            this.dots.get(i2).setBackgroundResource(R.C7941drawable.dago_pgc_ykl_indicator_dot_normal);
        }
        this.mCurrentPosition = i / this.mPageSize;
        int size2 = this.dots.size();
        int i3 = this.mCurrentPosition;
        if (size2 > i3) {
            this.dots.get(i3).setBackgroundResource(R.C7941drawable.dago_pgc_ykl_indicator_dot_selected);
        }
        if (this.viewPager.getAdapter() != null) {
            int count = this.viewPager.getAdapter().getCount();
            int i4 = this.mCurrentPosition;
            if (count > i4) {
                this.viewPager.setCurrentItem(i4);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "118113970")) {
            ipChange.ipc$dispatch("118113970", new Object[]{this});
        } else {
            super.onDetachedFromWindow();
        }
    }

    protected abstract void reportUT();

    public void setData(List<T> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1759456750")) {
            ipChange.ipc$dispatch("-1759456750", new Object[]{this, list});
            return;
        }
        List<T> list2 = this.mData;
        if (list2 != null) {
            list2.clear();
        }
        this.mData.addAll(list);
        notifyDataChange();
    }

    public void setItemClickInterface(OnItemClickInterface onItemClickInterface) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1357833455")) {
            ipChange.ipc$dispatch("1357833455", new Object[]{this, onItemClickInterface});
        } else {
            this.mItemClickInterface = onItemClickInterface;
        }
    }

    public void setLandscape(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2137117104")) {
            ipChange.ipc$dispatch("-2137117104", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.mIslandscape = z;
        }
    }

    protected void setNumColumns(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1216336945")) {
            ipChange.ipc$dispatch("-1216336945", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.mNumColumns = i;
        }
    }

    protected void setNumRow(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1143982412")) {
            ipChange.ipc$dispatch("1143982412", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.mNumRows = i;
        }
    }

    public void setRowNum(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-526520284")) {
            ipChange.ipc$dispatch("-526520284", new Object[]{this, Integer.valueOf(i)});
        } else {
            setNumRow(i);
        }
    }

    public GiftBaseView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        initView(context);
    }

    public GiftBaseView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mData = new ArrayList();
        this.mCategoryAllAdapterGV = new HashMap<>();
        this.mPageSize = 8;
        this.mNumColumns = 4;
        this.mNumRows = 2;
        this.mIslandscape = false;
        this.viewPagerContentViews = new ArrayList();
        this.dots = new ArrayList();
        this.mDataList = new ArrayList();
        this.mCurrentPosition = 0;
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.youku.live.dago.widgetlib.interactive.gift.view.pageview.GiftBaseView.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-690303946")) {
                    ipChange.ipc$dispatch("-690303946", new Object[]{this, Integer.valueOf(i2)});
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i2, float f, int i3) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1180954325")) {
                    ipChange.ipc$dispatch("1180954325", new Object[]{this, Integer.valueOf(i2), Float.valueOf(f), Integer.valueOf(i3)});
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1636587265")) {
                    ipChange.ipc$dispatch("1636587265", new Object[]{this, Integer.valueOf(i2)});
                    return;
                }
                GiftBaseView giftBaseView = GiftBaseView.this;
                giftBaseView.dots.get(giftBaseView.mCurrentPosition).setBackgroundResource(R.C7941drawable.dago_pgc_ykl_indicator_dot_normal);
                GiftBaseView.this.dots.get(i2).setBackgroundResource(R.C7941drawable.dago_pgc_ykl_indicator_dot_selected);
                GiftBaseView.this.mCurrentPosition = i2;
                if (GiftBaseView.this.mItemClickInterface == null || GiftBaseView.this.mDataList.size() <= i2) {
                    return;
                }
                GiftBaseView.this.mItemClickInterface.onChildPageChangeListener(i2, GiftBaseView.this.mDataList.get(i2));
            }
        };
        initView(context);
    }
}
