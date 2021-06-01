package phucph20173303.hust.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private EditText studentIdEditText;
    private EditText macAddressEditText;

    private EditText localTimeEditText;
    private EditText serverTimeEditText;
    private EditText tokenTimeEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        studentIdEditText = (EditText) findViewById(R.id.editText_student_id);
        macAddressEditText = (EditText) findViewById(R.id.editText_mac_id);

        localTimeEditText = (EditText)findViewById(R.id.editText_local_time);
        serverTimeEditText = (EditText)findViewById(R.id.editText_server_time);
        tokenTimeEditText = (EditText)findViewById(R.id.editText_token);
    }

    public void getTokenOnClick(View view) throws IOException {
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date();
        String macId = Utilities.getMacAddress();
        macAddressEditText.setText(macId);
        localTimeEditText.setText(formatter.format(date));

        String studentId = studentIdEditText.getText().toString();
        if (studentId != "") {
            new SimpleAsyncTask(serverTimeEditText, tokenTimeEditText).execute(studentId, macId);
        }
    }
}