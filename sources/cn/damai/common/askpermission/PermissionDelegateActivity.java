package cn.damai.common.askpermission;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class PermissionDelegateActivity extends AppCompatActivity {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String EXTRA = "EXTRA";
    public static final int PERMISSION_REQUEST_CODE = 4660;
    private static IPermissionCallBack sPermissionCallBack;

    public static void requestPermission(Context context, String[] strArr, IPermissionCallBack iPermissionCallBack) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-359362151")) {
            ipChange.ipc$dispatch("-359362151", new Object[]{context, strArr, iPermissionCallBack});
        } else if (context == null) {
        } else {
            sPermissionCallBack = iPermissionCallBack;
            Intent intent = new Intent(context, PermissionDelegateActivity.class);
            intent.putExtra(EXTRA, strArr);
            intent.setFlags(268435456);
            context.startActivity(intent);
            if (context instanceof Activity) {
                ((Activity) context).overridePendingTransition(-1, -1);
            }
        }
    }

    @Override // android.app.Activity
    public void finish() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1884119051")) {
            ipChange.ipc$dispatch("-1884119051", new Object[]{this});
            return;
        }
        sPermissionCallBack = null;
        super.finish();
        overridePendingTransition(-1, -1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1951656793")) {
            ipChange.ipc$dispatch("-1951656793", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        String[] stringArrayExtra = getIntent().getStringArrayExtra(EXTRA);
        if (stringArrayExtra != null && stringArrayExtra.length > 0 && Build.VERSION.SDK_INT >= 23) {
            try {
                requestPermissions(stringArrayExtra, PERMISSION_REQUEST_CODE);
                return;
            } catch (ActivityNotFoundException unused) {
                finish();
                return;
            }
        }
        finish();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-518282499")) {
            return ((Boolean) ipChange.ipc$dispatch("-518282499", new Object[]{this, Integer.valueOf(i), keyEvent})).booleanValue();
        }
        if (i == 4) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        IPermissionCallBack iPermissionCallBack;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-423890335")) {
            ipChange.ipc$dispatch("-423890335", new Object[]{this, Integer.valueOf(i), strArr, iArr});
            return;
        }
        if (i == 4660 && (iPermissionCallBack = sPermissionCallBack) != null) {
            iPermissionCallBack.onPermissionFinish(strArr, iArr);
        }
        finish();
    }
}
