package com.taobao.weex.ui.component;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.core.internal.view.SupportMenu;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.annotation.Component;
import com.taobao.weex.common.Constants;
import com.taobao.weex.ui.action.BasicComponentData;
import com.taobao.weex.ui.view.refresh.circlebar.CircleProgressBar;
import com.taobao.weex.utils.WXResourceUtils;
import com.taobao.weex.utils.WXUtils;

/* compiled from: Taobao */
@Component(lazyload = false)
/* loaded from: classes11.dex */
public class WXLoadingIndicator extends WXComponent<CircleProgressBar> {
    public WXLoadingIndicator(WXSDKInstance wXSDKInstance, WXVContainer wXVContainer, boolean z, BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, z, basicComponentData);
    }

    @WXComponentProp(name = Constants.Name.ANIMATING)
    public void setAnimating(boolean z) {
        if (z) {
            getHostView().start();
        } else {
            getHostView().stop();
        }
    }

    @WXComponentProp(name = "color")
    public void setColor(String str) {
        if (str == null || str.equals("")) {
            return;
        }
        getHostView().setColorSchemeColors(WXResourceUtils.getColor(str, SupportMenu.CATEGORY_MASK));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.weex.ui.component.WXComponent
    public boolean setProperty(String str, Object obj) {
        str.hashCode();
        if (str.equals("color")) {
            String string = WXUtils.getString(obj, null);
            if (string != null) {
                setColor(string);
            }
            return true;
        } else if (!str.equals(Constants.Name.ANIMATING)) {
            return super.setProperty(str, obj);
        } else {
            Boolean bool = WXUtils.getBoolean(obj, null);
            if (bool != null) {
                setAnimating(bool.booleanValue());
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.weex.ui.component.WXComponent
    public CircleProgressBar initComponentHostView(@NonNull Context context) {
        return new CircleProgressBar(context);
    }
}
