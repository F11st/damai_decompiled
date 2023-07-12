package com.alibaba.aliweex.adapter.module;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.alibaba.aliweex.AliWXSDKInstance;
import com.alibaba.aliweex.bundle.WeexPageFragment;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.common.WXModule;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class WXLocationModule extends WXModule {
    /* JADX INFO: Access modifiers changed from: protected */
    public WeexPageFragment findWeexPageFragment() {
        Fragment findFragmentByTag;
        Context context = this.mWXSDKInstance.getContext();
        String str = WeexPageFragment.FRAGMENT_TAG;
        WXSDKInstance wXSDKInstance = this.mWXSDKInstance;
        if (wXSDKInstance instanceof AliWXSDKInstance) {
            String a = ((AliWXSDKInstance) wXSDKInstance).a();
            if (!TextUtils.isEmpty(a)) {
                str = a;
            }
        }
        if ((context instanceof FragmentActivity) && (findFragmentByTag = ((FragmentActivity) context).getSupportFragmentManager().findFragmentByTag(str)) != null && (findFragmentByTag instanceof WeexPageFragment)) {
            return (WeexPageFragment) findFragmentByTag;
        }
        return null;
    }

    @JSMethod
    public void reload(Boolean bool) {
        Context context = this.mWXSDKInstance.getContext();
        if (context == null) {
            return;
        }
        WeexPageFragment findWeexPageFragment = findWeexPageFragment();
        if (findWeexPageFragment != null) {
            findWeexPageFragment.reload();
        } else if (context instanceof ILocationModule) {
            ((ILocationModule) context).reload(bool.booleanValue());
        }
    }

    @JSMethod
    public void replace(String str) {
        Context context;
        if (TextUtils.isEmpty(str) || (context = this.mWXSDKInstance.getContext()) == null) {
            return;
        }
        WeexPageFragment findWeexPageFragment = findWeexPageFragment();
        if (findWeexPageFragment != null) {
            replace(findWeexPageFragment, str);
        } else if (context instanceof ILocationModule) {
            ((ILocationModule) context).replace(str);
        }
    }

    private void replace(WeexPageFragment weexPageFragment, String str) {
        Uri parse = Uri.parse(str);
        String queryParameter = parse.getQueryParameter("_wx_tpl");
        if (TextUtils.isEmpty(queryParameter)) {
            queryParameter = "true".equals(parse.getQueryParameter("wh_weex")) ? str : "";
        }
        if (TextUtils.isEmpty(queryParameter) || weexPageFragment == null) {
            return;
        }
        weexPageFragment.replace(str, queryParameter);
    }
}
