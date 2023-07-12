package com.amap.api.mapcore.util;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.damai.R;
import com.amap.api.maps.offlinemap.OfflineMapManager;
import com.amap.api.maps.offlinemap.OfflineMapProvince;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class fk extends BaseExpandableListAdapter implements ExpandableListView.OnGroupCollapseListener, ExpandableListView.OnGroupExpandListener {
    private boolean[] a;
    private int b = -1;
    private List<OfflineMapProvince> c;
    private OfflineMapManager d;
    private Context e;

    /* compiled from: Taobao */
    /* renamed from: com.amap.api.mapcore.util.fk$a */
    /* loaded from: classes10.dex */
    public final class C4545a {
        public fo a;

        public C4545a() {
        }
    }

    public fk(List<OfflineMapProvince> list, OfflineMapManager offlineMapManager, Context context) {
        this.c = null;
        this.c = list;
        this.d = offlineMapManager;
        this.e = context;
        this.a = new boolean[list.size()];
    }

    private boolean a(int i) {
        return (i == 0 || i == getGroupCount() - 1) ? false : true;
    }

    public void b() {
        this.b = 0;
        notifyDataSetChanged();
    }

    @Override // android.widget.ExpandableListAdapter
    public Object getChild(int i, int i2) {
        return null;
    }

    @Override // android.widget.ExpandableListAdapter
    public long getChildId(int i, int i2) {
        return i2;
    }

    @Override // android.widget.ExpandableListAdapter
    public View getChildView(int i, int i2, boolean z, View view, ViewGroup viewGroup) {
        C4545a c4545a;
        if (view != null) {
            c4545a = (C4545a) view.getTag();
        } else {
            c4545a = new C4545a();
            fo foVar = new fo(this.e, this.d);
            foVar.a(1);
            View a = foVar.a();
            c4545a.a = foVar;
            a.setTag(c4545a);
            view = a;
        }
        c4545a.a.a(this.c.get(i).getCityList().get(i2));
        return view;
    }

    @Override // android.widget.ExpandableListAdapter
    public int getChildrenCount(int i) {
        if (a(i)) {
            return this.c.get(i).getCityList().size();
        }
        return this.c.get(i).getCityList().size();
    }

    @Override // android.widget.ExpandableListAdapter
    public Object getGroup(int i) {
        return this.c.get(i).getProvinceName();
    }

    @Override // android.widget.ExpandableListAdapter
    public int getGroupCount() {
        int i = this.b;
        return i == -1 ? this.c.size() : i;
    }

    @Override // android.widget.ExpandableListAdapter
    public long getGroupId(int i) {
        return i;
    }

    @Override // android.widget.ExpandableListAdapter
    public View getGroupView(int i, boolean z, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = (RelativeLayout) fs.a(this.e, R.array.custom_months, null);
        }
        ImageView imageView = (ImageView) view.findViewById(R.dimen.abc_action_bar_subtitle_bottom_margin_material);
        ((TextView) view.findViewById(R.dimen.abc_action_bar_stacked_tab_max_width)).setText(this.c.get(i).getProvinceName());
        if (this.a[i]) {
            imageView.setImageDrawable(fs.a().getDrawable(R.animator.fragment_close_enter));
        } else {
            imageView.setImageDrawable(fs.a().getDrawable(R.animator.fragment_close_exit));
        }
        return view;
    }

    @Override // android.widget.ExpandableListAdapter
    public boolean hasStableIds() {
        return true;
    }

    @Override // android.widget.ExpandableListAdapter
    public boolean isChildSelectable(int i, int i2) {
        return true;
    }

    @Override // android.widget.ExpandableListView.OnGroupCollapseListener
    public void onGroupCollapse(int i) {
        this.a[i] = false;
    }

    @Override // android.widget.ExpandableListView.OnGroupExpandListener
    public void onGroupExpand(int i) {
        this.a[i] = true;
    }

    public void a() {
        this.b = -1;
        notifyDataSetChanged();
    }
}
