package cn.damai.mine.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.category.category.ui.StarFragment;
import cn.damai.common.nav.DMNav;
import cn.damai.common.util.ToastUtil;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.mine.relationship.bean.RelationItemData;
import cn.damai.mine.util.RelationRequestUtil;
import com.alibaba.fastjson.JSONObject;
import com.alient.gaiax.container.gaiax.GaiaXBuilder;
import com.alient.gaiax.container.gaiax.PictureGaiaXEventProvider;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.gaiax.api.data.EventParams;
import com.youku.gaiax.common.utils.ScreenUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import tb.m61;
import tb.t60;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class RelationListAdapter extends RecyclerView.Adapter<ViewHolder> implements RelationRequestUtil.RelationRequestInter {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context a;
    private List<JSONObject> b = new ArrayList();
    private boolean c;
    private boolean d;
    private RelationRequestUtil e;
    private String f;

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public class ViewHolder extends RecyclerView.ViewHolder {
        FrameLayout a;

        public ViewHolder(RelationListAdapter relationListAdapter, View view) {
            super(view);
            this.a = (FrameLayout) view.findViewById(R$id.fl_gaiax_item);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public class a extends PictureGaiaXEventProvider {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ RelationItemData a;
        final /* synthetic */ int b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Context context, RelationItemData relationItemData, int i) {
            super(context);
            this.a = relationItemData;
            this.b = i;
        }

        @Override // com.alient.gaiax.container.gaiax.PictureGaiaXEventProvider, com.alient.gaiax.container.gaiax.PictureGaiaXDelegate
        public void onGaiaXEvent(EventParams eventParams, JSONObject jSONObject, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-125175264")) {
                ipChange.ipc$dispatch("-125175264", new Object[]{this, eventParams, jSONObject, Integer.valueOf(i)});
            } else if ("followfans_action_view".equals(eventParams.getViewId())) {
                if (RelationListAdapter.this.d) {
                    RelationListAdapter.this.e.a(RelationListAdapter.this.a, this.a.getStatus(), this.a.getObjectIdStr(), String.valueOf(this.a.getObjectType()), this.b, RelationListAdapter.this.f);
                    return;
                }
                RelationRequestUtil relationRequestUtil = RelationListAdapter.this.e;
                Context context = RelationListAdapter.this.a;
                int status = this.a.getStatus();
                String objectIdStr = this.a.getObjectIdStr();
                String valueOf = String.valueOf(this.a.getObjectType());
                int i2 = this.b;
                Objects.requireNonNull(RelationListAdapter.this.e);
                relationRequestUtil.a(context, status, objectIdStr, valueOf, i2, "fans");
            } else if (!"damai_followfans_avatar".equals(eventParams.getViewId()) || TextUtils.isEmpty(this.a.getSchema())) {
            } else {
                DMNav.from(RelationListAdapter.this.a).toUri(this.a.getSchema());
            }
        }

        @Override // com.alient.gaiax.container.gaiax.PictureGaiaXEventProvider, com.alient.gaiax.container.gaiax.PictureGaiaXDelegate
        public void onItemViewClick(View view, JSONObject jSONObject, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2041558154")) {
                ipChange.ipc$dispatch("2041558154", new Object[]{this, view, jSONObject, Integer.valueOf(i)});
            } else if (TextUtils.isEmpty(this.a.getSchema())) {
            } else {
                DMNav.from(RelationListAdapter.this.a).toUri(this.a.getSchema());
            }
        }
    }

    public RelationListAdapter(Context context, boolean z, boolean z2, String str) {
        g(context, z, z2);
        this.f = str;
    }

    private String f(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1201125341")) {
            return (String) ipChange.ipc$dispatch("1201125341", new Object[]{this, Long.valueOf(j)});
        }
        try {
            if (j < 10000) {
                return String.valueOf(j);
            }
            return (((float) (j / 1000)) / 10.0f) + "万";
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public void e(List<JSONObject> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2062600625")) {
            ipChange.ipc$dispatch("-2062600625", new Object[]{this, list});
            return;
        }
        int size = this.b.size();
        this.b.addAll(list);
        notifyItemRangeInserted(size, list.size());
    }

    @Override // cn.damai.mine.util.RelationRequestUtil.RelationRequestInter
    public void fail(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-354578969")) {
            ipChange.ipc$dispatch("-354578969", new Object[]{this, str, str2});
        } else {
            ToastUtil.i(str2);
        }
    }

    public void g(Context context, boolean z, boolean z2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2139688071")) {
            ipChange.ipc$dispatch("2139688071", new Object[]{this, context, Boolean.valueOf(z), Boolean.valueOf(z2)});
            return;
        }
        this.a = context;
        this.d = z;
        this.c = z2;
        this.e = new RelationRequestUtil(this);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1398903458") ? ((Integer) ipChange.ipc$dispatch("-1398903458", new Object[]{this})).intValue() : wh2.e(this.b);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1942727582") ? ((Long) ipChange.ipc$dispatch("-1942727582", new Object[]{this, Integer.valueOf(i)})).longValue() : i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: h */
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1044922161")) {
            ipChange.ipc$dispatch("1044922161", new Object[]{this, viewHolder, Integer.valueOf(i)});
            return;
        }
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) viewHolder.a.getLayoutParams();
        if (i == 0) {
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = t60.a(this.a, 12.0f);
        } else {
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = 0;
        }
        JSONObject jSONObject = this.b.get(i);
        RelationItemData relationItemData = (RelationItemData) m61.d(jSONObject, RelationItemData.class);
        if (relationItemData == null) {
            return;
        }
        if (this.d) {
            jSONObject.put("from", (Object) StarFragment.KEY_FOLLOW);
        } else {
            jSONObject.put("from", (Object) "fans");
        }
        jSONObject.put("fansNumStr", (Object) f(relationItemData.getFansNum()));
        jSONObject.put("isMine", (Object) (this.c ? "1" : "0"));
        GaiaXBuilder gaiaXBuilder = new GaiaXBuilder();
        FrameLayout frameLayout = viewHolder.a;
        Context context = this.a;
        gaiaXBuilder.renderGaiaXSimple(frameLayout, context, "damai_followfans_cell", jSONObject, ScreenUtils.INSTANCE.getScreenWidthPx(context) - t60.a(this.a, 24.0f), i, new a(this.a, relationItemData, i), false, false);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: i */
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2146986213") ? (ViewHolder) ipChange.ipc$dispatch("2146986213", new Object[]{this, viewGroup, Integer.valueOf(i)}) : new ViewHolder(this, LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.relation_gaiax_item_layout, viewGroup, false));
    }

    public void j(List<JSONObject> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-769213842")) {
            ipChange.ipc$dispatch("-769213842", new Object[]{this, list});
            return;
        }
        this.b.clear();
        this.b.addAll(list);
        notifyDataSetChanged();
    }

    @Override // cn.damai.mine.util.RelationRequestUtil.RelationRequestInter
    public void success(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-673426634")) {
            ipChange.ipc$dispatch("-673426634", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        this.b.get(i).put("status", (Object) Integer.valueOf(i2));
        notifyDataSetChanged();
    }

    public RelationListAdapter(Context context, boolean z, boolean z2) {
        g(context, z, z2);
    }
}
