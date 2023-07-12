package com.taobao.android.dinamic.constructor;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.CompoundButton;
import androidx.appcompat.widget.AppCompatCheckBox;
import com.taobao.android.dinamic.R$drawable;
import com.taobao.android.dinamic.R$id;
import com.taobao.android.dinamic.dinamic.DinamicViewAdvancedConstructor;
import com.taobao.android.dinamic.property.DAttrConstant;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Map;
import tb.a90;
import tb.bd0;
import tb.im1;
import tb.p62;
import tb.q80;
import tb.v80;
import tb.x80;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class DCheckBoxConstructor extends DinamicViewAdvancedConstructor {
    private static final String D_CHECKED = "dChecked";
    private static final String D_CHECK_IMG = "dCheckImg";
    private static final String D_DISCHECK_IMG = "dDisCheckImg";
    private static final String D_DISUNCHECK_IMG = "dDisUnCheckImg";
    private static final String D_HEIGHT = "dHeight";
    private static final String D_UNCHECK_IMG = "dUncheckImg";
    private static final String D_WIDTH = "dWidth";
    private static final String VIEW_EVENT_ON_CHANGE = "onChange";
    public static final String VIEW_TAG = "DCheckBox";

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public static class OnChangeListener implements CompoundButton.OnCheckedChangeListener {
        private v80 mDinamicParams;
        private b mHandler;
        private String mOnChangeExpression;
        private x80 mProperty;
        private View mView;

        public OnChangeListener(b bVar, v80 v80Var, x80 x80Var, View view) {
            this.mHandler = bVar;
            this.mDinamicParams = v80Var;
            this.mProperty = x80Var;
            this.mView = view;
            Map<String, String> map = x80Var.d;
            if (map.isEmpty()) {
                return;
            }
            this.mOnChangeExpression = map.get("onChange");
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            Object tag = compoundButton.getTag(R$id.change_with_attribute);
            if (TextUtils.isEmpty(this.mOnChangeExpression) || "true".equals(tag)) {
                return;
            }
            ArrayList arrayList = new ArrayList(5);
            arrayList.add(Boolean.valueOf(compoundButton.isChecked()));
            this.mView.setTag(a90.VIEW_PARAMS, arrayList);
            q80.d(this.mView, this.mDinamicParams, this.mProperty, this.mOnChangeExpression);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    private static class b extends q80 {
        private b() {
        }

        @Override // tb.q80
        public void b(View view, v80 v80Var) {
            e(view, v80Var);
        }

        public void e(View view, v80 v80Var) {
            x80 x80Var = (x80) view.getTag(a90.PROPERTY_KEY);
            if (x80Var == null) {
                return;
            }
            Map<String, String> map = x80Var.d;
            if (!map.isEmpty() && map.containsKey("onChange") && (view instanceof AppCompatCheckBox)) {
                ((AppCompatCheckBox) view).setOnCheckedChangeListener(new OnChangeListener(this, v80Var, x80Var, view));
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public static class c extends AsyncTask<Void, Void, Drawable[]> {
        String a;
        String b;
        String c;
        String d;
        private Context e;
        int f;
        int g;
        private WeakReference<AppCompatCheckBox> h;

        public c(AppCompatCheckBox appCompatCheckBox, String str, String str2, String str3, String str4, int i, int i2) {
            this.a = null;
            this.b = null;
            this.c = null;
            this.d = null;
            this.e = appCompatCheckBox.getContext().getApplicationContext();
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = str4;
            this.f = i;
            this.g = i2;
            this.h = new WeakReference<>(appCompatCheckBox);
        }

        private Drawable b(Context context, int i) {
            return context.getResources().getDrawable(i);
        }

        private Drawable c(Context context, String str) {
            try {
                return context.getResources().getDrawable(context.getResources().getIdentifier(str, "drawable", context.getPackageName()));
            } catch (Throwable unused) {
                return null;
            }
        }

        private StateListDrawable d(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
            return bd0.a(drawable, drawable2, drawable3, drawable4);
        }

        private Drawable f(Drawable drawable, Context context, int i, int i2) {
            if (drawable instanceof BitmapDrawable) {
                Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
                BitmapDrawable bitmapDrawable = new BitmapDrawable(context.getResources(), Bitmap.createScaledBitmap(bitmap, i, i2, true));
                bitmapDrawable.setTargetDensity(bitmap.getDensity());
                return bitmapDrawable;
            }
            return null;
        }

        private void g(AppCompatCheckBox appCompatCheckBox, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
            if (appCompatCheckBox != null) {
                appCompatCheckBox.setButtonDrawable(d(drawable, drawable2, drawable3, drawable4));
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public Drawable[] doInBackground(Void... voidArr) {
            Drawable c = c(this.e, this.a);
            if (c == null) {
                c = b(this.e, R$drawable.dinamicx_checked);
            }
            Drawable f = f(c, this.e, this.f, this.g);
            Drawable c2 = c(this.e, this.b);
            if (c2 == null) {
                c2 = b(this.e, R$drawable.dinamicx_uncheck);
            }
            Drawable f2 = f(c2, this.e, this.f, this.g);
            Drawable c3 = c(this.e, this.c);
            if (c3 == null) {
                c3 = b(this.e, R$drawable.dinamicx_discheck);
            }
            Drawable f3 = f(c3, this.e, this.f, this.g);
            Drawable c4 = c(this.e, this.d);
            if (c4 == null) {
                c4 = b(this.e, R$drawable.dinamicx_disunchk);
            }
            return new Drawable[]{f, f2, f3, f(c4, this.e, this.f, this.g)};
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: e */
        public void onPostExecute(Drawable[] drawableArr) {
            AppCompatCheckBox appCompatCheckBox = this.h.get();
            if (appCompatCheckBox == null) {
                return;
            }
            String str = (String) appCompatCheckBox.getTag(a90.NEED_INT_CHECK_IMG);
            String str2 = (String) appCompatCheckBox.getTag(a90.NEED_INT_UNCHECK_IMG);
            String str3 = (String) appCompatCheckBox.getTag(a90.NEED_INT_DIS_CHECK_IMG);
            String str4 = (String) appCompatCheckBox.getTag(a90.NEED_INT_DIS_UNCHECK_IMG);
            if (str.equals(this.a) && str2.equals(this.b) && str3.equals(this.c) && str4.equals(this.d)) {
                g(appCompatCheckBox, drawableArr[0], drawableArr[1], drawableArr[2], drawableArr[3]);
                appCompatCheckBox.setTag(a90.ALREADY_INT_CHECK_IMG, str);
                appCompatCheckBox.setTag(a90.ALREADY_INT_UNCHECK_IMG, str2);
                appCompatCheckBox.setTag(a90.ALREADY_INT_DIS_CHECK_IMG, str3);
                appCompatCheckBox.setTag(a90.ALREADY_INT_DIS_UNCHECK_IMG, str4);
            }
        }
    }

    private int getDefaultSize(Context context) {
        return (int) TypedValue.applyDimension(1, 17.0f, context.getResources().getDisplayMetrics());
    }

    private void setEnable(View view, boolean z) {
        view.setEnabled(z);
    }

    @Override // com.taobao.android.dinamic.dinamic.DinamicViewAdvancedConstructor
    public View initializeView(String str, Context context, AttributeSet attributeSet) {
        getDefaultSize(context);
        AppCompatCheckBox appCompatCheckBox = new AppCompatCheckBox(context, attributeSet);
        appCompatCheckBox.setClickable(true);
        return appCompatCheckBox;
    }

    @Override // com.taobao.android.dinamic.dinamic.DinamicViewAdvancedConstructor
    public void setAttributes(View view, Map<String, Object> map, ArrayList<String> arrayList, v80 v80Var) {
        int i;
        int i2;
        super.setAttributes(view, map, arrayList, v80Var);
        AppCompatCheckBox appCompatCheckBox = view instanceof AppCompatCheckBox ? (AppCompatCheckBox) view : null;
        if (arrayList.contains("dWidth") || arrayList.contains("dHeight") || arrayList.contains(D_CHECK_IMG) || arrayList.contains(D_UNCHECK_IMG) || arrayList.contains(D_DISCHECK_IMG) || arrayList.contains(D_DISUNCHECK_IMG)) {
            int defaultSize = getDefaultSize(view.getContext());
            int defaultSize2 = getDefaultSize(view.getContext());
            Object obj = map.get("dWidth");
            Object obj2 = map.get("dHeight");
            int b2 = p62.b(view.getContext(), obj, -1);
            int b3 = p62.b(view.getContext(), obj2, -1);
            if (b2 == -1 || b3 == -1) {
                i = defaultSize2;
                i2 = defaultSize;
            } else {
                i2 = b3;
                i = b2;
            }
            String str = (String) map.get(D_CHECK_IMG);
            String str2 = (String) view.getTag(a90.ALREADY_INT_CHECK_IMG);
            if (str == null) {
                str = "dinamicx_checked";
            }
            String str3 = str;
            String str4 = (String) map.get(D_UNCHECK_IMG);
            String str5 = (String) view.getTag(a90.ALREADY_INT_UNCHECK_IMG);
            if (str4 == null) {
                str4 = "dinamicx_uncheck";
            }
            String str6 = str4;
            String str7 = (String) map.get(D_DISCHECK_IMG);
            String str8 = (String) view.getTag(a90.ALREADY_INT_DIS_CHECK_IMG);
            if (str7 == null) {
                str7 = "dinamicx_discheck";
            }
            String str9 = str7;
            String str10 = (String) map.get(D_DISUNCHECK_IMG);
            String str11 = (String) view.getTag(a90.ALREADY_INT_DIS_UNCHECK_IMG);
            if (str10 == null) {
                str10 = "dinamicx_disunchk";
            }
            if (str2 == null && str5 == null && str8 == null && str11 == null) {
                appCompatCheckBox.setButtonDrawable((Drawable) null);
            }
            if (!str3.equals(str2) || !str6.equals(str5) || !str9.equals(str8) || !str10.equals(str11)) {
                view.setTag(a90.NEED_INT_CHECK_IMG, str3);
                view.setTag(a90.NEED_INT_UNCHECK_IMG, str6);
                view.setTag(a90.NEED_INT_DIS_CHECK_IMG, str9);
                view.setTag(a90.NEED_INT_DIS_UNCHECK_IMG, str10);
                new c(appCompatCheckBox, str3, str6, str9, str10, i, i2).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            }
        }
        if (arrayList.contains(D_CHECKED)) {
            setChecked(appCompatCheckBox, im1.b((String) map.get(D_CHECKED)));
        }
        if (arrayList.contains(DAttrConstant.VIEW_ENABLED)) {
            String str12 = (String) map.get(DAttrConstant.VIEW_ENABLED);
            if (!TextUtils.isEmpty(str12)) {
                setEnable(view, im1.b(str12));
            } else {
                setEnable(view, true);
            }
        }
    }

    public void setChecked(AppCompatCheckBox appCompatCheckBox, boolean z) {
        if (appCompatCheckBox != null) {
            int i = R$id.change_with_attribute;
            appCompatCheckBox.setTag(i, "true");
            appCompatCheckBox.setChecked(z);
            appCompatCheckBox.setTag(i, "false");
        }
    }

    @Override // com.taobao.android.dinamic.dinamic.DinamicViewAdvancedConstructor
    public void setEvents(View view, v80 v80Var) {
        new b().b(view, v80Var);
    }
}
