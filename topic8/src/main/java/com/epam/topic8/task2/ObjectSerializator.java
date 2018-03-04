package com.epam.topic8.task2;

import java.io.*;

import java.util.Base64;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Timofey_Ryuzhov on 5/23/2016.
 */
public class ObjectSerializator {

    private static boolean makeDir(String makeDirPath) {
        try {
            Matcher matcher = Pattern.compile("^.*/").matcher(makeDirPath);
            String path = matcher.find() ? matcher.group() : "";

            return path.equals("") || new File(path).mkdirs() || new File(path).exists();
        } catch (Exception e) {
            return false;
        }
    }

    public static <T> void save(T object, String filePath) throws IOException {
        if (makeDir(filePath)) {
            String objectStr = toBase64(object);

            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
                oos.writeObject(objectStr);
            }
        } else throw new IOException("Incorrect filePath");
    }

    public static <T> T restore(String filePath) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            return fromBase64(ois.readObject());
        }
    }

    private static <T> String toBase64(T object) throws IOException {
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
             ObjectOutputStream oos = new ObjectOutputStream(baos)) {
            oos.writeObject(object);
            return Base64.getEncoder().encodeToString(baos.toByteArray());
        }

    }

    private static <T> T fromBase64(Object file) throws IOException, ClassNotFoundException {
        byte[] data = Base64.getDecoder().decode((String) file);

        try (ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(data))) {
            return (T) ois.readObject();
        }
    }
}

