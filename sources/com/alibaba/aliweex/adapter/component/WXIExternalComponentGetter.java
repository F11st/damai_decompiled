package com.alibaba.aliweex.adapter.component;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.text.TextUtils;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.ui.IExternalComponentGetter;
import com.taobao.weex.ui.component.WXComponent;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class WXIExternalComponentGetter implements IExternalComponentGetter {
    @Override // com.taobao.weex.ui.IExternalComponentGetter
    public Class<? extends WXComponent> getExternalComponentClass(String str, WXSDKInstance wXSDKInstance) {
        Context context;
        ServiceInfo serviceInfo;
        if (wXSDKInstance != null && (context = wXSDKInstance.getContext()) != null && !TextUtils.isEmpty(str)) {
            Intent intent = new Intent(str);
            intent.setPackage(context.getPackageName());
            List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(intent, 4);
            if (queryIntentServices != null && !queryIntentServices.isEmpty() && (serviceInfo = queryIntentServices.get(0).serviceInfo) != null && serviceInfo.name != null) {
                try {
                    return ((IExternalComponentGetter) getClass().getClassLoader().loadClass(serviceInfo.name).newInstance()).getExternalComponentClass(str, wXSDKInstance);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
        return null;
    }
}
