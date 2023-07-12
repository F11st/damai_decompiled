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
import com.taobao.weex.ui.view.WXLoadingLayout;
import com.taobao.weex.ui.view.refresh.core.WXSwipeLayout;
import com.taobao.weex.ui.view.refresh.wrapper.BaseBounceView;
import com.taobao.weex.utils.WXUtils;
import java.util.HashMap;

/* compiled from: Taobao */
@Component(lazyload = false)
/* loaded from: classes11.dex */
public class WXLoading extends WXBaseRefresh implements WXSwipeLayout.WXOnLoadingListener {
    public static final String HIDE = "hide";

    public WXLoading(WXSDKInstance wXSDKInstance, WXVContainer wXVContainer, boolean z, BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, z, basicComponentData);
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    public boolean canRecycled() {
        return false;
    }

    @Override // com.taobao.weex.ui.view.refresh.core.WXSwipeLayout.WXOnLoadingListener
    public void onLoading() {
        if (getEvents().contains("loading")) {
            fireEvent("loading");
        }
    }

    @Override // com.taobao.weex.ui.view.refresh.core.WXSwipeLayout.WXOnLoadingListener
    public void onPullingUp(float f, int i, float f2) {
        if (getEvents().contains(Constants.Event.ONPULLING_UP)) {
            HashMap hashMap = new HashMap();
            hashMap.put(Constants.Name.DISTANCE_Y, Float.valueOf(f));
            hashMap.put(Constants.Name.PULLING_DISTANCE, Integer.valueOf(i));
            hashMap.put(Constants.Name.VIEW_HEIGHT, Float.valueOf(f2));
            fireEvent(Constants.Event.ONPULLING_UP, hashMap);
        }
    }

    @WXComponentProp(name = "display")
    public void setDisplay(String str) {
        if (TextUtils.isEmpty(str) || !str.equals("hide")) {
            return;
        }
        if (((getParent() instanceof WXListComponent) || (getParent() instanceof WXScroller)) && ((BaseBounceView) getParent().getHostView()).getSwipeLayout().isRefreshing()) {
            ((BaseBounceView) getParent().getHostView()).finishPullLoad();
            ((BaseBounceView) getParent().getHostView()).onLoadmoreComplete();
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.weex.ui.component.WXBaseRefresh, com.taobao.weex.ui.component.WXComponent
    public WXFrameLayout initComponentHostView(@NonNull Context context) {
        return new WXLoadingLayout(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.weex.ui.component.WXComponent
    public void setHostLayoutParams(WXFrameLayout wXFrameLayout, int i, int i2, int i3, int i4, int i5, int i6) {
        super.setHostLayoutParams((WXLoading) wXFrameLayout, i, i2, 0, 0, 0, 0);
    }
}
