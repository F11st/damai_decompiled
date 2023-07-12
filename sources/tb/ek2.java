package tb;

import android.content.Context;
import android.content.DialogInterface;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.alibaba.android.ultron.trade.R$id;
import com.alibaba.android.ultron.trade.dinamicx3.widget.TDTextInputDialog;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.taobao.android.dinamic.property.DAttrConstant;
import com.taobao.android.dinamicx.widget.DXTextViewWidgetNode;
import com.taobao.android.dinamicx.widget.DXWidgetNode;
import com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode;
import com.taobao.weex.common.Constants;
import java.util.ArrayList;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class ek2 extends DXTextViewWidgetNode {
    public static final String INPUT_TYPE_DIALOG = "dialog";
    public static final String INPUT_TYPE_INPUT = "input";
    private String A;
    private String B;
    private String v;
    private String w;
    private int x;
    private int y;
    private int z;
    public static final long DX_WIDGET_ID = iz.a("tdTextInput");
    private static final long C = iz.a(Constants.Name.PLACEHOLDER);
    private static final long D = iz.a(Constants.Name.PLACEHOLDER_COLOR);
    private static final long E = iz.a(Constants.Event.KEYBOARD);
    private static final long F = iz.a(Constants.Name.MAX_LENGTH);
    private static final long G = iz.a(RemoteMessageConst.INPUT_TYPE);
    private static final long H = iz.a("textUnit");
    private static final long I = iz.a(DAttrConstant.VIEW_EVENT_FINISH);
    public static final int ID_TV_TEXT = R$id.trade_id_text;
    public static final int ID_KEY_BOARD = R$id.trade_id_key_board;
    public static final int ID_MAX_LENGTH = R$id.trade_id_max_length;
    public static final int ID_PLACE_HOLDER = R$id.trade_id_place_holder;
    public static final int ID_PLACE_HOLDER_COLOR = R$id.trade_id_place_holder_color;
    private static final int J = R$id.trade_text_watcher;

    /* compiled from: Taobao */
    /* renamed from: tb.ek2$a */
    /* loaded from: classes6.dex */
    public static class C9102a implements IDXBuilderWidgetNode {
        @Override // com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode
        public DXWidgetNode build(@Nullable Object obj) {
            return new ek2();
        }
    }

    /* compiled from: Taobao */
    /* renamed from: tb.ek2$b */
    /* loaded from: classes6.dex */
    public class C9103b {
        private String a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: Taobao */
        /* renamed from: tb.ek2$b$a */
        /* loaded from: classes6.dex */
        public class View$OnTouchListenerC9104a implements View.OnTouchListener {
            final /* synthetic */ View a;

            /* compiled from: Taobao */
            /* renamed from: tb.ek2$b$a$a */
            /* loaded from: classes6.dex */
            class C9105a implements TDTextInputDialog.OnClickListener {
                C9105a() {
                }

                @Override // com.alibaba.android.ultron.trade.dinamicx3.widget.TDTextInputDialog.OnClickListener
                public void onClick(DialogInterface dialogInterface, CharSequence charSequence) {
                    View$OnTouchListenerC9104a view$OnTouchListenerC9104a = View$OnTouchListenerC9104a.this;
                    C9103b c9103b = C9103b.this;
                    c9103b.c(view$OnTouchListenerC9104a.a, c9103b.a);
                }
            }

            View$OnTouchListenerC9104a(View view) {
                this.a = view;
            }

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getActionMasked() != 1 || view.isFocusable()) {
                    return false;
                }
                TDTextInputDialog tDTextInputDialog = new TDTextInputDialog(view.getContext());
                tDTextInputDialog.h((EditText) this.a);
                tDTextInputDialog.i(new C9105a());
                tDTextInputDialog.show();
                return true;
            }
        }

        public C9103b(String str) {
            this.a = str;
        }

        public void b(View view) {
            if (view instanceof EditText) {
                ViewParent parent = view.getParent();
                if (parent instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) parent;
                    viewGroup.setFocusable(true);
                    viewGroup.setFocusableInTouchMode(true);
                }
                C9106c c9106c = (C9106c) view.getTag(ek2.J);
                if (c9106c != null) {
                    ((EditText) view).removeTextChangedListener(c9106c);
                }
                C9106c c9106c2 = new C9106c(view, this.a);
                view.setTag(ek2.J, c9106c2);
                ((EditText) view).addTextChangedListener(c9106c2);
                view.setOnTouchListener(new View$OnTouchListenerC9104a(view));
            }
        }

        public void c(View view, String str) {
            if ("dialog".equals(str)) {
                ArrayList arrayList = new ArrayList(5);
                arrayList.add("dialog");
                arrayList.add(((EditText) view).getText());
                view.setTag(ny2.DINAMICX_3_CUSTOM_INPUT_KEY, arrayList);
                ek2.this.postEvent(new hy(ek2.I));
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: tb.ek2$c */
    /* loaded from: classes6.dex */
    public class C9106c implements TextWatcher {
        private View a;
        private String b;

        public C9106c(View view, String str) {
            this.a = view;
            this.b = str;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (this.a.isFocusable() && "input".equals(this.b)) {
                ArrayList arrayList = new ArrayList(5);
                arrayList.add("input");
                arrayList.add(((EditText) this.a).getText());
                this.a.setTag(ny2.DINAMICX_3_CUSTOM_INPUT_KEY, arrayList);
                ek2.this.postEvent(new hy(ek2.I));
            }
        }
    }

    private void y(EditText editText, boolean z) {
        if (editText != null) {
            editText.setFocusable(z);
            editText.setFocusableInTouchMode(z);
        }
    }

    private void z(View view) {
        if (view instanceof EditText) {
            view.setTag(ID_TV_TEXT, this.v);
            EditText editText = (EditText) view;
            g90.b(editText, this.x);
            view.setTag(ID_PLACE_HOLDER_COLOR, Integer.valueOf(this.x));
            g90.c(editText, this.y);
            view.setTag(ID_KEY_BOARD, Integer.valueOf(this.y));
            g90.d(editText, this.z);
            view.setTag(ID_MAX_LENGTH, Integer.valueOf(this.z));
            if (!TextUtils.isEmpty(this.w)) {
                g90.a(editText, this.w);
                view.setTag(ID_PLACE_HOLDER, this.w);
            } else if (TextUtils.isEmpty(this.B)) {
            } else {
                y(editText, "input".equalsIgnoreCase(this.B));
            }
        }
    }

    @Override // com.taobao.android.dinamicx.widget.DXTextViewWidgetNode, com.taobao.android.dinamicx.widget.DXWidgetNode, com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode
    public DXWidgetNode build(@Nullable Object obj) {
        return new ek2();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXTextViewWidgetNode
    public void h(TextView textView) {
        super.h(textView);
        z(textView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onBindEvent(Context context, View view, long j) {
        super.onBindEvent(context, view, j);
        if (I == j) {
            new C9103b(this.B).b(view);
        }
    }

    @Override // com.taobao.android.dinamicx.widget.DXTextViewWidgetNode, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onClone(DXWidgetNode dXWidgetNode, boolean z) {
        super.onClone(dXWidgetNode, z);
        if (dXWidgetNode instanceof ek2) {
            ek2 ek2Var = (ek2) dXWidgetNode;
            this.v = ek2Var.v;
            this.A = ek2Var.A;
            this.w = ek2Var.w;
            this.x = ek2Var.x;
            this.y = ek2Var.y;
            this.z = ek2Var.z;
            this.B = ek2Var.B;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXTextViewWidgetNode, com.taobao.android.dinamicx.widget.DXWidgetNode
    public View onCreateView(Context context) {
        EditText editText = new EditText(context);
        editText.setPadding(0, 0, 0, 0);
        return editText;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXTextViewWidgetNode, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onRenderView(Context context, View view) {
        if (!TextUtils.isEmpty(this.A)) {
            t(this.v + this.A);
        }
        super.onRenderView(context, view);
        z(view);
    }

    @Override // com.taobao.android.dinamicx.widget.DXTextViewWidgetNode, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetIntAttribute(long j, int i) {
        super.onSetIntAttribute(j, i);
        if (D == j) {
            this.x = i;
        } else if (E == j) {
            this.y = i;
        } else if (F == j) {
            this.z = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXTextViewWidgetNode, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetStringAttribute(long j, String str) {
        super.onSetStringAttribute(j, str);
        if (38178040921L == j) {
            this.v = str;
        } else if (C == j) {
            this.w = str;
        } else if (G == j) {
            this.B = str;
        } else if (H == j) {
            this.A = str;
        }
    }
}
