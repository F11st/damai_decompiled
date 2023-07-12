package com.taobao.android.dinamicx.widget;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import androidx.annotation.Nullable;
import com.taobao.android.dinamicx.DinamicXEngine;
import com.taobao.android.dinamicx.widget.DXWidgetNode;
import com.taobao.weex.common.Constants;
import tb.a90;
import tb.t10;
import tb.w00;
import tb.z00;

/* compiled from: Taobao */
/* renamed from: com.taobao.android.dinamicx.widget.j */
/* loaded from: classes11.dex */
public class C6499j extends DXWidgetNode {
    public static final int DEFAULT_TEXT_COLOR = -16777216;
    public static int i;
    int b;
    float c;
    int d;
    int e;
    int f;
    String g;
    int h = -7829368;
    CharSequence a = "";

    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.dinamicx.widget.j$a */
    /* loaded from: classes12.dex */
    class View$OnTouchListenerC6500a implements View.OnTouchListener {
        final /* synthetic */ EditText a;

        View$OnTouchListenerC6500a(C6499j c6499j, EditText editText) {
            this.a = editText;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getActionMasked() == 1) {
                this.a.setCursorVisible(true);
                return false;
            }
            return false;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.dinamicx.widget.j$b */
    /* loaded from: classes11.dex */
    public static class C6501b implements IDXBuilderWidgetNode {
        @Override // com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode
        public DXWidgetNode build(@Nullable Object obj) {
            return new C6499j();
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.dinamicx.widget.j$c */
    /* loaded from: classes12.dex */
    public static class C6502c implements TextWatcher {
        private C6499j a;
        private View b;
        t10 c = new t10(5288679823228297259L);

        public C6502c(C6499j c6499j, View view) {
            this.a = c6499j;
            this.b = view;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.c.f(((EditText) this.b).getText());
            this.a.postEvent(this.c);
        }
    }

    public C6499j() {
        this.b = -16777216;
        this.d = 0;
        this.b = -16777216;
        if (i == 0 && DinamicXEngine.i() != null) {
            i = z00.c(DinamicXEngine.i(), 12.0f);
        }
        this.c = i;
        this.d = 0;
        this.accessibility = 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(EditText editText, int i2) {
        if (i2 == 0) {
            editText.setInputType(1);
        } else if (i2 == 1) {
            editText.setInputType(2);
        } else if (i2 != 2) {
            editText.setInputType(1);
        } else {
            editText.setInputType(3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(EditText editText, int i2) {
        if (i2 == 0) {
            editText.setGravity(19);
        } else if (i2 == 1) {
            editText.setGravity(17);
        } else if (i2 == 2) {
            editText.setGravity(21);
        } else {
            editText.setGravity(16);
        }
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode, com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode
    public DXWidgetNode build(@Nullable Object obj) {
        return new C6499j();
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public int getDefaultValueForIntAttr(long j) {
        if (j == 5737767606580872653L) {
            return -16777216;
        }
        if (j == 6751005219504497256L) {
            return i;
        }
        return super.getDefaultValueForIntAttr(j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onBindEvent(Context context, View view, long j) {
        if (j == 5288679823228297259L) {
            int i2 = a90.TEXT_WATCHER;
            C6502c c6502c = (C6502c) view.getTag(i2);
            if (c6502c != null) {
                ((EditText) view).removeTextChangedListener(c6502c);
            }
            C6502c c6502c2 = new C6502c(this, view);
            view.setTag(i2, c6502c2);
            ((EditText) view).addTextChangedListener(c6502c2);
            return;
        }
        super.onBindEvent(context, view, j);
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onClone(DXWidgetNode dXWidgetNode, boolean z) {
        super.onClone(dXWidgetNode, z);
        if (dXWidgetNode instanceof C6499j) {
            C6499j c6499j = (C6499j) dXWidgetNode;
            this.a = c6499j.a;
            this.b = c6499j.b;
            this.c = c6499j.c;
            this.d = c6499j.d;
            this.e = c6499j.e;
            this.g = c6499j.g;
            this.f = c6499j.f;
            this.h = c6499j.h;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public View onCreateView(Context context) {
        EditText editText = new EditText(context);
        editText.setLines(1);
        editText.setSingleLine();
        editText.setImeOptions(6);
        editText.setEllipsize(null);
        return editText;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onMeasure(int i2, int i3) {
        int a = DXWidgetNode.DXMeasureSpec.a(i2);
        int a2 = DXWidgetNode.DXMeasureSpec.a(i3);
        setMeasuredDimension(a == 1073741824 ? DXWidgetNode.DXMeasureSpec.b(i2) : 0, a2 == 1073741824 ? DXWidgetNode.DXMeasureSpec.b(i3) : 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onRenderView(Context context, View view) {
        if (view == null || !(view instanceof EditText)) {
            return;
        }
        EditText editText = (EditText) view;
        editText.setHint(this.g);
        editText.setHintTextColor(tryFetchDarkModeColor(Constants.Name.PLACEHOLDER_COLOR, 0, this.h));
        editText.setText(this.a);
        editText.setTextSize(0, this.c);
        editText.setTextColor(tryFetchDarkModeColor("textColor", 0, this.b));
        b(editText, this.d);
        a(editText, this.e);
        editText.setCursorVisible(false);
        editText.setOnTouchListener(new View$OnTouchListenerC6500a(this, editText));
        if (this.f <= 0) {
            editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(Integer.MAX_VALUE)});
        } else {
            editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(this.f)});
        }
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetIntAttribute(long j, int i2) {
        if (5737767606580872653L == j) {
            this.b = i2;
        } else if (w00.DXRICHTEXT_TEXTGRAVITY == j) {
            this.d = i2;
        } else if (-2628107586387168847L == j) {
            this.f = i2;
        } else if (1205272363096125842L == j) {
            this.h = i2;
        } else if (6751005219504497256L == j) {
            this.c = i2;
        } else if (4100686809917705561L == j) {
            this.e = i2;
        } else {
            super.onSetIntAttribute(j, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetStringAttribute(long j, String str) {
        if (38178040921L == j) {
            this.a = str;
        } else if (5980555813819279758L == j) {
            this.g = str;
        } else {
            super.onSetStringAttribute(j, str);
        }
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void setBackground(View view) {
        super.setBackground(view);
        if (this.needSetBackground) {
            return;
        }
        view.setBackgroundColor(0);
    }
}
