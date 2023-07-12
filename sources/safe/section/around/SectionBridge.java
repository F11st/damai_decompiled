package safe.section.around;

import com.alibaba.wireless.security.aopsdk.AopBridge;
import com.alibaba.wireless.security.aopsdk.AopManager;

/* loaded from: classes.dex */
public class SectionBridge extends AopBridge {
    public static SectionParam callAfterBridge(SectionParam sectionParam) {
        Object result = sectionParam.getResult();
        Throwable throwable = sectionParam.getThrowable();
        com.alibaba.wireless.security.aopsdk.Invocation invocation = new com.alibaba.wireless.security.aopsdk.Invocation(sectionParam.invocation);
        invocation.setResult(result);
        invocation.setThrowable(throwable);
        AopManager.getInstance().getBridge().callAfterBridge(invocation);
        sectionParam.setResult(invocation.getResult());
        sectionParam.setThrowable(invocation.getThrowable());
        return sectionParam;
    }

    public static SectionParam callBeforeBridge(Invocation invocation) {
        SectionParam sectionParam = new SectionParam();
        sectionParam.invocation = invocation;
        com.alibaba.wireless.security.aopsdk.Invocation invocation2 = new com.alibaba.wireless.security.aopsdk.Invocation(invocation);
        if (AopManager.getInstance().getBridge().callBeforeBridge(invocation2) && invocation2.shouldBlock()) {
            sectionParam.returnEarly = true;
            sectionParam.setResult(invocation2.getResult());
        }
        if (invocation2.shouldReport) {
            AopManager.getInstance().getBridge().reportTimeCost(invocation2);
        }
        return sectionParam;
    }

    public static byte resultBridgeB(SectionParam sectionParam) throws Throwable {
        if (!sectionParam.hasThrowable()) {
            return ((Byte) sectionParam.getResult()).byteValue();
        }
        throw sectionParam.getThrowable();
    }

    public static char resultBridgeC(SectionParam sectionParam) throws Throwable {
        if (!sectionParam.hasThrowable()) {
            return ((Character) sectionParam.getResult()).charValue();
        }
        throw sectionParam.getThrowable();
    }

    public static double resultBridgeD(SectionParam sectionParam) throws Throwable {
        if (!sectionParam.hasThrowable()) {
            return ((Double) sectionParam.getResult()).doubleValue();
        }
        throw sectionParam.getThrowable();
    }

    public static float resultBridgeF(SectionParam sectionParam) throws Throwable {
        if (!sectionParam.hasThrowable()) {
            return ((Float) sectionParam.getResult()).floatValue();
        }
        throw sectionParam.getThrowable();
    }

    public static int resultBridgeI(SectionParam sectionParam) throws Throwable {
        if (!sectionParam.hasThrowable()) {
            return ((Integer) sectionParam.getResult()).intValue();
        }
        throw sectionParam.getThrowable();
    }

    public static long resultBridgeJ(SectionParam sectionParam) throws Throwable {
        if (!sectionParam.hasThrowable()) {
            return ((Long) sectionParam.getResult()).longValue();
        }
        throw sectionParam.getThrowable();
    }

    public static Object resultBridgeL(SectionParam sectionParam) throws Throwable {
        if (!sectionParam.hasThrowable()) {
            return sectionParam.getResult();
        }
        throw sectionParam.getThrowable();
    }

    public static short resultBridgeS(SectionParam sectionParam) throws Throwable {
        if (!sectionParam.hasThrowable()) {
            return ((Short) sectionParam.getResult()).shortValue();
        }
        throw sectionParam.getThrowable();
    }

    public static void resultBridgeV(SectionParam sectionParam) throws Throwable {
        if (sectionParam.hasThrowable()) {
            throw sectionParam.getThrowable();
        }
    }

    public static boolean resultBridgeZ(SectionParam sectionParam) throws Throwable {
        if (!sectionParam.hasThrowable()) {
            return ((Boolean) sectionParam.getResult()).booleanValue();
        }
        throw sectionParam.getThrowable();
    }
}
