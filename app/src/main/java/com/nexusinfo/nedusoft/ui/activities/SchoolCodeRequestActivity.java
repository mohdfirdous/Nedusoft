package com.nexusinfo.nedusoft.ui.activities;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.nexusinfo.nedusoft.MyApplication;
import com.nexusinfo.nedusoft.R;
import com.nexusinfo.nedusoft.connection.SchoolCodeConnection;
import com.nexusinfo.nedusoft.models.UserModel;
import com.nexusinfo.nedusoft.receivers.InternetConnectivityReceiver;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import static com.nexusinfo.nedusoft.utils.Util.showCustomToast;

public class SchoolCodeRequestActivity extends AppCompatActivity implements InternetConnectivityReceiver.InternetConnectivityReceiverListener {

    private ProgressBar progressBar;
    private Button buttonSubmit;
    private EditText etSchoolCode;
    private TextView tvError;

    private String schoolCode, dbName, schoolEmail, schoolName, cmpId, brCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school_code_request);

        progressBar = findViewById(R.id.progressBar_school_code);
        progressBar.setVisibility(View.GONE);
        etSchoolCode = findViewById(R.id.editText_school_code);
        buttonSubmit = findViewById(R.id.button_school_code_submit);
        tvError = findViewById(R.id.textView_error_schoolCodeActivity);

        tvError.setVisibility(View.GONE);

        showError(InternetConnectivityReceiver.isConnected());

        buttonSubmit.setOnClickListener(view -> {

            if(!InternetConnectivityReceiver.isConnected()){
                tvError.setVisibility(View.VISIBLE);
                tvError.setText(R.string.errorMessageForInternet);
            }
            else {
                tvError.setVisibility(View.GONE);
                Log.e("Available", "Internet Available....  :) :) :D");

                CheckSchoolCodeTask task = new CheckSchoolCodeTask();
                task.execute("");
            }

        });

        etSchoolCode.setOnEditorActionListener((v, actionId, event) -> {
            if(actionId == EditorInfo.IME_ACTION_DONE) {
                buttonSubmit.performClick();
                return true;
            }
            return false;
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        MyApplication.getInstance().setConnectivityListener(this);
    }

    private void showError(boolean isConnected) {

        if (!isConnected) {
            tvError.setVisibility(View.VISIBLE);
            tvError.setText(R.string.errorMessageForInternet);
        }
        else {
            tvError.setVisibility(View.GONE);
        }

    }

    @Override
    public void onNetworkConnectionChanged(boolean isConnected) {
        showError(isConnected);
    }

    class CheckSchoolCodeTask extends AsyncTask<String, String, UserModel>{

        @Override
        protected void onPreExecute() {

            schoolCode = etSchoolCode.getText().toString().trim();

            if(schoolCode.equals("")){
                etSchoolCode.setError("Enter the school code to continue");
                cancel(true);
            }
            else {
                loadStart();
            }
        }

        @Override
        protected UserModel doInBackground(String... strings) {
            UserModel user = null;
            try{
                user = new UserModel();

                String query = "SELECT * FROM " + SchoolCodeConnection.TABLE_NEDUSOFT + " WHERE " + SchoolCodeConnection.COL_UNIQUE_ID + " = '" + schoolCode + "'";

                SchoolCodeConnection schoolCodeConnection = new SchoolCodeConnection();

                Connection conn = schoolCodeConnection.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                if(rs != null){
                    int count = 0;
                    while (rs.next()){
                        schoolCode = rs.getString(SchoolCodeConnection.COL_UNIQUE_ID);
                        dbName = rs.getString(SchoolCodeConnection.COL_DATABASE_NAME);
                        schoolEmail = rs.getString(SchoolCodeConnection.COL_EMAIL);
                        schoolName = rs.getString(SchoolCodeConnection.COL_SCHOOL_NAME);
                        cmpId = rs.getString(SchoolCodeConnection.COL_COMPANY_ID);
                        brCode = rs.getString(SchoolCodeConnection.COL_BRCODE);
                        count++;
                    }

                    user.setSchoolCode(schoolCode);
                    user.setSchoolDBName(dbName);
                    user.setSchoolEmail(schoolEmail);
                    user.setSchoolName(schoolName);
                    user.setCmpId(cmpId);
                    user.setBrCode(brCode);

                    if(count < 1) {
                        publishProgress("NoData");
                        cancel(true);
                        Log.e("Error", "No data for given school code");
                    }
                }
                else {
                    Log.e("Error", "rs is null");
                }
            }
            catch (Exception e){
                publishProgress("Exception");
                cancel(true);
                Log.e("Exception", e.toString());
            }
            return user;
        }

        @Override
        protected void onProgressUpdate(String... values) {
            if(values[0].equals("Exception")){
                showCustomToast(SchoolCodeRequestActivity.this, "Some error occurred.",1);
                loadFinish();
            }
            if(values[0].equals("NoData")){
                etSchoolCode.setError("Invalid school code");
                loadFinish();
            }
        }

        @Override
        protected void onPostExecute(UserModel user) {

            if(isCancelled()){
                return;
            }

            Log.e("Data", "School code: " + user.getSchoolCode() + " School DB: " + user.getSchoolDBName());
            Intent loginIntent = new Intent(SchoolCodeRequestActivity.this, LoginActivity.class);
            loginIntent.putExtra("User", user);
            startActivity(loginIntent);
            finish();

            loadFinish();
        }

        private void loadStart(){
            progressBar.setVisibility(View.VISIBLE);
            buttonSubmit.setEnabled(false);
            etSchoolCode.setEnabled(false);
        }

        private void loadFinish(){
            progressBar.setVisibility(View.GONE);
            buttonSubmit.setEnabled(true);
            etSchoolCode.setEnabled(true);
        }
    }
}
