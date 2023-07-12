package com.ali.user.mobile.ui.widget;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import com.ali.user.mobile.app.dataprovider.DataProviderFactory;
import com.ali.user.mobile.log.UserTrackAdapter;
import com.ali.user.mobile.ui.R;
import com.ali.user.mobile.utils.ElderUtil;
import com.ali.user.mobile.utils.ScreenUtil;
import com.taobao.weex.annotation.JSMethod;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class BottomMenuFragment extends DialogFragment {
    private int cancelBtnBgRes;
    private String controlHitPrefix;
    private int itemLayoutId;
    private String mMenuTitle;
    protected TextView mTitleView;
    private List<MenuItem> menuItems;
    private int rootLayoutId;
    private boolean transparent = true;
    protected boolean needDivider = true;

    public List<MenuItem> getMenuItems() {
        return this.menuItems;
    }

    protected void onCancelClick() {
        if (!TextUtils.isEmpty(getTag())) {
            String str = "";
            if (!TextUtils.isEmpty(this.controlHitPrefix)) {
                str = ("" + this.controlHitPrefix) + JSMethod.NOT_SET;
            }
            UserTrackAdapter.sendControlUT(getTag(), str + "cancel");
        }
        dismissAllowingStateLoss();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        getDialog().requestWindowFeature(1);
        if (this.transparent) {
            getDialog().getWindow().setWindowAnimations(R.C2967style.AliUserMenuAnimation);
        }
        if (this.rootLayoutId <= 0) {
            this.rootLayoutId = R.C2965layout.aliuser_fragment_bottom_menu;
        }
        View inflate = layoutInflater.inflate(this.rootLayoutId, viewGroup, false);
        if (this.menuItems == null) {
            dismissAllowingStateLoss();
            return inflate;
        }
        TextView textView = (TextView) inflate.findViewById(R.id.aliuser_cancel_tv);
        int i = this.cancelBtnBgRes;
        if (i > 0) {
            textView.setBackgroundResource(i);
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.ali.user.mobile.ui.widget.BottomMenuFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BottomMenuFragment.this.onCancelClick();
            }
        });
        this.mTitleView = (TextView) inflate.findViewById(R.id.aliuser_bottom_menu_title_tv);
        View findViewById = inflate.findViewById(R.id.aliuser_bottom_menu_title_divider);
        if (TextUtils.isEmpty(this.mMenuTitle)) {
            this.mTitleView.setVisibility(8);
            findViewById.setVisibility(8);
        } else {
            findViewById.setVisibility(0);
            this.mTitleView.setVisibility(0);
            this.mTitleView.setText(this.mMenuTitle);
        }
        ListView listView = (ListView) inflate.findViewById(R.id.aliuser_menu_lv);
        if (!this.needDivider) {
            listView.setDividerHeight(0);
        }
        MenuItemAdapter menuItemAdapter = new MenuItemAdapter(getActivity().getBaseContext(), this.menuItems);
        menuItemAdapter.setLayoutId(this.itemLayoutId);
        listView.setAdapter((ListAdapter) menuItemAdapter);
        ElderUtil.scaleTextSize(textView);
        return inflate;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        WindowManager.LayoutParams attributes = getDialog().getWindow().getAttributes();
        attributes.width = -1;
        attributes.height = -1;
        attributes.gravity = 80;
        getDialog().getWindow().setAttributes(attributes);
        if (this.transparent) {
            getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
        } else {
            getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(getContext().getResources().getColor(R.C2963color.aliuser_half_transparent_background)));
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStop() {
        if (this.transparent) {
            getView().setAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.aliuser_menu_out));
        }
        super.onStop();
    }

    public void setCancelBtnBgRes(int i) {
        this.cancelBtnBgRes = i;
    }

    public void setControlHitPrefix(String str) {
        this.controlHitPrefix = str;
    }

    public void setItemLayoutId(int i) {
        this.itemLayoutId = i;
    }

    public void setMenuItems(List<MenuItem> list) {
        for (MenuItem menuItem : list) {
            if (menuItem.textSize == 0.0f) {
                menuItem.textSize = DataProviderFactory.getApplicationContext().getResources().getDimension(R.dimen.aliuser_textsize_normal);
            }
            if (DataProviderFactory.getDataProvider().enableElder()) {
                menuItem.textSize = ScreenUtil.dip2px(DataProviderFactory.getApplicationContext(), ElderUtil.getScaleSize(ScreenUtil.pxTodip(DataProviderFactory.getApplicationContext(), menuItem.textSize)));
            }
        }
        this.menuItems = list;
    }

    public void setMenuTitle(String str) {
        this.mMenuTitle = str;
    }

    public void setNeedDivider(boolean z) {
        this.needDivider = z;
    }

    public void setRootLayoutId(int i) {
        this.rootLayoutId = i;
    }

    public void setTransparent(boolean z) {
        this.transparent = z;
    }

    @Override // androidx.fragment.app.DialogFragment
    public void show(FragmentManager fragmentManager, String str) {
        try {
            super.show(fragmentManager, str);
        } catch (IllegalStateException unused) {
        }
    }
}
