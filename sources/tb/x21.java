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
    /* renamed from: tb.x21$a */
    /* loaded from: classes11.dex */
    public class View$OnTouchListenerC9902a implements View.OnTouchListener {
        final /* synthetic */ View a;
        final /* synthetic */ Map b;
        final /* synthetic */ v80 c;
        final /* synthetic */ x80 d;

        View$OnTouchListenerC9902a(View view, Map map, v80 v80Var, x80 x80Var) {
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
                if (((ViewTreeObserver$OnGlobalLayoutListenerC9904c) view2.getTag(i)) == null) {
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
                    ViewTreeObserver$OnGlobalLayoutListenerC9904c viewTreeObserver$OnGlobalLayoutListenerC9904c = new ViewTreeObserver$OnGlobalLayoutListenerC9904c(x21.this, this.a, this.d);
                    viewTreeObserver$OnGlobalLayoutListenerC9904c.e(this.c);
                    this.a.getViewTreeObserver().addOnGlobalLayoutListener(viewTreeObserver$OnGlobalLayoutListenerC9904c);
                    this.a.setTag(i, viewTreeObserver$OnGlobalLayoutListenerC9904c);
                }
            }
            return false;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: tb.x21$b */
    /* loaded from: classes11.dex */
    public class C9903b implements TextWatcher {
        private v80 a;
        private x80 b;
        private String c;
        private View d;

        public C9903b(x21 x21Var, View view, x80 x80Var) {
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
    /* renamed from: tb.x21$c */
    /* loaded from: classes11.dex */
    public class ViewTreeObserver$OnGlobalLayoutListenerC9904c implements ViewTreeObserver.OnGlobalLayoutListener {
        private v80 a;
        private x80 b;
        private String c;
        private View d;
        private boolean e;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: Taobao */
        /* renamed from: tb.x21$c$a */
        /* loaded from: classes11.dex */
        public class View$OnFocusChangeListenerC9905a implements View.OnFocusChangeListener {
            View$OnFocusChangeListenerC9905a() {
            }

            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z || ViewTreeObserver$OnGlobalLayoutListenerC9904c.this.e) {
                    return;
                }
                ViewTreeObserver$OnGlobalLayoutListenerC9904c.this.c();
            }
        }

        public ViewTreeObserver$OnGlobalLayoutListenerC9904c(x21 x21Var, View view, x80 x80Var) {
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
            this.d.setOnFocusChangeListener(new View$OnFocusChangeListenerC9905a());
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
                C9903b c9903b = (C9903b) view.getTag(i);
                if (c9903b != null) {
                    ((EditText) view).removeTextChangedListener(c9903b);
                }
                C9903b c9903b2 = new C9903b(this, view, x80Var);
                c9903b2.a(v80Var);
                view.setTag(i, c9903b2);
                ((EditText) view).addTextChangedListener(c9903b2);
            }
            if (map.containsKey(DAttrConstant.VIEW_EVENT_FINISH) || map.containsKey(DAttrConstant.VIEW_EVENT_BEGIN)) {
                view.setOnTouchListener(new View$OnTouchListenerC9902a(view, map, v80Var, x80Var));
                return;
            }
            return;
        }
        view.setOnTouchListener(null);
        C9903b c9903b3 = (C9903b) view.getTag(a90.TEXT_WATCHER);
        if (c9903b3 != null) {
            ((EditText) view).removeTextChangedListener(c9903b3);
        }
        view.setOnFocusChangeListener(null);
    }
}
