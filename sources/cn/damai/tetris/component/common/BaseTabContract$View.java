package cn.damai.tetris.component.common;

import android.widget.LinearLayout;
import android.widget.TextView;
import cn.damai.commonbusiness.view.DmViewPager;
import cn.damai.tetris.component.common.BaseTabContract$Presenter;
import cn.damai.tetris.component.home.widget.HomeTabScrollView;
import cn.damai.tetris.core.IView;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
interface BaseTabContract$View<P extends BaseTabContract$Presenter> extends IView<P> {
    LinearLayout getModuleTitleMoreLayout();

    TextView getModuleTitleMoreTextView();

    BaseTabViewPagerAdapter getPagerAdapter();

    HomeTabScrollView getTabLayout();

    DmViewPager getViewPager();
}
