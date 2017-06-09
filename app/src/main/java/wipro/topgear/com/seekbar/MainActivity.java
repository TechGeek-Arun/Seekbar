package wipro.topgear.com.seekbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int seekbarR_value=0, seekbarG_value=0, seekbarB_value=0;
    SeekBar red_SeekBar, green_SeekBar, blue_SeekBar;
    RelativeLayout m_Screen;
    TextView red_val,green_val,blue_val;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        m_Screen = (RelativeLayout) findViewById(R.id.screen);

        red_SeekBar = (SeekBar) findViewById(R.id.seekingBar_R);
        green_SeekBar = (SeekBar) findViewById(R.id.seekingBar_G);
        blue_SeekBar = (SeekBar) findViewById(R.id.seekingBar_B);

        red_val= (TextView) findViewById(R.id.redvalue);
        green_val= (TextView) findViewById(R.id.greenvalue);
        blue_val= (TextView) findViewById(R.id.bluevalue);

        red_val.setText(String.valueOf(seekbarR_value));
        green_val.setText(String.valueOf(seekbarG_value));
        blue_val.setText(String.valueOf(seekbarB_value));

        updateBackground();

        red_SeekBar.setOnSeekBarChangeListener(seekBarChangeListener);
        green_SeekBar.setOnSeekBarChangeListener(seekBarChangeListener);
        blue_SeekBar.setOnSeekBarChangeListener(seekBarChangeListener);

    }

    private SeekBar.OnSeekBarChangeListener seekBarChangeListener
            = new SeekBar.OnSeekBarChangeListener()
    {

        @Override
        public void onProgressChanged(SeekBar seekBar, int progress,
                                      boolean fromUser) {
// TODO Auto-generated method stub
            updateBackground();
        }
        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
// TODO Auto-generated method stub
        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
// TODO Auto-generated method stub
        }
    };

    private void updateBackground()
    {
        seekbarR_value = red_SeekBar.getProgress();
        seekbarG_value = green_SeekBar.getProgress();
        seekbarB_value = blue_SeekBar.getProgress();

        red_val.setText(String.valueOf(seekbarR_value));
        green_val.setText(String.valueOf(seekbarG_value));
        blue_val.setText(String.valueOf(seekbarB_value));

        m_Screen.setBackgroundColor(
                0xff000000
                        + seekbarR_value * 0x10000
                        + seekbarG_value * 0x100
                        + seekbarB_value
        );
    }
}