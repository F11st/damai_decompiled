package com.youku.resource.utils;

import android.content.ComponentCallbacks;
import android.content.res.Configuration;
import android.util.Log;
import androidx.appcompat.app.AppCompatDelegate;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import com.youku.middlewareservice.provider.kvdata.HighPerfSPProviderProxy;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class UIMode {
    public static final int CSS_MODE = 4;
    public static final int DARK_MODE = 1;
    public static final int NORMAL_MODE = 0;
    public static final int SKINCHANGED_MODE = 2;
    private static final String TAG = "UIMODE";
    private static final UIMode ourInstance = new UIMode();
    private int uiMode = 0;

    private UIMode() {
        if (AppInfoProviderProxy.getApplication() == null) {
            return;
        }
        Log.d(TAG, "app UIMode " + AppInfoProviderProxy.getApplication().getResources().getConfiguration().uiMode + " last UIMode " + HighPerfSPProviderProxy.getInt("ONEARCH_UIMODE", "uimode", this.uiMode));
        getSystemUIMode(AppInfoProviderProxy.getApplication().getResources().getConfiguration().uiMode);
        AppInfoProviderProxy.getApplication().registerComponentCallbacks(new ComponentCallbacks() { // from class: com.youku.resource.utils.UIMode.1
            @Override // android.content.ComponentCallbacks
            public void onConfigurationChanged(Configuration configuration) {
                Log.d(UIMode.TAG, "onConfigurationChanged " + (configuration.uiMode & 48) + " defaultNightMode " + AppCompatDelegate.getDefaultNightMode());
                if (!((AppCompatDelegate.getDefaultNightMode() == 2) | (AppCompatDelegate.getDefaultNightMode() == 1))) {
                    UIMode.this.getSystemUIMode(configuration.uiMode);
                } else {
                    Log.d(UIMode.TAG, "强制模式，忽略系统变更");
                }
            }

            @Override // android.content.ComponentCallbacks
            public void onLowMemory() {
            }
        });
    }

    public static UIMode getInstance() {
        return ourInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getSystemUIMode(int i) {
        int i2 = i & 48;
        if (i2 == 16) {
            setDarkMode(false);
        } else if (i2 != 32) {
        } else {
            setDarkMode(true);
        }
    }

    public boolean isDarkMode() {
        boolean z = (this.uiMode & 1) > 0;
        Log.d(TAG, "is darkMode " + z);
        return z;
    }

    public void setDarkMode(boolean z) {
        Log.d(TAG, "set darkMode " + z);
        if (z == isDarkMode()) {
            return;
        }
        if (z) {
            int i = this.uiMode | 1;
            this.uiMode = i;
            HighPerfSPProviderProxy.putInt("ONEARCH_UIMODE", "uimode", i);
        } else {
            int i2 = this.uiMode ^ 1;
            this.uiMode = i2;
            HighPerfSPProviderProxy.putInt("ONEARCH_UIMODE", "uimode", i2);
        }
        ColorConfigureManager.getInstance().onConfigureChanged();
    }
}
