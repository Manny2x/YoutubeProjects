using System;
using System.Collections.Generic;
using System.Text;

namespace SpeedCoding_TextFileDatabase
{
    class NotEnoughFundsException : Exception
    {

        String time = " ";

        public NotEnoughFundsException()
        {
            time = DateTime.Now.ToString("DDMMyy");
        }

        public String ErrorMessage()
        {
            return "There were not enough funds to withdraw/deposit from or into \n" +
                "this account... \n" +
                "At time: " + time;
        }
    }
}
