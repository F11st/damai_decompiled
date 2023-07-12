package androidx.constraintlayout.core.parser;

import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import java.util.Iterator;
import org.apache.commons.lang3.StringUtils;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class CLArray extends CLContainer {
    public CLArray(char[] cArr) {
        super(cArr);
    }

    public static CLElement allocate(char[] cArr) {
        return new CLArray(cArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.constraintlayout.core.parser.CLElement
    public String toFormattedJSON(int i, int i2) {
        StringBuilder sb = new StringBuilder();
        String json = toJSON();
        if (i2 <= 0 && json.length() + i < CLElement.MAX_LINE) {
            sb.append(json);
        } else {
            sb.append("[\n");
            Iterator<CLElement> it = this.mElements.iterator();
            boolean z = true;
            while (it.hasNext()) {
                CLElement next = it.next();
                if (z) {
                    z = false;
                } else {
                    sb.append(",\n");
                }
                addIndent(sb, CLElement.BASE_INDENT + i);
                sb.append(next.toFormattedJSON(CLElement.BASE_INDENT + i, i2 - 1));
            }
            sb.append(StringUtils.LF);
            addIndent(sb, i);
            sb.append(jn1.ARRAY_END_STR);
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.constraintlayout.core.parser.CLElement
    public String toJSON() {
        StringBuilder sb = new StringBuilder(getDebugName() + jn1.ARRAY_START_STR);
        boolean z = true;
        for (int i = 0; i < this.mElements.size(); i++) {
            if (z) {
                z = false;
            } else {
                sb.append(AVFSCacheConstants.COMMA_SEP);
            }
            sb.append(this.mElements.get(i).toJSON());
        }
        return ((Object) sb) + jn1.ARRAY_END_STR;
    }
}
