package cn.damai.search.component.script;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import androidx.annotation.ColorInt;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import cn.damai.commonbusiness.R$color;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import io.flutter.wpkbridge.WPKFactory;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.jvm.JvmOverloads;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.k50;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public final class HighlightTextView extends AppCompatTextView {
    private static transient /* synthetic */ IpChange $ipChange;
    @ColorInt
    @Nullable
    private Integer highlightColor;
    private int index;
    @Nullable
    private ArrayList<String> keyWords;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public HighlightTextView(@NotNull Context context) {
        this(context, null, 2, null);
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
    }

    public /* synthetic */ HighlightTextView(Context context, AttributeSet attributeSet, int i, k50 k50Var) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    private final void doHighlight() {
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "2111018892")) {
            ipChange.ipc$dispatch("2111018892", new Object[]{this});
            return;
        }
        CharSequence text = getText();
        if (text == null || text.length() == 0) {
            return;
        }
        ArrayList<String> arrayList = this.keyWords;
        if ((arrayList == null || arrayList.isEmpty()) ? true : true) {
            return;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(getText());
        ArrayList<String> arrayList2 = this.keyWords;
        if (arrayList2 != null) {
            for (String str : arrayList2) {
                try {
                    Matcher matcher = Pattern.compile(str).matcher(getText());
                    while (matcher.find()) {
                        int start = matcher.start();
                        this.index = start;
                        if (start == -1) {
                            break;
                        } else if (start >= 0) {
                            Context context = getContext();
                            Integer num = this.highlightColor;
                            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(ContextCompat.getColor(context, num != null ? num.intValue() : R$color.color_FF2D79));
                            int i = this.index;
                            spannableStringBuilder.setSpan(foregroundColorSpan, i, str.length() + i, 18);
                        }
                    }
                } catch (Exception unused) {
                }
            }
        }
        setText(spannableStringBuilder);
    }

    @Override // android.widget.TextView
    @Nullable
    public final Integer getHighlightColor() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1153472105") ? (Integer) ipChange.ipc$dispatch("-1153472105", new Object[]{this}) : this.highlightColor;
    }

    public final void setHighlightColor(@Nullable Integer num) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-819809005")) {
            ipChange.ipc$dispatch("-819809005", new Object[]{this, num});
        } else {
            this.highlightColor = num;
        }
    }

    public final void setText(@Nullable String str, @Nullable ArrayList<String> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-498584102")) {
            ipChange.ipc$dispatch("-498584102", new Object[]{this, str, arrayList});
            return;
        }
        setText(str);
        this.keyWords = arrayList;
        doHighlight();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public HighlightTextView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
    }
}
