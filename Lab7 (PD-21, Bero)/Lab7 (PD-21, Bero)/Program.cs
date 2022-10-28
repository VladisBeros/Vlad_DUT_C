using System;

namespace Lab7__PD_21__Bero_
{
    class Program
    {
        static void In()
        {
            Class_1 data = new Class_1();
            Console.WriteLine("Введите int и нажмите Enter: ");
            string value = Console.ReadLine();
            data.In = Convert.ToInt32(value);
            Console.WriteLine("Int: " + data.In + "\n");
        }

        static void Str()
        {
            Class_1 data = new Class_1();
            Console.WriteLine("Введите string и нажмите Enter: ");
            data.Str = Console.ReadLine();
            Console.WriteLine("String: " + data.Str + "\n");
        }

        static void Dou()
        {
            Class_1 data = new Class_1();
            Console.WriteLine("Введите double и нажмите Enter: ");
            string value1 = Console.ReadLine();
            data.Dou = Convert.ToDouble(value1);
            Console.WriteLine("Double: " + data.Dou + "\n");
        }

        static void Bo()
        {
            Class_1 data = new Class_1();
            Console.WriteLine("Введите значение для bool (true или false) и нажмите Enter: ");
            string value2 = Console.ReadLine();
            data.Bo = Convert.ToBoolean(value2);
            Console.WriteLine("Bool: " + data.Bo + "\n");
        }

        static void Main(string[] args)
        {
            Console.WriteLine("Створити лiст об’єктiв, дозволити можливiсть заповнення з клавiатури i вивести кiлькiсть об’єктiв кожного типу(Char, String, Int, Doble, Bool).\n");

            Console.WriteLine("Сколько раз вы хотите использовать тип bool?\n");
            string b = Console.ReadLine();
            int B = Convert.ToInt32(b);
            for (int a = 0; a < B; a++)
            {
                Bo();
            }

            Console.WriteLine("Сколько раз вы хотите использовать тип double?\n");
            string d = Console.ReadLine();
            int D = Convert.ToInt32(d);
            for (int a = 0; a < D; a++)
            {
                Dou();
            }

            Console.WriteLine("Сколько раз вы хотите использовать тип int?\n");
            string i = Console.ReadLine();
            int I = Convert.ToInt32(i);
            for (int a = 0; a < I; a++)
            {
                In();
            }

            Console.WriteLine("Сколько раз вы хотите использовать тип string?\n");
            string s = Console.ReadLine();
            int S = Convert.ToInt32(s);
            for (int a = 0; a < S; a++)
            {
                Str();
            }

            Console.ReadKey();

            /* Console.WriteLine("Введите char и нажмите Enter: ");
            string value3 = Console.ReadLine();
            data.Str = Convert.ToChar(value3);
            Console.WriteLine("Char: " + data.Ch + "\n"); */
        }
    }
}