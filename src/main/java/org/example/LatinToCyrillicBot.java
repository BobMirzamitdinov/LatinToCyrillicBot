package org.example;

public class LatinToCyrillicBot
{

    public static void main(String[] args) {
        String inputString = "Salom";

        String convertedString = replaceLatinToCyrillic(inputString);
        System.out.println("Original String: " + inputString);
        System.out.println("Converted String: " + convertedString);
    }

    public static String replaceLatinToCyrillic(String inputString) {
        if (inputString == null || inputString.isEmpty()) {
            return inputString;
        }

        String latinChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        String cyrillicChars = "АБCДЕФГҲИЖКЛМНОПҚРСТУВWХЙЗабcдефгҳижклмнопқрстувwхйз";

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < inputString.length(); i++) {
            char currentChar = inputString.charAt(i);
            int latinIndex = latinChars.indexOf(currentChar);

            if (latinIndex != -1) {
                stringBuilder.append(cyrillicChars.charAt(latinIndex));
            } else {
                stringBuilder.append(currentChar);
            }
        }

        return stringBuilder.toString();
    }
}

