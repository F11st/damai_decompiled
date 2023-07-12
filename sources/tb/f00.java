package tb;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class f00 extends au {
    public static final String DX_EVENT_PIPELINE_SCHEDULE = "DX_EVENT_PIPELINE_SCHEDULE";
    public int d;
    public int e;
    public boolean f;

    public f00() {
        this.b = DX_EVENT_PIPELINE_SCHEDULE;
    }

    @Override // tb.au
    public boolean a(au auVar) {
        if (auVar != null && (auVar instanceof f00) && this.d == ((f00) auVar).d) {
            return super.a(auVar);
        }
        return false;
    }

    public String toString() {
        return "DXPipelineScheduleEvent{stage=" + this.d + ", sender=" + this.a + ", eventName='" + this.b + "', args=" + this.c + '}';
    }
}
