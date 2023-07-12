package com.taobao.android.dinamicx.widget.viewpager.tab.view;

import android.content.Context;
import android.content.res.TypedArray;
import androidx.appcompat.R;

/* compiled from: Taobao */
/* renamed from: com.taobao.android.dinamicx.widget.viewpager.tab.view.b */
/* loaded from: classes12.dex */
public class C6549b {
    private static final int[] a = {R.attr.colorPrimary};

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(a);
        boolean z = !obtainStyledAttributes.hasValue(0);
        obtainStyledAttributes.recycle();
        if (z) {
            throw new IllegalArgumentException("You need to use a Theme.AppCompat theme (or descendant) with the design library.");
        }
    }
}
