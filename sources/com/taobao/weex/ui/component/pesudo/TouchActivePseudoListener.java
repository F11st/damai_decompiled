package com.taobao.weex.ui.component.pesudo;

import android.annotation.SuppressLint;
import android.view.MotionEvent;
import android.view.View;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class TouchActivePseudoListener implements View.OnTouchListener {
    private boolean mIsConsumeOnTouch;
    private OnActivePseudoListner mOnActivePseudoListner;

    public TouchActivePseudoListener(OnActivePseudoListner onActivePseudoListner, boolean z) {
        this.mOnActivePseudoListner = onActivePseudoListner;
        this.mIsConsumeOnTouch = z;
    }

    @Override // android.view.View.OnTouchListener
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        OnActivePseudoListner onActivePseudoListner = this.mOnActivePseudoListner;
        if (onActivePseudoListner != null) {
            if (action == 0 || action == 5) {
                onActivePseudoListner.updateActivePseudo(true);
            } else if (action == 3 || action == 1 || action == 6) {
                onActivePseudoListner.updateActivePseudo(false);
            }
        }
        return this.mIsConsumeOnTouch;
    }
}
