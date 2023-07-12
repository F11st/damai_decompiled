package com.youku.gaiax.js.impl.qjs.module;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.youku.gaiax.js.GaiaXJS;
import com.youku.gaiax.js.api.IGaiaXCallback;
import com.youku.gaiax.js.api.IGaiaXPromise;
import com.youku.gaiax.js.core.GaiaXContext;
import com.youku.gaiax.js.core.api.ICallBridgeListener;
import com.youku.gaiax.js.support.JSDataConvert;
import com.youku.gaiax.js.utils.Log;
import com.youku.gaiax.quickjs.BridgeModuleListener;
import com.youku.gaiax.quickjs.JSContext;
import com.youku.gaiax.quickjs.JSFunction;
import com.youku.gaiax.quickjs.JSObject;
import com.youku.gaiax.quickjs.JSValue;
import com.youku.gaiax.quickjs.PromiseExecutor;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Ref$ObjectRef;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.hh1;
import tb.wt2;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J \u0010\u000e\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0018\u0010\u000f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0018\u0010\u0014\u001a\u00020\u00132\u000e\u0010\u0012\u001a\n\u0018\u00010\u0010j\u0004\u0018\u0001`\u0011H\u0016R\u0016\u0010\u0016\u001a\u00020\u00158\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0019\u001a\u00020\u00188\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001d"}, d2 = {"Lcom/youku/gaiax/js/impl/qjs/module/QuickJSBridgeModule;", "Lcom/youku/gaiax/quickjs/BridgeModuleListener;", "", "result", "", "Lcom/youku/gaiax/quickjs/JSValue;", "arrayOfJSValues", "(Ljava/lang/Object;)[Lcom/youku/gaiax/quickjs/JSValue;", "", "contextPointer", "", "argsMap", "callSync", "funPointer", "callAsync", "callPromise", "Ljava/lang/Exception;", "Lkotlin/Exception;", "e", "Ltb/wt2;", "wrapAsJSValueException", "Lcom/youku/gaiax/js/core/GaiaXContext;", "hostContext", "Lcom/youku/gaiax/js/core/GaiaXContext;", "Lcom/youku/gaiax/quickjs/JSContext;", "jsContext", "Lcom/youku/gaiax/quickjs/JSContext;", "<init>", "(Lcom/youku/gaiax/js/core/GaiaXContext;Lcom/youku/gaiax/quickjs/JSContext;)V", "GaiaX-Android-JS"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class QuickJSBridgeModule implements BridgeModuleListener {
    @NotNull
    private final GaiaXContext hostContext;
    @NotNull
    private final JSContext jsContext;

    public QuickJSBridgeModule(@NotNull GaiaXContext gaiaXContext, @NotNull JSContext jSContext) {
        b41.i(gaiaXContext, "hostContext");
        b41.i(jSContext, "jsContext");
        this.hostContext = gaiaXContext;
        this.jsContext = jSContext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final JSValue[] arrayOfJSValues(Object obj) {
        return obj != null ? new JSValue[]{JSDataConvert.INSTANCE.convertToJSValue(this.jsContext, obj)} : new JSValue[0];
    }

    @Override // com.youku.gaiax.quickjs.BridgeModuleListener
    public long callAsync(long j, final long j2, @NotNull String str) {
        b41.i(str, "argsMap");
        Log log = Log.INSTANCE;
        if (log.isLog()) {
            log.e("callAsync() called with: jsContext = " + j + ", argsMap = " + str);
        }
        if (this.jsContext.pointer == j) {
            JSONObject parseObject = JSON.parseObject(str);
            long longValue = parseObject.getLongValue("contextId");
            long longValue2 = parseObject.getLongValue("moduleId");
            long longValue3 = parseObject.getLongValue("methodId");
            JSONArray jSONArray = parseObject.getJSONArray("args");
            jSONArray.add(new IGaiaXCallback() { // from class: com.youku.gaiax.js.impl.qjs.module.QuickJSBridgeModule$callAsync$1
                @Override // com.youku.gaiax.js.api.IGaiaXCallback
                public void invoke(@Nullable final Object obj) {
                    Log log2 = Log.INSTANCE;
                    if (log2.isLog()) {
                        log2.e(b41.r("callAsync() called with: IGaiaXAsyncCallback result = ", obj));
                    }
                    GaiaXJS companion = GaiaXJS.Companion.getInstance();
                    final long j3 = j2;
                    final QuickJSBridgeModule quickJSBridgeModule = this;
                    companion.executeTask(new Function0<wt2>() { // from class: com.youku.gaiax.js.impl.qjs.module.QuickJSBridgeModule$callAsync$1$invoke$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ wt2 invoke() {
                            invoke2();
                            return wt2.INSTANCE;
                        }

                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            JSContext jSContext;
                            JSValue[] arrayOfJSValues;
                            long j4 = j3;
                            jSContext = quickJSBridgeModule.jsContext;
                            JSFunction jSFunction = new JSFunction(j4, jSContext);
                            jSFunction.dupValue();
                            arrayOfJSValues = quickJSBridgeModule.arrayOfJSValues(obj);
                            jSFunction.invoke(null, arrayOfJSValues);
                            jSFunction.freeValue();
                        }
                    });
                }
            });
            ICallBridgeListener bridge$GaiaX_Android_JS = this.hostContext.getBridge$GaiaX_Android_JS();
            b41.h(jSONArray, "args");
            bridge$GaiaX_Android_JS.callAsync(longValue, longValue2, longValue3, jSONArray);
        }
        return this.jsContext.createJSUndefined().pointer;
    }

    @Override // com.youku.gaiax.quickjs.BridgeModuleListener
    public long callPromise(long j, @NotNull String str) {
        b41.i(str, "argsMap");
        Log log = Log.INSTANCE;
        if (log.isLog()) {
            log.e("callPromise() called with: jsContext = " + j + ", argsMap = " + str);
        }
        JSContext jSContext = this.jsContext;
        if (jSContext.pointer == j) {
            JSONObject parseObject = JSON.parseObject(str);
            long longValue = parseObject.getLongValue("contextId");
            long longValue2 = parseObject.getLongValue("moduleId");
            long longValue3 = parseObject.getLongValue("methodId");
            JSONArray jSONArray = parseObject.getJSONArray("args");
            final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
            final Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
            JSObject createJSPromise = this.jsContext.createJSPromise(new PromiseExecutor() { // from class: com.youku.gaiax.js.impl.qjs.module.QuickJSBridgeModule$callPromise$jsPromise$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.youku.gaiax.quickjs.PromiseExecutor
                public final void execute(JSFunction jSFunction, JSFunction jSFunction2) {
                    ref$ObjectRef.element = jSFunction;
                    ref$ObjectRef2.element = jSFunction2;
                }
            });
            jSONArray.add(new IGaiaXPromise() { // from class: com.youku.gaiax.js.impl.qjs.module.QuickJSBridgeModule$callPromise$1
                @Override // com.youku.gaiax.js.api.IGaiaXPromise
                @NotNull
                public IGaiaXCallback reject() {
                    final Ref$ObjectRef<JSFunction> ref$ObjectRef3 = ref$ObjectRef2;
                    final QuickJSBridgeModule quickJSBridgeModule = this;
                    return new IGaiaXCallback() { // from class: com.youku.gaiax.js.impl.qjs.module.QuickJSBridgeModule$callPromise$1$reject$1
                        @Override // com.youku.gaiax.js.api.IGaiaXCallback
                        public void invoke(@Nullable final Object obj) {
                            GaiaXJS companion = GaiaXJS.Companion.getInstance();
                            final Ref$ObjectRef<JSFunction> ref$ObjectRef4 = ref$ObjectRef3;
                            final QuickJSBridgeModule quickJSBridgeModule2 = quickJSBridgeModule;
                            companion.executeTask(new Function0<wt2>() { // from class: com.youku.gaiax.js.impl.qjs.module.QuickJSBridgeModule$callPromise$1$reject$1$invoke$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public /* bridge */ /* synthetic */ wt2 invoke() {
                                    invoke2();
                                    return wt2.INSTANCE;
                                }

                                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                                public final void invoke2() {
                                    JSValue[] arrayOfJSValues;
                                    JSFunction jSFunction = ref$ObjectRef4.element;
                                    if (jSFunction == null) {
                                        return;
                                    }
                                    arrayOfJSValues = quickJSBridgeModule2.arrayOfJSValues(obj);
                                    jSFunction.invoke(null, arrayOfJSValues);
                                }
                            });
                        }
                    };
                }

                @Override // com.youku.gaiax.js.api.IGaiaXPromise
                @NotNull
                public IGaiaXCallback resolve() {
                    final Ref$ObjectRef<JSFunction> ref$ObjectRef3 = ref$ObjectRef;
                    final QuickJSBridgeModule quickJSBridgeModule = this;
                    return new IGaiaXCallback() { // from class: com.youku.gaiax.js.impl.qjs.module.QuickJSBridgeModule$callPromise$1$resolve$1
                        @Override // com.youku.gaiax.js.api.IGaiaXCallback
                        public void invoke(@Nullable final Object obj) {
                            GaiaXJS companion = GaiaXJS.Companion.getInstance();
                            final Ref$ObjectRef<JSFunction> ref$ObjectRef4 = ref$ObjectRef3;
                            final QuickJSBridgeModule quickJSBridgeModule2 = quickJSBridgeModule;
                            companion.executeTask(new Function0<wt2>() { // from class: com.youku.gaiax.js.impl.qjs.module.QuickJSBridgeModule$callPromise$1$resolve$1$invoke$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public /* bridge */ /* synthetic */ wt2 invoke() {
                                    invoke2();
                                    return wt2.INSTANCE;
                                }

                                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                                public final void invoke2() {
                                    JSValue[] arrayOfJSValues;
                                    JSFunction jSFunction = ref$ObjectRef4.element;
                                    if (jSFunction == null) {
                                        return;
                                    }
                                    arrayOfJSValues = quickJSBridgeModule2.arrayOfJSValues(obj);
                                    jSFunction.invoke(null, arrayOfJSValues);
                                }
                            });
                        }
                    };
                }
            });
            ICallBridgeListener bridge$GaiaX_Android_JS = this.hostContext.getBridge$GaiaX_Android_JS();
            b41.h(jSONArray, "args");
            bridge$GaiaX_Android_JS.callPromise(longValue, longValue2, longValue3, jSONArray);
            return createJSPromise.pointer;
        }
        return jSContext.createJSUndefined().pointer;
    }

    @Override // com.youku.gaiax.quickjs.BridgeModuleListener
    public long callSync(long j, @NotNull String str) {
        b41.i(str, "argsMap");
        Log log = Log.INSTANCE;
        if (log.isLog()) {
            log.e("callSync() called with: jsContext = " + j + ", argsMap = " + str);
        }
        JSContext jSContext = this.jsContext;
        if (jSContext.pointer == j) {
            JSONObject parseObject = JSON.parseObject(str);
            long longValue = parseObject.getLongValue("contextId");
            long longValue2 = parseObject.getLongValue("moduleId");
            long longValue3 = parseObject.getLongValue("methodId");
            JSONArray jSONArray = parseObject.getJSONArray("args");
            ICallBridgeListener bridge$GaiaX_Android_JS = this.hostContext.getBridge$GaiaX_Android_JS();
            b41.h(jSONArray, "args");
            Object callSync = bridge$GaiaX_Android_JS.callSync(longValue, longValue2, longValue3, jSONArray);
            if (callSync == null) {
                callSync = Long.valueOf(this.jsContext.createJSNull().pointer);
            }
            return JSDataConvert.INSTANCE.convertToJSValue(this.jsContext, callSync).pointer;
        }
        return jSContext.createJSUndefined().pointer;
    }

    @Override // com.youku.gaiax.quickjs.BridgeModuleListener
    public void wrapAsJSValueException(@Nullable Exception exc) {
        GaiaXJS.Listener listener$GaiaX_Android_JS;
        if (exc == null || (listener$GaiaX_Android_JS = GaiaXJS.Companion.getInstance().getListener$GaiaX_Android_JS()) == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put((JSONObject) "message", exc.getStackTrace().toString());
        jSONObject2.put((JSONObject) "templateId", "");
        jSONObject2.put((JSONObject) "templateVersion", "");
        jSONObject2.put((JSONObject) hh1.DIMEN_BIZ, "");
        jSONObject.put((JSONObject) "data", (String) jSONObject2);
        wt2 wt2Var = wt2.INSTANCE;
        listener$GaiaX_Android_JS.errorLog(jSONObject);
    }
}
