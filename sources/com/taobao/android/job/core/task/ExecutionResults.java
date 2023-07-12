package com.taobao.android.job.core.task;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public final class ExecutionResults<T, R> {
    private List<ExecutionResult<T, R>> results = new ArrayList();

    public void add(ExecutionResult<T, R> executionResult) {
        this.results.add(executionResult);
    }

    public void addAll(Collection<ExecutionResult<T, R>> collection) {
        this.results.addAll(collection);
    }

    public boolean anySkipped() {
        for (ExecutionResult<T, R> executionResult : this.results) {
            if (executionResult.isSkipped()) {
                return true;
            }
        }
        return false;
    }

    public List<ExecutionResult<T, R>> getAll() {
        return new ArrayList(this.results);
    }

    public ExecutionResult<T, R> getFirst() {
        if (this.results.isEmpty()) {
            return null;
        }
        return this.results.iterator().next();
    }

    public boolean hasAnyResult() {
        return !this.results.isEmpty();
    }

    public String toString() {
        return this.results.toString();
    }
}
