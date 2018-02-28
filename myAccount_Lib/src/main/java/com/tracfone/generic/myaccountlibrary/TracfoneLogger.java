package com.tracfone.generic.myaccountlibrary;

/***************************************************************************
 * TracFone Wireless, Inc.
 * Engineering Department  
 *
 * CLASS DESCRIPTION:  
 *  
 * This  class will create a log file and has methods to add entries into the 
 * log file.  In addition Log.d will be called for each new entry.  Logging will
 * only occur if the application is configured to be in debug mode. (ReleaseFlavorConfig.DEBUG)
 * 
 * 
 * TracFone Engineering Confidential Proprietary
 * Copyright (c) 2014,  All Rights Reserved
 *
 *  
 * ****************************************************************************/
  
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.Date; 
import android.os.Environment;
import android.util.Log;

public class TracfoneLogger {

 
	String LogPath = "default"; 
	OutputStreamWriter osw = null;
	File file = null;
	FileOutputStream fOut = null; 

	// File Trimming Constants.
	final int MAX_FILE_SIZE = 1000000; // Set to 1 MB
	final boolean TRIM_FILE = true;    // Set to trim, false to not trim logs.
	long file_size = 0;
	File fileToTrim = null;

	public static final String LOG_FILE_ALARM = "_tfAlarmLogger.txt";
	/**
     * 
     * The Class Constructor. Call this early in Actvity Oncreate. Makes logging available to activity.
	 *  Opens a file, creates it if it doesn't exist, and appends to it if it does.
	 * 
     * @param logFile  Name of log file created
     */  
	public TracfoneLogger(String logFile)
	{
		//Add brand to logfile name
        logFile = GlobalLibraryValues.getBrand() + logFile;
        
		if (DebugConfig.DEBUG_LOGGER) {
			
			// Check to see if directory exists. If it doesn't, make one.
			File folder = new File(Environment.getExternalStorageDirectory() + File.separator + "TF_logging");
			if (!folder.exists()) { 
				folder.mkdir();
			}

			// Create the Path string to the logging file.
			LogPath = Environment.getExternalStorageDirectory().toString() + File.separator + "TF_logging" + File.separator + logFile;
  
			// Check the file length, trim if trimming enabled and file too large.		
			if (TRIM_FILE)
			{
				try 
				{
					fileToTrim = new File(LogPath);

					// Check file size to see if it has become too long.
					file_size = fileToTrim.length(); 
					//Log.d(LibraryConstants.TAG, "Logger file size: " + file_size);

					// If file is too long, and trimming enabled, trim from the front to bring it down to allowable length.
					if (file_size > MAX_FILE_SIZE)
					{
						//Log.d(LibraryConstants.TAG, "Logger file size: " + file_size + ", now trimming file.");

						// Obtain log file contents as String
						FileInputStream is = new FileInputStream(fileToTrim);
						int size = is.available();
						byte[] buffer = new byte[size];
						is.read(buffer);
						is.close();
						String beforeString = new String(buffer);

						// Take the string length.
						int stringLength = beforeString.length()-1;



						// Trim Half of the String away to shorten it.
						String shortString = beforeString.substring(stringLength - (MAX_FILE_SIZE/2), stringLength);

						// Resave the file from the shortened string.
						file = new File(LogPath);
						fOut = new FileOutputStream(file, false);   // false on second parameter to truncate string.
						osw = new OutputStreamWriter(fOut); 

						// Write the string to the file
						osw.append(shortString);

						// Flush and Close the Stream.
						osw.flush();	
						osw.close();						
					}			
				} 

				catch (Exception e) {
					Log.e(LibraryConstants.TAG, "Exception in log file measurment and trimming: " + e);
				}		
			} // End If TRIM_FILE

			// Open the File		
			try {
				file = new File(LogPath);
				fOut = new FileOutputStream(file, true);   // true on second parameter to enable appending behavior.
			} catch (Exception e) {
				 Log.d(LibraryConstants.TAG, "Unable to create Logger directory: " + e);
			}


			// Create the file if it does not exist.
			try {
				osw = new OutputStreamWriter(fOut);  
			} catch (Exception e) { 
				Log.d(LibraryConstants.TAG, "Unable to create Logger file: " + e);
			}
		}
	}

	
	/**
	 *  Call this to add an entry.
	 *  
	 * @param callingClass   The class name which is making the log entry
	 * @param callingMethod  The method name which is making the log entry
	 * @param entry          String to be logged
	 */ 
	public void add(String callingClass, String callingMethod, String entry)
	{
		if (DebugConfig.DEBUG_LOGGER) {
			String logEntry = "";
			// Take Unix time and caluclate out a timestamp.
			Date date = new Date(System.currentTimeMillis());
			String timeStamp = date.toString();
			timeStamp = timeStamp.replace(' ','_'); 
			timeStamp = timeStamp.substring(4, 19); // cut off day of week, seconds, year, and time zone.

			// Assemble the Log Entry String.
			logEntry = timeStamp + " : " + callingClass + " : Method " + callingMethod + " - " + entry + " \n";

			// If entry is > 4000 characters it must be logged in chunks
			if (logEntry.length() > 4000) {
				int chunkCount = logEntry.length() / 4000;     // integer division
				for (int i = 0; i <= chunkCount; i++) {
					int max = 4000 * (i + 1);
					if (max >= logEntry.length()) {
						Log.d(LibraryConstants.TAG, logEntry.substring(4000 * i));
					} else {
						Log.d(LibraryConstants.TAG, logEntry.substring(4000 * i, max));
					}
				}
			} else {
				Log.d(LibraryConstants.TAG, logEntry);
			}

			// Append to the file.
			try {
				osw.append(logEntry);
				osw.flush();			
			} catch (Exception e) {
				//Do nothing 
			}
		}
	}

	/**
	 * Call this to close the log at the end of the activity's lifecycle.
	 */ 
	public void close()
	{
		if (DebugConfig.DEBUG_LOGGER) {
			// Close the log file.
			// Close and Flush
			try {
				osw.flush();
				osw.close();	

			} catch (Exception e) {
				//Do nothing
			}
		} 		

	}

	/**
	 * This Method is used only for alaram to log the time setting calls and for received calls
	 * @param callingClass The class name which is making the log entry
	 * @param callingMethod The method name which is making the log entry
	 * @param entry String to be logged
	 */

	public static void writeLog(String file ,String callingClass, String callingMethod, String entry){
		//use this log until unless it is compulsory as this log makes lot of work on UI as it opens write and closes file.
		if (DebugConfig.DEBUG_LOGGER) {
			TracfoneLogger tfLogger = new TracfoneLogger(file);
			tfLogger.add(callingClass, callingMethod, entry);
			tfLogger.close();
		}
	}

}
