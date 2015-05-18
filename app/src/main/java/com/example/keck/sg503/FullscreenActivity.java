package com.example.keck.sg503;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.widget.ImageButton;

import com.example.keck.sg503.util.SystemUiHider;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 *
 * @see SystemUiHider
 */
public class FullscreenActivity extends Activity {
    /**
     * Whether or not the system UI should be auto-hidden after
     * {@link #AUTO_HIDE_DELAY_MILLIS} milliseconds.
     */
    private static final boolean AUTO_HIDE = true;

    /**
     * If {@link #AUTO_HIDE} is set, the number of milliseconds to wait after
     * user interaction before hiding the system UI.
     */
    private static final int AUTO_HIDE_DELAY_MILLIS = 3000;

    /**
     * If set, will toggle the system UI visibility upon interaction. Otherwise,
     * will show the system UI visibility upon interaction.
     */
    private static final boolean TOGGLE_ON_CLICK = true;

    /**
     * The flags to pass to {@link SystemUiHider#getInstance}.
     */
    private static final int HIDER_FLAGS = SystemUiHider.FLAG_HIDE_NAVIGATION;

    /**
     * The instance of the {@link SystemUiHider} for this activity.
     */
    private SystemUiHider mSystemUiHider;

    ImageButton imgBtnLogo;
    int count = 0;


    private Handler customHandler = new Handler();
    private long startTime = 0L;
    long timeInMilliseconds = 0L;
    long updatedTime = 0L;
    long timeSwapBuff = 0L;
    boolean start=false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_fullscreen);
        count = 1;
        imgBtnLogo = (ImageButton) findViewById(R.id.btnLogo);


        startTime = SystemClock.uptimeMillis();
        customHandler.postDelayed(updateTimerThread2, 0);


        imgBtnLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customHandler.removeCallbacks(updateTimerThread2);

                blinkcount = 0;

                startTime = SystemClock.uptimeMillis();

                customHandler.postDelayed(updateTimerThread, 0);

//                if (!start) {
//                    startTime = SystemClock.uptimeMillis();
//                    customHandler.removeCallbacks(updateTimerThread2);
//                    customHandler.postDelayed(updateTimerThread, 0);
//                    start = true;
//                } else {
//                    customHandler.removeCallbacks(updateTimerThread);
//                    startTime = SystemClock.uptimeMillis();
//                    customHandler.postDelayed(updateTimerThread2, 0);
//                    start = false;
//                }
            }
        });

        // Upon interacting with UI controls, delay any scheduled hide()
        // operations to prevent the jarring behavior of controls going away
        // while interacting with the UI.

    }

    int blinkcount = 0;
    private Runnable updateTimerThread = new Runnable() {
        public void run() {
            timeInMilliseconds = SystemClock.uptimeMillis() - startTime;
            updatedTime = timeSwapBuff + timeInMilliseconds;
            //int secs = (int) (updatedTime / 1000);
            //int mins = secs / 60;
            //secs = secs % 60;
            //int milliseconds = (int) (updatedTime % 1000);
            customHandler.postDelayed(this, 0);
            if (timeInMilliseconds > 200)
            {
                //count++;
                startTime = SystemClock.uptimeMillis();

                switch (count) {
                    case 0:
                        //imgBtnLogo.setBackgroundResource(R.drawable.eyeb2);
                        imgBtnLogo.setImageDrawable(getResources().getDrawable(R.drawable.eyeb2));
                        break;
                    case 10:
                    case 11:
                    case 2:
                        //imgBtnLogo.setBackgroundResource(R.drawable.eyeb1);
                        imgBtnLogo.setImageDrawable(getResources().getDrawable(R.drawable.eyeb1));
                        break;
                }
                count++;
                if (count > 4) {
                    count = 0;
                    blinkcount++;
                }
            }
            if (blinkcount>2) {
                customHandler.removeCallbacks(updateTimerThread);
                startTime = SystemClock.uptimeMillis();
                customHandler.postDelayed(updateTimerThread2, 0);
            }
        }
    };

    private Runnable updateTimerThread2 = new Runnable() {
        public void run() {
            timeInMilliseconds = SystemClock.uptimeMillis() - startTime;
            updatedTime = timeSwapBuff + timeInMilliseconds;
            //int secs = (int) (updatedTime / 1000);
            //int mins = secs / 60;
            //secs = secs % 60;
            //int milliseconds = (int) (updatedTime % 1000);
            customHandler.postDelayed(this, 0);
            if (timeInMilliseconds > 200)
            {
                //count++;
                startTime = SystemClock.uptimeMillis();

                switch (count) {
                    case 0://imgBtnLogo.setBackgroundResource(R.drawable.eyem1);
                        imgBtnLogo.setImageDrawable(getResources().getDrawable(R.drawable.eyem1));
                        break;
                    case 1://imgBtnLogo.setBackgroundResource(R.drawable.eyem2);
                        imgBtnLogo.setImageDrawable(getResources().getDrawable(R.drawable.eyem2));
                        break;
                    case 2:case 3:case 4:case 5:
                    case 6:case 7:case 8:case 9:
                        //imgBtnLogo.setBackgroundResource(R.drawable.eyem3);
                        imgBtnLogo.setImageDrawable(getResources().getDrawable(R.drawable.eyem3));
                        break;
                    case 10://imgBtnLogo.setBackgroundResource(R.drawable.eyem2);
                        imgBtnLogo.setImageDrawable(getResources().getDrawable(R.drawable.eyem2));
                        break;
                    case 11://imgBtnLogo.setBackgroundResource(R.drawable.eyem9);
                        imgBtnLogo.setImageDrawable(getResources().getDrawable(R.drawable.eyem9));
                        break;
                    case 12://imgBtnLogo.setBackgroundResource(R.drawable.eyem8);
                        imgBtnLogo.setImageDrawable(getResources().getDrawable(R.drawable.eyem8));
                        break;
                    case 13:case 14:case 15:case 16:
                    case 17:case 18:case 19:case 20:
                        //imgBtnLogo.setBackgroundResource(R.drawable.eyem7);
                        imgBtnLogo.setImageDrawable(getResources().getDrawable(R.drawable.eyem7));
                        break;
                    case 21://imgBtnLogo.setBackgroundResource(R.drawable.eyem8);
                        imgBtnLogo.setImageDrawable(getResources().getDrawable(R.drawable.eyem8));
                        break;
                    case 22://imgBtnLogo.setBackgroundResource(R.drawable.eyem9);
                        imgBtnLogo.setImageDrawable(getResources().getDrawable(R.drawable.eyem9));
                        break;
//                    case 23:case 24:case 25:case 26:
//                    case 27:case 28:case 29:case 30:
//                        imgBtnLogo.setBackgroundResource(R.drawable.eyeb2);break;
                }
                count++;
                if (count > 30) count = 0;
            }
        }
    };


    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);



    }


    /**
     * Touch listener to use for in-layout UI controls to delay hiding the
     * system UI. This is to prevent the jarring behavior of controls going away
     * while interacting with activity UI.
     */

}
