package com.taobao.weex.bridge;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Stack;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class WXHashMap<K, V> extends HashMap<K, V> {
    private static final long serialVersionUID = 4294272345728974369L;
    private Stack<String> instancesStack = new Stack<>();
    private String mTag;

    public Stack<String> getInstanceStack() {
        return this.instancesStack;
    }

    public String getStackTopInstanceId() {
        return this.instancesStack.isEmpty() ? "" : this.instancesStack.pop();
    }

    public String getTag() {
        return this.mTag;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public V put(K k, V v) {
        if (k != null && k.toString() != null) {
            if (this.instancesStack.contains(k)) {
                this.instancesStack.remove(k);
            }
            this.instancesStack.push(k.toString());
        }
        return (V) super.put(k, v);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        return (V) super.remove(obj);
    }

    public V removeFromMapAndStack(Object obj) {
        this.instancesStack.remove(obj);
        return (V) super.remove(obj);
    }

    public void setStackTopInstance(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.instancesStack.remove(str);
        this.instancesStack.push(str);
    }

    public void setTag(String str) {
        this.mTag = str;
    }
}
