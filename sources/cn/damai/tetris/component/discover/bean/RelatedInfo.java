package cn.damai.tetris.component.discover.bean;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class RelatedInfo implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public String type;
    public String value;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x004f, code lost:
        if (r9.equals("2") == false) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x007f, code lost:
        if (r9.equals("2") == false) goto L30;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int getRelateIconRid(boolean r9) {
        /*
            r8 = this;
            com.android.alibaba.ip.runtime.IpChange r0 = cn.damai.tetris.component.discover.bean.RelatedInfo.$ipChange
            java.lang.String r1 = "1394666460"
            boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
            r3 = 1
            r4 = 0
            r5 = 2
            if (r2 == 0) goto L22
            java.lang.Object[] r2 = new java.lang.Object[r5]
            r2[r4] = r8
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r9)
            r2[r3] = r9
            java.lang.Object r9 = r0.ipc$dispatch(r1, r2)
            java.lang.Integer r9 = (java.lang.Integer) r9
            int r9 = r9.intValue()
            return r9
        L22:
            java.lang.String r0 = r8.type
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            r1 = -1
            if (r0 == 0) goto L2c
            return r1
        L2c:
            java.lang.String r0 = "3"
            java.lang.String r2 = "2"
            java.lang.String r6 = "1"
            if (r9 == 0) goto L64
            java.lang.String r9 = r8.type
            r9.hashCode()
            int r7 = r9.hashCode()
            switch(r7) {
                case 49: goto L52;
                case 50: goto L4b;
                case 51: goto L42;
                default: goto L40;
            }
        L40:
            r3 = -1
            goto L5a
        L42:
            boolean r9 = r9.equals(r0)
            if (r9 != 0) goto L49
            goto L40
        L49:
            r3 = 2
            goto L5a
        L4b:
            boolean r9 = r9.equals(r2)
            if (r9 != 0) goto L5a
            goto L40
        L52:
            boolean r9 = r9.equals(r6)
            if (r9 != 0) goto L59
            goto L40
        L59:
            r3 = 0
        L5a:
            switch(r3) {
                case 0: goto L61;
                case 1: goto L5e;
                case 2: goto L5e;
                default: goto L5d;
            }
        L5d:
            return r1
        L5e:
            int r9 = cn.damai.commonbusiness.R$drawable.note_v_white
            return r9
        L61:
            int r9 = cn.damai.commonbusiness.R$drawable.note_topic_white
            return r9
        L64:
            java.lang.String r9 = r8.type
            r9.hashCode()
            int r7 = r9.hashCode()
            switch(r7) {
                case 49: goto L82;
                case 50: goto L7b;
                case 51: goto L72;
                default: goto L70;
            }
        L70:
            r3 = -1
            goto L8a
        L72:
            boolean r9 = r9.equals(r0)
            if (r9 != 0) goto L79
            goto L70
        L79:
            r3 = 2
            goto L8a
        L7b:
            boolean r9 = r9.equals(r2)
            if (r9 != 0) goto L8a
            goto L70
        L82:
            boolean r9 = r9.equals(r6)
            if (r9 != 0) goto L89
            goto L70
        L89:
            r3 = 0
        L8a:
            switch(r3) {
                case 0: goto L94;
                case 1: goto L91;
                case 2: goto L8e;
                default: goto L8d;
            }
        L8d:
            return r1
        L8e:
            int r9 = cn.damai.commonbusiness.R$drawable.note_brand
            return r9
        L91:
            int r9 = cn.damai.commonbusiness.R$drawable.note_artist
            return r9
        L94:
            int r9 = cn.damai.commonbusiness.R$drawable.note_topic_
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.damai.tetris.component.discover.bean.RelatedInfo.getRelateIconRid(boolean):int");
    }

    public boolean isValid() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1550485652") ? ((Boolean) ipChange.ipc$dispatch("-1550485652", new Object[]{this})).booleanValue() : !TextUtils.isEmpty(this.value);
    }
}
