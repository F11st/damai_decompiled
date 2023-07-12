package cn.damai.category.category.ui.adapter;

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
import cn.damai.commonbusiness.city.model.HotCityBean;
import cn.damai.commonbusiness.city.model.SitesBean;
import cn.damai.uikit.flowlayout.FlowLayout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.cj;
import tb.e80;
import tb.t60;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class CitySelectAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange;
    private OnCityListItemClickListener2 a;
    private Context b;
    private List<cj> c;
    private int d;
    private int e;
    private String f;
    private View.OnClickListener g = new a();

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class GroupViewHolder extends RecyclerView.ViewHolder {
        private static transient /* synthetic */ IpChange $ipChange;
        private RecyclerView a;
        private GroupCityAdapter b;

        /* compiled from: Taobao */
        /* loaded from: classes.dex */
        public class a implements OnCityListItemClickListener2 {
            private static transient /* synthetic */ IpChange $ipChange;

            a(CitySelectAdapter citySelectAdapter) {
            }

            @Override // cn.damai.category.category.ui.adapter.CitySelectAdapter.OnCityListItemClickListener2
            public void onGroupCityClick(int i, String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1101389238")) {
                    ipChange.ipc$dispatch("1101389238", new Object[]{this, Integer.valueOf(i), str, str2});
                    return;
                }
                CitySelectAdapter.this.f = null;
                GroupViewHolder.this.b.notifyDataSetChanged();
                CitySelectAdapter.this.a.onGroupCityClick(i, str, str2);
            }

            @Override // cn.damai.category.category.ui.adapter.CitySelectAdapter.OnCityListItemClickListener2
            public void onHotCityClick(int i, String str, String str2, String str3) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-2025563406")) {
                    ipChange.ipc$dispatch("-2025563406", new Object[]{this, Integer.valueOf(i), str, str2, str3});
                }
            }

            @Override // cn.damai.category.category.ui.adapter.CitySelectAdapter.OnCityListItemClickListener2
            public void onLocationCityClick(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1667680969")) {
                    ipChange.ipc$dispatch("-1667680969", new Object[]{this, str, str2});
                }
            }

            @Override // cn.damai.category.category.ui.adapter.CitySelectAdapter.OnCityListItemClickListener2
            public void onRequestLocationPermission() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "854643224")) {
                    ipChange.ipc$dispatch("854643224", new Object[]{this});
                }
            }
        }

        public GroupViewHolder() {
            super(LayoutInflater.from(CitySelectAdapter.this.b).inflate(R$layout.layout_select_city_group_list, (ViewGroup) null));
            this.a = (RecyclerView) this.itemView.findViewById(R$id.group_city_list);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(CitySelectAdapter.this.b);
            linearLayoutManager.setOrientation(1);
            this.a.setLayoutManager(linearLayoutManager);
            GroupCityAdapter groupCityAdapter = new GroupCityAdapter(CitySelectAdapter.this.b);
            this.b = groupCityAdapter;
            groupCityAdapter.f(new a(CitySelectAdapter.this));
            this.a.setAdapter(this.b);
            this.itemView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        }

        public void b(cj cjVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1287734808")) {
                ipChange.ipc$dispatch("1287734808", new Object[]{this, cjVar});
                return;
            }
            this.b.setData(cjVar.c());
            this.b.notifyDataSetChanged();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class HotViewHolder extends RecyclerView.ViewHolder {
        private static transient /* synthetic */ IpChange $ipChange;
        private FlowLayout a;

        /* compiled from: Taobao */
        /* loaded from: classes.dex */
        public class a implements View.OnClickListener {
            private static transient /* synthetic */ IpChange $ipChange;
            final /* synthetic */ HotCityBean a;
            final /* synthetic */ int b;

            a(HotCityBean hotCityBean, int i) {
                this.a = hotCityBean;
                this.b = i;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "80331517")) {
                    ipChange.ipc$dispatch("80331517", new Object[]{this, view});
                    return;
                }
                CitySelectAdapter.this.f = this.a.getCityName();
                CitySelectAdapter.this.a.onHotCityClick(this.b, this.a.getCityName(), this.a.getCityId(), this.a.getUrl());
            }
        }

        public HotViewHolder() {
            super(LayoutInflater.from(CitySelectAdapter.this.b).inflate(R$layout.layout_select_city_hot_list, (ViewGroup) null));
            this.a = (FlowLayout) this.itemView.findViewById(R$id.hot_city_list);
            this.itemView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        }

        public void a(cj cjVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "871292902")) {
                ipChange.ipc$dispatch("871292902", new Object[]{this, cjVar});
                return;
            }
            List<HotCityBean> a2 = cjVar.a();
            int e = wh2.e(a2);
            this.a.removeAllViews();
            if (e > 0) {
                for (int i = 0; i < e; i++) {
                    HotCityBean hotCityBean = a2.get(i);
                    if (hotCityBean != null) {
                        View inflate = LayoutInflater.from(CitySelectAdapter.this.b).inflate(R$layout.layout_select_city_hot_list_item, (ViewGroup) null);
                        TextView textView = (TextView) inflate.findViewById(R$id.select_city_hot_list_item);
                        ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
                        layoutParams.width = CitySelectAdapter.this.d;
                        layoutParams.height = CitySelectAdapter.this.e;
                        textView.setLayoutParams(layoutParams);
                        if (!TextUtils.isEmpty(CitySelectAdapter.this.f) && CitySelectAdapter.this.f.equals(hotCityBean.getCityName())) {
                            textView.setBackgroundResource(R$drawable.city_select_hot_city_border_select);
                            textView.setTextColor(Color.parseColor("#FF2D79"));
                        } else {
                            textView.setBackgroundResource(R$drawable.city_select_hot_city_border_normal);
                            textView.setTextColor(Color.parseColor("#333333"));
                        }
                        textView.setText(hotCityBean.getCityName());
                        inflate.setOnClickListener(new a(hotCityBean, i));
                        this.a.addView(inflate);
                    }
                }
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class LacationViewHolder extends RecyclerView.ViewHolder {
        private static transient /* synthetic */ IpChange $ipChange;
        private TextView a;

        public LacationViewHolder() {
            super(LayoutInflater.from(CitySelectAdapter.this.b).inflate(cn.damai.homepage.R$layout.layout_select_city_location, (ViewGroup) null));
            TextView textView = (TextView) this.itemView.findViewById(cn.damai.homepage.R$id.select_city_hot_list_item);
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
            if (AndroidInstantRuntime.support(ipChange, "-492797936")) {
                ipChange.ipc$dispatch("-492797936", new Object[]{this, cjVar});
                return;
            }
            SitesBean b = cjVar.b();
            int i = cjVar.c;
            if (i == 102) {
                str = "定位获取失败，请点击重试";
            } else if (i != 119) {
                str = (i == 136 && b != null) ? b.getCityName() : "定位异常，请退出页面重试";
            } else {
                str = "定位中...";
            }
            this.a.setText(str);
            this.itemView.setTag(cjVar);
            this.itemView.setOnClickListener(CitySelectAdapter.this.g);
            if (!TextUtils.isEmpty(CitySelectAdapter.this.f) && TextUtils.equals(str, CitySelectAdapter.this.f)) {
                this.a.setBackgroundResource(R$drawable.city_select_hot_city_border_select);
                this.a.setTextColor(Color.parseColor("#FF2D79"));
                return;
            }
            this.a.setBackgroundResource(R$drawable.city_select_hot_city_border_normal);
            this.a.setTextColor(Color.parseColor("#333333"));
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public interface OnCityListItemClickListener2 {
        void onGroupCityClick(int i, String str, String str2);

        void onHotCityClick(int i, String str, String str2, String str3);

        void onLocationCityClick(String str, String str2);

        void onRequestLocationPermission();
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SitesBean b;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1342883683")) {
                ipChange.ipc$dispatch("1342883683", new Object[]{this, view});
                return;
            }
            Object tag = view.getTag();
            if (tag instanceof cj) {
                cj cjVar = (cj) tag;
                int i = cjVar.c;
                if (i == 102) {
                    CitySelectAdapter.this.a.onRequestLocationPermission();
                } else if (i == 136 && (b = cjVar.b()) != null) {
                    CitySelectAdapter.this.f = b.getCityName();
                    CitySelectAdapter.this.a.onLocationCityClick(b.getCityId(), b.getCityName());
                }
            }
        }
    }

    public CitySelectAdapter(Context context, List<cj> list) {
        this.b = context;
        this.c = list;
        int d = (e80.d() - t60.a(context, 63.0f)) / 3;
        this.d = d;
        this.e = (d * 31) / 104;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2016825582") ? ((Integer) ipChange.ipc$dispatch("-2016825582", new Object[]{this})).intValue() : wh2.e(this.c);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1618268345")) {
            return ((Integer) ipChange.ipc$dispatch("1618268345", new Object[]{this, Integer.valueOf(i)})).intValue();
        }
        try {
            return this.c.get(i).d();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public void h(OnCityListItemClickListener2 onCityListItemClickListener2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-562858508")) {
            ipChange.ipc$dispatch("-562858508", new Object[]{this, onCityListItemClickListener2});
        } else {
            this.a = onCityListItemClickListener2;
        }
    }

    public void i(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1042086747")) {
            ipChange.ipc$dispatch("1042086747", new Object[]{this, str});
            return;
        }
        this.f = str;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1295129945")) {
            ipChange.ipc$dispatch("-1295129945", new Object[]{this, viewHolder, Integer.valueOf(i)});
        } else if (viewHolder != null) {
            cj cjVar = this.c.get(i);
            int d = cjVar.d();
            if (d == 0) {
                ((LacationViewHolder) viewHolder).a(cjVar);
            } else if (d == 1) {
                ((HotViewHolder) viewHolder).a(cjVar);
            } else if (d != 2) {
            } else {
                ((GroupViewHolder) viewHolder).b(cjVar);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1086352593")) {
            return (RecyclerView.ViewHolder) ipChange.ipc$dispatch("-1086352593", new Object[]{this, viewGroup, Integer.valueOf(i)});
        }
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    return null;
                }
                return new GroupViewHolder();
            }
            return new HotViewHolder();
        }
        return new LacationViewHolder();
    }
}
