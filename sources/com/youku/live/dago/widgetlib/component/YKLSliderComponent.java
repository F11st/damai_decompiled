package com.youku.live.dago.widgetlib.component;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.common.Constants;
import com.taobao.weex.ui.action.BasicComponentData;
import com.taobao.weex.ui.component.WXComponent;
import com.taobao.weex.ui.component.WXComponentProp;
import com.taobao.weex.ui.component.WXVContainer;
import com.youku.live.dago.widgetlib.view.viewpager.ViewPager;
import com.youku.live.widgets.monitor.IPerfMonitor;
import com.youku.live.widgets.monitor.PerfMonitorImp;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class YKLSliderComponent extends ViewPager {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String TAG = "DagoSliderComponent";
    private IPerfMonitor perfMonitor;

    public YKLSliderComponent(WXSDKInstance wXSDKInstance, WXVContainer wXVContainer, BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, basicComponentData);
    }

    @Override // com.taobao.weex.ui.component.WXVContainer, com.taobao.weex.ui.component.WXComponent
    public void createViewImpl() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-170192399")) {
            ipChange.ipc$dispatch("-170192399", new Object[]{this});
            return;
        }
        IPerfMonitor createInstance = PerfMonitorImp.createInstance(TAG, this);
        this.perfMonitor = createInstance;
        createInstance.point("initComponentHostView", "initComponentHostView.begin");
        super.createViewImpl();
        this.perfMonitor.point("initComponentHostView", "initComponentHostView.end");
    }

    public androidx.viewpager.widget.ViewPager getViewPapar() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1514402788") ? (androidx.viewpager.widget.ViewPager) ipChange.ipc$dispatch("1514402788", new Object[]{this}) : (androidx.viewpager.widget.ViewPager) getRealView();
    }

    @Override // com.youku.live.dago.widgetlib.view.viewpager.ViewPager, androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2097479302")) {
            ipChange.ipc$dispatch("-2097479302", new Object[]{this, Integer.valueOf(i)});
        } else if (getViewPapar().getAdapter() == null || getViewPapar().getAdapter().getCount() == 0) {
        } else {
            int count = i % getViewPapar().getAdapter().getCount();
            ArrayList<WXComponent> arrayList = this.mChildren;
            if (arrayList == null || count >= arrayList.size()) {
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("index", Integer.valueOf(count));
            fireEvent(Constants.Event.CHANGE, hashMap);
        }
    }

    @WXComponentProp(name = "index")
    public void setIndex(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "637265921")) {
            ipChange.ipc$dispatch("637265921", new Object[]{this, Integer.valueOf(i)});
        } else {
            setInitialPage(i);
        }
    }

    @JSMethod
    public void slideTo(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-214471785")) {
            ipChange.ipc$dispatch("-214471785", new Object[]{this, Integer.valueOf(i)});
        } else {
            setCurrentItemWithAnimation(i);
        }
    }
}
