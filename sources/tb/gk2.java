package tb;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.RelativeSizeSpan;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.taobao.android.dinamicx.widget.DXTextViewWidgetNode;
import com.taobao.android.dinamicx.widget.DXWidgetNode;
import com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class gk2 extends DXTextViewWidgetNode {
    private CharSequence v;
    private CharSequence w;
    private float x = 0.625f;
    private float y = 1.0f;
    private float z = 0.625f;
    public static final String NAME = "tdTradePriceView";
    public static final long DX_WIDGET_ID = iz.a(NAME);
    private static final long A = iz.a("richText");
    private static final long B = iz.a("price");
    private static final long C = iz.a("symbolScale");
    private static final long D = iz.a("decimalScale");

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public static class a implements IDXBuilderWidgetNode {
        @Override // com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode
        public DXWidgetNode build(@Nullable Object obj) {
            return new gk2();
        }
    }

    private CharSequence w(CharSequence charSequence) {
        if (charSequence instanceof SpannableString) {
            return charSequence;
        }
        if (charSequence != null) {
            String charSequence2 = charSequence.toString();
            int indexOf = charSequence2.indexOf(46);
            SpannableString spannableString = new SpannableString(charSequence2);
            int x = x(charSequence2);
            try {
                spannableString.setSpan(new RelativeSizeSpan(this.x), 0, x, 33);
                int length = charSequence2.length();
                if (indexOf < 0) {
                    spannableString.setSpan(new RelativeSizeSpan(this.y), x, length, 33);
                } else {
                    spannableString.setSpan(new RelativeSizeSpan(this.y), x, indexOf, 33);
                    spannableString.setSpan(new RelativeSizeSpan(this.z), indexOf, length, 33);
                }
                return spannableString;
            } catch (Throwable unused) {
                return charSequence2;
            }
        }
        return "";
    }

    private int x(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (Character.isDigit(charArray[i])) {
                return i;
            }
        }
        return 0;
    }

    @Override // com.taobao.android.dinamicx.widget.DXTextViewWidgetNode, com.taobao.android.dinamicx.widget.DXWidgetNode, com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode
    public DXWidgetNode build(@Nullable Object obj) {
        return new gk2();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXTextViewWidgetNode
    public void h(TextView textView) {
        super.h(textView);
        if (!TextUtils.isEmpty(this.v)) {
            textView.setText(this.v);
        } else if (TextUtils.isEmpty(this.w)) {
        } else {
            CharSequence w = w(this.w);
            this.w = w;
            textView.setText(w);
        }
    }

    @Override // com.taobao.android.dinamicx.widget.DXTextViewWidgetNode, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onClone(DXWidgetNode dXWidgetNode, boolean z) {
        super.onClone(dXWidgetNode, z);
        if (dXWidgetNode instanceof gk2) {
            gk2 gk2Var = (gk2) dXWidgetNode;
            this.v = gk2Var.v;
            this.w = gk2Var.w;
            this.x = gk2Var.x;
            this.z = gk2Var.z;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXTextViewWidgetNode, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onRenderView(Context context, View view) {
        super.onRenderView(context, view);
        if (view instanceof TextView) {
            TextView textView = (TextView) view;
            if (!TextUtils.isEmpty(this.v)) {
                textView.setText(this.v);
            } else if (TextUtils.isEmpty(this.w)) {
            } else {
                CharSequence w = w(this.w);
                this.w = w;
                textView.setText(w);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXTextViewWidgetNode, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetDoubleAttribute(long j, double d) {
        super.onSetDoubleAttribute(j, d);
        if (C == j) {
            this.x = (float) d;
        } else if (D == j) {
            this.z = (float) d;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetObjAttribute(long j, Object obj) {
        super.onSetObjAttribute(j, obj);
        if (A == j) {
            if (obj instanceof CharSequence) {
                this.v = (CharSequence) obj;
            } else {
                this.v = "";
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXTextViewWidgetNode, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetStringAttribute(long j, String str) {
        super.onSetStringAttribute(j, str);
        if (B == j) {
            this.w = str;
        }
    }
}
