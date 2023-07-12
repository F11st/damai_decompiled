package com.alibaba.aliweex.adapter.component;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.text.TextUtils;
import com.taobao.weex.common.WXModule;
import com.taobao.weex.ui.IExternalModuleGetter;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class WXIExternalModuleGetter implements IExternalModuleGetter {
    @Override // com.taobao.weex.ui.IExternalModuleGetter
    public Class<? extends WXModule> getExternalModuleClass(String str, Context context) {
        ServiceInfo serviceInfo;
        if (context != null && !TextUtils.isEmpty(str)) {
            Intent intent = new Intent(str);
            intent.setPackage(context.getPackageName());
            List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(intent, 4);
            if (queryIntentServices != null && !queryIntentServices.isEmpty() && (serviceInfo = queryIntentServices.get(0).serviceInfo) != null && serviceInfo.name != null) {
                try {
                    return ((IExternalModuleGetter) getClass().getClassLoader().loadClass(serviceInfo.name).newInstance()).getExternalModuleClass(str, context);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
        return null;
    }
}
