package com.youku.resource.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import com.taobao.phenix.intf.event.IPhenixListener;
import com.youku.resource.R;
import com.youku.resource.utils.Utils;
import org.apache.commons.lang3.CharUtils;
import tb.ui2;
import tb.ur1;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class YKTextView extends AppCompatTextView implements YKCustomizedView {
    public static final String STYLE_1_A = "text_view_1a";
    public static final String STYLE_1_B = "text_view_1b";
    public static final String STYLE_2_A = "text_view_2a";
    public static final String STYLE_2_B = "text_view_2b";
    public static final String STYLE_3_A = "text_view_3a";
    public static final String STYLE_3_B = "text_view_3b";
    public static final String STYLE_3_C = "text_view_3c";
    public static final String STYLE_4_A = "text_view_4a";
    public static final String STYLE_4_B = "text_view_4b";
    public static final String STYLE_4_C = "text_view_4c";
    public static final String STYLE_5_A = "text_view_5a";
    public static final String STYLE_5_B = "text_view_5b";
    public static final String STYLE_5_C = "text_view_5c";
    public static final String STYLE_6_A = "text_view_6a";
    public static final String STYLE_6_B = "text_view_6b";
    public static final String STYLE_6_C = "text_view_6c";
    public static final String STYLE_7_A = "text_view_7a";
    public static final String STYLE_7_B = "text_view_7b";
    public static final String STYLE_7_C = "text_view_7c";
    public static final String STYLE_8_A = "text_view_8a";
    public static final String STYLE_9_A = "text_view_9a";
    private String mTextStyle;
    private int paddingLeft;
    private YKTextView ykTextView;

    public YKTextView(Context context) {
        super(context);
        init(context, null);
    }

    public void hideAll() {
        this.ykTextView.setCompoundDrawables(null, null, null, null);
    }

    @Override // com.youku.resource.widget.YKCustomizedView
    public void init(Context context, AttributeSet attributeSet) {
        this.ykTextView = this;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.YKTextView, 0, 0);
            int i = R.styleable.YKTextView_text_padding_left;
            if (obtainStyledAttributes.getResourceId(i, 0) != 0) {
                this.paddingLeft = getResources().getDimensionPixelOffset(obtainStyledAttributes.getResourceId(i, 0));
            } else {
                try {
                    this.paddingLeft = obtainStyledAttributes.getDimensionPixelOffset(i, 0);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (this.paddingLeft != 0 && getPaddingLeft() == 0) {
                setPadding(this.paddingLeft, getPaddingTop(), getPaddingRight(), getPaddingBottom());
            }
            obtainStyledAttributes.recycle();
        }
    }

    public void setBold(boolean z) {
        if (z) {
            setTypeface(Typeface.DEFAULT, 1);
        } else {
            setTypeface(Typeface.DEFAULT, 0);
        }
    }

    public void setLeftIcon(Drawable drawable, int i) {
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.resource_size_14);
        setLeftIcon(drawable, i, dimensionPixelOffset, dimensionPixelOffset);
    }

    public void setStyle(String str) {
        setSingleLine(false);
        setMaxLines(1);
        setLines(1);
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1815387880:
                if (str.equals(STYLE_1_A)) {
                    c = 0;
                    break;
                }
                break;
            case -1815387879:
                if (str.equals(STYLE_1_B)) {
                    c = 1;
                    break;
                }
                break;
            case -1815387849:
                if (str.equals(STYLE_2_A)) {
                    c = 2;
                    break;
                }
                break;
            case -1815387848:
                if (str.equals(STYLE_2_B)) {
                    c = 3;
                    break;
                }
                break;
            case -1815387818:
                if (str.equals(STYLE_3_A)) {
                    c = 4;
                    break;
                }
                break;
            case -1815387817:
                if (str.equals(STYLE_3_B)) {
                    c = 5;
                    break;
                }
                break;
            case -1815387816:
                if (str.equals(STYLE_3_C)) {
                    c = 6;
                    break;
                }
                break;
            case -1815387787:
                if (str.equals(STYLE_4_A)) {
                    c = 7;
                    break;
                }
                break;
            case -1815387786:
                if (str.equals(STYLE_4_B)) {
                    c = '\b';
                    break;
                }
                break;
            case -1815387785:
                if (str.equals(STYLE_4_C)) {
                    c = '\t';
                    break;
                }
                break;
            case -1815387756:
                if (str.equals(STYLE_5_A)) {
                    c = '\n';
                    break;
                }
                break;
            case -1815387755:
                if (str.equals(STYLE_5_B)) {
                    c = 11;
                    break;
                }
                break;
            case -1815387754:
                if (str.equals(STYLE_5_C)) {
                    c = '\f';
                    break;
                }
                break;
            case -1815387725:
                if (str.equals(STYLE_6_A)) {
                    c = CharUtils.CR;
                    break;
                }
                break;
            case -1815387724:
                if (str.equals(STYLE_6_B)) {
                    c = 14;
                    break;
                }
                break;
            case -1815387723:
                if (str.equals(STYLE_6_C)) {
                    c = 15;
                    break;
                }
                break;
            case -1815387694:
                if (str.equals(STYLE_7_A)) {
                    c = 16;
                    break;
                }
                break;
            case -1815387693:
                if (str.equals(STYLE_7_B)) {
                    c = 17;
                    break;
                }
                break;
            case -1815387692:
                if (str.equals(STYLE_7_C)) {
                    c = 18;
                    break;
                }
                break;
            case -1815387663:
                if (str.equals(STYLE_8_A)) {
                    c = 19;
                    break;
                }
                break;
            case -1815387632:
                if (str.equals(STYLE_9_A)) {
                    c = 20;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                setTextSize(0, getResources().getDimension(R.dimen.font_size_big1));
                setTypeface(Typeface.defaultFromStyle(1));
                setSingleLine(true);
                setEllipsize(TextUtils.TruncateAt.END);
                setTextColor(getResources().getColor(R.C8071color.ykn_primary_info));
                return;
            case 1:
                setTextSize(0, getResources().getDimension(R.dimen.font_size_big1));
                setTypeface(Typeface.defaultFromStyle(0));
                setSingleLine(true);
                setEllipsize(TextUtils.TruncateAt.END);
                setTextColor(getResources().getColor(R.C8071color.ykn_primary_info));
                return;
            case 2:
                setTextSize(0, getResources().getDimension(R.dimen.font_size_big2));
                setTypeface(Typeface.defaultFromStyle(1));
                setSingleLine(true);
                setEllipsize(TextUtils.TruncateAt.END);
                setTextColor(getResources().getColor(R.C8071color.ykn_primary_info));
                return;
            case 3:
                setTextSize(0, getResources().getDimension(R.dimen.font_size_big2));
                setTypeface(Typeface.defaultFromStyle(0));
                setSingleLine(true);
                setEllipsize(TextUtils.TruncateAt.END);
                setTextColor(getResources().getColor(R.C8071color.ykn_primary_info));
                return;
            case 4:
                setTextSize(0, getResources().getDimension(R.dimen.font_size_big3));
                setTypeface(Typeface.defaultFromStyle(1));
                setSingleLine(true);
                setEllipsize(TextUtils.TruncateAt.END);
                setTextColor(getResources().getColor(R.C8071color.ykn_primary_info));
                return;
            case 5:
                setTextSize(0, getResources().getDimension(R.dimen.font_size_big3));
                setTypeface(Typeface.defaultFromStyle(0));
                setSingleLine(true);
                setEllipsize(TextUtils.TruncateAt.END);
                setTextColor(getResources().getColor(R.C8071color.ykn_primary_info));
                return;
            case 6:
                setTextSize(0, getResources().getDimension(R.dimen.font_size_big3));
                setTypeface(Typeface.defaultFromStyle(0));
                setMaxLines(2);
                setSingleLine(false);
                setEllipsize(TextUtils.TruncateAt.END);
                setTextColor(getResources().getColor(R.C8071color.ykn_primary_info));
                return;
            case 7:
                setTextSize(0, getResources().getDimension(R.dimen.font_size_middle2));
                setTypeface(Typeface.defaultFromStyle(1));
                setSingleLine(true);
                setEllipsize(TextUtils.TruncateAt.END);
                setTextColor(getResources().getColor(R.C8071color.ykn_primary_info));
                return;
            case '\b':
                setTextSize(0, getResources().getDimension(R.dimen.font_size_middle2));
                setTypeface(Typeface.defaultFromStyle(0));
                setSingleLine(true);
                setEllipsize(TextUtils.TruncateAt.END);
                setTextColor(getResources().getColor(R.C8071color.ykn_primary_info));
                return;
            case '\t':
                setTextSize(0, getResources().getDimension(R.dimen.font_size_middle2));
                setTypeface(Typeface.defaultFromStyle(0));
                setMaxLines(2);
                setSingleLine(false);
                setEllipsize(TextUtils.TruncateAt.END);
                setTextColor(getResources().getColor(R.C8071color.ykn_primary_info));
                return;
            case '\n':
                setTextSize(0, getResources().getDimension(R.dimen.font_size_middle2));
                setTypeface(Typeface.defaultFromStyle(1));
                setSingleLine(true);
                setEllipsize(TextUtils.TruncateAt.END);
                setTextColor(getResources().getColor(R.C8071color.ykn_primary_info));
                return;
            case 11:
                setTextSize(0, getResources().getDimension(R.dimen.font_size_middle2));
                setTypeface(Typeface.defaultFromStyle(0));
                setSingleLine(true);
                setEllipsize(TextUtils.TruncateAt.END);
                setTextColor(getResources().getColor(R.C8071color.ykn_primary_info));
                return;
            case '\f':
                setTextSize(0, getResources().getDimension(R.dimen.font_size_middle2));
                setTypeface(Typeface.defaultFromStyle(0));
                setMaxLines(2);
                setSingleLine(false);
                setEllipsize(TextUtils.TruncateAt.END);
                setTextColor(getResources().getColor(R.C8071color.ykn_primary_info));
                return;
            case '\r':
                setTextSize(0, getResources().getDimension(R.dimen.font_size_middle3));
                setTypeface(Typeface.defaultFromStyle(1));
                setSingleLine(true);
                setEllipsize(TextUtils.TruncateAt.END);
                setTextColor(getResources().getColor(R.C8071color.ykn_tertiary_info));
                return;
            case 14:
                setTextSize(0, getResources().getDimension(R.dimen.font_size_middle3));
                setTypeface(Typeface.defaultFromStyle(0));
                setSingleLine(true);
                setEllipsize(TextUtils.TruncateAt.END);
                setTextColor(getResources().getColor(R.C8071color.ykn_tertiary_info));
                return;
            case 15:
                setTextSize(0, getResources().getDimension(R.dimen.font_size_middle3));
                setTypeface(Typeface.defaultFromStyle(0));
                setMaxLines(2);
                setSingleLine(false);
                setEllipsize(TextUtils.TruncateAt.END);
                setTextColor(getResources().getColor(R.C8071color.ykn_tertiary_info));
                return;
            case 16:
                setTextSize(0, getResources().getDimension(R.dimen.font_size_middle4));
                setTypeface(Typeface.defaultFromStyle(1));
                setSingleLine(true);
                setEllipsize(TextUtils.TruncateAt.END);
                setTextColor(getResources().getColor(R.C8071color.ykn_tertiary_info));
                return;
            case 17:
                setTextSize(0, getResources().getDimension(R.dimen.font_size_middle4));
                setTypeface(Typeface.defaultFromStyle(0));
                setSingleLine(true);
                setEllipsize(TextUtils.TruncateAt.END);
                setTextColor(getResources().getColor(R.C8071color.ykn_tertiary_info));
                return;
            case 18:
                setTextSize(0, getResources().getDimension(R.dimen.font_size_middle4));
                setTypeface(Typeface.defaultFromStyle(0));
                setMaxLines(2);
                setSingleLine(false);
                setEllipsize(TextUtils.TruncateAt.END);
                setTextColor(getResources().getColor(R.C8071color.ykn_tertiary_info));
                return;
            case 19:
                setTextSize(0, getResources().getDimension(R.dimen.font_size_small1));
                setTypeface(Typeface.defaultFromStyle(1));
                setSingleLine(true);
                setEllipsize(TextUtils.TruncateAt.END);
                setTextColor(getResources().getColor(R.C8071color.ykn_primary_info));
                return;
            case 20:
                setTextSize(0, getResources().getDimension(R.dimen.font_size_small2));
                setTypeface(Typeface.defaultFromStyle(1));
                setSingleLine(true);
                setEllipsize(TextUtils.TruncateAt.END);
                setTextColor(getResources().getColor(R.C8071color.ykn_primary_info));
                return;
            default:
                return;
        }
    }

    public YKTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public void setLeftIcon(Drawable drawable, int i, int i2, int i3) {
        Drawable zoomDrawable = Utils.zoomDrawable(drawable, getResources(), i2, i3);
        if (zoomDrawable != null) {
            zoomDrawable.setBounds(0, 0, i2, i3);
        }
        this.ykTextView.setCompoundDrawablePadding(i);
        this.ykTextView.setCompoundDrawables(zoomDrawable, null, null, null);
    }

    public void setLeftIcon(String str, int i) {
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.resource_size_14);
        setLeftIcon(str, i, dimensionPixelOffset, dimensionPixelOffset);
    }

    public void setLeftIcon(String str, final int i, final int i2, final int i3) {
        ur1.o().s(str).Q(new IPhenixListener<ui2>() { // from class: com.youku.resource.widget.YKTextView.1
            @Override // com.taobao.phenix.intf.event.IPhenixListener
            public boolean onHappen(ui2 ui2Var) {
                if (ui2Var.f() == null || ui2Var.i()) {
                    return true;
                }
                Drawable zoomDrawable = Utils.zoomDrawable(ui2Var.f(), YKTextView.this.getResources(), i2, i3);
                YKTextView.this.ykTextView.setCompoundDrawablePadding(i);
                YKTextView.this.ykTextView.setCompoundDrawablesWithIntrinsicBounds(zoomDrawable, (Drawable) null, (Drawable) null, (Drawable) null);
                return true;
            }
        }).n();
    }
}
