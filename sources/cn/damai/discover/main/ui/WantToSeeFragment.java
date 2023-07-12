package cn.damai.discover.main.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import cn.damai.discover.main.ui.adapter.LivePagerAdapter;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.uikit.irecycler.OnLoadMoreListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
@Deprecated
/* loaded from: classes5.dex */
public class WantToSeeFragment extends Fragment implements OnLoadMoreListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private LivePagerAdapter mPagerAdapter;
    private TextView mRecordBtn;
    private TextView mShowBtn;
    private View mView;
    private ViewPager mViewPager;
    private List<Fragment> mList = new ArrayList();
    private int mCurIndex = 0;

    private void initData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-888428821")) {
            ipChange.ipc$dispatch("-888428821", new Object[]{this});
        }
    }

    private void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1877395952")) {
            ipChange.ipc$dispatch("-1877395952", new Object[]{this});
            return;
        }
        this.mRecordBtn = (TextView) this.mView.findViewById(R$id.tv_record);
        this.mShowBtn = (TextView) this.mView.findViewById(R$id.tv_show);
        this.mViewPager = (ViewPager) this.mView.findViewById(R$id.see_pager);
        FragmentManager childFragmentManager = getChildFragmentManager();
        this.mList.clear();
        SeeRecordFragment seeRecordFragment = new SeeRecordFragment();
        SeeShowFragment seeShowFragment = new SeeShowFragment();
        this.mList.add(seeRecordFragment);
        this.mList.add(seeShowFragment);
        LivePagerAdapter livePagerAdapter = new LivePagerAdapter(childFragmentManager, this.mList);
        this.mPagerAdapter = livePagerAdapter;
        this.mViewPager.setAdapter(livePagerAdapter);
        this.mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: cn.damai.discover.main.ui.WantToSeeFragment.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "12992879")) {
                    ipChange2.ipc$dispatch("12992879", new Object[]{this, Integer.valueOf(i)});
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1364153074")) {
                    ipChange2.ipc$dispatch("-1364153074", new Object[]{this, Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)});
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-801812614")) {
                    ipChange2.ipc$dispatch("-801812614", new Object[]{this, Integer.valueOf(i)});
                } else {
                    WantToSeeFragment.this.mCurIndex = i;
                }
            }
        });
        this.mViewPager.setCurrentItem(this.mCurIndex);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-690949862")) {
            return (View) ipChange.ipc$dispatch("-690949862", new Object[]{this, layoutInflater, viewGroup, bundle});
        }
        this.mView = layoutInflater.inflate(R$layout.live_wanttosee_fragment, (ViewGroup) null);
        initView();
        initData();
        return this.mView;
    }

    @Override // cn.damai.uikit.irecycler.OnLoadMoreListener
    public void onLoadMore(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1366184839")) {
            ipChange.ipc$dispatch("1366184839", new Object[]{this, view});
        }
    }

    public void request(boolean z, boolean z2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-279389450")) {
            ipChange.ipc$dispatch("-279389450", new Object[]{this, Boolean.valueOf(z), Boolean.valueOf(z2)});
        }
    }
}
