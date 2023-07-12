package com.amap.api.mapcore.util;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.AutoCompleteTextView;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;
import cn.damai.R;
import com.amap.api.maps.offlinemap.DownLoadExpandListView;
import com.amap.api.maps.offlinemap.OfflineMapCity;
import com.amap.api.maps.offlinemap.OfflineMapManager;
import com.amap.api.maps.offlinemap.OfflineMapProvince;
import com.amap.api.offlineservice.AbstractC4659a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class fq extends AbstractC4659a implements TextWatcher, View.OnTouchListener, AbsListView.OnScrollListener, OfflineMapManager.OfflineLoadedListener, OfflineMapManager.OfflineMapDownloadListener {
    private ImageView b;
    private RelativeLayout c;
    private DownLoadExpandListView d;
    private ListView e;
    private ExpandableListView f;
    private ImageView g;
    private ImageView h;
    private AutoCompleteTextView i;
    private RelativeLayout j;
    private RelativeLayout k;
    private ImageView l;
    private ImageView m;
    private RelativeLayout n;
    private fk p;
    private fj r;
    private fl s;
    private fm x;
    private List<OfflineMapProvince> o = new ArrayList();
    private OfflineMapManager q = null;
    private boolean t = true;
    private boolean u = true;
    private int v = -1;
    private long w = 0;
    private boolean y = true;

    private void j() {
        try {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.m.getLayoutParams();
            layoutParams.leftMargin = a(18.0f);
            this.m.setLayoutParams(layoutParams);
            this.i.setPadding(a(30.0f), 0, 0, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void k() {
        l();
        fl flVar = new fl(this.o, this.q, this.a);
        this.s = flVar;
        this.e.setAdapter((ListAdapter) flVar);
    }

    private void l() {
        ArrayList<OfflineMapProvince> offlineMapProvinceList = this.q.getOfflineMapProvinceList();
        this.o.clear();
        this.o.add(null);
        ArrayList<OfflineMapCity> arrayList = new ArrayList<>();
        ArrayList<OfflineMapCity> arrayList2 = new ArrayList<>();
        ArrayList<OfflineMapCity> arrayList3 = new ArrayList<>();
        for (int i = 0; i < offlineMapProvinceList.size(); i++) {
            OfflineMapProvince offlineMapProvince = offlineMapProvinceList.get(i);
            if (offlineMapProvince.getCityList().size() != 1) {
                this.o.add(i + 1, offlineMapProvince);
            } else {
                String provinceName = offlineMapProvince.getProvinceName();
                if (provinceName.contains("香港")) {
                    arrayList2.addAll(offlineMapProvince.getCityList());
                } else if (provinceName.contains("澳门")) {
                    arrayList2.addAll(offlineMapProvince.getCityList());
                } else if (provinceName.contains("全国概要图")) {
                    arrayList3.addAll(0, offlineMapProvince.getCityList());
                } else {
                    arrayList3.addAll(offlineMapProvince.getCityList());
                }
            }
        }
        OfflineMapProvince offlineMapProvince2 = new OfflineMapProvince();
        offlineMapProvince2.setProvinceName("基本功能包+直辖市");
        offlineMapProvince2.setCityList(arrayList3);
        this.o.set(0, offlineMapProvince2);
        OfflineMapProvince offlineMapProvince3 = new OfflineMapProvince();
        offlineMapProvince3.setProvinceName("直辖市");
        offlineMapProvince3.setCityList(arrayList);
        OfflineMapProvince offlineMapProvince4 = new OfflineMapProvince();
        offlineMapProvince4.setProvinceName("港澳");
        offlineMapProvince4.setCityList(arrayList2);
        this.o.add(offlineMapProvince4);
    }

    private void m() {
        AutoCompleteTextView autoCompleteTextView = this.i;
        if (autoCompleteTextView == null || !autoCompleteTextView.isFocused()) {
            return;
        }
        this.i.clearFocus();
        InputMethodManager inputMethodManager = (InputMethodManager) this.a.getSystemService("input_method");
        if (inputMethodManager != null ? inputMethodManager.isActive() : false) {
            inputMethodManager.hideSoftInputFromWindow(this.i.getWindowToken(), 2);
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // com.amap.api.offlineservice.AbstractC4659a
    public void d() {
        this.q.destroy();
    }

    public void i() {
        fj fjVar = new fj(this.a, this, this.q, this.o);
        this.r = fjVar;
        this.d.setAdapter(fjVar);
        this.r.notifyDataSetChanged();
    }

    @Override // com.amap.api.maps.offlinemap.OfflineMapManager.OfflineMapDownloadListener
    public void onCheckUpdate(boolean z, String str) {
    }

    @Override // com.amap.api.maps.offlinemap.OfflineMapManager.OfflineMapDownloadListener
    public void onDownload(int i, int i2, String str) {
        if (i == 101) {
            try {
                Toast.makeText(this.a, "网络异常", 0).show();
                this.q.pause();
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        if (i == 2) {
            this.r.a();
        }
        if (this.v != i) {
            fk fkVar = this.p;
            if (fkVar != null) {
                fkVar.notifyDataSetChanged();
            }
            fj fjVar = this.r;
            if (fjVar != null) {
                fjVar.notifyDataSetChanged();
            }
            fl flVar = this.s;
            if (flVar != null) {
                flVar.notifyDataSetChanged();
            }
            this.v = i;
        } else if (System.currentTimeMillis() - this.w > 1200) {
            if (this.y) {
                this.r.notifyDataSetChanged();
            }
            this.w = System.currentTimeMillis();
        }
    }

    @Override // com.amap.api.maps.offlinemap.OfflineMapManager.OfflineMapDownloadListener
    public void onRemove(boolean z, String str, String str2) {
        fj fjVar = this.r;
        if (fjVar != null) {
            fjVar.b();
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 2) {
            this.y = false;
        } else {
            this.y = true;
        }
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (TextUtils.isEmpty(charSequence)) {
            a(false);
            this.l.setVisibility(8);
            return;
        }
        this.l.setVisibility(0);
        ArrayList arrayList = new ArrayList();
        List<OfflineMapProvince> list = this.o;
        if (list != null && list.size() > 0) {
            ArrayList<OfflineMapCity> arrayList2 = new ArrayList();
            for (OfflineMapProvince offlineMapProvince : this.o) {
                arrayList2.addAll(offlineMapProvince.getCityList());
            }
            for (OfflineMapCity offlineMapCity : arrayList2) {
                String city = offlineMapCity.getCity();
                String pinyin = offlineMapCity.getPinyin();
                String jianpin = offlineMapCity.getJianpin();
                if (charSequence.length() == 1) {
                    if (jianpin.startsWith(String.valueOf(charSequence))) {
                        arrayList.add(offlineMapCity);
                    }
                } else if (jianpin.startsWith(String.valueOf(charSequence)) || pinyin.startsWith(String.valueOf(charSequence)) || city.startsWith(String.valueOf(charSequence))) {
                    arrayList.add(offlineMapCity);
                }
            }
        }
        if (arrayList.size() > 0) {
            a(true);
            Collections.sort(arrayList, new Comparator<OfflineMapCity>() { // from class: com.amap.api.mapcore.util.fq.2
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(OfflineMapCity offlineMapCity2, OfflineMapCity offlineMapCity3) {
                    char[] charArray = offlineMapCity2.getJianpin().toCharArray();
                    char[] charArray2 = offlineMapCity3.getJianpin().toCharArray();
                    return (charArray[0] >= charArray2[0] && charArray[1] >= charArray2[1]) ? 0 : 1;
                }
            });
            fl flVar = this.s;
            if (flVar != null) {
                flVar.a(arrayList);
                this.s.notifyDataSetChanged();
                return;
            }
            return;
        }
        Toast.makeText(this.a, "未找到相关城市", 0).show();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        m();
        if (view.getId() == R.dimen.abc_alert_dialog_button_dimen) {
            j();
            return false;
        }
        return false;
    }

    @Override // com.amap.api.maps.offlinemap.OfflineMapManager.OfflineLoadedListener
    public void onVerifyComplete() {
        k();
        i();
    }

    @Override // com.amap.api.offlineservice.AbstractC4659a
    public void a() {
        View a = fs.a(this.a, R.array.collect_title, null);
        DownLoadExpandListView downLoadExpandListView = (DownLoadExpandListView) a.findViewById(R.dimen.USER_HEADER_HC);
        this.d = downLoadExpandListView;
        downLoadExpandListView.setOnTouchListener(this);
        this.j = (RelativeLayout) a.findViewById(R.dimen.CELL_HEADER_H);
        this.g = (ImageView) a.findViewById(R.dimen.USER_HEADER_HB);
        this.j.setOnClickListener(this.a);
        this.k = (RelativeLayout) a.findViewById(R.dimen.USER_INFO_H);
        this.h = (ImageView) a.findViewById(R.dimen.abc_action_bar_content_inset_material);
        this.k.setOnClickListener(this.a);
        this.n = (RelativeLayout) a.findViewById(R.dimen.USER_HEADER_HCMY);
        ImageView imageView = (ImageView) this.c.findViewById(R.dimen.abc_action_button_min_width_material);
        this.b = imageView;
        imageView.setOnClickListener(this.a);
        this.m = (ImageView) this.c.findViewById(R.dimen.abc_alert_dialog_button_bar_height);
        ImageView imageView2 = (ImageView) this.c.findViewById(R.dimen.abc_button_inset_horizontal_material);
        this.l = imageView2;
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.amap.api.mapcore.util.fq.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    fq.this.i.setText("");
                    fq.this.l.setVisibility(8);
                    fq.this.a(false);
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) fq.this.m.getLayoutParams();
                    layoutParams.leftMargin = fq.this.a(95.0f);
                    fq.this.m.setLayoutParams(layoutParams);
                    fq.this.i.setPadding(fq.this.a(105.0f), 0, 0, 0);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        this.c.findViewById(R.dimen.abc_button_inset_vertical_material).setOnTouchListener(this);
        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) this.c.findViewById(R.dimen.abc_alert_dialog_button_dimen);
        this.i = autoCompleteTextView;
        autoCompleteTextView.addTextChangedListener(this);
        this.i.setOnTouchListener(this);
        this.e = (ListView) this.c.findViewById(R.dimen.abc_button_padding_vertical_material);
        ExpandableListView expandableListView = (ExpandableListView) this.c.findViewById(R.dimen.abc_button_padding_horizontal_material);
        this.f = expandableListView;
        expandableListView.addHeaderView(a);
        this.f.setOnTouchListener(this);
        this.f.setOnScrollListener(this);
        OfflineMapManager offlineMapManager = new OfflineMapManager(this.a, this);
        this.q = offlineMapManager;
        offlineMapManager.setOnOfflineLoadedListener(this);
        l();
        fk fkVar = new fk(this.o, this.q, this.a);
        this.p = fkVar;
        this.f.setAdapter(fkVar);
        this.f.setOnGroupCollapseListener(this.p);
        this.f.setOnGroupExpandListener(this.p);
        this.f.setGroupIndicator(null);
        if (this.t) {
            this.h.setBackgroundResource(R.animator.design_appbar_state_list_animator);
            this.f.setVisibility(0);
        } else {
            this.h.setBackgroundResource(R.animator.flipper_out);
            this.f.setVisibility(8);
        }
        if (this.u) {
            this.g.setBackgroundResource(R.animator.design_appbar_state_list_animator);
            this.d.setVisibility(0);
            return;
        }
        this.g.setBackgroundResource(R.animator.flipper_out);
        this.d.setVisibility(8);
    }

    @Override // com.amap.api.offlineservice.AbstractC4659a
    public boolean b() {
        try {
            if (this.e.getVisibility() == 0) {
                this.i.setText("");
                this.l.setVisibility(8);
                a(false);
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return super.b();
    }

    @Override // com.amap.api.offlineservice.AbstractC4659a
    public RelativeLayout c() {
        if (this.c == null) {
            this.c = (RelativeLayout) fs.a(this.a, R.array.dago_pgc_ykl_gift_combo_star_anim, null);
        }
        return this.c;
    }

    @Override // com.amap.api.offlineservice.AbstractC4659a
    public void a(View view) {
        try {
            int id = view.getId();
            if (id == R.dimen.abc_action_button_min_width_material) {
                this.a.closeScr();
            } else if (id == R.dimen.CELL_HEADER_H) {
                if (this.u) {
                    this.d.setVisibility(8);
                    this.g.setBackgroundResource(R.animator.flipper_out);
                    this.u = false;
                } else {
                    this.d.setVisibility(0);
                    this.g.setBackgroundResource(R.animator.design_appbar_state_list_animator);
                    this.u = true;
                }
            } else if (id == R.dimen.USER_INFO_H) {
                if (this.t) {
                    this.p.b();
                    this.h.setBackgroundResource(R.animator.flipper_out);
                    this.t = false;
                } else {
                    this.p.a();
                    this.h.setBackgroundResource(R.animator.design_appbar_state_list_animator);
                    this.t = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void a(OfflineMapCity offlineMapCity) {
        try {
            if (this.x == null) {
                this.x = new fm(this.a, this.q);
            }
            this.x.a(offlineMapCity.getState(), offlineMapCity.getCity());
            this.x.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void a(boolean z) {
        if (z) {
            this.j.setVisibility(8);
            this.k.setVisibility(8);
            this.d.setVisibility(8);
            this.f.setVisibility(8);
            this.n.setVisibility(8);
            this.e.setVisibility(0);
            return;
        }
        this.j.setVisibility(0);
        this.k.setVisibility(0);
        this.n.setVisibility(0);
        this.d.setVisibility(this.u ? 0 : 8);
        this.f.setVisibility(this.t ? 0 : 8);
        this.e.setVisibility(8);
    }
}
