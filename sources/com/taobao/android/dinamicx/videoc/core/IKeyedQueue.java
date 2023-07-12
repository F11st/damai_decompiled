package com.taobao.android.dinamicx.videoc.core;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public interface IKeyedQueue<Data> {
    void addCurrent(int i);

    Data addNext(@NonNull Data data);

    boolean contains(@NonNull Data data);

    Data get(int i);

    int indexOf(@NonNull Data data);

    boolean isEmpty();

    Integer keyOf(Data data);

    Data last();

    List<Data> peek();

    List<Data> peekShifted();

    void push(int i, @NonNull List<Data> list);

    void reLoop();

    Data remove(int i);

    Data remove(@NonNull Data data);

    void reset();

    void reset(@Nullable List<Integer> list);

    Data shift(@NonNull Data data);

    int size();

    void skip(Data data);

    List<Data> toList();
}
