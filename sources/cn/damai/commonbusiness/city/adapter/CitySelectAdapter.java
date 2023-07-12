package cn.damai.commonbusiness.city.adapter;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.city.listener.OnCityListItemClickListener;
import cn.damai.commonbusiness.city.model.HotCityBean;
import cn.damai.commonbusiness.city.model.SitesBean;
import cn.damai.uikit.flowlayout.FlowLayout;
import com.ali.user.mobile.utils.ScreenUtil;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.cj;
import tb.e80;
import tb.r92;
import tb.t60;
import tb.wh2;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class CitySelectAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange;
    private OnCityListItemClickListener a;
    private Context b;
    private List<cj> c;
    private int d;
    private int e;
    private String f;
    private View.OnClickListener g = new View$OnClickListenerC0606a();

    /* compiled from: Taobao */
    /* loaded from: classes4.dex */
    public class GroupViewHolder extends RecyclerView.ViewHolder {
        private static transient /* synthetic */ IpChange $ipChange;
        private RecyclerView a;
        private GroupCityAdapter b;

        public GroupViewHolder(CitySelectAdapter citySelectAdapter) {
            super(LayoutInflater.from(citySelectAdapter.b).inflate(R$layout.layout_select_city_group_list, (ViewGroup) null));
            this.a = (RecyclerView) this.itemView.findViewById(R$id.group_city_list);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(citySelectAdapter.b);
            linearLayoutManager.setOrientation(1);
            this.a.setLayoutManager(linearLayoutManager);
            GroupCityAdapter groupCityAdapter = new GroupCityAdapter(citySelectAdapter.b);
            this.b = groupCityAdapter;
            groupCityAdapter.f(citySelectAdapter.a);
            this.a.setAdapter(this.b);
            this.itemView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        }

        public void a(cj cjVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "815829813")) {
                ipChange.ipc$dispatch("815829813", new Object[]{this, cjVar});
                return;
            }
            this.b.setData(cjVar.c());
            this.b.notifyDataSetChanged();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes4.dex */
    public class HotViewHolder extends RecyclerView.ViewHolder {
        private static transient /* synthetic */ IpChange $ipChange;
        private FlowLayout a;

        /* compiled from: Taobao */
        /* renamed from: cn.damai.commonbusiness.city.adapter.CitySelectAdapter$HotViewHolder$a */
        /* loaded from: classes14.dex */
        public class View$OnClickListenerC0605a implements View.OnClickListener {
            private static transient /* synthetic */ IpChange $ipChange;
            final /* synthetic */ HotCityBean a;

            View$OnClickListenerC0605a(HotCityBean hotCityBean) {
                this.a = hotCityBean;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1005958438")) {
                    ipChange.ipc$dispatch("-1005958438", new Object[]{this, view});
                } else if (r92.c() || CitySelectAdapter.this.a == null) {
                } else {
                    CitySelectAdapter.this.a.onHotCityClick(this.a.getCityName(), this.a.getCityId(), this.a.getUrl());
                }
            }
        }

        public HotViewHolder() {
            super(LayoutInflater.from(CitySelectAdapter.this.b).inflate(R$layout.layout_select_city_hot_list, (ViewGroup) null));
            this.a = (FlowLayout) this.itemView.findViewById(R$id.hot_city_list);
            this.itemView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        }

        public void a(cj cjVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1451806787")) {
                ipChange.ipc$dispatch("1451806787", new Object[]{this, cjVar});
                return;
            }
            List<HotCityBean> a = cjVar.a();
            int e = wh2.e(a);
            this.a.removeAllViews();
            if (e > 0) {
                for (int i = 0; i < e; i++) {
                    HotCityBean hotCityBean = a.get(i);
                    if (hotCityBean != null) {
                        View inflate = LayoutInflater.from(CitySelectAdapter.this.b).inflate(R$layout.layout_select_city_hot_list_item, (ViewGroup) null);
                        TextView textView = (TextView) inflate.findViewById(R$id.select_city_hot_list_item);
                        ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
                        layoutParams.width = CitySelectAdapter.this.d;
                        layoutParams.height = CitySelectAdapter.this.e;
                        textView.setLayoutParams(layoutParams);
                        if (!TextUtils.isEmpty(CitySelectAdapter.this.f) && CitySelectAdapter.this.f.equals(hotCityBean.getCityName())) {
                            textView.setBackgroundResource(R$drawable.city_select_hot_city_border_select);
                            textView.setTextColor(Color.parseColor("#FF2869"));
                        } else if (z20.d().equals(hotCityBean.getCityName()) && TextUtils.isEmpty(CitySelectAdapter.this.f)) {
                            textView.setBackgroundResource(R$drawable.city_select_hot_city_border_select);
                            textView.setTextColor(Color.parseColor("#FF2869"));
                        } else {
                            textView.setBackgroundResource(R$drawable.city_select_hot_city_border_normal);
                            textView.setTextColor(Color.parseColor("#000000"));
                        }
                        textView.setText(hotCityBean.getCityName());
                        inflate.setOnClickListener(new View$OnClickListenerC0605a(hotCityBean));
                        this.a.addView(inflate);
                    }
                }
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes4.dex */
    public class LacationViewHolder extends RecyclerView.ViewHolder {
        private static transient /* synthetic */ IpChange $ipChange;
        private TextView a;

        public LacationViewHolder() {
            super(LayoutInflater.from(CitySelectAdapter.this.b).inflate(R$layout.layout_select_city_location, (ViewGroup) null));
            TextView textView = (TextView) this.itemView.findViewById(R$id.select_city_hot_list_item);
            this.a = textView;
            ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
            layoutParams.width = -2;
            layoutParams.height = CitySelectAdapter.this.e;
            this.a.setLayoutParams(layoutParams);
            this.a.setMinWidth(CitySelectAdapter.this.d);
            this.itemView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        }

        public void a(cj cjVar) {
            String str;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1586544173")) {
                ipChange.ipc$dispatch("-1586544173", new Object[]{this, cjVar});
                return;
            }
            SitesBean b = cjVar.b();
            int i = cjVar.c;
            str = "定位异常，请退出页面重试";
            int i2 = -16777216;
            int i3 = R$drawable.city_select_hot_city_border_normal;
            if (i == 102) {
                str = "定位获取失败，请点击重试";
            } else if (i == 119) {
                str = "定位中...";
            } else if (i == 136) {
                str = b != null ? b.getCityName() : "定位异常，请退出页面重试";
                i2 = Color.parseColor("#FF2869");
                i3 = R$drawable.city_select_hot_city_border_select;
            }
            this.a.setText(str);
            this.a.setTextColor(i2);
            this.a.setBackgroundResource(i3);
            this.itemView.setTag(cjVar);
            this.itemView.setOnClickListener(CitySelectAdapter.this.g);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.city.adapter.CitySelectAdapter$a */
    /* loaded from: classes14.dex */
    public class View$OnClickListenerC0606a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC0606a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SitesBean b;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "311928320")) {
                ipChange.ipc$dispatch("311928320", new Object[]{this, view});
            } else if (r92.c() || CitySelectAdapter.this.a == null) {
            } else {
                Object tag = view.getTag();
                if (tag instanceof cj) {
                    cj cjVar = (cj) tag;
                    int i = cjVar.c;
                    if (i == 102) {
                        CitySelectAdapter.this.a.onRequestLocationPermission();
                    } else if (i == 136 && (b = cjVar.b()) != null) {
                        CitySelectAdapter.this.a.onLocationCityClick(b.getCityId(), b.getCityName());
                    }
                }
            }
        }
    }

    public CitySelectAdapter(Context context, List<cj> list) {
        this.b = context;
        this.c = list;
        this.d = (e80.d() - t60.a(context, 63.0f)) / 3;
        this.e = ScreenUtil.dip2px(this.b, 31.0f);
    }

    public void g(OnCityListItemClickListener onCityListItemClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-652602115")) {
            ipChange.ipc$dispatch("-652602115", new Object[]{this, onCityListItemClickListener});
        } else {
            this.a = onCityListItemClickListener;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "949577647") ? ((Integer) ipChange.ipc$dispatch("949577647", new Object[]{this})).intValue() : wh2.e(this.c);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "994898646")) {
            return ((Integer) ipChange.ipc$dispatch("994898646", new Object[]{this, Integer.valueOf(i)})).intValue();
        }
        try {
            return this.c.get(i).d();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public void h(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1072504290")) {
            ipChange.ipc$dispatch("-1072504290", new Object[]{this, str});
        } else {
            this.f = str;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-551623702")) {
            ipChange.ipc$dispatch("-551623702", new Object[]{this, viewHolder, Integer.valueOf(i)});
        } else if (viewHolder != null) {
            cj cjVar = this.c.get(i);
            int d = cjVar.d();
            if (d == 0) {
                ((LacationViewHolder) viewHolder).a(cjVar);
            } else if (d == 1) {
                ((HotViewHolder) viewHolder).a(cjVar);
            } else if (d != 2) {
            } else {
                ((GroupViewHolder) viewHolder).a(cjVar);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1253936308")) {
            return (RecyclerView.ViewHolder) ipChange.ipc$dispatch("-1253936308", new Object[]{this, viewGroup, Integer.valueOf(i)});
        }
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    return null;
                }
                return new GroupViewHolder(this);
            }
            return new HotViewHolder();
        }
        return new LacationViewHolder();
    }
}
