package org.NTUH.barcodereader;

import java.text.DecimalFormat;

import android.R.string;
import android.support.v7.app.ActionBarActivity;
import android.text.format.Time;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		findViews();
		setListeners();
	}

	private EditText field_input;
	private TextView view_output;
	private Time now = new Time();

	private void findViews() {
		field_input = (EditText) findViewById(R.id.input);
		view_output = (TextView) findViewById(R.id.output);
	}

	private void setListeners() {
		field_input.setOnEditorActionListener(checkKey);

	}

	private OnEditorActionListener checkKey = new OnEditorActionListener() {

		@Override
		public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
			now.setToNow();
			DecimalFormat tf = new DecimalFormat("00");
			String timeNow = "" + now.hour + ":" + tf.format(now.minute) + ":"
					+ tf.format(now.second);
			String tmp = view_output.getText().toString();
			view_output.setText(tmp + field_input.getText().toString() + " "
					+ timeNow);
			field_input.getText().clear();
			return false;
		}
	};

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
