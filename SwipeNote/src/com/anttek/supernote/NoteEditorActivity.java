package com.anttek.supernote;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

import com.anttek.supernote.model.Note;

public class NoteEditorActivity extends Activity implements OnClickListener {
	private static final int ALTER_DIALOG = 0;
	private EditText mTitleEdit;
	private EditText mContentEdit;
	private long mId;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.activity_note_editor);

		this.mTitleEdit = (EditText) this.findViewById(R.id.edit_note_title);
		this.mContentEdit = (EditText) this
				.findViewById(R.id.edit_note_content);

		String noteTitle = this.getIntent().getStringExtra(Note.EXTRA_TITLE);
		String noteContent = this.getIntent()
				.getStringExtra(Note.EXTRA_CONTENT);
		mId = this.getIntent().getLongExtra(Note._ID, Note.INVALIDATE_ID);

		if (!TextUtils.isEmpty(noteTitle)) {
			this.mTitleEdit.setText(noteTitle);
		}
		if (!TextUtils.isEmpty(noteContent)) {
			this.mContentEdit.setText(noteContent);
		}

		this.findViewById(R.id.btn_save_note).setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		if (v.getId() == R.id.btn_save_note) {
			if (TextUtils.isEmpty(mTitleEdit.getText().toString())) {
				showDialog(ALTER_DIALOG);
				return;
			}
			// TODO Will be implemented later
			Intent intent = new Intent();
			intent.putExtra(Note._ID, mId);
			intent.putExtra(Note.EXTRA_TITLE, mTitleEdit.getText().toString());
			intent.putExtra(Note.EXTRA_CONTENT, mContentEdit.getText()
					.toString());
			setResult(RESULT_OK, intent);
			finish();
		}
	}

	@Override
	public void onBackPressed() {
		finish();
	}

	@Override
	protected Dialog onCreateDialog(int id) {
		switch (id) {
		case ALTER_DIALOG:
			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setMessage(R.string.dialog_title)
					.setMessage(R.string.dialog_alter_empty_message)
					.setCancelable(true)
					.setPositiveButton(android.R.string.yes,
							new DialogInterface.OnClickListener() {

								@Override
								public void onClick(DialogInterface dialog,
										int which) {
									dismissDialog(ALTER_DIALOG);
								}
							});
			return builder.create();
		}
		return super.onCreateDialog(id);
	}

}
