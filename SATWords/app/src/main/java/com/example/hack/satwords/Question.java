package com.example.hack.satwords;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.view.GestureDetector;
import android.view.MotionEvent;

import java.util.Objects;
import java.util.Random;

/**
 * Created by Naomi on 1/23/2016.
 */
public class  Question {
    String[] words;
    String[] def;
    Boolean quest=true;
    Boolean showAns = false;
    int rightAns;
    int choice;
    String[] qa = new String[] {"","","","",""};
    Random r;
    int height;
    int width;
    int score;
    double accuracy;
    int questAns;
    int numRight;
    int lev;
    String levels[]=new String[]{"NOBODY.","A PEASANT.","A WORD APPRENTICE.","A BOOK.","A WORDSMITH.","A DICTIONARY.", "THE MAYOR OF WORDS.","THE WORD GOVERNOR.","ROYALTY!", "THE VOCAB PRINCE!!","THE VOCAB EMPEROR!!!", "THE RULER OF THE UNIVERSE!!!"};

    public Question(Resources res, int h, int w){
        words = res.getStringArray(R.array.words);
        def = res.getStringArray(R.array.definitions);
        r = new Random();
        lev=0;
        height = h;
        width = w;
        score = 0;
        questAns=0;
        numRight=0;
        accuracy = 0;
        setQuestion();
    }

    void setQuestion(){
        qa = new String[] {"","","","",""};
        int word = r.nextInt(words.length);
        qa[0]= words[word];
        rightAns=r.nextInt(5-1)+1;
        qa[rightAns]=def[word];

        boolean cont;
        int[] cantUse = new int[]{word,-1,-1};
        int use=-1;

        for (int i = 0; i<3;i++){
            cont = false;
            while (!cont){
                use = r.nextInt(words.length);
                if (use!=cantUse[0]&&use!=cantUse[1]&&use!=cantUse[2]){
                    cont = true;
                   if (i<2) cantUse[i+1]=use;
                }
            }
            for (int j=1;j<5;j++){
                if (qa[j].equals("")){
                    qa[j]=def[use];
                    j=5;
                }
            }
        }
    }

    void draw(Canvas canvas, Paint paint){
        paint.setColor(Color.LTGRAY);
        canvas.drawRect((width - height) / 2 - 200, 0, width - (width - height) / 2 + 200, height, paint);

        paint.setTextSize(60);

        paint.setColor(Color.RED);
        canvas.drawText("YOU ARE "+levels[lev], (width - height) / 2 - 180, 70, paint);

        paint.setColor(Color.BLUE);
        canvas.drawText(qa[0], (width - height) / 2 - 180, 180, paint);

        paint.setColor(Color.MAGENTA);
        canvas.drawText("Score: " + String.valueOf(score) +"   Accuracy: "+(int)(accuracy)+"%", width-(width - height)-70, 180, paint);

        paint.setColor(Color.WHITE);
        if (showAns && choice==1)paint.setColor(Color.parseColor("#F08080"));
        if (showAns && rightAns==1)paint.setColor(Color.parseColor("#93DB70"));
        canvas.drawRect((width - height) / 2 - 200, 200, width - (width - height) / 2 + 200, 350, paint);

        paint.setTextSize(50);
        paint.setColor(Color.BLACK);
        canvas.drawText("(A) " + qa[1], (width - height) / 2 - 180, 300, paint);

        if (!showAns)paint.setColor(Color.parseColor("#C1F0F6"));
        else paint.setColor(Color.WHITE);
        if (showAns && choice==2)paint.setColor(Color.parseColor("#F08080"));
        if (showAns && rightAns==2)paint.setColor(Color.parseColor("#93DB70"));
        canvas.drawRect((width - height) / 2 - 200, 350, width - (width - height) / 2 + 200, 500, paint);

        paint.setColor(Color.BLACK);
        canvas.drawText("(B) " + qa[2], (width - height) / 2 - 180, 450, paint);

        paint.setColor(Color.WHITE);
        if (showAns && choice==3)paint.setColor(Color.parseColor("#F08080"));
        if (showAns && rightAns==3)paint.setColor(Color.parseColor("#93DB70"));
        canvas.drawRect((width - height) / 2 - 200, 500, width - (width - height) / 2 + 200, 650, paint);

        paint.setColor(Color.BLACK);
        canvas.drawText("(C) " + qa[3], (width - height) / 2 - 180, 600, paint);

        if(!showAns)paint.setColor(Color.parseColor("#C1F0F6"));
        else paint.setColor(Color.WHITE);
        if (showAns && choice==4)paint.setColor(Color.parseColor("#F08080"));
        if (showAns && rightAns==4)paint.setColor(Color.parseColor("#93DB70"));
        canvas.drawRect((width - height) / 2 - 200, 650, width - (width - height) / 2 + 200, 800, paint);

        paint.setColor(Color.BLACK);
        canvas.drawText("(D) " + qa[4], (width - height) / 2-180, 750, paint);

        if (showAns){
            paint.setColor(Color.BLACK);
            canvas.drawRect((width - height) / 2 - 200, 850, width - (width - height) / 2 + 200, 1000, paint);
            paint.setColor(Color.WHITE);
            canvas.drawText("NEXT",(width - height) / 2-180,950,paint);
        }

    }



}
