package com.taobao.uikit.utils;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.taobao.uikit.feature.features.AbsFeature;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public interface IFeatureList<T extends View> {
    boolean addFeature(AbsFeature<? super T> absFeature);

    void clearFeatures();

    AbsFeature<? super T> findFeature(Class<? extends AbsFeature<? super T>> cls);

    void init(Context context, AttributeSet attributeSet, int i);

    boolean removeFeature(Class<? extends AbsFeature<? super T>> cls);
}
