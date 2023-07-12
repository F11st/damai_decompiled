package cn.damai.mine.util;

import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.LinkedList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class KeyBoardHelper implements ViewTreeObserver.OnGlobalLayoutListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private final List<SoftKeyboardStateListener> a;
    private final View b;
    private boolean c;

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public interface SoftKeyboardStateListener {
        void onSoftKeyboardClosed();

        void onSoftKeyboardOpened(int i);
    }

    public KeyBoardHelper(View view) {
        this(view, false);
    }

    private void b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2018202695")) {
            ipChange.ipc$dispatch("-2018202695", new Object[]{this});
            return;
        }
        for (SoftKeyboardStateListener softKeyboardStateListener : this.a) {
            if (softKeyboardStateListener != null) {
                softKeyboardStateListener.onSoftKeyboardClosed();
            }
        }
    }

    private void c(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "471424743")) {
            ipChange.ipc$dispatch("471424743", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        for (SoftKeyboardStateListener softKeyboardStateListener : this.a) {
            if (softKeyboardStateListener != null) {
                softKeyboardStateListener.onSoftKeyboardOpened(i);
            }
        }
    }

    public void a(SoftKeyboardStateListener softKeyboardStateListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-992134139")) {
            ipChange.ipc$dispatch("-992134139", new Object[]{this, softKeyboardStateListener});
        } else {
            this.a.add(softKeyboardStateListener);
        }
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "665768914")) {
            ipChange.ipc$dispatch("665768914", new Object[]{this});
            return;
        }
        Rect rect = new Rect();
        this.b.getWindowVisibleDisplayFrame(rect);
        int height = this.b.getRootView().getHeight() - (rect.bottom - rect.top);
        Log.d("SoftKeyboardStateHelper", "heightDiff:" + height);
        boolean z = this.c;
        if (!z && height > 500) {
            this.c = true;
            c(height);
        } else if (!z || height >= 500) {
        } else {
            this.c = false;
            b();
        }
    }

    public KeyBoardHelper(View view, boolean z) {
        this.a = new LinkedList();
        this.b = view;
        this.c = z;
        view.getViewTreeObserver().addOnGlobalLayoutListener(this);
    }
}
