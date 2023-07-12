package com.taobao.uikit.utils;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.taobao.uikit.base.R;
import com.taobao.uikit.feature.features.AbsFeature;
import com.taobao.uikit.feature.features.FeatureFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class FeatureList<T extends View> extends ArrayList<AbsFeature<? super T>> implements Comparator<AbsFeature<? super T>>, IFeatureList<T> {
    private static final long serialVersionUID = 5539018560951385305L;
    private T mHost;

    public FeatureList(T t) {
        this.mHost = t;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean add(Object obj) {
        return add((AbsFeature) ((AbsFeature) obj));
    }

    @Override // com.taobao.uikit.utils.IFeatureList
    public boolean addFeature(AbsFeature<? super T> absFeature) {
        if (absFeature != null) {
            absFeature.setHost(this.mHost);
            return add((AbsFeature) absFeature);
        }
        return false;
    }

    @Override // com.taobao.uikit.utils.IFeatureList
    public void clearFeatures() {
        clear();
        this.mHost.requestLayout();
    }

    @Override // java.util.Comparator
    public /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        return compare((AbsFeature) ((AbsFeature) obj), (AbsFeature) ((AbsFeature) obj2));
    }

    @Override // com.taobao.uikit.utils.IFeatureList
    public AbsFeature<? super T> findFeature(Class<? extends AbsFeature<? super T>> cls) {
        int size = size();
        for (int i = 0; i < size; i++) {
            AbsFeature<? super T> absFeature = (AbsFeature) get(i);
            if (absFeature.getClass() == cls) {
                return absFeature;
            }
        }
        return null;
    }

    @Override // com.taobao.uikit.utils.IFeatureList
    public void init(Context context, AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FeatureNameSpace);
        if (obtainStyledAttributes != null) {
            ArrayList creator = FeatureFactory.creator(this.mHost.getContext(), obtainStyledAttributes);
            int size = creator.size();
            for (int i2 = 0; i2 < size; i2++) {
                AbsFeature<? super T> absFeature = (AbsFeature) creator.get(i2);
                addFeature(absFeature);
                absFeature.constructor(context, attributeSet, i);
            }
            obtainStyledAttributes.recycle();
        }
    }

    @Override // com.taobao.uikit.utils.IFeatureList
    public boolean removeFeature(Class<? extends AbsFeature<? super T>> cls) {
        int size = size();
        for (int i = 0; i < size; i++) {
            AbsFeature absFeature = get(i);
            if (absFeature.getClass() == cls) {
                return remove(absFeature);
            }
        }
        return false;
    }

    public boolean add(AbsFeature<? super T> absFeature) {
        int size = size();
        for (int i = 0; i < size; i++) {
            AbsFeature absFeature2 = get(i);
            if (TextUtils.equals(absFeature2.getClass().getName(), absFeature.getClass().getName())) {
                throw new RuntimeException(absFeature2.getClass().getName() + " already add to this view");
            }
        }
        boolean add = super.add((FeatureList<T>) absFeature);
        Collections.sort(this, this);
        return add;
    }

    public int compare(AbsFeature<? super T> absFeature, AbsFeature<? super T> absFeature2) {
        return FeatureFactory.getFeaturePriority(absFeature.getClass().getName()) - FeatureFactory.getFeaturePriority(absFeature2.getClass().getName());
    }
}
