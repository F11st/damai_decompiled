package com.alibaba.pictures.bricks.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.alibaba.pictures.R$drawable;
import com.alibaba.pictures.R$styleable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import io.flutter.wpkbridge.WPKFactory;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.JvmOverloads;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.k50;
import tb.s60;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class FiveStarView extends LinearLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private final int[] mDrawableYellow;
    private final int mStarSize;
    @NotNull
    private final List<View> mStarViews;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public FiveStarView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public FiveStarView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
    }

    public /* synthetic */ FiveStarView(Context context, AttributeSet attributeSet, int i, int i2, k50 k50Var) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    private final void initView(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-586488687")) {
            ipChange.ipc$dispatch("-586488687", new Object[]{this, context});
            return;
        }
        setOrientation(0);
        for (int i = 0; i < 5; i++) {
            View view = new View(context);
            LinearLayout.LayoutParams generateDefaultLayoutParams = generateDefaultLayoutParams();
            int i2 = this.mStarSize;
            generateDefaultLayoutParams.height = i2;
            generateDefaultLayoutParams.width = i2;
            if (i != 4) {
                generateDefaultLayoutParams.setMarginEnd(s60.INSTANCE.a(context, 1.5f));
            }
            view.setLayoutParams(generateDefaultLayoutParams);
            addView(view);
            this.mStarViews.add(view);
        }
    }

    public final void updateView(double d) {
        char c;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1317576832")) {
            ipChange.ipc$dispatch("1317576832", new Object[]{this, Double.valueOf(d)});
            return;
        }
        try {
            int[] iArr = this.mDrawableYellow;
            int size = this.mStarViews.size();
            for (int i = 0; i < size; i++) {
                BigDecimal subtract = new BigDecimal(String.valueOf(d)).subtract(new BigDecimal(i * 2));
                b41.h(subtract, "this.subtract(other)");
                if (subtract.compareTo(new BigDecimal("0.9")) <= 0) {
                    c = 2;
                } else {
                    c = subtract.compareTo(new BigDecimal("1.9")) <= 0 ? (char) 1 : (char) 0;
                }
                this.mStarViews.get(i).setBackgroundResource(iArr[c]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public FiveStarView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        this.mDrawableYellow = new int[]{R$drawable.bricks_rating_fill_type_2, R$drawable.bricks_rating_half_type_2, R$drawable.bricks_rating_empty_type_2};
        this.mStarViews = new ArrayList();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.FiveStarView);
        b41.h(obtainStyledAttributes, "context.obtainStyledAttr…R.styleable.FiveStarView)");
        this.mStarSize = obtainStyledAttributes.getDimensionPixelSize(R$styleable.FiveStarView_one_star_size, 20);
        obtainStyledAttributes.recycle();
        initView(context);
    }
}
