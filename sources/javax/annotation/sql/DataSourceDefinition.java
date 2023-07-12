package javax.annotation.sql;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: Taobao */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes3.dex */
public @interface DataSourceDefinition {
    String className();

    String databaseName() default "";

    String description() default "";

    int initialPoolSize() default -1;

    int isolationLevel() default -1;

    int loginTimeout() default 0;

    int maxIdleTime() default -1;

    int maxPoolSize() default -1;

    int maxStatements() default -1;

    int minPoolSize() default -1;

    String name();

    String password() default "";

    int portNumber() default -1;

    String[] properties() default {};

    String serverName() default "localhost";

    boolean transactional() default true;

    String url() default "";

    String user() default "";
}
