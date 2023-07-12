package com.taobao.android.dinamic.dinamic;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.taobao.android.dinamic.C6313b;
import com.taobao.android.dinamic.log.DinamicLog;
import com.taobao.android.dinamic.property.DAttrConstant;
import com.taobao.android.dinamicx.DXDarkModeCenter;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import tb.f90;
import tb.m80;
import tb.oq;
import tb.p62;
import tb.p80;
import tb.q80;
import tb.v80;
import tb.x80;
import tb.y80;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class DinamicViewAdvancedConstructor {
    private static final String TAG = "DinamicViewAdvancedConstructor";
    private boolean isInitialize = false;
    private boolean isNeedReflect;
    private boolean isRunSuperMethod;
    private List<C6323a> methodInfos;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.dinamic.dinamic.DinamicViewAdvancedConstructor$a */
    /* loaded from: classes12.dex */
    public static class C6323a {
        Method a;
        String[] b;
        Class[] c;

        C6323a(Method method, String[] strArr, Class[] clsArr) {
            this.a = method;
            this.b = strArr;
            this.c = clsArr;
        }
    }

    public DinamicViewAdvancedConstructor() {
        y80.a(new Runnable() { // from class: com.taobao.android.dinamic.dinamic.DinamicViewAdvancedConstructor.1
            @Override // java.lang.Runnable
            public void run() {
                DinamicViewAdvancedConstructor.this.initialize();
            }
        });
    }

    private C6323a findMethodForAttr(String str) {
        for (C6323a c6323a : this.methodInfos) {
            for (String str2 : c6323a.b) {
                if (TextUtils.equals(str, str2)) {
                    return c6323a;
                }
            }
        }
        return null;
    }

    private Method findSetAttributesMethod() {
        try {
            return getClassLoader().loadClass(getClass().getName()).getDeclaredMethod("setAttributes", View.class, Map.class, ArrayList.class, v80.class);
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initialize() {
        this.isNeedReflect = findSetAttributesMethod() == null;
        scanAllDinamicAttrMethods();
        this.isInitialize = true;
    }

    private void scanAllDinamicAttrMethods() {
        Method[] methods;
        try {
            this.methodInfos = new ArrayList();
            for (Method method : getClassLoader().loadClass(getClass().getName()).getMethods()) {
                if (method.isAnnotationPresent(DinamicAttr.class)) {
                    String[] attrSet = ((DinamicAttr) method.getAnnotation(DinamicAttr.class)).attrSet();
                    Class<?>[] parameterTypes = method.getParameterTypes();
                    if (attrSet.length > 0 && parameterTypes.length > 0 && parameterTypes.length - attrSet.length == 1) {
                        this.methodInfos.add(new C6323a(method, attrSet, parameterTypes));
                    } else if (C6313b.e()) {
                        DinamicLog.a(C6313b.TAG, "Senioronstructor scanAllDinamicAttrMethods function info error");
                    }
                }
            }
        } catch (Throwable th) {
            if (C6313b.e()) {
                DinamicLog.i(C6313b.TAG, th, "Senioronstructor scanAllDinamicAttrMethods exception");
            }
        }
    }

    private void setSpecificAttributes(View view, Map<String, Object> map, v80 v80Var) {
        boolean z;
        C6323a findMethodForAttr;
        Object obj;
        Class[] clsArr;
        View view2 = view;
        List<C6323a> list = this.methodInfos;
        if (list == null || list.size() == 0) {
            return;
        }
        x80 c = f90.c(view);
        Map<String, Object> map2 = c.b;
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            Iterator it = arrayList.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (TextUtils.equals((String) it.next(), entry.getKey())) {
                        z = true;
                        break;
                    }
                } else {
                    z = false;
                    break;
                }
            }
            if (!z && (findMethodForAttr = findMethodForAttr(entry.getKey())) != null) {
                Method method = findMethodForAttr.a;
                String[] strArr = findMethodForAttr.b;
                Class[] clsArr2 = findMethodForAttr.c;
                if (strArr.length > 1) {
                    arrayList.addAll(Arrays.asList(strArr));
                }
                Object[] objArr = new Object[clsArr2.length];
                if (!clsArr2[0].isInstance(view2)) {
                    v80Var.e().b().a(p80.ERROR_CODE_VIEW_EXCEPTION, c.a);
                    if (C6313b.e()) {
                        DinamicLog.e(C6313b.TAG, "Senioronstructor first param class not match");
                    }
                } else {
                    objArr[0] = view2;
                    int i = 0;
                    while (i < strArr.length) {
                        if ("module".equals(strArr[i])) {
                            obj = v80Var.c();
                        } else if (DAttrConstant.DINAMIC_CONTEXT.equals(strArr[i])) {
                            obj = v80Var.b();
                        } else if (DAttrConstant.DINAMIC_PARAMS.equals(strArr[i])) {
                            obj = v80Var;
                        } else if (map.containsKey(strArr[i])) {
                            obj = map.get(strArr[i]);
                        } else {
                            obj = map2.get(strArr[i]);
                        }
                        int i2 = i + 1;
                        if (clsArr2[i2].isInstance(obj)) {
                            objArr[i2] = obj;
                            clsArr = clsArr2;
                        } else {
                            if (obj != null) {
                                v80Var.e().b().a(p80.ERROR_CODE_VIEW_EXCEPTION, c.a);
                            }
                            if (C6313b.e()) {
                                clsArr = clsArr2;
                                DinamicLog.e(C6313b.TAG, String.format("AdvancedConstructor %s value is null or not exist", strArr[i]));
                            } else {
                                clsArr = clsArr2;
                            }
                            objArr[i2] = null;
                        }
                        i = i2;
                        clsArr2 = clsArr;
                    }
                    try {
                        method.invoke(this, objArr);
                    } catch (Exception e) {
                        v80Var.e().b().a(p80.ERROR_CODE_VIEW_EXCEPTION, c.a);
                        if (C6313b.e()) {
                            DinamicLog.i(C6313b.TAG, e, "AdvancedConstructor method invoke exception");
                        }
                    }
                    view2 = view;
                }
            }
        }
    }

    @Deprecated
    public void applyDefaultProperty(View view) {
    }

    public void applyDefaultProperty(View view, Map<String, Object> map, v80 v80Var) {
        if (!map.containsKey("dBackgroundColor")) {
            view.setBackgroundColor(0);
        }
        if (!map.containsKey(DAttrConstant.VIEW_ALPHA)) {
            view.setAlpha(1.0f);
        }
        applyDefaultProperty(view);
    }

    public void bindDataImpl(View view, Map<String, Object> map, ArrayList<String> arrayList, v80 v80Var) {
        if (needBindData(view, map, v80Var)) {
            setAttributes(view, map, arrayList, v80Var);
        }
    }

    protected ClassLoader getClassLoader() {
        return getClass().getClassLoader();
    }

    public Class getDebugClass() {
        try {
            return getClassLoader().loadClass(getClass().getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public final x80 handleAttributeSet(AttributeSet attributeSet) {
        x80 x80Var = new x80();
        int attributeCount = attributeSet.getAttributeCount();
        if (attributeCount <= 0) {
            return x80Var;
        }
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        for (int i = 0; i < attributeCount; i++) {
            String attributeName = attributeSet.getAttributeName(i);
            String attributeValue = attributeSet.getAttributeValue(m80.RES_AUTO_NAMESPACE, attributeName);
            if (attributeValue != null) {
                if (attributeName.startsWith("on")) {
                    hashMap3.put(attributeName, attributeValue);
                } else if (!attributeValue.startsWith("$") && !attributeValue.startsWith(m80.DINAMIC_PREFIX_AT)) {
                    hashMap.put(attributeName, attributeValue);
                } else {
                    hashMap2.put(attributeName, attributeValue);
                }
            }
        }
        x80Var.b = hashMap;
        x80Var.c = Collections.unmodifiableMap(hashMap2);
        x80Var.d = Collections.unmodifiableMap(hashMap3);
        return x80Var;
    }

    public View initializeView(String str, Context context, AttributeSet attributeSet) {
        return new View(context, attributeSet);
    }

    public View initializeViewWithModule(String str, Context context, AttributeSet attributeSet, v80 v80Var) {
        return initializeView(str, context, attributeSet);
    }

    public boolean needBindData(View view, Map<String, Object> map, v80 v80Var) {
        if (map.containsKey(DAttrConstant.VIEW_VISIBILITY)) {
            Object obj = map.get(DAttrConstant.VIEW_VISIBILITY);
            if (obj instanceof String) {
                setVisibility(view, (String) obj);
            }
        }
        return view.getVisibility() != 8;
    }

    public void setAccessibilityHidden(View view, boolean z) {
        if (Build.VERSION.SDK_INT < 16) {
            view.setContentDescription("");
        } else if (z) {
            view.setImportantForAccessibility(2);
        } else {
            view.setImportantForAccessibility(1);
        }
    }

    public void setAccessibilityText(View view, String str) {
        view.setContentDescription(str);
    }

    public void setAlpha(View view, String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                view.setAlpha(Float.valueOf(str).floatValue());
                return;
            } catch (NumberFormatException unused) {
                view.setAlpha(1.0f);
                return;
            }
        }
        view.setAlpha(1.0f);
    }

    public void setAttributes(View view, Map<String, Object> map, ArrayList<String> arrayList, v80 v80Var) {
        if (arrayList.contains("dBackgroundColor") || arrayList.contains(DAttrConstant.VIEW_CORNER_RADIUS) || arrayList.contains(DAttrConstant.VIEW_BORDER_COLOR) || arrayList.contains(DAttrConstant.VIEW_BORDER_WIDTH)) {
            setBackground(view, (String) map.get(DAttrConstant.VIEW_CORNER_RADIUS), (String) map.get(DAttrConstant.VIEW_BORDER_COLOR), (String) map.get(DAttrConstant.VIEW_BORDER_WIDTH), (String) map.get("dBackgroundColor"));
        }
        if (arrayList.contains(DAttrConstant.VIEW_ALPHA)) {
            setAlpha(view, (String) map.get(DAttrConstant.VIEW_ALPHA));
        }
        if (arrayList.contains(DAttrConstant.VIEW_ACCESSIBILITYTEXT)) {
            setAccessibilityText(view, (String) map.get(DAttrConstant.VIEW_ACCESSIBILITYTEXT));
        }
        if (arrayList.contains(DAttrConstant.VIEW_ACCESSIBILITYTEXT_HIDDEN)) {
            String str = (String) map.get(DAttrConstant.VIEW_ACCESSIBILITYTEXT_HIDDEN);
            if (!TextUtils.isEmpty(str)) {
                setAccessibilityHidden(view, Boolean.valueOf(str).booleanValue());
            } else {
                setAccessibilityHidden(view, true);
            }
        }
        if (arrayList.contains(DAttrConstant.VIEW_DISABLE_DARK_MODE)) {
            setForceDark(view, Boolean.valueOf((String) map.get(DAttrConstant.VIEW_DISABLE_DARK_MODE)).booleanValue());
        }
        if (!this.isInitialize) {
            initialize();
        }
        if (this.isNeedReflect) {
            HashMap hashMap = new HashMap();
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                String next = it.next();
                hashMap.put(next, map.get(next));
            }
            setSpecificAttributes(view, hashMap, v80Var);
        }
    }

    public void setBackground(View view, String str, String str2, String str3, String str4) {
        Drawable background = view.getBackground();
        if (background != null && (background instanceof GradientDrawable)) {
            GradientDrawable gradientDrawable = (GradientDrawable) background;
            int d = oq.d(str4, 0);
            if (!TextUtils.isEmpty(str4)) {
                gradientDrawable.setColor(d);
            }
            if (!TextUtils.isEmpty(str)) {
                gradientDrawable.setCornerRadius(p62.b(view.getContext(), str, 0));
            }
            if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
                return;
            }
            gradientDrawable.setStroke(p62.b(view.getContext(), str3, 0), oq.d(str2, d));
        } else if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
            view.setBackgroundColor(oq.d(str4, 0));
        } else {
            int d2 = oq.d(str4, 0);
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            int b = p62.b(view.getContext(), str, 0);
            int d3 = oq.d(str2, d2);
            int b2 = p62.b(view.getContext(), str3, 0);
            gradientDrawable2.setCornerRadius(b);
            gradientDrawable2.setShape(0);
            gradientDrawable2.setColor(d2);
            if (b2 > 0) {
                gradientDrawable2.setStroke(b2, d3);
            }
            if (Build.VERSION.SDK_INT >= 16) {
                view.setBackground(gradientDrawable2);
            } else {
                view.setBackgroundDrawable(gradientDrawable2);
            }
        }
    }

    public void setEvents(View view, v80 v80Var) {
        new q80().b(view, v80Var);
    }

    protected void setForceDark(View view, boolean z) {
        if (z) {
            DXDarkModeCenter.a(view);
        }
    }

    public void setVisibility(View view, String str) {
        if (TextUtils.equals("visible", str)) {
            view.setVisibility(0);
        } else if (TextUtils.equals(DAttrConstant.VISIBILITY_INVISIBLE, str)) {
            view.setVisibility(4);
        } else if (TextUtils.equals("gone", str)) {
            view.setVisibility(8);
        } else {
            view.setVisibility(0);
        }
    }
}
