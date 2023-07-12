package cn.damai.discover.content.util;

import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.t60;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class SoftInputUtils {
    private static transient /* synthetic */ IpChange $ipChange;

    /* compiled from: Taobao */
    /* loaded from: classes14.dex */
    public interface OnSoftKeyboardChangeListener {
        void onSoftKeyBoardChange(int i, boolean z);
    }

    public static void a(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-411813564")) {
            ipChange.ipc$dispatch("-411813564", new Object[]{activity});
            return;
        }
        View currentFocus = activity.getCurrentFocus();
        if (currentFocus != null) {
            try {
                ((InputMethodManager) activity.getSystemService("input_method")).hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean b(Activity activity, MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1543719295")) {
            return ((Boolean) ipChange.ipc$dispatch("1543719295", new Object[]{activity, motionEvent})).booleanValue();
        }
        View currentFocus = activity.getCurrentFocus();
        if (currentFocus == null || !(currentFocus instanceof EditText)) {
            return false;
        }
        int[] iArr = {0, 0};
        currentFocus.getLocationInWindow(iArr);
        int i = iArr[0];
        int i2 = iArr[1];
        return motionEvent.getX() <= ((float) i) || motionEvent.getX() >= ((float) DisplayMetrics.getwidthPixels(t60.b(activity))) || motionEvent.getY() <= ((float) i2) || motionEvent.getY() >= ((float) (currentFocus.getHeight() + i2));
    }

    public static void c(Activity activity) {
        InputMethodManager inputMethodManager;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1011746879")) {
            ipChange.ipc$dispatch("1011746879", new Object[]{activity});
            return;
        }
        View currentFocus = activity.getCurrentFocus();
        if (currentFocus == null || (inputMethodManager = (InputMethodManager) activity.getSystemService("input_method")) == null) {
            return;
        }
        currentFocus.setFocusable(true);
        currentFocus.requestFocus();
        inputMethodManager.showSoftInput(currentFocus, 2);
    }
}
