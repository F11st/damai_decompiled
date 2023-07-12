package cn.damai.uikit.view;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import cn.damai.uikit.R$id;
import cn.damai.uikit.R$layout;
import cn.damai.uikit.R$string;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import cn.damai.uikit.view.DMProtocolDialogTextItemView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.q60;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class DMProtocolDialogTextItemView extends FrameLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private Boolean isCheck;
    private LinearLayout mContainerLL;
    private Context mContent;
    private DMIconFontTextView mIconCheck;
    private String mProtocolLink;
    private TextView mTvContent;
    private View.OnClickListener onClickListener;

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public class a extends ClickableSpan {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ String a;
        final /* synthetic */ String b;

        a(String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "775121891")) {
                ipChange.ipc$dispatch("775121891", new Object[]{this, view});
            } else if (DMProtocolDialogTextItemView.this.onClickListener != null) {
                DMProtocolDialogTextItemView.this.onClickListener.onClick(view);
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NonNull TextPaint textPaint) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1088919884")) {
                ipChange.ipc$dispatch("-1088919884", new Object[]{this, textPaint});
                return;
            }
            textPaint.setColor(Color.parseColor(TextUtils.isEmpty(this.a) ? this.b : this.a));
            textPaint.setUnderlineText(true);
        }
    }

    public DMProtocolDialogTextItemView(@NonNull Context context) {
        super(context);
    }

    private void initView(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2042086744")) {
            ipChange.ipc$dispatch("2042086744", new Object[]{this, context});
            return;
        }
        LayoutInflater.from(context).inflate(R$layout.damai_protocol_dialog_text_item, this);
        this.mIconCheck = (DMIconFontTextView) findViewById(R$id.icon_check);
        this.mTvContent = (TextView) findViewById(R$id.tv_content);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setData$0(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1421041112")) {
            ipChange.ipc$dispatch("-1421041112", new Object[]{this, view});
            return;
        }
        Boolean valueOf = Boolean.valueOf(!this.isCheck.booleanValue());
        this.isCheck = valueOf;
        this.mIconCheck.setText(valueOf.booleanValue() ? R$string.iconfont_gouxuanxuanzhong28 : R$string.iconfont_gouxuanweixuanzhong28);
    }

    public int getDataLine() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1095060420") ? ((Integer) ipChange.ipc$dispatch("1095060420", new Object[]{this})).intValue() : this.mTvContent.getLineCount();
    }

    public Boolean getIsCheck() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1130037722") ? (Boolean) ipChange.ipc$dispatch("1130037722", new Object[]{this}) : this.isCheck;
    }

    public String getProtocolLink() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "79329251") ? (String) ipChange.ipc$dispatch("79329251", new Object[]{this}) : this.mProtocolLink;
    }

    public void setContent(String str, String str2, String str3, String str4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1665230198")) {
            ipChange.ipc$dispatch("1665230198", new Object[]{this, str, str2, str3, str4});
        } else if (TextUtils.isEmpty(str)) {
            setVisibility(4);
            this.mTvContent.setText(" ");
        } else {
            setVisibility(0);
            setContentColor(str2);
            if (TextUtils.isEmpty(str3)) {
                this.mTvContent.setText(str);
                return;
            }
            String str5 = "《" + str3 + "》";
            int length = str.length();
            int length2 = str.length() + str5.length();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str + str5);
            spannableStringBuilder.setSpan(new a(str4, str2), length, length2, 33);
            this.mTvContent.setMovementMethod(LinkMovementMethod.getInstance());
            this.mTvContent.setText(spannableStringBuilder);
            this.mTvContent.setHighlightColor(Color.parseColor("#00000000"));
        }
    }

    public void setContentColor(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "637136547")) {
            ipChange.ipc$dispatch("637136547", new Object[]{this, str});
        } else if (TextUtils.isEmpty(str)) {
        } else {
            this.mIconCheck.setTextColor(Color.parseColor(str));
            this.mTvContent.setTextColor(Color.parseColor(str));
        }
    }

    public void setData(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "658301795")) {
            ipChange.ipc$dispatch("658301795", new Object[]{this, str});
        } else {
            setData(str, null, false, null, null, null);
        }
    }

    public void setProtocolClick(View.OnClickListener onClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1879334974")) {
            ipChange.ipc$dispatch("-1879334974", new Object[]{this, onClickListener});
        } else {
            this.onClickListener = onClickListener;
        }
    }

    public DMProtocolDialogTextItemView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setData(String str, String str2, boolean z, String str3, String str4, String str5) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "61570213")) {
            ipChange.ipc$dispatch("61570213", new Object[]{this, str, str2, Boolean.valueOf(z), str3, str4, str5});
            return;
        }
        this.mIconCheck.setVisibility(z ? 0 : 8);
        if (z) {
            this.isCheck = Boolean.FALSE;
            this.mTvContent.setMaxLines(2);
            this.mIconCheck.setOnClickListener(new View.OnClickListener() { // from class: tb.gs
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DMProtocolDialogTextItemView.this.lambda$setData$0(view);
                }
            });
        } else {
            this.mTvContent.setMaxLines(1);
            int a2 = q60.a(this.mContent, 24.5f);
            this.mTvContent.setPadding(a2, 0, a2, 0);
        }
        this.mProtocolLink = str5;
        setContent(str, str2, str3, str4);
    }

    public DMProtocolDialogTextItemView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContent = context;
        initView(context);
    }
}
