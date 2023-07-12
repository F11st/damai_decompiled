package cn.damai.tetris.util;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;
import cn.damai.commonbusiness.R$color;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class ColorTextUtil {
    private static transient /* synthetic */ IpChange $ipChange;

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public interface OnColorTextClickListener {
        void onColorTextClick(View view);
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.tetris.util.ColorTextUtil$a */
    /* loaded from: classes16.dex */
    public class C2005a extends ClickableSpan {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ Context a;
        final /* synthetic */ int b;
        final /* synthetic */ OnColorTextClickListener c;

        C2005a(Context context, int i, OnColorTextClickListener onColorTextClickListener) {
            this.a = context;
            this.b = i;
            this.c = onColorTextClickListener;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-633261325")) {
                ipChange.ipc$dispatch("-633261325", new Object[]{this, view});
                return;
            }
            OnColorTextClickListener onColorTextClickListener = this.c;
            if (onColorTextClickListener != null) {
                onColorTextClickListener.onColorTextClick(view);
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1438816676")) {
                ipChange.ipc$dispatch("1438816676", new Object[]{this, textPaint});
                return;
            }
            super.updateDrawState(textPaint);
            textPaint.setColor(this.a.getResources().getColor(this.b));
            textPaint.setUnderlineText(false);
        }
    }

    public static void a(@NonNull TextView textView, String str, @ColorRes int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-254399748")) {
            ipChange.ipc$dispatch("-254399748", new Object[]{textView, str, Integer.valueOf(i)});
        } else {
            b(textView, str, i, null);
        }
    }

    public static void b(@NonNull TextView textView, String str, @ColorRes int i, OnColorTextClickListener onColorTextClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1565544630")) {
            ipChange.ipc$dispatch("1565544630", new Object[]{textView, str, Integer.valueOf(i), onColorTextClickListener});
        } else {
            c(textView, textView.getText().toString().trim(), str, i, onColorTextClickListener);
        }
    }

    public static void c(TextView textView, String str, String str2, @ColorRes int i, OnColorTextClickListener onColorTextClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "737227916")) {
            ipChange.ipc$dispatch("737227916", new Object[]{textView, str, str2, Integer.valueOf(i), onColorTextClickListener});
            return;
        }
        Log.i("ColorTextUtil", "allTextStr: " + str);
        Log.i("ColorTextUtil", "colorTextStr: " + str2);
        if (!str.contains(str2)) {
            Log.e("ColorTextUtil", str + "  不包含  " + str2 + "  文字!!!!");
            return;
        }
        Context context = textView.getContext();
        int indexOf = str.indexOf(str2);
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new C2005a(context, i, onColorTextClickListener), indexOf, str2.length() + indexOf, 33);
        textView.setHighlightColor(context.getResources().getColor(R$color.transparent));
        textView.setText(spannableString);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
