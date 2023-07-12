package com.youku.widget;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;
import java.util.ArrayList;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class TouchDelegateGroup extends TouchDelegate {
    private static final Rect USELESS_HACKY_RECT = new Rect();
    private TouchDelegate mCurrentTouchDelegate;
    private ArrayList<TouchDelegate> mTouchDelegates;

    public TouchDelegateGroup(View view) {
        super(USELESS_HACKY_RECT, view);
    }

    public void addTouchDelegate(TouchDelegate touchDelegate) {
        if (this.mTouchDelegates == null) {
            this.mTouchDelegates = new ArrayList<>();
        }
        this.mTouchDelegates.add(touchDelegate);
    }

    public void clearTouchDelegates() {
        ArrayList<TouchDelegate> arrayList = this.mTouchDelegates;
        if (arrayList != null) {
            arrayList.clear();
        }
        this.mCurrentTouchDelegate = null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x000e, code lost:
        if (r0 != 3) goto L8;
     */
    @Override // android.view.TouchDelegate
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            int r0 = r6.getAction()
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L1a
            if (r0 == r1) goto L14
            r1 = 2
            if (r0 == r1) goto L11
            r1 = 3
            if (r0 == r1) goto L14
            goto L39
        L11:
            android.view.TouchDelegate r2 = r5.mCurrentTouchDelegate
            goto L39
        L14:
            android.view.TouchDelegate r0 = r5.mCurrentTouchDelegate
            r5.mCurrentTouchDelegate = r2
            r2 = r0
            goto L39
        L1a:
            java.util.ArrayList<android.view.TouchDelegate> r0 = r5.mTouchDelegates
            if (r0 == 0) goto L39
            java.util.Iterator r0 = r0.iterator()
        L22:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L39
            java.lang.Object r3 = r0.next()
            android.view.TouchDelegate r3 = (android.view.TouchDelegate) r3
            if (r3 == 0) goto L22
            boolean r4 = r3.onTouchEvent(r6)
            if (r4 == 0) goto L22
            r5.mCurrentTouchDelegate = r3
            return r1
        L39:
            if (r2 != 0) goto L3d
            r6 = 0
            goto L41
        L3d:
            boolean r6 = r2.onTouchEvent(r6)
        L41:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youku.widget.TouchDelegateGroup.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void removeTouchDelegate(TouchDelegate touchDelegate) {
        ArrayList<TouchDelegate> arrayList = this.mTouchDelegates;
        if (arrayList != null) {
            arrayList.remove(touchDelegate);
            if (this.mTouchDelegates.isEmpty()) {
                this.mTouchDelegates = null;
            }
        }
    }
}
