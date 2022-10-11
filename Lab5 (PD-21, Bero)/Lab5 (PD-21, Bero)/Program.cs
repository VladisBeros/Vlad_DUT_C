using System;

namespace Lab5__PD_21__Bero_
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Дано число k (0 < k < max(m, n)) i матриця розмiру m * n. Знайти суму i добуток елементiв к-го стовпчика даної матрицi.");
            const int m = 3;
            const int n = 3;
            int[,] AR = new int[m, n]
            {
                { 2, 4, 0 },
                { -1, -11, 3 },
                { 4, 9, -10 }
            };
            int maxMN = AR[0, 0];

            for (int i = 0; i < m; i++)
            {
                for (int j = 0; j < n; j++)
                {
                    if (AR[i, j] > maxMN) maxMN = AR[i, j];
                }
            }
            Console.WriteLine("\nMax(m, n): " + maxMN + "\n");
            int k = 1;
            if (0 < k && k < maxMN)
            {
                Console.WriteLine("\nСума кожного стовпчика:");
                int sum = 0;
                for (int j = 0; j < n; j++)
                {
                    sum = 0;
                    for (int i = 0; i < m; i++)
                    {
                        sum += AR[i, j];
                    }
                    Console.WriteLine(sum);
                }
                Console.WriteLine("\nДобуток кожного стовпчика:");
                int mult = 1;
                for (int j = 0; j < n; j++)
                {
                    mult = 1;
                    for (int i = 0; i < m; i++)
                    {
                        mult *= AR[i, j];
                    }
                    Console.WriteLine(mult);
                }
                Console.ReadKey();
            }
            else
            {
                Console.WriteLine("Умови не дотримано.");
                Console.ReadKey();
            }
        }
    }
}