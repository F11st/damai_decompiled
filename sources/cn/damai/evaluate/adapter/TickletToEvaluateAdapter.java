package cn.damai.evaluate.adapter;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.comment.R$drawable;
import cn.damai.comment.R$id;
import cn.damai.comment.R$layout;
import cn.damai.comment.util.CommentItemMoreUtil;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.user.a;
import cn.damai.common.user.c;
import cn.damai.issue.net.CommentInfo;
import cn.damai.issue.net.ToEvaListResponse;
import cn.damai.uikit.view.DMPosterView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import tb.in2;
import tb.t60;
import tb.un2;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class TickletToEvaluateAdapter extends RecyclerView.Adapter<TikletToEvaluateViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context a;
    private List<ToEvaListResponse.EvaluateInfo> b = new ArrayList();

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public static class TikletToEvaluateViewHolder extends RecyclerView.ViewHolder {
        private static transient /* synthetic */ IpChange $ipChange;
        public DMPosterView a;
        public TextView b;
        public LinearLayout c;
        public TextView d;
        public LinearLayout e;
        public TextView f;
        public RelativeLayout g;
        public TextView h;
        public LinearLayout i;
        public TextView j;

        public TikletToEvaluateViewHolder(View view) {
            super(view);
            a();
        }

        private void a() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "513496473")) {
                ipChange.ipc$dispatch("513496473", new Object[]{this});
                return;
            }
            this.a = (DMPosterView) this.itemView.findViewById(R$id.ticklet_to_evaluate_perform_iv);
            this.b = (TextView) this.itemView.findViewById(R$id.ticklet_to_evaluate_perform_name_tv);
            this.c = (LinearLayout) this.itemView.findViewById(R$id.ticklet_to_evaluate_show_time_lv);
            this.d = (TextView) this.itemView.findViewById(R$id.ticklet_to_evaluate_perform_time_tv);
            this.e = (LinearLayout) this.itemView.findViewById(R$id.ticklet_to_evaluate_perform_address_lv);
            this.f = (TextView) this.itemView.findViewById(R$id.ticklet_to_evaluate_perform_address_tv);
            LinearLayout linearLayout = (LinearLayout) this.itemView.findViewById(R$id.ticklet_ticket_evaluates_lv);
            this.g = (RelativeLayout) this.itemView.findViewById(R$id.ticklet_to_evaluate_user_evaluate_rv);
            this.h = (TextView) this.itemView.findViewById(R$id.ticklet_tosee_comments);
            this.i = (LinearLayout) this.itemView.findViewById(R$id.ticklet_tocomment_btn_layout);
            this.j = (TextView) this.itemView.findViewById(R$id.ticklet_list_comment_gift);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes14.dex */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ ToEvaListResponse.EvaluateInfo a;
        final /* synthetic */ CommentInfo b;

        a(ToEvaListResponse.EvaluateInfo evaluateInfo, CommentInfo commentInfo) {
            this.a = evaluateInfo;
            this.b = commentInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "230356395")) {
                ipChange.ipc$dispatch("230356395", new Object[]{this, view});
                return;
            }
            Bundle bundle = new Bundle();
            if (TextUtils.isEmpty(this.a.storeId)) {
                bundle.putString("projectId", this.b.getItemId());
            } else {
                bundle.putString("storeId", this.a.storeId);
            }
            DMNav.from(TickletToEvaluateAdapter.this.a).withExtras(bundle).toUri(NavUri.b("evaluate_list"));
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes14.dex */
    public class b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ ToEvaListResponse.EvaluateInfo a;
        final /* synthetic */ CommentInfo b;
        final /* synthetic */ int c;

        b(ToEvaListResponse.EvaluateInfo evaluateInfo, CommentInfo commentInfo, int i) {
            this.a = evaluateInfo;
            this.b = commentInfo;
            this.c = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1953320532")) {
                ipChange.ipc$dispatch("-1953320532", new Object[]{this, view});
                return;
            }
            String timeTitle = this.a.getTimeTitle();
            if (TextUtils.isEmpty(timeTitle)) {
                timeTitle = CommentItemMoreUtil.o(Long.valueOf(this.a.getBeginTime()), "yyyy.MM.dd");
            }
            String m = CommentItemMoreUtil.m(this.a.getLocaleName(), timeTitle);
            HashMap hashMap = new HashMap();
            hashMap.put("titlelabel", in2.TO_COMMENT);
            hashMap.put("item_id", this.b.getItemId());
            ToEvaListResponse.EvaluateInfo evaluateInfo = this.a;
            if (evaluateInfo.storeId != null && "1".equals(evaluateInfo.itemType)) {
                hashMap.put("store_id", this.a.storeId);
                hashMap.put("style", "1");
            } else {
                hashMap.put("style", "0");
            }
            c e = c.e();
            a.b i = new a.b().i(un2.TICKLET_MYCOMMENT_LIST_PAGE);
            e.x(i.f("tobeevaluate_" + this.c).l("goto_evaluate").g(true).j(hashMap));
            TickletToEvaluateAdapter.this.d(this.a, this.b.getItemId(), m);
        }
    }

    public TickletToEvaluateAdapter(Context context) {
        this.a = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ToEvaListResponse.EvaluateInfo evaluateInfo, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1684277193")) {
            ipChange.ipc$dispatch("1684277193", new Object[]{this, evaluateInfo, str, str2});
        } else if (evaluateInfo.getCommentInfo() != null) {
            CommentItemMoreUtil.g(this.a, evaluateInfo.getCommentInfo().getTargetId(), str, evaluateInfo.getProjectName(), evaluateInfo.getProjectImage(), evaluateInfo.getBeginTime() == 0 ? null : String.valueOf(evaluateInfo.getBeginTime()), str2);
        }
    }

    private void e(TikletToEvaluateViewHolder tikletToEvaluateViewHolder, String str, int i, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1807016231")) {
            ipChange.ipc$dispatch("-1807016231", new Object[]{this, tikletToEvaluateViewHolder, str, Integer.valueOf(i), Boolean.valueOf(z)});
            return;
        }
        if (z) {
            tikletToEvaluateViewHolder.a.getLayoutParams().height = t60.a(this.a, 78.0f);
            tikletToEvaluateViewHolder.a.getLayoutParams().width = t60.a(this.a, 78.0f);
            Context context = this.a;
            if (context != null && context.getResources() != null) {
                tikletToEvaluateViewHolder.a.setImageDrawable(this.a.getResources().getDrawable(R$drawable.store_defult_img));
            }
        } else {
            tikletToEvaluateViewHolder.a.getLayoutParams().height = t60.a(this.a, 104.0f);
            tikletToEvaluateViewHolder.a.getLayoutParams().width = t60.a(this.a, 78.0f);
            tikletToEvaluateViewHolder.a.setPlaceholder(R$drawable.uikit_default_image_bg_gradient);
        }
        tikletToEvaluateViewHolder.a.setImageUrl(str);
    }

    private void h(TikletToEvaluateViewHolder tikletToEvaluateViewHolder, ToEvaListResponse.EvaluateInfo evaluateInfo, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "678789426")) {
            ipChange.ipc$dispatch("678789426", new Object[]{this, tikletToEvaluateViewHolder, evaluateInfo, Integer.valueOf(i)});
            return;
        }
        evaluateInfo.getIsDisplayComment();
        CommentInfo commentInfo = evaluateInfo.getCommentInfo();
        tikletToEvaluateViewHolder.g.setVisibility(0);
        tikletToEvaluateViewHolder.h.setOnClickListener(new a(evaluateInfo, commentInfo));
        if (commentInfo != null) {
            if (!TextUtils.isEmpty(commentInfo.getIsHasComment()) && commentInfo.getIsHasComment().equals("1")) {
                tikletToEvaluateViewHolder.i.setVisibility(8);
            } else {
                tikletToEvaluateViewHolder.i.setVisibility(0);
            }
            tikletToEvaluateViewHolder.i.setOnClickListener(new b(evaluateInfo, commentInfo, i));
            if (!TextUtils.isEmpty(commentInfo.getCommentGiftTxt())) {
                tikletToEvaluateViewHolder.j.setText(commentInfo.getCommentGiftTxt());
                tikletToEvaluateViewHolder.j.setVisibility(0);
                return;
            }
            tikletToEvaluateViewHolder.j.setVisibility(8);
            return;
        }
        tikletToEvaluateViewHolder.i.setVisibility(8);
    }

    private void i(TikletToEvaluateViewHolder tikletToEvaluateViewHolder, ToEvaListResponse.EvaluateInfo evaluateInfo, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1824453792")) {
            ipChange.ipc$dispatch("-1824453792", new Object[]{this, tikletToEvaluateViewHolder, evaluateInfo, Integer.valueOf(i)});
        } else if (evaluateInfo == null) {
        } else {
            e(tikletToEvaluateViewHolder, evaluateInfo.getProjectImage(), i, evaluateInfo.isScriptmurderShop());
            String projectName = evaluateInfo.getProjectName();
            if (TextUtils.isEmpty(projectName)) {
                tikletToEvaluateViewHolder.b.setVisibility(4);
                tikletToEvaluateViewHolder.b.setText("");
            } else {
                tikletToEvaluateViewHolder.b.setVisibility(0);
                tikletToEvaluateViewHolder.b.setText(projectName);
            }
            String timeTitle = evaluateInfo.getTimeTitle();
            if (TextUtils.isEmpty(timeTitle)) {
                timeTitle = CommentItemMoreUtil.o(Long.valueOf(evaluateInfo.getBeginTime()), "yyyy.MM.dd HH:mm");
            }
            if (!wh2.j(timeTitle) && !evaluateInfo.isScriptmurderShop()) {
                tikletToEvaluateViewHolder.c.setVisibility(0);
                tikletToEvaluateViewHolder.d.setText(timeTitle);
            } else {
                tikletToEvaluateViewHolder.c.setVisibility(4);
                tikletToEvaluateViewHolder.d.setText("");
            }
            String localeName = evaluateInfo.getLocaleName();
            if (evaluateInfo.isScriptmurderShop() && !TextUtils.isEmpty(evaluateInfo.localeStoreName)) {
                tikletToEvaluateViewHolder.e.setVisibility(0);
                tikletToEvaluateViewHolder.f.setText(evaluateInfo.localeStoreName);
            } else if (!evaluateInfo.isScriptmurderShop() && !TextUtils.isEmpty(localeName)) {
                tikletToEvaluateViewHolder.e.setVisibility(0);
                tikletToEvaluateViewHolder.f.setText(localeName);
            } else {
                tikletToEvaluateViewHolder.e.setVisibility(4);
            }
            h(tikletToEvaluateViewHolder, evaluateInfo, i);
        }
    }

    public void c(List<ToEvaListResponse.EvaluateInfo> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "348405475")) {
            ipChange.ipc$dispatch("348405475", new Object[]{this, list});
            return;
        }
        this.b.addAll(list);
        notifyDataSetChanged();
    }

    public void clear() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "90833488")) {
            ipChange.ipc$dispatch("90833488", new Object[]{this});
            return;
        }
        this.b.clear();
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: f */
    public void onBindViewHolder(@NonNull TikletToEvaluateViewHolder tikletToEvaluateViewHolder, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-97214152")) {
            ipChange.ipc$dispatch("-97214152", new Object[]{this, tikletToEvaluateViewHolder, Integer.valueOf(i)});
        } else if (tikletToEvaluateViewHolder != null) {
            i(tikletToEvaluateViewHolder, this.b.get(i), i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: g */
    public TikletToEvaluateViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-486484866") ? (TikletToEvaluateViewHolder) ipChange.ipc$dispatch("-486484866", new Object[]{this, viewGroup, Integer.valueOf(i)}) : new TikletToEvaluateViewHolder(LayoutInflater.from(this.a).inflate(R$layout.ticklet_perform_to_evaluate_item_layout, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1827630426")) {
            return ((Integer) ipChange.ipc$dispatch("1827630426", new Object[]{this})).intValue();
        }
        List<ToEvaListResponse.EvaluateInfo> list = this.b;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public void setData(List<ToEvaListResponse.EvaluateInfo> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2052411906")) {
            ipChange.ipc$dispatch("2052411906", new Object[]{this, list});
            return;
        }
        this.b.clear();
        this.b.addAll(list);
        notifyDataSetChanged();
    }
}
