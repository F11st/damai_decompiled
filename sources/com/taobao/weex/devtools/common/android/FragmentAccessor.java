package com.taobao.weex.devtools.common.android;

import android.content.res.Resources;
import android.view.View;
import javax.annotation.Nullable;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public interface FragmentAccessor<FRAGMENT, FRAGMENT_MANAGER> {
    public static final int NO_ID = 0;

    @Nullable
    FRAGMENT_MANAGER getChildFragmentManager(FRAGMENT fragment);

    @Nullable
    FRAGMENT_MANAGER getFragmentManager(FRAGMENT fragment);

    int getId(FRAGMENT fragment);

    Resources getResources(FRAGMENT fragment);

    @Nullable
    String getTag(FRAGMENT fragment);

    @Nullable
    View getView(FRAGMENT fragment);
}
