package phucph20173303.hust.myapplication;

import android.os.AsyncTask;
import android.widget.EditText;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.ref.WeakReference;

public class SimpleAsyncTask extends AsyncTask<String, Void, String> {
    private WeakReference<EditText> mServerText;
    private WeakReference<EditText> mTokenText;

    SimpleAsyncTask(EditText mServerText, EditText mTokenText) {
        this.mServerText = new WeakReference<>(mServerText);
        this.mTokenText = new WeakReference<>(mTokenText);
    }

    @Override
    protected String doInBackground(String... strings) {
        try {
            return NetworkService.SEND_POST(strings[0], strings[1]);
        } catch (IOException e) {
            e.printStackTrace();
            return "0";
        }
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        try {
            JSONObject jsonObject = new JSONObject(s);
            mServerText.get().setText(jsonObject.getString("serverTime"));
            mTokenText.get().setText(jsonObject.getString("studentToken"));
        } catch (JSONException e) {
            mServerText.get().setText("");
            mTokenText.get().setText("");
            e.printStackTrace();
        }
    }
}
