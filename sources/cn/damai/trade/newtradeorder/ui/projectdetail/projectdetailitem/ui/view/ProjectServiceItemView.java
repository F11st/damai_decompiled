package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import cn.damai.trade.R$id;
import cn.damai.trade.R$layout;
import cn.damai.trade.R$string;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class ProjectServiceItemView extends LinearLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private TextView mTvSupportContent;
    private DMIconFontTextView mTvSupportIndicator;

    public ProjectServiceItemView(Context context) {
        super(context);
        init();
    }

    private void init() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1562149423")) {
            ipChange.ipc$dispatch("1562149423", new Object[]{this});
            return;
        }
        LayoutInflater.from(getContext()).inflate(R$layout.project_item_support_service_item_layout, this);
        this.mTvSupportIndicator = (DMIconFontTextView) findViewById(R$id.project_support_indicator_iv);
        this.mTvSupportContent = (TextView) findViewById(R$id.project_support_content_tv);
    }

    public void setSupported(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1318326041")) {
            ipChange.ipc$dispatch("-1318326041", new Object[]{this, str, str2});
            return;
        }
        if ("true".equals(str)) {
            this.mTvSupportIndicator.setText(getResources().getString(R$string.iconfont_dagou12));
        } else {
            this.mTvSupportIndicator.setText(getResources().getString(R$string.iconfont_dacha12));
        }
        this.mTvSupportContent.setText(str2);
    }

    public ProjectServiceItemView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public ProjectServiceItemView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }
}
