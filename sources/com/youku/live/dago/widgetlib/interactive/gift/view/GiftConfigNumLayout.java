package com.youku.live.dago.widgetlib.interactive.gift.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.youku.live.dago.widgetlib.R;
import com.youku.live.dago.widgetlib.interactive.gift.bean.GiftNumBean;
import com.youku.live.dago.widgetlib.interactive.gift.view.pageview.NoScrollGridView;
import java.util.ArrayList;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class GiftConfigNumLayout extends LinearLayout {
    private static final int MAX_COLUMN = 5;
    private ArrayList<GiftNumBean> giftNumBeanArrayList;
    NoScrollGridView gridView;

    public GiftConfigNumLayout(Context context) {
        this(context, null);
    }

    public GiftConfigNumLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GiftConfigNumLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.giftNumBeanArrayList = new ArrayList<>();
        setOrientation(1);
        LayoutInflater.from(context).inflate(R.layout.dago_pgc_ykl_gift_config_layout, (ViewGroup) this, true);
        this.gridView = (NoScrollGridView) findViewById(R.id.id_gv);
    }
}
