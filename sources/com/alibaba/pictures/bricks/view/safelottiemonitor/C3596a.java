package com.alibaba.pictures.bricks.view.safelottiemonitor;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.lang.reflect.Field;
import tb.nd;

/* compiled from: Taobao */
/* renamed from: com.alibaba.pictures.bricks.view.safelottiemonitor.a */
/* loaded from: classes7.dex */
public class C3596a {
    private static transient /* synthetic */ IpChange $ipChange;

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.pictures.bricks.view.safelottiemonitor.a$a */
    /* loaded from: classes7.dex */
    public static class C3597a<C, T> {
        private static transient /* synthetic */ IpChange $ipChange;
        private final Field a;

        public C3597a(Class<C> cls, String str) {
            Field field = null;
            if (cls != null) {
                try {
                    try {
                        if (!TextUtils.isEmpty(str) && (field = cls.getDeclaredField(str)) != null) {
                            field.setAccessible(true);
                        }
                    } catch (NoSuchFieldException e) {
                        if (e.getMessage() != null) {
                            nd.a(e.getMessage(), "Hack");
                        }
                    }
                } finally {
                    this.a = field;
                }
            }
        }

        public Field a() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1863223724") ? (Field) ipChange.ipc$dispatch("-1863223724", new Object[]{this}) : this.a;
        }

        public <T2> C3597a<C, T2> b(Class<T2> cls) throws HackHandleException {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-495507706")) {
                return (C3597a) ipChange.ipc$dispatch("-495507706", new Object[]{this, cls});
            }
            Field field = this.a;
            if (field != null && !cls.isAssignableFrom(field.getType())) {
                C3596a.c(new HackHandleException(new ClassCastException(this.a + " is not of type " + cls)));
            }
            return this;
        }
    }

    public static <C> C3597a<C, Object> b(Class<C> cls, String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1453853935") ? (C3597a) ipChange.ipc$dispatch("1453853935", new Object[]{cls, str}) : new C3597a<>(cls, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(HackHandleException hackHandleException) throws HackHandleException {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "965007436")) {
            throw hackHandleException;
        }
        ipChange.ipc$dispatch("965007436", new Object[]{hackHandleException});
    }
}
