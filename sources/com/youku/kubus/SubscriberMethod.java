package com.youku.kubus;

import java.lang.reflect.Method;

/* compiled from: Taobao */
@NoProguard
/* loaded from: classes2.dex */
public class SubscriberMethod {
    final String eventType;
    final Method method;
    String methodString;
    final int priority;
    final boolean sticky;
    final ThreadMode threadMode;

    public SubscriberMethod(Method method, String str, ThreadMode threadMode, int i, boolean z) {
        this.method = method;
        this.threadMode = threadMode;
        this.eventType = str;
        this.priority = i;
        this.sticky = z;
    }

    private synchronized void checkMethodString() {
        if (this.methodString == null) {
            StringBuilder sb = new StringBuilder(64);
            sb.append(this.method.getDeclaringClass().getName());
            sb.append('#');
            sb.append(this.method.getName());
            sb.append('(');
            sb.append(this.eventType);
            this.methodString = sb.toString();
        }
    }

    public String dumpInfo() {
        if (this.methodString == null) {
            StringBuilder sb = new StringBuilder(64);
            sb.append(this.method.getDeclaringClass().getName());
            sb.append('#');
            sb.append(this.method.getName());
            sb.append('(');
            sb.append(this.eventType);
            this.methodString = sb.toString();
        }
        return this.methodString;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof SubscriberMethod) {
            checkMethodString();
            SubscriberMethod subscriberMethod = (SubscriberMethod) obj;
            subscriberMethod.checkMethodString();
            return this.methodString.equals(subscriberMethod.methodString);
        }
        return false;
    }

    public int hashCode() {
        return this.method.hashCode();
    }
}
