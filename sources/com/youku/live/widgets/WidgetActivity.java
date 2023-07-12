package com.youku.live.widgets;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.arch.app.BaseActivity;
import com.youku.live.widgets.protocol.IEngineRenderListener;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public abstract class WidgetActivity extends BaseActivity implements IEngineRenderListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private WidgetInstance mInstance;
    protected ViewGroup root;

    @Override // android.app.Activity
    public void finish() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-621929556")) {
            ipChange.ipc$dispatch("-621929556", new Object[]{this});
            return;
        }
        super.finish();
        WidgetInstance widgetInstance = this.mInstance;
        if (widgetInstance != null) {
            widgetInstance.destroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public WidgetInstance getInstance() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "387522601")) {
            return (WidgetInstance) ipChange.ipc$dispatch("387522601", new Object[]{this});
        }
        if (this.mInstance == null) {
            WidgetInstance widgetInstance = new WidgetInstance();
            this.mInstance = widgetInstance;
            widgetInstance.setContext(this);
            this.mInstance.setRenderListener(this);
        }
        return this.mInstance;
    }

    public boolean onActivityBackPressed() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-596394206")) {
            return ((Boolean) ipChange.ipc$dispatch("-596394206", new Object[]{this})).booleanValue();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1136125969")) {
            ipChange.ipc$dispatch("1136125969", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), intent});
            return;
        }
        super.onActivityResult(i, i2, intent);
        WidgetInstance widgetInstance = this.mInstance;
        if (widgetInstance != null) {
            widgetInstance.onActivityResult(i, i2, intent);
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-340481233")) {
            ipChange.ipc$dispatch("-340481233", new Object[]{this});
        } else {
            super.onBackPressed();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-104587250")) {
            ipChange.ipc$dispatch("-104587250", new Object[]{this, configuration});
            return;
        }
        super.onConfigurationChanged(configuration);
        WidgetInstance widgetInstance = this.mInstance;
        if (widgetInstance != null) {
            widgetInstance.onActivityConfigurationChanged(configuration);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1919688368")) {
            ipChange.ipc$dispatch("-1919688368", new Object[]{this, bundle});
        } else {
            super.onCreate(bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-394621296")) {
            ipChange.ipc$dispatch("-394621296", new Object[]{this});
            return;
        }
        super.onDestroy();
        WidgetInstance widgetInstance = this.mInstance;
        if (widgetInstance != null) {
            widgetInstance.onActivityDestroy();
        }
    }

    @Override // com.youku.live.widgets.protocol.IEngineRenderListener
    public void onException(WidgetInstance widgetInstance, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1741014578")) {
            ipChange.ipc$dispatch("1741014578", new Object[]{this, widgetInstance, str, str2});
        }
    }

    @Override // com.youku.live.widgets.protocol.IEngineRenderListener
    public void onHostViewCreated(WidgetInstance widgetInstance, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-214891960")) {
            ipChange.ipc$dispatch("-214891960", new Object[]{this, widgetInstance, view});
        } else {
            this.root.addView(view, new ViewGroup.LayoutParams(-1, -1));
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onLowMemory() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1076918773")) {
            ipChange.ipc$dispatch("1076918773", new Object[]{this});
            return;
        }
        super.onLowMemory();
        WidgetInstance widgetInstance = this.mInstance;
        if (widgetInstance != null) {
            widgetInstance.onActivityLowMemory();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "793495636")) {
            ipChange.ipc$dispatch("793495636", new Object[]{this});
            return;
        }
        super.onPause();
        WidgetInstance widgetInstance = this.mInstance;
        if (widgetInstance != null) {
            widgetInstance.onActivityPause();
        }
    }

    @Override // com.youku.live.widgets.protocol.IEngineRenderListener
    public void onRefreshSuccess(WidgetInstance widgetInstance) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1967467393")) {
            ipChange.ipc$dispatch("1967467393", new Object[]{this, widgetInstance});
        }
    }

    @Override // com.youku.live.widgets.protocol.IEngineRenderListener
    public void onRenderSuccess(WidgetInstance widgetInstance) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "643116636")) {
            ipChange.ipc$dispatch("643116636", new Object[]{this, widgetInstance});
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1244911960")) {
            ipChange.ipc$dispatch("1244911960", new Object[]{this, Integer.valueOf(i), strArr, iArr});
            return;
        }
        super.onRequestPermissionsResult(i, strArr, iArr);
        WidgetInstance widgetInstance = this.mInstance;
        if (widgetInstance != null) {
            widgetInstance.onActivityRequestPermissionsResult(i, strArr, iArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "476347443")) {
            ipChange.ipc$dispatch("476347443", new Object[]{this});
            return;
        }
        super.onResume();
        WidgetInstance widgetInstance = this.mInstance;
        if (widgetInstance != null) {
            widgetInstance.onActivityResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "836600424")) {
            ipChange.ipc$dispatch("836600424", new Object[]{this});
            return;
        }
        super.onStart();
        WidgetInstance widgetInstance = this.mInstance;
        if (widgetInstance != null) {
            widgetInstance.onActivityStart();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1761331458")) {
            ipChange.ipc$dispatch("-1761331458", new Object[]{this});
            return;
        }
        super.onStop();
        WidgetInstance widgetInstance = this.mInstance;
        if (widgetInstance != null) {
            widgetInstance.onActivityStop();
        }
    }
}
