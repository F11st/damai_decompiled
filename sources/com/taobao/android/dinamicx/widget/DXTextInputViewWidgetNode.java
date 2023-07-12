package com.taobao.android.dinamicx.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.taobao.android.dinamic.R$id;
import com.taobao.android.dinamic.R$layout;
import com.taobao.weex.common.Constants;
import java.lang.reflect.Field;
import tb.a90;
import tb.e10;
import tb.nz;
import tb.t10;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class DXTextInputViewWidgetNode extends C6499j {
    public static final long DXORDERTEXTINPUTVIEWCHEN_CURSORCOLOR = -1990674490194665048L;
    public static final long DXTEXTINPUTVIEW_COUNTNUMCOLOR = 9071837297406208101L;
    public static final long DXTEXTINPUTVIEW_ISSHOWHINTNUM = 2472129721305181261L;
    public static final long DXTEXTINPUTVIEW_ISSINGLELINE = 9201315914461489362L;
    public static final long DXTEXTINPUTVIEW_MULTILINEMAXHEIGHT = 2175688563532828996L;
    public static final long DXTEXTINPUTVIEW_TEXTINPUTVIEW = -7398276613927103139L;
    public static final long DXTEXTINPUTVIEW_TOTALNUMCOLOR = 36296692771444064L;
    private int j;
    private int l;
    private int m;
    private int n;
    private boolean k = true;
    private boolean o = false;

    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.dinamicx.widget.DXTextInputViewWidgetNode$a */
    /* loaded from: classes12.dex */
    class View$OnClickListenerC6465a implements View.OnClickListener {
        final /* synthetic */ EditText a;

        View$OnClickListenerC6465a(EditText editText) {
            this.a = editText;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.a.requestFocus();
            this.a.setCursorVisible(true);
            DXTextInputViewWidgetNode.this.e(this.a);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.dinamicx.widget.DXTextInputViewWidgetNode$b */
    /* loaded from: classes12.dex */
    class View$OnTouchListenerC6466b implements View.OnTouchListener {
        final /* synthetic */ EditText a;

        View$OnTouchListenerC6466b(DXTextInputViewWidgetNode dXTextInputViewWidgetNode, EditText editText) {
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
    /* renamed from: com.taobao.android.dinamicx.widget.DXTextInputViewWidgetNode$c */
    /* loaded from: classes11.dex */
    public static class C6467c implements IDXBuilderWidgetNode {
        @Override // com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode
        public DXWidgetNode build(@Nullable Object obj) {
            return new DXTextInputViewWidgetNode();
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.dinamicx.widget.DXTextInputViewWidgetNode$d */
    /* loaded from: classes12.dex */
    public static class C6468d implements TextWatcher {
        private DXTextInputViewWidgetNode a;
        private View b;
        t10 c = new t10(5288679823228297259L);

        public C6468d(DXTextInputViewWidgetNode dXTextInputViewWidgetNode, View view) {
            this.a = dXTextInputViewWidgetNode;
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
            View view = this.b;
            if (view instanceof RelativeLayout) {
                ((TextView) view.findViewById(R$id.tv_word_count)).setText(String.valueOf(charSequence.length()));
                this.c.f(((EditText) this.b.findViewById(R$id.dx_multi_line_input)).getText());
                this.a.postEvent(this.c);
                return;
            }
            this.c.f(((EditText) view).getText());
            this.a.postEvent(this.c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(EditText editText) {
        InputMethodManager inputMethodManager;
        if (editText == null || getDXRuntimeContext() == null || getDXRuntimeContext().getContext() == null) {
            return;
        }
        if (((getDXRuntimeContext().getContext() instanceof Activity) && ((Activity) getDXRuntimeContext().getContext()).isFinishing()) || (inputMethodManager = (InputMethodManager) getDXRuntimeContext().getContext().getSystemService("input_method")) == null) {
            return;
        }
        editText.requestFocus();
        editText.requestFocusFromTouch();
        inputMethodManager.showSoftInput(editText, 0);
    }

    @Override // com.taobao.android.dinamicx.widget.C6499j, com.taobao.android.dinamicx.widget.DXWidgetNode, com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode
    public DXWidgetNode build(@Nullable Object obj) {
        return new DXTextInputViewWidgetNode();
    }

    public void d(EditText editText, int i) {
        try {
            Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
            declaredField.setAccessible(true);
            int i2 = declaredField.getInt(editText);
            Field declaredField2 = TextView.class.getDeclaredField("mEditor");
            declaredField2.setAccessible(true);
            Object obj = declaredField2.get(editText);
            Field declaredField3 = obj.getClass().getDeclaredField("mCursorDrawable");
            declaredField3.setAccessible(true);
            Drawable[] drawableArr = {editText.getContext().getResources().getDrawable(i2), editText.getContext().getResources().getDrawable(i2)};
            drawableArr[0].setColorFilter(i, PorterDuff.Mode.SRC_IN);
            drawableArr[1].setColorFilter(i, PorterDuff.Mode.SRC_IN);
            declaredField3.set(obj, drawableArr);
        } catch (Throwable unused) {
            nz.g(nz.TAG, "textInput 游标颜色设置失败");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.C6499j, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onBindEvent(Context context, View view, long j) {
        if (j == 5288679823228297259L) {
            if (view instanceof EditText) {
                super.onBindEvent(context, view, j);
                return;
            }
            int i = a90.TEXT_WATCHER;
            C6468d c6468d = (C6468d) view.getTag(i);
            EditText editText = (EditText) view.findViewById(R$id.dx_multi_line_input);
            if (c6468d != null) {
                editText.removeTextChangedListener(c6468d);
            }
            C6468d c6468d2 = new C6468d(this, view);
            editText.setTag(i, c6468d2);
            editText.addTextChangedListener(c6468d2);
            return;
        }
        super.onBindEvent(context, view, j);
    }

    @Override // com.taobao.android.dinamicx.widget.C6499j, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onClone(DXWidgetNode dXWidgetNode, boolean z) {
        super.onClone(dXWidgetNode, z);
        if (dXWidgetNode instanceof DXTextInputViewWidgetNode) {
            DXTextInputViewWidgetNode dXTextInputViewWidgetNode = (DXTextInputViewWidgetNode) dXWidgetNode;
            this.j = dXTextInputViewWidgetNode.j;
            this.k = dXTextInputViewWidgetNode.k;
            this.l = dXTextInputViewWidgetNode.l;
            this.o = dXTextInputViewWidgetNode.o;
            this.m = dXTextInputViewWidgetNode.m;
            this.n = dXTextInputViewWidgetNode.n;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.C6499j, com.taobao.android.dinamicx.widget.DXWidgetNode
    public View onCreateView(Context context) {
        if (!this.k) {
            View a = e10.a(context, R$layout.multi_line_input_view);
            ((EditText) a.findViewById(R$id.dx_multi_line_input)).setBackgroundColor(0);
            if (this.o) {
                ((TextView) a.findViewById(R$id.tv_word_total)).setVisibility(0);
                ((TextView) a.findViewById(R$id.tv_word_count)).setVisibility(0);
            }
            return a;
        }
        return super.onCreateView(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.C6499j, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onMeasure(int i, int i2) {
        if (!this.k) {
            setMeasuredDimension(i, this.j);
        } else {
            super.onMeasure(i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.C6499j, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onRenderView(Context context, final View view) {
        final EditText editText;
        if (view != null) {
            if ((view instanceof EditText) || (view instanceof RelativeLayout)) {
                if (!this.k) {
                    editText = (EditText) view.findViewById(R$id.dx_multi_line_input);
                    final TextView textView = (TextView) view.findViewById(R$id.tv_word_total);
                    if (this.f > 0) {
                        textView.setText("/" + this.f);
                    }
                    int i = this.m;
                    if (i != 0) {
                        ((TextView) view.findViewById(R$id.tv_word_count)).setTextColor(tryFetchDarkModeColor("textColor", 0, i));
                    }
                    int i2 = this.n;
                    if (i2 != 0) {
                        textView.setTextColor(tryFetchDarkModeColor("textColor", 0, i2));
                    }
                    view.setOnClickListener(new View$OnClickListenerC6465a(editText));
                    if (this.o) {
                        view.post(new Runnable() { // from class: com.taobao.android.dinamicx.widget.DXTextInputViewWidgetNode.2
                            @Override // java.lang.Runnable
                            public void run() {
                                editText.setMaxHeight((view.getHeight() - textView.getMeasuredHeight()) - ((RelativeLayout.LayoutParams) textView.getLayoutParams()).bottomMargin);
                            }
                        });
                    }
                } else {
                    editText = (EditText) view;
                    a(editText, this.e);
                }
                editText.setHint(this.g);
                editText.setHintTextColor(tryFetchDarkModeColor(Constants.Name.PLACEHOLDER_COLOR, 0, this.h));
                editText.setText(this.a);
                editText.setTextSize(0, this.c);
                editText.setTextColor(tryFetchDarkModeColor("textColor", 0, this.b));
                b(editText, this.d);
                editText.setCursorVisible(false);
                int i3 = this.l;
                if (i3 != 0) {
                    d(editText, i3);
                }
                editText.setOnTouchListener(new View$OnTouchListenerC6466b(this, editText));
                if (this.f <= 0) {
                    editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(Integer.MAX_VALUE)});
                } else {
                    editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(this.f)});
                }
            }
        }
    }

    @Override // com.taobao.android.dinamicx.widget.C6499j, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetIntAttribute(long j, int i) {
        if (j == DXTEXTINPUTVIEW_MULTILINEMAXHEIGHT) {
            this.j = i;
        } else if (j == DXORDERTEXTINPUTVIEWCHEN_CURSORCOLOR) {
            this.l = i;
        } else if (j == DXTEXTINPUTVIEW_COUNTNUMCOLOR) {
            this.m = i;
        } else if (j == DXTEXTINPUTVIEW_TOTALNUMCOLOR) {
            this.n = i;
        } else {
            if (j == DXTEXTINPUTVIEW_ISSINGLELINE) {
                this.k = i != 0;
            } else if (j == DXTEXTINPUTVIEW_ISSHOWHINTNUM) {
                this.o = i != 0;
            } else {
                super.onSetIntAttribute(j, i);
            }
        }
    }
}
