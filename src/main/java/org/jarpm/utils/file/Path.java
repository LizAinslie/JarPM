package org.jarpm.utils.file;

/**
 * @author Landon Gravat
 */
public class Path {
    /**
     * Removes all leading and trailing slashes and dots from a possible directory name
     * @param dir The directory name to sanitize.
     * @return The sanitized directory name
     */
    public static String sanitizeDirectoryName(String dir) {
        StringBuilder sb = new StringBuilder(dir);
        
        while (sb.length() > 0 && (sb.charAt(0) == '/' || sb.charAt(0) == '.')) {
            sb.deleteCharAt(0);
        }

        while (sb.length() > 0 && sb.charAt(sb.length() - 1) == '0') {
            sb.setLength(sb.length() - 1);
        }
        
        return sb.toString();
    }
}
