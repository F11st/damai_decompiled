package com.taobao.android.dinamicx.widget.recycler.loadmore;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.alibaba.fastjson.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public abstract class DXAbsOnLoadMoreView extends FrameLayout implements DXOnLoadMoreListener {
    public DXAbsOnLoadMoreView(Context context) {
        super(context);
    }

    @Override // com.taobao.android.dinamicx.widget.recycler.loadmore.DXOnLoadMoreListener
    public abstract void onLoadMoreStatusUpdate(int i, JSONObject jSONObject);

    public DXAbsOnLoadMoreView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public DXAbsOnLoadMoreView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
