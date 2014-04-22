package com.anttek.supernote;

import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.anttek.supernote.model.Note;
import com.anttek.supernote.model.NoteDBHelper;

public class MainActivity extends Activity implements OnClickListener,
		OnItemClickListener, OnItemLongClickListener {
	private static final int CREATE_NEW_NOTE = 0;
	private static final int EDIT_NOTE = 1;
	private static final int CONFIRM_DIALOG = 0;
	private ListView mNoteList;
	private NoteDBHelper mDBHelper;
	private Note mLongClickNote;

	// private long mNoteEditedId;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// Note[] notes = Note.createTestArray();
		mDBHelper = new NoteDBHelper(this);

		this.mNoteList = (ListView) this.findViewById(R.id.list_note);
		this.mNoteList.setEmptyView(this.findViewById(android.R.id.empty));
		this.mNoteList.setOnItemClickListener(this);
		this.mNoteList.setOnItemLongClickListener(this);

		this.findViewById(R.id.btn_new_note).setOnClickListener(this);
		setListContent();
	}

	@Override
	public void onClick(View v) {
		if (v.getId() == R.id.btn_new_note) {
			this.startActivityForResult(new Intent(this,
					NoteEditorActivity.class), CREATE_NEW_NOTE);
		}
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		Note note = (Note) parent.getItemAtPosition(position);
		Intent intent = new Intent(this, NoteEditorActivity.class);
		intent.putExtra(Note._ID, note.getId());
		intent.putExtra(Note.EXTRA_TITLE, note.getTitle());
		intent.putExtra(Note.EXTRA_CONTENT, note.getContent());

		this.startActivityForResult(intent, EDIT_NOTE);
	}

	@Override
	public boolean onItemLongClick(AdapterView<?> parent, View view,
			int position, long id) {
		mLongClickNote = (Note) parent.getItemAtPosition(position);
		showDialog(CONFIRM_DIALOG);
		return true;
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (resultCode == RESULT_OK) {
			String title = data.getStringExtra(Note.EXTRA_TITLE);
			String content = data.getStringExtra(Note.EXTRA_CONTENT);
			long id = data.getLongExtra(Note._ID, Note.INVALIDATE_ID);
			switch (requestCode) {
			case CREATE_NEW_NOTE:
				mDBHelper.createNote(new Note(title, content));
				break;
			case EDIT_NOTE:
				mDBHelper.updateNote(new Note(title, content), id);
				break;
			}
			setListContent();
		}
		super.onActivityResult(requestCode, resultCode, data);
	}

	@Override
	protected Dialog onCreateDialog(int id) {
		switch (id) {
		case CONFIRM_DIALOG:
			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setMessage(R.string.dialog_title)
					.setMessage(R.string.dialog_confirm_delete_message)
					.setCancelable(true)
					.setPositiveButton(R.string.yes,
							new DialogInterface.OnClickListener() {

								@Override
								public void onClick(DialogInterface dialog,
										int which) {
									mDBHelper.deleteNote(mLongClickNote);
									setListContent();
								}
							})
					.setNegativeButton(R.string.no,
							new DialogInterface.OnClickListener() {

								@Override
								public void onClick(DialogInterface dialog,
										int which) {
									dismissDialog(CONFIRM_DIALOG);
								}
							});
			return builder.create();
		}
		return super.onCreateDialog(id);
	}

	// =============================================================

	private void setListContent() {
		// create adapter
		ArrayList<Note> notes = mDBHelper.readAllNote();
		ArrayAdapter<Note> adapter = new ArrayAdapter<Note>(this,
				R.layout.listitem_note, R.id.text_note_title, notes);
		// update listView
		this.mNoteList.setAdapter(adapter);
	}

}
