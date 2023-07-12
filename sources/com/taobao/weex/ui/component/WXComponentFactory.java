package com.taobao.weex.ui.component;

import android.text.TextUtils;
import com.taobao.weex.WXEnvironment;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.common.WXErrorCode;
import com.taobao.weex.ui.IFComponentHolder;
import com.taobao.weex.ui.WXComponentRegistry;
import com.taobao.weex.ui.action.BasicComponentData;
import com.taobao.weex.utils.WXExceptionUtils;
import com.taobao.weex.utils.WXLogUtils;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class WXComponentFactory {
    public static WXComponent newInstance(WXSDKInstance wXSDKInstance, WXVContainer wXVContainer, BasicComponentData basicComponentData) {
        if (wXSDKInstance != null && !TextUtils.isEmpty(basicComponentData.mComponentType)) {
            IFComponentHolder component = WXComponentRegistry.getComponent(basicComponentData.mComponentType);
            if (component == null) {
                if (WXEnvironment.isApkDebugable()) {
                    WXLogUtils.e("WXComponentFactory error type:[" + basicComponentData.mComponentType + jn1.ARRAY_END_STR + " class not found");
                }
                component = WXComponentRegistry.getComponent("container");
                if (component == null) {
                    String instanceId = wXSDKInstance.getInstanceId();
                    WXErrorCode wXErrorCode = WXErrorCode.WX_RENDER_ERR_COMPONENT_NOT_REGISTER;
                    WXExceptionUtils.commitCriticalExceptionRT(instanceId, wXErrorCode, "createComponent", basicComponentData.mComponentType + " not registered", null);
                    return null;
                }
            }
            try {
                return component.createInstance(wXSDKInstance, wXVContainer, basicComponentData);
            } catch (Throwable th) {
                WXLogUtils.e("WXComponentFactory Exception type:[" + basicComponentData.mComponentType + "] ", th);
            }
        }
        return null;
    }
}
