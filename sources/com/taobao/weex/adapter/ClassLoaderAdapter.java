package com.taobao.weex.adapter;

import android.content.Context;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.common.WXModule;
import com.taobao.weex.ui.component.WXComponent;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ClassLoaderAdapter {
    public Class<? extends WXComponent> getComponentClass(String str, String str2, WXSDKInstance wXSDKInstance) {
        try {
            return wXSDKInstance.getContext().getClassLoader().loadClass(str2);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public Class<? extends WXModule> getModuleClass(String str, String str2, Context context) {
        try {
            return context.getClassLoader().loadClass(str2);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
