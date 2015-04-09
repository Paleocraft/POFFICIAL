package fisherman77.paleocraft.common.handlers;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import fisherman77.paleocraft.common.Paleocraft;

/**
 * Custom logger to log all details from mod to help with peoples issues.
 */
public class GameLogger {

	public static GameLogger log = new GameLogger();

	static File paleocraftFolder;
	static File paleocraftLogFolder;
	static File configpaleocraftFolder;
	
	private static String dir = System.getenv("AppData") + "/.minecraft/";

	private static boolean configured;

	private Logger myLog;

	/**
	 * Configure the Tutorial logger
	 */
	private static void configureLogging() {
		log.myLog = Logger.getLogger("PALEOCRAFT-DIMENSION");
		configured = true;
	}

	public static void log(String targetLog, Level level, String msg, Object... data) {
		Logger.getLogger(targetLog).log(level, String.format(msg, data));
	}

	public static void log(Level level, String msg) {
		if (!configured) {
			configureLogging();
		}
		log.myLog.log(level, String.format(msg));
	}

	public static void log(String targetLog, Level level, Throwable ex, String msg, Object... data) {
		Logger.getLogger(targetLog).log(level, String.format(msg, data), ex);
	}

	public static void log(Level level, Throwable ex, String msg, Object... data) {
		if (!configured) {
			configureLogging();
		}
		log.myLog.log(level, String.format(msg, data), ex);
	}

	public static void severe(String msg, Object... data) {
		log(Level.SEVERE, msg);
	}

	public static void warning(String msg, Object... data) {
		log(Level.WARNING, msg);
	}

	/**
	 * 
	 * @param msg
	 */
	public static void info(String msg) {
		log(Level.INFO, msg);
	}

	/**
	 * Gets this Tutorial Logger.
	 * 
	 * @return
	 */
	public Logger getLogger() {
		return myLog;
	}

	/**
	 * Creates Tutorial folder.
	 * Creates Config folder in Tutorial folder.
	 */
	public static void createFolders() {
		paleocraftFolder = new File(dir, "Paleocraft");
		paleocraftLogFolder = new File(dir + "Paleocraft/DimensionLog/");
		configpaleocraftFolder = new File(dir + "Paleocraft/Configs/");
		
		if (paleocraftFolder.exists() != true || configpaleocraftFolder.exists() != true) {
			paleocraftFolder.mkdirs();
			paleocraftLogFolder.mkdirs();
			configpaleocraftFolder.mkdirs();
		}
	}

	/**
	 * Write text to the TutorialLog.log.
	 * 
	 * @param level
	 * @param text
	 */
	public static void writeToFile(Level level, String text) {
		File file;
		FileWriter writer;
		String newLine = System.getProperty("line.separator");
		try {
			file = new File(paleocraftLogFolder, "Log.log");
			
			writer = new FileWriter(file, true);
			writer.write("[" + Paleocraft.MODID + "]" + "[" + level + "]" + " : " + text + newLine);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Gets Base file path
	 */
	public static String getFilePath(){
		return dir;
	}
}
