package com.ali.user.mobile.register.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import com.ali.user.mobile.model.RegionInfo;
import com.ali.user.mobile.register.RegistConstants;
import com.ali.user.mobile.ui.R;
import com.alibaba.wireless.security.aopsdk.replace.android.view.Display;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class RegionDialogFragment extends DialogFragment {
    private RegionAdapter mAdapter;
    private RegionInfo mCurrentRegion;
    private List<RegionInfo> mList;
    private ListView mListView;
    private RegionListener mRegionListener;

    private int getSelection() {
        RegionInfo regionInfo = this.mCurrentRegion;
        if (regionInfo == null || TextUtils.isEmpty(regionInfo.name) || this.mList == null) {
            return 0;
        }
        for (int i = 0; i < this.mList.size(); i++) {
            RegionInfo regionInfo2 = this.mList.get(i);
            if (regionInfo2 != null && !TextUtils.isEmpty(regionInfo2.name) && regionInfo2.name.equals(this.mCurrentRegion.name)) {
                return i;
            }
        }
        return 0;
    }

    public List<RegionInfo> getList() {
        return this.mList;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R.C2967style.AliUserDialogTheme);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        RegionAdapter regionAdapter;
        getDialog().requestWindowFeature(1);
        View inflate = layoutInflater.inflate(R.C2965layout.aliuser_register_region_fragment, viewGroup);
        ListView listView = (ListView) inflate.findViewById(R.id.aliuser_region_listview);
        this.mListView = listView;
        if (listView != null && (regionAdapter = this.mAdapter) != null) {
            listView.setAdapter((ListAdapter) regionAdapter);
            if (this.mCurrentRegion != null) {
                int selection = getSelection();
                this.mListView.setSelection(selection);
                this.mListView.setItemChecked(selection, true);
                this.mAdapter.setSelectedItem(this.mCurrentRegion);
            }
            this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.ali.user.mobile.register.ui.RegionDialogFragment.1
                @Override // android.widget.AdapterView.OnItemClickListener
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    RegionInfo regionInfo = (RegionInfo) RegionDialogFragment.this.mList.get(i);
                    new Intent().putExtra(RegistConstants.REGION_INFO, regionInfo);
                    RegionDialogFragment.this.dismissAllowingStateLoss();
                    if (RegionDialogFragment.this.mRegionListener != null) {
                        RegionDialogFragment.this.mRegionListener.onClick(regionInfo);
                    }
                }
            });
        }
        return inflate;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            Display.getMetrics(getActivity().getWindowManager().getDefaultDisplay(), displayMetrics);
            dialog.getWindow().setLayout(com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(displayMetrics), -2);
            WindowManager.LayoutParams attributes = getDialog().getWindow().getAttributes();
            attributes.gravity = 80;
            getDialog().getWindow().setAttributes(attributes);
        }
    }

    public void setCurrentRegion(RegionInfo regionInfo) {
        this.mCurrentRegion = regionInfo;
    }

    public void setList(List<RegionInfo> list) {
        this.mList = list;
    }

    public void setRegionListener(RegionListener regionListener) {
        this.mRegionListener = regionListener;
    }

    public void setupAdapter(Context context) {
        this.mAdapter = new RegionAdapter(context, this.mList);
    }
}
