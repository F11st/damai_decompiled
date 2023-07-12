package com.taobao.android.dinamicx.view.richtext;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.taobao.android.dinamicx.view.richtext.span.CloneableLongClickSpan;
import com.taobao.android.dinamicx.view.richtext.span.CloneableNoStyleClickSpan;
import tb.q32;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class DXNativeRichText extends View {
    private CheckForLongPressList mCheckForLongPressList;
    private boolean mHasPerformedLongPress;
    private q32 mRichTextRender;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public final class CheckForLongPressList implements Runnable {
        private CloneableLongClickSpan[] mLongClickSpans;
        private boolean mOriginalPressedState;
        private int mOriginalWindowAttachCount;

        public void rememberPressedState() {
            this.mOriginalPressedState = DXNativeRichText.this.isPressed();
        }

        public void rememberWindowAttachCount() {
            this.mOriginalWindowAttachCount = DXNativeRichText.this.getWindowAttachCount();
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mOriginalPressedState == DXNativeRichText.this.isPressed() && DXNativeRichText.this.getParent() != null && this.mOriginalWindowAttachCount == DXNativeRichText.this.getWindowAttachCount()) {
                boolean z = false;
                for (CloneableLongClickSpan cloneableLongClickSpan : this.mLongClickSpans) {
                    z = z || cloneableLongClickSpan.onLongClick(DXNativeRichText.this);
                }
                DXNativeRichText.this.mHasPerformedLongPress = z;
            }
        }

        private CheckForLongPressList(CloneableLongClickSpan[] cloneableLongClickSpanArr) {
            this.mLongClickSpans = cloneableLongClickSpanArr;
        }
    }

    public DXNativeRichText(Context context) {
        super(context);
        this.mHasPerformedLongPress = false;
    }

    private void checkForLongClicks(long j, CloneableLongClickSpan[] cloneableLongClickSpanArr) {
        this.mHasPerformedLongPress = false;
        CheckForLongPressList checkForLongPressList = new CheckForLongPressList(cloneableLongClickSpanArr);
        this.mCheckForLongPressList = checkForLongPressList;
        checkForLongPressList.rememberPressedState();
        this.mCheckForLongPressList.rememberWindowAttachCount();
        postDelayed(this.mCheckForLongPressList, j);
    }

    private void removeLongPressCallbacks() {
        CheckForLongPressList checkForLongPressList = this.mCheckForLongPressList;
        if (checkForLongPressList != null) {
            removeCallbacks(checkForLongPressList);
        }
    }

    public q32 getRichTextRender() {
        return this.mRichTextRender;
    }

    public boolean handleSpanTouchEvent(MotionEvent motionEvent) {
        boolean z;
        boolean z2;
        q32 q32Var = this.mRichTextRender;
        if (q32Var == null) {
            return false;
        }
        int n = q32Var.n(motionEvent.getX(), motionEvent.getY());
        CloneableNoStyleClickSpan[] cloneableNoStyleClickSpanArr = (CloneableNoStyleClickSpan[]) this.mRichTextRender.m(n, n, CloneableNoStyleClickSpan.class);
        if (cloneableNoStyleClickSpanArr != null) {
            z = false;
            for (CloneableNoStyleClickSpan cloneableNoStyleClickSpan : cloneableNoStyleClickSpanArr) {
                z = z || cloneableNoStyleClickSpan.getClickDelegate() != null;
            }
        } else {
            z = false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            CloneableLongClickSpan[] cloneableLongClickSpanArr = (CloneableLongClickSpan[]) this.mRichTextRender.m(n, n, CloneableLongClickSpan.class);
            if (cloneableLongClickSpanArr == null || cloneableLongClickSpanArr.length == 0) {
                z2 = false;
            } else {
                z2 = false;
                for (CloneableLongClickSpan cloneableLongClickSpan : cloneableLongClickSpanArr) {
                    z2 = z2 || cloneableLongClickSpan.getLongClickSpanDelegate() != null;
                }
                if (z2) {
                    setPressed(true);
                    checkForLongClicks(ViewConfiguration.getLongPressTimeout(), cloneableLongClickSpanArr);
                }
            }
            return z || z2;
        }
        if (action != 1) {
            if (action == 3) {
                setPressed(false);
            }
        } else if (this.mHasPerformedLongPress) {
            return true;
        } else {
            removeLongPressCallbacks();
            if (z) {
                for (CloneableNoStyleClickSpan cloneableNoStyleClickSpan2 : cloneableNoStyleClickSpanArr) {
                    if (cloneableNoStyleClickSpan2.getClickDelegate() != null) {
                        cloneableNoStyleClickSpan2.onClick(this);
                    }
                }
                return true;
            }
        }
        return false;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        q32 q32Var = this.mRichTextRender;
        if (q32Var == null) {
            return;
        }
        q32Var.d(canvas);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (handleSpanTouchEvent(motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setRichTextRender(q32 q32Var) {
        this.mRichTextRender = q32Var;
    }

    public DXNativeRichText(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mHasPerformedLongPress = false;
    }

    public DXNativeRichText(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mHasPerformedLongPress = false;
    }

    @RequiresApi(api = 21)
    public DXNativeRichText(Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mHasPerformedLongPress = false;
    }
}
