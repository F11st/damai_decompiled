package com.taobao.android.dinamic.view;

import android.annotation.SuppressLint;
import android.content.Context;
import com.taobao.android.dinamic.C6313b;

/* compiled from: Taobao */
@SuppressLint({"ViewConstructor"})
/* loaded from: classes11.dex */
public class CompatibleView extends DFrameLayout {
    public CompatibleView(Context context, String str) {
        super(context);
        if (C6313b.e()) {
            setContentDescription(str);
        }
    }
}
