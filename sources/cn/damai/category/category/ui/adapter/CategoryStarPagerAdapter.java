package cn.damai.category.category.ui.adapter;

import android.os.Bundle;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import cn.damai.category.category.bean.StarItemBean;
import cn.damai.category.category.bean.StarListBean;
import cn.damai.category.category.ui.StarFragment;
import cn.damai.user.star.StarIndexFragment;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.o91;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class CategoryStarPagerAdapter extends FragmentStatePagerAdapter {
    private static transient /* synthetic */ IpChange $ipChange;
    private StarListBean a;

    public CategoryStarPagerAdapter(FragmentManager fragmentManager, StarListBean starListBean) {
        super(fragmentManager);
        this.a = starListBean;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "642441163")) {
            return ((Integer) ipChange.ipc$dispatch("642441163", new Object[]{this})).intValue();
        }
        StarListBean starListBean = this.a;
        if (starListBean == null || o91.a(starListBean.artistList)) {
            return 2;
        }
        return 2 + this.a.artistList.size();
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter
    public Fragment getItem(int i) {
        int i2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1366553573")) {
            return (Fragment) ipChange.ipc$dispatch("-1366553573", new Object[]{this, Integer.valueOf(i)});
        }
        if (i == 0) {
            StarFragment starFragment = new StarFragment();
            Bundle bundle = new Bundle();
            bundle.putBoolean(StarFragment.KEY_FOLLOW, false);
            starFragment.setArguments(bundle);
            return starFragment;
        } else if (i == 1) {
            StarFragment starFragment2 = new StarFragment();
            Bundle bundle2 = new Bundle();
            bundle2.putBoolean(StarFragment.KEY_FOLLOW, true);
            starFragment2.setArguments(bundle2);
            return starFragment2;
        } else {
            StarListBean starListBean = this.a;
            if (starListBean == null || o91.a(starListBean.artistList) || (i2 = i - 2) < 0 || i2 >= this.a.artistList.size()) {
                return null;
            }
            StarItemBean starItemBean = this.a.artistList.get(i2);
            String str = starItemBean.damaiId;
            return StarIndexFragment.newInstance(str, starItemBean.type + "", 1, null);
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(@NonNull Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "346038422")) {
            return ((Integer) ipChange.ipc$dispatch("346038422", new Object[]{this, obj})).intValue();
        }
        return -2;
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "494037354") ? ipChange.ipc$dispatch("494037354", new Object[]{this, viewGroup, Integer.valueOf(i)}) : (Fragment) super.instantiateItem(viewGroup, i);
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-539955902")) {
            ipChange.ipc$dispatch("-539955902", new Object[]{this, viewGroup, Integer.valueOf(i), obj});
            return;
        }
        Fragment fragment = (Fragment) obj;
        super.setPrimaryItem(viewGroup, i, obj);
    }
}
