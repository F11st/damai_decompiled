package com.ali.user.mobile.ui.widget;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class MenuItem {
    public int bgColor;
    private MenuItemOnClickListener menuItemOnClickListener;
    private String text;
    public int textColor;
    public float textSize;

    public MenuItem() {
    }

    public MenuItemOnClickListener getMenuItemOnClickListener() {
        return this.menuItemOnClickListener;
    }

    public String getText() {
        return this.text;
    }

    public void setMenuItemOnClickListener(MenuItemOnClickListener menuItemOnClickListener) {
        this.menuItemOnClickListener = menuItemOnClickListener;
    }

    public void setText(String str) {
        this.text = str;
    }

    public MenuItem(String str, MenuItemOnClickListener menuItemOnClickListener) {
        this.text = str;
        this.menuItemOnClickListener = menuItemOnClickListener;
    }
}
