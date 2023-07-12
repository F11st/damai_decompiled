package cn.damai.trade.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import cn.damai.trade.R$id;
import cn.damai.trade.R$layout;
import cn.damai.trade.R$styleable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class AutoHideTextView extends FrameLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private String mTitle;
    private TextView mTvContent;
    private TextView mTvTitle;

    public AutoHideTextView(@NonNull Context context) {
        super(context);
    }

    private String getTitle(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1632522660")) {
            return (String) ipChange.ipc$dispatch("-1632522660", new Object[]{this, str});
        }
        return str + "：";
    }

    private void initView(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2046612927")) {
            ipChange.ipc$dispatch("-2046612927", new Object[]{this, context});
            return;
        }
        LayoutInflater.from(context).inflate(R$layout.auto_hide_view, this);
        this.mTvTitle = (TextView) findViewById(R$id.tv_title);
        this.mTvContent = (TextView) findViewById(R$id.tv_content);
    }

    public void setContent(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1803472113")) {
            ipChange.ipc$dispatch("-1803472113", new Object[]{this, str});
            return;
        }
        if (TextUtils.isEmpty(this.mTitle)) {
            setVisibility(8);
        }
        this.mTvTitle.setText(getTitle(this.mTitle));
        if (TextUtils.isEmpty(str)) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.mTvContent.setText(str);
    }

    public void setData(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1256706026")) {
            ipChange.ipc$dispatch("-1256706026", new Object[]{this, str, str2});
        } else if (TextUtils.isEmpty(str)) {
            setVisibility(8);
        } else {
            setContent(str2);
            this.mTitle = str;
            this.mTvTitle.setText(getTitle(str));
        }
    }

    public AutoHideTextView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AutoHideTextView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.AutoHideTextView);
        this.mTitle = obtainStyledAttributes.getString(R$styleable.AutoHideTextView_title_text);
        obtainStyledAttributes.recycle();
        initView(context);
    }
}
