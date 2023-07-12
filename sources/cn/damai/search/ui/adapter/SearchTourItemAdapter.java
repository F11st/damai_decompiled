package cn.damai.search.ui.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.commonbusiness.search.bean.SearchTourItem;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.search.bean.SearchTourUT;
import cn.damai.search.helper.SearchHelper;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.wh2;
import tb.xr;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class SearchTourItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<SearchTourItem> a = new ArrayList();
    private Context b;
    private boolean c;

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public class tourItemViewHolder extends RecyclerView.ViewHolder {
        private static transient /* synthetic */ IpChange $ipChange;
        private TextView a;
        private TextView b;
        private LinearLayout c;
        private ImageView d;

        /* compiled from: Taobao */
        /* renamed from: cn.damai.search.ui.adapter.SearchTourItemAdapter$tourItemViewHolder$a */
        /* loaded from: classes15.dex */
        public class View$OnClickListenerC1611a implements View.OnClickListener {
            private static transient /* synthetic */ IpChange $ipChange;
            final /* synthetic */ SearchTourItem a;
            final /* synthetic */ int b;

            View$OnClickListenerC1611a(tourItemViewHolder touritemviewholder, SearchTourItem searchTourItem, int i) {
                this.a = searchTourItem;
                this.b = i;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1384908398")) {
                    ipChange.ipc$dispatch("1384908398", new Object[]{this, view});
                    return;
                }
                String str = this.a.itemId;
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                SearchTourUT searchTourUT = new SearchTourUT();
                searchTourUT.projectId = str;
                searchTourUT.name = "";
                searchTourUT.verticalPic = "";
                searchTourUT.index = this.b + 1;
                searchTourUT.schema = this.a.getSchema();
                xr.c(SearchHelper.TOUR_JUMP_PROJECT_PAGE, searchTourUT);
            }
        }

        public tourItemViewHolder(SearchTourItemAdapter searchTourItemAdapter, LayoutInflater layoutInflater) {
            super(layoutInflater.inflate(R$layout.search_tour_city_item, (ViewGroup) null));
            this.itemView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            this.d = (ImageView) this.itemView.findViewById(R$id.current_city_logo);
            this.a = (TextView) this.itemView.findViewById(R$id.tv_city);
            this.b = (TextView) this.itemView.findViewById(R$id.tv_time);
            this.c = (LinearLayout) this.itemView.findViewById(R$id.ll_city_tour);
        }

        public void a(SearchTourItem searchTourItem, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-662898462")) {
                ipChange.ipc$dispatch("-662898462", new Object[]{this, searchTourItem, Integer.valueOf(i)});
                return;
            }
            this.a.setText(searchTourItem.city);
            if (searchTourItem.city.equals(z20.d())) {
                this.d.setVisibility(0);
            } else {
                this.d.setVisibility(8);
            }
            if (!searchTourItem.isLiveProject()) {
                this.b.setText(searchTourItem.showTime);
            } else {
                this.b.setText(searchTourItem.liveStartTime);
            }
            this.c.setOnClickListener(new View$OnClickListenerC1611a(this, searchTourItem, i));
        }
    }

    public SearchTourItemAdapter(Context context) {
        this.b = context;
    }

    public void a(List<SearchTourItem> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "139053293")) {
            ipChange.ipc$dispatch("139053293", new Object[]{this, list});
            return;
        }
        if (list == null) {
            list = new ArrayList<>();
        }
        if (wh2.e(list) <= 0) {
            return;
        }
        this.a.clear();
        this.a.addAll(list);
    }

    public void b(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "173653017")) {
            ipChange.ipc$dispatch("173653017", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.c = z;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "455065327")) {
            return ((Integer) ipChange.ipc$dispatch("455065327", new Object[]{this})).intValue();
        }
        if (this.c) {
            return wh2.e(this.a);
        }
        int e = wh2.e(this.a);
        if (e <= 6) {
            return e;
        }
        return 6;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-68614998")) {
            ipChange.ipc$dispatch("-68614998", new Object[]{this, viewHolder, Integer.valueOf(i)});
        } else {
            ((tourItemViewHolder) viewHolder).a(this.a.get(i), i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1025157772") ? (RecyclerView.ViewHolder) ipChange.ipc$dispatch("1025157772", new Object[]{this, viewGroup, Integer.valueOf(i)}) : new tourItemViewHolder(this, LayoutInflater.from(this.b));
    }
}
