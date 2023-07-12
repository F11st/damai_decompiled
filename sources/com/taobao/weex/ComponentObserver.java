package com.taobao.weex;

import android.view.View;
import com.taobao.weex.ui.component.WXComponent;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public interface ComponentObserver {
    void onCreate(WXComponent wXComponent);

    void onPreDestory(WXComponent wXComponent);

    void onViewCreated(WXComponent wXComponent, View view);
}
