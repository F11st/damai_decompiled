package com.taobao.weex.ui.component;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.annotation.Component;
import com.taobao.weex.common.Constants;
import com.taobao.weex.ui.action.BasicComponentData;
import com.taobao.weex.ui.component.list.WXListComponent;
import com.taobao.weex.ui.view.WXFrameLayout;
import com.taobao.weex.ui.view.WXRefreshLayout;
import com.taobao.weex.ui.view.refresh.core.WXSwipeLayout;
import com.taobao.weex.ui.view.refresh.wrapper.BaseBounceView;
import com.taobao.weex.utils.WXUtils;
import java.util.HashMap;

/* compiled from: Taobao */
@Component(lazyload = false)
/* loaded from: classes11.dex */
public class WXRefresh extends WXBaseRefresh implements WXSwipeLayout.WXOnRefreshListener {
    public static final String HIDE = "hide";

    @Deprecated
    public WXRefresh(WXSDKInstance wXSDKInstance, WXVContainer wXVContainer, String str, boolean z, BasicComponentData basicComponentData) {
        this(wXSDKInstance, wXVContainer, z, basicComponentData);
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    public boolean canRecycled() {
        return false;
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    public int getLayoutTopOffsetForSibling() {
        if (getParent() instanceof Scrollable) {
            return -Math.round(getLayoutHeight());
        }
        return 0;
    }

    @Override // com.taobao.weex.ui.view.refresh.core.WXSwipeLayout.WXOnRefreshListener
    public void onPullingDown(float f, int i, float f2) {
        if (getEvents() == null || !getEvents().contains(Constants.Event.ONPULLING_DOWN)) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(Constants.Name.DISTANCE_Y, Float.valueOf(f));
        hashMap.put(Constants.Name.PULLING_DISTANCE, Integer.valueOf(i));
        hashMap.put(Constants.Name.VIEW_HEIGHT, Float.valueOf(f2));
        fireEvent(Constants.Event.ONPULLING_DOWN, hashMap);
    }

    @Override // com.taobao.weex.ui.view.refresh.core.WXSwipeLayout.WXOnRefreshListener
    public void onRefresh() {
        if (!isDestoryed() && getEvents().contains("refresh")) {
            fireEvent("refresh");
        }
    }

    @WXComponentProp(name = "display")
    public void setDisplay(String str) {
        if (TextUtils.isEmpty(str) || !str.equals("hide")) {
            return;
        }
        if (((getParent() instanceof WXListComponent) || (getParent() instanceof WXScroller)) && ((BaseBounceView) getParent().getHostView()).getSwipeLayout().isRefreshing()) {
            ((BaseBounceView) getParent().getHostView()).finishPullRefresh();
            ((BaseBounceView) getParent().getHostView()).onRefreshingComplete();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.weex.ui.component.WXComponent
    public boolean setProperty(String str, Object obj) {
        str.hashCode();
        if (!str.equals("display")) {
            return super.setProperty(str, obj);
        }
        String string = WXUtils.getString(obj, null);
        if (string != null) {
            setDisplay(string);
            return true;
        }
        return true;
    }

    public WXRefresh(WXSDKInstance wXSDKInstance, WXVContainer wXVContainer, boolean z, BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, z, basicComponentData);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.weex.ui.component.WXBaseRefresh, com.taobao.weex.ui.component.WXComponent
    public WXFrameLayout initComponentHostView(@NonNull Context context) {
        return new WXRefreshLayout(context);
    }
}
