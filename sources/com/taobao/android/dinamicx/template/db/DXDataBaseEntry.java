package com.taobao.android.dinamicx.template.db;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public abstract class DXDataBaseEntry {
    public static final String[] ID_PROJECTION = {"_id"};

    /* compiled from: Taobao */
    @Target({ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: classes12.dex */
    public @interface Column {
        String defaultValue() default "";

        boolean indexed() default false;

        boolean notNull() default false;

        boolean primaryKey() default false;

        String value();
    }

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public interface Columns {
        public static final String ID = "_id";
    }

    /* compiled from: Taobao */
    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: classes12.dex */
    public @interface Table {
        String value();
    }
}
