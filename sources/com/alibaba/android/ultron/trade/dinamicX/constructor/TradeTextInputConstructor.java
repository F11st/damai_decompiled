package com.alibaba.android.ultron.trade.dinamicX.constructor;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.alibaba.android.ultron.trade.R$id;
import com.alibaba.android.ultron.trade.dinamicX.widget.TradeTextInputDialog;
import com.taobao.android.dinamic.dinamic.DinamicViewAdvancedConstructor;
import com.taobao.weex.common.Constants;
import com.youku.arch.v3.data.Constants;
import java.util.ArrayList;
import java.util.Map;
import tb.h90;
import tb.m80;
import tb.p62;
import tb.q80;
import tb.rk;
import tb.v80;
import tb.x80;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class TradeTextInputConstructor extends DinamicViewAdvancedConstructor {
    private static final int DEFAULT_TEXT_COLOR = -16777216;
    private static final int DEFAULT_TEXT_SIZE = 12;
    private static final int ELLIPSIZE_END = 3;
    private static final int ELLIPSIZE_MIDDLE = 2;
    private static final int ELLIPSIZE_NONE = 0;
    private static final int ELLIPSIZE_START = 1;
    private static final String ET_KEYBOARD = "dKeyboard";
    private static final String ET_MAX_LENGTH = "dMaxLength";
    private static final String ET_PLACE_HOLDER = "dPlaceholder";
    private static final String ET_PLACE_HOLDER_COLOR = "dPlaceholderColor";
    private static final String INPUT_TYPE = "dInputType";
    public static final String INPUT_TYPE_DIALOG = "dialog";
    public static final String INPUT_TYPE_INPUT = "input";
    private static final int TEXT_ALIGNMENT_CENTER = 1;
    private static final int TEXT_ALIGNMENT_LEFT = 0;
    private static final int TEXT_ALIGNMENT_RIGHT = 2;
    private static final int TEXT_STYLE_BOLD = 1;
    private static final int TEXT_STYLE_BOLD_ITALIC = 3;
    private static final int TEXT_STYLE_ITALIC = 2;
    private static final int TEXT_STYLE_NORMAL = 0;
    private static final String TV_LINE_BREAK_MODE = "dLineBreakMode";
    private static final String TV_TEXT = "dText";
    private static final String TV_TEXT_ALIGNMENT = "dTextAlignment";
    private static final String TV_TEXT_COLOR = "dTextColor";
    private static final String TV_TEXT_GRAVITY = "dTextGravity";
    private static final String TV_TEXT_SIZE = "dTextSize";
    private static final String VIEW_ACCESSIBILITY_TEXT_HIDDEN = "dAccessibilityTextHidden";
    private static final String VIEW_EVENT_ON_FINISH = "onFinish";
    public static final String VIEW_TAG = "TradeTextInput";
    public static final int ID_TV_TEXT = R$id.trade_id_text;
    public static final int ID_KEY_BOARD = R$id.trade_id_key_board;
    public static final int ID_MAX_LENGTH = R$id.trade_id_max_length;
    public static final int ID_PLACE_HOLDER = R$id.trade_id_place_holder;
    public static final int ID_PLACE_HOLDER_COLOR = R$id.trade_id_place_holder_color;
    private static final int TEXT_WATCHER = R$id.trade_text_watcher;

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public static class a extends q80 {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: Taobao */
        /* renamed from: com.alibaba.android.ultron.trade.dinamicX.constructor.TradeTextInputConstructor$a$a  reason: collision with other inner class name */
        /* loaded from: classes15.dex */
        public class View$OnTouchListenerC0132a implements View.OnTouchListener {
            final /* synthetic */ View a;
            final /* synthetic */ Map b;
            final /* synthetic */ v80 c;
            final /* synthetic */ x80 d;

            /* compiled from: Taobao */
            /* renamed from: com.alibaba.android.ultron.trade.dinamicX.constructor.TradeTextInputConstructor$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes6.dex */
            class C0133a implements TradeTextInputDialog.OnClickListener {
                C0133a() {
                }

                @Override // com.alibaba.android.ultron.trade.dinamicX.widget.TradeTextInputDialog.OnClickListener
                public void onClick(DialogInterface dialogInterface, CharSequence charSequence) {
                    View$OnTouchListenerC0132a view$OnTouchListenerC0132a = View$OnTouchListenerC0132a.this;
                    a.this.f(view$OnTouchListenerC0132a.a, view$OnTouchListenerC0132a.c, view$OnTouchListenerC0132a.d, (String) View$OnTouchListenerC0132a.this.b.get("onFinish"));
                }
            }

            View$OnTouchListenerC0132a(View view, Map map, v80 v80Var, x80 x80Var) {
                this.a = view;
                this.b = map;
                this.c = v80Var;
                this.d = x80Var;
            }

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getActionMasked() != 1 || view.isFocusable()) {
                    return false;
                }
                TradeTextInputDialog tradeTextInputDialog = new TradeTextInputDialog(view.getContext());
                tradeTextInputDialog.h((EditText) this.a);
                tradeTextInputDialog.i(new C0133a());
                tradeTextInputDialog.show();
                return true;
            }
        }

        @Override // tb.q80
        public void b(View view, v80 v80Var) {
            e(view, v80Var);
        }

        public void e(View view, v80 v80Var) {
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            if (viewGroup != null) {
                viewGroup.setFocusable(true);
                viewGroup.setFocusableInTouchMode(true);
            }
            x80 x80Var = (x80) view.getTag(m80.PROPERTY_KEY);
            if (x80Var == null) {
                return;
            }
            Map<String, String> map = x80Var.d;
            if (map.isEmpty()) {
                return;
            }
            b bVar = (b) view.getTag(TradeTextInputConstructor.TEXT_WATCHER);
            if (bVar != null) {
                ((EditText) view).removeTextChangedListener(bVar);
            }
            b bVar2 = new b(this, view, x80Var);
            bVar2.a(v80Var);
            view.setTag(TradeTextInputConstructor.TEXT_WATCHER, bVar2);
            ((EditText) view).addTextChangedListener(bVar2);
            view.setOnTouchListener(new View$OnTouchListenerC0132a(view, map, v80Var, x80Var));
        }

        public void f(View view, v80 v80Var, x80 x80Var, String str) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            ArrayList arrayList = new ArrayList(5);
            arrayList.add("dialog");
            arrayList.add(((EditText) view).getText());
            view.setTag(m80.VIEW_PARAMS, arrayList);
            q80.d(view, v80Var, x80Var, str);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public static class b implements TextWatcher {
        private v80 a;
        private x80 b;
        private String c;
        private View d;
        private a e;

        public b(a aVar, View view, x80 x80Var) {
            this.e = aVar;
            this.b = x80Var;
            this.d = view;
            Map<String, String> map = x80Var.d;
            if (map.isEmpty()) {
                return;
            }
            this.c = map.get("onFinish");
        }

        public void a(v80 v80Var) {
            this.a = v80Var;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (!this.d.isFocusable() || TextUtils.isEmpty(this.c)) {
                return;
            }
            ArrayList arrayList = new ArrayList(5);
            arrayList.add("input");
            arrayList.add(((EditText) this.d).getText());
            this.d.setTag(m80.VIEW_PARAMS, arrayList);
            q80.d(this.d, this.a, this.b, this.c);
        }
    }

    private void enableEditTextFocus(EditText editText, boolean z) {
        if (editText != null) {
            editText.setFocusable(z);
            editText.setFocusableInTouchMode(z);
        }
    }

    private void setBackground(EditText editText, String str) {
        editText.setBackgroundColor(rk.e(str, -16777216));
    }

    @Override // com.taobao.android.dinamic.dinamic.DinamicViewAdvancedConstructor
    public void applyDefaultProperty(View view, Map<String, Object> map, v80 v80Var) {
        super.applyDefaultProperty(view, map, v80Var);
        EditText editText = (EditText) view;
        editText.setLines(1);
        editText.setSingleLine();
        editText.setImeOptions(6);
        if (!map.containsKey("dTextSize")) {
            editText.setTextSize(1, 12.0f);
        }
        if (!map.containsKey("dTextColor")) {
            editText.setTextColor(-16777216);
        }
        if (!map.containsKey("dLineBreakMode")) {
            editText.setEllipsize(null);
        }
        if (!map.containsKey("dTextGravity") && !map.containsKey("dTextAlignment")) {
            editText.setGravity(16);
        }
        if (map.containsKey("dAccessibilityTextHidden")) {
            return;
        }
        setAccessibilityHidden(view, true);
    }

    @Override // com.taobao.android.dinamic.dinamic.DinamicViewAdvancedConstructor
    public View initializeView(String str, Context context, AttributeSet attributeSet) {
        return new EditText(context, attributeSet);
    }

    @Override // com.taobao.android.dinamic.dinamic.DinamicViewAdvancedConstructor
    public void setAttributes(View view, Map<String, Object> map, ArrayList<String> arrayList, v80 v80Var) {
        super.setAttributes(view, map, arrayList, v80Var);
        EditText editText = (EditText) view;
        if (arrayList.contains("dText")) {
            String str = (String) map.get("dText");
            h90.e(editText, str);
            view.setTag(ID_TV_TEXT, str);
        }
        if (arrayList.contains("dTextSize")) {
            setTextSize(editText, (String) map.get("dTextSize"));
        }
        if (arrayList.contains("dTextColor")) {
            setTextColor(editText, (String) map.get("dTextColor"));
        }
        if (arrayList.contains("dTextGravity") || arrayList.contains("dTextAlignment")) {
            setTextGravity(editText, (String) map.get("dTextGravity"), (String) map.get("dTextAlignment"));
        }
        if (arrayList.contains("dPlaceholder")) {
            String str2 = (String) map.get("dPlaceholder");
            h90.a(editText, str2);
            view.setTag(ID_PLACE_HOLDER, str2);
        }
        if (arrayList.contains("dPlaceholderColor")) {
            String str3 = (String) map.get("dPlaceholderColor");
            h90.b(editText, str3);
            view.setTag(ID_PLACE_HOLDER_COLOR, str3);
        }
        if (arrayList.contains("dKeyboard")) {
            String str4 = (String) map.get("dKeyboard");
            h90.c(editText, str4);
            view.setTag(ID_KEY_BOARD, str4);
        }
        if (arrayList.contains("dMaxLength")) {
            String str5 = (String) map.get("dMaxLength");
            h90.d(editText, str5);
            view.setTag(ID_MAX_LENGTH, str5);
        }
        if (arrayList.contains(INPUT_TYPE)) {
            enableEditTextFocus(editText, "input".equalsIgnoreCase((String) map.get(INPUT_TYPE)));
        }
    }

    public void setDeleteLine(EditText editText, String str) {
        if (TextUtils.equals(Constants.LayoutType.SINGLE, str)) {
            editText.getPaint().setFlags(16);
        }
    }

    @Override // com.taobao.android.dinamic.dinamic.DinamicViewAdvancedConstructor
    public void setEvents(View view, v80 v80Var) {
        new a().b(view, v80Var);
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
        int b2 = p62.b(editText.getContext(), str, -1);
        if (b2 != -1) {
            editText.setMaxWidth(b2);
        }
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
        editText.setTextColor(rk.e(str, -16777216));
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
        int b2 = p62.b(editText.getContext(), str, -1);
        if (b2 == -1) {
            editText.setTextSize(1, 12.0f);
        } else {
            editText.setTextSize(0, b2);
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
