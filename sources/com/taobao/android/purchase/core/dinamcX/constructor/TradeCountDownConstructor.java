package com.taobao.android.purchase.core.dinamcX.constructor;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.taobao.android.dinamic.constructor.DTextViewConstructor;
import com.taobao.android.purchase.core.dinamcX.view.CountDownTextView;
import java.util.ArrayList;
import java.util.Map;
import tb.m80;
import tb.q80;
import tb.v80;
import tb.x80;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class TradeCountDownConstructor extends DTextViewConstructor {
    private static final String D_BEGIN_TIME = "dBeginTime";
    private static final String D_COUNT_INTERVAL = "dCountInterval";
    private static final String D_IDLE_TEXT = "dIdleText";
    private static final String D_TIME_IN_FUTURE = "dTimeInFuture";
    private static final String VIEW_EVENT_ON_CLICK = "onClick";
    private static final String VIEW_EVENT_ON_FINISH = "onFinish";
    public static final String VIEW_TAG = "TradeCountDownTimer";

    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.purchase.core.dinamcX.constructor.TradeCountDownConstructor$b */
    /* loaded from: classes11.dex */
    private static class C6564b extends q80 {
        private C6564b() {
        }

        @Override // tb.q80
        public void b(View view, v80 v80Var) {
            e(view, v80Var);
        }

        public void e(View view, v80 v80Var) {
            x80 x80Var = (x80) view.getTag(m80.PROPERTY_KEY);
            if (x80Var == null) {
                return;
            }
            Map<String, String> map = x80Var.d;
            if (map.isEmpty()) {
                return;
            }
            if (map.containsKey("onClick") && (view instanceof CountDownTextView)) {
                view.setOnClickListener(new View$OnClickListenerC6565c(this, v80Var, x80Var, (CountDownTextView) view));
            }
            if (map.containsKey("onFinish") && (view instanceof CountDownTextView)) {
                ((CountDownTextView) view).setOnFinishListener(new C6566d(this, v80Var, x80Var, view));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.purchase.core.dinamcX.constructor.TradeCountDownConstructor$c */
    /* loaded from: classes12.dex */
    public static class View$OnClickListenerC6565c implements View.OnClickListener {
        private C6564b a;
        private v80 b;
        private x80 c;
        private CountDownTextView d;
        private String e;

        public View$OnClickListenerC6565c(C6564b c6564b, v80 v80Var, x80 x80Var, CountDownTextView countDownTextView) {
            this.a = c6564b;
            this.b = v80Var;
            this.c = x80Var;
            this.d = countDownTextView;
            Map<String, String> map = x80Var.d;
            if (map.isEmpty()) {
                return;
            }
            this.e = map.get("onClick");
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.d.isCountDowning() || TextUtils.isEmpty(this.e)) {
                return;
            }
            q80.d(this.d, this.b, this.c, this.e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.purchase.core.dinamcX.constructor.TradeCountDownConstructor$d */
    /* loaded from: classes11.dex */
    public static class C6566d implements CountDownTextView.OnFinishListener {
        private C6564b a;
        private v80 b;
        private x80 c;
        private View d;
        private String e;

        public C6566d(C6564b c6564b, v80 v80Var, x80 x80Var, View view) {
            this.a = c6564b;
            this.b = v80Var;
            this.c = x80Var;
            this.d = view;
            Map<String, String> map = x80Var.d;
            if (map.isEmpty()) {
                return;
            }
            this.e = map.get("onFinish");
        }

        @Override // com.taobao.android.purchase.core.dinamcX.view.CountDownTextView.OnFinishListener
        public void onFinish(CountDownTextView countDownTextView) {
            if (TextUtils.isEmpty(this.e)) {
                return;
            }
            q80.d(this.d, this.b, this.c, this.e);
        }
    }

    @Override // com.taobao.android.dinamic.constructor.DTextViewConstructor, com.taobao.android.dinamic.dinamic.DinamicViewAdvancedConstructor
    public View initializeView(String str, Context context, AttributeSet attributeSet) {
        return new CountDownTextView(context, attributeSet);
    }

    @Override // com.taobao.android.dinamic.constructor.DTextViewConstructor, com.taobao.android.dinamic.dinamic.DinamicViewAdvancedConstructor
    public void setAttributes(View view, Map<String, Object> map, ArrayList<String> arrayList, v80 v80Var) {
        super.setAttributes(view, map, arrayList, v80Var);
        CountDownTextView countDownTextView = view instanceof CountDownTextView ? (CountDownTextView) view : null;
        if (countDownTextView == null) {
            return;
        }
        if (arrayList.contains(D_IDLE_TEXT)) {
            Object obj = map.get(D_IDLE_TEXT);
            countDownTextView.setIdleText(obj != null ? obj.toString() : "");
        }
        if (arrayList.contains(D_COUNT_INTERVAL)) {
            try {
                countDownTextView.setCountInterval(Long.parseLong(map.get(D_COUNT_INTERVAL).toString()));
            } catch (Throwable unused) {
            }
        }
        if (arrayList.contains(D_TIME_IN_FUTURE)) {
            try {
                countDownTextView.setTimeInFuture(Long.parseLong(map.get(D_TIME_IN_FUTURE).toString()));
            } catch (Throwable unused2) {
            }
        }
        if (arrayList.contains(D_BEGIN_TIME)) {
            try {
                countDownTextView.startCount(Long.parseLong(map.get(D_BEGIN_TIME).toString()));
            } catch (Throwable unused3) {
            }
        }
    }

    @Override // com.taobao.android.dinamic.dinamic.DinamicViewAdvancedConstructor
    public void setEvents(View view, v80 v80Var) {
        new C6564b().b(view, v80Var);
    }

    @Override // com.taobao.android.dinamic.constructor.DTextViewConstructor
    public void setText(TextView textView, String str) {
    }
}
