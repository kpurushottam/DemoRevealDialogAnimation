package finder.krp.com.demobzrevealanimation;

import android.animation.Animator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;

public class DialogActivity extends AppCompatActivity {

    float currentX = 0;
    float currnetY = 0;
    float currentW = 0;
    float currentH = 0;

    float x, y, w, h;

    CardView mCardView;

    private View.OnClickListener mHideDialogListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            final float pivotalXR = x+w;
            final float pivotalXL = x;
            final float pivotalYT = y-h;

            if(x > currentX) {
                mCardView.setPivotX(pivotalXR);
                mCardView.setPivotY(y<currnetY ? pivotalYT : currnetY);
            } else {
                mCardView.setPivotX(pivotalXL);
                mCardView.setPivotY(y<currnetY ? pivotalYT : currnetY);
            }

            final float translateXR = (x+w) - (currentX+currentW);
            final float translateXL = (currentX) - (x);
            final float translateYT = (y) - (currnetY);
            final float translateYB = (y+h) - (currnetY+currentH);

            mCardView.animate()
                    .translationXBy(x>currentX ? translateXR : translateXL)
                    .translationYBy(y<currnetY ? translateYT : translateYB)
                    .scaleX(w/currentW)
                    .scaleY(h/currentH)
                    .alpha(0)
                    .setDuration(350)
                    .setInterpolator(new AccelerateInterpolator(1f))
                    .setListener(new Animator.AnimatorListener() {
                        @Override
                        public void onAnimationStart(Animator animation) {

                        }

                        @Override
                        public void onAnimationEnd(Animator animation) {
                            mCardView.setVisibility(View.GONE);
                            DialogActivity.this.finish();
                        }

                        @Override
                        public void onAnimationCancel(Animator animation) {

                        }

                        @Override
                        public void onAnimationRepeat(Animator animation) {

                        }
                    });
        }
    };

    private View.OnClickListener mShowDialogListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            final float pivotalXR = x+w;
            final float pivotalXL = x;
            final float pivotalYT = y-h;

            if(x > currentX) {
                mCardView.setPivotX(pivotalXR);
                mCardView.setPivotY(y<currnetY ? -pivotalYT : currnetY);
            } else {
                mCardView.setPivotX(pivotalXL);
                mCardView.setPivotY(y<currnetY ? -pivotalYT : currnetY);
            }

            final float translateXR = (x+w) - (currentX+currentW);
            final float translateXL = (currentX) - (x);
            final float translateYT = (y) - (currnetY);
            final float translateYB = (y+h) - (currnetY+currentH);

            mCardView.animate()
                    .translationXBy(x>currentX ? -translateXR : -translateXL)
                    .translationYBy(y<currnetY ? -translateYT : -translateYB)
                    .scaleX(1)
                    .scaleY(1)
                    .alpha(1)
                    .setDuration(200)
                    .setInterpolator(new DecelerateInterpolator(1f))
                    .setListener(new Animator.AnimatorListener() {
                        @Override
                        public void onAnimationStart(Animator animation) {

                        }

                        @Override
                        public void onAnimationEnd(Animator animation) {
                            mCardView.setVisibility(View.VISIBLE);
                        }

                        @Override
                        public void onAnimationCancel(Animator animation) {

                        }

                        @Override
                        public void onAnimationRepeat(Animator animation) {

                        }
                    });
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // remove title
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_dialog);

        mCardView = (CardView) findViewById(R.id.content_main);


        if(getIntent().getExtras() != null) {
            x = getIntent().getFloatExtra("x", 0.0f);
            y = getIntent().getFloatExtra("y", 0.0f);
            w = getIntent().getIntExtra("w", 0);
            h = getIntent().getIntExtra("h", 0);

            mCardView.setOnClickListener(mHideDialogListener);
        }
    }


    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

        if(hasFocus && mCardView != null) {
            currentX = mCardView.getX();
            currnetY = mCardView.getY();
            currentW = mCardView.getWidth();
            currentH = mCardView.getHeight();



            final float pivotalXR = x+w;
            final float pivotalXL = x;
            final float pivotalYT = y-h;

            if(x > currentX) {
                mCardView.setPivotX(pivotalXR);
                mCardView.setPivotY(y<currnetY ? pivotalYT : currnetY);
            } else {
                mCardView.setPivotX(pivotalXL);
                mCardView.setPivotY(y<currnetY ? pivotalYT : currnetY);
            }

            final float translateXR = (x+w) - (currentX+currentW);
            final float translateXL = (currentX) - (x);
            final float translateYT = (y) - (currnetY);
            final float translateYB = (y+h) - (currnetY+currentH);

            mCardView.animate()
                    .translationXBy(x>currentX ? translateXR : translateXL)
                    .translationYBy(y<currnetY ? translateYT : translateYB)
                    .scaleX(w/currentW)
                    .scaleY(h/currentH)
                    .alpha(0)
                    .setDuration(1)
                    .setListener(new Animator.AnimatorListener() {
                        @Override
                        public void onAnimationStart(Animator animation) {

                        }

                        @Override
                        public void onAnimationEnd(Animator animation) {
                            mShowDialogListener.onClick(mCardView);
                        }

                        @Override
                        public void onAnimationCancel(Animator animation) {

                        }

                        @Override
                        public void onAnimationRepeat(Animator animation) {

                        }
                    });
        }
    }
}
