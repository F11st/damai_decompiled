package cn.damai.commonbusiness.tab;

import android.view.View;
import androidx.annotation.Nullable;
import cn.damai.commonbusiness.home.bean.TabExtraBean;
import cn.damai.commonbusiness.tab.TabbarLayout;
import com.airbnb.lottie.LottieAnimationView;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public interface ITabView {
    View getClickView();

    LottieAnimationView getLottieAnimationView();

    String getTab();

    View getTabView();

    void onTabSelected();

    void setBadge(TabbarLayout.BadgeType badgeType, String str);

    void setTabAnimatorListener();

    void setUpTabItem(TabItem tabItem, String str);

    void updateTopCoverIcon(@Nullable TabExtraBean tabExtraBean);
}
