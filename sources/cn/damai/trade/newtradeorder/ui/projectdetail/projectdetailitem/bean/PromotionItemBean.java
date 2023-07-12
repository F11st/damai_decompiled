package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import cn.damai.commonbusiness.search.bean.MarketTagBean;
import cn.damai.trade.R$drawable;
import cn.damai.trade.R$id;
import cn.damai.trade.R$layout;
import cn.damai.uikit.flowlayout.FlowLayout;
import cn.damai.uikit.tag.DMCommonTagView;
import cn.damai.uikit.tag.DMTagType;
import com.alipay.mobile.bqcscanservice.BQCScanEngine;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.util.DisplayUtil;
import java.io.Serializable;
import java.util.List;
import tb.cb2;
import tb.t60;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class PromotionItemBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public List<MarketTagBean> contentList;
    public String desc;
    public String tag;
    public String type;

    private void addTags(ViewGroup viewGroup, FlowLayout flowLayout) {
        FlowLayout.LayoutParams layoutParams;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "675541556")) {
            ipChange.ipc$dispatch("675541556", new Object[]{this, viewGroup, flowLayout});
            return;
        }
        for (MarketTagBean marketTagBean : this.contentList) {
            if (isVip()) {
                DMCommonTagView addMarketTagView = marketTagBean.addMarketTagView(flowLayout, false);
                addMarketTagView.setTagType(DMTagType.TAG_TYPE_NEWPROMOTION_VIP);
                layoutParams = (FlowLayout.LayoutParams) addMarketTagView.getLayoutParams();
                addMarketTagView.adjustTagHeight(false);
                addMarketTagView.setPadding(0, 0, 0, 0);
            } else {
                TextView colorTextTag = getColorTextTag(marketTagBean, viewGroup.getContext());
                flowLayout.addView(colorTextTag);
                layoutParams = (FlowLayout.LayoutParams) colorTextTag.getLayoutParams();
                ((ViewGroup.MarginLayoutParams) layoutParams).height = t60.a(viewGroup.getContext(), 15.0f);
            }
            layoutParams.setMarginEnd(t60.a(viewGroup.getContext(), 3.0f));
            layoutParams.setMargins(0, 0, 0, t60.a(viewGroup.getContext(), 2.5f));
        }
    }

    private TextView getColorTextTag(MarketTagBean marketTagBean, Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1496408207")) {
            return (TextView) ipChange.ipc$dispatch("1496408207", new Object[]{this, marketTagBean, context});
        }
        TextView textView = new TextView(context);
        textView.setTextSize(1, 10.0f);
        textView.setTextColor(Color.parseColor("#FF4886"));
        textView.setGravity(17);
        textView.setBackground(context.getResources().getDrawable(R$drawable.common_promotion_tagview_tradetag));
        textView.setPadding(t60.a(context, 2.0f), 0, t60.a(context, 2.0f), 0);
        textView.setText(marketTagBean.tag);
        return textView;
    }

    private TextView getTextTag(String str, Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1023340794")) {
            return (TextView) ipChange.ipc$dispatch("-1023340794", new Object[]{this, str, context});
        }
        TextView textView = new TextView(context);
        textView.setTextSize(1, 12.0f);
        textView.setTextColor(Color.parseColor("#5F6672"));
        textView.setText(str);
        textView.setLineSpacing(t60.a(context, 4.0f), 1.0f);
        return textView;
    }

    public View addTagView(ViewGroup viewGroup, int[] iArr) {
        int i;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1425384532")) {
            return (View) ipChange.ipc$dispatch("1425384532", new Object[]{this, viewGroup, iArr});
        }
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.header_project_marketing_list_itemcell, viewGroup, false);
        if (iArr.length == 4) {
            inflate.setPadding(iArr[0], iArr[1], iArr[2], iArr[3]);
        }
        TextView textView = (TextView) inflate.findViewById(R$id.item_seat_promotion_tag);
        textView.setText(this.tag);
        if (isVip()) {
            textView.setBackgroundResource(R$drawable.bricks_common_promotion_tagview_bg_vip_new);
        } else if (isWednesdayDiscount()) {
            textView.setBackgroundResource(R$drawable.bricks_common_promotion_tagview_wednesday_discount);
            textView.getLayoutParams().height = DisplayUtil.dip2px(inflate.getContext(), 14.0f);
            try {
                i = (textView.getLayoutParams().height * textView.getBackground().getIntrinsicWidth()) / textView.getBackground().getIntrinsicHeight();
            } catch (Exception e) {
                e.printStackTrace();
                i = 0;
            }
            if (i > 0) {
                textView.getLayoutParams().width = i;
            }
            inflate.setPadding(0, 0, 0, 0);
            textView.setPadding(0, 0, 0, 0);
            textView.setText("");
        } else {
            textView.setBackgroundResource(R$drawable.bricks_common_promotion_tagview_bg);
        }
        FlowLayout flowLayout = (FlowLayout) inflate.findViewById(R$id.sub_tag_ll);
        flowLayout.removeAllViews();
        if (!cb2.d(this.contentList)) {
            addTags(viewGroup, flowLayout);
        } else if (!TextUtils.isEmpty(this.desc)) {
            flowLayout.addView(getTextTag(this.desc, viewGroup.getContext()));
        }
        viewGroup.addView(inflate);
        return inflate;
    }

    public boolean hasCoupon() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-314662325") ? ((Boolean) ipChange.ipc$dispatch("-314662325", new Object[]{this})).booleanValue() : isVip() || BQCScanEngine.COUPON_ENGINE.equalsIgnoreCase(this.type);
    }

    public boolean isVip() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1599431880") ? ((Boolean) ipChange.ipc$dispatch("-1599431880", new Object[]{this})).booleanValue() : "vip".equalsIgnoreCase(this.type);
    }

    public boolean isWednesdayDiscount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1583284574") ? ((Boolean) ipChange.ipc$dispatch("1583284574", new Object[]{this})).booleanValue() : "WED_HALF_PRICE".equals(this.type);
    }
}
