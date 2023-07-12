package com.alibaba.poplayerconsole;

import android.os.Handler;
import android.os.Message;
import android.taobao.windvane.jsbridge.WVApiPlugin;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.taobao.windvane.jsbridge.WVCallMethodContext;
import android.taobao.windvane.jsbridge.WVJsBridge;
import android.taobao.windvane.webview.IWVWebView;
import android.text.TextUtils;
import com.alibaba.poplayer.PopLayer;
import com.alibaba.poplayer.utils.Monitor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import tb.dt1;
import tb.jn1;

/* compiled from: Taobao */
/* renamed from: com.alibaba.poplayerconsole.a */
/* loaded from: classes8.dex */
public final class C3705a {
    private static final Set<String> a = new HashSet();

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.poplayerconsole.a$b */
    /* loaded from: classes8.dex */
    private static final class C3707b implements Handler.Callback {
        private final Handler.Callback a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: Taobao */
        /* renamed from: com.alibaba.poplayerconsole.a$b$a */
        /* loaded from: classes8.dex */
        public class C3708a extends WVCallBackContext {
            final /* synthetic */ WVCallMethodContext a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C3708a(C3707b c3707b, IWVWebView iWVWebView, String str, String str2, String str3, WVCallMethodContext wVCallMethodContext) {
                super(iWVWebView, str, str2, str3);
                this.a = wVCallMethodContext;
            }

            @Override // android.taobao.windvane.jsbridge.WVCallBackContext
            public void error(String str) {
                dt1.a(LogCache.d(this.a, str));
                super.error(str);
            }

            @Override // android.taobao.windvane.jsbridge.WVCallBackContext
            public void success(String str) {
                dt1.b(LogCache.d(this.a, str), new Object[0]);
                super.success(str);
            }
        }

        private boolean a(WVCallMethodContext wVCallMethodContext) {
            dt1.b(LogCache.d(wVCallMethodContext, null), new Object[0]);
            if (((WVApiPlugin) wVCallMethodContext.classinstance).execute(wVCallMethodContext.methodName, TextUtils.isEmpty(wVCallMethodContext.params) ? "{}" : wVCallMethodContext.params, new C3708a(this, wVCallMethodContext.webview, wVCallMethodContext.token, wVCallMethodContext.objectName, wVCallMethodContext.methodName, wVCallMethodContext))) {
                return true;
            }
            WVJsBridge.startCall(2, wVCallMethodContext);
            return true;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 0) {
                return this.a.handleMessage(message);
            }
            WVCallMethodContext wVCallMethodContext = (WVCallMethodContext) message.obj;
            if (wVCallMethodContext == null) {
                return false;
            }
            if (!C3705a.a.contains(wVCallMethodContext.objectName) && !C3705a.a.contains(jn1.MUL)) {
                return this.a.handleMessage(message);
            }
            return a(wVCallMethodContext);
        }

        private C3707b(Handler.Callback callback) {
            this.a = callback;
        }
    }

    private static Field b(Class<?> cls, Class<?> cls2) throws NoSuchFieldException {
        Field[] declaredFields;
        for (Field field : cls2.getDeclaredFields()) {
            if (field.getType() == cls) {
                return field;
            }
        }
        throw new NoSuchFieldException(String.format("Can't find %s in class %s", cls.getName(), cls2.getName()));
    }

    private static Field[] c(Class<?> cls) {
        ArrayList arrayList = new ArrayList();
        do {
            Field[] declaredFields = cls.getDeclaredFields();
            if (declaredFields.length != 0) {
                arrayList.addAll(Arrays.asList(declaredFields));
            }
            cls = cls.getSuperclass();
        } while (cls != null);
        return (Field[]) arrayList.toArray(new Field[0]);
    }

    public static Map<String, Monitor.C3703a> d() throws IllegalArgumentException, IllegalAccessException {
        HashMap hashMap = new HashMap();
        PopLayer reference = PopLayer.getReference();
        if (reference == null) {
            return hashMap;
        }
        e(reference, hashMap, new ArrayList(), null);
        return hashMap;
    }

    private static void e(Object obj, Map<String, Monitor.C3703a> map, List<Object> list, String str) throws IllegalArgumentException, IllegalAccessException {
        Field[] c;
        if (list.contains(obj)) {
            return;
        }
        list.add(obj);
        for (Field field : c(obj.getClass())) {
            Monitor.TargetField targetField = (Monitor.TargetField) field.getAnnotation(Monitor.TargetField.class);
            if (targetField != null) {
                field.setAccessible(true);
                String name = targetField.name();
                Object obj2 = Modifier.isStatic(field.getModifiers()) ? field.get(null) : field.get(obj);
                if (((Monitor.TargetClass) field.getType().getAnnotation(Monitor.TargetClass.class)) == null) {
                    Monitor.C3703a c3703a = new Monitor.C3703a(obj, name, obj2);
                    if (!TextUtils.isEmpty(str)) {
                        name = str + name;
                    }
                    map.put(name, c3703a);
                } else {
                    e(obj2, map, list, TextUtils.isEmpty(str) ? targetField.prefix() : str + targetField.prefix());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void f(String... strArr) throws NoSuchFieldException, IllegalAccessException, IllegalArgumentException {
        a.clear();
        for (String str : strArr) {
            a.add(str);
        }
        WVJsBridge wVJsBridge = WVJsBridge.getInstance();
        Field b = b(Handler.class, WVJsBridge.class);
        b.setAccessible(true);
        Handler handler = (Handler) b.get(WVJsBridge.getInstance());
        Field declaredField = Handler.class.getDeclaredField("mCallback");
        declaredField.setAccessible(true);
        if (declaredField.get(handler) instanceof C3707b) {
            return;
        }
        declaredField.set(handler, new C3707b(wVJsBridge));
    }
}
