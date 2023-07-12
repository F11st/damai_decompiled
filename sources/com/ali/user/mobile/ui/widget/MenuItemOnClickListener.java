package com.ali.user.mobile.ui.widget;

import android.view.View;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public abstract class MenuItemOnClickListener implements View.OnClickListener {
    private BottomMenuFragment bottomMenuFragment;
    private MenuItem menuItem;

    public MenuItemOnClickListener(BottomMenuFragment bottomMenuFragment, MenuItem menuItem) {
        this.bottomMenuFragment = bottomMenuFragment;
        this.menuItem = menuItem;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        BottomMenuFragment bottomMenuFragment = this.bottomMenuFragment;
        if (bottomMenuFragment != null && bottomMenuFragment.isVisible()) {
            try {
                this.bottomMenuFragment.dismiss();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        onClickMenuItem(view, this.menuItem);
    }

    public abstract void onClickMenuItem(View view, MenuItem menuItem);
}
