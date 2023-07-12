package com.alibaba.pictures.bricks.component.artist;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.alibaba.pictures.R$drawable;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.bricks.component.artist.bean.HistoryIPBean;
import com.alibaba.pictures.bricks.component.artist.bean.TextInfo;
import com.alibaba.pictures.bricks.view.DigitTextView;
import com.alient.onearch.adapter.view.BaseViewHolder;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.core.ItemValue;
import java.util.ArrayList;
import kotlin.collections.m;
import org.jetbrains.annotations.NotNull;
import tb.b41;
import tb.k62;
import tb.kg1;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class HistoryIPCardViewHolder extends BaseViewHolder<HistoryIPBean> {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private final ViewGroup mFansLayout;
    @NotNull
    private final ImageView mImg;
    @NotNull
    private final TextView mNameTv;
    @NotNull
    private final ViewGroup mSellLayout;
    @NotNull
    private final TextView mYearTv;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HistoryIPCardViewHolder(@NotNull View view) {
        super(view);
        b41.i(view, "itemView");
        View findViewById = view.findViewById(R$id.id_artist_history_ip_img);
        b41.h(findViewById, "itemView.findViewById<Im…id_artist_history_ip_img)");
        this.mImg = (ImageView) findViewById;
        View findViewById2 = view.findViewById(R$id.id_artist_history_ip_name);
        b41.h(findViewById2, "itemView.findViewById<Te…d_artist_history_ip_name)");
        TextView textView = (TextView) findViewById2;
        this.mNameTv = textView;
        View findViewById3 = view.findViewById(R$id.id_artist_history_ip_sell_layout);
        b41.h(findViewById3, "itemView.findViewById<Vi…t_history_ip_sell_layout)");
        this.mSellLayout = (ViewGroup) findViewById3;
        View findViewById4 = view.findViewById(R$id.id_artist_history_ip_fans_layout);
        b41.h(findViewById4, "itemView.findViewById<Vi…t_history_ip_fans_layout)");
        this.mFansLayout = (ViewGroup) findViewById4;
        View findViewById5 = view.findViewById(R$id.id_artist_history_ip_year);
        b41.h(findViewById5, "itemView.findViewById<Te…d_artist_history_ip_year)");
        TextView textView2 = (TextView) findViewById5;
        this.mYearTv = textView2;
        textView2.getPaint().setFakeBoldText(true);
        textView.getPaint().setFakeBoldText(true);
    }

    private final void addTextView(TextInfo textInfo, ViewGroup viewGroup) {
        TextView textView;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1923170146")) {
            ipChange.ipc$dispatch("-1923170146", new Object[]{this, textInfo, viewGroup});
        } else if (textInfo != null) {
            if (textInfo.isNumStyle()) {
                textView = new DigitTextView(this.itemView.getContext(), null, 0, 6, null);
                textView.setTextColor(Color.parseColor("#2E333E"));
                textView.setTextSize(1, 14.0f);
            } else {
                textView = new TextView(this.itemView.getContext());
                textView.setTextColor(Color.parseColor("#5F6672"));
                textView.setTextSize(1, 12.0f);
            }
            textView.setLines(1);
            textView.setEllipsize(TextUtils.TruncateAt.END);
            textView.setText(textInfo.value);
            ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
            marginLayoutParams.rightMargin = k62.a(this.itemView.getContext(), 2.0f);
            textView.setLayoutParams(marginLayoutParams);
            viewGroup.addView(textView);
        }
    }

    @Override // com.alient.onearch.adapter.view.BaseViewHolder
    public void bindData(@NotNull IItem<ItemValue> iItem) {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "1535909434")) {
            ipChange.ipc$dispatch("1535909434", new Object[]{this, iItem});
            return;
        }
        b41.i(iItem, "item");
        this.mNameTv.setText(getValue().name);
        this.mYearTv.setText(getValue().year);
        kg1 j = kg1.Companion.a(this.itemView.getContext()).j(getValue().headPic);
        int i2 = R$drawable.bricks_uikit_default_image_bg_gradient;
        j.e(i2).n(i2).g(this.mImg);
        this.mSellLayout.removeAllViews();
        this.mFansLayout.removeAllViews();
        ArrayList<TextInfo> arrayList = getValue().fansCountInfoList;
        if (arrayList != null) {
            for (TextInfo textInfo : arrayList) {
                addTextView(textInfo, this.mFansLayout);
            }
        }
        ArrayList<ArrayList<TextInfo>> arrayList2 = getValue().tourInfoList;
        if (arrayList2 != null) {
            int size = arrayList2.size();
            for (Object obj : arrayList2) {
                int i3 = i + 1;
                if (i < 0) {
                    m.p();
                }
                ArrayList<TextInfo> arrayList3 = (ArrayList) obj;
                if (arrayList3 != null) {
                    b41.h(arrayList3, "textInfos");
                    for (TextInfo textInfo2 : arrayList3) {
                        addTextView(textInfo2, this.mSellLayout);
                    }
                }
                if (i < size - 1) {
                    View view = new View(this.itemView.getContext());
                    int a = k62.a(this.itemView.getContext(), 12.0f);
                    int a2 = k62.a(this.itemView.getContext(), 4.0f);
                    ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(1, a);
                    marginLayoutParams.leftMargin = a2;
                    marginLayoutParams.rightMargin = a2;
                    view.setLayoutParams(marginLayoutParams);
                    view.setBackgroundColor(Color.parseColor("#E9EBEF"));
                    this.mSellLayout.addView(view);
                }
                i = i3;
            }
        }
    }
}
