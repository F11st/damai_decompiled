package com.alibaba.responsive.page;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import tb.t22;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class ResponsiveFragment extends Fragment implements IResponsivePage {
    private t22 mResponsiveFragmentStateManager;

    @Override // com.alibaba.responsive.page.IResponsivePage
    public Activity getPageActivity() {
        return getActivity();
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        t22 t22Var = this.mResponsiveFragmentStateManager;
        if (t22Var != null) {
            t22Var.a(configuration);
        }
        super.onConfigurationChanged(configuration);
        t22 t22Var2 = this.mResponsiveFragmentStateManager;
        if (t22Var2 != null) {
            t22Var2.b(configuration);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.mResponsiveFragmentStateManager = new t22(this);
    }

    @Override // com.alibaba.responsive.page.IResponsivePage
    public void onResponsiveLayout(Configuration configuration, int i, boolean z) {
    }
}
