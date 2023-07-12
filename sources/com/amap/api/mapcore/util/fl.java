package com.amap.api.mapcore.util;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import cn.damai.R;
import com.amap.api.maps.AMapException;
import com.amap.api.maps.offlinemap.OfflineMapActivity;
import com.amap.api.maps.offlinemap.OfflineMapCity;
import com.amap.api.maps.offlinemap.OfflineMapManager;
import com.amap.api.maps.offlinemap.OfflineMapProvince;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class fl extends BaseAdapter {
    private List<OfflineMapCity> a = new ArrayList();
    private OfflineMapManager b;
    private Activity c;

    /* compiled from: Taobao */
    /* renamed from: com.amap.api.mapcore.util.fl$a */
    /* loaded from: classes10.dex */
    public final class C4546a {
        public TextView a;
        public TextView b;
        public TextView c;
        public ImageView d;

        public C4546a() {
        }
    }

    public fl(List<OfflineMapProvince> list, OfflineMapManager offlineMapManager, OfflineMapActivity offlineMapActivity) {
        this.b = offlineMapManager;
        this.c = offlineMapActivity;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.a.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.a.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        final C4546a c4546a;
        int state;
        try {
            final OfflineMapCity offlineMapCity = this.a.get(i);
            if (view == null) {
                c4546a = new C4546a();
                view = fs.a(this.c, R.array.coupons_title, null);
                c4546a.a = (TextView) view.findViewById(R.dimen.abc_action_bar_default_padding_start_material);
                c4546a.b = (TextView) view.findViewById(R.dimen.abc_action_bar_overflow_padding_start_material);
                c4546a.c = (TextView) view.findViewById(R.dimen.abc_action_bar_icon_vertical_padding_material);
                c4546a.d = (ImageView) view.findViewById(R.dimen.abc_action_bar_overflow_padding_end_material);
                view.setTag(c4546a);
            } else {
                c4546a = (C4546a) view.getTag();
            }
            c4546a.d.setOnClickListener(new View.OnClickListener() { // from class: com.amap.api.mapcore.util.fl.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    c4546a.d.setVisibility(8);
                    c4546a.c.setVisibility(0);
                    c4546a.c.setText("下载中");
                    try {
                        fl.this.b.downloadByCityName(offlineMapCity.getCity());
                    } catch (AMapException e) {
                        e.printStackTrace();
                    }
                }
            });
            c4546a.c.setVisibility(0);
            c4546a.a.setText(offlineMapCity.getCity());
            TextView textView = c4546a.b;
            textView.setText(String.valueOf(((int) (((offlineMapCity.getSize() / 1024.0d) / 1024.0d) * 100.0d)) / 100.0d) + " M");
            state = offlineMapCity.getState();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (state != -1) {
            if (state == 0 || state == 1) {
                c4546a.d.setVisibility(8);
                c4546a.c.setText("下载中");
            } else if (state == 2) {
                c4546a.d.setVisibility(8);
                c4546a.c.setText("等待下载");
            } else if (state == 3) {
                c4546a.d.setVisibility(8);
                c4546a.c.setText("暂停中");
            } else if (state == 4) {
                c4546a.d.setVisibility(8);
                c4546a.c.setText("已下载");
            } else if (state != 6) {
                switch (state) {
                }
            } else {
                c4546a.d.setVisibility(0);
                c4546a.c.setVisibility(8);
            }
            return view;
        }
        c4546a.d.setVisibility(8);
        c4546a.c.setText("下载失败");
        return view;
    }

    public void a(List<OfflineMapCity> list) {
        this.a = list;
    }
}
