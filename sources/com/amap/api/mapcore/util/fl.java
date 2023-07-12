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
    /* loaded from: classes10.dex */
    public final class a {
        public TextView a;
        public TextView b;
        public TextView c;
        public ImageView d;

        public a() {
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
        final a aVar;
        int state;
        try {
            final OfflineMapCity offlineMapCity = this.a.get(i);
            if (view == null) {
                aVar = new a();
                view = fs.a(this.c, R.array.coupons_title, null);
                aVar.a = (TextView) view.findViewById(R.dimen.abc_action_bar_default_padding_start_material);
                aVar.b = (TextView) view.findViewById(R.dimen.abc_action_bar_overflow_padding_start_material);
                aVar.c = (TextView) view.findViewById(R.dimen.abc_action_bar_icon_vertical_padding_material);
                aVar.d = (ImageView) view.findViewById(R.dimen.abc_action_bar_overflow_padding_end_material);
                view.setTag(aVar);
            } else {
                aVar = (a) view.getTag();
            }
            aVar.d.setOnClickListener(new View.OnClickListener() { // from class: com.amap.api.mapcore.util.fl.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    aVar.d.setVisibility(8);
                    aVar.c.setVisibility(0);
                    aVar.c.setText("下载中");
                    try {
                        fl.this.b.downloadByCityName(offlineMapCity.getCity());
                    } catch (AMapException e) {
                        e.printStackTrace();
                    }
                }
            });
            aVar.c.setVisibility(0);
            aVar.a.setText(offlineMapCity.getCity());
            TextView textView = aVar.b;
            textView.setText(String.valueOf(((int) (((offlineMapCity.getSize() / 1024.0d) / 1024.0d) * 100.0d)) / 100.0d) + " M");
            state = offlineMapCity.getState();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (state != -1) {
            if (state == 0 || state == 1) {
                aVar.d.setVisibility(8);
                aVar.c.setText("下载中");
            } else if (state == 2) {
                aVar.d.setVisibility(8);
                aVar.c.setText("等待下载");
            } else if (state == 3) {
                aVar.d.setVisibility(8);
                aVar.c.setText("暂停中");
            } else if (state == 4) {
                aVar.d.setVisibility(8);
                aVar.c.setText("已下载");
            } else if (state != 6) {
                switch (state) {
                }
            } else {
                aVar.d.setVisibility(0);
                aVar.c.setVisibility(8);
            }
            return view;
        }
        aVar.d.setVisibility(8);
        aVar.c.setText("下载失败");
        return view;
    }

    public void a(List<OfflineMapCity> list) {
        this.a = list;
    }
}
