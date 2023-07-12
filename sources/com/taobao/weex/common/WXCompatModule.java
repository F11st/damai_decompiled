package com.taobao.weex.common;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.taobao.weex.WXEnvironment;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public abstract class WXCompatModule extends WXModule implements Destroyable {
    private ModuleReceive mModuleReceive = new ModuleReceive(this);

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    static class ModuleReceive extends BroadcastReceiver {
        private WXCompatModule mWXCompatModule;

        ModuleReceive(WXCompatModule wXCompatModule) {
            this.mWXCompatModule = wXCompatModule;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            action.hashCode();
            if (action.equals(WXModule.ACTION_ACTIVITY_RESULT)) {
                this.mWXCompatModule.onActivityResult(intent.getIntExtra("requestCode", -1), intent.getIntExtra("resultCode", -1), intent);
            } else if (action.equals(WXModule.ACTION_REQUEST_PERMISSIONS_RESULT)) {
                this.mWXCompatModule.onRequestPermissionsResult(intent.getIntExtra("requestCode", -1), intent.getStringArrayExtra("permissions"), intent.getIntArrayExtra(WXModule.GRANT_RESULTS));
            }
        }
    }

    public WXCompatModule() {
        LocalBroadcastManager.getInstance(WXEnvironment.getApplication()).registerReceiver(this.mModuleReceive, new IntentFilter(WXModule.ACTION_ACTIVITY_RESULT));
        LocalBroadcastManager.getInstance(WXEnvironment.getApplication()).registerReceiver(this.mModuleReceive, new IntentFilter(WXModule.ACTION_REQUEST_PERMISSIONS_RESULT));
    }

    @Override // com.taobao.weex.common.Destroyable
    public void destroy() {
        LocalBroadcastManager.getInstance(WXEnvironment.getApplication()).unregisterReceiver(this.mModuleReceive);
    }

    @Override // com.taobao.weex.common.WXModule
    public void onActivityResult(int i, int i2, Intent intent) {
    }

    @Override // com.taobao.weex.common.WXModule
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
    }
}
