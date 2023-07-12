package com.alibaba.android.ultron.trade.dinamicX.constructor;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.RelativeSizeSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.taobao.android.dinamic.constructor.DTextViewConstructor;
import java.util.ArrayList;
import java.util.Map;
import tb.v80;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class TradePriceViewConstructor extends DTextViewConstructor {
    private static final String D_DECIMAL_SCALE = "dDecimalScale";
    private static final String D_PRICE = "dPrice";
    private static final String D_RICH_TEXT = "dRichText";
    private static final String D_SYMBOL_SCALE = "dSymbolScale";
    private static final String D_TEXT = "dText";
    private static final float PRICE_DECIMAL_PROPORTION = 0.625f;
    private static final float PRICE_INTEGER_PROPORTION = 1.0f;
    private static final float PRICE_SYMBOL_PROPORTION = 0.625f;
    public static final String VIEW_TAG = "TradePriceView";

    private int getNumberStartIndex(String str) {
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

    private float getScale(Object obj, float f) {
        if (obj != null && !TextUtils.isEmpty(obj.toString())) {
            try {
                return Float.valueOf(obj.toString()).floatValue();
            } catch (Throwable unused) {
            }
        }
        return f;
    }

    private void setPrice(TextView textView, Object obj, float f, float f2, float f3) {
        if (textView == null) {
            return;
        }
        if (obj != null) {
            String obj2 = obj.toString();
            int indexOf = obj2.indexOf(46);
            SpannableString spannableString = new SpannableString(obj2);
            int numberStartIndex = getNumberStartIndex(obj2);
            try {
                spannableString.setSpan(new RelativeSizeSpan(f), 0, numberStartIndex, 33);
                int length = obj2.length();
                if (indexOf < 0) {
                    spannableString.setSpan(new RelativeSizeSpan(f2), numberStartIndex, length, 33);
                } else {
                    spannableString.setSpan(new RelativeSizeSpan(f2), numberStartIndex, indexOf, 33);
                    spannableString.setSpan(new RelativeSizeSpan(f3), indexOf, length, 33);
                }
                setTextInternal(textView, spannableString);
                return;
            } catch (Throwable unused) {
                setTextInternal(textView, obj2);
                return;
            }
        }
        setTextInternal(textView, "");
    }

    private void setTextInternal(TextView textView, CharSequence charSequence) {
        if (textView == null || charSequence == null) {
            return;
        }
        textView.setText(charSequence);
    }

    @Override // com.taobao.android.dinamic.constructor.DTextViewConstructor, com.taobao.android.dinamic.dinamic.DinamicViewAdvancedConstructor
    public View initializeView(String str, Context context, AttributeSet attributeSet) {
        return new TextView(context, attributeSet);
    }

    @Override // com.taobao.android.dinamic.constructor.DTextViewConstructor, com.taobao.android.dinamic.dinamic.DinamicViewAdvancedConstructor
    public void setAttributes(View view, Map<String, Object> map, ArrayList<String> arrayList, v80 v80Var) {
        super.setAttributes(view, map, arrayList, v80Var);
        TextView textView = view instanceof TextView ? (TextView) view : null;
        if (arrayList.contains(D_RICH_TEXT)) {
            Object obj = map.get(D_RICH_TEXT);
            if (obj instanceof CharSequence) {
                setTextInternal(textView, (CharSequence) obj);
            } else {
                setTextInternal(textView, "");
            }
        } else if (!arrayList.contains(D_PRICE) && !arrayList.contains(D_SYMBOL_SCALE) && !arrayList.contains(D_DECIMAL_SCALE)) {
            if (arrayList.contains("dText")) {
                Object obj2 = map.get("dText");
                if (obj2 != null) {
                    setTextInternal(textView, obj2.toString());
                } else {
                    setTextInternal(textView, "");
                }
            }
        } else {
            setPrice(textView, map.get(D_PRICE), getScale(map.get(D_SYMBOL_SCALE), 0.625f), 1.0f, getScale(map.get(D_DECIMAL_SCALE), 0.625f));
        }
    }

    @Override // com.taobao.android.dinamic.constructor.DTextViewConstructor
    public void setText(TextView textView, String str) {
    }
}
