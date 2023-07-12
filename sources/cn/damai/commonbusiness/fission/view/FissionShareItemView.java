package cn.damai.commonbusiness.fission.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.R$styleable;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class FissionShareItemView extends LinearLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context context;
    private String desc;
    private String iconfont;
    private View partent;
    private TextView tvShareDesc;
    private DMIconFontTextView tvShareIcon;

    public FissionShareItemView(Context context) {
        this(context, null);
    }

    private GradientDrawable gradienCircle(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1374472279")) {
            return (GradientDrawable) ipChange.ipc$dispatch("1374472279", new Object[]{this, Integer.valueOf(i)});
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i);
        gradientDrawable.setShape(1);
        return gradientDrawable;
    }

    private void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1142713967")) {
            ipChange.ipc$dispatch("-1142713967", new Object[]{this});
            return;
        }
        View inflate = LayoutInflater.from(this.context).inflate(R$layout.commonbusiness_fission_share_layout, this);
        this.partent = inflate;
        this.tvShareIcon = (DMIconFontTextView) inflate.findViewById(R$id.share_icon);
        this.tvShareDesc = (TextView) this.partent.findViewById(R$id.share_icon_desc);
        if (!TextUtils.isEmpty(this.iconfont)) {
            this.tvShareIcon.setText(this.iconfont);
        }
        if (TextUtils.isEmpty(this.desc)) {
            return;
        }
        this.tvShareDesc.setText(this.desc);
    }

    public void setListener(View.OnClickListener onClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1485261995")) {
            ipChange.ipc$dispatch("1485261995", new Object[]{this, onClickListener});
        } else {
            setOnClickListener(onClickListener);
        }
    }

    public void update(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "24272454")) {
            ipChange.ipc$dispatch("24272454", new Object[]{this, Integer.valueOf(i)});
        } else if (Build.VERSION.SDK_INT >= 16) {
            this.tvShareIcon.setBackground(gradienCircle(i));
        } else {
            this.tvShareIcon.setBackgroundDrawable(gradienCircle(i));
        }
    }

    public FissionShareItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FissionShareItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.context = context;
        setOrientation(1);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.fissionAttrs);
        if (obtainStyledAttributes != null) {
            this.iconfont = obtainStyledAttributes.getString(R$styleable.fissionAttrs_iconfont);
            this.desc = obtainStyledAttributes.getString(R$styleable.fissionAttrs_desc);
            obtainStyledAttributes.recycle();
        }
        initView();
    }
}
