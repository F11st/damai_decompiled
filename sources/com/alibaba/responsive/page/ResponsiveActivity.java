package com.alibaba.responsive.page;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import tb.r22;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class ResponsiveActivity extends AppCompatActivity implements IResponsivePage {
    private r22 mResponsiveActivityStateManager;

    @Override // com.alibaba.responsive.page.IResponsivePage
    public Activity getPageActivity() {
        return this;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        r22 r22Var = this.mResponsiveActivityStateManager;
        if (r22Var != null) {
            r22Var.e(configuration);
        }
        super.onConfigurationChanged(configuration);
        r22 r22Var2 = this.mResponsiveActivityStateManager;
        if (r22Var2 != null) {
            r22Var2.g(configuration);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.mResponsiveActivityStateManager = new r22(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        r22 r22Var = this.mResponsiveActivityStateManager;
        if (r22Var != null) {
            r22Var.f();
        }
    }

    @Override // com.alibaba.responsive.page.IResponsivePage
    public void onResponsiveLayout(Configuration configuration, int i, boolean z) {
    }
}
