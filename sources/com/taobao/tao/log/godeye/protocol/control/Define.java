package com.taobao.tao.log.godeye.protocol.control;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class Define<T> {
    List<Entry<T>> DEFINE = new CopyOnWriteArrayList();

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class Entry<T> {
        String opCode;
        T value;

        private Entry(String str, T t) {
            this.opCode = str;
            this.value = t;
        }

        public static <T> Entry<T> build(String str, T t) {
            return new Entry<>(str, t);
        }

        public String getOpCode() {
            return this.opCode;
        }

        public T getValue() {
            return this.value;
        }
    }

    public Entry<T> getDefine(T t) {
        for (Entry<T> entry : this.DEFINE) {
            if (entry.getValue().equals(t)) {
                return entry;
            }
        }
        return null;
    }

    public T getValue(String str) {
        for (Entry<T> entry : this.DEFINE) {
            if (entry.getOpCode().equals(str)) {
                return entry.getValue();
            }
        }
        return null;
    }

    public void register(Entry<T> entry) {
        Objects.requireNonNull(entry, "entry");
        Objects.requireNonNull(entry.getValue(), "value");
        for (Entry<T> entry2 : this.DEFINE) {
            if (!entry2.getOpCode().equals(entry.getOpCode())) {
                if (entry2.getValue().equals(entry.getValue())) {
                    throw new IllegalArgumentException(String.format("same value exist. OpCode:%s vlaue class:%s", entry.getOpCode(), entry.getValue().getClass()));
                }
            } else {
                throw new IllegalArgumentException(String.format("same command exist. OpCode:%s vlaue class:%s", entry.getOpCode(), entry.getValue().getClass()));
            }
        }
        this.DEFINE.add(entry);
    }

    public void unRegister(Entry<T> entry) {
        Objects.requireNonNull(entry, "entry");
        for (Entry<T> entry2 : this.DEFINE) {
            if (entry == entry2 || entry2.getOpCode().equals(entry.getOpCode())) {
                this.DEFINE.remove(entry2);
            }
        }
    }
}
