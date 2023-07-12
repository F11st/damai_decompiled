package cn.damai.commonbusiness.share.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class ShareExtendView extends LinearLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private DMIconFontTextView mExtendViewIcon;
    private ImageView mExtendViewImage;
    private TextView mExtendViewText;
    private RelativeLayout mIconFontBackground;

    public ShareExtendView(Context context) {
        super(context);
        initView(context);
    }

    private void initView(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1770017637")) {
            ipChange.ipc$dispatch("-1770017637", new Object[]{this, context});
            return;
        }
        View inflate = LayoutInflater.from(context).inflate(R$layout.share_ext_item, this);
        this.mIconFontBackground = (RelativeLayout) inflate.findViewById(R$id.share_item_bg);
        this.mExtendViewIcon = (DMIconFontTextView) inflate.findViewById(R$id.share_item_iconfont);
        this.mExtendViewImage = (ImageView) inflate.findViewById(R$id.share_item_image);
        this.mExtendViewText = (TextView) inflate.findViewById(R$id.share_item_text);
    }

    public TextView getExtendTextView() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "495330650") ? (TextView) ipChange.ipc$dispatch("495330650", new Object[]{this}) : this.mExtendViewText;
    }

    public DMIconFontTextView getExtendViewIcon() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1430308951") ? (DMIconFontTextView) ipChange.ipc$dispatch("-1430308951", new Object[]{this}) : this.mExtendViewIcon;
    }

    public ImageView getExtendViewImage() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1196756268") ? (ImageView) ipChange.ipc$dispatch("-1196756268", new Object[]{this}) : this.mExtendViewImage;
    }

    public RelativeLayout getIconFontBackgroundView() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1668657543") ? (RelativeLayout) ipChange.ipc$dispatch("1668657543", new Object[]{this}) : this.mIconFontBackground;
    }

    public LinearLayout getShareItemLayout() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1555544589") ? (LinearLayout) ipChange.ipc$dispatch("-1555544589", new Object[]{this}) : this;
    }

    public void setExtendViewIcon(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1725986869")) {
            ipChange.ipc$dispatch("1725986869", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        DMIconFontTextView dMIconFontTextView = this.mExtendViewIcon;
        if (dMIconFontTextView != null) {
            dMIconFontTextView.setText(getResources().getString(i));
        }
    }

    public void setExtendViewImage(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1765920325")) {
            ipChange.ipc$dispatch("-1765920325", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        ImageView imageView = this.mExtendViewImage;
        if (imageView != null) {
            imageView.setImageResource(i);
        }
        RelativeLayout relativeLayout = this.mIconFontBackground;
        if (relativeLayout != null) {
            relativeLayout.setBackgroundDrawable(null);
        }
        DMIconFontTextView dMIconFontTextView = this.mExtendViewIcon;
        if (dMIconFontTextView != null) {
            dMIconFontTextView.setVisibility(8);
        }
    }

    public void setExtendViewText(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1589976740")) {
            ipChange.ipc$dispatch("1589976740", new Object[]{this, str});
            return;
        }
        TextView textView = this.mExtendViewText;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void setIconFontBackground(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "952629107")) {
            ipChange.ipc$dispatch("952629107", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        RelativeLayout relativeLayout = this.mIconFontBackground;
        if (relativeLayout != null) {
            relativeLayout.setBackgroundResource(i);
        }
    }

    public ShareExtendView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        initView(context);
    }

    public ShareExtendView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView(context);
    }
}
