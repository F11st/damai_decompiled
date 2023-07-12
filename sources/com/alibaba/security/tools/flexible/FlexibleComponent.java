package com.alibaba.security.tools.flexible;

import android.content.Context;
import android.util.DisplayMetrics;
import com.alibaba.security.common.c.C3800a;
import com.alibaba.security.tools.flexible.component.GradientDrawableComp;
import com.alibaba.security.tools.flexible.component.IFlexibleComp;
import com.alibaba.security.tools.flexible.component.PaddingComp;
import com.alibaba.security.tools.flexible.component.ParameterComp;
import com.alibaba.security.tools.flexible.component.TextSizeComp;
import com.taobao.uikit.feature.features.FeatureFactory;
import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class FlexibleComponent {
    public static final String COMP_PRESET_GRADIENT_DRAWABLE = "COMP_PRESET_GRADIENT_DRAWABLE";
    public static final String COMP_PRESET_PADDING = "COMP_PRESET_PADDING";
    public static final String COMP_PRESET_PARAMETER = "COMP_PRESET_PARAMETER";
    public static final String COMP_PRESET_TEXT_SIZE = "COMP_PRESET_TEXT_SIZE";
    public static final FlexibleComponent INSTANCE;
    private static final String TAG = "FlexibleComponent";
    private static final LinkedList<IFlexibleComp> components;
    private static final IFlexibleComp presetGradientDrawableComp;
    private static final IFlexibleComp presetPaddingComp;
    private static final IFlexibleComp presetParameterComp;
    private static final IFlexibleComp presetTextSizeComp;
    private int designWidth = FeatureFactory.PRIORITY_ABOVE_NORMAL;
    private float scaledDensity = 1.0f;

    static {
        FlexibleComponent flexibleComponent = new FlexibleComponent();
        INSTANCE = flexibleComponent;
        components = new LinkedList<>();
        PaddingComp paddingComp = new PaddingComp();
        presetPaddingComp = paddingComp;
        ParameterComp parameterComp = new ParameterComp();
        presetParameterComp = parameterComp;
        TextSizeComp textSizeComp = new TextSizeComp();
        presetTextSizeComp = textSizeComp;
        GradientDrawableComp gradientDrawableComp = new GradientDrawableComp();
        presetGradientDrawableComp = gradientDrawableComp;
        flexibleComponent.add(paddingComp);
        flexibleComponent.add(parameterComp);
        flexibleComponent.add(textSizeComp);
        flexibleComponent.add(gradientDrawableComp);
    }

    private FlexibleComponent() {
    }

    public void add(IFlexibleComp iFlexibleComp) {
        components.add(iFlexibleComp);
    }

    public int calculate(BigDecimal bigDecimal, int i) {
        int intValue = new BigDecimal(i).multiply(bigDecimal).intValue();
        if (intValue <= 0) {
            return 1;
        }
        return intValue;
    }

    public void clear() {
        components.clear();
    }

    public List<IFlexibleComp> getAllComponents() {
        return components;
    }

    public float getScaledDensity() {
        return this.scaledDensity;
    }

    public int getScreenWidth(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.scaledDensity = displayMetrics.scaledDensity / displayMetrics.density;
        return com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(displayMetrics);
    }

    public BigDecimal getZoomRate(Context context) {
        return new BigDecimal(getScreenWidth(context)).divide(new BigDecimal(this.designWidth), 2, 4);
    }

    public void remove(IFlexibleComp iFlexibleComp) {
        components.remove(iFlexibleComp);
    }

    public float calculate(BigDecimal bigDecimal, float f) {
        float floatValue = new BigDecimal(f).multiply(bigDecimal).floatValue();
        if (floatValue <= 0.0f) {
            return 1.0f;
        }
        return floatValue;
    }

    public int calculate(int i, int i2, int i3) {
        if (i > 0) {
            int i4 = (int) ((i3 * i2) / i);
            if (i4 <= 0) {
                return 1;
            }
            return i4;
        }
        C3800a.e(TAG, "Found design value **" + i + "** is invalid. Have u forgot it?");
        return i3;
    }

    public float calculate(int i, int i2, float f) {
        if (i > 0) {
            float f2 = (float) ((f * i2) / i);
            if (f2 < 1.0f) {
                return 1.0f;
            }
            return f2;
        }
        C3800a.e(TAG, "Found design value **" + i + "** is invalid. Have u forgot it?");
        return f;
    }
}
