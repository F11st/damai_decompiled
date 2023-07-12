package org.apache.commons.lang3;

import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.arch.Processor;
import tv.cjump.jni.DeviceUtils;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class ArchUtils {
    private static final Map<String, Processor> ARCH_TO_PROCESSOR = new HashMap();

    static {
        init();
    }

    private static void addProcessor(String str, Processor processor) throws IllegalStateException {
        Map<String, Processor> map = ARCH_TO_PROCESSOR;
        if (!map.containsKey(str)) {
            map.put(str, processor);
            return;
        }
        throw new IllegalStateException("Key " + str + " already exists in processor map");
    }

    private static void addProcessors(Processor processor, String... strArr) throws IllegalStateException {
        for (String str : strArr) {
            addProcessor(str, processor);
        }
    }

    public static Processor getProcessor() {
        return getProcessor(SystemUtils.OS_ARCH);
    }

    private static void init() {
        init_X86_32Bit();
        init_X86_64Bit();
        init_IA64_32Bit();
        init_IA64_64Bit();
        init_PPC_32Bit();
        init_PPC_64Bit();
    }

    private static void init_IA64_32Bit() {
        addProcessors(new Processor(Processor.Arch.BIT_32, Processor.Type.IA_64), "ia64_32", "ia64n");
    }

    private static void init_IA64_64Bit() {
        addProcessors(new Processor(Processor.Arch.BIT_64, Processor.Type.IA_64), "ia64", "ia64w");
    }

    private static void init_PPC_32Bit() {
        addProcessors(new Processor(Processor.Arch.BIT_32, Processor.Type.PPC), "ppc", "power", "powerpc", "power_pc", "power_rs");
    }

    private static void init_PPC_64Bit() {
        addProcessors(new Processor(Processor.Arch.BIT_64, Processor.Type.PPC), "ppc64", "power64", "powerpc64", "power_pc64", "power_rs64");
    }

    private static void init_X86_32Bit() {
        addProcessors(new Processor(Processor.Arch.BIT_32, Processor.Type.X86), DeviceUtils.ABI_X86, "i386", "i486", "i586", "i686", "pentium");
    }

    private static void init_X86_64Bit() {
        addProcessors(new Processor(Processor.Arch.BIT_64, Processor.Type.X86), "x86_64", "amd64", "em64t", "universal");
    }

    public static Processor getProcessor(String str) {
        return ARCH_TO_PROCESSOR.get(str);
    }
}
