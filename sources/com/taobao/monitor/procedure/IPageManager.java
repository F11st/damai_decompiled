package com.taobao.monitor.procedure;

import android.app.Activity;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public interface IPageManager {
    @NonNull
    IPage getActivityPage(Activity activity);

    @NonNull
    IPage getFragmentPage(Fragment fragment);

    @NonNull
    IPage getPage(View view);

    @NonNull
    IPage getPageGroup(View view);
}
