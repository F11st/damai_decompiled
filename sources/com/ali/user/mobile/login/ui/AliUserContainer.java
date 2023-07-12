package com.ali.user.mobile.login.ui;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import com.ali.user.mobile.base.ui.BaseActivity;
import com.ali.user.mobile.model.CommonCallback;
import com.ali.user.mobile.ui.R;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class AliUserContainer extends BaseActivity {
    public static final String ACTION_TYPE = "actionType";
    public static final String TAG = "login.container";
    public static String TYPE_FINGER = "finger";
    public static CommonCallback callback;
    protected FragmentManager mFragmentManager;

    private void openFragmentByConfig(Intent intent) {
        String stringExtra;
        if (intent != null) {
            try {
                stringExtra = intent.getStringExtra("actionType");
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        } else {
            stringExtra = null;
        }
        if (TYPE_FINGER.equals(stringExtra)) {
            FingerPrintDialog fingerPrintDialog = new FingerPrintDialog(callback);
            fingerPrintDialog.setArguments(intent.getExtras());
            fingerPrintDialog.show(this.mFragmentManager, "finger");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ali.user.mobile.base.ui.BaseActivity
    public void initViews() {
        openFragmentByConfig(getIntent());
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        try {
            if (isFinishing()) {
                return;
            }
            finish();
            overridePendingTransition(0, 0);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ali.user.mobile.base.ui.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.activityIsTranslucent = true;
        this.mFragmentManager = getSupportFragmentManager();
        super.onCreate(bundle);
        setContentView(R.layout.aliuser_activity_frame_content);
    }
}
