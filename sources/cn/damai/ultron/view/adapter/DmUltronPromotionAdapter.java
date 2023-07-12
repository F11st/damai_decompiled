package cn.damai.ultron.view.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.user.c;
import cn.damai.ultron.R$drawable;
import cn.damai.ultron.R$id;
import cn.damai.ultron.R$layout;
import cn.damai.ultron.utils.DmChooseSwitchListenerImpl;
import cn.damai.ultron.view.bean.DmPromotionOptionsBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import tb.ua0;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class DmUltronPromotionAdapter extends RecyclerView.Adapter<CouponViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<DmPromotionOptionsBean> a;
    private Context b;
    private DmChooseSwitchListenerImpl<DmPromotionOptionsBean> c;
    private int d = -1;

    /* compiled from: Taobao */
    /* loaded from: classes9.dex */
    public class CouponViewHolder extends RecyclerView.ViewHolder {
        private static transient /* synthetic */ IpChange $ipChange;
        private View a;
        private TextView b;
        private TextView c;
        private TextView d;
        private TextView e;
        private TextView f;
        private TextView g;
        private TextView h;
        private TextView i;
        private TextView j;
        private View k;
        private LinearLayout l;
        private LinearLayout m;

        /* compiled from: Taobao */
        /* loaded from: classes17.dex */
        public class a implements View.OnClickListener {
            private static transient /* synthetic */ IpChange $ipChange;
            final /* synthetic */ DmPromotionOptionsBean a;
            final /* synthetic */ int b;

            a(DmPromotionOptionsBean dmPromotionOptionsBean, int i) {
                this.a = dmPromotionOptionsBean;
                this.b = i;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-412397253")) {
                    ipChange.ipc$dispatch("-412397253", new Object[]{this, view});
                    return;
                }
                DmPromotionOptionsBean dmPromotionOptionsBean = this.a;
                if (!dmPromotionOptionsBean.checked) {
                    DmUltronPromotionAdapter.this.i(this.b);
                    DmUltronPromotionAdapter.this.d = this.b;
                } else {
                    dmPromotionOptionsBean.checked = false;
                    DmUltronPromotionAdapter.this.d = -1;
                }
                DmUltronPromotionAdapter.this.notifyDataSetChanged();
                DmUltronPromotionAdapter.this.c.chooseItemListener(this.a, DmUltronPromotionAdapter.this.d);
            }
        }

        public CouponViewHolder(View view) {
            super(view);
            this.a = view;
            this.b = (TextView) view.findViewById(R$id.tv_title);
            this.i = (TextView) view.findViewById(R$id.checkbox);
            this.c = (TextView) view.findViewById(cn.damai.commonbusiness.R$id.tv_money);
            this.h = (TextView) view.findViewById(cn.damai.commonbusiness.R$id.tv_money_prefix);
            this.d = (TextView) view.findViewById(cn.damai.commonbusiness.R$id.tv_money_desc);
            this.e = (TextView) view.findViewById(cn.damai.commonbusiness.R$id.tv_desc);
            this.l = (LinearLayout) view.findViewById(cn.damai.commonbusiness.R$id.ll_container);
            this.j = (TextView) view.findViewById(cn.damai.commonbusiness.R$id.tv_vip_tag);
            this.k = view.findViewById(cn.damai.commonbusiness.R$id.vip_tag);
            this.f = (TextView) view.findViewById(cn.damai.commonbusiness.R$id.tv_coupon_unused_reson_desc);
            this.m = (LinearLayout) view.findViewById(R$id.ll_coupon_unused_reson);
            this.g = (TextView) view.findViewById(R$id.tv_coupon_title);
        }

        public void a(DmPromotionOptionsBean dmPromotionOptionsBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "996031427")) {
                ipChange.ipc$dispatch("996031427", new Object[]{this, dmPromotionOptionsBean, Integer.valueOf(i)});
                return;
            }
            this.l.setVisibility(0);
            this.m.setVisibility(8);
            this.g.setVisibility(8);
            if (!TextUtils.isEmpty(dmPromotionOptionsBean.fullTitle)) {
                this.b.setText(dmPromotionOptionsBean.fullTitle);
            } else {
                this.b.setText(dmPromotionOptionsBean.title);
            }
            if (dmPromotionOptionsBean.checked) {
                this.i.setBackgroundResource(R$drawable.radio_selected_big);
            } else {
                this.i.setBackgroundResource(R$drawable.radio_unselected_big);
            }
            if (dmPromotionOptionsBean.valid) {
                this.a.setOnClickListener(new a(dmPromotionOptionsBean, i));
            } else {
                this.a.setOnClickListener(null);
            }
            String str = dmPromotionOptionsBean.cost;
            if (TextUtils.isEmpty(str)) {
                this.c.setText("");
            } else {
                if (str.startsWith("￥")) {
                    str = str.substring(1);
                }
                this.c.setText(str);
                if (str.length() > 5) {
                    this.c.setTextSize(1, 22.0f);
                } else {
                    this.c.setTextSize(1, 26.0f);
                }
            }
            String str2 = dmPromotionOptionsBean.rule;
            if (!TextUtils.isEmpty(str2)) {
                this.d.setVisibility(0);
                this.d.setText(str2);
            } else {
                this.d.setVisibility(4);
            }
            String str3 = dmPromotionOptionsBean.invalidDate;
            if (!TextUtils.isEmpty(str3)) {
                this.e.setVisibility(0);
                this.e.setText(str3);
            } else {
                this.e.setVisibility(4);
            }
            if (!TextUtils.isEmpty(dmPromotionOptionsBean.tag)) {
                this.j.setText("专享");
                this.k.setVisibility(0);
                this.l.setBackgroundResource(cn.damai.commonbusiness.R$drawable.sku_profit_convert_bg);
            } else {
                this.k.setVisibility(8);
                this.l.setBackgroundResource(cn.damai.commonbusiness.R$drawable.sku_profit_coupon_bg);
            }
            if (!dmPromotionOptionsBean.valid) {
                this.l.setAlpha(0.4f);
                this.i.setVisibility(4);
                if (!TextUtils.isEmpty(dmPromotionOptionsBean.unusableReason)) {
                    this.m.setVisibility(0);
                    TextView textView = this.f;
                    textView.setText("不可用原因:" + dmPromotionOptionsBean.unusableReason);
                }
            } else {
                this.l.setAlpha(1.0f);
                this.i.setVisibility(0);
            }
            c(!TextUtils.isEmpty(dmPromotionOptionsBean.tag));
            HashMap hashMap = new HashMap();
            hashMap.put("item_id", String.valueOf(ua0.b(DmUltronPromotionAdapter.this.b)));
            hashMap.put("coupon_id", dmPromotionOptionsBean.selectedId);
            c e = c.e();
            View view = this.itemView;
            e.G(view, "item_" + (i - (!dmPromotionOptionsBean.valid ? 1 : 0)), "couponlayer", "confirm", hashMap);
        }

        public void b() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "285695026")) {
                ipChange.ipc$dispatch("285695026", new Object[]{this});
                return;
            }
            this.l.setVisibility(8);
            this.m.setVisibility(8);
            this.k.setVisibility(8);
            this.g.setText("不可用优惠券");
            this.g.setVisibility(0);
        }

        public void c(boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1368079450")) {
                ipChange.ipc$dispatch("1368079450", new Object[]{this, Boolean.valueOf(z)});
            } else if (!z) {
                this.c.setTextColor(Color.parseColor("#FF4886"));
                this.h.setTextColor(Color.parseColor("#FF4886"));
                this.d.setTextColor(Color.parseColor("#999999"));
                this.g.setTextColor(Color.parseColor("#000000"));
                this.e.setTextColor(Color.parseColor("#999999"));
            } else {
                this.c.setTextColor(Color.parseColor("#582331"));
                this.h.setTextColor(Color.parseColor("#582331"));
                this.d.setTextColor(Color.parseColor("#A67070"));
                this.g.setTextColor(Color.parseColor("#582331"));
                this.e.setTextColor(Color.parseColor("#999999"));
            }
        }
    }

    public DmUltronPromotionAdapter(Context context, List<DmPromotionOptionsBean> list, DmChooseSwitchListenerImpl<DmPromotionOptionsBean> dmChooseSwitchListenerImpl) {
        this.b = context;
        this.a = list;
        this.c = dmChooseSwitchListenerImpl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1655445005")) {
            ipChange.ipc$dispatch("1655445005", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        for (int i2 = 0; i2 < wh2.e(this.a); i2++) {
            if (i2 == i) {
                this.a.get(i2).checked = true;
            } else {
                this.a.get(i2).checked = false;
            }
        }
    }

    public void f(List<DmPromotionOptionsBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "921216938")) {
            ipChange.ipc$dispatch("921216938", new Object[]{this, list});
            return;
        }
        for (DmPromotionOptionsBean dmPromotionOptionsBean : list) {
            dmPromotionOptionsBean.valid = false;
        }
        List<DmPromotionOptionsBean> list2 = this.a;
        if (list2 == null || list2.size() == 0) {
            this.a = new ArrayList();
        }
        DmPromotionOptionsBean dmPromotionOptionsBean2 = new DmPromotionOptionsBean();
        dmPromotionOptionsBean2.isTitle = true;
        this.a.add(dmPromotionOptionsBean2);
        this.a.addAll(list);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: g */
    public void onBindViewHolder(CouponViewHolder couponViewHolder, @SuppressLint({"RecyclerView"}) int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1133172039")) {
            ipChange.ipc$dispatch("-1133172039", new Object[]{this, couponViewHolder, Integer.valueOf(i)});
            return;
        }
        DmPromotionOptionsBean dmPromotionOptionsBean = this.a.get(i);
        if (dmPromotionOptionsBean == null) {
            return;
        }
        if (dmPromotionOptionsBean.isTitle) {
            couponViewHolder.b();
        } else {
            couponViewHolder.a(dmPromotionOptionsBean, i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2018425565") ? ((Integer) ipChange.ipc$dispatch("2018425565", new Object[]{this})).intValue() : wh2.e(this.a);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: h */
    public CouponViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1558057507") ? (CouponViewHolder) ipChange.ipc$dispatch("-1558057507", new Object[]{this, viewGroup, Integer.valueOf(i)}) : new CouponViewHolder(LayoutInflater.from(this.b).inflate(R$layout.fragment_sku_ncov_promotion_select, viewGroup, false));
    }
}
