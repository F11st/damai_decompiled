package cn.damai.uikit.tag;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import cn.damai.uikit.R$id;
import cn.damai.uikit.R$layout;
import cn.damai.uikit.R$styleable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.l62;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class DMPeopleSeeTagView extends FrameLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context mContext;
    private TextView mNumName;
    private TextView mNumTip;
    private String mPostFix;

    public DMPeopleSeeTagView(@NonNull Context context) {
        this(context, null);
    }

    private void initView(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1282692129")) {
            ipChange.ipc$dispatch("-1282692129", new Object[]{this, context});
            return;
        }
        LayoutInflater.from(context).inflate(R$layout.people_see_tags_layout, this);
        setPadding(0, l62.a(this.mContext, 6.0f), l62.a(this.mContext, 3.0f), 0);
        this.mNumName = (TextView) findViewById(R$id.tv_num);
        this.mNumTip = (TextView) findViewById(R$id.tv_num_tip);
    }

    public DMPeopleSeeTagView setPeopleNum(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-686886774")) {
            return (DMPeopleSeeTagView) ipChange.ipc$dispatch("-686886774", new Object[]{this, Integer.valueOf(i)});
        }
        if (this.mNumName == null || this.mNumTip == null || i == 0) {
            setVisibility(8);
            return this;
        }
        if (i > 0) {
            String str = "";
            if (i >= 10000) {
                try {
                    String valueOf = String.valueOf(((int) ((i / 10000.0f) * 10.0f)) / 10.0f);
                    if (valueOf.endsWith("0")) {
                        valueOf = valueOf.substring(0, valueOf.length() - 2);
                    }
                    str = valueOf + "万";
                } catch (Exception unused) {
                }
            } else {
                str = i + "";
            }
            this.mNumName.setText(str);
            this.mNumTip.setText(this.mPostFix);
        }
        return this;
    }

    public DMPeopleSeeTagView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DMPeopleSeeTagView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.DMPeopleSeeTagView);
        String string = obtainStyledAttributes.getString(R$styleable.DMPeopleSeeTagView_pst_tip_postfix);
        this.mPostFix = string;
        if (TextUtils.isEmpty(string)) {
            this.mPostFix = "人想看";
        }
        obtainStyledAttributes.recycle();
        this.mContext = context;
        initView(context);
    }
}
