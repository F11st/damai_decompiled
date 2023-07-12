package cn.damai.commonbusiness.contacts.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.R$string;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.cs;
import tb.m62;
import tb.t60;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class RealNameTipView extends LinearLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private CheckBox checkBox;
    private DMIconFontTextView icon;
    private TextView textView;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.contacts.view.RealNameTipView$a */
    /* loaded from: classes14.dex */
    public class C0632a extends ClickableSpan {
        private static transient /* synthetic */ IpChange $ipChange;

        C0632a() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NonNull View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1810385467")) {
                ipChange.ipc$dispatch("1810385467", new Object[]{this, view});
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("url", "https://m.damai.cn/damai/mine/audience-notice/index.html");
            DMNav.from(RealNameTipView.this.getContext()).withExtras(bundle).toUri(NavUri.b(cs.t));
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NonNull TextPaint textPaint) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1593415516")) {
                ipChange.ipc$dispatch("1593415516", new Object[]{this, textPaint});
                return;
            }
            super.updateDrawState(textPaint);
            textPaint.setColor(Color.parseColor("#ff1268"));
            textPaint.setUnderlineText(false);
        }
    }

    public RealNameTipView(Context context) {
        this(context, null);
    }

    private void initView(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "378019328")) {
            ipChange.ipc$dispatch("378019328", new Object[]{this, context});
            return;
        }
        setOrientation(0);
        setGravity(16);
        DMIconFontTextView dMIconFontTextView = new DMIconFontTextView(context);
        this.icon = dMIconFontTextView;
        dMIconFontTextView.setTextSize(1, 12.0f);
        this.icon.setTextColor(Color.parseColor("#CCCCCC"));
        this.icon.setText(getResources().getString(R$string.iconfont_tishimian_));
        addView(this.icon);
        CheckBox checkBox = new CheckBox(context);
        this.checkBox = checkBox;
        checkBox.setButtonDrawable((Drawable) null);
        this.checkBox.setBackgroundResource(R$drawable.common_business_check_circle_selector);
        int a = m62.a(context, 16.0f);
        this.checkBox.setLayoutParams(new LinearLayout.LayoutParams(a, a));
        addView(this.checkBox);
        updateIconVis(false);
        TextView textView = new TextView(context);
        this.textView = textView;
        textView.setPadding(t60.a(context, 3.0f), 0, 0, t60.a(context, 2.0f));
        this.textView.setTextSize(1, 12.0f);
        this.textView.setTextColor(Color.parseColor("#8890A0"));
        addView(this.textView);
    }

    public boolean getCheckState() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-522784654")) {
            return ((Boolean) ipChange.ipc$dispatch("-522784654", new Object[]{this})).booleanValue();
        }
        CheckBox checkBox = this.checkBox;
        if (checkBox == null || checkBox.getVisibility() != 0) {
            return false;
        }
        return this.checkBox.isChecked();
    }

    public void setText(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1202713038")) {
            ipChange.ipc$dispatch("-1202713038", new Object[]{this, str, str2});
        } else if (this.textView == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
        } else {
            int indexOf = str.indexOf(str2);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            spannableStringBuilder.setSpan(new C0632a(), indexOf, str2.length() + indexOf, 18);
            this.textView.setHighlightColor(0);
            this.textView.setMovementMethod(LinkMovementMethod.getInstance());
            this.textView.setText(spannableStringBuilder);
        }
    }

    public void updateCheckState(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1831339209")) {
            ipChange.ipc$dispatch("1831339209", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        CheckBox checkBox = this.checkBox;
        if (checkBox != null) {
            checkBox.setChecked(z);
        }
    }

    public void updateIconVis(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "197958693")) {
            ipChange.ipc$dispatch("197958693", new Object[]{this, Boolean.valueOf(z)});
        } else if (z) {
            this.checkBox.setVisibility(0);
            this.icon.setVisibility(8);
        } else {
            this.checkBox.setVisibility(8);
            this.icon.setVisibility(0);
        }
    }

    public RealNameTipView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RealNameTipView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView(context);
    }
}
