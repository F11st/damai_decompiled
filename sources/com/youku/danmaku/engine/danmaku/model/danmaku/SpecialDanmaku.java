package com.youku.danmaku.engine.danmaku.model.danmaku;

import com.youku.danmaku.engine.danmaku.model.AlphaValue;
import com.youku.danmaku.engine.danmaku.model.BaseDanmaku;
import com.youku.danmaku.engine.danmaku.model.IDisplayer;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class SpecialDanmaku extends BaseDanmaku {
    public long alphaDuration;
    public int beginAlpha;
    public float beginX;
    public float beginY;
    public int deltaAlpha;
    public float deltaX;
    public float deltaY;
    public int endAlpha;
    public float endX;
    public float endY;
    public LinePath[] linePaths;
    public float pivotX;
    public float pivotY;
    public float rotateX;
    public float rotateZ;
    public long translationDuration;
    public long translationStartDelay;
    private float[] currStateValues = new float[4];
    private float positionY = -1.0f;
    private float positionX = -1.0f;

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public class LinePath {
        public long beginTime;
        float delatX;
        float deltaY;
        public long duration;
        public long endTime;
        Point pBegin;
        Point pEnd;

        public LinePath() {
        }

        public float[] getBeginPoint() {
            Point point = this.pBegin;
            return new float[]{point.x, point.y};
        }

        public float getDistance() {
            return this.pEnd.getDistance(this.pBegin);
        }

        public float[] getEndPoint() {
            Point point = this.pEnd;
            return new float[]{point.x, point.y};
        }

        public void setPoints(Point point, Point point2) {
            this.pBegin = point;
            this.pEnd = point2;
            this.delatX = point2.x - point.x;
            this.deltaY = point2.y - point.y;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public class Point {
        float x;
        float y;

        public Point(float f, float f2) {
            this.x = f;
            this.y = f2;
        }

        public float getDistance(Point point) {
            float abs = Math.abs(this.x - point.x);
            float abs2 = Math.abs(this.y - point.y);
            return (float) Math.sqrt((abs * abs) + (abs2 * abs2));
        }
    }

    @Override // com.youku.danmaku.engine.danmaku.model.BaseDanmaku
    public float getBottom() {
        return this.currStateValues[3];
    }

    @Override // com.youku.danmaku.engine.danmaku.model.BaseDanmaku
    public float getLeft() {
        return this.currStateValues[0];
    }

    @Override // com.youku.danmaku.engine.danmaku.model.BaseDanmaku
    public float getPositionY() {
        return this.positionY;
    }

    @Override // com.youku.danmaku.engine.danmaku.model.BaseDanmaku
    public float[] getRectAtTime(IDisplayer iDisplayer, long j) {
        int i;
        LinePath linePath = null;
        if (isMeasured()) {
            long j2 = j - this.time;
            long j3 = this.alphaDuration;
            if (j3 > 0 && (i = this.deltaAlpha) != 0) {
                if (j2 >= j3) {
                    this.alpha = this.endAlpha;
                } else {
                    this.alpha = this.beginAlpha + ((int) (i * (((float) j2) / ((float) j3))));
                }
            }
            float f = this.beginX;
            float f2 = this.beginY;
            long j4 = j2 - this.translationStartDelay;
            long j5 = this.translationDuration;
            if (j5 > 0 && j4 >= 0 && j4 <= j5) {
                float f3 = ((float) j4) / ((float) j5);
                LinePath[] linePathArr = this.linePaths;
                if (linePathArr != null) {
                    int length = linePathArr.length;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length) {
                            break;
                        }
                        LinePath linePath2 = linePathArr[i2];
                        if (j4 >= linePath2.beginTime && j4 < linePath2.endTime) {
                            linePath = linePath2;
                            break;
                        }
                        Point point = linePath2.pEnd;
                        float f4 = point.x;
                        i2++;
                        f2 = point.y;
                        f = f4;
                    }
                    if (linePath != null) {
                        float f5 = linePath.delatX;
                        float f6 = linePath.deltaY;
                        float f7 = ((float) (j2 - linePath.beginTime)) / ((float) linePath.duration);
                        Point point2 = linePath.pBegin;
                        float f8 = point2.x;
                        float f9 = point2.y;
                        if (f5 != 0.0f) {
                            f = f8 + (f5 * f7);
                        }
                        if (f6 != 0.0f) {
                            f2 = f9 + (f6 * f7);
                        }
                    }
                } else {
                    float f10 = this.deltaX;
                    if (f10 != 0.0f) {
                        f += f10 * f3;
                    }
                    float f11 = this.deltaY;
                    if (f11 != 0.0f) {
                        f2 += f11 * f3;
                    }
                }
            } else if (j4 > j5) {
                f = this.endX;
                f2 = this.endY;
            }
            float[] fArr = this.currStateValues;
            fArr[0] = f;
            fArr[1] = f2;
            fArr[2] = f + this.paintWidth;
            fArr[3] = f2 + this.paintHeight;
            setVisibility(!isOutside());
            return this.currStateValues;
        }
        return null;
    }

    @Override // com.youku.danmaku.engine.danmaku.model.BaseDanmaku
    public float getRight() {
        return this.currStateValues[2];
    }

    @Override // com.youku.danmaku.engine.danmaku.model.BaseDanmaku
    public float getTop() {
        return this.currStateValues[1];
    }

    @Override // com.youku.danmaku.engine.danmaku.model.BaseDanmaku
    public int getType() {
        return 7;
    }

    @Override // com.youku.danmaku.engine.danmaku.model.BaseDanmaku
    public void layout(IDisplayer iDisplayer, float f, float f2) {
        getRectAtTime(iDisplayer, this.mTimer.currMillisecond);
    }

    public void setAlphaData(int i, int i2, long j) {
        this.beginAlpha = i;
        this.endAlpha = i2;
        int i3 = i2 - i;
        this.deltaAlpha = i3;
        this.alphaDuration = j;
        if (i3 == 0 || i == AlphaValue.MAX) {
            return;
        }
        this.alpha = i;
    }

    public void setLinePathData(float[][] fArr) {
        LinePath[] linePathArr;
        if (fArr != null) {
            int length = fArr.length;
            int i = 0;
            this.beginX = fArr[0][0];
            this.beginY = fArr[0][1];
            int i2 = length - 1;
            this.endX = fArr[i2][0];
            this.endY = fArr[i2][1];
            if (fArr.length > 1) {
                this.linePaths = new LinePath[fArr.length - 1];
                int i3 = 0;
                while (true) {
                    linePathArr = this.linePaths;
                    if (i3 >= linePathArr.length) {
                        break;
                    }
                    linePathArr[i3] = new LinePath();
                    i3++;
                    this.linePaths[i3].setPoints(new Point(fArr[i3][0], fArr[i3][1]), new Point(fArr[i3][0], fArr[i3][1]));
                }
                float f = 0.0f;
                for (LinePath linePath : linePathArr) {
                    f += linePath.getDistance();
                }
                LinePath linePath2 = null;
                LinePath[] linePathArr2 = this.linePaths;
                int length2 = linePathArr2.length;
                while (i < length2) {
                    LinePath linePath3 = linePathArr2[i];
                    long distance = (linePath3.getDistance() / f) * ((float) this.translationDuration);
                    linePath3.duration = distance;
                    long j = linePath2 == null ? 0L : linePath2.endTime;
                    linePath3.beginTime = j;
                    linePath3.endTime = j + distance;
                    i++;
                    linePath2 = linePath3;
                }
            }
        }
    }

    @Override // com.youku.danmaku.engine.danmaku.model.BaseDanmaku
    public void setPositionX(float f) {
        this.positionX = f;
    }

    @Override // com.youku.danmaku.engine.danmaku.model.BaseDanmaku
    public void setPositionY(float f) {
        this.positionY = f;
    }

    public void setTranslationData(float f, float f2, float f3, float f4, long j, long j2) {
        this.beginX = f;
        this.beginY = f2;
        this.endX = f3;
        this.endY = f4;
        this.deltaX = f3 - f;
        this.deltaY = f4 - f2;
        this.translationDuration = j;
        this.translationStartDelay = j2;
    }

    public void updateData(float f) {
    }
}
