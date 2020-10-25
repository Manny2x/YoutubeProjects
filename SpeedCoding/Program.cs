using System;

namespace SpeedCoding_TextFileDatabase
{
    class Program
    {
        static void Main(string[] args)
        {
            Database database =
                new Database(@"C:\databasetxt\");
            Command command = null;
            while (true)
            {
                Console.WriteLine("Enter Command(!cmds for commands): ");
                command = new Command(Console.ReadLine(), 
                    database);

                command.doCommand();
                Console.Clear();

            }
        }
    }
}
