
using System;
using System.IO;


namespace SpeedCoding_TextFileDatabase
{
    class Database : Exception
    { 
        string path = " ";
        public Database(string path)
        {
            this.path = path;
        }

        public void writeAccount(Account account)
        {
            using StreamWriter streamWriter = 
                File.CreateText(path + account.getName() + ".txt");
            streamWriter.Write(account.getBalance());
            streamWriter.Flush();
        }

        public void deleteAccount(Account account)
        {
            string name = account.getName();

            File.Delete(path + name + ".txt");
        }

        public void transferFunds(Account from,
            int val,
            Account to)
        {
            from.minusBalance(val);
            to.addBalance(val);


            resetAccount(from);
            resetAccount(to);
        }

        public void resetAccount(Account account)
        {
            string name = account.getName();
            File.CreateText(path + account.getName() + ".txt")
                .Close();

            using StreamWriter stream =
                new StreamWriter(path + account.getName() + ".txt");

            stream.Write(account.getBalance());
            stream.Close();
        }

        public Account readAccount(string name)
        {
            string[] files = Directory.GetFiles(path);

            for(int i = 0; i < files.Length; i++)
            {
                if (files[i] == path + name + ".txt")
                {
                    string pathRead = path + name + ".txt";
                    Account account = new Account(name,
                       Convert.ToInt32(File.ReadAllText(pathRead)));
                    return account;
                }
            }
            return null;
        }

        public void withdraw(Account account, 
            int amount)
        {
            if(amount > account.getBalance())
                throw new NotEnoughFundsException();
            
            Account withdep =
                new Account("WD", Convert.ToInt32(File.ReadAllText(path + "WD.txt")));
            this.transferFunds(account, amount, withdep);
        }

        public void deposit(Account account, 
            int amount)
        {

            Account withdep =
                new Account("WD", Convert.ToInt32(File.ReadAllText(path + "WD.txt")));
            
            if (amount > withdep.getBalance())
                throw new NotEnoughFundsException();


            this.transferFunds(withdep, amount, account);
        }
    }
}
