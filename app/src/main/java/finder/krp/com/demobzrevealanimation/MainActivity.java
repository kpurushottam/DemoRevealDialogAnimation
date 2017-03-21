package finder.krp.com.demobzrevealanimation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int mActionBarHeight;

    private View.OnClickListener mDialogListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, DialogActivity.class);
            intent.putExtra("x", v.getX());
            intent.putExtra("y", v.getY()+mActionBarHeight/2);
            intent.putExtra("w", v.getWidth());
            intent.putExtra("h", v.getHeight());
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(intent);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView tvWelcome = (TextView) findViewById(R.id.tv_welcome);
        tvWelcome.setOnClickListener(mDialogListener);
        final TextView tvWelcomeLeft = (TextView) findViewById(R.id.tv_welcome_l);
        tvWelcomeLeft.setOnClickListener(mDialogListener);
        final TextView tvWelcomeCenter = (TextView) findViewById(R.id.tv_welcome_c);
        tvWelcomeCenter.setOnClickListener(mDialogListener);
        final TextView tvWelcomeBottomLeft = (TextView) findViewById(R.id.tv_welcome_bl);
        tvWelcomeBottomLeft.setOnClickListener(mDialogListener);
        final TextView tvWelcomeBottomRight = (TextView) findViewById(R.id.tv_welcome_br);
        tvWelcomeBottomRight.setOnClickListener(mDialogListener);

    }


    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        ActionBar actionBar = getSupportActionBar();
        if(hasFocus && actionBar.isShowing()) {
            mActionBarHeight = actionBar.getHeight();
        }
    }
}
