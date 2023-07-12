package cn.damai.search.ui.adapter;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.image.C0504a;
import cn.damai.common.image.DMImageCreator;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.user.C0529c;
import cn.damai.commonbusiness.search.bean.BaccountInfo;
import cn.damai.homepage.R$drawable;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.login.LoginManager;
import cn.damai.search.helper.SearchHelper;
import cn.damai.user.repertoite.ui.RepertoireDetailFragment;
import cn.damai.user.userprofile.FeedsViewModel;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.C9826vr;
import tb.b82;
import tb.cs;
import tb.u12;
import tb.wh2;
import tb.xr;
import tb.yq;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class AccountMoreAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context a;
    private List<BaccountInfo> b;

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public class AccountViewHolder extends RecyclerView.ViewHolder {
        private static transient /* synthetic */ IpChange $ipChange;
        private Context a;
        private LinearLayout b;
        private ImageView c;
        private ImageView d;
        private TextView e;
        private TextView f;
        private TextView g;
        private RelativeLayout h;
        private StringBuilder i;
        private View.OnClickListener j;

        /* compiled from: Taobao */
        /* renamed from: cn.damai.search.ui.adapter.AccountMoreAdapter$AccountViewHolder$a */
        /* loaded from: classes15.dex */
        public class View$OnClickListenerC1608a implements View.OnClickListener {
            private static transient /* synthetic */ IpChange $ipChange;

            View$OnClickListenerC1608a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BaccountInfo baccountInfo;
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1476786959")) {
                    ipChange.ipc$dispatch("-1476786959", new Object[]{this, view});
                    return;
                }
                int id = view.getId();
                if (R$id.ll_account == id) {
                    AccountViewHolder.this.d((BaccountInfo) view.getTag());
                } else if (R$id.relation_status_button != id || (baccountInfo = (BaccountInfo) view.getTag()) == null) {
                } else {
                    if (baccountInfo.isHasFollow()) {
                        AccountViewHolder.this.d(baccountInfo);
                    } else {
                        xr.c(SearchHelper.ACCOUNT_MORE_ATTENTION, baccountInfo);
                    }
                }
            }
        }

        public AccountViewHolder(AccountMoreAdapter accountMoreAdapter, Context context, LayoutInflater layoutInflater) {
            super(layoutInflater.inflate(R$layout.search_list_baccount, (ViewGroup) null));
            this.i = new StringBuilder();
            this.j = new View$OnClickListenerC1608a();
            this.itemView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            this.a = context;
            this.b = (LinearLayout) this.itemView.findViewById(R$id.ll_account);
            this.c = (ImageView) this.itemView.findViewById(R$id.iv_account_image);
            this.d = (ImageView) this.itemView.findViewById(R$id.iv_account_arrow);
            this.e = (TextView) this.itemView.findViewById(R$id.tv_account_name);
            this.f = (TextView) this.itemView.findViewById(R$id.tv_account_count);
            this.g = (TextView) this.itemView.findViewById(R$id.relation_status);
            this.h = (RelativeLayout) this.itemView.findViewById(R$id.relation_status_button);
            this.b.setOnClickListener(this.j);
            this.h.setOnClickListener(this.j);
        }

        private String b(BaccountInfo baccountInfo) {
            String g;
            IpChange ipChange = $ipChange;
            boolean z = true;
            if (AndroidInstantRuntime.support(ipChange, "214005001")) {
                return (String) ipChange.ipc$dispatch("214005001", new Object[]{this, baccountInfo});
            }
            if (baccountInfo == null) {
                return "";
            }
            StringBuilder sb = this.i;
            sb.delete(0, sb.length());
            if (TextUtils.isEmpty(baccountInfo.performanceCount) || baccountInfo.performanceCount.equals("0")) {
                z = false;
            } else {
                StringBuilder sb2 = this.i;
                sb2.append(baccountInfo.performanceCount + "场在售演出");
            }
            String str = baccountInfo.type;
            if (str != null && "3".equals(str)) {
                g = SearchHelper.f(baccountInfo.distance);
            } else {
                g = SearchHelper.g(baccountInfo.fansCount);
            }
            if (!TextUtils.isEmpty(g)) {
                if (z) {
                    this.i.append(" | ");
                }
                this.i.append(g);
            }
            return this.i.length() > 0 ? this.i.toString() : "";
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d(BaccountInfo baccountInfo) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1075045922")) {
                ipChange.ipc$dispatch("-1075045922", new Object[]{this, baccountInfo});
            } else if (baccountInfo == null) {
            } else {
                SearchHelper.a = baccountInfo.index;
                C0529c.e().x(b82.C().H(baccountInfo.damaiId));
                if (baccountInfo.type.equals("5")) {
                    Bundle bundle = new Bundle();
                    bundle.putString(RepertoireDetailFragment.REPERTOIREID, baccountInfo.damaiId);
                    DMNav.from(this.a).withExtras(bundle).toUri(NavUri.b(u12.REPERTOITE));
                    return;
                }
                Bundle bundle2 = new Bundle();
                bundle2.putString(FeedsViewModel.ARG_USERID, baccountInfo.damaiId);
                bundle2.putString("usertype", baccountInfo.type);
                DMNav.from(this.a).withExtras(bundle2).toUri(NavUri.b(cs.ARTISTID_THEME));
            }
        }

        public void c(BaccountInfo baccountInfo, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "967640456")) {
                ipChange.ipc$dispatch("967640456", new Object[]{this, baccountInfo, Integer.valueOf(i)});
            } else if (baccountInfo == null) {
            } else {
                baccountInfo.index = i;
                this.b.setTag(baccountInfo);
                this.h.setTag(baccountInfo);
                if (this.c.getTag() instanceof C9826vr) {
                    ((C9826vr) this.c.getTag()).cancel();
                }
                DMImageCreator c = C0504a.b().h(this.a).c(baccountInfo.headPic);
                int i2 = R$drawable.uikit_user_default_icon;
                this.c.setTag(c.i(i2).c(i2).k(new yq()).g(this.c));
                this.d.setVisibility(baccountInfo.isShowVTag() ? 0 : 8);
                this.e.setText(baccountInfo.name);
                String b = b(baccountInfo);
                if (TextUtils.isEmpty(b)) {
                    this.f.setVisibility(8);
                } else {
                    this.f.setText(b);
                    this.f.setVisibility(0);
                }
                if (LoginManager.k().q() && baccountInfo.isHasFollow()) {
                    e();
                } else {
                    f();
                }
            }
        }

        public void e() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1215593984")) {
                ipChange.ipc$dispatch("-1215593984", new Object[]{this});
                return;
            }
            this.g.setText("已关注");
            this.g.setTextColor(Color.parseColor("#888888"));
            this.h.setBackgroundResource(R$drawable.attention_button_bg);
        }

        public void f() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1695422623")) {
                ipChange.ipc$dispatch("-1695422623", new Object[]{this});
                return;
            }
            this.g.setText("+关注");
            this.g.setTextColor(Color.parseColor("#FF1268"));
            this.h.setBackgroundResource(R$drawable.attention_cancel_button_bg);
        }
    }

    public AccountMoreAdapter(Context context, List<BaccountInfo> list) {
        this.a = context;
        this.b = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1516305446") ? ((Integer) ipChange.ipc$dispatch("1516305446", new Object[]{this})).intValue() : wh2.e(this.b);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "843995411")) {
            ipChange.ipc$dispatch("843995411", new Object[]{this, viewHolder, Integer.valueOf(i)});
        } else {
            ((AccountViewHolder) viewHolder).c(this.b.get(i), i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1547768253")) {
            return (RecyclerView.ViewHolder) ipChange.ipc$dispatch("-1547768253", new Object[]{this, viewGroup, Integer.valueOf(i)});
        }
        Context context = this.a;
        return new AccountViewHolder(this, context, LayoutInflater.from(context));
    }
}
