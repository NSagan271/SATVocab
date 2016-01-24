package com.example.hack.satwords;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Naomi on 1/23/2016.
 */
public class Draw extends View{
    static Question quest;
    Paint paint;
    GestureDetector gestureDetector;

    public Draw(Context context, int height,int width,Paint p) {
        super(context);
        paint = p;
        if (quest==null)quest = new Question(getResources(),height,width);
        gestureDetector=new GestureDetector(context,new GestureListener());
    }

    @Override
    public void onDraw(Canvas canvas){
        super.onDraw(canvas);
        quest.draw(canvas, paint);
        invalidate();
    }

    @Override
    public boolean onTouchEvent(@NonNull MotionEvent e) {
        return gestureDetector != null && gestureDetector.onTouchEvent(e);
    }

    private class GestureListener extends GestureDetector.SimpleOnGestureListener {

        @Override
        public boolean onDown(MotionEvent event) {
            if (!quest.showAns) {
                if (event.getX() < quest.width - (quest.width - quest.height) / 2 + 200 && event.getX() > (quest.width - quest.height) / 2 - 200 && event.getY() > 200 && event.getY() < 350) {
                    quest.choice = 1;
                    quest.showAns = true;
                    quest.questAns++;
                    if (quest.rightAns==quest.choice){
                        quest.score+=10;
                        quest.numRight++;
                    }
                    else if(quest.score>9 )quest.score-=10;
                    else quest.score=0;
                    quest.accuracy=((double)(quest.numRight)/(double)(quest.questAns))*100;
                } if (event.getX() < quest.width - (quest.width - quest.height) / 2 + 200 && event.getX() >  (quest.width - quest.height) / 2 - 200 && event.getY() > 350 && event.getY() < 500) {
                    quest.choice = 2;
                    quest.showAns = true;
                    quest.questAns++;
                    if (quest.rightAns==quest.choice){
                        quest.score+=10;
                        quest.numRight++;
                    }
                    else if(quest.score>9 )quest.score-=10;
                    else quest.score=0;
                    quest.accuracy=((double)(quest.numRight)/(double)(quest.questAns))*100;
                } if (event.getX() < quest.width - (quest.width - quest.height) / 2 + 200 && event.getX() > (quest.width - quest.height) / 2 - 200 && event.getY() > 500 && event.getY() < 650) {
                    quest.choice = 3;
                    quest.showAns = true;
                    quest.questAns++;
                    if (quest.rightAns==quest.choice){
                        quest.score+=10;
                        quest.numRight++;
                    }
                    else if(quest.score>9 )quest.score-=10;
                    else quest.score=0;
                    quest.accuracy=((double)(quest.numRight)/(double)(quest.questAns))*100;
                } if (event.getX() < quest.width - (quest.width - quest.height) / 2 + 200 && event.getX() >(quest.width - quest.height) / 2 - 200 && event.getY() > 650 && event.getY() < 800) {
                    quest.choice = 4;
                    quest.showAns = true;
                    quest.questAns++;
                    if (quest.rightAns==quest.choice){
                        quest.score+=10;
                        quest.numRight++;
                    }
                    else if(quest.score>9 )quest.score-=10;
                    else quest.score=0;
                    quest.accuracy=((double)(quest.numRight)/(double)(quest.questAns))*100;
                }


                switch(quest.score){
                    case 0:quest.lev=0;break;
                    case 10:case 40:quest.lev=1;break;
                    case 50:case 90:quest.lev=2;break;
                    case 100:case 190:quest.lev=3;break;
                    case 200:case 290: quest.lev =4;break;
                    case 300:case 390: quest.lev=5;break;
                    case 400:case 490:quest.lev=6;break;
                    case 500:case 590:quest.lev=7;break;
                    case 600:case 690: quest.lev=8;break;
                    case 700:case 790: quest.lev=9;break;
                    case 800: quest.lev=10;break;
                }
            } else if (event.getX() < quest.width - (quest.width - quest.height) / 2 + 200 && event.getX() > (quest.width - quest.height) / 2 - 200 && event.getY() > 850) {

                quest.showAns = false;
                quest.setQuestion();
            }
            invalidate();
            return true;
        }

    }
}
