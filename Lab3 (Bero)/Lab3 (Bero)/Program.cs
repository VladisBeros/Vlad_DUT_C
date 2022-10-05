using System;

namespace ConsoleApp3
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Перевiрити iстиннiсть вислову: 'Квадратне рiвняння A·x^2 + B·x + C = 0 iз даними коефiцiєнтами A, B, C має дiйснi коренi'.");
            int A = 1;
            int B = 3;
            int C = -2;
            bool answer;
            double D = Math.Pow(B, 2) + 4 * A * C;
            double SqrtD = Math.Sqrt(D);
            double x1 = (-B - SqrtD) / 2 * A;
            double x2 = (-B + SqrtD) / 2 * A;
            Console.WriteLine("\nВiдповiдь:");
            if ((x1 % 1 == 0) && (x2 % 1 == 0))
            {
                answer = true;
                Console.WriteLine(answer);
            }
            else if ((x1 % 1 != 0) && (x2 % 1 != 0))
            {
                answer = false;
                Console.WriteLine(answer);
            }
            Console.ReadLine();
        }
    }
}