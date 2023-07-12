package com.alibaba.pictures.bricks.coupon.order;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.pictures.R$layout;
import com.alibaba.pictures.bricks.base.BricksBaseFragment;
import com.alibaba.pictures.bricks.bean.CouponOrderInfoBean;
import com.alibaba.pictures.bricks.bean.CouponRuleBean;
import com.alibaba.pictures.bricks.bean.CouponServiceRuleBean;
import com.alibaba.pictures.bricks.bean.FaqBean;
import com.alibaba.pictures.bricks.coupon.order.bean.GaiaXBean;
import com.alibaba.pictures.bricks.coupon.order.bean.Goods;
import com.alibaba.pictures.bricks.coupon.order.bean.GxRender;
import com.alibaba.pictures.bricks.coupon.order.bean.GxTemplate;
import com.alibaba.pictures.bricks.coupon.order.bean.Notice;
import com.alibaba.pictures.bricks.coupon.order.bean.NoticeItem;
import com.alibaba.pictures.bricks.coupon.order.bean.OrderDetail;
import com.alibaba.pictures.bricks.coupon.order.bean.ShopAndItemInfo;
import com.alibaba.pictures.bricks.coupon.order.bean.ShopDetailJson;
import com.alibaba.pictures.bricks.coupon.order.view.EmptyViewHolder;
import com.alibaba.pictures.bricks.coupon.order.view.GroupCouponsViewHolder;
import com.alibaba.pictures.bricks.coupon.order.view.NoticeViewHolder;
import com.alibaba.pictures.bricks.coupon.view.CouponInfoViewHolder;
import com.alibaba.pictures.bricks.coupon.view.CouponQuestionViewHolder;
import com.alibaba.pictures.bricks.coupon.view.CouponServiceRuleViewHolder;
import com.alibaba.pictures.bricks.gaiaxholder.GaiaXUtParamsGenerator;
import com.alibaba.pictures.bricks.gaiaxholder.RemoteNativeGaiaXViewHolder;
import com.alibaba.pictures.bricks.listener.OnItemListener;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.alient.oneservice.ut.TrackInfo;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.ap2;
import tb.b41;
import tb.k50;
import tb.lh0;
import tb.zn1;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class OrderDetailAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final C3514a Companion = new C3514a(null);
    public static final int FAQS = 7;
    public static final int GAIAX_UI = 9;
    public static final int GOODS = 3;
    public static final int NOTICE = 5;
    public static final int ORDER_INFO = 8;
    public static final int PAY_CARD = 1;
    public static final int RULE_CONTEXTS = 4;
    public static final int SHOP_AND_ITEM_INFO = 2;
    public static final int SHOP_DETAIL = 6;
    public static final int TIPS = 0;
    @NotNull
    private final Activity a;
    @Nullable
    private List<Object> b;
    @Nullable
    private OnItemListener<CouponRuleBean> c;
    @Nullable
    private OnItemListener<Notice> d;
    @Nullable
    private TrackInfo e;
    @Nullable
    private GaiaXUtParamsGenerator f;
    @Nullable
    private BricksBaseFragment g;

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.pictures.bricks.coupon.order.OrderDetailAdapter$a */
    /* loaded from: classes7.dex */
    public static final class C3514a {
        private C3514a() {
        }

        public /* synthetic */ C3514a(k50 k50Var) {
            this();
        }
    }

    public OrderDetailAdapter(@NotNull Activity activity) {
        b41.i(activity, "mContext");
        this.a = activity;
    }

    public final void a(@Nullable OrderDetail orderDetail, @NotNull TrackInfo trackInfo) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "301225994")) {
            ipChange.ipc$dispatch("301225994", new Object[]{this, orderDetail, trackInfo});
            return;
        }
        b41.i(trackInfo, "trackInfo");
        this.e = trackInfo;
        if (orderDetail != null) {
            ArrayList arrayList = new ArrayList();
            GaiaXBean validGaiaXBean = orderDetail.getValidGaiaXBean("damai_script_order_detail_header");
            if (validGaiaXBean != null) {
                arrayList.add(validGaiaXBean);
            }
            arrayList.add(orderDetail.getGoodsVO());
            JSONObject shopAndItemInfoVO = orderDetail.getShopAndItemInfoVO();
            if (shopAndItemInfoVO != null) {
                arrayList.add(new ShopAndItemInfo(shopAndItemInfoVO));
            }
            ArrayList<CouponServiceRuleBean> ruleContexts = orderDetail.getRuleContexts();
            if (!(ruleContexts == null || ruleContexts.isEmpty())) {
                arrayList.add(new CouponRuleBean(orderDetail.getRuleContexts(), orderDetail));
            }
            Notice noticeVO = orderDetail.getNoticeVO();
            if (noticeVO != null) {
                List<NoticeItem> noticeList = noticeVO.getNoticeList();
                if (!(noticeList == null || noticeList.isEmpty())) {
                    arrayList.add(noticeVO);
                }
            }
            GaiaXBean validGaiaXBean2 = orderDetail.getValidGaiaXBean("damai_script_play_apply_store");
            if (validGaiaXBean2 != null) {
                arrayList.add(validGaiaXBean2);
            }
            ArrayList<String> faqItems = orderDetail.getFaqItems();
            if (faqItems != null && !faqItems.isEmpty()) {
                z = false;
            }
            if (!z) {
                arrayList.add(new FaqBean(orderDetail.getFaqItems(), orderDetail));
            }
            CouponOrderInfoBean orderInfoVO = orderDetail.getOrderInfoVO();
            if (orderInfoVO != null) {
                arrayList.add(orderInfoVO);
            }
            this.b = arrayList;
            notifyDataSetChanged();
        }
    }

    public final void b(@Nullable BricksBaseFragment bricksBaseFragment) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "153556015")) {
            ipChange.ipc$dispatch("153556015", new Object[]{this, bricksBaseFragment});
        } else {
            this.g = bricksBaseFragment;
        }
    }

    public final void c(@Nullable GaiaXUtParamsGenerator gaiaXUtParamsGenerator) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1844925512")) {
            ipChange.ipc$dispatch("1844925512", new Object[]{this, gaiaXUtParamsGenerator});
        } else {
            this.f = gaiaXUtParamsGenerator;
        }
    }

    public final void d(@Nullable OnItemListener<Notice> onItemListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "205301480")) {
            ipChange.ipc$dispatch("205301480", new Object[]{this, onItemListener});
        } else {
            this.d = onItemListener;
        }
    }

    public final void e(@Nullable OnItemListener<CouponRuleBean> onItemListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1097381837")) {
            ipChange.ipc$dispatch("1097381837", new Object[]{this, onItemListener});
        } else {
            this.c = onItemListener;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2025938464")) {
            return ((Integer) ipChange.ipc$dispatch("2025938464", new Object[]{this})).intValue();
        }
        List<Object> list = this.b;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1597880121")) {
            return ((Integer) ipChange.ipc$dispatch("-1597880121", new Object[]{this, Integer.valueOf(i)})).intValue();
        }
        List<Object> list = this.b;
        Object obj = list != null ? list.get(i) : null;
        if (obj != null) {
            Class<?> cls = obj.getClass();
            if (b41.d(cls, Goods.class)) {
                return 3;
            }
            if (b41.d(cls, CouponOrderInfoBean.class)) {
                return 8;
            }
            if (b41.d(cls, FaqBean.class)) {
                return 7;
            }
            if (b41.d(cls, Notice.class)) {
                return 5;
            }
            if (b41.d(cls, CouponRuleBean.class)) {
                return 4;
            }
            if (b41.d(cls, ShopDetailJson.class)) {
                return 6;
            }
            if (b41.d(cls, GaiaXBean.class)) {
                return 9;
            }
        }
        return super.getItemViewType(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder viewHolder, int i) {
        GxTemplate gxTemplate;
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-407768359")) {
            ipChange.ipc$dispatch("-407768359", new Object[]{this, viewHolder, Integer.valueOf(i)});
            return;
        }
        b41.i(viewHolder, "holder");
        List<Object> list = this.b;
        Object obj = list != null ? list.get(i) : null;
        if (obj != null) {
            if (viewHolder instanceof GroupCouponsViewHolder) {
                TrackInfo trackInfo = this.e;
                if (trackInfo != null) {
                    ((GroupCouponsViewHolder) viewHolder).c((Goods) obj, trackInfo);
                }
            } else if (viewHolder instanceof CouponInfoViewHolder) {
                ((CouponInfoViewHolder) viewHolder).a((CouponOrderInfoBean) obj);
            } else if (viewHolder instanceof CouponQuestionViewHolder) {
                ((CouponQuestionViewHolder) viewHolder).b((FaqBean) obj, i);
            } else if (viewHolder instanceof NoticeViewHolder) {
                TrackInfo trackInfo2 = this.e;
                if (trackInfo2 != null) {
                    ((NoticeViewHolder) viewHolder).c((Notice) obj, zn1.a(trackInfo2));
                }
            } else if (viewHolder instanceof CouponServiceRuleViewHolder) {
                ((CouponServiceRuleViewHolder) viewHolder).c((CouponRuleBean) obj, i);
            } else if (obj instanceof GaiaXBean) {
                int i2 = DisplayMetrics.getwidthPixels(ap2.INSTANCE.b(this.a));
                RemoteNativeGaiaXViewHolder remoteNativeGaiaXViewHolder = (RemoteNativeGaiaXViewHolder) viewHolder;
                GaiaXBean gaiaXBean = (GaiaXBean) obj;
                List<GxRender> render = gaiaXBean.getRender();
                if (render != null && !render.isEmpty()) {
                    z = false;
                }
                if (z) {
                    return;
                }
                List<GxRender> render2 = gaiaXBean.getRender();
                GxRender gxRender = render2 != null ? render2.get(0) : null;
                if (gxRender == null || (gxTemplate = gxRender.getGxTemplate()) == null) {
                    return;
                }
                remoteNativeGaiaXViewHolder.c(gxTemplate, gaiaXBean.getData(), i2, i);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "75480893")) {
            return (RecyclerView.ViewHolder) ipChange.ipc$dispatch("75480893", new Object[]{this, viewGroup, Integer.valueOf(i)});
        }
        b41.i(viewGroup, "parent");
        switch (i) {
            case 3:
                View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.bricks_group_coupons_layout, viewGroup, false);
                b41.h(inflate, "from(parent.context)\n   …ns_layout, parent, false)");
                return new GroupCouponsViewHolder(inflate);
            case 4:
                return new CouponServiceRuleViewHolder(viewGroup, this.c);
            case 5:
                View inflate2 = LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.bricks_group_notices_layout, viewGroup, false);
                b41.h(inflate2, "from(parent.context)\n   …es_layout, parent, false)");
                return new NoticeViewHolder(inflate2, this.d);
            case 6:
            default:
                View inflate3 = LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.bricks_item_empty_layout, viewGroup, false);
                b41.h(inflate3, "from(parent.context)\n   …ty_layout, parent, false)");
                return new EmptyViewHolder(inflate3);
            case 7:
                return new CouponQuestionViewHolder(viewGroup, new lh0(this.a, this.g));
            case 8:
                return new CouponInfoViewHolder(viewGroup);
            case 9:
                return new RemoteNativeGaiaXViewHolder(this.a, this.f);
        }
    }
}
