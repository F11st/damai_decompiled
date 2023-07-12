package com.alibaba.aliweex.adapter.component;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.alibaba.aliweex.adapter.view.Marquee;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.common.Constants;
import com.taobao.weex.dom.transition.WXTransition;
import com.taobao.weex.ui.action.BasicComponentData;
import com.taobao.weex.ui.component.WXComponent;
import com.taobao.weex.ui.component.WXComponentProp;
import com.taobao.weex.ui.component.WXVContainer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class WXMarquee extends WXVContainer<Marquee> {
    private List<View> mViews;

    public WXMarquee(WXSDKInstance wXSDKInstance, WXVContainer wXVContainer, BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, basicComponentData);
        this.mViews = new ArrayList();
    }

    @Override // com.taobao.weex.ui.component.WXVContainer
    public void addSubView(View view, int i) {
        this.mViews.add(view);
    }

    @Override // com.taobao.weex.ui.component.WXVContainer, com.taobao.weex.ui.component.WXComponent
    public void createViewImpl() {
        super.createViewImpl();
        ((Marquee) getHostView()).setClipChildren(true);
    }

    @Override // com.taobao.weex.ui.component.WXVContainer, com.taobao.weex.ui.component.WXComponent
    public void destroy() {
        super.destroy();
        this.mViews.clear();
        ((Marquee) getHostView()).destroy();
    }

    @Override // com.taobao.weex.ui.component.WXVContainer, com.taobao.weex.ui.component.WXComponent, com.taobao.weex.IWXActivityStateListener
    public void onActivityPause() {
        super.onActivityPause();
        if (getHostView() != 0) {
            ((Marquee) getHostView()).stopScroll();
        }
    }

    @Override // com.taobao.weex.ui.component.WXVContainer, com.taobao.weex.ui.component.WXComponent, com.taobao.weex.IWXActivityStateListener
    public void onActivityResume() {
        super.onActivityResume();
        if (getHostView() != 0) {
            ((Marquee) getHostView()).startScroll();
        }
    }

    @Override // com.taobao.weex.ui.component.WXVContainer
    public void remove(WXComponent wXComponent, boolean z) {
        this.mViews.clear();
        super.remove(wXComponent, z);
    }

    @WXComponentProp(name = "delay")
    public void setDelay(String str) {
        if (str == null || !TextUtils.isDigitsOnly(str.trim())) {
            return;
        }
        long parseLong = Long.parseLong(str.trim());
        if (parseLong > 0) {
            ((Marquee) getHostView()).setDelayTime(parseLong);
        }
    }

    @WXComponentProp(name = Constants.Name.INTERVAL)
    public void setInterval(String str) {
        if (str == null || !TextUtils.isDigitsOnly(str.trim())) {
            return;
        }
        long parseLong = Long.parseLong(str.trim());
        if (parseLong > 0) {
            ((Marquee) getHostView()).setIntervalTime(parseLong);
        }
    }

    @WXComponentProp(name = WXTransition.TRANSITION_DURATION)
    public void setTransitionDuration(String str) {
        if (str == null || !TextUtils.isDigitsOnly(str.trim())) {
            return;
        }
        long parseLong = Long.parseLong(str.trim());
        if (parseLong > 0) {
            ((Marquee) getHostView()).setDurationTime(parseLong);
        }
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    public void updateProperties(Map map) {
        super.updateProperties(map);
        ((Marquee) getHostView()).setViewList(this.mViews, (FrameLayout.LayoutParams) getView().getLayoutParams());
        ((Marquee) getHostView()).startScrollA();
    }

    @Override // com.taobao.weex.ui.component.WXVContainer, com.taobao.weex.ui.component.WXComponent
    public ViewGroup getRealView() {
        return (ViewGroup) ((Marquee) getHostView()).getRealView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.weex.ui.component.WXComponent
    public Marquee initComponentHostView(@NonNull Context context) {
        return new Marquee(context);
    }
}
