using System;

namespace SpeedCoding_TextFileDatabase
{
    class Command
    {
        string command = " ";
        Database database = null;

        public Command(string command, 
            Database database)
        {
            this.database = database;
            this.command = command;
           
        }

        public void doCommand()
        {
            switch (command)
            {
                case "!cmds":
                    Console.WriteLine("!select--account");
                    Console.WriteLine("!create--account");
                    Console.WriteLine("!transfer--funds");
                    Console.WriteLine("!delete--account");
                    Console.WriteLine("!deposit");
                    Console.WriteLine("!withdraw");
                    Console.ReadLine();

                    break;
                case "!select--account":
                    Console.WriteLine("Please enter the name of this account: ");
                    string name2 = Console.ReadLine();

                    try
                    {
                        Account account2 = database.readAccount(name2);

                        if (account2 == null)
                        {
                            break;
                        }

                        Console.WriteLine(account2.getName() + "\n" + account2.getBalance());
                        Console.ReadLine();
                    }
                    catch (NullReferenceException e)
                    {

                        Console.WriteLine("FILE DOES NOT EXIST IN DATABASE" +
                            e);
                        Console.ReadLine();
                    }
                    break;

                case "!create--account":

                    Console.WriteLine("Please enter the name and balance of this account: ");
                    string name = Console.ReadLine();
                    int balance = Convert.ToInt32(Console.ReadLine());

                    Account account = new Account(name, balance);
                    database.writeAccount(account);
                    Console.WriteLine("Written account to database!");
                    Console.ReadLine();

                    break;

                case "!transfer--funds":
                    Console.WriteLine("Specify the account, amount you want to transfer and then the receiving account: ");
                    string from = Console.ReadLine();
                    int val = Convert.ToInt32(Console.ReadLine());
                    string to = Console.ReadLine();

                    database.transferFunds(database.readAccount(from),
                        val,
                        database.readAccount(to));

                    Console.WriteLine("The accounts have been successfully transferred!");
                    Console.ReadLine();


                    break;

                case "!delete--account":
                    Console.WriteLine("Specify name: ");
                    string nameDel = Console.ReadLine();

                    try
                    {
                        Account account1 = database.readAccount(nameDel);
                        database.deleteAccount(account1);

                        Console.WriteLine("Account successfully deleted");
                        Console.ReadLine();

                    } catch(NullReferenceException e)
                    {
                        Console.WriteLine(e);
                        Console.ReadLine();
                    }

                    break;
                case "!withdraw":
                    Console.WriteLine("Specify name: ");
                    string nameWith = Console.ReadLine();

                    Console.WriteLine("Specify amount to withdraw: ");
                    int amount = Convert.ToInt32(Console.ReadLine());

                    try
                    {
                        Account account1 = database.readAccount(nameWith);

                        database.withdraw(account1, amount);
                    } catch(NotEnoughFundsException exc)
                    {
                        Console.WriteLine(exc.ErrorMessage());
                        Console.Read();
                    }

                    break;

                case "!deposit":
                    Console.WriteLine("Specify name: ");
                    string nameDep = Console.ReadLine();

                    Console.WriteLine("Specify amount to deposit: ");
                    int amount2 = Convert.ToInt32(Console.ReadLine());

                    try
                    {
                        Account account1 = database.readAccount(nameDep);

                        database.deposit(account1, amount2);
                    } catch(NotEnoughFundsException exc)
                    {
                        Console.WriteLine(exc.ErrorMessage());
                        Console.Read();
                    }

                    break;
                    
            }
        }
    }
}
