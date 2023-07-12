package safe.section.around;

/* loaded from: classes.dex */
public class Invocation {
    public String annotationInfo;
    public Object[] args;
    public String methodinfo;
    public Object thiz;

    public Invocation(Object obj, Object... objArr) {
        this.thiz = obj;
        this.args = objArr;
    }

    public byte getParamB(int i) {
        return ((Byte) this.args[i]).byteValue();
    }

    public char getParamC(int i) {
        return ((Character) this.args[i]).charValue();
    }

    public double getParamD(int i) {
        return ((Double) this.args[i]).doubleValue();
    }

    public float getParamF(int i) {
        return ((Float) this.args[i]).floatValue();
    }

    public int getParamI(int i) {
        return ((Integer) this.args[i]).intValue();
    }

    public long getParamJ(int i) {
        return ((Long) this.args[i]).longValue();
    }

    public Object getParamL(int i) {
        return this.args[i];
    }

    public short getParamS(int i) {
        return ((Short) this.args[i]).shortValue();
    }

    public boolean getParamZ(int i) {
        return ((Boolean) this.args[i]).booleanValue();
    }

    public void initAnnotationInfo(String str) {
        this.annotationInfo = str;
    }

    public void initMethodInfo(String str) {
        this.methodinfo = str;
    }

    public void initThis(Object obj) {
        this.thiz = obj;
    }

    public void setParam(int i, boolean z) {
        this.args[i] = Boolean.valueOf(z);
    }

    public void setParam(int i, byte b) {
        this.args[i] = Byte.valueOf(b);
    }

    public void setParam(int i, short s) {
        this.args[i] = Short.valueOf(s);
    }

    public Invocation(int i) {
        this.args = new Object[i];
    }

    public void setParam(int i, char c) {
        this.args[i] = Character.valueOf(c);
    }

    public void setParam(int i, int i2) {
        this.args[i] = Integer.valueOf(i2);
    }

    public void setParam(int i, long j) {
        this.args[i] = Long.valueOf(j);
    }

    public void setParam(int i, float f) {
        this.args[i] = Float.valueOf(f);
    }

    public void setParam(int i, double d) {
        this.args[i] = Double.valueOf(d);
    }

    public void setParam(int i, Object obj) {
        this.args[i] = obj;
    }
}
