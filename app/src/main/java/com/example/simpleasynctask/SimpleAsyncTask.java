package com.example.simpleasynctask;

import android.os.AsyncTask;
import android.widget.TextView;

import java.lang.ref.WeakReference;
import java.util.Random;

public class SimpleAsyncTask extends AsyncTask<Void, Void, String > {

    private WeakReference<TextView> mTextView;

    SimpleAsyncTask(TextView tv) {
        mTextView = new WeakReference<>(tv);
    }

    @Override
    protected String doInBackground(Void... voids) {

        // Random number generator
        Random r = new Random();
        int n = r.nextInt(11);

        /*
        Make the phone sleep long enough to be able to
        rotate the phone while asleep
         */
        int s = n * 400;

        // Sleep for the random amount of time
        try {
            Thread.sleep(s);
        } catch (InterruptedException e){
            e.printStackTrace();
        }

        // Return a String result
        return "Awake at last after sleeping for " + s +
                " milliseconds!!";
    }

    protected void onPostExecute(String result){
        mTextView.get().setText(result);
    }
}
