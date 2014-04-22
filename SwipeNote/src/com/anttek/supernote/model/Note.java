package com.anttek.supernote.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

import android.provider.BaseColumns;

public class Note implements BaseColumns {
	// support for database
	public final static String NOTE_TABLE = "NoteTbl";
	public final static String EXTRA_TITLE = "EXTRA_TITLE";
	public final static String EXTRA_CONTENT = "EXTRA_CONTENT";
	public final static String CREATE_NOTE_TABLE = String
			.format("CREATE TABLE IF NOT EXISTS %s (%s INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT, %s TEXT )",
					NOTE_TABLE, _ID, EXTRA_TITLE, EXTRA_CONTENT);
	public final static String[] READ_NOTE_PROJECT = new String[] { _ID,
			EXTRA_TITLE, EXTRA_CONTENT };
	public final static String DROP_NOTE_TABLE = String.format(
			"DROP TABLE IF EXISTS %s", NOTE_TABLE);

	public static final String WHERE_UPDATE = String.format("%s=?", _ID);
	public static final String WHERE_DELETE = String.format("%s=?", _ID);
	public static final long INVALIDATE_ID = -1;

	// ======================================================

	long mId;
	private String mTitle;
	private String mContent;

	public Note() {
		mId = INVALIDATE_ID;
	}

	public Note(String title, String content) {
		super();
		this.mTitle = title;
		this.mContent = content;
	}

	Note(long id, String title, String content) {
		super();
		mId = id;
		this.mTitle = title;
		this.mContent = content;
	}

	public String getTitle() {
		return this.mTitle;
	}

	public void setTitle(String title) {
		this.mTitle = title;
	}

	public String getContent() {
		return this.mContent;
	}

	public void setContent(String content) {
		this.mContent = content;
	}

	@Override
	public String toString() {
		return this.mTitle;
	}

	public static Note[] createTestArray() {
		Note[] notes = new Note[10];
		for (int i = 0; i < 10; i++) {
			notes[i] = new Note("Note title " + (i + 1), "Note content "
					+ (i + 1));
		}

		return notes;
	}

	public long getId() {
		return mId;
	}

	public void save(String path) throws FileNotFoundException, IOException {
		Properties prop = new Properties();
		prop.setProperty(EXTRA_TITLE, mTitle);
		prop.setProperty(EXTRA_CONTENT, mContent);
		prop.storeToXML(new FileOutputStream(path), null);
	}

	public static Note load(String path)
			throws InvalidPropertiesFormatException, FileNotFoundException,
			IOException {
		Properties prop = new Properties();
		File file = new File(path);

		prop.loadFromXML(new FileInputStream(file));

		Note result = new Note();
		result.mTitle = prop.getProperty(EXTRA_TITLE);
		result.mContent = prop.getProperty(EXTRA_CONTENT);

		return result;
	}
}
