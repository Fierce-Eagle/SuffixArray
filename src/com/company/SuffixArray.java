package com.company;
import java.util.Arrays;

public class SuffixArray
{
    private char[] text;
    private int[] suffixArr;
    private class Suffix
    {
        public char suffix;
        public int index;
    }
    public SuffixArray(String string)
    {
        text = string.toCharArray();
        suffixArr = createArraySuffix();
    }
    /**
     * Суффиксный массив
     * @return
     *          массив суффиксов типа int
     */
    private int[] createArraySuffix()
    {
        // Структура для хранения суффиксов и их индексов
        Suffix[] suffixes = new Suffix[text.length];

        for (int i = 0; i < text.length; i++)
        {
            suffixes[i] = new Suffix();
            suffixes[i].index = i;
            suffixes[i].suffix = text[i];
        }
        Arrays.sort(suffixes, (suffix, suffix1) -> suffix.suffix - suffix1.suffix);
        int[] suffixArr = new int[text.length];

        for (int i = 0; i < suffixArr.length; i++)
            suffixArr[i] = suffixes[i].index;
        return  suffixArr;
    }
    private String getSubstring(int start, int size)
    {
        if (size + start > text.length)
            return "";
        String string = "";
        int lenght = start + size;
        for (int i = start; i < lenght; i++)
        {
            string += text[i];
        }
        return string;
    }
    /**
     * Поиск подстроки
     * @param substring
     *          искомая подстрока
     * @return
     *          результат поиска подстроки
     */
    public boolean SearchText(String substring)
    {
        for (int i = 0; i < text.length/* && substring.charAt(0) <= text[suffixArr[i]]*/; i++)
        {
            if (substring.charAt(0) == text[suffixArr[i]])
            {
                if (substring.equals(getSubstring(suffixArr[i], substring.length())))
                {
                    return true;
                }
            }
        }
        return false;
    }

    public String getText()
    {
        return text.toString();
    }
}
