package cn.damai.category.venue.adapter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.category.venue.bean.ProjectVo;
import cn.damai.common.user.b;
import cn.damai.common.user.c;
import cn.damai.homepage.R$drawable;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.uikit.number.DMDigitTextView;
import cn.damai.uikit.tag.DMCategroyTagView;
import cn.damai.uikit.view.RoundImageView;
import com.alimm.xadsdk.base.expose.MonitorType;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import tb.m62;
import tb.qd2;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class VenueProjectGridAdapter extends RecyclerView.Adapter<ViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context a;
    private List<ProjectVo> b;
    private String c;
    private String d;
    private String e;
    private String f;
    private int g;

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class ViewHolder extends RecyclerView.ViewHolder {
        RoundImageView a;
        DMCategroyTagView b;
        TextView c;
        TextView d;
        DMDigitTextView e;
        LinearLayout f;

        public ViewHolder(VenueProjectGridAdapter venueProjectGridAdapter, View view) {
            super(view);
            this.a = (RoundImageView) view.findViewById(R$id.venus_rank_item_image);
            this.b = (DMCategroyTagView) view.findViewById(R$id.venus_rank_item_image_tag);
            TextView textView = (TextView) view.findViewById(R$id.venus_rank_item_rank);
            this.c = (TextView) view.findViewById(R$id.venus_rank_item_title);
            this.d = (TextView) view.findViewById(R$id.venus_rank_item_time);
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R$id.venus_rank_item_price_layout);
            this.e = (DMDigitTextView) view.findViewById(R$id.venus_rank_item_price);
            TextView textView2 = (TextView) view.findViewById(R$id.venus_rank_item_price_label);
            this.f = (LinearLayout) view.findViewById(R$id.project_layout);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ ProjectVo a;
        final /* synthetic */ int b;

        a(ProjectVo projectVo, int i) {
            this.a = projectVo;
            this.b = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1078049252")) {
                ipChange.ipc$dispatch("1078049252", new Object[]{this, view});
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putBoolean(MonitorType.SKIP, true);
            bundle.putString("from_page", "venue");
            bundle.putString("id", this.a.projectId);
            qd2.a(VenueProjectGridAdapter.this.a, this.a.schema, bundle);
            HashMap hashMap = new HashMap();
            hashMap.put("city", VenueProjectGridAdapter.this.f);
            hashMap.put("titlelabel", VenueProjectGridAdapter.this.d);
            hashMap.put("contentlabel", this.a.projectName);
            hashMap.put("venue_id", VenueProjectGridAdapter.this.c);
            hashMap.put("item_id", this.a.projectId);
            if (VenueProjectGridAdapter.this.g == 1) {
                c.e().x(new b().e("venue", "venue_card_" + VenueProjectGridAdapter.this.e, "item_" + this.b, hashMap, Boolean.TRUE));
                return;
            }
            c.e().x(new b().e("venue", "nearby_venue_card_" + VenueProjectGridAdapter.this.e, "item_" + this.b, hashMap, Boolean.TRUE));
        }
    }

    public VenueProjectGridAdapter(Context context, List<ProjectVo> list, String str, String str2, String str3, String str4, int i) {
        this.b = new ArrayList();
        this.g = 1;
        this.b = list;
        this.a = context;
        this.c = str;
        this.d = str2;
        this.e = str3;
        this.f = str4;
        this.g = i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: g */
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "825413319")) {
            ipChange.ipc$dispatch("825413319", new Object[]{this, viewHolder, Integer.valueOf(i)});
            return;
        }
        ProjectVo projectVo = this.b.get(i);
        viewHolder.c.setText(projectVo.projectName);
        DMDigitTextView dMDigitTextView = viewHolder.e;
        dMDigitTextView.setText(String.valueOf("¥" + projectVo.priceLow));
        cn.damai.common.image.a.b().f(projectVo.projectPic, m62.a(this.a, 111.0f), m62.a(this.a, 148.0f)).c(R$drawable.uikit_default_image_bg_grey).g(viewHolder.a);
        viewHolder.f.setOnClickListener(new a(projectVo, i));
        String str = projectVo.categoryName;
        if (str != null && !str.isEmpty()) {
            viewHolder.b.setTagName(projectVo.categoryName);
            viewHolder.b.setVisibility(0);
        } else {
            viewHolder.b.setVisibility(8);
        }
        viewHolder.d.setText(projectVo.projectDatetime);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-653278317") ? ((Integer) ipChange.ipc$dispatch("-653278317", new Object[]{this})).intValue() : wh2.e(this.b);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-33573929") ? ((Long) ipChange.ipc$dispatch("-33573929", new Object[]{this, Integer.valueOf(i)})).longValue() : i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: h */
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2033964943") ? (ViewHolder) ipChange.ipc$dispatch("2033964943", new Object[]{this, viewGroup, Integer.valueOf(i)}) : new ViewHolder(this, LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.category_venue_project_item, viewGroup, false));
    }
}
