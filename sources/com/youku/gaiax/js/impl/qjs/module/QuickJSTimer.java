package com.youku.gaiax.js.impl.qjs.module;

import androidx.annotation.Keep;
import com.youku.gaiax.js.GaiaXJS;
import com.youku.gaiax.js.utils.IdGenerator;
import com.youku.gaiax.js.utils.Log;
import com.youku.gaiax.quickjs.JSContext;
import com.youku.gaiax.quickjs.JSFunction;
import com.youku.gaiax.quickjs.JSFunctionCallback;
import com.youku.gaiax.quickjs.JSInt;
import com.youku.gaiax.quickjs.JSNumber;
import com.youku.gaiax.quickjs.JSUndefined;
import com.youku.gaiax.quickjs.JSValue;
import io.flutter.wpkbridge.WPKFactory;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.wt2;

/* compiled from: Taobao */
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\bÁ\u0002\u0018\u00002\u00020\u0001:\u0004\t\n\u000b\fB\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0003\u001a\u00020\u0002H\u0007J\b\u0010\u0004\u001a\u00020\u0002H\u0007J\b\u0010\u0005\u001a\u00020\u0002H\u0007J\b\u0010\u0006\u001a\u00020\u0002H\u0007¨\u0006\r"}, d2 = {"Lcom/youku/gaiax/js/impl/qjs/module/QuickJSTimer;", "", "Lcom/youku/gaiax/quickjs/JSFunctionCallback;", "createClearIntervalFunc", "createSetIntervalFunc", "createClearTimeoutFunc", "createSetTimeoutFunc", "<init>", "()V", "ClearInterval", "ClearTimeout", "SetInterval", "SetTimeout", "GaiaX-Android-JS"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class QuickJSTimer {
    @NotNull
    public static final QuickJSTimer INSTANCE = new QuickJSTimer();

    /* compiled from: Taobao */
    @Keep
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nJ,\u0010\u0007\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0010\u0010\u0006\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0005\u0018\u00010\u0004H\u0096\u0002¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/youku/gaiax/js/impl/qjs/module/QuickJSTimer$ClearInterval;", "Lcom/youku/gaiax/quickjs/JSFunctionCallback;", "Lcom/youku/gaiax/quickjs/JSContext;", WPKFactory.INIT_KEY_CONTEXT, "", "Lcom/youku/gaiax/quickjs/JSValue;", "fromArgs", "invoke", "(Lcom/youku/gaiax/quickjs/JSContext;[Lcom/youku/gaiax/quickjs/JSValue;)Lcom/youku/gaiax/quickjs/JSValue;", "<init>", "()V", "GaiaX-Android-JS"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class ClearInterval implements JSFunctionCallback {
        @Override // com.youku.gaiax.quickjs.JSFunctionCallback
        @NotNull
        public JSValue invoke(@Nullable JSContext jSContext, @Nullable JSValue[] jSValueArr) {
            b41.f(jSContext);
            b41.f(jSValueArr);
            int i = ((JSInt) jSValueArr[0].cast(JSInt.class)).getInt();
            JSValue property = jSContext.getGlobalObject().getProperty("__CONTEXT_ID__");
            if (property instanceof JSInt) {
                long j = ((JSInt) property.cast(JSInt.class)).getLong();
                Log log = Log.INSTANCE;
                if (log.isLog()) {
                    log.e("createClearTimeoutFunc() called with: contextId = " + j + ", taskId = " + i);
                }
                GaiaXJS.Companion.getInstance().remoteIntervalTask(i);
            }
            JSUndefined createJSUndefined = jSContext.createJSUndefined();
            b41.h(createJSUndefined, "jsContext.createJSUndefined()");
            return createJSUndefined;
        }
    }

    /* compiled from: Taobao */
    @Keep
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nJ,\u0010\u0007\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0010\u0010\u0006\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0005\u0018\u00010\u0004H\u0096\u0002¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/youku/gaiax/js/impl/qjs/module/QuickJSTimer$ClearTimeout;", "Lcom/youku/gaiax/quickjs/JSFunctionCallback;", "Lcom/youku/gaiax/quickjs/JSContext;", WPKFactory.INIT_KEY_CONTEXT, "", "Lcom/youku/gaiax/quickjs/JSValue;", "fromArgs", "invoke", "(Lcom/youku/gaiax/quickjs/JSContext;[Lcom/youku/gaiax/quickjs/JSValue;)Lcom/youku/gaiax/quickjs/JSValue;", "<init>", "()V", "GaiaX-Android-JS"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class ClearTimeout implements JSFunctionCallback {
        @Override // com.youku.gaiax.quickjs.JSFunctionCallback
        @NotNull
        public JSValue invoke(@Nullable JSContext jSContext, @Nullable JSValue[] jSValueArr) {
            b41.f(jSContext);
            b41.f(jSValueArr);
            int i = ((JSInt) jSValueArr[0].cast(JSInt.class)).getInt();
            JSValue property = jSContext.getGlobalObject().getProperty("__CONTEXT_ID__");
            if (property instanceof JSInt) {
                long j = ((JSInt) property.cast(JSInt.class)).getLong();
                Log log = Log.INSTANCE;
                if (log.isLog()) {
                    log.e("createClearTimeoutFunc() called with: contextId = " + j + ", taskId = " + i);
                }
                GaiaXJS.Companion.getInstance().remoteDelayTask(i);
            }
            JSUndefined createJSUndefined = jSContext.createJSUndefined();
            b41.h(createJSUndefined, "jsContext.createJSUndefined()");
            return createJSUndefined;
        }
    }

    /* compiled from: Taobao */
    @Keep
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nJ,\u0010\u0007\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0010\u0010\u0006\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0005\u0018\u00010\u0004H\u0096\u0002¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/youku/gaiax/js/impl/qjs/module/QuickJSTimer$SetInterval;", "Lcom/youku/gaiax/quickjs/JSFunctionCallback;", "Lcom/youku/gaiax/quickjs/JSContext;", WPKFactory.INIT_KEY_CONTEXT, "", "Lcom/youku/gaiax/quickjs/JSValue;", "fromArgs", "invoke", "(Lcom/youku/gaiax/quickjs/JSContext;[Lcom/youku/gaiax/quickjs/JSValue;)Lcom/youku/gaiax/quickjs/JSValue;", "<init>", "()V", "GaiaX-Android-JS"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class SetInterval implements JSFunctionCallback {
        @Override // com.youku.gaiax.quickjs.JSFunctionCallback
        @NotNull
        public JSValue invoke(@Nullable final JSContext jSContext, @Nullable JSValue[] jSValueArr) {
            b41.f(jSContext);
            b41.f(jSValueArr);
            final JSFunction jSFunction = (JSFunction) jSValueArr[0].cast(JSFunction.class);
            long j = ((JSInt) jSValueArr[1].cast(JSInt.class)).getLong();
            JSValue property = jSContext.getGlobalObject().getProperty("__CONTEXT_ID__");
            if (property instanceof JSInt) {
                long j2 = ((JSInt) property.cast(JSInt.class)).getLong();
                int genIntId = IdGenerator.INSTANCE.genIntId();
                Log log = Log.INSTANCE;
                if (log.isLog()) {
                    log.e("createSetIntervalFunc() called with: contextId = " + j2 + ", taskId = " + genIntId + ' ');
                }
                GaiaXJS.Companion.getInstance().executeIntervalTask(genIntId, j, new Function0<wt2>() { // from class: com.youku.gaiax.js.impl.qjs.module.QuickJSTimer$SetInterval$invoke$1
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
                        JSFunction.this.invoke(jSContext.createJSUndefined(), new JSValue[0]);
                    }
                });
                JSNumber createJSNumber = jSContext.createJSNumber(genIntId);
                b41.h(createJSNumber, "jsContext.createJSNumber(taskId)");
                return createJSNumber;
            }
            JSUndefined createJSUndefined = jSContext.createJSUndefined();
            b41.h(createJSUndefined, "jsContext.createJSUndefined()");
            return createJSUndefined;
        }
    }

    /* compiled from: Taobao */
    @Keep
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nJ,\u0010\u0007\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0010\u0010\u0006\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0005\u0018\u00010\u0004H\u0096\u0002¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/youku/gaiax/js/impl/qjs/module/QuickJSTimer$SetTimeout;", "Lcom/youku/gaiax/quickjs/JSFunctionCallback;", "Lcom/youku/gaiax/quickjs/JSContext;", WPKFactory.INIT_KEY_CONTEXT, "", "Lcom/youku/gaiax/quickjs/JSValue;", "fromArgs", "invoke", "(Lcom/youku/gaiax/quickjs/JSContext;[Lcom/youku/gaiax/quickjs/JSValue;)Lcom/youku/gaiax/quickjs/JSValue;", "<init>", "()V", "GaiaX-Android-JS"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class SetTimeout implements JSFunctionCallback {
        @Override // com.youku.gaiax.quickjs.JSFunctionCallback
        @NotNull
        public JSValue invoke(@Nullable final JSContext jSContext, @Nullable JSValue[] jSValueArr) {
            b41.f(jSContext);
            b41.f(jSValueArr);
            final JSFunction jSFunction = (JSFunction) jSValueArr[0].cast(JSFunction.class);
            long j = ((JSInt) jSValueArr[1].cast(JSInt.class)).getLong();
            JSValue property = jSContext.getGlobalObject().getProperty("__CONTEXT_ID__");
            if (property instanceof JSInt) {
                long j2 = ((JSInt) property.cast(JSInt.class)).getLong();
                int genIntId = IdGenerator.INSTANCE.genIntId();
                Log log = Log.INSTANCE;
                if (log.isLog()) {
                    log.e("createTimeoutFunc() called with: contextId = " + j2 + ", taskId = " + genIntId);
                }
                GaiaXJS.Companion.getInstance().executeDelayTask(genIntId, j, new Function0<wt2>() { // from class: com.youku.gaiax.js.impl.qjs.module.QuickJSTimer$SetTimeout$invoke$1
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
                        JSFunction.this.invoke(jSContext.createJSUndefined(), new JSValue[0]);
                    }
                });
                JSNumber createJSNumber = jSContext.createJSNumber(genIntId);
                b41.h(createJSNumber, "jsContext.createJSNumber(taskId)");
                return createJSNumber;
            }
            JSUndefined createJSUndefined = jSContext.createJSUndefined();
            b41.h(createJSUndefined, "jsContext.createJSUndefined()");
            return createJSUndefined;
        }
    }

    private QuickJSTimer() {
    }

    @JvmStatic
    @NotNull
    public static final JSFunctionCallback createClearIntervalFunc() {
        return new ClearInterval();
    }

    @JvmStatic
    @NotNull
    public static final JSFunctionCallback createClearTimeoutFunc() {
        return new ClearTimeout();
    }

    @JvmStatic
    @NotNull
    public static final JSFunctionCallback createSetIntervalFunc() {
        return new SetInterval();
    }

    @JvmStatic
    @NotNull
    public static final JSFunctionCallback createSetTimeoutFunc() {
        return new SetTimeout();
    }
}
