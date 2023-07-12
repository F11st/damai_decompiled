package cn.damai.trade.newtradeorder.ui.projectdetail.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import cn.damai.trade.R$color;
import cn.damai.trade.R$drawable;
import cn.damai.trade.R$id;
import cn.damai.trade.R$layout;
import cn.damai.trade.R$string;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class SubscribeButton extends LinearLayout {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int STATUS_SUBSCRIBED = 1;
    public static final int STATUS_UNSUBSCRIBE = 0;
    private Context mContext;
    private String mSubscribeContent;
    private DMIconFontTextView mSubscribeIcon;
    private FrameLayout mSubscribeIconLayout;
    private LinearLayout mSubscribeLayout;
    private ProgressBar mSubscribeProgress;
    private TextView mSubscribeText;
    private String mUnSubscribeContent;

    public SubscribeButton(Context context) {
        this(context, null);
    }

    private void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1044498912")) {
            ipChange.ipc$dispatch("-1044498912", new Object[]{this});
            return;
        }
        View inflate = LayoutInflater.from(getContext()).inflate(R$layout.project_detail_subscribe_button, (ViewGroup) this, false);
        this.mSubscribeLayout = (LinearLayout) inflate.findViewById(R$id.ll_subscibe_bg);
        this.mSubscribeIconLayout = (FrameLayout) inflate.findViewById(R$id.art_subscribe_icon_layout);
        this.mSubscribeIcon = (DMIconFontTextView) inflate.findViewById(R$id.art_subscribe_add_icon);
        this.mSubscribeProgress = (ProgressBar) inflate.findViewById(R$id.art_subscribe_progress);
        this.mSubscribeText = (TextView) inflate.findViewById(R$id.art_subscribe_text);
        addView(inflate);
    }

    public void setIconColor(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2140666806")) {
            ipChange.ipc$dispatch("2140666806", new Object[]{this, Integer.valueOf(i)});
        } else if (i > 0) {
            this.mSubscribeIcon.setTextColor(ContextCompat.getColor(this.mContext, i));
        } else {
            this.mSubscribeIcon.setTextColor(ContextCompat.getColor(this.mContext, R$color.main_color));
        }
    }

    public void setSubscriBackground(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1358187231")) {
            ipChange.ipc$dispatch("-1358187231", new Object[]{this, Integer.valueOf(i)});
        } else if (i > 0) {
            this.mSubscribeLayout.setBackgroundResource(i);
        } else {
            this.mSubscribeLayout.setBackgroundResource(R$drawable.project_detail_subscibe_button_bg);
        }
    }

    public void setSubscribeProgress(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1524159075")) {
            ipChange.ipc$dispatch("1524159075", new Object[]{this, Integer.valueOf(i)});
        } else if (i > 0) {
            this.mSubscribeProgress.setIndeterminateDrawable(ContextCompat.getDrawable(this.mContext, i));
        } else {
            this.mSubscribeProgress.setIndeterminateDrawable(ContextCompat.getDrawable(this.mContext, R$drawable.project_detail_subscribe_loading_bg));
        }
    }

    public void setSubscribeStatus(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2143553624")) {
            ipChange.ipc$dispatch("-2143553624", new Object[]{this, Integer.valueOf(i)});
        } else if (i == 0) {
            setText(this.mUnSubscribeContent);
            this.mSubscribeText.setSelected(false);
            this.mSubscribeLayout.setSelected(false);
            this.mSubscribeIconLayout.setVisibility(0);
        } else if (i == 1) {
            setText(this.mSubscribeContent);
            this.mSubscribeText.setSelected(true);
            this.mSubscribeIconLayout.setVisibility(8);
            this.mSubscribeLayout.setSelected(true);
        }
    }

    public void setSubscribedStyle(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "24766880")) {
            ipChange.ipc$dispatch("24766880", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
        }
    }

    public void setText(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "545796624")) {
            ipChange.ipc$dispatch("545796624", new Object[]{this, str});
        } else {
            this.mSubscribeText.setText(str);
        }
    }

    public void setTextColor(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1000374910")) {
            ipChange.ipc$dispatch("-1000374910", new Object[]{this, Integer.valueOf(i)});
        } else if (i > 0) {
            this.mSubscribeText.setTextColor(ContextCompat.getColor(this.mContext, i));
        } else {
            this.mSubscribeText.setTextColor(ContextCompat.getColor(this.mContext, R$color.main_color));
        }
    }

    public void setTextContent(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1501261983")) {
            ipChange.ipc$dispatch("1501261983", new Object[]{this, str, str2});
            return;
        }
        this.mSubscribeContent = str;
        this.mUnSubscribeContent = str2;
    }

    public void startProgress() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-394808890")) {
            ipChange.ipc$dispatch("-394808890", new Object[]{this});
            return;
        }
        this.mSubscribeProgress.setVisibility(0);
        this.mSubscribeIcon.setVisibility(4);
    }

    public void stoProgress() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "586659962")) {
            ipChange.ipc$dispatch("586659962", new Object[]{this});
            return;
        }
        this.mSubscribeProgress.setVisibility(4);
        this.mSubscribeIcon.setVisibility(0);
    }

    public SubscribeButton(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SubscribeButton(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        this.mSubscribeContent = getResources().getString(R$string.str_project_detail_followed);
        this.mUnSubscribeContent = getResources().getString(R$string.str_project_detail_follow);
        initView();
    }
}
