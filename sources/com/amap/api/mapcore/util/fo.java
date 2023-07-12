package com.amap.api.mapcore.util;

import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.internal.view.SupportMenu;
import cn.damai.R;
import com.amap.api.maps.AMapException;
import com.amap.api.maps.offlinemap.DownloadProgressView;
import com.amap.api.maps.offlinemap.OfflineMapCity;
import com.amap.api.maps.offlinemap.OfflineMapManager;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class fo implements View.OnClickListener {
    private Context b;
    private TextView c;
    private TextView d;
    private ImageView e;
    private TextView f;
    private OfflineMapManager g;
    private OfflineMapCity h;
    private View k;
    private DownloadProgressView l;
    private int a = 0;
    private boolean i = false;
    private Handler j = new Handler() { // from class: com.amap.api.mapcore.util.fo.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            try {
                fo.this.a(message.arg1, message.arg2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };

    public fo(Context context, OfflineMapManager offlineMapManager) {
        this.b = context;
        b();
        this.g = offlineMapManager;
    }

    private void b() {
        View a = fs.a(this.b, R.array.coupons_title, null);
        this.k = a;
        this.l = (DownloadProgressView) a.findViewById(R.dimen.abc_action_bar_stacked_max_height);
        this.c = (TextView) this.k.findViewById(R.dimen.abc_action_bar_default_padding_start_material);
        this.d = (TextView) this.k.findViewById(R.dimen.abc_action_bar_overflow_padding_start_material);
        this.e = (ImageView) this.k.findViewById(R.dimen.abc_action_bar_overflow_padding_end_material);
        this.f = (TextView) this.k.findViewById(R.dimen.abc_action_bar_icon_vertical_padding_material);
        this.e.setOnClickListener(this);
    }

    private void c() {
        this.f.setVisibility(8);
        this.e.setVisibility(0);
        this.e.setImageResource(R.animator.design_fab_show_motion_spec);
    }

    private void d() {
        this.f.setVisibility(0);
        this.e.setVisibility(0);
        this.e.setImageResource(R.animator.design_fab_show_motion_spec);
        this.f.setText("已下载-有更新");
    }

    private void e() {
        this.f.setVisibility(0);
        this.e.setVisibility(8);
        this.f.setTextColor(SupportMenu.CATEGORY_MASK);
        this.f.setText("下载出现异常");
    }

    private void f() {
        this.f.setVisibility(0);
        this.e.setVisibility(8);
        this.f.setText("已下载");
        this.f.setTextColor(Color.parseColor("#898989"));
    }

    private synchronized void g() {
        this.g.pause();
        this.g.restart();
    }

    private synchronized boolean h() {
        try {
            this.g.downloadByCityName(this.h.getCity());
        } catch (AMapException e) {
            e.printStackTrace();
            Toast.makeText(this.b, e.getErrorMessage(), 0).show();
            return false;
        }
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        try {
            if (!eq.d(this.b)) {
                Toast.makeText(this.b, "无网络连接", 0).show();
                return;
            }
            OfflineMapCity offlineMapCity = this.h;
            if (offlineMapCity != null) {
                int state = offlineMapCity.getState();
                int i = this.h.getcompleteCode();
                if (state == 0) {
                    g();
                    c(i);
                } else if (state == 1 || state == 4) {
                } else {
                    if (h()) {
                        b(i);
                    } else {
                        e();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2) throws Exception {
        if (this.a == 2 && i2 > 3 && i2 < 100) {
            this.l.setVisibility(0);
            this.l.setProgress(i2);
        } else {
            this.l.setVisibility(8);
        }
        if (i == -1) {
            e();
        } else if (i == 0) {
            if (this.a == 1) {
                this.e.setVisibility(8);
                this.f.setText("下载中");
                this.f.setTextColor(Color.parseColor("#4287ff"));
                return;
            }
            e(i2);
        } else if (i == 1) {
            d(i2);
        } else if (i == 2) {
            b(i2);
        } else if (i == 3) {
            c(i2);
        } else if (i == 4) {
            f();
        } else if (i == 6) {
            c();
        } else if (i != 7) {
            switch (i) {
                case 101:
                case 102:
                case 103:
                    e();
                    return;
                default:
                    return;
            }
        } else {
            d();
        }
    }

    private void c(int i) {
        this.f.setVisibility(0);
        this.e.setVisibility(8);
        this.f.setTextColor(-7829368);
        this.f.setText("暂停");
    }

    private void d(int i) {
        if (this.a == 1) {
            return;
        }
        this.f.setVisibility(0);
        this.e.setVisibility(8);
        this.f.setText("解压中");
        this.f.setTextColor(Color.parseColor("#898989"));
    }

    private void e(int i) {
        if (this.h == null) {
            return;
        }
        this.f.setVisibility(0);
        this.f.setText("下载中");
        this.e.setVisibility(8);
        this.f.setTextColor(Color.parseColor("#4287ff"));
    }

    private void b(int i) {
        if (this.a == 1) {
            this.e.setVisibility(8);
            this.f.setVisibility(0);
            this.f.setText("等待中");
            this.f.setTextColor(Color.parseColor("#4287ff"));
            return;
        }
        this.f.setVisibility(0);
        this.e.setVisibility(8);
        this.f.setTextColor(Color.parseColor("#4287ff"));
        this.f.setText("等待中");
    }

    public void a(int i) {
        this.a = i;
    }

    public View a() {
        return this.k;
    }

    public void a(OfflineMapCity offlineMapCity) {
        if (offlineMapCity != null) {
            this.h = offlineMapCity;
            this.c.setText(offlineMapCity.getCity());
            TextView textView = this.d;
            textView.setText(String.valueOf(((int) (((offlineMapCity.getSize() / 1024.0d) / 1024.0d) * 100.0d)) / 100.0d) + " M");
            a(this.h.getState(), this.h.getcompleteCode(), this.i);
        }
    }

    private void a(int i, int i2, boolean z) {
        OfflineMapCity offlineMapCity = this.h;
        if (offlineMapCity != null) {
            offlineMapCity.setState(i);
            this.h.setCompleteCode(i2);
        }
        Message message = new Message();
        message.arg1 = i;
        message.arg2 = i2;
        this.j.sendMessage(message);
    }
}
