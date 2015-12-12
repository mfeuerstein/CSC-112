      // ********** Lab 4c - #5 **********    
      // Write the sorted records to a new file
      
      try
      { // begin exception try
      
          // Create the FileWriter name fw and BufferedWriter name fw
          FileWriter fw = new FileWriter("SortedEmployees.txt", false);
          BufferedWriter bw = new BufferedWriter(fw);

          // write each object + gross pay as a new record on the file
          for (i=0; i < count; i++)
          {     
              record ="";
              record += emp[i].getFirstName() + " ";
              record += emp[i].getMiddleName() + " ";
              record += emp[i].getLastName() + " ";
              record += emp[i].getPayRate() + " ";
              record += emp[i].getHoursWorked() + " ";
              record += emp[i].calculatePay() + "\n";
              bw.write(record);
          }
          // Clear the buffer and close it
          bw.flush();
          bw.close();
          
      } // end exception try
      
      catch(IOException e)
      { // beging exception catch
      
          e.printStackTrace();
          
      } // end exception catch     
