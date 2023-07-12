package com.alibaba.poplayer.trigger.view;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import com.alibaba.poplayer.PopLayer;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import tb.dt1;
import tb.fw2;
import tb.jn1;

/* compiled from: Taobao */
/* renamed from: com.alibaba.poplayer.trigger.view.c */
/* loaded from: classes8.dex */
public final class C3698c {
    private final Rect a = new Rect();
    private final int[] b = new int[2];
    private final Map<String, WeakReference<View>[]> c = new HashMap();
    private final Map<Class, String> d = new HashMap();
    private final Pattern e = Pattern.compile("\\[.*?\\]");

    private View a(View view, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            view = (View) view.getParent();
        }
        return view;
    }

    private List<View> c(String[] strArr, List<View> list) {
        List asList = Arrays.asList(strArr);
        Collections.reverse(asList);
        String[] strArr2 = (String[]) asList.toArray(new String[0]);
        ArrayList arrayList = new ArrayList(list);
        for (View view : list) {
            View[] e = e(view);
            int i = 0;
            while (true) {
                if (i >= strArr2.length) {
                    break;
                } else if (!j(strArr2[i], e[i])) {
                    arrayList.remove(view);
                    break;
                } else {
                    i++;
                }
            }
        }
        return arrayList;
    }

    private String d(Class cls) {
        String str = this.d.get(cls);
        if (TextUtils.isEmpty(str)) {
            String name = cls.getName();
            this.d.put(cls, name);
            return name;
        }
        return str;
    }

    private View[] e(View view) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(view);
        while (true) {
            ViewParent parent = view.getParent();
            if (!(parent instanceof View)) {
                return (View[]) arrayList.toArray(new View[0]);
            }
            view = (View) parent;
            arrayList.add(view);
        }
    }

    private String f(View view, String str) {
        String str2;
        if ("id".equals(str)) {
            int id = view.getId();
            if (-1 != id && id != 0) {
                Resources resources = view.getResources();
                int i = (-16777216) & id;
                if (i == 16777216) {
                    str2 = "android";
                } else if (i != 2130706432) {
                    try {
                        str2 = resources.getResourcePackageName(id);
                    } catch (Resources.NotFoundException e) {
                        dt1.c("Selector.getID.error", e);
                    }
                } else {
                    str2 = "app";
                }
                String resourceTypeName = resources.getResourceTypeName(id);
                String resourceEntryName = resources.getResourceEntryName(id);
                return str2 + ":" + resourceTypeName + "/" + resourceEntryName;
            }
            return null;
        } else if ("text".equals(str) && (view instanceof TextView)) {
            CharSequence text = ((TextView) view).getText();
            if (text == null) {
                return null;
            }
            return text.toString();
        } else if ("contentDescription".equals(str)) {
            CharSequence contentDescription = view.getContentDescription();
            if (contentDescription == null) {
                return null;
            }
            return contentDescription.toString();
        } else if ("tag".equals(str)) {
            Object tag = view.getTag();
            if (tag == null) {
                return null;
            }
            return tag.toString();
        } else {
            try {
                dt1.b("Selector.getViewProperty:getPropertyWithMethod:%s.", str);
                Class<?> cls = view.getClass();
                do {
                    Method declaredMethod = cls.getDeclaredMethod(str, new Class[0]);
                    if (declaredMethod != null) {
                        declaredMethod.setAccessible(true);
                        String obj = declaredMethod.invoke(view, new Object[0]).toString();
                        dt1.b("Selector.getViewProperty:find - method key:%s,value:%s.", str, obj);
                        return obj;
                    }
                    cls = cls.getSuperclass();
                } while (cls != Object.class);
                dt1.b("Selector.getViewProperty:not find ", new Object[0]);
                return null;
            } catch (Throwable th) {
                dt1.c("Selector.getViewProperty.error", th);
                return null;
            }
        }
    }

    private void g(View view, Rect rect) {
        view.getLocationOnScreen(this.b);
        int[] iArr = this.b;
        int i = iArr[0];
        rect.left = i;
        rect.top = iArr[1];
        rect.right = i + view.getWidth();
        rect.bottom = rect.top + view.getHeight();
    }

    private void h(View view, int i, int i2, List<View> list) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                h(viewGroup.getChildAt(i3), i, i2, list);
            }
            return;
        }
        g(view, this.a);
        if (this.a.contains(i, i2)) {
            list.add(view);
        }
    }

    private void i(View view, String str, List<View> list) {
        if (str.equals(d(view.getClass())) && view.getVisibility() == 0) {
            list.add(view);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                i(viewGroup.getChildAt(i), str, list);
            }
        }
    }

    private boolean j(String str, View view) {
        int indexOf = str.indexOf(91);
        String d = d(view.getClass());
        if (-1 == indexOf) {
            return d.equals(str);
        }
        if (d.equals(str.substring(0, indexOf))) {
            Matcher matcher = this.e.matcher(str);
            while (matcher.find()) {
                String group = matcher.group();
                String[] split = group.substring(1, group.length() - 1).split("=");
                if (!split[1].equals(f(view, split[0]))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    private WeakReference<View>[] m(View[] viewArr) {
        int length = viewArr.length;
        WeakReference<View>[] weakReferenceArr = new WeakReference[length];
        for (int i = 0; i < length; i++) {
            weakReferenceArr[i] = new WeakReference<>(viewArr[i]);
        }
        return weakReferenceArr;
    }

    private View[] n(WeakReference<View>[] weakReferenceArr) {
        if (weakReferenceArr == null) {
            return null;
        }
        int length = weakReferenceArr.length;
        View[] viewArr = new View[length];
        for (int i = 0; i < length; i++) {
            viewArr[i] = weakReferenceArr[i].get();
            if (viewArr[i] == null) {
                return null;
            }
        }
        return viewArr;
    }

    public void b() {
        this.c.clear();
        this.d.clear();
    }

    public View[] k(int i, int i2) {
        ViewGroup e = fw2.e(PopLayer.getReference().internalGetCurrentActivity());
        ArrayList arrayList = new ArrayList();
        h(e, i, i2, arrayList);
        return (View[]) arrayList.toArray(new View[0]);
    }

    public View[] l(String str, boolean z) throws ClassNotFoundException {
        View[] n = z ? n(this.c.get(str)) : null;
        if (n != null) {
            return n;
        }
        PopLayer reference = PopLayer.getReference();
        if (reference == null) {
            dt1.a("Selector.selectViewsBySelector{%s}.popLayer is not setup.error");
            return null;
        }
        Activity internalGetCurrentActivity = reference.internalGetCurrentActivity();
        if (internalGetCurrentActivity == null) {
            dt1.a("Selector.selectViewsBySelector{%s}.activityIsNull.error");
            return null;
        }
        int indexOf = str.indexOf(60);
        String[] split = (-1 == indexOf ? str : str.substring(0, indexOf)).split(jn1.G);
        String str2 = split[split.length - 1];
        int indexOf2 = str2.indexOf(91);
        if (-1 != indexOf2) {
            str2 = str2.substring(0, indexOf2);
        }
        ArrayList arrayList = new ArrayList();
        i(fw2.e(internalGetCurrentActivity), str2, arrayList);
        View[] viewArr = (View[]) c(split, arrayList).toArray(new View[0]);
        if (viewArr.length == 0) {
            return viewArr;
        }
        if (-1 != indexOf) {
            int length = str.substring(indexOf).length();
            dt1.b("Selector.selectViewsBySelector.backupon.counts{%s}", Integer.valueOf(length));
            for (int i = 0; i < viewArr.length; i++) {
                viewArr[i] = a(viewArr[i], length);
            }
        }
        this.c.put(str, m(viewArr));
        return viewArr;
    }
}
