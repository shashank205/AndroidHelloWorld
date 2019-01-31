package com.example.simpleasynctask;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import java.lang.ref.WeakReference;
import java.util.Random;

public class SimpleAsyncTask extends AsyncTask<Void, Void, String> {

    private WeakReference<TextView> mTextView;
    private Random r =new Random();

    SimpleAsyncTask(TextView tv){
        mTextView = new WeakReference<>(tv);
    }

    @Override
    protected String doInBackground(Void... voids) {
        int n = r.nextInt(11) * 200;
        try {
            Thread.sleep(n);
        } catch (InterruptedException e){
            Thread.currentThread().interrupt();
            Log.e("Interrupted Exception", e.getMessage());
        }
        return "Awake at last after sleeping for " + n + " milliseconds!";
    }

    protected void onPostExecute(String result) {
        mTextView.get().setText(result);
    }
}
