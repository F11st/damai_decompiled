package tb;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class w4 {
    public static void a() {
        b(null, null, null, null, null);
    }

    public static void b(Integer num, Integer num2, Integer num3, Integer num4, Integer num5) {
        y4 y4Var = new y4();
        y4Var.b();
        try {
            u90 with = ur1.o().diskCacheBuilder().with(y4Var);
            if (num != null) {
                with.b(17, num.intValue());
            }
            if (num2 != null) {
                with.b(34, num2.intValue());
            }
            if (num3 != null) {
                with.b(51, num3.intValue());
            }
            if (num4 != null) {
                with.b(68, num4.intValue());
            }
            if (num5 != null) {
                with.b(85, num5.intValue());
            }
            xt2.f("Alivfs4Phenix", "disk cache setup, top1=%s top2=%s top3=%s top4=%s top5=%s", num, num2, num3, num4, num5);
        } catch (RuntimeException e) {
            xt2.c("Alivfs4Phenix", "disk cache setup error=%s", e);
        }
    }
}
