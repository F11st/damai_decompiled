package com.taobao.android.dinamic.constructor;

import android.content.Context;
import android.graphics.Typeface;
import android.text.InputFilter;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import com.taobao.android.dinamic.dinamic.DinamicViewAdvancedConstructor;
import com.taobao.android.dinamic.property.DAttrConstant;
import com.taobao.weex.common.Constants;
import com.youku.arch.v3.data.Constants;
import java.util.ArrayList;
import java.util.Map;
import tb.im1;
import tb.oq;
import tb.p62;
import tb.v80;
import tb.x21;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class DTextInputConstructor extends DinamicViewAdvancedConstructor {
    public static final int DEFAULT_TEXT_COLOR = -16777216;
    public static final String TAG = "DTextInputConstructor";

    private void setBackground(EditText editText, String str) {
        editText.setBackgroundColor(oq.d(str, -16777216));
    }

    private void setHintColor(EditText editText, String str) {
        editText.setHintTextColor(oq.d(str, -16777216));
    }

    private void setKeyBoardType(EditText editText, String str) {
        if (TextUtils.isEmpty(str)) {
            editText.setInputType(1);
            return;
        }
        int intValue = Integer.valueOf(str).intValue();
        if (intValue == 0) {
            editText.setInputType(1);
        } else if (intValue == 1) {
            editText.setInputType(2);
        } else if (intValue == 2) {
            editText.setInputType(3);
        } else if (intValue != 3) {
            editText.setInputType(1);
        } else {
            editText.setInputType(128);
        }
    }

    private void setMaxLength(EditText editText, String str) {
        if (TextUtils.isEmpty(str)) {
            editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(Integer.MAX_VALUE)});
            return;
        }
        Integer valueOf = Integer.valueOf(str);
        if (valueOf.intValue() <= 0) {
            editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(Integer.MAX_VALUE)});
        } else {
            editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(valueOf.intValue())});
        }
    }

    @Override // com.taobao.android.dinamic.dinamic.DinamicViewAdvancedConstructor
    public void applyDefaultProperty(View view, Map<String, Object> map, v80 v80Var) {
        super.applyDefaultProperty(view, map, v80Var);
        EditText editText = (EditText) view;
        editText.setLines(1);
        editText.setSingleLine();
        editText.setImeOptions(6);
        if (!map.containsKey(DAttrConstant.TV_TEXT_SIZE)) {
            editText.setTextSize(1, 12.0f);
        }
        if (!map.containsKey(DAttrConstant.TV_TEXT_COLOR)) {
            editText.setTextColor(-16777216);
        }
        if (!map.containsKey(DAttrConstant.TV_LINE_BREAK_MODE)) {
            editText.setEllipsize(null);
        }
        if (map.containsKey(DAttrConstant.TV_TEXT_GRAVITY) || map.containsKey(DAttrConstant.TV_TEXT_ALIGNMENT)) {
            return;
        }
        editText.setGravity(16);
    }

    @Override // com.taobao.android.dinamic.dinamic.DinamicViewAdvancedConstructor
    public View initializeView(String str, Context context, AttributeSet attributeSet) {
        return new EditText(context, attributeSet);
    }

    @Override // com.taobao.android.dinamic.dinamic.DinamicViewAdvancedConstructor
    public void setAttributes(View view, Map<String, Object> map, ArrayList<String> arrayList, v80 v80Var) {
        super.setAttributes(view, map, arrayList, v80Var);
        EditText editText = (EditText) view;
        if (arrayList.contains(DAttrConstant.TV_TEXT)) {
            setText(editText, (String) map.get(DAttrConstant.TV_TEXT));
        }
        if (arrayList.contains(DAttrConstant.TV_TEXT_SIZE)) {
            setTextSize(editText, (String) map.get(DAttrConstant.TV_TEXT_SIZE));
        }
        if (arrayList.contains(DAttrConstant.TV_TEXT_COLOR)) {
            setTextColor(editText, (String) map.get(DAttrConstant.TV_TEXT_COLOR));
        }
        if (arrayList.contains(DAttrConstant.TV_TEXT_GRAVITY) || arrayList.contains(DAttrConstant.TV_TEXT_ALIGNMENT)) {
            setTextGravity(editText, (String) map.get(DAttrConstant.TV_TEXT_GRAVITY), (String) map.get(DAttrConstant.TV_TEXT_ALIGNMENT));
        }
        if (arrayList.contains(DAttrConstant.ET_PLACE_HOLDER)) {
            editText.setHint((String) map.get(DAttrConstant.ET_PLACE_HOLDER));
        }
        if (arrayList.contains(DAttrConstant.ET_PLACE_HOLDER_COLOR)) {
            setHintColor(editText, (String) map.get(DAttrConstant.ET_PLACE_HOLDER_COLOR));
        }
        if (arrayList.contains(DAttrConstant.ET_KEYBOARD)) {
            setKeyBoardType(editText, (String) map.get(DAttrConstant.ET_KEYBOARD));
        }
        if (arrayList.contains(DAttrConstant.ET_MAX_LENGTH)) {
            setMaxLength(editText, (String) map.get(DAttrConstant.ET_MAX_LENGTH));
        }
        if (arrayList.contains(DAttrConstant.INPUT_FOCUSABLE)) {
            boolean b = im1.b((String) map.get(DAttrConstant.INPUT_FOCUSABLE));
            editText.setFocusable(b);
            editText.setFocusableInTouchMode(b);
        }
    }

    public void setDeleteLine(EditText editText, String str) {
        if (TextUtils.equals(Constants.LayoutType.SINGLE, str)) {
            editText.getPaint().setFlags(16);
        }
    }

    @Override // com.taobao.android.dinamic.dinamic.DinamicViewAdvancedConstructor
    public void setEvents(View view, v80 v80Var) {
        new x21().b(view, v80Var);
    }

    public void setMaxLines(EditText editText, String str) {
        Integer valueOf = Integer.valueOf(str);
        if (valueOf.intValue() <= 0) {
            editText.setMaxLines(Integer.MAX_VALUE);
        } else if (valueOf.intValue() == 1) {
            editText.setMaxLines(1);
        } else {
            editText.setMaxLines(valueOf.intValue());
        }
    }

    public void setMaxWidth(EditText editText, String str) {
        int b = p62.b(editText.getContext(), str, -1);
        if (b != -1) {
            editText.setMaxWidth(b);
        }
    }

    public void setText(EditText editText, String str) {
        editText.setText(str);
    }

    public void setTextAlignment(EditText editText, String str) {
        int intValue = Integer.valueOf(str).intValue();
        if (intValue == 0) {
            editText.setGravity(19);
        } else if (intValue == 1) {
            editText.setGravity(17);
        } else if (intValue != 2) {
        } else {
            editText.setGravity(21);
        }
    }

    public void setTextColor(EditText editText, String str) {
        editText.setTextColor(oq.d(str, -16777216));
    }

    public void setTextGravity(EditText editText, String str, String str2) {
        if (str != null) {
            if ("left".equals(str)) {
                editText.setGravity(19);
                return;
            } else if ("center".equals(str)) {
                editText.setGravity(17);
                return;
            } else if ("right".equals(str)) {
                editText.setGravity(21);
                return;
            } else {
                editText.setGravity(16);
                return;
            }
        }
        setTextAlignment(editText, str2);
    }

    public void setTextLineBreakMode(EditText editText, String str) {
        int intValue = Integer.valueOf(str).intValue();
        if (intValue == 0) {
            editText.setEllipsize(null);
        } else if (intValue == 1) {
            editText.setEllipsize(TextUtils.TruncateAt.START);
        } else if (intValue == 2) {
            editText.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        } else if (intValue != 3) {
        } else {
            editText.setEllipsize(TextUtils.TruncateAt.END);
        }
    }

    public void setTextSize(EditText editText, String str) {
        int b = p62.b(editText.getContext(), str, -1);
        if (b == -1) {
            editText.setTextSize(1, 12.0f);
        } else {
            editText.setTextSize(0, b);
        }
    }

    public void setTextStyle(EditText editText, String str) {
        if (TextUtils.isEmpty(str)) {
            editText.setTypeface(Typeface.defaultFromStyle(0));
            return;
        }
        int intValue = Integer.valueOf(str).intValue();
        if (intValue == 0) {
            editText.setTypeface(Typeface.defaultFromStyle(0));
        } else if (intValue == 1) {
            editText.setTypeface(Typeface.defaultFromStyle(1));
        } else if (intValue == 2) {
            editText.setTypeface(Typeface.defaultFromStyle(2));
        } else if (intValue != 3) {
        } else {
            editText.setTypeface(Typeface.defaultFromStyle(3));
        }
    }

    public void setTextTheme(EditText editText, String str, String str2) {
        if (str != null) {
            if ("normal".equals(str)) {
                editText.setTypeface(Typeface.defaultFromStyle(0));
                return;
            } else if (Constants.Value.BOLD.equals(str)) {
                editText.setTypeface(Typeface.defaultFromStyle(1));
                return;
            } else if (Constants.Value.ITALIC.equals(str)) {
                editText.setTypeface(Typeface.defaultFromStyle(2));
                return;
            } else {
                editText.setTypeface(Typeface.defaultFromStyle(0));
                return;
            }
        }
        setTextStyle(editText, str2);
    }
}
