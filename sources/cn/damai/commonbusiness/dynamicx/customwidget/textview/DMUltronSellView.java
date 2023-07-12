package cn.damai.commonbusiness.dynamicx.customwidget.textview;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import cn.damai.commonbusiness.R$color;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.m62;
import tb.ny1;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class DMUltronSellView extends FrameLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context mContext;
    private TextView mTvItemName;
    private TextView mTvSellDesc;

    public DMUltronSellView(@NonNull Context context) {
        this(context, null);
    }

    private void initView(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1186464764")) {
            ipChange.ipc$dispatch("1186464764", new Object[]{this, context});
            return;
        }
        this.mContext = context;
        View inflate = LayoutInflater.from(context).inflate(R$layout.layout_ultron_sell_desc, this);
        this.mTvItemName = (TextView) inflate.findViewById(R$id.text_name);
        this.mTvSellDesc = (TextView) inflate.findViewById(R$id.tv_mark);
    }

    public void setItemSellDesc(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "585821957")) {
            ipChange.ipc$dispatch("585821957", new Object[]{this, str, str2});
        } else if (TextUtils.isEmpty(str2)) {
            this.mTvItemName.setText(str);
            this.mTvSellDesc.setVisibility(8);
        } else {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str2 + str);
            Context context = this.mContext;
            int i = R$color.color_white;
            spannableStringBuilder.setSpan(new ny1(ContextCompat.getColor(context, i), ContextCompat.getColor(this.mContext, i), m62.a(this.mContext, 12.0f)), 0, str2.length(), 17);
            this.mTvItemName.setText(spannableStringBuilder);
            this.mTvSellDesc.setText(str2);
            this.mTvSellDesc.setVisibility(0);
        }
    }

    public DMUltronSellView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DMUltronSellView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView(context);
    }
}
