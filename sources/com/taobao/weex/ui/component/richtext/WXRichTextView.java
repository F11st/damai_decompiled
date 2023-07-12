package com.taobao.weex.ui.component.richtext;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.Spanned;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import com.taobao.weex.ui.component.richtext.span.ImgSpan;
import com.taobao.weex.ui.view.WXTextView;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class WXRichTextView extends WXTextView {
    public WXRichTextView(Context context) {
        super(context);
    }

    private boolean updateSelection(MotionEvent motionEvent, Spannable spannable) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 1 || actionMasked == 0) {
            int x = ((int) motionEvent.getX()) - getPaddingLeft();
            int y = ((int) motionEvent.getY()) - getPaddingTop();
            int scrollX = x + getScrollX();
            int scrollY = y + getScrollY();
            Layout textLayout = getTextLayout();
            int offsetForHorizontal = textLayout.getOffsetForHorizontal(textLayout.getLineForVertical(scrollY), scrollX);
            Object[] objArr = (ClickableSpan[]) spannable.getSpans(offsetForHorizontal, offsetForHorizontal, ClickableSpan.class);
            if (objArr.length != 0) {
                if (actionMasked == 1) {
                    objArr[0].onClick(this);
                } else {
                    Selection.setSelection(spannable, spannable.getSpanStart(objArr[0]), spannable.getSpanEnd(objArr[0]));
                }
                return true;
            }
            Selection.removeSelection(spannable);
        }
        return false;
    }

    @Override // com.taobao.weex.ui.view.WXTextView, android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return ((!isEnabled() || getTextLayout() == null || !(getText() instanceof Spannable)) ? false : updateSelection(motionEvent, (Spannable) getText())) || super.onTouchEvent(motionEvent);
    }

    @Override // com.taobao.weex.ui.view.WXTextView
    public void setTextLayout(Layout layout) {
        super.setTextLayout(layout);
        if (layout.getText() instanceof Spanned) {
            Spanned spanned = (Spanned) layout.getText();
            ImgSpan[] imgSpanArr = (ImgSpan[]) spanned.getSpans(0, spanned.length(), ImgSpan.class);
            if (imgSpanArr != null) {
                for (ImgSpan imgSpan : imgSpanArr) {
                    imgSpan.setView(this);
                }
            }
        }
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        super.verifyDrawable(drawable);
        return true;
    }
}
