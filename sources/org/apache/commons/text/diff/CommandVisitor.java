package org.apache.commons.text.diff;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public interface CommandVisitor<T> {
    void visitDeleteCommand(T t);

    void visitInsertCommand(T t);

    void visitKeepCommand(T t);
}
