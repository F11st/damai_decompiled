package com.youku.live.dago.widgetlib.ailproom.adapter.chatinput.expression.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.youku.live.dago.widgetlib.ailproom.adapter.chatinput.expression.listener.IExpressionSelectListener;
import com.youku.live.dago.widgetlib.interactive.gift.view.pageview.NoScrollGridView;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public abstract class PagerExpression extends RelativeLayout {
    public static final String BACK = "lf_delete";
    public static final String BLANK = "lf_blank";
    public static final String RES_ID = "RESOURCE_ID";
    public static final String RES_NAME = "RESOURCE_NAME";
    protected List<Map<String, Object>> listItems;
    protected NoScrollGridView mGridview;
    protected IExpressionSelectListener mListener;

    public PagerExpression(Context context) {
        super(context);
        this.mGridview = null;
        this.listItems = null;
        this.mListener = null;
    }

    public abstract void init(int i, int i2, IExpressionSelectListener iExpressionSelectListener);

    public PagerExpression(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mGridview = null;
        this.listItems = null;
        this.mListener = null;
    }
}
