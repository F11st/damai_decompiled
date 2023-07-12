package com.ali.user.mobile.ui.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.ali.user.mobile.ui.R;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class MenuItemAdapter extends BaseAdapter {
    private Context context;
    private int layoutId;
    private LayoutInflater layoutInflater;
    private List<MenuItem> menuItems;

    public MenuItemAdapter(Context context, List<MenuItem> list) {
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
        this.menuItems = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.menuItems.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (i >= this.menuItems.size() || i < 0) {
            return null;
        }
        return this.menuItems.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            LayoutInflater layoutInflater = this.layoutInflater;
            int i2 = this.layoutId;
            if (i2 <= 0) {
                i2 = R.layout.aliuser_menu_item;
            }
            view = layoutInflater.inflate(i2, (ViewGroup) null);
        }
        MenuItem menuItem = this.menuItems.get(i);
        TextView textView = (TextView) view.findViewById(R.id.aliuser_menu_item);
        textView.setText(menuItem.getText());
        int i3 = menuItem.textColor;
        if (i3 != 0) {
            textView.setTextColor(i3);
        }
        int i4 = menuItem.bgColor;
        if (i4 != 0) {
            textView.setBackgroundColor(i4);
        }
        float f = menuItem.textSize;
        if (f > 0.0f) {
            textView.setTextSize(0, f);
        }
        textView.setOnClickListener(menuItem.getMenuItemOnClickListener());
        return view;
    }

    public void setLayoutId(int i) {
        this.layoutId = i;
    }
}
