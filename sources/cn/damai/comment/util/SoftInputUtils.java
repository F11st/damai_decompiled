package cn.damai.comment.util;

import android.app.Activity;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.t60;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class SoftInputUtils {
    private static transient /* synthetic */ IpChange $ipChange;

    /* compiled from: Taobao */
    /* loaded from: classes13.dex */
    public interface OnSoftKeyboardChangeListener {
        void onSoftKeyBoardChange(int i, boolean z);
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.comment.util.SoftInputUtils$a */
    /* loaded from: classes13.dex */
    public class ViewTreeObserver$OnGlobalLayoutListenerC0454a implements ViewTreeObserver.OnGlobalLayoutListener {
        private static transient /* synthetic */ IpChange $ipChange;
        int a = -1;
        final /* synthetic */ View b;
        final /* synthetic */ OnSoftKeyboardChangeListener c;

        ViewTreeObserver$OnGlobalLayoutListenerC0454a(View view, OnSoftKeyboardChangeListener onSoftKeyboardChangeListener) {
            this.b = view;
            this.c = onSoftKeyboardChangeListener;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1004884393")) {
                ipChange.ipc$dispatch("1004884393", new Object[]{this});
                return;
            }
            Rect rect = new Rect();
            this.b.getWindowVisibleDisplayFrame(rect);
            int i = rect.bottom - rect.top;
            int height = this.b.getHeight();
            int i2 = height - i;
            if (this.a != i2) {
                this.c.onSoftKeyBoardChange(i2, !(((double) i) / ((double) height) > 0.8d));
            }
            this.a = height;
        }
    }

    public static void a(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "553053302")) {
            ipChange.ipc$dispatch("553053302", new Object[]{activity});
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
        if (AndroidInstantRuntime.support(ipChange, "18302093")) {
            return ((Boolean) ipChange.ipc$dispatch("18302093", new Object[]{activity, motionEvent})).booleanValue();
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

    public static void c(Activity activity, OnSoftKeyboardChangeListener onSoftKeyboardChangeListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "517298229")) {
            ipChange.ipc$dispatch("517298229", new Object[]{activity, onSoftKeyboardChangeListener});
            return;
        }
        View decorView = activity.getWindow().getDecorView();
        decorView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver$OnGlobalLayoutListenerC0454a(decorView, onSoftKeyboardChangeListener));
    }

    public static void d(Activity activity) {
        InputMethodManager inputMethodManager;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1976613745")) {
            ipChange.ipc$dispatch("1976613745", new Object[]{activity});
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
