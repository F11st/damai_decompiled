package cn.damai.mine.wantpraise;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.nav.DMNav;
import cn.damai.common.util.ToastUtil;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.mine.util.RelationRequestUtil;
import cn.damai.mine.wantpraise.net.WantSeePraiseD;
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
public class WantListAdapter extends RecyclerView.Adapter<ViewHolder> implements RelationRequestUtil.RelationRequestInter {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context a;
    private List<JSONObject> b = new ArrayList();
    private RelationRequestUtil c = new RelationRequestUtil(this);

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public class ViewHolder extends RecyclerView.ViewHolder {
        FrameLayout a;

        public ViewHolder(WantListAdapter wantListAdapter, View view) {
            super(view);
            this.a = (FrameLayout) view.findViewById(R$id.fl_gaiax_item);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public class a extends PictureGaiaXEventProvider {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ WantSeePraiseD a;
        final /* synthetic */ int b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Context context, WantSeePraiseD wantSeePraiseD, int i) {
            super(context);
            this.a = wantSeePraiseD;
            this.b = i;
        }

        @Override // com.alient.gaiax.container.gaiax.PictureGaiaXEventProvider, com.alient.gaiax.container.gaiax.PictureGaiaXDelegate
        public void onGaiaXEvent(EventParams eventParams, JSONObject jSONObject, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1400722237")) {
                ipChange.ipc$dispatch("-1400722237", new Object[]{this, eventParams, jSONObject, Integer.valueOf(i)});
            } else if ("followfans_action_view".equals(eventParams.getViewId())) {
                RelationRequestUtil relationRequestUtil = WantListAdapter.this.c;
                Context context = WantListAdapter.this.a;
                WantSeePraiseD wantSeePraiseD = this.a;
                int i2 = wantSeePraiseD.status;
                String str = wantSeePraiseD.havanaIdStr;
                String str2 = wantSeePraiseD.objectType;
                int i3 = this.b;
                Objects.requireNonNull(WantListAdapter.this.c);
                relationRequestUtil.a(context, i2, str, str2, i3, "wantsee");
            } else if (("damai_wantsee_avatar".equals(eventParams.getViewId()) || "name_title".equals(eventParams.getViewId())) && !TextUtils.isEmpty(this.a.userCenterSchema)) {
                DMNav.from(WantListAdapter.this.a).toUri(this.a.userCenterSchema);
            }
        }

        @Override // com.alient.gaiax.container.gaiax.PictureGaiaXEventProvider, com.alient.gaiax.container.gaiax.PictureGaiaXDelegate
        public void onItemViewClick(View view, JSONObject jSONObject, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1831865645")) {
                ipChange.ipc$dispatch("1831865645", new Object[]{this, view, jSONObject, Integer.valueOf(i)});
            } else if (TextUtils.isEmpty(this.a.schema)) {
            } else {
                DMNav.from(WantListAdapter.this.a).toUri(this.a.schema);
            }
        }
    }

    public WantListAdapter(Context context, boolean z) {
        this.a = context;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: c */
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1047757151")) {
            ipChange.ipc$dispatch("1047757151", new Object[]{this, viewHolder, Integer.valueOf(i)});
            return;
        }
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) viewHolder.a.getLayoutParams();
        if (i == 0) {
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = t60.a(this.a, 12.0f);
        } else {
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = 0;
        }
        JSONObject jSONObject = this.b.get(i);
        WantSeePraiseD wantSeePraiseD = (WantSeePraiseD) m61.d(jSONObject, WantSeePraiseD.class);
        if (wantSeePraiseD == null) {
            return;
        }
        GaiaXBuilder gaiaXBuilder = new GaiaXBuilder();
        FrameLayout frameLayout = viewHolder.a;
        Context context = this.a;
        gaiaXBuilder.renderGaiaXSimple(frameLayout, context, "damai_wantsee_cell", jSONObject, ScreenUtils.INSTANCE.getScreenWidthPx(context) - t60.a(this.a, 24.0f), i, new a(this.a, wantSeePraiseD, i), false, false);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: d */
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "693863991") ? (ViewHolder) ipChange.ipc$dispatch("693863991", new Object[]{this, viewGroup, Integer.valueOf(i)}) : new ViewHolder(this, LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.relation_gaiax_item_layout, viewGroup, false));
    }

    public void e(List<JSONObject> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2145536213")) {
            ipChange.ipc$dispatch("-2145536213", new Object[]{this, list});
            return;
        }
        this.b.clear();
        this.b.addAll(list);
        notifyDataSetChanged();
    }

    @Override // cn.damai.mine.util.RelationRequestUtil.RelationRequestInter
    public void fail(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "926586314")) {
            ipChange.ipc$dispatch("926586314", new Object[]{this, str, str2});
        } else {
            ToastUtil.i(str2);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1817778113") ? ((Integer) ipChange.ipc$dispatch("1817778113", new Object[]{this})).intValue() : wh2.e(this.b);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1917598597") ? ((Long) ipChange.ipc$dispatch("1917598597", new Object[]{this, Integer.valueOf(i)})).longValue() : i;
    }

    @Override // cn.damai.mine.util.RelationRequestUtil.RelationRequestInter
    public void success(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1667857331")) {
            ipChange.ipc$dispatch("1667857331", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        this.b.get(i).put("status", (Object) Integer.valueOf(i2));
        notifyDataSetChanged();
    }
}
