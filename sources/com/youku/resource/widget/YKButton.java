package com.youku.resource.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatButton;
import com.youku.resource.R;
import com.youku.resource.utils.ColorConfigureManager;
import com.youku.resource.utils.StaticColorDefine;
import com.youku.resource.utils.Utils;
import org.apache.commons.lang3.CharUtils;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class YKButton extends AppCompatButton implements YKCustomizedView {
    public static final String BUTTON_GHOST_MIDDLE_X = "button_ghost_middle_x";
    public static final String BUTTON_GHOST_MIDDLE_XX = "button_ghost_middle_xx";
    public static final String BUTTON_GHOST_SMALL = "button_ghost_small";
    public static final String BUTTON_GRADIENT = "button_gradient";
    public static final String BUTTON_LIGHT_MIDDLE_X = "button_light_middle_x";
    public static final String BUTTON_LIGHT_MIDDLE_XX = "button_light_middle_xx";
    public static final String BUTTON_LIGHT_SMALL = "button_light_small";
    public static final String BUTTON_NORMAL_LARGE = "button_normal_large";
    public static final String BUTTON_NORMAL_MIDDLE_X = "button_normal_middle_x";
    public static final String BUTTON_NORMAL_MIDDLE_XX = "button_normal_middle_xx";
    public static final String BUTTON_NORMAL_SMALL = "button_normal_small";
    public static final String BUTTON_PRIMARY_LARGE = "button_primary_large";
    public static final String BUTTON_PROMARY_MIDDLE_X = "button_primary_middle_x";
    public static final String BUTTON_PROMARY_MIDDLE_XX = "button_primary_middle_xx";
    public static final String BUTTON_PROMARY_SMALL = "button_primary_small";
    public static final String BUTTON_SECONDARY = "button_secondary";
    public static final String BUTTON_VIP = "button_vip";
    public static final String BUTTON_VIP_GHOST = "button_vip_ghost";
    public static final String BUTTON_VIP_SALE = "button_vip_sale";
    public static final String BUTTON_WARNING_LARGE = "button_warning_large";
    public static final String BUTTON_WARNING_MIDDLE_X = "button_warning_middle_x";
    public static final String BUTTON_WARNING_MIDDLE_XX = "button_warning_middle_xx";
    public static final String BUTTON_WARNING_SMALL = "button_warning_small";
    private static final int[][] states = {new int[]{16842910, 16842919}, new int[]{16842910, 16842908}, new int[]{16842910}, new int[]{-16842910}};
    private boolean pressedMask;

    public YKButton(Context context) {
        super(context);
        this.pressedMask = true;
        init(context, null);
    }

    private StateListDrawable getStateListDrawable(String str) {
        GradientDrawable drawable;
        Drawable drawable2;
        Drawable drawable3;
        StateListDrawable stateListDrawable = new StateListDrawable();
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -2078160725:
                if (str.equals(BUTTON_GHOST_MIDDLE_X)) {
                    c = 0;
                    break;
                }
                break;
            case -1910335712:
                if (str.equals(BUTTON_VIP_GHOST)) {
                    c = 1;
                    break;
                }
                break;
            case -1669794502:
                if (str.equals(BUTTON_WARNING_MIDDLE_XX)) {
                    c = 2;
                    break;
                }
                break;
            case -1647461209:
                if (str.equals(BUTTON_SECONDARY)) {
                    c = 3;
                    break;
                }
                break;
            case -1644823041:
                if (str.equals(BUTTON_NORMAL_MIDDLE_XX)) {
                    c = 4;
                    break;
                }
                break;
            case -1045497443:
                if (str.equals(BUTTON_GRADIENT)) {
                    c = 5;
                    break;
                }
                break;
            case -805843183:
                if (str.equals(BUTTON_LIGHT_SMALL)) {
                    c = 6;
                    break;
                }
                break;
            case -628892940:
                if (str.equals(BUTTON_LIGHT_MIDDLE_XX)) {
                    c = 7;
                    break;
                }
                break;
            case -133619061:
                if (str.equals(BUTTON_WARNING_LARGE)) {
                    c = '\b';
                    break;
                }
                break;
            case -133474864:
                if (str.equals(BUTTON_NORMAL_LARGE)) {
                    c = '\t';
                    break;
                }
                break;
            case -126813097:
                if (str.equals(BUTTON_WARNING_SMALL)) {
                    c = '\n';
                    break;
                }
                break;
            case -126668900:
                if (str.equals(BUTTON_NORMAL_SMALL)) {
                    c = 11;
                    break;
                }
                break;
            case 1527085:
                if (str.equals(BUTTON_GHOST_MIDDLE_XX)) {
                    c = '\f';
                    break;
                }
                break;
            case 201803210:
                if (str.equals(BUTTON_GHOST_SMALL)) {
                    c = CharUtils.CR;
                    break;
                }
                break;
            case 354368918:
                if (str.equals(BUTTON_VIP_SALE)) {
                    c = 14;
                    break;
                }
                break;
            case 358888848:
                if (str.equals(BUTTON_VIP)) {
                    c = 15;
                    break;
                }
                break;
            case 638872318:
                if (str.equals(BUTTON_WARNING_MIDDLE_X)) {
                    c = 16;
                    break;
                }
                break;
            case 639677849:
                if (str.equals(BUTTON_NORMAL_MIDDLE_X)) {
                    c = 17;
                    break;
                }
                break;
            case 949544452:
                if (str.equals(BUTTON_LIGHT_MIDDLE_X)) {
                    c = 18;
                    break;
                }
                break;
            case 1451876184:
                if (str.equals(BUTTON_PROMARY_MIDDLE_X)) {
                    c = 19;
                    break;
                }
                break;
            case 2055052401:
                if (str.equals(BUTTON_PRIMARY_LARGE)) {
                    c = 20;
                    break;
                }
                break;
            case 2058488864:
                if (str.equals(BUTTON_PROMARY_MIDDLE_XX)) {
                    c = 21;
                    break;
                }
                break;
            case 2061858365:
                if (str.equals(BUTTON_PROMARY_SMALL)) {
                    c = 22;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
            case '\f':
            case '\r':
                Resources resources = getResources();
                int i = R.color.cb_1;
                int color = resources.getColor(i);
                int colorIntWithAlpha = ColorConfigureManager.getInstance().getColorIntWithAlpha(StaticColorDefine.CB_1, 30);
                Resources resources2 = getResources();
                int i2 = R.dimen.button_stroke_width;
                int dimensionPixelOffset = resources2.getDimensionPixelOffset(i2);
                Resources resources3 = getResources();
                int i3 = R.dimen.button_large_h;
                drawable = Utils.getDrawable(color, colorIntWithAlpha, dimensionPixelOffset, resources3.getDimension(i3) / 2.0f, 255);
                drawable2 = Utils.getDrawable(getResources().getColor(i), ColorConfigureManager.getInstance().getColorIntWithAlpha(StaticColorDefine.CB_1, 30), getResources().getDimensionPixelOffset(i2), getResources().getDimension(i3) / 2.0f, 127);
                drawable3 = drawable;
                break;
            case 1:
                Resources resources4 = getResources();
                int i4 = R.color.ykn_personal_center_vipcard;
                int color2 = resources4.getColor(i4);
                int color3 = getResources().getColor(i4);
                Resources resources5 = getResources();
                int i5 = R.dimen.button_stroke_width;
                int dimensionPixelOffset2 = resources5.getDimensionPixelOffset(i5);
                Resources resources6 = getResources();
                int i6 = R.dimen.button_large_h;
                drawable = Utils.getDrawable(color2, color3, dimensionPixelOffset2, resources6.getDimension(i6) / 2.0f, 255);
                drawable2 = Utils.getDrawable(getResources().getColor(i4), getResources().getColor(i4), getResources().getDimensionPixelOffset(i5), getResources().getDimension(i6) / 2.0f, 127);
                drawable3 = drawable;
                break;
            case 2:
            case '\b':
            case '\n':
            case 16:
                GradientDrawable.Orientation orientation = GradientDrawable.Orientation.LEFT_RIGHT;
                Resources resources7 = getResources();
                int i7 = R.color.gra_r_1_f;
                Resources resources8 = getResources();
                int i8 = R.color.gra_r_1_t;
                int[] iArr = {resources7.getColor(i7), resources8.getColor(i8)};
                Resources resources9 = getResources();
                int i9 = R.dimen.button_large_h;
                drawable3 = Utils.getDrawable(orientation, iArr, 0, 0, resources9.getDimension(i9) / 2.0f, 255);
                drawable2 = Utils.getDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{getResources().getColor(i7), getResources().getColor(i8)}, 0, 0, getResources().getDimension(i9) / 2.0f, 127);
                break;
            case 3:
                int colorIntWithAlpha2 = ColorConfigureManager.getInstance().getColorIntWithAlpha(StaticColorDefine.CB_1, 10);
                int colorIntWithAlpha3 = ColorConfigureManager.getInstance().getColorIntWithAlpha(StaticColorDefine.CB_1, 30);
                Resources resources10 = getResources();
                int i10 = R.dimen.button_stroke_width;
                int dimensionPixelOffset3 = resources10.getDimensionPixelOffset(i10);
                Resources resources11 = getResources();
                int i11 = R.dimen.button_large_h;
                drawable = Utils.getDrawable(colorIntWithAlpha2, colorIntWithAlpha3, dimensionPixelOffset3, resources11.getDimension(i11) / 2.0f, 255);
                drawable2 = Utils.getDrawable(ColorConfigureManager.getInstance().getColorIntWithAlpha(StaticColorDefine.CB_1, 10), ColorConfigureManager.getInstance().getColorIntWithAlpha(StaticColorDefine.CB_1, 30), getResources().getDimensionPixelOffset(i10), getResources().getDimension(i11) / 2.0f, 127);
                drawable3 = drawable;
                break;
            case 4:
            case '\t':
            case 11:
            case 17:
                Resources resources12 = getResources();
                int i12 = R.color.cg_6;
                int color4 = resources12.getColor(i12);
                Resources resources13 = getResources();
                int i13 = R.color.ykn_tertiary_info;
                int color5 = resources13.getColor(i13);
                Resources resources14 = getResources();
                int i14 = R.dimen.button_stroke_width;
                int dimensionPixelOffset4 = resources14.getDimensionPixelOffset(i14);
                Resources resources15 = getResources();
                int i15 = R.dimen.button_large_h;
                drawable3 = Utils.getDrawable(color4, color5, dimensionPixelOffset4, resources15.getDimension(i15) / 2.0f, 255);
                drawable2 = Utils.getDrawable(getResources().getColor(i12), getResources().getColor(i13), getResources().getDimensionPixelOffset(i14), getResources().getDimension(i15) / 2.0f, 127);
                break;
            case 5:
                Resources resources16 = getResources();
                int i16 = R.drawable.yk_button_gradient;
                drawable3 = resources16.getDrawable(i16);
                Resources resources17 = getResources();
                int i17 = R.dimen.button_large_h;
                ((GradientDrawable) drawable3).setCornerRadius(resources17.getDimension(i17) / 2.0f);
                drawable2 = getResources().getDrawable(i16);
                drawable2.setAlpha(127);
                ((GradientDrawable) drawable2).setCornerRadius(getResources().getDimension(i17) / 2.0f);
                break;
            case 6:
            case 7:
            case 18:
                Resources resources18 = getResources();
                int i18 = R.color.cw_1;
                int color6 = resources18.getColor(i18);
                int color7 = getResources().getColor(i18);
                Resources resources19 = getResources();
                int i19 = R.dimen.button_stroke_width;
                int dimensionPixelOffset5 = resources19.getDimensionPixelOffset(i19);
                Resources resources20 = getResources();
                int i20 = R.dimen.button_large_h;
                drawable3 = Utils.getDrawable(color6, color7, dimensionPixelOffset5, resources20.getDimension(i20) / 2.0f, 255);
                drawable2 = Utils.getDrawable(getResources().getColor(i18), getResources().getColor(i18), getResources().getDimensionPixelOffset(i19), getResources().getDimension(i20) / 2.0f, 127);
                break;
            case 14:
                Resources resources21 = getResources();
                int i21 = R.color.cy_3;
                int color8 = resources21.getColor(i21);
                Resources resources22 = getResources();
                int i22 = R.dimen.button_large_h;
                drawable3 = Utils.getDrawable(color8, 0, 0, resources22.getDimension(i22) / 2.0f, 255);
                drawable2 = Utils.getDrawable(getResources().getColor(i21), 0, 0, getResources().getDimension(i22) / 2.0f, 127);
                break;
            case 15:
                GradientDrawable.Orientation orientation2 = GradientDrawable.Orientation.LEFT_RIGHT;
                int[] iArr2 = {Color.parseColor("#FFFABE96"), Color.parseColor("#FFFFE0CB")};
                Resources resources23 = getResources();
                int i23 = R.dimen.button_large_h;
                GradientDrawable drawable4 = Utils.getDrawable(orientation2, iArr2, 0, 0, resources23.getDimension(i23) / 2.0f, 255);
                drawable2 = Utils.getDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{Color.parseColor("#FFFABE96"), Color.parseColor("#FFFFE0CB")}, 0, 0, getResources().getDimension(i23) / 2.0f, 127);
                drawable3 = drawable4;
                break;
            case 19:
            case 21:
            case 22:
                Resources resources24 = getResources();
                int i24 = R.color.cb_1;
                int color9 = resources24.getColor(i24);
                Resources resources25 = getResources();
                int i25 = R.dimen.button_large_h;
                drawable3 = Utils.getDrawable(color9, 0, 0, resources25.getDimension(i25) / 2.0f, 255);
                drawable2 = Utils.getDrawable(getResources().getColor(i24), 0, 0, getResources().getDimension(i25) / 2.0f, 127);
                break;
            case 20:
                GradientDrawable.Orientation orientation3 = GradientDrawable.Orientation.TL_BR;
                Resources resources26 = getResources();
                int i26 = R.color.gra_b_1_f;
                Resources resources27 = getResources();
                int i27 = R.color.gra_b_1_t;
                int[] iArr3 = {resources26.getColor(i26), resources27.getColor(i27)};
                Resources resources28 = getResources();
                int i28 = R.dimen.button_large_h;
                drawable3 = Utils.getDrawable(orientation3, iArr3, 0, 0, resources28.getDimension(i28) / 2.0f, 255);
                drawable2 = Utils.getDrawable(GradientDrawable.Orientation.TL_BR, new int[]{getResources().getColor(i26), getResources().getColor(i27)}, 0, 0, getResources().getDimension(i28) / 2.0f, 127);
                break;
            default:
                drawable3 = null;
                drawable2 = null;
                break;
        }
        Drawable newDrawable = drawable3 != null ? drawable3.getConstantState().newDrawable() : null;
        if (newDrawable != null && this.pressedMask) {
            newDrawable.setColorFilter(getResources().getColor(R.color.mask_cd_1), PorterDuff.Mode.OVERLAY);
        }
        int[][] iArr4 = states;
        stateListDrawable.addState(iArr4[0], newDrawable);
        stateListDrawable.addState(iArr4[1], newDrawable);
        stateListDrawable.addState(iArr4[2], drawable3);
        stateListDrawable.addState(iArr4[3], drawable2);
        return stateListDrawable;
    }

    @Override // com.youku.resource.widget.YKCustomizedView
    public void init(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.YKButtonView, 0, 0);
            String string = obtainStyledAttributes.getString(R.styleable.YKButtonView_button_style);
            this.pressedMask = obtainStyledAttributes.getBoolean(R.styleable.YKButtonView_button_mask, true);
            if (string != null) {
                setStateDrawable(string);
            }
            obtainStyledAttributes.recycle();
        }
    }

    public void setSize(String str) {
        str.hashCode();
        int i = 0;
        char c = 65535;
        switch (str.hashCode()) {
            case -2078160725:
                if (str.equals(BUTTON_GHOST_MIDDLE_X)) {
                    c = 0;
                    break;
                }
                break;
            case -1669794502:
                if (str.equals(BUTTON_WARNING_MIDDLE_XX)) {
                    c = 1;
                    break;
                }
                break;
            case -1644823041:
                if (str.equals(BUTTON_NORMAL_MIDDLE_XX)) {
                    c = 2;
                    break;
                }
                break;
            case -805843183:
                if (str.equals(BUTTON_LIGHT_SMALL)) {
                    c = 3;
                    break;
                }
                break;
            case -628892940:
                if (str.equals(BUTTON_LIGHT_MIDDLE_XX)) {
                    c = 4;
                    break;
                }
                break;
            case -133619061:
                if (str.equals(BUTTON_WARNING_LARGE)) {
                    c = 5;
                    break;
                }
                break;
            case -133474864:
                if (str.equals(BUTTON_NORMAL_LARGE)) {
                    c = 6;
                    break;
                }
                break;
            case -126813097:
                if (str.equals(BUTTON_WARNING_SMALL)) {
                    c = 7;
                    break;
                }
                break;
            case -126668900:
                if (str.equals(BUTTON_NORMAL_SMALL)) {
                    c = '\b';
                    break;
                }
                break;
            case 1527085:
                if (str.equals(BUTTON_GHOST_MIDDLE_XX)) {
                    c = '\t';
                    break;
                }
                break;
            case 201803210:
                if (str.equals(BUTTON_GHOST_SMALL)) {
                    c = '\n';
                    break;
                }
                break;
            case 638872318:
                if (str.equals(BUTTON_WARNING_MIDDLE_X)) {
                    c = 11;
                    break;
                }
                break;
            case 639677849:
                if (str.equals(BUTTON_NORMAL_MIDDLE_X)) {
                    c = '\f';
                    break;
                }
                break;
            case 949544452:
                if (str.equals(BUTTON_LIGHT_MIDDLE_X)) {
                    c = CharUtils.CR;
                    break;
                }
                break;
            case 1451876184:
                if (str.equals(BUTTON_PROMARY_MIDDLE_X)) {
                    c = 14;
                    break;
                }
                break;
            case 2055052401:
                if (str.equals(BUTTON_PRIMARY_LARGE)) {
                    c = 15;
                    break;
                }
                break;
            case 2058488864:
                if (str.equals(BUTTON_PROMARY_MIDDLE_XX)) {
                    c = 16;
                    break;
                }
                break;
            case 2061858365:
                if (str.equals(BUTTON_PROMARY_SMALL)) {
                    c = 17;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
            case 11:
            case '\f':
            case '\r':
            case 14:
                i = getResources().getDimensionPixelOffset(R.dimen.button_middle_x_h);
                break;
            case 1:
            case 2:
            case 4:
            case '\t':
            case 16:
                i = getResources().getDimensionPixelOffset(R.dimen.button_middle_xx_h);
                break;
            case 3:
            case 7:
            case '\b':
            case '\n':
            case 17:
                i = getResources().getDimensionPixelOffset(R.dimen.button_small_h);
                break;
            case 5:
            case 6:
            case 15:
                i = getResources().getDimensionPixelOffset(R.dimen.button_large_h);
                break;
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = i;
        setLayoutParams(layoutParams);
    }

    public void setStateDrawable(String str) {
        setBackgroundDrawable(getStateListDrawable(str));
    }

    public void setTextColor(String str) {
        int defaultColor = getTextColors().getDefaultColor();
        if (str != null) {
            char c = 65535;
            switch (str.hashCode()) {
                case -2078160725:
                    if (str.equals(BUTTON_GHOST_MIDDLE_X)) {
                        c = 0;
                        break;
                    }
                    break;
                case -1910335712:
                    if (str.equals(BUTTON_VIP_GHOST)) {
                        c = 1;
                        break;
                    }
                    break;
                case -1669794502:
                    if (str.equals(BUTTON_WARNING_MIDDLE_XX)) {
                        c = 2;
                        break;
                    }
                    break;
                case -1647461209:
                    if (str.equals(BUTTON_SECONDARY)) {
                        c = 3;
                        break;
                    }
                    break;
                case -1644823041:
                    if (str.equals(BUTTON_NORMAL_MIDDLE_XX)) {
                        c = 4;
                        break;
                    }
                    break;
                case -1045497443:
                    if (str.equals(BUTTON_GRADIENT)) {
                        c = 5;
                        break;
                    }
                    break;
                case -805843183:
                    if (str.equals(BUTTON_LIGHT_SMALL)) {
                        c = 6;
                        break;
                    }
                    break;
                case -628892940:
                    if (str.equals(BUTTON_LIGHT_MIDDLE_XX)) {
                        c = 7;
                        break;
                    }
                    break;
                case -133619061:
                    if (str.equals(BUTTON_WARNING_LARGE)) {
                        c = '\b';
                        break;
                    }
                    break;
                case -133474864:
                    if (str.equals(BUTTON_NORMAL_LARGE)) {
                        c = '\t';
                        break;
                    }
                    break;
                case -126813097:
                    if (str.equals(BUTTON_WARNING_SMALL)) {
                        c = '\n';
                        break;
                    }
                    break;
                case -126668900:
                    if (str.equals(BUTTON_NORMAL_SMALL)) {
                        c = 11;
                        break;
                    }
                    break;
                case 1527085:
                    if (str.equals(BUTTON_GHOST_MIDDLE_XX)) {
                        c = '\f';
                        break;
                    }
                    break;
                case 201803210:
                    if (str.equals(BUTTON_GHOST_SMALL)) {
                        c = CharUtils.CR;
                        break;
                    }
                    break;
                case 354368918:
                    if (str.equals(BUTTON_VIP_SALE)) {
                        c = 14;
                        break;
                    }
                    break;
                case 358888848:
                    if (str.equals(BUTTON_VIP)) {
                        c = 15;
                        break;
                    }
                    break;
                case 638872318:
                    if (str.equals(BUTTON_WARNING_MIDDLE_X)) {
                        c = 16;
                        break;
                    }
                    break;
                case 639677849:
                    if (str.equals(BUTTON_NORMAL_MIDDLE_X)) {
                        c = 17;
                        break;
                    }
                    break;
                case 949544452:
                    if (str.equals(BUTTON_LIGHT_MIDDLE_X)) {
                        c = 18;
                        break;
                    }
                    break;
                case 1451876184:
                    if (str.equals(BUTTON_PROMARY_MIDDLE_X)) {
                        c = 19;
                        break;
                    }
                    break;
                case 2055052401:
                    if (str.equals(BUTTON_PRIMARY_LARGE)) {
                        c = 20;
                        break;
                    }
                    break;
                case 2058488864:
                    if (str.equals(BUTTON_PROMARY_MIDDLE_XX)) {
                        c = 21;
                        break;
                    }
                    break;
                case 2061858365:
                    if (str.equals(BUTTON_PROMARY_SMALL)) {
                        c = 22;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                case '\f':
                case '\r':
                    defaultColor = getResources().getColor(R.color.cb_1);
                    break;
                case 1:
                    defaultColor = getResources().getColor(R.color.ykn_personal_center_vipcard);
                    break;
                case 2:
                case '\b':
                case '\n':
                case 16:
                    defaultColor = getResources().getColor(R.color.cw_1);
                    break;
                case 3:
                    defaultColor = getResources().getColor(R.color.cb_1);
                    break;
                case 4:
                case '\t':
                case 11:
                case 17:
                    defaultColor = getResources().getColor(R.color.ykn_tertiary_info);
                    break;
                case 5:
                    defaultColor = getResources().getColor(R.color.cw_1);
                    break;
                case 6:
                case 7:
                case 18:
                    defaultColor = getResources().getColor(R.color.cw_1);
                    break;
                case 14:
                case 19:
                case 20:
                case 21:
                case 22:
                    defaultColor = getResources().getColor(R.color.cw_1);
                    break;
                case 15:
                    defaultColor = getResources().getColor(R.color.cv_2);
                    break;
            }
        }
        int colorWithAlpha = Utils.getColorWithAlpha(0.6f, defaultColor);
        setTextColor(new ColorStateList(states, new int[]{colorWithAlpha, colorWithAlpha, defaultColor, Utils.getColorWithAlpha(0.5f, defaultColor)}));
    }

    public void setStateDrawable(String str, boolean z) {
        this.pressedMask = z;
        setBackgroundDrawable(getStateListDrawable(str));
    }

    public YKButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.pressedMask = true;
        init(context, attributeSet);
    }
}
