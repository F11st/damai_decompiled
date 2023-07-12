package cn.damai.homepage.ui.fragment;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import cn.damai.homepage.bean.TabExtra;
import cn.damai.homepage.ui.fragment.HomeTabFragment;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public interface HomeFragmentAgent extends FragmentAgent {
    Fragment getCurFragment();

    int getCurIndex();

    Fragment self();

    void setArguments(@Nullable Bundle bundle);

    void setOnTabClickListener(HomeTabFragment.OnTabClickListener onTabClickListener);

    void setSelectTab(TabExtra tabExtra);
}
