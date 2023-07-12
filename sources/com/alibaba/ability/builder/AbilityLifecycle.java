package com.alibaba.ability.builder;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000¨\u0006\u0004"}, d2 = {"Lcom/alibaba/ability/builder/AbilityLifecycle;", "", "Companion", "a", "megability_interface_release"}, k = 1, mv = {1, 4, 1})
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.FIELD, AnnotationTarget.FUNCTION, AnnotationTarget.CLASS, AnnotationTarget.PROPERTY, AnnotationTarget.TYPE})
@Retention(RetentionPolicy.SOURCE)
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
/* loaded from: classes9.dex */
public @interface AbilityLifecycle {
    @NotNull
    public static final a Companion = a.a;

    /* renamed from: app  reason: collision with root package name */
    public static final int f1026app = 1;
    public static final int instance = 3;
    public static final int invoke = 4;
    public static final int namespace = 2;

    /* compiled from: Taobao */
    /* loaded from: classes9.dex */
    public static final class a {
        static final /* synthetic */ a a = new a();

        /* renamed from: app  reason: collision with root package name */
        public static final int f1027app = 1;
        public static final int instance = 3;
        public static final int invoke = 4;
        public static final int namespace = 2;

        private a() {
        }
    }
}
