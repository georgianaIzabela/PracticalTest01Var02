package ro.pub.cs.systems.eim.practicaltest01var02;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PracticalTestVar02SecondaryActivity extends Activity {

	private EditText editText1 = null;
	private EditText editText2 = null;
	private EditText editText3 = null;
	private EditText editText4 = null;
	private Button sumB = null, productB = null;
	private ButtonListener listener = new ButtonListener();
	class ButtonListener implements View.OnClickListener {

		@Override
		public void onClick(View v) {
			
			switch (v.getId()) {
			
			case R.id.button1:
				int s = Integer.parseInt(editText1.getText().toString()) + Integer.parseInt(editText2.getText().toString()) +
				 Integer.parseInt(editText3.getText().toString()) + Integer.parseInt(editText4.getText().toString());
				Toast.makeText(getApplicationContext(), "result " + s, Toast.LENGTH_LONG).show();
				// sum
				break;
			case R.id.button2:
				// product
				int p = Integer.parseInt(editText1.getText().toString()) * Integer.parseInt(editText2.getText().toString()) *
				 Integer.parseInt(editText3.getText().toString()) * Integer.parseInt(editText4.getText().toString());
				Toast.makeText(getApplicationContext(), "result " + p, Toast.LENGTH_LONG).show();
				break;
			}
			
			
		}
		
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_practical_test_var02_secondary);
		
		editText1 = (EditText) findViewById(R.id.editText1);
		editText2 = (EditText) findViewById(R.id.editText2);
		editText3 = (EditText) findViewById(R.id.editText3);
		editText4 = (EditText) findViewById(R.id.editText4);
		
		
		Intent intent = getIntent();
		if (intent != null) {
			String val1 = intent.getStringExtra("val1");
			String val2 = intent.getStringExtra("val2");
			String val3 = intent.getStringExtra("val3");
			String val4 = intent.getStringExtra("val4");
			editText1.setText(val1);
			editText2.setText(val2);
			editText3.setText(val3);
			editText4.setText(val4);
		}
		sumB = (Button)findViewById(R.id.button1);
		productB = (Button)findViewById(R.id.button2);
		sumB.setOnClickListener(listener);
		productB.setOnClickListener(listener);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.practical_test_var02_secondary, menu);
		
		
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
