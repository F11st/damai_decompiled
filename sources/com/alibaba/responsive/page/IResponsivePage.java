package com.alibaba.responsive.page;

import android.app.Activity;
import android.content.res.Configuration;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public interface IResponsivePage {
    Activity getPageActivity();

    void onResponsiveLayout(Configuration configuration, int i, boolean z);
}
