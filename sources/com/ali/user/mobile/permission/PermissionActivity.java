package com.ali.user.mobile.permission;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityCompat;
import com.ali.user.mobile.R;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class PermissionActivity extends Activity implements ActivityCompat.OnRequestPermissionsResultCallback {
    private static final int OVERLAY_PERMISSION_REQ_CODE = 123;
    private static final int PERMISSION_REQUEST = 0;
    public static final String TAG = "PermissionActivity";

    private void requestCustomPermission(final String[] strArr, String str) {
        if (shouldShowRequestPermissionRationale(strArr) && !TextUtils.isEmpty(str)) {
            new AlertDialog.Builder(this).setMessage(str).setCancelable(false).setPositiveButton("我知道了", new DialogInterface.OnClickListener() { // from class: com.ali.user.mobile.permission.PermissionActivity.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    ActivityCompat.requestPermissions(PermissionActivity.this, strArr, 0);
                    dialogInterface.dismiss();
                }
            }).show();
        } else {
            ActivityCompat.requestPermissions(this, strArr, 0);
        }
    }

    private boolean shouldShowRequestPermissionRationale(String[] strArr) {
        for (String str : strArr) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, str)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        overridePendingTransition(0, 0);
    }

    @Override // android.app.Activity
    @RequiresApi(api = 23)
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 123) {
            PermissionUtil.onActivityResult(i, i2, intent);
        }
        finish();
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.aliuser_activity_permission);
        String[] stringArrayExtra = getIntent().getStringArrayExtra("permissions");
        String stringExtra = getIntent().getStringExtra("explain");
        if (stringArrayExtra != null && stringArrayExtra.length == 1 && stringArrayExtra[0].equals("android.permission.SYSTEM_ALERT_WINDOW")) {
            startActivityForResult(new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse("package:" + getPackageName())), 123);
        } else if (stringArrayExtra != null && stringArrayExtra.length > 0) {
            requestCustomPermission(stringArrayExtra, stringExtra);
        } else {
            finish();
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return true;
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        return true;
    }

    @Override // android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 0) {
            PermissionUtil.onRequestPermissionsResult(i, strArr, iArr);
        }
        finish();
    }
}
