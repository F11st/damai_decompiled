package cn.damai.user.userprofile;

import android.view.ViewGroup;
import androidx.fragment.app.FragmentManager;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class UnDestoryAdapter extends FragmentAdapter {
    private static transient /* synthetic */ IpChange $ipChange;

    public UnDestoryAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter, androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-66954842")) {
            ipChange.ipc$dispatch("-66954842", new Object[]{this, viewGroup, Integer.valueOf(i), obj});
        }
    }
}
