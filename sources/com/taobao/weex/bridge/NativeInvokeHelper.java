package com.taobao.weex.bridge;

import android.util.Log;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.WXSDKManager;
import com.taobao.weex.bridge.SimpleJSCallback;
import com.taobao.weex.utils.WXLogUtils;
import com.taobao.weex.utils.WXReflectionUtils;
import java.lang.reflect.Type;
import tb.gz2;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class NativeInvokeHelper {
    private String mInstanceId;

    public NativeInvokeHelper(String str) {
        this.mInstanceId = str;
    }

    public Object invoke(final Object obj, final Invoker invoker, JSONArray jSONArray) throws Exception {
        final Object[] prepareArguments = prepareArguments(invoker.getParameterTypes(), jSONArray);
        if (gz2.a() && (invoker instanceof MethodInvoker)) {
            int i = 0;
            while (true) {
                if (i >= prepareArguments.length) {
                    break;
                } else if (prepareArguments[i] instanceof SimpleJSCallback) {
                    final String callbackId = ((SimpleJSCallback) prepareArguments[i]).getCallbackId();
                    StringBuilder sb = new StringBuilder();
                    sb.append("[client][callNativeModuleStart],");
                    sb.append(this.mInstanceId);
                    sb.append(",");
                    MethodInvoker methodInvoker = (MethodInvoker) invoker;
                    sb.append(methodInvoker.mMethod.getDeclaringClass());
                    sb.append(",");
                    sb.append(methodInvoker.mMethod.getName());
                    sb.append(",");
                    sb.append(callbackId);
                    Log.d(gz2.INTERACTION_TAG, sb.toString());
                    ((SimpleJSCallback) prepareArguments[i]).setInvokerCallback(new SimpleJSCallback.InvokerCallback() { // from class: com.taobao.weex.bridge.NativeInvokeHelper.1
                        @Override // com.taobao.weex.bridge.SimpleJSCallback.InvokerCallback
                        public void onInvokeSuccess() {
                            Log.d(gz2.INTERACTION_TAG, "[client][callNativeModuleEnd]," + NativeInvokeHelper.this.mInstanceId + "," + ((MethodInvoker) invoker).mMethod.getDeclaringClass() + "," + ((MethodInvoker) invoker).mMethod.getName() + "," + callbackId);
                        }
                    });
                    break;
                } else {
                    i++;
                }
            }
        }
        if (invoker.isRunOnUIThread()) {
            WXSDKManager.v().N(new Runnable() { // from class: com.taobao.weex.bridge.NativeInvokeHelper.2
                @Override // java.lang.Runnable
                public void run() {
                    if (invoker != null) {
                        try {
                            WXSDKInstance y = WXSDKManager.v().y(NativeInvokeHelper.this.mInstanceId);
                            if (y != null && !y.isDestroy()) {
                                invoker.invoke(obj, prepareArguments);
                            }
                        } catch (Exception e) {
                            WXLogUtils.e("NativeInvokeHelper", obj + " Invoker " + invoker.toString() + " exception:" + e);
                        }
                    }
                }
            }, 0L);
            return null;
        }
        return invoker.invoke(obj, prepareArguments);
    }

    protected Object[] prepareArguments(Type[] typeArr, JSONArray jSONArray) throws Exception {
        Object[] objArr = new Object[typeArr.length];
        for (int i = 0; i < typeArr.length; i++) {
            Type type = typeArr[i];
            if (i >= jSONArray.size()) {
                if (!type.getClass().isPrimitive()) {
                    objArr[i] = null;
                } else {
                    throw new Exception("[prepareArguments] method argument list not match.");
                }
            } else {
                Object obj = jSONArray.get(i);
                if (type == JSONObject.class) {
                    if (!(obj instanceof JSONObject) && obj != null) {
                        if (obj instanceof String) {
                            objArr[i] = JSON.parseObject(obj.toString());
                        }
                    } else {
                        objArr[i] = obj;
                    }
                } else if (JSCallback.class == type) {
                    if (obj instanceof String) {
                        objArr[i] = new SimpleJSCallback(this.mInstanceId, (String) obj);
                    } else {
                        throw new Exception("Parameter type not match.");
                    }
                } else {
                    objArr[i] = WXReflectionUtils.parseArgument(type, obj);
                }
            }
        }
        return objArr;
    }
}
