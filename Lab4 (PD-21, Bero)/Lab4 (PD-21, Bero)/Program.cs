using System;

namespace Lab4__PD_21__Bero_
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Даний масив розмiру N. Вивести його елементи в зворотному порядку.");
            int[] M = { 0, 10, 20 };
            Console.WriteLine("\nВывод в обычном порядке:");
            for (int i = 0; i < M.Length; i++)
            {
                Console.WriteLine(M[i]);
            }
            Console.WriteLine("\nВывод в обратном порядке:");
            for (int i = M.Length - 1; i >= 0; i--)
            {
                Console.WriteLine(M[i]);
            }
            Console.ReadLine();
        }
    }
}
