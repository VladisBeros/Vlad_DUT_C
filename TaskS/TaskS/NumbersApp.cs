using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using static System.Windows.Forms.LinkLabel;

namespace TaskS
{
    public partial class NumbersApp : Form
    {
        public string MaxElement(double[] numbers)
        {
            return $"Максимальне число: {numbers.Max()}";
        }

        public string MinElement(double[] numbers)
        {
            return $"Mінімальне число: {numbers.Min()}";
        }

        public string Median(double[] numbers)
        {
            Array.Sort(numbers);

            int numbersLength = numbers.Length;
            if (numbersLength % 2 == 1)
            {
                return $"{numbers[numbersLength / 2]}";
            }
            else
            {
                double middle1 = numbers[(numbersLength / 2) - 1];
                double middle2 = numbers[numbersLength / 2];
                return $"{(middle1 + middle2) / 2}";
            }
        }

        public string Average(double[] numbers)
        {
            double sum = 0;

            for (int i = 0; i < numbers.Length; i++)
            {
                sum += numbers[i];
            }

            return $"Середнє арефметичне: {sum / numbers.Length}";
        }

        public NumbersApp()
        {
            InitializeComponent();
        }

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void button1_Click(object sender, EventArgs e)
        {
            openFileDialog1.ShowDialog();
            string filename = openFileDialog1.FileName;
            string[] readfile = File.ReadAllLines(filename);

            double[] numbers = readfile.Select(line =>
            {
                double number;
                if (double.TryParse(line, out number))
                {
                    return number;
                }
                else throw new FormatException($"Неможливо перетворити '{line}'.");
            }).ToArray();

            richTextBox1.Text = MaxElement(numbers);
            richTextBox2.Text = MinElement(numbers);
            richTextBox3.Text = Average(numbers);
            richTextBox4.Text = Median(numbers);
        }

        private void label1_Click_1(object sender, EventArgs e)
        {

        }

        private void label4_Click(object sender, EventArgs e)
        {

        }

        private void label5_Click(object sender, EventArgs e)
        {

        }
    }
}