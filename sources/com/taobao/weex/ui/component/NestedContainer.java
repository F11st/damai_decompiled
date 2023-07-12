package com.taobao.weex.ui.component;

import android.view.ViewGroup;
import com.taobao.weex.WXSDKInstance;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public interface NestedContainer {

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public interface OnNestedInstanceEventListener {
        void onCreated(NestedContainer nestedContainer, WXSDKInstance wXSDKInstance);

        void onException(NestedContainer nestedContainer, String str, String str2);

        boolean onPreCreate(NestedContainer nestedContainer, String str);

        String transformUrl(String str);
    }

    ViewGroup getViewContainer();

    void reload();

    void renderNewURL(String str);

    void setOnNestEventListener(OnNestedInstanceEventListener onNestedInstanceEventListener);
}
