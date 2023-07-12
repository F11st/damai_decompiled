package tb;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.text.TextUtils;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.adapter.ClassLoaderAdapter;
import com.taobao.weex.common.WXModule;
import com.taobao.weex.ui.IExternalComponentGetter;
import com.taobao.weex.ui.IExternalModuleGetter;
import com.taobao.weex.ui.component.WXComponent;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class q8 extends ClassLoaderAdapter {
    private Class<? extends WXComponent> a(String str, WXSDKInstance wXSDKInstance) {
        Context context;
        ServiceInfo serviceInfo;
        if (wXSDKInstance != null && (context = wXSDKInstance.getContext()) != null && !TextUtils.isEmpty(str)) {
            Intent intent = new Intent(str);
            intent.setPackage(context.getPackageName());
            List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(intent, 4);
            if (queryIntentServices != null && !queryIntentServices.isEmpty() && (serviceInfo = queryIntentServices.get(0).serviceInfo) != null && serviceInfo.name != null) {
                try {
                    return ((IExternalComponentGetter) q8.class.getClassLoader().loadClass(serviceInfo.name).newInstance()).getExternalComponentClass(str, wXSDKInstance);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
        return null;
    }

    private Class<? extends WXModule> b(String str, Context context) {
        ServiceInfo serviceInfo;
        if (context != null && !TextUtils.isEmpty(str)) {
            Intent intent = new Intent(str);
            intent.setPackage(context.getPackageName());
            List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(intent, 4);
            if (queryIntentServices != null && !queryIntentServices.isEmpty() && (serviceInfo = queryIntentServices.get(0).serviceInfo) != null && serviceInfo.name != null) {
                try {
                    return ((IExternalModuleGetter) q8.class.getClassLoader().loadClass(serviceInfo.name).newInstance()).getExternalModuleClass(str, context);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
        return null;
    }

    @Override // com.taobao.weex.adapter.ClassLoaderAdapter
    public Class<? extends WXComponent> getComponentClass(String str, String str2, WXSDKInstance wXSDKInstance) {
        Class<? extends WXComponent> a = a(str, wXSDKInstance);
        if (a != null) {
            return a;
        }
        Class<? extends WXComponent> a2 = a(str2, wXSDKInstance);
        return a2 != null ? a2 : super.getComponentClass(str, str2, wXSDKInstance);
    }

    @Override // com.taobao.weex.adapter.ClassLoaderAdapter
    public Class<? extends WXModule> getModuleClass(String str, String str2, Context context) {
        Class<? extends WXModule> b = b(str, context);
        if (b != null) {
            return b;
        }
        Class<? extends WXModule> b2 = b(str2, context);
        return b2 != null ? b2 : super.getModuleClass(str, str2, context);
    }
}
