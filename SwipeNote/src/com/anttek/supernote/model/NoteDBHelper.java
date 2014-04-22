package com.anttek.supernote.model;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class NoteDBHelper extends SQLiteOpenHelper {
	private static final String DATABASE_NAME = "note.db";
	private static final int DATABASE_VERSION = 1;

	public NoteDBHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(Note.CREATE_NOTE_TABLE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO upgrade database if possible.
	}

	public void createNote(Note note) {
		SQLiteDatabase db = getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(Note.EXTRA_TITLE, note.getTitle());
		values.put(Note.EXTRA_CONTENT, note.getContent());
		note.mId = db.insert(Note.NOTE_TABLE, null, values);
	}

	public void updateNote(Note note, long id) {
		SQLiteDatabase db = getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(Note.EXTRA_TITLE, note.getTitle());
		values.put(Note.EXTRA_CONTENT, note.getContent());
		db.update(Note.NOTE_TABLE, values, Note.WHERE_UPDATE,
				new String[] { String.valueOf(id) });

	}

	public void deleteNote(Note note) {
		SQLiteDatabase db = getWritableDatabase();
		db.delete(Note.NOTE_TABLE, Note.WHERE_DELETE,
				new String[] { String.valueOf(note.getId()) });

	}

	public ArrayList<Note> readAllNote() {
		SQLiteDatabase db = getReadableDatabase();
		ArrayList<Note> tmp = new ArrayList<Note>();

		Cursor c = db.query(Note.NOTE_TABLE, Note.READ_NOTE_PROJECT, null,
				null, null, null, null);
		if (c.moveToFirst()) {
			do {
				long id = c.getLong(c.getColumnIndex(Note._ID));
				String title = c.getString(c.getColumnIndex(Note.EXTRA_TITLE));
				String content = c.getString(c
						.getColumnIndex(Note.EXTRA_CONTENT));

				Note tmpnote = new Note(id, title, content);
				tmp.add(tmpnote);
			} while (c.moveToNext());
		}
		c.close();

		return tmp;
	}
}
