package com.youku.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.baseproject.ui.R$dimen;
import com.baseproject.ui.R$id;
import com.baseproject.ui.R$layout;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
@TargetApi(4)
/* loaded from: classes3.dex */
public class YoukuPopupMenu {
    private MenuItemAdapter mAdapter;
    private Context mContext;
    private TextView mHeaderTitleView;
    private LayoutInflater mInflater;
    private List<MenuItem> mItems = new ArrayList();
    private ListView mItemsView;
    private OnItemSelectedListener mListener;
    private PopupWindow mPopupWindow;
    private int mWidth;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static class MenuItem {
        private Drawable icon;
        private Intent intent;
        private int itemId;
        private String title;

        public Drawable getIcon() {
            return this.icon;
        }

        public Intent getIntent() {
            return this.intent;
        }

        public int getItemId() {
            return this.itemId;
        }

        public String getTitle() {
            return this.title;
        }

        public void setIcon(Drawable drawable) {
            this.icon = drawable;
        }

        public void setIntent(Intent intent) {
            this.intent = intent;
        }

        public void setItemId(int i) {
            this.itemId = i;
        }

        public void setTitle(String str) {
            this.title = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static class MenuItemAdapter extends ArrayAdapter<MenuItem> {
        private LayoutInflater mInflater;

        /* compiled from: Taobao */
        /* loaded from: classes3.dex */
        static class ViewHolder {
            ImageView icon;
            TextView title;

            ViewHolder() {
            }
        }

        public MenuItemAdapter(Context context, List<MenuItem> list) {
            super(context, 0, list);
            this.mInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            if (view == null) {
                view = this.mInflater.inflate(R$layout.menu_list_item, (ViewGroup) null);
                viewHolder = new ViewHolder();
                viewHolder.icon = (ImageView) view.findViewById(R$id.icon);
                viewHolder.title = (TextView) view.findViewById(R$id.title);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            MenuItem item = getItem(i);
            if (item.getIcon() != null) {
                viewHolder.icon.setImageDrawable(item.getIcon());
                viewHolder.icon.setVisibility(0);
            } else {
                viewHolder.icon.setVisibility(8);
            }
            viewHolder.title.setText(item.getTitle());
            return view;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public interface OnItemSelectedListener {
        void onItemSelected(MenuItem menuItem);
    }

    public YoukuPopupMenu(Context context) {
        this.mContext = context;
        this.mInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        this.mWidth = this.mContext.getResources().getDimensionPixelSize(R$dimen.popup_menu_width);
        initPopupWindow();
        View inflate = this.mInflater.inflate(R$layout.popup_menu, (ViewGroup) null);
        this.mItemsView = (ListView) inflate.findViewById(R$id.items);
        this.mHeaderTitleView = (TextView) inflate.findViewById(R$id.header_title);
        this.mItemsView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.youku.widget.YoukuPopupMenu.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (YoukuPopupMenu.this.mListener != null) {
                    YoukuPopupMenu.this.mListener.onItemSelected((MenuItem) YoukuPopupMenu.this.mItems.get(i));
                }
                YoukuPopupMenu.this.mPopupWindow.dismiss();
            }
        });
        this.mPopupWindow.setContentView(inflate);
    }

    private void initPopupWindow() {
        PopupWindow newPopInstance = YoukuPopupHelper.newPopInstance(this.mContext);
        this.mPopupWindow = newPopInstance;
        newPopInstance.setWidth(this.mWidth);
        this.mPopupWindow.setHeight(-2);
    }

    private void preShow() {
        MenuItemAdapter menuItemAdapter = this.mAdapter;
        if (menuItemAdapter == null) {
            MenuItemAdapter menuItemAdapter2 = new MenuItemAdapter(this.mContext, this.mItems);
            this.mAdapter = menuItemAdapter2;
            this.mItemsView.setAdapter((ListAdapter) menuItemAdapter2);
            return;
        }
        menuItemAdapter.notifyDataSetChanged();
    }

    public MenuItem add(int i, int i2) {
        return add(i, this.mContext.getString(i2));
    }

    public void clear() {
        List<MenuItem> list = this.mItems;
        if (list != null) {
            list.clear();
            MenuItemAdapter menuItemAdapter = this.mAdapter;
            if (menuItemAdapter != null) {
                menuItemAdapter.notifyDataSetChanged();
            }
        }
    }

    public void dismiss() {
        PopupWindow popupWindow = this.mPopupWindow;
        if (popupWindow == null || !popupWindow.isShowing()) {
            return;
        }
        this.mPopupWindow.dismiss();
    }

    public void setDivider(Drawable drawable, int i) {
        ListView listView = this.mItemsView;
        if (listView != null) {
            listView.setDivider(drawable);
            this.mItemsView.setDividerHeight(i);
        }
    }

    public void setHeaderTitle(CharSequence charSequence) {
        this.mHeaderTitleView.setText(charSequence);
        this.mHeaderTitleView.setVisibility(0);
        this.mHeaderTitleView.requestFocus();
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.mPopupWindow.setOnDismissListener(onDismissListener);
    }

    public void setOnItemSelectedListener(OnItemSelectedListener onItemSelectedListener) {
        this.mListener = onItemSelectedListener;
    }

    public void setWidth(int i) {
        this.mWidth = i;
        this.mPopupWindow.setWidth(i);
    }

    public void showAsDropDown(View view) {
        showAsDropDown(view, YoukuPopupHelper.getGravity(view, this.mWidth));
    }

    public MenuItem add(int i, String str) {
        MenuItem menuItem = new MenuItem();
        menuItem.setItemId(i);
        menuItem.setTitle(str);
        this.mItems.add(menuItem);
        return menuItem;
    }

    public void showAsDropDown(View view, int i) {
        if (view != null) {
            if (this.mItems.size() != 0) {
                preShow();
                int[] popupPosition = YoukuPopupHelper.getPopupPosition(view, i);
                this.mPopupWindow.showAtLocation(view, i, popupPosition[0], popupPosition[1]);
                return;
            }
            throw new IllegalStateException("PopupMenu#add was not called with a menu item to display.");
        }
        throw new IllegalStateException("PopupMenu#showAsDropDown anchor cannot be null.");
    }
}
