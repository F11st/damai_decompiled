package com.taobao.monitor.procedure;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public interface IPageFactory {
    @NonNull
    IPage createPage(@NonNull View view, boolean z);

    @NonNull
    IPage createStartedPage(@NonNull Fragment fragment, String str, String str2, @NonNull View view, boolean z);
}
