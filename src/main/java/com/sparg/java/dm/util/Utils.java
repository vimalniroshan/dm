package com.sparg.java.dm.util;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author: vimal.sengoden
 * Date: 3/31/14
 * Time: 2:32 PM
 */
public class Utils {

    public static String getResourceAsString(String resourceName) throws IOException {
        StringWriter writer = new StringWriter();
        IOUtils.copy(Thread.currentThread()
                .getContextClassLoader()
                .getResourceAsStream(resourceName),
                writer);
        return writer.toString();
    }

    public static <T> Class<T> loadClass(String className) throws ClassNotFoundException {
        return (Class<T>) Class.forName(StringUtils.trim(className));
    }

    public static Set<String> asSet(String... str) {
        Set<String> strings = new HashSet<String>();

        for(String s: str) {
            strings.add(s);
        }

        return strings;
    }

    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }

    public static List<String> splitToSize(String text, int size) {
        List<String> ret = new ArrayList<String>((text.length() + size - 1) / size);

        for (int start = 0; start < text.length(); start += size) {
            ret.add(text.substring(start, Math.min(text.length(), start + size)));
        }

        return ret;
    }
}
