package tb;

import android.text.InputFilter;
import android.text.TextUtils;
import android.widget.EditText;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class h90 {
    public static final int DEFAULT_TEXT_HINT_COLOR = -16777216;
    public static final int INPUT_TYPE_NORMAL = 0;
    public static final int INPUT_TYPE_NUMBER = 1;
    public static final int INPUT_TYPE_PASSWORD = 3;
    public static final int INPUT_TYPE_PHONE = 2;

    public static void a(EditText editText, String str) {
        if (editText == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        editText.setHint(str);
    }

    public static void b(EditText editText, String str) {
        if (editText == null) {
            return;
        }
        editText.setHintTextColor(rk.e(str, -16777216));
    }

    public static void c(EditText editText, String str) {
        if (editText == null) {
            return;
        }
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

    public static void d(EditText editText, String str) {
        if (editText == null) {
            return;
        }
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

    public static void e(EditText editText, String str) {
        if (editText == null) {
            return;
        }
        editText.setText(str);
    }
}
