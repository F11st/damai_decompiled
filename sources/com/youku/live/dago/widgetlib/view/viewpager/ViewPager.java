package com.youku.live.dago.widgetlib.view.viewpager;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.ViewPager;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.WXEnvironment;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.dom.WXEvent;
import com.taobao.weex.ui.action.BasicComponentData;
import com.taobao.weex.ui.component.WXComponent;
import com.taobao.weex.ui.component.WXComponentProp;
import com.taobao.weex.ui.component.WXVContainer;
import com.taobao.weex.utils.WXLogUtils;
import com.taobao.weex.utils.WXViewUtils;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class ViewPager extends WXVContainer<ViewPagerView> implements ViewPager.OnPageChangeListener {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String COMPONENT_TYPE = "yk-viewpager";
    private static final String EVENT_PAGE_SCROLL = "pageScroll";
    private static final String EVENT_PAGE_SCROLL2 = "pagescroll";
    private static final String EVENT_PAGE_SCROLL_STATE_CHANGED = "pageScrollStateChanged";
    private static final String EVENT_PAGE_SCROLL_STATE_CHANGED2 = "pagescrollstatechanged";
    private static final String EVENT_PAGE_SELECTED = "pageSelected";
    private static final String EVENT_PAGE_SELECTED2 = "pageselected";
    private int mInitialPage;
    private boolean mInitialPageSetted;
    private boolean mIsCurrentItemFromJs;
    private ViewPagerView mViewPager;

    public ViewPager(WXSDKInstance wXSDKInstance, WXVContainer wXVContainer, BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, basicComponentData);
        this.mIsCurrentItemFromJs = false;
    }

    private void setCurrentItemFromJs(int i, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1172171253")) {
            ipChange.ipc$dispatch("1172171253", new Object[]{this, Integer.valueOf(i), Boolean.valueOf(z)});
        } else if (i < 0) {
        } else {
            this.mIsCurrentItemFromJs = true;
            this.mViewPager.setCurrentItem(i, z);
            this.mIsCurrentItemFromJs = false;
        }
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    public void addEvent(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1622576690")) {
            ipChange.ipc$dispatch("1622576690", new Object[]{this, str});
            return;
        }
        super.addEvent(str);
        if (getRealView() != null) {
            getRealView().setOnTouchListener(null);
        }
    }

    @Override // com.taobao.weex.ui.component.WXVContainer
    public void addSubView(View view, int i) {
        int i2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1508918066")) {
            ipChange.ipc$dispatch("-1508918066", new Object[]{this, view, Integer.valueOf(i)});
        } else if (view == null || this.mViewPager.getAdapter() == null) {
        } else {
            this.mIsCurrentItemFromJs = true;
            this.mViewPager.addViewToAdapter(view);
            this.mIsCurrentItemFromJs = false;
            if (this.mInitialPageSetted || (i2 = this.mInitialPage) <= 0 || i2 >= this.mViewPager.getViewCountInAdapter()) {
                return;
            }
            setCurrentItemFromJs(this.mInitialPage, false);
            this.mInitialPageSetted = true;
        }
    }

    @Override // com.taobao.weex.ui.component.WXVContainer, com.taobao.weex.ui.component.WXComponent
    public void destroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1377536081")) {
            ipChange.ipc$dispatch("-1377536081", new Object[]{this});
            return;
        }
        super.destroy();
        ViewPagerView viewPagerView = this.mViewPager;
        if (viewPagerView != null) {
            viewPagerView.removeAllViews();
        }
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [android.view.View] */
    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1843419808")) {
            ipChange.ipc$dispatch("1843419808", new Object[]{this, Integer.valueOf(i)});
        } else if (getEvents() == null || getEvents().size() == 0) {
        } else {
            if (i == 0) {
                str = "idle";
            } else if (i == 1) {
                str = "dragging";
            } else if (i != 2) {
                throw new IllegalStateException("Unsupported pageScrollState");
            } else {
                str = "settling";
            }
            WXEvent events = getEvents();
            String ref = getRef();
            if (WXViewUtils.onScreenArea(getHostView())) {
                HashMap hashMap = new HashMap();
                hashMap.put("pageScrollState", str);
                if (events.contains(EVENT_PAGE_SCROLL_STATE_CHANGED)) {
                    getInstance().fireEvent(ref, EVENT_PAGE_SCROLL_STATE_CHANGED, hashMap);
                } else if (events.contains(EVENT_PAGE_SCROLL_STATE_CHANGED2)) {
                    getInstance().fireEvent(ref, EVENT_PAGE_SCROLL_STATE_CHANGED2, hashMap);
                }
            }
        }
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [android.view.View] */
    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1909749953")) {
            ipChange.ipc$dispatch("-1909749953", new Object[]{this, Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)});
        } else if (getEvents() == null || getEvents().size() == 0) {
        } else {
            WXEvent events = getEvents();
            String ref = getRef();
            if (WXViewUtils.onScreenArea(getHostView())) {
                HashMap hashMap = new HashMap();
                hashMap.put("position", Integer.valueOf(i));
                hashMap.put("offset", Float.valueOf(f));
                if (events.contains(EVENT_PAGE_SCROLL)) {
                    getInstance().fireEvent(ref, EVENT_PAGE_SCROLL, hashMap);
                } else if (events.contains(EVENT_PAGE_SCROLL2)) {
                    getInstance().fireEvent(ref, EVENT_PAGE_SCROLL2, hashMap);
                }
            }
        }
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [android.view.View] */
    public void onPageSelected(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1079181803")) {
            ipChange.ipc$dispatch("1079181803", new Object[]{this, Integer.valueOf(i)});
        } else if (this.mIsCurrentItemFromJs) {
        } else {
            if (WXEnvironment.isApkDebugable()) {
                WXLogUtils.d("onPageSelected >>>>" + i);
            }
            if (this.mViewPager.getAdapter() == null || this.mViewPager.getAdapter().getCount() == 0) {
                return;
            }
            int count = i % this.mViewPager.getAdapter().getCount();
            ArrayList<WXComponent> arrayList = this.mChildren;
            if (arrayList == null || count >= arrayList.size() || getEvents() == null || getEvents().size() == 0) {
                return;
            }
            WXEvent events = getEvents();
            String ref = getRef();
            if (WXViewUtils.onScreenArea(getHostView())) {
                HashMap hashMap = new HashMap();
                hashMap.put("position", Integer.valueOf(count));
                if (events.contains(EVENT_PAGE_SELECTED)) {
                    getInstance().fireEvent(ref, EVENT_PAGE_SELECTED, hashMap);
                } else if (events.contains(EVENT_PAGE_SELECTED2)) {
                    getInstance().fireEvent(ref, EVENT_PAGE_SELECTED2, hashMap);
                }
            }
        }
    }

    @Override // com.taobao.weex.ui.component.WXVContainer
    public void remove(WXComponent wXComponent, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1682518286")) {
            ipChange.ipc$dispatch("-1682518286", new Object[]{this, wXComponent, Boolean.valueOf(z)});
        } else if (wXComponent == null || wXComponent.getHostView() == null || this.mViewPager.getAdapter() == null) {
        } else {
            this.mChildren.remove(wXComponent);
            if (z) {
                this.mIsCurrentItemFromJs = true;
                this.mViewPager.removeViewFromAdapter(wXComponent.getHostView());
                this.mIsCurrentItemFromJs = false;
                int currentItem = this.mViewPager.getCurrentItem();
                if (currentItem > 0) {
                    setCurrentItemFromJs(currentItem - 1, false);
                }
            }
            if (z) {
                wXComponent.destroy();
            }
        }
    }

    @WXComponentProp(name = "currentItem")
    public void setCurrentItemWithAnimation(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1783081294")) {
            ipChange.ipc$dispatch("1783081294", new Object[]{this, Integer.valueOf(i)});
        } else {
            setCurrentItemFromJs(i, true);
        }
    }

    @WXComponentProp(name = "currentitem")
    public void setCurrentItemWithAnimation2(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-550773184")) {
            ipChange.ipc$dispatch("-550773184", new Object[]{this, Integer.valueOf(i)});
        } else {
            setCurrentItemWithAnimation(i);
        }
    }

    @WXComponentProp(name = "initialPage")
    public void setInitialPage(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-259330477")) {
            ipChange.ipc$dispatch("-259330477", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.mInitialPage = i;
        }
    }

    @WXComponentProp(name = "initialpage")
    public void setInitialPage2(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "558971355")) {
            ipChange.ipc$dispatch("558971355", new Object[]{this, Integer.valueOf(i)});
        } else {
            setInitialPage(i);
        }
    }

    @WXComponentProp(name = "pageMargin")
    public void setPageMargin(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "252470678")) {
            ipChange.ipc$dispatch("252470678", new Object[]{this, Float.valueOf(f)});
        } else {
            this.mViewPager.setPageMargin((int) WXViewUtils.getRealPxByWidth2(f));
        }
    }

    @WXComponentProp(name = "pagemargin")
    public void setPageMargin2(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-754975534")) {
            ipChange.ipc$dispatch("-754975534", new Object[]{this, Float.valueOf(f)});
        } else {
            setPageMargin(f);
        }
    }

    @WXComponentProp(name = "scrollEnabled")
    public void setScrollEnabled(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "347160805")) {
            ipChange.ipc$dispatch("347160805", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.mViewPager.setScrollEnabled(z);
        }
    }

    @WXComponentProp(name = "scrollenabled")
    public void setScrollEnabled2(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2115125493")) {
            ipChange.ipc$dispatch("-2115125493", new Object[]{this, Boolean.valueOf(z)});
        } else {
            setScrollEnabled(z);
        }
    }

    @Override // com.taobao.weex.ui.component.WXVContainer, com.taobao.weex.ui.component.WXComponent
    public ViewGroup getRealView() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1588970917") ? (ViewGroup) ipChange.ipc$dispatch("1588970917", new Object[]{this}) : this.mViewPager;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.weex.ui.component.WXComponent
    public ViewPagerView initComponentHostView(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1263410043")) {
            return (ViewPagerView) ipChange.ipc$dispatch("1263410043", new Object[]{this, context});
        }
        ViewPagerView viewPagerView = new ViewPagerView(getContext());
        this.mViewPager = viewPagerView;
        viewPagerView.addOnPageChangeListener(this);
        return this.mViewPager;
    }
}
