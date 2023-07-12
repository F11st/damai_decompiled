package com.alibaba.aliweex.bundle;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.ui.component.NestedContainer;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public interface WeexPageContract {

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public interface IDynamicUrlPresenter {
        String getOriginalRenderUrl();

        String getOriginalUrl();

        String getRenderUrl();

        String getUrl();

        void onWXException(WXSDKInstance wXSDKInstance, String str, String str2);

        void transformUrl(String str, String str2);
    }

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public interface IErrorView {
        void createErrorView(Context context, View view);

        void destroy();

        void showErrorView(boolean z, String str);
    }

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public interface IProgressBar {
        View createProgressBar(Context context);

        void destroy();

        void showProgressBar(boolean z);
    }

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public interface IRenderPresenter {
        WXSDKInstance createWXSDKInstance(Context context);

        void destroySDKInstance();

        void fireEvent(String str, Map<String, Object> map);

        NestedContainer getNestedContainer(WXSDKInstance wXSDKInstance);

        String getOriginalRenderUrl();

        String getOriginalUrl();

        String getRenderUrl();

        String getUrl();

        WXSDKInstance getWXSDKInstance();

        void onActivityCreate(ViewGroup viewGroup, Map<String, Object> map, String str, String str2, String str3, String str4, String str5);

        void onActivityDestroy();

        void onActivityPause();

        void onActivityResult(int i, int i2, Intent intent);

        void onActivityResume();

        void onActivityStart();

        void onActivityStop();

        boolean onBackPressed();

        void onCreateOptionsMenu(Menu menu);

        boolean onSupportNavigateUp();

        void reload();

        void replace(String str, String str2);

        void startRenderByTemplate(String str, String str2, Map<String, Object> map, String str3);

        void startRenderByUrl(Map<String, Object> map, String str, String str2, String str3);

        void transformUrl(String str, String str2);
    }

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public interface IUTPresenter {
        void destroy();

        boolean enable();

        void pageAppear(String str);

        void pageDisappear();

        void refreshUT(String str);

        void skipPage();

        void tryToUpdatePageSpmCnt(WXSDKInstance wXSDKInstance);

        void updatePageName(String str);

        void viewAutoExposure(WXSDKInstance wXSDKInstance);
    }

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public interface IUrlValidate {
        void checkUrlValidate(String str);

        Handler getHandler();

        void onWXViewCreated(WXSDKInstance wXSDKInstance, View view);
    }
}
