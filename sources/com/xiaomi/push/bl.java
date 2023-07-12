package com.xiaomi.push;

import java.util.LinkedList;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class bl {
    private LinkedList<a> a = new LinkedList<>();

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class a {
        private static final bl a = new bl();

        /* renamed from: a  reason: collision with other field name */
        public int f134a;

        /* renamed from: a  reason: collision with other field name */
        public Object f135a;

        /* renamed from: a  reason: collision with other field name */
        public String f136a;

        a(int i, Object obj) {
            this.f134a = i;
            this.f135a = obj;
        }
    }

    public static bl a() {
        return a.a;
    }

    /* renamed from: a  reason: collision with other method in class */
    private void m698a() {
        if (this.a.size() > 100) {
            this.a.removeFirst();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized int m699a() {
        return this.a.size();
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized LinkedList<a> m700a() {
        LinkedList<a> linkedList;
        linkedList = this.a;
        this.a = new LinkedList<>();
        return linkedList;
    }

    public synchronized void a(Object obj) {
        this.a.add(new a(0, obj));
        m698a();
    }
}
