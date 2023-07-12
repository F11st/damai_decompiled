package tb;

import android.graphics.Rect;
import android.os.Build;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.taobao.android.dinamic.property.DAttrConstant;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class x21 extends q80 {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public class a implements View.OnTouchListener {
        final /* synthetic */ View a;
        final /* synthetic */ Map b;
        final /* synthetic */ v80 c;
        final /* synthetic */ x80 d;

        a(View view, Map map, v80 v80Var, x80 x80Var) {
            this.a = view;
            this.b = map;
            this.c = v80Var;
            this.d = x80Var;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getActionMasked() == 1) {
                View view2 = this.a;
                int i = a90.KEY_BOARD_LISTENER;
                if (((c) view2.getTag(i)) == null) {
                    ((InputMethodManager) this.a.getContext().getSystemService("input_method")).showSoftInput(this.a, 0);
                    if (this.b.containsKey(DAttrConstant.VIEW_EVENT_BEGIN)) {
                        String str = (String) this.b.get(DAttrConstant.VIEW_EVENT_BEGIN);
                        if (!TextUtils.isEmpty(str)) {
                            ArrayList arrayList = new ArrayList(5);
                            arrayList.add(((EditText) this.a).getText());
                            this.a.setTag(a90.VIEW_PARAMS, arrayList);
                            q80.d(this.a, this.c, this.d, str);
                        }
                    }
                    c cVar = new c(x21.this, this.a, this.d);
                    cVar.e(this.c);
                    this.a.getViewTreeObserver().addOnGlobalLayoutListener(cVar);
                    this.a.setTag(i, cVar);
                }
            }
            return false;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public class b implements TextWatcher {
        private v80 a;
        private x80 b;
        private String c;
        private View d;

        public b(x21 x21Var, View view, x80 x80Var) {
            this.b = x80Var;
            this.d = view;
            Map<String, String> map = x80Var.d;
            if (map.isEmpty()) {
                return;
            }
            this.c = map.get(DAttrConstant.VIEW_EVENT_CHANGE);
            map.get(DAttrConstant.VIEW_EVENT_BEGIN);
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
            if (TextUtils.isEmpty(this.c)) {
                return;
            }
            ArrayList arrayList = new ArrayList(5);
            arrayList.add(((EditText) this.d).getText());
            this.d.setTag(a90.VIEW_PARAMS, arrayList);
            q80.d(this.d, this.a, this.b, this.c);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public class c implements ViewTreeObserver.OnGlobalLayoutListener {
        private v80 a;
        private x80 b;
        private String c;
        private View d;
        private boolean e;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: Taobao */
        /* loaded from: classes11.dex */
        public class a implements View.OnFocusChangeListener {
            a() {
            }

            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z || c.this.e) {
                    return;
                }
                c.this.c();
            }
        }

        public c(x21 x21Var, View view, x80 x80Var) {
            this.b = x80Var;
            this.d = view;
            Map<String, String> map = x80Var.d;
            if (map.isEmpty()) {
                return;
            }
            this.c = map.get(DAttrConstant.VIEW_EVENT_FINISH);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c() {
            if (!TextUtils.isEmpty(this.c)) {
                ArrayList arrayList = new ArrayList(5);
                arrayList.add(((EditText) this.d).getText());
                this.d.setTag(a90.VIEW_PARAMS, arrayList);
                q80.d(this.d, this.a, this.b, this.c);
            }
            if (Build.VERSION.SDK_INT >= 16) {
                this.d.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                this.d.setTag(a90.KEY_BOARD_LISTENER, null);
            } else {
                this.d.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                this.d.setTag(a90.KEY_BOARD_LISTENER, null);
            }
            this.e = true;
        }

        private void d() {
        }

        public void e(v80 v80Var) {
            this.a = v80Var;
            this.d.setOnFocusChangeListener(new a());
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Rect rect = new Rect();
            View rootView = this.d.getRootView();
            rootView.getWindowVisibleDisplayFrame(rect);
            int height = rootView.getHeight();
            if (height - rect.bottom > height / 3) {
                d();
            } else {
                c();
            }
        }
    }

    @Override // tb.q80
    public void b(View view, v80 v80Var) {
        super.b(view, v80Var);
        e(view, v80Var);
    }

    public void e(View view, v80 v80Var) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup != null) {
            viewGroup.setFocusable(true);
            viewGroup.setFocusableInTouchMode(true);
        }
        x80 x80Var = (x80) view.getTag(a90.PROPERTY_KEY);
        if (x80Var == null) {
            return;
        }
        Map<String, String> map = x80Var.d;
        if (map.isEmpty()) {
            return;
        }
        if (view.isFocusable()) {
            if (map.containsKey(DAttrConstant.VIEW_EVENT_CHANGE)) {
                int i = a90.TEXT_WATCHER;
                b bVar = (b) view.getTag(i);
                if (bVar != null) {
                    ((EditText) view).removeTextChangedListener(bVar);
                }
                b bVar2 = new b(this, view, x80Var);
                bVar2.a(v80Var);
                view.setTag(i, bVar2);
                ((EditText) view).addTextChangedListener(bVar2);
            }
            if (map.containsKey(DAttrConstant.VIEW_EVENT_FINISH) || map.containsKey(DAttrConstant.VIEW_EVENT_BEGIN)) {
                view.setOnTouchListener(new a(view, map, v80Var, x80Var));
                return;
            }
            return;
        }
        view.setOnTouchListener(null);
        b bVar3 = (b) view.getTag(a90.TEXT_WATCHER);
        if (bVar3 != null) {
            ((EditText) view).removeTextChangedListener(bVar3);
        }
        view.setOnFocusChangeListener(null);
    }
}
