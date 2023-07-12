package cn.damai.seat.helper;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.discover.viewholder.BaseViewHolder;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.PriceLevel;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.biz.SubPrice;
import cn.damai.commonbusiness.seatbiz.sku.qilin.bean.Tag;
import cn.damai.seat.R$id;
import cn.damai.seat.R$layout;
import cn.damai.seat.bean.biz.Price;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.c23;
import tb.cb2;
import tb.f92;
import tb.g92;
import tb.m62;
import tb.r92;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class SeatPriceListPanel extends a {
    private static transient /* synthetic */ IpChange $ipChange;
    private View b;
    private HorizontalScrollView c;
    private LinearLayout d;
    private LinearLayout e;
    private int f;
    private int g;
    private g92 h;
    private List<? extends PriceLevel> i;
    private PriceLevel j;
    private ViewHolder k;
    private OnPriceClickListener l;
    private boolean m;
    private boolean n;

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public interface OnPriceClickListener {
        void onPriceClick(@NonNull PriceLevel priceLevel, int i);
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public class ViewHolder extends BaseViewHolder<PriceLevel> implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        private TextView a;
        private TextView b;
        private TextView c;
        private View d;
        private PriceLevel e;
        private int f;

        public ViewHolder(View view) {
            super(view);
            this.a = (TextView) view.findViewById(R$id.price_icon_combine_text);
            this.b = (TextView) view.findViewById(R$id.price_text);
            this.c = (TextView) view.findViewById(R$id.price_tag);
            this.d = view.findViewById(R$id.price_text_div);
        }

        @Override // cn.damai.commonbusiness.discover.viewholder.BaseViewHolder
        /* renamed from: c */
        public void a(PriceLevel priceLevel, int i) {
            int parseColor;
            String showPriceText;
            Tag tag;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "669458212")) {
                ipChange.ipc$dispatch("669458212", new Object[]{this, priceLevel, Integer.valueOf(i)});
                return;
            }
            this.e = priceLevel;
            this.f = i;
            boolean isSalable = priceLevel.isSalable();
            boolean z = SeatPriceListPanel.this.j == priceLevel;
            this.itemView.setSelected(z);
            if (z) {
                SeatPriceListPanel.this.k = this;
            }
            if (z) {
                parseColor = -16777216;
                showPriceText = priceLevel.getPriceTitle();
            } else {
                parseColor = Color.parseColor("#666666");
                showPriceText = priceLevel.getShowPriceText();
            }
            if (!isSalable) {
                parseColor = Color.parseColor("#CCCCCC");
            }
            this.b.setText(showPriceText);
            this.b.setTextColor(parseColor);
            String str = null;
            if ((priceLevel instanceof Price) && (tag = ((Price) priceLevel).promotionTag) != null) {
                str = tag.tagDesc;
            }
            boolean z2 = !TextUtils.isEmpty(str);
            this.c.setVisibility(z2 ? 0 : 8);
            this.d.setVisibility(z2 ? 8 : 0);
            if (z2) {
                this.c.setText(str);
            }
            SeatPriceListPanel seatPriceListPanel = SeatPriceListPanel.this;
            this.a.setText(seatPriceListPanel.k(priceLevel, seatPriceListPanel.h));
            this.itemView.setOnClickListener(this);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-807549081")) {
                ipChange.ipc$dispatch("-807549081", new Object[]{this, view});
            } else if (r92.c() || this.e == null || SeatPriceListPanel.this.l == null || !SeatPriceListPanel.this.a()) {
            } else {
                if (this.e.isSalable()) {
                    SeatPriceListPanel.this.l.onPriceClick(this.e, this.f);
                } else {
                    ToastUtil.a().e(SeatPriceListPanel.this.a, "该票档当前不可售");
                }
            }
        }
    }

    public SeatPriceListPanel(Activity activity, View view, OnPriceClickListener onPriceClickListener) {
        super(activity);
        this.m = true;
        this.l = onPriceClickListener;
        this.b = view;
        this.c = (HorizontalScrollView) view.findViewById(R$id.price_scroll_view);
        this.e = (LinearLayout) this.b.findViewById(R$id.price_list_1_layout);
        this.d = (LinearLayout) this.b.findViewById(R$id.price_list_2_layout);
        this.f = m62.a(activity, 3.0f);
        this.g = m62.a(activity, 12.0f);
    }

    private void i(ViewGroup viewGroup, List<? extends PriceLevel> list, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1591163492")) {
            ipChange.ipc$dispatch("1591163492", new Object[]{this, viewGroup, list, Integer.valueOf(i)});
        } else if (cb2.d(list)) {
            viewGroup.removeAllViews();
        } else {
            int size = list.size();
            int childCount = viewGroup.getChildCount();
            if (childCount > size) {
                while (size < childCount) {
                    View childAt = viewGroup.getChildAt(0);
                    if (childAt != null) {
                        viewGroup.removeView(childAt);
                    }
                    size++;
                }
            } else if (childCount < size) {
                int i2 = size - childCount;
                for (int i3 = 0; i3 < i2; i3++) {
                    View inflate = LayoutInflater.from(this.a).inflate(R$layout.item_seat_price_level_new, viewGroup, false);
                    ViewGroup.LayoutParams layoutParams = inflate.getLayoutParams();
                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                        int i4 = this.f;
                        marginLayoutParams.rightMargin = i4;
                        marginLayoutParams.leftMargin = i4;
                    }
                    inflate.setTag(new ViewHolder(inflate));
                    viewGroup.addView(inflate);
                }
            }
            for (int i5 = 0; i5 < list.size(); i5++) {
                PriceLevel priceLevel = list.get(i5);
                View childAt2 = viewGroup.getChildAt(i5);
                if (childAt2 != null) {
                    Object tag = childAt2.getTag();
                    if (tag instanceof ViewHolder) {
                        ((ViewHolder) tag).a(priceLevel, i);
                        i++;
                    }
                }
            }
        }
    }

    private void j(List<? extends PriceLevel> list) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-1468991424")) {
            ipChange.ipc$dispatch("-1468991424", new Object[]{this, list});
        } else if (this.m) {
            this.m = false;
            this.n = (wh2.e(list) <= 4 || !f92.x(list)) ? false : false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CharSequence k(PriceLevel priceLevel, g92 g92Var) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "514935325")) {
            return (CharSequence) ipChange.ipc$dispatch("514935325", new Object[]{this, priceLevel, g92Var});
        }
        if (priceLevel == null || g92Var == null || !a()) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (priceLevel.isSinglePrice()) {
            spannableStringBuilder.append((CharSequence) l(priceLevel.colorInt(), false));
        } else {
            List<SubPrice> subPriceList = priceLevel.getSubPriceList();
            boolean isTaoPiao = priceLevel.isTaoPiao();
            if (!cb2.d(subPriceList)) {
                int size = subPriceList.size();
                int i = 0;
                boolean z = false;
                while (i < size) {
                    SubPrice subPrice = subPriceList.get(i);
                    int colorInt = subPrice.colorInt();
                    boolean z2 = i == 0;
                    boolean z3 = i == size + (-1);
                    if (subPrice.count >= 4) {
                        SpannableStringBuilder l = l(colorInt, isTaoPiao);
                        if (!z2 && !z) {
                            spannableStringBuilder.append((CharSequence) " +");
                        }
                        spannableStringBuilder.append((CharSequence) l).append((CharSequence) " x").append((CharSequence) String.valueOf(subPrice.count));
                        if (!z3) {
                            spannableStringBuilder.append((CharSequence) " +");
                            z = true;
                        }
                    } else {
                        for (int i2 = 0; i2 < subPrice.count; i2++) {
                            spannableStringBuilder.append((CharSequence) l(colorInt, isTaoPiao));
                        }
                        z = false;
                    }
                    i++;
                }
            }
        }
        return spannableStringBuilder;
    }

    private SpannableStringBuilder l(int i, boolean z) {
        Bitmap a;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "496042638")) {
            return (SpannableStringBuilder) ipChange.ipc$dispatch("496042638", new Object[]{this, Integer.valueOf(i), Boolean.valueOf(z)});
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(" proxy");
        if (z) {
            a = this.h.a(i, 0.0f, (byte) 12, false);
        } else {
            a = this.h.a(i, 0.0f, (byte) 10, false);
        }
        Activity activity = this.a;
        int i2 = this.g;
        spannableStringBuilder.setSpan(new c23(activity, a, i2, i2), 1, 6, 17);
        return spannableStringBuilder;
    }

    public void m() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-25937666")) {
            ipChange.ipc$dispatch("-25937666", new Object[]{this});
            return;
        }
        HorizontalScrollView horizontalScrollView = this.c;
        if (horizontalScrollView == null || this.j == null) {
            return;
        }
        horizontalScrollView.post(new Runnable() { // from class: cn.damai.seat.helper.SeatPriceListPanel.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // java.lang.Runnable
            public void run() {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-271828223")) {
                    ipChange2.ipc$dispatch("-271828223", new Object[]{this});
                } else if (!SeatPriceListPanel.this.a() || SeatPriceListPanel.this.c == null || SeatPriceListPanel.this.j == null || SeatPriceListPanel.this.k == null) {
                } else {
                    View view = SeatPriceListPanel.this.k.itemView;
                    int width = view.getWidth();
                    int width2 = SeatPriceListPanel.this.c.getWidth();
                    if (width2 <= 0 || width <= 0) {
                        return;
                    }
                    int left = view.getLeft();
                    int right = view.getRight();
                    int scrollX = SeatPriceListPanel.this.c.getScrollX();
                    int i = left - scrollX;
                    int i2 = right - scrollX;
                    if (width >= width2) {
                        SeatPriceListPanel.this.c.smoothScrollBy(i, 0);
                    } else if (i < 0) {
                        SeatPriceListPanel.this.c.smoothScrollBy(i, 0);
                    } else if (i2 > width2) {
                        SeatPriceListPanel.this.c.smoothScrollBy(i2 - width2, 0);
                    }
                }
            }
        });
    }

    public void n(PriceLevel priceLevel) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "692068500")) {
            ipChange.ipc$dispatch("692068500", new Object[]{this, priceLevel});
        } else {
            o(this.i, this.h, priceLevel);
        }
    }

    public void o(List<? extends PriceLevel> list, g92 g92Var, PriceLevel priceLevel) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-994365028")) {
            ipChange.ipc$dispatch("-994365028", new Object[]{this, list, g92Var, priceLevel});
            return;
        }
        this.i = list;
        this.j = priceLevel;
        this.h = g92Var;
        j(list);
        if (this.n) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            this.d.setVisibility(0);
            if (!cb2.d(list)) {
                for (PriceLevel priceLevel2 : list) {
                    if (priceLevel2.isSinglePrice()) {
                        arrayList.add(priceLevel2);
                    } else {
                        arrayList2.add(priceLevel2);
                    }
                }
            }
            int e = wh2.e(arrayList);
            i(this.e, arrayList, 0);
            i(this.d, arrayList2, e);
        } else {
            i(this.e, list, 0);
            this.d.setVisibility(8);
        }
        if (priceLevel != null) {
            m();
        }
    }
}
