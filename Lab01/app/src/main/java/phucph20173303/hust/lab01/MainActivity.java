package phucph20173303.hust.lab01;

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

    public  void add(View view){
        mCount++;
        if (mShowCount != null)  mShowCount.setText(Integer.toString(mCount));
    }

    public  void subtract(View view){
        mCount--;
        if (mShowCount != null)  mShowCount.setText(Integer.toString(mCount));
    }

    public  void showMessage(View view){
        Toast toast = Toast.makeText(this, R.string.toast_message, Toast.LENGTH_SHORT);
        toast.show();
    }
}