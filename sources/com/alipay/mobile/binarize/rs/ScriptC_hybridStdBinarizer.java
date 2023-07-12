package com.alipay.mobile.binarize.rs;

import android.annotation.TargetApi;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.FieldPacker;
import android.renderscript.RSIllegalArgumentException;
import android.renderscript.RSRuntimeException;
import android.renderscript.RenderScript;
import android.renderscript.Script;
import android.renderscript.ScriptC;

/* compiled from: Taobao */
@TargetApi(24)
/* loaded from: classes12.dex */
public class ScriptC_hybridStdBinarizer extends ScriptC {
    private Element a;
    private Element b;
    private RenderScript c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;
    private int n;
    private Allocation o;
    private Allocation p;
    private Allocation q;
    private Allocation r;

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public static class result_int {
        private Allocation[] a;
        private Allocation b;
        private boolean c;
        private int d;

        public int get() {
            if (!this.c) {
                int[] iArr = new int[1];
                this.b.copyTo(iArr);
                this.d = iArr[0];
                this.b.destroy();
                this.b = null;
                Allocation[] allocationArr = this.a;
                if (allocationArr != null) {
                    for (Allocation allocation : allocationArr) {
                        allocation.destroy();
                    }
                    this.a = null;
                }
                this.c = true;
            }
            return this.d;
        }

        private result_int(Allocation allocation) {
            this.a = null;
            this.b = allocation;
            this.c = false;
        }
    }

    public ScriptC_hybridStdBinarizer(RenderScript renderScript) {
        super(renderScript, "hybridstdbinarizer", hybridStdBinarizerBitCode.getBitCode32(), hybridStdBinarizerBitCode.getBitCode64());
        this.a = Element.I32(renderScript);
        Element.ALLOCATION(renderScript);
        this.c = renderScript;
        this.b = Element.U8(renderScript);
    }

    public void forEach_calAverage(Allocation allocation) {
        forEach_calAverage(allocation, null);
    }

    public void forEach_setBlack(Allocation allocation) {
        forEach_setBlack(allocation, null);
    }

    public Script.FieldID getFieldID__var_th() {
        return createFieldID(9, null);
    }

    public Script.FieldID getFieldID_areaSize() {
        return createFieldID(6, null);
    }

    public Script.FieldID getFieldID_avgSum() {
        return createFieldID(10, null);
    }

    public Script.FieldID getFieldID_bitMatrixRowSize() {
        return createFieldID(8, null);
    }

    public Script.FieldID getFieldID_gAverageBlockAllocation() {
        return createFieldID(13, null);
    }

    public Script.FieldID getFieldID_gBitMatrixAllocation() {
        return createFieldID(14, null);
    }

    public Script.FieldID getFieldID_gCurrentFrame() {
        return createFieldID(11, null);
    }

    public Script.FieldID getFieldID_gTypeAllocation() {
        return createFieldID(12, null);
    }

    public Script.FieldID getFieldID_height() {
        return createFieldID(3, null);
    }

    public Script.FieldID getFieldID_log_nBlockSize() {
        return createFieldID(0, null);
    }

    public Script.FieldID getFieldID_nBlockSize() {
        return createFieldID(1, null);
    }

    public Script.FieldID getFieldID_subAreaSize() {
        return createFieldID(7, null);
    }

    public Script.FieldID getFieldID_subHeight() {
        return createFieldID(5, null);
    }

    public Script.FieldID getFieldID_subWidth() {
        return createFieldID(4, null);
    }

    public Script.FieldID getFieldID_width() {
        return createFieldID(2, null);
    }

    public Script.InvokeID getInvokeID_initBinarizer() {
        return createInvokeID(0);
    }

    public Script.KernelID getKernelID_calAverage() {
        return createKernelID(1, 41, null, null);
    }

    public Script.KernelID getKernelID_setBlack() {
        return createKernelID(2, 41, null, null);
    }

    public int get__var_th() {
        return this.m;
    }

    public int get_areaSize() {
        return this.j;
    }

    public int get_avgSum() {
        return this.n;
    }

    public int get_bitMatrixRowSize() {
        return this.l;
    }

    public Allocation get_gAverageBlockAllocation() {
        return this.q;
    }

    public Allocation get_gBitMatrixAllocation() {
        return this.r;
    }

    public Allocation get_gCurrentFrame() {
        return this.o;
    }

    public Allocation get_gTypeAllocation() {
        return this.p;
    }

    public int get_height() {
        return this.g;
    }

    public int get_log_nBlockSize() {
        return this.d;
    }

    public int get_nBlockSize() {
        return this.e;
    }

    public int get_subAreaSize() {
        return this.k;
    }

    public int get_subHeight() {
        return this.i;
    }

    public int get_subWidth() {
        return this.h;
    }

    public int get_width() {
        return this.f;
    }

    public void invoke_initBinarizer(int i, int i2, int i3, int i4, int i5) {
        FieldPacker fieldPacker = new FieldPacker(20);
        fieldPacker.addI32(i);
        fieldPacker.addI32(i2);
        fieldPacker.addI32(i3);
        fieldPacker.addI32(i4);
        fieldPacker.addI32(i5);
        invoke(0, fieldPacker);
    }

    public result_int reduce_produceAverage(byte[] bArr) {
        if (bArr != null) {
            Allocation createSized = Allocation.createSized(this.c, this.b, bArr.length);
            createSized.setAutoPadding(true);
            createSized.copyFrom(bArr);
            result_int reduce_produceAverage = reduce_produceAverage(createSized, null);
            reduce_produceAverage.a = new Allocation[]{createSized};
            return reduce_produceAverage;
        }
        throw new RSIllegalArgumentException("Array \"in1\" is null!");
    }

    public synchronized void set__var_th(int i) {
        setVar(9, i);
        this.m = i;
    }

    public synchronized void set_areaSize(int i) {
        setVar(6, i);
        this.j = i;
    }

    public synchronized void set_avgSum(int i) {
        setVar(10, i);
        this.n = i;
    }

    public synchronized void set_bitMatrixRowSize(int i) {
        setVar(8, i);
        this.l = i;
    }

    public synchronized void set_gAverageBlockAllocation(Allocation allocation) {
        setVar(13, allocation);
        this.q = allocation;
    }

    public synchronized void set_gBitMatrixAllocation(Allocation allocation) {
        setVar(14, allocation);
        this.r = allocation;
    }

    public synchronized void set_gCurrentFrame(Allocation allocation) {
        setVar(11, allocation);
        this.o = allocation;
    }

    public synchronized void set_gTypeAllocation(Allocation allocation) {
        setVar(12, allocation);
        this.p = allocation;
    }

    public synchronized void set_height(int i) {
        setVar(3, i);
        this.g = i;
    }

    public synchronized void set_log_nBlockSize(int i) {
        setVar(0, i);
        this.d = i;
    }

    public synchronized void set_nBlockSize(int i) {
        setVar(1, i);
        this.e = i;
    }

    public synchronized void set_subAreaSize(int i) {
        setVar(7, i);
        this.k = i;
    }

    public synchronized void set_subHeight(int i) {
        setVar(5, i);
        this.i = i;
    }

    public synchronized void set_subWidth(int i) {
        setVar(4, i);
        this.h = i;
    }

    public synchronized void set_width(int i) {
        setVar(2, i);
        this.f = i;
    }

    public void forEach_calAverage(Allocation allocation, Script.LaunchOptions launchOptions) {
        if (allocation.getType().getElement().isCompatible(this.b)) {
            forEach(1, allocation, (Allocation) null, (FieldPacker) null, launchOptions);
            return;
        }
        throw new RSRuntimeException("Type mismatch with U8!");
    }

    public void forEach_setBlack(Allocation allocation, Script.LaunchOptions launchOptions) {
        if (allocation.getType().getElement().isCompatible(this.b)) {
            forEach(2, allocation, (Allocation) null, (FieldPacker) null, launchOptions);
            return;
        }
        throw new RSRuntimeException("Type mismatch with U8!");
    }

    public result_int reduce_produceAverage(Allocation allocation) {
        return reduce_produceAverage(allocation, null);
    }

    public result_int reduce_produceAverage(Allocation allocation, Script.LaunchOptions launchOptions) {
        if (allocation.getType().getElement().isCompatible(this.b)) {
            Allocation createSized = Allocation.createSized(this.c, this.a, 1);
            createSized.setAutoPadding(true);
            reduce(0, new Allocation[]{allocation}, createSized, launchOptions);
            return new result_int(createSized);
        }
        throw new RSRuntimeException("Type mismatch with U8!");
    }
}
