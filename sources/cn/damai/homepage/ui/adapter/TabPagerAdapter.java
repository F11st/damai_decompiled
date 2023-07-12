package cn.damai.homepage.ui.adapter;

import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import cn.damai.category.discountticket.bean.biz.DtParams;
import cn.damai.category.discountticket.ui.DiscountTicketFragment;
import cn.damai.common.AppConfig;
import cn.damai.commonbusiness.home.OnCityChangedListener;
import cn.damai.commonbusiness.home.bean.HomeTabBean;
import cn.damai.dramachannel.fragment.DramaChannelFragment;
import cn.damai.homepage.girl.GirlFragment;
import cn.damai.homepage.show.ui.ShowFragment;
import cn.damai.homepage.ui.fragment.HomeCmsFragment;
import cn.damai.homepage.ui.listener.HomeTopBgListener;
import cn.damai.livehouse.fragment.LiveHouseFragment;
import cn.damai.musicfestival.fragment.MusicFestivalFragment;
import cn.damai.performance.fragment.OnlinePerformanceFragment;
import cn.damai.tetris.listener.IsRefreshListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tb.cb1;
import tb.m61;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class TabPagerAdapter extends FragmentStatePagerAdapter {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<HomeTabBean> a;
    private Fragment b;
    private FragmentManager c;
    private Fragment d;
    private HomeTopBgListener e;
    private IsRefreshListener f;
    private HomeCmsFragment g;

    public TabPagerAdapter(FragmentManager fragmentManager, List<HomeTabBean> list, HomeTopBgListener homeTopBgListener, IsRefreshListener isRefreshListener) {
        super(fragmentManager);
        this.c = fragmentManager;
        this.a = list;
        this.e = homeTopBgListener;
        this.f = isRefreshListener;
        this.g = null;
    }

    public Fragment a() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1290566560") ? (Fragment) ipChange.ipc$dispatch("1290566560", new Object[]{this}) : this.b;
    }

    public HomeCmsFragment b() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "717362405") ? (HomeCmsFragment) ipChange.ipc$dispatch("717362405", new Object[]{this}) : this.g;
    }

    public void c(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2052040646")) {
            ipChange.ipc$dispatch("-2052040646", new Object[]{this, Boolean.valueOf(z)});
        } else if (z) {
            try {
                Field declaredField = FragmentStatePagerAdapter.class.getDeclaredField("mFragments");
                declaredField.setAccessible(true);
                ArrayList arrayList = (ArrayList) declaredField.get(this);
                if (arrayList == null || arrayList.size() <= 0) {
                    return;
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    Fragment fragment = (Fragment) it.next();
                    if (fragment != null && (fragment instanceof OnCityChangedListener)) {
                        ((OnCityChangedListener) fragment).onCityIdChanged();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2080879396")) {
            ipChange.ipc$dispatch("2080879396", new Object[]{this, viewGroup, Integer.valueOf(i), obj});
        } else if (i == 0) {
            this.d = (Fragment) obj;
            this.c.beginTransaction().hide(this.d);
        } else {
            super.destroyItem(viewGroup, i, obj);
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1090743099")) {
            return ((Integer) ipChange.ipc$dispatch("1090743099", new Object[]{this})).intValue();
        }
        List<HomeTabBean> list = this.a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter
    public Fragment getItem(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "77468331")) {
            return (Fragment) ipChange.ipc$dispatch("77468331", new Object[]{this, Integer.valueOf(i)});
        }
        List<HomeTabBean> list = this.a;
        Fragment fragment = null;
        if (list == null || list.get(i) == null) {
            return null;
        }
        HomeTabBean homeTabBean = this.a.get(i);
        int i2 = homeTabBean.type;
        if (i2 == 999) {
            if (this.g == null) {
                this.g = HomeCmsFragment.newInstance(this.e, this.f);
            }
            fragment = this.g;
        } else if (i2 == 1) {
            fragment = GirlFragment.newInstance(homeTabBean.name, homeTabBean.spmb);
        } else if (i2 == 2) {
            fragment = DiscountTicketFragment.instance(new DtParams(8, "discount"));
        } else if (i2 == 3) {
            if (TextUtils.equals("3", homeTabBean.categoryId)) {
                fragment = DramaChannelFragment.getInstance(homeTabBean);
            } else {
                fragment = ShowFragment.getInstance(homeTabBean);
            }
        } else if (i2 == 4) {
            fragment = MusicFestivalFragment.getInstance(homeTabBean, this.e);
        } else if (i2 == 5) {
            fragment = OnlinePerformanceFragment.getInstance(homeTabBean, this.e);
        } else if (i2 == 6) {
            fragment = LiveHouseFragment.getInstance(homeTabBean, this.e);
        } else if (i2 == 100) {
            fragment = DramaChannelFragment.getInstance(homeTabBean);
        }
        if (fragment == null) {
            if (AppConfig.v()) {
                cb1.c("TabPagerExp", "HomeTab can not find match fragment " + m61.e(homeTabBean));
            }
            return DramaChannelFragment.getInstance(homeTabBean);
        }
        return fragment;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(@NonNull Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-937536730")) {
            return ((Integer) ipChange.ipc$dispatch("-937536730", new Object[]{this, obj})).intValue();
        }
        return -2;
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        Fragment fragment;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2128221190")) {
            return ipChange.ipc$dispatch("-2128221190", new Object[]{this, viewGroup, Integer.valueOf(i)});
        }
        if (i == 0 && (fragment = this.d) != null) {
            this.c.beginTransaction().show(fragment);
            return fragment;
        }
        return (Fragment) super.instantiateItem(viewGroup, i);
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1132752850")) {
            ipChange.ipc$dispatch("1132752850", new Object[]{this, viewGroup, Integer.valueOf(i), obj});
            return;
        }
        this.b = (Fragment) obj;
        super.setPrimaryItem(viewGroup, i, obj);
    }
}
