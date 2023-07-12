package cn.damai.homepage.v2.feed;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.homepage.R$id;
import cn.damai.homepage.bean.WaterFlowRecommendItem;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.alient.onearch.adapter.pom.OneArchConstants;
import com.alient.onearch.adapter.view.BaseViewHolder;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.core.ItemValue;
import com.youku.resource.widget.YKActionSheet;
import java.util.List;
import tb.cs;
import tb.t60;
import tb.ux0;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class WaterFlowCategoryViewHolder extends BaseViewHolder<WaterFlowRecommendItem> {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context mContext;
    private TextView mFirstKeyword;
    private LinearLayout mFirstKeywordLayout;
    private TextView mFourthKeyword;
    private LinearLayout mFourthKeywordLayout;
    private View.OnClickListener mOnClickListener;
    private TextView mSecondKeyword;
    private LinearLayout mSecondKeywordLayout;
    private TextView mSubtitle;
    private TextView mThirdKeyword;
    private LinearLayout mThirdKeywordLayout;
    private TextView mTitle;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.homepage.v2.feed.WaterFlowCategoryViewHolder$a */
    /* loaded from: classes14.dex */
    public class View$OnClickListenerC1261a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC1261a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-895817685")) {
                ipChange.ipc$dispatch("-895817685", new Object[]{this, view});
                return;
            }
            WaterFlowRecommendItem waterFlowRecommendItem = (WaterFlowRecommendItem) view.getTag();
            int id = view.getId();
            if (id == R$id.homepage_waterflow_category_first_keyword_layout) {
                str = waterFlowRecommendItem.hotwords.get(0);
            } else if (id == R$id.homepage_waterflow_category_second_keyword_layout) {
                str = waterFlowRecommendItem.hotwords.get(1);
            } else if (id == R$id.homepage_waterflow_category_third_keyword_layout) {
                str = waterFlowRecommendItem.hotwords.get(2);
            } else {
                str = id == R$id.homepage_waterflow_category_fourth_keyword_layout ? waterFlowRecommendItem.hotwords.get(3) : "";
            }
            ux0.i().m(ux0.g(WaterFlowCategoryViewHolder.this.getComponentActions()), "", waterFlowRecommendItem.alg, waterFlowRecommendItem.scm, waterFlowRecommendItem.cardType, "", WaterFlowCategoryViewHolder.this.getData().getIndex());
            Bundle bundle = new Bundle();
            bundle.putString("autowords", str);
            bundle.putString(OneArchConstants.LayoutKey.KEY_WORDS, str);
            bundle.putString(YKActionSheet.ACTION_STYLE_DESCRIBE, str);
            bundle.putString("keyType", "home_feed");
            DMNav.from(WaterFlowCategoryViewHolder.this.mContext).withExtras(bundle).toUri(NavUri.b(cs.o));
        }
    }

    public WaterFlowCategoryViewHolder(View view) {
        super(view);
        this.mOnClickListener = new View$OnClickListenerC1261a();
        this.mContext = view.getContext();
        this.mTitle = (TextView) this.itemView.findViewById(R$id.homepage_waterflow_category_title);
        this.mSubtitle = (TextView) this.itemView.findViewById(R$id.homepage_waterflow_category_subtitle);
        this.mFirstKeywordLayout = (LinearLayout) this.itemView.findViewById(R$id.homepage_waterflow_category_first_keyword_layout);
        this.mFirstKeyword = (TextView) this.itemView.findViewById(R$id.homepage_waterflow_category_first_keyword);
        this.mSecondKeywordLayout = (LinearLayout) this.itemView.findViewById(R$id.homepage_waterflow_category_second_keyword_layout);
        this.mSecondKeyword = (TextView) this.itemView.findViewById(R$id.homepage_waterflow_category_second_keyword);
        this.mThirdKeywordLayout = (LinearLayout) this.itemView.findViewById(R$id.homepage_waterflow_category_third_keyword_layout);
        this.mThirdKeyword = (TextView) this.itemView.findViewById(R$id.homepage_waterflow_category_third_keyword);
        this.mFourthKeywordLayout = (LinearLayout) this.itemView.findViewById(R$id.homepage_waterflow_category_fourth_keyword_layout);
        this.mFourthKeyword = (TextView) this.itemView.findViewById(R$id.homepage_waterflow_category_fourth_keyword);
        this.mFirstKeywordLayout.setOnClickListener(this.mOnClickListener);
        this.mSecondKeywordLayout.setOnClickListener(this.mOnClickListener);
        this.mThirdKeywordLayout.setOnClickListener(this.mOnClickListener);
        this.mFourthKeywordLayout.setOnClickListener(this.mOnClickListener);
        this.itemView.setLayoutParams(new ViewGroup.LayoutParams(-1, ((int) ((((((DisplayMetrics.getwidthPixels(t60.b(this.mContext)) - t60.a(this.mContext, 30.0f)) / 2) - t60.a(this.mContext, 12.0f)) * 233) * 1.0f) / 160.5d)) + t60.a(this.mContext, 20.0f)));
    }

    @Override // com.alient.onearch.adapter.view.BaseViewHolder
    public void bindData(@NonNull IItem<ItemValue> iItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1438208044")) {
            ipChange.ipc$dispatch("1438208044", new Object[]{this, iItem});
        } else {
            handleView(getValue());
        }
    }

    public void handleView(WaterFlowRecommendItem waterFlowRecommendItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-427866978")) {
            ipChange.ipc$dispatch("-427866978", new Object[]{this, waterFlowRecommendItem});
        } else if (waterFlowRecommendItem != null) {
            this.mTitle.setText(waterFlowRecommendItem.title);
            this.mSubtitle.setText(waterFlowRecommendItem.subTitle);
            List<String> list = waterFlowRecommendItem.hotwords;
            int e = wh2.e(list);
            for (int i = 0; i < e; i++) {
                if (TextUtils.isEmpty(list.get(0))) {
                    list.remove(i);
                }
            }
            String str = "";
            int e2 = wh2.e(list);
            if (e2 >= 1) {
                this.mFirstKeywordLayout.setVisibility(0);
                this.mFirstKeyword.setText(list.get(0));
                this.mFirstKeywordLayout.setTag(waterFlowRecommendItem);
                str = "" + list.get(0);
            }
            if (e2 >= 2) {
                this.mSecondKeywordLayout.setVisibility(0);
                this.mSecondKeyword.setText(list.get(1));
                this.mSecondKeywordLayout.setTag(waterFlowRecommendItem);
                str = (str + "&") + list.get(1);
            }
            if (e2 >= 3) {
                this.mThirdKeywordLayout.setVisibility(0);
                this.mThirdKeyword.setText(list.get(2));
                this.mThirdKeywordLayout.setTag(waterFlowRecommendItem);
                str = (str + "&") + list.get(2);
            } else {
                this.mThirdKeywordLayout.setVisibility(8);
            }
            if (e2 >= 4) {
                this.mFourthKeywordLayout.setVisibility(0);
                this.mFourthKeyword.setText(list.get(3));
                this.mFourthKeywordLayout.setTag(waterFlowRecommendItem);
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append("&");
                list.get(3);
            } else {
                this.mFourthKeywordLayout.setVisibility(8);
            }
            ux0.i().k(ux0.g(getComponentActions()), this.itemView, "", waterFlowRecommendItem.alg, waterFlowRecommendItem.scm, waterFlowRecommendItem.cardType, "", getData().getIndex());
        }
    }
}
