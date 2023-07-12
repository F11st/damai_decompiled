package com.youku.live.dago.widgetlib.ailproom.adapter.chatinput.expression.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.R;
import com.youku.live.dago.widgetlib.ailproom.adapter.chatinput.expression.ExpressionDict;
import com.youku.live.dago.widgetlib.ailproom.adapter.chatinput.expression.listener.IExpressionSelectListener;
import com.youku.live.dago.widgetlib.interactive.gift.view.pageview.NoScrollGridView;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class PagerExpressionNormal extends PagerExpression {
    private static transient /* synthetic */ IpChange $ipChange;

    public PagerExpressionNormal(Context context) {
        super(context);
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.adapter.chatinput.expression.widget.PagerExpression
    public void init(int i, int i2, IExpressionSelectListener iExpressionSelectListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-848071691")) {
            ipChange.ipc$dispatch("-848071691", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), iExpressionSelectListener});
            return;
        }
        this.mGridview = (NoScrollGridView) findViewById(R.id.expression_gridview);
        this.mListener = iExpressionSelectListener;
        this.listItems = new ArrayList();
        Field field = null;
        for (int i3 = i; i3 < i2; i3++) {
            HashMap hashMap = new HashMap();
            String prefix = ExpressionDict.getPrefix();
            if (i3 < 10) {
                try {
                    field = R.drawable.class.getDeclaredField(prefix + "00" + i3);
                    hashMap.put(PagerExpression.RES_NAME, prefix + "00" + i3);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (NoSuchFieldException e2) {
                    e2.printStackTrace();
                } catch (NumberFormatException e3) {
                    e3.printStackTrace();
                } catch (IllegalArgumentException e4) {
                    e4.printStackTrace();
                }
            } else if (i3 >= 10 && i3 < 100) {
                field = R.drawable.class.getDeclaredField(prefix + "0" + i3);
                hashMap.put(PagerExpression.RES_NAME, prefix + "0" + i3);
            } else if (i3 >= 100) {
                field = R.drawable.class.getDeclaredField(prefix + i3);
                hashMap.put(PagerExpression.RES_NAME, prefix + i3);
            }
            hashMap.put(PagerExpression.RES_ID, Integer.valueOf(Integer.parseInt(field.get(null).toString())));
            this.listItems.add(hashMap);
        }
        int i4 = i2 - i;
        try {
            int parseInt = Integer.parseInt(R.drawable.class.getDeclaredField(PagerExpression.BLANK).get(null).toString());
            for (int i5 = 0; i5 < 23 - i4; i5++) {
                HashMap hashMap2 = new HashMap();
                hashMap2.put(PagerExpression.RES_ID, Integer.valueOf(parseInt));
                hashMap2.put(PagerExpression.RES_NAME, PagerExpression.BLANK);
                this.listItems.add(hashMap2);
            }
            int parseInt2 = Integer.parseInt(R.drawable.class.getDeclaredField(PagerExpression.BACK).get(null).toString());
            HashMap hashMap3 = new HashMap();
            hashMap3.put(PagerExpression.RES_ID, Integer.valueOf(parseInt2));
            hashMap3.put(PagerExpression.RES_NAME, PagerExpression.BACK);
            this.listItems.add(hashMap3);
        } catch (IllegalAccessException e5) {
            e5.printStackTrace();
        } catch (NoSuchFieldException e6) {
            e6.printStackTrace();
        }
        this.mGridview.setAdapter((ListAdapter) new SimpleAdapter(getContext(), this.listItems, R.layout.dago_pgc_item_grid_cell, new String[]{PagerExpression.RES_ID}, new int[]{R.id.image}));
        this.mGridview.setStretchMode(2);
        this.mGridview.setNumColumns(8);
        this.mGridview.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.youku.live.dago.widgetlib.ailproom.adapter.chatinput.expression.widget.PagerExpressionNormal.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i6, long j) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-445913651")) {
                    ipChange2.ipc$dispatch("-445913651", new Object[]{this, adapterView, view, Integer.valueOf(i6), Long.valueOf(j)});
                    return;
                }
                Map<String, Object> map = PagerExpressionNormal.this.listItems.get(i6);
                PagerExpressionNormal.this.mListener.onExpressionClick((String) map.get(PagerExpression.RES_NAME), ((Integer) map.get(PagerExpression.RES_ID)).intValue());
            }
        });
    }

    public PagerExpressionNormal(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
