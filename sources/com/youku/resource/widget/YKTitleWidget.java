package com.youku.resource.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewStub;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.taobao.uikit.extend.feature.view.TUrlImageView;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class YKTitleWidget extends LinearLayout implements YKCustomizedView {
    public static final String TITLE_STYLE_1 = "title_1";
    public static final String TITLE_STYLE_2 = "title_2";
    public static final String TITLE_STYLE_3 = "title_3";
    public static final String TITLE_STYLE_4 = "title_4";
    public static final String TITLE_STYLE_5 = "title_5";
    public static final String TITLE_STYLE_6 = "title_6";
    private TUrlImageView deleteIcon;
    private TUrlImageView leftIcon;
    private TUrlImageView navArrow;
    private YKTextView navHint;
    private TUrlImageView navIcon;
    private YKTextView textContext1;
    private YKTextView textContext2;
    private YKTextView textContext3;
    private TUrlImageView titleImg;
    private ViewStub titleImgVb;
    private String titleStyle;

    public YKTitleWidget(Context context) {
        super(context);
        init(context, null);
    }

    public TUrlImageView getDeleteIcon() {
        return this.deleteIcon;
    }

    public TUrlImageView getLeftIcon() {
        return this.leftIcon;
    }

    public TUrlImageView getNavArrow() {
        return this.navArrow;
    }

    public YKTextView getNavHint() {
        return this.navHint;
    }

    public TUrlImageView getNavIcon() {
        return this.navIcon;
    }

    public YKTextView getTextContext1() {
        return this.textContext1;
    }

    public YKTextView getTextContext2() {
        return this.textContext2;
    }

    public YKTextView getTextContext3() {
        return this.textContext3;
    }

    public TUrlImageView getTitleImg() {
        return this.titleImg;
    }

    public ViewStub getTitleImgVb() {
        return this.titleImgVb;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0069, code lost:
        if (r0.equals(com.youku.resource.widget.YKTitleWidget.TITLE_STYLE_1) == false) goto L6;
     */
    @Override // com.youku.resource.widget.YKCustomizedView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void init(android.content.Context r6, android.util.AttributeSet r7) {
        /*
            Method dump skipped, instructions count: 258
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youku.resource.widget.YKTitleWidget.init(android.content.Context, android.util.AttributeSet):void");
    }

    public void reset() {
        TUrlImageView tUrlImageView = this.leftIcon;
        if (tUrlImageView != null) {
            tUrlImageView.setVisibility(8);
        }
        TUrlImageView tUrlImageView2 = this.deleteIcon;
        if (tUrlImageView2 != null) {
            tUrlImageView2.setVisibility(8);
        }
        YKTextView yKTextView = this.navHint;
        if (yKTextView != null) {
            yKTextView.setVisibility(8);
        }
        TUrlImageView tUrlImageView3 = this.navIcon;
        if (tUrlImageView3 != null) {
            tUrlImageView3.setVisibility(8);
        }
        TUrlImageView tUrlImageView4 = this.navArrow;
        if (tUrlImageView4 != null) {
            tUrlImageView4.setVisibility(8);
        }
        TUrlImageView tUrlImageView5 = this.titleImg;
        if (tUrlImageView5 != null) {
            tUrlImageView5.setVisibility(8);
        }
    }

    public YKTitleWidget(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }
}
