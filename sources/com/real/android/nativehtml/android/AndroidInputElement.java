package com.real.android.nativehtml.android;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import com.real.android.nativehtml.common.dom.ContentType;
import com.real.android.nativehtml.common.dom.HtmlInputElement;
import tb.qb0;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class AndroidInputElement extends AndroidWrapperElement implements HtmlInputElement {
    public AndroidInputElement(Context context, qb0 qb0Var) {
        super(context, qb0Var, "input", new EditText(context));
        ((EditText) this.child).setMinEms(20);
    }

    @Override // com.real.android.nativehtml.common.dom.Element
    public ContentType getElementContentType() {
        return ContentType.EMPTY;
    }

    @Override // com.real.android.nativehtml.android.AbstractAndroidComponentElement, com.real.android.nativehtml.common.dom.Element
    public void setAttribute(String str, String str2) {
        if ("type".equals(str)) {
            removeAllViews();
            String lowerCase = str2.toLowerCase();
            lowerCase.hashCode();
            char c = 65535;
            switch (lowerCase.hashCode()) {
                case -891535336:
                    if (lowerCase.equals("submit")) {
                        c = 0;
                        break;
                    }
                    break;
                case 108270587:
                    if (lowerCase.equals("radio")) {
                        c = 1;
                        break;
                    }
                    break;
                case 1536891843:
                    if (lowerCase.equals("checkbox")) {
                        c = 2;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    this.child = new Button(getContext());
                    break;
                case 1:
                    this.child = new RadioButton(getContext());
                    break;
                case 2:
                    this.child = new CheckBox(getContext());
                    break;
                default:
                    EditText editText = new EditText(getContext());
                    editText.setMinEms(20);
                    this.child = editText;
                    break;
            }
            addView(this.child);
            setAttribute("value", getAttribute(str2));
        } else if ("value".equals(str)) {
            View view = this.child;
            if (!(view instanceof CompoundButton)) {
                ((TextView) view).setText(str2);
            }
        }
        super.setAttribute(str, str2);
    }
}
