package cse.mobile.myviewtest;

import android.content.Context;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class MyView extends View {
    int mPosX, mPosY;
    Paint mPaint = new Paint();
    int x,y;

    public MyView(Context context) {
        super(context);
        mPaint.setTextSize(20);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        x = (int) event.getX(0);
        y = (int) event.getY(0);
        invalidate();
        return super.onTouchEvent(event);
    }
}


//이벤트 처리에 대한 방법3가지 + 각강에 대해 코드랑 정리해서 레포트... 10/2 화요일까지제출
