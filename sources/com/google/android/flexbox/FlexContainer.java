package com.google.android.flexbox;

import android.view.View;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
interface FlexContainer {
    public static final int NOT_SET = -1;

    void addView(View view);

    void addView(View view, int i);

    int getAlignContent();

    int getAlignItems();

    int getChildHeightMeasureSpec(int i, int i2, int i3);

    int getChildWidthMeasureSpec(int i, int i2, int i3);

    int getDecorationLengthCrossAxis(View view);

    int getDecorationLengthMainAxis(View view, int i, int i2);

    int getFlexDirection();

    View getFlexItemAt(int i);

    int getFlexItemCount();

    List<a> getFlexLines();

    List<a> getFlexLinesInternal();

    int getFlexWrap();

    int getJustifyContent();

    int getLargestMainSize();

    int getMaxLine();

    int getPaddingBottom();

    int getPaddingEnd();

    int getPaddingLeft();

    int getPaddingRight();

    int getPaddingStart();

    int getPaddingTop();

    View getReorderedFlexItemAt(int i);

    int getSumOfCrossSize();

    boolean isMainAxisDirectionHorizontal();

    void onNewFlexItemAdded(View view, int i, int i2, a aVar);

    void onNewFlexLineAdded(a aVar);

    void removeAllViews();

    void removeViewAt(int i);

    void setAlignContent(int i);

    void setAlignItems(int i);

    void setFlexDirection(int i);

    void setFlexLines(List<a> list);

    void setFlexWrap(int i);

    void setJustifyContent(int i);

    void setMaxLine(int i);

    void updateViewCache(int i, View view);
}
