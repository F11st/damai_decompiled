package cn.damai.category.venue.adapter;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.category.venue.bean.VenueListBean;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.user.b;
import cn.damai.common.user.c;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import cn.damai.user.userprofile.FeedsViewModel;
import com.alibaba.aliweex.adapter.module.location.ILocatable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import tb.cs;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class VenueItemAdapter extends RecyclerView.Adapter<VenueItemViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context a;
    private String c;
    private String d;
    private List<VenueListBean> b = new ArrayList();
    private int e = 1;

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class VenueItemViewHolder extends RecyclerView.ViewHolder {
        private RecyclerView a;
        private TextView b;
        private TextView c;
        private TextView d;
        private TextView e;
        private LinearLayout f;
        private TextView g;
        private DMIconFontTextView h;

        public VenueItemViewHolder(VenueItemAdapter venueItemAdapter, View view) {
            super(view);
            this.a = (RecyclerView) view.findViewById(R$id.venues_pro_recyclerview);
            this.b = (TextView) view.findViewById(R$id.venue_num_tv);
            this.c = (TextView) view.findViewById(R$id.venue_name_tv);
            this.d = (TextView) view.findViewById(R$id.site_address_miles_tv);
            this.e = (TextView) view.findViewById(R$id.venue_distance_tv);
            this.f = (LinearLayout) view.findViewById(R$id.venue_header_layout);
            this.g = (TextView) view.findViewById(R$id.rec_tage);
            DMIconFontTextView dMIconFontTextView = (DMIconFontTextView) view.findViewById(R$id.more_arrow_first);
            this.h = (DMIconFontTextView) view.findViewById(R$id.more_arrow_second);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ int a;

        a(int i) {
            this.a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "481283415")) {
                ipChange.ipc$dispatch("481283415", new Object[]{this, view});
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString(ILocatable.ADDRESS, ((VenueListBean) VenueItemAdapter.this.b.get(this.a)).address);
            bundle.putString(FeedsViewModel.ARG_USERID, ((VenueListBean) VenueItemAdapter.this.b.get(this.a)).id);
            bundle.putString("usertype", "3");
            DMNav.from(VenueItemAdapter.this.a).withExtras(bundle).toUri(NavUri.b(cs.ARTISTID_THEME));
            HashMap hashMap = new HashMap();
            hashMap.put("city", VenueItemAdapter.this.d);
            hashMap.put("titlelabel", ((VenueListBean) VenueItemAdapter.this.b.get(this.a)).name);
            hashMap.put("venue_id", String.valueOf(((VenueListBean) VenueItemAdapter.this.b.get(this.a)).id));
            if (VenueItemAdapter.this.e == 1) {
                b bVar = new b();
                c.e().x(bVar.e("venue", "venue_card_" + this.a, "venue", hashMap, Boolean.TRUE));
                return;
            }
            b bVar2 = new b();
            c.e().x(bVar2.e("venue", "nearby_venue_card_" + this.a, "venue", hashMap, Boolean.TRUE));
        }
    }

    public VenueItemAdapter(Context context) {
        this.a = context;
    }

    public void e(List<VenueListBean> list, String str, String str2, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1028965714")) {
            ipChange.ipc$dispatch("1028965714", new Object[]{this, list, str, str2, Integer.valueOf(i)});
            return;
        }
        this.d = str2;
        this.c = str;
        this.b.addAll(list);
        this.e = i;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: f */
    public void onBindViewHolder(final VenueItemViewHolder venueItemViewHolder, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1754919451")) {
            ipChange.ipc$dispatch("1754919451", new Object[]{this, venueItemViewHolder, Integer.valueOf(i)});
            return;
        }
        VenueProjectGridAdapter venueProjectGridAdapter = new VenueProjectGridAdapter(this.a, this.b.get(i).projectVos, this.b.get(i).id, this.b.get(i).name, String.valueOf(i), this.d, this.e);
        if (TextUtils.isEmpty(this.c)) {
            venueItemViewHolder.g.setVisibility(8);
        } else if (i == 0) {
            venueItemViewHolder.g.setVisibility(0);
        } else {
            venueItemViewHolder.g.setVisibility(8);
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.a);
        linearLayoutManager.setOrientation(0);
        venueItemViewHolder.a.setLayoutManager(linearLayoutManager);
        venueItemViewHolder.a.setAdapter(venueProjectGridAdapter);
        venueItemViewHolder.c.setText(this.b.get(i).name);
        venueItemViewHolder.b.setText(String.valueOf(this.b.get(i).itemOnSaleSize));
        venueItemViewHolder.d.setText(this.b.get(i).address);
        venueItemViewHolder.e.setText(this.b.get(i).distance);
        venueItemViewHolder.c.post(new Runnable() { // from class: cn.damai.category.venue.adapter.VenueItemAdapter.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // java.lang.Runnable
            public void run() {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1362574106")) {
                    ipChange2.ipc$dispatch("1362574106", new Object[]{this});
                } else if (venueItemViewHolder.c == null || venueItemViewHolder.c.getLayout() == null) {
                } else {
                    if (venueItemViewHolder.c.getLayout().getEllipsisCount(venueItemViewHolder.c.getLineCount() - 1) > 0) {
                        venueItemViewHolder.h.setVisibility(0);
                    } else {
                        venueItemViewHolder.h.setVisibility(8);
                    }
                }
            }
        });
        venueItemViewHolder.f.setOnClickListener(new a(i));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: g */
    public VenueItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "507575739") ? (VenueItemViewHolder) ipChange.ipc$dispatch("507575739", new Object[]{this, viewGroup, Integer.valueOf(i)}) : new VenueItemViewHolder(this, LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.category_venue_item, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "475479813") ? ((Integer) ipChange.ipc$dispatch("475479813", new Object[]{this})).intValue() : wh2.e(this.b);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-814521399") ? ((Long) ipChange.ipc$dispatch("-814521399", new Object[]{this, Integer.valueOf(i)})).longValue() : i;
    }

    public void h(List<VenueListBean> list, String str, String str2, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1756018520")) {
            ipChange.ipc$dispatch("1756018520", new Object[]{this, list, str, str2, Integer.valueOf(i)});
            return;
        }
        this.d = str2;
        this.c = str;
        this.e = i;
        if (wh2.e(list) > 0) {
            List<VenueListBean> list2 = this.b;
            if (list2 != null) {
                list2.clear();
            }
            e(list, str, str2, i);
        }
    }
}
