package com.alipay.mobile.binarize.rs;

import android.annotation.TargetApi;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.FieldPacker;
import android.renderscript.RSRuntimeException;
import android.renderscript.RenderScript;
import android.renderscript.Script;
import android.renderscript.ScriptC;
import android.renderscript.Type;

/* compiled from: Taobao */
@TargetApi(24)
/* loaded from: classes12.dex */
public class ScriptC_localAdaptiveBinarizer extends ScriptC {
    private Element a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private Allocation i;
    private Allocation j;
    private Allocation k;

    public ScriptC_localAdaptiveBinarizer(RenderScript renderScript) {
        super(renderScript, "localadaptivebinarizer", localAdaptiveBinarizerBitCode.getBitCode32(), localAdaptiveBinarizerBitCode.getBitCode64());
        Element.I32(renderScript);
        Element.ALLOCATION(renderScript);
        this.a = Element.U8(renderScript);
    }

    public void forEach_calculateBlock(Allocation allocation) {
        forEach_calculateBlock(allocation, null);
    }

    public void forEach_calculateThresholdForBlock(Allocation allocation, Allocation allocation2) {
        forEach_calculateThresholdForBlock(allocation, allocation2, null);
    }

    public void forEach_setBlack(Allocation allocation, Allocation allocation2) {
        forEach_setBlack(allocation, allocation2, null);
    }

    public Script.FieldID getFieldID_blockHeight() {
        return createFieldID(2, null);
    }

    public Script.FieldID getFieldID_blockMatrixHeight() {
        return createFieldID(4, null);
    }

    public Script.FieldID getFieldID_blockMatrixWidth() {
        return createFieldID(3, null);
    }

    public Script.FieldID getFieldID_blockWidth() {
        return createFieldID(1, null);
    }

    public Script.FieldID getFieldID_gBlockAllocation() {
        return createFieldID(8, null);
    }

    public Script.FieldID getFieldID_gCurrentFrame() {
        return createFieldID(7, null);
    }

    public Script.FieldID getFieldID_gThresholdAllocation() {
        return createFieldID(9, null);
    }

    public Script.FieldID getFieldID_height() {
        return createFieldID(6, null);
    }

    public Script.FieldID getFieldID_width() {
        return createFieldID(5, null);
    }

    public Script.FieldID getFieldID_windowSize() {
        return createFieldID(0, null);
    }

    public Script.InvokeID getInvokeID_initLocalBinarizer() {
        return createInvokeID(0);
    }

    public Script.KernelID getKernelID_calculateBlock() {
        return createKernelID(1, 41, null, null);
    }

    public Script.KernelID getKernelID_calculateThresholdForBlock() {
        return createKernelID(2, 43, null, null);
    }

    public Script.KernelID getKernelID_setBlack() {
        return createKernelID(3, 59, null, null);
    }

    public int get_blockHeight() {
        return this.d;
    }

    public int get_blockMatrixHeight() {
        return this.f;
    }

    public int get_blockMatrixWidth() {
        return this.e;
    }

    public int get_blockWidth() {
        return this.c;
    }

    public Allocation get_gBlockAllocation() {
        return this.j;
    }

    public Allocation get_gCurrentFrame() {
        return this.i;
    }

    public Allocation get_gThresholdAllocation() {
        return this.k;
    }

    public int get_height() {
        return this.h;
    }

    public int get_width() {
        return this.g;
    }

    public int get_windowSize() {
        return this.b;
    }

    public void invoke_initLocalBinarizer(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        FieldPacker fieldPacker = new FieldPacker(28);
        fieldPacker.addI32(i);
        fieldPacker.addI32(i2);
        fieldPacker.addI32(i3);
        fieldPacker.addI32(i4);
        fieldPacker.addI32(i5);
        fieldPacker.addI32(i6);
        fieldPacker.addI32(i7);
        invoke(0, fieldPacker);
    }

    public synchronized void set_blockHeight(int i) {
        setVar(2, i);
        this.d = i;
    }

    public synchronized void set_blockMatrixHeight(int i) {
        setVar(4, i);
        this.f = i;
    }

    public synchronized void set_blockMatrixWidth(int i) {
        setVar(3, i);
        this.e = i;
    }

    public synchronized void set_blockWidth(int i) {
        setVar(1, i);
        this.c = i;
    }

    public synchronized void set_gBlockAllocation(Allocation allocation) {
        setVar(8, allocation);
        this.j = allocation;
    }

    public synchronized void set_gCurrentFrame(Allocation allocation) {
        setVar(7, allocation);
        this.i = allocation;
    }

    public synchronized void set_gThresholdAllocation(Allocation allocation) {
        setVar(9, allocation);
        this.k = allocation;
    }

    public synchronized void set_height(int i) {
        setVar(6, i);
        this.h = i;
    }

    public synchronized void set_width(int i) {
        setVar(5, i);
        this.g = i;
    }

    public synchronized void set_windowSize(int i) {
        setVar(0, i);
        this.b = i;
    }

    public void forEach_calculateBlock(Allocation allocation, Script.LaunchOptions launchOptions) {
        if (allocation.getType().getElement().isCompatible(this.a)) {
            forEach(1, allocation, (Allocation) null, (FieldPacker) null, launchOptions);
            return;
        }
        throw new RSRuntimeException("Type mismatch with U8!");
    }

    public void forEach_calculateThresholdForBlock(Allocation allocation, Allocation allocation2, Script.LaunchOptions launchOptions) {
        if (allocation.getType().getElement().isCompatible(this.a)) {
            if (allocation2.getType().getElement().isCompatible(this.a)) {
                Type type = allocation.getType();
                Type type2 = allocation2.getType();
                if (type.getCount() == type2.getCount() && type.getX() == type2.getX() && type.getY() == type2.getY() && type.getZ() == type2.getZ() && type.hasFaces() == type2.hasFaces() && type.hasMipmaps() == type2.hasMipmaps()) {
                    forEach(2, allocation, allocation2, (FieldPacker) null, launchOptions);
                    return;
                }
                throw new RSRuntimeException("Dimension mismatch between parameters ain and aout!");
            }
            throw new RSRuntimeException("Type mismatch with U8!");
        }
        throw new RSRuntimeException("Type mismatch with U8!");
    }

    public void forEach_setBlack(Allocation allocation, Allocation allocation2, Script.LaunchOptions launchOptions) {
        if (allocation.getType().getElement().isCompatible(this.a)) {
            if (allocation2.getType().getElement().isCompatible(this.a)) {
                Type type = allocation.getType();
                Type type2 = allocation2.getType();
                if (type.getCount() == type2.getCount() && type.getX() == type2.getX() && type.getY() == type2.getY() && type.getZ() == type2.getZ() && type.hasFaces() == type2.hasFaces() && type.hasMipmaps() == type2.hasMipmaps()) {
                    forEach(3, allocation, allocation2, (FieldPacker) null, launchOptions);
                    return;
                }
                throw new RSRuntimeException("Dimension mismatch between parameters ain and aout!");
            }
            throw new RSRuntimeException("Type mismatch with U8!");
        }
        throw new RSRuntimeException("Type mismatch with U8!");
    }
}
