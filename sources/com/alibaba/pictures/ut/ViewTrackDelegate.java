package com.alibaba.pictures.ut;

import android.view.View;
import kotlin.Metadata;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u0000*\n\b\u0000\u0010\u0002*\u0004\u0018\u00010\u00012\u00020\u0003J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00028\u0000H&¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\t\u001a\u00020\bH&¨\u0006\n"}, d2 = {"Lcom/alibaba/pictures/ut/ViewTrackDelegate;", "Landroid/view/View;", "V", "", "view", "Ltb/wt2;", "onViewInit", "(Landroid/view/View;)V", "", "viewId", "ut_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes8.dex */
public interface ViewTrackDelegate<V extends View> {
    void onViewInit(V v);

    int viewId();
}
