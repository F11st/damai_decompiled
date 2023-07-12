package com.alibaba.ability.result;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000¨\u0006\u0004"}, d2 = {"Lcom/alibaba/ability/result/ExecuteError;", "", "Companion", "a", "megability_interface_release"}, k = 1, mv = {1, 4, 1})
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.FIELD, AnnotationTarget.FUNCTION})
@Retention(RetentionPolicy.SOURCE)
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
/* loaded from: classes9.dex */
public @interface ExecuteError {
    @NotNull
    public static final C3002a Companion = C3002a.a;
    @NotNull
    public static final String abilityInternalError = "500";
    @NotNull
    public static final String abilityNotFound = "404";
    @NotNull
    public static final String apiNotFound = "501";
    @NotNull
    public static final String parametersNotCorrect = "400";

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.ability.result.ExecuteError$a */
    /* loaded from: classes9.dex */
    public static final class C3002a {
        static final /* synthetic */ C3002a a = new C3002a();
        @NotNull
        public static final String abilityInternalError = "500";
        @NotNull
        public static final String abilityNotFound = "404";
        @NotNull
        public static final String apiNotFound = "501";
        @NotNull
        public static final String parametersNotCorrect = "400";

        private C3002a() {
        }
    }
}
