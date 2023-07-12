package cn.damai.commonbusiness.seatbiz.promotion.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.seatbiz.promotion.OnCouponApplyClickListener;
import cn.damai.commonbusiness.seatbiz.promotion.bean.CouponActivityBean;
import cn.damai.commonbusiness.seatbiz.promotion.bean.GroupItemBean;
import cn.damai.commonbusiness.seatbiz.promotion.bean.PromotionGroupBean;
import cn.damai.commonbusiness.seatbiz.promotion.bean.Tip;
import cn.damai.commonbusiness.seatbiz.promotion.bean.Title;
import cn.damai.commonbusiness.seatbiz.promotion.bean.UserProfitInfoBean;
import cn.damai.commonbusiness.seatbiz.promotion.viewholder.ProjectProfitViewHolder;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.util.DisplayUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tb.cb2;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class PromotionAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange;
    private List a;
    private Context b;
    private OnCouponApplyClickListener c;
    private List<CouponActivityBean> d;
    private List<CouponActivityBean> e;
    private List<PromotionGroupBean> f;
    private Tip g;
    private UserProfitInfoBean h;
    private String i;
    private String j;
    int k = 0;

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public static final class BottomVH extends RecyclerView.ViewHolder {
        BottomVH(View view) {
            super(view);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public static final class ProjectPromotionViewHolder extends RecyclerView.ViewHolder {
        private static transient /* synthetic */ IpChange $ipChange;
        private LinearLayout a;
        private TextView b;

        ProjectPromotionViewHolder(View view) {
            super(view);
            this.b = (TextView) view.findViewById(R$id.item_promotion_title);
            this.a = (LinearLayout) view.findViewById(R$id.item_promotion_list_ll);
        }

        public void a(PromotionGroupBean promotionGroupBean) {
            int i;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-566470497")) {
                ipChange.ipc$dispatch("-566470497", new Object[]{this, promotionGroupBean});
            } else if (promotionGroupBean != null && !TextUtils.isEmpty(promotionGroupBean.promotionGroupTypeDesc) && !cb2.d(promotionGroupBean.promotionList)) {
                this.b.setVisibility(0);
                this.b.setText(promotionGroupBean.promotionGroupTypeDesc);
                this.a.removeAllViews();
                for (GroupItemBean groupItemBean : promotionGroupBean.promotionList) {
                    if (groupItemBean != null && !cb2.d(groupItemBean.promotionContentList) && !TextUtils.isEmpty(groupItemBean.promotionTag)) {
                        for (int i2 = 0; i2 < groupItemBean.promotionContentList.size(); i2++) {
                            View inflate = LayoutInflater.from(this.itemView.getContext()).inflate(R$layout.ll_seat_promotion_item, (ViewGroup) null);
                            TextView textView = (TextView) inflate.findViewById(R$id.item_seat_promotion_tag);
                            if (groupItemBean.isWednesdayDiscount()) {
                                Context context = this.itemView.getContext();
                                int i3 = R$drawable.bricks_common_promotion_tagview_wednesday_discount;
                                AppCompatResources.getDrawable(context, i3);
                                textView.setBackgroundResource(i3);
                                textView.getLayoutParams().height = DisplayUtil.dip2px(this.itemView.getContext(), 14.0f);
                                try {
                                    i = (textView.getLayoutParams().height * textView.getBackground().getIntrinsicWidth()) / textView.getBackground().getIntrinsicHeight();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                    i = 0;
                                }
                                if (i > 0) {
                                    textView.getLayoutParams().width = i;
                                }
                                textView.setText("");
                            } else {
                                textView.setText(groupItemBean.promotionTag);
                            }
                            if (i2 == 0) {
                                textView.setVisibility(0);
                            } else {
                                textView.setVisibility(4);
                            }
                            TextView textView2 = (TextView) inflate.findViewById(R$id.item_promotion_content);
                            if (!TextUtils.isEmpty(groupItemBean.promotionContentList.get(i2))) {
                                textView2.setText(groupItemBean.promotionContentList.get(i2));
                                textView2.setVisibility(0);
                            } else {
                                textView2.setVisibility(8);
                            }
                            this.a.addView(inflate);
                        }
                    }
                }
            } else {
                this.b.setVisibility(8);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public static final class ProjectTipViewHolder extends RecyclerView.ViewHolder {
        private static transient /* synthetic */ IpChange $ipChange;
        private TextView a;

        ProjectTipViewHolder(View view) {
            super(view);
            this.a = (TextView) view.findViewById(R$id.item_promotion_tv);
        }

        public void a(Tip tip) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "905203618")) {
                ipChange.ipc$dispatch("905203618", new Object[]{this, tip});
            } else {
                this.a.setText(tip.tip);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public static final class ProjectTitleViewHolder extends RecyclerView.ViewHolder {
        private static transient /* synthetic */ IpChange $ipChange;
        private TextView a;

        ProjectTitleViewHolder(View view) {
            super(view);
            this.a = (TextView) view.findViewById(R$id.item_promotion_title);
        }

        public void a(Title title) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "945064962")) {
                ipChange.ipc$dispatch("945064962", new Object[]{this, title});
            } else {
                this.a.setText(title.title);
            }
        }
    }

    public PromotionAdapter(Context context, OnCouponApplyClickListener onCouponApplyClickListener) {
        this.b = context;
        this.c = onCouponApplyClickListener;
    }

    private void a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1590470969")) {
            ipChange.ipc$dispatch("-1590470969", new Object[]{this});
            return;
        }
        ArrayList arrayList = new ArrayList();
        this.a = arrayList;
        arrayList.clear();
        this.k = 0;
        List<PromotionGroupBean> list = this.f;
        if (list != null && list.size() > 0) {
            Iterator<PromotionGroupBean> it = this.f.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                PromotionGroupBean next = it.next();
                if (next != null && next.promotionGroupType == 1) {
                    this.a.add(next);
                    this.k++;
                    break;
                }
            }
        }
        List<PromotionGroupBean> list2 = this.f;
        if (list2 != null && list2.size() > 0) {
            for (PromotionGroupBean promotionGroupBean : this.f) {
                if (promotionGroupBean != null && promotionGroupBean.promotionGroupType != 1) {
                    this.a.add(promotionGroupBean);
                }
            }
        }
        if (wh2.e(this.d) + wh2.e(this.e) > 0) {
            this.k++;
            this.a.add(new Title("优惠券"));
        }
        if (wh2.e(this.d) > 0) {
            this.a.addAll(this.d);
        }
        int e = wh2.e(this.e);
        for (int i = 0; i < e; i++) {
            CouponActivityBean couponActivityBean = this.e.get(i);
            if (couponActivityBean != null) {
                couponActivityBean.setActivityType(1);
                this.a.add(couponActivityBean);
                if (i == e - 1) {
                    couponActivityBean.setNeedAuthorizeProfit(this.h.isNeedAuthorizeProfit);
                    couponActivityBean.setAuthorizeProfitText(this.h.authorizeProfitText);
                    couponActivityBean.setMaxVipLastOne(true);
                } else {
                    couponActivityBean.setMaxVipLastOne(false);
                }
            }
        }
        Tip tip = this.g;
        if (tip != null) {
            this.a.add(tip);
        }
        this.a.add("bottom");
        notifyDataSetChanged();
    }

    public void b(List<CouponActivityBean> list, List<CouponActivityBean> list2, List<PromotionGroupBean> list3, Tip tip) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "636578376")) {
            ipChange.ipc$dispatch("636578376", new Object[]{this, list, list2, list3, tip});
            return;
        }
        this.d = list;
        this.e = list2;
        this.f = list3;
        this.g = tip;
        a();
    }

    public void c(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1426622021")) {
            ipChange.ipc$dispatch("-1426622021", new Object[]{this, str, str2});
            return;
        }
        this.i = str;
        this.j = str2;
    }

    public void d(List<PromotionGroupBean> list, Tip tip) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "478986340")) {
            ipChange.ipc$dispatch("478986340", new Object[]{this, list, tip});
            return;
        }
        this.f = list;
        this.g = tip;
        a();
    }

    public void e(UserProfitInfoBean userProfitInfoBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-815946153")) {
            ipChange.ipc$dispatch("-815946153", new Object[]{this, userProfitInfoBean});
        } else {
            this.h = userProfitInfoBean;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1765718308")) {
            return ((Integer) ipChange.ipc$dispatch("1765718308", new Object[]{this})).intValue();
        }
        List list = this.a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "223510987")) {
            return ((Integer) ipChange.ipc$dispatch("223510987", new Object[]{this, Integer.valueOf(i)})).intValue();
        }
        Object obj = this.a.get(i);
        if (obj instanceof CouponActivityBean) {
            return 1;
        }
        if (obj instanceof PromotionGroupBean) {
            return 2;
        }
        if (obj instanceof Tip) {
            return 3;
        }
        if (obj instanceof Title) {
            return 4;
        }
        return super.getItemViewType(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1234246315")) {
            ipChange.ipc$dispatch("-1234246315", new Object[]{this, viewHolder, Integer.valueOf(i)});
            return;
        }
        int itemViewType = getItemViewType(i);
        Object obj = this.a.get(i);
        if (obj == null) {
            return;
        }
        if (itemViewType == 1) {
            ((ProjectProfitViewHolder) viewHolder).g((CouponActivityBean) obj, this.h, this.i, this.j, i - this.k);
        } else if (itemViewType == 2) {
            ((ProjectPromotionViewHolder) viewHolder).a((PromotionGroupBean) obj);
        } else if (itemViewType == 3) {
            ((ProjectTipViewHolder) viewHolder).a((Tip) obj);
        } else if (itemViewType != 4) {
        } else {
            ((ProjectTitleViewHolder) viewHolder).a((Title) obj);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1461407809")) {
            return (RecyclerView.ViewHolder) ipChange.ipc$dispatch("1461407809", new Object[]{this, viewGroup, Integer.valueOf(i)});
        }
        if (i == 1) {
            return new ProjectProfitViewHolder(viewGroup.getContext(), LayoutInflater.from(this.b).inflate(R$layout.fragment_sku_ncov_promotion_profit, viewGroup, false), this.c);
        }
        if (i == 2) {
            return new ProjectPromotionViewHolder(LayoutInflater.from(this.b).inflate(R$layout.fragment_sku_ncov_promotion_item, viewGroup, false));
        }
        if (i == 3) {
            return new ProjectTipViewHolder(LayoutInflater.from(this.b).inflate(R$layout.fragment_sku_ncov_promotion_item_foot, viewGroup, false));
        }
        if (i == 4) {
            return new ProjectTitleViewHolder(LayoutInflater.from(this.b).inflate(R$layout.fragment_sku_ncov_promotion_item, viewGroup, false));
        }
        return new BottomVH(LayoutInflater.from(this.b).inflate(R$layout.fragment_sku_ncov_promotion_item_bottom, viewGroup, false));
    }
}
