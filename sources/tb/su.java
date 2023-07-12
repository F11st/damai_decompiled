package tb;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.EditText;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.android.dinamicx.widget.C6499j;
import com.taobao.android.dinamicx.widget.DXWidgetNode;
import com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode;
import java.util.ArrayList;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class su extends C6499j {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final long DXDMINPUT_DMINPUT = 3573405303742391208L;
    public static final long DXDMINPUT_ONINPUTCHANGE = -417835413824138176L;

    /* compiled from: Taobao */
    /* renamed from: tb.su$a */
    /* loaded from: classes9.dex */
    public static class C9700a implements IDXBuilderWidgetNode {
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode
        public DXWidgetNode build(Object obj) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-467268727") ? (DXWidgetNode) ipChange.ipc$dispatch("-467268727", new Object[]{this, obj}) : new su();
        }
    }

    /* compiled from: Taobao */
    /* renamed from: tb.su$b */
    /* loaded from: classes9.dex */
    public static class C9701b implements TextWatcher {
        private static transient /* synthetic */ IpChange $ipChange;
        private su a;
        private View b;

        public C9701b(su suVar, View view) {
            this.a = suVar;
            this.b = view;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "492705177")) {
                ipChange.ipc$dispatch("492705177", new Object[]{this, editable});
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1158823498")) {
                ipChange.ipc$dispatch("1158823498", new Object[]{this, charSequence, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-870668310")) {
                ipChange.ipc$dispatch("-870668310", new Object[]{this, charSequence, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
                return;
            }
            ArrayList arrayList = new ArrayList(5);
            arrayList.add("input");
            arrayList.add(((EditText) this.b).getText());
            this.b.setTag(ny2.DINAMICX_3_CUSTOM_INPUT_KEY, arrayList);
            this.a.postEvent(new t10(su.DXDMINPUT_ONINPUTCHANGE));
        }
    }

    private void c(EditText editText, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1885550186")) {
            ipChange.ipc$dispatch("1885550186", new Object[]{this, editText, Boolean.valueOf(z)});
        } else if (editText != null) {
            editText.setFocusable(z);
            editText.setFocusableInTouchMode(z);
        }
    }

    @Override // com.taobao.android.dinamicx.widget.C6499j, com.taobao.android.dinamicx.widget.DXWidgetNode, com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode
    public DXWidgetNode build(Object obj) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-977860864") ? (DXWidgetNode) ipChange.ipc$dispatch("-977860864", new Object[]{this, obj}) : new su();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.C6499j, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onBindEvent(Context context, View view, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-426668507")) {
            ipChange.ipc$dispatch("-426668507", new Object[]{this, context, view, Long.valueOf(j)});
            return;
        }
        super.onBindEvent(context, view, j);
        if (j == DXDMINPUT_ONINPUTCHANGE && (view instanceof EditText)) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) parent;
                viewGroup.setFocusable(true);
                viewGroup.setFocusableInTouchMode(true);
            }
            int i = a90.TEXT_WATCHER;
            C9701b c9701b = (C9701b) view.getTag(i);
            if (c9701b != null) {
                ((EditText) view).removeTextChangedListener(c9701b);
            }
            C9701b c9701b2 = new C9701b(this, view);
            view.setTag(i, c9701b2);
            ((EditText) view).addTextChangedListener(c9701b2);
        }
    }

    @Override // com.taobao.android.dinamicx.widget.C6499j, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onClone(DXWidgetNode dXWidgetNode, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "462495674")) {
            ipChange.ipc$dispatch("462495674", new Object[]{this, dXWidgetNode, Boolean.valueOf(z)});
        } else {
            super.onClone(dXWidgetNode, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.C6499j, com.taobao.android.dinamicx.widget.DXWidgetNode
    public View onCreateView(Context context) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1261087245") ? (View) ipChange.ipc$dispatch("-1261087245", new Object[]{this, context}) : super.onCreateView(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1413341990")) {
            ipChange.ipc$dispatch("1413341990", new Object[]{this, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
        } else {
            super.onLayout(z, i, i2, i3, i4);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.C6499j, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onMeasure(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "110861812")) {
            ipChange.ipc$dispatch("110861812", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
        } else {
            super.onMeasure(i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.C6499j, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onRenderView(Context context, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1543695975")) {
            ipChange.ipc$dispatch("1543695975", new Object[]{this, context, view});
            return;
        }
        super.onRenderView(context, view);
        if (view instanceof EditText) {
            c((EditText) view, true);
        }
    }
}
