package com.youku.live.widgets;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.arch.app.BaseActivity;
import com.youku.live.widgets.protocol.activity.IActivityBackPressedListener;
import com.youku.live.widgets.protocol.activity.IActivityStateReader;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class WidgetEngineActivity extends BaseActivity implements IActivityBackPressedListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private int mActivityOrientation;
    private boolean mIsActivityResume;
    private boolean mIsActivityStart;
    private WidgetEngineContext mWidgetEngineContext;

    @Override // android.app.Activity
    public void finish() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1575035854")) {
            ipChange.ipc$dispatch("1575035854", new Object[]{this});
        } else {
            super.finish();
        }
    }

    @Override // com.youku.live.widgets.protocol.activity.IActivityBackPressedListener
    public boolean onActivityBackPressed() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "963587776")) {
            return ((Boolean) ipChange.ipc$dispatch("963587776", new Object[]{this})).booleanValue();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1678837555")) {
            ipChange.ipc$dispatch("1678837555", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), intent});
        } else {
            super.onActivityResult(i, i2, intent);
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1766811443")) {
            ipChange.ipc$dispatch("-1766811443", new Object[]{this});
        } else {
            super.onBackPressed();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1685546836")) {
            ipChange.ipc$dispatch("-1685546836", new Object[]{this, configuration});
            return;
        }
        this.mActivityOrientation = configuration.orientation;
        super.onConfigurationChanged(configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2081989230")) {
            ipChange.ipc$dispatch("2081989230", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        this.mWidgetEngineContext = new WidgetEngineContext().bindActivityStateReader(this, new IActivityStateReader() { // from class: com.youku.live.widgets.WidgetEngineActivity.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.live.widgets.protocol.activity.IActivityStateReader
            public ActivityLifecycleState getActivityLifecycleState() {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-2022723396")) {
                    return (ActivityLifecycleState) ipChange2.ipc$dispatch("-2022723396", new Object[]{this});
                }
                return null;
            }

            @Override // com.youku.live.widgets.protocol.activity.IActivityStateReader
            public int getActivityOrientation() {
                IpChange ipChange2 = $ipChange;
                return AndroidInstantRuntime.support(ipChange2, "753454678") ? ((Integer) ipChange2.ipc$dispatch("753454678", new Object[]{this})).intValue() : WidgetEngineActivity.this.mActivityOrientation;
            }
        }).initialize();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1604715730")) {
            ipChange.ipc$dispatch("-1604715730", new Object[]{this});
            return;
        }
        super.onDestroy();
        WidgetEngineContext widgetEngineContext = this.mWidgetEngineContext;
        if (widgetEngineContext != null) {
            widgetEngineContext.unbindActivityStateReader(this);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onLowMemory() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2112304915")) {
            ipChange.ipc$dispatch("2112304915", new Object[]{this});
        } else {
            super.onLowMemory();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "179946610")) {
            ipChange.ipc$dispatch("179946610", new Object[]{this});
            return;
        }
        this.mIsActivityResume = false;
        super.onPause();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-343042310")) {
            ipChange.ipc$dispatch("-343042310", new Object[]{this, Integer.valueOf(i), strArr, iArr});
        } else {
            super.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1363803179")) {
            ipChange.ipc$dispatch("-1363803179", new Object[]{this});
            return;
        }
        this.mIsActivityResume = true;
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "223051398")) {
            ipChange.ipc$dispatch("223051398", new Object[]{this});
            return;
        }
        this.mIsActivityStart = true;
        super.onStart();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "435633952")) {
            ipChange.ipc$dispatch("435633952", new Object[]{this});
            return;
        }
        this.mIsActivityStart = false;
        super.onStop();
    }
}
