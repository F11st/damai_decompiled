package cn.damai.commonbusiness.citycopy.adapter;

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
import cn.damai.commonbusiness.citycopy.listener.OnCityListItemClickListener;
import cn.damai.commonbusiness.citycopy.model.HotCityBean;
import cn.damai.commonbusiness.citycopy.model.SitesBean;
import com.alibaba.pictures.R$drawable;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.R$layout;
import com.alibaba.pictures.bricks.view.FlowLayout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.bb2;
import tb.bj;
import tb.gm;
import tb.k62;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class CitySelectAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange;
    private OnCityListItemClickListener a;
    private Context b;
    private List<bj> c;
    private int d;
    private int e;
    private String f;
    private View.OnClickListener g = new View$OnClickListenerC0610a();

    /* compiled from: Taobao */
    /* loaded from: classes4.dex */
    public class GroupViewHolder extends RecyclerView.ViewHolder {
        private static transient /* synthetic */ IpChange $ipChange;
        private RecyclerView a;
        private GroupCityAdapter b;

        public GroupViewHolder(CitySelectAdapter citySelectAdapter) {
            super(LayoutInflater.from(citySelectAdapter.b).inflate(R$layout.copy_layout_select_city_group_list, (ViewGroup) null));
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

        public void a(bj bjVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2030104469")) {
                ipChange.ipc$dispatch("2030104469", new Object[]{this, bjVar});
                return;
            }
            this.b.setData(bjVar.c());
            this.b.notifyDataSetChanged();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes4.dex */
    public class HotViewHolder extends RecyclerView.ViewHolder {
        private static transient /* synthetic */ IpChange $ipChange;
        private FlowLayout a;

        /* compiled from: Taobao */
        /* renamed from: cn.damai.commonbusiness.citycopy.adapter.CitySelectAdapter$HotViewHolder$a */
        /* loaded from: classes14.dex */
        public class View$OnClickListenerC0609a implements View.OnClickListener {
            private static transient /* synthetic */ IpChange $ipChange;
            final /* synthetic */ HotCityBean a;

            View$OnClickListenerC0609a(HotCityBean hotCityBean) {
                this.a = hotCityBean;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1322044401")) {
                    ipChange.ipc$dispatch("-1322044401", new Object[]{this, view});
                } else if (k62.d() || CitySelectAdapter.this.a == null) {
                } else {
                    CitySelectAdapter.this.a.onHotCityClick(this.a.getCityName(), this.a.getCityId(), this.a.getUrl());
                }
            }
        }

        public HotViewHolder() {
            super(LayoutInflater.from(CitySelectAdapter.this.b).inflate(R$layout.copy_layout_select_city_hot_list, (ViewGroup) null));
            this.a = (FlowLayout) this.itemView.findViewById(R$id.hot_city_list);
            this.itemView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        }

        public void a(bj bjVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-66195741")) {
                ipChange.ipc$dispatch("-66195741", new Object[]{this, bjVar});
                return;
            }
            List<HotCityBean> a = bjVar.a();
            int c = bb2.c(a);
            this.a.removeAllViews();
            if (c > 0) {
                for (int i = 0; i < c; i++) {
                    HotCityBean hotCityBean = a.get(i);
                    if (hotCityBean != null) {
                        View inflate = LayoutInflater.from(CitySelectAdapter.this.b).inflate(R$layout.copy_layout_select_city_hot_list_item, (ViewGroup) null);
                        TextView textView = (TextView) inflate.findViewById(R$id.select_city_hot_list_item);
                        ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
                        layoutParams.width = CitySelectAdapter.this.d;
                        layoutParams.height = CitySelectAdapter.this.e;
                        textView.setLayoutParams(layoutParams);
                        if (!TextUtils.isEmpty(CitySelectAdapter.this.f) && CitySelectAdapter.this.f.equals(hotCityBean.getCityName())) {
                            textView.setBackgroundResource(R$drawable.copy_city_select_hot_city_border_select);
                            textView.setTextColor(Color.parseColor("#FF2869"));
                        } else if (gm.INSTANCE.a().getCityName().equals(hotCityBean.getCityName()) && TextUtils.isEmpty(CitySelectAdapter.this.f)) {
                            textView.setBackgroundResource(R$drawable.copy_city_select_hot_city_border_select);
                            textView.setTextColor(Color.parseColor("#FF2869"));
                        } else {
                            textView.setBackgroundResource(R$drawable.copy_city_select_hot_city_border_normal);
                            textView.setTextColor(Color.parseColor("#000000"));
                        }
                        textView.setText(hotCityBean.getCityName());
                        inflate.setOnClickListener(new View$OnClickListenerC0609a(hotCityBean));
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
            super(LayoutInflater.from(CitySelectAdapter.this.b).inflate(R$layout.copy_layout_select_city_location, (ViewGroup) null));
            TextView textView = (TextView) this.itemView.findViewById(R$id.select_city_hot_list_item);
            this.a = textView;
            ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
            layoutParams.width = -2;
            layoutParams.height = CitySelectAdapter.this.e;
            this.a.setLayoutParams(layoutParams);
            this.a.setMinWidth(CitySelectAdapter.this.d);
            this.itemView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        }

        public void a(bj bjVar) {
            String str;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-331793623")) {
                ipChange.ipc$dispatch("-331793623", new Object[]{this, bjVar});
                return;
            }
            SitesBean b = bjVar.b();
            int i = bjVar.c;
            str = "定位异常，请退出页面重试";
            int i2 = -16777216;
            int i3 = R$drawable.copy_city_select_hot_city_border_normal;
            if (i == 102) {
                str = "定位获取失败，请点击重试";
            } else if (i == 119) {
                str = "定位中...";
            } else if (i == 136) {
                str = b != null ? b.getCityName() : "定位异常，请退出页面重试";
                i2 = Color.parseColor("#FF2869");
                i3 = R$drawable.copy_city_select_hot_city_border_select;
            }
            this.a.setText(str);
            this.a.setTextColor(i2);
            this.a.setBackgroundResource(i3);
            this.itemView.setTag(bjVar);
            this.itemView.setOnClickListener(CitySelectAdapter.this.g);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.citycopy.adapter.CitySelectAdapter$a */
    /* loaded from: classes14.dex */
    public class View$OnClickListenerC0610a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC0610a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SitesBean b;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1940627445")) {
                ipChange.ipc$dispatch("1940627445", new Object[]{this, view});
            } else if (k62.d() || CitySelectAdapter.this.a == null) {
            } else {
                Object tag = view.getTag();
                if (tag instanceof bj) {
                    bj bjVar = (bj) tag;
                    int i = bjVar.c;
                    if (i == 102) {
                        CitySelectAdapter.this.a.onRequestLocationPermission();
                    } else if (i == 136 && (b = bjVar.b()) != null) {
                        CitySelectAdapter.this.a.onLocationCityClick(b.getCityId(), b.getCityName());
                    }
                }
            }
        }
    }

    public CitySelectAdapter(Context context, List<bj> list) {
        this.b = context;
        this.c = list;
        this.d = (k62.c(context) - k62.a(context, 63.0f)) / 3;
        this.e = k62.a(this.b, 31.0f);
    }

    public void g(OnCityListItemClickListener onCityListItemClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1466517533")) {
            ipChange.ipc$dispatch("1466517533", new Object[]{this, onCityListItemClickListener});
        } else {
            this.a = onCityListItemClickListener;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1250028452") ? ((Integer) ipChange.ipc$dispatch("1250028452", new Object[]{this})).intValue() : bb2.c(this.c);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1555592267")) {
            return ((Integer) ipChange.ipc$dispatch("1555592267", new Object[]{this, Integer.valueOf(i)})).intValue();
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
        if (AndroidInstantRuntime.support(ipChange, "46447241")) {
            ipChange.ipc$dispatch("46447241", new Object[]{this, str});
        } else {
            this.f = str;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "787096277")) {
            ipChange.ipc$dispatch("787096277", new Object[]{this, viewHolder, Integer.valueOf(i)});
        } else if (viewHolder != null) {
            bj bjVar = this.c.get(i);
            int d = bjVar.d();
            if (d == 0) {
                ((LacationViewHolder) viewHolder).a(bjVar);
            } else if (d == 1) {
                ((HotViewHolder) viewHolder).a(bjVar);
            } else if (d != 2) {
            } else {
                ((GroupViewHolder) viewHolder).a(bjVar);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2072493375")) {
            return (RecyclerView.ViewHolder) ipChange.ipc$dispatch("-2072493375", new Object[]{this, viewGroup, Integer.valueOf(i)});
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
