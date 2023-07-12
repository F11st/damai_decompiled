package cn.damai.mine.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import cn.damai.commonbusiness.wannasee.bean.WannaBean;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.mine.adapter.StatePagerAdapter;
import cn.damai.mine.bean.PageType;
import cn.damai.mine.listener.OnWannaBeanListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class Wanna2SeeFragment extends Fragment {
    private static transient /* synthetic */ IpChange $ipChange;
    private ViewPager mViewPager;

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public class a implements OnWannaBeanListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a(Wanna2SeeFragment wanna2SeeFragment) {
        }

        @Override // cn.damai.mine.listener.OnWannaBeanListener
        public void onWannaBean(WannaBean wannaBean) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-630199655")) {
                ipChange.ipc$dispatch("-630199655", new Object[]{this, wannaBean});
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "792460272")) {
            ipChange.ipc$dispatch("792460272", new Object[]{this, bundle});
        } else {
            super.onCreate(bundle);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "547610004") ? (View) ipChange.ipc$dispatch("547610004", new Object[]{this, layoutInflater, viewGroup, bundle}) : layoutInflater.inflate(R$layout.fragment_live_see, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1648226000")) {
            ipChange.ipc$dispatch("-1648226000", new Object[]{this});
        } else {
            super.onDestroy();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-896559351")) {
            ipChange.ipc$dispatch("-896559351", new Object[]{this, view, bundle});
            return;
        }
        this.mViewPager = (ViewPager) view.findViewById(R$id.live_view_pager);
        ArrayList arrayList = new ArrayList();
        MultipleListFragment instance = MultipleListFragment.instance(PageType.RECORD);
        instance.setListener(new a(this));
        arrayList.add(instance);
        this.mViewPager.setOffscreenPageLimit(1);
        this.mViewPager.setAdapter(new StatePagerAdapter(getChildFragmentManager(), arrayList));
    }
}
