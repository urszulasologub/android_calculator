package com.example.calculator;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Button exit_button = (Button) findViewById(R.id.exit_button);
		exit_button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
				System.exit(0);
			}
		});

		Button about_button = (Button) findViewById((R.id.about_button));
		final AlertDialog.Builder about_dialog = new AlertDialog.Builder(this);
		about_dialog.setTitle("About");
		about_dialog.setMessage("Developed by Urszula Sołogub\ngithub.com/urszulasologub\n2020");
		about_button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				about_dialog.show();
			}
		});

		Button basic_button = (Button) findViewById(R.id.basic_button);
		basic_button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, BasicCalculatorActivity.class);
				startActivity(intent);
			}
		});
	}
}
