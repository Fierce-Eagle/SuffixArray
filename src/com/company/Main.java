package com.company;

import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        System.out.print("Введите текст: ");
        SuffixArray suffixArray = new SuffixArray(new Scanner(System.in).next());
        List <String> stringList = new ArrayList<>();
        String substring;
        System.out.println("\nДля заканчивания ввода вводи out:");
        while (true)
        {
            System.out.print("Введите подстроку: ");
            substring = new Scanner(System.in).next();
            if (substring.equals("out"))
                break;
            // добавление неподходящих подстрок
            if (!suffixArray.SearchText(substring))
            {
                stringList.add(substring);
            }
        }
        System.out.print("Введите длину подстроки: ");
        int n = new Scanner(System.in).nextInt();
        System.out.println("Вывод: ");
        for (int i = 0; i < stringList.size(); i++)
        {
            String pattern = stringList.get(i);
            int size = pattern.length() - n;
            for (int offset = 0; offset < size; offset++)
            {
                String subsubstring = "";
                for (int j = 0; j < n; j++)
                {
                    subsubstring += pattern.charAt(j + offset);
                }
                if (suffixArray.SearchText(subsubstring))
                {
                    System.out.println(pattern);
                    break;
                }
            }

        }
    }
}
