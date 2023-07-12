package org.apache.commons.text.diff;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class StringsComparator {
    private final String left;
    private final String right;
    private final int[] vDown;
    private final int[] vUp;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static class Snake {
        private final int diag;
        private final int end;
        private final int start;

        Snake(int i, int i2, int i3) {
            this.start = i;
            this.end = i2;
            this.diag = i3;
        }

        public int getDiag() {
            return this.diag;
        }

        public int getEnd() {
            return this.end;
        }

        public int getStart() {
            return this.start;
        }
    }

    public StringsComparator(String str, String str2) {
        this.left = str;
        this.right = str2;
        int length = str.length() + str2.length() + 2;
        this.vDown = new int[length];
        this.vUp = new int[length];
    }

    private void buildScript(int i, int i2, int i3, int i4, EditScript<Character> editScript) {
        Snake middleSnake = getMiddleSnake(i, i2, i3, i4);
        if (middleSnake != null && ((middleSnake.getStart() != i2 || middleSnake.getDiag() != i2 - i4) && (middleSnake.getEnd() != i || middleSnake.getDiag() != i - i3))) {
            buildScript(i, middleSnake.getStart(), i3, middleSnake.getStart() - middleSnake.getDiag(), editScript);
            for (int start = middleSnake.getStart(); start < middleSnake.getEnd(); start++) {
                editScript.append(new KeepCommand<>(Character.valueOf(this.left.charAt(start))));
            }
            buildScript(middleSnake.getEnd(), i2, middleSnake.getEnd() - middleSnake.getDiag(), i4, editScript);
            return;
        }
        int i5 = i;
        int i6 = i3;
        while (true) {
            if (i5 >= i2 && i6 >= i4) {
                return;
            }
            if (i5 < i2 && i6 < i4 && this.left.charAt(i5) == this.right.charAt(i6)) {
                editScript.append(new KeepCommand<>(Character.valueOf(this.left.charAt(i5))));
                i5++;
            } else if (i2 - i > i4 - i3) {
                editScript.append(new DeleteCommand<>(Character.valueOf(this.left.charAt(i5))));
                i5++;
            } else {
                editScript.append(new InsertCommand<>(Character.valueOf(this.right.charAt(i6))));
            }
            i6++;
        }
    }

    private Snake buildSnake(int i, int i2, int i3, int i4) {
        int i5 = i;
        while (true) {
            int i6 = i5 - i2;
            if (i6 >= i4 || i5 >= i3 || this.left.charAt(i5) != this.right.charAt(i6)) {
                break;
            }
            i5++;
        }
        return new Snake(i, i5, i2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0039, code lost:
        if (r6[r5 - 1] < r6[r5 + 1]) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00ae, code lost:
        if (r6[r7 + 1] <= r6[r7 - 1]) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x010a, code lost:
        r0 = r0 + 1;
     */
    /* JADX WARN: Removed duplicated region for block: B:70:0x008a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00fe A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0093 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0107 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private org.apache.commons.text.diff.StringsComparator.Snake getMiddleSnake(int r12, int r13, int r14, int r15) {
        /*
            Method dump skipped, instructions count: 280
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.text.diff.StringsComparator.getMiddleSnake(int, int, int, int):org.apache.commons.text.diff.StringsComparator$Snake");
    }

    public EditScript<Character> getScript() {
        EditScript<Character> editScript = new EditScript<>();
        buildScript(0, this.left.length(), 0, this.right.length(), editScript);
        return editScript;
    }
}
