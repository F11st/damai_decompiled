package com.amap.api.mapcore.util;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import cn.damai.R;
import com.amap.api.maps.offlinemap.OfflineMapManager;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class fm extends fn implements View.OnClickListener {
    private OfflineMapManager a;
    private View b;
    private TextView c;
    private TextView d;
    private TextView e;
    private TextView f;
    private int g;
    private String h;

    public fm(Context context, OfflineMapManager offlineMapManager) {
        super(context);
        this.a = offlineMapManager;
    }

    @Override // com.amap.api.mapcore.util.fn
    protected void a() {
        View a = fs.a(getContext(), R.array.country_codes, null);
        this.b = a;
        setContentView(a);
        this.b.setOnClickListener(new View.OnClickListener() { // from class: com.amap.api.mapcore.util.fm.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                fm.this.dismiss();
            }
        });
        this.c = (TextView) this.b.findViewById(R.dimen.abc_action_bar_content_inset_with_nav);
        TextView textView = (TextView) this.b.findViewById(R.dimen.abc_action_bar_default_height);
        this.d = textView;
        textView.setText("暂停下载");
        this.e = (TextView) this.b.findViewById(R.dimen.abc_action_bar_default_height_material);
        this.f = (TextView) this.b.findViewById(R.dimen.abc_action_bar_default_padding_end_material);
        this.d.setOnClickListener(this);
        this.e.setOnClickListener(this);
        this.f.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        try {
            int id = view.getId();
            if (id != R.dimen.abc_action_bar_default_height) {
                if (id != R.dimen.abc_action_bar_default_height_material) {
                    if (id == R.dimen.abc_action_bar_default_padding_end_material) {
                        dismiss();
                        return;
                    }
                    return;
                } else if (TextUtils.isEmpty(this.h)) {
                    return;
                } else {
                    this.a.remove(this.h);
                    dismiss();
                    return;
                }
            }
            int i = this.g;
            if (i == 0) {
                this.d.setText("继续下载");
                this.a.pause();
            } else if (i == 3 || i == -1 || i == 101 || i == 102 || i == 103) {
                this.d.setText("暂停下载");
                this.a.downloadByCityName(this.h);
            }
            dismiss();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void a(int i, String str) {
        this.c.setText(str);
        if (i == 0) {
            this.d.setText("暂停下载");
            this.d.setVisibility(0);
            this.e.setText("取消下载");
        }
        if (i == 2) {
            this.d.setVisibility(8);
            this.e.setText("取消下载");
        } else if (i == -1 || i == 101 || i == 102 || i == 103) {
            this.d.setText("继续下载");
            this.d.setVisibility(0);
        } else if (i == 3) {
            this.d.setVisibility(0);
            this.d.setText("继续下载");
            this.e.setText("取消下载");
        } else if (i == 4) {
            this.e.setText("删除");
            this.d.setVisibility(8);
        }
        this.g = i;
        this.h = str;
    }
}
