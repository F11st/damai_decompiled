package cn.damai.evaluate.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.comment.R$id;
import cn.damai.comment.R$layout;
import cn.damai.common.nav.DMNav;
import cn.damai.common.user.C0529c;
import cn.damai.evaluate.ui.EvaluateSuccessActivity;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.gaiax.GaiaX;
import com.youku.gaiax.api.data.EventParams;
import com.youku.gaiax.common.utils.ScreenUtils;
import java.util.ArrayList;
import java.util.List;
import tb.dl;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class EvaluateSuccessAdapter extends RecyclerView.Adapter<ViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context b;
    private List<JSONObject> a = new ArrayList();
    private String c = this.c;
    private String c = this.c;

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public class ViewHolder extends RecyclerView.ViewHolder {
        FrameLayout a;

        public ViewHolder(EvaluateSuccessAdapter evaluateSuccessAdapter, View view) {
            super(view);
            this.a = (FrameLayout) view.findViewById(R$id.fl_gaiax_item);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.evaluate.adapter.EvaluateSuccessAdapter$a */
    /* loaded from: classes5.dex */
    public class C1076a implements GaiaX.IEventDelegate {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ JSONObject a;
        final /* synthetic */ int b;

        C1076a(JSONObject jSONObject, int i) {
            this.a = jSONObject;
            this.b = i;
        }

        @Override // com.youku.gaiax.GaiaX.IEventDelegate
        public void onEvent(EventParams eventParams) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "785911343")) {
                ipChange.ipc$dispatch("785911343", new Object[]{this, eventParams});
                return;
            }
            DMNav from = DMNav.from(EvaluateSuccessAdapter.this.b);
            from.toUri("damai://V1/ScriptDetail?scriptId=" + this.a.get("id"));
            ((EvaluateSuccessActivity) EvaluateSuccessAdapter.this.b).finish();
            C0529c.e().x(dl.I().N(EvaluateSuccessAdapter.this.c, this.b, this.a.get("id").toString()));
        }
    }

    public EvaluateSuccessAdapter(Context context) {
        this.b = context;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: c */
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1464241855")) {
            ipChange.ipc$dispatch("1464241855", new Object[]{this, viewHolder, Integer.valueOf(i)});
            return;
        }
        JSONObject jSONObject = this.a.get(i);
        GaiaX.Params build = new GaiaX.Params.Builder().templateBiz("damai").templateId("damai_script_play_cell_go_see").container(viewHolder.a).data(jSONObject).width(ScreenUtils.INSTANCE.getScreenWidthPx(this.b)).build();
        build.setEventDelegate(new C1076a(jSONObject, i));
        GaiaX.Companion.getInstance().bindView(build);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: d */
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1820536919") ? (ViewHolder) ipChange.ipc$dispatch("1820536919", new Object[]{this, viewGroup, Integer.valueOf(i)}) : new ViewHolder(this, LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.evaluate_success_script_item_layout, viewGroup, false));
    }

    public void e(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1527179920")) {
            ipChange.ipc$dispatch("-1527179920", new Object[]{this, str});
        } else {
            this.c = str;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1987983582") ? ((Integer) ipChange.ipc$dispatch("-1987983582", new Object[]{this})).intValue() : this.a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "988499750") ? ((Long) ipChange.ipc$dispatch("988499750", new Object[]{this, Integer.valueOf(i)})).longValue() : this.a.get(i).getLong("id").longValue();
    }

    public void setData(List<JSONObject> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-204829894")) {
            ipChange.ipc$dispatch("-204829894", new Object[]{this, list});
            return;
        }
        this.a = list;
        notifyDataSetChanged();
    }
}
