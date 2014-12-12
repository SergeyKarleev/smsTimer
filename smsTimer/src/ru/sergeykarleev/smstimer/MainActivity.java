package ru.sergeykarleev.smstimer;

import ru.sergeykarleev.smstimer.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends Activity {

	TextView tvSMS;
	TextView tvTimer;
	ProgressBar pbTimer;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		tvSMS = (TextView) findViewById(R.id.tvSMS);
		tvSMS.setText(getSMSBody());
		tvTimer = (TextView) findViewById(R.id.tvTimer);
	}

	private String getSMSBody() {
		try {
			return getIntent().getExtras().getString(SMSMonitor.SMS_BODY);
		} catch (Exception e) {
			return "none";
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
