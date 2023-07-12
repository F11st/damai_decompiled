package com.xiaomi.push;

import java.util.LinkedList;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class bl {
    private LinkedList<C7612a> a = new LinkedList<>();

    /* compiled from: Taobao */
    /* renamed from: com.xiaomi.push.bl$a */
    /* loaded from: classes11.dex */
    public static class C7612a {
        private static final bl a = new bl();

        /* renamed from: a  reason: collision with other field name */
        public int f134a;

        /* renamed from: a  reason: collision with other field name */
        public Object f135a;

        /* renamed from: a  reason: collision with other field name */
        public String f136a;

        C7612a(int i, Object obj) {
            this.f134a = i;
            this.f135a = obj;
        }
    }

    public static bl a() {
        return C7612a.a;
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
    public synchronized LinkedList<C7612a> m700a() {
        LinkedList<C7612a> linkedList;
        linkedList = this.a;
        this.a = new LinkedList<>();
        return linkedList;
    }

    public synchronized void a(Object obj) {
        this.a.add(new C7612a(0, obj));
        m698a();
    }
}
