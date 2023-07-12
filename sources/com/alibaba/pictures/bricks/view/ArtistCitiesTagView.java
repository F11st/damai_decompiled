package com.alibaba.pictures.bricks.view;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.alibaba.pictures.R$color;
import com.alibaba.pictures.bricks.bean.BaseArtistDataMo;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.google.android.flexbox.FlexboxLayout;
import com.taobao.weex.ui.component.list.template.TemplateDom;
import java.util.List;
import kotlin.collections.C8214m;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.wt2;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class ArtistCitiesTagView extends FlexboxLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private final Context mContext;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArtistCitiesTagView(@NotNull Context context, @NotNull AttributeSet attributeSet) {
        super(context, attributeSet);
        b41.i(context, "mContext");
        b41.i(attributeSet, TemplateDom.KEY_ATTRS);
        this.mContext = context;
        setFlexDirection(0);
        setJustifyContent(0);
        setFlexWrap(1);
    }

    private final TextView mCitiesTagFactory(List<? extends BaseArtistDataMo> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "263469803")) {
            return (TextView) ipChange.ipc$dispatch("263469803", new Object[]{this, list});
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("");
        for (BaseArtistDataMo baseArtistDataMo : list) {
            if (baseArtistDataMo != null) {
                String str = baseArtistDataMo.value;
                if (str == null) {
                    str = "";
                } else {
                    b41.h(str, "it.value ?: \"\"");
                }
                spannableStringBuilder.append((CharSequence) str);
                if (baseArtistDataMo.valueType == BaseArtistDataMo.ValueType.NUM) {
                    spannableStringBuilder.setSpan(new StyleSpan(1), spannableStringBuilder.length() - baseArtistDataMo.value.length(), spannableStringBuilder.length(), 33);
                }
            }
        }
        TextView textView = new TextView(this.mContext);
        textView.setText(spannableStringBuilder);
        textView.setTextSize(1, 12.0f);
        textView.setTextColor(this.mContext.getResources().getColor(R$color.cg_1));
        return textView;
    }

    @NotNull
    public final Context getMContext() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2124980660") ? (Context) ipChange.ipc$dispatch("-2124980660", new Object[]{this}) : this.mContext;
    }

    public final void setCitiesView(@Nullable List<? extends List<? extends BaseArtistDataMo>> list) {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "384856557")) {
            ipChange.ipc$dispatch("384856557", new Object[]{this, list});
            return;
        }
        removeAllViews();
        if (list == null || list.isEmpty()) {
            return;
        }
        for (Object obj : list) {
            int i2 = i + 1;
            if (i < 0) {
                C8214m.p();
            }
            List<? extends BaseArtistDataMo> list2 = (List) obj;
            if (!list2.isEmpty()) {
                TextView mCitiesTagFactory = mCitiesTagFactory(list2);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                layoutParams.topMargin = (int) TypedValue.applyDimension(1, 3.0f, this.mContext.getResources().getDisplayMetrics());
                wt2 wt2Var = wt2.INSTANCE;
                addView(mCitiesTagFactory, layoutParams);
                if (i < list.size() - 1) {
                    TextView textView = new TextView(this.mContext);
                    textView.setText(" | ");
                    textView.setTextSize(1, 12.0f);
                    textView.setTextColor(Color.parseColor("#E9EBEF"));
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams2.topMargin = (int) TypedValue.applyDimension(1, 3.0f, this.mContext.getResources().getDisplayMetrics());
                    addView(textView, layoutParams2);
                }
            }
            i = i2;
        }
    }

    public final void setNoCitiesView(@NotNull String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1140858747")) {
            ipChange.ipc$dispatch("-1140858747", new Object[]{this, str});
            return;
        }
        b41.i(str, "mCitiesText");
        removeAllViews();
        TextView textView = new TextView(this.mContext);
        textView.setText(str);
        textView.setTextSize(1, 12.0f);
        textView.setTextColor(this.mContext.getResources().getColor(R$color.cg_1));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = (int) TypedValue.applyDimension(1, 3.0f, this.mContext.getResources().getDisplayMetrics());
        wt2 wt2Var = wt2.INSTANCE;
        addView(textView, layoutParams);
    }
}
