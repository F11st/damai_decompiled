package com.alibaba.aliweex.adapter.view;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.alibaba.aliweex.R$id;
import java.util.ArrayList;
import java.util.List;
import tb.ud0;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class ElevatorAdapter extends BaseAdapter {
    private Context context;
    private List<ud0> itemList;
    private int resourceId;
    private String selectedColor = "#EE0A3B";
    private String normalColor = "#333333";

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.aliweex.adapter.view.ElevatorAdapter$a */
    /* loaded from: classes15.dex */
    public class C3071a {
        TextView a;
        ImageView b;

        public C3071a(ElevatorAdapter elevatorAdapter) {
        }
    }

    public ElevatorAdapter(Context context, int i, List<ud0> list) {
        this.itemList = new ArrayList();
        this.context = context;
        this.resourceId = i;
        this.itemList = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.itemList.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C3071a c3071a;
        ud0 item = getItem(i);
        if (view == null) {
            view = LayoutInflater.from(this.context).inflate(this.resourceId, (ViewGroup) null);
            view.setLayoutParams(new AbsListView.LayoutParams(-2, -1));
            c3071a = new C3071a(this);
            c3071a.a = (TextView) view.findViewById(R$id.loc_text);
            c3071a.b = (ImageView) view.findViewById(R$id.loc_icon);
            view.setTag(c3071a);
        } else {
            c3071a = (C3071a) view.getTag();
        }
        c3071a.a.setText(item.d());
        if (item.b()) {
            c3071a.a.setTextColor(Color.parseColor(this.selectedColor));
        } else {
            c3071a.a.setTextColor(Color.parseColor(this.normalColor));
        }
        if (item.c()) {
            c3071a.b.setVisibility(0);
        } else {
            c3071a.b.setVisibility(4);
        }
        return view;
    }

    public void setNormalColor(String str) {
        this.normalColor = str;
        notifyDataSetChanged();
    }

    public void setSelectedColor(String str) {
        this.selectedColor = str;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public ud0 getItem(int i) {
        return this.itemList.get(i);
    }
}
