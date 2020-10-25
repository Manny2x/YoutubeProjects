using System;
using System.IO;

namespace SpeedCoding_TextFileDatabase
{
    class Account
    {
        string accountName = " ";
        int balance = 0;
        StreamWriter stream;

        public Account(string name,
            int balance)
        {
            this.accountName = name;
            this.balance = balance;
        }

        public string getName()
        {
            return accountName;
        }
        public int getBalance()
        {
            return balance;
        }

        public void addBalance(int val)
        {
            balance += val;
        }

        public void minusBalance(int val)
        {
            if(balance - val < 0)
            {
                Console.WriteLine("Not enough funds...");
                Console.ReadLine();


                return;
            }

            balance -= val;
        }

        public void setStream(StreamWriter stream)
        {
            this.stream = stream;
        }

        public StreamWriter getStream()
        {
            return stream;
        }
    }
}
;
