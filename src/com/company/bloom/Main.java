package com.company.bloom;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * this code was written from Pelican https://stackoverflow.com/questions/39314877/how-to-parse-an-audio-file-and-download-it-by-jsoup
 */
public class Main {
    /**
     * path in local storage to save in
     */
    static String filePath = "D:/web_sounds/";

    static String filePathPrefix = "01";
    static String filePathEnding = "_0127.mp3";

    /**
     * basic URL to file
     */
    static String urlBase = "https://www.englishaccentcoach.com/mp3/";

    public static void main(String[] args) {
        /**
         * set pages query as you need
         */
        for (int page = 1; page <= 7; page++) {

            /**
             * form url to mp3 file
             */
            String url = urlBase + filePathPrefix + page + filePathEnding;

            try {
                /**
                 * connect to page and open input stream
                 */
                URLConnection urlConnection = new URL(url).openConnection();
                InputStream inputStream = urlConnection.getInputStream();

                /**
                 * save file on local storage
                 */
                OutputStream outStream = new FileOutputStream(new File( filePath + filePathPrefix + page + filePathEnding));
                byte[] buffer = new byte[4096];
                int len;
                while ((len = inputStream.read(buffer)) > 0) {
                    outStream.write(buffer, 0, len);
                }
                outStream.close();

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
