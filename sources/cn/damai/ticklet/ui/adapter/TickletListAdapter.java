package cn.damai.ticklet.ui.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.comment.bean.EvaluateParams;
import cn.damai.comment.util.CommentItemMoreUtil;
import cn.damai.common.AppConfig;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.member.R$color;
import cn.damai.member.R$drawable;
import cn.damai.member.R$id;
import cn.damai.member.R$layout;
import cn.damai.onearch.errpage.bean.ErrControlViewInfo;
import cn.damai.ticklet.bean.PerformOpModule;
import cn.damai.ticklet.bean.PerformTable;
import cn.damai.ticklet.ui.fragment.TickletListFragment;
import cn.damai.uikit.flowlayout.FlowLayout;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import cn.damai.uikit.number.DMDigitTextView;
import com.airbnb.lottie.LottieAnimationView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.uikit.extend.feature.view.TUrlImageView;
import com.taobao.weex.annotation.JSMethod;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tb.cb1;
import tb.py2;
import tb.t60;
import tb.un2;
import tb.x30;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class TickletListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String HISTORY_LIST = "history";
    public static final int TEANSFER_PAGE_LIST_REQUEST_CODE = 100;
    public static final int TYPE_PERFORM_ITEM = 0;
    public static final int TYPE_PERFORM_ITEM_SEP = 1;
    private Context a;
    private TickletListFragment c;
    private String d = "TickletListAdapter";
    String e = null;
    private List<PerformTable> b = new ArrayList();

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public class a implements View.OnAttachStateChangeListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ RecyclerView.ViewHolder a;

        a(TickletListAdapter tickletListAdapter, RecyclerView.ViewHolder viewHolder) {
            this.a = viewHolder;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-777123423")) {
                ipChange.ipc$dispatch("-777123423", new Object[]{this, view});
                return;
            }
            RecyclerView.ViewHolder viewHolder = this.a;
            if ((viewHolder instanceof e) && ((e) viewHolder).h != null && ((e) viewHolder).h.getVisibility() == 0) {
                ((e) this.a).h.playAnimation();
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "632203742")) {
                ipChange.ipc$dispatch("632203742", new Object[]{this, view});
                return;
            }
            RecyclerView.ViewHolder viewHolder = this.a;
            if ((viewHolder instanceof e) && ((e) viewHolder).h != null && ((e) viewHolder).h.getVisibility() == 0) {
                ((e) this.a).h.pauseAnimation();
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ PerformTable a;
        final /* synthetic */ int b;

        b(PerformTable performTable, int i) {
            this.a = performTable;
            this.b = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2048406474")) {
                ipChange.ipc$dispatch("-2048406474", new Object[]{this, view});
            } else if (py2.p()) {
            } else {
                HashMap hashMap = new HashMap();
                hashMap.put("item_id", this.a.getProjectId());
                hashMap.put("screening_id", this.a.getPerformId());
                hashMap.put("type", TickletListAdapter.this.m(this.a));
                hashMap.put("status", this.a.isHistoryTicket() ? "是" : "否");
                if (TickletListAdapter.this.f() != null) {
                    if (this.a.isHistoryTicket()) {
                        TickletListAdapter.this.f().gotoDetailPage("history", this.b, hashMap, this.a.getPerformId(), this.a.productSystemId);
                    } else {
                        TickletListAdapter.this.f().gotoDetailPage("", this.b, hashMap, this.a.getPerformId(), this.a.productSystemId);
                    }
                }
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ PerformOpModule a;
        final /* synthetic */ int b;
        final /* synthetic */ Map c;
        final /* synthetic */ PerformTable d;

        c(PerformOpModule performOpModule, int i, Map map, PerformTable performTable) {
            this.a = performOpModule;
            this.b = i;
            this.c = map;
            this.d = performTable;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "62883895")) {
                ipChange.ipc$dispatch("62883895", new Object[]{this, view});
            } else if ("4".equals(this.a.performOpType)) {
                cn.damai.common.user.c e = cn.damai.common.user.c.e();
                cn.damai.common.user.b bVar = cn.damai.common.user.b.getInstance();
                e.x(bVar.e(un2.TICKLET_LIST_PAGE, "list", "souvenir_ticket_" + this.b, this.c, Boolean.TRUE));
                py2 f = py2.f();
                Context context = TickletListAdapter.this.a;
                PerformTable performTable = this.d;
                f.m(context, performTable.performId, performTable.productSystemId, performTable.isLivePerform() && this.d.isMaiLive(), this.d.getProjectImage(), this.d.getProjectId(), this.d.getProjectName(), x30.h(Long.valueOf(this.d.startTimeByLong), "yyyy.MM.dd | HH:mm"), this.d.liveH5Url, "", true);
            } else if ("3".equals(this.a.performOpType)) {
                cn.damai.common.user.c e2 = cn.damai.common.user.c.e();
                cn.damai.common.user.b bVar2 = cn.damai.common.user.b.getInstance();
                e2.x(bVar2.e(un2.TICKLET_LIST_PAGE, "list", "transfer_ticket_" + this.b, this.c, Boolean.TRUE));
                PerformTable performTable2 = this.d;
                py2.f().j((DamaiBaseActivity) TickletListAdapter.this.a, performTable2.performId, performTable2.productSystemId, 100);
            } else if ("1".equals(this.a.performOpType)) {
                cn.damai.common.user.c.e().x(un2.k().x(this.b, this.d.getItemId(), this.d.getPerformId()));
                TickletListAdapter tickletListAdapter = TickletListAdapter.this;
                PerformTable performTable3 = this.d;
                tickletListAdapter.g(performTable3, performTable3.getItemId());
            } else if ("2".equals(this.a.performOpType)) {
                cn.damai.common.user.c.e().x(un2.k().v(this.b, this.d.getItemId(), this.d.getPerformId()));
                Bundle bundle = new Bundle();
                bundle.putString("projectId", this.d.getItemId());
                bundle.putBoolean(EvaluateParams.OPEN_QUERY_STORE_INFO, true);
                DMNav.from(TickletListAdapter.this.a).withExtras(bundle).toUri(NavUri.b("evaluate_list"));
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    class d extends RecyclerView.ViewHolder {
        View a;

        public d(TickletListAdapter tickletListAdapter, View view) {
            super(view);
            this.a = view;
            TextView textView = (TextView) view.findViewById(R$id.ticklet_perform_history_sep_tip_text);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public class e extends RecyclerView.ViewHolder {
        View a;
        TextView b;
        TextView c;
        TextView d;
        RelativeLayout e;
        TextView f;
        DMIconFontTextView g;
        LottieAnimationView h;
        LinearLayout i;
        LinearLayout j;
        DMDigitTextView k;
        TextView l;
        TUrlImageView m;
        ImageView n;
        ImageView o;
        ImageView p;
        LinearLayout q;
        FlowLayout r;

        public e(TickletListAdapter tickletListAdapter, View view) {
            super(view);
            this.a = view;
            this.e = (RelativeLayout) view.findViewById(R$id.ticklet_perform_item_view);
            this.b = (TextView) view.findViewById(R$id.ticklet_list_performname);
            this.c = (TextView) view.findViewById(R$id.ticklet_list_performtime);
            this.m = (TUrlImageView) view.findViewById(R$id.ticklet_perform_list_project_image);
            this.n = (ImageView) view.findViewById(R$id.ticklet_perform_item_status_icon);
            this.d = (TextView) view.findViewById(R$id.ticklet_list_performaddress);
            this.g = (DMIconFontTextView) view.findViewById(R$id.ticklet_list_type_icon);
            this.f = (TextView) view.findViewById(R$id.ticklet_perform_op_type);
            this.h = (LottieAnimationView) view.findViewById(R$id.ticklet_list_live_icon);
            this.i = (LinearLayout) view.findViewById(R$id.ticklet_perform_list_bottom);
            this.j = (LinearLayout) view.findViewById(R$id.ticklet_list_item_num_layout);
            this.k = (DMDigitTextView) view.findViewById(R$id.ticklet_list_item_num);
            this.l = (TextView) view.findViewById(R$id.ticklet_list_item_num_unit);
            this.o = (ImageView) view.findViewById(R$id.ticklet_perform_list_divider);
            this.p = (ImageView) view.findViewById(R$id.ticklet_perform_shadow);
            this.q = (LinearLayout) view.findViewById(R$id.ticklet_list_entry);
            this.r = (FlowLayout) view.findViewById(R$id.ticklet_list_item_info);
        }
    }

    public TickletListAdapter(Context context) {
        this.a = context;
    }

    private View d(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1070390348")) {
            return (View) ipChange.ipc$dispatch("-1070390348", new Object[]{this, str, str2, str3});
        }
        View inflate = LayoutInflater.from(this.a).inflate(R$layout.ticklet_list_item_label_layout, (ViewGroup) null);
        DMIconFontTextView dMIconFontTextView = (DMIconFontTextView) inflate.findViewById(R$id.ticklet_perform_tip_icon);
        TextView textView = (TextView) inflate.findViewById(R$id.ticklet_perform_list_label_content);
        textView.setText(str2);
        textView.setTextColor(Color.parseColor(str3));
        dMIconFontTextView.setText(str);
        dMIconFontTextView.setTextColor(Color.parseColor(str3));
        return inflate;
    }

    private void e(int i, LinearLayout linearLayout, PerformTable performTable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-625272297")) {
            ipChange.ipc$dispatch("-625272297", new Object[]{this, Integer.valueOf(i), linearLayout, performTable});
            return;
        }
        int size = performTable.getPerformOpList().size() > 3 ? 3 : performTable.getPerformOpList().size();
        if (linearLayout.getChildCount() != 0 && linearLayout.getChildCount() == size) {
            if (linearLayout.getChildCount() == size) {
                for (int i2 = 0; i2 < size; i2++) {
                    Long valueOf = Long.valueOf(System.currentTimeMillis());
                    TextView textView = (TextView) linearLayout.getChildAt(i2);
                    PerformOpModule performOpModule = performTable.getPerformOpList().get(i2);
                    if (performOpModule != null && textView != null) {
                        n(textView, i, i2, performOpModule, performTable);
                    }
                    cb1.c("entryShow1", "dur=" + (System.currentTimeMillis() - valueOf.longValue()));
                }
            }
        } else {
            linearLayout.removeAllViews();
            for (int i3 = 0; i3 < size; i3++) {
                Long valueOf2 = Long.valueOf(System.currentTimeMillis());
                PerformOpModule performOpModule2 = performTable.getPerformOpList().get(i3);
                if (performOpModule2 != null) {
                    TextView textView2 = new TextView(this.a);
                    textView2.setTextColor(this.a.getResources().getColor(R$color.white));
                    textView2.setTextSize(1, 14.0f);
                    n(textView2, i, i3, performOpModule2, performTable);
                    linearLayout.addView(textView2);
                }
                cb1.c("entryShow", "dur=" + (System.currentTimeMillis() - valueOf2.longValue()));
            }
        }
        cb1.c("entryShow", "end");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(PerformTable performTable, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "793887937")) {
            ipChange.ipc$dispatch("793887937", new Object[]{this, performTable, str});
            return;
        }
        String timeTitle = performTable.getTimeTitle();
        if (TextUtils.isEmpty(timeTitle)) {
            timeTitle = x30.h(Long.valueOf(performTable.getStartTimeByLong()), "yyyy.MM.dd");
        }
        CommentItemMoreUtil.g(this.a, performTable.getPerformId(), str, performTable.getProjectName(), performTable.getProjectImage(), performTable.getStartTimeByLong() == 0 ? null : String.valueOf(performTable.getStartTimeByLong()), CommentItemMoreUtil.m(performTable.getLocaleName(), timeTitle));
    }

    private void h(TUrlImageView tUrlImageView, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-231952601")) {
            ipChange.ipc$dispatch("-231952601", new Object[]{this, tUrlImageView, str});
        } else {
            tUrlImageView.setImageUrl(str);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:96:0x043c  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x044a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void i(cn.damai.ticklet.ui.adapter.TickletListAdapter.e r18, cn.damai.ticklet.bean.PerformTable r19, int r20) {
        /*
            Method dump skipped, instructions count: 1144
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.damai.ticklet.ui.adapter.TickletListAdapter.i(cn.damai.ticklet.ui.adapter.TickletListAdapter$e, cn.damai.ticklet.bean.PerformTable, int):void");
    }

    private int j(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-196338796")) {
            return ((Integer) ipChange.ipc$dispatch("-196338796", new Object[]{this, Boolean.valueOf(z)})).intValue();
        }
        return z ? R$drawable.submit_enable_btn_h32 : R$drawable.ticklet_33ffffff_bg;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String m(PerformTable performTable) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-916364786") ? (String) ipChange.ipc$dispatch("-916364786", new Object[]{this, performTable}) : performTable.isCouponPerform() ? ErrControlViewInfo.TYPE_SCRIPT : performTable.isLivePerform() ? performTable.isMaiLive() ? "平行麦现场直播票" : "非平行麦现场直播票" : performTable.isNftPerform() ? "数字门票" : "电子和纸质票";
    }

    private void n(TextView textView, int i, int i2, PerformOpModule performOpModule, PerformTable performTable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1127305059")) {
            ipChange.ipc$dispatch("-1127305059", new Object[]{this, textView, Integer.valueOf(i), Integer.valueOf(i2), performOpModule, performTable});
            return;
        }
        int a2 = t60.a(this.a, 6.0f);
        textView.setBackgroundResource(j(performTable.isHistoryTicket()));
        textView.setText(performOpModule.performOpDesc);
        Map<String, String> t = un2.k().t(performTable.getProjectId(), performTable.performId);
        if ("4".equals(performOpModule.performOpType)) {
            this.e = "souvenir_ticket_" + i;
        } else if ("3".equals(performOpModule.performOpType)) {
            this.e = "transfer_ticket_" + i;
        } else {
            this.e = performOpModule.performOpDesc + JSMethod.NOT_SET + performOpModule.performOpType;
        }
        cn.damai.common.user.c.e().G(textView, this.e, "list", un2.TICKLET_LIST_PAGE, t);
        textView.setOnClickListener(new c(performOpModule, i, t, performTable));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(t60.a(this.a, 65.0f), t60.a(this.a, 32.0f));
        if (i2 > 0) {
            layoutParams.setMargins(a2, 0, 0, 0);
        }
        textView.setGravity(17);
        textView.setLayoutParams(layoutParams);
    }

    public void clear() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1538688250")) {
            ipChange.ipc$dispatch("-1538688250", new Object[]{this});
            return;
        }
        this.b.clear();
        notifyDataSetChanged();
    }

    public TickletListFragment f() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "840339560") ? (TickletListFragment) ipChange.ipc$dispatch("840339560", new Object[]{this}) : this.c;
    }

    public List<PerformTable> getData() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-569617132") ? (List) ipChange.ipc$dispatch("-569617132", new Object[]{this}) : this.b;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1940988956") ? ((Integer) ipChange.ipc$dispatch("-1940988956", new Object[]{this})).intValue() : this.b.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "303252619") ? ((Integer) ipChange.ipc$dispatch("303252619", new Object[]{this, Integer.valueOf(i)})).intValue() : (getData() == null || getData().get(i) == null || this.b.get(i).sepType == 0 || 1 != this.b.get(i).sepType) ? 0 : 1;
    }

    public GradientDrawable k(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1322288426")) {
            return (GradientDrawable) ipChange.ipc$dispatch("1322288426", new Object[]{this, Integer.valueOf(i)});
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i);
        gradientDrawable.setCornerRadius(t60.a(this.a, 12.0f));
        return gradientDrawable;
    }

    public void l(TickletListFragment tickletListFragment) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "53455936")) {
            ipChange.ipc$dispatch("53455936", new Object[]{this, tickletListFragment});
        } else {
            this.c = tickletListFragment;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1832520341")) {
            ipChange.ipc$dispatch("1832520341", new Object[]{this, viewHolder, Integer.valueOf(i)});
        } else if (getData() == null || getData().get(i) == null) {
        } else {
            if (AppConfig.v()) {
                System.currentTimeMillis();
            }
            PerformTable performTable = this.b.get(i);
            if (performTable.sepType == 0) {
                i((e) viewHolder, performTable, i);
            }
            try {
                if (Build.VERSION.SDK_INT >= 12) {
                    if (viewHolder.itemView.getTag() != null) {
                        View view = viewHolder.itemView;
                        view.removeOnAttachStateChangeListener((View.OnAttachStateChangeListener) view.getTag());
                    }
                    a aVar = new a(this, viewHolder);
                    viewHolder.itemView.addOnAttachStateChangeListener(aVar);
                    viewHolder.itemView.setTag(aVar);
                }
            } catch (Exception unused) {
            }
            cb1.b("onBindViewHolder", "position=" + i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "705204993")) {
            return (RecyclerView.ViewHolder) ipChange.ipc$dispatch("705204993", new Object[]{this, viewGroup, Integer.valueOf(i)});
        }
        if (i != 0) {
            if (i != 1) {
                return null;
            }
            return new d(this, LayoutInflater.from(this.a).inflate(R$layout.ticklet_perform_item_history_tips_item, viewGroup, false));
        }
        return new e(this, LayoutInflater.from(this.a).inflate(R$layout.ticklet_tickletlist_item_layout, viewGroup, false));
    }

    public void setData(List<PerformTable> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-731363016")) {
            ipChange.ipc$dispatch("-731363016", new Object[]{this, list});
            return;
        }
        this.b = list;
        String str = this.d;
        cb1.b(str, "mDatas = " + list.size() + "");
        notifyDataSetChanged();
    }
}
