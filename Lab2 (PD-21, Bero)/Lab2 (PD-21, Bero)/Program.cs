using System;

namespace Lab2__PD_21__Bero_
{
    class Program
    {
        static void Main(string[] args)
        {
            double answer = 0;
            double sum = 0;
            int nn = 0;
            int k = nn;
            int nk = 10;

            if (nn >= 0 && nn <= nk)
            {
                for (nn = 0; nn < nk; nn++)
                {
                    answer = (Math.Pow(k, 2) - 3) / (Math.Pow(-1, k) * Math.Pow(k, 2) + 5);
                    Console.WriteLine(answer);
                    k++;
                    sum += answer;
                }
                Console.WriteLine("Ответ:");
                Console.WriteLine(sum);
                Console.ReadLine();
            }
            else
            {
                Console.WriteLine("Неправильно.");
                Console.ReadLine();
            }
        }
    }
}
