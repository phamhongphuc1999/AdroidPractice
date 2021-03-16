package phucph20173303.hust.lab02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private int mCount = 0;
    private TextView mShowCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowCount = (TextView) findViewById(R.id.show_count);
    }

    public void toastButton_Click(View view) {
        Toast toast = Toast.makeText(this, R.string.toast_message, Toast.LENGTH_SHORT);
        toast.show();
    }

    public void zeroButton_Click(View view) {
        mCount = 0;
        if (mShowCount != null) mShowCount.setText(Integer.toString(mCount));
    }

    public void countButton_Click(View view) {
        mCount++;
        if (mShowCount != null) mShowCount.setText(Integer.toString(mCount));
    }
}