package cn.damai.tetris.component.common;

import android.view.View;
import android.widget.LinearLayout;
import androidx.viewpager.widget.ViewPager;
import cn.damai.common.nav.DMNav;
import cn.damai.tetris.component.common.bean.BaseTabResultItem;
import cn.damai.tetris.component.common.bean.TabStyle;
import cn.damai.tetris.core.BasePresenter;
import cn.damai.tetris.core.BaseSection;
import cn.damai.tetris.core.TrackInfo;
import cn.damai.tetris.core.ut.TrackProxy;
import cn.damai.tetris.core.ut.TrackType;
import cn.damai.uikit.snake.ScrollTitleBean;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.d23;
import tb.ja;
import tb.t60;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class BaseTabPresenter extends BasePresenter<BaseTabContract$Model, BaseTabView, BaseSection> implements BaseTabContract$Presenter<BaseTabContract$Model, BaseTabView, BaseSection> {
    private static transient /* synthetic */ IpChange $ipChange;
    int currentTabIndex;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private View.OnClickListener mOnTabItemClickListener;
    public JSONObject mTrackInfo;
    private List<ScrollTitleBean> tabs;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.tetris.component.common.BaseTabPresenter$a */
    /* loaded from: classes16.dex */
    public class View$OnClickListenerC1797a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ BaseTabResultItem.BaseTabBtn a;
        final /* synthetic */ int b;

        View$OnClickListenerC1797a(BaseTabResultItem.BaseTabBtn baseTabBtn, int i) {
            this.a = baseTabBtn;
            this.b = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1022014614")) {
                ipChange.ipc$dispatch("1022014614", new Object[]{this, view});
                return;
            }
            DMNav.from(((BasePresenter) BaseTabPresenter.this).mContext.getActivity()).toUri(this.a.btnAction);
            TrackInfo e = d23.e("item_tabResults_" + this.b + "_tabMores_0", BaseTabPresenter.this.mTrackInfo);
            if (e != null) {
                TrackProxy.a().userTrack(TrackType.click, null, e.trackB, e.trackC, e.trackD, e.getArgsMap(), true);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.tetris.component.common.BaseTabPresenter$b */
    /* loaded from: classes16.dex */
    public class View$OnClickListenerC1798b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC1798b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "949628056")) {
                ipChange.ipc$dispatch("949628056", new Object[]{this, view});
                return;
            }
            ScrollTitleBean scrollTitleBean = (ScrollTitleBean) view.getTag();
            BaseTabPresenter baseTabPresenter = BaseTabPresenter.this;
            baseTabPresenter.currentTabIndex = scrollTitleBean.index;
            String str = ((ScrollTitleBean) baseTabPresenter.tabs.get(scrollTitleBean.index)).name;
            if (BaseTabPresenter.this.getView().getViewPager() != null) {
                BaseTabPresenter.this.getView().getViewPager().setCurrentItem(BaseTabPresenter.this.currentTabIndex, true);
            }
            TrackInfo e = d23.e("item_tabResults_" + BaseTabPresenter.this.currentTabIndex, BaseTabPresenter.this.mTrackInfo);
            if (e != null) {
                TrackProxy.ITrack a = TrackProxy.a();
                TrackType trackType = TrackType.click;
                String str2 = e.trackB;
                String str3 = e.trackC;
                a.userTrack(trackType, null, str2, str3, e.trackD + BaseTabPresenter.this.currentTabIndex, e.getArgsMap(), false);
            }
        }
    }

    public BaseTabPresenter(BaseTabView baseTabView, String str, ja jaVar) {
        super(baseTabView, str, jaVar);
        this.currentTabIndex = 0;
        this.tabs = new ArrayList();
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: cn.damai.tetris.component.common.BaseTabPresenter.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-760935461")) {
                    ipChange.ipc$dispatch("-760935461", new Object[]{this, Integer.valueOf(i)});
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1443275642")) {
                    ipChange.ipc$dispatch("1443275642", new Object[]{this, Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)});
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1395519718")) {
                    ipChange.ipc$dispatch("1395519718", new Object[]{this, Integer.valueOf(i)});
                    return;
                }
                BaseTabPresenter.this.getView().getTabLayout().selectTitle(i);
                if (BaseTabPresenter.this.getModel().getTabLists() == null || BaseTabPresenter.this.getModel().getTabLists().size() == 0) {
                    return;
                }
                BaseTabPresenter.this.setRightConerBtn(BaseTabPresenter.this.getModel().getTabLists().get(i), i);
            }
        };
        this.mOnTabItemClickListener = new View$OnClickListenerC1798b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRightConerBtn(BaseTabResultItem baseTabResultItem, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-683868193")) {
            ipChange.ipc$dispatch("-683868193", new Object[]{this, baseTabResultItem, Integer.valueOf(i)});
            return;
        }
        List<BaseTabResultItem.BaseTabBtn> list = baseTabResultItem.tabMores;
        if (list != null && list.size() > 0 && baseTabResultItem.tabMores.get(0) != null && baseTabResultItem.tabMores.get(0).isValid()) {
            BaseTabResultItem.BaseTabBtn baseTabBtn = baseTabResultItem.tabMores.get(0);
            getView().getModuleTitleMoreTextView().setText(baseTabBtn.btnName);
            getView().getModuleTitleMoreLayout().setOnClickListener(new View$OnClickListenerC1797a(baseTabBtn, i));
            getView().getModuleTitleMoreLayout().setVisibility(0);
            return;
        }
        getView().getModuleTitleMoreLayout().setVisibility(8);
    }

    @Override // cn.damai.tetris.core.BasePresenter, cn.damai.tetris.core.msg.IMessage
    public void onMessage(int i, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "139594581")) {
            ipChange.ipc$dispatch("139594581", new Object[]{this, Integer.valueOf(i), obj});
        }
    }

    @Override // cn.damai.tetris.core.BasePresenter
    public boolean rebindAble() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1761190606")) {
            return ((Boolean) ipChange.ipc$dispatch("-1761190606", new Object[]{this})).booleanValue();
        }
        return true;
    }

    @Override // cn.damai.tetris.core.BasePresenter
    public void rebindData(BaseTabContract$Model baseTabContract$Model) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-247765143")) {
            ipChange.ipc$dispatch("-247765143", new Object[]{this, baseTabContract$Model});
        }
    }

    protected void setData(List<BaseTabResultItem> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-144790473")) {
            ipChange.ipc$dispatch("-144790473", new Object[]{this, list});
        } else if (list != null && list.size() != 0) {
            ArrayList<String> arrayList = new ArrayList<>();
            this.tabs.clear();
            int i = 0;
            boolean z = false;
            for (BaseTabResultItem baseTabResultItem : list) {
                ScrollTitleBean scrollTitleBean = new ScrollTitleBean();
                scrollTitleBean.id = i + "";
                scrollTitleBean.name = baseTabResultItem.tabName;
                scrollTitleBean.picUrl = baseTabResultItem.tabIconUrl;
                scrollTitleBean.index = i;
                this.tabs.add(scrollTitleBean);
                TabStyle tabStyle = baseTabResultItem.tabStyle;
                if (tabStyle != null && tabStyle.isShowDateAndVenue()) {
                    z = true;
                }
                arrayList.add(baseTabResultItem.tabName);
                int i2 = this.currentTabIndex;
                if (i == i2) {
                    setRightConerBtn(baseTabResultItem, i2);
                }
                i++;
            }
            if (this.tabs.size() == 1) {
                getView().getTabLayout().setLineShow(false);
            } else {
                getView().getTabLayout().setLineShow(true);
            }
            getView().getTabLayout().setTitle(this.tabs).commit();
            getView().getTabLayout().selectTitle(this.currentTabIndex);
            getView().getTabLayout().setOnTitleClickListener(this.mOnTabItemClickListener);
            getView().getPagerAdapter().a(arrayList, getModel().getTabLists(), getModel().getTrackInfoAction());
            getView().getViewPager().setCurrentItem(this.currentTabIndex);
            getView().getViewPager().addOnPageChangeListener(this.mOnPageChangeListener);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getView().getViewPager().getLayoutParams();
            layoutParams.weight = -1.0f;
            layoutParams.height = t60.a(getContext().getActivity(), z ? 222 : 204);
            getView().getViewPager().setLayoutParams(layoutParams);
        }
    }

    @Override // cn.damai.tetris.core.BasePresenter
    public void init(BaseTabContract$Model baseTabContract$Model) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1910659181")) {
            ipChange.ipc$dispatch("-1910659181", new Object[]{this, baseTabContract$Model});
            return;
        }
        this.mTrackInfo = baseTabContract$Model.getTrackInfoAction();
        setData(getModel().getTabLists());
    }
}
