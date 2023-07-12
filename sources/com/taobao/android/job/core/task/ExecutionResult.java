package com.taobao.android.job.core.task;

import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public final class ExecutionResult<T, R> {
    private static final String EMPTY = "";
    private final T id;
    private final String message;
    private final R result;
    private int status;
    private final ExecutionSummary summary;

    public ExecutionResult(T t, R r, int i, ExecutionSummary executionSummary) {
        this(t, r, i, "", executionSummary);
    }

    public static <T, R> ExecutionResult<T, R> failed(T t, R r, String str) {
        return new ExecutionResult<>(t, r, 0, str, ExecutionSummary.create(-1L, -1L));
    }

    public static <T, R> ExecutionResult<T, R> success(T t, R r, long j, long j2) {
        return new ExecutionResult<>(t, r, 2, "", ExecutionSummary.create(j, j2));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && ExecutionResult.class == obj.getClass()) {
            ExecutionResult executionResult = (ExecutionResult) obj;
            T t = this.id;
            if (t == null) {
                if (executionResult.id != null) {
                    return false;
                }
            } else if (!t.equals(executionResult.id)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public T getId() {
        return this.id;
    }

    public String getMessage() {
        return this.message;
    }

    public R getResult() {
        return this.result;
    }

    public int getStatus() {
        return this.status;
    }

    public ExecutionSummary getSummary() {
        return this.summary;
    }

    public int hashCode() {
        T t = this.id;
        return 31 + (t == null ? 0 : t.hashCode());
    }

    public boolean isFailed() {
        return this.status == 0;
    }

    public boolean isSkipped() {
        return 1 == this.status;
    }

    public boolean isSuccess() {
        return 2 == this.status;
    }

    public void skipped() {
        this.status = 1;
    }

    public String toString() {
        return "ExecutionResult [id=" + this.id + ", result=" + this.result + ", status=" + this.status + ", message=" + this.message + jn1.ARRAY_END_STR;
    }

    private ExecutionResult(T t, R r, int i, String str, ExecutionSummary executionSummary) {
        this.status = 2;
        this.id = t;
        this.result = r;
        this.status = i;
        this.message = str;
        this.summary = executionSummary;
    }

    public void failed() {
        this.status = 0;
    }
}
