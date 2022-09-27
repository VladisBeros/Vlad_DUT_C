using System;

namespace Lab1__PD_21__Bero_
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Период колебания маятника:");
            Console.ReadKey();
            double g = 1;
            double l = 1;
            double T = 2 * Math.PI * Math.Sqrt(l/g);
            Console.WriteLine("Ответ:");
            Console.WriteLine(T);
            Console.ReadKey();
        }
    }
}
