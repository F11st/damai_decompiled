package com.taobao.weex.ui;

import android.util.Pair;
import com.taobao.weex.WXEnvironment;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.annotation.Component;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.bridge.Invoker;
import com.taobao.weex.bridge.MethodInvoker;
import com.taobao.weex.common.WXRuntimeException;
import com.taobao.weex.ui.action.BasicComponentData;
import com.taobao.weex.ui.component.WXComponent;
import com.taobao.weex.ui.component.WXComponentProp;
import com.taobao.weex.ui.component.WXVContainer;
import com.taobao.weex.utils.WXLogUtils;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class SimpleComponentHolder implements IFComponentHolder {
    public static final String TAG = "SimpleComponentHolder";
    private final Class<? extends WXComponent> mClz;
    private ComponentCreator mCreator;
    private Map<String, Invoker> mMethodInvokers;
    private Map<String, Invoker> mPropertyInvokers;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class ClazzComponentCreator implements ComponentCreator {
        private final Class<? extends WXComponent> mCompClz;
        private Constructor<? extends WXComponent> mConstructor;

        public ClazzComponentCreator(Class<? extends WXComponent> cls) {
            this.mCompClz = cls;
        }

        private void loadConstructor() {
            Constructor<? extends WXComponent> constructor;
            Class<? extends WXComponent> cls = this.mCompClz;
            try {
                constructor = cls.getConstructor(WXSDKInstance.class, WXVContainer.class, BasicComponentData.class);
            } catch (NoSuchMethodException unused) {
                WXLogUtils.d("ClazzComponentCreator", "Use deprecated component constructor");
                try {
                    constructor = cls.getConstructor(WXSDKInstance.class, WXVContainer.class, Boolean.TYPE, BasicComponentData.class);
                } catch (NoSuchMethodException unused2) {
                    try {
                        constructor = cls.getConstructor(WXSDKInstance.class, WXVContainer.class, String.class, Boolean.TYPE, BasicComponentData.class);
                    } catch (NoSuchMethodException unused3) {
                        throw new WXRuntimeException("Can't find constructor of component.");
                    }
                }
            }
            this.mConstructor = constructor;
        }

        @Override // com.taobao.weex.ui.ComponentCreator
        public WXComponent createInstance(WXSDKInstance wXSDKInstance, WXVContainer wXVContainer, BasicComponentData basicComponentData) throws IllegalAccessException, InvocationTargetException, InstantiationException {
            if (this.mConstructor == null) {
                loadConstructor();
            }
            int length = this.mConstructor.getParameterTypes().length;
            return length == 3 ? this.mConstructor.newInstance(wXSDKInstance, wXVContainer, basicComponentData) : length == 4 ? this.mConstructor.newInstance(wXSDKInstance, wXVContainer, Boolean.FALSE, basicComponentData) : this.mConstructor.newInstance(wXSDKInstance, wXVContainer, wXSDKInstance.getInstanceId(), Boolean.valueOf(wXVContainer.isLazy()));
        }
    }

    public SimpleComponentHolder(Class<? extends WXComponent> cls) {
        this(cls, new ClazzComponentCreator(cls));
    }

    private synchronized void generate() {
        if (WXEnvironment.isApkDebugable()) {
            WXLogUtils.d("SimpleComponentHolder", "Generate Component:" + this.mClz.getSimpleName());
        }
        Pair<Map<String, Invoker>, Map<String, Invoker>> methods = getMethods(this.mClz);
        this.mPropertyInvokers = (Map) methods.first;
        this.mMethodInvokers = (Map) methods.second;
    }

    public static Pair<Map<String, Invoker>, Map<String, Invoker>> getMethods(Class cls) {
        Method[] methods;
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        try {
            for (Method method : cls.getMethods()) {
                try {
                    Annotation[] declaredAnnotations = method.getDeclaredAnnotations();
                    int length = declaredAnnotations.length;
                    int i = 0;
                    while (true) {
                        if (i >= length) {
                            break;
                        }
                        Annotation annotation = declaredAnnotations[i];
                        if (annotation != null) {
                            if (annotation instanceof WXComponentProp) {
                                hashMap.put(((WXComponentProp) annotation).name(), new MethodInvoker(method, true));
                                break;
                            } else if (annotation instanceof JSMethod) {
                                JSMethod jSMethod = (JSMethod) annotation;
                                String alias = jSMethod.alias();
                                if (JSMethod.NOT_SET.equals(alias)) {
                                    alias = method.getName();
                                }
                                hashMap2.put(alias, new MethodInvoker(method, jSMethod.uiThread()));
                            }
                        }
                        i++;
                    }
                } catch (ArrayIndexOutOfBoundsException | IncompatibleClassChangeError unused) {
                }
            }
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            WXLogUtils.e("SimpleComponentHolder", e2);
        }
        return new Pair<>(hashMap, hashMap2);
    }

    @Override // com.taobao.weex.ui.ComponentCreator
    public synchronized WXComponent createInstance(WXSDKInstance wXSDKInstance, WXVContainer wXVContainer, BasicComponentData basicComponentData) throws IllegalAccessException, InvocationTargetException, InstantiationException {
        WXComponent createInstance;
        createInstance = this.mCreator.createInstance(wXSDKInstance, wXVContainer, basicComponentData);
        createInstance.bindHolder(this);
        return createInstance;
    }

    @Override // com.taobao.weex.bridge.JavascriptInvokable
    public Invoker getMethodInvoker(String str) {
        if (this.mMethodInvokers == null) {
            generate();
        }
        return this.mMethodInvokers.get(str);
    }

    @Override // com.taobao.weex.ui.IFComponentHolder
    public synchronized Invoker getPropertyInvoker(String str) {
        if (this.mPropertyInvokers == null) {
            generate();
        }
        return this.mPropertyInvokers.get(str);
    }

    @Override // com.taobao.weex.ui.IFComponentHolder
    public void loadIfNonLazy() {
        Annotation[] declaredAnnotations;
        for (Annotation annotation : this.mClz.getDeclaredAnnotations()) {
            if (annotation instanceof Component) {
                if (((Component) annotation).lazyload() || this.mMethodInvokers != null) {
                    return;
                }
                generate();
                return;
            }
        }
    }

    public SimpleComponentHolder(Class<? extends WXComponent> cls, ComponentCreator componentCreator) {
        this.mClz = cls;
        this.mCreator = componentCreator;
    }

    @Override // com.taobao.weex.bridge.JavascriptInvokable
    public synchronized String[] getMethods() {
        Set<String> keySet;
        if (this.mMethodInvokers == null) {
            generate();
        }
        keySet = this.mMethodInvokers.keySet();
        return (String[]) keySet.toArray(new String[keySet.size()]);
    }
}
