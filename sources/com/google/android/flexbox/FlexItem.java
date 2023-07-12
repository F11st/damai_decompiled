package com.google.android.flexbox;

import android.os.Parcelable;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
interface FlexItem extends Parcelable {
    public static final float FLEX_BASIS_PERCENT_DEFAULT = -1.0f;
    public static final float FLEX_GROW_DEFAULT = 0.0f;
    public static final float FLEX_SHRINK_DEFAULT = 1.0f;
    public static final int MAX_SIZE = 16777215;
    public static final int ORDER_DEFAULT = 1;

    int getAlignSelf();

    float getFlexBasisPercent();

    float getFlexGrow();

    float getFlexShrink();

    int getHeight();

    int getMarginBottom();

    int getMarginEnd();

    int getMarginLeft();

    int getMarginRight();

    int getMarginStart();

    int getMarginTop();

    int getMaxHeight();

    int getMaxWidth();

    int getMinHeight();

    int getMinWidth();

    int getOrder();

    int getWidth();

    boolean isWrapBefore();

    void setAlignSelf(int i);

    void setFlexBasisPercent(float f);

    void setFlexGrow(float f);

    void setFlexShrink(float f);

    void setHeight(int i);

    void setMaxHeight(int i);

    void setMaxWidth(int i);

    void setMinHeight(int i);

    void setMinWidth(int i);

    void setOrder(int i);

    void setWidth(int i);

    void setWrapBefore(boolean z);
}
