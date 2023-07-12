package com.youku.gaiax.quickjs;

import androidx.annotation.Keep;
import java.io.Closeable;

/* compiled from: Taobao */
@Keep
/* loaded from: classes2.dex */
public class JSRuntime implements Closeable {
    private long pointer;
    private final QuickJS quickJS;

    /* compiled from: Taobao */
    @Keep
    /* loaded from: classes2.dex */
    public interface InterruptHandler {
        @Keep
        boolean onInterrupt();
    }

    /* compiled from: Taobao */
    @Keep
    /* loaded from: classes2.dex */
    public interface PromiseRejectionHandler {
        @Keep
        void onError(String str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public JSRuntime(long j, QuickJS quickJS) {
        this.pointer = j;
        this.quickJS = quickJS;
    }

    private void checkClosed() {
        if (this.pointer == 0) {
            throw new IllegalStateException("The JSRuntime is closed");
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        long j = this.pointer;
        if (j != 0) {
            this.pointer = 0L;
            QuickJS.destroyRuntime(j);
        }
    }

    public synchronized JSContext createJSContext() {
        long createContext;
        checkClosed();
        createContext = QuickJS.createContext(this.pointer);
        if (createContext != 0) {
        } else {
            throw new IllegalStateException("Cannot create JSContext instance");
        }
        return new JSContext(createContext, this.quickJS, this);
    }

    public synchronized void initStdHandlers() {
        checkClosed();
        QuickJS.initStdHandlers(this.pointer);
    }

    public synchronized void setInterruptHandler(InterruptHandler interruptHandler) {
        checkClosed();
        QuickJS.setRuntimeInterruptHandler(this.pointer, interruptHandler);
    }

    public synchronized void setMallocLimit(int i) {
        checkClosed();
        if (i != 0 && i >= -1) {
            QuickJS.setRuntimeMallocLimit(this.pointer, i);
        } else {
            throw new IllegalArgumentException("Only positive number and -1 are accepted as malloc limit");
        }
    }

    public synchronized void setPromiseRejectionHandler(PromiseRejectionHandler promiseRejectionHandler) {
        checkClosed();
        QuickJS.setPromiseRejectionHandler(this.pointer, promiseRejectionHandler);
    }

    public synchronized void setRuntimeMaxStackSize(int i) {
        checkClosed();
        QuickJS.setRuntimeMaxStackSize(this.pointer, i);
    }
}
